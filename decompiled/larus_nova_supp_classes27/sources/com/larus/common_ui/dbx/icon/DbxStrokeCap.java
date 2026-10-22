package com.larus.common_ui.dbx.icon;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/dbx/icon/DbxStrokeCap;", "", "<init>", "(Ljava/lang/String;I)V", "BUTT", "ROUND", "SQUARE", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxStrokeCap extends Enum<DbxStrokeCap> {
    public static final DbxStrokeCap BUTT = null;
    public static final DbxStrokeCap ROUND = null;
    public static final DbxStrokeCap SQUARE = null;
    public static final /* synthetic */ DbxStrokeCap[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DbxStrokeCap> getEntries() {
        return b;
    }

    static {
        DbxStrokeCap r0 = new DbxStrokeCap("BUTT", 0);
        BUTT = r0;
        DbxStrokeCap r1 = new DbxStrokeCap("ROUND", 1);
        ROUND = r1;
        DbxStrokeCap r3 = new DbxStrokeCap("SQUARE", 2);
        SQUARE = r3;
        DbxStrokeCap[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DbxStrokeCap[] values() {
        return (DbxStrokeCap[]) a.clone();
    }

    public static DbxStrokeCap valueOf(String r1) {
        return (DbxStrokeCap) a.a(DbxStrokeCap.class, r1);
    }

    public DbxStrokeCap(String r1, int r2) {
        super(r1, r2);
    }
}
