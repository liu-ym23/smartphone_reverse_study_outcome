package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/ExternalRouteEntry;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_ACTIVITY", "NEW_INTENT", "EXISTING_STACK", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ExternalRouteEntry extends Enum<ExternalRouteEntry> {
    public static final ExternalRouteEntry EXISTING_STACK = null;
    public static final ExternalRouteEntry INITIAL_ACTIVITY = null;
    public static final ExternalRouteEntry NEW_INTENT = null;
    public static final /* synthetic */ ExternalRouteEntry[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExternalRouteEntry> getEntries() {
        return b;
    }

    static {
        ExternalRouteEntry r0 = new ExternalRouteEntry("INITIAL_ACTIVITY", 0);
        INITIAL_ACTIVITY = r0;
        ExternalRouteEntry r1 = new ExternalRouteEntry("NEW_INTENT", 1);
        NEW_INTENT = r1;
        ExternalRouteEntry r3 = new ExternalRouteEntry("EXISTING_STACK", 2);
        EXISTING_STACK = r3;
        ExternalRouteEntry[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ExternalRouteEntry[] values() {
        return (ExternalRouteEntry[]) a.clone();
    }

    public static ExternalRouteEntry valueOf(String r1) {
        return (ExternalRouteEntry) r27.a.a(ExternalRouteEntry.class, r1);
    }

    public ExternalRouteEntry(String r1, int r2) {
        super(r1, r2);
    }
}
