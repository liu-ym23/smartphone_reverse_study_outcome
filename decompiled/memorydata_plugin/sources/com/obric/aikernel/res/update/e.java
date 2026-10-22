package com.obric.aikernel.res.update;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a{\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00010\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002\u001a\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002\u001a\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0000\u001a\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$H\u0000\u001aÁ\u0001\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&21\u0010'\u001a-\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0(2$\b\u0002\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0(2O\b\u0002\u0010,\u001aI\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(.\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\r0-H\u0080@ø\u0001\u0000¢\u0006\u0002\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"TLS_BOOTSTRAP_RETRY_DELAYS", "", "", "collectParsedDistributeConfigs", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "parseBusinesses", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "parseLoras", "Lkotlin/Function0;", "onBusinessFailure", "", "", "onLoraFailure", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "describeMetadataJsonElement", "", "element", "Lcom/google/gson/JsonElement;", "isMetadataResponseStatusSuccessful", "", "status", "nextMetadataRequestRetryDelayMillis", "failureKind", "Lcom/obric/aikernel/res/update/MetadataRequestFailureKind;", "attempt", "", "(Lcom/obric/aikernel/res/update/MetadataRequestFailureKind;I)Ljava/lang/Long;", "normalizeMetadataRequestFailure", "Lcom/obric/aikernel/res/update/MetadataRequestException;", "throwable", "parseMetadataResponseEnvelope", "Lcom/obric/aikernel/res/update/MetadataResponseEnvelope;", Params.CONTENT, "gson", "Lcom/google/gson/Gson;", "runMetadataRequestWithRetry", ExifInterface.GPS_DIRECTION_TRUE, "executeAttempt", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "delayFn", "onAttemptFailure", "Lkotlin/Function3;", "failure", "nextDelayMillis", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Long> f6127a = null;

    static {
        f6127a = CollectionsKt.listOf(new Long[]{2000L, 5000L, 10000L});
    }

    public static final MetadataRequestException a(Throwable r6) {
        Intrinsics.checkNotNullParameter(r6, "throwable");
        if (ZeusTransformUtils.instanceOf(r6, MetadataRequestException.class) == false) goto L7;
        return (MetadataRequestException) ZeusTransformUtils.preCheckCast(r6, MetadataRequestException.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r6, IllegalAccessException.class) == false) goto L18;
        String r0 = r6.getMessage();
        boolean r2 = false;
        if (r0 != null) goto L11;
    L13:
        if (r2 == false) goto L18;
        MetadataRequestFailureKind r1 = MetadataRequestFailureKind.TLS_BOOTSTRAP_PENDING;
        String r3 = r6.getMessage();
        if (r3 != null) goto L17;
        r3 = "metadata request tls bootstrap pending";
    L17:
        MetadataRequestException r4 = new MetadataRequestException(r1, r3, r6);
    L22:
        return r4;
    L11:
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("tls not ready", CharSequence.class, "com.obric.memorydata.plugin"), true) != true) goto L13;
        r2 = true;
    L18:
        MetadataRequestFailureKind r5 = MetadataRequestFailureKind.UNKNOWN_TRANSPORT;
        String r7 = r6.getMessage();
        if (r7 != null) goto L21;
        r7 = "metadata request transport failure";
    L21:
        r4 = new MetadataRequestException(r5, r7, r6);
        goto L22
    }

    public static final g a(String r14, Gson r15) {
        Intrinsics.checkNotNullParameter(r14, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r15, "gson");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.m1421constructorimpl((JsonObject) ZeusTransformUtils.preCheckCast(r15.fromJson(r14, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.m1424exceptionOrNullimpl(r0);
        if (r1 != null) goto L29;
        JsonObject r2 = (JsonObject) ZeusTransformUtils.preCheckCast(r0, JsonObject.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L27;
        String r4 = b(r2.get("status"));
        String r5 = b(r2.get("message"));
        String r6 = b(r2.get(WsConstants.KEY_EXTRA));
        if (a(r2.get("status")) == false) goto L25;
        JsonElement r7 = r2.get("data");
        boolean r8 = true;
        if (r7 != null) goto L16;
    L18:
        r8 = false;
    L19:
        if (r8 == false) goto L23;
        JsonObject r9 = r7.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r9, "data.asJsonObject");
        return new g(r4, r5, r6, r9);
    L23:
        throw new MetadataRequestException(MetadataRequestFailureKind.RESPONSE_PARSE_FAILED, "metadata response missing data object status=" + r4 + " message=" + r5 + " extra=" + r6, null, 4, null);
    L16:
        if (r7.isJsonObject() != true) goto L18;
    L25:
        throw new MetadataRequestException(MetadataRequestFailureKind.BUSINESS_REJECTED, "metadata response rejected status=" + r4 + " message=" + r5 + " extra=" + r6, null, 4, null);
    L27:
        throw new MetadataRequestException(MetadataRequestFailureKind.RESPONSE_PARSE_FAILED, "metadata response json is null", null, 4, null);
    L29:
        throw new MetadataRequestException(MetadataRequestFailureKind.RESPONSE_PARSE_FAILED, "metadata response json parse failed", r1);
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final Long a(MetadataRequestFailureKind r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "failureKind");
        if (r1 == MetadataRequestFailureKind.TLS_BOOTSTRAP_PENDING) goto L7;
        return null;
    L7:
        return (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(f6127a, r2 - 1), Long.class, "com.obric.memorydata.plugin");
    }

    public static final Object a(Function1<? super Continuation<? super List<? extends com.obric.aikernel.res.metadata.config.k>>, ? extends Object> r6, Function0<? extends List<? extends com.obric.aikernel.res.metadata.config.k>> r7, Function1<? super Throwable, Unit> r8, Function1<? super Throwable, Unit> r9, Continuation<? super List<? extends com.obric.aikernel.res.metadata.config.k>> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, MetadataRequestFailureKt$collectParsedDistributeConfigs$1.class) == false) goto L7;
        MetadataRequestFailureKt$collectParsedDistributeConfigs$1 r0 = (MetadataRequestFailureKt$collectParsedDistributeConfigs$1) ZeusTransformUtils.preCheckCast(r15, MetadataRequestFailureKt$collectParsedDistributeConfigs$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        List r17 = (List) ZeusTransformUtils.preCheckCast(r0.L$3, List.class, "com.obric.memorydata.plugin");
        r14 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$2, Function1.class, "com.obric.memorydata.plugin");
        r13 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$1, Function1.class, "com.obric.memorydata.plugin");
        r12 = (Function0) ZeusTransformUtils.preCheckCast(r0.L$0, Function0.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
    L23:
        Object r18 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L29:
        if (Result.m1428isSuccessimpl(r18) == false) goto L31;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L31:
        Throwable r19 = Result.m1424exceptionOrNullimpl(r18);
        if (r19 == null) goto L49;
        r13.invoke(r19);
    L49:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L36
        Object r21 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r12.invoke(), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L36
    L39:
        if (Result.m1428isSuccessimpl(r21) == false) goto L41;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L41:
        Throwable r22 = Result.m1424exceptionOrNullimpl(r21);
        if (r22 == null) goto L44;
        r14.invoke(r22);
    L44:
        return r17;
    L36:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L14:
        Throwable th = th;
    L27:
        Result.Companion r1 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r16);
        List r110 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L25
        r0.L$0 = r12;     // Catch: Throwable -> L25
        r0.L$1 = r13;     // Catch: Throwable -> L25
        r0.L$2 = r14;     // Catch: Throwable -> L25
        r0.L$3 = r110;     // Catch: Throwable -> L25
        r0.label = 1;     // Catch: Throwable -> L25
        Object r24 = r11.invoke(r0);     // Catch: Throwable -> L25
        if (r24 != r2) goto L22;
        return r2;
    L22:
        r16 = r24;
        r17 = r110;
    L25:
        th = move-exception;
        th = th;
        r17 = r110;
    L7:
        r0 = new MetadataRequestFailureKt$collectParsedDistributeConfigs$1(r15);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ef -> B:13:0x0077). Please report as a decompilation issue!!! */
    public static final <T> Object a(Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> r9, Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r10, Function3<? super Integer, ? super MetadataRequestException, ? super Long, Unit> r11, Continuation<? super T> r12) {
        Function2 r13 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Function2 r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        Function3 r15 = (Function3) ZeusTransformUtils.wrapperContextForParams(r11, Function3.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, MetadataRequestFailureKt$runMetadataRequestWithRetry$1.class) == false) goto L7;
        MetadataRequestFailureKt$runMetadataRequestWithRetry$1 r0 = (MetadataRequestFailureKt$runMetadataRequestWithRetry$1) ZeusTransformUtils.preCheckCast(r16, MetadataRequestFailureKt$runMetadataRequestWithRetry$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L21;
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        int r18 = r0.I$0;
        Function3 r19 = (Function3) ZeusTransformUtils.preCheckCast(r0.L$2, Function3.class, "com.obric.memorydata.plugin");
        Function2 r110 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$1, Function2.class, "com.obric.memorydata.plugin");
        Function2 r1 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$0, Function2.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L13:
        Function2 r7 = r110;
        r15 = r19;
        r14 = r7;
        int r111 = r18 + 1;
        r13 = r1;
    L35:
        Integer r4 = Boxing.boxInt(r111);     // Catch: Throwable -> L26
        r0.L$0 = r13;     // Catch: Throwable -> L26
        r0.L$1 = r14;     // Catch: Throwable -> L26
        r0.L$2 = r15;     // Catch: Throwable -> L26
        r0.I$0 = r111;     // Catch: Throwable -> L26
        r0.label = 1;     // Catch: Throwable -> L26
        r17 = r13.invoke(r4, r0);     // Catch: Throwable -> L26
        if (r17 != r2) goto L25;
        return r2;
    L25:
        return r17;
    L26:
        th = move-exception;
        r1 = r13;
        r18 = r111;
        Throwable th = th;
        Function3 r8 = r15;
        r110 = r14;
        r19 = r8;
    L28:
        MetadataRequestException r112 = a(th);
        Long r5 = a(r112.getKind(), r18);
        r19.invoke(Boxing.boxInt(r18), r112, r5);
        if (r5 == null) goto L34;
        r0.L$0 = r1;
        r0.L$1 = r110;
        r0.L$2 = r19;
        r0.I$0 = r18;
        r0.label = 2;
        if (r110.invoke(r5, r0) != r2) goto L13;
        return r2;
    L34:
        throw r112;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r18 = r0.I$0;
        r19 = (Function3) ZeusTransformUtils.preCheckCast(r0.L$2, Function3.class, "com.obric.memorydata.plugin");
        r110 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$1, Function2.class, "com.obric.memorydata.plugin");
        r1 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$0, Function2.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L19
    L19:
        th = th;
        goto L28
    L21:
        ResultKt.throwOnFailure(r17);
        r111 = 1;
    L7:
        r0 = new MetadataRequestFailureKt$runMetadataRequestWithRetry$1(r16);
        goto L8
    }

    public static /* synthetic */ Object a(Function2 r1, Function2 r2, Function3 r3, Continuation r4, int r5, Object r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r1, Function2.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Function3 r9 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = (Function2) ZeusTransformUtils.preCheckCast(new MetadataRequestFailureKt$runMetadataRequestWithRetry$2(null), Function2.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L9;
        r9 = (Function3) ZeusTransformUtils.preCheckCast(MetadataRequestFailureKt$runMetadataRequestWithRetry$3.INSTANCE, Function3.class, "com.obric.memorydata.plugin");
    L9:
        return a(r7, r8, r9, r10);
    }

    private static final boolean a(JsonElement r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r3.isJsonNull() == false) goto L8;
        return true;
    L8:
        if (r3.isJsonPrimitive() == true) goto L10;
        return false;
    L10:
        JsonPrimitive r4 = r3.getAsJsonPrimitive();
        if (r4.isNumber() == false) goto L16;
        if (r4.getAsInt() != 0) goto L19;
        return true;
    L19:
        return false;
    L16:
        if (r4.isString() == false) goto L19;
        return Intrinsics.areEqual(r4.getAsString(), "0");
    }

    private static final String b(JsonElement r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.isJsonNull() == false) goto L7;
        return null;
    L7:
        if (r1.isJsonPrimitive() == false) goto L13;
        if (r1.getAsJsonPrimitive().isString() == false) goto L13;
        return r1.getAsString();
    L13:
        return r1.toString();
    }
}
