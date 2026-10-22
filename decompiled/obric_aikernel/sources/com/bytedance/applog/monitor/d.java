package com.bytedance.applog.monitor;

import android.content.Context;
import android.util.Log;
import f1.g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f1207c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f1208d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f1210b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f1211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<JSONObject> f1212b;

        a() {
            this.f1211a = 0;
            this.f1212b = new ArrayList();
        }
    }

    static {
        f1207c = Collections.singletonList("Store");
        f1208d = System.getProperty("line.separator", "\n");
    }

    protected d(Context r10, String r11, g r12) {
        this.f1210b = r12;
        this.f1209a = r10.getFilesDir() + "/" + r11 + "monitor_file";
    }

    private void a(Closeable r10) {
        if (r10 == null) goto L10;
        r10.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        this.f1210b.r(8, f1207c, "[close] error ", th, new Object[0]);
        return;
    }

    private a d(String r11) {
        a r10 = new a();
        if (new File(r11).exists() == true) goto L6;
        this.f1210b.b(8, f1207c, "[loadByLine] not exists file: {}", new Object[]{r11});
        return r10;
    L6:
        Closeable r12 = null;
        FileInputStream r13 = new FileInputStream(r11);     // Catch: Throwable -> L32 Exception -> L34
        InputStreamReader r14 = new InputStreamReader(r13, "UTF-8");     // Catch: Throwable -> L28 Exception -> L30
        BufferedReader r15 = new BufferedReader(r14);     // Catch: Throwable -> L24 Exception -> L26
        int r16 = 0;
    L47:
        String r17 = r15.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (r17 == null) goto L18;
        Log.d("Store", "[loadByLine]:lineIndex:" + r16 + ",line:" + r17);     // Catch: Throwable -> L20 Exception -> L22
        if (r16 != 0) goto L16;
        r10.f1211a = Long.parseLong(r17);     // Catch: Throwable -> L20 Exception -> L22
    L17:
        r16 = r16 + 1;
        goto L47
    L16:
        r10.f1212b.add(new JSONObject(r17));     // Catch: Throwable -> L20 Exception -> L22
        goto L17
    L18:
        a(r15);
        a(r14);
        a(r13);
        return r10;
    L22:
        e = move-exception;
        Exception r18 = e;
        FileInputStream r19 = r13;
        r12 = r15;
    L43:
        this.f1210b.r(8, f1207c, "load lines error ", r18, new Object[0]);     // Catch: Throwable -> L39
        a(r12);
        a(r14);
        a(r19);
        return r10;
    L39:
        th = th;
        r13 = r19;
    L41:
        a(r12);
        a(r14);
        a(r13);
        throw th;
    L20:
        th = th;
        r12 = r15;
        goto L41
    L26:
        e = move-exception;
        r19 = r13;
        r18 = e;
    L24:
        th = th;
        goto L41
    L30:
        e = move-exception;
        r18 = e;
        r14 = null;
        r19 = r13;
    L28:
        th = th;
        r14 = null;
        goto L41
    L34:
        e = move-exception;
        r18 = e;
        r14 = null;
        r19 = null;
    L32:
        th = th;
        r14 = null;
        r13 = null;
        goto L41
    }

    private void f(String r10, long r11, List<JSONObject> r12) {
        Closeable r13 = null;
        FileOutputStream r14 = new FileOutputStream(r10);     // Catch: Throwable -> L26
        OutputStreamWriter r15 = new OutputStreamWriter(r14, "UTF-8");     // Catch: Throwable -> L23
        BufferedWriter r16 = new BufferedWriter(r15);     // Catch: Throwable -> L21
        r16.write(r11 + f1208d);     // Catch: Throwable -> L19
        if (r12 != null) goto L9;
    L17:
        a(r16);
        a(r15);
        a(r14);
        return;
    L9:
        if (r12.size() == 0) goto L17;
        int r17 = 0;
    L13:
        if (r17 >= r12.size()) goto L16;
        r16.write(r12.get(r17).toString() + f1208d);     // Catch: Throwable -> L19
        r17 = r17 + 1;
        goto L13
    L16:
        a(r16);
        a(r15);
        a(r14);
        return;
    L19:
        th = move-exception;
        Throwable r18 = th;
        r13 = r14;
        Closeable r19 = r16;
    L38:
        this.f1210b.r(8, f1207c, "saveByLine error ", r18, new Object[0]);     // Catch: Throwable -> L31
        a(r19);
        a(r15);
        a(r13);
        return;
    L31:
        th = move-exception;
        a(r19);
        a(r15);
        a(r13);
        throw th;
    L21:
        th = move-exception;
        r18 = th;
        r19 = null;
    L25:
        r13 = r14;
    L23:
        th = move-exception;
        r18 = th;
        r15 = null;
        r19 = null;
    L26:
        th = move-exception;
        r18 = th;
        r15 = null;
        r19 = null;
        goto L38
    }

    void b() {
        File r10 = new File(this.f1209a);
        if (r10.exists() == false) goto L6;
        r10.delete();
        return;
    }

    a c() {
        a r10 = d(this.f1209a);
        this.f1210b.n(8, f1207c, "[loadRecords]: ts:" + r10.f1211a + ",jsonObjects:" + r10.f1212b.size(), new Object[0]);
        return r10;
    }

    void e(long r10, List<JSONObject> r11) {
        this.f1210b.n(8, f1207c, "[saveRecords]: lastReportTS:" + r10 + ",jsonObjects:" + r11.size(), new Object[0]);
        f(this.f1209a, r10, r11);
    }
}
