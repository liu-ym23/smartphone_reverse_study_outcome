package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmSwitchViewStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SWITCH_ONLY", "SWITCH_HINT", "ICON_ONLY", "ICON_HINT", "CONTENT_ONLY", "CONTENT_HINT", "CHECK_ONLY", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSwitchViewStyle extends Enum<MmSwitchViewStyle> {
    public static final MmSwitchViewStyle CHECK_ONLY = null;
    public static final MmSwitchViewStyle CONTENT_HINT = null;
    public static final MmSwitchViewStyle CONTENT_ONLY = null;
    public static final MmSwitchViewStyle ICON_HINT = null;
    public static final MmSwitchViewStyle ICON_ONLY = null;
    public static final MmSwitchViewStyle SWITCH_HINT = null;
    public static final MmSwitchViewStyle SWITCH_ONLY = null;
    public static final /* synthetic */ MmSwitchViewStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmSwitchViewStyle> getEntries() {
        return b;
    }

    static {
        MmSwitchViewStyle r0 = new MmSwitchViewStyle("SWITCH_ONLY", 0, 0);
        SWITCH_ONLY = r0;
        MmSwitchViewStyle r1 = new MmSwitchViewStyle("SWITCH_HINT", 1, 1);
        SWITCH_HINT = r1;
        MmSwitchViewStyle r3 = new MmSwitchViewStyle("ICON_ONLY", 2, 2);
        ICON_ONLY = r3;
        MmSwitchViewStyle r5 = new MmSwitchViewStyle("ICON_HINT", 3, 3);
        ICON_HINT = r5;
        MmSwitchViewStyle r7 = new MmSwitchViewStyle("CONTENT_ONLY", 4, 4);
        CONTENT_ONLY = r7;
        MmSwitchViewStyle r9 = new MmSwitchViewStyle("CONTENT_HINT", 5, 5);
        CONTENT_HINT = r9;
        MmSwitchViewStyle r11 = new MmSwitchViewStyle("CHECK_ONLY", 6, 6);
        CHECK_ONLY = r11;
        MmSwitchViewStyle[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static MmSwitchViewStyle[] values() {
        return (MmSwitchViewStyle[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmSwitchViewStyle valueOf(String r1) {
        return (MmSwitchViewStyle) r27.a.a(MmSwitchViewStyle.class, r1);
    }

    public MmSwitchViewStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
