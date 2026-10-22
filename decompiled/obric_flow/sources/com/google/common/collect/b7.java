package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b7 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f8909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8910c;

    public b7(e5 r5, Map.Entry r10) {
        this.f8908a = 1;
        this.f8910c = r5;
        this.f8909b = r10;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch(this.f8908a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8909b.getKey();
    L7:
        return this.f8909b.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        switch(this.f8908a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Map.Entry r5 = this.f8909b;
        r5.getKey();
        Object r10 = r5.getValue();
        return ((com.google.common.base.q) ((f7) this.f8910c).f8976a).apply(r10);
    L5:
        return ((Map) this.f8909b.getValue()).get(((b9) ((e5) this.f8910c).e).d);
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public Object setValue(Object r5) {
        switch(this.f8908a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        Map r10 = (Map) this.f8909b.getValue();
        Object r11 = ((b9) ((e5) this.f8910c).e).d;
        r5.getClass();
        return r10.put(r11, r5);
    L5:
        return super.setValue(r5);
    }

    public b7(Map.Entry r5, f7 r10) {
        this.f8908a = 0;
        this.f8909b = r5;
        this.f8910c = r10;
    }
}
