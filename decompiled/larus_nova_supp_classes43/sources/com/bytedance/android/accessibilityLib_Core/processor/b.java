package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.byted.cast.sink.api.ServerInfo;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final ConcurrentHashMap<String, String> a;
    public final ConcurrentHashMap<String, WeakReference<View>> b;
    public final int c;

    public b() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = ServerInfo.ERROR_BIND_SERVICE;
    }

    public static String a(View r10) {
        CharSequence r0 = r10.getContentDescription();
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r11 = true;
    L12:
        if (r11 == true) goto L14;
        return r1;
    L14:
        if ((r10 instanceof TextView) == false) goto L27;
        String r12 = ((TextView) r10).getText().toString();     // Catch: Exception -> L17
    L23:
        return r12;
    L17:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L21;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L21:
        r12 = "";
        goto L23
    L27:
        return r1;
    L8:
        if (r1.length() == 0) goto L11;
        r11 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
