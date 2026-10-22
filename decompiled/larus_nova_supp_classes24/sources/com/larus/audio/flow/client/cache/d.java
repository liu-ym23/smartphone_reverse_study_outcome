package com.larus.audio.flow.client.cache;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r6, String r7, String r8, String r9) {
        StringBuilder r1 = new StringBuilder();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r1.append(r6);
        r1.append('-');
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r1.append(r7);
        StringBuilder r0 = new StringBuilder(r1.toString());
        boolean r10 = false;
        if (r8 != null) goto L11;
    L21:
        if (r9 != null) goto L23;
    L24:
        r10 = true;
    L25:
        if (r10 == true) goto L28;
        r0.append("-" + r9.hashCode());
    L28:
        return r0.toString();
    L23:
        if (r9.length() != 0) goto L25;
    L11:
        if (r8.length() <= 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L21;
        JSONObject r3 = new JSONObject(r8);
        if (r3.has("pitch") == false) goto L19;
        r0.append("-" + r3.optInt("pitch"));
    L19:
        if (r3.has("speech_rate") == false) goto L21;
        r0.append("-" + r3.optDouble("speech_rate"));
        goto L21
    L13:
        r2 = false;
        goto L14
    }
}
