package com.bytedance.ai.model;

import com.bytedance.ai.bridge.ContainerType;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends m1.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2300c;
    public final ContainerType d;
    public final String e;

    public t(JSWorkerRuntime r5) {
        this.f2298a = 0;
        String r10 = r5.f2197h.F;
        this.f2299b = r10;
        this.f2300c = r10;
        this.d = ContainerType.d;
        this.e = r5.f;
    }

    @Override // m1.j
    public final String a() {
        switch(this.f2298a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.f2300c;
    L7:
        return this.f2300c;
    L9:
        return this.f2300c;
    }

    @Override // m1.j
    public final String b() {
        switch(this.f2298a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.f2299b;
    L7:
        return this.f2299b;
    L9:
        return this.f2299b;
    }

    @Override // m1.j
    public final String c() {
        switch(this.f2298a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.e;
    L7:
        return this.e;
    L9:
        return this.e;
    }

    @Override // m1.j
    public final ContainerType d() {
        switch(this.f2298a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.d;
    L7:
        return this.d;
    L9:
        return this.d;
    }

    public t(LynxWorkerRuntime r5) {
        this.f2298a = 1;
        String r10 = r5.f2197h.F;
        this.f2299b = r10;
        this.f2300c = r10;
        this.d = ContainerType.d;
        this.e = r5.f;
    }

    public t(RelaxWorkerRuntime r5) {
        this.f2298a = 2;
        String r10 = r5.f2197h.F;
        this.f2299b = r10;
        this.f2300c = r10;
        this.d = ContainerType.d;
        this.e = r5.f;
    }
}
