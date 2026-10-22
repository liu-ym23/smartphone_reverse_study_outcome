package com.obric.assistant.interaction.base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "state", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "<init>", "(Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;)V", "getState", "()Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "SmallWindowEvent", "NineSplitEvent", "FullScreenEvent", "InvisibleEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$FullScreenEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$InvisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$NineSplitEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$SmallWindowEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class InteractionEvent$InteractionActivityExpandEvent extends InteractionEvent {
    private final AssistantActivityExpandState state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$FullScreenEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FullScreenEvent extends InteractionEvent$InteractionActivityExpandEvent {
        public static final FullScreenEvent INSTANCE = null;

        static {
            INSTANCE = new FullScreenEvent();
        }

        private FullScreenEvent() {
            super(AssistantActivityExpandState.FULL_SCREEN, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$InvisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvisibleEvent extends InteractionEvent$InteractionActivityExpandEvent {
        public static final InvisibleEvent INSTANCE = null;

        static {
            INSTANCE = new InvisibleEvent();
        }

        private InvisibleEvent() {
            super(AssistantActivityExpandState.INVISIBLE, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$NineSplitEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NineSplitEvent extends InteractionEvent$InteractionActivityExpandEvent {
        public static final NineSplitEvent INSTANCE = null;

        static {
            INSTANCE = new NineSplitEvent();
        }

        private NineSplitEvent() {
            super(AssistantActivityExpandState.HALF_WINDOW, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$SmallWindowEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SmallWindowEvent extends InteractionEvent$InteractionActivityExpandEvent {
        public static final SmallWindowEvent INSTANCE = null;

        static {
            INSTANCE = new SmallWindowEvent();
        }

        private SmallWindowEvent() {
            super(AssistantActivityExpandState.CHAT_WINDOW, null);
        }
    }

    public /* synthetic */ InteractionEvent$InteractionActivityExpandEvent(AssistantActivityExpandState r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public final AssistantActivityExpandState getState() {
        return this.state;
    }

    private InteractionEvent$InteractionActivityExpandEvent(AssistantActivityExpandState r2) {
        super(null);
        this.state = r2;
    }
}
