package com.larus.common_ui.dbx.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDetent;", "", "<init>", "(Ljava/lang/String;I)V", "MINIMUM", "MAXIMUM", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxPanelDetent extends Enum<DbxPanelDetent> {
    public static final DbxPanelDetent MAXIMUM = null;
    public static final DbxPanelDetent MINIMUM = null;
    public static final /* synthetic */ DbxPanelDetent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DbxPanelDetent> getEntries() {
        return b;
    }

    static {
        DbxPanelDetent r0 = new DbxPanelDetent("MINIMUM", 0);
        MINIMUM = r0;
        DbxPanelDetent r1 = new DbxPanelDetent("MAXIMUM", 1);
        MAXIMUM = r1;
        DbxPanelDetent[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DbxPanelDetent[] values() {
        return (DbxPanelDetent[]) a.clone();
    }

    public static DbxPanelDetent valueOf(String r1) {
        return (DbxPanelDetent) r27.a.a(DbxPanelDetent.class, r1);
    }

    public DbxPanelDetent(String r1, int r2) {
        super(r1, r2);
    }
}
