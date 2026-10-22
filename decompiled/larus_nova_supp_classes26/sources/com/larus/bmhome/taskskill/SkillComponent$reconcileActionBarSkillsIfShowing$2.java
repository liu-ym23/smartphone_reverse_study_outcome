package com.larus.bmhome.taskskill;

import bs8.o;
import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.bmhome.taskskill.network.q;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$reconcileActionBarSkillsIfShowing$2", f = "SkillComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SkillComponent$reconcileActionBarSkillsIfShowing$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $pendingGeneration;
    final /* synthetic */ String $requestOwnerUserId;
    final /* synthetic */ q $requestParam;
    final /* synthetic */ List<TaskSkill> $skills;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$reconcileActionBarSkillsIfShowing$2(SkillComponent r1, String r2, q r3, List<TaskSkill> r4, long r5, Continuation<? super SkillComponent$reconcileActionBarSkillsIfShowing$2> r7) {
        this.this$0 = r1;
        this.$requestOwnerUserId = r2;
        this.$requestParam = r3;
        this.$skills = r4;
        this.$pendingGeneration = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new SkillComponent$reconcileActionBarSkillsIfShowing$2(this.this$0, this.$requestOwnerUserId, this.$requestParam, this.$skills, this.$pendingGeneration, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L59;
        ResultKt.throwOnFailure(r15);
        if (this.this$0.sY() == false) goto L57;
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), this.$requestOwnerUserId) == false) goto L57;
        if (Intrinsics.areEqual(this.this$0.a4(), this.$requestParam) == false) goto L57;
        SkillComponent r16 = this.this$0;
        r16.P0 = this.$requestOwnerUserId;
        r16.V0 = this.$requestParam;
        r16.b1 = this.$skills;
        String r2 = r16.Z3();
        SkillComponent r17 = this.this$0;
        if (r17.k0 != null) goto L14;
    L17:
        ConcurrentHashMap r18 = j2.a;
        o r19 = j2.l(r2);
        List<TaskSkill> r0 = this.$skills;
        Intrinsics.checkNotNullParameter(r0, "availableSkills");
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter("task_mode", "modeKey");
        j2$a r1 = new j2$a(r2, "task_mode");
        ArrayList r4 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L19:
        if (r3.hasNext() == false) goto L23;
        String r5 = ((TaskSkill) r3.next()).getName();
        if (r5 == null) goto L19;
        r4.add(r5);
        goto L19
    L23:
        Set r6 = CollectionsKt.toSet(r4);
        Set r7 = (Set) j2.b.get(r1);
        if (r7 != null) goto L26;
        r7 = SetsKt.emptySet();
    L26:
        Set r8 = SetsKt.plus(r6, r7);
        Set r9 = (Set) j2.c.get(r1);
        if (r9 != null) goto L29;
        r9 = SetsKt.emptySet();
    L29:
        Set r10 = SetsKt.plus(r8, r9);
        o r11 = (o) j2.a.get(r1);
        if (r11 != null) goto L32;
        r11 = new o(false, 63);
    L32:
        o r12 = r11;
        List<TaskSkill> r13 = r12.a;
        ArrayList r14 = new ArrayList();
        Iterator<T> r20 = r13.iterator();
    L34:
        if (r20.hasNext() == false) goto L38;
        Object r21 = r20.next();
        if (CollectionsKt.contains(r10, ((TaskSkill) r21).getName()) == false) goto L34;
        r14.add(r21);
        goto L34
    L38:
        List<TaskSkill> r22 = r12.b;
        ArrayList r23 = new ArrayList();
        Iterator<T> r24 = r22.iterator();
    L40:
        if (r24.hasNext() == false) goto L44;
        Object r25 = r24.next();
        if (CollectionsKt.contains(r10, ((TaskSkill) r25).getName()) == false) goto L40;
        r23.add(r25);
        goto L40
    L44:
        List r26 = j2.q(r12);
        ArrayList r110 = new ArrayList();
        Iterator r27 = r26.iterator();
    L46:
        if (r27.hasNext() == false) goto L50;
        Object r28 = r27.next();
        if (CollectionsKt.contains(r10, ((TaskSkill) r28).getName()) == false) goto L46;
        r110.add(r28);
        goto L46
    L50:
        o r29 = o.a(r12, r14, r23, r110, false, null, 56);
        j2.a.put(r1, r29);
        FLogger r30 = FLogger.a;
        r30.d("TaskSkillStateStore", "[reconcile] conversationId=" + r2 + ", modeKey=task_mode, availableCount=" + r0.size() + ", selectedCount=" + r29.a.size() + ", visibleCount=" + r29.c.size());
        if (Intrinsics.areEqual(r19.c, r29.c) == false) goto L54;
        r30.d("SkillComponent", "[reconcileActionBarSkillsIfShowing] action bar skills not changed");
        return Unit.INSTANCE;
    L54:
        this.this$0.KY();
        this.this$0.T4(true);
        return Unit.INSTANCE;
    L14:
        if (Intrinsics.areEqual(r17.p0, r2) == false) goto L17;
        this.this$0.s5(r2, this.$pendingGeneration, this.$skills, true);
        return Unit.INSTANCE;
    L57:
        return Unit.INSTANCE;
    L59:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
