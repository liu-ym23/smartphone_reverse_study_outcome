package com.obric.aikernel.res.downloader;

import android.content.Context;
import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0000\u001a0\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0000¨\u0006\u0013"}, d2 = {"failedDownloadConstraintState", "", "onlyWifi", "", "hasValidatedInternet", "hasUnmeteredNetwork", "hasWifiOrUnmeteredNetwork", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "resolveDownloadNetworkState", "Lcom/obric/aikernel/res/downloader/DownloadNetworkState;", "shouldMarkDownloadTaskCompleted", "finished", "shouldReplaceFinishedDownloadTask", "completed", "splitTaskCompleted", "success", "state", "holderCount", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class k {
    public static final int a(boolean r0, boolean r1, boolean r2) {
        if (r1 == true) goto L4;
        return 5;
    L4:
        if (r0 == false) goto L7;
        if (r2 == true) goto L7;
        return 3;
    L7:
        return 0;
    }

    public static final g a(PackageResourceManager.PresmConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        return new g(com.obric.aikernel.runtime.utils.h.f6225a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), b(r5));
    }

    public static final boolean a(boolean r0) {
        return r0;
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2, int r3, int r4) {
        if (r0 == false) goto L9;
        if (r1 == false) goto L9;
        if (r2 == true) goto L9;
        if (r4 != 0) goto L9;
        if (b.a(r3) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean b(PackageResourceManager.PresmConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        if (com.obric.aikernel.runtime.utils.h.f6225a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L8:
        return true;
    L5:
        if (com.obric.aikernel.runtime.utils.h.f6225a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L8;
        return false;
    }
}
