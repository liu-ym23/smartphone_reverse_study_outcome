package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetBindReason;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "RESTORE", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WidgetBindReason extends Enum<WidgetBindReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WidgetBindReason[] $VALUES = null;
    public static final WidgetBindReason ADD = null;
    public static final WidgetBindReason RESTORE = null;

    private static final /* synthetic */ WidgetBindReason[] $values() {
        return new WidgetBindReason[]{ADD, RESTORE};
    }

    static {
        ADD = new WidgetBindReason("ADD", 0);
        RESTORE = new WidgetBindReason("RESTORE", 1);
        WidgetBindReason[] r5 = $values();
        $VALUES = r5;
        $ENTRIES = EnumEntriesKt.enumEntries(r5);
    }

    private WidgetBindReason(String r5, int r10) {
        super(r5, r10);
    }

    public static EnumEntries<WidgetBindReason> getEntries() {
        return $ENTRIES;
    }

    public static WidgetBindReason valueOf(String r5) {
        return (WidgetBindReason) Enum.valueOf(WidgetBindReason.class, r5);
    }

    public static WidgetBindReason[] values() {
        return (WidgetBindReason[]) $VALUES.clone();
    }
}
