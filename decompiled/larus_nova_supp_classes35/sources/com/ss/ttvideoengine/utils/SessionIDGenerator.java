package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SessionIDGenerator {
    public SessionIDGenerator() {
    }

    public static String generateSessionID(String r3) {
        String r0 = new String();
        if (r3 == null) goto L6;
        r0 = r0.concat(r3);
    L6:
        return Base64.encodeToString(((r0 + new Random().nextInt()) + System.currentTimeMillis()).getBytes(), 2);
    }

    public static String generateTrackID(String r5) {
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(r5) == true) goto L5;
        r0.append(r5);
        r0.append("T");
    L5:
        r0.append(Long.toString(System.currentTimeMillis()));
        r0.append("T");
        r0.append(Integer.toString((int) (Math.random() * 65535.0d)));
        return r0.toString();
    }
}
