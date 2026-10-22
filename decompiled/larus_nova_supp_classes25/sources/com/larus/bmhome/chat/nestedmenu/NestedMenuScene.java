package com.larus.bmhome.chat.nestedmenu;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/NestedMenuScene;", "", "<init>", "(Ljava/lang/String;I)V", "ACTION_BAR", "SETTINGS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum NestedMenuScene extends Enum<NestedMenuScene> {
    public static final NestedMenuScene ACTION_BAR = null;
    public static final NestedMenuScene SETTINGS = null;
    public static final /* synthetic */ NestedMenuScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<NestedMenuScene> getEntries() {
        return b;
    }

    static {
        NestedMenuScene r0 = new NestedMenuScene("ACTION_BAR", 0);
        ACTION_BAR = r0;
        NestedMenuScene r1 = new NestedMenuScene("SETTINGS", 1);
        SETTINGS = r1;
        NestedMenuScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static NestedMenuScene[] values() {
        return (NestedMenuScene[]) a.clone();
    }

    public static NestedMenuScene valueOf(String r1) {
        return (NestedMenuScene) r27.a.a(NestedMenuScene.class, r1);
    }

    public NestedMenuScene(String r1, int r2) {
        super(r1, r2);
    }
}
