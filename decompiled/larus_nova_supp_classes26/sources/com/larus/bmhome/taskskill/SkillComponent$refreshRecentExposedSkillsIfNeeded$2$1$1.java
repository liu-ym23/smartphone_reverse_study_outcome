package com.larus.bmhome.taskskill;

import bs8.o;
import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashSet;
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
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$refreshRecentExposedSkillsIfNeeded$2$1$1", f = "SkillComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$refreshRecentExposedSkillsIfNeeded$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $load;
    final /* synthetic */ String $requestOwnerUserId;
    final /* synthetic */ bs8.j $result;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$refreshRecentExposedSkillsIfNeeded$2$1$1(SkillComponent r1, i r2, String r3, bs8.j r4, Continuation<? super SkillComponent$refreshRecentExposedSkillsIfNeeded$2$1$1> r5) {
        this.this$0 = r1;
        this.$load = r2;
        this.$requestOwnerUserId = r3;
        this.$result = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SkillComponent$refreshRecentExposedSkillsIfNeeded$2$1$1(this.this$0, this.$load, this.$requestOwnerUserId, this.$result, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L140;
        ResultKt.throwOnFailure(r20);
        if (this.this$0.R != this.$load) goto L138;
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), this.$requestOwnerUserId) == false) goto L138;
        if (Intrinsics.areEqual(this.this$0.Z3(), this.$load.a) == false) goto L138;
        String r3 = this.$load.a;
        SkillComponent r1 = this.this$0;
        r1.g1 = this.$requestOwnerUserId;
        r1.h1 = r3;
        r1.k1 = this.$result.a;
        Job r2 = r1.S;
        if (r2 == null) goto L14;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L14:
        this.this$0.S = null;
        ConcurrentHashMap r4 = j2.a;
        j2.p(r3);
        o r5 = j2.l(r3);
        List<TaskSkill> r6 = this.$result.a;
        i r7 = this.$load;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r6.iterator();
    L16:
        if (r9.hasNext() == false) goto L23;
        Object r10 = r9.next();
        TaskSkill r11 = (TaskSkill) r10;
        Set<String> r12 = r7.c;
        if (r12 != null) goto L21;
        r12 = SetsKt.emptySet();
    L21:
        if (CollectionsKt.contains(r12, r11.getName()) == true) goto L16;
        r8.add(r10);
        goto L16
    L23:
        int r13 = this.$result.b;
        Intrinsics.checkNotNullParameter(r8, "skills");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter("task_mode", "modeKey");
        j2$a r14 = new j2$a(r3, "task_mode");
        o r15 = j2.l(r3);
        if (r13 > 0) goto L26;
        j2.a.put(r14, o.a(r15, null, null, null, false, 0, 31));
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter("task_mode", "modeKey");
        j2.i().erase("larus_task_skill_render_cache_" + r3 + "_task_mode");
        FLogger.a.i("TaskSkillStateStore", "[eraseDiskCache] conversationId=" + r3 + ", modeKey=task_mode");
        o r18 = r5;
    L111:
        List r16 = null;
        this.$load.c = null;
        this.this$0.d5(null);
        ConcurrentHashMap r17 = j2.a;
        if (Intrinsics.areEqual(j2.l(r3), r18) == true) goto L115;
        this.this$0.T4(true);
    L115:
        SkillComponent r19 = this.this$0;
        List r21 = r19.b1;
        if (r21 == null) goto L126;
        if (Intrinsics.areEqual(r19.P0, this.$requestOwnerUserId) == true) goto L120;
    L122:
        boolean r110 = false;
    L123:
        if (r110 == false) goto L126;
        r16 = r21;
        goto L126
    L120:
        if (Intrinsics.areEqual(r19.V0, r19.a4()) == false) goto L122;
        r110 = true;
    L126:
        if (Intrinsics.areEqual(this.this$0.p0, r3) == false) goto L136;
        SkillComponent r22 = this.this$0;
        long r23 = r22.L0;
        if (r16 != null) goto L130;
        List r24 = CollectionsKt.emptyList();
    L131:
        if (r16 == null) goto L133;
        boolean r25 = true;
    L134:
        r22.s5(r3, r23, r24, r25);
        goto L136
    L133:
        r25 = false;
        goto L134
    L130:
        r24 = r16;
    L136:
        return Unit.INSTANCE;
    L26:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r8.iterator();
    L28:
        if (r27.hasNext() == false) goto L37;
        Object r28 = r27.next();
        String r111 = ((TaskSkill) r28).getName();
        if (r111 != null) goto L32;
    L34:
        boolean r112 = false;
    L35:
        if (r112 == false) goto L28;
        r26.add(r28);
        goto L28
    L32:
        if ((!StringsKt.isBlank(r111)) != true) goto L34;
        r112 = true;
        goto L35
    L37:
        HashSet r29 = new HashSet();
        ArrayList r30 = new ArrayList();
        Iterator r31 = r26.iterator();
    L39:
        if (r31.hasNext() == false) goto L43;
        Object r113 = r31.next();
        if (r29.add(((TaskSkill) r113).getName()) == false) goto L39;
        r30.add(r113);
        goto L39
    L43:
        List r32 = CollectionsKt.take(r30, RangesKt.coerceAtLeast(r13, 0));
        Set r33 = (Set) j2.c.get(r14);
        if (r33 != null) goto L46;
        r33 = SetsKt.emptySet();
    L46:
        List r34 = r32;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r34.iterator();
    L48:
        if (r115.hasNext() == false) goto L52;
        String r116 = ((TaskSkill) r115.next()).getName();
        if (r116 == null) goto L48;
        r114.add(r116);
        goto L48
    L52:
        Set r117 = CollectionsKt.toSet(r114);
        Set r118 = SetsKt.minus(r33, r117);
        Set r119 = (Set) j2.b.get(r14);
        if (r119 != null) goto L55;
        r119 = SetsKt.emptySet();
    L55:
        Set r120 = SetsKt.minus(r118, r119);
        List<TaskSkill> r121 = r15.a;
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r121.iterator();
    L57:
        if (r123.hasNext() == false) goto L62;
        String r35 = ((TaskSkill) r123.next()).getName();
        if (r35 == null) goto L57;
        r122.add(r35);
        goto L57
    L62:
        Set r36 = CollectionsKt.toSet(r122);
        j2.c.put(r14, SetsKt.plus(r117, CollectionsKt.intersect(r33, r36)));
        List r37 = (List) j2.e.remove(r14);
        if (r37 != null) goto L65;
        r37 = CollectionsKt.emptyList();
    L65:
        List r38 = r37;
        List r124 = CollectionsKt.plus(r15.a, r38);
        HashSet r125 = new HashSet();
        ArrayList r126 = new ArrayList();
        Iterator r127 = r124.iterator();
    L67:
        if (r127.hasNext() == false) goto L72;
        Object r39 = r127.next();
        Iterator r128 = r127;
        if (r125.add(((TaskSkill) r39).getName()) == false) goto L71;
        r126.add(r39);
    L71:
        r127 = r128;
        goto L67
    L72:
        int r40 = r126.size();
        List<TaskSkill> r129 = r15.a;
        ArrayList r130 = new ArrayList();
        Iterator r41 = r38.iterator();
    L74:
        if (r41.hasNext() == false) goto L85;
        Object r131 = r41.next();
        Iterator r132 = r41;
        String r42 = ((TaskSkill) r131).getName();
        if (r42 == null) goto L80;
        o r133 = r5;
        if (r120.contains(r42) != true) goto L81;
        boolean r43 = true;
    L82:
        if (r43 == true) goto L84;
        r130.add(r131);
    L84:
        r41 = r132;
        r5 = r133;
    L81:
        r43 = false;
        goto L82
    L80:
        r133 = r5;
        goto L81
    L85:
        r18 = r5;
        List r44 = CollectionsKt.plus(CollectionsKt.plus(r129, r130), r34);
        List<TaskSkill> r45 = r15.c;
        ArrayList r134 = new ArrayList();
        Iterator r46 = r45.iterator();
    L87:
        if (r46.hasNext() == false) goto L98;
        Object r135 = r46.next();
        String r136 = ((TaskSkill) r135).getName();
        if (r136 == null) goto L93;
        Iterator r137 = r46;
        if (r120.contains(r136) != true) goto L94;
        boolean r138 = true;
    L95:
        if (r138 == true) goto L97;
        r134.add(r135);
    L97:
        r46 = r137;
    L94:
        r138 = false;
        goto L95
    L93:
        r137 = r46;
        goto L94
    L98:
        List r47 = CollectionsKt.plus(r44, r134);
        HashSet r48 = new HashSet();
        ArrayList r139 = new ArrayList();
        Iterator r49 = r47.iterator();
    L100:
        if (r49.hasNext() == false) goto L104;
        Object r140 = r49.next();
        if (r48.add(((TaskSkill) r140).getName()) == false) goto L100;
        r139.add(r140);
        goto L100
    L104:
        List r141 = CollectionsKt.take(r139, RangesKt.coerceAtLeast(Math.max(r13, r40), 0));
        List<TaskSkill> r142 = r15.a;
        ArrayList r143 = new ArrayList();
        Iterator r50 = r34.iterator();
    L106:
        if (r50.hasNext() == false) goto L110;
        Object r51 = r50.next();
        if (CollectionsKt.contains(r36, ((TaskSkill) r51).getName()) == true) goto L106;
        r143.add(r51);
        goto L106
    L110:
        o r52 = o.a(r15, r142, r143, r141, false, Integer.valueOf(r13), 24);
        j2.a.put(r14, r52);
        j2.j(r3);
        FLogger.a.i("TaskSkillStateStore", "[applyRemoteRecentExposedSkills] conversationId=" + r3 + ", modeKey=task_mode, remoteCount=" + r32.size() + ", selectedCount=" + r52.a.size() + ", visibleCount=" + r52.c.size() + ", maxVisibleSlotCount=" + r13);
    L138:
        return Unit.INSTANCE;
    L140:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
