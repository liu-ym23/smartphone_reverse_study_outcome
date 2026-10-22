package com.larus.bmhome.chat.component.bottom.core.speaker;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/speaker/SessionType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERCOM", "CLICK_TALK", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SessionType extends Enum<SessionType> {
    public static final SessionType CLICK_TALK = null;
    public static final a Companion = null;
    public static final SessionType INTERCOM = null;
    public static final /* synthetic */ SessionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SessionType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.core.speaker.SessionType$a] */
    static {
        SessionType r0 = new SessionType("INTERCOM", 0);
        INTERCOM = r0;
        SessionType r1 = new SessionType("CLICK_TALK", 1);
        CLICK_TALK = r1;
        SessionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static SessionType[] values() {
        return (SessionType[]) a.clone();
    }

    public static SessionType valueOf(String r1) {
        return (SessionType) r27.a.a(SessionType.class, r1);
    }

    public SessionType(String r1, int r2) {
        super(r1, r2);
    }
}
