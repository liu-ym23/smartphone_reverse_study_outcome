package com.ss.android.lark.maintab.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabSite;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN", "NAVIGATION", "TEMPORARY", "OTHER", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum TabSite extends Enum<TabSite> {
    public static final TabSite MAIN = null;
    public static final TabSite NAVIGATION = null;
    public static final TabSite OTHER = null;
    public static final TabSite TEMPORARY = null;
    public static final /* synthetic */ TabSite[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TabSite> getEntries() {
        return b;
    }

    static {
        TabSite r0 = new TabSite("MAIN", 0);
        MAIN = r0;
        TabSite r1 = new TabSite("NAVIGATION", 1);
        NAVIGATION = r1;
        TabSite r3 = new TabSite("TEMPORARY", 2);
        TEMPORARY = r3;
        TabSite r5 = new TabSite("OTHER", 3);
        OTHER = r5;
        TabSite[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static TabSite[] values() {
        return (TabSite[]) a.clone();
    }

    public static TabSite valueOf(String r1) {
        return (TabSite) r27.a.a(TabSite.class, r1);
    }

    public TabSite(String r1, int r2) {
        super(r1, r2);
    }
}
