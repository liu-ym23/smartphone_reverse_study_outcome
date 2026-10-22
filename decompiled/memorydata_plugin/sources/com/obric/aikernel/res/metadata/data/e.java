package com.obric.aikernel.res.metadata.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a \u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¨\u0006\n"}, d2 = {"isOwnedResourceLinkTarget", "", TypedValues.AttributesType.S_TARGET, "Ljava/io/File;", "resourceRoot", "shouldClearReinstallFlagAfterCheck", "fastCheck", "hadReinstallFlag", "shouldReinstall", "shouldDeferReinstallFlagClear", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class e {
    public static final boolean a(File r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r4, "resourceRoot");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        String r5 = r3.getCanonicalFile().getPath();     // Catch: Throwable -> L5
        String r6 = r4.getCanonicalFile().getPath();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r5, "canonicalTarget");     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(Boolean.valueOf(StringsKt.startsWith$default(r5, r6 + File.separator, false, 2, null)));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r7) == false) goto L11;
        r7 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final boolean a(boolean r0, boolean r1) {
        if (r0 == false) goto L5;
        if (r1 == false) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2) {
        if (r0 == true) goto L6;
        if (r1 == false) goto L6;
        if (r2 == true) goto L6;
        return true;
    L6:
        return false;
    }
}
