package com.bytedance.android.monitorV2.exception;

import android.os.Handler;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import java.util.HashMap;
import java.util.regex.Pattern;
import k5.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f3568a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f3569b = "";

    static {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Npth.addAttachUserData(a.f3567a, CrashType.ALL);     // Catch: Throwable -> L4
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static void a(String r5, String r10) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        f3568a = r5;
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        f3569b = r10;
        HashMap r11 = new HashMap();
        Pattern r12 = k.f18621a;
        r11.put("last_bdhm_url", k.a(f3568a));
        r11.put("last_bdhm_bid", f3569b);
        Npth.addTags(r11);
    }

    public static void b(final String r5, final String r10) {
        Handler r11 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new HybridCrashHelper$injectInfo$1(r5, r10));
    }
}
