package com.obric.aikernel.res.metadata.config;

import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"finalArtifactSpec", "Lcom/obric/aikernel/res/metadata/config/ModelArtifactSpec;", "Lcom/obric/aikernel/res/metadata/config/Downloadable;", "decryptFeature", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$DecryptFeature;", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class g {
    public static final f a(c r3, PackageResourceManager.PresmConfig.a r4) {
        PackageResourceManager.PresmConfig.a r5 = (PackageResourceManager.PresmConfig.a) ZeusTransformUtils.wrapperContextForParams(r4, PackageResourceManager.PresmConfig.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "decryptFeature");
        boolean r6 = r3.a(r5);
        String r1 = r3.f();
        if (r6 == false) goto L5;
        String r2 = r3.i();
    L6:
        if (r6 == false) goto L8;
        long r7 = r3.k();
    L10:
        return new f(r1, r2, r7);
    L8:
        r7 = r3.j();
        goto L10
    L5:
        r2 = r3.g();
        goto L6
    }
}
