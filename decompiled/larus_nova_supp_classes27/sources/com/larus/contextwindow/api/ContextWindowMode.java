package com.larus.contextwindow.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowMode;", "", "<init>", "(Ljava/lang/String;I)V", "SUPPORTED", "CLOSE", "PRO", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowMode extends Enum<ContextWindowMode> {
    public static final ContextWindowMode CLOSE = null;
    public static final ContextWindowMode PRO = null;
    public static final ContextWindowMode SUPPORTED = null;
    public static final ContextWindowMode UNKNOWN = null;
    public static final /* synthetic */ ContextWindowMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ContextWindowMode> getEntries() {
        return b;
    }

    static {
        ContextWindowMode r0 = new ContextWindowMode("SUPPORTED", 0);
        SUPPORTED = r0;
        ContextWindowMode r1 = new ContextWindowMode("CLOSE", 1);
        CLOSE = r1;
        ContextWindowMode r3 = new ContextWindowMode("PRO", 2);
        PRO = r3;
        ContextWindowMode r5 = new ContextWindowMode("UNKNOWN", 3);
        UNKNOWN = r5;
        ContextWindowMode[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ContextWindowMode[] values() {
        return (ContextWindowMode[]) a.clone();
    }

    public static ContextWindowMode valueOf(String r1) {
        return (ContextWindowMode) a.a(ContextWindowMode.class, r1);
    }

    public ContextWindowMode(String r1, int r2) {
        super(r1, r2);
    }
}
