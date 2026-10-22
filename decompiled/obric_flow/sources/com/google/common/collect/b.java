package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map.Entry f8900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8901c;

    public /* synthetic */ b(Object r5, Map.Entry r10, int r11) {
        this.f8899a = r11;
        this.f8901c = r5;
        this.f8900b = r10;
    }

    @Override // com.google.common.collect.w2
    public final Map.Entry b() {
        switch(this.f8899a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8900b;
    L7:
        return this.f8900b;
    }

    @Override // com.google.common.collect.z2
    public final Object delegate() {
        switch(this.f8899a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8900b;
    L7:
        return this.f8900b;
    }

    @Override // com.google.common.collect.w2, java.util.Map.Entry
    public Object getValue() {
        switch(this.f8899a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getValue();
    L7:
        return p7.d((Collection) this.f8900b.getValue(), ((Synchronized$SynchronizedAsMapEntries) ((i9) this.f8901c).f9027c).mutex);
    }

    @Override // com.google.common.collect.w2, java.util.Map.Entry
    public Object setValue(Object r10) {
        switch(this.f8899a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        AbstractBiMap r5 = (AbstractBiMap) this.f8901c;
        r5.checkValue(r10);
        com.google.common.base.b0.u(r5.entrySet().contains(this), "entry no longer in map");
        if (com.google.common.base.b0.w(r10, getValue()) == true) goto L11;
        com.google.common.base.b0.h("value already present: %s", !r5.containsValue(r10), r10);
        Object r11 = this.f8900b.setValue(r10);
        com.google.common.base.b0.u(com.google.common.base.b0.w(r10, r5.get(getKey())), "entry no longer in map");
        AbstractBiMap.access$500(r5, getKey(), true, r11, r10);
        return r11;
    L11:
        return r10;
    L5:
        return super.setValue(r10);
    }
}
