package com.lynx.clay.embedding.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.FlutterEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public Context a;
    public FlutterEngine b;
    public FlutterView c;
    public final c d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile int g;
    public final FlutterFunctorView h;
    public final com.lynx.clay.embedding.android.c i;
    public final a j;

    public class a implements s5a.b {
        @Override // s5a.b
        public final void a() {
        }

        @Override // s5a.b
        public final void b() {
        }

        public a() {
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ d a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(d r1) {
            this.a = r1;
        }
    }

    public static class c {
        public final boolean a;
        public final RenderMode b;
        public final boolean c;
        public final HashMap<String, String> d;

        public c(RenderMode r2, boolean r3, HashMap r4) {
            this.a = false;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: com.lynx.clay.embedding.android.d$d, reason: collision with other inner class name */
    public static class C0034d {
        public static final List<FlutterEngine> a = null;
        public static boolean b;

        static {
            a = new ArrayList();
            b = false;
        }
    }

    public final void a() {
        Context r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b == null) goto L41;
        Object r1 = com.lynx.clay.util.a.a;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        b r3 = new b(this);
        com.lynx.clay.util.a.a().post(r3);
        return;
    L14:
        Context r4 = r0.getApplicationContext();
        d5a.c r5 = d5a.c.h;
        if (r4 == null) goto L17;
        r0 = r4;
    L17:
        r5.getClass();
        if (r5.e == true) goto L34;
        r5.e = true;
        r0.getApplicationContext().registerComponentCallbacks(r5.g);
        if (r5.d == true) goto L34;
        ActivityManager.RunningAppProcessInfo r6 = new ActivityManager.RunningAppProcessInfo();     // Catch: Exception -> L36
        ActivityManager.getMyMemoryState(r6);     // Catch: Exception -> L36
        int r7 = r6.lastTrimLevel;     // Catch: Exception -> L36
        if (r7 < 80) goto L24;
    L29:
        Integer r8 = 2;     // Catch: Exception -> L36
    L32:
        if (r8 == null) goto L34;
        r5.a(r8.intValue());
        goto L34
    L24:
        if (r7 == 15) goto L29;
        if (r7 < 40) goto L31;
        r8 = 1;     // Catch: Exception -> L36
        goto L32
    L39:
        r8 = null;
    L31:
        r8 = null;
    L34:
        this.e = true;
        return;
    L10:
        r2 = false;
        goto L11
    }

    public final void b() {
        if (this.a == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
    }

    public d(Context r7, RenderMode r8, boolean r9) {
        boolean r0 = false;
        this.e = false;
        this.f = false;
        this.g = 0;
        this.i = new com.lynx.clay.embedding.android.c();
        this.j = new a();
        this.a = r7;
        JSONObject r1 = c5a.b.a().a.b();     // Catch: Exception -> L13
        if (r1 == null) goto L26;
        String r2 = r1.optString("renderMode", "sync");     // Catch: Exception -> L13
        if ("surface".equalsIgnoreCase(r2) == false) goto L9;
        r8 = RenderMode.surface;     // Catch: Exception -> L13
        goto L26
    L9:
        if ("texture".equalsIgnoreCase(r2) == false) goto L11;
        r8 = RenderMode.texture;     // Catch: Exception -> L13
        goto L26
    L11:
        r8 = RenderMode.sync;     // Catch: Exception -> L13
    L26:
    L16:
        if (r8 != RenderMode.sync) goto L24;
        FlutterFunctorView r3 = new FlutterFunctorView(r7);
        this.h = r3;
        if (r3.e != (-1)) goto L20;
    L22:
        if (r0 == true) goto L24;
        r8 = RenderMode.texture;
        goto L24
    L20:
        if (r3.d == (-1)) goto L22;
        r0 = true;
    L24:
        this.d = new c(r8, r9, new HashMap());
        return;
    L13:
        e = move-exception;
        c5a.c.f("ClayViewProvider", "Failed to determine render mode from clay settings; keeping fallback.", e);
        goto L16
    }
}
