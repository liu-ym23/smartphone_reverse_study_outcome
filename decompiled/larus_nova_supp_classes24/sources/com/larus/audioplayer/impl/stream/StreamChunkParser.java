package com.larus.audioplayer.impl.stream;

import android.os.SystemClock;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.BufferedReader;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class StreamChunkParser {
    public static final StreamChunkParser a = null;

    static {
        a = new StreamChunkParser();
    }

    public StreamChunkParser() {
    }

    public static w b(BufferedReader r11) {
    L2:
        String r0 = r11.readLine();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r1 = StringsKt.trim(r0).toString();
        if ((!StringsKt.isBlank(r1)) == false) goto L2;
        w r2 = new w();
        StringBuilder r3 = new StringBuilder();
    L9:
        if ((!StringsKt.isBlank(r1)) == false) goto L45;
        int r4 = StringsKt.indexOf$default(r1, ":", 0, false, 6, null);
        int r5 = -1;
        if (r4 == (-1)) goto L9;
        String r6 = StringsKt.trim(r1.substring(0, r4)).toString();
        String r7 = StringsKt.trim(r1.substring(r4 + 1)).toString();
        r3.append(r1);
        if (StringsKt.isBlank(r7) == true) goto L15;
        int r8 = r6.hashCode();
        if (r8 == 3355) goto L34;
        if (r8 == 3076010) goto L30;
        if (r8 != 96891546) goto L41;
        if (r6.equals("event") == false) goto L41;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r2.b = r7;
    L41:
        if (Intrinsics.areEqual(r2.b, "done") == true) goto L45;
        r1 = r11.readLine();
        if (r1 != null) goto L9;
    L44:
        r1 = "";
        goto L9
    L30:
        if (r6.equals("data") == false) goto L41;
        String r9 = r2.c + r7;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r2.c = r9;
        goto L41
    L34:
        if (r6.equals("id") == false) goto L41;
        Integer r10 = StringsKt.toIntOrNull(r7);
        if (r10 == null) goto L39;
        r5 = r10.intValue();
    L39:
        r2.a = r5;
        goto L41
    L15:
        r1 = r11.readLine();
        if (r1 != null) goto L9;
    L45:
        Intrinsics.checkNotNullParameter(r3.toString(), "<set-?>");
        return r2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x011d -> B:50:0x0120). Please report as a decompilation issue!!! */
    public final Object a(BufferedReader r20, Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r21, Function0<Boolean> r22, Continuation<? super Unit> r23) {
        if ((r23 instanceof StreamChunkParser$parseStream$1) == false) goto L7;
        StreamChunkParser$parseStream$1 r1 = (StreamChunkParser$parseStream$1) r23;
        int r2 = r1.label;
        if ((r2 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r1.label = r2 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L60:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r9 = r1.J$0;
        w r5 = (w) r1.L$3;
        Function0<Boolean> r11 = (Function0) r1.L$2;
        Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r12 = (Function2) r1.L$1;
        BufferedReader r13 = (BufferedReader) r1.L$0;
        ResultKt.throwOnFailure(r0);
        StreamChunkParser$parseStream$1 r8 = r1;
        BufferedReader r6 = r13;
        Object r10 = r3;
        String r14 = "StreamChunkParser";
        Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r7 = r12;
        long r15 = r9;
    L51:
        if (Intrinsics.areEqual(r5.b, "done") == false) goto L53;
        FLogger.a.i(r14, "receive done pkg，finish the chunk request normally");
    L56:
        FLogger.a.i(r14, "parseStream() exec finished");
        CoroutineDispatcher r16 = Dispatchers.getIO();
        StreamChunkParser$parseStream$2 r17 = new StreamChunkParser$parseStream$2(r6, null);
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.L$3 = null;
        r8.label = 2;
        if (BuildersKt.withContext(r16, r17, r8) != r10) goto L60;
        return r10;
    L53:
        Function0<Boolean> r19 = r11;
        long r110 = r15;
    L18:
        if (JobKt.isActive(r8.getContext()) == false) goto L56;
        if (((Boolean) r19.invoke()).booleanValue() == false) goto L61;
        FLogger.a.i(r14, "Conditional judgment is over, stop parseStream");
        goto L56
    L61:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L24
        Object r25 = Result.constructor-impl(b(r6));     // Catch: Throwable -> L24
    L26:
        Throwable r111 = Result.exceptionOrNull-impl(r25);
        if (r111 != null) goto L54;
        w r26 = (w) r25;
        if (AppHost.a.isTestChannel() == false) goto L46;
        IFlowSdkDepend r112 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r112 == null) goto L33;
        r112.a0();
        Integer r113 = com.larus.home.impl.sdk.g.a.b();
    L34:
        if (r113 != null) goto L37;
    L43:
        if (r113 == null) goto L46;
        FLogger.a.i(r14, "finish the StreamChunkParser#parseStrea() for debug index=" + r113);
        if (r26.a >= r113.intValue()) goto L56;
    L37:
        if (r113.intValue() != 20) goto L43;
        if (r26.a < r113.intValue()) goto L43;
        throw new IOException("test demo");
    L33:
        r113 = null;
    L46:
        r8.L$0 = r6;
        r8.L$1 = r7;
        r8.L$2 = r19;
        r8.L$3 = r26;
        r8.J$0 = r110;
        r8.label = 1;
        if (r7.invoke(r26, r8) != r10) goto L49;
        return r10;
    L49:
        r15 = r110;
        r11 = r19;
        r5 = r26;
        goto L51
    L54:
        r6.close();
        FLogger.a.e(r14, "parse chunk error。total cost duration=" + (SystemClock.elapsedRealtime() - r110) + "ms err=" + r111);
        throw r111;
    L24:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L16:
        ResultKt.throwOnFailure(r0);
        r19 = r22;
        r110 = SystemClock.elapsedRealtime();
        r10 = r3;
        r14 = "StreamChunkParser";
        r7 = r21;
        r8 = r1;
        r6 = r20;
    L7:
        r1 = new StreamChunkParser$parseStream$1(this, r23);
        goto L8
    }
}
