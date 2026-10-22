package com.obric.assistant.session.endpoint;

import android.content.ComponentName;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v0 {
    public static final String a(Bundle r6) {
        Object r0 = "";
        if (r6 != null) goto L29;
        return "";
    L29:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        ArrayList r7 = r6.getParcelableArrayList("android.service.voice.FOREGROUND_ACTIVITIES", ComponentName.class);     // Catch: Throwable -> L15
        if (r7 == null) goto L10;
        ComponentName r8 = (ComponentName) CollectionsKt.firstOrNull(r7);     // Catch: Throwable -> L15
        if (r8 == null) goto L10;
        String r9 = r8.getPackageName();     // Catch: Throwable -> L15
    L11:
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L15
    L17:
        Throwable r2 = Result.exceptionOrNull-impl(r10);
        if (r2 == null) goto L21;
        FLogger.a.e("EndpointUtil", "getForeGroundAppPackageName error: " + r2);
    L21:
        if (Result.isSuccess-impl(r10) == false) goto L24;
        FLogger.a.i("EndpointUtil", "getForeGroundAppPackageName packageName: " + ((String) r10));
    L24:
        if (Result.isFailure-impl(r10) == true) goto L28;
        r0 = r10;
    L28:
        return (String) r0;
    L10:
        r9 = null;
    L15:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
