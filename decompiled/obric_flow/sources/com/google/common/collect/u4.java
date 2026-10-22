package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class u4 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f9181a;

    public u4(Comparator r5) {
        this.f9181a = r5;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        Map.Entry r11 = (Map.Entry) r5;
        Map.Entry r12 = (Map.Entry) r10;
        Objects.requireNonNull(r11);
        Objects.requireNonNull(r12);
        Object r13 = r11.getKey();
        Object r14 = r12.getKey();
        return this.f9181a.compare(r13, r14);
    }
}
