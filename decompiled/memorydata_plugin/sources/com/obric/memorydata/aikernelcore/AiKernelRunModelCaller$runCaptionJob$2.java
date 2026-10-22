package com.obric.memorydata.aikernelcore;

import android.net.Uri;
import com.bytedance.crash.Ensure;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$runCaptionJob$2", f = "AiKernelRunModelCaller.kt", i = {}, l = {471}, m = "invokeSuspend", n = {}, s = {})
final class AiKernelRunModelCaller$runCaptionJob$2 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ Uri $img;
    final /* synthetic */ String $packageName;
    final /* synthetic */ boolean $throwThermalStatusError;
    int label;

    AiKernelRunModelCaller$runCaptionJob$2(String r3, Uri r4, String r5, boolean r6, Continuation<? super AiKernelRunModelCaller$runCaptionJob$2> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$packageName = r3;
        this.$img = r4;
        this.$foregroundCallerPkg = r5;
        this.$throwThermalStatusError = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runCaptionJob$2(this.$packageName, this.$img, this.$foregroundCallerPkg, this.$throwThermalStatusError, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super String> r4) {
        return ((AiKernelRunModelCaller$runCaptionJob$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$runCaptionJob$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L15:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L21;
        return null;
    L21:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L11;
    L19:
        Ensure.ensureNotReachHere("runCaptionJob called when AIKernel not available or not support VLM");
        throw new RuntimeException("runCaptionJob called when AIKernel not available or not support VLM");
    L11:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L19;
        a r4 = a.INSTANCE;
        String r5 = this.$packageName;
        Uri r6 = this.$img;
        String r8 = this.$foregroundCallerPkg;
        boolean r9 = this.$throwThermalStatusError;
        Continuation<? super String> r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r12 = r4.a(r5, r6, "caption", r8, r9, r10);
        if (r12 != r0) goto L15;
        return r0;
    }
}
