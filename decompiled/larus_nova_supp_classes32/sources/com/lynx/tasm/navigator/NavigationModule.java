package com.lynx.tasm.navigator;

import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashMap;
import x7a.f;
import x7a.g;
import x7a.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NavigationModule extends LynxModule {
    public static String NAME = "NavigationModule";

    public class a implements Runnable {
        public final /* synthetic */ ReadableMap a;

        @Override // java.lang.Runnable
        public final void run() {
            g r0 = g.d;     // Catch: Throwable -> L6
            ReadableMap r1 = this.a;     // Catch: Throwable -> L6
            x7a.d r2 = r0.a();     // Catch: Throwable -> L6
            if (r2 == null) goto L9;
            r2.c = r1.asHashMap();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(ReadableMap r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ReadableMap a;
        public final /* synthetic */ String b;

        @Override // java.lang.Runnable
        public final void run() {
            HashMap<String, Object> r0 = new HashMap();     // Catch: Throwable -> L7
            ReadableMap r1 = this.a;     // Catch: Throwable -> L7
            if (r1 == null) goto L5;
            r0 = r1.asHashMap();     // Catch: Throwable -> L7
        L5:
            g.d.c(this.b, r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b(ReadableMap r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ ReadableMap a;
        public final /* synthetic */ String b;

        public final void a() {
            HashMap<String, Object> r0 = new HashMap();
            ReadableMap r1 = this.a;
            if (r1 == null) goto L5;
            r0 = r1.asHashMap();
        L5:
            g r2 = g.d;
            String r3 = this.b;
            r2.getClass();
            if (TextUtils.isEmpty(r3) == true) goto L19;
            x7a.d r4 = r2.a();
            if (r4 == null) goto L20;
            HashMap<String, Object> r5 = r4.c;
            if (r5 == null) goto L14;
            Object r6 = r5.get(r3);
            if ((r6 instanceof String) == false) goto L14;
            String r7 = (String) r6;
        L15:
            h r8 = new h(r7, r0);
            x7a.b r9 = new x7a.b(r4, r8, r3);
            f r10 = r4.b();
            if (r10 == null) goto L21;
            r10.j(r8, new x7a.c(r4, r8, r9));
            return;
        L21:
            return;
        L14:
            r7 = r3;
            goto L15
        L20:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(ReadableMap r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class d implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            g.d.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d() {
        }
    }

    @LynxMethod
    public void goBack() {
        UIThreadUtils.runOnUiThread(new d());
    }

    @LynxMethod
    public String getString() {
        return NAME;
    }

    public NavigationModule(Context r1) {
        super(r1);
    }

    @LynxMethod
    public void registerRoute(ReadableMap r2) {
        UIThreadUtils.runOnUiThread(new a(r2));
    }

    public NavigationModule(Context r1, Object r2) {
        super(r1, r2);
    }

    @LynxMethod
    public void navigateTo(String r2, ReadableMap r3) {
        UIThreadUtils.runOnUiThread(new b(r3, r2));
    }

    @LynxMethod
    public void replace(String r2, ReadableMap r3) {
        UIThreadUtils.runOnUiThread(new c(r3, r2));
    }
}
