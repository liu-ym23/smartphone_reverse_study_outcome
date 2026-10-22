package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import q5.j;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;

    @Nullable
    private ColorStateList backgroundTint;

    @NonNull
    private final ArrayList<d> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;

    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;

    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private l shapeAppearanceModelDefault;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.e stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;

    @Nullable
    private VelocityTracker velocityTracker;

    @Nullable
    ViewDragHelper viewDragHelper;

    @Nullable
    WeakReference<V> viewRef;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

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

        public SavedState(@NonNull Parcel r10) {
            this(r10, null);
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.state = r10.readInt();
            this.peekHeight = r10.readInt();
            boolean r12 = false;
            if (r10.readInt() != 1) goto L5;
            boolean r13 = true;
        L6:
            this.fitToContents = r13;
            if (r10.readInt() != 1) goto L9;
            boolean r14 = true;
        L10:
            this.hideable = r14;
            if (r10.readInt() != 1) goto L13;
            r12 = true;
        L13:
            this.skipCollapsed = r12;
            return;
        L9:
            r14 = false;
            goto L10
        L5:
            r13 = false;
            goto L6
        }

        @Deprecated
        public SavedState(Parcelable r10, int r11) {
            super(r10);
            this.state = r11;
        }

        public SavedState(Parcelable r10, @NonNull BottomSheetBehavior<?> r11) {
            super(r10);
            this.state = r11.state;
            this.peekHeight = BottomSheetBehavior.access$1700(r11);
            this.fitToContents = BottomSheetBehavior.access$1400(r11);
            this.hideable = r11.hideable;
            this.skipCollapsed = BottomSheetBehavior.access$1800(r11);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.state);
            r10.writeInt(this.peekHeight);
            r10.writeInt(this.fitToContents ? 1 : 0);
            r10.writeInt(this.hideable ? 1 : 0);
            r10.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3045c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3046g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f3047h;

        a(BottomSheetBehavior r10, View r11, int r12) {
            this.f3047h = r10;
            this.f3045c = r11;
            this.f3046g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.access$100(this.f3047h, this.f3045c, this.f3046g, false);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f3048c;

        b(BottomSheetBehavior r10) {
            this.f3048c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.access$200(this.f3048c) == null) goto L6;
            BottomSheetBehavior.access$200(this.f3048c).setInterpolation(r11);
            return;
        }
    }

    class c implements ViewUtils.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f3050b;

        c(BottomSheetBehavior r10, boolean r11) {
            this.f3050b = r10;
            this.f3049a = r11;
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        public WindowInsetsCompat a(View r11, WindowInsetsCompat r12, ViewUtils.e r13) {
            Insets r10 = r12.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets r14 = r12.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures());
            BottomSheetBehavior.access$302(this.f3050b, r10.top);
            boolean r15 = ViewUtils.i(r11);
            int r16 = r11.getPaddingBottom();
            int r17 = r11.getPaddingLeft();
            int r18 = r11.getPaddingRight();
            if (BottomSheetBehavior.access$400(this.f3050b) == false) goto L6;
            BottomSheetBehavior.access$502(this.f3050b, r12.getSystemWindowInsetBottom());
            r16 = r13.f3376d + BottomSheetBehavior.access$500(this.f3050b);
        L6:
            if (BottomSheetBehavior.access$600(this.f3050b) == false) goto L12;
            if (r15 == false) goto L9;
            int r19 = r13.f3375c;
        L10:
            r17 = r19 + r10.left;
            goto L12
        L9:
            r19 = r13.f3373a;
        L12:
            if (BottomSheetBehavior.access$700(this.f3050b) == false) goto L17;
            if (r15 == false) goto L15;
            int r110 = r13.f3373a;
        L16:
            r18 = r110 + r10.right;
            goto L17
        L15:
            r110 = r13.f3375c;
        L17:
            ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
            boolean r20 = true;
            if (BottomSheetBehavior.access$800(this.f3050b) == false) goto L22;
            int r21 = r111.leftMargin;
            int r22 = r10.left;
            if (r21 == r22) goto L22;
            r111.leftMargin = r22;
            boolean r23 = true;
        L24:
            if (BottomSheetBehavior.access$900(this.f3050b) == false) goto L29;
            int r24 = r111.rightMargin;
            int r25 = r10.right;
            if (r24 == r25) goto L29;
            r111.rightMargin = r25;
            r23 = true;
        L29:
            if (BottomSheetBehavior.access$1000(this.f3050b) == false) goto L33;
            int r26 = r111.topMargin;
            int r27 = r10.top;
            if (r26 == r27) goto L33;
            r111.topMargin = r27;
        L34:
            if (r20 == false) goto L36;
            r11.setLayoutParams(r111);
        L36:
            r11.setPadding(r17, r11.getPaddingTop(), r18, r16);
            if (this.f3049a == false) goto L40;
            BottomSheetBehavior.access$1102(this.f3050b, r14.bottom);
        L40:
            if (BottomSheetBehavior.access$400(this.f3050b) == false) goto L42;
        L43:
            BottomSheetBehavior.access$1200(this.f3050b, false);
        L44:
            return r12;
        L42:
            if (this.f3049a == false) goto L44;
        L33:
            r20 = r23;
        L22:
            r23 = false;
            goto L24
        }
    }

    public static abstract class d {
        public d() {
        }

        void a(@NonNull View r10) {
        }

        public abstract void b(@NonNull View r10, float r11);

        public abstract void c(@NonNull View r10, int r11);
    }

    private class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f3053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f3054d;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f3055c;

            a(e r10) {
                this.f3055c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.a(this.f3055c, false);
                ViewDragHelper r10 = this.f3055c.f3054d.viewDragHelper;
                if (r10 != null) goto L5;
            L7:
                e r11 = this.f3055c;
                BottomSheetBehavior r12 = r11.f3054d;
                if (r12.state != 2) goto L12;
                r12.setStateInternal(e.b(r11));
                return;
            L12:
                return;
            L5:
                if (r10.continueSettling(true) == false) goto L7;
                e r13 = this.f3055c;
                r13.c(e.b(r13));
            }
        }

        private e(BottomSheetBehavior r10) {
            this.f3054d = r10;
            this.f3053c = new a(this);
        }

        /* synthetic */ e(BottomSheetBehavior r10, a r11) {
            this(r10);
        }

        static /* synthetic */ boolean a(e r10, boolean r11) {
            r10.f3052b = r11;
            return r11;
        }

        static /* synthetic */ int b(e r10) {
            return r10.f3051a;
        }

        void c(int r10) {
            WeakReference<V> r11 = this.f3054d.viewRef;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.get() == null) goto L13;
            this.f3051a = r10;
            if (this.f3052b == true) goto L12;
            ViewCompat.postOnAnimation(this.f3054d.viewRef.get(), this.f3053c);
            this.f3052b = true;
            return;
        L12:
            return;
        }
    }

    static {
        DEF_STYLE_RES = k.Widget_Design_BottomSheet_Modal;
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new e(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass4(this);
    }

    public BottomSheetBehavior(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new e(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass4(this);
        this.peekHeightGestureInsetBuffer = r10.getResources().getDimensionPixelSize(q5.d.mtrl_min_touch_target_size);
        TypedArray r12 = r10.obtainStyledAttributes(r11, q5.l.BottomSheetBehavior_Layout);
        int r13 = q5.l.BottomSheetBehavior_Layout_backgroundTint;
        if (r12.hasValue(r13) == false) goto L6;
        this.backgroundTint = com.google.android.material.resources.c.a(r10, r12, r13);
    L6:
        if (r12.hasValue(q5.l.BottomSheetBehavior_Layout_shapeAppearance) == false) goto L8;
        this.shapeAppearanceModelDefault = l.e(r10, r11, q5.b.bottomSheetStyle, DEF_STYLE_RES).m();
    L8:
        createMaterialShapeDrawableIfNeeded(r10);
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT < 21) goto L11;
        this.elevation = r12.getDimension(q5.l.BottomSheetBehavior_Layout_android_elevation, -1.0f);
    L11:
        int r14 = q5.l.BottomSheetBehavior_Layout_android_maxWidth;
        if (r12.hasValue(r14) == false) goto L14;
        setMaxWidth(r12.getDimensionPixelSize(r14, -1));
    L14:
        int r15 = q5.l.BottomSheetBehavior_Layout_android_maxHeight;
        if (r12.hasValue(r15) == false) goto L17;
        setMaxHeight(r12.getDimensionPixelSize(r15, -1));
    L17:
        int r16 = q5.l.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue r17 = r12.peekValue(r16);
        if (r17 == null) goto L22;
        int r18 = r17.data;
        if (r18 != (-1)) goto L22;
        setPeekHeight(r18);
    L23:
        setHideable(r12.getBoolean(q5.l.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(r12.getBoolean(q5.l.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(r12.getBoolean(q5.l.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r12.getBoolean(q5.l.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(r12.getBoolean(q5.l.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(r12.getInt(q5.l.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(r12.getFloat(q5.l.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int r19 = q5.l.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue r20 = r12.peekValue(r19);
        if (r20 != null) goto L26;
    L28:
        int r110 = r12.getDimensionPixelOffset(r19, 0);
    L29:
        setExpandedOffset(r110);
        this.paddingBottomSystemWindowInsets = r12.getBoolean(q5.l.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r12.getBoolean(q5.l.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r12.getBoolean(q5.l.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = r12.getBoolean(q5.l.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = r12.getBoolean(q5.l.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = r12.getBoolean(q5.l.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = r12.getBoolean(q5.l.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        r12.recycle();
        this.maximumVelocity = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L26:
        if (r20.type != 16) goto L28;
        r110 = r20.data;
    L22:
        setPeekHeight(r12.getDimensionPixelSize(r16, -1));
        goto L23
    }

    static /* synthetic */ void access$100(BottomSheetBehavior r10, View r11, int r12, boolean r13) {
        r10.startSettling(r11, r12, r13);
    }

    static /* synthetic */ boolean access$1000(BottomSheetBehavior r10) {
        return r10.marginTopSystemWindowInsets;
    }

    static /* synthetic */ int access$1102(BottomSheetBehavior r10, int r11) {
        r10.gestureInsetBottom = r11;
        return r11;
    }

    static /* synthetic */ void access$1200(BottomSheetBehavior r10, boolean r11) {
        r10.updatePeekHeight(r11);
    }

    static /* synthetic */ boolean access$1300(BottomSheetBehavior r10) {
        return r10.draggable;
    }

    static /* synthetic */ boolean access$1400(BottomSheetBehavior r10) {
        return r10.fitToContents;
    }

    static /* synthetic */ int access$1700(BottomSheetBehavior r10) {
        return r10.peekHeight;
    }

    static /* synthetic */ boolean access$1800(BottomSheetBehavior r10) {
        return r10.skipCollapsed;
    }

    static /* synthetic */ MaterialShapeDrawable access$200(BottomSheetBehavior r10) {
        return r10.materialShapeDrawable;
    }

    static /* synthetic */ int access$302(BottomSheetBehavior r10, int r11) {
        r10.insetTop = r11;
        return r11;
    }

    static /* synthetic */ boolean access$400(BottomSheetBehavior r10) {
        return r10.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$500(BottomSheetBehavior r10) {
        return r10.insetBottom;
    }

    static /* synthetic */ int access$502(BottomSheetBehavior r10, int r11) {
        r10.insetBottom = r11;
        return r11;
    }

    static /* synthetic */ boolean access$600(BottomSheetBehavior r10) {
        return r10.paddingLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$700(BottomSheetBehavior r10) {
        return r10.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ boolean access$800(BottomSheetBehavior r10) {
        return r10.marginLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$900(BottomSheetBehavior r10) {
        return r10.marginRightSystemWindowInsets;
    }

    private int addAccessibilityActionForState(V r10, @StringRes int r11, int r12) {
        return ViewCompat.addAccessibilityAction(r10, r10.getResources().getString(r11), createAccessibilityViewCommandForState(r12));
    }

    private void calculateCollapsedOffset() {
        int r10 = calculatePeekHeight();
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - r10, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - r10;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto == false) goto L8;
        int r10 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
    L6:
        return r10 + this.insetBottom;
    L8:
        if (this.gestureInsetBottomIgnored == false) goto L10;
    L15:
        r10 = this.peekHeight;
        goto L6
    L10:
        if (this.paddingBottomSystemWindowInsets == true) goto L15;
        int r11 = this.gestureInsetBottom;
        if (r11 <= 0) goto L15;
        return Math.max(this.peekHeight, r11 + this.peekHeightGestureInsetBuffer);
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int r10) {
        return new AnonymousClass5(this, r10);
    }

    private void createMaterialShapeDrawableIfNeeded(@NonNull Context r10) {
        if (this.shapeAppearanceModelDefault != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r11 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = r11;
        r11.initializeElevationOverlay(r10);
        ColorStateList r12 = this.backgroundTint;
        if (r12 == null) goto L8;
        this.materialShapeDrawable.setFillColor(r12);
        return;
    L8:
        TypedValue r13 = new TypedValue();
        r10.getTheme().resolveAttribute(R.attr.colorBackground, r13, true);
        this.materialShapeDrawable.setTint(r13.data);
    }

    private void createShapeValueAnimator() {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = r10;
        r10.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new b(this));
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.LayoutParams) r11).getBehavior();
        if ((r12 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r12;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int r10, int r11, int r12, int r13) {
        int r14 = ViewGroup.getChildMeasureSpec(r10, r11, r13);
        if (r12 != (-1)) goto L5;
        return r14;
    L5:
        int r15 = View.MeasureSpec.getMode(r14);
        int r16 = View.MeasureSpec.getSize(r14);
        if (r15 == 1073741824) goto L13;
        if (r16 == 0) goto L11;
        r12 = Math.min(r16, r12);
    L11:
        return View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE);
    L13:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r16, r12), 1073741824);
    }

    private int getTopOffsetForState(int r10) {
        if (r10 == 3) goto L19;
        if (r10 == 4) goto L17;
        if (r10 == 5) goto L15;
        if (r10 != 6) goto L13;
        return this.halfExpandedOffset;
    L13:
        throw new IllegalArgumentException("Invalid state to get top offset: " + r10);
    L15:
        return this.parentHeight;
    L17:
        return this.collapsedOffset;
    L19:
        return getExpandedOffset();
    }

    private float getYVelocity() {
        VelocityTracker r10 = this.velocityTracker;
        if (r10 != null) goto L6;
        return 0.0f;
    L6:
        r10.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isLayouting(V r10) {
        ViewParent r11 = r10.getParent();
        if (r11 != null) goto L5;
    L9:
        return false;
    L5:
        if (r11.isLayoutRequested() == false) goto L9;
        if (ViewCompat.isAttachedToWindow(r10) == false) goto L9;
        return true;
    }

    private void replaceAccessibilityActionForState(V r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat r11, int r12) {
        ViewCompat.replaceAccessibilityAction(r10, r11, null, createAccessibilityViewCommandForState(r12));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r10 = this.velocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.velocityTracker = null;
        return;
    }

    private void restoreOptionalState(@NonNull SavedState r10) {
        int r11 = this.saveFlags;
        if (r11 != 0) goto L6;
        return;
    L6:
        if (r11 != (-1)) goto L8;
    L9:
        this.peekHeight = r10.peekHeight;
    L10:
        if (r11 != (-1)) goto L12;
    L13:
        this.fitToContents = r10.fitToContents;
    L14:
        if (r11 != (-1)) goto L16;
    L17:
        this.hideable = r10.hideable;
    L18:
        if (r11 != (-1)) goto L20;
    L21:
        this.skipCollapsed = r10.skipCollapsed;
        return;
    L20:
        if ((r11 & 8) == 8) goto L21;
        return;
    L16:
        if ((r11 & 4) != 4) goto L18;
    L12:
        if ((r11 & 2) != 2) goto L14;
    L8:
        if ((r11 & 1) != 1) goto L10;
        goto L9
    }

    private void runAfterLayout(V r10, Runnable r11) {
        if (isLayouting(r10) == false) goto L5;
        r10.post(r11);
        return;
    L5:
        r11.run();
    }

    private void setWindowInsetsListener(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
    L9:
        boolean r11 = false;
    L11:
        if (this.paddingBottomSystemWindowInsets == false) goto L13;
    L24:
        ViewUtils.b(r10, new c(this, r11));
        return;
    L13:
        if (this.paddingLeftSystemWindowInsets == true) goto L24;
        if (this.paddingRightSystemWindowInsets == true) goto L24;
        if (this.marginLeftSystemWindowInsets == true) goto L24;
        if (this.marginRightSystemWindowInsets == true) goto L24;
        if (this.marginTopSystemWindowInsets == true) goto L24;
        if (r11 == true) goto L24;
        return;
    L5:
        if (isGestureInsetBottomIgnored() == true) goto L9;
        if (this.peekHeightAuto == true) goto L9;
        r11 = true;
        goto L11
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper != null) goto L5;
    L9:
        return false;
    L5:
        if (this.draggable == false) goto L7;
        return true;
    L7:
        if (this.state != 1) goto L9;
        return true;
    }

    private void startSettling(View r10, int r11, boolean r12) {
        int r13 = getTopOffsetForState(r11);
        ViewDragHelper r14 = this.viewDragHelper;
        if (r14 == null) goto L11;
        if (r12 == false) goto L9;
        if (r14.settleCapturedViewAt(r10.getLeft(), r13) == false) goto L11;
    L10:
        boolean r15 = true;
    L12:
        if (r15 == false) goto L14;
        setStateInternal(2);
        updateDrawableForTargetState(r11);
        this.stateSettlingTracker.c(r11);
        return;
    L14:
        setStateInternal(r11);
        return;
    L9:
        if (r14.smoothSlideViewTo(r10, r10.getLeft(), r13) == true) goto L10;
    L11:
        r15 = false;
        goto L12
    }

    private void updateAccessibilityActions() {
        WeakReference<V> r10 = this.viewRef;
        if (r10 != null) goto L5;
        return;
    L5:
        V r11 = r10.get();
        if (r11 != null) goto L8;
        return;
    L8:
        ViewCompat.removeAccessibilityAction(r11, 524288);
        ViewCompat.removeAccessibilityAction(r11, 262144);
        ViewCompat.removeAccessibilityAction(r11, 1048576);
        int r12 = this.expandHalfwayActionId;
        if (r12 == (-1)) goto L11;
        ViewCompat.removeAccessibilityAction(r11, r12);
    L11:
        int r13 = 6;
        if (this.fitToContents == true) goto L17;
        if (this.state == 6) goto L17;
        this.expandHalfwayActionId = addAccessibilityActionForState(r11, j.bottomsheet_action_expand_halfway, 6);
    L17:
        if (this.hideable == true) goto L19;
    L21:
        int r14 = this.state;
        if (r14 == 3) goto L32;
        if (r14 == 4) goto L28;
        if (r14 != 6) goto L38;
        replaceAccessibilityActionForState(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        replaceAccessibilityActionForState(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
    L38:
        return;
    L28:
        if (this.fitToContents == false) goto L30;
        r13 = 3;
    L30:
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r15 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND;
    L35:
        replaceAccessibilityActionForState(r11, r15, r13);
        return;
    L32:
        if (this.fitToContents == false) goto L34;
        r13 = 4;
    L34:
        r15 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE;
        goto L35
    L19:
        if (this.state == 5) goto L21;
        replaceAccessibilityActionForState(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        goto L21
    }

    private void updateDrawableForTargetState(int r10) {
        if (r10 != 2) goto L6;
        return;
    L6:
        if (r10 != 3) goto L8;
        boolean r11 = true;
    L10:
        if (this.isShapeExpanded == r11) goto L24;
        this.isShapeExpanded = r11;
        if (this.materialShapeDrawable == null) goto L25;
        ValueAnimator r12 = this.interpolatorAnimator;
        if (r12 != null) goto L16;
        return;
    L16:
        if (r12.isRunning() == false) goto L19;
        this.interpolatorAnimator.reverse();
        return;
    L19:
        if (r11 == false) goto L21;
        float r13 = 0.0f;
    L22:
        this.interpolatorAnimator.setFloatValues(new float[]{1.0f - r13, r13});
        this.interpolatorAnimator.start();
        return;
    L21:
        r13 = 1.0f;
        goto L22
    L25:
        return;
    L24:
        return;
    L8:
        r11 = false;
        goto L10
    }

    private void updateImportantForAccessibility(boolean r10) {
        WeakReference<V> r11 = this.viewRef;
        if (r11 != null) goto L5;
        return;
    L5:
        ViewParent r12 = r11.get().getParent();
        if ((r12 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r13 = (CoordinatorLayout) r12;
        int r14 = r13.getChildCount();
        if (Build.VERSION.SDK_INT < 16) goto L15;
        if (r10 == false) goto L15;
        if (this.importantForAccessibilityMap != null) goto L14;
        this.importantForAccessibilityMap = new HashMap(r14);
        goto L15
    L14:
        return;
    L15:
        int r15 = 0;
    L16:
        if (r15 >= r14) goto L36;
        View r16 = r13.getChildAt(r15);
        if (r16 == this.viewRef.get()) goto L35;
        if (r10 == false) goto L29;
        if (Build.VERSION.SDK_INT < 16) goto L25;
        this.importantForAccessibilityMap.put(r16, Integer.valueOf(r16.getImportantForAccessibility()));
    L25:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L35;
        int r17 = 4;
    L27:
        ViewCompat.setImportantForAccessibility(r16, r17);
        goto L35
    L29:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L35;
        Map<View, Integer> r18 = this.importantForAccessibilityMap;
        if (r18 == null) goto L35;
        if (r18.containsKey(r16) == false) goto L35;
        r17 = this.importantForAccessibilityMap.get(r16).intValue();
    L35:
        r15 = r15 + 1;
        goto L16
    L36:
        if (r10 == true) goto L39;
        this.importantForAccessibilityMap = null;
        return;
    L39:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L50;
        this.viewRef.get().sendAccessibilityEvent(8);
        return;
    }

    private void updatePeekHeight(boolean r10) {
        if (this.viewRef == null) goto L12;
        calculateCollapsedOffset();
        if (this.state != 4) goto L13;
        V r11 = this.viewRef.get();
        if (r11 == null) goto L14;
        if (r10 == false) goto L10;
        setState(4);
        return;
    L10:
        r11.requestLayout();
        return;
    L14:
        return;
    L13:
        return;
    }

    public void addBottomSheetCallback(@NonNull d r10) {
        if (this.callbacks.contains(r10) == true) goto L6;
        this.callbacks.add(r10);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    void dispatchOnSlide(int r10) {
        V r11 = this.viewRef.get();
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L19;
        int r12 = this.collapsedOffset;
        if (r10 <= r12) goto L9;
    L12:
        int r13 = this.collapsedOffset;
        float r14 = r13 - r10;
        float r15 = this.parentHeight - r13;
    L13:
        float r16 = r14 / r15;
        int r17 = 0;
    L15:
        if (r17 >= this.callbacks.size()) goto L20;
        this.callbacks.get(r17).b(r11, r16);
        r17 = r17 + 1;
        goto L15
    L20:
        return;
    L9:
        if (r12 == getExpandedOffset()) goto L12;
        int r18 = this.collapsedOffset;
        r14 = r18 - r10;
        r15 = r18 - getExpandedOffset();
        goto L13
    }

    @Nullable
    @VisibleForTesting
    View findScrollingChild(View r10) {
        if (ViewCompat.isNestedScrollingEnabled(r10) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = 0;
        int r13 = r11.getChildCount();
    L8:
        if (r12 >= r13) goto L17;
        View r14 = findScrollingChild(r11.getChildAt(r12));
        if (r14 != null) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        return r14;
    L17:
        return null;
    L13:
        return null;
    }

    public int getExpandedOffset() {
        if (this.fitToContents == true) goto L11;
        int r10 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets == false) goto L8;
        int r11 = 0;
    L10:
        return Math.max(r10, r11);
    L8:
        r11 = this.insetTop;
        goto L10
    L11:
        return this.fitToContentsOffset;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    @VisibleForTesting
    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r10) {
        super.onAttachedToLayoutParams(r10);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L64:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L64;
        int r13 = r12.getActionMasked();
        if (r13 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r12);
        View r14 = null;
        if (r13 == 0) goto L23;
        if (r13 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L41;
        this.ignoreEvents = false;
        return false;
    L41:
        if (this.ignoreEvents == true) goto L47;
        ViewDragHelper r15 = this.viewDragHelper;
        if (r15 == null) goto L47;
        if (r15.shouldInterceptTouchEvent(r12) == false) goto L47;
        return true;
    L47:
        WeakReference<View> r16 = this.nestedScrollingChildRef;
        if (r16 == null) goto L50;
        r14 = r16.get();
    L50:
        if (r13 != 2) goto L66;
        if (r14 != null) goto L53;
        return false;
    L53:
        if (this.ignoreEvents == false) goto L55;
        return false;
    L55:
        if (this.state != 1) goto L57;
        return false;
    L57:
        if (r10.isPointInChildBounds(r14, (int) r12.getX(), (int) r12.getY()) == false) goto L59;
        return false;
    L59:
        if (this.viewDragHelper != null) goto L61;
        return false;
    L61:
        if (Math.abs(this.initialY - r12.getY()) > this.viewDragHelper.getTouchSlop()) goto L63;
        return false;
    L63:
        return true;
    L66:
        return false;
    L17:
        if (r13 == 3) goto L19;
    L23:
        int r17 = (int) r12.getX();
        this.initialY = (int) r12.getY();
        if (this.state == 2) goto L34;
        WeakReference<View> r18 = this.nestedScrollingChildRef;
        if (r18 == null) goto L28;
        View r19 = r18.get();
    L29:
        if (r19 == null) goto L34;
        if (r10.isPointInChildBounds(r19, r17, this.initialY) == false) goto L34;
        this.activePointerId = r12.getPointerId(r12.getActionIndex());
        this.touchingScrollingChild = true;
        goto L34
    L28:
        r19 = null;
    L34:
        if (this.activePointerId == (-1)) goto L36;
    L38:
        boolean r110 = false;
    L39:
        this.ignoreEvents = r110;
        goto L41
    L36:
        if (r10.isPointInChildBounds(r11, r17, this.initialY) == true) goto L38;
        r110 = true;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L5;
    L7:
        int r13 = 0;
        if (this.viewRef != null) goto L30;
        this.peekHeightMin = r10.getResources().getDimensionPixelSize(q5.d.design_bottom_sheet_peek_height_min);
        setWindowInsetsListener(r11);
        this.viewRef = new WeakReference(r11);
        MaterialShapeDrawable r14 = this.materialShapeDrawable;
        if (r14 == null) goto L23;
        ViewCompat.setBackground(r11, r14);
        MaterialShapeDrawable r15 = this.materialShapeDrawable;
        float r16 = this.elevation;
        if (r16 != (-1.0f)) goto L14;
        r16 = ViewCompat.getElevation(r11);
    L14:
        r15.setElevation(r16);
        if (this.state != 3) goto L17;
        boolean r17 = true;
    L18:
        this.isShapeExpanded = r17;
        MaterialShapeDrawable r18 = this.materialShapeDrawable;
        if (r17 == false) goto L21;
        float r19 = 0.0f;
    L22:
        r18.setInterpolation(r19);
    L26:
        updateAccessibilityActions();
        if (ViewCompat.getImportantForAccessibility(r11) != 0) goto L30;
        ViewCompat.setImportantForAccessibility(r11, 1);
        goto L30
    L21:
        r19 = 1.0f;
        goto L22
    L17:
        r17 = false;
        goto L18
    L23:
        ColorStateList r20 = this.backgroundTint;
        if (r20 == null) goto L26;
        ViewCompat.setBackgroundTintList(r11, r20);
    L30:
        if (this.viewDragHelper != null) goto L32;
        this.viewDragHelper = ViewDragHelper.create(r10, this.dragCallback);
    L32:
        int r21 = r11.getTop();
        r10.onLayoutChild(r11, r12);
        this.parentWidth = r10.getWidth();
        this.parentHeight = r10.getHeight();
        int r22 = r11.getHeight();
        this.childHeight = r22;
        int r23 = this.parentHeight;
        int r24 = r23 - r22;
        int r25 = this.insetTop;
        if (r24 < r25) goto L35;
    L38:
        this.fitToContentsOffset = Math.max(0, r23 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int r26 = this.state;
        if (r26 != 3) goto L43;
        int r27 = getExpandedOffset();
    L41:
        ViewCompat.offsetTopAndBottom(r11, r27);
    L57:
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r11));
    L59:
        if (r13 >= this.callbacks.size()) goto L61;
        this.callbacks.get(r13).a(r11);
        r13 = r13 + 1;
        goto L59
    L61:
        return true;
    L43:
        if (r26 != 6) goto L46;
        r27 = this.halfExpandedOffset;
        goto L41
    L46:
        if (this.hideable == false) goto L51;
        if (r26 != 5) goto L51;
        r27 = this.parentHeight;
    L51:
        if (r26 != 4) goto L53;
        r27 = this.collapsedOffset;
        goto L41
    L53:
        if (r26 != 1) goto L55;
    L56:
        ViewCompat.offsetTopAndBottom(r11, r21 - r11.getTop());
        goto L57
    L55:
        if (r26 != 2) goto L57;
    L35:
        if (this.paddingTopSystemWindowInsets == false) goto L37;
        this.childHeight = r23;
        goto L38
    L37:
        this.childHeight = r23 - r25;
        goto L38
    L5:
        if (ViewCompat.getFitsSystemWindows(r11) == true) goto L7;
        r11.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12, int r13, int r14, int r15) {
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        r11.measure(getChildMeasureSpec(r12, (((r10.getPaddingLeft() + r10.getPaddingRight()) + r16.leftMargin) + r16.rightMargin) + r13, this.maxWidth, r16.width), getChildMeasureSpec(r14, (((r10.getPaddingTop() + r10.getPaddingBottom()) + r16.topMargin) + r16.bottomMargin) + r15, this.maxHeight, r16.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, float r13, float r14) {
        if (isNestedScrollingCheckEnabled() == false) goto L14;
        WeakReference<View> r15 = this.nestedScrollingChildRef;
        if (r15 != null) goto L7;
        return false;
    L7:
        if (r12 == r15.get()) goto L9;
        return false;
    L9:
        if (this.state == 3) goto L11;
    L12:
        return true;
    L11:
        if (super.onNestedPreFling(r10, r11, r12, r13, r14) == true) goto L12;
        return false;
    L14:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, @NonNull int[] r15, int r16) {
        if (r16 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r17 = this.nestedScrollingChildRef;
        if (r17 == null) goto L8;
        View r18 = r17.get();
    L10:
        if (isNestedScrollingCheckEnabled() == false) goto L13;
        if (r12 == r18) goto L13;
        return;
    L13:
        int r19 = r11.getTop();
        int r20 = r19 - r14;
        if (r14 > 0) goto L16;
        if (r14 < 0) goto L26;
    L37:
        dispatchOnSlide(r11.getTop());
        this.lastNestedScrollDy = r14;
        this.nestedScrolled = true;
        return;
    L26:
        if (r12.canScrollVertically(-1) == true) goto L37;
        int r21 = this.collapsedOffset;
        if (r20 <= r21) goto L34;
        if (this.hideable == true) goto L34;
        r15[1] = r19 - r21;
        ViewCompat.offsetTopAndBottom(r11, -r15[1]);
        int r22 = 4;
    L18:
        setStateInternal(r22);
    L34:
        if (this.draggable == true) goto L36;
        return;
    L36:
        r15[1] = r14;
    L23:
        ViewCompat.offsetTopAndBottom(r11, -r14);
        setStateInternal(1);
        goto L37
    L16:
        if (r20 >= getExpandedOffset()) goto L20;
        r15[1] = r19 - getExpandedOffset();
        ViewCompat.offsetTopAndBottom(r11, -r15[1]);
        r22 = 3;
        goto L18
    L20:
        if (this.draggable == true) goto L22;
        return;
    L22:
        r15[1] = r14;
        goto L23
    L8:
        r18 = null;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16, int r17, @NonNull int[] r18) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull Parcelable r12) {
        SavedState r13 = (SavedState) r12;
        super.onRestoreInstanceState(r10, r11, r13.getSuperState());
        restoreOptionalState(r13);
        int r14 = r13.state;
        if (r14 != 1) goto L5;
    L6:
        r14 = 4;
    L7:
        this.state = r14;
        this.lastStableState = r14;
        return;
    L5:
        if (r14 != 2) goto L7;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull V r11) {
        return new SavedState(super.onSaveInstanceState(r10, r11), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r14 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13) {
        int r14 = 3;
        if (r11.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (isNestedScrollingCheckEnabled() == false) goto L16;
        WeakReference<View> r15 = this.nestedScrollingChildRef;
        if (r15 != null) goto L11;
        return;
    L11:
        if (r12 == r15.get()) goto L13;
        return;
    L13:
        if (this.nestedScrolled == true) goto L16;
        return;
    L16:
        if (this.lastNestedScrollDy <= 0) goto L24;
        if (this.fitToContents == false) goto L21;
    L52:
        startSettling(r11, r14, false);
        this.nestedScrolled = false;
        return;
    L21:
        if (r11.getTop() <= this.halfExpandedOffset) goto L52;
    L51:
        r14 = 6;
        goto L52
    L24:
        if (this.hideable == false) goto L29;
        if (shouldHide(r11, getYVelocity()) == false) goto L29;
        r14 = 5;
    L29:
        if (this.lastNestedScrollDy != 0) goto L47;
        int r16 = r11.getTop();
        if (this.fitToContents == true) goto L33;
        int r17 = this.halfExpandedOffset;
        if (r16 >= r17) goto L44;
        if (r16 < Math.abs(r16 - this.collapsedOffset)) goto L52;
        if (shouldSkipHalfExpandedStateWhenDragging() == false) goto L51;
    L48:
        r14 = 4;
        goto L52
    L44:
        if (Math.abs(r16 - r17) >= Math.abs(r16 - this.collapsedOffset)) goto L48;
    L33:
        if (Math.abs(r16 - this.fitToContentsOffset) >= Math.abs(r16 - this.collapsedOffset)) goto L48;
    L47:
        if (this.fitToContents == true) goto L48;
        int r18 = r11.getTop();
        if (Math.abs(r18 - this.halfExpandedOffset) >= Math.abs(r18 - this.collapsedOffset)) goto L48;
        goto L48
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (r11.isShown() == true) goto L6;
        return false;
    L6:
        int r13 = r12.getActionMasked();
        if (this.state != 1) goto L11;
        if (r13 != 0) goto L11;
        return true;
    L11:
        if (shouldHandleDraggingWithHelper() == false) goto L13;
        this.viewDragHelper.processTouchEvent(r12);
    L13:
        if (r13 != 0) goto L16;
        reset();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r12);
        if (shouldHandleDraggingWithHelper() == false) goto L28;
        if (r13 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (Math.abs(this.initialY - r12.getY()) <= this.viewDragHelper.getTouchSlop()) goto L28;
        this.viewDragHelper.captureChildView(r11, r12.getPointerId(r12.getActionIndex()));
    L28:
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull d r10) {
        this.callbacks.remove(r10);
    }

    @Deprecated
    public void setBottomSheetCallback(d r10) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (r10 == null) goto L6;
        this.callbacks.add(r10);
        return;
    }

    public void setDraggable(boolean r10) {
        this.draggable = r10;
    }

    public void setExpandedOffset(int r10) {
        if (r10 < 0) goto L6;
        this.expandedOffset = r10;
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean r10) {
        if (this.fitToContents != r10) goto L5;
        return;
    L5:
        this.fitToContents = r10;
        if (this.viewRef == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.fitToContents == true) goto L11;
    L13:
        int r11 = this.state;
    L14:
        setStateInternal(r11);
        updateAccessibilityActions();
        return;
    L11:
        if (this.state != 6) goto L13;
        r11 = 3;
        goto L14
    }

    public void setGestureInsetBottomIgnored(boolean r10) {
        this.gestureInsetBottomIgnored = r10;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float r10) {
        if (r10 <= 0.0f) goto L11;
        if (r10 >= 1.0f) goto L11;
        this.halfExpandedRatio = r10;
        if (this.viewRef == null) goto L12;
        calculateHalfExpandedOffset();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean r10) {
        if (this.hideable == r10) goto L11;
        this.hideable = r10;
        if (r10 == false) goto L7;
    L9:
        updateAccessibilityActions();
        return;
    L7:
        if (this.state != 5) goto L9;
        setState(4);
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHideableInternal(boolean r10) {
        this.hideable = r10;
    }

    public void setMaxHeight(@Px int r10) {
        this.maxHeight = r10;
    }

    public void setMaxWidth(@Px int r10) {
        this.maxWidth = r10;
    }

    public void setPeekHeight(int r10) {
        setPeekHeight(r10, false);
    }

    public final void setPeekHeight(int r10, boolean r11) {
        boolean r12 = true;
        if (r10 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r12 == false) goto L17;
        updatePeekHeight(r11);
        return;
    L17:
        return;
    L12:
        r12 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r10);
        goto L14
    L10:
        if (this.peekHeight == r10) goto L12;
        goto L12
    }

    public void setSaveFlags(int r10) {
        this.saveFlags = r10;
    }

    public void setSkipCollapsed(boolean r10) {
        this.skipCollapsed = r10;
    }

    public void setState(int r10) {
        if (r10 != 1) goto L5;
    L29:
        StringBuilder r11 = new StringBuilder();
        r11.append("STATE_");
        if (r10 != 1) goto L32;
        String r12 = "DRAGGING";
    L33:
        r11.append(r12);
        r11.append(" should not be set externally.");
        throw new IllegalArgumentException(r11.toString());
    L32:
        r12 = "SETTLING";
        goto L33
    L5:
        if (r10 == 2) goto L29;
        if (this.hideable == true) goto L14;
        if (r10 != 5) goto L14;
        Log.w(TAG, "Cannot set state: " + r10);
        return;
    L14:
        if (r10 == 6) goto L16;
    L20:
        int r13 = r10;
    L21:
        WeakReference<V> r14 = this.viewRef;
        if (r14 != null) goto L24;
    L27:
        setStateInternal(r10);
        return;
    L24:
        if (r14.get() == null) goto L27;
        V r15 = this.viewRef.get();
        runAfterLayout(r15, new a(this, r15, r13));
        return;
    L16:
        if (this.fitToContents == false) goto L20;
        if (getTopOffsetForState(r10) > this.fitToContentsOffset) goto L20;
        r13 = 3;
        goto L21
    }

    void setStateInternal(int r10) {
        if (this.state != r10) goto L5;
        return;
    L5:
        this.state = r10;
        if (r10 == 4) goto L12;
        if (r10 == 3) goto L12;
        if (r10 == 6) goto L12;
        if (this.hideable == false) goto L13;
        if (r10 == 5) goto L12;
    L13:
        WeakReference<V> r11 = this.viewRef;
        if (r11 != null) goto L16;
        return;
    L16:
        V r12 = r11.get();
        if (r12 != null) goto L19;
        return;
    L19:
        int r13 = 0;
        if (r10 != 3) goto L22;
        updateImportantForAccessibility(true);
    L26:
        updateDrawableForTargetState(r10);
    L28:
        if (r13 >= this.callbacks.size()) goto L30;
        this.callbacks.get(r13).c(r12, r10);
        r13 = r13 + 1;
        goto L28
    L30:
        updateAccessibilityActions();
        return;
    L22:
        if (r10 == 6) goto L25;
        if (r10 == 5) goto L25;
        if (r10 != 4) goto L26;
    L25:
        updateImportantForAccessibility(false);
    L12:
        this.lastStableState = r10;
        goto L13
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean r10) {
        this.updateImportantForAccessibilityOnSiblings = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldExpandOnUpwardDrag(long r10, @FloatRange(from = 0.0d, to = 100.0d) float r11) {
        return false;
    }

    boolean shouldHide(@NonNull View r10, float r11) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r10.getTop() >= this.collapsedOffset) goto L9;
        return false;
    L9:
        if ((Math.abs((r10.getTop() + (r11 * 0.1f)) - this.collapsedOffset) / calculatePeekHeight()) <= 0.5f) goto L12;
        return true;
    L12:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }
}
