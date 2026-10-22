package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslActionTrackerEvent;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "DORA_CARD_CLICK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslActionTrackerEvent extends Enum<DslActionTrackerEvent> {

    @SerializedName("dora_card_click")
    public static final DslActionTrackerEvent DORA_CARD_CLICK = null;
    public static final /* synthetic */ DslActionTrackerEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String eventName;

    public static EnumEntries<DslActionTrackerEvent> getEntries() {
        return b;
    }

    static {
        DslActionTrackerEvent r0 = new DslActionTrackerEvent();
        DORA_CARD_CLICK = r0;
        DslActionTrackerEvent[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public DslActionTrackerEvent() {
        super("DORA_CARD_CLICK", 0);
        this.eventName = "dora_card_click";
    }

    public static DslActionTrackerEvent[] values() {
        return (DslActionTrackerEvent[]) a.clone();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public static DslActionTrackerEvent valueOf(String r1) {
        return (DslActionTrackerEvent) r27.a.a(DslActionTrackerEvent.class, r1);
    }
}
