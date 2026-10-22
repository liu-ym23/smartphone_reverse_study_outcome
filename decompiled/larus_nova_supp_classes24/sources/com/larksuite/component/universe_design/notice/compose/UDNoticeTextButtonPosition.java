package com.larksuite.component.universe_design.notice.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/notice/compose/UDNoticeTextButtonPosition;", "", "<init>", "(Ljava/lang/String;I)V", "Right", "Bottom", "Auto", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDNoticeTextButtonPosition extends Enum<UDNoticeTextButtonPosition> {
    public static final UDNoticeTextButtonPosition Auto = null;
    public static final UDNoticeTextButtonPosition Bottom = null;
    public static final UDNoticeTextButtonPosition Right = null;
    public static final /* synthetic */ UDNoticeTextButtonPosition[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDNoticeTextButtonPosition> getEntries() {
        return b;
    }

    static {
        UDNoticeTextButtonPosition r0 = new UDNoticeTextButtonPosition("Right", 0);
        Right = r0;
        UDNoticeTextButtonPosition r1 = new UDNoticeTextButtonPosition("Bottom", 1);
        Bottom = r1;
        UDNoticeTextButtonPosition r3 = new UDNoticeTextButtonPosition("Auto", 2);
        Auto = r3;
        UDNoticeTextButtonPosition[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UDNoticeTextButtonPosition[] values() {
        return (UDNoticeTextButtonPosition[]) a.clone();
    }

    public static UDNoticeTextButtonPosition valueOf(String r1) {
        return (UDNoticeTextButtonPosition) r27.a.a(UDNoticeTextButtonPosition.class, r1);
    }

    public UDNoticeTextButtonPosition(String r1, int r2) {
        super(r1, r2);
    }
}
