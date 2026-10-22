package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class fr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile b f5587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private z f5588b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static fr f5589a;

        static {
            f5589a = new fr();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f5590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5591b;
        private final boolean c;
        private boolean d;

        private b() {
            this.f5591b = 0;
            this.f5590a = true;
            this.c = true;
            this.d = false;
        }

        /* synthetic */ b(byte r1) {
            this();
        }

        public final void a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L6;
            return;
        L6:
            if (this.f5591b <= 0) goto L8;
            return;
        L8:
            if (Build.VERSION.SDK_INT < 4) goto L12;
            this.f5591b = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion;
            return;
        }

        public final void a(boolean r1) {
            this.f5590a = r1;
        }

        public final boolean a() {
            if (this.d == false) goto L5;
        L27:
            return true;
        L5:
            if (Build.VERSION.SDK_INT < 28) goto L7;
            boolean r0 = true;
        L9:
            if (this.f5590a == false) goto L19;
            int r5 = this.f5591b;
            if (r5 > 0) goto L13;
            r5 = 28;
        L13:
            if (r5 < 28) goto L15;
            boolean r6 = true;
        L16:
            if (r6 == true) goto L19;
            boolean r7 = false;
        L20:
            if (r0 == false) goto L23;
            if (r7 == false) goto L23;
            boolean r8 = true;
        L24:
            if (r8 == true) goto L27;
            return false;
        L23:
            r8 = false;
            goto L24
        L15:
            r6 = false;
        L19:
            r7 = true;
            goto L20
        L7:
            r0 = false;
            goto L9
        }
    }

    public fr() {
        this.f5587a = new b(0);
        this.f5588b = new z("HttpsDecisionUtil");
    }

    public static fr a() {
        return a.f5589a;
    }

    public static String a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        if (r2.startsWith(LocationInfoConst.HTTPS) == true) goto L13;
        Uri.Builder r1 = Uri.parse(r2).buildUpon();     // Catch: Throwable -> L9
        r1.scheme(LocationInfoConst.HTTPS);     // Catch: Throwable -> L9
        return r1.build().toString();
    L14:
        return r2;
    L13:
        return r2;
    }

    public static void b(Context r2) {
        b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), true);
    }

    private static void b(Context r2, boolean r3) {
        SharedPreferences.Editor r4 = z.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "open_common");
        z.a(r4, "a3", r3);
        z.a(r4);
    }

    private static boolean c() {
        if (Build.VERSION.SDK_INT != 19) goto L6;
        return true;
    L6:
        return false;
    }

    public final void a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (this.f5587a != null) goto L5;
        this.f5587a = new b(0);
    L5:
        this.f5587a.a(z.a(r6, "open_common", "a3", true));
        this.f5587a.a(r6);
        c.a(r6).a();
    }

    final void a(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.f5587a != null) goto L5;
        this.f5587a = new b(0);
    L5:
        b(r5, r4);
        this.f5587a.a(r4);
    }

    public final boolean a(boolean r3) {
        if (c() == false) goto L5;
        return false;
    L5:
        if (r3 == false) goto L7;
        return true;
    L7:
        if (b() == true) goto L12;
        return false;
    L12:
        return true;
    }

    public final boolean b() {
        if (this.f5587a != null) goto L6;
        this.f5587a = new b(0);
    L6:
        return this.f5587a.a();
    }
}
