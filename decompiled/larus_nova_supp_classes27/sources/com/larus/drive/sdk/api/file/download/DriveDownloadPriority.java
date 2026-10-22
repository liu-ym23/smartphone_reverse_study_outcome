package com.larus.drive.sdk.api.file.download;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/drive/sdk/api/file/download/DriveDownloadPriority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOWEST", "LOW", "NORMAL", "HIGH", "HIGHEST", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveDownloadPriority extends Enum<DriveDownloadPriority> {
    public static final DriveDownloadPriority HIGH = null;
    public static final DriveDownloadPriority HIGHEST = null;
    public static final DriveDownloadPriority LOW = null;
    public static final DriveDownloadPriority LOWEST = null;
    public static final DriveDownloadPriority NORMAL = null;
    public static final /* synthetic */ DriveDownloadPriority[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<DriveDownloadPriority> getEntries() {
        return b;
    }

    static {
        DriveDownloadPriority r0 = new DriveDownloadPriority("LOWEST", 0, -10);
        LOWEST = r0;
        DriveDownloadPriority r1 = new DriveDownloadPriority("LOW", 1, -5);
        LOW = r1;
        DriveDownloadPriority r2 = new DriveDownloadPriority("NORMAL", 2, 0);
        NORMAL = r2;
        DriveDownloadPriority r4 = new DriveDownloadPriority("HIGH", 3, 5);
        HIGH = r4;
        DriveDownloadPriority r7 = new DriveDownloadPriority("HIGHEST", 4, 10);
        HIGHEST = r7;
        DriveDownloadPriority[] r9 = {r0, r1, r2, r4, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DriveDownloadPriority[] values() {
        return (DriveDownloadPriority[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DriveDownloadPriority valueOf(String r1) {
        return (DriveDownloadPriority) a.a(DriveDownloadPriority.class, r1);
    }

    public DriveDownloadPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
