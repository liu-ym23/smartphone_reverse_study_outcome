package com.larus.common_ui.photoviewer.circular;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class LooperHorizontalLinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public final boolean a;
    public int b;
    public d c;
    public OrientationHelper d;
    public final boolean e;
    public int f;
    public int g;
    public SavedState h;
    public final b i;
    public final c j;
    public final int k;
    public final int[] l;
    public final ViewBoundsCheck m;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int a;
        public int b;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r2) {
                return new SavedState(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public SavedState() {
        }

        public SavedState(Parcel r2) {
            this.a = r2.readInt();
            this.b = r2.readInt();
        }

        public SavedState(SavedState r2) {
            this.a = r2.a;
            this.b = r2.b;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.a);
            r1.writeInt(this.b);
        }
    }

    public class a implements ViewBoundsCheck.b {
        public final /* synthetic */ LooperHorizontalLinearLayoutManager a;

        public a(LooperHorizontalLinearLayoutManager r1) {
            this.a = r1;
        }
    }

    public static class b {
        public OrientationHelper a;
        public int b;
        public int c;
        public boolean d;

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mValid=" + this.d + '}';
        }

        public b() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
        }

        public final void a(View r4, int r5) {
            int r0 = this.a.getTotalSpaceChange();
            if (r0 < 0) goto L6;
            this.c = this.a.getDecoratedStart(r4);
            this.b = r5;
            return;
        L6:
            this.b = r5;
            int r6 = this.a.getDecoratedStart(r4);
            int r1 = r6 - this.a.getStartAfterPadding();
            this.c = r6;
            if (r1 <= 0) goto L12;
            int r7 = (this.a.getEndAfterPadding() - Math.min(0, (this.a.getEndAfterPadding() - r0) - this.a.getDecoratedEnd(r4))) - (r6 + this.a.getDecoratedMeasurement(r4));
            if (r7 >= 0) goto L13;
            this.c -= Math.min(r1, -r7);
            return;
        L13:
            return;
        }
    }

    public static class c {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        public c() {
        }
    }

    public static class d {
        public boolean a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;

        public d() {
            this.a = true;
            this.h = 0;
            this.i = 0;
        }
    }

    public LooperHorizontalLinearLayoutManager() {
        throw null;
    }

    public final boolean canScrollHorizontally() {
        return true;
    }

    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    public final void ensureLayoutState() {
        if (this.c != null) goto L6;
        this.c = new d();
        return;
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final Parcelable onSaveInstanceState() {
        if (this.h != null) goto L5;
        SavedState r0 = new SavedState();
        if (getChildCount() <= 0) goto L9;
        ensureLayoutState();
        View r1 = getChildAt(0);
        r0.a = getPosition(r1);
        r0.b = this.d.getDecoratedStart(r1) - this.d.getStartAfterPadding();
    L10:
        return r0;
    L9:
        r0.a = -1;
        goto L10
    L5:
        return new SavedState(this.h);
    }

    public final boolean supportsPredictiveItemAnimations() {
        if (this.h != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void assertNotInLayoutOrScroll(String r2) {
        if (this.h != null) goto L6;
        super.assertNotInLayoutOrScroll(r2);
        return;
    }

    public final int computeHorizontalScrollExtent(RecyclerView.State r1) {
        return computeScrollExtent(r1);
    }

    public final int computeHorizontalScrollOffset(RecyclerView.State r1) {
        return computeScrollOffset(r1);
    }

    public final int computeHorizontalScrollRange(RecyclerView.State r1) {
        return computeScrollRange(r1);
    }

    public final int computeScrollExtent(RecyclerView.State r8) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        ensureLayoutState();
        OrientationHelper r0 = this.d;
        View r2 = findOneVisibleChild(0, getChildCount(), !this.e, true);
        View r4 = findOneVisibleChild(getChildCount() - 1, -1, !this.e, true);
        boolean r5 = this.e;
        if (getChildCount() != 0) goto L8;
        return 0;
    L8:
        if (r8.getItemCount() == 0) goto L17;
        if (r2 == null) goto L18;
        if (r4 == null) goto L20;
        if (r5 == true) goto L15;
        return Math.abs(getPosition(r2) - getPosition(r4)) + 1;
    L15:
        return Math.min(r0.getTotalSpace(), r0.getDecoratedEnd(r4) - r0.getDecoratedStart(r2));
    L20:
        return 0;
    L18:
        return 0;
    L17:
        return 0;
    }

    public final int computeScrollOffset(RecyclerView.State r9) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        ensureLayoutState();
        OrientationHelper r0 = this.d;
        View r2 = findOneVisibleChild(0, getChildCount(), !this.e, true);
        View r4 = findOneVisibleChild(getChildCount() - 1, -1, !this.e, true);
        boolean r5 = this.e;
        if (getChildCount() != 0) goto L8;
        return 0;
    L8:
        if (r9.getItemCount() == 0) goto L18;
        if (r2 == null) goto L19;
        if (r4 == null) goto L20;
        int r10 = Math.min(getPosition(r2), getPosition(r4));
        Math.max(getPosition(r2), getPosition(r4));
        int r1 = Math.max(0, r10);
        if (r5 == true) goto L16;
        return r1;
    L16:
        return Math.round((r1 * (Math.abs(r0.getDecoratedEnd(r4) - r0.getDecoratedStart(r2)) / (Math.abs(getPosition(r2) - getPosition(r4)) + 1))) + (r0.getStartAfterPadding() - r0.getDecoratedStart(r2)));
    L20:
        return 0;
    L19:
        return 0;
    L18:
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State r8) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        ensureLayoutState();
        OrientationHelper r0 = this.d;
        View r2 = findOneVisibleChild(0, getChildCount(), !this.e, true);
        View r4 = findOneVisibleChild(getChildCount() - 1, -1, !this.e, true);
        boolean r5 = this.e;
        if (getChildCount() != 0) goto L8;
        return 0;
    L8:
        if (r8.getItemCount() == 0) goto L17;
        if (r2 == null) goto L18;
        if (r4 == null) goto L20;
        if (r5 == true) goto L15;
        return r8.getItemCount();
    L15:
        return (int) (((r0.getDecoratedEnd(r4) - r0.getDecoratedStart(r2)) / (Math.abs(getPosition(r2) - getPosition(r4)) + 1)) * r8.getItemCount());
    L20:
        return 0;
    L18:
        return 0;
    L17:
        return 0;
    }

    public final PointF computeScrollVectorForPosition(int r3) {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        if (r3 >= getPosition(getChildAt(0))) goto L9;
        int r4 = -1;
    L11:
        if (this.b != 0) goto L15;
        return new PointF(r4, 0.0f);
    L15:
        return new PointF(0.0f, r4);
    L9:
        r4 = 1;
        goto L11
    }

    public final int computeVerticalScrollExtent(RecyclerView.State r1) {
        return computeScrollExtent(r1);
    }

    public final int computeVerticalScrollOffset(RecyclerView.State r1) {
        return computeScrollOffset(r1);
    }

    public final int computeVerticalScrollRange(RecyclerView.State r1) {
        return computeScrollRange(r1);
    }

    public final View findViewByPosition(int r3) {
        int r0 = getChildCount();
        if (r0 != 0) goto L6;
        return null;
    L6:
        int r1 = r3 - getPosition(getChildAt(0));
        if (r1 < 0) goto L13;
        if (r1 >= r0) goto L13;
        View r2 = getChildAt(r1);
        if (getPosition(r2) != r3) goto L13;
        return r2;
    L13:
        return super.findViewByPosition(r3);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        if (getChildCount() <= 0) goto L14;
        View r0 = findOneVisibleChild(0, getChildCount(), false, true);
        int r3 = -1;
        if (r0 != null) goto L7;
        int r1 = -1;
    L8:
        r5.setFromIndex(r1);
        View r2 = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (r2 == null) goto L12;
        r3 = getPosition(r2);
    L12:
        r5.setToIndex(r3);
        return;
    L7:
        r1 = getPosition(r0);
        goto L8
    }

    public final void onLayoutCompleted(RecyclerView.State r3) {
        super.onLayoutCompleted(r3);
        this.h = null;
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        b r1 = this.i;
        r1.b = -1;
        r1.c = Integer.MIN_VALUE;
        r1.d = false;
    }

    public final void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof SavedState) == false) goto L9;
        SavedState r4 = (SavedState) r3;
        this.h = r4;
        if (this.f == (-1)) goto L7;
        r4.a = -1;
    L7:
        requestLayout();
        return;
    }

    public final void scrollToPosition(int r2) {
        this.f = r2;
        this.g = Integer.MIN_VALUE;
        SavedState r3 = this.h;
        if (r3 == null) goto L5;
        r3.a = -1;
    L5:
        requestLayout();
    }

    public final void calculateExtraLayoutSpace(RecyclerView.State r4, int[] r5) {
        if (r4.hasTargetScrollPosition() == false) goto L5;
        int r6 = this.d.getTotalSpace();
    L7:
        if (this.c.f != (-1)) goto L9;
        int r1 = 0;
    L10:
        r5[0] = r6;
        r5[1] = r1;
        return;
    L9:
        r1 = r6;
        r6 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L7
    }

    public final void collectInitialPrefetchPositions(int r5, RecyclerView.LayoutManager.LayoutPrefetchRegistry r6) {
        SavedState r0 = this.h;
        if (r0 == null) goto L10;
        int r1 = r0.a;
        if (r1 < 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
    L13:
        int r3 = 0;
    L15:
        if (r3 >= this.k) goto L24;
        if (r1 < 0) goto L19;
        if (r1 >= r5) goto L23;
        r6.addPosition(r1, 0);
        r1 = r1 + 1;
        r3 = r3 + 1;
        goto L15
    L23:
        return;
    L19:
        return;
    L24:
        return;
    L7:
        r2 = false;
    L10:
        r1 = this.f;
        if (r1 != (-1)) goto L13;
        r1 = 0;
        goto L13
    }

    public final View findOnePartiallyOrCompletelyInvisibleChild(int r4, int r5) {
        ensureLayoutState();
        if (r5 <= r4) goto L5;
        byte r0 = 1;
    L8:
        if (r0 != 0) goto L12;
        return getChildAt(r4);
    L12:
        if (this.d.getDecoratedStart(getChildAt(r4)) >= this.d.getStartAfterPadding()) goto L14;
        int r1 = 16644;
        int r2 = 16388;
    L16:
        return this.m.a(r4, r5, r1, r2);
    L14:
        r1 = 4161;
        r2 = 4097;
        goto L16
    L5:
        if (r5 >= r4) goto L7;
        r0 = -1;
        goto L8
    L7:
        r0 = 0;
        goto L8
    }

    public final void onDetachedFromWindow(RecyclerView r1, RecyclerView.Recycler r2) {
        super.onDetachedFromWindow(r1, r2);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r17, RecyclerView.State r18) {
        if (this.h != null) goto L7;
        if (this.f != (-1)) goto L7;
    L10:
        SavedState r3 = this.h;
        if (r3 == null) goto L18;
        int r4 = r3.a;
        if (r4 < 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        this.f = r4;
        goto L18
    L15:
        r7 = false;
    L18:
        ensureLayoutState();
        this.c.a = false;
        View r5 = getFocusedChild();
        b r8 = this.i;
        if (r8.d == true) goto L21;
    L32:
        r8.b = -1;
        r8.c = Integer.MIN_VALUE;
        r8.d = false;
        if (r18.isPreLayout() == true) goto L70;
        int r6 = this.f;
        if (r6 == (-1)) goto L70;
        if (r6 >= 0) goto L39;
    L69:
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        goto L70
    L39:
        if (r6 >= r18.getItemCount()) goto L69;
        int r9 = this.f;
        r8.b = r9;
        SavedState r10 = this.h;
        if (r10 == null) goto L50;
        if (r10.a < 0) goto L46;
        boolean r11 = true;
    L47:
        if (r11 == false) goto L50;
        r8.c = this.d.getStartAfterPadding() + this.h.b;
    L68:
        boolean r12 = true;
    L71:
        if (r12 == false) goto L74;
    L140:
        char r13 = 1;
        this.i.d = true;
    L141:
        d r14 = this.c;
        if (r14.j < 0) goto L144;
        int r15 = 1;
    L145:
        r14.f = r15;
        int[] r16 = this.l;
        r16[0] = 0;
        r16[r13] = 0;
        calculateExtraLayoutSpace(r18, r16);
        int r20 = Math.max(0, this.l[0]) + this.d.getStartAfterPadding();
        int r21 = Math.max(0, this.l[r13]) + this.d.getEndPadding();
        if (r18.isPreLayout() == false) goto L157;
        int r22 = this.f;
        if (r22 == (-1)) goto L157;
        if (this.g == Integer.MIN_VALUE) goto L157;
        View r23 = findViewByPosition(r22);
        if (r23 == null) goto L157;
        int r24 = this.g - (this.d.getDecoratedStart(r23) - this.d.getStartAfterPadding());
        if (r24 <= 0) goto L156;
        r20 = r20 + r24;
        goto L157
    L156:
        r21 = r21 - r24;
    L157:
        detachAndScrapAttachedViews(r17);
        d r25 = this.c;
        if (this.d.getMode() == 0) goto L160;
    L162:
        boolean r26 = false;
    L163:
        r25.k = r26;
        d r27 = this.c;
        r18.isPreLayout();
        r27.getClass();
        d r28 = this.c;
        r28.i = 0;
        b r30 = this.i;
        int r31 = r30.b;
        int r32 = r30.c;
        r28.c = this.d.getEndAfterPadding() - r32;
        d r33 = this.c;
        r33.e = 1;
        r33.d = r31;
        r33.f = 1;
        r33.b = r32;
        r33.g = Integer.MIN_VALUE;
        r33.h = r21;
        p(r17, r33, r18, false);
        d r34 = this.c;
        int r35 = r34.b;
        int r36 = r34.d;
        int r37 = r34.c;
        if (r37 <= 0) goto L166;
        r20 = r20 + r37;
    L166:
        b r38 = this.i;
        int r40 = r38.b;
        int r41 = r38.c;
        r34.c = r41 - this.d.getStartAfterPadding();
        d r42 = this.c;
        r42.e = -1;
        r42.f = -1;
        r42.b = r41;
        r42.g = Integer.MIN_VALUE;
        r42.h = r20;
        r42.d = r40 - 1;
        p(r17, r42, r18, false);
        d r43 = this.c;
        int r44 = r43.b;
        int r45 = r43.c;
        if (r45 <= 0) goto L170;
        r43.c = this.d.getEndAfterPadding() - r35;
        d r46 = this.c;
        r46.e = 1;
        r46.d = r36;
        r46.f = 1;
        r46.b = r35;
        r46.g = Integer.MIN_VALUE;
        r46.h = r45;
        p(r17, r46, r18, false);
        r35 = this.c.b;
    L170:
        if (getChildCount() <= 0) goto L181;
        int r47 = r44 - this.d.getStartAfterPadding();
        if (r47 <= 0) goto L176;
        int r48 = -scrollBy(r47, r17, r18);
        int r50 = (r44 + r48) - this.d.getStartAfterPadding();
        if (r50 <= 0) goto L177;
        this.d.offsetChildren(-r50);
        r48 = r48 - r50;
    L177:
        int r51 = this.d.getEndAfterPadding() - (r35 + r48);
        if (r51 <= 0) goto L181;
        scrollBy(-r51, r17, r18);
        goto L181
    L176:
        r48 = 0;
    L181:
        if (r18.isPreLayout() == true) goto L183;
        this.d.onLayoutComplete();
        return;
    L183:
        b r1 = this.i;
        r1.b = -1;
        r1.c = Integer.MIN_VALUE;
        r1.d = false;
        return;
    L160:
        if (this.d.getEnd() != 0) goto L162;
        r26 = true;
        goto L163
    L144:
        r15 = -1;
        goto L145
    L74:
        if (getChildCount() == 0) goto L136;
        View r52 = getFocusedChild();
        if (r52 == null) goto L88;
        r8.getClass();
        RecyclerView.LayoutParams r53 = r52.getLayoutParams();
        if (r53.isItemRemoved() == false) goto L81;
    L85:
        boolean r54 = false;
    L86:
        if (r54 == false) goto L88;
        r8.a(r52, getPosition(r52));
    L135:
        boolean r55 = true;
    L137:
        if (r55 == true) goto L140;
        r8.c = r8.a.getStartAfterPadding();
        r8.b = 0;
        goto L140
    L81:
        if (r53.getViewLayoutPosition() < 0) goto L85;
        if (r53.getViewLayoutPosition() >= r18.getItemCount()) goto L85;
        r54 = true;
    L88:
        ensureLayoutState();
        int r56 = getChildCount();
        int r57 = r18.getItemCount();
        int r110 = this.d.getStartAfterPadding();
        int r111 = this.d.getEndAfterPadding();
        View r112 = null;
        View r113 = null;
        View r114 = null;
        int r115 = 0;
    L89:
        if (r115 == r56) goto L112;
        View r58 = getChildAt(r115);
        int r60 = getPosition(r58);
        int r61 = this.d.getDecoratedStart(r58);
        int r62 = this.d.getDecoratedEnd(r58);
        if (r60 < 0) goto L111;
        if (r60 >= r57) goto L111;
        if (r58.getLayoutParams().isItemRemoved() == false) goto L97;
        if (r114 != null) goto L111;
        r114 = r58;
        goto L111
    L97:
        if (r62 > r110) goto L100;
        if (r61 >= r110) goto L100;
        boolean r63 = true;
    L101:
        if (r61 < r111) goto L104;
        if (r62 <= r111) goto L104;
        boolean r64 = true;
    L105:
        if (r63 == true) goto L107;
        if (r64 == true) goto L107;
    L118:
        if (r58 == null) goto L136;
        int r65 = getPosition(r58);
        r8.c = r8.a.getDecoratedStart(r58);
        r8.b = r65;
        if (r18.isPreLayout() == true) goto L135;
        if (supportsPredictiveItemAnimations() == false) goto L135;
        int r66 = this.d.getDecoratedStart(r58);
        int r67 = this.d.getDecoratedEnd(r58);
        int r68 = this.d.getStartAfterPadding();
        int r70 = this.d.getEndAfterPadding();
        if (r67 > r68) goto L127;
        if (r66 >= r68) goto L127;
        boolean r71 = true;
    L128:
        if (r66 < r70) goto L131;
        if (r67 <= r70) goto L131;
        boolean r72 = true;
    L132:
        if (r71 == true) goto L134;
        if (r72 == false) goto L135;
    L134:
        r8.c = r68;
    L131:
        r72 = false;
    L127:
        r71 = false;
    L107:
        if (r63 == false) goto L109;
        r113 = r58;
        goto L111
    L109:
        if (r112 != null) goto L111;
        r112 = r58;
    L104:
        r64 = false;
    L100:
        r63 = false;
    L111:
        r115 = r115 + 1;
        goto L89
    L112:
        if (r112 != null) goto L117;
        if (r113 == null) goto L116;
        r112 = r113;
        goto L117
    L116:
        r112 = r114;
    L117:
        r58 = r112;
    L136:
        r55 = false;
        goto L137
    L46:
        r11 = false;
    L50:
        if (this.g != Integer.MIN_VALUE) goto L67;
        View r73 = findViewByPosition(r9);
        if (r73 == null) goto L64;
        if (this.d.getDecoratedMeasurement(r73) <= this.d.getTotalSpace()) goto L57;
        r8.c = r8.a.getStartAfterPadding();
        goto L68
    L57:
        if ((this.d.getDecoratedStart(r73) - this.d.getStartAfterPadding()) >= 0) goto L60;
        r8.c = this.d.getStartAfterPadding();
        goto L68
    L60:
        if ((this.d.getEndAfterPadding() - this.d.getDecoratedEnd(r73)) >= 0) goto L62;
        r8.c = this.d.getEndAfterPadding();
        goto L68
    L62:
        r8.c = this.d.getDecoratedStart(r73);
        goto L68
    L64:
        if (getChildCount() <= 0) goto L66;
        getPosition(getChildAt(0));
    L66:
        r8.c = r8.a.getStartAfterPadding();
        goto L68
    L67:
        r8.c = this.d.getStartAfterPadding() + this.g;
    L70:
        r12 = false;
        goto L71
    L21:
        if (this.f != (-1)) goto L32;
        if (this.h != null) goto L32;
        if (r5 != null) goto L27;
    L31:
        r13 = 1;
        goto L141
    L27:
        if (this.d.getDecoratedStart(r5) < this.d.getEndAfterPadding()) goto L29;
    L30:
        this.i.a(r5, getPosition(r5));
        goto L31
    L29:
        if (this.d.getDecoratedEnd(r5) > this.d.getStartAfterPadding()) goto L31;
    L7:
        if (r18.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r17);
    }

    public final void q(RecyclerView.Recycler r7, d r8) {
        if (r8.a == true) goto L5;
        return;
    L5:
        if (r8.k == true) goto L57;
        int r0 = r8.g;
        int r1 = r8.i;
        if (r8.f != (-1)) goto L28;
        int r9 = getChildCount();
        if (r0 < 0) goto L58;
        int r3 = (this.d.getEnd() - r0) + r1;
        int r10 = r9 - 1;
        int r2 = r10;
    L13:
        if (r2 < 0) goto L62;
        View r4 = getChildAt(r2);
        if (this.d.getDecoratedStart(r4) < r3) goto L20;
        if (this.d.getTransformedStartWithDecoration(r4) < r3) goto L20;
        r2 = r2 - 1;
    L20:
        if (r10 == r2) goto L59;
        if (r2 <= r10) goto L26;
        int r5 = r2 - 1;
    L24:
        if (r5 < r10) goto L63;
        removeAndRecycleViewAt(r5, r7);
        r5 = r5 - 1;
        goto L24
    L63:
        return;
    L26:
        if (r10 <= r2) goto L64;
        removeAndRecycleViewAt(r10, r7);
        r10 = r10 - 1;
        goto L26
    L64:
        return;
    L59:
        return;
    L62:
        return;
    L58:
        return;
    L28:
        if (r0 < 0) goto L60;
        int r6 = r0 - r1;
        int r11 = getChildCount();
        int r12 = 0;
        int r13 = 0;
    L31:
        if (r13 >= r11) goto L65;
        View r14 = getChildAt(r13);
        if (this.d.getDecoratedEnd(r14) > r6) goto L38;
        if (this.d.getTransformedEndWithDecoration(r14) > r6) goto L38;
        r13 = r13 + 1;
    L38:
        if (r13 == 0) goto L61;
        if (r13 <= 0) goto L44;
        int r15 = r13 - 1;
    L42:
        if (r15 < 0) goto L66;
        removeAndRecycleViewAt(r15, r7);
        r15 = r15 - 1;
        goto L42
    L66:
        return;
    L44:
        if (r12 <= r13) goto L67;
        removeAndRecycleViewAt(r12, r7);
        r12 = r12 - 1;
        goto L44
    L67:
        return;
    L61:
        return;
    L65:
        return;
    L60:
        return;
    }

    public final int scrollBy(int r6, RecyclerView.Recycler r7, RecyclerView.State r8) {
        if (getChildCount() == 0) goto L17;
        if (r6 == 0) goto L17;
        ensureLayoutState();
        this.c.a = true;
        if (r6 <= 0) goto L9;
        int r0 = 1;
    L10:
        int r3 = Math.abs(r6);
        updateLayoutState(r0, r3, true, r8);
        d r2 = this.c;
        int r4 = r2.g + p(r7, r2, r8, false);
        if (r4 >= 0) goto L13;
        return 0;
    L13:
        if (r3 <= r4) goto L15;
        r6 = r0 * r4;
    L15:
        this.d.offsetChildren(-r6);
        this.c.j = r6;
        return r6;
    L9:
        r0 = -1;
    L17:
        return 0;
    }

    public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return scrollBy(r1, r2, r3);
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        LinearSmoothScroller r4 = new LinearSmoothScroller(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }

    public LooperHorizontalLinearLayoutManager(Context r5, AttributeSet r6, int r7, int r8) {
        this.a = true;
        this.b = 0;
        this.e = true;
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.h = null;
        b r1 = new b();
        this.i = r1;
        this.j = new c();
        this.k = 2;
        this.l = new int[2];
        this.m = new ViewBoundsCheck(new a(this));
        int r9 = RecyclerView.LayoutManager.getProperties(r5, r6, r7, r8).orientation;
        assertNotInLayoutOrScroll(null);
        if (r9 == this.b) goto L5;
    L6:
        OrientationHelper r10 = OrientationHelper.createOrientationHelper(this, r9);
        this.d = r10;
        r1.a = r10;
        this.b = r9;
        requestLayout();
        return;
    L5:
        if (this.d == null) goto L6;
    }

    public final void collectAdjacentPrefetchPositions(int r2, int r3, RecyclerView.State r4, RecyclerView.LayoutManager.LayoutPrefetchRegistry r5) {
        if (getChildCount() == 0) goto L16;
        if (r2 == 0) goto L19;
        ensureLayoutState();
        if (r2 <= 0) goto L9;
        int r0 = 1;
    L10:
        updateLayoutState(r0, Math.abs(r2), true, r4);
        d r6 = this.c;
        int r7 = r6.d;
        if (r7 >= 0) goto L13;
        return;
    L13:
        if (r7 >= r4.getItemCount()) goto L18;
        r5.addPosition(r7, Math.max(0, r6.g));
        return;
    L18:
        return;
    L9:
        r0 = -1;
        goto L10
    L19:
        return;
    }

    public final View findOneVisibleChild(int r2, int r3, boolean r4, boolean r5) {
        ensureLayoutState();
        if (r4 == false) goto L5;
        int r6 = 24579;
    L7:
        return this.m.a(r2, r3, r6, 320);
    L5:
        r6 = 320;
        goto L7
    }

    public final View onFocusSearchFailed(View r6, int r7, RecyclerView.Recycler r8, RecyclerView.State r9) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        if (r7 != 1) goto L8;
    L15:
        int r10 = -1;
    L16:
        if (r10 != Integer.MIN_VALUE) goto L18;
        return null;
    L18:
        ensureLayoutState();
        updateLayoutState(r10, (int) (this.d.getTotalSpace() * 0.33333334f), false, r9);
        d r3 = this.c;
        r3.g = Integer.MIN_VALUE;
        r3.a = false;
        p(r8, r3, r9, true);
        if (r10 != (-1)) goto L21;
        View r11 = findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    L22:
        if (r10 != (-1)) goto L24;
        View r12 = getChildAt(0);
    L26:
        if (r12.hasFocusable() == false) goto L30;
        if (r11 != null) goto L29;
        return null;
    L29:
        return r12;
    L30:
        return r11;
    L24:
        r12 = getChildAt(getChildCount() - 1);
        goto L26
    L21:
        r11 = findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
        goto L22
    L8:
        if (r7 != 2) goto L10;
    L14:
        r10 = 1;
        goto L16
    L10:
        if (r7 == 17) goto L15;
        if (r7 == 66) goto L14;
        r10 = Integer.MIN_VALUE;
        goto L16
    }

    public final int p(RecyclerView.Recycler r17, d r18, RecyclerView.State r110, boolean r20) {
        int r8 = r18.c;
        int r0 = r18.g;
        if (r0 == Integer.MIN_VALUE) goto L7;
        if (r8 >= 0) goto L6;
        r18.g = r0 + r8;
    L6:
        q(r17, r18);
    L7:
        int r1 = r18.c + r18.h;
        c r10 = this.j;
        int r11 = r1;
    L9:
        if (r18.k == true) goto L11;
        if (r11 > 0) goto L11;
    L53:
        return r8 - r18.c;
    L11:
        int r2 = r18.d;
        if (r2 >= 0) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L53;
        r10.a = 0;
        r10.b = false;
        r10.c = false;
        r10.d = false;
        View r14 = r17.getViewForPosition(r18.d);
        r18.d += r18.e;
        if (r14 != null) goto L21;
        r10.b = true;
    L36:
        if (r10.b == true) goto L53;
        r18.b += r10.a * r18.f;
        if (r10.c == true) goto L41;
    L42:
        int r4 = r18.c;
        int r5 = r10.a;
        r18.c = r4 - r5;
        r11 = r11 - r5;
    L43:
        int r6 = r18.g;
        if (r6 == Integer.MIN_VALUE) goto L49;
        int r7 = r6 + r10.a;
        r18.g = r7;
        int r9 = r18.c;
        if (r9 >= 0) goto L48;
        r18.g = r7 + r9;
    L48:
        q(r17, r18);
    L49:
        if (r20 == false) goto L9;
        if (r10.d == false) goto L9;
    L41:
        if (r110.isPreLayout() == true) goto L43;
    L21:
        RecyclerView.LayoutParams r15 = r14.getLayoutParams();
        if (r18.f == (-1)) goto L24;
        addView(r14);
    L25:
        measureChildWithMargins(r14, 0, 0);
        r10.a = this.d.getDecoratedMeasurement(r14);
        int r12 = getPaddingTop();
        int r13 = r12 + this.d.getDecoratedMeasurementInOther(r14);
        if (r18.f != (-1)) goto L28;
        int r16 = r18.b;
        int r21 = r16;
        int r22 = r16 - r10.a;
    L29:
        layoutDecoratedWithMargins(r14, r22, r12, r21, r13);
        if (r15.isItemRemoved() == false) goto L32;
    L33:
        r10.c = true;
    L34:
        r10.d = r14.hasFocusable();
        goto L36
    L32:
        if (r15.isItemChanged() == false) goto L34;
    L28:
        int r23 = r18.b;
        r22 = r23;
        r21 = r10.a + r23;
        goto L29
    L24:
        addView(r14, 0);
        goto L25
    L14:
        if (r2 >= r110.getItemCount()) goto L16;
        r3 = true;
        goto L17
    }

    public final void prepareForDrop(View r2, View r3, int r4, int r5) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        int r6 = getPosition(r2);
        int r7 = getPosition(r3);
        if (r6 >= r7) goto L5;
        byte r8 = 1;
    L6:
        if (r8 != (-1)) goto L11;
        int r9 = this.d.getDecoratedStart(r3);
        this.f = r7;
        this.g = r9;
        SavedState r10 = this.h;
        if (r10 == null) goto L10;
        r10.a = -1;
    L10:
        requestLayout();
        return;
    L11:
        int r11 = this.d.getDecoratedEnd(r3) - this.d.getDecoratedMeasurement(r2);
        this.f = r7;
        this.g = r11;
        SavedState r12 = this.h;
        if (r12 == null) goto L14;
        r12.a = -1;
    L14:
        requestLayout();
        return;
    L5:
        r8 = -1;
        goto L6
    }

    public final void updateLayoutState(int r6, int r7, boolean r8, RecyclerView.State r9) {
        d r0 = this.c;
        if (this.d.getMode() == 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r0.k = r1;
        this.c.f = r6;
        int[] r2 = this.l;
        r2[0] = 0;
        r2[1] = 0;
        calculateExtraLayoutSpace(r9, r2);
        int r10 = Math.max(0, this.l[0]);
        int r3 = Math.max(0, this.l[1]);
        if (r6 != 1) goto L11;
        boolean r11 = true;
    L12:
        d r4 = this.c;
        if (r11 == false) goto L15;
        int r5 = r3;
    L16:
        r4.h = r5;
        if (r11 == true) goto L20;
        r10 = r3;
    L20:
        r4.i = r10;
        if (r11 == false) goto L30;
        r4.h = r5 + this.d.getEndPadding();
        View r12 = getChildAt(getChildCount() - 1);
        d r13 = this.c;
        r13.e = 1;
        if (this.a == true) goto L25;
        r13.d = getPosition(r12) + this.c.e;
    L29:
        this.c.b = this.d.getDecoratedEnd(r12);
        int r14 = this.d.getDecoratedEnd(r12) - this.d.getEndAfterPadding();
    L38:
        d r15 = this.c;
        r15.c = r7;
        if (r8 == false) goto L41;
        r15.c = r7 - r14;
    L41:
        r15.g = r14;
        return;
    L25:
        if (getPosition(r12) != (getItemCount() - 1)) goto L27;
        this.c.d = 0;
        goto L29
    L27:
        this.c.d = getPosition(r12) + this.c.e;
        goto L29
    L30:
        View r16 = getChildAt(0);
        this.c.h += this.d.getStartAfterPadding();
        d r17 = this.c;
        r17.e = -1;
        if (this.a == true) goto L33;
        r17.d = getPosition(r16) + this.c.e;
    L37:
        this.c.b = this.d.getDecoratedStart(r16);
        r14 = (-this.d.getDecoratedStart(r16)) + this.d.getStartAfterPadding();
        goto L38
    L33:
        if (getPosition(r16) != 0) goto L35;
        this.c.d = getItemCount() - 1;
        goto L37
    L35:
        this.c.d = getPosition(r16) + this.c.e;
        goto L37
    L15:
        r5 = r10;
        goto L16
    L11:
        r11 = false;
        goto L12
    L5:
        if (this.d.getEnd() != 0) goto L7;
        r1 = true;
        goto L8
    }
}
