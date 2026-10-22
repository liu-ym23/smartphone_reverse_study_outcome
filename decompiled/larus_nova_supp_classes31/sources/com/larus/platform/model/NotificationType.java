package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/NotificationType;", "", "<init>", "(Ljava/lang/String;I)V", "FEEDBACK", "DEFAULT", "AWEME_FEED", "QUOTA_LIMIT", "LEFT_RIGHT_IMAGE", "LEFT_RIGHT_IMAGE_TEXT", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum NotificationType extends Enum<NotificationType> {
    public static final NotificationType AWEME_FEED = null;
    public static final NotificationType DEFAULT = null;
    public static final NotificationType FEEDBACK = null;
    public static final NotificationType LEFT_RIGHT_IMAGE = null;
    public static final NotificationType LEFT_RIGHT_IMAGE_TEXT = null;
    public static final NotificationType QUOTA_LIMIT = null;
    public static final /* synthetic */ NotificationType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<NotificationType> getEntries() {
        return b;
    }

    static {
        NotificationType r0 = new NotificationType("FEEDBACK", 0);
        FEEDBACK = r0;
        NotificationType r1 = new NotificationType("DEFAULT", 1);
        DEFAULT = r1;
        NotificationType r3 = new NotificationType("AWEME_FEED", 2);
        AWEME_FEED = r3;
        NotificationType r5 = new NotificationType("QUOTA_LIMIT", 3);
        QUOTA_LIMIT = r5;
        NotificationType r7 = new NotificationType("LEFT_RIGHT_IMAGE", 4);
        LEFT_RIGHT_IMAGE = r7;
        NotificationType r9 = new NotificationType("LEFT_RIGHT_IMAGE_TEXT", 5);
        LEFT_RIGHT_IMAGE_TEXT = r9;
        NotificationType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static NotificationType[] values() {
        return (NotificationType[]) a.clone();
    }

    public static NotificationType valueOf(String r1) {
        return (NotificationType) a.a(NotificationType.class, r1);
    }

    public NotificationType(String r1, int r2) {
        super(r1, r2);
    }
}
