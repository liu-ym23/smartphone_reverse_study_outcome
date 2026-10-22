package com.bytedance.android.live.revlink.link.core.layoutstatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static final boolean a(i r2) {
        if (r2 == null) goto L6;
        MainBackupStreamStatus r3 = r2.c;
        if (r3 == null) goto L6;
        Integer r4 = Integer.valueOf(r3.ordinal());
    L7:
        int r0 = MainBackupStreamStatus.MAIN_FLAG_WITH_MAIN_LINK_ID.ordinal();
        if (r4 != null) goto L11;
    L13:
        int r1 = MainBackupStreamStatus.BACKUP_FLAG_WITH_BACKUP_LINK_ID.ordinal();
        if (r4 != null) goto L17;
    L19:
        return false;
    L17:
        if (r4.intValue() != r1) goto L19;
    L18:
        return true;
    L11:
        if (r4.intValue() != r0) goto L13;
    L6:
        r4 = null;
        goto L7
    }
}
