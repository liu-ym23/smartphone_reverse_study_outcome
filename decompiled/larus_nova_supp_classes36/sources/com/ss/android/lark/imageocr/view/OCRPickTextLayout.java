package com.ss.android.lark.imageocr.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.imageocr.ImageOCRKit;
import com.ss.android.lark.imageocr.select.SelectTextView;
import com.ss.android.lark.imageocr.select.e;
import com.ss.android.lark.imageocr.select.f;
import com.ss.android.lark.imageocr.select.g;
import com.ss.android.lark.imageocr.select.h;
import com.ss.android.lark.imageocr.select.i;
import com.ss.android.lark.imageocr.select.j;
import com.ss.android.lark.imageocr.select.k;
import com.ss.android.lark.imageocr.select.l;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001_B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0014J\u0010\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020\u000bH\u0002J\u000e\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u000209J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\u001a\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010N\u001a\u00020J2\u0006\u0010O\u001a\u000204H\u0002J\u0010\u0010P\u001a\u00020J2\u0006\u0010O\u001a\u000204H\u0002J\u0010\u0010Q\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010R\u001a\u000209H\u0002J\b\u0010S\u001a\u000209H\u0002J\b\u0010T\u001a\u000209H\u0002J2\u0010U\u001a\u0002092\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020Y2\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010[H\u0002J\u0010\u0010\\\u001a\u0002092\u0006\u0010]\u001a\u00020\u000bH\u0002J\b\u0010^\u001a\u000209H\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0013\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0013\u001a\u0004\b0\u00101R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/ss/android/lark/imageocr/view/OCRPickTextLayout;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/imageocr/select/ISelectActionListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "defaultTopMargin", "getDefaultTopMargin", "()I", "defaultTopMargin$delegate", "Lkotlin/Lazy;", "windowVisibleRect", "Landroid/graphics/Rect;", "cursorVisibleRect", "closeView", "Landroid/view/View;", "getCloseView", "()Landroid/view/View;", "closeView$delegate", "contentLayout", "getContentLayout", "contentLayout$delegate", "contentLayoutLP", "Landroid/widget/FrameLayout$LayoutParams;", "getContentLayoutLP", "()Landroid/widget/FrameLayout$LayoutParams;", "contentLayoutLP$delegate", "contentScrollView", "Landroid/widget/ScrollView;", "getContentScrollView", "()Landroid/widget/ScrollView;", "contentScrollView$delegate", "contentView", "Lcom/ss/android/lark/imageocr/view/OCRPickTextView;", "getContentView", "()Lcom/ss/android/lark/imageocr/view/OCRPickTextView;", "contentView$delegate", "textSelectHelper", "Lcom/ss/android/lark/imageocr/select/TextViewSelectHelper;", "getTextSelectHelper", "()Lcom/ss/android/lark/imageocr/select/TextViewSelectHelper;", "textSelectHelper$delegate", "downY", "", "dragLastY", "animator", "Landroid/animation/ValueAnimator;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "updateVisibleRect", "maxHeight", "showPickDialog", "txt", "", "hidePickDialog", "getSelectActionList", "", "Lcom/ss/android/lark/imageocr/select/SelectAction;", "onSelectActionClick", "clickId", "selectedTxt", "", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "isCanDragUp", "currentY", "isCanDragDown", "onTouchEvent", "showAnim", "hideAnim", "backAnim", "animTopMargin", "start", "end", "duration", "", "finish", "Lkotlin/Function0;", "refreshTopMargin", "topMargin", "onDetachedFromWindow", "Companion", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OCRPickTextLayout extends FrameLayout implements com.ss.android.lark.imageocr.select.a {
    public static final /* synthetic */ int m = 0;
    public final Lazy a;
    public final Rect b;
    public final Rect c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public float j;
    public float k;
    public ValueAnimator l;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ OCRPickTextLayout a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Function0<Unit> d;

        public b(OCRPickTextLayout r1, int r2, int r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            Object r6 = r5.getAnimatedValue();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Float");
            float r7 = ((Float) r6).floatValue();
            OCRPickTextLayout r0 = this.a;
            int r1 = this.b;
            int r2 = (int) (r1 + ((this.c - r1) * r7));
            int r3 = OCRPickTextLayout.m;
            r0.g(r2);
            if (r7 != 1.0f) goto L5;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L11;
            Function0<Unit> r9 = this.d;
            if (r9 == null) goto L12;
            r9.invoke();
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r8 = false;
            goto L6
        }
    }

    static {
    }

    private final View getCloseView() {
        return (View) this.d.getValue();
    }

    private final View getContentLayout() {
        return (View) this.e.getValue();
    }

    private final FrameLayout.LayoutParams getContentLayoutLP() {
        return (FrameLayout.LayoutParams) this.f.getValue();
    }

    private final ScrollView getContentScrollView() {
        return (ScrollView) this.g.getValue();
    }

    private final OCRPickTextView getContentView() {
        return (OCRPickTextView) this.h.getValue();
    }

    private final int getDefaultTopMargin() {
        return ((Number) this.a.getValue()).intValue();
    }

    private final List<com.ss.android.lark.imageocr.select.b> getSelectActionList() {
        ArrayList r0 = new ArrayList();
        r0.add(new com.ss.android.lark.imageocr.select.b(1, 2131891163, this));
        r0.add(new com.ss.android.lark.imageocr.select.b(2, 2131891172, this));
        return r0;
    }

    private final e getTextSelectHelper() {
        return (e) this.i.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Log.i("OCRPickTextView", "onDetachedFromWindow, cancel animation");
        ValueAnimator r0 = this.l;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
    L5:
        ValueAnimator r1 = this.l;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.l = null;
        super.onDetachedFromWindow();
    }

    public final void f() {
        e(getContentLayoutLP().topMargin, UIUtils.getScreenHeight(getContext()), 350, new OCRPickTextLayout$hideAnim$1(this));
    }

    public OCRPickTextLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ View b(OCRPickTextLayout r0) {
        return r0.getContentLayout();
    }

    public static final /* synthetic */ OCRPickTextView c(OCRPickTextLayout r0) {
        return r0.getContentView();
    }

    public static final /* synthetic */ List d(OCRPickTextLayout r0) {
        return r0.getSelectActionList();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "ev");
        float r0 = r12.getY();
        View r1 = getCloseView();
        float r2 = r12.getX();
        float r3 = r12.getY();
        int r4 = com.ss.android.lark.imageocr.utils.b.a;
        Intrinsics.checkNotNullParameter(r1, "view");
        int[] r5 = new int[2];
        r1.getLocationInWindow(r5);
        int r6 = r5[0];
        if (new RectF(r6, r5[1], r6 + r1.getWidth(), r5[1] + r1.getHeight()).contains(r2, r3) == true) goto L7;
        if (r0 <= getDefaultTopMargin()) goto L7;
    L11:
        return super.dispatchTouchEvent(r12);
    L7:
        if (r12.getAction() != 0) goto L11;
        f();
        return true;
    }

    public final void g(int r2) {
        if (r2 >= getDefaultTopMargin()) goto L6;
        r2 = getDefaultTopMargin();
    L6:
        if (getContentLayoutLP().topMargin == r2) goto L9;
        getContentLayoutLP().topMargin = r2;
        getContentLayout().setLayoutParams(getContentLayoutLP());
        getTextSelectHelper().b();
        return;
    }

    public final void h(CharSequence r9) {
        Intrinsics.checkNotNullParameter(r9, "txt");
        int r0 = com.ss.android.lark.imageocr.utils.a.a;
        Statistics.sendEvent("public_identity_select_accurate_character_view");
        setVisibility(0);
        e(UIUtils.getScreenHeight(getContext()), getDefaultTopMargin(), 350, null);
        getContentScrollView().scrollTo(0, 0);
        getContentView().setText(r9);
    }

    public final void i(int r7) {
        int r0 = getDefaultTopMargin() + UIUtils.dp2px(getContext(), 56.0f);
        int r8 = r7 - UIUtils.getNavigationBarHeight(getContext());
        int r1 = r8 - UIUtils.dp2px(getContext(), 41.0f);
        this.b.set(Target.SIZE_ORIGINAL, getDefaultTopMargin(), Integer.MAX_VALUE, r1);
        this.c.set(Target.SIZE_ORIGINAL, r0, Integer.MAX_VALUE, r8);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        float r0 = r7.getY();
        if (r7.getAction() != 0) goto L6;
        this.j = r0;
    L22:
        return super.onInterceptTouchEvent(r7);
    L6:
        if (r7.getAction() != 2) goto L22;
        boolean r2 = false;
        if ((this.j - r0) > 20.0f) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L15;
    L20:
        return true;
    L15:
        if ((r0 - this.j) > 20.0f) goto L17;
    L19:
        if (r2 == false) goto L22;
    L17:
        if (getContentScrollView().getScrollY() > 0) goto L19;
        r2 = true;
        goto L19
    L10:
        if (getContentScrollView().getHeight() <= getContentView().getHeight()) goto L12;
        r1 = true;
        goto L13
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "ev");
        float r0 = r13.getY();
        int r1 = getContentLayoutLP().topMargin;
        int r14 = r13.getAction();
        boolean r2 = false;
        if (r14 == 1) goto L15;
        if (r14 == 2) goto L8;
        if (r14 == 3) goto L15;
    L19:
        return true;
    L8:
        float r15 = this.k;
        if (r15 != 0.0f) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L13;
        g(r1 + ((int) (r0 - r15)));
    L13:
        this.k = r0;
    L15:
        if (r1 <= (getDefaultTopMargin() * 3)) goto L17;
        f();
    L18:
        this.k = 0.0f;
        goto L19
    L17:
        setVisibility(0);
        e(getContentLayoutLP().topMargin, getDefaultTopMargin(), 150, null);
        goto L18
    }

    public OCRPickTextLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // com.ss.android.lark.imageocr.select.a
    public final void a(int r3, String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        Log.e("OCRPickTextView", "selectedTxt is null");
        return;
    L12:
        if (r3 != 1) goto L14;
        com.ss.android.lark.imageocr.utils.a.b("copy", "none");
        if (com.ss.android.lark.imageocr.utils.b.b(getContext(), r4) == false) goto L22;
        UDToast.show(getContext(), 2131891160);
        return;
    L22:
        return;
    L14:
        if (r3 != 2) goto L23;
        com.ss.android.lark.imageocr.utils.a.b("forward", "public_multi_select_share_view");
        ImageOCRKit.a().c();
        return;
    L23:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (ImageWidgetFG.a() == false) goto L8;
        i(getMeasuredHeight());
        e r4 = getTextSelectHelper();
        Rect r5 = this.b;
        Rect r0 = this.c;
        r4.l = r5;
        r4.m = r0;
        e r6 = getTextSelectHelper();
        int r7 = getMeasuredWidth();
        e.d r8 = r6.c;
        if (r8 == null) goto L9;
        r8.e = r7;
        return;
    L9:
        return;
    }

    public OCRPickTextLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Context r5 = getContext();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.app.Activity");
        Activity r6 = (Activity) r5;
        this.a = LazyKt.lazy(new OCRPickTextLayout$defaultTopMargin$2(this));
        this.b = new Rect();
        this.c = new Rect();
        this.d = LazyKt.lazy(new OCRPickTextLayout$closeView$2(this));
        this.e = LazyKt.lazy(new OCRPickTextLayout$contentLayout$2(this));
        this.f = LazyKt.lazy(new OCRPickTextLayout$contentLayoutLP$2(this));
        this.g = LazyKt.lazy(new OCRPickTextLayout$contentScrollView$2(this));
        this.h = LazyKt.lazy(new OCRPickTextLayout$contentView$2(this));
        this.i = LazyKt.lazy(new OCRPickTextLayout$textSelectHelper$2(this));
        setClickable(true);
        setVisibility(8);
        setBackgroundColor(UIUtils.getColor(getContext(), 2131106508));
        addView(getContentLayout(), new FrameLayout.LayoutParams(-1, -1));
        e r7 = getTextSelectHelper();
        SelectTextView r8 = r7.f;
        r8.setText(r8.getText(), TextView.BufferType.SPANNABLE);
        r7.f.setOnLongClickListener(new f(r7));
        if (r7.o == false) goto L5;
        r7.f.setOnDoubleTapListener(new g(r7));
    L5:
        r7.f.setOnTouchListener(new h(r7));
        r7.f.setOnClickListener(new i(r7));
        r7.f.addOnAttachStateChangeListener(new j(r7));
        r7.r = new k(r7);
        r7.f.getViewTreeObserver().addOnPreDrawListener(r7.r);
        r7.s = new l(r7);
        r7.f.getViewTreeObserver().addOnScrollChangedListener(r7.s);
    }

    public final void e(int r4, int r5, long r6, Function0<Unit> r8) {
        ValueAnimator r0 = this.l;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L36;
        ValueAnimator r3 = this.l;
        if (r3 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == true) goto L38;
        ValueAnimator r7 = this.l;
        if (r7 == null) goto L20;
        r7.removeAllUpdateListeners();
    L20:
        ValueAnimator r9 = this.l;
        if (r9 == null) goto L23;
        r9.cancel();
    L23:
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.l = r10;
        if (r10 == null) goto L26;
        r10.setDuration(r6);
    L26:
        ValueAnimator r11 = this.l;
        if (r11 == null) goto L29;
        r11.setInterpolator(new DecelerateInterpolator());
    L29:
        ValueAnimator r12 = this.l;
        if (r12 == null) goto L32;
        r12.addUpdateListener(new b(this, r4, r5, r8));
    L32:
        ValueAnimator r13 = this.l;
        if (r13 == null) goto L37;
        r13.start();
        return;
    L37:
        return;
    L38:
        return;
    L12:
        if (r3.isRunning() != true) goto L14;
    L36:
        return;
    L5:
        if (r0.isStarted() != true) goto L7;
        r2 = true;
        goto L8
    }
}
