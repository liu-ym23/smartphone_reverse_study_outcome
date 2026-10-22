package com.larus.bmhome.chat.component.halfscreen;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/halfscreen/ScreenState;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "HALF", "FULL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ScreenState extends Enum<ScreenState> {
    public static final ScreenState FULL = null;
    public static final ScreenState HALF = null;
    public static final ScreenState UNINITIALIZED = null;
    public static final /* synthetic */ ScreenState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ScreenState> getEntries() {
        return b;
    }

    static {
        ScreenState r0 = new ScreenState("UNINITIALIZED", 0);
        UNINITIALIZED = r0;
        ScreenState r1 = new ScreenState("HALF", 1);
        HALF = r1;
        ScreenState r3 = new ScreenState("FULL", 2);
        FULL = r3;
        ScreenState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ScreenState[] values() {
        return (ScreenState[]) a.clone();
    }

    public static ScreenState valueOf(String r1) {
        return (ScreenState) a.a(ScreenState.class, r1);
    }

    public ScreenState(String r1, int r2) {
        super(r1, r2);
    }
}
