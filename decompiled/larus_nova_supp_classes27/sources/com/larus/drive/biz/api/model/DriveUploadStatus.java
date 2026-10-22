package com.larus.drive.biz.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/drive/biz/api/model/DriveUploadStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNSTARTED", "UPLOADING", "FINISH", "FAILED", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveUploadStatus extends Enum<DriveUploadStatus> {
    public static final a Companion = null;
    public static final DriveUploadStatus FAILED = null;
    public static final DriveUploadStatus FINISH = null;
    public static final DriveUploadStatus UNSTARTED = null;
    public static final DriveUploadStatus UPLOADING = null;
    public static final /* synthetic */ DriveUploadStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DriveUploadStatus> getEntries() {
        return b;
    }

    static {
        DriveUploadStatus r0 = new DriveUploadStatus("UNSTARTED", 0, "unstarted");
        UNSTARTED = r0;
        DriveUploadStatus r1 = new DriveUploadStatus("UPLOADING", 1, "uploading");
        UPLOADING = r1;
        DriveUploadStatus r3 = new DriveUploadStatus("FINISH", 2, "finish");
        FINISH = r3;
        DriveUploadStatus r5 = new DriveUploadStatus("FAILED", 3, "failed");
        FAILED = r5;
        DriveUploadStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static DriveUploadStatus[] values() {
        return (DriveUploadStatus[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DriveUploadStatus valueOf(String r1) {
        return (DriveUploadStatus) r27.a.a(DriveUploadStatus.class, r1);
    }

    public DriveUploadStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
