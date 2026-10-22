package com.larus.disk.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class IAppDiskServiceImpl$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AppDiskManager$CleanExecutionStatus.values().length];
        r0[AppDiskManager$CleanExecutionStatus.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
    L21:
        r0[AppDiskManager$CleanExecutionStatus.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
    L31:
        r0[AppDiskManager$CleanExecutionStatus.TASK_RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[AppDiskManager$CleanExecutionStatus.ACCOUNT_CHANGED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
    L25:
        r0[AppDiskManager$CleanExecutionStatus.APP_FOREGROUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
    L19:
        r0[AppDiskManager$CleanExecutionStatus.PARTIAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
    L27:
        r0[AppDiskManager$CleanExecutionStatus.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
    L10:
        a = r0;
    }
}
