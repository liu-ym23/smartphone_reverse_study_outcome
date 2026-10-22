package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5324a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ar f5325b;
    private final Map<String, Map<String, List<String>>> c;
    private final Map<String, List<String>> d;
    private final List<String> e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5327b;
        public String c;

        public a(String r2, String r3) {
            this.f5326a = null;
            this.f5327b = r2;
            this.c = r3;
        }

        public a(URL r2) {
            this.f5326a = r2.getProtocol();
            this.f5327b = r2.getHost();
            this.c = r2.getPath();
        }
    }

    static {
    }

    public ar() {
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new ArrayList();
    }

    private static a a(a r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.c != null) goto L9;
        return r4;
    L9:
        if (r4.c.length() != 0) goto L12;
        return r4;
    L12:
        if (r4.c.charAt(r4.c.length() - 1) != '/') goto L15;
        r4.c = r4.c.substring(0, r4.c.length() - 1);
    L15:
        if (r4.c.charAt(0) != '/') goto L17;
        r4.c = r4.c.substring(1);
        goto L15
    L17:
        return r4;
    }

    public static synchronized ar a() {
        monitor-enter(ar.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f5325b != null) goto L7;
        f5325b = new ar();     // Catch: Throwable -> L10
    L7:
        ar r1 = f5325b;     // Catch: Throwable -> L10
        monitor-exit(ar.class);
        return r1;
    }

    private static boolean a(String r4, String r5) {
        String[] r6 = r4.split("/");
        String[] r7 = r5.split("/");
        if (r7.length >= r6.length) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r6.length) goto L14;
        if (r6[r0].equals("*") == true) goto L13;
        if (r6[r0].equals(r7[r0]) == true) goto L13;
        return false;
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        return true;
    }

    private static a b(String r6) {
        return new a(new URL(r6));
    L4:
        String r1 = null;
        if (r6.contains("://") == false) goto L8;
        return null;
    L8:
        if (r6.startsWith("/") == false) goto L10;
        r6 = r6.substring(1);
        goto L8
    L10:
        String[] r7 = r6.split("/");
        int r2 = 0;
        if (r7[0].contains(".") == false) goto L13;
        r1 = r7[0];
        r2 = 1;
    L13:
        StringBuilder r4 = new StringBuilder();
    L15:
        if (r2 >= r7.length) goto L21;
        if (r4.length() <= 0) goto L19;
        r4.append("/");
    L19:
        r4.append(r7[r2]);
        r2 = r2 + 1;
        goto L15
    L21:
        if (r4.length() <= 0) goto L26;
        if (r4.charAt(r4.length() - 1) != '/') goto L26;
        r4.deleteCharAt(r4.length() - 1);
    L26:
        return new a(r1, r4.toString());
    }

    private synchronized boolean b(a r6) {
        monitor-enter(this);
        if (r6 != null) goto L44;
    L42:
        monitor-exit(this);
        return false;
    L44:
    L39:
        th = move-exception;
        throw th;
    L6:
        if (r6.c.length() == 0) goto L42;
        Map<String, List<String>> r1 = this.d;     // Catch: Throwable -> L39
        if (r6.f5326a != null) goto L11;
    L13:
        List<String> r2 = this.e;     // Catch: Throwable -> L39
        boolean r3 = f5324a;     // Catch: Throwable -> L39
        if (r3 == true) goto L20;
        if (r1 != null) goto L20;
        throw new AssertionError();     // Catch: Throwable -> L39
    L20:
        if (r6.f5327b != null) goto L22;
    L24:
        if (r3 == true) goto L29;
        if (r2 != null) goto L29;
        throw new AssertionError();     // Catch: Throwable -> L39
    L29:
        Iterator<String> r4 = r2.iterator();     // Catch: Throwable -> L39
    L31:
        if (r4.hasNext() == false) goto L37;
        if (a((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"), r6.c) == false) goto L31;
        monitor-exit(this);
        return true;
    L37:
        monitor-exit(this);
        return false;
    L22:
        if (r1.containsKey(r6.f5327b) == false) goto L24;
        r2 = (List) ZeusTransformUtils.preCheckCast(r1.get(r6.f5327b), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        goto L24
    L11:
        if (this.c.containsKey(r6.f5326a) == false) goto L13;
        r1 = (Map) ZeusTransformUtils.preCheckCast(this.c.get(r6.f5326a), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        goto L13
    }

    public final boolean a(String r3) {
        if (r3 != null) goto L5;
    L12:
        return false;
    L5:
        if (r3.length() == 0) goto L12;
        a r4 = a(b(r3));
        if (r4 != null) goto L11;
        return false;
    L11:
        return b(r4);
    }
}
