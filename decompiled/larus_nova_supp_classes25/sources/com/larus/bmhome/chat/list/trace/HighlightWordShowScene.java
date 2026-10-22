package com.larus.bmhome.chat.list.trace;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/list/trace/HighlightWordShowScene;", "", "<init>", "(Ljava/lang/String;I)V", "LINK_META_INFO", "LINK_PHONE_NUMBER", "LINK_LONG_URL", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum HighlightWordShowScene extends Enum<HighlightWordShowScene> {
    public static final HighlightWordShowScene LINK_LONG_URL = null;
    public static final HighlightWordShowScene LINK_META_INFO = null;
    public static final HighlightWordShowScene LINK_PHONE_NUMBER = null;
    public static final /* synthetic */ HighlightWordShowScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HighlightWordShowScene> getEntries() {
        return b;
    }

    static {
        HighlightWordShowScene r0 = new HighlightWordShowScene("LINK_META_INFO", 0);
        LINK_META_INFO = r0;
        HighlightWordShowScene r1 = new HighlightWordShowScene("LINK_PHONE_NUMBER", 1);
        LINK_PHONE_NUMBER = r1;
        HighlightWordShowScene r3 = new HighlightWordShowScene("LINK_LONG_URL", 2);
        LINK_LONG_URL = r3;
        HighlightWordShowScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static HighlightWordShowScene[] values() {
        return (HighlightWordShowScene[]) a.clone();
    }

    public static HighlightWordShowScene valueOf(String r1) {
        return (HighlightWordShowScene) r27.a.a(HighlightWordShowScene.class, r1);
    }

    public HighlightWordShowScene(String r1, int r2) {
        super(r1, r2);
    }
}
