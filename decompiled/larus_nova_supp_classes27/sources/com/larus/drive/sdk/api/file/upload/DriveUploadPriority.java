package com.larus.drive.sdk.api.file.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/drive/sdk/api/file/upload/DriveUploadPriority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOWEST", "LOW", "NORMAL", "HIGH", "HIGHEST", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveUploadPriority extends Enum<DriveUploadPriority> {
    public static final DriveUploadPriority HIGH = null;
    public static final DriveUploadPriority HIGHEST = null;
    public static final DriveUploadPriority LOW = null;
    public static final DriveUploadPriority LOWEST = null;
    public static final DriveUploadPriority NORMAL = null;
    public static final /* synthetic */ DriveUploadPriority[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<DriveUploadPriority> getEntries() {
        return b;
    }

    static {
        DriveUploadPriority r0 = new DriveUploadPriority("LOWEST", 0, -10);
        LOWEST = r0;
        DriveUploadPriority r1 = new DriveUploadPriority("LOW", 1, -5);
        LOW = r1;
        DriveUploadPriority r2 = new DriveUploadPriority("NORMAL", 2, 0);
        NORMAL = r2;
        DriveUploadPriority r4 = new DriveUploadPriority("HIGH", 3, 5);
        HIGH = r4;
        DriveUploadPriority r7 = new DriveUploadPriority("HIGHEST", 4, 10);
        HIGHEST = r7;
        DriveUploadPriority[] r9 = {r0, r1, r2, r4, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DriveUploadPriority[] values() {
        return (DriveUploadPriority[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DriveUploadPriority valueOf(String r1) {
        return (DriveUploadPriority) a.a(DriveUploadPriority.class, r1);
    }

    public DriveUploadPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
