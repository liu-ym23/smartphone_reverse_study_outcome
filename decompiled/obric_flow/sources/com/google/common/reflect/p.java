package com.google.common.reflect;

import com.google.common.collect.g8;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends g8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g8 f9368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f9369b;

    public p(g8 r5, HashMap r10) {
        this.f9368a = r5;
        this.f9369b = r10;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        HashMap r11 = this.f9369b;
        Object r12 = r11.get(r5);
        Objects.requireNonNull(r12);
        Object r13 = r11.get(r10);
        Objects.requireNonNull(r13);
        return this.f9368a.compare(r12, r13);
    }
}
