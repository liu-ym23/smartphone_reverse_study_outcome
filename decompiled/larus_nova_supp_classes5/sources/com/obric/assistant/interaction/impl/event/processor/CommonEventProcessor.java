package com.obric.assistant.interaction.impl.event.processor;

import com.obric.assistant.interaction.base.model.InteractionEvent$CommonEvent;
import com.obric.assistant.interaction.impl.event.annotation.EventProcessor;
import com.obric.assistant.interaction.impl.event.processor.base.BaseProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@EventProcessor(clazzes = {InteractionEvent$CommonEvent.class})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/assistant/interaction/impl/event/processor/CommonEventProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/BaseProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/IEventProcessor;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonEventProcessor extends BaseProcessor {
    public static final CommonEventProcessor INSTANCE = null;

    static {
        INSTANCE = new CommonEventProcessor();
    }

    private CommonEventProcessor() {
        super(Reflection.getOrCreateKotlinClass(CommonEventProcessor.class));
    }
}
