package com.bytedance.ies.bullet.kit.resourceloader;

import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    static {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Object r10 = Result.m124constructorimpl(DownloadTask.class.getDeclaredMethod("a", new Class[]{Long.TYPE}));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r10) == false) goto L9;
        r10 = null;
    L9:
        Method r11 = (Method) r10;
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
