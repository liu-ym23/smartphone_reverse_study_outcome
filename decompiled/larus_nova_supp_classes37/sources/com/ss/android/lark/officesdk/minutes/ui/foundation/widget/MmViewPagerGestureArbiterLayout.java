package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u00039:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010)\u001a\u00020&J\b\u0010*\u001a\u00020&H\u0014J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020&H\u0002J\u001a\u00100\u001a\u00020&2\b\b\u0002\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u0011H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\u00132\u0006\u00106\u001a\u00020\u0001H\u0002J\u0010\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "orientationBiasRatio", "", "manualSwitchThreshold", "conflictChild", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$PagingConflictChild;", "conflictChildTag", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "gestureSessionId", "requestSeq", "activePointerId", "downX", "downY", "lastX", "lastY", "gestureOrientation", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$GestureOrientation;", "currentDirection", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$ScrollDirection;", "currentDirectionCanScroll", "", "Ljava/lang/Boolean;", "pendingDirection", "activeChildSnapshot", "manualSwitchConsumed", "bindPagingConflictChild", "", "tag", "child", "clearPagingConflictChild", "onAttachedToWindow", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleTouchEvent", "maybeTriggerManualPageSwitch", "syncViewPagerUserInputEnabled", "active", "reason", "resetGestureState", "from", "findDescendantViewPager2", "root", "actionToString", "action", "PagingConflictChild", "ScrollDirection", "GestureOrientation", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmViewPagerGestureArbiterLayout extends FrameLayout {
    public final int a;
    public final float b;
    public final int c;
    public a d;
    public String e;
    public ViewPager2 f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public GestureOrientation m;
    public ScrollDirection n;
    public Boolean o;
    public ScrollDirection p;
    public boolean q;
    public boolean r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$GestureOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Unknown", "Horizontal", "Vertical", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum GestureOrientation extends Enum<GestureOrientation> {
        public static final GestureOrientation Horizontal = null;
        public static final GestureOrientation Unknown = null;
        public static final GestureOrientation Vertical = null;
        public static final /* synthetic */ GestureOrientation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<GestureOrientation> getEntries() {
            return b;
        }

        static {
            GestureOrientation r0 = new GestureOrientation("Unknown", 0);
            Unknown = r0;
            GestureOrientation r1 = new GestureOrientation("Horizontal", 1);
            Horizontal = r1;
            GestureOrientation r3 = new GestureOrientation("Vertical", 2);
            Vertical = r3;
            GestureOrientation[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static GestureOrientation[] values() {
            return (GestureOrientation[]) a.clone();
        }

        public static GestureOrientation valueOf(String r1) {
            return (GestureOrientation) r27.a.a(GestureOrientation.class, r1);
        }

        public GestureOrientation(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$ScrollDirection;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "Left", "Right", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection Left = null;
        public static final ScrollDirection Right = null;
        public static final /* synthetic */ ScrollDirection[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String rawValue;

        public static EnumEntries<ScrollDirection> getEntries() {
            return b;
        }

        static {
            ScrollDirection r0 = new ScrollDirection("Left", 0, "left");
            Left = r0;
            ScrollDirection r1 = new ScrollDirection("Right", 1, "right");
            Right = r1;
            ScrollDirection[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) a.clone();
        }

        public final String getRawValue() {
            return this.rawValue;
        }

        public static ScrollDirection valueOf(String r1) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r1);
        }

        public ScrollDirection(String r1, int r2, String r3) {
            super(r1, r2);
            this.rawValue = r3;
        }
    }

    public interface a {
        void a(ScrollDirection r1, int r2, int r3, Function1<? super Boolean, Unit> r4);

        boolean isActive();
    }

    public MmViewPagerGestureArbiterLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmViewPagerGestureArbiterLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.i = -1;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = GestureOrientation.Unknown;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = false;
        this.r = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r0 = getChildCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        View r3 = getChildAt(r1);
        if ((r3 instanceof ViewPager2) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        ViewPager2 r4 = (ViewPager2) r3;
    L10:
        this.f = r4;
        int r2 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onAttachedToWindow", "viewPager2=" + this.f, null, 8);
        return;
    L9:
        r4 = null;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r20) {
        Intrinsics.checkNotNullParameter(r20, "ev");
        ViewPager2 r2 = this.f;
        if (r2 != null) goto L11;
        int r3 = getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L10;
        View r6 = getChildAt(r5);
        if ((r6 instanceof ViewPager2) == true) goto L8;
        r5 = r5 + 1;
        goto L5
    L8:
        r2 = (ViewPager2) r6;
        goto L11
    L10:
        r2 = null;
    L11:
        this.f = r2;
        a r4 = this.d;
        if (r4 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        StringBuilder r8 = new StringBuilder("dispatch_");
        int r9 = r20.getActionMasked();
        if (r9 == 0) goto L28;
        if (r9 == 1) goto L27;
        if (r9 == 2) goto L26;
        if (r9 == 3) goto L25;
        if (r9 == 6) goto L24;
        String r10 = "ACTION_" + r9;
    L29:
        r8.append(r10);
        b(r7, r8.toString());
        if (r7 == true) goto L32;
        a();
    L136:
        return super.dispatchTouchEvent(r20);
    L32:
        if (r4 != null) goto L34;
        int r11 = bwb.b.a;
        bwb.b.h(MmUiLogScene.FOUNDATION, "handleTouchEvent", "active child expected but conflictChild is null", null);
        a();
        goto L136
    L34:
        int r12 = r20.getActionMasked();
        if (r12 != 0) goto L37;
        this.g++;
        this.h = 0;
        this.i = r20.getPointerId(0);
        this.j = r20.getX();
        this.k = r20.getY();
        this.l = r20.getX();
        r20.getY();
        this.m = GestureOrientation.Unknown;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = false;
        this.q = true;
        int r1 = bwb.b.a;
        MmUiLogScene r13 = MmUiLogScene.FOUNDATION;
        StringBuilder r14 = new StringBuilder("gestureSession=");
        r14.append(this.g);
        r14.append(", x=");
        r14.append(r20.getX());
        r14.append(", y=");
        r14.append(r20.getY());
        r14.append(", childTag=");
        r14.append(this.e);
        r14.append(", currentItem=");
        ViewPager2 r15 = this.f;
        if (r15 == null) goto L133;
        Integer r16 = Integer.valueOf(r15.getCurrentItem());
    L134:
        r14.append(r16);
        bwb.b.g(r13, "ACTION_DOWN", r14.toString(), null, 8);
        goto L136
    L133:
        r16 = null;
        goto L134
    L37:
        if (r12 != 1) goto L39;
        int r17 = bwb.b.a;
        MmUiLogScene r18 = MmUiLogScene.FOUNDATION;
        bwb.b.g(r18, "ACTION_UP", "gestureSession=" + this.g, null, 8);
        if (this.q == true) goto L94;
    L129:
        a();
        goto L136
    L94:
        if (this.r == true) goto L129;
        if (this.m != GestureOrientation.Horizontal) goto L129;
        ScrollDirection r19 = this.n;
        if (r19 == null) goto L129;
        Boolean r21 = this.o;
        if (r21 != null) goto L106;
        bwb.b.h(r18, "maybeTriggerManualPageSwitch", "skip, canScroll result pending, direction=" + r19, null);
        goto L129
    L106:
        if (r21.booleanValue() == true) goto L129;
        float r22 = this.l - this.j;
        if (Math.abs(r22) >= this.c) goto L111;
        bwb.b.g(r18, "maybeTriggerManualPageSwitch", "skip, swipe too short, dx=" + r22 + ", threshold=" + this.c + ", direction=" + r19, null, 8);
        goto L129
    L111:
        ViewPager2 r23 = this.f;
        if (r23 != null) goto L114;
        bwb.b.h(r18, "maybeTriggerManualPageSwitch", "skip, viewPager2 is null", null);
        goto L129
    L114:
        RecyclerView.Adapter r24 = r23.getAdapter();
        if (r24 != null) goto L117;
        bwb.b.h(r18, "maybeTriggerManualPageSwitch", "skip, adapter is null", null);
        goto L129
    L117:
        int r25 = r24.getItemCount();
        int r26 = r23.getCurrentItem();
        if (r19 != ScrollDirection.Left) goto L120;
        int r27 = r26 + 1;
    L121:
        if (r27 < 0) goto L124;
        if (r27 >= r25) goto L124;
        boolean r110 = true;
    L126:
        if (r110 == true) goto L128;
        bwb.b.g(r18, "maybeTriggerManualPageSwitch", "skip, target out of bounds, currentItem=" + r26 + ", targetItem=" + r27 + ", pageCount=" + r25 + ", direction=" + r19, null, 8);
        goto L129
    L128:
        this.r = true;
        bwb.b.g(r18, "maybeTriggerManualPageSwitch", "trigger manual page switch, currentItem=" + r26 + ", targetItem=" + r27 + ", direction=" + r19 + ", dx=" + r22, null, 8);
        r23.setCurrentItem(r27, true);
    L124:
        r110 = false;
        goto L126
    L120:
        r27 = r26 - 1;
        goto L121
    L39:
        if (r12 != 2) goto L41;
        int r28 = this.i;
        if (r28 == (-1)) goto L136;
        int r29 = r20.findPointerIndex(r28);
        if (r29 >= 0) goto L55;
        int r30 = bwb.b.a;
        bwb.b.h(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "invalid pointerIndex, activePointerId=" + this.i, null);
        goto L136
    L55:
        float r31 = r20.getX(r29);
        float r32 = r20.getY(r29);
        this.l = r31;
        float r33 = r31 - this.j;
        float r34 = r32 - this.k;
        float r111 = Math.abs(r33);
        float r112 = Math.abs(r34);
        if (this.m != GestureOrientation.Unknown) goto L74;
        float r35 = this.a;
        if (r111 > r35) goto L63;
        if (r112 <= r35) goto L136;
    L63:
        if (r112 > r35) goto L65;
    L67:
        if (r111 <= r35) goto L136;
        if (r111 <= (r112 * this.b)) goto L136;
        this.m = GestureOrientation.Horizontal;
        int r36 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "horizontal gesture locked, gestureSession=" + this.g + ", dx=" + r33 + ", dy=" + r34 + ", ratio=" + this.b, null, 8);
        goto L74
    L65:
        if (r112 <= (this.b * r111)) goto L67;
        this.m = GestureOrientation.Vertical;
        int r37 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "vertical gesture locked, gestureSession=" + this.g + ", dx=" + r33 + ", dy=" + r34 + ", ratio=" + this.b, null, 8);
    L74:
        if (this.m != GestureOrientation.Horizontal) goto L136;
        if (r33 >= 0.0f) goto L79;
        final ScrollDirection r38 = ScrollDirection.Left;
    L81:
        if (r38 == this.n) goto L84;
        int r39 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "direction changed, gestureSession=" + this.g + ", old=" + this.n + ", new=" + r38 + ", x=" + r31 + ", y=" + r32, null, 8);
        this.n = r38;
        this.o = null;
        this.p = null;
    L84:
        if (this.o != null) goto L136;
        if (this.p == r38) goto L136;
        final int r40 = this.h + 1;
        this.h = r40;
        final int r41 = this.g;
        this.p = r38;
        int r42 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "request child canScroll, gestureSession=" + r41 + ", request=" + r40 + ", direction=" + r38 + ", startX=" + ((int) this.j) + ", startY=" + ((int) this.k) + ", currentX=" + ((int) r31) + ", currentY=" + ((int) r32) + ", childTag=" + this.e, null, 8);
        r4.a(r38, (int) this.j, (int) this.k, new MmViewPagerGestureArbiterLayout$handleTouchEvent$1(r41, this, r40, r38));
        goto L136
    L79:
        r38 = ScrollDirection.Right;
        goto L81
    L41:
        if (r12 != 3) goto L43;
        int r43 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_CANCEL", "gestureSession=" + this.g, null, 8);
        a();
        goto L136
    L43:
        if (r12 != 6) goto L136;
        int r44 = r20.getPointerId(r20.getActionIndex());
        if (r44 != this.i) goto L136;
        int r45 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_POINTER_UP", "active pointer released, pointerId=" + r44, null, 8);
        this.i = -1;
        goto L136
    L24:
        r10 = "ACTION_POINTER_UP";
        goto L29
    L25:
        r10 = "ACTION_CANCEL";
        goto L29
    L26:
        r10 = "ACTION_MOVE";
        goto L29
    L27:
        r10 = "ACTION_UP";
        goto L29
    L28:
        r10 = "ACTION_DOWN";
        goto L29
    L14:
        if (r4.isActive() != true) goto L16;
        r7 = true;
        goto L17
    }

    public final void b(boolean r6, String r7) {
        ViewPager2 r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r8 = !r6;
        if (r0.isUserInputEnabled() != r8) goto L8;
        return;
    L8:
        int r1 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "syncViewPagerUserInputEnabled", "reason=" + r7 + ", enabled=" + r8, null, 8);
        r0.setUserInputEnabled(r8);
    }

    public MmViewPagerGestureArbiterLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        int r5 = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.a = r5;
        this.b = 1.2f;
        this.c = r5 * 2;
        this.e = "unset";
        this.i = -1;
        this.m = GestureOrientation.Unknown;
    }

    public /* synthetic */ MmViewPagerGestureArbiterLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
