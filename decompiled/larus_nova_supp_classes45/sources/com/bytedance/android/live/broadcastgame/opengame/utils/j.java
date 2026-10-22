package com.bytedance.android.live.broadcastgame.opengame.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(File r5) {
        Intrinsics.checkNotNullParameter(r5, "res");
        Intrinsics.checkNotNullParameter("introduce", "pageAlias");
        com.bytedance.android.live.broadcastgame.opengame.lynx.b r6 = c(FilesKt.resolve(r5, "config.json"));
        if (r6 == null) goto L24;
        List<com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b> r7 = r6.a;
        if (r7 == null) goto L31;
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L17;
        Object r0 = r8.next();
        com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b r2 = (com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b) r0;
        if (Intrinsics.areEqual(r2.getType(), "panel") == true) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == false) goto L8;
    L18:
        com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b r1 = (com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b) r0;
        if (r1 == null) goto L32;
        String r9 = r1.c;
        if (r9 == null) goto L33;
        return r9;
    L33:
        return "";
    L32:
        return "";
    L12:
        if (Intrinsics.areEqual(r2.b, "introduce") == false) goto L14;
        r3 = true;
        goto L15
    L17:
        r0 = null;
        goto L18
    L31:
        return "";
    L24:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "src");
        byte[] r0 = new byte[20480];
        PolarisFileInputStreamWrapper r1 = null;
        String r2 = null;
        PolarisFileInputStreamWrapper r3 = new PolarisFileInputStreamWrapper(r5);     // Catch: Throwable -> L30 Exception -> L32
    L102:
        ByteArrayOutputStream r6 = new ByteArrayOutputStream(r3.available());     // Catch: Throwable -> L26 Exception -> L28
    L99:
        int r4 = r3.read(r0);     // Catch: Exception -> L24 Throwable -> L54
        if (r4 == (-1)) goto L8;
        r6.write(r0, 0, r4);     // Catch: Exception -> L24 Throwable -> L54
        goto L99
    L8:
        r6.flush();     // Catch: Exception -> L24 Throwable -> L54
        byte[] r7 = r6.toByteArray();     // Catch: Exception -> L24 Throwable -> L54
        r3.close();     // Catch: Throwable -> L11 IOException -> L13
    L89:
        r6.close();     // Catch: Throwable -> L17 IOException -> L19
    L21:
        return r7;
    L17:
        th = move-exception;
        throw th;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L24:
        Exception e = e;
    L34:
        e.printStackTrace();     // Catch: Throwable -> L54
        if (r3 != null) goto L96;
    L78:
        if (r6 != null) goto L85;
    L53:
        return null;
    L85:
        r6.close();     // Catch: Throwable -> L47 IOException -> L49
    L77:
        goto L53
    L49:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L96:
        r3.close();     // Catch: Throwable -> L38 IOException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L28:
        e = move-exception;
        e = e;
        r6 = null;
    L26:
        th = th;
    L27:
        ByteArrayOutputStream r8 = r2;
        r1 = r3;
    L56:
        if (r1 != null) goto L91;
    L81:
        if (r8 == 0) goto L105;
        r8.close();     // Catch: Throwable -> L68 IOException -> L70
    L80:
        throw th;
    L70:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L68
        goto L80
    L105:
        throw th;
    L68:
        th = move-exception;
        throw th;
    L91:
        r1.close();     // Catch: Throwable -> L59 IOException -> L61
    L61:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L54:
        th = move-exception;
        r2 = r5;
        th = th;
    L32:
        e = move-exception;
        e = e;
        r6 = null;
        r3 = null;
    L30:
        th = th;
        r8 = 0;
        goto L56
    }

    public static com.bytedance.android.live.broadcastgame.opengame.lynx.b c(File r3) {
        if (r3.exists() == true) goto L5;
    L13:
        PolarisFileInputStreamWrapper r0 = null;
    L14:
        if (r0 != null) goto L34;
        return null;
    L34:
        BufferedReader r4 = new BufferedReader(new InputStreamReader(r0));     // Catch: Throwable -> L26
        String r1 = TextStreamsKt.readText(r4);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L26
        JSONObject r5 = new JSONObject(r1);     // Catch: Throwable -> L26
    L27:
        if (r5 != null) goto L39;
        return null;
    L39:
        int r2 = com.bytedance.android.live.broadcastgame.opengame.lynx.b.d;     // Catch: JSONException -> L31
        return com.bytedance.android.live.broadcastgame.opengame.lynx.b.a.a(r5);
    L31:
        return null;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        r5 = null;
        goto L27
    L5:
        if (r3.isFile() == true) goto L41;
        FilesKt.deleteRecursively(r3);     // Catch: IOException -> L11
    L11:
        e = move-exception;
        ALogger.e("GameFileUtils", String.valueOf(e.getMessage()));
        goto L13
    L41:
        r0 = new PolarisFileInputStreamWrapper(r3);     // Catch: IOException -> L8
        goto L14
    }

    public static String d(String r4) {
        Intrinsics.checkNotNullParameter(r4, LiveSlardarConstants.EXTRA_KEY_URL);
        if (Intrinsics.areEqual(r4, "") == false) goto L13;
        return "";
    L13:
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new URL(r4).openStream()));     // Catch: Throwable -> L10
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L10
        String r2 = r1.readLine();     // Catch: Throwable -> L10
    L6:
        if (r2 == null) goto L8;
        r5.append(r2);     // Catch: Throwable -> L10
        r2 = r1.readLine();     // Catch: Throwable -> L10
        goto L6
    L8:
        r1.close();     // Catch: Throwable -> L10
        return r5.toString();
    L10:
        th = move-exception;
        ALogger.e("OpenPlatform", "OpenPlatformFileUtil : " + th);
        return "";
    }
}
