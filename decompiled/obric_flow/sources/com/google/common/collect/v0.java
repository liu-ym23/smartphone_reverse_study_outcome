package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends r9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayTable f9189c;

    public v0(ArrayTable r5, int r10) {
        this.f9189c = r5;
        this.f9187a = r10 / ArrayTable.access$100(r5).size();
        this.f9188b = r10 % ArrayTable.access$100(r5).size();
    }

    @Override // com.google.common.collect.k9
    public final Object getColumnKey() {
        return ArrayTable.access$100(this.f9189c).get(this.f9188b);
    }

    @Override // com.google.common.collect.k9
    public final Object getRowKey() {
        return ArrayTable.access$200(this.f9189c).get(this.f9187a);
    }

    @Override // com.google.common.collect.k9
    public final Object getValue() {
        int r5 = this.f9187a;
        int r10 = this.f9188b;
        return this.f9189c.at(r5, r10);
    }
}
