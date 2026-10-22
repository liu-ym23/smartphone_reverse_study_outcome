package com.ss.android.lark.maintab.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/maintab/export/MainTabNavigationMode;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM_MODE", "LEFT_NARROW_MODE", "LEFT_WIDE_MODE", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum MainTabNavigationMode extends Enum<MainTabNavigationMode> {
    public static final MainTabNavigationMode BOTTOM_MODE = null;
    public static final MainTabNavigationMode LEFT_NARROW_MODE = null;
    public static final MainTabNavigationMode LEFT_WIDE_MODE = null;
    public static final /* synthetic */ MainTabNavigationMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MainTabNavigationMode> getEntries() {
        return b;
    }

    static {
        MainTabNavigationMode r0 = new MainTabNavigationMode("BOTTOM_MODE", 0);
        BOTTOM_MODE = r0;
        MainTabNavigationMode r1 = new MainTabNavigationMode("LEFT_NARROW_MODE", 1);
        LEFT_NARROW_MODE = r1;
        MainTabNavigationMode r3 = new MainTabNavigationMode("LEFT_WIDE_MODE", 2);
        LEFT_WIDE_MODE = r3;
        MainTabNavigationMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MainTabNavigationMode[] values() {
        return (MainTabNavigationMode[]) a.clone();
    }

    public static MainTabNavigationMode valueOf(String r1) {
        return (MainTabNavigationMode) r27.a.a(MainTabNavigationMode.class, r1);
    }

    public MainTabNavigationMode(String r1, int r2) {
        super(r1, r2);
    }
}
