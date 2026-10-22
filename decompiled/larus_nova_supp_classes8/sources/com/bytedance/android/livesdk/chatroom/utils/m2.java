package com.bytedance.android.livesdk.chatroom.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.OutputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m2 {
    public static final String a = null;

    static {
        a = Environment.getExternalStorageDirectory().getPath() + '/' + Environment.DIRECTORY_DCIM + "/Camera/";
    }

    @JvmStatic
    public static final String a(Context r4, Bitmap r5, String r6) {
        if (r5 != null) goto L5;
        return "";
    L5:
        if (r4 != null) goto L12;
        return "";
    L12:
        String r7 = r6 + '_' + System.currentTimeMillis() + ".png";     // Catch: Exception -> L9
        OutputStream r8 = ContentResolverWrapper.openOutputStream(r4.getContentResolver(), BdMediaFileSystem.createImageUri(r4, r7, "image/png"));     // Catch: Exception -> L9
        Bitmap.CompressFormat r1 = Bitmap.CompressFormat.PNG;     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L9
        r5.compress(r1, 70, r8);     // Catch: Exception -> L9
        return a + r7;
    L9:
        e = move-exception;
        ALogger.d("ttlive_poster", "save bitmap failure: " + e.getMessage());
        return "";
    }
}
