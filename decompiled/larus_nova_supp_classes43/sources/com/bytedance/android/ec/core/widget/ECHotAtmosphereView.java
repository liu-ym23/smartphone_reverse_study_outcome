package com.bytedance.android.ec.core.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.sink.api.IServerListener;
import com.byted.cast.sink.api.ServerInfo;
import com.bytedance.android.ec.core.abtest.ECLiveSettings;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000b\u0018\u00002\u00020\u0001:\u0001)B\u0019\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\tR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\"\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECHotAtmosphereView;", "Landroid/widget/LinearLayout;", "", "width", "", "setMaxWidth", "Lcom/bytedance/android/ec/core/widget/h;", "callback", "setCallback", "Lkotlin/Function0;", "setDegradeModeCallback", "com/bytedance/android/ec/core/widget/ECHotAtmosphereView$hideHotAtmosphereAction$2$a", "r", "Lkotlin/Lazy;", "getHideHotAtmosphereAction", "()Lcom/bytedance/android/ec/core/widget/ECHotAtmosphereView$hideHotAtmosphereAction$2$a;", "hideHotAtmosphereAction", "Landroid/graphics/Path;", "s", "getPath", "()Landroid/graphics/Path;", "path", "Landroid/graphics/Paint;", "t", "getSolidPaint", "()Landroid/graphics/Paint;", "solidPaint", "u", "getBorderPaint", "borderPaint", "z", "I", "getMaxNumValue", "()I", "maxNumValue", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHotAtmosphereView extends LinearLayout {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public boolean B;
    public int C;
    public boolean a;
    public boolean b;
    public ECDraweeView c;
    public ECDraweeView d;
    public ItalicTextView e;
    public ViewGroup f;
    public Animator g;
    public Integer h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final LinkedList<ECHotAtmosphere> l;
    public ECHotAtmosphere m;
    public ECHotAtmosphere n;
    public boolean o;
    public Function0<Integer> p;
    public TextView q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public boolean v;
    public h w;
    public boolean x;
    public b y;
    public final int z;

    public static final class a {
    }

    static {
    }

    private final Paint getBorderPaint() {
        return (Paint) this.u.getValue();
    }

    private final ECHotAtmosphereView$hideHotAtmosphereAction$2.a getHideHotAtmosphereAction() {
        return (ECHotAtmosphereView$hideHotAtmosphereAction$2.a) this.r.getValue();
    }

    private final Path getPath() {
        return (Path) this.s.getValue();
    }

    private final Paint getSolidPaint() {
        return (Paint) this.t.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasTransientState() {
        return false;
    }

    public final void b() {
        ECHotAtmosphere r0 = this.l.peek();
        ECHotAtmosphere r1 = this.m;
        if (r1 != null) goto L8;
        if (r0 == null) goto L8;
        h r10 = this.w;
        if (r10 == null) goto L36;
        r10.c(r0);
    L36:
        ECHotAtmosphere r11 = this.m;
        ECHotAtmosphere r12 = this.l.peek();
        if (r11 == null) goto L42;
        if (r12 == null) goto L42;
        if (r11.type == r12.type) goto L42;
        boolean r13 = true;
    L43:
        if (r13 == false) goto L55;
        if (this.j == false) goto L47;
        return;
    L47:
        if (this.k == true) goto L70;
        h r14 = this.w;
        if (r14 == null) goto L52;
        r14.a(this.l.peek());
    L52:
        this.j = true;
        ViewPropertyAnimator r15 = animate().alpha(0.0f).setDuration(300);
        com.bytedance.android.ec.core.utils.f.b(r15, new ECHotAtmosphereView$consumeNextItem$1(this));
        r15.start();
        return;
    L70:
        return;
    L55:
        if (this.l.size() <= 0) goto L72;
        ViewGroup r16 = this.f;
        if (r16 == null) goto L67;
        if (r16.getVisibility() != 8) goto L67;
        ViewGroup r17 = this.f;
        if (r17 == null) goto L63;
        r17.setVisibility(4);
    L63:
        ECHotAtmosphere r18 = this.l.peekFirst();
        if (r18 == null) goto L67;
        n(r18);
    L67:
        if (this.i == false) goto L73;
        h(false);
        return;
    L73:
        return;
    L72:
        return;
    L42:
        r13 = false;
    L8:
        if (r0 == null) goto L36;
        if (r1 == null) goto L36;
        if (r0.type == r1.type) goto L13;
        boolean r19 = true;
    L14:
        if (r19 == false) goto L18;
        h r20 = this.w;
        if (r20 == null) goto L36;
        r20.c(r0);
        goto L36
    L18:
        String r21 = r0.num;
        String r22 = r1.num;
        if (r21 == null) goto L36;
        if (r22 == null) goto L36;
        if (r21.length() <= 0) goto L24;
        boolean r23 = true;
    L25:
        if (r23 == false) goto L36;
        if (r22.length() <= 0) goto L29;
        boolean r24 = true;
    L30:
        if (r24 == false) goto L36;
        if ((!Intrinsics.areEqual(r21, r22)) == false) goto L36;
        h r25 = this.w;
        if (r25 == null) goto L36;
        r25.c(r0);
        goto L36
    L29:
        r24 = false;
        goto L30
    L24:
        r23 = false;
        goto L25
    L13:
        r19 = false;
        goto L14
    }

    public final void i() {
        this.l.clear();
        Animator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        SystemClock.elapsedRealtime();
        this.i = false;
        ViewGroup r1 = this.f;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        this.m = null;
    }

    public final void a() {
        animate().setListener(null).cancel();
        ViewGroup r0 = this.f;
        if (r0 == null) goto L9;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L9;
        ViewPropertyAnimator r10 = r1.setListener(null);
        if (r10 == null) goto L9;
        r10.cancel();
    L9:
        ECDraweeView r11 = this.c;
        if (r11 == null) goto L17;
        ViewPropertyAnimator r12 = r11.animate();
        if (r12 == null) goto L18;
        ViewPropertyAnimator r13 = r12.setListener(null);
        if (r13 == null) goto L19;
        r13.cancel();
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h r0 = this.w;
        if (r0 == null) goto L6;
        r0.onAttachedToWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h r0 = this.w;
        if (r0 == null) goto L5;
        r0.onDetachedFromWindow();
    L5:
        this.x = false;
    }

    public final int getMaxNumValue() {
        return this.z;
    }

    public final float d(float r10) {
        return UIUtils.dip2Px(getContext(), r10);
    }

    public final void h(boolean r10) {
        Animator r0 = this.g;
        boolean r1 = true;
        if (r0 == null) goto L8;
        if (r0.isRunning() != true) goto L8;
        return;
    L8:
        if (this.j == false) goto L10;
        return;
    L10:
        ECHotAtmosphere r11 = this.m;
        ECHotAtmosphere r12 = this.l.peekFirst();
        if (r11 == null) goto L16;
        if (r12 == null) goto L16;
        if (r11.type == r12.type) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == false) goto L20;
        if (r10 == true) goto L20;
        return;
    L20:
        ECHotAtmosphere r14 = this.l.poll();
        ViewGroup r15 = this.f;
        if (r14 == null) goto L38;
        if (r15 == null) goto L38;
        ECHotAtmosphere r16 = r14;
        this.m = r16;
        m(false);
        removeCallbacks(getHideHotAtmosphereAction());
        Function0<Integer> r17 = this.p;
        if (r17 == null) goto L30;
        Integer r18 = (Integer) r17.invoke();
        if (r18 == null) goto L30;
        if (r18.intValue() < 2) goto L30;
    L31:
        if (r1 == true) goto L36;
        AnimatorSet r19 = com.bytedance.android.ec.core.utils.f.c(r15, new float[]{1.0f, 1.3f, 1.0f});
        r19.setDuration(250);
        com.bytedance.android.ec.core.utils.f.a(r19, new ECHotAtmosphereView$onTextChange$$inlined$lets2$lambda$1(this));
        if (this.A == false) goto L35;
        setClipChildren(false);
        setClipToPadding(false);
    L35:
        r19.start();
        Unit r20 = Unit.INSTANCE;
        this.g = r19;
    L37:
        n(r16);
        Unit r21 = Unit.INSTANCE;
    L39:
        if (r21 == null) goto L41;
        return;
    L41:
        if (this.o == true) goto L43;
    L47:
        Unit r22 = Unit.INSTANCE;
        return;
    L43:
        if (this.a == false) goto L45;
        long r23 = 2000;
    L46:
        removeCallbacks(getHideHotAtmosphereAction());
        postDelayed(getHideHotAtmosphereAction(), r23);
        goto L47
    L45:
        r23 = 1000;
        goto L46
    L36:
        h(false);
    L30:
        r1 = false;
    L38:
        r21 = null;
    L16:
        r13 = false;
        goto L17
    }

    public final void l(boolean r10) {
        this.i = true;
        if (r10 == false) goto L6;
        h(false);
        return;
    }

    public final void m(boolean r10) {
        if (this.o == false) goto L5;
        setAlpha(1.0f);
    L5:
        ViewGroup r0 = this.f;
        if (r0 == null) goto L11;
        if (r10 == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        r0.animate().cancel();
        r0.setVisibility(0);
        r0.setAlpha(1.0f);
        r0.setTranslationX(0.0f);
        return;
    }

    public final void n(final ECHotAtmosphere r17) {
        ECDraweeView r0 = this.c;
        if (r0 != null) goto L5;
    L26:
        String r1 = r17.topImg;
        if (r1 != null) goto L29;
    L37:
        ECDraweeView r10 = this.d;
        if (r10 == null) goto L41;
        r10.setVisibility(8);
    L41:
        if (this.o == false) goto L55;
        TextView r11 = this.q;
        if (r11 == null) goto L55;
        if (a2.b(r17.prefix) == false) goto L47;
        String r12 = r17.prefix;
    L54:
        r11.setText(r12);
        goto L55
    L47:
        int r13 = r17.type;
        if (r13 != 10001) goto L50;
        r12 = th.a.g(getContext(), 2131913886);
        goto L54
    L50:
        if (r13 == 10002) goto L52;
        r12 = th.a.g(getContext(), 2131913886);
        goto L54
    L52:
        r12 = th.a.g(getContext(), 2131913891);
    L55:
        ItalicTextView r14 = this.e;
        if (r14 == null) goto L113;
        final int r15 = r17.getNumInt();
        int r16 = 20;
        int r18 = 11;
        if (this.o == false) goto L68;
        com.bytedance.android.ec.core.toolbox.text.d r19 = new com.bytedance.android.ec.core.toolbox.text.d(new SpannableStringBuilder());
        if (this.a == false) goto L62;
        r18 = 14;
    L62:
        r19.h(r18, new ECHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$1(this, r15));
        com.bytedance.android.ec.core.toolbox.text.c.a.a(r19, (int) d(2.0f));
        if (this.a == true) goto L66;
        r16 = 15;
    L66:
        r19.h(r16, new ECHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$2(this, r15));
        SpannedString r20 = r19.f();
    L111:
        r14.setText(r20);
        return;
    L68:
        if (this.A == false) goto L77;
        final long r110 = r17.getNumLong();
        com.bytedance.android.ec.core.toolbox.text.d r111 = new com.bytedance.android.ec.core.toolbox.text.d(new SpannableStringBuilder());
        int r21 = r17.type;
        if (r21 == 1) goto L72;
        if (r21 == 2) goto L72;
    L74:
        if (r17.type != 10001) goto L76;
        r111.h(10, new ECHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$3(this, r17, r110, r15));
        com.bytedance.android.ec.core.toolbox.text.c.a.a(r111, (int) d(1.0f));
    L76:
        r111.h(this.C, new ECHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$4(this, r17, r110, r15));
        r20 = r111.f();
    L72:
        r111.h(10, ECHotAtmosphereView$buildAnimTextStr$2$1.INSTANCE);
        com.bytedance.android.ec.core.toolbox.text.c.a.a(r111, (int) d(1.0f));
        goto L74
    L77:
        com.bytedance.android.ec.core.toolbox.text.d r22 = new com.bytedance.android.ec.core.toolbox.text.d(new SpannableStringBuilder());
        int r23 = r17.type;
        if (r23 == 2) goto L80;
        if (r23 == 1) goto L80;
    L88:
        b r24 = this.y;
        if (r24 == null) goto L92;
        r16 = r24.d;
    L95:
        r22.h(r16, new ECHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$5(this, r17, r15));
        if (r17.type == 2) goto L98;
    L110:
        r20 = r22.f();
        goto L111
    L98:
        if (r17.uiType != 2) goto L110;
        if (r17.getNumInt() >= 500) goto L102;
    L103:
        com.bytedance.android.ec.core.toolbox.text.c.a.a(r22, (int) d(2.5f));
        b r25 = this.y;
        if (r25 == null) goto L107;
        r18 = r25.e;
    L109:
        r22.h(r18, new ECHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$6(this, r17, r15));
        goto L110
    L107:
        if (this.a == false) goto L109;
        r18 = 13;
        goto L109
    L102:
        if (r17.getNumInt() < 10000) goto L110;
    L92:
        if (this.a == true) goto L95;
        r16 = 15;
    L80:
        b r26 = this.y;
        if (r26 == null) goto L84;
        int r27 = r26.c;
    L87:
        r22.h(r27, ECHotAtmosphereView$buildAnimTextStr$3$1.INSTANCE);
        com.bytedance.android.ec.core.toolbox.text.c.a.a(r22, (int) d(1.0f));
        goto L88
    L84:
        if (this.a == false) goto L86;
        r27 = 12;
        goto L87
    L86:
        r27 = 11;
        goto L87
    L113:
        return;
    L29:
        if (r1.length() <= 0) goto L31;
        boolean r28 = true;
    L32:
        if (r28 != true) goto L37;
        ECDraweeView r29 = this.d;
        if (r29 == null) goto L36;
        r29.setVisibility(0);
    L36:
        com.bytedance.android.ec.core.utils.y.d(this.d, r17.topImg);
        goto L41
    L31:
        r28 = false;
        goto L32
    L5:
        if (this.o == false) goto L10;
        String r30 = r17.img;
        if (r30 != null) goto L9;
        r30 = "";
    L9:
        r0.setImageURI(UriProtector.parse(r30));
        goto L26
    L10:
        Object r31 = r0.getTag();
        if ((r31 instanceof ECHotAtmosphere) == true) goto L13;
        r31 = null;
    L13:
        ECHotAtmosphere r32 = (ECHotAtmosphere) r31;
        if (r32 != null) goto L16;
    L17:
        r0.setTag(r17);
        Function0<Integer> r33 = this.p;
        if (r33 == null) goto L24;
        Integer r34 = (Integer) r33.invoke();
        if (r34 == null) goto L24;
        if (r34.intValue() < 2) goto L24;
        boolean r35 = true;
    L25:
        r0.setAutoPlayAnimation(!r35);
        com.bytedance.android.ec.core.utils.y.d(r0, r17.img);
    L24:
        r35 = false;
        goto L25
    L16:
        if (r32.type == r17.type) goto L26;
        goto L17
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r27) {
        Intrinsics.checkNotNullParameter(r27, "canvas");
        super.onDraw(r27);
        ECHotAtmosphere r10 = this.m;
        if (r10 != null) goto L5;
        r10 = this.l.peek();
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        float r11 = UIUtils.dip2Px(getContext(), r10.leftMargin);
        ViewGroup r12 = this.f;
        if (r12 == null) goto L10;
        float r13 = r12.getHeight();
    L11:
        float r14 = getWidth() - r11;
        float r15 = getHeight() - r13;
        int r16 = 0;
        if (this.v == true) goto L32;
        ECHotAtmosphere r17 = this.n;
        if (r17 == null) goto L32;
        if (r17.type != r10.type) goto L32;
        if (r17.leftMargin != r10.leftMargin) goto L32;
        List r18 = r17.bgColors;
        if (r18 == null) goto L28;
        String r19 = (String) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L28;
        List r20 = r10.bgColors;
        if (r20 == null) goto L28;
        String r21 = (String) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L28;
        boolean r22 = Intrinsics.areEqual(r19, r21);
    L29:
        if (r22 == false) goto L32;
        boolean r23 = false;
    L34:
        if (this.v == true) goto L41;
        ECHotAtmosphere r24 = this.n;
        if (r24 == null) goto L41;
        if (r24.leftMargin != r10.leftMargin) goto L41;
        boolean r110 = false;
    L42:
        this.n = r10;
        int r25 = r10.uiType;
        if (r25 == 1) goto L58;
        if (r25 == 2) goto L57;
        if (r25 == 5000) goto L47;
        int[] r111 = null;
    L70:
        int r26 = r10.uiType;
        if (r26 == 1) goto L87;
        if (r26 != 2) goto L74;
        int[] r28 = r10.getCacheBorderColors();
    L98:
        b r29 = this.y;
        if (r29 == null) goto L104;
        float[] r30 = r29.g;
        if (r30 == null) goto L104;
        float[] r112 = r30;
        int r31 = 3;
    L105:
        if (r23 == false) goto L115;
        if (r111 != null) goto L108;
    L114:
        char r210 = 2;
        char r211 = 3;
        getSolidPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, (int) 2566914048L, 0, Shader.TileMode.CLAMP));
    L116:
        if (r110 == false) goto L130;
        float r1 = getHeight() / 2.0f;
        getPath().reset();
        b r32 = this.y;
        if (r32 == null) goto L120;
        float[] r33 = r32.h;
    L121:
        if (r33 != null) goto L123;
        Path r34 = getPath();
        RectF r35 = new RectF(r11, r15, r14 + r11, r13 + r15);
        float[] r36 = new float[8];
        r36[0] = r1;
        r36[1] = r1;
        r36[r210] = 0.0f;
        r36[r211] = 0.0f;
        r36[4] = 0.0f;
        r36[5] = 0.0f;
        r36[6] = r1;
        r36[7] = r1;
        r34.addRoundRect(r35, r36, Path.Direction.CW);
        goto L130
    L123:
        if (r33.length != 0) goto L125;
        boolean r113 = true;
    L126:
        if (r113 == false) goto L128;
        getPath().addRect(r11, r15, r11 + r14, r15 + r13, Path.Direction.CW);
        goto L130
    L128:
        getPath().addRoundRect(new RectF(r11, r15, r14 + r11, r13 + r15), r33, Path.Direction.CW);
        goto L130
    L125:
        r113 = false;
        goto L126
    L120:
        r33 = null;
    L130:
        b r37 = this.y;
        if (r37 == null) goto L137;
        if (r37.k != true) goto L137;
        Canvas r38 = r27;
        boolean r39 = true;
    L138:
        b r40 = this.y;
        if (r40 != null) goto L141;
    L142:
        if (r28 == null) goto L144;
        r16 = r28.length;
    L144:
        if (r16 <= 0) goto L148;
        r38.drawPath(getPath(), getBorderPaint());
        return;
    L148:
        return;
    L141:
        if (r40.l != r39) goto L142;
        return;
    L137:
        r38 = r27;
        r39 = true;
        r38.drawPath(getPath(), getSolidPaint());
        goto L138
    L108:
        if (r111.length != r31) goto L114;
        if (r28 == null) goto L114;
        if (r28.length != r31) goto L114;
        r210 = 2;
        int[] r114 = r111;
        r211 = 3;
        float[] r115 = r112;
        getSolidPaint().setShader(new LinearGradient(0.0f, 0.0f, r14, 0.0f, r114, r115, Shader.TileMode.CLAMP));
        getBorderPaint().setShader(new LinearGradient(0.0f, 0.0f, r14, 0.0f, r28, r115, Shader.TileMode.CLAMP));
        goto L116
    L115:
        r210 = 2;
        r211 = 3;
    L104:
        r31 = 3;
        r112 = new float[]{0.0f, 0.8f, 1.0f};
        goto L105
    L74:
        if (r26 == 5000) goto L76;
        r28 = null;
        goto L98
    L76:
        b r41 = this.y;
        if (r41 != null) goto L79;
    L81:
        int r42 = com.bytedance.android.ec.core.utils.s.a;
        Integer r43 = com.bytedance.android.ec.core.utils.s.b(r10.borderColor);
        if (r43 == null) goto L84;
        int r44 = r43.intValue();
    L85:
        int[] r45 = {r44, r44, r44};
    L97:
        r28 = r45;
        goto L98
    L84:
        r44 = th.a.a(getContext(), 2131106164);
        goto L85
    L79:
        if (r41.f != true) goto L81;
        r28 = r10.getCacheBorderColors();
        goto L98
    L87:
        b r46 = this.y;
        if (r46 != null) goto L90;
    L92:
        int r47 = com.bytedance.android.ec.core.utils.s.a;
        Integer r48 = com.bytedance.android.ec.core.utils.s.b(r10.borderColor);
        if (r48 == null) goto L95;
        int r49 = r48.intValue();
    L96:
        float r50 = 255;
        r45 = new int[]{ColorUtils.setAlphaComponent(r49, (int) (0.8f * r50)), ColorUtils.setAlphaComponent(r49, (int) (0.6f * r50)), 0};
        goto L97
    L95:
        r49 = th.a.a(getContext(), 2131106164);
        goto L96
    L90:
        if (r46.f != true) goto L92;
        r28 = r10.getCacheBorderColors();
        goto L98
    L47:
        b r51 = this.y;
        if (r51 != null) goto L50;
    L52:
        int r52 = com.bytedance.android.ec.core.utils.s.a;
        Integer r53 = com.bytedance.android.ec.core.utils.s.b(r10.bgColor);
        if (r53 == null) goto L55;
        int r54 = r53.intValue();
    L56:
        int[] r116 = {r54, r54, r54};
    L69:
        r111 = r116;
        goto L70
    L55:
        r54 = th.a.a(getContext(), 2131106164);
        goto L56
    L50:
        if (r51.f != true) goto L52;
        int[] r55 = r10.getCacheBgColors();
    L63:
        r111 = r55;
        goto L70
    L57:
        r55 = r10.getCacheBgColors();
        goto L63
    L58:
        b r56 = this.y;
        if (r56 != null) goto L61;
    L64:
        int r57 = com.bytedance.android.ec.core.utils.s.a;
        Integer r58 = com.bytedance.android.ec.core.utils.s.b(r10.bgColor);
        if (r58 == null) goto L67;
        int r59 = r58.intValue();
    L68:
        float r117 = 255;
        r116 = new int[]{ColorUtils.setAlphaComponent(r59, (int) (0.8f * r117)), ColorUtils.setAlphaComponent(r59, (int) (r117 * 0.6f)), 0};
        goto L69
    L67:
        r59 = th.a.a(getContext(), 2131106164);
        goto L68
    L61:
        if (r56.f != true) goto L64;
        r55 = r10.getCacheBgColors();
    L41:
        r110 = true;
    L28:
        r22 = false;
    L32:
        r23 = true;
        goto L34
    L10:
        r13 = 0.0f;
        goto L11
    }

    public final void setCallback(h r1) {
        this.w = r1;
    }

    public final void setDegradeModeCallback(Function0<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        this.p = r10;
    }

    public final void setMaxWidth(int r1) {
        this.h = Integer.valueOf(r1);
    }

    public ECHotAtmosphereView(final Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.l = new LinkedList();
        this.r = LazyKt.lazy(new ECHotAtmosphereView$hideHotAtmosphereAction$2(this));
        this.s = LazyKt.lazy(ECHotAtmosphereView$path$2.INSTANCE);
        this.t = LazyKt.lazy(new ECHotAtmosphereView$solidPaint$2(r10));
        this.u = LazyKt.lazy(new ECHotAtmosphereView$borderPaint$2(r10));
        this.v = true;
        this.z = ECLiveSettings.INSTANCE.getHOT_SALE_NUM_LIMIT();
        setWillNotDraw(false);
        setClipToPadding(false);
        setOrientation(1);
        this.C = 18;
    }

    public final String e(int r10, int r11) {
        if (r11 == 2) goto L10;
        if (r10 <= this.z) goto L8;
        StringBuilder r12 = new StringBuilder();
        r12.append(this.z);
        r12.append('+');
        return r12.toString();
    L8:
        return String.valueOf(r10);
    L10:
        if (r10 <= 9999) goto L16;
        if (((r10 / IServerListener.WHAT_BYTELINK_SINK_ERROR) % 10) == 0) goto L18;
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(((double) r10) / 10000.0d)}, 1));
    L18:
        return String.valueOf(r10 / ServerInfo.ERROR_BIND_SERVICE);
    L16:
        return String.valueOf(r10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        if (this.b == true) goto L5;
    L9:
        Integer r0 = this.h;
        if (r0 != null) goto L13;
        r0 = Integer.valueOf(View.MeasureSpec.getSize(r10));
    L13:
        if (getLayoutParams().width == (-1)) goto L17;
        r10 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
    L17:
        if (this.a == true) goto L32;
        ECDraweeView r12 = this.d;
        if (r12 != null) goto L21;
    L23:
        int r13 = 0;
    L24:
        ViewGroup.LayoutParams r14 = getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L27;
        r14 = null;
    L27:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L32;
        if (r15.topMargin == r13) goto L32;
        r15.topMargin = r13;
        setLayoutParams(r15);
        goto L32
    L21:
        if (r12.getVisibility() == 8) goto L23;
        r13 = -r12.getMeasuredHeight();
    L32:
        super.onMeasure(r10, r11);
        if (getMeasuredWidth() <= r0.intValue()) goto L36;
        setMeasuredDimension(r0.intValue(), getMeasuredHeight());
    L36:
        if (getMeasuredWidth() <= 0) goto L58;
        ItalicTextView r16 = this.e;
        if (r16 == null) goto L59;
        int r17 = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        ECDraweeView r1 = this.c;
        if (r1 == null) goto L42;
        int r18 = r1.getMeasuredWidth();
    L43:
        int r19 = r17 - r18;
        TextView r20 = this.q;
        if (r20 == null) goto L46;
        int r21 = r20.getMeasuredWidth();
    L47:
        int r22 = r19 - r21;
        if (r16.getMeasuredWidth() != 0) goto L50;
        float r23 = 1.0f;
    L52:
        if (r23 < 1) goto L54;
    L56:
        r16.setScaleX(1.0f);
        r16.setScaleY(1.0f);
        return;
    L54:
        if (r23 <= 0) goto L56;
        r16.setScaleX(r23);
        r16.setScaleY(r23);
        r16.setPivotX(0.0f);
        r16.setPivotY(r16.getMeasuredHeight() / 2.0f);
        return;
    L50:
        r23 = r22 / r16.getMeasuredWidth();
        goto L52
    L46:
        r21 = 0;
        goto L47
    L42:
        r18 = 0;
        goto L43
    L59:
        return;
    L58:
        return;
    L5:
        if (this.a == true) goto L9;
        if (this.x == true) goto L9;
        this.x = true;
        c(this, false, 0);
        goto L9
    }

    public static void c(View r1, boolean r10, int r11) {
        if (r10 == false) goto L4;
        return;
    L4:
        if (r11 > 4) goto L17;
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r1 instanceof ViewGroup) == false) goto L10;
        ViewGroup r12 = (ViewGroup) r1;
        r12.setClipChildren(false);
        r12.setClipToPadding(false);
    L10:
        Object r13 = r1.getParent();
        if ((r13 instanceof View) == true) goto L13;
        r13 = null;
    L13:
        c((View) r13, r1 instanceof RecyclerView, r11 + 1);
        return;
    }

    public final void f(boolean r21, boolean r22, b r23) {
        this.y = r23;
        this.a = r21;
        this.o = r22;
        int r10 = 1;
        this.b = true;
        float r11 = 24.0f;
        if (getChildCount() == 0) goto L5;
        if (r23 == null) goto L59;
        r11 = r23.b;
    L62:
        int r1 = (int) d(r11);
        ECDraweeView r12 = this.c;
        if (r12 == null) goto L67;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L67;
        r13.height = r1;
    L67:
        ViewGroup r14 = this.f;
        if (r14 == null) goto L75;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L76;
        r15.height = r1;
        return;
    L76:
        return;
    L75:
        return;
    L59:
        if (r21 == true) goto L62;
        r11 = 20.0f;
        goto L62
    L5:
        if (r23 == null) goto L7;
        Float r16 = r23.j;
    L8:
        if (r16 == null) goto L10;
        float r17 = d(r23.j.floatValue());
    L16:
        setPadding(0, 0, (int) r17, 0);
        if (r23 == null) goto L19;
        r11 = r23.b;
    L22:
        int r18 = (int) d(r11);
        ECDraweeView r19 = new ECDraweeView(getContext(), null, 0, 6, null);
        r19.setAdjustMode(1);
        this.d = r19;
        r19.setAutoPlayAnimation(true);
        if (r23 == null) goto L25;
        float r20 = r23.a;
    L28:
        r19.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) d(r20)));
        Unit r24 = Unit.INSTANCE;
        addView(r19);
        LinearLayout r25 = new LinearLayout(getContext());
        r25.setOrientation(0);
        if (r22 == false) goto L31;
        r25.setGravity(16);
        int r26 = (int) d(18.0f);
        ECDraweeView r110 = new ECDraweeView(r25.getContext(), null, 0, 6, null);
        this.c = r110;
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(r26, r26);
        r110.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(r26 / 2.0f));
        r111.leftMargin = (int) d(3.0f);
        r111.rightMargin = (int) d(3.0f);
        r110.setLayoutParams(r111);
        r25.addView(r110);
        TextView r27 = new TextView(r25.getContext());
        this.q = r27;
        r27.setIncludeFontPadding(false);
        r27.setTextColor(-1);
        r27.setTextSize(1, 10.0f);
        r27.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r25.addView(r27);
    L36:
        FrameLayout r28 = new FrameLayout(r25.getContext());
        this.f = r28;
        r28.setVisibility(8);
        r28.setLayoutParams(new LinearLayout.LayoutParams(-1, r18));
        ItalicTextView r29 = new ItalicTextView(r28.getContext(), null);
        this.e = r29;
        r29.setIncludeFontPadding(false);
        if (r22 == false) goto L39;
        r10 = 3;
    L39:
        r29.setTypeface(null, r10);
        if (this.A == false) goto L50;
        r29.setTypeface(ECFontHelper.e.b("DouyinNumberABC", FontWeight.WEIGHT_600, false));
        if (this.B == true) goto L44;
        ItalicTextView r30 = this.e;
        if (r30 == null) goto L50;
        r30.setTranslationY(-1.0f);
        goto L50
    L44:
        if (Build.VERSION.SDK_INT < 28) goto L46;
        r29.setFallbackLineSpacing(false);
    L46:
        r29.setGravity(16);
        r29.setLineSpacing(0.0f, r29.getLineSpacingMultiplier());
    L50:
        r29.setTextColor(-1);
        if (this.A == false) goto L53;
        int r31 = com.bytedance.android.shopping.extensions.b.b(20);
    L54:
        FrameLayout.LayoutParams r32 = new FrameLayout.LayoutParams(-2, r31);
        r32.gravity = 16;
        r29.setLayoutParams(r32);
        r28.addView(r29);
        r25.addView(r28);
        addView(r25);
        ViewGroup r33 = this.f;
        if (r33 == null) goto L73;
        r33.setPadding((int) d(2.0f), 0, 0, 0);
        return;
    L73:
        return;
    L53:
        r31 = -2;
        goto L54
    L31:
        r25.setGravity(80);
        ECDraweeView r112 = new ECDraweeView(r25.getContext(), null, 0, 6, null);
        this.c = r112;
        r112.setAdjustMode(1);
        r112.setAutoPlayAnimation(true);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, r18);
        r113.gravity = 80;
        if (r23 == null) goto L34;
        float r34 = r23.i;
    L35:
        r113.rightMargin = (int) d(r34);
        r112.setLayoutParams(r113);
        r25.addView(r112);
        goto L36
    L34:
        r34 = 0.0f;
        goto L35
    L25:
        if (r21 == false) goto L27;
        r20 = 14.0f;
        goto L28
    L27:
        r20 = 11.67f;
        goto L28
    L19:
        if (r21 == true) goto L22;
        r11 = 20.0f;
        goto L22
    L10:
        if (r21 == true) goto L12;
        r17 = d(20.0f);
        goto L16
    L12:
        if (this.A == false) goto L14;
        r17 = d(4.0f);
        goto L16
    L14:
        r17 = d(8.0f);
        goto L16
    L7:
        r16 = null;
        goto L8
    }

    public final void j(ECHotAtmosphere r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "info");
        ImagePipeline r0 = Fresco.getImagePipeline();
        if (r0 != null) goto L5;
    L10:
        if (r11 == false) goto L49;
        ECHotAtmosphere r13 = r10.copy();
        ECHotAtmosphere r14 = this.l.peek();
        if (r14 != null) goto L14;
    L15:
        this.l.clear();
    L16:
        ECHotAtmosphere r15 = this.l.peekLast();
        if (r15 != null) goto L19;
        r15 = this.m;
    L19:
        boolean r1 = true;
        if (this.o == true) goto L22;
    L24:
        int r16 = r13.type;
        if (r16 != 2) goto L27;
        if (r15 != null) goto L41;
    L46:
        if (r1 == false) goto L48;
        this.l.offer(r13);
    L48:
        b();
        return;
    L41:
        if (r15.getNumInt() < r13.getNumInt()) goto L43;
    L45:
        r1 = false;
        goto L46
    L43:
        if ((!Intrinsics.areEqual(e(r15.getNumInt(), r15.uiType), e(r13.getNumInt(), r15.uiType))) == false) goto L45;
    L27:
        if (r16 != 4) goto L29;
        if (r15 == null) goto L46;
        if (r15.getNumInt() >= r13.getNumInt()) goto L45;
    L29:
        if (r16 != 10001) goto L31;
    L33:
        boolean r17 = r13.isEquals(r15);
    L34:
        r1 = true ^ r17;
        goto L46
    L31:
        if (r16 == 10002) goto L33;
    L22:
        if (a2.b(r13.prefix) == false) goto L24;
        r17 = r13.isEquals(r15);
        goto L34
    L14:
        if (r14.type == r13.type) goto L16;
    L49:
        this.l.clear();
        a();
        setAlpha(1.0f);
        this.m = r10;
        m(r12);
        n(r10);
        return;
    L5:
        if (a2.b(r10.img) == false) goto L10;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L8
        Result.constructor-impl(r0.prefetchToDiskCache(ImageRequest.fromUri(r10.img), getContext()));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static /* synthetic */ void k(ECHotAtmosphereView r0, ECHotAtmosphere r1, boolean r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        r0.j(r1, r10, false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r10, int r11, int r12) {
        super.onSizeChanged(r1, r10, r11, r12);
        if (r1 == r11) goto L6;
        this.v = true;
        return;
    }

    public static /* synthetic */ void g(ECHotAtmosphereView r1, boolean r10, boolean r11, b r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        r1.f(r10, r11, r12);
    }
}
