package com.ss.android.lark.flow.chat.message.layout;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/layout/BubbleLayoutAlphaMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "AVATAR_HIGHLIGHT", "EDIT_MASK", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum BubbleLayoutAlphaMode extends Enum<BubbleLayoutAlphaMode> {
    public static final BubbleLayoutAlphaMode AVATAR_HIGHLIGHT = null;
    public static final BubbleLayoutAlphaMode EDIT_MASK = null;
    public static final BubbleLayoutAlphaMode NORMAL = null;
    public static final /* synthetic */ BubbleLayoutAlphaMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BubbleLayoutAlphaMode> getEntries() {
        return b;
    }

    static {
        BubbleLayoutAlphaMode r0 = new BubbleLayoutAlphaMode("NORMAL", 0);
        NORMAL = r0;
        BubbleLayoutAlphaMode r1 = new BubbleLayoutAlphaMode("AVATAR_HIGHLIGHT", 1);
        AVATAR_HIGHLIGHT = r1;
        BubbleLayoutAlphaMode r3 = new BubbleLayoutAlphaMode("EDIT_MASK", 2);
        EDIT_MASK = r3;
        BubbleLayoutAlphaMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BubbleLayoutAlphaMode[] values() {
        return (BubbleLayoutAlphaMode[]) a.clone();
    }

    public static BubbleLayoutAlphaMode valueOf(String r1) {
        return (BubbleLayoutAlphaMode) r27.a.a(BubbleLayoutAlphaMode.class, r1);
    }

    public BubbleLayoutAlphaMode(String r1, int r2) {
        super(r1, r2);
    }
}
