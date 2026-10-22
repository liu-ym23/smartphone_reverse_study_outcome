package com.larus.common_ui.dbx.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE_BUTTON", "BACKDROP", "DRAG_DOWN", "PROGRAMMATIC", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxPanelDismissReason extends Enum<DbxPanelDismissReason> {
    public static final DbxPanelDismissReason BACKDROP = null;
    public static final DbxPanelDismissReason CLOSE_BUTTON = null;
    public static final DbxPanelDismissReason DRAG_DOWN = null;
    public static final DbxPanelDismissReason PROGRAMMATIC = null;
    public static final /* synthetic */ DbxPanelDismissReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DbxPanelDismissReason> getEntries() {
        return b;
    }

    static {
        DbxPanelDismissReason r0 = new DbxPanelDismissReason("CLOSE_BUTTON", 0);
        CLOSE_BUTTON = r0;
        DbxPanelDismissReason r1 = new DbxPanelDismissReason("BACKDROP", 1);
        BACKDROP = r1;
        DbxPanelDismissReason r3 = new DbxPanelDismissReason("DRAG_DOWN", 2);
        DRAG_DOWN = r3;
        DbxPanelDismissReason r5 = new DbxPanelDismissReason("PROGRAMMATIC", 3);
        PROGRAMMATIC = r5;
        DbxPanelDismissReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DbxPanelDismissReason[] values() {
        return (DbxPanelDismissReason[]) a.clone();
    }

    public static DbxPanelDismissReason valueOf(String r1) {
        return (DbxPanelDismissReason) r27.a.a(DbxPanelDismissReason.class, r1);
    }

    public DbxPanelDismissReason(String r1, int r2) {
        super(r1, r2);
    }
}
