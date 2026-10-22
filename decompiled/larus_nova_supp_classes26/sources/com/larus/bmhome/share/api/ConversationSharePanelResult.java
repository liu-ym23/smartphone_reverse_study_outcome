package com.larus.bmhome.share.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/share/api/ConversationSharePanelResult;", "", "<init>", "(Ljava/lang/String;I)V", "SHOWN", "FAILED", "UNSUPPORTED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationSharePanelResult extends Enum<ConversationSharePanelResult> {
    public static final ConversationSharePanelResult FAILED = null;
    public static final ConversationSharePanelResult SHOWN = null;
    public static final ConversationSharePanelResult UNSUPPORTED = null;
    public static final /* synthetic */ ConversationSharePanelResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ConversationSharePanelResult> getEntries() {
        return b;
    }

    static {
        ConversationSharePanelResult r0 = new ConversationSharePanelResult("SHOWN", 0);
        SHOWN = r0;
        ConversationSharePanelResult r1 = new ConversationSharePanelResult("FAILED", 1);
        FAILED = r1;
        ConversationSharePanelResult r3 = new ConversationSharePanelResult("UNSUPPORTED", 2);
        UNSUPPORTED = r3;
        ConversationSharePanelResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ConversationSharePanelResult[] values() {
        return (ConversationSharePanelResult[]) a.clone();
    }

    public static ConversationSharePanelResult valueOf(String r1) {
        return (ConversationSharePanelResult) a.a(ConversationSharePanelResult.class, r1);
    }

    public ConversationSharePanelResult(String r1, int r2) {
        super(r1, r2);
    }
}
