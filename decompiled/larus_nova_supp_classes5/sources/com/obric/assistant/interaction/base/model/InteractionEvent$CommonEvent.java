package com.obric.assistant.interaction.base.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\b6\u0018\u00002\u00020\u0001B'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$CommonEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "eventId", "", "args", "", "", "", "<init>", "(ILjava/util/Map;)V", "getEventId", "()I", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class InteractionEvent$CommonEvent extends InteractionEvent {
    private final int eventId;

    public /* synthetic */ InteractionEvent$CommonEvent(int r1, Map r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public final int getEventId() {
        return this.eventId;
    }

    private InteractionEvent$CommonEvent(int r1, Map<String, ? extends Object> r2) {
        super(null);
        this.eventId = r1;
    }

    public /* synthetic */ InteractionEvent$CommonEvent(int r1, Map r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = MapsKt.emptyMap();
    L5:
        this(r1, r2, null);
    }
}
