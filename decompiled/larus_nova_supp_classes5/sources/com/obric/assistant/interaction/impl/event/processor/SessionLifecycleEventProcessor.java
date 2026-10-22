package com.obric.assistant.interaction.impl.event.processor;

import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.obric.assistant.interaction.base.model.InteractionEvent$SessionLifecycleEvent;
import com.obric.assistant.interaction.base.model.SessionLifecycleState;
import com.obric.assistant.interaction.impl.KtUtils;
import com.obric.assistant.interaction.impl.event.annotation.EventProcessor;
import com.obric.assistant.interaction.impl.event.processor.base.BaseProcessor;
import com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@EventProcessor(clazzes = {InteractionEvent$SessionLifecycleEvent.class})
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/event/processor/SessionLifecycleEventProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/BaseProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/IEventProcessor;", "<init>", "()V", "process", "", "event", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionLifecycleEventProcessor extends BaseProcessor {
    public static final SessionLifecycleEventProcessor INSTANCE = null;

    static {
        INSTANCE = new SessionLifecycleEventProcessor();
    }

    private SessionLifecycleEventProcessor() {
        super(Reflection.getOrCreateKotlinClass(SessionLifecycleEventProcessor.class));
    }

    @Override // com.obric.assistant.interaction.impl.event.processor.base.BaseProcessor
    public void process(InteractionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        super.process(r11);
        if ((r11 instanceof InteractionEvent$SessionLifecycleEvent.ShowSession) == false) goto L6;
        InteractionStateServiceImpl r12 = getStateService();
        SessionLifecycleState r0 = SessionLifecycleState.SHOW;
        BuildersKt.launch$default(KtUtils.INSTANCE.getScope(Reflection.getOrCreateKotlinClass(SessionLifecycleState.class), r12.getScopeMaps()), null, null, new InteractionStateServiceImpl.C00371(r0, null), 3, null);
        return;
    L6:
        if ((r11 instanceof InteractionEvent$SessionLifecycleEvent.HideSession) == false) goto L9;
        InteractionStateServiceImpl r13 = getStateService();
        SessionLifecycleState r1 = SessionLifecycleState.HIDE;
        BuildersKt.launch$default(KtUtils.INSTANCE.getScope(Reflection.getOrCreateKotlinClass(SessionLifecycleState.class), r13.getScopeMaps()), null, null, new InteractionStateServiceImpl.C00371(r1, null), 3, null);
        return;
    L9:
        if ((r11 instanceof InteractionEvent$SessionLifecycleEvent.DestroySession) == false) goto L12;
        InteractionStateServiceImpl r14 = getStateService();
        SessionLifecycleState r2 = SessionLifecycleState.DESTROY;
        BuildersKt.launch$default(KtUtils.INSTANCE.getScope(Reflection.getOrCreateKotlinClass(SessionLifecycleState.class), r14.getScopeMaps()), null, null, new InteractionStateServiceImpl.C00371(r2, null), 3, null);
        return;
    L12:
        if ((r11 instanceof InteractionEvent$SessionLifecycleEvent.CreateSession) == false) goto L15;
        InteractionStateServiceImpl r15 = getStateService();
        SessionLifecycleState r3 = SessionLifecycleState.CREATE;
        BuildersKt.launch$default(KtUtils.INSTANCE.getScope(Reflection.getOrCreateKotlinClass(SessionLifecycleState.class), r15.getScopeMaps()), null, null, new InteractionStateServiceImpl.C00371(r3, null), 3, null);
        return;
    L15:
        if ((r11 instanceof InteractionEvent$SessionLifecycleEvent.PrepareSession) == false) goto L22;
        InteractionStateServiceImpl r16 = getStateService();
        SessionLifecycleState r4 = SessionLifecycleState.PREPARE;
        BuildersKt.launch$default(KtUtils.INSTANCE.getScope(Reflection.getOrCreateKotlinClass(SessionLifecycleState.class), r16.getScopeMaps()), null, null, new InteractionStateServiceImpl.C00371(r4, null), 3, null);
        return;
    }
}
