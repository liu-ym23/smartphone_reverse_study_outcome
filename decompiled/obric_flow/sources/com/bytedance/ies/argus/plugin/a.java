package com.bytedance.ies.argus.plugin;

import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.config.AppSecConfig;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static String a() {
        Object r5 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        String r11 = SecLinkFacade.getVerifyHost();     // Catch: Throwable -> L8
        if (r11 != null) goto L11;
        AppSecConfig r12 = SecLinkFacade.getLinkConfig();     // Catch: Throwable -> L8
        if (r12 == null) goto L10;
        r11 = r12.getHost();     // Catch: Throwable -> L8
        goto L11
    L10:
        r11 = null;
    L11:
        Object r13 = Result.m124constructorimpl(r11);     // Catch: Throwable -> L8
    L15:
        if (Result.m130isFailureimpl(r13) == true) goto L19;
        r5 = r13;
    L19:
        return (String) r5;
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
