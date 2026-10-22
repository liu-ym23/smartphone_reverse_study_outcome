package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020*H\u0002J\b\u0010J\u001a\u00020*H\u0002J \u0010K\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\bJ\u000e\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u000203J \u0010N\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\bJ\u0018\u0010O\u001a\u00020\b2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\bH\u0002J\u0018\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u0002012\u0006\u0010R\u001a\u00020\bH\u0002J\u0012\u0010S\u001a\u00020\b2\b\u0010Q\u001a\u0004\u0018\u000101H\u0002J\b\u0010T\u001a\u00020*H\u0014J\u0010\u0010W\u001a\u00020*2\b\b\u0001\u0010X\u001a\u00020\bJ\u0018\u0010W\u001a\u00020*2\u0006\u0010Q\u001a\u0002012\b\u0010Y\u001a\u0004\u0018\u00010ZR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R7\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.Ra\u0010/\u001aI\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\b¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020*00X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R7\u0010:\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020*\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001a\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0014\u0010U\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u000e¨\u0006\\"}, d2 = {"Lcom/ss/android/lark/flow/passport/ui/widget/layout/CommonContainerLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lifecycleRegistry", "Landroidx/lifecycle/Lifecycle;", "getLifecycleRegistry", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "tvTitle", "Landroid/widget/TextView;", "locationOnScreen", "", "paddingUpdateAnimator", "Landroid/animation/ValueAnimator;", "titleBarContainer", "Landroid/widget/LinearLayout;", "getTitleBarContainer", "()Landroid/widget/LinearLayout;", "headerContainer", "getHeaderContainer", "contentContainer", "getContentContainer", "footerContainer", "getFooterContainer", "contentScrollView", "Lcom/ss/android/lark/flow/passport/ui/widget/layout/BlockedNestedScrollView;", "getContentScrollView", "()Lcom/ss/android/lark/flow/passport/ui/widget/layout/BlockedNestedScrollView;", "onContentScrollListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "titleTopToToolBarBottom", "", "getOnContentScrollListener", "()Lkotlin/jvm/functions/Function1;", "setOnContentScrollListener", "(Lkotlin/jvm/functions/Function1;)V", "onImeChangeHandler", "Lkotlin/Function3;", "Landroid/view/View;", "focusedView", "", "imeShowing", "imeHeight", "getOnImeChangeHandler", "()Lkotlin/jvm/functions/Function3;", "setOnImeChangeHandler", "(Lkotlin/jvm/functions/Function3;)V", "onImeChangedEndListener", "getOnImeChangedEndListener", "setOnImeChangedEndListener", "onImeChangedExtraHeightProvider", "Lcom/ss/android/lark/flow/passport/ui/widget/layout/OnImeChangedExtraHeightProvider;", "getOnImeChangedExtraHeightProvider", "()Lcom/ss/android/lark/flow/passport/ui/widget/layout/OnImeChangedExtraHeightProvider;", "setOnImeChangedExtraHeightProvider", "(Lcom/ss/android/lark/flow/passport/ui/widget/layout/OnImeChangedExtraHeightProvider;)V", "intercept", "getIntercept", "()Z", "setIntercept", "(Z)V", "onFirstLayout", "observeScroll", "observeIme", "onImeChanged", "setContentScrollable", "scrollable", "handleImeChanged", "measureAvailablePaddingBottom", "smoothUpdatePaddingBottom", "view", "to", "computeViewBottomInScreen", "onDetachedFromWindow", "lifecycle", "getLifecycle", "inflatePartialLayout", "layoutId", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "flow-passport-ui_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CommonContainerLayout extends ConstraintLayout implements LifecycleOwner {
    public static final /* synthetic */ int o = 0;
    public final Lazy a;
    public final TextView b;
    public final int[] c;
    public ValueAnimator d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final BlockedNestedScrollView i;
    public Function1<? super Integer, Unit> j;
    public Function3<? super View, ? super Boolean, ? super Integer, Unit> k;
    public Function1<? super Boolean, Unit> l;
    public g m;
    public boolean n;

    public static final class a {
    }

    public static final class b implements g {
        public b() {
        }

        @Override // com.ss.android.lark.flow.passport.ui.widget.layout.g
        public final /* synthetic */ void a() {
        }

        @Override // com.ss.android.lark.flow.passport.ui.widget.layout.g
        public final /* synthetic */ void b() {
        }

        @Override // com.ss.android.lark.flow.passport.ui.widget.layout.g
        public final /* synthetic */ void c() {
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ CommonContainerLayout a;

        public c(CommonContainerLayout r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, android.view.ViewGroup, androidx.lifecycle.LifecycleOwner, com.ss.android.lark.flow.passport.ui.widget.layout.CommonContainerLayout, java.lang.Object] */
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            Intrinsics.checkNotNullParameter(r1, "view");
            r1.removeOnLayoutChangeListener(this);
            ?? r10 = this.a;
            int r11 = CommonContainerLayout.o;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r10, "<this>");
            if (r10.isAttachedToWindow() == false) goto L12;
            Context r12 = r10.getContext();
        L7:
            if ((r12 instanceof ContextWrapper) == false) goto L12;
            if ((r12 instanceof Activity) == true) goto L10;
            r12 = ((ContextWrapper) r12).getBaseContext();
            goto L7
        L10:
            Window r13 = ((Activity) r12).getWindow();
        L13:
            if (r13 == null) goto L22;
            Intrinsics.checkNotNullParameter(r13, "<this>");
            int r14 = r13.getAttributes().flags & 67108864;
            View r15 = r13.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L20;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r16 = ThreadMethodProxy.currentThread();
            if (r16 == com.larus.home.impl.utils.c.a) goto L20;
            com.larus.home.impl.utils.c.a(r16, "getDecorView");
        L20:
            if ((r14 | (r15.getSystemUiVisibility() & 1024)) == 0) goto L22;
            boolean r17 = true;
        L23:
            if (r17 == false) goto L25;
            int r18 = uzb.b.f;
            Intrinsics.checkNotNullParameter(r10, "view");
            new uzb.b(r10).e.observe(r10, new com.ss.android.lark.flow.passport.ui.widget.layout.c(r10));
        L25:
            View r19 = r10.findViewById(2131386498);
            Intrinsics.checkNotNull(r19);
            ViewGroup.LayoutParams r20 = r19.getLayoutParams();
            if (r20 == null) goto L30;
            r20.height = r10.e.getHeight();
            r19.setLayoutParams(r20);
            return;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L22:
            r17 = false;
        L12:
            r13 = null;
            goto L13
        }
    }

    static {
    }

    public CommonContainerLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonContainerLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Lifecycle getLifecycleRegistry() {
        return (Lifecycle) this.a.getValue();
    }

    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        qyb.d.c(this, 0);
    }

    public final LinearLayout getContentContainer() {
        return this.g;
    }

    public final BlockedNestedScrollView getContentScrollView() {
        return this.i;
    }

    public final LinearLayout getFooterContainer() {
        return this.h;
    }

    public final LinearLayout getHeaderContainer() {
        return this.f;
    }

    public final boolean getIntercept() {
        return this.n;
    }

    public final Function1<Integer, Unit> getOnContentScrollListener() {
        return this.j;
    }

    public final Function3<View, Boolean, Integer, Unit> getOnImeChangeHandler() {
        return this.k;
    }

    public final Function1<Boolean, Unit> getOnImeChangedEndListener() {
        return this.l;
    }

    public final g getOnImeChangedExtraHeightProvider() {
        return this.m;
    }

    public final LinearLayout getTitleBarContainer() {
        return this.e;
    }

    public final int R5(View r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
    L18:
        return 0;
    L5:
        if (r5.getVisibility() != 8) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L18;
        r5.getLocationOnScreen(this.c);
        ViewGroup.LayoutParams r2 = r5.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L14:
        if (r3 == null) goto L17;
        r0 = r3.bottomMargin;
    L17:
        return (this.c[1] + r5.getHeight()) + r0;
    L13:
        r3 = null;
        goto L14
    L7:
        r1 = false;
        goto L8
    }

    public final void setContentScrollable(boolean r2) {
        if (r2 == false) goto L4;
        this.i.a = true;
        return;
    L4:
        this.i.a = false;
    }

    public final void setIntercept(boolean r1) {
        this.n = r1;
    }

    public final void setOnContentScrollListener(Function1<? super Integer, Unit> r1) {
        this.j = r1;
    }

    public final void setOnImeChangeHandler(Function3<? super View, ? super Boolean, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setOnImeChangedEndListener(Function1<? super Boolean, Unit> r1) {
        this.l = r1;
    }

    public final void setOnImeChangedExtraHeightProvider(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonContainerLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new CommonContainerLayout$lifecycleRegistry$2(this));
        this.c = new int[2];
        this.k = new CommonContainerLayout$onImeChangeHandler$1(this);
        this.m = new b();
        View.inflate(r2, 2131564167, this);
        this.f = (LinearLayout) findViewById(2131386495);
        BlockedNestedScrollView r5 = (BlockedNestedScrollView) findViewById(2131386497);
        this.i = r5;
        this.g = (LinearLayout) findViewById(2131386492);
        this.h = (LinearLayout) findViewById(2131386494);
        this.e = (LinearLayout) findViewById(2131386502);
        this.b = (TextView) findViewById(2131386500);
        r5.setOnScrollChangeListener(new d(this));
        addOnLayoutChangeListener(new c(this));
    }

    public /* synthetic */ CommonContainerLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
