package com.obric.aikernel.runtime;

import android.net.Uri;
import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aee/res/PackageInfo;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$addLoraPackageInfo$1$wrapper$1", f = "AIInferRuntime.kt", i = {1, 1}, l = {1532, 1541}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u241", "loraModel"}, s = {"L$8", "L$10"})
final class AIInferRuntime$addLoraPackageInfo$1$wrapper$1 extends SuspendLambda implements Function1<Continuation<? super com.obric.aee.res.b>, Object> {
    final /* synthetic */ com.obric.aikernel.res.metadata.data.f $lora;
    final /* synthetic */ com.obric.aikernel.res.metadata.data.b $pkg;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$addLoraPackageInfo$1$wrapper$1(AIInferRuntime r3, com.obric.aikernel.res.metadata.data.b r4, com.obric.aikernel.res.metadata.data.f r5, Continuation<? super AIInferRuntime$addLoraPackageInfo$1$wrapper$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$pkg = r4;
        this.$lora = r5;
        super(1, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$addLoraPackageInfo$1$wrapper$1(this.this$0, this.$pkg, this.$lora, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super com.obric.aee.res.b> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super com.obric.aee.res.b> r3) {
        return ((AIInferRuntime$addLoraPackageInfo$1$wrapper$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$addLoraPackageInfo$1$wrapper$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0198 -> B:25:0x019d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        AIInferRuntime$addLoraPackageInfo$1$wrapper$1 r0 = this;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        com.obric.aikernel.res.metadata.data.a r3 = (com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r0.L$10, com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin");
        Iterator r6 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$9, Iterator.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r0.L$8, List.class, "com.obric.memorydata.plugin");
        AIInferRuntime r8 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r0.L$7, AIInferRuntime.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(r0.L$6, List.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r0.L$5, String.class, "com.obric.memorydata.plugin");
        List<com.obric.aee.res.a> r11 = (List) ZeusTransformUtils.preCheckCast(r0.L$4, List.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r0.L$3, String.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$2, String.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        String r5 = r4;
        List r15 = r9;
        String r16 = r13;
        String r17 = r10;
        String r19 = r12;
        AIInferRuntime r110 = r8;
        String r20 = r14;
    L25:
        com.obric.aikernel.res.metadata.data.d.b((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin"), false, 1, null);
        List r21 = r7;
        String r22 = r5;
        r0 = r0;
    L15:
        if (r6.hasNext() == false) goto L27;
        com.obric.aikernel.res.metadata.data.a r111 = (com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin");
        String r23 = r111.s();
        Object r112 = r1;
        String r24 = r111.t();
        Uri r113 = r111.i();
        if (r113 == null) goto L20;
        String r114 = r113.getPath();
        if (r114 == null) goto L20;
    L21:
        Iterator r115 = r6;
        String r25 = r114;
        List r116 = r15;
        r21.add(new com.obric.aee.res.c(r23, r24, r25, r111.l()));
        PackageResourceManager.PresmConfig.a r26 = r110.a().g().getDecryptFeature();
        Collection<String> r27 = (Collection) ZeusTransformUtils.preCheckCast(SetsKt.setOf(r111.s() + '@' + r111.t()), Collection.class, "com.obric.memorydata.plugin");
        r0.L$0 = r22;
        r0.L$1 = r20;
        r0.L$2 = r16;
        r0.L$3 = r19;
        r0.L$4 = r11;
        r0.L$5 = r17;
        r0.L$6 = r116;
        r0.L$7 = r110;
        r0.L$8 = r21;
        r6 = r115;
        r0.L$9 = r6;
        r0.L$10 = r111;
        r0.label = 2;
        if (r26.a(r27, r0) != r112) goto L24;
        return r112;
    L24:
        r1 = r112;
        r15 = r116;
        r5 = r22;
        r7 = r21;
        r3 = r111;
    L20:
        r114 = "";
        goto L21
    L27:
        return new com.obric.aee.res.b(r22, r20, r16, r19, r11, r15, r17);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        Object r28 = r18;
    L13:
        com.obric.aee.res.b r29 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r28, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        String r30 = r29.a();
        String r31 = r29.b();
        String r32 = r29.c();
        String r33 = r29.d();
        List<com.obric.aee.res.a> r34 = r29.e();
        String r117 = r29.f();
        r21 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r29.getResources(), Collection.class, "com.obric.memorydata.plugin"));
        com.obric.aikernel.res.metadata.data.f r118 = r0.$lora;
        r110 = r0.this$0;
        r17 = r117;
        r19 = r33;
        r20 = r31;
        r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r118.q(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r11 = r34;
        r16 = r32;
        r22 = r30;
        r15 = r21;
        goto L15
    L10:
        ResultKt.throwOnFailure(r18);
        AIInferRuntime r35 = r0.this$0;
        com.obric.aikernel.res.metadata.data.b r36 = r0.$pkg;
        Continuation r37 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r28 = AIInferRuntime.a(r35, r36, r37);
        if (r28 != r1) goto L13;
        return r1;
    }
}
