package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/disk/api/MessageCacheQueryStatus;", "", "<init>", "(Ljava/lang/String;I)V", "READY", "UNAVAILABLE", "FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageCacheQueryStatus extends Enum<MessageCacheQueryStatus> {
    public static final MessageCacheQueryStatus FAILED = null;
    public static final MessageCacheQueryStatus READY = null;
    public static final MessageCacheQueryStatus UNAVAILABLE = null;
    public static final /* synthetic */ MessageCacheQueryStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MessageCacheQueryStatus> getEntries() {
        return b;
    }

    static {
        MessageCacheQueryStatus r0 = new MessageCacheQueryStatus("READY", 0);
        READY = r0;
        MessageCacheQueryStatus r1 = new MessageCacheQueryStatus("UNAVAILABLE", 1);
        UNAVAILABLE = r1;
        MessageCacheQueryStatus r3 = new MessageCacheQueryStatus("FAILED", 2);
        FAILED = r3;
        MessageCacheQueryStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MessageCacheQueryStatus[] values() {
        return (MessageCacheQueryStatus[]) a.clone();
    }

    public static MessageCacheQueryStatus valueOf(String r1) {
        return (MessageCacheQueryStatus) a.a(MessageCacheQueryStatus.class, r1);
    }

    public MessageCacheQueryStatus(String r1, int r2) {
        super(r1, r2);
    }
}
