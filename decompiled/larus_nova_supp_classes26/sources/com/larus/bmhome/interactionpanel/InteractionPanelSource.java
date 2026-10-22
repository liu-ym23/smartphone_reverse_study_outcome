package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelSource;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_MESSAGE", "THREAD_MESSAGE", "GENERAL_INTERACTION_ASK_NOTIFY", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelSource extends Enum<InteractionPanelSource> {
    public static final InteractionPanelSource GENERAL_INTERACTION_ASK_NOTIFY = null;
    public static final InteractionPanelSource MAIN_MESSAGE = null;
    public static final InteractionPanelSource THREAD_MESSAGE = null;
    public static final /* synthetic */ InteractionPanelSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InteractionPanelSource> getEntries() {
        return b;
    }

    static {
        InteractionPanelSource r0 = new InteractionPanelSource("MAIN_MESSAGE", 0);
        MAIN_MESSAGE = r0;
        InteractionPanelSource r1 = new InteractionPanelSource("THREAD_MESSAGE", 1);
        THREAD_MESSAGE = r1;
        InteractionPanelSource r3 = new InteractionPanelSource("GENERAL_INTERACTION_ASK_NOTIFY", 2);
        GENERAL_INTERACTION_ASK_NOTIFY = r3;
        InteractionPanelSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static InteractionPanelSource[] values() {
        return (InteractionPanelSource[]) a.clone();
    }

    public static InteractionPanelSource valueOf(String r1) {
        return (InteractionPanelSource) r27.a.a(InteractionPanelSource.class, r1);
    }

    public InteractionPanelSource(String r1, int r2) {
        super(r1, r2);
    }
}
