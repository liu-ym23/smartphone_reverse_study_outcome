package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.m;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d8a.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FontFaceManager {
    public final Map<String, h> a;
    public final Object b;
    public final Map<String, com.lynx.tasm.fontface.a> c;
    public final Map<com.lynx.tasm.fontface.g, Typeface> d;

    public class a implements Runnable {
        public final /* synthetic */ h a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Handler c;
        public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c d;

        /* JADX INFO: renamed from: com.lynx.tasm.fontface.FontFaceManager$a$a, reason: collision with other inner class name */
        public class RunnableC0062a implements Runnable {
            public final /* synthetic */ Typeface a;
            public final /* synthetic */ a b;

            @Override // java.lang.Runnable
            public final void run() {
                LLog.i("FontFaceManager", "Lynx load font success.");     // Catch: Throwable -> L4
                a r0 = this.b;     // Catch: Throwable -> L4
                r0.d.a(this.a, r0.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0062a(a r1, Typeface r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Typeface r0 = this.a.a(this.b);     // Catch: Throwable -> L4
            this.c.post(new RunnableC0062a(this, r0));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(h r1, int r2, Handler r3, com.lynx.tasm.behavior.shadow.text.g.c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c c;
        public final /* synthetic */ h d;
        public final /* synthetic */ Handler e;
        public final /* synthetic */ FontFaceManager f;

        public final void a() {
            LLog.i("Lynx", "load font success " + this.a + this.b);
            if (Build.VERSION.SDK_INT < 28) goto L5;
            this.c.a(this.d.a(this.b), this.b);
            return;
        L5:
            FontFaceManager r0 = this.f;
            Handler r1 = this.e;
            com.lynx.tasm.behavior.shadow.text.g.c r2 = this.c;
            h r3 = this.d;
            int r4 = this.b;
            r0.getClass();
            FontFaceManager.h(r1, r2, r3, r4);
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

        public b(FontFaceManager r1, String r2, int r3, com.lynx.tasm.behavior.shadow.text.g.c r4, h r5, Handler r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ LynxContext a;
        public final /* synthetic */ FontFace b;
        public final /* synthetic */ int c;
        public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c d;
        public final /* synthetic */ Handler e;
        public final /* synthetic */ FontFaceManager f;

        public final void a() {
            FontFaceManager r0 = this.f;
            LynxContext r1 = this.a;
            FontFace r2 = this.b;
            int r3 = this.c;
            com.lynx.tasm.behavior.shadow.text.g.c r4 = this.d;
            Handler r5 = this.e;
            h r6 = r0.f(r2);
            if (r6 == null) goto L11;
            r2.b = r6;
            r0.c(r2, r6);
            if (r4 != null) goto L8;
            return;
        L8:
            if (Build.VERSION.SDK_INT < 28) goto L10;
            r5.post(new com.lynx.tasm.fontface.d(r4, r6.a(r3), r3));
            return;
        L10:
            FontFaceManager.h(r5, r4, r6, r3);
            return;
        L11:
            Object r7 = r0.b;
            monitor-enter(r7);
            h r8 = r0.f(r2);     // Catch: Throwable -> L25
            if (r8 == null) goto L27;
            r2.b = r8;     // Catch: Throwable -> L25
            r0.c(r2, r8);     // Catch: Throwable -> L25
            if (r4 != null) goto L20;
            monitor-exit(r7);     // Catch: Throwable -> L25
            return;
        L20:
            if (Build.VERSION.SDK_INT < 28) goto L22;
            r5.post(new com.lynx.tasm.fontface.e(r4, r8.a(r3), r3));     // Catch: Throwable -> L25
        L23:
            monitor-exit(r7);     // Catch: Throwable -> L25
            return;
        L22:
            FontFaceManager.h(r5, r4, r8, r3);     // Catch: Throwable -> L25
            goto L23
        L27:
            com.lynx.tasm.fontface.a r9 = r0.e(r2);     // Catch: Throwable -> L25
            if (r9 == null) goto L32;
            r9.b.add(r2);     // Catch: Throwable -> L25
            Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer> r10 = new Pair(r4, Integer.valueOf(r3));     // Catch: Throwable -> L25
            r9.a.offer(r10);     // Catch: Throwable -> L25
            monitor-exit(r7);     // Catch: Throwable -> L25
            return;
        L32:
            com.lynx.tasm.fontface.a r11 = new com.lynx.tasm.fontface.a();     // Catch: Throwable -> L25
            Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer> r12 = new Pair(r4, Integer.valueOf(r3));     // Catch: Throwable -> L25
            r11.a.offer(r12);     // Catch: Throwable -> L25
            r11.b.add(r2);     // Catch: Throwable -> L25
            Iterator r13 = ((ArrayList) r2.a).iterator();     // Catch: Throwable -> L25
        L34:
            if (r13.hasNext() == false) goto L43;
            Pair r14 = (Pair) r13.next();     // Catch: Throwable -> L25
            if (r14 == null) goto L34;
            Object r15 = r14.first;     // Catch: Throwable -> L25
            if (r15 == null) goto L34;
            Object r16 = r14.second;     // Catch: Throwable -> L25
            if (r16 == null) goto L34;
            Map<String, com.lynx.tasm.fontface.a> r17 = r0.c;     // Catch: Throwable -> L25
            HashMap r18 = (HashMap) r17;     // Catch: Throwable -> L25
            r18.put(FontFaceManager.o((FontFace.TYPE) r15, (String) r16), r11);     // Catch: Throwable -> L25
            goto L34
        L43:
            monitor-exit(r7);     // Catch: Throwable -> L25
            Iterator<Pair<FontFace.TYPE, String>> r19 = ((ArrayList) r2.a).iterator();
            Iterator<Pair<FontFace.TYPE, String>> r20 = ((ArrayList) r2.a).iterator();
            if (r1.getGenericResourceFetcher() == null) goto L47;
            TraceEvent.beginSection("FontFaceManager.loadTypefaceWithGenericLynxResourceFetcher");
            LLog.i("FontFaceManager", "Try to loadTypeface with GenericLynxResourceFetcher.");
            r0.k(r1, r11, r19, r20, r5);
            TraceEvent.endSection("FontFaceManager.loadTypefaceWithGenericLynxResourceFetcher");
            return;
        L47:
            TraceEvent.beginSection("FontFaceManager.loadTypeface");
            r0.j(r1, r11, r19, r5);
            TraceEvent.endSection("FontFaceManager.loadTypeface");
            return;
        L25:
            th = move-exception;
            throw th;
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

        public c(FontFaceManager r1, LynxContext r2, FontFace r3, int r4, com.lynx.tasm.behavior.shadow.text.g.c r5, Handler r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ com.lynx.tasm.fontface.a a;
        public final /* synthetic */ h b;
        public final /* synthetic */ Handler c;
        public final /* synthetic */ FontFaceManager d;

        public final void a() {
            com.lynx.tasm.fontface.a r0 = this.a;
            r0.getClass();
            ArrayList r1 = new ArrayList();
        L3:
            Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer> r2 = r0.a.poll();
            if (r2 == null) goto L6;
            r1.add(r2);
            goto L3
        L6:
            Iterator r3 = r1.iterator();
        L8:
            if (r3.hasNext() == false) goto L16;
            Pair r4 = (Pair) r3.next();
            Object r5 = r4.first;
            if (r5 == null) goto L8;
            if (Build.VERSION.SDK_INT >= 28) goto L14;
            FontFaceManager r6 = this.d;
            h r7 = this.b;
            int r8 = ((Integer) r4.second).intValue();
            r6.getClass();
            FontFaceManager.h(this.c, (com.lynx.tasm.behavior.shadow.text.g.c) r5, r7, r8);
            goto L8
        L14:
            LLog.i("Lynx", "load font success");
            ((com.lynx.tasm.behavior.shadow.text.g.c) r4.first).a(this.b.a(((Integer) r4.second).intValue()), ((Integer) r4.second).intValue());
            goto L8
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

        public d(FontFaceManager r1, com.lynx.tasm.fontface.a r2, h r3, Handler r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ com.lynx.tasm.fontface.a a;
        public final /* synthetic */ Handler b;
        public final /* synthetic */ h c;
        public final /* synthetic */ FontFaceManager d;

        public final void a() {
            com.lynx.tasm.fontface.a r0 = this.a;
            r0.getClass();
            ArrayList r1 = new ArrayList();
        L3:
            Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer> r2 = r0.a.poll();
            if (r2 == null) goto L6;
            r1.add(r2);
            goto L3
        L6:
            Iterator r3 = r1.iterator();
        L8:
            if (r3.hasNext() == false) goto L20;
            Pair r4 = (Pair) r3.next();
            Object r5 = r4.first;
            if (r5 == null) goto L8;
            FontFaceManager r6 = this.d;
            Handler r7 = this.b;
            com.lynx.tasm.behavior.shadow.text.g.c r8 = (com.lynx.tasm.behavior.shadow.text.g.c) r5;
            h r9 = this.c;
            Integer r10 = (Integer) r4.second;
            r6.getClass();
            if (r10 != null) goto L15;
            int r11 = 0;
        L17:
            if (Build.VERSION.SDK_INT >= 28) goto L18;
            FontFaceManager.h(r7, r8, r9, r11);
            goto L8
        L18:
            LLog.i("FontFaceManager", "Lynx load font success.");
            r8.a(r9.a(r11), r11);
            goto L8
        L15:
            r11 = r10.intValue();
            goto L17
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

        public e(FontFaceManager r1, com.lynx.tasm.fontface.a r2, Handler r3, h r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public interface f {
    }

    public static class g {
        public static final FontFaceManager a = null;

        static {
            a = new FontFaceManager();
        }
    }

    public FontFaceManager() {
        this.a = new ConcurrentHashMap();
        this.b = new Object();
        this.c = new HashMap();
        final float r1 = 0.75f;
        final boolean r2 = true;
        final int r3 = 16;
        this.d = Collections.synchronizedMap(new AnonymousClass1(this, r3, r1, r2));
    }

    public final com.lynx.tasm.fontface.a e(FontFace r4) {
        Iterator r5 = ((ArrayList) r4.a).iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        Pair r0 = (Pair) r5.next();
        if (r0 == null) goto L4;
        Object r1 = r0.first;
        if (r1 == null) goto L4;
        Object r2 = r0.second;
        if (r2 == null) goto L4;
        Map<String, com.lynx.tasm.fontface.a> r3 = this.c;
        HashMap r6 = (HashMap) r3;
        com.lynx.tasm.fontface.a r7 = (com.lynx.tasm.fontface.a) r6.get(o((FontFace.TYPE) r1, (String) r2));
        if (r7 == null) goto L4;
        return r7;
    L15:
        return null;
    }

    public final h f(FontFace r4) {
        Iterator r5 = ((ArrayList) r4.a).iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        Pair r0 = (Pair) r5.next();
        if (r0 == null) goto L4;
        Object r1 = r0.first;
        if (r1 == null) goto L4;
        Object r2 = r0.second;
        if (r2 == null) goto L4;
        Map<String, h> r3 = this.a;
        ConcurrentHashMap r6 = (ConcurrentHashMap) r3;
        h r7 = (h) r6.get(o((FontFace.TYPE) r1, (String) r2));
        if (r7 == null) goto L4;
        return r7;
    L15:
        return null;
    }

    public final void l(com.lynx.tasm.fontface.a r2) {
        Object r0 = this.b;
        monitor-enter(r0);
        p(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void p(com.lynx.tasm.fontface.a r3) {
        Iterator r0 = ((HashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((Map.Entry) r0.next()).getValue() != r3) goto L4;
        r0.remove();
        goto L4
    }

    public static Typeface d(String r3, LynxContext r4) {
    L13:
        e = move-exception;
        n(30205, "Create typeface from local path failed", r3, e, r4);
        return null;
    L3:
        if (TypeFaceOptimizer.getSwitch() == false) goto L11;
        if (r3 == null) goto L11;
        if (TypeFaceLancet.cache.contains(r3) == false) goto L8;
        Typeface r0 = (Typeface) TypeFaceLancet.cache.get(r3);     // Catch: RuntimeException -> L13
    L16:
        return r0;
    L8:
        r0 = Typeface.createFromFile(r3);     // Catch: RuntimeException -> L13
        if (r0 == null) goto L11;
        TypeFaceLancet.cache.put(r3, r0);     // Catch: RuntimeException -> L13
    L11:
        r0 = Typeface.createFromFile(r3);     // Catch: RuntimeException -> L13
        goto L16
    }

    public static String o(FontFace.TYPE r1, String r2) {
        return r1.name() + r2;
    }

    public final void b(String r3, Typeface r4) {
        h r0 = new h(r4);
        ((ConcurrentHashMap) this.a).put(o(FontFace.TYPE.URL, r3), r0);
        LLog.i("FontFaceManager", "prefetchFont success: " + r3);
    }

    public final void c(FontFace r4, h r5) {
        Iterator r6 = ((ArrayList) r4.a).iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Pair r0 = (Pair) r6.next();
        if (r0 == null) goto L4;
        Object r1 = r0.first;
        if (r1 == null) goto L4;
        Object r2 = r0.second;
        if (r2 == null) goto L4;
        Map<String, h> r3 = this.a;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r3;
        r7.put(o((FontFace.TYPE) r1, (String) r2), r5);
        goto L4
    }

    public static Typeface i(LynxContext r2, FontFace.TYPE r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        if (r3 == FontFace.TYPE.LOCAL) goto L23;
        int r5 = r4.indexOf("base64,");
        if (r4.startsWith("data:") == true) goto L10;
        return null;
    L10:
        if (r5 != (-1)) goto L19;
        return null;
    L19:
        return m.c(r2, Base64.decode(r4.substring(r5 + 7), 0));
    L15:
        e = move-exception;
        n(30203, "Error when parsing base64 resource", r4, e, r2);
        return null;
    L23:
        return null;
    }

    public final void m(LynxContext r3, String r4, LynxResourceModule.e r5) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        if (r5 == null) goto L9;
        ((LynxResourceModule.c) r5.a).a(32101, "url is empty");
        return;
    L9:
        return;
    L7:
        LynxThreadPool.b().execute(new com.lynx.tasm.fontface.c(this, r4, r3, r5));
    }

    public static void a(FontFaceManager r3, LynxContext r4, String r5, f r6) {
        r3.getClass();
        int r0 = 32101;
        Typeface r7 = w7a.a.a(r4).a(r4, FontFace.TYPE.URL, r5);     // Catch: Exception -> L9
        if (r7 == null) goto L7;
        r3.b(r5, r7);     // Catch: Exception -> L9
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        r0 = 0;
    L11:
        if (r6 == null) goto L16;
        ((LynxResourceModule.c) ((LynxResourceModule.e) r6).a).a(r0, r8);
        return;
    L16:
        return;
    L7:
        r8 = "loadFontFace failed";
    L9:
        e = move-exception;
        r8 = "prefetchFont with loader failed: " + e.getMessage();
        LLog.e("FontFaceManager", r8);
        goto L11
    }

    public static void h(Handler r1, com.lynx.tasm.behavior.shadow.text.g.c r2, h r3, int r4) {
        UIThreadUtils.runOnUiThreadImmediately(new a(r3, r4, r1, r2));
    }

    public final Typeface g(LynxContext r11, String r12, int r13, com.lynx.tasm.behavior.shadow.text.g.c r14) {
        FontFace r3 = r11.getFontFace(r12);
        if (r3 != null) goto L5;
        return null;
    L5:
        h r0 = f(r3);
        if (r0 != null) goto L8;
    L14:
        h r1 = r3.b;
        Handler r9 = new Handler(Looper.myLooper());
        if (r1 == null) goto L24;
        if (r14 == null) goto L19;
        r9.post(new b(this, r12, r13, r14, r1, r9));
    L19:
        if (Build.VERSION.SDK_INT < 28) goto L23;
        return r1.a(r13);
    L23:
        return r1.a(0);
    L24:
        LynxThreadPool.b().execute(new c(this, r11, r3, r13, r14, r9));
        return null;
    L8:
        if (r0.b[r13] == null) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        return r0.a(r13);
    L10:
        r2 = false;
        goto L11
    }

    public final void j(LynxContext r9, com.lynx.tasm.fontface.a r10, Iterator<Pair<FontFace.TYPE, String>> r11, Handler r12) {
        if (r11.hasNext() == true) goto L6;
        l(r10);
        return;
    L6:
        Pair<FontFace.TYPE, String> r0 = r11.next();
        d8a.f r1 = r9.getProviderRegistry();
        r1.getClass();
        Typeface r4 = null;
        if (TextUtils.isEmpty("FONT") == false) goto L9;
        k r2 = null;
    L10:
        if (r2 != null) goto L12;
    L27:
        if (r4 != null) goto L29;
        r4 = w7a.a.a(r9).a(r9, (FontFace.TYPE) r0.first, (String) r0.second);
    L29:
        if (r4 != null) goto L32;
        j(r9, r10, r11, r12);
        return;
    L32:
        h r13 = new h(r4);
        Object r14 = this.b;
        monitor-enter(r14);
        Iterator<FontFace> r3 = r10.b.iterator();     // Catch: Throwable -> L48
    L36:
        if (r3.hasNext() == false) goto L38;
        FontFace r5 = r3.next();     // Catch: Throwable -> L48
        r5.b = r13;     // Catch: Throwable -> L48
        c(r5, r13);     // Catch: Throwable -> L48
        goto L36
    L38:
        p(r10);     // Catch: Throwable -> L48
        monitor-exit(r14);     // Catch: Throwable -> L48
        if (Build.VERSION.SDK_INT < 28) goto L46;
        Iterator r15 = new ArrayList(r10.a).iterator();
    L44:
        if (r15.hasNext() == false) goto L46;
        r13.a(((Integer) ((Pair) r15.next()).second).intValue());
    L46:
        r12.post(new d(this, r10, r13, r12));
        return;
    L48:
        th = move-exception;
        throw th;
    L12:
        if (((String) r0.second).startsWith("data:") == true) goto L27;
        FontFace.TYPE r6 = (FontFace.TYPE) r0.first;
        String r7 = (String) r0.second;
        String[] r8 = new String[1];
        Bundle r16 = new Bundle();
        r16.putString("type", r6.toString());
        r2.request(new LynxResourceRequest(r7, r16), new com.lynx.tasm.fontface.f(this, r8, r7, r9));
        String r17 = r8[0];
        if (r17 == null) goto L27;
        if (r17.startsWith("https") == false) goto L19;
        r4 = w7a.a.a(r9).a(r9, FontFace.TYPE.URL, r17);
        goto L27
    L19:
        if (r17.startsWith("file://") == false) goto L22;
        r4 = d(r17.substring(7), r9);
        goto L27
    L22:
        if (r17.startsWith("asset:///") == false) goto L27;
        r4 = Typeface.createFromAsset(LynxEnv.inst().getAppContext().getAssets(), r17.substring(9));     // Catch: RuntimeException -> L25
    L25:
        e = move-exception;
        n(30205, "Create typeface from local asset failed", r17, e, r9);
        goto L27
    L9:
        r2 = (k) ((HashMap) r1.a).get("FONT");
        goto L10
    }

    public static void n(int r1, String r2, String r3, Exception r4, LynxContext r5) {
        LynxError r0 = new LynxError(r1, r2);
        if (r4 == null) goto L5;
        r0.setCallStack(CallStackUtil.a(r4));
        LLog.e("FontFaceManager", r4.getMessage());
    L6:
        r5.reportResourceError(r3, LynxResourceModule.FONT_TYPE, r0);
        return;
    L5:
        LLog.e("FontFaceManager", r2 + ",src:" + r3);
        goto L6
    }

    public final void k(LynxContext r18, com.lynx.tasm.fontface.a r19, Iterator<Pair<FontFace.TYPE, String>> r20, Iterator<Pair<FontFace.TYPE, String>> r21, Handler r22) {
        if (r20.hasNext() == true) goto L6;
        LLog.w("FontFaceManager", "load typeface with GenericLynxResourceFetcher failed, try loadTypeface.");
        j(r18, r19, r21, r22);
        return;
    L6:
        Pair<FontFace.TYPE, String> r0 = r20.next();
        String r12 = (String) r0.second;
        if (TextUtils.isEmpty(r12) == false) goto L9;
    L38:
        Typeface r2 = null;
    L39:
        Typeface r13 = r2;
    L40:
        if (r13 != null) goto L43;
        k(r18, r19, r20, r21, r22);
        return;
    L43:
        LLog.i("FontFaceManager", "Lynx load typeface with GenericLynxResourceFetcher success.");
        h r1 = new h(r13);
        Object r3 = this.b;
        monitor-enter(r3);
        Iterator<FontFace> r4 = r19.b.iterator();     // Catch: Throwable -> L59
    L47:
        if (r4.hasNext() == false) goto L49;
        FontFace r5 = r4.next();     // Catch: Throwable -> L59
        r5.b = r1;     // Catch: Throwable -> L59
        c(r5, r1);     // Catch: Throwable -> L59
        goto L47
    L49:
        p(r19);     // Catch: Throwable -> L59
        monitor-exit(r3);     // Catch: Throwable -> L59
        if (Build.VERSION.SDK_INT < 28) goto L57;
        Iterator r6 = new ArrayList(r19.a).iterator();
    L55:
        if (r6.hasNext() == false) goto L57;
        r1.a(((Integer) ((Pair) r6.next()).second).intValue());
    L57:
        r22.post(new e(this, r19, r22, r1));
        return;
    L59:
        th = move-exception;
        throw th;
    L9:
        if (FontFace.TYPE.LOCAL != r0.first) goto L14;
        if (r12.startsWith("file://") == false) goto L38;
        r13 = d(r12.substring(7), r18);
        goto L40
    L14:
        if (r12.startsWith("data:") == false) goto L19;
        if (r12.contains("base64,") == false) goto L19;
        r13 = i(r18, (FontFace.TYPE) r0.first, r12);
    L19:
        if (r12.startsWith("http") == false) goto L37;
        com.lynx.tasm.resourceprovider.LynxResourceRequest r7 = new com.lynx.tasm.resourceprovider.LynxResourceRequest(r12, com.lynx.tasm.resourceprovider.LynxResourceRequest.LynxResourceType.LynxResourceTypeFont);
        com.lynx.tasm.resourceprovider.LynxResourceRequest.AsyncMode r8 = com.lynx.tasm.resourceprovider.LynxResourceRequest.AsyncMode.EXACTLY_ASYNC;
        f8a.a r14 = r18.getGenericResourceFetcher();
        AtomicReference r15 = new AtomicReference();
        CountDownLatch r9 = new CountDownLatch(1);
        if (r14 == null) goto L62;
        r14.a(r7, new com.lynx.tasm.fontface.b(this, r15, r12, r18, r9));
    L62:
    L35:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        n(30202, "Load font with genericResourceFetcher failed", r12, e, r18);
        goto L38
    L26:
        if (r9.await(30, TimeUnit.SECONDS) == true) goto L29;
        n(30202, "Load font with genericResourceFetcher failed:request timeout", r12, null, r18);     // Catch: InterruptedException -> L35
        goto L38
    L29:
        byte[] r10 = (byte[]) r15.get();
        if (r10 == null) goto L38;
        if (r10.length == 0) goto L38;
        r13 = m.c(r18, r10);
        goto L40
    L37:
        r2 = null;
        n(30201, "Src format is incorrect", r12, null, r18);
        goto L39
    }
}
