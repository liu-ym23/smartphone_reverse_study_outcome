package com.ss.android.lark.maintab.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabIconStyle;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CENTER", "FULL", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum TabIconStyle extends Enum<TabIconStyle> {
    public static final TabIconStyle CENTER = null;
    public static final TabIconStyle FULL = null;
    public static final TabIconStyle UNKNOWN = null;
    public static final /* synthetic */ TabIconStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TabIconStyle> getEntries() {
        return b;
    }

    static {
        TabIconStyle r0 = new TabIconStyle("UNKNOWN", 0);
        UNKNOWN = r0;
        TabIconStyle r1 = new TabIconStyle("CENTER", 1);
        CENTER = r1;
        TabIconStyle r3 = new TabIconStyle("FULL", 2);
        FULL = r3;
        TabIconStyle[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TabIconStyle[] values() {
        return (TabIconStyle[]) a.clone();
    }

    public static TabIconStyle valueOf(String r1) {
        return (TabIconStyle) r27.a.a(TabIconStyle.class, r1);
    }

    public TabIconStyle(String r1, int r2) {
        super(r1, r2);
    }
}
