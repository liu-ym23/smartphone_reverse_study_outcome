package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/disk/impl/AppDiskManager$CleanExecutionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "COMPLETED", "PARTIAL", "DISABLED", "TASK_RUNNING", "ACCOUNT_CHANGED", "APP_FOREGROUND", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppDiskManager$CleanExecutionStatus extends Enum<AppDiskManager$CleanExecutionStatus> {
    public static final AppDiskManager$CleanExecutionStatus ACCOUNT_CHANGED = null;
    public static final AppDiskManager$CleanExecutionStatus APP_FOREGROUND = null;
    public static final AppDiskManager$CleanExecutionStatus COMPLETED = null;
    public static final AppDiskManager$CleanExecutionStatus DISABLED = null;
    public static final AppDiskManager$CleanExecutionStatus FAILED = null;
    public static final AppDiskManager$CleanExecutionStatus PARTIAL = null;
    public static final AppDiskManager$CleanExecutionStatus TASK_RUNNING = null;
    public static final /* synthetic */ AppDiskManager$CleanExecutionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AppDiskManager$CleanExecutionStatus> getEntries() {
        return b;
    }

    static {
        AppDiskManager$CleanExecutionStatus r0 = new AppDiskManager$CleanExecutionStatus("COMPLETED", 0);
        COMPLETED = r0;
        AppDiskManager$CleanExecutionStatus r1 = new AppDiskManager$CleanExecutionStatus("PARTIAL", 1);
        PARTIAL = r1;
        AppDiskManager$CleanExecutionStatus r3 = new AppDiskManager$CleanExecutionStatus("DISABLED", 2);
        DISABLED = r3;
        AppDiskManager$CleanExecutionStatus r5 = new AppDiskManager$CleanExecutionStatus("TASK_RUNNING", 3);
        TASK_RUNNING = r5;
        AppDiskManager$CleanExecutionStatus r7 = new AppDiskManager$CleanExecutionStatus("ACCOUNT_CHANGED", 4);
        ACCOUNT_CHANGED = r7;
        AppDiskManager$CleanExecutionStatus r9 = new AppDiskManager$CleanExecutionStatus("APP_FOREGROUND", 5);
        APP_FOREGROUND = r9;
        AppDiskManager$CleanExecutionStatus r11 = new AppDiskManager$CleanExecutionStatus("FAILED", 6);
        FAILED = r11;
        AppDiskManager$CleanExecutionStatus[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static AppDiskManager$CleanExecutionStatus[] values() {
        return (AppDiskManager$CleanExecutionStatus[]) a.clone();
    }

    public static AppDiskManager$CleanExecutionStatus valueOf(String r1) {
        return (AppDiskManager$CleanExecutionStatus) r27.a.a(AppDiskManager$CleanExecutionStatus.class, r1);
    }

    public AppDiskManager$CleanExecutionStatus(String r1, int r2) {
        super(r1, r2);
    }
}
