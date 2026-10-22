package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ThreadLocal<m> f2521o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f2522p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<RecyclerView> f2523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2524b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2525m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<c> f2526n;

    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        public final int compare(c r8, c r10) {
            c r11 = r8;
            c r12 = r10;
            RecyclerView r13 = r11.f2534d;
            if (r13 != null) goto L5;
            boolean r14 = true;
        L7:
            if (r12.f2534d != null) goto L9;
            boolean r15 = true;
        L11:
            if (r14 == r15) goto L15;
            if (r13 != null) goto L26;
        L25:
            return 1;
        L26:
            return -1;
        L15:
            boolean r16 = r11.f2531a;
            if (r16 == r12.f2531a) goto L19;
            if (r16 == false) goto L25;
        L19:
            int r17 = r12.f2532b - r11.f2532b;
            if (r17 != 0) goto L27;
            r17 = r11.f2533c - r12.f2533c;
            if (r17 != 0) goto L27;
            return 0;
        L27:
            return r17;
        L9:
            r15 = false;
            goto L11
        L5:
            r14 = false;
            goto L7
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static class b implements RecyclerView.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f2529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2530d;

        public final void a(int r8, int r10) {
            if (r8 < 0) goto L15;
            if (r10 < 0) goto L13;
            int r11 = this.f2530d * 2;
            int[] r12 = this.f2529c;
            if (r12 != null) goto L8;
            int[] r13 = new int[4];
            this.f2529c = r13;
            Arrays.fill(r13, -1);
        L10:
            int[] r14 = this.f2529c;
            r14[r11] = r8;
            r14[r11 + 1] = r10;
            this.f2530d++;
            return;
        L8:
            if (r11 < r12.length) goto L10;
            int[] r15 = new int[r11 * 2];
            this.f2529c = r15;
            System.arraycopy(r12, 0, r15, 0, r12.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public final void b(RecyclerView r8, boolean r10) {
            this.f2530d = 0;
            int[] r11 = this.f2529c;
            if (r11 == null) goto L5;
            Arrays.fill(r11, -1);
        L5:
            RecyclerView.o r12 = r8.mLayout;
            if (r8.mAdapter == null) goto L21;
            if (r12 != null) goto L9;
            return;
        L9:
            if (r12.f2321i == false) goto L23;
            if (r10 == false) goto L15;
            if (r8.mAdapterHelper.g() == true) goto L17;
            r12.j(r8.mAdapter.a(), this);
        L17:
            int r13 = this.f2530d;
            if (r13 <= r12.f2322j) goto L24;
            r12.f2322j = r13;
            r12.f2323k = r10;
            r8.mRecycler.m();
            return;
        L24:
            return;
        L15:
            if (r8.hasPendingAdapterUpdates() == true) goto L17;
            r12.i(this.f2527a, this.f2528b, r8.mState, this);
            goto L17
        L23:
            return;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f2534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2535e;

        public c() {
        }
    }

    static {
        f2521o = new ThreadLocal();
        f2522p = new a();
    }

    public m() {
        this.f2523a = new ArrayList();
        this.f2526n = new ArrayList();
    }

    public static RecyclerView.c0 c(RecyclerView r8, int r10, long r11) {
        int r12 = r8.mChildHelper.h();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        RecyclerView.c0 r14 = RecyclerView.getChildViewHolderInt(r8.mChildHelper.g(r13));
        if (r14.f2283c != r10) goto L9;
        if (r14.g() == true) goto L9;
        boolean r15 = true;
    L11:
        if (r15 == false) goto L14;
        return null;
    L14:
        RecyclerView.v r16 = r8.mRecycler;
        r8.onEnterLayoutOrScroll();     // Catch: Throwable -> L25
        RecyclerView.c0 r17 = r16.k(r11, r10);     // Catch: Throwable -> L25
        if (r17 != null) goto L18;
    L23:
        r8.onExitLayoutOrScroll(false);
        return r17;
    L18:
        if (r17.f() == true) goto L20;
    L22:
        r16.a(r17, false);     // Catch: Throwable -> L25
        goto L23
    L20:
        if (r17.g() == true) goto L22;
        r16.h(r17.f2281a);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r8.onExitLayoutOrScroll(false);
        throw th;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        r15 = false;
        goto L11
    }

    public final void a(RecyclerView r8, int r10, int r11) {
        if (r8.isAttachedToWindow() == true) goto L5;
    L7:
        b r12 = r8.mPrefetchRegistry;
        r12.f2527a = r10;
        r12.f2528b = r11;
        return;
    L5:
        if (this.f2524b != 0) goto L7;
        this.f2524b = r8.getNanoTime();
        r8.post(this);
        goto L7
    }

    public final void b(long r16) {
        ArrayList<RecyclerView> r8 = this.f2523a;
        int r10 = r8.size();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L8;
        RecyclerView r13 = r8.get(r11);
        if (r13.getWindowVisibility() != 0) goto L7;
        r13.mPrefetchRegistry.b(r13, false);
        r12 = r12 + r13.mPrefetchRegistry.f2530d;
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        ArrayList<c> r14 = this.f2526n;
        r14.ensureCapacity(r12);
        int r15 = 0;
        int r17 = 0;
    L10:
        if (r15 >= r10) goto L27;
        RecyclerView r18 = r8.get(r15);
        if (r18.getWindowVisibility() != 0) goto L26;
        b r19 = r18.mPrefetchRegistry;
        int r110 = Math.abs(r19.f2528b) + Math.abs(r19.f2527a);
        int r20 = 0;
    L16:
        if (r20 >= (r19.f2530d * 2)) goto L26;
        if (r17 < r14.size()) goto L20;
        c r111 = new c();
        r14.add(r111);
    L21:
        int[] r112 = r19.f2529c;
        int r113 = r112[r20 + 1];
        if (r113 > r110) goto L24;
        boolean r114 = true;
    L25:
        r111.f2531a = r114;
        r111.f2532b = r110;
        r111.f2533c = r113;
        r111.f2534d = r18;
        r111.f2535e = r112[r20];
        r17 = r17 + 1;
        r20 = r20 + 2;
        goto L16
    L24:
        r114 = false;
        goto L25
    L20:
        r111 = r14.get(r17);
    L26:
        r15 = r15 + 1;
        goto L10
    L27:
        Collections.sort(r14, f2522p);
        int r21 = 0;
    L29:
        if (r21 >= r14.size()) goto L66;
        c r22 = r14.get(r21);
        RecyclerView r23 = r22.f2534d;
        if (r23 == null) goto L82;
        if (r22.f2531a == false) goto L36;
        long r24 = Long.MAX_VALUE;
    L37:
        RecyclerView.c0 r25 = c(r23, r22.f2535e, r24);
        if (r25 == null) goto L65;
        if (r25.f2282b == null) goto L65;
        if (r25.f() == false) goto L65;
        if (r25.g() == true) goto L65;
        RecyclerView r26 = r25.f2282b.get();
        if (r26 == null) goto L65;
        if (r26.mDataSetHasChangedAfterLayout == true) goto L51;
    L53:
        b r27 = r26.mPrefetchRegistry;
        r27.b(r26, true);
        if (r27.f2530d == 0) goto L65;
        f0.h.a("RV Nested Prefetch");     // Catch: Throwable -> L61
        RecyclerView.z r28 = r26.mState;     // Catch: Throwable -> L61
        RecyclerView.g r29 = r26.mAdapter;     // Catch: Throwable -> L61
        r28.f2367d = 1;     // Catch: Throwable -> L61
        r28.f2368e = r29.a();     // Catch: Throwable -> L61
        r28.f2370g = false;     // Catch: Throwable -> L61
        r28.f2371h = false;     // Catch: Throwable -> L61
        r28.f2372i = false;     // Catch: Throwable -> L61
        int r30 = 0;
    L57:
        if (r30 >= (r27.f2530d * 2)) goto L60;
        c(r26, r27.f2529c[r30], r16);     // Catch: Throwable -> L61
        r30 = r30 + 2;
        goto L57
    L60:
        f0.h.b();
    L61:
        th = move-exception;
        f0.h.b();
        throw th;
    L51:
        if (r26.mChildHelper.h() == 0) goto L53;
        r26.removeAndRecycleViews();
    L65:
        r22.f2531a = false;
        r22.f2532b = 0;
        r22.f2533c = 0;
        r22.f2534d = null;
        r22.f2535e = 0;
        r21 = r21 + 1;
        goto L29
    L36:
        r24 = r16;
        goto L37
    L82:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f0.h.a("RV Prefetch");     // Catch: Throwable -> L22
        ArrayList<RecyclerView> r8 = this.f2523a;
        if (r8.isEmpty() == false) goto L9;
        this.f2524b = 0;
        f0.h.b();
        return;
    L9:
        int r10 = r8.size();     // Catch: Throwable -> L22
        int r11 = 0;
        long r12 = 0;
    L10:
        if (r11 >= r10) goto L16;
        RecyclerView r13 = r8.get(r11);     // Catch: Throwable -> L22
        if (r13.getWindowVisibility() != 0) goto L14;
        r12 = Math.max(r13.getDrawingTime(), r12);     // Catch: Throwable -> L22
    L14:
        r11 = r11 + 1;
        goto L10
    L16:
        if (r12 != 0) goto L19;
        this.f2524b = 0;
        f0.h.b();
        return;
    L19:
        b(TimeUnit.MILLISECONDS.toNanos(r12) + this.f2525m);     // Catch: Throwable -> L22
        this.f2524b = 0;
        f0.h.b();
        return;
    L22:
        th = move-exception;
        this.f2524b = 0;
        f0.h.b();
        throw th;
    }
}
