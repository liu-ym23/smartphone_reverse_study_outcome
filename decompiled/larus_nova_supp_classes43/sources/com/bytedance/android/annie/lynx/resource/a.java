package com.bytedance.android.annie.lynx.resource;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Boolean a = null;

    static {
        a = AnnieConfigSettingKeys.FIX_LYNX_FILE_STREAM_CLOSE.a();
    }

    public static byte[] a(InputStream r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (a.booleanValue() == false) goto L23;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(Math.max(8192, r10.available()));     // Catch: Throwable -> L17
        ByteStreamsKt.copyTo$default(r10, r1, 0, 2, null);     // Catch: Throwable -> L12
        byte[] r11 = r1.toByteArray();     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r10, null);
        return r11;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L23:
        return ByteStreamsKt.readBytes(r10);
    }
}
