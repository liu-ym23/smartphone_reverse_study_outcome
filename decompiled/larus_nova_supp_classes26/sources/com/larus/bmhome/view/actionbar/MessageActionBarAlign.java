package com.larus.bmhome.view.actionbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/view/actionbar/MessageActionBarAlign;", "", "<init>", "(Ljava/lang/String;I)V", "START", "END", "KEEP", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageActionBarAlign extends Enum<MessageActionBarAlign> {
    public static final MessageActionBarAlign END = null;
    public static final MessageActionBarAlign KEEP = null;
    public static final MessageActionBarAlign START = null;
    public static final /* synthetic */ MessageActionBarAlign[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MessageActionBarAlign> getEntries() {
        return b;
    }

    static {
        MessageActionBarAlign r0 = new MessageActionBarAlign("START", 0);
        START = r0;
        MessageActionBarAlign r1 = new MessageActionBarAlign("END", 1);
        END = r1;
        MessageActionBarAlign r3 = new MessageActionBarAlign("KEEP", 2);
        KEEP = r3;
        MessageActionBarAlign[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MessageActionBarAlign[] values() {
        return (MessageActionBarAlign[]) a.clone();
    }

    public static MessageActionBarAlign valueOf(String r1) {
        return (MessageActionBarAlign) a.a(MessageActionBarAlign.class, r1);
    }

    public MessageActionBarAlign(String r1, int r2) {
        super(r1, r2);
    }
}
