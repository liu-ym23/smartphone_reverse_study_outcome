package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.bmhome.taskskill.network.TaskSkillRepository;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$reportRecentExposedSkills$1", f = "SkillComponent.kt", i = {}, l = {3789}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$reportRecentExposedSkills$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ List<TaskSkill> $exposedSkills;
    final /* synthetic */ int $maxCount;
    int label;

    public SkillComponent$reportRecentExposedSkills$1(wc9.e r1, List<TaskSkill> r2, int r3, Continuation<? super SkillComponent$reportRecentExposedSkills$1> r4) {
        this.$conversation = r1;
        this.$exposedSkills = r2;
        this.$maxCount = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SkillComponent$reportRecentExposedSkills$1(this.$conversation, this.$exposedSkills, this.$maxCount, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L11:
        wc9.e r2 = this.$conversation;
        if (Result.isSuccess-impl(r8) == false) goto L14;
        Unit r3 = (Unit) r8;
        ConcurrentHashMap r4 = j2.a;
        j2.j(r2.a);
    L14:
        wc9.e r5 = this.$conversation;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L18;
        FLogger.a.w("SkillComponent", "[reportRecentExposedSkills] failed, conversationId=" + r5.a + ", msg=" + r9.getMessage());
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        TaskSkillRepository r10 = TaskSkillRepository.a;
        String r6 = this.$conversation.a;
        List<TaskSkill> r11 = CollectionsKt.take(this.$exposedSkills, RangesKt.coerceAtLeast(this.$maxCount, 0));
        this.label = 1;
        r8 = r10.p(r6, r11, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
