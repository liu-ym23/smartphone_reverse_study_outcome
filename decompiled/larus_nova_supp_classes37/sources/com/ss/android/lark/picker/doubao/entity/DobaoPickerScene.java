package com.ss.android.lark.picker.doubao.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/DobaoPickerScene;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "YUNPAN_SEARCH", "SELECT_FILE", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum DobaoPickerScene extends Enum<DobaoPickerScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DobaoPickerScene[] $VALUES = null;
    public static final DobaoPickerScene SELECT_FILE = null;
    public static final DobaoPickerScene UNKNOWN = null;
    public static final DobaoPickerScene YUNPAN_SEARCH = null;

    private static final /* synthetic */ DobaoPickerScene[] $values() {
        return new DobaoPickerScene[]{UNKNOWN, YUNPAN_SEARCH, SELECT_FILE};
    }

    public static EnumEntries<DobaoPickerScene> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new DobaoPickerScene("UNKNOWN", 0);
        YUNPAN_SEARCH = new DobaoPickerScene("YUNPAN_SEARCH", 1);
        SELECT_FILE = new DobaoPickerScene("SELECT_FILE", 2);
        DobaoPickerScene[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static DobaoPickerScene[] values() {
        return (DobaoPickerScene[]) $VALUES.clone();
    }

    public static DobaoPickerScene valueOf(String r1) {
        return (DobaoPickerScene) a.a(DobaoPickerScene.class, r1);
    }

    private DobaoPickerScene(String r1, int r2) {
        super(r1, r2);
    }
}
