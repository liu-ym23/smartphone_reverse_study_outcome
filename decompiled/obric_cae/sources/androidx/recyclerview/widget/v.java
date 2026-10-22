package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class v extends j0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f2560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f2561e;

    public static class a extends j0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final v f2562d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WeakHashMap f2563e;

        public a(v r8) {
            this.f2563e = new WeakHashMap();
            this.f2562d = r8;
        }

        @Override // j0.a
        public final boolean a(View r8, AccessibilityEvent r10) {
            j0.a r11 = (j0.a) this.f2563e.get(r8);
            if (r11 == null) goto L7;
            return r11.a(r8, r10);
        L7:
            return super.a(r8, r10);
        }

        @Override // j0.a
        public final k0.g b(View r8) {
            j0.a r10 = (j0.a) this.f2563e.get(r8);
            if (r10 == null) goto L7;
            return r10.b(r8);
        L7:
            return super.b(r8);
        }

        @Override // j0.a
        public final void c(View r8, AccessibilityEvent r10) {
            j0.a r11 = (j0.a) this.f2563e.get(r8);
            if (r11 == null) goto L5;
            r11.c(r8, r10);
            return;
        L5:
            super.c(r8, r10);
        }

        @Override // j0.a
        public final void d(View r8, k0.f r10) {
            v r11 = this.f2562d;
            if (r11.f2560d.hasPendingAdapterUpdates() == true) goto L9;
            RecyclerView r12 = r11.f2560d;
            if (r12.getLayoutManager() == null) goto L9;
            r12.getLayoutManager().T(r8, r10);
            j0.a r13 = (j0.a) this.f2563e.get(r8);
            if (r13 == null) goto L9;
            r13.d(r8, r10);
            return;
        L9:
            AccessibilityNodeInfo r14 = r10.f8890a;
            this.f8370a.onInitializeAccessibilityNodeInfo(r8, r14);
        }

        @Override // j0.a
        public final void e(View r8, AccessibilityEvent r10) {
            j0.a r11 = (j0.a) this.f2563e.get(r8);
            if (r11 == null) goto L5;
            r11.e(r8, r10);
            return;
        L5:
            super.e(r8, r10);
        }

        @Override // j0.a
        public final boolean f(ViewGroup r8, View r10, AccessibilityEvent r11) {
            j0.a r12 = (j0.a) this.f2563e.get(r8);
            if (r12 == null) goto L7;
            return r12.f(r8, r10, r11);
        L7:
            return super.f(r8, r10, r11);
        }

        @Override // j0.a
        public final boolean g(View r8, int r10, Bundle r11) {
            v r12 = this.f2562d;
            if (r12.f2560d.hasPendingAdapterUpdates() == true) goto L17;
            RecyclerView r13 = r12.f2560d;
            if (r13.getLayoutManager() == null) goto L17;
            j0.a r14 = (j0.a) this.f2563e.get(r8);
            if (r14 == null) goto L12;
            if (r14.g(r8, r10, r11) == false) goto L14;
            return true;
        L14:
            RecyclerView.v r15 = r13.getLayoutManager().f2314b.mRecycler;
            return false;
        L12:
            if (super.g(r8, r10, r11) == false) goto L14;
            return true;
        L17:
            return super.g(r8, r10, r11);
        }

        @Override // j0.a
        public final void h(View r8, int r10) {
            j0.a r11 = (j0.a) this.f2563e.get(r8);
            if (r11 == null) goto L5;
            r11.h(r8, r10);
            return;
        L5:
            super.h(r8, r10);
        }

        @Override // j0.a
        public final void i(View r8, AccessibilityEvent r10) {
            j0.a r11 = (j0.a) this.f2563e.get(r8);
            if (r11 == null) goto L5;
            r11.i(r8, r10);
            return;
        L5:
            super.i(r8, r10);
        }
    }

    public v(RecyclerView r8) {
        this.f2560d = r8;
        a r10 = this.f2561e;
        if (r10 != null) goto L6;
        r10 = new a(this);
    L6:
        this.f2561e = r10;
    }

    @Override // j0.a
    public final void c(View r8, AccessibilityEvent r10) {
        super.c(r8, r10);
        if ((r8 instanceof RecyclerView) == true) goto L5;
        return;
    L5:
        if (this.f2560d.hasPendingAdapterUpdates() == true) goto L11;
        RecyclerView r11 = (RecyclerView) r8;
        if (r11.getLayoutManager() == null) goto L12;
        r11.getLayoutManager().S(r10);
        return;
    L12:
        return;
    }

    @Override // j0.a
    public final void d(View r8, k0.f r10) {
        AccessibilityNodeInfo r11 = r10.f8890a;
        this.f8370a.onInitializeAccessibilityNodeInfo(r8, r11);
        RecyclerView r12 = this.f2560d;
        if (r12.hasPendingAdapterUpdates() == false) goto L5;
        return;
    L5:
        if (r12.getLayoutManager() == null) goto L19;
        RecyclerView.o r13 = r12.getLayoutManager();
        RecyclerView r14 = r13.f2314b;
        RecyclerView.v r15 = r14.mRecycler;
        RecyclerView.z r16 = r14.mState;
        if (r14.canScrollVertically(-1) == false) goto L9;
    L10:
        r10.a(8192);
        r10.j(true);
    L12:
        if (r13.f2314b.canScrollVertically(1) == false) goto L14;
    L15:
        r10.a(4096);
        r10.j(true);
    L16:
        r10.g(new k0.f.b(AccessibilityNodeInfo.CollectionInfo.obtain(r13.I(r15, r16), r13.y(r15, r16), false, 0)));
        return;
    L14:
        if (r13.f2314b.canScrollHorizontally(1) == false) goto L16;
    L9:
        if (r13.f2314b.canScrollHorizontally(-1) == false) goto L12;
    }

    @Override // j0.a
    public final boolean g(View r8, int r10, Bundle r11) {
        if (super.g(r8, r10, r11) == false) goto L5;
        return true;
    L5:
        RecyclerView r12 = this.f2560d;
        if (r12.hasPendingAdapterUpdates() == false) goto L8;
    L35:
        return false;
    L8:
        if (r12.getLayoutManager() == null) goto L35;
        RecyclerView.o r13 = r12.getLayoutManager();
        RecyclerView r14 = r13.f2314b;
        RecyclerView.v r15 = r14.mRecycler;
        if (r10 == 4096) goto L22;
        if (r10 == 8192) goto L15;
        int r16 = 0;
        int r17 = 0;
    L30:
        if (r17 != 0) goto L33;
        if (r16 != 0) goto L33;
        return false;
    L33:
        r13.f2314b.smoothScrollBy(r16, r17, null, Integer.MIN_VALUE, true);
        return true;
    L15:
        if (r14.canScrollVertically(-1) == false) goto L17;
        int r18 = -((r13.f2327o - r13.F()) - r13.C());
    L19:
        if (r13.f2314b.canScrollHorizontally(-1) == false) goto L29;
        int r19 = -((r13.f2326n - r13.D()) - r13.E());
    L28:
        r17 = r18;
        r16 = r19;
    L29:
        r17 = r18;
        r16 = 0;
        goto L30
    L17:
        r18 = 0;
        goto L19
    L22:
        if (r14.canScrollVertically(1) == false) goto L24;
        r18 = (r13.f2327o - r13.F()) - r13.C();
    L26:
        if (r13.f2314b.canScrollHorizontally(1) == false) goto L29;
        r19 = (r13.f2326n - r13.D()) - r13.E();
        goto L28
    L24:
        r18 = 0;
        goto L26
    }
}
