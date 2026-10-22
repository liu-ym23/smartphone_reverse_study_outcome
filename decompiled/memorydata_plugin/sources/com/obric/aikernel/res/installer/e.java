package com.obric.aikernel.res.installer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"prepareLinkFileForInstall", "", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", "useLinkFile", "", TypedValues.AttributesType.S_TARGET, "Ljava/io/File;", LocationMonitorConst.TAG, "", "prepareResRootLinkFileForInstall", "useResRoot", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class e {
    public static final void a(com.obric.aikernel.res.metadata.data.d r4, boolean r5, File r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        if (r5 == false) goto L5;
        File r8 = r4.C();
        boolean r0 = true;
        if (r8 != null) goto L31;
    L27:
        r0 = false;
    L28:
        if (r0 == true) goto L37;
        com.obric.aikernel.runtime.utils.d.f6216a.f(r7, "install: repair invalid uri_link " + r4.A() + " to " + r6);
        r4.a(r6);
        return;
    L37:
        return;
    L31:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        Object r9 = Result.m1421constructorimpl(Boolean.valueOf(Intrinsics.areEqual(r8.getCanonicalPath(), r6.getCanonicalPath())));     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r9) == false) goto L25;
        r9 = false;
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L27;
    L19:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        if (r4.A().exists() == false) goto L35;
        com.obric.aikernel.runtime.utils.d.f6216a.f(r7, "install: remove unexpected uri_link " + r4.A());
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        Object r11 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r4.A())));     // Catch: Throwable -> L9
    L11:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L36;
        com.obric.aikernel.runtime.utils.d.f6216a.f(r7, "install: remove uri_link " + r4.A() + " failed " + r12);
        return;
    L36:
        return;
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final void a(com.obric.aikernel.res.metadata.data.d r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        a(r1, r2, r1.B(), r3);
    }

    public static /* synthetic */ void a(com.obric.aikernel.res.metadata.data.d r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = PackageResourceManager.TAG;
    L5:
        a(r0, r1, r2);
    }
}
