package com.bytedance.ai.resource.core.net;

import a3.f;
import com.bytedance.ai.resource.IAIPackageNetService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/net/AIPackageTTNET;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AIPackageTTNET {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2669a = null;

    static {
        f2669a = LazyKt.lazy(new f(16));
    }

    public static final IAIPackageNetService a() {
        ConcurrentHashMap r5 = s2.a.f21813a;
        Intrinsics.checkNotNullParameter(IAIPackageNetService.class, "clazz");
        Object r10 = s2.a.f21813a.get(IAIPackageNetService.class);
        if ((r10 instanceof IAIPackageNetService) == false) goto L5;
        IAIPackageNetService r11 = (IAIPackageNetService) r10;
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return new DefaultAIPackageNetService();
    L5:
        r11 = null;
        goto L6
    }
}
