package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class w implements com.larksuite.framework.ui.b, View.OnLayoutChangeListener {
    public final RecyclerView a;
    public final boolean b;
    public final LinearLayoutManager c;
    public boolean d;
    public boolean e;
    public final x f;

    public static final class a {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "Anchor(position=" + this.a + ", offset=" + this.b + ')';
        }

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void a() {
    }

    public final void b() {
    }

    public final void onLayoutComplete() {
    }

    public final boolean d() {
        if (this.c.getItemCount() != 0) goto L6;
        return false;
    L6:
        if (this.a.canScrollVertically(1) == false) goto L8;
    L24:
        return true;
    L8:
        if (this.a.canScrollVertically(-1) == true) goto L24;
        int r0 = this.c.findFirstVisibleItemPosition();
        int r4 = this.c.findLastVisibleItemPosition();
        if (r0 == (-1)) goto L25;
        if (r4 == (-1)) goto L27;
        View r1 = this.c.findViewByPosition(r0);
        if (r1 == null) goto L28;
        View r3 = this.c.findViewByPosition(r4);
        if (r3 != null) goto L21;
        return false;
    L21:
        if ((r3.getBottom() - r1.getTop()) < ((this.a.getHeight() - this.a.getPaddingTop()) - this.a.getPaddingBottom())) goto L26;
        return true;
    L26:
        return false;
    L28:
        return false;
    L27:
        return false;
    L25:
        return false;
    }

    public w(RecyclerView r6) {
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        this.a = r6;
        this.b = true;
        LinearLayoutManager r1 = r6.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r2 = r1;
    L6:
        if (r2 == null) goto L10;
        this.c = r2;
        this.d = r2.getStackFromEnd();
        int r3 = bwb.b.a;
        bwb.b.g(MmUiLogScene.SUBTITLE, "init", hashCode() + ", isEnabled=true", null, 8);
        r6.addOnLayoutChangeListener(this);
        this.f = new x(this);
        return;
    L10:
        throw new IllegalStateException("RecyclerView must use LinearLayoutManager");
    L5:
        r2 = null;
        goto L6
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if (this.b == true) goto L6;
        return;
    L6:
        if (this.d == false) goto L9;
        return;
    L9:
        if (d() == true) goto L11;
        return;
    L11:
        f(true, r2);
    }

    public final void e(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (this.e == r4) goto L6;
        this.e = r4;
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.SUBTITLE, "setFrozenStackFromEnd", "frozen=" + r4 + ", source=" + r5, null, 8);
        return;
    }

    public final boolean f(boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        int r0 = bwb.b.a;
        a r3 = null;
        bwb.b.g(MmUiLogScene.SUBTITLE, "toggleStackFromEnd", "enable=" + r5 + ", stackFromEnd:" + this.d + ", source=" + r6, null, 8);
        if (this.b == true) goto L6;
        return false;
    L6:
        if (this.d != r5) goto L8;
        return false;
    L8:
        this.d = r5;
        this.c.setStackFromEnd(r5);
        if (r5 == true) goto L11;
        int r7 = this.c.findFirstVisibleItemPosition();
        if (r7 == (-1)) goto L22;
        View r8 = this.c.findViewByPosition(r7);
        if (r8 == null) goto L22;
        r3 = new a(r7, r8.getTop() - this.a.getPaddingTop());
    L22:
        if (r3 == null) goto L24;
        this.c.scrollToPositionWithOffset(r3.a, r3.b);
    L24:
        return true;
    L11:
        if (this.c.getItemCount() <= 0) goto L14;
        LinearLayoutManager r9 = this.c;
        r9.scrollToPositionWithOffset(r9.getItemCount() - 1, 0);
    L14:
        return true;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (this.d == true) goto L5;
        return;
    L5:
        if ((r5 - r3) == (r9 - r7)) goto L7;
    L8:
        this.a.removeCallbacks(this.f);
        this.a.post(this.f);
        return;
    L7:
        if ((r4 - r2) != (r8 - r6)) goto L8;
    }
}
