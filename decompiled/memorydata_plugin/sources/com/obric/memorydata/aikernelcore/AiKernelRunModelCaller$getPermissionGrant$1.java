package com.obric.memorydata.aikernelcore;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$getPermissionGrant$1", f = "AiKernelRunModelCaller.kt", i = {}, l = {848}, m = "invokeSuspend", n = {}, s = {})
final class AiKernelRunModelCaller$getPermissionGrant$1 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $packageName;
    final /* synthetic */ RequestParams $requestParams;
    final /* synthetic */ Uri $uri;
    int label;

    AiKernelRunModelCaller$getPermissionGrant$1(String r3, Uri r4, RequestParams r5, Continuation<? super AiKernelRunModelCaller$getPermissionGrant$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$packageName = r3;
        this.$uri = r4;
        this.$requestParams = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$getPermissionGrant$1(this.$packageName, this.$uri, this.$requestParams, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
        return ((AiKernelRunModelCaller$getPermissionGrant$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$getPermissionGrant$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L7
    L15:
        UriFileAccessSession r12 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r11, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        if (r12.getFd() != null) goto L18;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "openFileDescriptorPrivileged failed " + r12, null, 4, null);     // Catch: Exception -> L7
    L18:
        RequestParams r2 = this.$requestParams;     // Catch: Exception -> L7
        String r10 = this.$uri.toString();     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");     // Catch: Exception -> L7
        AssetFileDescriptor r13 = r12.getFd();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L7
        ParamsKt.setAssetFd(r2, r10, r13);     // Catch: Exception -> L7
        return Boxing.boxBoolean(true);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "getPermissionGrant packageName: " + this.$packageName + ", uri: " + this.$uri, false, 4, null);     // Catch: Exception -> L7
        AtomicCapabilitySdk r14 = AtomicCapabilitySdk.INSTANCE;     // Catch: Exception -> L7
        String r3 = this.$packageName;     // Catch: Exception -> L7
        Uri r4 = this.$uri;     // Catch: Exception -> L7
        Continuation<? super UriFileAccessSession> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        r11 = r14.openFileDescriptorPrivileged(r3, r4, r5);     // Catch: Exception -> L7
        if (r11 != r0) goto L15;
        return r0;
    L7:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "getPermissionGrant error " + e.getMessage(), null, 4, null);
        return Boxing.boxBoolean(false);
    }
}
