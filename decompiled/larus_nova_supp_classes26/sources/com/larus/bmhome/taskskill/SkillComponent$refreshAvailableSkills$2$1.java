package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.bmhome.taskskill.network.q;
import com.larus.platform.service.AccountService;
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
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$refreshAvailableSkills$2$1", f = "SkillComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$refreshAvailableSkills$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ long $generation;
    final /* synthetic */ boolean $hasPendingDraftSkills;
    final /* synthetic */ String $requestOwnerUserId;
    final /* synthetic */ q $requestParam;
    final /* synthetic */ List<TaskSkill> $skills;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$refreshAvailableSkills$2$1(String r1, SkillComponent r2, q r3, boolean r4, List<TaskSkill> r5, String r6, long r7, Continuation<? super SkillComponent$refreshAvailableSkills$2$1> r9) {
        this.$requestOwnerUserId = r1;
        this.this$0 = r2;
        this.$requestParam = r3;
        this.$hasPendingDraftSkills = r4;
        this.$skills = r5;
        this.$conversationId = r6;
        this.$generation = r7;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new SkillComponent$refreshAvailableSkills$2$1(this.$requestOwnerUserId, this.this$0, this.$requestParam, this.$hasPendingDraftSkills, this.$skills, this.$conversationId, this.$generation, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r8);
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), this.$requestOwnerUserId) == false) goto L13;
        SkillComponent r9 = this.this$0;
        Regex r0 = SkillComponent.F2;
        if (Intrinsics.areEqual(r9.a4(), this.$requestParam) == false) goto L13;
        if (this.$hasPendingDraftSkills == false) goto L11;
        SkillComponent r10 = this.this$0;
        r10.P0 = this.$requestOwnerUserId;
        r10.V0 = this.$requestParam;
        r10.b1 = this.$skills;
    L11:
        this.this$0.s5(this.$conversationId, this.$generation, this.$skills, true);
    L13:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
