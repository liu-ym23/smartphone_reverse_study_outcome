package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public f() {
    }

    public final void a(hs8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        com.larus.bmhome.upload.sdk.impl.a r4 = r3.b(new ResourceCenterTokenCredentialProvider());
        r4.b(new UploadAuthTokenCredentialProvider());
        r4.c(new ResourceUploadEngine(UploadEngineType.IMAGE));
        r4.c(new ResourceUploadEngine(UploadEngineType.VIDEO));
        r4.c(new ResourceUploadEngine(UploadEngineType.FILE));
        r4.d(new ResourceCenterRegisterPostAction());
    }
}
