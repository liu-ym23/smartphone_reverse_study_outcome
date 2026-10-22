package com.larus.bmhome.chat.api;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NotificationApi {
    public static final Lazy<NotificationApi> a = null;

    public static final class a {
    }

    public NotificationApi() {
    }

    static {
        a = LazyKt.lazy(new s0());
    }

    public static Object a(List r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$deleteNotification$2(r3, null), r4);
    }

    public static Object d(List r3, String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$requireUnreadNotificationCount$2(r3, r4, null), r5);
    }

    public static Object c(long r12, boolean r14, DowngradeSource r15, boolean r16, Continuation r17) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$requireNotificationList$2(0, r12, 20, r14, r16, r15, null), r17);
    }

    public static Object e(int r8, Long r9, Long r10, Integer r11, Continuation r12) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$updateReadNotification$2(r8, r9, r10, r11, null), r12);
    }

    public static Object b(long r18, boolean r20, long r21, long r23, long r25, String r27, Continuation r28) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$requireAggNotificationList$2(0, r18, 20, r27, r20, r21, r23, r25, null), r28);
    }
}
