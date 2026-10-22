package com.larus.common_ui.dbx.theme;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/dbx/theme/DbxTheme$Variant;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LIGHT", "DARK", "NONE", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxTheme$Variant extends Enum<DbxTheme$Variant> {
    public static final DbxTheme$Variant DARK = null;
    public static final DbxTheme$Variant DEFAULT = null;
    public static final DbxTheme$Variant LIGHT = null;
    public static final DbxTheme$Variant NONE = null;
    public static final /* synthetic */ DbxTheme$Variant[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DbxTheme$Variant> getEntries() {
        return b;
    }

    static {
        DbxTheme$Variant r0 = new DbxTheme$Variant("DEFAULT", 0);
        DEFAULT = r0;
        DbxTheme$Variant r1 = new DbxTheme$Variant("LIGHT", 1);
        LIGHT = r1;
        DbxTheme$Variant r3 = new DbxTheme$Variant("DARK", 2);
        DARK = r3;
        DbxTheme$Variant r5 = new DbxTheme$Variant("NONE", 3);
        NONE = r5;
        DbxTheme$Variant[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DbxTheme$Variant[] values() {
        return (DbxTheme$Variant[]) a.clone();
    }

    public static DbxTheme$Variant valueOf(String r1) {
        return (DbxTheme$Variant) r27.a.a(DbxTheme$Variant.class, r1);
    }

    public DbxTheme$Variant(String r1, int r2) {
        super(r1, r2);
    }
}
