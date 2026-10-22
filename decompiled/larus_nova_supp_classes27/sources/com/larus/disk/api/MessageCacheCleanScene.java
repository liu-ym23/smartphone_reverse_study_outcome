package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/disk/api/MessageCacheCleanScene;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "LOW_DISK", "MANUAL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageCacheCleanScene extends Enum<MessageCacheCleanScene> {
    public static final MessageCacheCleanScene LOW_DISK = null;
    public static final MessageCacheCleanScene MANUAL = null;
    public static final MessageCacheCleanScene REGULAR = null;
    public static final /* synthetic */ MessageCacheCleanScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MessageCacheCleanScene> getEntries() {
        return b;
    }

    static {
        MessageCacheCleanScene r0 = new MessageCacheCleanScene("REGULAR", 0);
        REGULAR = r0;
        MessageCacheCleanScene r1 = new MessageCacheCleanScene("LOW_DISK", 1);
        LOW_DISK = r1;
        MessageCacheCleanScene r3 = new MessageCacheCleanScene("MANUAL", 2);
        MANUAL = r3;
        MessageCacheCleanScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MessageCacheCleanScene[] values() {
        return (MessageCacheCleanScene[]) a.clone();
    }

    public static MessageCacheCleanScene valueOf(String r1) {
        return (MessageCacheCleanScene) a.a(MessageCacheCleanScene.class, r1);
    }

    public MessageCacheCleanScene(String r1, int r2) {
        super(r1, r2);
    }
}
