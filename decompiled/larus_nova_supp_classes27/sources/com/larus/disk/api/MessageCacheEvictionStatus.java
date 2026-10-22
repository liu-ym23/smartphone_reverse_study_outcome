package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/disk/api/MessageCacheEvictionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "PARTIAL", "STALE_SNAPSHOT", "UNAVAILABLE", "FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageCacheEvictionStatus extends Enum<MessageCacheEvictionStatus> {
    public static final MessageCacheEvictionStatus FAILED = null;
    public static final MessageCacheEvictionStatus PARTIAL = null;
    public static final MessageCacheEvictionStatus STALE_SNAPSHOT = null;
    public static final MessageCacheEvictionStatus SUCCESS = null;
    public static final MessageCacheEvictionStatus UNAVAILABLE = null;
    public static final /* synthetic */ MessageCacheEvictionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MessageCacheEvictionStatus> getEntries() {
        return b;
    }

    static {
        MessageCacheEvictionStatus r0 = new MessageCacheEvictionStatus("SUCCESS", 0);
        SUCCESS = r0;
        MessageCacheEvictionStatus r1 = new MessageCacheEvictionStatus("PARTIAL", 1);
        PARTIAL = r1;
        MessageCacheEvictionStatus r3 = new MessageCacheEvictionStatus("STALE_SNAPSHOT", 2);
        STALE_SNAPSHOT = r3;
        MessageCacheEvictionStatus r5 = new MessageCacheEvictionStatus("UNAVAILABLE", 3);
        UNAVAILABLE = r5;
        MessageCacheEvictionStatus r7 = new MessageCacheEvictionStatus("FAILED", 4);
        FAILED = r7;
        MessageCacheEvictionStatus[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MessageCacheEvictionStatus[] values() {
        return (MessageCacheEvictionStatus[]) a.clone();
    }

    public static MessageCacheEvictionStatus valueOf(String r1) {
        return (MessageCacheEvictionStatus) a.a(MessageCacheEvictionStatus.class, r1);
    }

    public MessageCacheEvictionStatus(String r1, int r2) {
        super(r1, r2);
    }
}
