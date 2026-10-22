package com.obric.aikernel.phx.sdk;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\t\u0010\u0018\u001a\u00020\u0001H\u0086\u0002J+\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0017J2\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lcom/obric/aikernel/phx/sdk/AIKernelManager;", "Lcom/obric/aikernel/phx/sdk/IAIKernelManager;", "()V", "instance", "Lcom/obric/aikernel/phx/sdk/api/AIKernelApi;", "getInstance$sdk_release", "()Lcom/obric/aikernel/phx/sdk/api/AIKernelApi;", "clearAIKernelData", "", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackage", "Lkotlin/Result;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "business", "", "getPackage-0E7RQCE", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CommonConsts.APM_INNER_EVENT_COST_INIT, "config", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "logger", "Lcom/obric/aikernel/core/log/ILog;", "invoke", "loadPackage", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", ActivityLifecycle.NAME, "useCloud", "", "(Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerLog", "inst", "updatePackage", "updatePackage-0E7RQCE", "(Lcom/obric/aikernel/sdk/data/PackageResource;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIKernelManager implements IAIKernelManager {
    public static final AIKernelManager INSTANCE = null;
    private static final AIKernelApi instance = null;

    static {
        INSTANCE = new AIKernelManager();
        instance = new AIKernelApi();
    }

    private AIKernelManager() {
    }

    public static /* synthetic */ void init$default(AIKernelManager r1, AIKernelConfig r2, ILog r3, int r4, Object r5) {
        ILog r6 = (ILog) ZeusTransformUtils.wrapperContextForParams(r3, ILog.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.init(r2, r6);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r2, Continuation<? super Unit> r3) {
        Continuation<? super Unit> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Object r4 = instance.clearAIKernelData(r2, r1);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final AIKernelApi getInstance$sdk_release() {
        return instance;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE, reason: not valid java name */
    public Object mo188getPackage0E7RQCE(String r5, RequestParams r6, Continuation<? super Result<PackageResource>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AIKernelManager$getPackage$1.class) == false) goto L7;
        AIKernelManager$getPackage$1 r0 = (AIKernelManager$getPackage$1) ZeusTransformUtils.preCheckCast(r8, AIKernelManager$getPackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r4);
        return ((Result) ZeusTransformUtils.preCheckCast(r4, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        AIKernelApi r10 = instance;
        r0.label = 1;
        Object r11 = r10.mo188getPackage0E7RQCE(r5, r6, r0);
        if (r11 != r9) goto L18;
        return r9;
    L18:
        return r11;
    L7:
        r0 = new AIKernelManager$getPackage$1(this, r8);
        goto L8
    }

    public final void init(AIKernelConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        AIKernelApi.init$default(instance, r3, null, 2, null);
    }

    public final void init(AIKernelConfig r2, ILog r3) {
        ILog r1 = (ILog) ZeusTransformUtils.wrapperContextForParams(r3, ILog.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "config");
        instance.init(r2, r1);
    }

    public final IAIKernelManager invoke() {
        return (IAIKernelManager) ZeusTransformUtils.preCheckCast(this, IAIKernelManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r2, boolean r3, RequestParams r4, Continuation<? super IBaseModel> r5) {
        Continuation<? super IBaseModel> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return instance.loadPackage(r2, r3, r4, r1);
    }

    public final void registerLog(ILog r2) {
        ILog r1 = (ILog) ZeusTransformUtils.wrapperContextForParams(r2, ILog.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "inst");
        AIKLog.INSTANCE.registerLog(r1);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE, reason: not valid java name */
    public Object mo189updatePackage0E7RQCE(PackageResource r5, RequestParams r6, Continuation<? super Result<PackageResource>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AIKernelManager$updatePackage$1.class) == false) goto L7;
        AIKernelManager$updatePackage$1 r0 = (AIKernelManager$updatePackage$1) ZeusTransformUtils.preCheckCast(r8, AIKernelManager$updatePackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r4);
        return ((Result) ZeusTransformUtils.preCheckCast(r4, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        AIKernelApi r10 = instance;
        r0.label = 1;
        Object r11 = r10.mo189updatePackage0E7RQCE(r5, r6, r0);
        if (r11 != r9) goto L18;
        return r9;
    L18:
        return r11;
    L7:
        r0 = new AIKernelManager$updatePackage$1(this, r8);
        goto L8
    }
}
