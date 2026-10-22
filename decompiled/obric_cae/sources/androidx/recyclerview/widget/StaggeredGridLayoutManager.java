package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import j0.h0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    public int A;
    public final LazySpanLookup B;
    public final int C;
    public boolean D;
    public boolean E;
    public SavedState F;
    public int G;
    public final Rect H;
    public final b I;
    public boolean J;
    public final boolean K;
    public int[] L;
    public final a M;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2378p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d[] f2379q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public s f2380r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public s f2381s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2382t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2383u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final n f2384v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2385w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2386x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BitSet f2387y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2388z;

    public static class LazySpanLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f2389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<FullSpanItem> f2390b;

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2391a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2392b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int[] f2393m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public boolean f2394n;

            public static class a implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                public final FullSpanItem createFromParcel(Parcel r8) {
                    return new FullSpanItem(r8);
                }

                @Override // android.os.Parcelable.Creator
                public final FullSpanItem[] newArray(int r8) {
                    return new FullSpanItem[r8];
                }
            }

            static {
                CREATOR = new a();
            }

            public FullSpanItem() {
            }

            public FullSpanItem(Parcel r8) {
                this.f2391a = r8.readInt();
                this.f2392b = r8.readInt();
                boolean r10 = true;
                if (r8.readInt() == 1) goto L6;
                r10 = false;
            L6:
                this.f2394n = r10;
                int r11 = r8.readInt();
                if (r11 <= 0) goto L10;
                int[] r12 = new int[r11];
                this.f2393m = r12;
                r8.readIntArray(r12);
                return;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final String toString() {
                return "FullSpanItem{mPosition=" + this.f2391a + ", mGapDir=" + this.f2392b + ", mHasUnwantedGapAfter=" + this.f2394n + ", mGapPerSpan=" + Arrays.toString(this.f2393m) + '}';
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel r8, int r10) {
                r8.writeInt(this.f2391a);
                r8.writeInt(this.f2392b);
                r8.writeInt(this.f2394n ? 1 : 0);
                int[] r11 = this.f2393m;
                if (r11 != null) goto L5;
            L7:
                r8.writeInt(0);
                return;
            L5:
                if (r11.length <= 0) goto L7;
                r8.writeInt(r11.length);
                r8.writeIntArray(this.f2393m);
            }
        }

        public final void a(FullSpanItem r8) {
            if (this.f2390b != null) goto L5;
            this.f2390b = new ArrayList();
        L5:
            int r10 = this.f2390b.size();
            int r11 = 0;
        L6:
            if (r11 >= r10) goto L15;
            FullSpanItem r12 = this.f2390b.get(r11);
            if (r12.f2391a != r8.f2391a) goto L11;
            this.f2390b.remove(r11);
        L11:
            if (r12.f2391a >= r8.f2391a) goto L12;
            r11 = r11 + 1;
            goto L6
        L12:
            this.f2390b.add(r11, r8);
            return;
        L15:
            this.f2390b.add(r8);
        }

        public final void b(int r8) {
            int[] r10 = this.f2389a;
            if (r10 != null) goto L6;
            int[] r11 = new int[Math.max(r8, 10) + 1];
            this.f2389a = r11;
            Arrays.fill(r11, -1);
            return;
        L6:
            if (r8 < r10.length) goto L14;
            int r12 = r10.length;
        L8:
            if (r12 > r8) goto L10;
            r12 = r12 * 2;
            goto L8
        L10:
            int[] r13 = new int[r12];
            this.f2389a = r13;
            System.arraycopy(r10, 0, r13, 0, r10.length);
            int[] r14 = this.f2389a;
            Arrays.fill(r14, r10.length, r14.length, -1);
            return;
        }

        public final void c(int r8) {
            List<FullSpanItem> r10 = this.f2390b;
            if (r10 == null) goto L10;
            int r11 = r10.size();
        L5:
            r11 = r11 - 1;
            if (r11 < 0) goto L10;
            if (this.f2390b.get(r11).f2391a < r8) goto L5;
            this.f2390b.remove(r11);
        L10:
            f(r8);
        }

        public final FullSpanItem d(int r8, int r10, int r11) {
            List<FullSpanItem> r12 = this.f2390b;
            if (r12 != null) goto L5;
            return null;
        L5:
            int r13 = r12.size();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L18;
            FullSpanItem r15 = this.f2390b.get(r14);
            int r16 = r15.f2391a;
            if (r16 >= r10) goto L9;
            if (r16 < r8) goto L17;
            if (r11 == 0) goto L16;
            if (r15.f2392b == r11) goto L16;
            if (r15.f2394n == false) goto L17;
        L16:
            return r15;
        L17:
            r14 = r14 + 1;
            goto L6
        L9:
            return null;
        L18:
            return null;
        }

        public final FullSpanItem e(int r8) {
            List<FullSpanItem> r10 = this.f2390b;
            if (r10 != null) goto L5;
            return null;
        L5:
            int r11 = r10.size() - 1;
        L6:
            if (r11 < 0) goto L11;
            FullSpanItem r12 = this.f2390b.get(r11);
            if (r12.f2391a == r8) goto L9;
            r11 = r11 - 1;
            goto L6
        L9:
            return r12;
        L11:
            return null;
        }

        public final int f(int r8) {
            int[] r10 = this.f2389a;
            if (r10 != null) goto L6;
            return -1;
        L6:
            if (r8 < r10.length) goto L9;
            return -1;
        L9:
            if (this.f2390b != null) goto L11;
        L10:
            int r11 = -1;
        L23:
            if (r11 != (-1)) goto L26;
            int[] r12 = this.f2389a;
            Arrays.fill(r12, r8, r12.length, -1);
            return this.f2389a.length;
        L26:
            int r13 = r11 + 1;
            Arrays.fill(this.f2389a, r8, r13, -1);
            return r13;
        L11:
            FullSpanItem r14 = e(r8);
            if (r14 == null) goto L14;
            this.f2390b.remove(r14);
        L14:
            int r15 = this.f2390b.size();
            int r16 = 0;
        L15:
            if (r16 >= r15) goto L20;
            if (this.f2390b.get(r16).f2391a >= r8) goto L21;
            r16 = r16 + 1;
        L21:
            if (r16 == (-1)) goto L10;
            FullSpanItem r17 = this.f2390b.get(r16);
            this.f2390b.remove(r16);
            r11 = r17.f2391a;
            goto L23
        L20:
            r16 = -1;
            goto L21
        }

        public final void g(int r8, int r10) {
            int[] r11 = this.f2389a;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r8 >= r11.length) goto L21;
            int r12 = r8 + r10;
            b(r12);
            int[] r13 = this.f2389a;
            System.arraycopy(r13, r8, r13, r12, (r13.length - r8) - r10);
            Arrays.fill(this.f2389a, r8, r12, -1);
            List<FullSpanItem> r14 = this.f2390b;
            if (r14 == null) goto L22;
            int r15 = r14.size() - 1;
        L11:
            if (r15 < 0) goto L23;
            FullSpanItem r16 = this.f2390b.get(r15);
            int r17 = r16.f2391a;
            if (r17 < r8) goto L16;
            r16.f2391a = r17 + r10;
        L16:
            r15 = r15 - 1;
            goto L11
        L23:
            return;
        L22:
            return;
        }

        public final void h(int r8, int r10) {
            int[] r11 = this.f2389a;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r8 >= r11.length) goto L24;
            int r12 = r8 + r10;
            b(r12);
            int[] r13 = this.f2389a;
            System.arraycopy(r13, r12, r13, r8, (r13.length - r8) - r10);
            int[] r14 = this.f2389a;
            Arrays.fill(r14, r14.length - r10, r14.length, -1);
            List<FullSpanItem> r15 = this.f2390b;
            if (r15 == null) goto L25;
            int r16 = r15.size() - 1;
        L11:
            if (r16 < 0) goto L26;
            FullSpanItem r17 = this.f2390b.get(r16);
            int r18 = r17.f2391a;
            if (r18 < r8) goto L18;
            if (r18 >= r12) goto L17;
            this.f2390b.remove(r16);
            goto L18
        L17:
            r17.f2391a = r18 - r10;
        L18:
            r16 = r16 - 1;
            goto L11
        L26:
            return;
        L25:
            return;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2396b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2397m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int[] f2398n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f2399o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int[] f2400p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List<LazySpanLookup.FullSpanItem> f2401q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f2402r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f2403s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f2404t;

        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r8) {
                return new SavedState(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r8) {
                return new SavedState[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState() {
        }

        public SavedState(Parcel r8) {
            this.f2395a = r8.readInt();
            this.f2396b = r8.readInt();
            int r10 = r8.readInt();
            this.f2397m = r10;
            if (r10 <= 0) goto L5;
            int[] r11 = new int[r10];
            this.f2398n = r11;
            r8.readIntArray(r11);
        L5:
            int r12 = r8.readInt();
            this.f2399o = r12;
            if (r12 <= 0) goto L8;
            int[] r13 = new int[r12];
            this.f2400p = r13;
            r8.readIntArray(r13);
        L8:
            boolean r14 = false;
            if (r8.readInt() != 1) goto L11;
            boolean r15 = true;
        L12:
            this.f2402r = r15;
            if (r8.readInt() != 1) goto L15;
            boolean r16 = true;
        L16:
            this.f2403s = r16;
            if (r8.readInt() != 1) goto L19;
            r14 = true;
        L19:
            this.f2404t = r14;
            this.f2401q = r8.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
            return;
        L15:
            r16 = false;
            goto L16
        L11:
            r15 = false;
            goto L12
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeInt(this.f2395a);
            r8.writeInt(this.f2396b);
            r8.writeInt(this.f2397m);
            if (this.f2397m <= 0) goto L5;
            r8.writeIntArray(this.f2398n);
        L5:
            r8.writeInt(this.f2399o);
            if (this.f2399o <= 0) goto L8;
            r8.writeIntArray(this.f2400p);
        L8:
            r8.writeInt(this.f2402r ? 1 : 0);
            r8.writeInt(this.f2403s ? 1 : 0);
            r8.writeInt(this.f2404t ? 1 : 0);
            r8.writeList(this.f2401q);
        }

        public SavedState(SavedState r8) {
            this.f2397m = r8.f2397m;
            this.f2395a = r8.f2395a;
            this.f2396b = r8.f2396b;
            this.f2398n = r8.f2398n;
            this.f2399o = r8.f2399o;
            this.f2400p = r8.f2400p;
            this.f2402r = r8.f2402r;
            this.f2403s = r8.f2403s;
            this.f2404t = r8.f2404t;
            this.f2401q = r8.f2401q;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StaggeredGridLayoutManager f2405a;

        public a(StaggeredGridLayoutManager r8) {
            this.f2405a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f2405a.A0();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2410e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f2411f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ StaggeredGridLayoutManager f2412g;

        public b(StaggeredGridLayoutManager r8) {
            this.f2412g = r8;
            a();
        }

        public final void a() {
            this.f2406a = -1;
            this.f2407b = Integer.MIN_VALUE;
            this.f2408c = false;
            this.f2409d = false;
            this.f2410e = false;
            int[] r8 = this.f2411f;
            if (r8 == null) goto L6;
            Arrays.fill(r8, -1);
            return;
        }
    }

    public static class c extends RecyclerView.p {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        d mSpan;

        public c(int r8, int r10) {
            super(r8, r10);
        }

        public final int getSpanIndex() {
            d r8 = this.mSpan;
            if (r8 != null) goto L7;
            return -1;
        L7:
            return r8.f2417e;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean r8) {
            this.mFullSpan = r8;
        }

        public c(Context r8, AttributeSet r10) {
            super(r8, r10);
        }

        public c(ViewGroup.LayoutParams r8) {
            super(r8);
        }

        public c(ViewGroup.MarginLayoutParams r8) {
            super(r8);
        }

        public c(RecyclerView.p r8) {
            super(r8);
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<View> f2413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2416d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2417e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ StaggeredGridLayoutManager f2418f;

        public d(StaggeredGridLayoutManager r8, int r10) {
            this.f2418f = r8;
            this.f2413a = new ArrayList();
            this.f2414b = Integer.MIN_VALUE;
            this.f2415c = Integer.MIN_VALUE;
            this.f2416d = 0;
            this.f2417e = r10;
        }

        public static c j(View r8) {
            return (c) r8.getLayoutParams();
        }

        public final void a(View r8) {
            c r10 = (c) r8.getLayoutParams();
            r10.mSpan = this;
            ArrayList<View> r11 = this.f2413a;
            r11.add(r8);
            this.f2415c = Integer.MIN_VALUE;
            if (r11.size() != 1) goto L6;
            this.f2414b = Integer.MIN_VALUE;
        L6:
            if (r10.isItemRemoved() == false) goto L8;
        L9:
            int r12 = this.f2416d;
            this.f2416d = this.f2418f.f2380r.c(r8) + r12;
            return;
        L8:
            if (r10.isItemChanged() == true) goto L9;
        }

        public final void b() {
            ArrayList<View> r8 = this.f2413a;
            View r10 = r8.get(r8.size() - 1);
            c r11 = j(r10);
            StaggeredGridLayoutManager r12 = this.f2418f;
            this.f2415c = r12.f2380r.b(r10);
            if (r11.mFullSpan == false) goto L14;
            LazySpanLookup.FullSpanItem r13 = r12.B.e(r11.getViewLayoutPosition());
            if (r13 != null) goto L7;
            return;
        L7:
            if (r13.f2392b != 1) goto L16;
            int r14 = this.f2415c;
            int[] r15 = r13.f2393m;
            if (r15 != null) goto L11;
            int r16 = 0;
        L12:
            this.f2415c = r14 + r16;
            return;
        L11:
            r16 = r15[this.f2417e];
            goto L12
        L16:
            return;
        }

        public final void c() {
            int r8 = 0;
            View r10 = this.f2413a.get(0);
            c r11 = j(r10);
            StaggeredGridLayoutManager r12 = this.f2418f;
            this.f2414b = r12.f2380r.e(r10);
            if (r11.mFullSpan == false) goto L14;
            LazySpanLookup.FullSpanItem r13 = r12.B.e(r11.getViewLayoutPosition());
            if (r13 != null) goto L7;
            return;
        L7:
            if (r13.f2392b != (-1)) goto L16;
            int r14 = this.f2414b;
            int[] r15 = r13.f2393m;
            if (r15 == null) goto L12;
            r8 = r15[this.f2417e];
        L12:
            this.f2414b = r14 - r8;
            return;
        L16:
            return;
        }

        public final void d() {
            this.f2413a.clear();
            this.f2414b = Integer.MIN_VALUE;
            this.f2415c = Integer.MIN_VALUE;
            this.f2416d = 0;
        }

        public final int e() {
            boolean r8 = this.f2418f.f2385w;
            ArrayList<View> r10 = this.f2413a;
            if (r8 == false) goto L6;
            return g(r10.size() - 1, -1);
        L6:
            return g(0, r10.size());
        }

        public final int f() {
            boolean r8 = this.f2418f.f2385w;
            ArrayList<View> r10 = this.f2413a;
            if (r8 == false) goto L6;
            return g(0, r10.size());
        L6:
            return g(r10.size() - 1, -1);
        }

        public final int g(int r12, int r13) {
            StaggeredGridLayoutManager r8 = this.f2418f;
            int r10 = r8.f2380r.k();
            int r11 = r8.f2380r.g();
            if (r13 <= r12) goto L5;
            int r14 = 1;
        L6:
            if (r12 == r13) goto L27;
            View r15 = this.f2413a.get(r12);
            int r16 = r8.f2380r.e(r15);
            int r17 = r8.f2380r.b(r15);
            boolean r18 = false;
            if (r16 > r11) goto L10;
            boolean r19 = true;
        L11:
            if (r17 < r10) goto L13;
            r18 = true;
        L13:
            if (r19 == false) goto L18;
            if (r18 == false) goto L18;
            if (r16 < r10) goto L19;
            if (r17 <= r11) goto L18;
        L19:
            return RecyclerView.o.G(r15);
        L18:
            r12 = r12 + r14;
            goto L6
        L10:
            r19 = false;
            goto L11
        L27:
            return -1;
        L5:
            r14 = -1;
            goto L6
        }

        public final int h(int r8) {
            int r10 = this.f2415c;
            if (r10 == Integer.MIN_VALUE) goto L6;
            return r10;
        L6:
            if (this.f2413a.size() != 0) goto L8;
            return r8;
        L8:
            b();
            return this.f2415c;
        }

        public final View i(int r8, int r10) {
            ArrayList<View> r11 = this.f2413a;
            StaggeredGridLayoutManager r12 = this.f2418f;
            View r13 = null;
            if (r10 != (-1)) goto L18;
            int r14 = r11.size();
            int r15 = 0;
        L5:
            if (r15 >= r14) goto L32;
            View r16 = r11.get(r15);
            if (r12.f2385w == false) goto L11;
            if (RecyclerView.o.G(r16) <= r8) goto L32;
        L11:
            if (r12.f2385w == true) goto L16;
            if (RecyclerView.o.G(r16) >= r8) goto L32;
        L16:
            if (r16.hasFocusable() == false) goto L32;
            r15 = r15 + 1;
            r13 = r16;
        L32:
            return r13;
        L18:
            int r17 = r11.size() - 1;
        L19:
            if (r17 < 0) goto L32;
            View r18 = r11.get(r17);
            if (r12.f2385w == false) goto L25;
            if (RecyclerView.o.G(r18) >= r8) goto L32;
        L25:
            if (r12.f2385w == true) goto L30;
            if (RecyclerView.o.G(r18) <= r8) goto L32;
        L30:
            if (r18.hasFocusable() == false) goto L32;
            r17 = r17 - 1;
            r13 = r18;
            goto L19
        }

        public final int k(int r8) {
            int r10 = this.f2414b;
            if (r10 == Integer.MIN_VALUE) goto L6;
            return r10;
        L6:
            if (this.f2413a.size() != 0) goto L8;
            return r8;
        L8:
            c();
            return this.f2414b;
        }

        public final void l() {
            ArrayList<View> r8 = this.f2413a;
            int r10 = r8.size();
            View r11 = r8.remove(r10 - 1);
            c r12 = j(r11);
            r12.mSpan = null;
            if (r12.isItemRemoved() == false) goto L5;
        L6:
            this.f2416d -= this.f2418f.f2380r.c(r11);
        L8:
            if (r10 != 1) goto L10;
            this.f2414b = Integer.MIN_VALUE;
        L10:
            this.f2415c = Integer.MIN_VALUE;
            return;
        L5:
            if (r12.isItemChanged() == false) goto L8;
            goto L6
        }

        public final void m() {
            ArrayList<View> r8 = this.f2413a;
            View r10 = r8.remove(0);
            c r11 = j(r10);
            r11.mSpan = null;
            if (r8.size() != 0) goto L6;
            this.f2415c = Integer.MIN_VALUE;
        L6:
            if (r11.isItemRemoved() == false) goto L8;
        L9:
            this.f2416d -= this.f2418f.f2380r.c(r10);
        L10:
            this.f2414b = Integer.MIN_VALUE;
            return;
        L8:
            if (r11.isItemChanged() == false) goto L10;
            goto L9
        }

        public final void n(View r8) {
            c r10 = (c) r8.getLayoutParams();
            r10.mSpan = this;
            ArrayList<View> r11 = this.f2413a;
            r11.add(0, r8);
            this.f2414b = Integer.MIN_VALUE;
            if (r11.size() != 1) goto L6;
            this.f2415c = Integer.MIN_VALUE;
        L6:
            if (r10.isItemRemoved() == false) goto L8;
        L9:
            int r12 = this.f2416d;
            this.f2416d = this.f2418f.f2380r.c(r8) + r12;
            return;
        L8:
            if (r10.isItemChanged() == true) goto L9;
        }
    }

    public StaggeredGridLayoutManager(Context r8, AttributeSet r10, int r11, int r12) {
        this.f2378p = -1;
        int r13 = 0;
        this.f2385w = false;
        this.f2386x = false;
        this.f2388z = -1;
        this.A = Integer.MIN_VALUE;
        LazySpanLookup r14 = new LazySpanLookup();
        this.B = r14;
        this.C = 2;
        this.H = new Rect();
        this.I = new b(this);
        this.J = false;
        this.K = true;
        this.M = new a(this);
        RecyclerView.o.d r15 = RecyclerView.o.H(r8, r10, r11, r12);
        int r16 = r15.f2330a;
        if (r16 == 0) goto L8;
        if (r16 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation.");
    L8:
        c(null);
        if (r16 == this.f2382t) goto L12;
        this.f2382t = r16;
        s r17 = this.f2380r;
        this.f2380r = this.f2381s;
        this.f2381s = r17;
        k0();
    L12:
        int r18 = r15.f2331b;
        c(null);
        if (r18 == this.f2378p) goto L22;
        int[] r19 = r14.f2389a;
        if (r19 == null) goto L17;
        Arrays.fill(r19, -1);
    L17:
        r14.f2390b = null;
        k0();
        this.f2378p = r18;
        this.f2387y = new BitSet(this.f2378p);
        this.f2379q = new d[this.f2378p];
    L19:
        if (r13 >= this.f2378p) goto L21;
        this.f2379q[r13] = new d(this, r13);
        r13 = r13 + 1;
        goto L19
    L21:
        k0();
    L22:
        boolean r20 = r15.f2332c;
        c(null);
        SavedState r21 = this.F;
        if (r21 != null) goto L25;
    L27:
        this.f2385w = r20;
        k0();
        this.f2384v = new n();
        this.f2380r = s.a(this, this.f2382t);
        this.f2381s = s.a(this, 1 - this.f2382t);
        return;
    L25:
        if (r21.f2402r == r20) goto L27;
        r21.f2402r = r20;
        goto L27
    }

    public static int d1(int r8, int r10, int r11) {
        if (r10 != 0) goto L5;
        if (r11 != 0) goto L5;
        return r8;
    L5:
        int r12 = View.MeasureSpec.getMode(r8);
        if (r12 == Integer.MIN_VALUE) goto L12;
        if (r12 == 1073741824) goto L12;
        return r8;
    L12:
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r8) - r10) - r11), r12);
    }

    public final boolean A0() {
        if (w() != 0) goto L5;
    L39:
        return false;
    L5:
        if (this.C == 0) goto L39;
        if (this.f2319g == false) goto L39;
        if (this.f2386x == false) goto L12;
        int r8 = K0();
        int r10 = J0();
    L13:
        LazySpanLookup r11 = this.B;
        if (r8 != 0) goto L24;
        if (O0() == null) goto L24;
        int[] r12 = r11.f2389a;
        if (r12 == null) goto L20;
        Arrays.fill(r12, -1);
    L20:
        r11.f2390b = null;
    L21:
        this.f2318f = true;
        k0();
        return true;
    L24:
        if (this.J == true) goto L27;
        return false;
    L27:
        if (this.f2386x == false) goto L29;
        int r13 = -1;
    L30:
        int r14 = r10 + 1;
        LazySpanLookup.FullSpanItem r15 = r11.d(r8, r14, r13);
        if (r15 != null) goto L34;
        this.J = false;
        r11.c(r14);
        return false;
    L34:
        LazySpanLookup.FullSpanItem r16 = r11.d(r8, r15.f2391a, r13 * (-1));
        if (r16 != null) goto L37;
        int r17 = r15.f2391a;
    L38:
        r11.c(r17);
        goto L21
    L37:
        r17 = r16.f2391a + 1;
        goto L38
    L29:
        r13 = 1;
        goto L30
    L12:
        r8 = J0();
        r10 = K0();
        goto L13
    }

    public final int B0(RecyclerView.z r8) {
        if (w() != 0) goto L6;
        return 0;
    L6:
        s r10 = this.f2380r;
        boolean r11 = this.K;
        return w.a(r8, r10, G0(!r11), F0(!r11), this, this.K);
    }

    public final int C0(RecyclerView.z r8) {
        if (w() != 0) goto L6;
        return 0;
    L6:
        s r10 = this.f2380r;
        boolean r11 = this.K;
        return w.b(r8, r10, G0(!r11), F0(!r11), this, this.K, this.f2386x);
    }

    public final int D0(RecyclerView.z r8) {
        if (w() != 0) goto L6;
        return 0;
    L6:
        s r10 = this.f2380r;
        boolean r11 = this.K;
        return w.c(r8, r10, G0(!r11), F0(!r11), this, this.K);
    }

    public final int E0(RecyclerView.v r22, n r23, RecyclerView.z r24) {
        RecyclerView.v r8 = r22;
        int r10 = 0;
        int r11 = 1;
        this.f2387y.set(0, this.f2378p, true);
        n r12 = this.f2384v;
        if (r12.f2544i == false) goto L9;
        if (r23.f2540e != 1) goto L7;
        int r13 = Integer.MAX_VALUE;
    L12:
        a1(r23.f2540e, r13);
        if (this.f2386x == false) goto L15;
        int r14 = this.f2380r.g();
    L16:
        boolean r15 = false;
    L17:
        int r16 = r23.f2538c;
        if (r16 >= 0) goto L20;
    L22:
        int r17 = r10;
    L24:
        if (r17 == 0) goto L191;
        if (r12.f2544i == false) goto L28;
    L29:
        View r18 = r8.d(r23.f2538c);
        r23.f2538c += r23.f2539d;
        c r19 = (c) r18.getLayoutParams();
        int r110 = r19.getViewLayoutPosition();
        LazySpanLookup r111 = this.B;
        int[] r112 = r111.f2389a;
        if (r112 != null) goto L32;
    L35:
        int r20 = -1;
    L36:
        if (r20 != (-1)) goto L38;
        int r113 = r11;
    L39:
        if (r113 != 0) goto L41;
        d r21 = this.f2379q[r20];
    L64:
        r19.mSpan = r21;
        if (r23.f2540e != 1) goto L67;
        b(r18, -1, false);
    L69:
        if (r19.mFullSpan == false) goto L75;
        if (this.f2382t != 1) goto L73;
        int r25 = this.G;
    L77:
        int r26 = RecyclerView.o.x(this.f2327o, this.f2325m, C() + F(), true, ((ViewGroup.MarginLayoutParams) r19).height);
        int r27 = r25;
        boolean r28 = false;
    L79:
        Q0(r18, r27, r26, r28);
    L81:
        if (r23.f2540e != 1) goto L98;
        if (r19.mFullSpan == false) goto L85;
        int r29 = L0(r14);
    L86:
        int r30 = this.f2380r.c(r18) + r29;
        if (r113 != 0) goto L89;
    L95:
        int r114 = r30;
    L96:
        int r31 = r114;
    L113:
        if (r19.mFullSpan == true) goto L115;
    L142:
        boolean r32 = true;
    L145:
        if (r23.f2540e != r32) goto L154;
        if (r19.mFullSpan == false) goto L152;
        int r33 = this.f2378p;
    L149:
        r33 = r33 - 1;
        if (r33 < 0) goto L161;
        this.f2379q[r33].a(r18);
    L161:
        if (P0() == false) goto L170;
        if (this.f2382t != 1) goto L170;
        if (r19.mFullSpan == false) goto L167;
        int r34 = this.f2381s.g();
    L168:
        int r115 = r34 - this.f2381s.c(r18);
    L175:
        if (this.f2382t != 1) goto L177;
        int r116 = r115;
        r115 = r29;
        r29 = r116;
        int r210 = r34;
        r34 = r31;
        r31 = r210;
    L177:
        RecyclerView.o.M(r18, r29, r115, r31, r34);
        if (r19.mFullSpan == false) goto L180;
        a1(r12.f2540e, r13);
    L181:
        r8 = r22;
        U0(r8, r12);
        if (r12.f2543h == true) goto L184;
    L189:
        int r35 = 0;
    L190:
        r10 = r35;
        r11 = 1;
        r15 = true;
        goto L17
    L184:
        if (r18.hasFocusable() == false) goto L189;
        if (r19.mFullSpan == false) goto L188;
        this.f2387y.clear();
        goto L189
    L188:
        BitSet r36 = this.f2387y;
        int r37 = r21.f2417e;
        r35 = 0;
        r36.set(r37, false);
        goto L190
    L180:
        c1(r21, r12.f2540e, r13);
        goto L181
    L167:
        r34 = this.f2381s.g() - (((this.f2378p - 1) - r21.f2417e) * this.f2383u);
    L170:
        if (r19.mFullSpan == false) goto L172;
        r115 = this.f2381s.k();
    L173:
        r34 = this.f2381s.c(r18) + r115;
        goto L175
    L172:
        r115 = this.f2381s.k() + (r21.f2417e * this.f2383u);
        goto L173
    L152:
        r19.mSpan.a(r18);
        goto L161
    L154:
        if (r19.mFullSpan == false) goto L159;
        int r38 = this.f2378p;
    L156:
        r38 = r38 - 1;
        if (r38 < 0) goto L161;
        this.f2379q[r38].n(r18);
        goto L156
    L159:
        r19.mSpan.n(r18);
        goto L161
    L115:
        if (r23.f2539d != (-1)) goto L142;
        r32 = true;
        if (r113 == 0) goto L120;
        this.J = true;
        goto L145
    L120:
        if (r23.f2540e != 1) goto L128;
        int r39 = this.f2379q[0].h(Integer.MIN_VALUE);
        int r117 = 1;
    L123:
        if (r117 >= this.f2378p) goto L135;
        if (this.f2379q[r117].h(Integer.MIN_VALUE) != r39) goto L133;
        r117 = r117 + 1;
    L133:
        r32 = true;
        boolean r118 = false;
    L137:
        if ((!r118) == false) goto L145;
        LazySpanLookup.FullSpanItem r119 = r111.e(r110);
        if (r119 == null) goto L141;
        r119.f2394n = r32;
    L141:
        this.J = r32;
    L135:
        r32 = true;
        r118 = true;
        goto L137
    L128:
        int r40 = this.f2379q[0].k(Integer.MIN_VALUE);
        int r120 = 1;
    L130:
        if (r120 >= this.f2378p) goto L135;
        if (this.f2379q[r120].k(Integer.MIN_VALUE) != r40) goto L133;
        r120 = r120 + 1;
        goto L130
    L89:
        if (r19.mFullSpan == false) goto L95;
        LazySpanLookup.FullSpanItem r41 = new LazySpanLookup.FullSpanItem();
        r41.f2393m = new int[this.f2378p];
        int r42 = 0;
    L92:
        if (r42 >= this.f2378p) goto L94;
        r41.f2393m[r42] = r29 - this.f2379q[r42].h(r29);
        r42 = r42 + 1;
        r30 = r30;
        goto L92
    L94:
        r114 = r30;
        r41.f2392b = -1;
        r41.f2391a = r110;
        r111.a(r41);
        goto L96
    L85:
        r29 = r21.h(r14);
        goto L86
    L98:
        if (r19.mFullSpan == false) goto L100;
        int r43 = M0(r14);
    L101:
        r31 = r43;
        int r44 = r31 - this.f2380r.c(r18);
        if (r113 != 0) goto L104;
    L110:
        int r121 = r44;
    L111:
        r29 = r121;
        goto L113
    L104:
        if (r19.mFullSpan == false) goto L110;
        LazySpanLookup.FullSpanItem r45 = new LazySpanLookup.FullSpanItem();
        r45.f2393m = new int[this.f2378p];
        int r46 = 0;
    L107:
        if (r46 >= this.f2378p) goto L109;
        r45.f2393m[r46] = this.f2379q[r46].k(r31) - r31;
        r46 = r46 + 1;
        r44 = r44;
        goto L107
    L109:
        r121 = r44;
        r45.f2392b = 1;
        r45.f2391a = r110;
        r111.a(r45);
        goto L111
    L100:
        r43 = r21.k(r14);
        goto L101
    L73:
        Q0(r18, RecyclerView.o.x(this.f2326n, this.f2324l, E() + D(), true, ((ViewGroup.MarginLayoutParams) r19).width), this.G, false);
        goto L81
    L75:
        if (this.f2382t != 1) goto L78;
        r25 = RecyclerView.o.x(this.f2383u, this.f2324l, 0, false, ((ViewGroup.MarginLayoutParams) r19).width);
        goto L77
    L78:
        r27 = RecyclerView.o.x(this.f2326n, this.f2324l, E() + D(), true, ((ViewGroup.MarginLayoutParams) r19).width);
        r28 = false;
        r26 = RecyclerView.o.x(this.f2383u, this.f2325m, 0, false, ((ViewGroup.MarginLayoutParams) r19).height);
        goto L79
    L67:
        b(r18, 0, false);
        goto L69
    L41:
        if (r19.mFullSpan == false) goto L44;
        r21 = this.f2379q[r10];
    L62:
        r111.b(r110);
        r111.f2389a[r110] = r21.f2417e;
        goto L64
    L44:
        if (S0(r23.f2540e) == false) goto L46;
        int r47 = this.f2378p - r11;
        int r48 = -1;
        int r122 = -1;
    L47:
        d r123 = null;
        if (r23.f2540e != r11) goto L55;
        int r49 = this.f2380r.k();
        int r124 = Integer.MAX_VALUE;
    L50:
        if (r47 == r48) goto L61;
        d r50 = this.f2379q[r47];
        int r51 = r50.h(r49);
        if (r51 >= r124) goto L54;
        r124 = r51;
        r123 = r50;
    L54:
        r47 = r47 + r122;
    L61:
        r21 = r123;
        goto L62
    L55:
        int r52 = this.f2380r.g();
        int r53 = Integer.MIN_VALUE;
    L56:
        if (r47 == r48) goto L61;
        d r54 = this.f2379q[r47];
        int r125 = r54.k(r52);
        if (r125 <= r53) goto L60;
        r123 = r54;
        r53 = r125;
    L60:
        r47 = r47 + r122;
        goto L56
    L46:
        r122 = r11;
        r48 = this.f2378p;
        r47 = r10;
        goto L47
    L38:
        r113 = r10;
        goto L39
    L32:
        if (r110 >= r112.length) goto L35;
        r20 = r112[r110];
        goto L36
    L28:
        if (this.f2387y.isEmpty() == false) goto L29;
    L191:
        int r55 = r10;
        if (r15 == true) goto L195;
        U0(r8, r12);
    L195:
        if (r12.f2540e != (-1)) goto L197;
        int r56 = this.f2380r.k() - M0(this.f2380r.k());
    L198:
        if (r56 <= 0) goto L201;
        return Math.min(r23.f2537b, r56);
    L201:
        return r55;
    L197:
        r56 = L0(this.f2380r.g()) - this.f2380r.g();
        goto L198
    L20:
        if (r16 >= r24.b()) goto L22;
        r17 = r11;
        goto L24
    L15:
        r14 = this.f2380r.k();
        goto L16
    L7:
        r13 = Integer.MIN_VALUE;
        goto L12
    L9:
        if (r23.f2540e != 1) goto L11;
        r13 = r23.f2542g + r23.f2537b;
        goto L12
    L11:
        r13 = r23.f2541f - r23.f2537b;
        goto L12
    }

    public final View F0(boolean r8) {
        int r10 = this.f2380r.k();
        int r11 = this.f2380r.g();
        int r12 = w() - 1;
        View r13 = null;
    L3:
        if (r12 < 0) goto L15;
        View r14 = v(r12);
        int r15 = this.f2380r.e(r14);
        int r16 = this.f2380r.b(r14);
        if (r16 <= r10) goto L14;
        if (r15 >= r11) goto L14;
        if (r16 <= r11) goto L13;
        if (r8 == false) goto L13;
        if (r13 != null) goto L14;
        r13 = r14;
    L13:
        return r14;
    L14:
        r12 = r12 - 1;
        goto L3
    L15:
        return r13;
    }

    public final View G0(boolean r10) {
        int r8 = this.f2380r.k();
        int r11 = this.f2380r.g();
        int r12 = w();
        View r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L15;
        View r15 = v(r14);
        int r16 = this.f2380r.e(r15);
        if (this.f2380r.b(r15) <= r8) goto L14;
        if (r16 >= r11) goto L14;
        if (r16 >= r8) goto L13;
        if (r10 == false) goto L13;
        if (r13 != null) goto L14;
        r13 = r15;
    L13:
        return r15;
    L14:
        r14 = r14 + 1;
        goto L3
    L15:
        return r13;
    }

    public final void H0(RecyclerView.v r8, RecyclerView.z r10, boolean r11) {
        int r12 = L0(Integer.MIN_VALUE);
        if (r12 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        int r13 = this.f2380r.g() - r12;
        if (r13 <= 0) goto L12;
        int r14 = r13 - (-Y0(-r13, r8, r10));
        if (r11 == false) goto L13;
        if (r14 <= 0) goto L14;
        this.f2380r.p(r14);
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int I(RecyclerView.v r8, RecyclerView.z r10) {
        if (this.f2382t != 0) goto L7;
        return this.f2378p;
    L7:
        return super.I(r8, r10);
    }

    public final void I0(RecyclerView.v r8, RecyclerView.z r10, boolean r11) {
        int r12 = M0(Integer.MAX_VALUE);
        if (r12 != Integer.MAX_VALUE) goto L5;
        return;
    L5:
        int r13 = r12 - this.f2380r.k();
        if (r13 <= 0) goto L12;
        int r14 = r13 - Y0(r13, r8, r10);
        if (r11 == false) goto L13;
        if (r14 <= 0) goto L14;
        this.f2380r.p(-r14);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final int J0() {
        if (w() != 0) goto L6;
        return 0;
    L6:
        return RecyclerView.o.G(v(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean K() {
        if (this.C == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int K0() {
        int r8 = w();
        if (r8 != 0) goto L6;
        return 0;
    L6:
        return RecyclerView.o.G(v(r8 - 1));
    }

    public final int L0(int r8) {
        int r10 = this.f2379q[0].h(r8);
        int r11 = 1;
    L4:
        if (r11 >= this.f2378p) goto L9;
        int r12 = this.f2379q[r11].h(r8);
        if (r12 <= r10) goto L8;
        r10 = r12;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    public final int M0(int r8) {
        int r10 = this.f2379q[0].k(r8);
        int r11 = 1;
    L4:
        if (r11 >= this.f2378p) goto L9;
        int r12 = this.f2379q[r11].k(r8);
        if (r12 >= r10) goto L8;
        r10 = r12;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void N(int r8) {
        super.N(r8);
        int r10 = 0;
    L4:
        if (r10 >= this.f2378p) goto L12;
        d r11 = this.f2379q[r10];
        int r12 = r11.f2414b;
        if (r12 == Integer.MIN_VALUE) goto L8;
        r11.f2414b = r12 + r8;
    L8:
        int r13 = r11.f2415c;
        if (r13 == Integer.MIN_VALUE) goto L11;
        r11.f2415c = r13 + r8;
    L11:
        r10 = r10 + 1;
        goto L4
    }

    public final void N0(int r8, int r10, int r11) {
        if (this.f2386x == false) goto L5;
        int r12 = K0();
    L7:
        if (r11 != 8) goto L11;
        if (r8 >= r10) goto L10;
        int r13 = r10 + 1;
    L12:
        int r14 = r8;
    L13:
        LazySpanLookup r15 = this.B;
        r15.f(r14);
        if (r11 != 1) goto L16;
        r15.g(r8, r10);
    L22:
        if (r13 > r12) goto L25;
        return;
    L25:
        if (this.f2386x == false) goto L27;
        int r16 = J0();
    L28:
        if (r14 > r16) goto L31;
        k0();
        return;
    L31:
        return;
    L27:
        r16 = K0();
        goto L28
    L16:
        if (r11 == 2) goto L20;
        if (r11 != 8) goto L22;
        r15.h(r8, 1);
        r15.g(r10, 1);
        goto L22
    L20:
        r15.h(r8, r10);
        goto L22
    L10:
        r13 = r8 + 1;
        r14 = r10;
        goto L13
    L11:
        r13 = r8 + r10;
        goto L12
    L5:
        r12 = J0();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void O(int r8) {
        super.O(r8);
        int r10 = 0;
    L4:
        if (r10 >= this.f2378p) goto L12;
        d r11 = this.f2379q[r10];
        int r12 = r11.f2414b;
        if (r12 == Integer.MIN_VALUE) goto L8;
        r11.f2414b = r12 + r8;
    L8:
        int r13 = r11.f2415c;
        if (r13 == Integer.MIN_VALUE) goto L11;
        r11.f2415c = r13 + r8;
    L11:
        r10 = r10 + 1;
        goto L4
    }

    public final View O0() {
        int r8 = w() - 1;
        BitSet r10 = new BitSet(this.f2378p);
        r10.set(0, this.f2378p, true);
        if (this.f2382t == 1) goto L5;
    L7:
        byte r11 = -1;
    L9:
        if (this.f2386x == false) goto L11;
        int r12 = -1;
    L12:
        if (r8 >= r12) goto L14;
        int r13 = 1;
    L15:
        if (r8 == r12) goto L68;
        View r14 = v(r8);
        c r15 = (c) r14.getLayoutParams();
        if (r10.get(r15.mSpan.f2417e) == false) goto L40;
        d r16 = r15.mSpan;
        if (this.f2386x == false) goto L27;
        int r17 = r16.f2415c;
        if (r17 != Integer.MIN_VALUE) goto L25;
        r16.b();
        r17 = r16.f2415c;
    L25:
        if (r17 >= this.f2380r.g()) goto L35;
        ArrayList<View> r18 = r16.f2413a;
        View r19 = r18.get(r18.size() - 1);
    L34:
        r16.getClass();
        boolean r110 = !d.j(r19).mFullSpan;
    L36:
        if (r110 == true) goto L37;
        r10.clear(r15.mSpan.f2417e);
        goto L40
    L37:
        return r14;
    L35:
        r110 = false;
        goto L36
    L27:
        int r111 = r16.f2414b;
        if (r111 != Integer.MIN_VALUE) goto L32;
        r16.c();
        r111 = r16.f2414b;
    L32:
        if (r111 <= this.f2380r.k()) goto L35;
        r19 = r16.f2413a.get(0);
    L40:
        if (r15.mFullSpan == true) goto L67;
        int r112 = r8 + r13;
        if (r112 == r12) goto L67;
        View r113 = v(r112);
        if (this.f2386x == false) goto L51;
        int r114 = this.f2380r.b(r14);
        int r115 = this.f2380r.b(r113);
        if (r114 < r115) goto L48;
        if (r114 == r115) goto L55;
    L56:
        boolean r116 = false;
    L57:
        if (r116 == false) goto L67;
        if ((r15.mSpan.f2417e - ((c) r113.getLayoutParams()).mSpan.f2417e) >= 0) goto L61;
        boolean r20 = true;
    L62:
        if (r11 >= 0) goto L64;
        boolean r117 = true;
    L65:
        if (r20 == r117) goto L67;
        return r14;
    L64:
        r117 = false;
        goto L65
    L61:
        r20 = false;
    L55:
        r116 = true;
        goto L57
    L48:
        return r14;
    L51:
        int r118 = this.f2380r.e(r14);
        int r119 = this.f2380r.e(r113);
        if (r118 > r119) goto L53;
        if (r118 != r119) goto L56;
    L53:
        return r14;
    L67:
        r8 = r8 + r13;
        goto L15
    L68:
        return null;
    L14:
        r13 = -1;
        goto L15
    L11:
        r12 = r8 + 1;
        r8 = 0;
        goto L12
    L5:
        if (P0() == false) goto L7;
        r11 = 1;
        goto L9
    }

    public final boolean P0() {
        if (B() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void Q(RecyclerView r8) {
        RecyclerView r10 = this.f2314b;
        if (r10 == null) goto L5;
        r10.removeCallbacks(this.M);
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.f2378p) goto L9;
        this.f2379q[r11].d();
        r11 = r11 + 1;
        goto L7
    L9:
        r8.requestLayout();
    }

    public final void Q0(View r8, int r10, int r11, boolean r12) {
        Rect r13 = this.H;
        d(r8, r13);
        c r14 = (c) r8.getLayoutParams();
        int r15 = d1(r10, ((ViewGroup.MarginLayoutParams) r14).leftMargin + r13.left, ((ViewGroup.MarginLayoutParams) r14).rightMargin + r13.right);
        int r16 = d1(r11, ((ViewGroup.MarginLayoutParams) r14).topMargin + r13.top, ((ViewGroup.MarginLayoutParams) r14).bottomMargin + r13.bottom);
        if (t0(r8, r15, r16, r14) == false) goto L6;
        r8.measure(r15, r16);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final View R(View r10, int r11, RecyclerView.v r12, RecyclerView.z r13) {
        if (w() != 0) goto L5;
        return null;
    L5:
        RecyclerView r8 = this.f2314b;
        if (r8 != null) goto L8;
    L7:
        View r14 = null;
    L14:
        if (r14 != null) goto L16;
        return null;
    L16:
        X0();
        if (r11 == 1) goto L49;
        if (r11 == 2) goto L43;
        if (r11 == 17) goto L39;
        if (r11 == 33) goto L36;
        if (r11 == 66) goto L33;
        if (r11 == 130) goto L30;
    L41:
        int r15 = Integer.MIN_VALUE;
    L55:
        if (r15 != Integer.MIN_VALUE) goto L57;
        return null;
    L57:
        c r16 = (c) r14.getLayoutParams();
        boolean r17 = r16.mFullSpan;
        d r18 = r16.mSpan;
        if (r15 != 1) goto L60;
        int r19 = K0();
    L61:
        b1(r19, r13);
        Z0(r15);
        n r20 = this.f2384v;
        r20.f2538c = r20.f2539d + r19;
        r20.f2537b = (int) (this.f2380r.l() * 0.33333334f);
        r20.f2543h = true;
        int r21 = 0;
        r20.f2536a = false;
        E0(r12, r20, r13);
        this.D = this.f2386x;
        if (r17 == true) goto L68;
        View r110 = r18.i(r19, r15);
        if (r110 == null) goto L68;
        if (r110 == r14) goto L68;
        return r110;
    L68:
        if (S0(r15) == false) goto L76;
        int r111 = this.f2378p - 1;
    L70:
        if (r111 < 0) goto L84;
        View r112 = this.f2379q[r111].i(r19, r15);
        if (r112 == null) goto L75;
        if (r112 == r14) goto L75;
        return r112;
    L75:
        r111 = r111 - 1;
    L84:
        boolean r113 = !this.f2385w;
        if (r15 != (-1)) goto L87;
        boolean r114 = true;
    L88:
        if (r113 != r114) goto L90;
        boolean r115 = true;
    L91:
        if (r17 == true) goto L100;
        if (r115 == false) goto L94;
        int r116 = r18.e();
    L95:
        View r117 = r(r116);
        if (r117 == null) goto L100;
        if (r117 == r14) goto L100;
        return r117;
    L94:
        r116 = r18.f();
    L100:
        if (S0(r15) == false) goto L116;
        int r118 = this.f2378p - 1;
    L102:
        if (r118 < 0) goto L126;
        if (r118 == r18.f2417e) goto L114;
        d[] r119 = this.f2379q;
        if (r115 == false) goto L109;
        int r120 = r119[r118].e();
    L110:
        View r121 = r(r120);
        if (r121 == null) goto L114;
        if (r121 == r14) goto L114;
        return r121;
    L109:
        r120 = r119[r118].f();
    L114:
        r118 = r118 - 1;
    L126:
        return null;
    L116:
        if (r21 >= this.f2378p) goto L126;
        d[] r122 = this.f2379q;
        if (r115 == false) goto L120;
        int r123 = r122[r21].e();
    L121:
        View r124 = r(r123);
        if (r124 == null) goto L125;
        if (r124 == r14) goto L125;
        return r124;
    L125:
        r21 = r21 + 1;
        goto L116
    L120:
        r123 = r122[r21].f();
        goto L121
    L90:
        r115 = false;
        goto L91
    L87:
        r114 = false;
        goto L88
    L76:
        int r125 = 0;
    L78:
        if (r125 >= this.f2378p) goto L84;
        View r126 = this.f2379q[r125].i(r19, r15);
        if (r126 == null) goto L83;
        if (r126 == r14) goto L83;
        return r126;
    L83:
        r125 = r125 + 1;
        goto L78
    L60:
        r19 = J0();
        goto L61
    L30:
        if (this.f2382t != 1) goto L41;
    L53:
        r15 = 1;
        goto L55
    L33:
        if (this.f2382t != 0) goto L41;
    L36:
        if (this.f2382t != 1) goto L41;
    L54:
        r15 = -1;
        goto L55
    L39:
        if (this.f2382t != 0) goto L41;
    L43:
        if (this.f2382t == 1) goto L53;
        if (P0() == false) goto L53;
    L49:
        if (this.f2382t == 1) goto L54;
        if (P0() == false) goto L54;
    L8:
        r14 = r8.findContainingItemView(r10);
        if (r14 == null) goto L7;
        if (this.f2313a.j(r14) == false) goto L14;
        goto L14
    }

    public final void R0(RecyclerView.v r17, RecyclerView.z r18, boolean r19) {
        SavedState r8 = this.F;
        b r10 = this.I;
        if (r8 != null) goto L7;
        if (this.f2388z != (-1)) goto L7;
    L10:
        boolean r11 = true;
        if (r10.f2410e == true) goto L13;
    L18:
        boolean r12 = true;
    L19:
        StaggeredGridLayoutManager r13 = r10.f2412g;
        LazySpanLookup r14 = this.B;
        if (r12 == false) goto L138;
        r10.a();
        SavedState r15 = this.F;
        if (r15 == null) goto L51;
        int r16 = r15.f2397m;
        if (r16 > 0) goto L26;
    L39:
        SavedState r110 = this.F;
        this.E = r110.f2404t;
        boolean r111 = r110.f2402r;
        c(null);
        SavedState r112 = this.F;
        if (r112 != null) goto L42;
    L44:
        this.f2385w = r111;
        k0();
        X0();
        SavedState r113 = this.F;
        int r114 = r113.f2395a;
        if (r114 == (-1)) goto L47;
        this.f2388z = r114;
        boolean r115 = r113.f2403s;
    L48:
        r10.f2408c = r115;
        if (r113.f2399o <= 1) goto L53;
        r14.f2389a = r113.f2400p;
        r14.f2390b = r113.f2401q;
    L53:
        if (r18.f2370g == true) goto L115;
        int r116 = this.f2388z;
        if (r116 == (-1)) goto L115;
        if (r116 >= 0) goto L59;
    L114:
        this.f2388z = -1;
        this.A = Integer.MIN_VALUE;
        goto L115
    L59:
        if (r116 >= r18.b()) goto L114;
        SavedState r117 = this.F;
        if (r117 != null) goto L64;
    L69:
        View r118 = r(this.f2388z);
        if (r118 != null) goto L72;
        int r119 = this.f2388z;
        r10.f2406a = r119;
        int r120 = this.A;
        if (r120 != Integer.MIN_VALUE) goto L108;
        if (z0(r119) != 1) goto L101;
        boolean r121 = true;
    L102:
        r10.f2408c = r121;
        if (r121 == false) goto L105;
        int r122 = r13.f2380r.g();
    L106:
        r10.f2407b = r122;
    L112:
        r10.f2409d = true;
    L113:
        boolean r123 = true;
    L116:
        if (r123 == true) goto L136;
        boolean r124 = this.D;
        int r125 = r18.b();
        if (r124 == false) goto L127;
        int r126 = w();
    L121:
        r126 = r126 - 1;
        if (r126 < 0) goto L134;
        int r127 = RecyclerView.o.G(v(r126));
        if (r127 < 0) goto L121;
        if (r127 >= r125) goto L121;
    L135:
        r10.f2406a = r127;
        r10.f2407b = Integer.MIN_VALUE;
    L134:
        r127 = 0;
        goto L135
    L127:
        int r128 = w();
        int r129 = 0;
    L128:
        if (r129 >= r128) goto L134;
        int r130 = RecyclerView.o.G(v(r129));
        if (r130 < 0) goto L133;
        if (r130 >= r125) goto L133;
        r127 = r130;
    L133:
        r129 = r129 + 1;
    L136:
        r10.f2410e = true;
        goto L138
    L105:
        r122 = r13.f2380r.k();
        goto L106
    L101:
        r121 = false;
        goto L102
    L108:
        if (r10.f2408c == false) goto L110;
        int r131 = r13.f2380r.g() - r120;
    L111:
        r10.f2407b = r131;
        goto L112
    L110:
        r131 = r13.f2380r.k() + r120;
        goto L111
    L72:
        if (this.f2386x == false) goto L74;
        int r132 = K0();
    L75:
        r10.f2406a = r132;
        if (this.A == Integer.MIN_VALUE) goto L83;
        if (r10.f2408c == false) goto L80;
        int r133 = this.f2380r.g() - this.A;
        int r134 = this.f2380r.b(r118);
    L81:
        int r135 = r133 - r134;
    L94:
        r10.f2407b = r135;
        goto L113
    L80:
        r133 = this.f2380r.k() + this.A;
        r134 = this.f2380r.e(r118);
        goto L81
    L83:
        if (this.f2380r.c(r118) <= this.f2380r.l()) goto L88;
        boolean r136 = r10.f2408c;
        s r137 = this.f2380r;
        if (r136 == false) goto L87;
        int r138 = r137.g();
    L91:
        r10.f2407b = r138;
        goto L113
    L87:
        r138 = r137.k();
        goto L91
    L88:
        int r139 = this.f2380r.e(r118) - this.f2380r.k();
        if (r139 >= 0) goto L92;
        r138 = -r139;
        goto L91
    L92:
        r135 = this.f2380r.g() - this.f2380r.b(r118);
        if (r135 < 0) goto L94;
        r10.f2407b = Integer.MIN_VALUE;
        goto L113
    L74:
        r132 = J0();
        goto L75
    L64:
        if (r117.f2395a == (-1)) goto L69;
        if (r117.f2397m < 1) goto L69;
        r10.f2407b = Integer.MIN_VALUE;
        r10.f2406a = this.f2388z;
    L115:
        r123 = false;
        goto L116
    L47:
        r115 = this.f2386x;
        goto L48
    L42:
        if (r112.f2402r == r111) goto L44;
        r112.f2402r = r111;
        goto L44
    L26:
        if (r16 != this.f2378p) goto L38;
        int r140 = 0;
    L29:
        if (r140 >= this.f2378p) goto L39;
        this.f2379q[r140].d();
        SavedState r141 = this.F;
        int r142 = r141.f2398n[r140];
        if (r142 == Integer.MIN_VALUE) goto L37;
        if (r141.f2403s == false) goto L35;
        int r143 = this.f2380r.g();
    L36:
        r142 = r142 + r143;
        goto L37
    L35:
        r143 = this.f2380r.k();
    L37:
        d r144 = this.f2379q[r140];
        r144.f2414b = r142;
        r144.f2415c = r142;
        r140 = r140 + 1;
        goto L29
    L38:
        r15.f2398n = null;
        r15.f2397m = 0;
        r15.f2399o = 0;
        r15.f2400p = null;
        r15.f2401q = null;
        r15.f2395a = r15.f2396b;
        goto L39
    L51:
        X0();
        r10.f2408c = this.f2386x;
    L138:
        if (this.F != null) goto L150;
        if (this.f2388z != (-1)) goto L150;
        if (r10.f2408c == this.D) goto L144;
    L145:
        int[] r145 = r14.f2389a;
        if (r145 == null) goto L148;
        Arrays.fill(r145, -1);
    L148:
        r14.f2390b = null;
        r10.f2409d = true;
        goto L150
    L144:
        if (P0() != this.E) goto L145;
    L150:
        if (w() <= 0) goto L202;
        SavedState r20 = this.F;
        if (r20 == null) goto L156;
        if (r20.f2397m >= 1) goto L202;
    L156:
        if (r10.f2409d == false) goto L164;
        int r21 = 0;
    L159:
        if (r21 >= this.f2378p) goto L202;
        this.f2379q[r21].d();
        int r22 = r10.f2407b;
        if (r22 == Integer.MIN_VALUE) goto L163;
        d r23 = this.f2379q[r21];
        r23.f2414b = r22;
        r23.f2415c = r22;
    L163:
        r21 = r21 + 1;
        goto L159
    L164:
        if (r12 == false) goto L166;
    L172:
        int r24 = 0;
    L174:
        if (r24 >= this.f2378p) goto L194;
        d r25 = this.f2379q[r24];
        boolean r146 = this.f2386x;
        int r147 = r10.f2407b;
        if (r146 == false) goto L178;
        int r148 = r25.h(Integer.MIN_VALUE);
    L179:
        r25.d();
        if (r148 == Integer.MIN_VALUE) goto L193;
        StaggeredGridLayoutManager r149 = r25.f2418f;
        if (r146 == true) goto L185;
    L186:
        if (r146 == false) goto L188;
    L190:
        if (r147 == Integer.MIN_VALUE) goto L192;
        r148 = r148 + r147;
    L192:
        r25.f2415c = r148;
        r25.f2414b = r148;
        goto L193
    L188:
        if (r148 <= r149.f2380r.k()) goto L190;
    L185:
        if (r148 >= r149.f2380r.g()) goto L186;
    L193:
        r24 = r24 + 1;
        goto L174
    L178:
        r148 = r25.k(Integer.MIN_VALUE);
        goto L179
    L194:
        d[] r26 = this.f2379q;
        int r27 = r26.length;
        int[] r150 = r10.f2411f;
        if (r150 != null) goto L197;
    L198:
        r10.f2411f = new int[r13.f2379q.length];
    L199:
        int r28 = 0;
    L200:
        if (r28 >= r27) goto L202;
        r10.f2411f[r28] = r26[r28].k(Integer.MIN_VALUE);
        r28 = r28 + 1;
        goto L200
    L197:
        if (r150.length >= r27) goto L199;
    L166:
        if (r10.f2411f == null) goto L172;
        int r29 = 0;
    L170:
        if (r29 >= this.f2378p) goto L202;
        d r30 = this.f2379q[r29];
        r30.d();
        int r31 = r10.f2411f[r29];
        r30.f2414b = r31;
        r30.f2415c = r31;
        r29 = r29 + 1;
    L202:
        q(r17);
        n r32 = this.f2384v;
        r32.f2536a = false;
        this.J = false;
        int r33 = this.f2381s.l();
        this.f2383u = r33 / this.f2378p;
        this.G = View.MeasureSpec.makeMeasureSpec(r33, this.f2381s.i());
        b1(r10.f2406a, r18);
        if (r10.f2408c == false) goto L205;
        Z0(-1);
        E0(r17, r32, r18);
        Z0(1);
    L206:
        r32.f2538c = r10.f2406a + r32.f2539d;
        E0(r17, r32, r18);
        if (this.f2381s.i() == 1073741824) goto L241;
        int r34 = w();
        float r35 = 0.0f;
        int r36 = 0;
    L210:
        if (r36 >= r34) goto L219;
        View r37 = v(r36);
        float r151 = this.f2381s.c(r37);
        if (r151 < r35) goto L218;
        if (((c) r37.getLayoutParams()).isFullSpan() == false) goto L217;
        r151 = (r151 * 1.0f) / this.f2378p;
    L217:
        r35 = Math.max(r35, r151);
    L218:
        r36 = r36 + 1;
        goto L210
    L219:
        int r38 = this.f2383u;
        int r39 = Math.round(r35 * this.f2378p);
        if (this.f2381s.i() != Integer.MIN_VALUE) goto L222;
        r39 = Math.min(r39, this.f2381s.l());
    L222:
        this.f2383u = r39 / this.f2378p;
        this.G = View.MeasureSpec.makeMeasureSpec(r39, this.f2381s.i());
        if (this.f2383u == r38) goto L241;
        int r40 = 0;
    L226:
        if (r40 >= r34) goto L241;
        View r41 = v(r40);
        c r152 = (c) r41.getLayoutParams();
        if (r152.mFullSpan == true) goto L239;
        if (P0() == true) goto L233;
    L235:
        int r153 = r152.mSpan.f2417e;
        int r154 = this.f2382t;
        int r155 = (this.f2383u * r153) - (r153 * r38);
        if (r154 != 1) goto L238;
        r41.offsetLeftAndRight(r155);
        goto L239
    L238:
        r41.offsetTopAndBottom(r155);
        goto L239
    L233:
        if (this.f2382t != 1) goto L235;
        int r156 = this.f2378p;
        int r157 = r152.mSpan.f2417e;
        r41.offsetLeftAndRight(((-((r156 - 1) - r157)) * this.f2383u) - ((-((r156 - 1) - r157)) * r38));
    L239:
        r40 = r40 + 1;
    L241:
        if (w() > 0) goto L243;
    L246:
        if (r19 == true) goto L248;
    L266:
        r11 = false;
    L268:
        if (r18.f2370g == false) goto L270;
        r10.a();
    L270:
        this.D = r10.f2408c;
        this.E = P0();
        if (r11 == false) goto L305;
        r10.a();
        R0(r17, r18, false);
        return;
    L305:
        return;
    L248:
        if (r18.f2370g == true) goto L266;
        if (this.C != 0) goto L252;
    L258:
        boolean r42 = false;
    L259:
        if (r42 == false) goto L266;
        RecyclerView r43 = this.f2314b;
        if (r43 == null) goto L264;
        r43.removeCallbacks(this.M);
    L264:
        if (A0() == false) goto L266;
    L252:
        if (w() <= 0) goto L258;
        if (this.J == false) goto L256;
    L257:
        r42 = true;
        goto L259
    L256:
        if (O0() == null) goto L258;
    L243:
        if (this.f2386x == false) goto L245;
        H0(r17, r18, true);
        I0(r17, r18, false);
        goto L246
    L245:
        I0(r17, r18, true);
        H0(r17, r18, false);
        goto L246
    L205:
        Z0(1);
        E0(r17, r32, r18);
        Z0(-1);
        goto L206
    L13:
        if (this.f2388z != (-1)) goto L18;
        if (this.F != null) goto L18;
        r12 = false;
    L7:
        if (r18.b() != 0) goto L10;
        f0(r17);
        r10.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void S(AccessibilityEvent r8) {
        super.S(r8);
        if (w() <= 0) goto L13;
        View r10 = G0(false);
        View r11 = F0(false);
        if (r10 == null) goto L14;
        if (r11 == null) goto L16;
        int r12 = RecyclerView.o.G(r10);
        int r13 = RecyclerView.o.G(r11);
        if (r12 >= r13) goto L11;
        r8.setFromIndex(r12);
        r8.setToIndex(r13);
        return;
    L11:
        r8.setFromIndex(r13);
        r8.setToIndex(r12);
        return;
    L16:
        return;
    L14:
        return;
    }

    public final boolean S0(int r8) {
        if (this.f2382t != 0) goto L12;
        if (r8 != (-1)) goto L6;
        boolean r10 = true;
    L8:
        if (r10 == this.f2386x) goto L11;
        return true;
    L11:
        return false;
    L6:
        r10 = false;
        goto L8
    L12:
        if (r8 != (-1)) goto L14;
        boolean r11 = true;
    L16:
        if (r11 != this.f2386x) goto L18;
        boolean r12 = true;
    L20:
        if (r12 != P0()) goto L23;
        return true;
    L23:
        return false;
    L18:
        r12 = false;
        goto L20
    L14:
        r11 = false;
        goto L16
    }

    public final void T0(int r8, RecyclerView.z r10) {
        if (r8 <= 0) goto L5;
        int r11 = K0();
        int r12 = 1;
    L6:
        n r13 = this.f2384v;
        r13.f2536a = true;
        b1(r11, r10);
        Z0(r12);
        r13.f2538c = r11 + r13.f2539d;
        r13.f2537b = Math.abs(r8);
        return;
    L5:
        r11 = J0();
        r12 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void U(RecyclerView.v r8, RecyclerView.z r10, View r11, k0.f r12) {
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        if ((r13 instanceof c) == true) goto L6;
        T(r11, r12);
        return;
    L6:
        c r14 = (c) r13;
        int r15 = -1;
        int r16 = 1;
        if (this.f2382t != 0) goto L12;
        int r17 = r14.getSpanIndex();
        if (r14.mFullSpan == false) goto L11;
        r16 = this.f2378p;
    L11:
        int r18 = -1;
        r15 = r17;
        int r19 = -1;
    L16:
        r12.h(k0.f.c.a(r15, r16, r19, r18, false));
        return;
    L12:
        r19 = r14.getSpanIndex();
        if (r14.mFullSpan == false) goto L15;
        r16 = this.f2378p;
    L15:
        r18 = r16;
        r16 = -1;
        goto L16
    }

    public final void U0(RecyclerView.v r8, n r10) {
        if (r10.f2536a == true) goto L5;
        return;
    L5:
        if (r10.f2544i == false) goto L8;
        return;
    L8:
        if (r10.f2537b == 0) goto L10;
        int r11 = 1;
        if (r10.f2540e != (-1)) goto L28;
        int r12 = r10.f2541f;
        int r13 = this.f2379q[0].k(r12);
    L19:
        if (r11 >= this.f2378p) goto L24;
        int r14 = this.f2379q[r11].k(r12);
        if (r14 <= r13) goto L23;
        r13 = r14;
    L23:
        r11 = r11 + 1;
        goto L19
    L24:
        int r15 = r12 - r13;
        if (r15 < 0) goto L11;
        int r16 = r10.f2542g - Math.min(r15, r10.f2537b);
    L12:
        V0(r16, r8);
        return;
    L11:
        r16 = r10.f2542g;
        goto L12
    L28:
        int r17 = r10.f2542g;
        int r18 = this.f2379q[0].h(r17);
    L30:
        if (r11 >= this.f2378p) goto L35;
        int r19 = this.f2379q[r11].h(r17);
        if (r19 >= r18) goto L34;
        r18 = r19;
    L34:
        r11 = r11 + 1;
        goto L30
    L35:
        int r20 = r18 - r10.f2542g;
        if (r20 < 0) goto L13;
        int r21 = r10.f2541f;
        int r22 = Math.min(r20, r10.f2537b) + r21;
    L14:
        W0(r22, r8);
        return;
    L13:
        r22 = r10.f2541f;
        goto L14
    L10:
        if (r10.f2540e != (-1)) goto L13;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void V(int r8, int r10) {
        N0(r8, r10, 1);
    }

    public final void V0(int r8, RecyclerView.v r10) {
        int r11 = w() - 1;
    L3:
        if (r11 < 0) goto L25;
        View r12 = v(r11);
        if (this.f2380r.e(r12) < r8) goto L34;
        if (this.f2380r.o(r12) < r8) goto L35;
        c r13 = (c) r12.getLayoutParams();
        if (r13.mFullSpan == false) goto L21;
        int r14 = 0;
        int r15 = 0;
    L12:
        if (r15 >= this.f2378p) goto L18;
        if (this.f2379q[r15].f2413a.size() == 1) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r14 >= this.f2378p) goto L24;
        this.f2379q[r14].l();
        r14 = r14 + 1;
    L24:
        h0(r12, r10);
        r11 = r11 - 1;
        goto L3
    L21:
        if (r13.mSpan.f2413a.size() == 1) goto L22;
        r13.mSpan.l();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void W() {
        LazySpanLookup r8 = this.B;
        int[] r10 = r8.f2389a;
        if (r10 == null) goto L5;
        Arrays.fill(r10, -1);
    L5:
        r8.f2390b = null;
        k0();
    }

    public final void W0(int r8, RecyclerView.v r10) {
    L3:
        if (w() <= 0) goto L25;
        int r11 = 0;
        View r12 = v(0);
        if (this.f2380r.b(r12) > r8) goto L34;
        if (this.f2380r.n(r12) > r8) goto L35;
        c r13 = (c) r12.getLayoutParams();
        if (r13.mFullSpan == false) goto L21;
        int r14 = 0;
    L12:
        if (r14 >= this.f2378p) goto L18;
        if (this.f2379q[r14].f2413a.size() == 1) goto L15;
        r14 = r14 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r11 >= this.f2378p) goto L24;
        this.f2379q[r11].m();
        r11 = r11 + 1;
    L24:
        h0(r12, r10);
        goto L3
    L21:
        if (r13.mSpan.f2413a.size() == 1) goto L22;
        r13.mSpan.m();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void X(int r8, int r10) {
        N0(r8, r10, 8);
    }

    public final void X0() {
        if (this.f2382t != 1) goto L5;
    L8:
        boolean r8 = this.f2385w;
    L9:
        this.f2386x = r8;
        return;
    L5:
        if (P0() == false) goto L8;
        r8 = !this.f2385w;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void Y(int r8, int r10) {
        N0(r8, r10, 2);
    }

    public final int Y0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        if (w() == 0) goto L14;
        if (r8 == 0) goto L14;
        T0(r8, r11);
        n r12 = this.f2384v;
        int r13 = E0(r10, r12, r11);
        if (r12.f2537b < r13) goto L12;
        if (r8 >= 0) goto L11;
        r8 = -r13;
        goto L12
    L11:
        r8 = r13;
    L12:
        this.f2380r.p(-r8);
        this.D = this.f2386x;
        r12.f2537b = 0;
        U0(r10, r12);
        return r8;
    L14:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void Z(int r8, int r10) {
        N0(r8, r10, 4);
    }

    public final void Z0(int r8) {
        n r10 = this.f2384v;
        r10.f2540e = r8;
        boolean r11 = this.f2386x;
        int r12 = 1;
        if (r8 != (-1)) goto L5;
        boolean r13 = true;
    L6:
        if (r11 == r13) goto L9;
        r12 = -1;
    L9:
        r10.f2539d = r12;
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public final PointF a(int r8) {
        int r10 = z0(r8);
        PointF r11 = new PointF();
        if (r10 != 0) goto L7;
        return null;
    L7:
        if (this.f2382t != 0) goto L9;
        r11.x = r10;
        r11.y = 0.0f;
    L10:
        return r11;
    L9:
        r11.x = 0.0f;
        r11.y = r10;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void a0(RecyclerView.v r8, RecyclerView.z r10) {
        R0(r8, r10, true);
    }

    public final void a1(int r8, int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f2378p) goto L10;
        if (this.f2379q[r11].f2413a.isEmpty() == true) goto L9;
        c1(this.f2379q[r11], r8, r10);
    L9:
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void b0(RecyclerView.z r8) {
        this.f2388z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.I.a();
    }

    public final void b1(int r8, RecyclerView.z r10) {
        n r11 = this.f2384v;
        boolean r12 = false;
        r11.f2537b = 0;
        r11.f2538c = r8;
        RecyclerView.y r13 = this.f2317e;
        if (r13 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r14 == false) goto L18;
        int r15 = r10.f2364a;
        if (r15 == (-1)) goto L18;
        boolean r16 = this.f2386x;
        if (r15 >= r8) goto L14;
        boolean r17 = true;
    L15:
        if (r16 != r17) goto L17;
        int r18 = this.f2380r.l();
        int r19 = 0;
    L19:
        RecyclerView r20 = this.f2314b;
        if (r20 != null) goto L22;
    L24:
        boolean r21 = false;
    L25:
        if (r21 == false) goto L27;
        r11.f2541f = this.f2380r.k() - r19;
        r11.f2542g = this.f2380r.g() + r18;
    L28:
        r11.f2543h = false;
        r11.f2536a = true;
        if (this.f2380r.i() == 0) goto L31;
    L33:
        r11.f2544i = r12;
        return;
    L31:
        if (this.f2380r.f() != 0) goto L33;
        r12 = true;
        goto L33
    L27:
        r11.f2542g = this.f2380r.f() + r18;
        r11.f2541f = -r19;
        goto L28
    L22:
        if (r20.mClipToPadding == false) goto L24;
        r21 = true;
        goto L25
    L17:
        r19 = this.f2380r.l();
        r18 = 0;
        goto L19
    L14:
        r17 = false;
    L18:
        r18 = 0;
        r19 = 0;
        goto L19
    L5:
        if (r13.f2353e == false) goto L7;
        r14 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void c(String r8) {
        if (this.F != null) goto L6;
        super.c(r8);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void c0(Parcelable r8) {
        if ((r8 instanceof SavedState) == false) goto L6;
        this.F = (SavedState) r8;
        k0();
        return;
    }

    public final void c1(d r8, int r10, int r11) {
        int r12 = r8.f2416d;
        if (r10 != (-1)) goto L11;
        int r13 = r8.f2414b;
        if (r13 != Integer.MIN_VALUE) goto L9;
        r8.c();
        r13 = r8.f2414b;
    L9:
        if ((r13 + r12) > r11) goto L19;
    L17:
        this.f2387y.set(r8.f2417e, false);
        return;
    L19:
        return;
    L11:
        int r14 = r8.f2415c;
        if (r14 != Integer.MIN_VALUE) goto L16;
        r8.b();
        r14 = r8.f2415c;
    L16:
        if ((r14 - r12) >= r11) goto L17;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final Parcelable d0() {
        SavedState r8 = this.F;
        if (r8 != null) goto L5;
        SavedState r10 = new SavedState();
        r10.f2402r = this.f2385w;
        r10.f2403s = this.D;
        r10.f2404t = this.E;
        int r11 = 0;
        LazySpanLookup r12 = this.B;
        if (r12 == null) goto L11;
        int[] r13 = r12.f2389a;
        if (r13 == null) goto L11;
        r10.f2400p = r13;
        r10.f2399o = r13.length;
        r10.f2401q = r12.f2390b;
    L12:
        int r14 = -1;
        if (w() > 0) goto L15;
        r10.f2395a = -1;
        r10.f2396b = -1;
        r10.f2397m = 0;
    L39:
        return r10;
    L15:
        if (this.D == false) goto L17;
        int r15 = K0();
    L18:
        r10.f2395a = r15;
        if (this.f2386x == false) goto L21;
        View r16 = F0(true);
    L22:
        if (r16 == null) goto L25;
        r14 = RecyclerView.o.G(r16);
    L25:
        r10.f2396b = r14;
        int r17 = this.f2378p;
        r10.f2397m = r17;
        r10.f2398n = new int[r17];
    L27:
        if (r11 >= this.f2378p) goto L39;
        if (this.D == false) goto L33;
        int r18 = this.f2379q[r11].h(Integer.MIN_VALUE);
        if (r18 == Integer.MIN_VALUE) goto L37;
        int r19 = this.f2380r.g();
    L36:
        r18 = r18 - r19;
    L37:
        r10.f2398n[r11] = r18;
        r11 = r11 + 1;
        goto L27
    L33:
        r18 = this.f2379q[r11].k(Integer.MIN_VALUE);
        if (r18 == Integer.MIN_VALUE) goto L37;
        r19 = this.f2380r.k();
        goto L36
    L21:
        r16 = G0(true);
        goto L22
    L17:
        r15 = J0();
    L11:
        r10.f2399o = 0;
        goto L12
    L5:
        return new SavedState(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean e() {
        if (this.f2382t != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void e0(int r8) {
        if (r8 != 0) goto L5;
        A0();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean f() {
        if (this.f2382t == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean g(RecyclerView.p r8) {
        return r8 instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void i(int r8, int r10, RecyclerView.z r11, RecyclerView.o.c r12) {
        if (this.f2382t == 0) goto L7;
        r8 = r10;
    L7:
        if (w() == 0) goto L36;
        if (r8 == 0) goto L42;
        T0(r8, r11);
        int[] r13 = this.L;
        if (r13 != null) goto L13;
    L14:
        this.L = new int[this.f2378p];
    L15:
        int r14 = 0;
        int r15 = 0;
    L16:
        int r16 = this.f2378p;
        n r17 = this.f2384v;
        if (r14 >= r16) goto L26;
        if (r17.f2539d != (-1)) goto L21;
        int r18 = r17.f2541f;
        int r19 = this.f2379q[r14].k(r18);
    L22:
        int r20 = r18 - r19;
        if (r20 < 0) goto L25;
        this.L[r15] = r20;
        r15 = r15 + 1;
    L25:
        r14 = r14 + 1;
        goto L16
    L21:
        r18 = this.f2379q[r14].h(r17.f2542g);
        r19 = r17.f2542g;
        goto L22
    L26:
        Arrays.sort(this.L, 0, r15);
        int r21 = 0;
    L27:
        if (r21 >= r15) goto L44;
        int r22 = r17.f2538c;
        if (r22 >= 0) goto L31;
    L33:
        boolean r23 = false;
    L34:
        if (r23 == false) goto L43;
        ((m.b) r12).a(r17.f2538c, this.L[r21]);
        r17.f2538c += r17.f2539d;
        r21 = r21 + 1;
        goto L27
    L43:
        return;
    L31:
        if (r22 >= r11.b()) goto L33;
        r23 = true;
        goto L34
    L44:
        return;
    L13:
        if (r13.length >= this.f2378p) goto L15;
    L42:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int k(RecyclerView.z r8) {
        return B0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int l(RecyclerView.z r8) {
        return C0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int l0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        return Y0(r8, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int m(RecyclerView.z r8) {
        return D0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void m0(int r8) {
        SavedState r10 = this.F;
        if (r10 != null) goto L5;
    L7:
        this.f2388z = r8;
        this.A = Integer.MIN_VALUE;
        k0();
        return;
    L5:
        if (r10.f2395a == r8) goto L7;
        r10.f2398n = null;
        r10.f2397m = 0;
        r10.f2395a = -1;
        r10.f2396b = -1;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int n(RecyclerView.z r8) {
        return B0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int n0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        return Y0(r8, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int o(RecyclerView.z r8) {
        return C0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int p(RecyclerView.z r8) {
        return D0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void q0(int r8, int r10, Rect r11) {
        int r12 = D();
        int r13 = E() + r12;
        int r14 = F();
        int r15 = C() + r14;
        if (this.f2382t != 1) goto L5;
        int r16 = r11.height() + r15;
        RecyclerView r17 = this.f2314b;
        WeakHashMap<View, h0> r18 = j0.w.f8437a;
        int r19 = RecyclerView.o.h(r10, r16, j0.w.d.d(r17));
        int r20 = RecyclerView.o.h(r8, (this.f2383u * this.f2378p) + r13, j0.w.d.e(this.f2314b));
    L6:
        RecyclerView.access$300(this.f2314b, r20, r19);
        return;
    L5:
        int r21 = r11.width() + r13;
        RecyclerView r22 = this.f2314b;
        WeakHashMap<View, h0> r23 = j0.w.f8437a;
        r20 = RecyclerView.o.h(r8, r21, j0.w.d.e(r22));
        r19 = RecyclerView.o.h(r10, (this.f2383u * this.f2378p) + r15, j0.w.d.d(this.f2314b));
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p s() {
        if (this.f2382t != 0) goto L7;
        return new c(-2, -1);
    L7:
        return new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p t(Context r8, AttributeSet r10) {
        return new c(r8, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p u(ViewGroup.LayoutParams r8) {
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new c((ViewGroup.MarginLayoutParams) r8);
    L7:
        return new c(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void w0(RecyclerView r8, int r10) {
        o r11 = new o(r8.getContext());
        r11.f2349a = r10;
        x0(r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int y(RecyclerView.v r8, RecyclerView.z r10) {
        if (this.f2382t != 1) goto L7;
        return this.f2378p;
    L7:
        return super.y(r8, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean y0() {
        if (this.F != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final int z0(int r8) {
        if (w() != 0) goto L9;
        if (this.f2386x == true) goto L7;
        return -1;
    L7:
        return 1;
    L9:
        if (r8 >= J0()) goto L11;
        boolean r10 = true;
    L13:
        if (r10 == this.f2386x) goto L16;
        return -1;
    L16:
        return 1;
    L11:
        r10 = false;
        goto L13
    }
}
