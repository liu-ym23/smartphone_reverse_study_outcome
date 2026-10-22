package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class StaggeredGridLayoutManager extends RecyclerView.h implements RecyclerView.r.b {
    private SavedState A;
    private int B;
    private final Rect C;
    private final a D;
    private boolean E;
    private boolean F;
    private int[] G;
    private final Runnable H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b[] f14100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    v f14101b;
    v c;
    boolean d;
    boolean e;
    int f;
    int g;
    LazySpanLookup h;
    private int i;
    private int j;
    private int k;
    private final o l;
    private BitSet m;
    private int n;
    private boolean o;
    private boolean z;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b f14102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f14103b;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }

        public boolean a() {
            return this.f14103b;
        }
    }

    static class LazySpanLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f14104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<FullSpanItem> f14105b;

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = null;
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            static {
                CREATOR = new AnonymousClass1();
            }

            FullSpanItem() {
            }

            FullSpanItem(Parcel r3) {
                this.mPosition = r3.readInt();
                this.mGapDir = r3.readInt();
                boolean r1 = true;
                if (r3.readInt() == 1) goto L6;
                r1 = false;
            L6:
                this.mHasUnwantedGapAfter = r1;
                int r0 = r3.readInt();
                if (r0 <= 0) goto L10;
                int[] r2 = new int[r0];
                this.mGapPerSpan = r2;
                r3.readIntArray(r2);
                return;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            int getGapForSpan(int r1) {
                int[] r0 = this.mGapPerSpan;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0[r1];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r2, int r3) {
                r2.writeInt(this.mPosition);
                r2.writeInt(this.mGapDir);
                r2.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] r4 = this.mGapPerSpan;
                if (r4 != null) goto L5;
            L7:
                r2.writeInt(0);
                return;
            L5:
                if (r4.length <= 0) goto L7;
                r2.writeInt(r4.length);
                r2.writeIntArray(this.mGapPerSpan);
            }
        }

        private void c(int r6, int r7) {
            List<FullSpanItem> r0 = this.f14105b;
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r6 + r7;
            int r2 = r0.size() - 1;
        L6:
            if (r2 < 0) goto L15;
            FullSpanItem r3 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f14105b.get(r2), FullSpanItem.class, "com.obric.memorydata.plugin");
            if (r3.mPosition < r6) goto L14;
            if (r3.mPosition >= r1) goto L13;
            this.f14105b.remove(r2);
            goto L14
        L13:
            r3.mPosition -= r7;
        L14:
            r2 = r2 - 1;
            goto L6
        }

        private void d(int r5, int r6) {
            List<FullSpanItem> r0 = this.f14105b;
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.size() - 1;
        L6:
            if (r1 < 0) goto L12;
            FullSpanItem r2 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f14105b.get(r1), FullSpanItem.class, "com.obric.memorydata.plugin");
            if (r2.mPosition < r5) goto L11;
            r2.mPosition += r6;
        L11:
            r1 = r1 - 1;
            goto L6
        }

        private int g(int r7) {
            if (this.f14105b != null) goto L5;
            return -1;
        L5:
            FullSpanItem r0 = f(r7);
            if (r0 == null) goto L8;
            this.f14105b.remove(r0);
        L8:
            int r1 = this.f14105b.size();
            int r2 = 0;
        L10:
            if (r2 >= r1) goto L15;
            if (((FullSpanItem) ZeusTransformUtils.preCheckCast(this.f14105b.get(r2), FullSpanItem.class, "com.obric.memorydata.plugin")).mPosition >= r7) goto L16;
            r2 = r2 + 1;
        L16:
            if (r2 == (-1)) goto L19;
            FullSpanItem r8 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f14105b.get(r2), FullSpanItem.class, "com.obric.memorydata.plugin");
            this.f14105b.remove(r2);
            return r8.mPosition;
        L19:
            return -1;
        L15:
            r2 = -1;
            goto L16
        }

        int a(int r5) {
            List<FullSpanItem> r0 = this.f14105b;
            if (r0 == null) goto L11;
            int r1 = r0.size() - 1;
        L5:
            if (r1 < 0) goto L11;
            if (((FullSpanItem) ZeusTransformUtils.preCheckCast(this.f14105b.get(r1), FullSpanItem.class, "com.obric.memorydata.plugin")).mPosition < r5) goto L9;
            this.f14105b.remove(r1);
        L9:
            r1 = r1 - 1;
        L11:
            return b(r5);
        }

        public FullSpanItem a(int r7, int r8, int r9, boolean r10) {
            List<FullSpanItem> r0 = this.f14105b;
            if (r0 != null) goto L5;
            return null;
        L5:
            int r1 = r0.size();
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L20;
            FullSpanItem r3 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f14105b.get(r2), FullSpanItem.class, "com.obric.memorydata.plugin");
            if (r3.mPosition >= r8) goto L9;
            if (r3.mPosition < r7) goto L19;
            if (r9 == 0) goto L18;
            if (r3.mGapDir == r9) goto L18;
            if (r10 == false) goto L19;
            if (r3.mHasUnwantedGapAfter == false) goto L19;
        L18:
            return r3;
        L19:
            r2 = r2 + 1;
            goto L6
        L9:
            return null;
        L20:
            return null;
        }

        void a() {
            int[] r0 = this.f14104a;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            this.f14105b = null;
        }

        void a(int r5, int r6) {
            int[] r0 = this.f14104a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r5 >= r0.length) goto L10;
            int r1 = r5 + r6;
            e(r1);
            int[] r2 = this.f14104a;
            System.arraycopy(r2, r1, r2, r5, (r2.length - r5) - r6);
            int[] r3 = this.f14104a;
            Arrays.fill(r3, r3.length - r6, r3.length, -1);
            c(r5, r6);
            return;
        }

        void a(int r1, b r2) {
            e(r1);
            this.f14104a[r1] = r2.e;
        }

        public void a(FullSpanItem r6) {
            if (this.f14105b != null) goto L5;
            this.f14105b = new ArrayList();
        L5:
            int r0 = this.f14105b.size();
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L15;
            FullSpanItem r2 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f14105b.get(r1), FullSpanItem.class, "com.obric.memorydata.plugin");
            if (r2.mPosition != r6.mPosition) goto L11;
            this.f14105b.remove(r1);
        L11:
            if (r2.mPosition >= r6.mPosition) goto L12;
            r1 = r1 + 1;
            goto L6
        L12:
            this.f14105b.add(r1, r6);
            return;
        L15:
            this.f14105b.add(r6);
        }

        int b(int r4) {
            int[] r0 = this.f14104a;
            if (r0 != null) goto L6;
            return -1;
        L6:
            if (r4 < r0.length) goto L8;
            return -1;
        L8:
            int r1 = g(r4);
            if (r1 != (-1)) goto L12;
            int[] r2 = this.f14104a;
            Arrays.fill(r2, r4, r2.length, -1);
            return this.f14104a.length;
        L12:
            int r3 = Math.min(r1 + 1, this.f14104a.length);
            Arrays.fill(this.f14104a, r4, r3, -1);
            return r3;
        }

        void b(int r4, int r5) {
            int[] r0 = this.f14104a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r4 >= r0.length) goto L10;
            int r1 = r4 + r5;
            e(r1);
            int[] r2 = this.f14104a;
            System.arraycopy(r2, r4, r2, r1, (r2.length - r4) - r5);
            Arrays.fill(this.f14104a, r4, r1, -1);
            d(r4, r5);
            return;
        }

        int c(int r2) {
            int[] r1 = this.f14104a;
            if (r1 != null) goto L5;
            return -1;
        L5:
            if (r2 < r1.length) goto L8;
            return -1;
        L8:
            return r1[r2];
        }

        int d(int r1) {
            int r0 = this.f14104a.length;
        L3:
            if (r0 > r1) goto L5;
            r0 = r0 * 2;
            goto L3
        L5:
            return r0;
        }

        void e(int r5) {
            int[] r0 = this.f14104a;
            if (r0 != null) goto L6;
            int[] r6 = new int[Math.max(r5, 10) + 1];
            this.f14104a = r6;
            Arrays.fill(r6, -1);
            return;
        L6:
            if (r5 < r0.length) goto L10;
            int[] r7 = new int[d(r5)];
            this.f14104a = r7;
            System.arraycopy(r0, 0, r7, 0, r0.length);
            int[] r4 = this.f14104a;
            Arrays.fill(r4, r0.length, r4.length, -1);
            return;
        }

        public FullSpanItem f(int r6) {
            List<FullSpanItem> r0 = this.f14105b;
            if (r0 != null) goto L5;
            return null;
        L5:
            int r1 = r0.size() - 1;
        L6:
            if (r1 < 0) goto L11;
            FullSpanItem r2 = (FullSpanItem) ZeusTransformUtils.preCheckCast(this.f14105b.get(r1), FullSpanItem.class, "com.obric.memorydata.plugin");
            if (r2.mPosition == r6) goto L9;
            r1 = r1 - 1;
            goto L6
        L9:
            return r2;
        L11:
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        SavedState(Parcel r4) {
            this.mAnchorPosition = r4.readInt();
            this.mVisibleAnchorPosition = r4.readInt();
            int r0 = r4.readInt();
            this.mSpanOffsetsSize = r0;
            if (r0 <= 0) goto L5;
            int[] r1 = new int[r0];
            this.mSpanOffsets = r1;
            r4.readIntArray(r1);
        L5:
            int r2 = r4.readInt();
            this.mSpanLookupSize = r2;
            if (r2 <= 0) goto L8;
            int[] r3 = new int[r2];
            this.mSpanLookup = r3;
            r4.readIntArray(r3);
        L8:
            boolean r5 = false;
            if (r4.readInt() != 1) goto L11;
            boolean r6 = true;
        L12:
            this.mReverseLayout = r6;
            if (r4.readInt() != 1) goto L15;
            boolean r7 = true;
        L16:
            this.mAnchorLayoutFromEnd = r7;
            if (r4.readInt() != 1) goto L19;
            r5 = true;
        L19:
            this.mLastLayoutRTL = r5;
            this.mFullSpanItems = r4.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
            return;
        L15:
            r7 = false;
            goto L16
        L11:
            r6 = false;
            goto L12
        }

        public SavedState(SavedState r2) {
            this.mSpanOffsetsSize = r2.mSpanOffsetsSize;
            this.mAnchorPosition = r2.mAnchorPosition;
            this.mVisibleAnchorPosition = r2.mVisibleAnchorPosition;
            this.mSpanOffsets = r2.mSpanOffsets;
            this.mSpanLookupSize = r2.mSpanLookupSize;
            this.mSpanLookup = r2.mSpanLookup;
            this.mReverseLayout = r2.mReverseLayout;
            this.mAnchorLayoutFromEnd = r2.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = r2.mLastLayoutRTL;
            this.mFullSpanItems = r2.mFullSpanItems;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.mAnchorPosition);
            r1.writeInt(this.mVisibleAnchorPosition);
            r1.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize <= 0) goto L5;
            r1.writeIntArray(this.mSpanOffsets);
        L5:
            r1.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize <= 0) goto L8;
            r1.writeIntArray(this.mSpanLookup);
        L8:
            r1.writeInt(this.mReverseLayout ? 1 : 0);
            r1.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            r1.writeInt(this.mLastLayoutRTL ? 1 : 0);
            r1.writeList(this.mFullSpanItems);
        }
    }

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14107b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;
        final /* synthetic */ StaggeredGridLayoutManager g;

        void a() {
            this.f14106a = -1;
            this.f14107b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] r2 = this.f;
            if (r2 == null) goto L6;
            Arrays.fill(r2, -1);
            return;
        }

        void a(int r2) {
            if (this.c == false) goto L5;
            int r0 = this.g.f14101b.d() - r2;
        L6:
            this.f14107b = r0;
            return;
        L5:
            r0 = this.g.f14101b.c() + r2;
            goto L6
        }

        void a(b[] r6) {
            int r0 = r6.length;
            int[] r1 = this.f;
            if (r1 != null) goto L5;
        L6:
            this.f = new int[this.g.f14100a.length];
        L7:
            int r2 = 0;
        L8:
            if (r2 >= r0) goto L10;
            this.f[r2] = r6[r2].a(Integer.MIN_VALUE);
            r2 = r2 + 1;
            goto L8
        L10:
            return;
        L5:
            if (r1.length >= r0) goto L7;
            goto L6
        }

        void b() {
            if (this.c == false) goto L5;
            int r0 = this.g.f14101b.d();
        L6:
            this.f14107b = r0;
            return;
        L5:
            r0 = this.g.f14101b.c();
            goto L6
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<View> f14108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14109b;
        int c;
        int d;
        final int e;
        final /* synthetic */ StaggeredGridLayoutManager f;

        int a(int r3) {
            int r0 = this.f14109b;
            if (r0 == Integer.MIN_VALUE) goto L6;
            return r0;
        L6:
            if (this.f14108a.size() != 0) goto L8;
            return r3;
        L8:
            a();
            return this.f14109b;
        }

        int a(int r7, int r8, boolean r9) {
            return a(r7, r8, false, false, r9);
        }

        int a(int r11, int r12, boolean r13, boolean r14, boolean r15) {
            int r0 = this.f.f14101b.c();
            int r1 = this.f.f14101b.d();
            if (r12 <= r11) goto L5;
            int r4 = 1;
        L6:
            if (r11 == r12) goto L33;
            View r5 = (View) ZeusTransformUtils.preCheckCast(this.f14108a.get(r11), View.class, "com.obric.memorydata.plugin");
            int r6 = this.f.f14101b.a(r5);
            int r7 = this.f.f14101b.b(r5);
            boolean r8 = false;
            if (r15 == false) goto L11;
            if (r6 <= r1) goto L12;
        L13:
            boolean r9 = false;
        L14:
            if (r15 == false) goto L17;
            if (r7 >= r0) goto L18;
        L19:
            if (r9 == false) goto L32;
            if (r8 == false) goto L32;
            if (r13 == false) goto L27;
            if (r14 == false) goto L27;
            if (r6 < r0) goto L32;
            if (r7 > r1) goto L32;
        L26:
            return this.f.d(r5);
        L27:
            if (r14 == true) goto L26;
            if (r6 < r0) goto L26;
            if (r7 > r1) goto L26;
        L32:
            r11 = r11 + r4;
        L18:
            r8 = true;
            goto L19
        L17:
            if (r7 <= r0) goto L19;
        L12:
            r9 = true;
            goto L14
        L11:
            if (r6 >= r1) goto L13;
        L33:
            return -1;
        L5:
            r4 = -1;
            goto L6
        }

        public View a(int r6, int r7) {
            View r2 = null;
            if (r7 != (-1)) goto L18;
            int r8 = this.f14108a.size();
            int r1 = 0;
        L5:
            if (r1 >= r8) goto L32;
            View r3 = (View) ZeusTransformUtils.preCheckCast(this.f14108a.get(r1), View.class, "com.obric.memorydata.plugin");
            if (this.f.d == false) goto L11;
            if (this.f.d(r3) <= r6) goto L32;
        L11:
            if (this.f.d == true) goto L16;
            if (this.f.d(r3) >= r6) goto L32;
        L16:
            if (r3.hasFocusable() == false) goto L32;
            r1 = r1 + 1;
            r2 = r3;
        L32:
            return r2;
        L18:
            int r9 = this.f14108a.size() - 1;
        L19:
            if (r9 < 0) goto L32;
            View r4 = (View) ZeusTransformUtils.preCheckCast(this.f14108a.get(r9), View.class, "com.obric.memorydata.plugin");
            if (this.f.d == false) goto L25;
            if (this.f.d(r4) >= r6) goto L32;
        L25:
            if (this.f.d == true) goto L30;
            if (this.f.d(r4) <= r6) goto L32;
        L30:
            if (r4.hasFocusable() == false) goto L32;
            r9 = r9 - 1;
            r2 = r4;
            goto L19
        }

        void a() {
            View r0 = (View) ZeusTransformUtils.preCheckCast(this.f14108a.get(0), View.class, "com.obric.memorydata.plugin");
            LayoutParams r1 = c(r0);
            this.f14109b = this.f.f14101b.a(r0);
            if (r1.f14103b == false) goto L10;
            LazySpanLookup.FullSpanItem r2 = this.f.h.f(r1.f());
            if (r2 != null) goto L7;
            return;
        L7:
            if (r2.mGapDir != (-1)) goto L12;
            this.f14109b -= r2.getGapForSpan(this.e);
            return;
        L12:
            return;
        }

        void a(View r5) {
            LayoutParams r0 = c(r5);
            r0.f14102a = this;
            this.f14108a.add(0, r5);
            this.f14109b = Integer.MIN_VALUE;
            if (this.f14108a.size() != 1) goto L6;
            this.c = Integer.MIN_VALUE;
        L6:
            if (r0.d() == false) goto L8;
        L9:
            this.d += this.f.f14101b.e(r5);
            return;
        L8:
            if (r0.e() == true) goto L9;
        }

        void a(boolean r4, int r5) {
            if (r4 == false) goto L5;
            int r1 = b(Integer.MIN_VALUE);
        L6:
            e();
            if (r1 != Integer.MIN_VALUE) goto L9;
            return;
        L9:
            if (r4 == true) goto L11;
        L12:
            if (r4 == false) goto L14;
        L16:
            if (r5 == Integer.MIN_VALUE) goto L18;
            r1 = r1 + r5;
        L18:
            this.c = r1;
            this.f14109b = r1;
            return;
        L14:
            if (r1 <= this.f.f14101b.c()) goto L16;
            return;
        L11:
            if (r1 >= this.f.f14101b.d()) goto L12;
            return;
        L5:
            r1 = a(Integer.MIN_VALUE);
            goto L6
        }

        int b() {
            int r0 = this.f14109b;
            if (r0 == Integer.MIN_VALUE) goto L5;
            return r0;
        L5:
            a();
            return this.f14109b;
        }

        int b(int r3) {
            int r0 = this.c;
            if (r0 == Integer.MIN_VALUE) goto L6;
            return r0;
        L6:
            if (this.f14108a.size() != 0) goto L8;
            return r3;
        L8:
            c();
            return this.c;
        }

        void b(View r5) {
            LayoutParams r0 = c(r5);
            r0.f14102a = this;
            this.f14108a.add(r5);
            this.c = Integer.MIN_VALUE;
            if (this.f14108a.size() != 1) goto L6;
            this.f14109b = Integer.MIN_VALUE;
        L6:
            if (r0.d() == false) goto L8;
        L9:
            this.d += this.f.f14101b.e(r5);
            return;
        L8:
            if (r0.e() == true) goto L9;
        }

        LayoutParams c(View r2) {
            return (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        }

        void c() {
            ArrayList<View> r0 = this.f14108a;
            View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), View.class, "com.obric.memorydata.plugin");
            LayoutParams r2 = c(r1);
            this.c = this.f.f14101b.b(r1);
            if (r2.f14103b == false) goto L10;
            LazySpanLookup.FullSpanItem r3 = this.f.h.f(r2.f());
            if (r3 != null) goto L7;
            return;
        L7:
            if (r3.mGapDir != 1) goto L12;
            this.c += r3.getGapForSpan(this.e);
            return;
        L12:
            return;
        }

        void c(int r1) {
            this.f14109b = r1;
            this.c = r1;
        }

        int d() {
            int r0 = this.c;
            if (r0 == Integer.MIN_VALUE) goto L5;
            return r0;
        L5:
            c();
            return this.c;
        }

        void d(int r3) {
            int r0 = this.f14109b;
            if (r0 == Integer.MIN_VALUE) goto L5;
            this.f14109b = r0 + r3;
        L5:
            int r1 = this.c;
            if (r1 == Integer.MIN_VALUE) goto L9;
            this.c = r1 + r3;
            return;
        }

        void e() {
            this.f14108a.clear();
            f();
            this.d = 0;
        }

        void f() {
            this.f14109b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        void g() {
            int r0 = this.f14108a.size();
            View r1 = (View) ZeusTransformUtils.preCheckCast(this.f14108a.remove(r0 - 1), View.class, "com.obric.memorydata.plugin");
            LayoutParams r2 = c(r1);
            r2.f14102a = null;
            if (r2.d() == false) goto L5;
        L6:
            this.d -= this.f.f14101b.e(r1);
        L8:
            if (r0 != 1) goto L10;
            this.f14109b = Integer.MIN_VALUE;
        L10:
            this.c = Integer.MIN_VALUE;
            return;
        L5:
            if (r2.e() == false) goto L8;
            goto L6
        }

        void h() {
            View r0 = (View) ZeusTransformUtils.preCheckCast(this.f14108a.remove(0), View.class, "com.obric.memorydata.plugin");
            LayoutParams r1 = c(r0);
            r1.f14102a = null;
            if (this.f14108a.size() != 0) goto L6;
            this.c = Integer.MIN_VALUE;
        L6:
            if (r1.d() == false) goto L8;
        L9:
            this.d -= this.f.f14101b.e(r0);
        L10:
            this.f14109b = Integer.MIN_VALUE;
            return;
        L8:
            if (r1.e() == false) goto L10;
            goto L9
        }

        public int i() {
            return this.d;
        }

        public int j() {
            if (this.f.d == false) goto L5;
            int r0 = this.f14108a.size() - 1;
            int r2 = -1;
        L7:
            return a(r0, r2, true);
        L5:
            r0 = 0;
            r2 = this.f14108a.size();
            goto L7
        }

        public int k() {
            if (this.f.d == false) goto L5;
            int r0 = 0;
            int r2 = this.f14108a.size();
        L7:
            return a(r0, r2, true);
        L5:
            r0 = this.f14108a.size() - 1;
            r2 = -1;
            goto L7
        }
    }

    private void N() {
        if (this.c.h() != 1073741824) goto L5;
        return;
    L5:
        float r0 = 0.0f;
        int r1 = x();
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L16;
        View r5 = i(r3);
        float r6 = this.c.e(r5);
        if (r6 < r0) goto L15;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).a() == false) goto L14;
        r6 = (r6 * 1.0f) / this.i;
    L14:
        r0 = Math.max(r0, r6);
    L15:
        r3 = r3 + 1;
        goto L7
    L16:
        int r4 = this.k;
        int r7 = Math.round(r0 * this.i);
        if (this.c.h() != Integer.MIN_VALUE) goto L19;
        r7 = Math.min(r7, this.c.f());
    L19:
        a(r7);
        if (this.k != r4) goto L22;
        return;
    L22:
        if (r2 >= r1) goto L36;
        View r8 = i(r2);
        LayoutParams r9 = (LayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r9.f14103b == true) goto L35;
        if (i() == true) goto L29;
    L31:
        int r10 = (r9.f14102a.e * this.k) - (r9.f14102a.e * r4);
        if (this.j != 1) goto L34;
    L33:
        r8.offsetLeftAndRight(r10);
        goto L35
    L34:
        r8.offsetTopAndBottom(r10);
        goto L35
    L29:
        if (this.j != 1) goto L31;
        r10 = ((-((this.i - 1) - r9.f14102a.e)) * this.k) - ((-((this.i - 1) - r9.f14102a.e)) * r4);
    L35:
        r2 = r2 + 1;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.obric.oui.orecyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int a(RecyclerView.o r17, o r18, RecyclerView.s r19) {
        ?? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i == false) goto L9;
        if (r18.e != 1) goto L7;
        int r0 = Integer.MAX_VALUE;
    L12:
        int r11 = r0;
        a(r18.e, r11);
        if (this.e == false) goto L15;
        int r1 = this.f14101b.d();
    L16:
        int r12 = r1;
        ?? r2 = false;
    L18:
        if (r18.a(r19) == false) goto L107;
        if (this.l.i == false) goto L22;
    L23:
        View r13 = r18.a(r17);
        LayoutParams r14 = (LayoutParams) ZeusTransformUtils.preCheckCast(r13.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r3 = r14.f();
        int r4 = this.h.c(r3);
        if (r4 != (-1)) goto L26;
        ?? r5 = 1;
    L27:
        if (r5 != 0) goto L29;
        b r6 = this.f14100a[r4];
    L34:
        b r15 = r6;
        r14.f14102a = r15;
        if (r18.e != 1) goto L37;
        b(r13);
    L38:
        a(r13, r14, r9);
        if (r18.e != 1) goto L51;
        if (r14.f14103b == false) goto L43;
        int r7 = p(r12);
    L44:
        int r8 = this.f14101b.e(r13) + r7;
        if (r5 != 0) goto L47;
    L49:
        int r10 = r8;
        int r16 = r7;
    L61:
        if (r14.f14103b == true) goto L63;
    L75:
        a(r13, r14, r18);
        if (i() == false) goto L85;
        if (this.j != 1) goto L85;
        if (r14.f14103b == false) goto L82;
        int r20 = this.c.d();
    L83:
        int r21 = r20;
        int r22 = r20 - this.c.e(r13);
    L90:
        if (this.j != 1) goto L92;
        int r23 = r22;
        r22 = r16;
        int r24 = r21;
    L93:
        b(r13, r23, r22, r24, r10);
        if (r14.f14103b == false) goto L96;
        a(this.l.e, r11);
    L97:
        a(r17, this.l);
        if (this.l.h == true) goto L100;
    L105:
        boolean r25 = false;
    L106:
        r9 = r25;
        r2 = true;
        goto L18
    L100:
        if (r13.hasFocusable() == false) goto L105;
        if (r14.f14103b == false) goto L104;
        this.m.clear();
        goto L105
    L104:
        r25 = false;
        this.m.set(r15.e, false);
        goto L106
    L96:
        a(r15, this.l.e, r11);
        goto L97
    L92:
        r23 = r16;
        r24 = r10;
        r10 = r21;
        goto L93
    L82:
        r20 = this.c.d() - (((this.i - 1) - r15.e) * this.k);
    L85:
        if (r14.f14103b == false) goto L87;
        int r26 = this.c.c();
    L88:
        r22 = r26;
        r21 = this.c.e(r13) + r26;
        goto L90
    L87:
        r26 = (r15.e * this.k) + this.c.c();
        goto L88
    L63:
        if (r18.d != (-1)) goto L75;
        if (r5 == 0) goto L67;
    L65:
        this.E = true;
        goto L75
    L67:
        if (r18.e != 1) goto L69;
        boolean r27 = k();
    L71:
        if ((!r27) == false) goto L75;
        LazySpanLookup.FullSpanItem r28 = this.h.f(r3);
        if (r28 == null) goto L65;
        r28.mHasUnwantedGapAfter = true;
        goto L65
    L69:
        r27 = l();
        goto L71
    L47:
        if (r14.f14103b == false) goto L49;
        LazySpanLookup.FullSpanItem r29 = f(r7);
        r29.mGapDir = -1;
        r29.mPosition = r3;
        this.h.a(r29);
        goto L49
    L43:
        r7 = r15.b(r12);
        goto L44
    L51:
        if (r14.f14103b == false) goto L53;
        int r30 = o(r12);
    L54:
        r16 = r30 - this.f14101b.e(r13);
        if (r5 != 0) goto L57;
    L59:
        r10 = r30;
        goto L61
    L57:
        if (r14.f14103b == false) goto L59;
        LazySpanLookup.FullSpanItem r31 = m(r30);
        r31.mGapDir = 1;
        r31.mPosition = r3;
        this.h.a(r31);
        goto L59
    L53:
        r30 = r15.a(r12);
        goto L54
    L37:
        b(r13, r9);
        goto L38
    L29:
        if (r14.f14103b == false) goto L31;
        r6 = this.f14100a[r9];
    L32:
        this.h.a(r3, r6);
        goto L34
    L31:
        r6 = a(r18);
        goto L32
    L26:
        r5 = r9;
        goto L27
    L22:
        if (this.m.isEmpty() == false) goto L23;
    L107:
        ?? r32 = r9;
        if (r2 == true) goto L111;
        a(r17, this.l);
    L111:
        if (this.l.e != (-1)) goto L113;
        int r33 = this.f14101b.c() - o(this.f14101b.c());
    L114:
        if (r33 <= 0) goto L117;
        return Math.min(r18.f14224b, r33);
    L117:
        return r32 == true ? 1 : 0;
    L113:
        r33 = p(this.f14101b.d()) - this.f14101b.d();
        goto L114
    L15:
        r1 = this.f14101b.c();
        goto L16
    L7:
        r0 = Integer.MIN_VALUE;
        goto L12
    L9:
        if (r18.e != 1) goto L11;
        r0 = r18.g + r18.f14224b;
        goto L12
    L11:
        r0 = r18.f - r18.f14224b;
        goto L12
    }

    private b a(o r8) {
        int r1 = -1;
        if (r(r8.e) == false) goto L5;
        int r0 = this.i - 1;
        int r3 = -1;
    L6:
        b r4 = null;
        if (r8.e != 1) goto L15;
        int r9 = Integer.MAX_VALUE;
        int r2 = this.f14101b.c();
    L9:
        if (r0 == r1) goto L14;
        b r5 = this.f14100a[r0];
        int r6 = r5.b(r2);
        if (r6 >= r9) goto L13;
        r4 = r5;
        r9 = r6;
    L13:
        r0 = r0 + r3;
        goto L9
    L14:
        return r4;
    L15:
        int r10 = Integer.MIN_VALUE;
        int r7 = this.f14101b.d();
    L16:
        if (r0 == r1) goto L21;
        b r11 = this.f14100a[r0];
        int r12 = r11.a(r7);
        if (r12 <= r10) goto L20;
        r4 = r11;
        r10 = r12;
    L20:
        r0 = r0 + r3;
        goto L16
    L21:
        return r4;
    L5:
        r0 = 0;
        r1 = this.i;
        r3 = 1;
        goto L6
    }

    private void a(int r3, int r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.i) goto L10;
        if (this.f14100a[r0].f14108a.isEmpty() == true) goto L9;
        a(this.f14100a[r0], r3, r4);
    L9:
        r0 = r0 + 1;
        goto L4
    }

    private void a(View r5, int r6, int r7, boolean r8) {
        b(r5, this.C);
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r9 = b(r6, r0.leftMargin + this.C.left, r0.rightMargin + this.C.right);
        int r10 = b(r7, r0.topMargin + this.C.top, r0.bottomMargin + this.C.bottom);
        if (r8 == false) goto L5;
        boolean r4 = a(r5, r9, r10, r0);
    L6:
        if (r4 == false) goto L9;
        r5.measure(r9, r10);
        return;
    L9:
        return;
    L5:
        r4 = b(r5, r9, r10, r0);
        goto L6
    }

    private void a(View r2, LayoutParams r3, o r4) {
        if (r4.e != 1) goto L9;
        if (r3.f14103b == false) goto L7;
        p(r2);
        return;
    L7:
        r3.f14102a.b(r2);
        return;
    L9:
        if (r3.f14103b == false) goto L11;
        q(r2);
        return;
    L11:
        r3.f14102a.a(r2);
    }

    private void a(View r7, LayoutParams r8, boolean r9) {
        if (r8.f14103b == false) goto L9;
        if (this.j != 1) goto L7;
        int r0 = this.B;
    L11:
        int r10 = a(B(), z(), D() + F(), r8.height, true);
    L13:
        a(r7, r0, r10, r9);
        return;
    L7:
        a(r7, a(A(), y(), C() + E(), r8.width, true), this.B, r9);
        return;
    L9:
        if (this.j != 1) goto L12;
        r0 = a(this.k, y(), 0, r8.width, false);
        goto L11
    L12:
        r0 = a(A(), y(), C() + E(), r8.width, true);
        r10 = a(this.k, z(), 0, r8.height, false);
        goto L13
    }

    private void a(RecyclerView.o r6, int r7) {
    L3:
        if (x() <= 0) goto L25;
        int r0 = 0;
        View r1 = i(0);
        if (this.f14101b.b(r1) > r7) goto L34;
        if (this.f14101b.c(r1) > r7) goto L35;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r2.f14103b == false) goto L21;
        int r3 = 0;
    L12:
        if (r3 >= this.i) goto L18;
        if (this.f14100a[r3].f14108a.size() == 1) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r0 >= this.i) goto L24;
        this.f14100a[r0].h();
        r0 = r0 + 1;
    L24:
        b(r1, r6);
        goto L3
    L21:
        if (r2.f14102a.f14108a.size() == 1) goto L22;
        r2.f14102a.h();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private void a(RecyclerView.o r9, RecyclerView.s r10, boolean r11) {
        a r0 = this.D;
        if (this.A != null) goto L7;
        if (this.f != (-1)) goto L7;
    L10:
        boolean r4 = true;
        if (r0.e == true) goto L13;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == false) goto L26;
        r0.a();
        if (this.A == null) goto L23;
        a(r0);
    L24:
        a(r10, r0);
        r0.e = true;
        goto L26
    L23:
        p();
        r0.c = this.e;
    L26:
        if (this.A != null) goto L35;
        if (this.f != (-1)) goto L35;
        if (r0.c == this.o) goto L32;
    L33:
        this.h.a();
        r0.d = true;
        goto L35
    L32:
        if (i() != this.z) goto L33;
    L35:
        if (x() <= 0) goto L62;
        SavedState r5 = this.A;
        if (r5 == null) goto L41;
        if (r5.mSpanOffsetsSize >= 1) goto L62;
    L41:
        if (r0.d == false) goto L49;
        int r2 = 0;
    L44:
        if (r2 >= this.i) goto L62;
        this.f14100a[r2].e();
        if (r0.f14107b == Integer.MIN_VALUE) goto L48;
        this.f14100a[r2].c(r0.f14107b);
    L48:
        r2 = r2 + 1;
        goto L44
    L49:
        if (r1 == false) goto L51;
    L57:
        int r3 = 0;
    L59:
        if (r3 >= this.i) goto L61;
        this.f14100a[r3].a(this.e, r0.f14107b);
        r3 = r3 + 1;
        goto L59
    L61:
        this.D.a(this.f14100a);
        goto L62
    L51:
        if (this.D.f == null) goto L57;
        int r6 = 0;
    L55:
        if (r6 >= this.i) goto L62;
        b r7 = this.f14100a[r6];
        r7.e();
        r7.c(this.D.f[r6]);
        r6 = r6 + 1;
    L62:
        a(r9);
        this.l.f14223a = false;
        this.E = false;
        a(this.c.f());
        b(r0.f14106a, r10);
        if (r0.c == false) goto L65;
        b(-1);
        a(r9, this.l, r10);
        b(1);
    L66:
        this.l.c = r0.f14106a + this.l.d;
        a(r9, this.l, r10);
        N();
        if (x() > 0) goto L69;
    L72:
        if (r11 == true) goto L74;
    L89:
        r4 = false;
    L91:
        if (r10.a() == false) goto L93;
        this.D.a();
    L93:
        this.o = r0.c;
        this.z = i();
        if (r4 == false) goto L102;
        this.D.a();
        a(r9, r10, false);
        return;
    L102:
        return;
    L74:
        if (r10.a() == true) goto L89;
        if (this.n != 0) goto L78;
    L84:
        boolean r12 = false;
    L85:
        if (r12 == false) goto L89;
        a(this.H);
        if (g() == false) goto L89;
    L78:
        if (x() <= 0) goto L84;
        if (this.E == false) goto L82;
    L83:
        r12 = true;
        goto L85
    L82:
        if (h() == null) goto L84;
    L69:
        if (this.e == false) goto L71;
        b(r9, r10, true);
        c(r9, r10, false);
        goto L72
    L71:
        c(r9, r10, true);
        b(r9, r10, false);
        goto L72
    L65:
        b(1);
        a(r9, this.l, r10);
        b(-1);
        goto L66
    L13:
        if (this.f != (-1)) goto L18;
        if (this.A != null) goto L18;
        r1 = false;
    L7:
        if (r10.e() != 0) goto L10;
        c(r9);
        r0.a();
    }

    private void a(RecyclerView.o r3, o r4) {
        if (r4.f14223a == true) goto L5;
        return;
    L5:
        if (r4.i == false) goto L8;
        return;
    L8:
        if (r4.f14224b != 0) goto L16;
        if (r4.e != (-1)) goto L13;
    L11:
        int r5 = r4.g;
    L12:
        b(r3, r5);
        return;
    L13:
        int r6 = r4.f;
    L14:
        a(r3, r6);
        return;
    L16:
        if (r4.e != (-1)) goto L21;
        int r0 = r4.f - n(r4.f);
        if (r0 < 0) goto L11;
        r5 = r4.g - Math.min(r0, r4.f14224b);
        goto L12
    L21:
        int r1 = q(r4.g) - r4.g;
        if (r1 < 0) goto L13;
        int r2 = r4.f;
        r6 = Math.min(r1, r4.f14224b) + r2;
        goto L14
    }

    private void a(a r4) {
        if (this.A.mSpanOffsetsSize > 0) goto L5;
    L18:
        this.z = this.A.mLastLayoutRTL;
        a(this.A.mReverseLayout);
        p();
        if (this.A.mAnchorPosition == (-1)) goto L21;
        this.f = this.A.mAnchorPosition;
        boolean r0 = this.A.mAnchorLayoutFromEnd;
    L22:
        r4.c = r0;
        if (this.A.mSpanLookupSize <= 1) goto L29;
        LazySpanLookup r5 = this.h;
        r5.f14104a = this.A.mSpanLookup;
        LazySpanLookup r6 = this.h;
        r6.f14105b = this.A.mFullSpanItems;
        return;
    L29:
        return;
    L21:
        r0 = this.e;
        goto L22
    L5:
        if (this.A.mSpanOffsetsSize != this.i) goto L17;
        int r1 = 0;
    L8:
        if (r1 >= this.i) goto L18;
        this.f14100a[r1].e();
        int r2 = this.A.mSpanOffsets[r1];
        if (r2 == Integer.MIN_VALUE) goto L16;
        if (this.A.mAnchorLayoutFromEnd == false) goto L14;
        int r3 = this.f14101b.d();
    L15:
        r2 = r2 + r3;
        goto L16
    L14:
        r3 = this.f14101b.c();
    L16:
        this.f14100a[r1].c(r2);
        r1 = r1 + 1;
        goto L8
    L17:
        this.A.invalidateSpanInfo();
        SavedState r7 = this.A;
        r7.mAnchorPosition = r7.mVisibleAnchorPosition;
        goto L18
    }

    private void a(b r4, int r5, int r6) {
        int r0 = r4.i();
        if (r5 != (-1)) goto L8;
        if ((r4.b() + r0) > r6) goto L11;
    L9:
        this.m.set(r4.e, false);
        return;
    L11:
        return;
    L8:
        if ((r4.d() - r0) >= r6) goto L9;
    }

    private boolean a(b r4) {
        if (this.e == false) goto L9;
        if (r4.d() < this.f14101b.d()) goto L7;
    L12:
        return false;
    L7:
        return !r4.c((View) ZeusTransformUtils.preCheckCast(r4.f14108a.get(r4.f14108a.size() - 1), View.class, "com.obric.memorydata.plugin")).f14103b;
    L9:
        if (r4.b() <= this.f14101b.c()) goto L12;
        return !r4.c((View) ZeusTransformUtils.preCheckCast(r4.f14108a.get(0), View.class, "com.obric.memorydata.plugin")).f14103b;
    }

    private int b(int r2, int r3, int r4) {
        if (r3 != 0) goto L5;
        if (r4 != 0) goto L5;
        return r2;
    L5:
        int r1 = View.MeasureSpec.getMode(r2);
        if (r1 == Integer.MIN_VALUE) goto L12;
        if (r1 == 1073741824) goto L12;
        return r2;
    L12:
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r2) - r3) - r4), r1);
    }

    private void b(int r4) {
        this.l.e = r4;
        o r0 = this.l;
        boolean r3 = this.e;
        int r1 = 1;
        if (r4 != (-1)) goto L5;
        boolean r5 = true;
    L6:
        if (r3 == r5) goto L9;
        r1 = -1;
    L9:
        r0.d = r1;
        return;
    L5:
        r5 = false;
        goto L6
    }

    private void b(int r5, RecyclerView.s r6) {
        boolean r1 = false;
        this.l.f14224b = 0;
        this.l.c = r5;
        if (u() == false) goto L13;
        int r7 = r6.c();
        if (r7 == (-1)) goto L13;
        boolean r0 = this.e;
        if (r7 >= r5) goto L9;
        boolean r8 = true;
    L10:
        if (r0 != r8) goto L12;
        int r9 = this.f14101b.f();
        int r10 = 0;
    L15:
        if (t() == false) goto L17;
        this.l.f = this.f14101b.c() - r10;
        this.l.g = this.f14101b.d() + r9;
    L18:
        this.l.h = false;
        this.l.f14223a = true;
        o r11 = this.l;
        if (this.f14101b.h() == 0) goto L21;
    L23:
        r11.i = r1;
        return;
    L21:
        if (this.f14101b.e() != 0) goto L23;
        r1 = true;
        goto L23
    L17:
        this.l.g = this.f14101b.e() + r9;
        this.l.f = -r10;
        goto L18
    L12:
        r10 = this.f14101b.f();
        r9 = 0;
        goto L15
    L9:
        r8 = false;
    L13:
        r9 = 0;
        r10 = 0;
        goto L15
    }

    private void b(RecyclerView.o r7, int r8) {
        int r0 = x() - 1;
    L3:
        if (r0 < 0) goto L25;
        View r2 = i(r0);
        if (this.f14101b.a(r2) < r8) goto L34;
        if (this.f14101b.d(r2) < r8) goto L35;
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r3.f14103b == false) goto L21;
        int r4 = 0;
        int r5 = 0;
    L12:
        if (r5 >= this.i) goto L18;
        if (this.f14100a[r5].f14108a.size() == 1) goto L15;
        r5 = r5 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r4 >= this.i) goto L24;
        this.f14100a[r4].g();
        r4 = r4 + 1;
    L24:
        b(r2, r7);
        r0 = r0 - 1;
        goto L3
    L21:
        if (r3.f14102a.f14108a.size() == 1) goto L22;
        r3.f14102a.g();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private void b(RecyclerView.o r3, RecyclerView.s r4, boolean r5) {
        int r1 = p(Integer.MIN_VALUE);
        if (r1 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        int r0 = this.f14101b.d() - r1;
        if (r0 <= 0) goto L12;
        int r2 = r0 - (-c(-r0, r3, r4));
        if (r5 == false) goto L13;
        if (r2 <= 0) goto L14;
        this.f14101b.a(r2);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void c(int r7, int r8, int r9) {
        if (this.e == false) goto L5;
        int r0 = m();
    L7:
        if (r9 != 8) goto L11;
        if (r7 >= r8) goto L10;
        int r2 = r8 + 1;
    L12:
        int r3 = r7;
    L13:
        this.h.b(r3);
        if (r9 != 1) goto L16;
        this.h.b(r7, r8);
    L22:
        if (r2 > r0) goto L25;
        return;
    L25:
        if (this.e == false) goto L27;
        int r10 = o();
    L28:
        if (r3 > r10) goto L31;
        q();
        return;
    L31:
        return;
    L27:
        r10 = m();
        goto L28
    L16:
        if (r9 == 2) goto L20;
        if (r9 != 8) goto L22;
        this.h.a(r7, 1);
        this.h.b(r8, 1);
        goto L22
    L20:
        this.h.a(r7, r8);
        goto L22
    L10:
        r2 = r7 + 1;
        r3 = r8;
        goto L13
    L11:
        r2 = r7 + r8;
        goto L12
    L5:
        r0 = o();
        goto L7
    }

    private void c(RecyclerView.o r3, RecyclerView.s r4, boolean r5) {
        int r1 = o(Integer.MAX_VALUE);
        if (r1 != Integer.MAX_VALUE) goto L5;
        return;
    L5:
        int r2 = r1 - this.f14101b.c();
        if (r2 <= 0) goto L12;
        int r6 = r2 - c(r2, r3, r4);
        if (r5 == false) goto L13;
        if (r6 <= 0) goto L14;
        this.f14101b.a(-r6);
        return;
    L14:
        return;
    L13:
        return;
    }

    private boolean c(RecyclerView.s r2, a r3) {
        boolean r0 = this.o;
        int r4 = r2.e();
        if (r0 == false) goto L5;
        int r1 = u(r4);
    L6:
        r3.f14106a = r1;
        r3.f14107b = Integer.MIN_VALUE;
        return true;
    L5:
        r1 = t(r4);
        goto L6
    }

    private int f(RecyclerView.s r8) {
        if (x() != 0) goto L7;
        return 0;
    L7:
        return y.a(r8, this.f14101b, b(!this.F), c(!this.F), this, this.F, this.e);
    }

    private LazySpanLookup.FullSpanItem f(int r5) {
        LazySpanLookup.FullSpanItem r0 = new LazySpanLookup.FullSpanItem();
        r0.mGapPerSpan = new int[this.i];
        int r1 = 0;
    L4:
        if (r1 >= this.i) goto L6;
        r0.mGapPerSpan[r1] = r5 - this.f14100a[r1].b(r5);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private int i(RecyclerView.s r7) {
        if (x() != 0) goto L7;
        return 0;
    L7:
        return y.a(r7, this.f14101b, b(!this.F), c(!this.F), this, this.F);
    }

    private int j(RecyclerView.s r7) {
        if (x() != 0) goto L7;
        return 0;
    L7:
        return y.b(r7, this.f14101b, b(!this.F), c(!this.F), this, this.F);
    }

    private LazySpanLookup.FullSpanItem m(int r5) {
        LazySpanLookup.FullSpanItem r0 = new LazySpanLookup.FullSpanItem();
        r0.mGapPerSpan = new int[this.i];
        int r1 = 0;
    L4:
        if (r1 >= this.i) goto L6;
        r0.mGapPerSpan[r1] = this.f14100a[r1].a(r5) - r5;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private int n(int r4) {
        int r0 = this.f14100a[0].a(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.i) goto L9;
        int r2 = this.f14100a[r1].a(r4);
        if (r2 <= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private int o(int r4) {
        int r0 = this.f14100a[0].a(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.i) goto L9;
        int r2 = this.f14100a[r1].a(r4);
        if (r2 >= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private int p(int r4) {
        int r0 = this.f14100a[0].b(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.i) goto L9;
        int r2 = this.f14100a[r1].b(r4);
        if (r2 <= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private void p() {
        if (this.j != 1) goto L5;
    L8:
        boolean r0 = this.d;
    L9:
        this.e = r0;
        return;
    L5:
        if (i() == false) goto L8;
        r0 = !this.d;
        goto L9
    }

    private void p(View r3) {
        int r0 = this.i - 1;
    L3:
        if (r0 < 0) goto L5;
        this.f14100a[r0].b(r3);
        r0 = r0 - 1;
        goto L3
    }

    private int q(int r4) {
        int r0 = this.f14100a[0].b(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.i) goto L9;
        int r2 = this.f14100a[r1].b(r4);
        if (r2 >= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private void q(View r3) {
        int r0 = this.i - 1;
    L3:
        if (r0 < 0) goto L5;
        this.f14100a[r0].a(r3);
        r0 = r0 - 1;
        goto L3
    }

    private boolean r(int r5) {
        if (this.j != 0) goto L12;
        if (r5 != (-1)) goto L6;
        boolean r6 = true;
    L8:
        if (r6 == this.e) goto L11;
        return true;
    L11:
        return false;
    L6:
        r6 = false;
        goto L8
    L12:
        if (r5 != (-1)) goto L14;
        boolean r7 = true;
    L16:
        if (r7 != this.e) goto L18;
        boolean r8 = true;
    L20:
        if (r8 != i()) goto L23;
        return true;
    L23:
        return false;
    L18:
        r8 = false;
        goto L20
    L14:
        r7 = false;
        goto L16
    }

    private int s(int r4) {
        if (x() != 0) goto L9;
        if (this.e == true) goto L7;
        return -1;
    L7:
        return 1;
    L9:
        if (r4 >= o()) goto L11;
        boolean r5 = true;
    L13:
        if (r5 == this.e) goto L16;
        return -1;
    L16:
        return 1;
    L11:
        r5 = false;
        goto L13
    }

    private int t(int r5) {
        int r0 = x();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int r3 = d(i(r2));
        if (r3 < 0) goto L8;
        if (r3 >= r5) goto L8;
        return r3;
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return 0;
    }

    private int u(int r3) {
        int r0 = x() - 1;
    L3:
        if (r0 < 0) goto L9;
        int r1 = d(i(r0));
        if (r1 < 0) goto L8;
        if (r1 >= r3) goto L8;
        return r1;
    L8:
        r0 = r0 - 1;
        goto L3
    L9:
        return 0;
    }

    private int v(int r5) {
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L36;
        if (r5 == 17) goto L31;
        if (r5 == 33) goto L26;
        if (r5 == 66) goto L21;
        if (r5 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.j != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.j != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.j != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.j != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.j != 1) goto L39;
        return 1;
    L39:
        if (i() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.j != 1) goto L46;
        return -1;
    L46:
        if (i() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int a(int r1, RecyclerView.o r2, RecyclerView.s r3) {
        return c(r1, r2, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public View a(View r9, int r10, RecyclerView.o r11, RecyclerView.s r12) {
        if (x() != 0) goto L5;
        return null;
    L5:
        View r13 = e(r9);
        if (r13 != null) goto L8;
        return null;
    L8:
        p();
        int r14 = v(r10);
        if (r14 != Integer.MIN_VALUE) goto L11;
        return null;
    L11:
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r13.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        boolean r2 = r0.f14103b;
        b r1 = r0.f14102a;
        if (r14 != 1) goto L14;
        int r4 = m();
    L15:
        b(r4, r12);
        b(r14);
        o r5 = this.l;
        r5.c = r5.d + r4;
        this.l.f14224b = (int) (this.f14101b.f() * 0.33333334f);
        this.l.h = true;
        int r6 = 0;
        this.l.f14223a = false;
        a(r11, this.l, r12);
        this.o = this.e;
        if (r2 == true) goto L22;
        View r15 = r1.a(r4, r14);
        if (r15 == null) goto L22;
        if (r15 == r13) goto L22;
        return r15;
    L22:
        if (r(r14) == false) goto L30;
        int r16 = this.i - 1;
    L24:
        if (r16 < 0) goto L38;
        View r17 = this.f14100a[r16].a(r4, r14);
        if (r17 == null) goto L29;
        if (r17 == r13) goto L29;
        return r17;
    L29:
        r16 = r16 - 1;
    L38:
        boolean r18 = !this.d;
        if (r14 != (-1)) goto L41;
        boolean r19 = true;
    L42:
        if (r18 != r19) goto L44;
        boolean r110 = true;
    L45:
        if (r2 == true) goto L54;
        if (r110 == false) goto L48;
        int r111 = r1.j();
    L49:
        View r112 = c(r111);
        if (r112 == null) goto L54;
        if (r112 == r13) goto L54;
        return r112;
    L48:
        r111 = r1.k();
    L54:
        if (r(r14) == false) goto L70;
        int r113 = this.i - 1;
    L56:
        if (r113 < 0) goto L80;
        if (r113 == r1.e) goto L68;
        b[] r114 = this.f14100a;
        if (r110 == false) goto L63;
        int r115 = r114[r113].j();
    L64:
        View r116 = c(r115);
        if (r116 == null) goto L68;
        if (r116 == r13) goto L68;
        return r116;
    L63:
        r115 = r114[r113].k();
    L68:
        r113 = r113 - 1;
    L80:
        return null;
    L70:
        if (r6 >= this.i) goto L80;
        b[] r117 = this.f14100a;
        if (r110 == false) goto L74;
        int r118 = r117[r6].j();
    L75:
        View r119 = c(r118);
        if (r119 == null) goto L79;
        if (r119 == r13) goto L79;
        return r119;
    L79:
        r6 = r6 + 1;
        goto L70
    L74:
        r118 = r117[r6].k();
        goto L75
    L44:
        r110 = false;
        goto L45
    L41:
        r19 = false;
        goto L42
    L30:
        int r120 = 0;
    L32:
        if (r120 >= this.i) goto L38;
        View r121 = this.f14100a[r120].a(r4, r14);
        if (r121 == null) goto L37;
        if (r121 == r13) goto L37;
        return r121;
    L37:
        r120 = r120 + 1;
        goto L32
    L14:
        r4 = o();
        goto L15
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a() {
        if (this.j != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a(Context r2, AttributeSet r3) {
        return new LayoutParams((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L7:
        return new LayoutParams(r3);
    }

    void a(int r2) {
        this.k = r2 / this.i;
        this.B = View.MeasureSpec.makeMeasureSpec(r2, this.c.h());
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(int r5, int r6, RecyclerView.s r7, RecyclerView.h.a r8) {
        RecyclerView.h.a r9 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r8, RecyclerView.h.a.class, "com.obric.memorydata.plugin");
        if (this.j == 0) goto L7;
        r5 = r6;
    L7:
        if (x() == 0) goto L31;
        if (r5 == 0) goto L37;
        a(r5, r7);
        int[] r10 = this.G;
        if (r10 != null) goto L13;
    L14:
        this.G = new int[this.i];
    L15:
        int r11 = 0;
        int r12 = 0;
        int r0 = 0;
    L17:
        if (r12 >= this.i) goto L26;
        if (this.l.d != (-1)) goto L21;
        int r1 = this.l.f;
        int r2 = this.f14100a[r12].a(this.l.f);
    L22:
        int r3 = r1 - r2;
        if (r3 < 0) goto L25;
        this.G[r0] = r3;
        r0 = r0 + 1;
    L25:
        r12 = r12 + 1;
        goto L17
    L21:
        r1 = this.f14100a[r12].b(this.l.g);
        r2 = this.l.g;
        goto L22
    L26:
        Arrays.sort(this.G, 0, r0);
    L27:
        if (r11 >= r0) goto L38;
        if (this.l.a(r7) == false) goto L39;
        r9.b(this.l.c, this.G[r11]);
        this.l.c += this.l.d;
        r11 = r11 + 1;
        goto L27
    L39:
        return;
    L38:
        return;
    L13:
        if (r10.length >= this.i) goto L15;
    L37:
        return;
    }

    void a(int r6, RecyclerView.s r7) {
        if (r6 <= 0) goto L5;
        int r1 = m();
        int r2 = 1;
    L6:
        this.l.f14223a = true;
        b(r1, r7);
        b(r2);
        o r8 = this.l;
        r8.c = r1 + r8.d;
        this.l.f14224b = Math.abs(r6);
        return;
    L5:
        r2 = -1;
        r1 = o();
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(Rect r5, int r6, int r7) {
        int r0 = C() + E();
        int r1 = D() + F();
        if (this.j != 1) goto L5;
        int r8 = a(r7, r5.height() + r1, J());
        int r9 = a(r6, (this.k * this.i) + r0, I());
    L6:
        g(r9, r8);
        return;
    L5:
        r9 = a(r6, r5.width() + r0, I());
        r8 = a(r7, (this.k * this.i) + r1, J());
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == false) goto L9;
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        this.A = r5;
        if (this.f == (-1)) goto L7;
        r5.invalidateAnchorPositionInfo();
        this.A.invalidateSpanInfo();
    L7:
        q();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(AccessibilityEvent r3) {
        super.a(r3);
        if (x() <= 0) goto L13;
        View r1 = b(false);
        View r0 = c(false);
        if (r1 == null) goto L14;
        if (r0 == null) goto L16;
        int r2 = d(r1);
        int r4 = d(r0);
        if (r2 >= r4) goto L11;
        r3.setFromIndex(r2);
        r3.setToIndex(r4);
        return;
    L11:
        r3.setFromIndex(r4);
        r3.setToIndex(r2);
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView.Adapter r1, RecyclerView.Adapter r2) {
        this.h.a();
        int r3 = 0;
    L4:
        if (r3 >= this.i) goto L6;
        this.f14100a[r3].e();
        r3 = r3 + 1;
        goto L4
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView.s r1) {
        super.a(r1);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    void a(RecyclerView.s r2, a r3) {
        if (b(r2, r3) == false) goto L6;
        return;
    L6:
        if (c(r2, r3) == false) goto L8;
        return;
    L8:
        r3.b();
        r3.f14106a = 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1) {
        this.h.a();
        q();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3) {
        c(r2, r3, 1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3, int r4) {
        c(r2, r3, 8);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3, Object r4) {
        c(r2, r3, 4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView r2, RecyclerView.o r3) {
        super.a(r2, r3);
        a(this.H);
        int r4 = 0;
    L4:
        if (r4 >= this.i) goto L6;
        this.f14100a[r4].e();
        r4 = r4 + 1;
        goto L4
    L6:
        r2.requestLayout();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(RecyclerView r3, RecyclerView.s r4, int r5) {
        p r6 = new p((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r6.c(r5);
        a(r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void a(String r2) {
        if (this.A != null) goto L6;
        super.a(r2);
        return;
    }

    public void a(boolean r2) {
        a(null);
        SavedState r0 = this.A;
        if (r0 != null) goto L5;
    L7:
        this.d = r2;
        q();
        return;
    L5:
        if (r0.mReverseLayout == r2) goto L7;
        this.A.mReverseLayout = r2;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean a(RecyclerView.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int b(int r1, RecyclerView.o r2, RecyclerView.s r3) {
        return c(r1, r2, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int b(RecyclerView.s r1) {
        return j(r1);
    }

    View b(boolean r9) {
        int r0 = this.f14101b.c();
        int r1 = this.f14101b.d();
        int r2 = x();
        View r3 = null;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L15;
        View r5 = i(r4);
        int r6 = this.f14101b.a(r5);
        if (this.f14101b.b(r5) <= r0) goto L14;
        if (r6 >= r1) goto L14;
        if (r6 >= r0) goto L13;
        if (r9 == false) goto L13;
        if (r3 != null) goto L14;
        r3 = r5;
    L13:
        return r5;
    L14:
        r4 = r4 + 1;
        goto L3
    L15:
        return r3;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void b(RecyclerView r1, int r2, int r3) {
        c(r2, r3, 2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean b() {
        if (this.A != null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean b(RecyclerView.s r5, a r6) {
        boolean r1 = false;
        if (r5.a() == true) goto L61;
        int r0 = this.f;
        if (r0 == (-1)) goto L61;
        if (r0 >= 0) goto L10;
    L60:
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        goto L61
    L10:
        if (r0 >= r5.e()) goto L60;
        SavedState r7 = this.A;
        if (r7 != null) goto L15;
    L20:
        View r8 = c(this.f);
        if (r8 != null) goto L23;
        r6.f14106a = this.f;
        int r9 = this.g;
        if (r9 == Integer.MIN_VALUE) goto L54;
        r6.a(r9);
    L58:
        r6.d = true;
    L59:
        return true;
    L54:
        if (s(r6.f14106a) != 1) goto L56;
        r1 = true;
    L56:
        r6.c = r1;
        r6.b();
        goto L58
    L23:
        if (this.e == false) goto L25;
        int r2 = m();
    L26:
        r6.f14106a = r2;
        if (this.g == Integer.MIN_VALUE) goto L35;
        if (r6.c == false) goto L31;
        int r3 = this.f14101b.d() - this.g;
        int r4 = this.f14101b.b(r8);
    L32:
        r6.f14107b = r3 - r4;
        return true;
    L31:
        r3 = this.f14101b.c() + this.g;
        r4 = this.f14101b.a(r8);
        goto L32
    L35:
        if (this.f14101b.e(r8) <= this.f14101b.f()) goto L42;
        boolean r10 = r6.c;
        v r11 = this.f14101b;
        if (r10 == false) goto L39;
        int r12 = r11.d();
    L40:
        r6.f14107b = r12;
        return true;
    L39:
        r12 = r11.c();
        goto L40
    L42:
        int r13 = this.f14101b.a(r8) - this.f14101b.c();
        if (r13 >= 0) goto L46;
        r6.f14107b = -r13;
        return true;
    L46:
        int r14 = this.f14101b.d() - this.f14101b.b(r8);
        if (r14 >= 0) goto L50;
        r6.f14107b = r14;
        return true;
    L50:
        r6.f14107b = Integer.MIN_VALUE;
        goto L59
    L25:
        r2 = o();
        goto L26
    L15:
        if (r7.mAnchorPosition == (-1)) goto L20;
        if (this.A.mSpanOffsetsSize < 1) goto L20;
        r6.f14107b = Integer.MIN_VALUE;
        r6.f14106a = this.f;
    L61:
        return false;
    }

    int c(int r3, RecyclerView.o r4, RecyclerView.s r5) {
        if (x() == 0) goto L14;
        if (r3 == 0) goto L14;
        a(r3, r5);
        int r6 = a(r4, this.l, r5);
        if (this.l.f14224b < r6) goto L12;
        if (r3 >= 0) goto L11;
        r3 = -r6;
        goto L12
    L11:
        r3 = r6;
    L12:
        this.f14101b.a(-r3);
        this.o = this.e;
        this.l.f14224b = 0;
        a(r4, this.l);
        return r3;
    L14:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int c(RecyclerView.s r1) {
        return j(r1);
    }

    View c(boolean r8) {
        int r0 = this.f14101b.c();
        int r1 = this.f14101b.d();
        int r2 = x() - 1;
        View r3 = null;
    L3:
        if (r2 < 0) goto L15;
        View r4 = i(r2);
        int r5 = this.f14101b.a(r4);
        int r6 = this.f14101b.b(r4);
        if (r6 <= r0) goto L14;
        if (r5 >= r1) goto L14;
        if (r6 <= r1) goto L13;
        if (r8 == false) goto L13;
        if (r3 != null) goto L14;
        r3 = r4;
    L13:
        return r4;
    L14:
        r2 = r2 - 1;
        goto L3
    L15:
        return r3;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void c(RecyclerView.o r2, RecyclerView.s r3) {
        a(r2, r3, true);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean c() {
        if (this.n == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int d(RecyclerView.s r1) {
        return f(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r.b
    public PointF d(int r3) {
        int r4 = s(r3);
        PointF r0 = new PointF();
        if (r4 != 0) goto L7;
        return null;
    L7:
        if (this.j != 0) goto L9;
        r0.x = r4;
        r0.y = 0.0f;
    L10:
        return r0;
    L9:
        r0.x = 0.0f;
        r0.y = r4;
        goto L10
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public Parcelable d() {
        if (this.A != null) goto L5;
        SavedState r0 = new SavedState();
        r0.mReverseLayout = this.d;
        r0.mAnchorLayoutFromEnd = this.o;
        r0.mLastLayoutRTL = this.z;
        LazySpanLookup r1 = this.h;
        int r2 = 0;
        if (r1 != null) goto L9;
    L11:
        r0.mSpanLookupSize = 0;
    L13:
        if (x() > 0) goto L15;
        r0.mAnchorPosition = -1;
        r0.mVisibleAnchorPosition = -1;
        r0.mSpanOffsetsSize = 0;
    L32:
        return r0;
    L15:
        if (this.o == false) goto L17;
        int r3 = m();
    L18:
        r0.mAnchorPosition = r3;
        r0.mVisibleAnchorPosition = j();
        r0.mSpanOffsetsSize = this.i;
        r0.mSpanOffsets = new int[this.i];
    L20:
        if (r2 >= this.i) goto L32;
        if (this.o == false) goto L26;
        int r4 = this.f14100a[r2].b(Integer.MIN_VALUE);
        if (r4 == Integer.MIN_VALUE) goto L30;
        int r5 = this.f14101b.d();
    L29:
        r4 = r4 - r5;
    L30:
        r0.mSpanOffsets[r2] = r4;
        r2 = r2 + 1;
        goto L20
    L26:
        r4 = this.f14100a[r2].a(Integer.MIN_VALUE);
        if (r4 == Integer.MIN_VALUE) goto L30;
        r5 = this.f14101b.c();
        goto L29
    L17:
        r3 = o();
        goto L18
    L9:
        if (r1.f14104a == null) goto L11;
        r0.mSpanLookup = this.h.f14104a;
        r0.mSpanLookupSize = r0.mSpanLookup.length;
        r0.mFullSpanItems = this.h.f14105b;
        goto L13
    L5:
        return new SavedState(this.A);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int e(RecyclerView.s r1) {
        return f(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void e(int r2) {
        SavedState r0 = this.A;
        if (r0 != null) goto L5;
    L7:
        this.f = r2;
        this.g = Integer.MIN_VALUE;
        q();
        return;
    L5:
        if (r0.mAnchorPosition == r2) goto L7;
        this.A.invalidateAnchorPositionInfo();
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean e() {
        if (this.j != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean f() {
        if (this.j == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int g(RecyclerView.s r1) {
        return i(r1);
    }

    boolean g() {
        if (x() != 0) goto L5;
    L35:
        return false;
    L5:
        if (this.n == 0) goto L35;
        if (s() == false) goto L35;
        if (this.e == false) goto L12;
        int r0 = m();
        int r2 = o();
    L14:
        if (r0 != 0) goto L21;
        if (h() == null) goto L21;
        this.h.a();
    L18:
        L();
        q();
        return true;
    L21:
        if (this.E == true) goto L24;
        return false;
    L24:
        if (this.e == false) goto L26;
        int r4 = -1;
    L27:
        int r3 = r2 + 1;
        LazySpanLookup.FullSpanItem r6 = this.h.a(r0, r3, r4, true);
        if (r6 != null) goto L31;
        this.E = false;
        this.h.a(r3);
        return false;
    L31:
        LazySpanLookup.FullSpanItem r1 = this.h.a(r0, r6.mPosition, r4 * (-1), true);
        if (r1 != null) goto L34;
        this.h.a(r6.mPosition);
        goto L18
    L34:
        this.h.a(r1.mPosition + 1);
        goto L18
    L26:
        r4 = 1;
        goto L27
    L12:
        r0 = o();
        r2 = m();
        goto L14
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int h(RecyclerView.s r1) {
        return i(r1);
    }

    View h() {
        int r0 = x() - 1;
        BitSet r2 = new BitSet(this.i);
        r2.set(0, this.i, true);
        int r5 = -1;
        if (this.j == 1) goto L5;
    L7:
        byte r3 = -1;
    L9:
        if (this.e == false) goto L11;
        int r6 = -1;
    L12:
        if (r0 >= r6) goto L14;
        r5 = 1;
    L14:
        if (r0 == r6) goto L50;
        View r7 = i(r0);
        LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r2.get(r8.f14102a.e) == false) goto L22;
        if (a(r8.f14102a) == true) goto L19;
        r2.clear(r8.f14102a.e);
        goto L22
    L19:
        return r7;
    L22:
        if (r8.f14103b == true) goto L49;
        int r9 = r0 + r5;
        if (r9 == r6) goto L49;
        View r10 = i(r9);
        if (this.e == false) goto L33;
        int r11 = this.f14101b.b(r7);
        int r12 = this.f14101b.b(r10);
        if (r11 < r12) goto L30;
        if (r11 == r12) goto L37;
    L38:
        boolean r13 = false;
    L39:
        if (r13 == false) goto L49;
        if ((r8.f14102a.e - ((LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).f14102a.e) >= 0) goto L43;
        boolean r14 = true;
    L44:
        if (r3 >= 0) goto L46;
        boolean r15 = true;
    L47:
        if (r14 == r15) goto L49;
        return r7;
    L46:
        r15 = false;
        goto L47
    L43:
        r14 = false;
    L37:
        r13 = true;
        goto L39
    L30:
        return r7;
    L33:
        int r16 = this.f14101b.a(r7);
        int r17 = this.f14101b.a(r10);
        if (r16 > r17) goto L35;
        if (r16 != r17) goto L38;
    L35:
        return r7;
    L49:
        r0 = r0 + r5;
        goto L14
    L50:
        return null;
    L11:
        r6 = r0 + 1;
        r0 = 0;
        goto L12
    L5:
        if (i() == false) goto L7;
        r3 = 1;
        goto L9
    }

    boolean i() {
        if (v() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    int j() {
        if (this.e == false) goto L5;
        View r0 = c(true);
    L6:
        if (r0 != null) goto L9;
        return -1;
    L9:
        return d(r0);
    L5:
        r0 = b(true);
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void j(int r3) {
        super.j(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.i) goto L6;
        this.f14100a[r0].d(r3);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void k(int r3) {
        super.k(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.i) goto L6;
        this.f14100a[r0].d(r3);
        r0 = r0 + 1;
        goto L4
    }

    boolean k() {
        int r0 = this.f14100a[0].b(Integer.MIN_VALUE);
        int r4 = 1;
    L4:
        if (r4 >= this.i) goto L9;
        if (this.f14100a[r4].b(Integer.MIN_VALUE) != r0) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void l(int r1) {
        if (r1 != 0) goto L5;
        g();
        return;
    }

    boolean l() {
        int r0 = this.f14100a[0].a(Integer.MIN_VALUE);
        int r4 = 1;
    L4:
        if (r4 >= this.i) goto L9;
        if (this.f14100a[r4].a(Integer.MIN_VALUE) != r0) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    int m() {
        int r0 = x();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        return d(i(r0 - 1));
    }

    int o() {
        if (x() != 0) goto L6;
        return 0;
    L6:
        return d(i(0));
    }
}
