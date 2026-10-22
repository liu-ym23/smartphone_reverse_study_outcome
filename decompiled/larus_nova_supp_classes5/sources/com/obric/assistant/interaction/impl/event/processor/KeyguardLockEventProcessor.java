package com.obric.assistant.interaction.impl.event.processor;

import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.obric.assistant.interaction.base.model.InteractionEvent$InteractionKeyguardLockedEvent;
import com.obric.assistant.interaction.impl.KtUtils;
import com.obric.assistant.interaction.impl.event.annotation.EventProcessor;
import com.obric.assistant.interaction.impl.event.processor.base.BaseProcessor;
import com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@EventProcessor(clazzes = {InteractionEvent$InteractionKeyguardLockedEvent.class})
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/event/processor/KeyguardLockEventProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/BaseProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/IEventProcessor;", "<init>", "()V", "process", "", "event", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyguardLockEventProcessor extends BaseProcessor {
    public static final KeyguardLockEventProcessor INSTANCE = null;

    static {
        INSTANCE = new KeyguardLockEventProcessor();
    }

    private KeyguardLockEventProcessor() {
        super(Reflection.getOrCreateKotlinClass(KeyguardLockEventProcessor.class));
    }

    @Override // com.obric.assistant.interaction.impl.event.processor.base.BaseProcessor
    public void process(InteractionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        super.process(r10);
        if ((r10 instanceof InteractionEvent$InteractionKeyguardLockedEvent) == false) goto L6;
        InteractionStateServiceImpl r0 = getStateService();
        KeyguardLockedState r11 = ((InteractionEvent$InteractionKeyguardLockedEvent) r10).getState();
        BuildersKt.launch$default(KtUtils.INSTANCE.getScope(Reflection.getOrCreateKotlinClass(KeyguardLockedState.class), r0.getScopeMaps()), null, null, new InteractionStateServiceImpl.C00371(r11, null), 3, null);
        return;
    }
}
