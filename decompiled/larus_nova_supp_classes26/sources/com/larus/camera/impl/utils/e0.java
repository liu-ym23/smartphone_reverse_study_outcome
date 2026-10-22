package com.larus.camera.impl.utils;

import android.graphics.Bitmap;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 {
    public static final ConcurrentHashMap<String, Bitmap> a = null;
    public static final ConcurrentHashMap<String, String> b = null;
    public static final ConcurrentHashMap<String, Boolean> c = null;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static Bitmap a(String r1) {
        Intrinsics.checkNotNullParameter(r1, MusicAppletPage.KEY_PATH);
        return a.remove(r1);
    }

    public static void b(String r1, Bitmap r2) {
        Intrinsics.checkNotNullParameter(r1, MusicAppletPage.KEY_PATH);
        if (r2 != null) goto L5;
        return;
    L5:
        a.put(r1, r2);
    }

    public static void c(String r3, String r4) {
        boolean r0 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L19;
        if (r4 != null) goto L12;
    L15:
        if (r0 == true) goto L20;
        b.put(r3, r4);
        return;
    L20:
        return;
    L12:
        if (r4.length() == 0) goto L15;
        r0 = false;
        goto L15
    L19:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
