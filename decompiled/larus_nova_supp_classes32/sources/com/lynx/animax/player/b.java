package com.lynx.animax.player;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.lynx.animax.util.AnimaXLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static b c;
    public final Map<String, Boolean> a;
    public volatile MediaCodecInfo[] b;

    public b() {
        this.a = new ConcurrentHashMap();
    }

    public final boolean a(String r10, boolean r11) {
        boolean r1 = false;
        if (r10.isEmpty() == true) goto L52;
        StringBuilder r0 = new StringBuilder();
        r0.append(r10.toLowerCase());
        if (r11 == false) goto L8;
        String r2 = "_HW";
    L9:
        r0.append(r2);
        String r3 = r0.toString();
        if (((ConcurrentHashMap) this.a).containsKey(r3) == false) goto L14;
        return ((Boolean) ((ConcurrentHashMap) this.a).get(r3)).booleanValue();
    L14:
        if (r10.isEmpty() == false) goto L53;
    L51:
        ((ConcurrentHashMap) this.a).put(r3, Boolean.valueOf(r1));
        goto L52
    L53:
    L49:
        e = move-exception;
        AnimaXLog.a("CodecDecodeCapability", "checkCodecSupport failed, mimeType: " + r10 + ", message: " + e.getMessage());
        goto L51
    L17:
        if (this.b == null) goto L19;
        MediaCodecInfo[] r4 = this.b;     // Catch: Exception -> L49
    L28:
        int r5 = r4.length;     // Catch: Exception -> L49
        int r6 = 0;
    L29:
        if (r6 >= r5) goto L51;
        MediaCodecInfo r7 = r4[r6];     // Catch: Exception -> L49
        if (r7.isEncoder() == true) goto L45;
        if (r11 == true) goto L35;
    L39:
        String[] r8 = r7.getSupportedTypes();     // Catch: Exception -> L49
        int r9 = r8.length;     // Catch: Exception -> L49
        int r12 = 0;
    L40:
        if (r12 >= r9) goto L45;
        if (r8[r12].equalsIgnoreCase(r10) == true) goto L43;
        r12 = r12 + 1;
        goto L40
    L43:
        r1 = true;
        goto L51
    L35:
        if (Build.VERSION.SDK_INT < 29) goto L39;
        if (r7.isHardwareAccelerated() == true) goto L39;
    L45:
        r6 = r6 + 1;
        goto L29
    L19:
        monitor-enter(this);     // Catch: Exception -> L49
    L46:
        th = move-exception;
        throw th;     // Catch: Exception -> L49
    L21:
        if (this.b != null) goto L26;
        int r13 = MediaCodecList.getCodecCount();     // Catch: Throwable -> L46
        MediaCodecInfo[] r14 = new MediaCodecInfo[r13];     // Catch: Throwable -> L46
        int r15 = 0;
    L23:
        if (r15 >= r13) goto L25;
        r14[r15] = MediaCodecList.getCodecInfoAt(r15);     // Catch: Throwable -> L46
        r15 = r15 + 1;     // Catch: Throwable -> L46
        goto L23
    L25:
        this.b = r14;     // Catch: Throwable -> L46
    L26:
        r4 = this.b;     // Catch: Throwable -> L46
        monitor-exit(this);     // Catch: Throwable -> L46
    L8:
        r2 = "_SW";
    L52:
        return r1;
    }
}
