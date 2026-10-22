package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelSubmitResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "CANCELLED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelSubmitResult extends Enum<InteractionPanelSubmitResult> {
    public static final InteractionPanelSubmitResult CANCELLED = null;
    public static final InteractionPanelSubmitResult FAILURE = null;
    public static final InteractionPanelSubmitResult SUCCESS = null;
    public static final /* synthetic */ InteractionPanelSubmitResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InteractionPanelSubmitResult> getEntries() {
        return b;
    }

    static {
        InteractionPanelSubmitResult r0 = new InteractionPanelSubmitResult("SUCCESS", 0);
        SUCCESS = r0;
        InteractionPanelSubmitResult r1 = new InteractionPanelSubmitResult("FAILURE", 1);
        FAILURE = r1;
        InteractionPanelSubmitResult r3 = new InteractionPanelSubmitResult("CANCELLED", 2);
        CANCELLED = r3;
        InteractionPanelSubmitResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static InteractionPanelSubmitResult[] values() {
        return (InteractionPanelSubmitResult[]) a.clone();
    }

    public static InteractionPanelSubmitResult valueOf(String r1) {
        return (InteractionPanelSubmitResult) r27.a.a(InteractionPanelSubmitResult.class, r1);
    }

    public InteractionPanelSubmitResult(String r1, int r2) {
        super(r1, r2);
    }
}
