package com.obric.aikernel.api.impl.security;

import com.bytedance.crypto.platform.PlatformConst;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.DeviceUtils;
import com.obric.aikernel.service.res.DecryptFeature;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.obric.aikernel.api.security.b {
    public b() {
    }

    @Override // com.obric.aikernel.api.security.b
    public boolean a() {
        return true;
    }

    @Override // com.obric.aikernel.api.security.b
    public /* bridge */ /* synthetic */ PackageResourceManager.PresmConfig.b b(PackageResourceManager.PresmConfig r10) {
        return d(r10);
    }

    @Override // com.obric.aikernel.api.security.b
    public int c() {
        DeviceUtils r10 = DeviceUtils.f5383a;
        if (r10.k() == false) goto L6;
        return PlatformConst.SM8750_PLATFORM_VERSION;
    L6:
        if (r10.j() == false) goto L8;
        return PlatformConst.N1_SM8850_PLATFORM_VERSION;
    L8:
        return PlatformConst.G1_PLATFORM_VERSION;
    }

    public DecryptFeature d(PackageResourceManager.PresmConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        return new DecryptFeature(r10);
    }
}
