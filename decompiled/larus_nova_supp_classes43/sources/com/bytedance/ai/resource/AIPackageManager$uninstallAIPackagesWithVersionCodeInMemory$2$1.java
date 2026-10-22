package com.bytedance.ai.resource;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1", f = "AIPackageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<Boolean> $continuation;
    final /* synthetic */ List<String> $fileListToDelete;
    final /* synthetic */ Ref.BooleanRef $uninstallResult;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1(List<String> r1, kotlinx.coroutines.i<? super Boolean> r10, Ref.BooleanRef r11, Continuation<? super AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1> r12) {
        this.$fileListToDelete = r1;
        this.$continuation = r10;
        this.$uninstallResult = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1(this.$fileListToDelete, this.$continuation, this.$uninstallResult, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r10);
        List<String> r11 = this.$fileListToDelete;
        Ref.BooleanRef r0 = this.$uninstallResult;
        Iterator<T> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        String r1 = (String) r12.next();
        boolean r13 = com.bytedance.ai.utils.f.delete(r1);
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "remove file----->" + r1 + " is removed: " + r13);
        if (r13 == true) goto L6;
        r0.element = r13;
        goto L6
    L11:
        if (this.$continuation.isCompleted() == true) goto L14;
        kotlinx.coroutines.i<Boolean> r14 = this.$continuation;
        Result.Companion r15 = Result.Companion;
        r14.resumeWith(Result.constructor-impl(Boxing.boxBoolean(this.$uninstallResult.element)));
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
