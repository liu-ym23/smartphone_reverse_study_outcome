package com.ss.android.lark.picker.base.widget.constants;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/constants/PickerUsePage;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CREATE_GROUP_FROM_FEED_AND_SHARE", "CREATE_GROUP_FROM_P2P", "GROUP_ADD_MEMBER_AND_SEND_PROFILE", "LITTLE_APP_PICK_USER", "CALENDAR_ADD_ATTENDEE", "SEARCH", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum PickerUsePage extends Enum<PickerUsePage> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PickerUsePage[] $VALUES = null;
    public static final PickerUsePage CALENDAR_ADD_ATTENDEE = null;
    public static final PickerUsePage CREATE_GROUP_FROM_FEED_AND_SHARE = null;
    public static final PickerUsePage CREATE_GROUP_FROM_P2P = null;
    public static final PickerUsePage GROUP_ADD_MEMBER_AND_SEND_PROFILE = null;
    public static final PickerUsePage LITTLE_APP_PICK_USER = null;
    public static final PickerUsePage SEARCH = null;
    public static final PickerUsePage UNKNOWN = null;

    private static final /* synthetic */ PickerUsePage[] $values() {
        return new PickerUsePage[]{UNKNOWN, CREATE_GROUP_FROM_FEED_AND_SHARE, CREATE_GROUP_FROM_P2P, GROUP_ADD_MEMBER_AND_SEND_PROFILE, LITTLE_APP_PICK_USER, CALENDAR_ADD_ATTENDEE, SEARCH};
    }

    public static EnumEntries<PickerUsePage> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new PickerUsePage("UNKNOWN", 0);
        CREATE_GROUP_FROM_FEED_AND_SHARE = new PickerUsePage("CREATE_GROUP_FROM_FEED_AND_SHARE", 1);
        CREATE_GROUP_FROM_P2P = new PickerUsePage("CREATE_GROUP_FROM_P2P", 2);
        GROUP_ADD_MEMBER_AND_SEND_PROFILE = new PickerUsePage("GROUP_ADD_MEMBER_AND_SEND_PROFILE", 3);
        LITTLE_APP_PICK_USER = new PickerUsePage("LITTLE_APP_PICK_USER", 4);
        CALENDAR_ADD_ATTENDEE = new PickerUsePage("CALENDAR_ADD_ATTENDEE", 5);
        SEARCH = new PickerUsePage("SEARCH", 6);
        PickerUsePage[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static PickerUsePage[] values() {
        return (PickerUsePage[]) $VALUES.clone();
    }

    public static PickerUsePage valueOf(String r1) {
        return (PickerUsePage) a.a(PickerUsePage.class, r1);
    }

    private PickerUsePage(String r1, int r2) {
        super(r1, r2);
    }
}
