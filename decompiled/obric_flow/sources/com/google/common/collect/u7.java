package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class u7 extends b8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f9186a;

    public u7(Map.Entry r5) {
        this.f9186a = r5;
    }

    @Override // com.google.common.collect.y7
    public final int getCount() {
        return ((Collection) this.f9186a.getValue()).size();
    }

    @Override // com.google.common.collect.y7
    public final Object getElement() {
        return this.f9186a.getKey();
    }
}
