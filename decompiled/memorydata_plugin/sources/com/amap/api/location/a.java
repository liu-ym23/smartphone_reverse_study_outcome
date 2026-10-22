package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.loc.cc;
import com.loc.ev;
import com.loc.ex;
import com.loc.fb;
import com.loc.fp;
import com.loc.fu;
import com.loc.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    cc f492b;

    public a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        b(r5);
        if (r5 == null) goto L9;
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f491a = r0;     // Catch: Throwable -> L6
        ex.a(r0);     // Catch: Throwable -> L6
        this.f492b = new cc(r5, null, null);     // Catch: Throwable -> L6
        return;
    L9:
        throw new IllegalArgumentException("Context参数不能为null");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        ev.a(th, "AMClt", "ne1");
    }

    public static String a(Context r2) {
        return fp.q((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static void a(Context r2, boolean r3) {
        u.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, ev.c());
    }

    public static void a(Context r2, boolean r3, boolean r4) {
        u.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, ev.c());
    }

    private static void b(Context r2) {
        fu r3 = u.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), ev.c());
        if (r3.f5592a != u.c.f5641a) goto L5;
        return;
    L5:
        Log.e("AMapLocationClient", r3.f5593b);
        throw new Exception(r3.f5593b);
    }

    public void a() {
        cc r2 = this.f492b;     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.b();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        ev.a(th, "AMClt", "stl");
    }

    public void a(AMapLocationClientOption r3) {
        if (r3 == null) goto L16;
        cc r0 = this.f492b;     // Catch: Throwable -> L13
        if (r0 == null) goto L7;
        r0.a(r3);     // Catch: Throwable -> L13
    L7:
        if (r3.f477b == false) goto L20;
        r3.f477b = false;     // Catch: Throwable -> L13
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r3.c) == true) goto L11;
        r1.put("amap_loc_scenes_type", r3.c);     // Catch: Throwable -> L13
    L11:
        fb.a(this.f491a, "O019", r1);     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L16:
        throw new IllegalArgumentException("LocationManagerOption参数不能为null");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        ev.a(th, "AMClt", "sLocnO");
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        cc r2 = this.f492b;     // Catch: Throwable -> L8
        if (r2 == null) goto L15;
        r2.a(r4);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        throw new IllegalArgumentException("listener参数不能为null");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        ev.a(th, "AMClt", "sLocL");
    }

    public void a(boolean r2) {
        cc r1 = this.f492b;     // Catch: Throwable -> L6
        if (r1 == null) goto L11;
        r1.a(r2);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        ev.a(th, "AMClt", "dBackL");
    }

    public void b() {
        cc r2 = this.f492b;     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.c();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        ev.a(th, "AMClt", "stl");
    }

    public void b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        cc r2 = this.f492b;     // Catch: Throwable -> L7
        if (r2 == null) goto L12;
        r2.b(r4);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        ev.a(th, "AMClt", "unRL");
    }

    public String c() {
        return "6.4.8";
    }

    public void d() {
        cc r2 = this.f492b;     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.d();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        ev.a(th, "AMClt", "onDy");
    }
}
