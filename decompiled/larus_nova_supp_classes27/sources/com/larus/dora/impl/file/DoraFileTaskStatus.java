package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/file/DoraFileTaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "START", "RUNNING", "PAUSED", "UPLOADING", "DONE", "FAILED", "CANCELED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraFileTaskStatus extends Enum<DoraFileTaskStatus> {
    public static final DoraFileTaskStatus CANCELED = null;
    public static final DoraFileTaskStatus DONE = null;
    public static final DoraFileTaskStatus FAILED = null;
    public static final DoraFileTaskStatus PAUSED = null;
    public static final DoraFileTaskStatus PENDING = null;
    public static final DoraFileTaskStatus RUNNING = null;
    public static final DoraFileTaskStatus START = null;
    public static final DoraFileTaskStatus UPLOADING = null;
    public static final /* synthetic */ DoraFileTaskStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraFileTaskStatus> getEntries() {
        return b;
    }

    static {
        DoraFileTaskStatus r0 = new DoraFileTaskStatus("PENDING", 0);
        PENDING = r0;
        DoraFileTaskStatus r1 = new DoraFileTaskStatus("START", 1);
        START = r1;
        DoraFileTaskStatus r3 = new DoraFileTaskStatus("RUNNING", 2);
        RUNNING = r3;
        DoraFileTaskStatus r5 = new DoraFileTaskStatus("PAUSED", 3);
        PAUSED = r5;
        DoraFileTaskStatus r7 = new DoraFileTaskStatus("UPLOADING", 4);
        UPLOADING = r7;
        DoraFileTaskStatus r9 = new DoraFileTaskStatus("DONE", 5);
        DONE = r9;
        DoraFileTaskStatus r11 = new DoraFileTaskStatus("FAILED", 6);
        FAILED = r11;
        DoraFileTaskStatus r13 = new DoraFileTaskStatus("CANCELED", 7);
        CANCELED = r13;
        DoraFileTaskStatus[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static DoraFileTaskStatus[] values() {
        return (DoraFileTaskStatus[]) a.clone();
    }

    public static DoraFileTaskStatus valueOf(String r1) {
        return (DoraFileTaskStatus) r27.a.a(DoraFileTaskStatus.class, r1);
    }

    public DoraFileTaskStatus(String r1, int r2) {
        super(r1, r2);
    }
}
