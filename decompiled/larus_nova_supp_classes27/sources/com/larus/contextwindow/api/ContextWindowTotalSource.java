package com.larus.contextwindow.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowTotalSource;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE", "CURRENT_MODEL", "MESSAGE_FALLBACK", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowTotalSource extends Enum<ContextWindowTotalSource> {
    public static final ContextWindowTotalSource CURRENT_MODEL = null;
    public static final ContextWindowTotalSource MESSAGE = null;
    public static final ContextWindowTotalSource MESSAGE_FALLBACK = null;
    public static final /* synthetic */ ContextWindowTotalSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ContextWindowTotalSource> getEntries() {
        return b;
    }

    static {
        ContextWindowTotalSource r0 = new ContextWindowTotalSource("MESSAGE", 0);
        MESSAGE = r0;
        ContextWindowTotalSource r1 = new ContextWindowTotalSource("CURRENT_MODEL", 1);
        CURRENT_MODEL = r1;
        ContextWindowTotalSource r3 = new ContextWindowTotalSource("MESSAGE_FALLBACK", 2);
        MESSAGE_FALLBACK = r3;
        ContextWindowTotalSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ContextWindowTotalSource[] values() {
        return (ContextWindowTotalSource[]) a.clone();
    }

    public static ContextWindowTotalSource valueOf(String r1) {
        return (ContextWindowTotalSource) a.a(ContextWindowTotalSource.class, r1);
    }

    public ContextWindowTotalSource(String r1, int r2) {
        super(r1, r2);
    }
}
