package com.bytedance.ai.model.widgets;

import com.bytedance.ai.bridge.ContainerType;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends m1.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContainerType f2363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2364c;

    public p(RelaxViewFloatingPageV2 r5) {
        this.f2362a = r5.getAppletId();
        this.f2363b = ContainerType.f1801c;
        this.f2364c = r5.f2331c;
    }

    @Override // m1.j
    public final String b() {
        return this.f2362a;
    }

    @Override // m1.j
    public final String c() {
        return this.f2364c;
    }

    @Override // m1.j
    public final ContainerType d() {
        return this.f2363b;
    }
}
