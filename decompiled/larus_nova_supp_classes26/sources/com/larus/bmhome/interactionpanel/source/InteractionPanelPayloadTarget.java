package com.larus.bmhome.interactionpanel.source;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/interactionpanel/source/InteractionPanelPayloadTarget;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_HOST", "THREAD_HOST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelPayloadTarget extends Enum<InteractionPanelPayloadTarget> {
    public static final InteractionPanelPayloadTarget MAIN_HOST = null;
    public static final InteractionPanelPayloadTarget THREAD_HOST = null;
    public static final /* synthetic */ InteractionPanelPayloadTarget[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InteractionPanelPayloadTarget> getEntries() {
        return b;
    }

    static {
        InteractionPanelPayloadTarget r0 = new InteractionPanelPayloadTarget("MAIN_HOST", 0);
        MAIN_HOST = r0;
        InteractionPanelPayloadTarget r1 = new InteractionPanelPayloadTarget("THREAD_HOST", 1);
        THREAD_HOST = r1;
        InteractionPanelPayloadTarget[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static InteractionPanelPayloadTarget[] values() {
        return (InteractionPanelPayloadTarget[]) a.clone();
    }

    public static InteractionPanelPayloadTarget valueOf(String r1) {
        return (InteractionPanelPayloadTarget) a.a(InteractionPanelPayloadTarget.class, r1);
    }

    public InteractionPanelPayloadTarget(String r1, int r2) {
        super(r1, r2);
    }
}
