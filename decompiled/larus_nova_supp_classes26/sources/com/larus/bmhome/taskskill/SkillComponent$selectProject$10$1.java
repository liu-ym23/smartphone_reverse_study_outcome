package com.larus.bmhome.taskskill;

import com.larus.platform.service.AccountService;
import com.larus.project.TaskProjectRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$selectProject$10$1", f = "SkillComponent.kt", i = {}, l = {2022}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$selectProject$10$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ long $restoreGeneration;
    final /* synthetic */ String $restoreOwnerUserId;
    final /* synthetic */ String $restoredProjectId;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$selectProject$10$1(String r1, String r2, SkillComponent r3, long r4, String r6, Continuation<? super SkillComponent$selectProject$10$1> r7) {
        this.$restoredProjectId = r1;
        this.$restoreOwnerUserId = r2;
        this.this$0 = r3;
        this.$restoreGeneration = r4;
        this.$conversationId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new SkillComponent$selectProject$10$1(this.$restoredProjectId, this.$restoreOwnerUserId, this.this$0, this.$restoreGeneration, this.$conversationId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L11:
        String r2 = this.$restoreOwnerUserId;
        SkillComponent r3 = this.this$0;
        long r4 = this.$restoreGeneration;
        String r5 = this.$conversationId;
        String r6 = this.$restoredProjectId;
        if (Result.isSuccess-impl(r11) == false) goto L27;
        com.larus.project.i r12 = (com.larus.project.i) r11;
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), r2) == false) goto L27;
        if (r3.L0 != r4) goto L27;
        if (r3.yW() == false) goto L27;
        if (Intrinsics.areEqual(r3.Z3(), r5) == false) goto L27;
        if (Intrinsics.areEqual(r3.G1, r6) == false) goto L27;
        if (r12 != null) goto L27;
        r3.G1 = null;
        r3.H1 = null;
        r3.U5("");
        r3.L1 = false;
        r3.KY();
        r3.T4(true);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        TaskProjectRepository r13 = TaskProjectRepository.a;
        String r7 = this.$restoredProjectId;
        this.label = 1;
        r11 = r13.a(r7, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
