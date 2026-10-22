package com.sdk.bwdl.NearFieldSwap;

import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6713a;

    public /* synthetic */ b(int r8) {
        this.f6713a = r8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r8) {
        switch(this.f6713a) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return DiscoveryEngine.BWDLDiscoverySbjectManager.a((Short) r8);
    L8:
        return DiscoveryEngine.BWDLDiscoverySbjectManager.c((Short) r8);
    }
}
