package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"KEY_SEPARATOR", "", "buildModelDownloadIdentity", "Lcom/obric/aikernel/res/update/ModelDownloadIdentity;", "owner", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "model", "Lcom/obric/aikernel/res/metadata/config/ModelConfig;", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class k {
    public static final i a(com.obric.aikernel.res.metadata.config.k r10, com.obric.aikernel.res.metadata.config.h r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "model");
        String r2 = r10.getType();
        String r3 = r10.a();
        String r4 = r10.c();
        String r5 = r10.l();
        if (ZeusTransformUtils.instanceOf(r10, com.obric.aikernel.res.metadata.config.e.class) == false) goto L5;
        String r1 = ((com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(r10, com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin")).h();
    L6:
        String r6 = r1;
        if (ZeusTransformUtils.instanceOf(r10, com.obric.aikernel.res.metadata.config.e.class) == false) goto L9;
        String r12 = r10.a();
    L11:
        return new i(r2, r3, r4, r5, r6, r12, r11.a(), r11.c());
    L9:
        r12 = "";
        goto L11
    L5:
        r1 = r10.a();
        goto L6
    }
}
