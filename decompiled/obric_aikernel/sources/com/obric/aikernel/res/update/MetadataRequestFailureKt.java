package com.obric.aikernel.res.update;

import androidx.work.WorkRequest;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class MetadataRequestFailureKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Long> f5116a = null;

    static {
        f5116a = CollectionsKt.listOf(new Long[]{2000L, 5000L, Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS)});
    }

    public static final Object a(Function1<? super Continuation<? super List<? extends UpdateTaskConfig>>, ? extends Object> r10, Function0<? extends List<? extends UpdateTaskConfig>> r11, Function1<? super Throwable, Unit> r12, Function1<? super Throwable, Unit> r13, Continuation<? super List<? extends UpdateTaskConfig>> r14) {
        if ((r14 instanceof MetadataRequestFailureKt$collectParsedDistributeConfigs$1) == false) goto L7;
        MetadataRequestFailureKt$collectParsedDistributeConfigs$1 r15 = (MetadataRequestFailureKt$collectParsedDistributeConfigs$1) r14;
        int r16 = r15.label;
        if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
        r15.label = r16 - Integer.MIN_VALUE;
    L8:
        Object r17 = r15.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r15.label;
        if (r19 == 0) goto L18;
        if (r19 != 1) goto L17;
        List r20 = (List) r15.L$3;
        r13 = (Function1) r15.L$2;
        r12 = (Function1) r15.L$1;
        r11 = (Function0) r15.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L14
    L23:
        Object r21 = Result.m32constructorimpl((List) r17);     // Catch: Throwable -> L14
    L29:
        if (Result.m39isSuccessimpl(r21) == false) goto L31;
        CollectionsKt.addAll(r20, (List) r21);
    L31:
        Throwable r22 = Result.m35exceptionOrNullimpl(r21);
        if (r22 == null) goto L47;
        r12.invoke(r22);
    L47:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L36
        Object r24 = Result.m32constructorimpl(r11.invoke());     // Catch: Throwable -> L36
    L39:
        if (Result.m39isSuccessimpl(r24) == false) goto L41;
        CollectionsKt.addAll(r20, (List) r24);
    L41:
        Throwable r25 = Result.m35exceptionOrNullimpl(r24);
        if (r25 == null) goto L44;
        r13.invoke(r25);
    L44:
        return r20;
    L36:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L14:
        Throwable th = th;
    L27:
        Result.Companion r27 = Result.Companion;
        r21 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L29
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r17);
        ArrayList r28 = new ArrayList();
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L25
        r15.L$0 = r11;     // Catch: Throwable -> L25
        r15.L$1 = r12;     // Catch: Throwable -> L25
        r15.L$2 = r13;     // Catch: Throwable -> L25
        r15.L$3 = r28;     // Catch: Throwable -> L25
        r15.label = 1;     // Catch: Throwable -> L25
        Object r30 = r10.invoke(r15);     // Catch: Throwable -> L25
        if (r30 != r18) goto L22;
        return r18;
    L22:
        r17 = r30;
        r20 = r28;
    L25:
        th = move-exception;
        th = th;
        r20 = r28;
    L7:
        r15 = new MetadataRequestFailureKt$collectParsedDistributeConfigs$1(r14);
        goto L8
    }

    private static final String b(com.google.gson.i r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.j() == false) goto L7;
        return null;
    L7:
        if (r10.l() == false) goto L13;
        if (r10.f().q() == false) goto L13;
        return r10.h();
    L13:
        return r10.toString();
    }

    private static final boolean c(com.google.gson.i r10) {
        if (r10 != null) goto L5;
        return true;
    L5:
        if (r10.j() == false) goto L8;
        return true;
    L8:
        if (r10.l() == true) goto L10;
        return false;
    L10:
        com.google.gson.m r11 = r10.f();
        if (r11.p() == false) goto L16;
        if (r11.c() != 0) goto L19;
        return true;
    L19:
        return false;
    L16:
        if (r11.q() == false) goto L19;
        return Intrinsics.areEqual(r11.h(), NetConst.NOT_ENCRYPT_VERISON_CODE);
    }

    public static final Long d(MetadataRequestFailureKind r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "failureKind");
        if (r10 == MetadataRequestFailureKind.TLS_BOOTSTRAP_PENDING) goto L7;
        return null;
    L7:
        return (Long) CollectionsKt.getOrNull(f5116a, r11 - 1);
    }

    public static final MetadataRequestException e(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "throwable");
        if ((r10 instanceof MetadataRequestException) == false) goto L7;
        return (MetadataRequestException) r10;
    L7:
        if ((r10 instanceof IllegalAccessException) == false) goto L18;
        String r11 = r10.getMessage();
        boolean r12 = false;
        if (r11 != null) goto L11;
    L13:
        if (r12 == false) goto L18;
        MetadataRequestFailureKind r13 = MetadataRequestFailureKind.TLS_BOOTSTRAP_PENDING;
        String r14 = r10.getMessage();
        if (r14 != null) goto L17;
        r14 = "metadata request tls bootstrap pending";
    L17:
        MetadataRequestException r15 = new MetadataRequestException(r13, r14, r10);
    L22:
        return r15;
    L11:
        if (StringsKt.contains(r11, "tls not ready", true) != true) goto L13;
        r12 = true;
    L18:
        MetadataRequestFailureKind r16 = MetadataRequestFailureKind.UNKNOWN_TRANSPORT;
        String r17 = r10.getMessage();
        if (r17 != null) goto L21;
        r17 = "metadata request transport failure";
    L21:
        r15 = new MetadataRequestException(r16, r17, r10);
        goto L22
    }

    public static final e f(String r14, com.google.gson.d r15) {
        Intrinsics.checkNotNullParameter(r14, "content");
        Intrinsics.checkNotNullParameter(r15, "gson");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m32constructorimpl((com.google.gson.k) r15.k(r14, com.google.gson.k.class));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m35exceptionOrNullimpl(r11);
        if (r12 != null) goto L29;
        com.google.gson.k r13 = (com.google.gson.k) r11;
        if (r13 == null) goto L27;
        String r16 = b(r13.s("status"));
        String r17 = b(r13.s("message"));
        String r18 = b(r13.s(WsConstants.KEY_EXTRA));
        if (c(r13.s("status")) == false) goto L25;
        com.google.gson.i r19 = r13.s("data");
        boolean r20 = true;
        if (r19 != null) goto L16;
    L18:
        r20 = false;
    L19:
        if (r20 == false) goto L23;
        com.google.gson.k r21 = r19.e();
        Intrinsics.checkNotNullExpressionValue(r21, "data.asJsonObject");
        return new e(r16, r17, r18, r21);
    L23:
        throw new MetadataRequestException(MetadataRequestFailureKind.RESPONSE_PARSE_FAILED, "metadata response missing data object status=" + r16 + " message=" + r17 + " extra=" + r18, null, 4, null);
    L16:
        if (r19.k() != true) goto L18;
    L25:
        throw new MetadataRequestException(MetadataRequestFailureKind.BUSINESS_REJECTED, "metadata response rejected status=" + r16 + " message=" + r17 + " extra=" + r18, null, 4, null);
    L27:
        throw new MetadataRequestException(MetadataRequestFailureKind.RESPONSE_PARSE_FAILED, "metadata response json is null", null, 4, null);
    L29:
        throw new MetadataRequestException(MetadataRequestFailureKind.RESPONSE_PARSE_FAILED, "metadata response json parse failed", r12);
    L5:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009e -> B:13:0x0039). Please report as a decompilation issue!!! */
    public static final <T> Object g(Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> r10, Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r11, Function3<? super Integer, ? super MetadataRequestException, ? super Long, Unit> r12, Continuation<? super T> r13) {
        if ((r13 instanceof MetadataRequestFailureKt$runMetadataRequestWithRetry$1) == false) goto L7;
        MetadataRequestFailureKt$runMetadataRequestWithRetry$1 r14 = (MetadataRequestFailureKt$runMetadataRequestWithRetry$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L21;
        if (r18 == 1) goto L16;
        if (r18 != 2) goto L15;
        int r19 = r14.I$0;
        Function3<? super Integer, ? super MetadataRequestException, ? super Long, Unit> r110 = (Function3) r14.L$2;
        Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r111 = (Function2) r14.L$1;
        Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> r20 = (Function2) r14.L$0;
        ResultKt.throwOnFailure(r16);
    L13:
        Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r21 = r111;
        r12 = r110;
        r11 = r21;
        int r112 = r19 + 1;
        r10 = r20;
    L35:
        Integer r22 = Boxing.boxInt(r112);     // Catch: Throwable -> L26
        r14.L$0 = r10;     // Catch: Throwable -> L26
        r14.L$1 = r11;     // Catch: Throwable -> L26
        r14.L$2 = r12;     // Catch: Throwable -> L26
        r14.I$0 = r112;     // Catch: Throwable -> L26
        r14.label = 1;     // Catch: Throwable -> L26
        r16 = r10.invoke(r22, r14);     // Catch: Throwable -> L26
        if (r16 != r17) goto L25;
        return r17;
    L25:
        return r16;
    L26:
        th = move-exception;
        r20 = r10;
        r19 = r112;
        Throwable th = th;
        Function3<? super Integer, ? super MetadataRequestException, ? super Long, Unit> r23 = r12;
        r111 = r11;
        r110 = r23;
    L28:
        MetadataRequestException r113 = e(th);
        Long r24 = d(r113.getKind(), r19);
        r110.invoke(Boxing.boxInt(r19), r113, r24);
        if (r24 == null) goto L34;
        r14.L$0 = r20;
        r14.L$1 = r111;
        r14.L$2 = r110;
        r14.I$0 = r19;
        r14.label = 2;
        if (r111.invoke(r24, r14) != r17) goto L13;
        return r17;
    L34:
        throw r113;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r19 = r14.I$0;
        r110 = (Function3) r14.L$2;
        r111 = (Function2) r14.L$1;
        r20 = (Function2) r14.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L19
    L19:
        th = th;
        goto L28
    L21:
        ResultKt.throwOnFailure(r16);
        r112 = 1;
    L7:
        r14 = new MetadataRequestFailureKt$runMetadataRequestWithRetry$1(r13);
        goto L8
    }

    public static /* synthetic */ Object h(Function2 r10, Function2 r11, Function3 r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = new MetadataRequestFailureKt$runMetadataRequestWithRetry$2(null);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = MetadataRequestFailureKt$runMetadataRequestWithRetry$3.INSTANCE;
    L9:
        return g(r10, r11, r12, r13);
    }
}
