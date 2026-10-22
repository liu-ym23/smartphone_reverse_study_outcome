package com.obric.aikernel.runtime;

import android.net.Uri;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.data.AIModel;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.res.metadata.data.Lora;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$addLoraPackageInfo$1$wrapper$1", f = "AIInferRuntime.kt", i = {1, 1}, l = {1493, 1502}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u241", "loraModel"}, s = {"L$8", "L$10"})
final class AIInferRuntime$addLoraPackageInfo$1$wrapper$1 extends SuspendLambda implements Function1<Continuation<? super y6.b>, Object> {
    final /* synthetic */ Lora $lora;
    final /* synthetic */ AIPackage $pkg;
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

    AIInferRuntime$addLoraPackageInfo$1$wrapper$1(AIInferRuntime r10, AIPackage r11, Lora r12, Continuation<? super AIInferRuntime$addLoraPackageInfo$1$wrapper$1> r13) {
        this.this$0 = r10;
        this.$pkg = r11;
        this.$lora = r12;
        super(1, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AIInferRuntime$addLoraPackageInfo$1$wrapper$1(this.this$0, this.$pkg, this.$lora, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super y6.b> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super y6.b> r10) {
        return ((AIInferRuntime$addLoraPackageInfo$1$wrapper$1) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x012a -> B:25:0x012b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        AIModel r12 = (AIModel) this.L$10;
        Iterator r13 = (Iterator) this.L$9;
        List r14 = (List) this.L$8;
        AIInferRuntime r15 = (AIInferRuntime) this.L$7;
        List r16 = (List) this.L$6;
        String r17 = (String) this.L$5;
        List<y6.a> r18 = (List) this.L$4;
        String r19 = (String) this.L$3;
        String r110 = (String) this.L$2;
        String r111 = (String) this.L$1;
        String r112 = (String) this.L$0;
        ResultKt.throwOnFailure(r20);
        Iterator r21 = r13;
        String r113 = r17;
        String r22 = r112;
        List r114 = r16;
        List<y6.a> r115 = r18;
        String r116 = r111;
        String r117 = r19;
        String r118 = r110;
    L25:
        com.obric.aikernel.res.metadata.data.b.c(r12, false, 1, null);
        Iterator r23 = r21;
    L15:
        if (r23.hasNext() == false) goto L27;
        r12 = (AIModel) r23.next();
        String r24 = r12.w();
        String r25 = r12.D();
        Uri r119 = r12.v();
        if (r119 == null) goto L20;
        String r120 = r119.getPath();
        if (r120 == null) goto L20;
    L21:
        Object r121 = r10;
        r14.add(new y6.c(r24, r25, r120, r12.u()));
        PackageResourceManager.PresmConfig.b r26 = r15.R().h().getDecryptFeature();
        Set r27 = SetsKt.setOf(r12.w() + '@' + r12.D());
        this.L$0 = r22;
        this.L$1 = r116;
        this.L$2 = r118;
        this.L$3 = r117;
        this.L$4 = r115;
        this.L$5 = r113;
        this.L$6 = r114;
        this.L$7 = r15;
        this.L$8 = r14;
        r21 = r23;
        this.L$9 = r21;
        this.L$10 = r12;
        this.label = 2;
        if (r26.waitDecrypting(r27, this) != r121) goto L24;
        return r121;
    L24:
        r10 = r121;
    L20:
        r120 = "";
        goto L21
    L27:
        return new y6.b(r22, r116, r118, r117, r115, r114, r113);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r20);
        Object r28 = r20;
    L13:
        y6.b r29 = (y6.b) r28;
        String r30 = r29.c();
        String r31 = r29.h();
        String r32 = r29.d();
        String r33 = r29.f();
        List<y6.a> r34 = r29.b();
        String r122 = r29.a();
        List r35 = CollectionsKt.toMutableList(r29.e());
        Lora r123 = this.$lora;
        AIInferRuntime r124 = this.this$0;
        r114 = r35;
        r115 = r34;
        r113 = r122;
        r22 = r30;
        r116 = r31;
        r23 = r123.k0().iterator();
        r14 = r114;
        r118 = r32;
        r15 = r124;
        r117 = r33;
        goto L15
    L10:
        ResultKt.throwOnFailure(r20);
        AIInferRuntime r36 = this.this$0;
        AIPackage r37 = this.$pkg;
        this.label = 1;
        r28 = AIInferRuntime.d(r36, r37, this);
        if (r28 != r10) goto L13;
        return r10;
    }
}
