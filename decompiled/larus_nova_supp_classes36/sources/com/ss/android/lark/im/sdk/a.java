package com.ss.android.lark.im.sdk;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Log.e(r1, r2);
    }

    public static void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Log.i(r1, r2);
    }
}
