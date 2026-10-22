package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageStorage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/objects/AIPackage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$queryOrActiveAIPackage$2", f = "AIManager.kt", i = {}, l = {1218}, m = "invokeSuspend", n = {}, s = {})
final class AIManager$queryOrActiveAIPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AIPackage>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ String $packageName;
    final /* synthetic */ AIPackage.AIPackageType $type;
    int label;

    public AIManager$queryOrActiveAIPackage$2(String r1, String r10, AIPackage.AIPackageType r11, Continuation<? super AIManager$queryOrActiveAIPackage$2> r12) {
        this.$packageName = r1;
        this.$appId = r10;
        this.$type = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIManager$queryOrActiveAIPackage$2(this.$packageName, this.$appId, this.$type, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AIPackage> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        AIPackage r12 = (AIPackage) r11;
        if (r12 == null) goto L14;
        AIManager r10 = AIManager.a;
        AIManager.e(r12, false);
    L14:
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        AIManager r13 = AIManager.a;
        long r14 = AIManager.l(this.$packageName).i;
        AIPackageManager r15 = AIPackageManager.a;
        AIPackageManager.a r16 = new AIPackageManager.a(this.$appId, this.$packageName);
        AIPackage.AIPackageType r17 = this.$type;
        this.label = 1;
        r15.getClass();
        r11 = AIPackageStorage.a.k(r16, r17, true, r14, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
