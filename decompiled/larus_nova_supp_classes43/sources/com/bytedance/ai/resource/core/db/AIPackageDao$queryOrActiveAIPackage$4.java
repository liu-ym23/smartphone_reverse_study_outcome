package com.bytedance.ai.resource.core.db;

import com.byted.cast.sink.api.CastInfo;
import com.bytedance.ai.model.objects.AIPackage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao$queryOrActiveAIPackage$4", f = "AIPackageDao.kt", i = {}, l = {97, CastInfo.TYPE_CAST_SUCCESS}, m = "invokeSuspend", n = {}, s = {})
public final class AIPackageDao$queryOrActiveAIPackage$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIPackage $finalPkg;
    final /* synthetic */ List<AIPackage> $inactivePkg;
    final /* synthetic */ AIPackage $installPkg;
    Object L$0;
    int label;
    final /* synthetic */ AIPackageDao this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageDao$queryOrActiveAIPackage$4(AIPackage r1, AIPackage r10, List<? extends AIPackage> r11, AIPackageDao r12, Continuation<? super AIPackageDao$queryOrActiveAIPackage$4> r13) {
        this.$installPkg = r1;
        this.$finalPkg = r10;
        this.$inactivePkg = r11;
        this.this$0 = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageDao$queryOrActiveAIPackage$4(this.$installPkg, this.$finalPkg, this.$inactivePkg, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Iterator<AIPackage> r10 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r12);
    L24:
        if (r10.hasNext() == false) goto L34;
        AIPackage r11 = r10.next();
        if (Intrinsics.areEqual(this.$finalPkg, r11) == true) goto L24;
        if (Intrinsics.areEqual(r11.n, this.$finalPkg.n) == true) goto L24;
        AIPackageDao r13 = this.this$0;
        long r14 = r11.c;
        String r15 = r11.a();
        String r16 = r11.b;
        String r17 = r11.n;
        this.L$0 = r10;
        this.label = 2;
        if (r13.a(r14, r15, r16, r17, this) != r0) goto L24;
        return r0;
    L34:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        AIPackage r18 = (AIPackage) this.L$0;
        ResultKt.throwOnFailure(r12);
    L21:
        r10 = this.$inactivePkg.iterator();
        goto L24
    L10:
        ResultKt.throwOnFailure(r12);
        AIPackage r19 = this.$installPkg;
        if (r19 == null) goto L13;
        String r110 = r19.n;
    L15:
        if (Intrinsics.areEqual(r110, this.$finalPkg.n) == true) goto L21;
        AIPackage r111 = this.$installPkg;
        if (r111 == null) goto L21;
        AIPackageDao r20 = this.this$0;
        long r21 = r111.c;
        String r22 = r111.a();
        String r23 = r111.b;
        String r24 = r111.n;
        this.L$0 = r111;
        this.label = 1;
        if (r20.a(r21, r22, r23, r24, this) != r0) goto L21;
        return r0;
    L13:
        r110 = null;
        goto L15
    }
}
