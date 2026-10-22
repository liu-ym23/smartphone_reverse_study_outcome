package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13913c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13916j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13917k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f13918l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13919m;

    public final void a(int r5) {
        if ((this.f13913c & r5) == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r5) + " but it is " + Integer.toBinaryString(this.f13913c));
    }

    public final int b() {
        if (this.f == false) goto L6;
        return this.f13911a - this.f13912b;
    L6:
        return this.d;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("State{mTargetPosition=-1, mData=null, mItemCount=");
        r5.append(this.d);
        r5.append(", mIsMeasuring=");
        r5.append(this.f13914h);
        r5.append(", mPreviousLayoutItemCount=");
        r5.append(this.f13911a);
        r5.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
        r5.append(this.f13912b);
        r5.append(", mStructureChanged=");
        r5.append(this.e);
        r5.append(", mInPreLayout=");
        r5.append(this.f);
        r5.append(", mRunSimpleAnimations=");
        r5.append(this.f13915i);
        r5.append(", mRunPredictiveAnimations=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f13916j, '}');
    }
}
