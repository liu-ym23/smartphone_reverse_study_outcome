package com.bytedance.android.live.revlink.link.core.layoutstatus;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/layoutstatus/MainBackupStreamStatus;", "", "", "getRefreshReason", "BACKUP_FLAG_WITH_MAIN_LINK_ID", "MAIN_FLAG_WITH_BACKUP_LINK_ID", "MAIN_FLAG_WITH_MAIN_LINK_ID", "BACKUP_FLAG_WITH_BACKUP_LINK_ID", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MainBackupStreamStatus extends Enum<MainBackupStreamStatus> {
    public static final MainBackupStreamStatus BACKUP_FLAG_WITH_BACKUP_LINK_ID = null;
    public static final MainBackupStreamStatus BACKUP_FLAG_WITH_MAIN_LINK_ID = null;
    public static final MainBackupStreamStatus MAIN_FLAG_WITH_BACKUP_LINK_ID = null;
    public static final MainBackupStreamStatus MAIN_FLAG_WITH_MAIN_LINK_ID = null;
    public static final /* synthetic */ MainBackupStreamStatus[] a = null;

    static {
        MainBackupStreamStatus r1 = new MainBackupStreamStatus("BACKUP_FLAG_WITH_MAIN_LINK_ID", 0);
        BACKUP_FLAG_WITH_MAIN_LINK_ID = r1;
        MainBackupStreamStatus r2 = new MainBackupStreamStatus("MAIN_FLAG_WITH_BACKUP_LINK_ID", 1);
        MAIN_FLAG_WITH_BACKUP_LINK_ID = r2;
        MainBackupStreamStatus r3 = new MainBackupStreamStatus("MAIN_FLAG_WITH_MAIN_LINK_ID", 2);
        MAIN_FLAG_WITH_MAIN_LINK_ID = r3;
        MainBackupStreamStatus r4 = new MainBackupStreamStatus("BACKUP_FLAG_WITH_BACKUP_LINK_ID", 3);
        BACKUP_FLAG_WITH_BACKUP_LINK_ID = r4;
        a = new MainBackupStreamStatus[]{r1, r2, r3, r4};
    }

    public static MainBackupStreamStatus valueOf(String r1) {
        return (MainBackupStreamStatus) r27.a.a(MainBackupStreamStatus.class, r1);
    }

    public static MainBackupStreamStatus[] values() {
        return (MainBackupStreamStatus[]) a.clone();
    }

    public final String getRefreshReason() {
        if (this != MAIN_FLAG_WITH_MAIN_LINK_ID) goto L7;
        return "handleRefreshMainStream";
    L7:
        if (this != BACKUP_FLAG_WITH_BACKUP_LINK_ID) goto L11;
        return "handleRefreshBackStream";
    L11:
        if (this != MAIN_FLAG_WITH_BACKUP_LINK_ID) goto L15;
        return "MAIN_FLAG_WITH_BACKUP_LINK_ID";
    L15:
        if (this != BACKUP_FLAG_WITH_MAIN_LINK_ID) goto L18;
        return "BACKUP_FLAG_WITH_MAIN_LINK_ID";
    L18:
        return "";
    }

    public MainBackupStreamStatus(String r1, int r2) {
        super(r1, r2);
    }
}
