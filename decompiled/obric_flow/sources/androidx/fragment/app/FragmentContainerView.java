package androidx.fragment.app;

import ai.j0;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001<B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\"\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0014J \u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0017\u0010(\u001a\u0002H)\"\n\b\u0000\u0010)*\u0004\u0018\u00010*¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017J\b\u0010-\u001a\u00020\u0016H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0018\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016J\u0018\u00104\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0001J\u0012\u00106\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "applyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", "disappearingFragmentChildren", "", "Landroid/view/View;", "drawDisappearingViewsFirst", "", "transitioningFragmentViews", "addDisappearingFragmentView", "", "v", "addView", "child", "index", LynxResourceModule.PARAMS_KEY, "Landroid/view/ViewGroup$LayoutParams;", "dispatchApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawChild", "drawingTime", "", "endViewTransition", "view", "getFragment", "F", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "onApplyWindowInsets", "removeAllViewsInLayout", "removeView", "removeViewAt", "removeViewInLayout", "removeViews", "start", "count", "removeViewsInLayout", "setDrawDisappearingViewsLast", "setLayoutTransition", "transition", "Landroid/animation/LayoutTransition;", "setOnApplyWindowInsetsListener", "listener", "startViewTransition", "Api20Impl", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFragmentContainerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentContainerView.kt\nandroidx/fragment/app/FragmentContainerView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,353:1\n55#2,6:354\n55#2,6:360\n1855#3,2:366\n*S KotlinDebug\n*F\n+ 1 FragmentContainerView.kt\nandroidx/fragment/app/FragmentContainerView\n*L\n113#1:354,6\n135#1:360,6\n226#1:366,2\n*E\n"})
public final class FragmentContainerView extends FrameLayout {
    private View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    private final List<View> disappearingFragmentChildren;
    private boolean drawDisappearingViewsFirst;
    private final List<View> transitioningFragmentViews;

    @RequiresApi(20)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Landroidx/fragment/app/FragmentContainerView$Api20Impl;", "", "()V", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "onApplyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", "v", "Landroid/view/View;", "insets", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api20Impl {
        public static final Api20Impl INSTANCE = null;

        static {
            INSTANCE = new Api20Impl();
        }

        private Api20Impl() {
        }

        public final WindowInsets onApplyWindowInsets(View.OnApplyWindowInsetsListener r5, View r10, WindowInsets r11) {
            Intrinsics.checkNotNullParameter(r5, "onApplyWindowInsetsListener");
            Intrinsics.checkNotNullParameter(r10, "v");
            Intrinsics.checkNotNullParameter(r11, "insets");
            return r5.onApplyWindowInsets(r10, r11);
        }
    }

    @JvmOverloads
    public FragmentContainerView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r5 = 0;
        this(r10, r11, r5, 4, null);
    }

    private final void addDisappearingFragmentView(View r5) {
        if (this.transitioningFragmentViews.contains(r5) == false) goto L6;
        this.disappearingFragmentChildren.add(r5);
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r5, "child");
        if (FragmentManager.getViewFragment(r5) == null) goto L7;
        super.addView(r5, r10, r11);
        return;
    L7:
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + r5 + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(20)
    public WindowInsets dispatchApplyWindowInsets(WindowInsets r5) {
        Intrinsics.checkNotNullParameter(r5, "insets");
        WindowInsetsCompat r10 = WindowInsetsCompat.toWindowInsetsCompat(r5);
        View.OnApplyWindowInsetsListener r11 = this.applyWindowInsetsListener;
        if (r11 == null) goto L5;
        Api20Impl r12 = Api20Impl.INSTANCE;
        Intrinsics.checkNotNull(r11);
        WindowInsetsCompat r13 = WindowInsetsCompat.toWindowInsetsCompat(r12.onApplyWindowInsets(r11, this, r5));
    L7:
        if (r13.isConsumed() == true) goto L11;
        int r14 = getChildCount();
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L11;
        ViewCompat.dispatchApplyWindowInsets(getChildAt(r15), r13);
        r15 = r15 + 1;
    L11:
        return r5;
    L5:
        r13 = ViewCompat.onApplyWindowInsets(this, r10);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.drawDisappearingViewsFirst == false) goto L8;
        Iterator<T> r10 = this.disappearingFragmentChildren.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        super.drawChild(r5, (View) r10.next(), getDrawingTime());
    L8:
        super.dispatchDraw(r5);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r5, View r10, long r11) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Intrinsics.checkNotNullParameter(r10, "child");
        if (this.drawDisappearingViewsFirst == false) goto L11;
        if (this.disappearingFragmentChildren.isEmpty() == true) goto L11;
        if (this.disappearingFragmentChildren.contains(r10) == false) goto L11;
        return false;
    L11:
        return super.drawChild(r5, r10, r11);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.transitioningFragmentViews.remove(r5);
        if (this.disappearingFragmentChildren.remove(r5) == false) goto L5;
        this.drawDisappearingViewsFirst = true;
    L5:
        super.endViewTransition(r5);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.findFragmentManager(this).findFragmentById(getId());
    }

    @Override // android.view.View
    @RequiresApi(20)
    public WindowInsets onApplyWindowInsets(WindowInsets r5) {
        Intrinsics.checkNotNullParameter(r5, "insets");
        return r5;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int r5 = getChildCount();
    L3:
        r5 = r5 - 1;
        if ((-1) >= r5) goto L6;
        addDisappearingFragmentView(getChildAt(r5));
        goto L3
    L6:
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        addDisappearingFragmentView(r5);
        super.removeView(r5);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r5) {
        addDisappearingFragmentView(getChildAt(r5));
        super.removeViewAt(r5);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        addDisappearingFragmentView(r5);
        super.removeViewInLayout(r5);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int r5, int r10) {
        int r11 = r5 + r10;
        int r12 = r5;
    L3:
        if (r12 >= r11) goto L5;
        addDisappearingFragmentView(getChildAt(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        super.removeViews(r5, r10);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int r5, int r10) {
        int r11 = r5 + r10;
        int r12 = r5;
    L3:
        if (r12 >= r11) goto L5;
        addDisappearingFragmentView(getChildAt(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        super.removeViewsInLayout(r5, r10);
    }

    @JvmName(name = "setDrawDisappearingViewsLast")
    public final void setDrawDisappearingViewsLast(boolean r5) {
        this.drawDisappearingViewsFirst = r5;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition r5) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.applyWindowInsetsListener = r5;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (r5.getParent() != this) goto L5;
        this.transitioningFragmentViews.add(r5);
    L5:
        super.startViewTransition(r5);
    }

    public FragmentContainerView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
    }

    public /* synthetic */ FragmentContainerView(Context r5, AttributeSet r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = 0;
    L5:
        this(r5, r10, r11);
    }

    @JvmOverloads
    public FragmentContainerView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        if (r10 == null) goto L15;
        String r12 = r10.getClassAttribute();
        TypedArray r13 = r5.obtainStyledAttributes(r10, R.styleable.FragmentContainerView, 0, 0);
        if (r12 != null) goto L7;
        r12 = r13.getString(R.styleable.FragmentContainerView_android_name);
        String r14 = "android:name";
    L8:
        r13.recycle();
        if (r12 != null) goto L11;
        return;
    L11:
        if (isInEditMode() == false) goto L14;
        return;
    L14:
        throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + r14 + "=\"" + r12 + Typography.quote);
    L7:
        r14 = "class";
        goto L8
    }

    public FragmentContainerView(Context r10, AttributeSet r11, FragmentManager r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        Intrinsics.checkNotNullParameter(r12, "fm");
        super(r10, r11);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String r5 = r11.getClassAttribute();
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.FragmentContainerView, 0, 0);
        if (r5 != null) goto L5;
        r5 = r13.getString(R.styleable.FragmentContainerView_android_name);
    L5:
        String r14 = r13.getString(R.styleable.FragmentContainerView_android_tag);
        r13.recycle();
        int r15 = getId();
        Fragment r16 = r12.findFragmentById(r15);
        if (r5 == null) goto L16;
        if (r16 != null) goto L16;
        if (r15 != (-1)) goto L15;
        if (r14 == null) goto L12;
        String r17 = " with tag ".concat(r14);
    L14:
        throw new IllegalStateException(j0.k("FragmentContainerView must have an android:id to add Fragment ", r5, r17));
    L12:
        r17 = "";
        goto L14
    L15:
        Fragment r18 = r12.getFragmentFactory().instantiate(r10.getClassLoader(), r5);
        r18.mFragmentId = r15;
        r18.mContainerId = r15;
        r18.mTag = r14;
        r18.mFragmentManager = r12;
        r18.mHost = r12.getHost();
        r18.onInflate(r10, r11, null);
        r12.beginTransaction().setReorderingAllowed(true).add(this, r18, r14).commitNowAllowingStateLoss();
    L16:
        r12.onContainerAvailable(this);
    }
}
