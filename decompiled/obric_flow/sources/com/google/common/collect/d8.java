package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d8 extends w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f8943b;

    public /* synthetic */ d8(Map.Entry r5, int r10) {
        this.f8942a = r10;
        this.f8943b = r5;
    }

    @Override // com.google.common.collect.w2
    public final Map.Entry b() {
        switch(this.f8942a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8943b;
    L7:
        return this.f8943b;
    }

    @Override // com.google.common.collect.z2
    public final Object delegate() {
        switch(this.f8942a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8943b;
    L7:
        return this.f8943b;
    }

    @Override // com.google.common.collect.w2, java.util.Map.Entry
    public boolean equals(Object r5) {
        switch(this.f8942a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.equals(r5);
    L7:
        if ((r5 instanceof Map.Entry) == false) goto L14;
        Map.Entry r10 = (Map.Entry) r5;
        if (com.google.common.base.b0.w(getKey(), r10.getKey()) == true) goto L11;
        return false;
    L11:
        if (com.google.common.base.b0.w(getValue(), r10.getValue()) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    @Override // com.google.common.collect.w2, java.util.Map.Entry
    public final Object setValue(Object r5) {
        switch(this.f8942a) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        r5.getClass();
        return super.setValue(r5);
    L7:
        return super.setValue(MutableClassToInstanceMap.access$000((Class) getKey(), r5));
    }
}
