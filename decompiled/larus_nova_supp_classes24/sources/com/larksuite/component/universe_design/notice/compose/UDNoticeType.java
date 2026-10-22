package com.larksuite.component.universe_design.notice.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/universe_design/notice/compose/UDNoticeType;", "", "<init>", "(Ljava/lang/String;I)V", "Info", "Success", "Warning", "Error", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDNoticeType extends Enum<UDNoticeType> {
    public static final UDNoticeType Error = null;
    public static final UDNoticeType Info = null;
    public static final UDNoticeType Success = null;
    public static final UDNoticeType Warning = null;
    public static final /* synthetic */ UDNoticeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDNoticeType> getEntries() {
        return b;
    }

    static {
        UDNoticeType r0 = new UDNoticeType("Info", 0);
        Info = r0;
        UDNoticeType r1 = new UDNoticeType("Success", 1);
        Success = r1;
        UDNoticeType r3 = new UDNoticeType("Warning", 2);
        Warning = r3;
        UDNoticeType r5 = new UDNoticeType("Error", 3);
        Error = r5;
        UDNoticeType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static UDNoticeType[] values() {
        return (UDNoticeType[]) a.clone();
    }

    public static UDNoticeType valueOf(String r1) {
        return (UDNoticeType) r27.a.a(UDNoticeType.class, r1);
    }

    public UDNoticeType(String r1, int r2) {
        super(r1, r2);
    }
}
