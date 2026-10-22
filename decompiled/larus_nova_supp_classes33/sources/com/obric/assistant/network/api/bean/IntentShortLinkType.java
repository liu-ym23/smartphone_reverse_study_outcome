package com.obric.assistant.network.api.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/network/api/bean/IntentShortLinkType;", "", "<init>", "(Ljava/lang/String;I)V", "COMPENSATION", "ASYNC_NOTIFY", "NORMAL", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IntentShortLinkType extends Enum<IntentShortLinkType> {
    public static final IntentShortLinkType ASYNC_NOTIFY = null;
    public static final IntentShortLinkType COMPENSATION = null;
    public static final IntentShortLinkType NORMAL = null;
    public static final /* synthetic */ IntentShortLinkType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IntentShortLinkType> getEntries() {
        return b;
    }

    static {
        IntentShortLinkType r0 = new IntentShortLinkType("COMPENSATION", 0);
        COMPENSATION = r0;
        IntentShortLinkType r1 = new IntentShortLinkType("ASYNC_NOTIFY", 1);
        ASYNC_NOTIFY = r1;
        IntentShortLinkType r3 = new IntentShortLinkType("NORMAL", 2);
        NORMAL = r3;
        IntentShortLinkType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static IntentShortLinkType[] values() {
        return (IntentShortLinkType[]) a.clone();
    }

    public static IntentShortLinkType valueOf(String r1) {
        return (IntentShortLinkType) a.a(IntentShortLinkType.class, r1);
    }

    public IntentShortLinkType(String r1, int r2) {
        super(r1, r2);
    }
}
