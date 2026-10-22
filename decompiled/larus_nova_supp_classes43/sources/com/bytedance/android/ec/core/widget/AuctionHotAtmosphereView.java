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
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.sink.api.IServerListener;
import com.byted.cast.sink.api.ServerInfo;
import com.bytedance.android.ec.core.abtest.ECLiveSettings;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
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
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000b\u0018\u00002\u00020\u0001:\u0001.B\u0019\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\tR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\"\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010&¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/core/widget/AuctionHotAtmosphereView;", "Landroid/widget/LinearLayout;", "", "width", "", "setMaxWidth", "Lcom/bytedance/android/ec/core/widget/h;", "callback", "setCallback", "Lkotlin/Function0;", "setDegradeModeCallback", "com/bytedance/android/ec/core/widget/AuctionHotAtmosphereView$hideHotAtmosphereAction$2$a", "p", "Lkotlin/Lazy;", "getHideHotAtmosphereAction", "()Lcom/bytedance/android/ec/core/widget/AuctionHotAtmosphereView$hideHotAtmosphereAction$2$a;", "hideHotAtmosphereAction", "Landroid/graphics/Path;", "q", "getPath", "()Landroid/graphics/Path;", "path", "Landroid/graphics/Paint;", "r", "getSolidPaint", "()Landroid/graphics/Paint;", "solidPaint", "s", "getBorderPaint", "borderPaint", "w", "I", "getMaxNumValue", "()I", "maxNumValue", "Landroid/graphics/Typeface;", "x", "getNumberTypeface", "()Landroid/graphics/Typeface;", "numberTypeface", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionHotAtmosphereView extends LinearLayout {
    public static final /* synthetic */ int y = 0;
    public boolean a;
    public boolean b;
    public ECDraweeView c;
    public ItalicTextView d;
    public ImageView e;
    public ViewGroup f;
    public Animator g;
    public Integer h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final LinkedList<ECHotAtmosphere> l;
    public ECHotAtmosphere m;
    public ECHotAtmosphere n;
    public Function0<Integer> o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public boolean t;
    public h u;
    public boolean v;
    public final int w;
    public final Lazy x;

    public static final class a {
    }

    static {
    }

    private final Paint getBorderPaint() {
        return (Paint) this.s.getValue();
    }

    private final AuctionHotAtmosphereView$hideHotAtmosphereAction$2.a getHideHotAtmosphereAction() {
        return (AuctionHotAtmosphereView$hideHotAtmosphereAction$2.a) this.p.getValue();
    }

    private final Typeface getNumberTypeface() {
        return (Typeface) this.x.getValue();
    }

    private final Path getPath() {
        return (Path) this.q.getValue();
    }

    private final Paint getSolidPaint() {
        return (Paint) this.r.getValue();
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
        h r10 = this.u;
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
        h r14 = this.u;
        if (r14 == null) goto L52;
        r14.a(this.l.peek());
    L52:
        this.j = true;
        ViewPropertyAnimator r15 = animate().alpha(0.0f).setDuration(300);
        com.bytedance.android.ec.core.utils.f.b(r15, new AuctionHotAtmosphereView$consumeNextItem$1(this));
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
        k(r18);
    L67:
        if (this.i == false) goto L73;
        g(false);
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
        h r20 = this.u;
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
        h r25 = this.u;
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

    public final void h() {
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
        h r0 = this.u;
        if (r0 == null) goto L6;
        r0.onAttachedToWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h r0 = this.u;
        if (r0 == null) goto L5;
        r0.onDetachedFromWindow();
    L5:
        this.v = false;
    }

    public final int getMaxNumValue() {
        return this.w;
    }

    public final float d(float r10) {
        return UIUtils.dip2Px(getContext(), r10);
    }

    public final void f(boolean r12) {
        this.a = r12;
        this.b = true;
        if (getChildCount() != 0) goto L15;
        if (r12 == false) goto L6;
        float r1 = 4.0f;
    L7:
        setPadding(0, 0, (int) d(r1), 0);
        if (r12 == false) goto L10;
        float r13 = 24.0f;
    L11:
        int r14 = (int) d(r13);
        LinearLayout r10 = new LinearLayout(getContext());
        r10.setOrientation(0);
        r10.setGravity(80);
        r10.setClipChildren(false);
        ECDraweeView r11 = new ECDraweeView(r10.getContext(), null, 0, 6, null);
        this.c = r11;
        r11.setAdjustMode(1);
        r11.setAutoPlayAnimation(true);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, r14);
        r15.gravity = 80;
        Unit r16 = Unit.INSTANCE;
        r11.setLayoutParams(r15);
        r10.addView(r11);
        FrameLayout r17 = new FrameLayout(r10.getContext());
        this.f = r17;
        r17.setVisibility(8);
        r17.setLayoutParams(new LinearLayout.LayoutParams(-2, r14));
        r17.setClipChildren(false);
        r17.setClipToPadding(false);
        ItalicTextView r18 = new ItalicTextView(r17.getContext(), null);
        this.d = r18;
        r18.setIncludeFontPadding(false);
        r18.setTypeface(getNumberTypeface());
        r18.setTextColor(-1);
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
        r19.gravity = 16;
        r18.setLayoutParams(r19);
        r18.setMaxLines(1);
        r17.addView(r18);
        r10.addView(r17);
        ImageView r110 = new ImageView(r10.getContext());
        this.e = r110;
        r110.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r110.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r110.setAdjustViewBounds(true);
        r110.setPadding((int) d(2.0f), 0, 0, 0);
        r10.addView(r110);
        addView(r10);
        ViewGroup r111 = this.f;
        if (r111 == null) goto L16;
        r111.setPadding((int) d(2.0f), 0, 0, 0);
        return;
    L16:
        return;
    L10:
        r13 = 20.0f;
        goto L11
    L6:
        r1 = 16.0f;
        goto L7
    }

    public final void g(boolean r10) {
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
        if (r14 == null) goto L36;
        if (r15 == null) goto L37;
        ECHotAtmosphere r16 = r14;
        this.m = r16;
        j(false);
        removeCallbacks(getHideHotAtmosphereAction());
        Function0<Integer> r17 = this.o;
        if (r17 == null) goto L30;
        Integer r18 = (Integer) r17.invoke();
        if (r18 == null) goto L30;
        if (r18.intValue() < 2) goto L30;
    L31:
        if (r1 == true) goto L33;
        AnimatorSet r19 = com.bytedance.android.ec.core.utils.f.c(r15, new float[]{1.0f, 1.3f, 1.0f});
        r19.setDuration(250);
        com.bytedance.android.ec.core.utils.f.a(r19, new AuctionHotAtmosphereView$onTextChange$$inlined$lets2$lambda$1(this));
        r19.start();
        Unit r20 = Unit.INSTANCE;
        this.g = r19;
    L34:
        k(r16);
        return;
    L33:
        g(false);
    L30:
        r1 = false;
        goto L31
    L37:
        return;
    L36:
        return;
    L16:
        r13 = false;
        goto L17
    }

    public final void j(boolean r10) {
        ViewGroup r0 = this.f;
        if (r0 == null) goto L8;
        if (r10 == false) goto L6;
        r0.setVisibility(8);
        return;
    L6:
        r0.animate().cancel();
        r0.setVisibility(0);
        r0.setAlpha(1.0f);
        r0.setTranslationX(0.0f);
        return;
    }

    public final void k(final ECHotAtmosphere r10) {
        ECDraweeView r0 = this.c;
        Integer r11 = null;
        if (r0 == null) goto L22;
        Object r12 = r0.getTag();
        if ((r12 instanceof ECHotAtmosphere) == true) goto L7;
        r12 = null;
    L7:
        ECHotAtmosphere r13 = (ECHotAtmosphere) r12;
        if (r13 != null) goto L10;
    L13:
        r0.setTag(r10);
        Function0<Integer> r14 = this.o;
        if (r14 == null) goto L20;
        Integer r15 = (Integer) r14.invoke();
        if (r15 == null) goto L20;
        if (r15.intValue() < 2) goto L20;
        boolean r16 = true;
    L21:
        r0.setAutoPlayAnimation(!r16);
        com.bytedance.android.ec.core.utils.y.d(r0, r10.img);
    L20:
        r16 = false;
        goto L21
    L10:
        if (r13.type != r10.type) goto L13;
        if ((!Intrinsics.areEqual(r13.img, r10.img)) == true) goto L13;
    L22:
        String r1 = r10.topImg;
        if (r1 != null) goto L25;
    L30:
        Integer r17 = Integer.valueOf(r10.afterTextIconResId);
        if (r17.intValue() == 0) goto L33;
        boolean r18 = true;
    L34:
        if (r18 == false) goto L36;
        r11 = r17;
    L36:
        if (r11 == null) goto L43;
        int r19 = r11.intValue();
        ImageView r20 = this.e;
        if (r20 == null) goto L40;
        r20.setVisibility(0);
    L40:
        ImageView r21 = this.e;
        if (r21 == null) goto L47;
        r21.setImageResource(r19);
    L47:
        ItalicTextView r22 = this.d;
        if (r22 == null) goto L78;
        final int r23 = r10.getNumInt();
        com.bytedance.android.ec.core.toolbox.text.d r24 = new com.bytedance.android.ec.core.toolbox.text.d(new SpannableStringBuilder());
        int r25 = r10.type;
        int r26 = 11;
        if (r25 == 2) goto L53;
        if (r25 == 1) goto L53;
    L58:
        if (Intrinsics.areEqual(r10.auctionType, "digital") == false) goto L61;
        r24.h(10, AuctionHotAtmosphereView$buildAnimTextStr$1$2.INSTANCE);
        com.bytedance.android.ec.core.toolbox.text.c.a.a(r24, (int) d(1.0f));
    L61:
        if (this.a == false) goto L63;
        int r27 = 18;
    L64:
        r24.h(r27, new AuctionHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$1(this, r10, r23));
        if (r10.type == 2) goto L67;
    L76:
        r22.setText(r24.f());
        return;
    L67:
        if (r10.uiType != 2) goto L76;
        if (r10.getNumInt() >= 500) goto L71;
    L72:
        com.bytedance.android.ec.core.toolbox.text.c.a.a(r24, (int) d(2.5f));
        if (this.a == false) goto L75;
        r26 = 13;
    L75:
        r24.h(r26, new AuctionHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$2(this, r10, r23));
        goto L76
    L71:
        if (r10.getNumInt() < 10000) goto L76;
    L63:
        r27 = 15;
    L53:
        if (this.a == false) goto L55;
        int r28 = 12;
    L56:
        r24.h(r28, AuctionHotAtmosphereView$buildAnimTextStr$1$1.INSTANCE);
        com.bytedance.android.ec.core.toolbox.text.c.a.a(r24, (int) d(1.0f));
        goto L58
    L55:
        r28 = 11;
        goto L56
    L78:
        return;
    L43:
        ImageView r29 = this.e;
        if (r29 == null) goto L46;
        r29.setVisibility(8);
    L46:
        Unit r30 = Unit.INSTANCE;
        goto L47
    L33:
        r18 = false;
        goto L34
    L25:
        if (r1.length() <= 0) goto L27;
        boolean r31 = true;
    L28:
        if (r31 != true) goto L30;
        com.bytedance.android.ec.core.utils.y.d(null, r10.topImg);
        goto L30
    L27:
        r31 = false;
        goto L28
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
        if (this.t == true) goto L32;
        ECHotAtmosphere r16 = this.n;
        if (r16 == null) goto L32;
        if (r16.type != r10.type) goto L32;
        if (r16.leftMargin != r10.leftMargin) goto L32;
        List r17 = r16.bgColors;
        if (r17 == null) goto L28;
        String r18 = (String) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L28;
        List r19 = r10.bgColors;
        if (r19 == null) goto L28;
        String r20 = (String) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L28;
        boolean r21 = Intrinsics.areEqual(r18, r20);
    L29:
        if (r21 == false) goto L32;
        boolean r22 = false;
    L34:
        if (this.t == true) goto L41;
        ECHotAtmosphere r23 = this.n;
        if (r23 == null) goto L41;
        if (r23.leftMargin != r10.leftMargin) goto L41;
        boolean r110 = false;
    L42:
        this.n = r10;
        int r24 = com.bytedance.android.ec.core.utils.s.a;
        Integer r25 = com.bytedance.android.ec.core.utils.s.b(r10.bgColor);
        if (r25 == null) goto L45;
        int r26 = r25.intValue();
    L46:
        float r111 = 255;
        int r112 = (int) (0.8f * r111);
        int r113 = (int) (0.6f * r111);
        int[] r114 = {ColorUtils.setAlphaComponent(r26, r112), ColorUtils.setAlphaComponent(r26, r113), 0};
        Integer r28 = com.bytedance.android.ec.core.utils.s.b(r10.borderColor);
        if (r28 == null) goto L49;
        int r29 = r28.intValue();
    L50:
        int[] r115 = {ColorUtils.setAlphaComponent(r29, r112), ColorUtils.setAlphaComponent(r29, r113), 0};
        float[] r30 = {0.0f, 0.8f, 1.0f};
        if (r22 == false) goto L53;
        char r210 = 3;
        getSolidPaint().setShader(new LinearGradient(0.0f, 0.0f, r14, 0.0f, r114, r30, Shader.TileMode.CLAMP));
        getBorderPaint().setShader(new LinearGradient(0.0f, 0.0f, r14, 0.0f, r115, r30, Shader.TileMode.CLAMP));
    L54:
        if (r110 == false) goto L56;
        float r31 = getHeight() / 2.0f;
        getPath().reset();
        Path r32 = getPath();
        RectF r33 = new RectF(r11, r15, r14 + r11, r13 + r15);
        float[] r34 = new float[8];
        r34[0] = r31;
        r34[1] = r31;
        r34[2] = 0.0f;
        r34[r210] = 0.0f;
        r34[4] = 0.0f;
        r34[5] = 0.0f;
        r34[6] = r31;
        r34[7] = r31;
        r32.addRoundRect(r33, r34, Path.Direction.CW);
    L56:
        r27.drawPath(getPath(), getSolidPaint());
        r27.drawPath(getPath(), getBorderPaint());
        return;
    L53:
        r210 = 3;
        goto L54
    L49:
        r29 = th.a.a(getContext(), 2131106164);
        goto L50
    L45:
        r26 = th.a.a(getContext(), 2131106164);
    L41:
        r110 = true;
    L28:
        r21 = false;
    L32:
        r22 = true;
        goto L34
    L10:
        r13 = 0.0f;
        goto L11
    }

    public final void setCallback(h r1) {
        this.u = r1;
    }

    public final void setDegradeModeCallback(Function0<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        this.o = r10;
    }

    public final void setMaxWidth(int r1) {
        this.h = Integer.valueOf(r1);
    }

    public AuctionHotAtmosphereView(final Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.l = new LinkedList();
        this.p = LazyKt.lazy(new AuctionHotAtmosphereView$hideHotAtmosphereAction$2(this));
        this.q = LazyKt.lazy(AuctionHotAtmosphereView$path$2.INSTANCE);
        this.r = LazyKt.lazy(new AuctionHotAtmosphereView$solidPaint$2(r10));
        this.s = LazyKt.lazy(new AuctionHotAtmosphereView$borderPaint$2(r10));
        this.t = true;
        this.w = ECLiveSettings.INSTANCE.getHOT_SALE_NUM_LIMIT();
        this.x = LazyKt.lazy(AuctionHotAtmosphereView$numberTypeface$2.INSTANCE);
        setWillNotDraw(false);
        setClipToPadding(false);
        setOrientation(1);
    }

    public final String e(int r10, int r11) {
        if (r11 == 2) goto L10;
        if (r10 <= this.w) goto L8;
        StringBuilder r12 = new StringBuilder();
        r12.append(this.w);
        r12.append('+');
        return r12.toString();
    L8:
        return String.valueOf(r10);
    L10:
        if (r10 <= 9999) goto L19;
        if (((r10 / IServerListener.WHAT_BYTELINK_SINK_ERROR) % 10) == 0) goto L23;
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L16
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(((double) r10) / 10000.0d)}, 1));
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return "";
    L23:
        return String.valueOf(r10 / ServerInfo.ERROR_BIND_SERVICE);
    L19:
        return String.valueOf(r10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        boolean r1 = true;
        if (this.b == true) goto L5;
    L9:
        Integer r0 = this.h;
        if (r0 != null) goto L13;
        r0 = Integer.valueOf(View.MeasureSpec.getSize(r10));
    L13:
        if (getLayoutParams().width == (-1)) goto L16;
        r10 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
    L16:
        CharSequence r12 = null;
        if (this.a == true) goto L26;
        ViewGroup.LayoutParams r13 = getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        r13 = null;
    L21:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        if (r14 == null) goto L26;
        if (r14.topMargin == 0) goto L26;
        r14.topMargin = 0;
        setLayoutParams(r14);
    L26:
        super.onMeasure(r10, r11);
        if (getMeasuredWidth() <= r0.intValue()) goto L30;
        setMeasuredDimension(r0.intValue(), getMeasuredHeight());
    L30:
        if (getMeasuredWidth() <= 0) goto L72;
        ItalicTextView r15 = this.d;
        if (r15 == null) goto L73;
        int r16 = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        ECDraweeView r17 = this.c;
        if (r17 == null) goto L36;
        int r18 = r17.getMeasuredWidth();
    L37:
        int r19 = r16 - r18;
        CharSequence r20 = r15.getText();
        if (r20 != null) goto L40;
    L47:
        int r21 = 0;
    L48:
        ImageView r22 = this.e;
        if (r22 != null) goto L51;
    L52:
        boolean r23 = this.a;
        if (r23 == false) goto L61;
        if (r23 == false) goto L56;
        float r24 = 80.0f;
    L57:
        r15.measure(View.MeasureSpec.makeMeasureSpec((int) d(r24), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (r21 <= 0) goto L62;
        float r25 = r19 - com.bytedance.android.shopping.extensions.b.b(8);
    L64:
        float r26 = r25 / r21;
    L66:
        if (r26 < 1.0f) goto L68;
    L70:
        r15.setScaleX(1.0f);
        r15.setScaleY(1.0f);
        return;
    L68:
        if (r26 <= 0.0f) goto L70;
        r15.setScaleX(r26);
        r15.setScaleY(r26);
        r15.setPivotX(0.0f);
        r15.setPivotY(r15.getMeasuredHeight() / 2.0f);
        return;
    L62:
        r26 = 1.0f;
        goto L66
    L56:
        r24 = 60.0f;
    L61:
        if (r15.getMeasuredWidth() == 0) goto L62;
        r25 = r19;
        r21 = r15.getMeasuredWidth();
        goto L64
    L51:
        if (r22.getVisibility() == 0) goto L61;
    L40:
        if (r20.length() > 0) goto L43;
        r1 = false;
    L43:
        if (r1 == false) goto L45;
        r12 = r20;
    L45:
        if (r12 == null) goto L47;
        r21 = (int) r15.getPaint().measureText(r12, 0, r12.length());
        goto L48
    L36:
        r18 = 0;
        goto L37
    L73:
        return;
    L72:
        return;
    L5:
        if (this.a == true) goto L9;
        if (this.v == true) goto L9;
        this.v = true;
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

    public final void i(ECHotAtmosphere r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "info");
        ImagePipeline r0 = Fresco.getImagePipeline();
        if (r0 != null) goto L5;
    L10:
        if (r11 == false) goto L43;
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
        int r16 = r13.type;
        boolean r1 = true;
        if (r16 != 2) goto L22;
        if (r15 != null) goto L35;
    L40:
        if (r1 == false) goto L42;
        this.l.offer(r13);
    L42:
        b();
        return;
    L35:
        if (r15.getNumInt() < r13.getNumInt()) goto L37;
    L39:
        r1 = false;
        goto L40
    L37:
        if ((!Intrinsics.areEqual(e(r15.getNumInt(), r15.uiType), e(r13.getNumInt(), r15.uiType))) == false) goto L39;
    L22:
        if (r16 != 4) goto L24;
        if (r15 == null) goto L40;
        if (r15.getNumInt() >= r13.getNumInt()) goto L39;
    L24:
        if (r16 != 10001) goto L26;
    L28:
        r1 = true ^ r13.isEquals(r15);
        goto L40
    L26:
        if (r16 == 10002) goto L28;
    L14:
        if (r14.type == r13.type) goto L16;
    L43:
        this.l.clear();
        a();
        setAlpha(1.0f);
        this.m = r10;
        j(r12);
        k(r10);
        return;
    L5:
        if (a2.b(r10.img) == false) goto L10;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L8
        Result.constructor-impl(r0.prefetchToDiskCache(ImageRequest.fromUri(r10.img), getContext()));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r10, int r11, int r12) {
        super.onSizeChanged(r1, r10, r11, r12);
        if (r1 == r11) goto L6;
        this.t = true;
        return;
    }
}
