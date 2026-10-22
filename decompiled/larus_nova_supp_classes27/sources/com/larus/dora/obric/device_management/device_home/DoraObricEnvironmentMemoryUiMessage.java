package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryUiMessage;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "TEMPORARY_OVERRIDE", "UNAVAILABLE", "NETWORK_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryUiMessage extends Enum<DoraObricEnvironmentMemoryUiMessage> {
    public static final DoraObricEnvironmentMemoryUiMessage ENABLED = null;
    public static final DoraObricEnvironmentMemoryUiMessage NETWORK_ERROR = null;
    public static final DoraObricEnvironmentMemoryUiMessage TEMPORARY_OVERRIDE = null;
    public static final DoraObricEnvironmentMemoryUiMessage UNAVAILABLE = null;
    public static final /* synthetic */ DoraObricEnvironmentMemoryUiMessage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryUiMessage> getEntries() {
        return b;
    }

    static {
        DoraObricEnvironmentMemoryUiMessage r0 = new DoraObricEnvironmentMemoryUiMessage("ENABLED", 0);
        ENABLED = r0;
        DoraObricEnvironmentMemoryUiMessage r1 = new DoraObricEnvironmentMemoryUiMessage("TEMPORARY_OVERRIDE", 1);
        TEMPORARY_OVERRIDE = r1;
        DoraObricEnvironmentMemoryUiMessage r3 = new DoraObricEnvironmentMemoryUiMessage("UNAVAILABLE", 2);
        UNAVAILABLE = r3;
        DoraObricEnvironmentMemoryUiMessage r5 = new DoraObricEnvironmentMemoryUiMessage("NETWORK_ERROR", 3);
        NETWORK_ERROR = r5;
        DoraObricEnvironmentMemoryUiMessage[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DoraObricEnvironmentMemoryUiMessage[] values() {
        return (DoraObricEnvironmentMemoryUiMessage[]) a.clone();
    }

    public static DoraObricEnvironmentMemoryUiMessage valueOf(String r1) {
        return (DoraObricEnvironmentMemoryUiMessage) r27.a.a(DoraObricEnvironmentMemoryUiMessage.class, r1);
    }

    public DoraObricEnvironmentMemoryUiMessage(String r1, int r2) {
        super(r1, r2);
    }
}
