package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.bytedance.lark.rustclient.api.l;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.api.y;
import com.ss.android.lark.pb.improto.Command;
import hvb.f;
import hvb.g;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmNetRequestHandler implements com.ss.android.lark.officesdk.minutes.service.foundation.network.b {
    public static final /* synthetic */ int c = 0;
    public final l a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.FEISHU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L71:
            r0[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L85:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L55:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L57:
            r0[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L67:
            r0[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L79:
            r0[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
        L59:
            r0[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L37
        L75:
            r0[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L38
        L77:
            r0[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 10;     // Catch: NoSuchFieldError -> L39
        L49:
            r0[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 11;     // Catch: NoSuchFieldError -> L40
        L69:
            r0[MmRecordingSource.OBRIC_RECORDER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L41
        L19:
            a = r0;
            int[] r1 = new int[MmHttpContentType.values().length];
            r1[MmHttpContentType.JSON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L63:
            r1[MmHttpContentType.FORM_URL_ENCODED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L22:
            b = r1;
            int[] r2 = new int[MmHttpMethod.values().length];
            r2[MmHttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L53:
            r2[MmHttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L65:
            r2[MmHttpMethod.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L73:
            r2[MmHttpMethod.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L81:
            r2[MmHttpMethod.PATCH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L28:
            c = r2;
        }
    }

    static {
    }

    public final <R> Result<R> e(String r4) {
        String r0 = this.b.getCurrentUserId();
        if (y.a(r0) == true) goto L6;
        return null;
    L6:
        lvb.a.e("MmNetRequestHandler", "[skipNetworkRequestForAbsentUser] requestPath=" + r4 + ", userId=" + r0);
        Result.Companion r5 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(MmCustomExceptionKt.b)));
    }

    public MmNetRequestHandler(l r2, MinutesUCCImpl r3) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        Intrinsics.checkNotNullParameter(r3, "userContext");
        this.a = r2;
        this.b = r3;
    }

    public static void f(String r7, ErrorResult r8) {
        qvb.a.a.f(r7, Integer.valueOf(r8.getCode()), Integer.valueOf(r8.getStatus()), r8.getLogId(), Integer.valueOf(r8.getStatus()), "request_failed");
    }

    public static int d(String r4, String r5, int r6) {
        Lazy r0 = MmNetworkReqPath.a;
        Intrinsics.checkNotNullParameter(r4, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
        boolean r1 = false;
        if (StringsKt.endsWith$default(r4, "/quota", false, 2, null) == false) goto L5;
    L8:
        r1 = true;
    L9:
        if (r1 == true) goto L21;
        return r6;
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl(Integer.valueOf(JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r5), "error"), "id")));     // Catch: Throwable -> L13
    L15:
        Throwable r3 = Result.exceptionOrNull-impl(r7);
        if (r3 == null) goto L20;
        lvb.a.b("MmNetRequestHandler", "resolveHttpErrorBizCode failed: path=" + r4 + ", err=" + r3.getMessage());
        r7 = Integer.valueOf(r6);
    L20:
        return ((Number) r7).intValue();
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (StringsKt.endsWith$default(r4, "/upload/prepare", false, 2, null) == true) goto L8;
        if (StringsKt.endsWith$default(r4, "/upload/finish", false, 2, null) == false) goto L9;
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object c(Class<R> r6, gvb.a r7, Continuation<? super Result<? extends R>> r8) {
        if ((r8 instanceof MmNetRequestHandler$sendHttpRequest$1) == false) goto L7;
        MmNetRequestHandler$sendHttpRequest$1 r0 = (MmNetRequestHandler$sendHttpRequest$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L18:
        return ((Result) r9).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ExecutorCoroutineDispatcher r10 = MMCoroutines.a();
        MmNetRequestHandler$sendHttpRequest$2 r4 = new MmNetRequestHandler$sendHttpRequest$2(r7, this, r6, null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r10, r4, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new MmNetRequestHandler$sendHttpRequest$1(this, r8);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendServerPbRequest$3$callback$1, java.lang.Object] */
    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object a(final Command r18, final Class<R> r19, Message<?, ?> r20, Continuation<? super Result<? extends R>> r21) {
        if ((r21 instanceof MmNetRequestHandler$sendServerPbRequest$1) == false) goto L7;
        MmNetRequestHandler$sendServerPbRequest$1 r4 = (MmNetRequestHandler$sendServerPbRequest$1) r21;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        MmNetRequestHandler$sendServerPbRequest$1 r10 = r4;
        Object r3 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r10.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        Message r1 = (Message) r10.L$2;
        Class r2 = (Class) r10.L$1;
        Command r7 = (Command) r10.L$0;
        ResultKt.throwOnFailure(r3);
    L24:
        return ((Result) r3).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        Result<R> r8 = e(r18.getName());
        if (r8 != null) goto L17;
        r10.L$0 = r18;
        r10.L$1 = r19;
        r10.L$2 = r20;
        r10.label = 1;
        final SafeContinuation r12 = new SafeContinuation(IntrinsicsKt.intercepted(r10));
        lvb.a.e("MmNetRequestHandler", "[sendServerPbRequest] handle, command: " + r18 + ", input: " + r20);
        ProtoAdapter r9 = ProtoAdapter.get(r19);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<com.squareup.wire.Message<*, *>>");
        ?? r13 = new MmNetRequestHandler$sendServerPbRequest$3$callback$1(r12, r19, this, r18);
        int r14 = g.a;
        l r15 = this.a;
        Intrinsics.checkNotNullParameter(r15, "rustClient");
        Intrinsics.checkNotNullParameter(r18, "command");
        Intrinsics.checkNotNullParameter(r20, "request");
        Intrinsics.checkNotNullParameter(r9, "responseProtoAdapter");
        Intrinsics.checkNotNullParameter(r13, "callBack");
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = r15.h(new com.bytedance.lark.rustclient.api.d(r20.newBuilder(), r9, com.bytedance.lark.pb.basic.v1.Command.POST_GATEWAY, null, null, r18, null, 184)).a().subscribe(new f(r13, r16));
        r3 = r12.getOrThrow();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L21:
        if (r3 != r11) goto L24;
        return r11;
    L17:
        return r8.unbox-impl();
    L7:
        r4 = new MmNetRequestHandler$sendServerPbRequest$1(this, r21);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendPbRequest$3$callback$1, java.lang.Object] */
    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object b(final com.bytedance.lark.pb.basic.v1.Command r18, final Class<R> r19, Message<?, ?> r20, Continuation<? super Result<? extends R>> r21) {
        if ((r21 instanceof MmNetRequestHandler$sendPbRequest$1) == false) goto L7;
        MmNetRequestHandler$sendPbRequest$1 r5 = (MmNetRequestHandler$sendPbRequest$1) r21;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        MmNetRequestHandler$sendPbRequest$1 r10 = r5;
        Object r3 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r10.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        Message r1 = (Message) r10.L$2;
        Class r2 = (Class) r10.L$1;
        com.bytedance.lark.pb.basic.v1.Command r4 = (com.bytedance.lark.pb.basic.v1.Command) r10.L$0;
        ResultKt.throwOnFailure(r3);
    L24:
        return ((Result) r3).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        Result<R> r8 = e(r18.getName());
        if (r8 != null) goto L17;
        r10.L$0 = r18;
        r10.L$1 = r19;
        r10.L$2 = r20;
        r10.label = 1;
        final SafeContinuation r12 = new SafeContinuation(IntrinsicsKt.intercepted(r10));
        lvb.a.e("MmNetRequestHandler", "[sendPbRequest] handle, command=" + r18 + ", userId=" + this.b.getCurrentUserId() + ", rustClientHash=" + System.identityHashCode(this.a) + ", input=" + r20);
        ProtoAdapter r9 = ProtoAdapter.get(r19);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<com.squareup.wire.Message<*, *>>");
        ?? r13 = new MmNetRequestHandler$sendPbRequest$3$callback$1(r12, r19, this, r18);
        int r14 = g.a;
        l r15 = this.a;
        Intrinsics.checkNotNullParameter(r15, "rustClient");
        Intrinsics.checkNotNullParameter(r18, "command");
        Intrinsics.checkNotNullParameter(r20, "request");
        Intrinsics.checkNotNullParameter(r9, "responseProtoAdapter");
        Intrinsics.checkNotNullParameter(r13, "callBack");
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = r15.h(new com.bytedance.lark.rustclient.api.d(r20.newBuilder(), r9, r18, null, null, null, null, 248)).a().subscribe(new hvb.e(r13, r16));
        r3 = r12.getOrThrow();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L21:
        if (r3 != r11) goto L24;
        return r11;
    L17:
        return r8.unbox-impl();
    L7:
        r5 = new MmNetRequestHandler$sendPbRequest$1(this, r21);
        goto L8
    }
}
