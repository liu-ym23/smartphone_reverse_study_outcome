package com.larus.drive.sdk.api.file.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/drive/sdk/api/file/list/RequestDriveFileListRankType;", "", "<init>", "(Ljava/lang/String;I)V", "ACCESS_TIME", "EDIT_TIME", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RequestDriveFileListRankType extends Enum<RequestDriveFileListRankType> {
    public static final RequestDriveFileListRankType ACCESS_TIME = null;
    public static final RequestDriveFileListRankType EDIT_TIME = null;
    public static final /* synthetic */ RequestDriveFileListRankType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RequestDriveFileListRankType> getEntries() {
        return b;
    }

    static {
        RequestDriveFileListRankType r0 = new RequestDriveFileListRankType("ACCESS_TIME", 0);
        ACCESS_TIME = r0;
        RequestDriveFileListRankType r1 = new RequestDriveFileListRankType("EDIT_TIME", 1);
        EDIT_TIME = r1;
        RequestDriveFileListRankType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RequestDriveFileListRankType[] values() {
        return (RequestDriveFileListRankType[]) a.clone();
    }

    public static RequestDriveFileListRankType valueOf(String r1) {
        return (RequestDriveFileListRankType) a.a(RequestDriveFileListRankType.class, r1);
    }

    public RequestDriveFileListRankType(String r1, int r2) {
        super(r1, r2);
    }
}
