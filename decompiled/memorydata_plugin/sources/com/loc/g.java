package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5604b = null;
    private static final String c = null;
    private static final String d = null;
    private static final String e = null;
    private static boolean f;
    private String g;

    static {
        f5603a = fx.c("SRFZHZUVZT3BOa0ZiemZRQQ");
        f5604b = fx.c("FbGJzX3Nkaw");
        c = fx.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
        d = fx.c("FQU5EU0RLMTA");
        e = fx.c("FMTAw");
        f = false;
    }

    public g() {
        this.g = "";
    }

    public static fp.a a() {
        return new AnonymousClass1();
    }

    public static String a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject(r3);     // Catch: JSONException -> L9
        if (r0.optInt(fx.c("UY29kZQ")) != 1) goto L15;
        String r5 = new JSONObject(r0.optString(fx.c("FZGF0YQ"))).optString(fx.c("FYWRpdQ"));     // Catch: JSONException -> L9
        if (TextUtils.isEmpty(r5) == true) goto L16;
        h.a(r5);     // Catch: JSONException -> L9
        c.a(r4).a(r5);     // Catch: JSONException -> L9
        return r5;
    L16:
        return "";
    L15:
        return "";
    L9:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String c() {
        return h.a();
    }

    private String d() {
        if (TextUtils.isEmpty(this.g) == false) goto L5;
        String r0 = fq.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer r1 = new StringBuffer();
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r3 >= r0.length()) goto L10;
        r1.append((char) (r0.charAt(r3) - (r3 % 48)));
        r3 = r3 + 1;
        goto L8
    L10:
        String r4 = r1.toString();
        StringBuffer r5 = new StringBuffer();
    L12:
        if (r2 >= (r4.length() / 2)) goto L14;
        r5.append((char) ((r4.charAt(r2) + r4.charAt((r4.length() - 1) - r2)) / 2));
        r2 = r2 + 1;
        goto L12
    L14:
        String r6 = r5.toString();
        this.g = r6;
        return r6;
    L5:
        return this.g;
    }

    public final String a(String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        r0.put(fx.c("LdGlk"), r3);     // Catch: Throwable -> L5
        r0.put(fx.c("FZGl1"), r4);     // Catch: Throwable -> L5
        r0.put(fx.c("AZGl1Mg"), r5);     // Catch: Throwable -> L5
        r0.put(fx.c("EZGl1Mw"), r6);     // Catch: Throwable -> L5
    L7:
        String r7 = r0.toString();
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return null;
    L10:
        String r8 = j.a();
        if (TextUtils.isEmpty(r8) == true) goto L18;
        String r9 = e.a(ag.a((r7 + "\u0000").getBytes(), r8.getBytes()));
        if (TextUtils.isEmpty(r9) == true) goto L18;
        return fx.c("Fa2V5PQ") + URLEncoder.encode(e.a(i.a(r8.getBytes("utf-8"), i.a(d())))) + fx.c("SJmRhdGE9") + URLEncoder.encode(r9);
    L16:
        th = move-exception;
        th.printStackTrace();
    L18:
        return null;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public final synchronized Map<String, String> b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f == false) goto L9;
        monitor-exit(this);
        return null;
    L9:
        f = true;     // Catch: Throwable -> L12
        HashMap r0 = new HashMap();     // Catch: Throwable -> L12
        r0.put(fx.c("FZW50"), fx.c("FMg"));     // Catch: Throwable -> L12
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L12
        StringBuilder r2 = r1.append(fx.c("SY2hhbm5lbD0"));     // Catch: Throwable -> L12
        String r3 = f5604b;     // Catch: Throwable -> L12
        StringBuilder r4 = r2.append(r3).append(fx.c("SJmRpdj0"));     // Catch: Throwable -> L12
        String r5 = d;     // Catch: Throwable -> L12
        r4.append(r5);     // Catch: Throwable -> L12
        StringBuffer r6 = new StringBuffer();     // Catch: Throwable -> L12
        r6.append(r3).append(r5).append(fx.c("FQA")).append(c);     // Catch: Throwable -> L12
        r1.append(fx.c("FJnNpZ249")).append(j.a(r6.toString()).toUpperCase(Locale.US));     // Catch: Throwable -> L12
        r1.append(fx.c("SJm91dHB1dD1qc29u") + "\u0000");     // Catch: Throwable -> L12
        r0.put(fx.c("FaW4"), e.a(ag.a(r1.toString().getBytes(), f5603a.getBytes())));     // Catch: Throwable -> L12
        r0.put(fx.c("Sa2V5dA"), e);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    }
}
