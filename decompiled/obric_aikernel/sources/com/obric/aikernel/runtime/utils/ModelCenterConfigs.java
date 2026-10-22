package com.obric.aikernel.runtime.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ModelCenterConfigs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ModelCenterConfigs f5396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5397b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f5398c = null;

    static {
        f5396a = new ModelCenterConfigs();
        if (Intrinsics.areEqual(DeviceUtils.f5383a.f(), "genesis_simu") == false) goto L5;
        String r10 = "https://aikernel-g1.bytedance.net";
    L6:
        f5397b = r10;
        f5398c = LazyKt.lazy(ModelCenterConfigs$targetDistPath$2.INSTANCE);
        return;
    L5:
        r10 = "https://ofa.obriccloud.com";
        goto L6
    }

    private ModelCenterConfigs() {
    }

    private final String d() {
        return (String) f5398c.getValue();
    }

    public final String a() {
        return d();
    }

    public final String b() {
        return f5397b + "/api/v1/" + a() + "/distribute";
    }

    public final String c() {
        return f5397b;
    }
}
