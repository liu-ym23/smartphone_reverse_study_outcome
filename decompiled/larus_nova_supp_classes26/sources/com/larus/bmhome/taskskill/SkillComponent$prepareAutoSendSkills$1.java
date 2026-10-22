package com.larus.bmhome.taskskill;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.bmhome.taskskill.network.q;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$prepareAutoSendSkills$1", f = "SkillComponent.kt", i = {}, l = {2070}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$prepareAutoSendSkills$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Function0<Unit> $onComplete;
    final /* synthetic */ q $requestParam;
    final /* synthetic */ List<String> $requestedSkillIds;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$prepareAutoSendSkills$1(List<String> r1, SkillComponent r2, String r3, Function0<Unit> r4, q r5, Continuation<? super SkillComponent$prepareAutoSendSkills$1> r6) {
        this.$requestedSkillIds = r1;
        this.this$0 = r2;
        this.$conversationId = r3;
        this.$onComplete = r4;
        this.$requestParam = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SkillComponent$prepareAutoSendSkills$1(this.$requestedSkillIds, this.this$0, this.$conversationId, this.$onComplete, this.$requestParam, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = null;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        Object r14 = ((Result) r13).unbox-impl();
        Object r4 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r14) == true) goto L15;
        r4 = r14;
    L15:
        List r5 = (List) r4;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L29;
        TaskSkill r8 = (TaskSkill) r7.next();
        String r9 = r8.d();
        if (r9 != null) goto L21;
    L26:
        Pair r10 = null;
    L27:
        if (r10 == null) goto L17;
        r6.add(r10);
        goto L17
    L21:
        if ((!StringsKt.isBlank(r9)) == true) goto L24;
        r9 = null;
    L24:
        if (r9 == null) goto L26;
        r10 = TuplesKt.to(r9, r8);
        goto L27
    L29:
        Map r11 = MapsKt.toMap(r6);
        List<String> r12 = this.$requestedSkillIds;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r12.iterator();
    L31:
        if (r16.hasNext() == false) goto L35;
        TaskSkill r17 = (TaskSkill) r11.get((String) r16.next());
        if (r17 == null) goto L31;
        r15.add(r17);
        goto L31
    L35:
        SkillComponent r18 = this.this$0;
        Regex r19 = SkillComponent.F2;
        int r20 = 0;
        if (r18.yW() == true) goto L47;
        if ((!r15.isEmpty()) == false) goto L47;
        com.larus.bmhome.instruction.g r21 = this.this$0.vc();
        if (r21 == null) goto L47;
        com.larus.bmhome.instruction.g r22 = this.this$0.vc();
        if (r22 == null) goto L44;
        ReplyOption r23 = r22.IT(wa8.t0.e);
    L45:
        com.larus.bmhome.instruction.g.a.b(r21, null, r23, false, 5);
        goto L47
    L44:
        r23 = null;
    L47:
        if ((!r15.isEmpty()) == true) goto L49;
    L51:
        r3 = false;
    L52:
        if (r3 == false) goto L57;
        this.this$0.q4();
        ConcurrentHashMap r24 = j2.a;
        j2.o(r15, this.$conversationId, false, null, null, 56);
        SkillComponent r25 = this.this$0;
        TaskSkill r26 = (TaskSkill) CollectionsKt.firstOrNull(r15);
        if (r26 == null) goto L56;
        r2 = r26.getName();
    L56:
        r25.d5(r2);
        this.this$0.T4(false);
    L57:
        Throwable r110 = Result.exceptionOrNull-impl(r14);
        if (r110 == null) goto L60;
        FLogger.a.w("SkillComponent", "[prepareAutoSendSkills] load available skills failed, msg=" + r110.getMessage());
    L60:
        if (r3 == false) goto L62;
        r20 = r15.size();
    L62:
        FLogger.a.i("SkillComponent", "[prepareAutoSendSkills] conversationId=" + this.$conversationId + ", requestedCount=" + this.$requestedSkillIds.size() + ", availableCount=" + r5.size() + ", matchedCount=" + r15.size() + ", appliedCount=" + r20 + ", ignoredCount=" + (this.$requestedSkillIds.size() - r20));
        this.$onComplete.invoke();
        return Unit.INSTANCE;
    L49:
        if (this.this$0.sY() == false) goto L51;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r111 = Dispatchers.getIO();
        SkillComponent$prepareAutoSendSkills$1$result$1 r27 = new SkillComponent$prepareAutoSendSkills$1$result$1(this.$requestParam, null);
        this.label = 1;
        r13 = BuildersKt.withContext(r111, r27, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
