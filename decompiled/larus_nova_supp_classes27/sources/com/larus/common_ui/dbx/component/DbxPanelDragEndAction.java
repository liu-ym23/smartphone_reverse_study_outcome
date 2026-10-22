package com.larus.common_ui.dbx.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDragEndAction;", "", "<init>", "(Ljava/lang/String;I)V", "RESTORE", "MINIMUM", "MAXIMUM", "DISMISS", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxPanelDragEndAction extends Enum<DbxPanelDragEndAction> {
    public static final DbxPanelDragEndAction DISMISS = null;
    public static final DbxPanelDragEndAction MAXIMUM = null;
    public static final DbxPanelDragEndAction MINIMUM = null;
    public static final DbxPanelDragEndAction RESTORE = null;
    public static final /* synthetic */ DbxPanelDragEndAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DbxPanelDragEndAction> getEntries() {
        return b;
    }

    static {
        DbxPanelDragEndAction r0 = new DbxPanelDragEndAction("RESTORE", 0);
        RESTORE = r0;
        DbxPanelDragEndAction r1 = new DbxPanelDragEndAction("MINIMUM", 1);
        MINIMUM = r1;
        DbxPanelDragEndAction r3 = new DbxPanelDragEndAction("MAXIMUM", 2);
        MAXIMUM = r3;
        DbxPanelDragEndAction r5 = new DbxPanelDragEndAction("DISMISS", 3);
        DISMISS = r5;
        DbxPanelDragEndAction[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DbxPanelDragEndAction[] values() {
        return (DbxPanelDragEndAction[]) a.clone();
    }

    public static DbxPanelDragEndAction valueOf(String r1) {
        return (DbxPanelDragEndAction) r27.a.a(DbxPanelDragEndAction.class, r1);
    }

    public DbxPanelDragEndAction(String r1, int r2) {
        super(r1, r2);
    }
}
