package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 extends y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9239c;
    public final /* synthetic */ ArrayTable d;

    public z0(ArrayTable r5, int r10, int r11) {
        this.f9238b = r11;
        switch(r11) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.d = r5;
        super(ArrayTable.access$300(r5));
        this.f9239c = r10;
        return;
    L6:
        this.d = r5;
        super(ArrayTable.access$600(r5));
        this.f9239c = r10;
    }

    @Override // com.google.common.collect.y0
    public final String a() {
        switch(this.f9238b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "Column";
    L6:
        return "Row";
    }

    @Override // com.google.common.collect.y0
    public final Object b(int r5) {
        switch(this.f9238b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.d.at(this.f9239c, r5);
    L7:
        return this.d.at(r5, this.f9239c);
    }

    @Override // com.google.common.collect.y0
    public final Object c(int r5, Object r10) {
        switch(this.f9238b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.d.set(this.f9239c, r5, r10);
    L7:
        return this.d.set(r5, this.f9239c, r10);
    }
}
