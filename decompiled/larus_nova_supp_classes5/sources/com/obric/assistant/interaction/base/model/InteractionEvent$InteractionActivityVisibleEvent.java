package com.obric.assistant.interaction.base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "state", "Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;", "<init>", "(Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;)V", "getState", "()Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;", "VisibleEvent", "InvisibleEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent$InvisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent$VisibleEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class InteractionEvent$InteractionActivityVisibleEvent extends InteractionEvent {
    private final AssistantActivityVisibleState state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent$InvisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvisibleEvent extends InteractionEvent$InteractionActivityVisibleEvent {
        public static final InvisibleEvent INSTANCE = null;

        static {
            INSTANCE = new InvisibleEvent();
        }

        private InvisibleEvent() {
            super(AssistantActivityVisibleState.INVISIBLE, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent$VisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VisibleEvent extends InteractionEvent$InteractionActivityVisibleEvent {
        public static final VisibleEvent INSTANCE = null;

        static {
            INSTANCE = new VisibleEvent();
        }

        private VisibleEvent() {
            super(AssistantActivityVisibleState.VISIBLE, null);
        }
    }

    public /* synthetic */ InteractionEvent$InteractionActivityVisibleEvent(AssistantActivityVisibleState r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public final AssistantActivityVisibleState getState() {
        return this.state;
    }

    private InteractionEvent$InteractionActivityVisibleEvent(AssistantActivityVisibleState r2) {
        super(null);
        this.state = r2;
    }
}
