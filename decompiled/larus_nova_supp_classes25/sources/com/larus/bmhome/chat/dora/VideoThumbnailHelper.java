package com.larus.bmhome.chat.dora;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class VideoThumbnailHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public VideoThumbnailHelper() {
    }

    public static Object b(Context r3, String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2(r4, r3, null), r5);
    }

    public static void c(Bitmap r4, PolarisFileWrapper r5, int r6) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r5.getParent(), r5.getName() + ".tmp");
        PolarisFileOutputStreamWrapper r1 = new PolarisFileOutputStreamWrapper(r0);     // Catch: Exception -> L13
        r4.compress(Bitmap.CompressFormat.JPEG, r6, r1);     // Catch: Throwable -> L8
        r1.flush();     // Catch: Throwable -> L8
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        CloseableKt.closeFinally(r1, null);     // Catch: Exception -> L13
        r0.renameTo(r5);     // Catch: Exception -> L13
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r0.delete();
        e.printStackTrace();
    }

    public static Object a(Context r3, String r4, String r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2(r5, r4, r3, null), r6);
    }
}
