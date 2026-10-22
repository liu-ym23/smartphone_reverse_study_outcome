package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q5.l;
import r5.k;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = 0;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<j> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;

    @NonNull
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;

    @NonNull
    k<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private boolean menuAnimatingWithFabAlignmentMode;

    @Nullable
    private Animator menuAnimator;

    @Nullable
    private Animator modeAnimator;

    @Nullable
    private Integer navigationIconTint;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;

    @MenuRes
    private int pendingMenuResId;
    private int rightInset;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        @NonNull
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        class a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Behavior f3020a;

            a(Behavior r10) {
                this.f3020a = r10;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
                BottomAppBar r19 = (BottomAppBar) Behavior.access$2400(this.f3020a).get();
                if (r19 != null) goto L5;
            L14:
                r10.removeOnLayoutChangeListener(this);
                return;
            L5:
                if ((r10 instanceof FloatingActionButton) == false) goto L14;
                FloatingActionButton r20 = (FloatingActionButton) r10;
                r20.getMeasuredContentRect(Behavior.access$2500(this.f3020a));
                int r21 = Behavior.access$2500(this.f3020a).height();
                r19.setFabDiameter(r21);
                r19.setFabCornerSize(r20.getShapeAppearanceModel().r().a(new RectF(Behavior.access$2500(this.f3020a))));
                CoordinatorLayout.LayoutParams r22 = (CoordinatorLayout.LayoutParams) r10.getLayoutParams();
                if (Behavior.access$2600(this.f3020a) != 0) goto L16;
                ((ViewGroup.MarginLayoutParams) r22).bottomMargin = BottomAppBar.access$2700(r19) + (r19.getResources().getDimensionPixelOffset(q5.d.mtrl_bottomappbar_fab_bottom_margin) - ((r20.getMeasuredHeight() - r21) / 2));
                ((ViewGroup.MarginLayoutParams) r22).leftMargin = BottomAppBar.access$2800(r19);
                ((ViewGroup.MarginLayoutParams) r22).rightMargin = BottomAppBar.access$2900(r19);
                if (ViewUtils.i(r20) == false) goto L12;
                ((ViewGroup.MarginLayoutParams) r22).leftMargin += BottomAppBar.access$3000(r19);
                return;
            L12:
                ((ViewGroup.MarginLayoutParams) r22).rightMargin += BottomAppBar.access$3000(r19);
                return;
            }
        }

        public Behavior() {
            this.fabLayoutListener = new a(this);
            this.fabContentRect = new Rect();
        }

        public Behavior(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.fabLayoutListener = new a(this);
            this.fabContentRect = new Rect();
        }

        static /* synthetic */ WeakReference access$2400(Behavior r10) {
            return r10.viewRef;
        }

        static /* synthetic */ Rect access$2500(Behavior r10) {
            return r10.fabContentRect;
        }

        static /* synthetic */ int access$2600(Behavior r10) {
            return r10.originalBottomMargin;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return onLayoutChild(r10, (BottomAppBar) r11, r12);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull BottomAppBar r11, int r12) {
            this.viewRef = new WeakReference(r11);
            View r13 = BottomAppBar.access$3100(r11);
            if (r13 != null) goto L5;
        L16:
            r10.onLayoutChild(r11, r12);
            return super.onLayoutChild(r10, r11, r12);
        L5:
            if (ViewCompat.isLaidOut(r13) == true) goto L16;
            CoordinatorLayout.LayoutParams r14 = (CoordinatorLayout.LayoutParams) r13.getLayoutParams();
            r14.anchorGravity = 49;
            this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) r14).bottomMargin;
            if ((r13 instanceof FloatingActionButton) == false) goto L15;
            FloatingActionButton r15 = (FloatingActionButton) r13;
            if (r15.getShowMotionSpec() != null) goto L12;
            r15.setShowMotionSpecResource(q5.a.mtrl_fab_show_motion_spec);
        L12:
            if (r15.getHideMotionSpec() != null) goto L14;
            r15.setHideMotionSpecResource(q5.a.mtrl_fab_hide_motion_spec);
        L14:
            r15.addOnLayoutChangeListener(this.fabLayoutListener);
            BottomAppBar.access$3200(r11, r15);
        L15:
            BottomAppBar.access$1300(r11);
            goto L16
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
            return onStartNestedScroll(r10, (BottomAppBar) r11, r12, r13, r14, r15);
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull BottomAppBar r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
            if (r11.getHideOnScroll() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onStartNestedScroll(r10, r11, r12, r13, r14, r15) == false) goto L7;
            return true;
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int fabAlignmentMode;
        boolean fabAttached;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Nullable
            public SavedState a(@NonNull Parcel r10) {
                return new SavedState(r10, null);
            }

            @NonNull
            public SavedState b(@NonNull Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            @NonNull
            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.fabAlignmentMode = r10.readInt();
            if (r10.readInt() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.fabAttached = r12;
            return;
        L5:
            r12 = false;
            goto L6
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.fabAlignmentMode);
            r10.writeInt(this.fabAttached ? 1 : 0);
        }
    }

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3021c;

        a(BottomAppBar r10) {
            this.f3021c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            if (BottomAppBar.access$000(this.f3021c) == true) goto L6;
            BottomAppBar r11 = this.f3021c;
            BottomAppBar.access$300(r11, BottomAppBar.access$100(r11), BottomAppBar.access$200(this.f3021c));
            return;
        }
    }

    class b implements k<FloatingActionButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3022a;

        b(BottomAppBar r10) {
            this.f3022a = r10;
        }

        @Override // r5.k
        public /* bridge */ /* synthetic */ void a(@NonNull View r10) {
            c((FloatingActionButton) r10);
        }

        @Override // r5.k
        public /* bridge */ /* synthetic */ void b(@NonNull View r10) {
            d((FloatingActionButton) r10);
        }

        public void c(@NonNull FloatingActionButton r10) {
            MaterialShapeDrawable r11 = BottomAppBar.access$400(this.f3022a);
            if (r10.getVisibility() != 0) goto L5;
            float r12 = r10.getScaleY();
        L6:
            r11.setInterpolation(r12);
            return;
        L5:
            r12 = 0.0f;
            goto L6
        }

        public void d(@NonNull FloatingActionButton r10) {
            float r11 = r10.getTranslationX();
            if (BottomAppBar.access$500(this.f3022a).j() == r11) goto L5;
            BottomAppBar.access$500(this.f3022a).p(r11);
            BottomAppBar.access$400(this.f3022a).invalidateSelf();
        L5:
            float r12 = 0.0f;
            float r13 = Math.max(0.0f, -r10.getTranslationY());
            if (BottomAppBar.access$500(this.f3022a).e() == r13) goto L8;
            BottomAppBar.access$500(this.f3022a).k(r13);
            BottomAppBar.access$400(this.f3022a).invalidateSelf();
        L8:
            MaterialShapeDrawable r14 = BottomAppBar.access$400(this.f3022a);
            if (r10.getVisibility() != 0) goto L11;
            r12 = r10.getScaleY();
        L11:
            r14.setInterpolation(r12);
        }
    }

    class c implements ViewUtils.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3023a;

        c(BottomAppBar r10) {
            this.f3023a = r10;
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        @NonNull
        public WindowInsetsCompat a(View r10, @NonNull WindowInsetsCompat r11, @NonNull ViewUtils.e r12) {
            if (BottomAppBar.access$600(this.f3023a) == false) goto L5;
            BottomAppBar.access$702(this.f3023a, r11.getSystemWindowInsetBottom());
        L5:
            boolean r13 = true;
            boolean r14 = false;
            if (BottomAppBar.access$800(this.f3023a) == true) goto L8;
            boolean r15 = false;
        L14:
            if (BottomAppBar.access$1000(this.f3023a) == true) goto L16;
        L20:
            if (r15 == true) goto L22;
            if (r14 == true) goto L22;
        L23:
            return r11;
        L22:
            BottomAppBar.access$1200(this.f3023a);
            BottomAppBar.access$1300(this.f3023a);
            BottomAppBar.access$1400(this.f3023a);
            goto L23
        L16:
            if (BottomAppBar.access$1100(this.f3023a) != r11.getSystemWindowInsetRight()) goto L19;
            r13 = false;
        L19:
            BottomAppBar.access$1102(this.f3023a, r11.getSystemWindowInsetRight());
            r14 = r13;
            goto L20
        L8:
            if (BottomAppBar.access$900(this.f3023a) == r11.getSystemWindowInsetLeft()) goto L10;
            r15 = true;
        L11:
            BottomAppBar.access$902(this.f3023a, r11.getSystemWindowInsetLeft());
            goto L14
        L10:
            r15 = false;
            goto L11
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3024c;

        d(BottomAppBar r10) {
            this.f3024c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            BottomAppBar.access$1600(this.f3024c);
            BottomAppBar.access$1702(this.f3024c, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            BottomAppBar.access$1500(this.f3024c);
        }
    }

    class e extends FloatingActionButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3026b;

        class a extends FloatingActionButton.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f3027a;

            a(e r10) {
                this.f3027a = r10;
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton r10) {
                BottomAppBar.access$1600(this.f3027a.f3026b);
            }
        }

        e(BottomAppBar r10, int r11) {
            this.f3026b = r10;
            this.f3025a = r11;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@NonNull FloatingActionButton r10) {
            r10.setTranslationX(BottomAppBar.access$1800(this.f3026b, this.f3025a));
            r10.show(new a(this));
        }
    }

    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3028c;

        f(BottomAppBar r10) {
            this.f3028c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            BottomAppBar.access$1600(this.f3028c);
            BottomAppBar.access$002(this.f3028c, false);
            BottomAppBar.access$1902(this.f3028c, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            BottomAppBar.access$1500(this.f3028c);
        }
    }

    class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3029c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f3030g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f3031h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f3032i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3033j;

        g(BottomAppBar r10, ActionMenuView r11, int r12, boolean r13) {
            this.f3033j = r10;
            this.f3030g = r11;
            this.f3031h = r12;
            this.f3032i = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f3029c = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f3029c == false) goto L5;
            return;
        L5:
            if (BottomAppBar.access$2000(this.f3033j) == 0) goto L7;
            boolean r11 = true;
        L8:
            BottomAppBar r12 = this.f3033j;
            r12.replaceMenu(BottomAppBar.access$2000(r12));
            BottomAppBar.access$2100(this.f3033j, this.f3030g, this.f3031h, this.f3032i, r11);
            return;
        L7:
            r11 = false;
            goto L8
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f3034c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3035g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f3036h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3037i;

        h(BottomAppBar r10, ActionMenuView r11, int r12, boolean r13) {
            this.f3037i = r10;
            this.f3034c = r11;
            this.f3035g = r12;
            this.f3036h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView r10 = this.f3034c;
            r10.setTranslationX(this.f3037i.getActionMenuViewTranslationX(r10, this.f3035g, this.f3036h));
        }
    }

    class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f3038c;

        i(BottomAppBar r10) {
            this.f3038c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f3038c.fabAnimationListener.onAnimationStart(r10);
            FloatingActionButton r11 = BottomAppBar.access$2200(this.f3038c);
            if (r11 == null) goto L6;
            r11.setTranslationX(BottomAppBar.access$2300(this.f3038c));
            return;
        }
    }

    interface j {
        void a(BottomAppBar r10);

        void b(BottomAppBar r10);
    }

    static {
        DEF_STYLE_RES = q5.k.Widget_MaterialComponents_BottomAppBar;
    }

    public BottomAppBar(@NonNull Context r10) {
        this(r10, null);
    }

    public BottomAppBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.bottomAppBarStyle);
    }

    public BottomAppBar(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = DEF_STYLE_RES;
        super(b6.a.c(r11, r12, r13, r10), r12, r13);
        MaterialShapeDrawable r14 = new MaterialShapeDrawable();
        this.materialShapeDrawable = r14;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new a(this);
        this.fabTransformationCallback = new b(this);
        Context r15 = getContext();
        TypedArray r16 = com.google.android.material.internal.k.h(r15, r12, l.BottomAppBar, r13, r10, new int[0]);
        ColorStateList r17 = com.google.android.material.resources.c.a(r15, r16, l.BottomAppBar_backgroundTint);
        int r18 = l.BottomAppBar_navigationIconTint;
        if (r16.hasValue(r18) == false) goto L5;
        setNavigationIconTint(r16.getColor(r18, -1));
    L5:
        int r19 = r16.getDimensionPixelSize(l.BottomAppBar_elevation, 0);
        float r20 = r16.getDimensionPixelOffset(l.BottomAppBar_fabCradleMargin, 0);
        float r21 = r16.getDimensionPixelOffset(l.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float r22 = r16.getDimensionPixelOffset(l.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = r16.getInt(l.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = r16.getInt(l.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = r16.getBoolean(l.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = r16.getBoolean(l.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r16.getBoolean(l.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r16.getBoolean(l.BottomAppBar_paddingRightSystemWindowInsets, false);
        r16.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(q5.d.mtrl_bottomappbar_fabOffsetEndMode);
        r14.setShapeAppearanceModel(com.google.android.material.shape.l.a().B(new com.google.android.material.bottomappbar.a(r20, r21, r22)).m());
        r14.setShadowCompatibilityMode(2);
        r14.setPaintStyle(Paint.Style.FILL);
        r14.initializeElevationOverlay(r15);
        setElevation(r19);
        DrawableCompat.setTintList(r14, r17);
        ViewCompat.setBackground(this, r14);
        ViewUtils.a(this, r12, r13, r10, new c(this));
    }

    static /* synthetic */ boolean access$000(BottomAppBar r10) {
        return r10.menuAnimatingWithFabAlignmentMode;
    }

    static /* synthetic */ boolean access$002(BottomAppBar r10, boolean r11) {
        r10.menuAnimatingWithFabAlignmentMode = r11;
        return r11;
    }

    static /* synthetic */ int access$100(BottomAppBar r10) {
        return r10.fabAlignmentMode;
    }

    static /* synthetic */ boolean access$1000(BottomAppBar r10) {
        return r10.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ int access$1100(BottomAppBar r10) {
        return r10.rightInset;
    }

    static /* synthetic */ int access$1102(BottomAppBar r10, int r11) {
        r10.rightInset = r11;
        return r11;
    }

    static /* synthetic */ void access$1200(BottomAppBar r10) {
        r10.cancelAnimations();
    }

    static /* synthetic */ void access$1300(BottomAppBar r10) {
        r10.setCutoutState();
    }

    static /* synthetic */ void access$1400(BottomAppBar r10) {
        r10.setActionMenuViewPosition();
    }

    static /* synthetic */ void access$1500(BottomAppBar r10) {
        r10.dispatchAnimationStart();
    }

    static /* synthetic */ void access$1600(BottomAppBar r10) {
        r10.dispatchAnimationEnd();
    }

    static /* synthetic */ Animator access$1702(BottomAppBar r10, Animator r11) {
        r10.modeAnimator = r11;
        return r11;
    }

    static /* synthetic */ float access$1800(BottomAppBar r10, int r11) {
        return r10.getFabTranslationX(r11);
    }

    static /* synthetic */ Animator access$1902(BottomAppBar r10, Animator r11) {
        r10.menuAnimator = r11;
        return r11;
    }

    static /* synthetic */ boolean access$200(BottomAppBar r10) {
        return r10.fabAttached;
    }

    static /* synthetic */ int access$2000(BottomAppBar r10) {
        return r10.pendingMenuResId;
    }

    static /* synthetic */ void access$2100(BottomAppBar r10, ActionMenuView r11, int r12, boolean r13, boolean r14) {
        r10.translateActionMenuView(r11, r12, r13, r14);
    }

    static /* synthetic */ FloatingActionButton access$2200(BottomAppBar r10) {
        return r10.findDependentFab();
    }

    static /* synthetic */ float access$2300(BottomAppBar r10) {
        return r10.getFabTranslationX();
    }

    static /* synthetic */ int access$2700(BottomAppBar r10) {
        return r10.getBottomInset();
    }

    static /* synthetic */ int access$2800(BottomAppBar r10) {
        return r10.getLeftInset();
    }

    static /* synthetic */ int access$2900(BottomAppBar r10) {
        return r10.getRightInset();
    }

    static /* synthetic */ void access$300(BottomAppBar r10, int r11, boolean r12) {
        r10.maybeAnimateMenuView(r11, r12);
    }

    static /* synthetic */ int access$3000(BottomAppBar r10) {
        return r10.fabOffsetEndMode;
    }

    static /* synthetic */ View access$3100(BottomAppBar r10) {
        return r10.findDependentView();
    }

    static /* synthetic */ void access$3200(BottomAppBar r10, FloatingActionButton r11) {
        r10.addFabAnimationListeners(r11);
    }

    static /* synthetic */ MaterialShapeDrawable access$400(BottomAppBar r10) {
        return r10.materialShapeDrawable;
    }

    static /* synthetic */ com.google.android.material.bottomappbar.a access$500(BottomAppBar r10) {
        return r10.getTopEdgeTreatment();
    }

    static /* synthetic */ boolean access$600(BottomAppBar r10) {
        return r10.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$702(BottomAppBar r10, int r11) {
        r10.bottomInset = r11;
        return r11;
    }

    static /* synthetic */ boolean access$800(BottomAppBar r10) {
        return r10.paddingLeftSystemWindowInsets;
    }

    static /* synthetic */ int access$900(BottomAppBar r10) {
        return r10.leftInset;
    }

    static /* synthetic */ int access$902(BottomAppBar r10, int r11) {
        r10.leftInset = r11;
        return r11;
    }

    private void addFabAnimationListeners(@NonNull FloatingActionButton r10) {
        r10.addOnHideAnimationListener(this.fabAnimationListener);
        r10.addOnShowAnimationListener(new i(this));
        r10.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        Animator r10 = this.menuAnimator;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        Animator r11 = this.modeAnimator;
        if (r11 == null) goto L9;
        r11.cancel();
        return;
    }

    private void createFabTranslationXAnimation(int r10, @NonNull List<Animator> r11) {
        ObjectAnimator r12 = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(r10)});
        r12.setDuration(ANIMATION_DURATION);
        r11.add(r12);
    }

    private void createMenuViewTranslationAnimation(int r10, boolean r11, @NonNull List<Animator> r12) {
        ActionMenuView r13 = getActionMenuView();
        if (r13 != null) goto L5;
        return;
    L5:
        Animator r14 = ObjectAnimator.ofFloat(r13, "alpha", new float[]{1.0f});
        if (Math.abs(r13.getTranslationX() - getActionMenuViewTranslationX(r13, r10, r11)) <= 1.0f) goto L9;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r13, "alpha", new float[]{0.0f});
        r15.addListener(new g(this, r13, r10, r11));
        AnimatorSet r16 = new AnimatorSet();
        r16.setDuration(150);
        r16.playSequentially(new Animator[]{r15, r14});
        r12.add(r16);
        return;
    L9:
        if (r13.getAlpha() >= 1.0f) goto L13;
        r12.add(r14);
        return;
    }

    private void dispatchAnimationEnd() {
        int r10 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = r10;
        if (r10 != 0) goto L10;
        ArrayList<j> r11 = this.animationListeners;
        if (r11 == null) goto L12;
        Iterator<j> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        r12.next().b(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private void dispatchAnimationStart() {
        int r10 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = r10 + 1;
        if (r10 != 0) goto L10;
        ArrayList<j> r11 = this.animationListeners;
        if (r11 == null) goto L12;
        Iterator<j> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        r12.next().a(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Nullable
    private FloatingActionButton findDependentFab() {
        View r10 = findDependentView();
        if ((r10 instanceof FloatingActionButton) == true) goto L7;
        return null;
    L7:
        return (FloatingActionButton) r10;
    }

    @Nullable
    private View findDependentView() {
        if ((getParent() instanceof CoordinatorLayout) == true) goto L5;
        return null;
    L5:
        Iterator<View> r10 = ((CoordinatorLayout) getParent()).getDependents(this).iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        View r11 = r10.next();
        if ((r11 instanceof FloatingActionButton) == true) goto L12;
        if ((r11 instanceof ExtendedFloatingActionButton) == false) goto L7;
    L12:
        return r11;
    L13:
        return null;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L10;
        View r11 = getChildAt(r10);
        if ((r11 instanceof ActionMenuView) == true) goto L8;
        r10 = r10 + 1;
        goto L4
    L8:
        return (ActionMenuView) r11;
    L10:
        return null;
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    private float getFabTranslationX(int r10) {
        boolean r11 = ViewUtils.i(this);
        int r12 = 1;
        if (r10 != 1) goto L12;
        if (r11 == false) goto L6;
        int r13 = this.leftInset;
    L7:
        int r14 = (getMeasuredWidth() / 2) - (this.fabOffsetEndMode + r13);
        if (r11 == false) goto L11;
        r12 = -1;
    L11:
        return r14 * r12;
    L6:
        r13 = this.rightInset;
        goto L7
    L12:
        return 0.0f;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().e();
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    @NonNull
    private com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.materialShapeDrawable.getShapeAppearanceModel().p();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton r10 = findDependentFab();
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isOrWillBeShown() == false) goto L7;
        return true;
    }

    private void maybeAnimateMenuView(int r10, boolean r11) {
        if (ViewCompat.isLaidOut(this) == true) goto L6;
        this.menuAnimatingWithFabAlignmentMode = false;
        replaceMenu(this.pendingMenuResId);
        return;
    L6:
        Animator r12 = this.menuAnimator;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        ArrayList r13 = new ArrayList();
        if (isFabVisibleOrWillBeShown() == true) goto L12;
        r10 = 0;
        r11 = false;
    L12:
        createMenuViewTranslationAnimation(r10, r11, r13);
        AnimatorSet r14 = new AnimatorSet();
        r14.playTogether(r13);
        this.menuAnimator = r14;
        r14.addListener(new f(this));
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int r10) {
        if (this.fabAlignmentMode != r10) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        Animator r11 = this.modeAnimator;
        if (r11 == null) goto L10;
        r11.cancel();
    L10:
        ArrayList r12 = new ArrayList();
        if (this.fabAnimationMode != 1) goto L13;
        createFabTranslationXAnimation(r10, r12);
    L14:
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(r12);
        this.modeAnimator = r13;
        r13.addListener(new d(this));
        this.modeAnimator.start();
        return;
    L13:
        createFabDefaultXAnimation(r10, r12);
        goto L14
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r11 = DrawableCompat.wrap(r10.mutate());
        DrawableCompat.setTint(r11, this.navigationIconTint.intValue());
        return r11;
    L8:
        return r10;
    }

    private void setActionMenuViewPosition() {
        ActionMenuView r10 = getActionMenuView();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.menuAnimator != null) goto L12;
        r10.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown() == true) goto L9;
        translateActionMenuView(r10, 0, false);
        return;
    L9:
        translateActionMenuView(r10, this.fabAlignmentMode, this.fabAttached);
        return;
    }

    private void setCutoutState() {
        getTopEdgeTreatment().p(getFabTranslationX());
        View r10 = findDependentView();
        MaterialShapeDrawable r11 = this.materialShapeDrawable;
        if (this.fabAttached == true) goto L5;
    L7:
        float r12 = 0.0f;
    L8:
        r11.setInterpolation(r12);
        if (r10 == null) goto L12;
        r10.setTranslationY(getFabTranslationY());
        r10.setTranslationX(getFabTranslationX());
        return;
    L12:
        return;
    L5:
        if (isFabVisibleOrWillBeShown() == false) goto L7;
        r12 = 1.0f;
        goto L8
    }

    private void translateActionMenuView(@NonNull ActionMenuView r10, int r11, boolean r12) {
        translateActionMenuView(r10, r11, r12, false);
    }

    private void translateActionMenuView(@NonNull ActionMenuView r10, int r11, boolean r12, boolean r13) {
        h r14 = new h(this, r10, r11, r12);
        if (r13 == false) goto L5;
        r10.post(r14);
        return;
    L5:
        r14.run();
    }

    void addAnimationListener(@NonNull j r10) {
        if (this.animationListeners != null) goto L5;
        this.animationListeners = new ArrayList();
    L5:
        this.animationListeners.add(r10);
    }

    protected void createFabDefaultXAnimation(int r10, List<Animator> r11) {
        FloatingActionButton r12 = findDependentFab();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isOrWillBeHidden() == true) goto L10;
        dispatchAnimationStart();
        r12.hide(new e(this, r10));
        return;
    }

    protected int getActionMenuViewTranslationX(@NonNull ActionMenuView r10, int r11, boolean r12) {
        if (r11 != 1) goto L32;
        if (r12 == false) goto L32;
        boolean r13 = ViewUtils.i(this);
        if (r13 == false) goto L9;
        int r14 = getMeasuredWidth();
    L10:
        int r15 = 0;
    L12:
        if (r15 >= getChildCount()) goto L24;
        View r16 = getChildAt(r15);
        if ((r16.getLayoutParams() instanceof Toolbar.LayoutParams) == true) goto L16;
    L18:
        boolean r17 = false;
    L19:
        if (r17 == false) goto L23;
        if (r13 == false) goto L22;
        r14 = Math.min(r14, r16.getLeft());
        goto L23
    L22:
        r14 = Math.max(r14, r16.getRight());
    L23:
        r15 = r15 + 1;
        goto L12
    L16:
        if ((((Toolbar.LayoutParams) r16.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 8388611) goto L18;
        r17 = true;
        goto L19
    L24:
        if (r13 == false) goto L26;
        int r18 = r10.getRight();
    L27:
        if (r13 == false) goto L29;
        int r19 = this.rightInset;
    L31:
        return r14 - (r18 + r19);
    L29:
        r19 = -this.leftInset;
        goto L31
    L26:
        r18 = r10.getLeft();
        goto L27
    L9:
        r14 = 0;
    L32:
        return 0;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public /* bridge */ /* synthetic */ CoordinatorLayout.Behavior getBehavior() {
        return getBehavior();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.behavior != null) goto L6;
        this.behavior = new Behavior();
    L6:
        return this.behavior;
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().e();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().g();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().h();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public boolean isScrolledDown() {
        return getBehavior().isScrolledDown();
    }

    public boolean isScrolledUp() {
        return getBehavior().isScrolledUp();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.h.f(this, this.materialShapeDrawable);
        if ((getParent() instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) getParent()).setClipChildren(false);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (r10 == false) goto L5;
        cancelAnimations();
        setCutoutState();
    L5:
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.fabAlignmentMode = r11.fabAlignmentMode;
        this.fabAttached = r11.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.fabAlignmentMode = this.fabAlignmentMode;
        r10.fabAttached = this.fabAttached;
        return r10;
    }

    public void performHide() {
        performHide(true);
    }

    public void performHide(boolean r10) {
        getBehavior().slideDown(this, r10);
    }

    public void performShow() {
        performShow(true);
    }

    public void performShow(boolean r10) {
        getBehavior().slideUp(this, r10);
    }

    void removeAnimationListener(@NonNull j r10) {
        ArrayList<j> r11 = this.animationListeners;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    public void replaceMenu(@MenuRes int r10) {
        if (r10 == 0) goto L5;
        this.pendingMenuResId = 0;
        getMenu().clear();
        inflateMenu(r10);
        return;
    }

    public void setBackgroundTint(@Nullable ColorStateList r10) {
        DrawableCompat.setTintList(this.materialShapeDrawable, r10);
    }

    public void setCradleVerticalOffset(@Dimension float r10) {
        if (r10 == getCradleVerticalOffset()) goto L6;
        getTopEdgeTreatment().k(r10);
        this.materialShapeDrawable.invalidateSelf();
        setCutoutState();
        return;
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        this.materialShapeDrawable.setElevation(r10);
        int r11 = this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY();
        getBehavior().setAdditionalHiddenOffsetY(this, r11);
    }

    public void setFabAlignmentMode(int r10) {
        setFabAlignmentModeAndReplaceMenu(r10, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int r10, @MenuRes int r11) {
        this.pendingMenuResId = r11;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(r10, this.fabAttached);
        maybeAnimateModeChange(r10);
        this.fabAlignmentMode = r10;
    }

    public void setFabAnimationMode(int r10) {
        this.fabAnimationMode = r10;
    }

    void setFabCornerSize(@Dimension float r10) {
        if (r10 == getTopEdgeTreatment().f()) goto L6;
        getTopEdgeTreatment().l(r10);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleMargin(@Dimension float r10) {
        if (r10 == getFabCradleMargin()) goto L6;
        getTopEdgeTreatment().m(r10);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float r10) {
        if (r10 == getFabCradleRoundedCornerRadius()) goto L6;
        getTopEdgeTreatment().n(r10);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    boolean setFabDiameter(@Px int r10) {
        float r11 = r10;
        if (r11 == getTopEdgeTreatment().i()) goto L6;
        getTopEdgeTreatment().o(r11);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    L6:
        return false;
    }

    public void setHideOnScroll(boolean r10) {
        this.hideOnScroll = r10;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable r10) {
        super.setNavigationIcon(maybeTintNavigationIcon(r10));
    }

    public void setNavigationIconTint(@ColorInt int r10) {
        this.navigationIconTint = Integer.valueOf(r10);
        Drawable r11 = getNavigationIcon();
        if (r11 == null) goto L6;
        setNavigationIcon(r11);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r10) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r10) {
    }
}
