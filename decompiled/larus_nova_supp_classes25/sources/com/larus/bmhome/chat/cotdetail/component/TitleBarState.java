package com.larus.bmhome.chat.cotdetail.component;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/TitleBarState;", "", "<init>", "(Ljava/lang/String;I)V", "SHARE", "STREAMING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum TitleBarState extends Enum<TitleBarState> {
    public static final TitleBarState SHARE = null;
    public static final TitleBarState STREAMING = null;
    public static final /* synthetic */ TitleBarState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TitleBarState> getEntries() {
        return b;
    }

    static {
        TitleBarState r0 = new TitleBarState("SHARE", 0);
        SHARE = r0;
        TitleBarState r1 = new TitleBarState("STREAMING", 1);
        STREAMING = r1;
        TitleBarState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TitleBarState[] values() {
        return (TitleBarState[]) a.clone();
    }

    public static TitleBarState valueOf(String r1) {
        return (TitleBarState) r27.a.a(TitleBarState.class, r1);
    }

    public TitleBarState(String r1, int r2) {
        super(r1, r2);
    }
}
