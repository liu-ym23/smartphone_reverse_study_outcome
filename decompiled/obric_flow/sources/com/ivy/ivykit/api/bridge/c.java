package com.ivy.ivykit.api.bridge;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements IBridgeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ c f9472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f9473b = null;

    static {
        f9472a = new c();
        f9473b = LazyKt.lazy(IBridgeService$Companion$impl$2.f9468a);
    }

    @Override // com.ivy.ivykit.api.bridge.IBridgeService
    public final void init(a r5) {
        Intrinsics.checkNotNullParameter(r5, "bridgeConfig");
        IBridgeService r10 = (IBridgeService) f9473b.getValue();
        if (r10 == null) goto L6;
        r10.init(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.bridge.IBridgeService
    public final void registerHostDepend(Object r5) {
        IBridgeService r10 = (IBridgeService) f9473b.getValue();
        if (r10 == null) goto L6;
        r10.registerHostDepend(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.bridge.IBridgeService
    public final void registerIvyMethod(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        IBridgeService r10 = (IBridgeService) f9473b.getValue();
        if (r10 == null) goto L6;
        r10.registerIvyMethod(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.bridge.IBridgeService
    public final void registerMethod(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        IBridgeService r10 = (IBridgeService) f9473b.getValue();
        if (r10 == null) goto L6;
        r10.registerMethod(r5);
        return;
    }
}
