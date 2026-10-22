package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelDequeueReason;", "", "<init>", "(Ljava/lang/String;I)V", "CONSUMED", "HIDDEN", "EXPIRED", "SOURCE_INVALIDATED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelDequeueReason extends Enum<InteractionPanelDequeueReason> {
    public static final InteractionPanelDequeueReason CONSUMED = null;
    public static final InteractionPanelDequeueReason EXPIRED = null;
    public static final InteractionPanelDequeueReason HIDDEN = null;
    public static final InteractionPanelDequeueReason SOURCE_INVALIDATED = null;
    public static final /* synthetic */ InteractionPanelDequeueReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InteractionPanelDequeueReason> getEntries() {
        return b;
    }

    static {
        InteractionPanelDequeueReason r0 = new InteractionPanelDequeueReason("CONSUMED", 0);
        CONSUMED = r0;
        InteractionPanelDequeueReason r1 = new InteractionPanelDequeueReason("HIDDEN", 1);
        HIDDEN = r1;
        InteractionPanelDequeueReason r3 = new InteractionPanelDequeueReason("EXPIRED", 2);
        EXPIRED = r3;
        InteractionPanelDequeueReason r5 = new InteractionPanelDequeueReason("SOURCE_INVALIDATED", 3);
        SOURCE_INVALIDATED = r5;
        InteractionPanelDequeueReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static InteractionPanelDequeueReason[] values() {
        return (InteractionPanelDequeueReason[]) a.clone();
    }

    public static InteractionPanelDequeueReason valueOf(String r1) {
        return (InteractionPanelDequeueReason) r27.a.a(InteractionPanelDequeueReason.class, r1);
    }

    public InteractionPanelDequeueReason(String r1, int r2) {
        super(r1, r2);
    }
}
