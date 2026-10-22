package com.larus.avlink.activeSummary;

import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.avlink.n1;
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
public final class ChunkParser {
    public static final ChunkParser a = null;

    static {
        a = new ChunkParser();
    }

    public ChunkParser() {
    }

    public static a b(Function0 r10) {
    L2:
        String r0 = StringsKt.trim((String) r10.invoke()).toString();
        if ((!StringsKt.isBlank(r0)) == false) goto L2;
        a r1 = new a();
        StringBuilder r2 = new StringBuilder();
    L6:
        if ((!StringsKt.isBlank(r0)) == false) goto L38;
        int r3 = StringsKt.indexOf$default(r0, ":", 0, false, 6, null);
        int r4 = -1;
        if (r3 == (-1)) goto L6;
        String r5 = StringsKt.trim(r0.substring(0, r3)).toString();
        String r6 = StringsKt.trim(r0.substring(r3 + 1)).toString();
        r2.append(r0);
        if (StringsKt.isBlank(r6) == true) goto L12;
        int r7 = r5.hashCode();
        if (r7 == 3355) goto L29;
        if (r7 == 3076010) goto L25;
        if (r7 != 96891546) goto L36;
        if (r5.equals("event") == false) goto L36;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r1.b = r6;
    L36:
        if (Intrinsics.areEqual(r1.b, "done") == true) goto L38;
        r0 = (String) r10.invoke();
        goto L6
    L25:
        if (r5.equals("data") == false) goto L36;
        String r8 = r1.c + r6;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r1.c = r8;
        goto L36
    L29:
        if (r5.equals("id") == false) goto L36;
        Integer r9 = StringsKt.toIntOrNull(r6);
        if (r9 == null) goto L34;
        r4 = r9.intValue();
    L34:
        r1.a = r4;
        goto L36
    L12:
        r0 = (String) r10.invoke();
    L38:
        Intrinsics.checkNotNullParameter(r2.toString(), "<set-?>");
        return r1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0088 -> B:29:0x008a). Please report as a decompilation issue!!! */
    public final Object a(Function0<String> r7, Function0<Unit> r8, Function2<? super a, ? super Continuation<? super Unit>, ? extends Object> r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof ChunkParser$parseStream$1) == false) goto L7;
        ChunkParser$parseStream$1 r0 = (ChunkParser$parseStream$1) r10;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        a r12 = (a) r0.L$3;
        Function2<? super a, ? super Continuation<? super Unit>, ? extends Object> r13 = (Function2) r0.L$2;
        Function0<Unit> r14 = (Function0) r0.L$1;
        Function0<String> r4 = (Function0) r0.L$0;
        ResultKt.throwOnFailure(r11);
        r9 = r13;
        r8 = r14;
    L30:
        if (Intrinsics.areEqual(r12.b, "done") == true) goto L39;
        r7 = r4;
    L18:
        if (JobKt.isActive(r0.getContext()) == false) goto L39;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L21
        Object r16 = Result.constructor-impl(b(r7));     // Catch: Throwable -> L21
    L23:
        Throwable r5 = Result.exceptionOrNull-impl(r16);
        if (r5 != null) goto L44;
        a r17 = (a) r16;
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.L$2 = r9;
        r0.L$3 = r17;
        r0.label = 1;
        if (r9.invoke(r17, r0) != r2) goto L28;
        return r2;
    L28:
        r4 = r7;
        r12 = r17;
        goto L30
    L44:
        r8.invoke();     // Catch: Throwable -> L35
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        n1.a("ChunkParser", "ChunkParser.parseStream IllegalStateException " + r5);
        throw new IllegalStateException("read line exception", r5);
    L35:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        CoroutineDispatcher r20 = Dispatchers.getIO();
        ChunkParser$parseStream$2 r21 = new ChunkParser$parseStream$2(r8, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.label = 2;
        if (BuildersKt.withContext(r20, r21, r0) != r2) goto L43;
        return r2;
    L16:
        ResultKt.throwOnFailure(r11);
    L7:
        r0 = new ChunkParser$parseStream$1(this, r10);
        goto L8
    }
}
