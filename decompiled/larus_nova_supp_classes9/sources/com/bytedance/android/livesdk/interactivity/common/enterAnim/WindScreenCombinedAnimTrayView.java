package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.g4;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.o6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.CombinedTextRenderView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayImageListView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayTextView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.m;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.o;
import com.bytedance.android.livesdk.message.model.pg;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003$%&B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/WindScreenCombinedAnimTrayView;", "Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/BaseWindScreenAnimEnterTrayView;", "Lk32/d;", "msg", BuildConfig.FLAVOR, "setCombineText", BuildConfig.FLAVOR, "textSize", "setTextSize", "Lcom/bytedance/android/live/base/model/message/e;", "getComboInfo", "setBackground", "Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/WindScreenCombinedAnimTrayView$c;", "f", "Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/WindScreenCombinedAnimTrayView$c;", "getConfigSceneInterceptor", "()Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/WindScreenCombinedAnimTrayView$c;", "setConfigSceneInterceptor", "(Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/WindScreenCombinedAnimTrayView$c;)V", "configSceneInterceptor", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "g", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "getOnSchemaHandleListener", "()Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "setOnSchemaHandleListener", "(Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;)V", "onSchemaHandleListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindScreenCombinedAnimTrayView extends BaseWindScreenAnimEnterTrayView {
    public static final /* synthetic */ int j = 0;
    public final ViewGroup b;
    public final ViewGroup c;
    public final CombinedTextRenderView d;
    public final RadiusHSImageView e;
    public c f;
    public o g;
    public final CompositeDisposable h;
    public final CombinedTextRenderView.a i;

    public static final class a implements com.bytedance.android.livesdk.interactivity.common.enterAnim.c {
        public boolean a;
        public boolean b;
        public final Function0<Unit> c;

        @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
        public final void a() {
            this.a = true;
            if (this.b == false) goto L7;
            this.c.invoke();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
        public final void b() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
        public final void c() {
            this.b = true;
            if (this.a == false) goto L6;
            this.c.invoke();
            return;
        }

        public a(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "onRenderEndCallBack");
            this.c = r2;
        }
    }

    public static final class b {
    }

    public interface c {
        CombinedTextRenderView.a a(CombinedTextRenderView.a r1, g4 r2);
    }

    public static final class d implements a3.b {
        public final /* synthetic */ WindScreenCombinedAnimTrayView a;
        public final /* synthetic */ k32.d b;

        public final void onFail() {
            ALogger.d("WindScreenCombinedAnimTrayView", "error load nine patch");
            com.bytedance.android.livesdk.interactivity.common.enterAnim.c r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public final void a(NinePatchDrawable r8) {
            Intrinsics.checkNotNullParameter(r8, "ninePatchDrawable");
            com.bytedance.android.livesdk.interactivity.common.enterAnim.c r0 = this.a.a;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            h3 r1 = this.b.t;
            if (r1 == null) goto L17;
            pg.a r2 = r1.getBackground();
            if (r2 == null) goto L17;
            ImageModel r3 = r2.c();
            if (r3 == null) goto L17;
            WindScreenCombinedAnimTrayView r4 = this.a;
            int r5 = WindScreenCombinedAnimTrayView.j;
            r4.getClass();
            PipelineDraweeControllerBuilder r6 = Fresco.newDraweeControllerBuilder();
            List r7 = r3.getUrls();
            if (r7 == null) goto L15;
            String r9 = (String) ListProtector.get(r7, 0);
            if (r9 == null) goto L15;
        L16:
            AbstractDraweeController r10 = r6.setUri(UriProtector.parse(r9)).setAutoPlayAnimations(true).setControllerListener(new e()).build();
            RxUtilKt.c(Single.timer(50, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.common.enterAnim.d(r4, r10)), r4.h);
        L15:
            r9 = BuildConfig.FLAVOR;
        L17:
            Rect r11 = new Rect();
            r8.getPadding(r11);
            if (this.a.d.getPaddingLeft() == 0) goto L20;
        L22:
            h3 r13 = this.b.t;
            if (r13 == null) goto L31;
            com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.getClass();
            pg.c r14 = r13.M();
            if (r14 == null) goto L27;
            boolean r15 = com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.a(r14);
        L28:
            if (r15 != true) goto L32;
            a1.k(this.a.c, UtilityKotlinExtentionsKt.i(30));
            this.a.c.setPadding(UtilityKotlinExtentionsKt.i(8), 0, UtilityKotlinExtentionsKt.i(8), 0);
            this.a.d.setGravity(16);
            return;
        L32:
            return;
        L27:
            r15 = false;
            goto L28
        L31:
            return;
        L20:
            if (r11.left >= UtilityKotlinExtentionsKt.i(4)) goto L22;
            this.a.c.setPadding(UtilityKotlinExtentionsKt.i(4), r11.top, r11.right, r11.bottom);
            goto L22
        }

        public d(WindScreenCombinedAnimTrayView r1, k32.d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public WindScreenCombinedAnimTrayView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public WindScreenCombinedAnimTrayView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public com.bytedance.android.live.base.model.message.e getComboInfo() {
        return this.d.getComboInfo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.h.clear();
    }

    public final c getConfigSceneInterceptor() {
        return this.f;
    }

    public final o getOnSchemaHandleListener() {
        return this.g;
    }

    private final void setCombineText(k32.d r5) {
        h3 r0 = r5.t;
        if (r0 == null) goto L30;
        com.bytedance.android.live.base.model.message.d r1 = r0.I0();
        if (r1 == null) goto L31;
        final com.bytedance.android.livesdk.interactivity.common.enterAnim.c r2 = this.a;
        if (r2 == null) goto L10;
        this.d.setOnImageRenderEndCallback(new WindScreenCombinedAnimTrayView$setCombineText$1$1(r2));
    L10:
        h3 r3 = r5.t;
        if (r3 == null) goto L19;
        pg.c r4 = r3.M();
        if (r4 == null) goto L19;
        com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.getClass();
        if (com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.a(r4) != true) goto L19;
        ViewGroup.LayoutParams r6 = this.d.getLayoutParams();
        if (r6 == null) goto L19;
        r6.height = s1.f(25.0f);
        this.d.setLayoutParams(r6);
    L19:
        this.d.setOnSchemaHandleListener(this.g);
        CombinedTextRenderView r7 = this.d;
        c r8 = this.f;
        if (r8 == null) goto L27;
        CombinedTextRenderView.a r9 = this.i;
        h3 r10 = r5.t;
        if (r10 == null) goto L24;
        pg.c r11 = r10.M();
    L25:
        CombinedTextRenderView.a r13 = r8.a(r9, r11);
        if (r13 == null) goto L27;
    L28:
        r7.a(r1, r13);
        return;
    L24:
        r11 = null;
    L27:
        r13 = this.i;
        goto L28
    L31:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void R5(k32.d r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        setCombineText(r1);
        setBackground(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final boolean T5(com.bytedance.android.livesdk.interactivity.enteranim.utils.e r8) {
        Intrinsics.checkNotNullParameter(r8, "onComboListener");
        CombinedTextRenderView r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "onComboListener");
        Iterator r0 = ((ArrayList) r1.b).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L32;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Pair r5 = (Pair) r3;
        com.bytedance.android.live.base.model.message.f r6 = (com.bytedance.android.live.base.model.message.f) r5.getFirst();
        if (r6 == null) goto L15;
        o6 r7 = r6.g();
        if (r7 == null) goto L15;
        a5 r9 = r7.a();
        if (r9 == null) goto L15;
        List r10 = r9.getPieces();
    L16:
        com.bytedance.android.live.base.model.message.f r11 = (com.bytedance.android.live.base.model.message.f) r5.getFirst();
        if (r11 == null) goto L24;
        if (r11.e() != true) goto L24;
        if (r10 == null) goto L24;
        if (r10.size() != 1) goto L24;
        ((m) r5.getSecond()).f((com.bytedance.android.live.base.model.message.f) r5.getFirst(), r8);
        return true;
    L24:
        r2 = r4;
    L15:
        r10 = null;
        goto L16
    L32:
        return false;
    }

    public final void setBackground(k32.d r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        h3 r0 = r4.t;
        if (r0 == null) goto L7;
        pg.a r1 = r0.getBackground();
        if (r1 == null) goto L7;
        py.k r2 = r1.a();
    L8:
        if (r2 == null) goto L11;
        this.c.setBackground(null);
        int r3 = a3.d;
        a3.a.a(this.c, r2, new d(this, r4), 0.0f);
        return;
    L11:
        Drawable r5 = this.c.getBackground();
        h3 r6 = r4.t;
        if (r6 == null) goto L23;
        pg.a r7 = r6.getBackground();
        if (r7 == null) goto L24;
        String r8 = r7.b();
        if (r8 == null) goto L25;
        if (r5 == null) goto L22;
        ((GradientDrawable) r5).setColor(com.bytedance.android.live.schema.helper.g.b(r8, ColorProtector.parseColor("#99FAA14F")));
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void setConfigSceneInterceptor(c r1) {
        this.f = r1;
    }

    public final void setOnSchemaHandleListener(o r1) {
        this.g = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public void setTextSize(float r5) {
        CombinedTextRenderView.a r0 = this.i;
        DisplayTextView.a r1 = new DisplayTextView.a(r5, false, false, 2046);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void S5(com.bytedance.android.live.base.model.message.d r9, com.bytedance.android.livesdk.interactivity.enteranim.utils.d r10) {
        Intrinsics.checkNotNullParameter(r9, "nextCombo");
        Intrinsics.checkNotNullParameter(r10, "onComboListener");
        CombinedTextRenderView r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "combinedText");
        Intrinsics.checkNotNullParameter(r10, "onComboListener");
        com.bytedance.android.live.base.model.message.d r0 = r1.a;
        if (r0 == null) goto L76;
        com.bytedance.android.live.base.model.message.e r2 = r0.a();
        if (r2 == null) goto L77;
        com.bytedance.android.live.base.model.message.e r3 = r9.a();
        if (r3 != null) goto L12;
        return;
    L12:
        if ((!Intrinsics.areEqual(r3.b(), r2.b())) == false) goto L15;
        r10.b();
        return;
    L15:
        if (r3.a() > r2.a()) goto L17;
        r10.b();
        return;
    L17:
        List r4 = r9.b();
        if (r4 != null) goto L21;
        return;
    L21:
        if (((ArrayList) r1.b).size() == r4.size()) goto L23;
        r10.b();
        return;
    L23:
        r1.a = r9;
        List r11 = r4;
        if ((r11 instanceof Collection) == true) goto L26;
    L28:
        Iterator r13 = r11.iterator();
    L30:
        if (r13.hasNext() == false) goto L34;
        if (((com.bytedance.android.live.base.model.message.f) r13.next()).i() == false) goto L30;
        boolean r14 = false;
    L35:
        if (r14 == false) goto L37;
        r10.b();
        return;
    L37:
        Iterator r15 = ((ArrayList) r1.b).iterator();
        int r5 = 0;
    L39:
        if (r15.hasNext() == false) goto L80;
        Object r6 = r15.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        Pair r8 = (Pair) r6;
        if (r5 >= r4.size()) goto L63;
        com.bytedance.android.live.base.model.message.f r16 = (com.bytedance.android.live.base.model.message.f) ListProtector.get(r4, r5);
        com.bytedance.android.live.base.model.message.f r17 = (com.bytedance.android.live.base.model.message.f) r8.getFirst();
        if (r16 != null) goto L49;
        r17.getClass();
    L58:
        boolean r18 = false;
    L59:
        if (r18 == false) goto L63;
        if (r16.i() == false) goto L63;
        ((m) r8.getSecond()).n(r16, new CombinedTextRenderView.b(r10), false);
        goto L63
    L49:
        if (r17.k() == false) goto L54;
        if (r16.k() == false) goto L54;
    L57:
        r18 = true;
    L54:
        if (r17.j() == false) goto L58;
        if (r16.j() == false) goto L58;
    L63:
        r5 = r7;
        goto L39
    L80:
        return;
    L34:
        r14 = true;
        goto L35
    L26:
        if (r11.isEmpty() == false) goto L28;
    L77:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void U5(int r3, int r4) {
        CombinedTextRenderView.a r0 = this.i;
        DisplayImageListView.a r1 = new DisplayImageListView.a(r3, r4);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindScreenCombinedAnimTrayView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.h = new CompositeDisposable();
        this.i = new CombinedTextRenderView.a(new DisplayTextView.a(UtilityKotlinExtentionsKt.m(14), true, false, 1918), new DisplayImageListView.a(UtilityKotlinExtentionsKt.i(18), UtilityKotlinExtentionsKt.i(18)));
        ViewGroup.inflate(r5, 2131568046, this);
        this.b = (ViewGroup) findViewById(2131362942);
        this.c = (ViewGroup) findViewById(2131367225);
        this.d = (CombinedTextRenderView) findViewById(2131367224);
        this.e = (RadiusHSImageView) findViewById(2131363809);
        setMaxWidth(s1.y() - s1.f(12.0f));
    }

    public /* synthetic */ WindScreenCombinedAnimTrayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
