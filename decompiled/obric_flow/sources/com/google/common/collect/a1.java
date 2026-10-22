package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 extends y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayTable f8885c;

    public a1(ArrayTable r5, int r10) {
        this.f8884b = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f8885c = r5;
        super(ArrayTable.access$600(r5));
        return;
    L6:
        this.f8885c = r5;
        super(ArrayTable.access$300(r5));
    }

    @Override // com.google.common.collect.y0
    public final String a() {
        switch(this.f8884b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "Row";
    L6:
        return "Column";
    }

    @Override // com.google.common.collect.y0
    public final Object b(int r5) {
        switch(this.f8884b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new z0(this.f8885c, r5, 1);
    L7:
        return new z0(this.f8885c, r5, 0);
    }

    @Override // com.google.common.collect.y0
    public final Object c(int r5, Object r10) {
        switch(this.f8884b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Map r11 = (Map) r10;
        throw new UnsupportedOperationException();
    L6:
        Map r12 = (Map) r10;
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y0, java.util.AbstractMap, java.util.Map
    public final Object put(Object r5, Object r10) {
        switch(this.f8884b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Map r11 = (Map) r10;
        throw new UnsupportedOperationException();
    L6:
        Map r12 = (Map) r10;
        throw new UnsupportedOperationException();
    }
}
