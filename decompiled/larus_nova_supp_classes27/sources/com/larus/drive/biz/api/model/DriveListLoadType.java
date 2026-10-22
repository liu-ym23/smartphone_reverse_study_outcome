package com.larus.drive.biz.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/drive/biz/api/model/DriveListLoadType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RECENT", "FOLDER", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveListLoadType extends Enum<DriveListLoadType> {
    public static final a Companion = null;
    public static final DriveListLoadType FOLDER = null;
    public static final DriveListLoadType RECENT = null;
    public static final /* synthetic */ DriveListLoadType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<DriveListLoadType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.drive.biz.api.model.DriveListLoadType$a] */
    static {
        DriveListLoadType r0 = new DriveListLoadType("RECENT", 0, "recent");
        RECENT = r0;
        DriveListLoadType r1 = new DriveListLoadType("FOLDER", 1, "folder");
        FOLDER = r1;
        DriveListLoadType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static DriveListLoadType[] values() {
        return (DriveListLoadType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DriveListLoadType valueOf(String r1) {
        return (DriveListLoadType) r27.a.a(DriveListLoadType.class, r1);
    }

    public DriveListLoadType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
