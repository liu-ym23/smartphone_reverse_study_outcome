package com.obric.aikernel.runtime.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\r\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/aikernel/runtime/utils/ModelCenterConfigs;", "", "()V", "G1_BOE_HOST_URL", "", "GR_BOE_HOST_URL", "HOST_URL", "getHOST_URL", "()Ljava/lang/String;", "LEGACY_HOST_URL", "MOTO_BOE_HOST_URL", "RLS_HOST_URL", "targetDistPath", "getTargetDistPath", "targetDistPath$delegate", "Lkotlin/Lazy;", "getDistributePath", "getDistributeUrl", "useCenterDistribution", "", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f6218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f6219b = null;
    private static final Lazy c = null;

    static {
        f6218a = new e();
        if (Intrinsics.areEqual(a.f6212a.b(), "genesis_simu") == false) goto L5;
        String r0 = "https://aikernel-g1.bytedance.net";
    L6:
        f6219b = r0;
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(ModelCenterConfigs$targetDistPath$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = "https://ofa.obriccloud.com";
        goto L6
    }

    private e() {
    }

    private final String b() {
        return (String) ZeusTransformUtils.preCheckCast(c.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final String a() {
        return b();
    }

    public final String a(boolean r2) {
        if (r2 == false) goto L4;
        StringBuilder r1 = new StringBuilder().append("api/v1/aikernel/engine/center/").append(a());
        String r3 = "/algo/distribute";
    L6:
        return f6219b + '/' + r1.append(r3).toString();
    L4:
        r1 = new StringBuilder().append("api/v1/").append(a());
        r3 = "/distribute";
        goto L6
    }
}
