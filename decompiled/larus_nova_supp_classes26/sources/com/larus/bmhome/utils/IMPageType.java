package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/utils/IMPageType;", "", "<init>", "(Ljava/lang/String;I)V", "IM_CHAT_BOT", "IM_CHAT_USER", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMPageType extends Enum<IMPageType> {
    public static final IMPageType IM_CHAT_BOT = null;
    public static final IMPageType IM_CHAT_USER = null;
    public static final /* synthetic */ IMPageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IMPageType> getEntries() {
        return b;
    }

    static {
        IMPageType r0 = new IMPageType("IM_CHAT_BOT", 0);
        IM_CHAT_BOT = r0;
        IMPageType r1 = new IMPageType("IM_CHAT_USER", 1);
        IM_CHAT_USER = r1;
        IMPageType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static IMPageType[] values() {
        return (IMPageType[]) a.clone();
    }

    public static IMPageType valueOf(String r1) {
        return (IMPageType) r27.a.a(IMPageType.class, r1);
    }

    public IMPageType(String r1, int r2) {
        super(r1, r2);
    }
}
