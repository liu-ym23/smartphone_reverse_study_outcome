package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelQueueState;", "", "<init>", "(Ljava/lang/String;I)V", "QUEUED", "SUBMITTING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelQueueState extends Enum<InteractionPanelQueueState> {
    public static final InteractionPanelQueueState QUEUED = null;
    public static final InteractionPanelQueueState SUBMITTING = null;
    public static final /* synthetic */ InteractionPanelQueueState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InteractionPanelQueueState> getEntries() {
        return b;
    }

    static {
        InteractionPanelQueueState r0 = new InteractionPanelQueueState("QUEUED", 0);
        QUEUED = r0;
        InteractionPanelQueueState r1 = new InteractionPanelQueueState("SUBMITTING", 1);
        SUBMITTING = r1;
        InteractionPanelQueueState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static InteractionPanelQueueState[] values() {
        return (InteractionPanelQueueState[]) a.clone();
    }

    public static InteractionPanelQueueState valueOf(String r1) {
        return (InteractionPanelQueueState) r27.a.a(InteractionPanelQueueState.class, r1);
    }

    public InteractionPanelQueueState(String r1, int r2) {
        super(r1, r2);
    }
}
