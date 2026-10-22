package com.obric.memorydata.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/utils/ProcessUtils;", "", "<init>", "()V", "MEMORYDATA_PROCESS_SUFFIX", "", "getCurrentProcessName", "context", "Landroid/content/Context;", "isMemoryDataProcess", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final an f13171a = null;

    static {
        f13171a = new an();
    }

    private an() {
    }

    public final String a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (Build.VERSION.SDK_INT < 28) goto L6;
        String r5 = Application.getProcessName();
        Intrinsics.checkNotNullExpressionValue(r5, "getProcessName(...)");
        return r5;
    L6:
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        an r8 = (an) ZeusTransformUtils.preCheckCast(this, an.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Object r9 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.memorydata.plugin").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L13
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L10;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L11:
        Object r11 = Result.m1421constructorimpl(r10);     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r11) == true) goto L19;
        r0 = r11;
    L19:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L25;
        String r13 = com.ss.android.common.b.d.b(r7);
        Intrinsics.checkNotNullExpressionValue(r13, "getCurProcessName(...)");
        return r13;
    L25:
        return r12;
    L10:
        r10 = null;
    L13:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return Intrinsics.areEqual(a(r4), r4.getPackageName() + ":memorydata");
    }
}
