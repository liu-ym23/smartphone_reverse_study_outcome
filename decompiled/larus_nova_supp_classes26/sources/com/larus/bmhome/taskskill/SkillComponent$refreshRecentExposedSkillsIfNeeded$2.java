package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.network.TaskSkillRepository;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$refreshRecentExposedSkillsIfNeeded$2", f = "SkillComponent.kt", i = {2}, l = {2768, 2770, 2821}, m = "invokeSuspend", n = {"it"}, s = {"L$2"})
public final class SkillComponent$refreshRecentExposedSkillsIfNeeded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ i $load;
    final /* synthetic */ String $requestOwnerUserId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$refreshRecentExposedSkillsIfNeeded$2(String r1, SkillComponent r2, i r3, String r4, Continuation<? super SkillComponent$refreshRecentExposedSkillsIfNeeded$2> r5) {
        this.$conversationId = r1;
        this.this$0 = r2;
        this.$load = r3;
        this.$requestOwnerUserId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SkillComponent$refreshRecentExposedSkillsIfNeeded$2(this.$conversationId, this.this$0, this.$load, this.$requestOwnerUserId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        Throwable r2 = (Throwable) this.L$2;
        String r3 = (String) this.L$1;
        ResultKt.throwOnFailure(r12);
    L26:
        FLogger.a.w("SkillComponent", "[refreshRecentExposedSkillsIfNeeded] failed, conversationId=" + r3 + ", msg=" + r2.getMessage());
    L28:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Object r4 = this.L$0;
        ResultKt.throwOnFailure(r12);
    L20:
        String r13 = this.$conversationId;
        SkillComponent r5 = this.this$0;
        i r6 = this.$load;
        Throwable r7 = Result.exceptionOrNull-impl(r4);
        if (r7 == null) goto L28;
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        SkillComponent$refreshRecentExposedSkillsIfNeeded$2$2$1 r9 = new SkillComponent$refreshRecentExposedSkillsIfNeeded$2$2$1(r5, r6, null);
        this.L$0 = r4;
        this.L$1 = r13;
        this.L$2 = r7;
        this.label = 3;
        if (BuildersKt.withContext(r8, r9, this) != r0) goto L25;
        return r0;
    L25:
        r3 = r13;
        r2 = r7;
        goto L26
    L11:
        ResultKt.throwOnFailure(r12);
        Object r14 = ((Result) r12).unbox-impl();
    L15:
        r4 = r14;
        SkillComponent r10 = this.this$0;
        i r11 = this.$load;
        String r15 = this.$requestOwnerUserId;
        if (Result.isSuccess-impl(r4) == false) goto L20;
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        SkillComponent$refreshRecentExposedSkillsIfNeeded$2$1$1 r17 = new SkillComponent$refreshRecentExposedSkillsIfNeeded$2$1$1(r10, r11, r15, (bs8.j) r4, null);
        this.L$0 = r4;
        this.label = 2;
        if (BuildersKt.withContext(r16, r17, this) != r0) goto L20;
        return r0;
    L12:
        ResultKt.throwOnFailure(r12);
        TaskSkillRepository r18 = TaskSkillRepository.a;
        String r19 = this.$conversationId;
        this.label = 1;
        r14 = r18.e(r19, this);
        if (r14 != r0) goto L15;
        return r0;
    }
}
