package com.larus.bmhome.taskskill;

import com.larus.project.TaskProjectRepository;
import com.larus.utils.logger.FLogger;
import ic8.n;
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
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$syncSelectedProjectFromConversation$1", f = "SkillComponent.kt", i = {}, l = {2303}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$syncSelectedProjectFromConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $new;
    final /* synthetic */ String $newProjectId;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$syncSelectedProjectFromConversation$1(String r1, SkillComponent r2, wc9.e r3, Continuation<? super SkillComponent$syncSelectedProjectFromConversation$1> r4) {
        this.$newProjectId = r1;
        this.this$0 = r2;
        this.$new = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SkillComponent$syncSelectedProjectFromConversation$1(this.$newProjectId, this.this$0, this.$new, r5);
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
        SkillComponent r2 = this.this$0;
        String r3 = this.$newProjectId;
        wc9.e r4 = this.$new;
        if (Result.isSuccess-impl(r11) == false) goto L41;
        com.larus.project.i r5 = (com.larus.project.i) r11;
        Regex r6 = SkillComponent.F2;
        com.larus.bmhome.chat.component.cvs.y r7 = r2.d4();
        String r8 = null;
        if (r7 == null) goto L22;
        wc9.e r9 = r7.h();
        if (r9 == null) goto L22;
        String r12 = r9.I;
        if (r12 == null) goto L22;
        if ((!StringsKt.isBlank(r12)) == false) goto L22;
    L24:
        if (Intrinsics.areEqual(r12, r3) == false) goto L41;
        if (Intrinsics.areEqual(r2.G1, r3) == false) goto L41;
        if (r5 == null) goto L34;
        String r13 = r5.b;
        if (r13 == null) goto L34;
        if ((!StringsKt.isBlank(r13)) == false) goto L34;
        r8 = r13;
    L34:
        if (r8 != null) goto L36;
        FLogger.a.w("SkillComponent", "[syncSelectedProjectFromConversation] project not found, projectId=" + r3);
        goto L41
    L36:
        r2.H1 = r8;
        r2.KY();
        if (SkillComponent.i4() == false) goto L41;
        if (n.r(r4) == false) goto L41;
        r2.T4(true);
    L22:
        r12 = null;
    L41:
        String r14 = this.$newProjectId;
        Throwable r15 = Result.exceptionOrNull-impl(r11);
        if (r15 == null) goto L45;
        FLogger.a.e("SkillComponent", "[syncSelectedProjectFromConversation] load failed, projectId=" + r14, r15);
    L45:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        TaskProjectRepository r16 = TaskProjectRepository.a;
        String r17 = this.$newProjectId;
        this.label = 1;
        r11 = r16.a(r17, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
