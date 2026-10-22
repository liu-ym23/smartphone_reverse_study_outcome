package com.ss.android.lark.picker.base.widget.constants;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/constants/PickerUseCategory;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "GROUP", "PROFILE", "LITTLE_APP", "CALENDAR", "SEARCH", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum PickerUseCategory extends Enum<PickerUseCategory> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PickerUseCategory[] $VALUES = null;
    public static final PickerUseCategory CALENDAR = null;
    public static final PickerUseCategory GROUP = null;
    public static final PickerUseCategory LITTLE_APP = null;
    public static final PickerUseCategory PROFILE = null;
    public static final PickerUseCategory SEARCH = null;
    public static final PickerUseCategory UNKNOWN = null;

    private static final /* synthetic */ PickerUseCategory[] $values() {
        return new PickerUseCategory[]{UNKNOWN, GROUP, PROFILE, LITTLE_APP, CALENDAR, SEARCH};
    }

    public static EnumEntries<PickerUseCategory> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new PickerUseCategory("UNKNOWN", 0);
        GROUP = new PickerUseCategory("GROUP", 1);
        PROFILE = new PickerUseCategory("PROFILE", 2);
        LITTLE_APP = new PickerUseCategory("LITTLE_APP", 3);
        CALENDAR = new PickerUseCategory("CALENDAR", 4);
        SEARCH = new PickerUseCategory("SEARCH", 5);
        PickerUseCategory[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static PickerUseCategory[] values() {
        return (PickerUseCategory[]) $VALUES.clone();
    }

    public static PickerUseCategory valueOf(String r1) {
        return (PickerUseCategory) a.a(PickerUseCategory.class, r1);
    }

    private PickerUseCategory(String r1, int r2) {
        super(r1, r2);
    }
}
