package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.network.TaskSkillRepository;
import com.larus.bmhome.taskskill.network.q;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$prefetchIfInTaskMode$1", f = "SkillComponent.kt", i = {}, l = {2713, 2719}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$prefetchIfInTaskMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $canUseRecentCache;
    final /* synthetic */ long $pendingGeneration;
    final /* synthetic */ String $requestOwnerUserId;
    final /* synthetic */ q $requestParam;
    Object L$0;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$prefetchIfInTaskMode$1(q r1, boolean r2, SkillComponent r3, long r4, String r6, Continuation<? super SkillComponent$prefetchIfInTaskMode$1> r7) {
        this.$requestParam = r1;
        this.$canUseRecentCache = r2;
        this.this$0 = r3;
        this.$pendingGeneration = r4;
        this.$requestOwnerUserId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new SkillComponent$prefetchIfInTaskMode$1(this.$requestParam, this.$canUseRecentCache, this.this$0, this.$pendingGeneration, this.$requestOwnerUserId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        Object r15 = ((Result) r14).unbox-impl();
    L13:
        FLogger.a.d("SkillComponent", "[prefetchIfInTaskMode] result = " + Result.toString-impl(r15));
        SkillComponent r6 = this.this$0;
        q r8 = this.$requestParam;
        long r10 = this.$pendingGeneration;
        String r7 = this.$requestOwnerUserId;
        if (Result.isSuccess-impl(r15) == false) goto L22;
        List r9 = (List) r15;
        this.L$0 = r15;
        this.label = 2;
        Regex r16 = SkillComponent.F2;
        r6.getClass();
        Object r17 = BuildersKt.withContext(Dispatchers.getMain(), new SkillComponent$reconcileActionBarSkillsIfShowing$2(r6, r7, r8, r9, r10, null), this);
        if (r17 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        r17 = Unit.INSTANCE;
    L19:
        if (r17 != r0) goto L22;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        TaskSkillRepository r18 = TaskSkillRepository.a;
        q r2 = this.$requestParam;
        boolean r4 = this.$canUseRecentCache;
        this.label = 1;
        r15 = r18.i(r2, r4, this);
        if (r15 != r0) goto L13;
        return r0;
    }
}
