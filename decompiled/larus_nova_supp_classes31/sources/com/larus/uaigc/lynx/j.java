package com.larus.uaigc.lynx;

import com.google.gson.Gson;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public static final j a = null;
    public static final Gson b = null;

    public j() {
    }

    public static boolean b() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        s09.a r2 = PollingConfigService.a.d();     // Catch: Throwable -> L14
        if (r2 == null) goto L8;
        Map r3 = r2.a;     // Catch: Throwable -> L14
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("m_cache_off");     // Catch: Throwable -> L14
    L9:
        if (l3.e(r4, 0) != 1) goto L21;
        return true;
    L21:
        return false;
    L8:
        r4 = null;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Throwable r6 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r6 == null) goto L18;
        FLogger.a.e("PollingConfigInfoProvider", "[provideMainPageCacheDisable] failed, error = " + r6);
    L18:
        return false;
    }

    public static int c() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        s09.a r2 = PollingConfigService.a.h();     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        Map r3 = r2.a;     // Catch: Throwable -> L15
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("t_scatter");     // Catch: Throwable -> L15
    L10:
        if (o0.d(r4) == false) goto L22;
        Integer r5 = ((Scatter) b.fromJson(r4, Scatter.class)).getProbs();     // Catch: Throwable -> L15
        if (r5 == null) goto L23;
        return r5.intValue();
    L23:
        return 0;
    L22:
        return 0;
    L8:
        r4 = null;
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Throwable r7 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r7 == null) goto L19;
        FLogger.a.e("PollingConfigInfoProvider", "[provideMainTimeScatterProbs] failed, error = " + r7);
    L19:
        return 0;
    }

    public static Scatter e() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        s09.a r2 = PollingConfigService.a.d();     // Catch: Throwable -> L14
        if (r2 == null) goto L8;
        Map r3 = r2.a;     // Catch: Throwable -> L14
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("t_scatter");     // Catch: Throwable -> L14
    L10:
        if (o0.d(r4) == false) goto L13;
        return (Scatter) b.fromJson(r4, Scatter.class);
    L13:
        return null;
    L8:
        r4 = null;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Throwable r6 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r6 == null) goto L18;
        FLogger.a.e("PollingConfigInfoProvider", "[provideMainTimeScatterStruct] failed, error = " + r6);
    L18:
        return null;
    }

    static {
        a = new j();
        b = new Gson();
    }

    public static String a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        s09.a r2 = PollingConfigService.a.d();     // Catch: Throwable -> L16
        if (r2 == null) goto L8;
        Map r3 = r2.a;     // Catch: Throwable -> L16
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("chat_lite");     // Catch: Throwable -> L16
    L10:
        if (o0.d(r4) == false) goto L23;
        String r5 = ((ChatLite) b.fromJson(r4, ChatLite.class)).getChatLiteOption();     // Catch: Throwable -> L16
        if (r5 != null) goto L15;
        return "0";
    L15:
        return r5;
    L23:
        return "0";
    L8:
        r4 = null;
    L16:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Throwable r7 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r7 == null) goto L20;
        FLogger.a.e("PollingConfigInfoProvider", "[provideChatLiteOption] failed, error = " + r7);
    L20:
        return "0";
    }

    public static List d() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        s09.a r1 = PollingConfigService.a.d();     // Catch: Throwable -> L16
        if (r1 == null) goto L7;
        Map r2 = r1.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("t_scatter");     // Catch: Throwable -> L16
    L9:
        if (o0.d(r3) == false) goto L15;
        List<Segment> r4 = ((Scatter) b.fromJson(r3, Scatter.class)).getSegments();     // Catch: Throwable -> L16
        if (r4 == null) goto L13;
        return r4;
    L13:
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt.emptyList();
    L7:
        r3 = null;
    L16:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Throwable r6 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r6 == null) goto L21;
        FLogger.a.e("PollingConfigInfoProvider", "[provideMainTimeScatterSegments] failed, error = " + r6);
    L21:
        return CollectionsKt.emptyList();
    }
}
