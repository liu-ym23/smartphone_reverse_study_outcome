package com.obric.assistant.component;

import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.network.api.bean.ObricOmniModel;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.obric.assistant.task.skill.ObricOmniModelConfigManager;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricSkillComponent$setCurrentTaskModeStatus$1", f = "ObricSkillComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricSkillComponent$setCurrentTaskModeStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReplyOption $replyOption;
    int label;

    public ObricSkillComponent$setCurrentTaskModeStatus$1(ReplyOption r1, Continuation<? super ObricSkillComponent$setCurrentTaskModeStatus$1> r2) {
        this.$replyOption = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricSkillComponent$setCurrentTaskModeStatus$1(this.$replyOption, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L50;
        ResultKt.throwOnFailure(r6);
        ObricOmniModelConfigManager r7 = ObricOmniModelConfigManager.a;
        ReplyOption r0 = this.$replyOption;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "replyOption");
        Intrinsics.checkNotNullParameter(r0, "<this>");
        ObricOmniModelConfig r8 = ObricOmniModelConfigManager.c();
        if (com.obric.assistant.task.skill.n.b(r0) == false) goto L41;
        int r1 = r0.getModel().getDeprecatedItemId();
        AtomicBoolean r2 = com.obric.assistant.task.skill.m.a;
        if (com.obric.assistant.task.skill.m.j(Integer.valueOf(r1)) == false) goto L19;
        Iterator<T> r3 = com.obric.assistant.task.skill.a.a(r8).iterator();
    L10:
        if (r3.hasNext() == false) goto L19;
        ObricOmniModel r4 = (ObricOmniModel) r3.next();
        if (r4.getOldItemKey() == null) goto L10;
        Integer r5 = r4.getOldItemKey();
        if (r5 == null) goto L10;
        if (r5.intValue() != r1) goto L10;
        String r9 = r4.getDisplayModel();
    L44:
        if (r9 == null) goto L48;
        ((Keva) ObricOmniModelConfigManager.c.getValue()).storeString("current_display_model", r9);
    L48:
        return Unit.INSTANCE;
    L19:
        Iterator<T> r10 = com.obric.assistant.task.skill.a.a(r8).iterator();
    L20:
        String r11 = null;
        if (r10.hasNext() == false) goto L29;
        ObricOmniModel r12 = (ObricOmniModel) r10.next();
        vea.k r13 = r12.getModelItemIndex();
        if (r13 == null) goto L25;
        r11 = r13.b();
    L25:
        if (r11 == null) goto L20;
        if (Intrinsics.areEqual(r11, r0.getModel().getKey()) == false) goto L20;
        r9 = r12.getDisplayModel();
        goto L44
    L29:
        Iterator<T> r14 = com.obric.assistant.task.skill.a.a(r8).iterator();
    L31:
        if (r14.hasNext() == false) goto L35;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((ObricOmniModel) r15).isSupportedModel(), Boolean.TRUE) == false) goto L31;
    L36:
        ObricOmniModel r16 = (ObricOmniModel) r15;
        if (r16 == null) goto L39;
        r9 = r16.getDisplayModel();
        goto L44
    L39:
        r9 = null;
        goto L44
    L35:
        r15 = null;
        goto L36
    L41:
        if (Intrinsics.areEqual(r0.getModel().getKey(), "0") == false) goto L43;
        r9 = "chat";
        goto L44
    L43:
        r9 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
        goto L44
    L50:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
