package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class y3 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f9229a;

    public y3(Map.Entry r5) {
        this.f9229a = r5;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9229a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return ImmutableSet.of(this.f9229a.getValue());
    }
}
