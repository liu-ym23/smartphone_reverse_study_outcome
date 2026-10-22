package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryClickAction;", "", "<init>", "(Ljava/lang/String;I)V", "NO_OP", "SHOW_UNAVAILABLE", "REQUEST_AUTHORIZATION", "ENABLE_SWITCH", "ENABLE_SWITCH_WITH_OVERRIDE", "DISABLE_SWITCH", "ACTIVATE_OVERRIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryClickAction extends Enum<DoraObricEnvironmentMemoryClickAction> {
    public static final DoraObricEnvironmentMemoryClickAction ACTIVATE_OVERRIDE = null;
    public static final DoraObricEnvironmentMemoryClickAction DISABLE_SWITCH = null;
    public static final DoraObricEnvironmentMemoryClickAction ENABLE_SWITCH = null;
    public static final DoraObricEnvironmentMemoryClickAction ENABLE_SWITCH_WITH_OVERRIDE = null;
    public static final DoraObricEnvironmentMemoryClickAction NO_OP = null;
    public static final DoraObricEnvironmentMemoryClickAction REQUEST_AUTHORIZATION = null;
    public static final DoraObricEnvironmentMemoryClickAction SHOW_UNAVAILABLE = null;
    public static final /* synthetic */ DoraObricEnvironmentMemoryClickAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryClickAction> getEntries() {
        return b;
    }

    static {
        DoraObricEnvironmentMemoryClickAction r0 = new DoraObricEnvironmentMemoryClickAction("NO_OP", 0);
        NO_OP = r0;
        DoraObricEnvironmentMemoryClickAction r1 = new DoraObricEnvironmentMemoryClickAction("SHOW_UNAVAILABLE", 1);
        SHOW_UNAVAILABLE = r1;
        DoraObricEnvironmentMemoryClickAction r3 = new DoraObricEnvironmentMemoryClickAction("REQUEST_AUTHORIZATION", 2);
        REQUEST_AUTHORIZATION = r3;
        DoraObricEnvironmentMemoryClickAction r5 = new DoraObricEnvironmentMemoryClickAction("ENABLE_SWITCH", 3);
        ENABLE_SWITCH = r5;
        DoraObricEnvironmentMemoryClickAction r7 = new DoraObricEnvironmentMemoryClickAction("ENABLE_SWITCH_WITH_OVERRIDE", 4);
        ENABLE_SWITCH_WITH_OVERRIDE = r7;
        DoraObricEnvironmentMemoryClickAction r9 = new DoraObricEnvironmentMemoryClickAction("DISABLE_SWITCH", 5);
        DISABLE_SWITCH = r9;
        DoraObricEnvironmentMemoryClickAction r11 = new DoraObricEnvironmentMemoryClickAction("ACTIVATE_OVERRIDE", 6);
        ACTIVATE_OVERRIDE = r11;
        DoraObricEnvironmentMemoryClickAction[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static DoraObricEnvironmentMemoryClickAction[] values() {
        return (DoraObricEnvironmentMemoryClickAction[]) a.clone();
    }

    public static DoraObricEnvironmentMemoryClickAction valueOf(String r1) {
        return (DoraObricEnvironmentMemoryClickAction) r27.a.a(DoraObricEnvironmentMemoryClickAction.class, r1);
    }

    public DoraObricEnvironmentMemoryClickAction(String r1, int r2) {
        super(r1, r2);
    }
}
