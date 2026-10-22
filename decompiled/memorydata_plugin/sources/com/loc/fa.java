package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fa {
    private static fa f;
    private static long i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f5522b;
    private LinkedHashMap<String, Long> c;
    private File d;
    private String e;
    private Context g;
    private boolean h;

    static {
    }

    private fa(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.c = new LinkedHashMap();
        this.e = null;
        this.f5521a = "";
        this.f5522b = null;
        Context r6 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.g = r6;
        String r7 = r6.getFilesDir().getPath();
        if (this.e != null) goto L11;
        this.e = fd.l(this.g);
    L11:
        this.d = new File(r7, "reportRecorder");     // Catch: Throwable -> L7
    L9:
        c();
        return;
    L7:
        th = move-exception;
        de.a(th);
        goto L9
    }

    public static synchronized fa a(Context r3) {
        monitor-enter(fa.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (f != null) goto L7;
        f = new fa(r4);     // Catch: Throwable -> L10
    L7:
        fa r5 = f;     // Catch: Throwable -> L10
        monitor-exit(fa.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean b(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (this.f5522b != null) goto L6;
        this.f5522b = fc.a(r6, "pref", "lastavedate", "0");
    L6:
        if (this.f5522b.equals(this.f5521a) == false) goto L9;
        return false;
    L9:
        SharedPreferences.Editor r7 = fc.a(r6, "pref");
        fc.a(r7, "lastavedate", this.f5521a);
        fc.a(r7);
        this.f5522b = this.f5521a;
        return true;
    }

    private synchronized void c() {
        monitor-enter(this);
        LinkedHashMap<String, Long> r0 = this.c;     // Catch: Throwable -> L30
        if (r0 != null) goto L6;
    L34:
        this.f5521a = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));     // Catch: Throwable -> L26
        Iterator<String> r1 = fd.a(this.d).iterator();     // Catch: Throwable -> L26
    L10:
        if (r1.hasNext() == false) goto L24;
        String[] r2 = new String(eh.b(fq.b((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")), this.e), RpcUtils.CHARSET_UTF8).split(",");     // Catch: Throwable -> L19 UnsupportedEncodingException -> L21
        if (r2 == null) goto L10;
        if (r2.length <= 1) goto L10;
        this.c.put(r2[0], Long.valueOf(Long.parseLong(r2[1])));     // Catch: Throwable -> L19 UnsupportedEncodingException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        goto L10
    L24:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
        return;
    L6:
        if (r0.size() <= 0) goto L34;
        monitor-exit(this);
        return;
    L30:
        th = move-exception;
        throw th;
    }

    private void d() {
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L15
        Iterator<Map.Entry<String, Long>> r2 = this.c.entrySet().iterator();     // Catch: Throwable -> L15
    L5:
        if (r2.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        r1.append(fq.b(eh.a((((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin")) + "," + r3.getValue()).getBytes(RpcUtils.CHARSET_UTF8), this.e)) + "\n");     // Catch: UnsupportedEncodingException -> L9 Throwable -> L15
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L5
    L11:
        String r0 = r1.toString();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r0) == true) goto L26;
        fd.a(this.d, r0);     // Catch: Throwable -> L15
        return;
    L26:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
    }

    public final synchronized void a() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.h == false) goto L6;
        d();     // Catch: Throwable -> L8
        this.h = false;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void a(AMapLocation r7) {
        monitor-enter(this);
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L52
        return;
    L52:
        th = move-exception;
        throw th;
    L4:
        if (this.c.containsKey(this.f5521a) == true) goto L8;
        if (this.c.size() < 8) goto L8;
    L11:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L48
        Iterator<Map.Entry<String, Long>> r1 = this.c.entrySet().iterator();     // Catch: Throwable -> L48
    L13:
        if (r1.hasNext() == false) goto L21;
        r0.add(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey());     // Catch: Throwable -> L19
    L17:
        if (r0.size() != (this.c.size() - 7)) goto L13;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L48
    L21:
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L48
    L23:
        if (r2.hasNext() == false) goto L26;
        this.c.remove((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48
    L26:
        if (r7.getErrorCode() == 0) goto L30;
        monitor-exit(this);
        return;
    L30:
        if (r7.getLocationType() != 6) goto L32;
    L46:
        monitor-exit(this);
        return;
    L32:
        if (r7.getLocationType() == 5) goto L46;
        if (this.c.containsKey(this.f5521a) == false) goto L37;
        long r3 = ((Long) ZeusTransformUtils.preCheckCast(this.c.get(this.f5521a), Long.class, "com.obric.memorydata.plugin")).longValue() + 1;     // Catch: Throwable -> L48
        i = r3;     // Catch: Throwable -> L48
        this.c.put(this.f5521a, Long.valueOf(r3));     // Catch: Throwable -> L48
    L38:
        long r4 = i;     // Catch: Throwable -> L48
        if (r4 != 0) goto L41;
    L43:
        this.h = true;     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L41:
        if ((r4 % 100) != 0) goto L43;
        a();     // Catch: Throwable -> L48
        goto L43
    L37:
        this.c.put(this.f5521a, 1L);     // Catch: Throwable -> L48
        i = 1;     // Catch: Throwable -> L48
    L8:
        if (this.c.containsKey(this.f5521a) == false) goto L26;
        if (this.c.size() < 9) goto L26;
        goto L11
    }

    public final synchronized void b() {
        monitor-enter(this);
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L4:
        if (b(this.g) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<Map.Entry<String, Long>> r0 = this.c.entrySet().iterator();     // Catch: Throwable -> L21
    L8:
        if (r0.hasNext() == false) goto L19;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L8
    L12:
        if (this.f5521a.equals(r1.getKey()) == true) goto L8;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L16
        r2.put("param_long_first", r1.getKey());     // Catch: Throwable -> L16
        r2.put("param_long_second", r1.getValue());     // Catch: Throwable -> L16
        fb.a(this.g, "O023", r2);     // Catch: Throwable -> L16
    L19:
        monitor-exit(this);
    }
}
