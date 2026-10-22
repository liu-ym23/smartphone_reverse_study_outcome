package com.larus.dora.impl.dynamic.loader;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import d59.g;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final Gson a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.loader.b$b, reason: collision with other inner class name */
    public interface InterfaceC0065b {
        void onFail();

        void onSuccess();
    }

    static {
    }

    public b() {
        this.a = new Gson();
    }

    public static final Object a(b r6, String r7, InterfaceC0065b r8, Continuation r9) {
        r6.getClass();
        if ((r9 instanceof DoraLaunchProductDataLoader$requestAndProcessData$1) == false) goto L7;
        DoraLaunchProductDataLoader$requestAndProcessData$1 r0 = (DoraLaunchProductDataLoader$requestAndProcessData$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r8 = (InterfaceC0065b) r0.L$1;
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L25
    L20:
        g r11 = (g) r10;     // Catch: Exception -> L25
        if (r11 == null) goto L23;
        Keva r4 = g49.c.a;     // Catch: Exception -> L25
        g49.c.a(r7, r6.a.toJson(r11));     // Catch: Exception -> L25
        r8.onSuccess();     // Catch: Exception -> L25
    L28:
        return Unit.INSTANCE;
    L23:
        r8.onFail();     // Catch: Exception -> L25
        goto L28
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
        FLogger.a.e("DoraDynamicDataLoader", "Requesting data");     // Catch: Exception -> L25
        CoroutineDispatcher r12 = Dispatchers.getIO();     // Catch: Exception -> L25
        DoraLaunchProductDataLoader$requestAndProcessData$$inlined$requestData$1 r5 = new DoraLaunchProductDataLoader$requestAndProcessData$$inlined$requestData$1(r6, null);     // Catch: Exception -> L25
        r0.L$0 = r7;     // Catch: Exception -> L25
        r0.L$1 = r8;     // Catch: Exception -> L25
        r0.label = 1;     // Catch: Exception -> L25
        r10 = BuildersKt.withContext(r12, r5, r0);     // Catch: Exception -> L25
        if (r10 != r2) goto L20;
        return r2;
    L25:
        e = move-exception;
        FLogger.a.e("DoraDynamicDataLoader", "fetchData error: " + e.getMessage());
        e.getMessage();
        r8.onFail();
    L7:
        r0 = new DoraLaunchProductDataLoader$requestAndProcessData$1(r6, r9);
        goto L8
    }
}
