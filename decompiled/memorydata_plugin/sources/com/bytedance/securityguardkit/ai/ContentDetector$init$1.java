package com.bytedance.securityguardkit.ai;

import android.util.Log;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.securityguardkit.ai.ContentDetector$init$1", f = "ContentDetector.kt", i = {}, l = {38, 46}, m = "invokeSuspend", n = {}, s = {})
final class ContentDetector$init$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ a this$0;

    ContentDetector$init$1(a r3, Continuation<? super ContentDetector$init$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ContentDetector$init$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ContentDetector$init$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ContentDetector$init$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = false;
        Throwable r5 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
        Object r14 = ((Result) ZeusTransformUtils.preCheckCast(r15, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L37:
        if (Result.m1427isFailureimpl(r14) == false) goto L39;
        Object r16 = null;
    L40:
        PackageResource r17 = (PackageResource) ZeusTransformUtils.preCheckCast(r16, PackageResource.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L43;
    L45:
        if (r3 == false) goto L49;
        String r18 = "算法包准备好了，可以进行推理";
    L47:
        Log.i("ContentDetector", r18);
    L66:
        return Unit.INSTANCE;
    L49:
        if (Result.m1427isFailureimpl(r14) == false) goto L63;
        Throwable r19 = Result.m1424exceptionOrNullimpl(r14);
        if (ZeusTransformUtils.instanceOf(r19, AIKernelException.class) == false) goto L53;
        AIKernelException r110 = (AIKernelException) ZeusTransformUtils.preCheckCast(r19, AIKernelException.class, "com.obric.memorydata.plugin");
    L54:
        if (r110 == null) goto L56;
        Integer r111 = Boxing.boxInt(r110.getCode());
    L57:
        if (r110 == null) goto L59;
        String r2 = r110.getMessage();
    L60:
        if (r110 == null) goto L62;
        r5 = r110.getCause();
    L62:
        Log.e("ContentDetector", "更新失败：" + r111 + ", " + r2 + ", " + r5);
        goto L66
    L59:
        r2 = null;
        goto L60
    L56:
        r111 = null;
        goto L57
    L53:
        r110 = null;
        goto L54
    L63:
        r18 = "更新成功，但算法包暂不可用，可以稍后重试";
        goto L47
    L43:
        if (r17.isAvailable() != true) goto L45;
        r3 = true;
        goto L45
    L39:
        r16 = r14;
        goto L40
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
        Object r112 = ((Result) ZeusTransformUtils.preCheckCast(r15, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L14:
        if (Result.m1427isFailureimpl(r112) == false) goto L16;
        r112 = null;
    L16:
        PackageResource r113 = (PackageResource) ZeusTransformUtils.preCheckCast(r112, PackageResource.class, "com.obric.memorydata.plugin");
        if (r113 != null) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L24;
        Log.i("ContentDetector", "模型可以使用");
        a.a(this.this$0, r113);
        goto L66
    L24:
        if (r113 != null) goto L26;
    L28:
        boolean r6 = false;
    L29:
        if (r6 == true) goto L32;
        r18 = "不支持的算法包";
        goto L47
    L32:
        if (r113.isDownloaded() == true) goto L64;
        Log.i("ContentDetector", "算法包资源待下载");
        IAIKernelManager r7 = AIKernelManager.INSTANCE.invoke();
        RequestParams r8 = new RequestParams(null, (Function1) ZeusTransformUtils.preCheckCast(ContentDetector$init$1$ret$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 1, null);
        Continuation<? super Result<PackageResource>> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        r14 = r7.mo189updatePackage0E7RQCE(r113, r8, r9);
        if (r14 != r0) goto L37;
        return r0;
    L64:
        r18 = "未知状态";
        goto L47
    L26:
        if (r113.isProvisioned() != true) goto L28;
        r6 = true;
        goto L29
    L19:
        if (r113.isAvailable() != true) goto L21;
        r4 = true;
        goto L22
    L10:
        ResultKt.throwOnFailure(r15);
        IAIKernelManager r10 = AIKernelManager.INSTANCE.invoke();
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r112 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r10, "pico_content_security", null, r11, 2, null);
        if (r112 != r0) goto L14;
        return r0;
    }
}
