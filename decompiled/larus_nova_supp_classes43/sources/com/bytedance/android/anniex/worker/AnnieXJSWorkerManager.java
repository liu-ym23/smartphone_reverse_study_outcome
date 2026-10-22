package com.bytedance.android.anniex.worker;

import android.app.Application;
import android.os.Handler;
import bolts.Task;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXJSWorkerManager {
    public static final AnnieXJSWorkerManager a = null;
    public static volatile boolean b;
    public static com.bytedance.android.anniex.worker.c c;
    public static final Lazy d = null;

    public static final class a {
        public final boolean a;
        public final String b;

        public a(boolean r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "actualMD5");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            AnnieXJSWorkerManager r0 = AnnieXJSWorkerManager.a;
            String r1 = String.valueOf(ib.e.b(UriProtector.parse(this.a)));
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
            String r10 = UriProtector.parse(r1).buildUpon().clearQuery().build().toString();
            HashMap r11 = new HashMap();
            r11.put("current_page_url", r10);
            Event r12 = new Event("page_destroy", System.currentTimeMillis(), null, 4, null);
            r12.setMapParams(r11);
            EventCenter.enqueueEvent(r12);
            AnnieXJSWorkerManager.b("page_destroy", r11);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ String a;
        public final /* synthetic */ KitType b;
        public final /* synthetic */ String c;

        public c(String r1, KitType r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            AnnieXJSWorkerManager r0 = AnnieXJSWorkerManager.a;
            String r1 = String.valueOf(ib.e.b(UriProtector.parse(this.a)));
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
            String r10 = UriProtector.parse(r1).buildUpon().clearQuery().build().toString();
            KitType r11 = this.b;
            if (r11 != KitType.WEB) goto L6;
            String r12 = "web";
        L8:
            HashMap r13 = new HashMap();
            String r14 = this.c;
            r13.put("current_page_url", r10);
            r13.put("engine_type", r12);
            r13.put("bid", r14);
            Event r15 = new Event("page_first_visiable", System.currentTimeMillis(), null, 4, null);
            r15.setMapParams(r13);
            EventCenter.enqueueEvent(r15);
            AnnieXJSWorkerManager.b("page_first_visiable", r13);
            return;
        L6:
            if (r11 != KitType.LYNX) goto L10;
            r12 = "lynx";
            goto L8
        L10:
            HybridLogger r16 = HybridLogger.a;
            HybridLogger.i("AnnieXJSWorkerManager", "kit_type:" + r11 + " can not be identified!", null, 12);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public AnnieXJSWorkerManager() {
    }

    static {
        a = new AnnieXJSWorkerManager();
        d = LazyKt.lazy(AnnieXJSWorkerManager$handler$2.INSTANCE);
    }

    public static final a a(byte[] r10) {
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L7;
        w26.e r11 = (w26.e) r1.n0(w26.e.class);
        if (r11 == null) goto L7;
        boolean r12 = r11.w0();
    L9:
        if (r12 == true) goto L11;
        HybridLogger.m("AnnieXJSWorkerManager", "anniex worker md5 check not enable", null, null, 12);
        return new a(true, "");
    L11:
        String r13 = MD5Utils.INSTANCE.getMD5(new ByteArrayInputStream(r10));
        w26.g r14 = (w26.g) x26.a.a(w26.g.class);
        if (r14 == null) goto L16;
        com.bytedance.ies.bullet.base.settings.j r15 = (com.bytedance.ies.bullet.base.settings.j) r14.n0(com.bytedance.ies.bullet.base.settings.j.class);
        if (r15 == null) goto L16;
        List r16 = r15.b();
    L17:
        List r17 = r16;
        if (r17 != null) goto L20;
    L23:
        boolean r18 = true;
    L24:
        if (r18 == false) goto L26;
        r16 = CollectionsKt.listOf(new String[]{"84c1a41d47b9a3b566656c5d0fd24703", "c63c98481074b27fbf0c4b45553f05d5"});
    L26:
        if (r16 == null) goto L34;
        Iterator r19 = r16.iterator();
    L29:
        if (r19.hasNext() == false) goto L34;
        String r20 = (String) r19.next();
        if (StringsKt.equals(r13, r20, true) == false) goto L29;
        HybridLogger r21 = HybridLogger.a;
        HybridLogger.m("AnnieXJSWorkerManager", "compareMD5 true bundle.js md5:" + r20, null, null, 12);
        a r22 = new a(true, r13);
    L38:
        return r22;
    L34:
        if (com.bytedance.ies.bullet.core.h.h.a == false) goto L36;
        HybridLogger.m("AnnieXJSWorkerManager", "compareMD5 always true in debuggable env", null, null, 12);
        r22 = new a(true, r13);
        goto L38
    L36:
        HybridLogger.i("AnnieXJSWorkerManager", "compareMD5 failed", null, 12);
        r22 = new a(false, r13);
        goto L38
    L20:
        if (r17.isEmpty() == true) goto L23;
        r18 = false;
    L16:
        r16 = null;
    L7:
        r12 = true;
        goto L9
    }

    public static void d(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        s26.d r0 = s26.d.c;
        m0 r1 = s26.d.c.c(m0.class);
        if (r1 != null) goto L5;
    L7:
        Boolean r11 = null;
    L9:
        if (Intrinsics.areEqual(r11, Boolean.FALSE) == false) goto L11;
        return;
    L11:
        Task.callInBackground(new b(r10));
        return;
    L5:
        if (r1.a0() == null) goto L7;
        r11 = Boolean.FALSE;
        goto L9
    }

    public static final void b(String r10, Map r11) {
        s26.d r0 = s26.d.c;
        m0 r1 = s26.d.c.c(m0.class);
        if (r1 == null) goto L5;
        com.bytedance.ies.bullet.service.base.d r12 = r1.a0();
    L6:
        if (r12 == null) goto L10;
        boolean r13 = true;
        if (true != r12.r) goto L10;
    L11:
        if (r13 == false) goto L16;
        r r14 = s26.d.c.c(r.class);
        if (r14 == null) goto L17;
        c1 r15 = new c1(r10, null, null, null, null, 254);
        JSONObject r16 = new JSONObject(r11);
        r16.put("is_worker_ready", b);
        r15.d = r16;
        r14.S(r15);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        r13 = false;
        goto L11
    L5:
        r12 = null;
        goto L6
    }

    public final synchronized void c(Application r10, String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "context");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L18
        s26.d r0 = s26.d.c;     // Catch: Throwable -> L18
        m0 r1 = s26.d.c.c(m0.class);     // Catch: Throwable -> L18
        if (r1 == null) goto L7;
        r1.a0();     // Catch: Throwable -> L18
    L7:
        if (b == true) goto L16;
        Map r12 = x26.a.a;     // Catch: Throwable -> L18
        w26.g r13 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L18
        if (r13 == null) goto L13;
        w26.e r14 = (w26.e) r13.n0(w26.e.class);     // Catch: Throwable -> L18
        if (r14 == null) goto L13;
        boolean r15 = r14.x0();     // Catch: Throwable -> L18
    L14:
        if (r15 == false) goto L16;
        ((Handler) d.getValue()).post(new d(r11, r10));     // Catch: Throwable -> L18
    L13:
        r15 = true;
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static void e(String r10, String r11, KitType r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "kitType");
        s26.d r0 = s26.d.c;
        m0 r1 = s26.d.c.c(m0.class);
        if (r1 != null) goto L5;
    L7:
        Boolean r13 = null;
    L9:
        if (Intrinsics.areEqual(r13, Boolean.FALSE) == false) goto L11;
        return;
    L11:
        Task.callInBackground(new c(r10, r12, r11));
        return;
    L5:
        if (r1.a0() == null) goto L7;
        r13 = Boolean.FALSE;
        goto L9
    }
}
