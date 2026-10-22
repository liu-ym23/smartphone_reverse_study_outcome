package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/ota/g2/DeadlineType;", "", "<init>", "(Ljava/lang/String;I)V", "WINDOW_OPEN", "WINDOW_CLOSE", "DOWNLOAD_RETRY", "INSTALL_COOLDOWN", "PACKAGE_EXPIRY", "PACKAGE_CLEANUP", "MANUAL_REARM", "RECONNECT", "LEGACY_INSTALL", "TYPE_DECLARE", "TRANSFER", "DISCONNECT", "TERMINAL_RETRY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DeadlineType extends Enum<DeadlineType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DeadlineType[] $VALUES = null;
    public static final DeadlineType DISCONNECT = null;
    public static final DeadlineType DOWNLOAD_RETRY = null;
    public static final DeadlineType INSTALL_COOLDOWN = null;
    public static final DeadlineType LEGACY_INSTALL = null;
    public static final DeadlineType MANUAL_REARM = null;
    public static final DeadlineType PACKAGE_CLEANUP = null;
    public static final DeadlineType PACKAGE_EXPIRY = null;
    public static final DeadlineType RECONNECT = null;
    public static final DeadlineType TERMINAL_RETRY = null;
    public static final DeadlineType TRANSFER = null;
    public static final DeadlineType TYPE_DECLARE = null;
    public static final DeadlineType WINDOW_CLOSE = null;
    public static final DeadlineType WINDOW_OPEN = null;

    public static EnumEntries<DeadlineType> getEntries() {
        return $ENTRIES;
    }

    static {
        DeadlineType r0 = new DeadlineType("WINDOW_OPEN", 0);
        WINDOW_OPEN = r0;
        DeadlineType r1 = new DeadlineType("WINDOW_CLOSE", 1);
        WINDOW_CLOSE = r1;
        DeadlineType r3 = new DeadlineType("DOWNLOAD_RETRY", 2);
        DOWNLOAD_RETRY = r3;
        DeadlineType r5 = new DeadlineType("INSTALL_COOLDOWN", 3);
        INSTALL_COOLDOWN = r5;
        DeadlineType r7 = new DeadlineType("PACKAGE_EXPIRY", 4);
        PACKAGE_EXPIRY = r7;
        DeadlineType r9 = new DeadlineType("PACKAGE_CLEANUP", 5);
        PACKAGE_CLEANUP = r9;
        DeadlineType r11 = new DeadlineType("MANUAL_REARM", 6);
        MANUAL_REARM = r11;
        DeadlineType r13 = new DeadlineType("RECONNECT", 7);
        RECONNECT = r13;
        DeadlineType r15 = new DeadlineType("LEGACY_INSTALL", 8);
        LEGACY_INSTALL = r15;
        DeadlineType r14 = new DeadlineType("TYPE_DECLARE", 9);
        TYPE_DECLARE = r14;
        DeadlineType r12 = new DeadlineType("TRANSFER", 10);
        TRANSFER = r12;
        DeadlineType r10 = new DeadlineType("DISCONNECT", 11);
        DISCONNECT = r10;
        DeadlineType r8 = new DeadlineType("TERMINAL_RETRY", 12);
        TERMINAL_RETRY = r8;
        DeadlineType[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        $VALUES = r6;
        $ENTRIES = EnumEntriesKt.enumEntries(r6);
    }

    public static DeadlineType[] values() {
        return (DeadlineType[]) $VALUES.clone();
    }

    public static DeadlineType valueOf(String r1) {
        return (DeadlineType) r27.a.a(DeadlineType.class, r1);
    }

    public DeadlineType(String r1, int r2) {
        super(r1, r2);
    }
}
