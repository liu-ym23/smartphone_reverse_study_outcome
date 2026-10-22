package com.obric.aikernel.res.downloader;

import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class DownloadTask$2 extends FunctionReferenceImpl implements Function1<PackageResourceManager.PresmConfig, g> {
    public static final DownloadTask$2 INSTANCE = null;

    static {
        INSTANCE = new DownloadTask$2();
    }

    DownloadTask$2() {
        super(1, k.class, "resolveDownloadNetworkState", "resolveDownloadNetworkState(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)Lcom/obric/aikernel/res/downloader/DownloadNetworkState;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final g invoke2(PackageResourceManager.PresmConfig r1) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        return k.a(r1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ g invoke(PackageResourceManager.PresmConfig r3) {
        return invoke2((PackageResourceManager.PresmConfig) ZeusTransformUtils.preCheckCast(r3, PackageResourceManager.PresmConfig.class, "com.obric.memorydata.plugin"));
    }
}
