package com.larus.common_ui.dbx.icon;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/dbx/icon/DbxStrokeJoin;", "", "<init>", "(Ljava/lang/String;I)V", "MITER", "ROUND", "BEVEL", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxStrokeJoin extends Enum<DbxStrokeJoin> {
    public static final DbxStrokeJoin BEVEL = null;
    public static final DbxStrokeJoin MITER = null;
    public static final DbxStrokeJoin ROUND = null;
    public static final /* synthetic */ DbxStrokeJoin[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DbxStrokeJoin> getEntries() {
        return b;
    }

    static {
        DbxStrokeJoin r0 = new DbxStrokeJoin("MITER", 0);
        MITER = r0;
        DbxStrokeJoin r1 = new DbxStrokeJoin("ROUND", 1);
        ROUND = r1;
        DbxStrokeJoin r3 = new DbxStrokeJoin("BEVEL", 2);
        BEVEL = r3;
        DbxStrokeJoin[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DbxStrokeJoin[] values() {
        return (DbxStrokeJoin[]) a.clone();
    }

    public static DbxStrokeJoin valueOf(String r1) {
        return (DbxStrokeJoin) a.a(DbxStrokeJoin.class, r1);
    }

    public DbxStrokeJoin(String r1, int r2) {
        super(r1, r2);
    }
}
