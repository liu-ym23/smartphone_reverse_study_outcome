package com.larus.bmhome.chat.manager;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/manager/NavigationSideBarState;", "", "state", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getState", "()Ljava/lang/String;", "YES", "NO", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum NavigationSideBarState extends Enum<NavigationSideBarState> {
    public static final NavigationSideBarState NO = null;
    public static final NavigationSideBarState YES = null;
    public static final /* synthetic */ NavigationSideBarState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String state;

    public static EnumEntries<NavigationSideBarState> getEntries() {
        return b;
    }

    static {
        NavigationSideBarState r0 = new NavigationSideBarState("YES", 0, "1");
        YES = r0;
        NavigationSideBarState r1 = new NavigationSideBarState("NO", 1, "0");
        NO = r1;
        NavigationSideBarState[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static NavigationSideBarState[] values() {
        return (NavigationSideBarState[]) a.clone();
    }

    public final String getState() {
        return this.state;
    }

    public static NavigationSideBarState valueOf(String r1) {
        return (NavigationSideBarState) r27.a.a(NavigationSideBarState.class, r1);
    }

    public NavigationSideBarState(String r1, int r2, String r3) {
        super(r1, r2);
        this.state = r3;
    }
}
