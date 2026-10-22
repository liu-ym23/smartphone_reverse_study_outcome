package com.larus.drive.sdk.api.file.download;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/drive/sdk/api/file/download/DriveDownloadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNSTARTED", "DOWNLOADING", "FINISH", "CANCELED", "FAILED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveDownloadStatus extends Enum<DriveDownloadStatus> {
    public static final DriveDownloadStatus CANCELED = null;
    public static final DriveDownloadStatus DOWNLOADING = null;
    public static final DriveDownloadStatus FAILED = null;
    public static final DriveDownloadStatus FINISH = null;
    public static final DriveDownloadStatus UNSTARTED = null;
    public static final /* synthetic */ DriveDownloadStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DriveDownloadStatus> getEntries() {
        return b;
    }

    static {
        DriveDownloadStatus r0 = new DriveDownloadStatus("UNSTARTED", 0);
        UNSTARTED = r0;
        DriveDownloadStatus r1 = new DriveDownloadStatus("DOWNLOADING", 1);
        DOWNLOADING = r1;
        DriveDownloadStatus r3 = new DriveDownloadStatus("FINISH", 2);
        FINISH = r3;
        DriveDownloadStatus r5 = new DriveDownloadStatus("CANCELED", 3);
        CANCELED = r5;
        DriveDownloadStatus r7 = new DriveDownloadStatus("FAILED", 4);
        FAILED = r7;
        DriveDownloadStatus[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DriveDownloadStatus[] values() {
        return (DriveDownloadStatus[]) a.clone();
    }

    public static DriveDownloadStatus valueOf(String r1) {
        return (DriveDownloadStatus) a.a(DriveDownloadStatus.class, r1);
    }

    public DriveDownloadStatus(String r1, int r2) {
        super(r1, r2);
    }
}
