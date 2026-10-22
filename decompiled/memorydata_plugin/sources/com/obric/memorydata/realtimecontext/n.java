package com.obric.memorydata.realtimecontext;

import android.os.Bundle;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.da;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J6\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J*\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ0\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001e0\u00182\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002JX\u0010\"\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001e0\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0$2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020 0$H\u0002J*\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018*\u00020\u00152\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0011H\u0002J(\u0010+\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u00060"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ReferenceResolution;", "", "<init>", "()V", "loadingModel", "", EventBody.KEY_VALUE, "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "model", "getModel", "()Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "loadModel", "resolution", "Lcom/obric/memorydata/sdk/realtime/RealTimeContextResult;", ChatMessage.TYPE_QUERY, "", "rewriteQuery", "queryId", "realTimeData", "Lcom/obric/memorydata/realtimecontext/session/RealTimeDataForClient;", "callPkg", "runModel", "Lkotlin/Pair;", "", "args", "Lorg/json/JSONObject;", "(Lcom/obric/aikernel/phx/sdk/api/IBaseModel;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processModelResult", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "result", "adjustResult", "screenAppEntities", "", "historyAppEntities", "screenMetaValues", "historyMetaValues", "findEntity", "type", OaidModel.KEY_ID, "reportRealmDuration", "modelDuration", "", "duration", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IBaseModel f12479b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ReferenceResolution$Companion;", "", "<init>", "()V", "TAG", "", "MODEL_NAME", "REALM_RESULT_KEY_ENTITIES", "REALM_RESULT_KEY_ID", "REALM_RESULT_KEY_TYPE", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12478a = new a(null);
    }

    public n() {
    }

    private static final Unit a(JSONObject r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$setCustomArgs");
        r4.putAll(BundleExtKt.json2Bundle$default(r3, false, 2, null));
        return Unit.INSTANCE;
    }

    private static final Unit a(final JSONObject r1, RequestParams r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$RequestParams");
        ParamsKt.setCustomArgs(r2, new $$Lambda$n$7pq19Wh6FtU3DYF7QPAmdgOVrSs(r1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(n r2, IBaseModel r3) {
        r2.f12479b = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r3, IBaseModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Unit lambda$7pq19Wh6FtU3DYF7QPAmdgOVrSs(JSONObject r0, Bundle r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$WCEh0UYTVzdFEurVzbYhIKOkIac(JSONObject r0, RequestParams r1) {
        return a(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.obric.aikernel.phx.sdk.api.IBaseModel] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public final Object a(IBaseModel r9, final JSONObject r10, Continuation<? super Pair<Integer, String>> r11) {
        Ref.IntRef r12 = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r9, IBaseModel.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ReferenceResolution$runModel$1.class) == false) goto L7;
        ReferenceResolution$runModel$1 r0 = (ReferenceResolution$runModel$1) ZeusTransformUtils.preCheckCast(r13, ReferenceResolution$runModel$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Ref.IntRef r15 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r16 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15 TimeoutCancellationException -> L30
        r12 = r15;
        r10 = r16;
    L39:
    L31:
        Object r17 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        Ref.IntRef r18 = r12;
        Ref.ObjectRef r19 = r10;
    L34:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r17);
        if (r20 == null) goto L38;
        r18.element = 1004;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "run model failed: " + r20, null, 4, null);
    L38:
        return new Pair(Boxing.boxInt(r18.element), r19.element);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Ref.IntRef r21 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r110 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
        Ref.IntRef r22 = r21;
        Ref.ObjectRef r111 = r110;
    L24:
        kotlinx.coroutines.flow.i r23 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        Function2 r24 = (Function2) ZeusTransformUtils.preCheckCast(new ReferenceResolution$runModel$2$1(r23, r111, r22, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 TimeoutCancellationException -> L30
        r0.L$0 = r111;     // Catch: Throwable -> L15 TimeoutCancellationException -> L30
        r0.L$1 = r22;     // Catch: Throwable -> L15 TimeoutCancellationException -> L30
        r0.label = 2;     // Catch: Throwable -> L15 TimeoutCancellationException -> L30
        r12 = r22;
        r10 = r111;
        if (da.a(5000, r24, r0) != r14) goto L39;
        return r14;
    L20:
        ResultKt.throwOnFailure(r8);
        Ref.ObjectRef r25 = new Ref.ObjectRef();
        r25.element = "";
        Ref.IntRef r4 = new Ref.IntRef();
        RequestParams r6 = new RequestParams(null, new $$Lambda$n$WCEh0UYTVzdFEurVzbYhIKOkIac(r10), 1, null);
        r0.L$0 = r25;
        r0.L$1 = r4;
        r0.label = 1;
        Object r26 = r12.inferAsFlow(r6, r0);
        if (r26 != r14) goto L23;
        return r14;
    L23:
        r111 = r25;
        r8 = r26;
        r22 = r4;
    L30:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "query result time out", null, 4, null);     // Catch: Throwable -> L15
        r12.element = 1007;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        r18 = r12;
        r19 = r10;
    L7:
        r0 = new ReferenceResolution$runModel$1(this, r13);
        goto L8
    }
}
