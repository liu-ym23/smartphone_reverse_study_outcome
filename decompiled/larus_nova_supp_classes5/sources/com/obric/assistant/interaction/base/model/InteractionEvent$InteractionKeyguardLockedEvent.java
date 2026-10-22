package com.obric.assistant.interaction.base.model;

import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "state", "Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;", "<init>", "(Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;)V", "getState", "()Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;", "LockedEvent", "UnlockedEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent$LockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent$UnlockedEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class InteractionEvent$InteractionKeyguardLockedEvent extends InteractionEvent {
    private final KeyguardLockedState state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent$LockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LockedEvent extends InteractionEvent$InteractionKeyguardLockedEvent {
        public static final LockedEvent INSTANCE = null;

        static {
            INSTANCE = new LockedEvent();
        }

        private LockedEvent() {
            super(KeyguardLockedState.LOCKED, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent$UnlockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UnlockedEvent extends InteractionEvent$InteractionKeyguardLockedEvent {
        public static final UnlockedEvent INSTANCE = null;

        static {
            INSTANCE = new UnlockedEvent();
        }

        private UnlockedEvent() {
            super(KeyguardLockedState.UNLOCKED, null);
        }
    }

    public /* synthetic */ InteractionEvent$InteractionKeyguardLockedEvent(KeyguardLockedState r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public final KeyguardLockedState getState() {
        return this.state;
    }

    private InteractionEvent$InteractionKeyguardLockedEvent(KeyguardLockedState r2) {
        super(null);
        this.state = r2;
    }
}
