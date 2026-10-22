package com.larksuite.component.universe_design.notice.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/notice/compose/UDNoticeGravity;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "Center", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDNoticeGravity extends Enum<UDNoticeGravity> {
    public static final UDNoticeGravity Center = null;
    public static final UDNoticeGravity Left = null;
    public static final /* synthetic */ UDNoticeGravity[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDNoticeGravity> getEntries() {
        return b;
    }

    static {
        UDNoticeGravity r0 = new UDNoticeGravity("Left", 0);
        Left = r0;
        UDNoticeGravity r1 = new UDNoticeGravity("Center", 1);
        Center = r1;
        UDNoticeGravity[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static UDNoticeGravity[] values() {
        return (UDNoticeGravity[]) a.clone();
    }

    public static UDNoticeGravity valueOf(String r1) {
        return (UDNoticeGravity) r27.a.a(UDNoticeGravity.class, r1);
    }

    public UDNoticeGravity(String r1, int r2) {
        super(r1, r2);
    }
}
