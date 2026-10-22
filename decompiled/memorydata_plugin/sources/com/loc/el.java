package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.ArrayList;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class el {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5495a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5496b = 2;
    private static el e;
    private long c;
    private boolean d;
    private ArrayList<String> f;
    private dn g;
    private dn h;
    private long i;
    private Context j;
    private String k;
    private boolean l;

    static {
    }

    private el(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.c = 0;
        this.d = false;
        this.f = new ArrayList();
        this.g = new dn();
        this.h = new dn();
        this.i = 120000;
        this.l = false;
        this.j = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ long a(el r0, long r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ Context a(el r0) {
        return r0.j;
    }

    static /* synthetic */ dn a(el r0, int r1) {
        return r0.b(r1);
    }

    public static synchronized el a(Context r3) {
        monitor-enter(el.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (e != null) goto L7;
        e = new el(r4);     // Catch: Throwable -> L10
    L7:
        el r5 = e;     // Catch: Throwable -> L10
        monitor-exit(el.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean a(String[] r0, String[] r1) {
        return b(r0, r1);
    }

    static /* synthetic */ String[] a(JSONArray r0, int r1) {
        return b(r0, r1);
    }

    private dn b(int r2) {
        if (r2 != f5496b) goto L7;
        return this.h;
    L7:
        return this.g;
    }

    static /* synthetic */ void b(el r0, int r1) {
        r0.f(r1);
    }

    private synchronized void b(boolean r9, final int r10) {
        monitor-enter(this);
        if (r9 == true) goto L11;
    L27:
        th = move-exception;
        throw th;
    L5:
        if (eu.p() == true) goto L11;
        if (this.l == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (this.c == 0) goto L21;
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L27
        long r2 = this.c;     // Catch: Throwable -> L27
        if ((r0 - r2) >= this.i) goto L18;
        monitor-exit(this);
        return;
    L18:
        if ((r0 - r2) >= 60000) goto L21;
        monitor-exit(this);
        return;
    L21:
        this.c = System.currentTimeMillis();     // Catch: Throwable -> L27
        this.l = true;     // Catch: Throwable -> L27
        StackTraceElement[] r11 = Thread.currentThread().getStackTrace();     // Catch: Throwable -> L27
        StringBuffer r1 = new StringBuffer();     // Catch: Throwable -> L27
        int r3 = r11.length;     // Catch: Throwable -> L27
        int r4 = 0;
    L22:
        if (r4 >= r3) goto L24;
        StackTraceElement r5 = r11[r4];     // Catch: Throwable -> L27
        r1.append(r5.getClassName() + "(" + r5.getMethodName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r5.getLineNumber() + "),");     // Catch: Throwable -> L27
        r4 = r4 + 1;     // Catch: Throwable -> L27
        goto L22
    L24:
        bp.a().b(new AnonymousClass1(this, r10));     // Catch: Throwable -> L27
        monitor-exit(this);
    }

    private static boolean b(String[] r5, String[] r6) {
        if (r5 != null) goto L5;
    L22:
        return false;
    L5:
        if (r5.length == 0) goto L22;
        if (r6 == null) goto L22;
        if (r6.length == 0) goto L22;
        if (r5.length == r6.length) goto L14;
        return false;
    L14:
        int r1 = r5.length;
        int r2 = 0;
    L15:
        if (r2 >= r1) goto L20;
        if (r5[r2].equals(r6[r2]) == false) goto L18;
        r2 = r2 + 1;
        goto L15
    L18:
        return false;
    L20:
        return true;
    }

    private static String[] b(JSONArray r6, int r7) {
        int r0 = 0;
        if (r6 == null) goto L18;
        if (r6.length() == 0) goto L18;
        int r1 = r6.length();
        String[] r2 = new String[r1];
    L8:
        if (r0 >= r1) goto L16;
        String r3 = r6.getString(r0);
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (r7 != f5496b) goto L14;
        r3 = "[" + r3 + "]";
    L14:
        r2[r0] = r3;
    L15:
        r0 = r0 + 1;
        goto L8
    L16:
        return r2;
    L18:
        return new String[0];
    }

    private static String c(int r1) {
        if (r1 != f5496b) goto L6;
        return "last_ip_6";
    L6:
        return "last_ip_4";
    }

    private void d(int r3) {
        if (b(r3).d() == false) goto L6;
        SharedPreferences.Editor r0 = fc.a(this.j, "cbG9jaXA");
        fc.a(r0, c(r3));
        fc.a(r0);
        b(r3).a(false);
        return;
    }

    private String e(int r7) {
        int r0 = 0;
        b(false, r7);
        String[] r1 = b(r7).a();
        if (r1 != null) goto L5;
    L19:
        g(r7);
        return b(r7).b();
    L5:
        if (r1.length <= 0) goto L19;
        int r2 = r1.length;
    L8:
        if (r0 >= r2) goto L13;
        String r4 = r1[r0];
        if (this.f.contains(r4) == false) goto L15;
        r0 = r0 + 1;
    L15:
        if (TextUtils.isEmpty(r4) == false) goto L17;
        return null;
    L17:
        b(r7).a(r4);
        return r4;
    L13:
        r4 = null;
        goto L15
    }

    private void f(int r3) {
        if (b(r3).a() != null) goto L5;
        return;
    L5:
        if (b(r3).a().length <= 0) goto L16;
        String r0 = b(r3).a()[0];
        if (r0.equals(this.k) == false) goto L10;
        return;
    L10:
        if (this.f.contains(r0) == true) goto L15;
        this.k = r0;
        SharedPreferences.Editor r2 = fc.a(this.j, "cbG9jaXA");
        fc.a(r2, c(r3), r0);
        fc.a(r2);
        return;
    L15:
        return;
    }

    private void g(int r5) {
        String r0 = fc.a(this.j, "cbG9jaXA", c(r5), null);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        if (this.f.contains(r0) == true) goto L9;
        b(r5).a(r0);
        b(r5).b(r0);
        b(r5).a(true);
        return;
    }

    public final String a(ep r6, int r7) {
        if (eu.q() == true) goto L6;
        return null;
    L6:
        if (r6 == null) goto L27;
        String r1 = r6.c();     // Catch: Throwable -> L28
        String r2 = new URL(r1).getHost();     // Catch: Throwable -> L28
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(r1) == true) goto L27;
        if ("abroad.apilocate.amap.com".equals(r2) == true) goto L27;
        if ("apilocate.amap.com".equalsIgnoreCase(r2) == false) goto L15;
        String r3 = "httpdns.apilocate.amap.com";
    L17:
        if (fn.g(r3) == true) goto L19;
        return null;
    L19:
        String r5 = e(r7);     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r5) == true) goto L27;
        r6.d(r1.replace(r2, r5));     // Catch: Throwable -> L28
        r6.a().put("host", r3);     // Catch: Throwable -> L28
        r6.e(r3);     // Catch: Throwable -> L28
        if (r7 != f5496b) goto L24;
        boolean r8 = true;
    L25:
        r6.a(r8);     // Catch: Throwable -> L28
        return r5;
    L24:
        r8 = false;
        goto L25
    L15:
        r3 = r2;
    L27:
        return null;
    }

    public final void a(int r3) {
        if (b(r3).e() == true) goto L6;
        this.f.add(b(r3).b());
        d(r3);
        b(true, r3);
        return;
    L6:
        d(r3);
    }

    public final void a(boolean r3, int r4) {
        b(r4).b(r3);
        if (r3 == false) goto L10;
        String r5 = b(r4).c();
        String r0 = b(r4).b();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return;
    L7:
        if (r0.equals(r5) == true) goto L12;
        SharedPreferences.Editor r2 = fc.a(this.j, "cbG9jaXA");
        fc.a(r2, c(r4), r0);
        fc.a(r2);
        return;
    L12:
        return;
    }
}
