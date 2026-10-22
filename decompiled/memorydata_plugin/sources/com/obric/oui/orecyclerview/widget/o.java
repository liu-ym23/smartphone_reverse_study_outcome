package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f14223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f14224b;
    int c;
    int d;
    int e;
    int f;
    int g;
    boolean h;
    boolean i;

    View a(RecyclerView.o r3) {
        View r4 = r3.c(this.c);
        this.c += this.d;
        return r4;
    }

    boolean a(RecyclerView.s r1) {
        int r0 = this.c;
        if (r0 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= r1.e()) goto L7;
        return true;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f14224b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
