package com.obric.aikernel.phx.sdk;

import androidx.annotation.Keep;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class AIKernelManager implements IAIKernelManager {
    public static final AIKernelManager INSTANCE = null;
    private static final AIKernelApi instance = null;

    static {
        INSTANCE = new AIKernelManager();
        instance = new AIKernelApi();
    }

    private AIKernelManager() {
    }

    public static /* synthetic */ void init$default(AIKernelManager r10, AIKernelConfig r11, ILog r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.init(r11, r12);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r10, Continuation<? super Unit> r11) {
        Object r12 = instance.clearAIKernelData(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public final AIKernelApi getInstance$sdk_release() {
        return instance;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE, reason: not valid java name */
    public Object mo23getPackage0E7RQCE(String r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        if ((r12 instanceof AIKernelManager$getPackage$1) == false) goto L7;
        AIKernelManager$getPackage$1 r13 = (AIKernelManager$getPackage$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        return ((Result) r15).m41unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        AIKernelApi r18 = instance;
        r13.label = 1;
        Object r19 = r18.mo23getPackage0E7RQCE(r10, r11, r13);
        if (r19 != r16) goto L18;
        return r16;
    L18:
        return r19;
    L7:
        r13 = new AIKernelManager$getPackage$1(this, r12);
        goto L8
    }

    public final void init(AIKernelConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        AIKernelApi.q(instance, r10, null, 2, null);
    }

    public final void init(AIKernelConfig r10, ILog r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        instance.p(r10, r11);
    }

    public final IAIKernelManager invoke() {
        return this;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r10, boolean r11, RequestParams r12, Continuation<? super IBaseModel> r13) {
        return instance.loadPackage(r10, r11, r12, r13);
    }

    public final void registerLog(ILog r10) {
        Intrinsics.checkNotNullParameter(r10, "inst");
        AIKLog.INSTANCE.registerLog(r10);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE, reason: not valid java name */
    public Object mo24updatePackage0E7RQCE(PackageResource r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        if ((r12 instanceof AIKernelManager$updatePackage$1) == false) goto L7;
        AIKernelManager$updatePackage$1 r13 = (AIKernelManager$updatePackage$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        return ((Result) r15).m41unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        AIKernelApi r18 = instance;
        r13.label = 1;
        Object r19 = r18.mo24updatePackage0E7RQCE(r10, r11, r13);
        if (r19 != r16) goto L18;
        return r16;
    L18:
        return r19;
    L7:
        r13 = new AIKernelManager$updatePackage$1(this, r12);
        goto L8
    }
}
