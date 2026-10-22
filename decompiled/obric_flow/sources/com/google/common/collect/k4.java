package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class k4 extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ga f9055c;
    public ga d;
    public final /* synthetic */ ImmutableRangeSet.AsSet e;

    public k4(ImmutableRangeSet.AsSet r5) {
        this.e = r5;
        this.f9055c = ImmutableRangeSet.access$000(r5.this$0).iterator();
        this.d = g5.d;
    }

    @Override // com.google.common.collect.g
    public final Object a() {
    L3:
        if (this.d.hasNext() == true) goto L9;
        ga r5 = this.f9055c;
        if (r5.hasNext() == false) goto L7;
        this.d = ContiguousSet.create((Range) r5.next(), ImmutableRangeSet.AsSet.access$100(this.e)).iterator();
        goto L3
    L7:
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L9:
        return (Comparable) this.d.next();
    }
}
