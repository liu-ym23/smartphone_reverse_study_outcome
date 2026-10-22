package com.obric.assistant.interaction.impl.event.processor;

import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.interaction.base.model.AssistantActivityVisibleState;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.obric.assistant.interaction.base.model.InteractionEvent$InteractionActivityExpandEvent;
import com.obric.assistant.interaction.base.model.InteractionEvent$InteractionActivityVisibleEvent;
import com.obric.assistant.interaction.impl.KtUtils;
import com.obric.assistant.interaction.impl.event.annotation.EventProcessor;
import com.obric.assistant.interaction.impl.event.processor.base.BaseProcessor;
import com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@EventProcessor(clazzes = {InteractionEvent$InteractionActivityExpandEvent.class, InteractionEvent$InteractionActivityVisibleEvent.class})
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/event/processor/AssistantActivityEventProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/BaseProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/IEventProcessor;", "<init>", "()V", "process", "", "event", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantActivityEventProcessor extends BaseProcessor {
    public static final AssistantActivityEventProcessor INSTANCE = null;

    static {
        INSTANCE = new AssistantActivityEventProcessor();
    }

    private AssistantActivityEventProcessor() {
        super(Reflection.getOrCreateKotlinClass(AssistantActivityEventProcessor.class));
    }

    @Override // com.obric.assistant.interaction.impl.event.processor.base.BaseProcessor
    public void process(InteractionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        super.process(r11);
        if ((r11 instanceof InteractionEvent$InteractionActivityExpandEvent) == false) goto L6;
        InteractionStateServiceImpl r0 = getStateService();
        AssistantActivityExpandState r12 = ((InteractionEvent$InteractionActivityExpandEvent) r11).getState();
        BuildersKt.launch$default(KtUtils.INSTANCE.getScope(Reflection.getOrCreateKotlinClass(AssistantActivityExpandState.class), r0.getScopeMaps()), null, null, new InteractionStateServiceImpl.C00371(r12, null), 3, null);
        return;
    L6:
        if ((r11 instanceof InteractionEvent$InteractionActivityVisibleEvent) == false) goto L10;
        InteractionStateServiceImpl r1 = getStateService();
        AssistantActivityVisibleState r13 = ((InteractionEvent$InteractionActivityVisibleEvent) r11).getState();
        BuildersKt.launch$default(KtUtils.INSTANCE.getScope(Reflection.getOrCreateKotlinClass(AssistantActivityVisibleState.class), r1.getScopeMaps()), null, null, new InteractionStateServiceImpl.C00371(r13, null), 3, null);
        return;
    }
}
