package com.ss.android.lark.image.uploader.utils;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public c() {
    }

    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Log.d("ImageUploader_".concat(r1), r2);
    }

    public static void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Log.i("ImageUploader_".concat(r1), r2);
    }

    public static void b(String r2, String r3, Throwable r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        if (r4 == null) goto L5;
        Log.e("ImageUploader_".concat(r2), r3, r4, r5);
        return;
    L5:
        if (r5 == false) goto L7;
        Log.e("ImageUploader_".concat(r2), r3, new Throwable(r3), r5);
        return;
    L7:
        Log.e("ImageUploader_".concat(r2), r3);
    }
}
