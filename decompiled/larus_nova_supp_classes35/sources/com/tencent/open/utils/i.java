package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.tencent.open.log.SLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class i {
    private static Map<String, i> a;
    private static String b;
    private Context c;
    private String d;
    private JSONObject e;
    private long f;
    private int g;
    private boolean h;

    static {
        a = Collections.synchronizedMap(new HashMap());
        b = null;
    }

    private void a() {
        this.e = new JSONObject(c("com.tencent.open.config.json"));     // Catch: JSONException -> L5
        return;
    L5:
        this.e = new JSONObject();
    }

    private void b() {
        if (this.g == 0) goto L6;
        d("update thread is running, return");
        return;
    L6:
        this.g = 1;
        final HashMap r0 = new HashMap();
        r0.put("appid", this.d);
        r0.put("status_os", Build.VERSION.RELEASE);
        r0.put("status_machine", f.a().c(g.a()));
        r0.put("status_version", Build.VERSION.SDK);
        r0.put("sdkv", "3.5.11.lite");
        r0.put("sdkp", "a");
        l.a(new AnonymousClass1(this, r0));
    }

    private void c() {
        int r0 = this.e.optInt("Common_frequency");
        if (r0 != 0) goto L6;
        r0 = 1;
    L6:
        if ((SystemClock.elapsedRealtime() - this.f) < (r0 * 3600000)) goto L9;
        b();
        return;
    }

    private String c(String r5) {
        String r0 = BuildConfig.FLAVOR;
    L9:
        InputStream r6 = this.c.getAssets().open(r5);     // Catch: IOException -> L30
    L10:
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r6, Charset.forName("UTF-8")));
        StringBuffer r2 = new StringBuffer();
    L33:
        String r3 = r1.readLine();     // Catch: Throwable -> L19 IOException -> L21
        if (r3 == null) goto L14;
        r2.append(r3);     // Catch: Throwable -> L19 IOException -> L21
        goto L33
    L14:
        r0 = r2.toString();     // Catch: Throwable -> L19 IOException -> L21
        r6.close();     // Catch: IOException -> L17
        r1.close();     // Catch: IOException -> L17
    L24:
        return r0;
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        r6.close();     // Catch: IOException -> L17
        r1.close();     // Catch: IOException -> L17
    L19:
        th = move-exception;
        r6.close();     // Catch: IOException -> L27
        r1.close();     // Catch: IOException -> L27
    L29:
        throw th;
    L27:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e.printStackTrace();
        return BuildConfig.FLAVOR;
    L4:
        if (this.d == null) goto L6;
        String r4 = r5 + "." + this.d;     // Catch: FileNotFoundException -> L9
    L7:
        r6 = this.c.openFileInput(r4);     // Catch: FileNotFoundException -> L9
        goto L10
    L6:
        r4 = r5;
        goto L7
    }

    private void d(String r2) {
        if (this.h == false) goto L6;
        SLog.v("openSDK_LOG.OpenConfig", r2 + "; appid: " + this.d);
        return;
    }

    public int a(String r3) {
        d("get " + r3);
        c();
        return this.e.optInt(r3);
    }

    public boolean b(String r3) {
        d("get " + r3);
        c();
        Object r4 = this.e.opt(r3);
        if (r4 != null) goto L6;
        return false;
    L6:
        if ((r4 instanceof Integer) == false) goto L10;
        return !r4.equals(0);
    L10:
        if ((r4 instanceof Boolean) == true) goto L12;
        return false;
    L12:
        return ((Boolean) r4).booleanValue();
    }

    private void a(JSONObject r3) {
        d("cgi back, do update");
        this.e = r3;
        a("com.tencent.open.config.json", r3.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    private i(Context r3, String r4) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = true;
        this.c = r3.getApplicationContext();
        this.d = r4;
        a();
        b();
    }

    private void a(String r3, String r4) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.d == null) goto L5;
        r3 = r3 + "." + this.d;     // Catch: IOException -> L7
    L5:
        OutputStreamWriter r0 = new OutputStreamWriter(this.c.openFileOutput(r3, 0), Charset.forName("UTF-8"));     // Catch: IOException -> L7
        r0.write(r4);     // Catch: IOException -> L7
        r0.flush();     // Catch: IOException -> L7
        r0.close();     // Catch: IOException -> L7
    }

    public static i a(Context r3, String r4) {
        Map<String, i> r0 = a;
        monitor-enter(r0);
        SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");     // Catch: Throwable -> L18
        if (r4 == null) goto L7;
        b = r4;     // Catch: Throwable -> L18
    L7:
        if (r4 != null) goto L12;
        r4 = b;     // Catch: Throwable -> L18
        if (r4 != null) goto L12;
        r4 = DocTabPayload.DocType.UNKNOWN;
    L12:
        i r1 = a.get(r4);     // Catch: Throwable -> L18
        if (r1 != null) goto L15;
        r1 = new i(r3, r4);     // Catch: Throwable -> L18
        a.put(r4, r1);     // Catch: Throwable -> L18
    L15:
        SLog.v("openSDK_LOG.OpenConfig", "getInstance end");     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r1;
    L18:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void a(i r0, JSONObject r1) {
        r0.a(r1);
    }

    public static /* synthetic */ int a(i r0, int r1) {
        r0.g = r1;
        return r1;
    }
}
