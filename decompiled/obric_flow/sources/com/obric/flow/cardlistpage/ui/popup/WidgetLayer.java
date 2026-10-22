package com.obric.flow.cardlistpage.ui.popup;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import jq.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u00013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010&\u001a\u00020!8\u0006X\u0086D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010)\u001a\u00020!8\u0006X\u0086D¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R*\u00102\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/popup/WidgetLayer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/animation/AnimatorSet;", "getOpenAnimation", "()Landroid/animation/AnimatorSet;", "getCloseAnimation", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "b", "Landroid/content/Context;", "getRealDensityContext", "()Landroid/content/Context;", "setRealDensityContext", "(Landroid/content/Context;)V", "realDensityContext", "Ljava/lang/Runnable;", "h", "Ljava/lang/Runnable;", "getPopupAction", "()Ljava/lang/Runnable;", "setPopupAction", "(Ljava/lang/Runnable;)V", "popupAction", "", "i", "J", "getANIMATION_DURATION_OPEN", "()J", "ANIMATION_DURATION_OPEN", "j", "getANIMATION_DURATION_CLOSE", "ANIMATION_DURATION_CLOSE", "Lkotlin/Function0;", "", "k", "Lkotlin/jvm/functions/Function0;", "getOnDismissEditPopup", "()Lkotlin/jvm/functions/Function0;", "setOnDismissEditPopup", "(Lkotlin/jvm/functions/Function0;)V", "onDismissEditPopup", "com/obric/flow/cardlistpage/ui/popup/d", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetLayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetLayer.kt\ncom/obric/flow/cardlistpage/ui/popup/WidgetLayer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,260:1\n1#2:261\n*E\n"})
public final class WidgetLayer extends FrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f11798l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f11800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f11801c;
    public View d;
    public ScrimView e;
    public WidgetBox f;
    public jq.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f11802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f11803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f11804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0 f11805k;

    public WidgetLayer(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        super(r5, r10);
        this.f11799a = "WidgetLayer";
        this.f11803i = 200;
        this.f11804j = 200;
    }

    public final void a(WidgetBox r10) {
        if (r10.getShadowView() != null) goto L6;
        Intrinsics.checkNotNullParameter(this, "viewParent");
        com.obric.flow.cardlistpage.ui.view.a r5 = new com.obric.flow.cardlistpage.ui.view.a(r10.getContext(), r10.getHeight() / r10.getWidth());
        View r11 = r10.getChildAt(0);
        com.lynx.tasm.utils.d.w(r11);
        r10.removeAllViews();
        r10.addView(r5);
        r10.setVisibility(0);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(r10.getWidth(), r10.getHeight());
        r12.gravity = 8388659;
        com.obric.flow.cardlistpage.ui.view.a r13 = new com.obric.flow.cardlistpage.ui.view.a(r10.getContext(), r10.getHeight() / r10.getWidth());
        r13.addView(r11);
        r13.setX(r10.getX());
        r13.setY(r10.getY());
        r13.setElevation(com.lynx.tasm.utils.a.u(50));
        r13.setScaleX(r10.getScaleX());
        r13.setScaleY(r10.getScaleY());
        addView(r13, r12);
        r10.f11831a = r13;
        return;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final void b(boolean r10) {
        if (this.f11802h == null) goto L14;
        WidgetBox r5 = this.f;
        if (r5 == null) goto L7;
        int r11 = WidgetBox.f11830j;
        r5.d(false, true);
    L7:
        ScrimView r12 = this.e;
        if (r12 == null) goto L11;
        r12.setVisibility(8);
    L11:
        Runnable r13 = this.f11802h;
        if (r13 == null) goto L14;
        removeCallbacks(r13);
        this.f11802h = null;
    L14:
        b r14 = this.f11801c;
        if (r14 != null) goto L17;
        d();
        return;
    L17:
        if (r14.f11810b != true) goto L33;
        WidgetBox r15 = this.f;
        if (r15 == null) goto L21;
        r15.d(false, r10);
    L21:
        b r16 = this.f11801c;
        if (r16 == null) goto L36;
        Function0<Unit> r17 = new WidgetLayer$dismissPopupInternal$1(this);
        Intrinsics.checkNotNullParameter(r17, "callback");
        r16.f11810b = false;
        AnimatorSet r18 = r16.e;
        if (r18 == null) goto L26;
        r18.cancel();
    L26:
        OPopoverLayout r19 = r16.f11809a;
        if (r10 == true) goto L29;
        r17.invoke();
        r16.f11811c.invoke();
        r16.e = null;
        com.lynx.tasm.utils.d.w(r19);
    L29:
        AnimatorSet r20 = h.a(r19, false, r16.a(), r16.f11813i, r16.f11814j);
        AnimatorSet r21 = r16.f;
        if (r21 == null) goto L32;
        r20.playTogether(new Animator[]{r21});
    L32:
        r20.addListener(new a(r16, r20, 0));
        r20.addListener(new com.bytedance.ies.bullet.service.popup.ui.b(r17, r16));
        r20.start();
        return;
    L36:
        return;
    L33:
        this.f11801c = null;
        d();
    }

    public final boolean c() {
        if (this.f11801c == null) goto L5;
    L8:
        return true;
    L5:
        if (this.f11802h != null) goto L8;
        return false;
    }

    public final void d() {
        WidgetBox r5 = this.f;
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.f11802h == null) goto L8;
        return;
    L8:
        if (this.f11801c == null) goto L10;
        return;
    L10:
        if ((r5.getStatus() & 2) != 0) goto L28;
        WidgetBox r10 = this.f;
        if (r10 != null) goto L15;
    L24:
        this.f = null;
        return;
    L15:
        if (r10.getShadowView() == null) goto L24;
        r10.removeAllViews();
        View r11 = r10.f11831a;
        if (r11 != null) goto L19;
    L23:
        r10.setVisibility(0);
        r10.f11831a = null;
        goto L24
    L19:
        if ((r11 instanceof com.obric.flow.cardlistpage.ui.view.a) == false) goto L23;
        com.lynx.tasm.utils.d.w(r11);
        View r12 = ((com.obric.flow.cardlistpage.ui.view.a) r11).getChildAt(0);
        if (r12 == null) goto L23;
        Intrinsics.checkNotNull(r12);
        com.lynx.tasm.utils.d.w(r12);
        r12.setTranslationX(0.0f);
        r12.setTranslationY(0.0f);
        r12.setScaleX(1.0f);
        r12.setScaleY(1.0f);
        r10.addView(r12);
        goto L23
    }

    public final long getANIMATION_DURATION_CLOSE() {
        return this.f11804j;
    }

    public final long getANIMATION_DURATION_OPEN() {
        return this.f11803i;
    }

    public final AnimatorSet getCloseAnimation() {
        jq.b r5 = this.g;
        if (r5 != null) goto L7;
        return null;
    L7:
        return jq.b.a(r5, 1.0f, 0.0f, this.f11804j);
    }

    public final Function0<Unit> getOnDismissEditPopup() {
        return this.f11805k;
    }

    public final AnimatorSet getOpenAnimation() {
        jq.b r5 = this.g;
        if (r5 != null) goto L7;
        return null;
    L7:
        return jq.b.a(r5, 0.0f, 1.0f, this.f11803i);
    }

    public final Runnable getPopupAction() {
        return this.f11802h;
    }

    public final Context getRealDensityContext() {
        return this.f11800b;
    }

    public final String getTAG() {
        return this.f11799a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable r5 = this.f11802h;
        if (r5 == null) goto L5;
        removeCallbacks(r5);
        this.f11802h = null;
    L5:
        ScrimView r10 = (ScrimView) findViewById(R$id.scrim_view);
        this.e = r10;
        if (r10 == null) goto L8;
        r10.setOnClickListener(new ar.a(this, 11));
    L8:
        b(true);
        this.d = findViewById(R$id.container_view);
        ScrimView r11 = this.e;
        Intrinsics.checkNotNull(r11);
        this.g = new jq.b(r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.f11801c == null) goto L7;
        Function0 r5 = this.f11805k;
        if (r5 == null) goto L7;
        r5.invoke();
    L7:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r14 = this.f11799a;
        Intrinsics.checkNotNullParameter(r14, "tag");
        Intrinsics.checkNotNullParameter("onLayout err", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L10;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w(r14, "onLayout err", e);
        return;
    L10:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void setOnDismissEditPopup(Function0<Unit> r5) {
        this.f11805k = r5;
    }

    public final void setPopupAction(Runnable r5) {
        this.f11802h = r5;
    }

    public final void setRealDensityContext(Context r5) {
        this.f11800b = r5;
    }
}
