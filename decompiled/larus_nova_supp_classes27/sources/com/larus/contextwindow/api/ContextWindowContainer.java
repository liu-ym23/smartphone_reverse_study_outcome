package com.larus.contextwindow.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowContainer;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT_CHAT", "NATIVE_ROUTE", "UNSUPPORTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowContainer extends Enum<ContextWindowContainer> {
    public static final ContextWindowContainer DEFAULT_CHAT = null;
    public static final ContextWindowContainer NATIVE_ROUTE = null;
    public static final ContextWindowContainer UNSUPPORTED = null;
    public static final /* synthetic */ ContextWindowContainer[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ContextWindowContainer> getEntries() {
        return b;
    }

    static {
        ContextWindowContainer r0 = new ContextWindowContainer("DEFAULT_CHAT", 0);
        DEFAULT_CHAT = r0;
        ContextWindowContainer r1 = new ContextWindowContainer("NATIVE_ROUTE", 1);
        NATIVE_ROUTE = r1;
        ContextWindowContainer r3 = new ContextWindowContainer("UNSUPPORTED", 2);
        UNSUPPORTED = r3;
        ContextWindowContainer[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ContextWindowContainer[] values() {
        return (ContextWindowContainer[]) a.clone();
    }

    public static ContextWindowContainer valueOf(String r1) {
        return (ContextWindowContainer) a.a(ContextWindowContainer.class, r1);
    }

    public ContextWindowContainer(String r1, int r2) {
        super(r1, r2);
    }
}
