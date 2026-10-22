package com.larus.bmhome.taskskill.ui;

import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.flowskill.impl.databinding.LarusFragmentTaskSkillPanelBinding;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.ui.TaskSkillPanelFragment$loadRecommendSkills$1", f = "TaskSkillPanelFragment.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
final class TaskSkillPanelFragment$loadRecommendSkills$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TaskSkillPanelFragment this$0;

    public TaskSkillPanelFragment$loadRecommendSkills$1(TaskSkillPanelFragment r1, Continuation<? super TaskSkillPanelFragment$loadRecommendSkills$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TaskSkillPanelFragment$loadRecommendSkills$1(this.this$0, r3);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        Object r11 = ((Result) r10).unbox-impl();
        TaskSkillPanelFragment r3 = this.this$0;
        r3.i = false;
        if (Result.isSuccess-impl(r11) == false) goto L33;
        List r4 = (List) r11;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[loadRecommendSkills] success, skills=");
        r7.append(r4.size());
        r7.append(", viewReady=");
        if (r3.d == null) goto L16;
        boolean r8 = true;
    L17:
        r7.append(r8);
        r6.i("TaskSkillPanelFragment", r7.toString());
        if (r4.isEmpty() == false) goto L20;
        TaskSkillPanelFragment.W90(r3);
        goto L33
    L20:
        LarusFragmentTaskSkillPanelBinding r9 = r3.d;
        if (r9 == null) goto L23;
        r9.d.setVisibility(0);
        r9.c.setVisibility(8);
    L23:
        q r12 = r3.f;
        if (r12 == null) goto L26;
        r12.a();
    L26:
        TaskSkillListAdapter r5 = r3.e;
        if (r5 == null) goto L33;
        List r13 = r4;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L30:
        if (r15.hasNext() == false) goto L32;
        r14.add(new r.b((TaskSkill) r15.next()));
        goto L30
    L32:
        r5.submitList(r14);
        goto L33
    L16:
        r8 = false;
    L33:
        TaskSkillPanelFragment r16 = this.this$0;
        Throwable r17 = Result.exceptionOrNull-impl(r11);
        if (r17 == null) goto L60;
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("[loadRecommendSkills] failed, hasPcDeviceId=");
        String r20 = r16.g;
        if (r20 != null) goto L38;
    L41:
        boolean r21 = true;
    L42:
        r19.append(!r21);
        r19.append(", error=");
        r19.append(r17.getMessage());
        r18.w("TaskSkillPanelFragment", r19.toString());
        String r110 = r16.g;
        if (r110 != null) goto L45;
    L48:
        if (r2 == false) goto L58;
        LarusFragmentTaskSkillPanelBinding r111 = r16.d;
        if (r111 == null) goto L52;
        r111.d.setVisibility(8);
        r111.c.setVisibility(8);
    L52:
        q r112 = r16.f;
        if (r112 == null) goto L55;
        r112.c();
    L55:
        TaskSkillListAdapter r113 = r16.e;
        if (r113 == null) goto L60;
        r113.submitList(CollectionsKt.emptyList());
        goto L60
    L58:
        TaskSkillPanelFragment.W90(r16);
        goto L60
    L45:
        if (StringsKt.isBlank(r110) == true) goto L48;
        r2 = false;
        goto L48
    L38:
        if (StringsKt.isBlank(r20) == true) goto L41;
        r21 = false;
    L60:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r114 = Dispatchers.getIO();
        TaskSkillPanelFragment$loadRecommendSkills$1$result$1 r22 = new TaskSkillPanelFragment$loadRecommendSkills$1$result$1(this.this$0, null);
        this.label = 1;
        r10 = BuildersKt.withContext(r114, r22, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
