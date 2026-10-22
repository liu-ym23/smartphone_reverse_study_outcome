package com.ss.android.lark.flow.chat.message.image.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/image/model/FlowMediaMessageType;", "", "<init>", "(Ljava/lang/String;I)V", "Lark", "Doubao", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum FlowMediaMessageType extends Enum<FlowMediaMessageType> {
    public static final FlowMediaMessageType Doubao = null;
    public static final FlowMediaMessageType Lark = null;
    public static final /* synthetic */ FlowMediaMessageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FlowMediaMessageType> getEntries() {
        return b;
    }

    static {
        FlowMediaMessageType r0 = new FlowMediaMessageType("Lark", 0);
        Lark = r0;
        FlowMediaMessageType r1 = new FlowMediaMessageType("Doubao", 1);
        Doubao = r1;
        FlowMediaMessageType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static FlowMediaMessageType[] values() {
        return (FlowMediaMessageType[]) a.clone();
    }

    public static FlowMediaMessageType valueOf(String r1) {
        return (FlowMediaMessageType) a.a(FlowMediaMessageType.class, r1);
    }

    public FlowMediaMessageType(String r1, int r2) {
        super(r1, r2);
    }
}
