package com.obric.aikernel.runtime;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$getSubProcProxy$result$1$1$2", f = "AIInferRuntime.kt", i = {}, l = {690}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$getSubProcProxy$result$1$1$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $proc;
    final /* synthetic */ Map<String, com.obric.aikernel.runtime.subproc.b.c> $proxyMap;
    final /* synthetic */ IBinder $remote;
    final /* synthetic */ Bundle $subProcInfo;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/aikernel/runtime/AIInferRuntime$getSubProcProxy$result$1$1$2$deathRecipient$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, com.obric.aikernel.runtime.subproc.b.c> f6177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6178b;

        a(Map<String, com.obric.aikernel.runtime.subproc.b.c> r3, String r4) {
            this.f6177a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            this.f6178b = r4;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f6177a.remove(this.f6178b);
        }
    }

    AIInferRuntime$getSubProcProxy$result$1$1$2(AIInferRuntime r3, String r4, Bundle r5, IBinder r6, Map<String, com.obric.aikernel.runtime.subproc.b.c> r7, Continuation<? super AIInferRuntime$getSubProcProxy$result$1$1$2> r8) {
        IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.memorydata.plugin");
        Map<String, com.obric.aikernel.runtime.subproc.b.c> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$proc = r4;
        this.$subProcInfo = r5;
        this.$remote = r9;
        this.$proxyMap = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$getSubProcProxy$result$1$1$2(this.this$0, this.$proc, this.$subProcInfo, this.$remote, this.$proxyMap, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AIInferRuntime$getSubProcProxy$result$1$1$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$getSubProcProxy$result$1$1$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        if (Intrinsics.areEqual(this.$proc, this.this$0.a().m().a()) == false) goto L31;
        String r10 = this.$subProcInfo.getString("@vlm_local_ver");
        if (r10 == null) goto L31;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L19;
        r3 = false;
    L19:
        String r4 = null;
        if (r3 == false) goto L25;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "getSubProcProxy vlm_local reset null and refresh!");
        com.obric.aikernel.res.metadata.c.f6058a.a(null);
        PackageResourceManager r11 = AIInferRuntime.b(this.this$0);
        if (r11 == null) goto L24;
        r11.refreshPackageState("vlm_local");
    L24:
        AIInferRuntime.d(this.this$0).clear();
        goto L31
    L25:
        com.obric.aikernel.res.metadata.data.b r5 = com.obric.aikernel.res.metadata.c.f6058a.b();
        if (r5 == null) goto L29;
        r4 = r5.t();
    L29:
        if (Intrinsics.areEqual(r4, r10) == true) goto L31;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "getSubProcProxy vlm_local sync transferPackage " + r4 + " to " + r10);
        com.obric.aikernel.res.metadata.data.b r6 = new com.obric.aikernel.res.metadata.data.b("vlm_local", r10, this.this$0.a().g());
        com.obric.aikernel.res.metadata.c.f6058a.a(r6);
        AIInferRuntime.a(this.this$0, r6);
    L31:
        this.$remote.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new a(this.$proxyMap, this.$proc), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        AIInferRuntime r12 = this.this$0;
        String r2 = this.$proc;
        Bundle r7 = this.$subProcInfo;
        Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (AIInferRuntime.a(r12, r2, r7, r8) != r0) goto L12;
        return r0;
    }
}
