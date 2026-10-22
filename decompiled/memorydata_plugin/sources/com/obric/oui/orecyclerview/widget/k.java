package com.obric.oui.orecyclerview.widget;

import androidx.core.os.TraceCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ThreadLocal<k> f14205a = null;
    static Comparator<b> e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<RecyclerView> f14206b;
    long c;
    long d;
    private ArrayList<b> f;

    static class a implements RecyclerView.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14208b;
        int[] c;
        int d;

        a() {
        }

        void a() {
            int[] r0 = this.c;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            this.d = 0;
        }

        void a(int r1, int r2) {
            this.f14207a = r1;
            this.f14208b = r2;
        }

        void a(RecyclerView r5, boolean r6) {
            this.d = 0;
            int[] r0 = this.c;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            RecyclerView.h r1 = r5.mLayout;
            if (r5.mAdapter == null) goto L21;
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.r() == false) goto L23;
            if (r6 == false) goto L15;
            if (r5.mAdapterHelper.d() == true) goto L18;
            r1.a(r5.mAdapter.d(), this);
        L18:
            if (this.d <= r1.x) goto L24;
            r1.x = this.d;
            r1.y = r6;
            r5.mRecycler.b();
            return;
        L24:
            return;
        L15:
            if (r5.hasPendingAdapterUpdates() == true) goto L18;
            r1.a(this.f14207a, this.f14208b, r5.mState, this);
            goto L18
        L23:
            return;
        }

        boolean a(int r5) {
            if (this.c == null) goto L11;
            int r0 = this.d * 2;
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L11;
            if (this.c[r2] == r5) goto L8;
            r2 = r2 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h.a
        public void b(int r6, int r7) {
            if (r6 < 0) goto L15;
            if (r7 < 0) goto L13;
            int r0 = this.d * 2;
            int[] r1 = this.c;
            if (r1 != null) goto L8;
            int[] r2 = new int[4];
            this.c = r2;
            Arrays.fill(r2, -1);
        L10:
            int[] r3 = this.c;
            r3[r0] = r6;
            r3[r0 + 1] = r7;
            this.d++;
            return;
        L8:
            if (r0 < r1.length) goto L10;
            int[] r4 = new int[r0 * 2];
            this.c = r4;
            System.arraycopy(r1, 0, r4, 0, r1.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14210b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.f14209a = false;
            this.f14210b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    static {
        f14205a = new ThreadLocal();
        e = new AnonymousClass1();
    }

    k() {
        this.f14206b = new ArrayList();
        this.f = new ArrayList();
    }

    private RecyclerView.v a(RecyclerView r2, int r3, long r4) {
        if (a(r2, r3) == false) goto L6;
        return null;
    L6:
        RecyclerView.o r1 = r2.mRecycler;
        r2.onEnterLayoutOrScroll();     // Catch: Throwable -> L17
        RecyclerView.v r5 = r1.a(r3, false, r4);     // Catch: Throwable -> L17
        if (r5 != null) goto L10;
    L15:
        r2.onExitLayoutOrScroll(false);
        return r5;
    L10:
        if (r5.A() == true) goto L12;
    L14:
        r1.a(r5, false);     // Catch: Throwable -> L17
        goto L15
    L12:
        if (r5.y() == true) goto L14;
        r1.a(r5.c);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r2.onExitLayoutOrScroll(false);
        throw th;
    }

    private void a() {
        int r0 = this.f14206b.size();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L9;
        RecyclerView r4 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f14206b.get(r2), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r4.getWindowVisibility() != 0) goto L8;
        r4.mPrefetchRegistry.a(r4, false);
        r3 = r3 + r4.mPrefetchRegistry.d;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        this.f.ensureCapacity(r3);
        int r5 = 0;
        int r6 = 0;
    L10:
        if (r5 >= r0) goto L27;
        RecyclerView r7 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f14206b.get(r5), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r7.getWindowVisibility() != 0) goto L26;
        a r8 = r7.mPrefetchRegistry;
        int r9 = Math.abs(r8.f14207a) + Math.abs(r8.f14208b);
        int r10 = 0;
    L16:
        if (r10 >= (r8.d * 2)) goto L26;
        if (r6 < this.f.size()) goto L20;
        b r11 = new b();
        this.f.add(r11);
    L21:
        int r12 = r8.c[r10 + 1];
        if (r12 > r9) goto L24;
        boolean r13 = true;
    L25:
        r11.f14209a = r13;
        r11.f14210b = r9;
        r11.c = r12;
        r11.d = r7;
        r11.e = r8.c[r10];
        r6 = r6 + 1;
        r10 = r10 + 2;
        goto L16
    L24:
        r13 = false;
        goto L25
    L20:
        r11 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r6), b.class, "com.obric.memorydata.plugin");
    L26:
        r5 = r5 + 1;
        goto L10
    L27:
        Collections.sort(this.f, e);
    }

    private void a(RecyclerView r4, long r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.mDataSetHasChangedAfterLayout == true) goto L7;
    L9:
        a r0 = r4.mPrefetchRegistry;
        r0.a(r4, true);
        if (r0.d != 0) goto L21;
        return;
    L21:
        TraceCompat.beginSection("RV Nested Prefetch");     // Catch: Throwable -> L17
        r4.mState.a(r4.mAdapter);     // Catch: Throwable -> L17
        int r1 = 0;
    L13:
        if (r1 >= (r0.d * 2)) goto L16;
        a(r4, r0.c[r1], r5);     // Catch: Throwable -> L17
        r1 = r1 + 2;
        goto L13
    L16:
        TraceCompat.endSection();
        return;
    L17:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    L7:
        if (r4.mChildHelper.c() == 0) goto L9;
        r4.removeAndRecycleViews();
        goto L9
    }

    private void a(b r4, long r5) {
        if (r4.f14209a == false) goto L5;
        long r0 = Long.MAX_VALUE;
    L6:
        RecyclerView.v r6 = a(r4.d, r4.e, r0);
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.d != null) goto L11;
        return;
    L11:
        if (r6.A() == true) goto L13;
        return;
    L13:
        if (r6.y() == true) goto L19;
        a((RecyclerView) ZeusTransformUtils.preCheckCast(r6.d.get(), RecyclerView.class, "com.obric.memorydata.plugin"), r5);
        return;
    L19:
        return;
    L5:
        r0 = r5;
        goto L6
    }

    static boolean a(RecyclerView r5, int r6) {
        int r0 = r5.mChildHelper.c();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        RecyclerView.v r3 = RecyclerView.getChildViewHolderInt(r5.mChildHelper.d(r2));
        if (r3.e != r6) goto L10;
        if (r3.y() == true) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    private void b(long r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.f.size()) goto L9;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r0), b.class, "com.obric.memorydata.plugin");
        if (r1.d == null) goto L12;
        a(r1, r5);
        r1.a();
        r0 = r0 + 1;
        goto L4
    L12:
        return;
    }

    void a(long r1) {
        a();
        b(r1);
    }

    public void a(RecyclerView r2) {
        if (RecyclerView.sDebugAssertionsEnabled == true) goto L5;
    L9:
        this.f14206b.add(r2);
        return;
    L5:
        if (this.f14206b.contains(r2) == false) goto L9;
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    void a(RecyclerView r5, int r6, int r7) {
        if (r5.isAttachedToWindow() == true) goto L5;
    L14:
        r5.mPrefetchRegistry.a(r6, r7);
        return;
    L5:
        if (RecyclerView.sDebugAssertionsEnabled == false) goto L12;
        if (this.f14206b.contains(r5) == true) goto L12;
        throw new IllegalStateException("attempting to post unregistered view!");
    L12:
        if (this.c != 0) goto L14;
        this.c = r5.getNanoTime();
        r5.post(this);
        goto L14
    }

    public void b(RecyclerView r1) {
        boolean r0 = this.f14206b.remove(r1);
        if (RecyclerView.sDebugAssertionsEnabled == false) goto L8;
        if (r0 == false) goto L7;
        return;
    L7:
        throw new IllegalStateException("RecyclerView removal failed!");
    }

    @Override // java.lang.Runnable
    public void run() {
        TraceCompat.beginSection("RV Prefetch");     // Catch: Throwable -> L19
        if (this.f14206b.isEmpty() == false) goto L7;
    L5:
        this.c = 0;
        TraceCompat.endSection();
        return;
    L7:
        int r2 = this.f14206b.size();     // Catch: Throwable -> L19
        int r3 = 0;
        long r4 = 0;
    L8:
        if (r3 >= r2) goto L14;
        RecyclerView r6 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f14206b.get(r3), RecyclerView.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r6.getWindowVisibility() != 0) goto L12;
        r4 = Math.max(r6.getDrawingTime(), r4);     // Catch: Throwable -> L19
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L19
        goto L8
    L14:
        if (r4 == 0) goto L5;
        a(TimeUnit.MILLISECONDS.toNanos(r4) + this.d);     // Catch: Throwable -> L19
        this.c = 0;
        TraceCompat.endSection();
        return;
    L19:
        th = move-exception;
        this.c = 0;
        TraceCompat.endSection();
        throw th;
    }
}
