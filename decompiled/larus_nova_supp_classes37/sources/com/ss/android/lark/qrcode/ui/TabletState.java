package com.ss.android.lark.qrcode.ui;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/qrcode/ui/TabletState;", "", "<init>", "(Ljava/lang/String;I)V", "NULL", "ROTATION_90", "ROTATION_270", "qrcode_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum TabletState extends Enum<TabletState> {
    public static final TabletState NULL = null;
    public static final TabletState ROTATION_270 = null;
    public static final TabletState ROTATION_90 = null;
    public static final /* synthetic */ TabletState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TabletState> getEntries() {
        return b;
    }

    static {
        TabletState r0 = new TabletState("NULL", 0);
        NULL = r0;
        TabletState r1 = new TabletState("ROTATION_90", 1);
        ROTATION_90 = r1;
        TabletState r3 = new TabletState("ROTATION_270", 2);
        ROTATION_270 = r3;
        TabletState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TabletState[] values() {
        return (TabletState[]) a.clone();
    }

    public static TabletState valueOf(String r1) {
        return (TabletState) r27.a.a(TabletState.class, r1);
    }

    public TabletState(String r1, int r2) {
        super(r1, r2);
    }
}
