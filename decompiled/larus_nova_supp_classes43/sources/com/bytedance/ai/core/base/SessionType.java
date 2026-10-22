package com.bytedance.ai.core.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/core/base/SessionType;", "", "<init>", "(Ljava/lang/String;I)V", "CHATUI", "PLAYGROUND", "DESKTOP", "DEBUG", "OTHER", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SessionType extends Enum<SessionType> {
    public static final SessionType CHATUI = null;
    public static final SessionType DEBUG = null;
    public static final SessionType DESKTOP = null;
    public static final SessionType OTHER = null;
    public static final SessionType PLAYGROUND = null;
    public static final /* synthetic */ SessionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SessionType> getEntries() {
        return b;
    }

    static {
        SessionType r0 = new SessionType("CHATUI", 0);
        CHATUI = r0;
        SessionType r1 = new SessionType("PLAYGROUND", 1);
        PLAYGROUND = r1;
        SessionType r10 = new SessionType("DESKTOP", 2);
        DESKTOP = r10;
        SessionType r11 = new SessionType("DEBUG", 3);
        DEBUG = r11;
        SessionType r12 = new SessionType("OTHER", 4);
        OTHER = r12;
        SessionType[] r13 = {r0, r1, r10, r11, r12};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static SessionType[] values() {
        return (SessionType[]) a.clone();
    }

    public static SessionType valueOf(String r1) {
        return (SessionType) r27.a.a(SessionType.class, r1);
    }

    public SessionType(String r1, int r10) {
        super(r1, r10);
    }
}
