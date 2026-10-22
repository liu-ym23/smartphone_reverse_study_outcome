package com.larus.apm.impl;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.agilelogger.ALog;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y8a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ApmImpl$c implements b {
    public List<String> a;
    public final /* synthetic */ boolean b;

    public final z8a.b getConsumerResult() {
        boolean r0 = !this.a.isEmpty();
        boolean r1 = this.b;
        if (r0 == false) goto L5;
        String r2 = "";
    L8:
        if (r0 == false) goto L10;
        HashMap r3 = null;
    L12:
        return new z8a.b(r0, r2, r3);
    L10:
        r3 = ALog.getLastFetchErrorInfo();
        goto L12
    L5:
        if (r1 == false) goto L7;
        r2 = "Cloud Command blocked: Forbidden in Minor Mode";
        goto L8
    L7:
        r2 = "alog file not get";
        goto L8
    }

    public ApmImpl$c(boolean r1) {
        this.b = r1;
        this.a = CollectionsKt.emptyList();
    }

    public final List<String> handleAlogData(long r5, long r7, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "params");
        if (this.b == false) goto L6;
        FLogger.a.d("ApmImpl", "handleAlogData, isMinorMode: " + this.b + " , return empty list");
        return this.a;
    L6:
        FLogger.a.d("ApmImpl", "handleAlogData, startTime: " + r5 + ", endTime: " + r7 + ", params: " + r9 + ", get files");
        if (r5 >= r7) goto L15;
        ALog.asyncFlush();
        ObricAlogServiceDelegate.b.e();
        Thread.sleep(1000);     // Catch: InterruptedException -> L11
    L13:
        List<String> r6 = ALog.getALogFiles(r5, r7);
        this.a = r6;
        this.a = ObricAlogServiceDelegate.b.a(r6);
    L11:
        e = move-exception;
        e.printStackTrace();
    L15:
        return this.a;
    }
}
