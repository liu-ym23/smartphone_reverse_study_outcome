package com.bytedance.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f995a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f996b;
    private Vector<C0075a> c;
    private Vector<C0075a> d;
    private String e;
    private Context f;

    /* JADX INFO: renamed from: com.bytedance.a.a$a, reason: collision with other inner class name */
    private class C0075a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f998b;
        private String c;
        private String d;
        private String e;
        private int f;

        public C0075a(a r1) {
            this.f997a = r1;
        }

        static /* synthetic */ String a(C0075a r0) {
            return r0.f998b;
        }

        static /* synthetic */ String b(C0075a r0) {
            return r0.d;
        }

        public void a(String r4, String r5, int r6) {
            PackageInfo r0 = d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(this.f997a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
            if (r0 != null) goto L5;
            b.c(a.a(), "Get package info failed! package:" + r4);
            String r1 = "";
            this.c = "";
        L6:
            this.e = r1;
            this.f = r6;
            this.f998b = r4;
            this.d = r5;
            return;
        L5:
            this.c = r0.packageName;
            r1 = r0.versionName;
            goto L6
        }
    }

    static {
    }

    public a() {
        this.f996b = -1;
        this.c = new Vector();
        this.d = new Vector();
    }

    static /* synthetic */ Context a(a r0) {
        return r0.f;
    }

    static /* synthetic */ String a() {
        return f995a;
    }

    private void c(String r4) {
        if (b.a() == true) goto L5;
        return;
    L5:
        byte[] r3 = d.b(this.f, r4);
        if (r3 != null) goto L8;
    L12:
        b.c(f995a, "Get subject app signature failed! app:" + r4);
        return;
    L8:
        if (r3.length == 0) goto L12;
        b.a(f995a, "packageName:" + r4 + " signHash:" + d.a(r3));
    }

    private int d(String r10) {
        FileReader r0 = new FileReader(r10);     // Catch: JSONException -> L26 IOException -> L28
        char[] r11 = new char[1024];     // Catch: Throwable -> L20
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L20
    L5:
        int r2 = r0.read(r11);     // Catch: Throwable -> L20
        if (r2 <= 0) goto L8;
        r1.append(r11, 0, r2);     // Catch: Throwable -> L20
        goto L5
    L8:
        JSONObject r12 = new JSONObject(r1.toString());     // Catch: Throwable -> L20
        String r3 = r12.getString(Params.CONTENT);     // Catch: Throwable -> L20
        this.e = r12.getString("signature");     // Catch: Throwable -> L20
        JSONObject r13 = new JSONObject(r3);     // Catch: Throwable -> L20
        this.f996b = r13.getInt("version");     // Catch: Throwable -> L20
        b.b(f995a, "Authorized apps file version:" + this.f996b);     // Catch: Throwable -> L20
        JSONArray r4 = new JSONArray(r13.getString("subject_apps"));     // Catch: Throwable -> L20
        int r5 = 0;
    L11:
        if (r5 >= r4.length()) goto L13;
        JSONObject r6 = r4.getJSONObject(r5);     // Catch: Throwable -> L20
        String r7 = r6.getString("package");     // Catch: Throwable -> L20
        String r8 = r6.getString("sign");     // Catch: Throwable -> L20
        C0075a r9 = new C0075a(this);     // Catch: Throwable -> L20
        r9.a(r7, r8, 1);     // Catch: Throwable -> L20
        this.c.add(r9);     // Catch: Throwable -> L20
        c(r7);     // Catch: Throwable -> L20
        r5 = r5 + 1;     // Catch: Throwable -> L20
        goto L11
    L13:
        JSONArray r14 = new JSONArray(r13.getString("target_apps"));     // Catch: Throwable -> L20
        int r15 = 0;
    L14:
        if (r15 >= r14.length()) goto L18;
        JSONObject r16 = r14.getJSONObject(r15);     // Catch: Throwable -> L20
        String r17 = r16.getString("package");     // Catch: Throwable -> L20
        String r18 = r16.getString("sign");     // Catch: Throwable -> L20
        C0075a r19 = new C0075a(this);     // Catch: Throwable -> L20
        r19.a(r17, r18, 2);     // Catch: Throwable -> L20
        this.d.add(r19);     // Catch: Throwable -> L20
        c(r17);     // Catch: Throwable -> L20
        r15 = r15 + 1;
        goto L14
    L18:
        r0.close();     // Catch: JSONException -> L26 IOException -> L28
        return 0;
    L20:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: JSONException -> L26 IOException -> L28
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: JSONException -> L26 IOException -> L28
    L28:
        e = move-exception;
        String r110 = f995a;
        StringBuilder r20 = new StringBuilder().append("Parse authorized apps failed, IOException error:");
        String r21 = e.getMessage();
    L30:
        b.c(r110, r20.append(r21).toString());
        return 3;
    L26:
        e = move-exception;
        r110 = f995a;
        r20 = new StringBuilder().append("Parse authorized apps failed, JSONException error:");
        r21 = e.getMessage();
        goto L30
    }

    public int a(Context r5, String r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
    L24:
        String r4 = f995a;
        String r9 = "Input init param is invalid!!";
    L9:
        b.c(r4, r9);
        return 1;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L24;
        if (r7 == 1) goto L11;
        r4 = f995a;
        r9 = "Not supported vendor type!!";
        goto L9
    L11:
        String r0 = f995a;
        b.b(r0, "Init file:" + r6);
        this.f = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        File r10 = new File(r6);
        if (r10.exists() == true) goto L14;
    L22:
        b.c(r0, "File not exist:" + r6);
        return 2;
    L14:
        if (r10.isFile() == false) goto L22;
        int r11 = new c().a(r6, r7);
        if (r11 == 0) goto L21;
        b.c(r0, "Authorized apps file signature verify failed, result:" + r11);
        return r11;
    L21:
        return d(r6);
    }

    public boolean a(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L8;
        String r7 = f995a;
        String r9 = "Input subject app is invalid!!";
    L5:
        b.c(r7, r9);
        return false;
    L8:
        if (this.c.isEmpty() == false) goto L10;
        r7 = f995a;
        r9 = "Authorized subject apps are not initialized!!";
        goto L5
    L10:
        Iterator<C0075a> r0 = this.c.iterator();
    L12:
        if (r0.hasNext() == false) goto L27;
        C0075a r2 = (C0075a) ZeusTransformUtils.preCheckCast(r0.next(), C0075a.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(r8, C0075a.a(r2)) == false) goto L12;
        byte[] r3 = d.b(this.f, r8);
        if (r3 == null) goto L25;
        if (r3.length == 0) goto L25;
        String r4 = d.a(r3);
        String r5 = f995a;
        b.a(r5, "packageName:" + r8 + " signHash:" + r4);
        if (TextUtils.equals(r4, C0075a.b(r2)) == true) goto L22;
        b.c(r5, "App signature is invalid:" + r4 + " app:" + r8);
        goto L12
    L22:
        b.a(r5, "Check subject app:" + r8 + " success!");
        return true;
    L25:
        r7 = f995a;
        StringBuilder r1 = new StringBuilder();
        String r6 = "Get subject app signature failed! app:";
    L26:
        r9 = r1.append(r6).append(r8).toString();
        goto L5
    L27:
        r7 = f995a;
        r1 = new StringBuilder();
        r6 = "Not valid subject app:";
        goto L26
    }

    public boolean b(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L8;
        String r7 = f995a;
        String r9 = "Input target app is invalid!!";
    L5:
        b.c(r7, r9);
        return false;
    L8:
        if (this.d.isEmpty() == false) goto L10;
        r7 = f995a;
        r9 = "Authorized target apps are not initialized!!";
        goto L5
    L10:
        Iterator<C0075a> r0 = this.d.iterator();
    L12:
        if (r0.hasNext() == false) goto L27;
        C0075a r2 = (C0075a) ZeusTransformUtils.preCheckCast(r0.next(), C0075a.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(r8, C0075a.a(r2)) == false) goto L12;
        byte[] r3 = d.b(this.f, r8);
        if (r3 == null) goto L25;
        if (r3.length == 0) goto L25;
        String r4 = d.a(r3);
        String r5 = f995a;
        b.a(r5, "packageName:" + r8 + " signHash:" + r4);
        if (TextUtils.equals(r4, C0075a.b(r2)) == true) goto L22;
        b.c(r5, "App signature is invalid:" + r4 + " app:" + r8);
        goto L12
    L22:
        b.a(r5, "Check target app:" + r8 + " success!");
        return true;
    L25:
        r7 = f995a;
        StringBuilder r1 = new StringBuilder();
        String r6 = "Get target app signature failed! app:";
    L26:
        r9 = r1.append(r6).append(r8).toString();
        goto L5
    L27:
        r7 = f995a;
        r1 = new StringBuilder();
        r6 = "Not valid target app:";
        goto L26
    }
}
