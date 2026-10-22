package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/api/IDoraService$Debug$FileTaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "START", "RUNNING", "PAUSED", "UPLOADING", "DONE", "FAILED", "CANCELED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IDoraService$Debug$FileTaskStatus extends Enum<IDoraService$Debug$FileTaskStatus> {
    public static final IDoraService$Debug$FileTaskStatus CANCELED = null;
    public static final IDoraService$Debug$FileTaskStatus DONE = null;
    public static final IDoraService$Debug$FileTaskStatus FAILED = null;
    public static final IDoraService$Debug$FileTaskStatus PAUSED = null;
    public static final IDoraService$Debug$FileTaskStatus PENDING = null;
    public static final IDoraService$Debug$FileTaskStatus RUNNING = null;
    public static final IDoraService$Debug$FileTaskStatus START = null;
    public static final IDoraService$Debug$FileTaskStatus UPLOADING = null;
    public static final /* synthetic */ IDoraService$Debug$FileTaskStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IDoraService$Debug$FileTaskStatus> getEntries() {
        return b;
    }

    static {
        IDoraService$Debug$FileTaskStatus r0 = new IDoraService$Debug$FileTaskStatus("PENDING", 0);
        PENDING = r0;
        IDoraService$Debug$FileTaskStatus r1 = new IDoraService$Debug$FileTaskStatus("START", 1);
        START = r1;
        IDoraService$Debug$FileTaskStatus r3 = new IDoraService$Debug$FileTaskStatus("RUNNING", 2);
        RUNNING = r3;
        IDoraService$Debug$FileTaskStatus r5 = new IDoraService$Debug$FileTaskStatus("PAUSED", 3);
        PAUSED = r5;
        IDoraService$Debug$FileTaskStatus r7 = new IDoraService$Debug$FileTaskStatus("UPLOADING", 4);
        UPLOADING = r7;
        IDoraService$Debug$FileTaskStatus r9 = new IDoraService$Debug$FileTaskStatus("DONE", 5);
        DONE = r9;
        IDoraService$Debug$FileTaskStatus r11 = new IDoraService$Debug$FileTaskStatus("FAILED", 6);
        FAILED = r11;
        IDoraService$Debug$FileTaskStatus r13 = new IDoraService$Debug$FileTaskStatus("CANCELED", 7);
        CANCELED = r13;
        IDoraService$Debug$FileTaskStatus[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static IDoraService$Debug$FileTaskStatus[] values() {
        return (IDoraService$Debug$FileTaskStatus[]) a.clone();
    }

    public static IDoraService$Debug$FileTaskStatus valueOf(String r1) {
        return (IDoraService$Debug$FileTaskStatus) a.a(IDoraService$Debug$FileTaskStatus.class, r1);
    }

    public IDoraService$Debug$FileTaskStatus(String r1, int r2) {
        super(r1, r2);
    }
}
