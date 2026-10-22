package com.ss.android.lark.maintab.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabScreenStyle;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "TAB_FULL_WITH_AUTO_SPLIT", "FULLSCREEN", "FULLSCREEN_IMMERSIVE", "PAGE_FULL_WITH_AUTO_SPLIT", "ONLY_TAB_FULL_WITH_ALL_PAGE_FULL", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum TabScreenStyle extends Enum<TabScreenStyle> {
    public static final TabScreenStyle DEFAULT = null;
    public static final TabScreenStyle FULLSCREEN = null;
    public static final TabScreenStyle FULLSCREEN_IMMERSIVE = null;
    public static final TabScreenStyle ONLY_TAB_FULL_WITH_ALL_PAGE_FULL = null;
    public static final TabScreenStyle PAGE_FULL_WITH_AUTO_SPLIT = null;
    public static final TabScreenStyle TAB_FULL_WITH_AUTO_SPLIT = null;
    public static final /* synthetic */ TabScreenStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TabScreenStyle> getEntries() {
        return b;
    }

    static {
        TabScreenStyle r0 = new TabScreenStyle("DEFAULT", 0);
        DEFAULT = r0;
        TabScreenStyle r1 = new TabScreenStyle("TAB_FULL_WITH_AUTO_SPLIT", 1);
        TAB_FULL_WITH_AUTO_SPLIT = r1;
        TabScreenStyle r3 = new TabScreenStyle("FULLSCREEN", 2);
        FULLSCREEN = r3;
        TabScreenStyle r5 = new TabScreenStyle("FULLSCREEN_IMMERSIVE", 3);
        FULLSCREEN_IMMERSIVE = r5;
        TabScreenStyle r7 = new TabScreenStyle("PAGE_FULL_WITH_AUTO_SPLIT", 4);
        PAGE_FULL_WITH_AUTO_SPLIT = r7;
        TabScreenStyle r9 = new TabScreenStyle("ONLY_TAB_FULL_WITH_ALL_PAGE_FULL", 5);
        ONLY_TAB_FULL_WITH_ALL_PAGE_FULL = r9;
        TabScreenStyle[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static TabScreenStyle[] values() {
        return (TabScreenStyle[]) a.clone();
    }

    public static TabScreenStyle valueOf(String r1) {
        return (TabScreenStyle) r27.a.a(TabScreenStyle.class, r1);
    }

    public TabScreenStyle(String r1, int r2) {
        super(r1, r2);
    }
}
