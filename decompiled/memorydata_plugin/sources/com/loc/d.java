package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5423a = null;
    private static d f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f5424b;
    private String c;
    private final Context d;
    private final Handler e;

    private static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<d> f5427a;

        a(Looper r1, d r2) {
            super(r1);
            this.f5427a = new WeakReference(r2);
        }

        a(d r2) {
            this.f5427a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            d r3 = (d) ZeusTransformUtils.preCheckCast(this.f5427a.get(), d.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L5;
            return;
        L5:
            if (r4 != null) goto L7;
            return;
        L7:
            if (r4.obj == null) goto L12;
            d.a(r3, (String) ZeusTransformUtils.preCheckCast(r4.obj, String.class, "com.obric.memorydata.plugin"), r4.what);
            return;
        }
    }

    static {
        f5423a = fx.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    }

    private d(Context r3) {
        this.d = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (Looper.myLooper() != null) goto L7;
        a r4 = new a(Looper.getMainLooper(), this);
    L5:
        this.e = r4;
        return;
    L7:
        r4 = new a(this);
        goto L5
    }

    static /* synthetic */ Context a(d r0) {
        return r0.d;
    }

    public static d a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new d(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    static /* synthetic */ void a(d r0, String r1, int r2) {
        r0.a(r1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.loc.d$1] */
    private synchronized void a(final String r3, final int r4) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
        new AnonymousClass1(this, r3, r4).start();     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L8:
        String r5 = j.b(r3);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r5) == false) goto L11;
    L29:
        monitor-exit(this);
        return;
    L11:
        if ((r4 & 1) <= 0) goto L19;
        if (Build.VERSION.SDK_INT < 23) goto L16;
        ContentResolver r0 = this.d.getContentResolver();     // Catch: Exception -> L34 Throwable -> L31
        String r1 = this.c;     // Catch: Exception -> L34 Throwable -> L31
    L15:
        Settings.System.putString(r0, r1, r5);     // Catch: Exception -> L34 Throwable -> L31
        goto L19
    L16:
        r0 = this.d.getContentResolver();     // Catch: Exception -> L34 Throwable -> L31
        r1 = this.c;     // Catch: Exception -> L34 Throwable -> L31
    L19:
        if ((r4 & 16) <= 0) goto L22;
        f.a(this.d, this.c, r5);     // Catch: Throwable -> L31
    L22:
        if ((r4 & 256) <= 0) goto L29;
        SharedPreferences.Editor r6 = this.d.getSharedPreferences(f5423a, 0).edit();     // Catch: Throwable -> L31
        r6.putString(this.c, r5);     // Catch: Throwable -> L31
        if (Build.VERSION.SDK_INT < 9) goto L28;
        r6.apply();     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L28:
        r6.commit();     // Catch: Throwable -> L31
        goto L29
    }

    static /* synthetic */ String b(d r0) {
        return r0.c;
    }

    public final void a(String r1) {
        this.c = r1;
    }

    public final void b(String r2) {
        List<String> r0 = this.f5424b;
        if (r0 == null) goto L5;
        r0.clear();
        this.f5424b.add(r2);
    L5:
        a(r2, 273);
    }
}
