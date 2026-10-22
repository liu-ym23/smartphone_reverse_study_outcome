package com.obric.assistant.interaction.base.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\u001f\b\u0004\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "args", "", "", "", "<init>", "(Ljava/util/Map;)V", "ShowSession", "HideSession", "CreateSession", "PrepareSession", "DestroySession", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$CreateSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$DestroySession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$HideSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$PrepareSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$ShowSession;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class InteractionEvent$SessionLifecycleEvent extends InteractionEvent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$CreateSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CreateSession extends InteractionEvent$SessionLifecycleEvent {
        public CreateSession() {
            Map r0 = null;
            super(r0, 1, r0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$DestroySession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DestroySession extends InteractionEvent$SessionLifecycleEvent {
        public DestroySession() {
            Map r0 = null;
            super(r0, 1, r0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$HideSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HideSession extends InteractionEvent$SessionLifecycleEvent {
        public HideSession() {
            Map r0 = null;
            super(r0, 1, r0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$PrepareSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PrepareSession extends InteractionEvent$SessionLifecycleEvent {
        public PrepareSession() {
            Map r0 = null;
            super(r0, 1, r0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$ShowSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShowSession extends InteractionEvent$SessionLifecycleEvent {
        public ShowSession() {
            Map r0 = null;
            super(r0, 1, r0);
        }
    }

    public /* synthetic */ InteractionEvent$SessionLifecycleEvent(Map r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private InteractionEvent$SessionLifecycleEvent(Map<String, ? extends Object> r1) {
        super(null);
    }

    public /* synthetic */ InteractionEvent$SessionLifecycleEvent(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        this(r1, null);
    }
}
