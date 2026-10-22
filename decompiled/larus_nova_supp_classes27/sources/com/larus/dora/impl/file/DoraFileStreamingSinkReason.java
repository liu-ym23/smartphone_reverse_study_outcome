package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/file/DoraFileStreamingSinkReason;", "", "<init>", "(Ljava/lang/String;I)V", "START", "ERROR", "INCOMPLETED", "PAUSED", "FIRST_FRAME_TIMEOUT", "DONE", "NO_ENOUGH_SPACE", "MD5_CHECK_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraFileStreamingSinkReason extends Enum<DoraFileStreamingSinkReason> {
    public static final DoraFileStreamingSinkReason DONE = null;
    public static final DoraFileStreamingSinkReason ERROR = null;
    public static final DoraFileStreamingSinkReason FIRST_FRAME_TIMEOUT = null;
    public static final DoraFileStreamingSinkReason INCOMPLETED = null;
    public static final DoraFileStreamingSinkReason MD5_CHECK_FAILED = null;
    public static final DoraFileStreamingSinkReason NO_ENOUGH_SPACE = null;
    public static final DoraFileStreamingSinkReason PAUSED = null;
    public static final DoraFileStreamingSinkReason START = null;
    public static final /* synthetic */ DoraFileStreamingSinkReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraFileStreamingSinkReason> getEntries() {
        return b;
    }

    static {
        DoraFileStreamingSinkReason r0 = new DoraFileStreamingSinkReason("START", 0);
        START = r0;
        DoraFileStreamingSinkReason r1 = new DoraFileStreamingSinkReason("ERROR", 1);
        ERROR = r1;
        DoraFileStreamingSinkReason r3 = new DoraFileStreamingSinkReason("INCOMPLETED", 2);
        INCOMPLETED = r3;
        DoraFileStreamingSinkReason r5 = new DoraFileStreamingSinkReason("PAUSED", 3);
        PAUSED = r5;
        DoraFileStreamingSinkReason r7 = new DoraFileStreamingSinkReason("FIRST_FRAME_TIMEOUT", 4);
        FIRST_FRAME_TIMEOUT = r7;
        DoraFileStreamingSinkReason r9 = new DoraFileStreamingSinkReason("DONE", 5);
        DONE = r9;
        DoraFileStreamingSinkReason r11 = new DoraFileStreamingSinkReason("NO_ENOUGH_SPACE", 6);
        NO_ENOUGH_SPACE = r11;
        DoraFileStreamingSinkReason r13 = new DoraFileStreamingSinkReason("MD5_CHECK_FAILED", 7);
        MD5_CHECK_FAILED = r13;
        DoraFileStreamingSinkReason[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static DoraFileStreamingSinkReason[] values() {
        return (DoraFileStreamingSinkReason[]) a.clone();
    }

    public static DoraFileStreamingSinkReason valueOf(String r1) {
        return (DoraFileStreamingSinkReason) r27.a.a(DoraFileStreamingSinkReason.class, r1);
    }

    public DoraFileStreamingSinkReason(String r1, int r2) {
        super(r1, r2);
    }
}
