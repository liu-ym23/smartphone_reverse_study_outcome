package com.larus.extension.chat_extension.impl.ltm;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NO_STATUS", "PLACEHOLDER", "NORMAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ChatLtmStatus extends Enum<ChatLtmStatus> {
    public static final ChatLtmStatus NORMAL = null;
    public static final ChatLtmStatus NO_STATUS = null;
    public static final ChatLtmStatus PLACEHOLDER = null;
    public static final /* synthetic */ ChatLtmStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatLtmStatus> getEntries() {
        return b;
    }

    static {
        ChatLtmStatus r0 = new ChatLtmStatus("NO_STATUS", 0);
        NO_STATUS = r0;
        ChatLtmStatus r1 = new ChatLtmStatus("PLACEHOLDER", 1);
        PLACEHOLDER = r1;
        ChatLtmStatus r3 = new ChatLtmStatus("NORMAL", 2);
        NORMAL = r3;
        ChatLtmStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ChatLtmStatus[] values() {
        return (ChatLtmStatus[]) a.clone();
    }

    public static ChatLtmStatus valueOf(String r1) {
        return (ChatLtmStatus) r27.a.a(ChatLtmStatus.class, r1);
    }

    public ChatLtmStatus(String r1, int r2) {
        super(r1, r2);
    }
}
