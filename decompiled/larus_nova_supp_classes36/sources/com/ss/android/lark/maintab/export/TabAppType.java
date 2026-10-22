package com.ss.android.lark.maintab.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "APP_TYPE_NATIVE", "APP_TYPE_MINI", "APP_TYPE_WEB", "APP_TYPE_CUSTOM_NATIVE", "APP_TYPE_OPEN_APP", "APP_TYPE_URL", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum TabAppType extends Enum<TabAppType> {
    public static final TabAppType APP_TYPE_CUSTOM_NATIVE = null;
    public static final TabAppType APP_TYPE_MINI = null;
    public static final TabAppType APP_TYPE_NATIVE = null;
    public static final TabAppType APP_TYPE_OPEN_APP = null;
    public static final TabAppType APP_TYPE_URL = null;
    public static final TabAppType APP_TYPE_WEB = null;
    public static final /* synthetic */ TabAppType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<TabAppType> getEntries() {
        return b;
    }

    static {
        TabAppType r0 = new TabAppType("APP_TYPE_NATIVE", 0, 1);
        APP_TYPE_NATIVE = r0;
        TabAppType r1 = new TabAppType("APP_TYPE_MINI", 1, 2);
        APP_TYPE_MINI = r1;
        TabAppType r4 = new TabAppType("APP_TYPE_WEB", 2, 3);
        APP_TYPE_WEB = r4;
        TabAppType r6 = new TabAppType("APP_TYPE_CUSTOM_NATIVE", 3, 4);
        APP_TYPE_CUSTOM_NATIVE = r6;
        TabAppType r8 = new TabAppType("APP_TYPE_OPEN_APP", 4, 5);
        APP_TYPE_OPEN_APP = r8;
        TabAppType r10 = new TabAppType("APP_TYPE_URL", 5, 6);
        APP_TYPE_URL = r10;
        TabAppType[] r12 = {r0, r1, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static TabAppType[] values() {
        return (TabAppType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TabAppType valueOf(String r1) {
        return (TabAppType) r27.a.a(TabAppType.class, r1);
    }

    public TabAppType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
