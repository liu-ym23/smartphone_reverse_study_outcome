package com.bytedance.ies.bullet.forest;

import android.app.Application;
import android.net.Uri;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.ResourceFetcher;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.Status;
import com.bytedance.forest.model.w;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.lynx.tasm.ui.image.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zm.c f5397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zm.c f5398b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f5399c = null;
    public static final k d = null;
    public static final i e = null;
    public static volatile Forest f;

    static {
        f5397a = new zm.c(3);
        f5398b = new zm.c(3);
        f5399c = new LinkedHashMap();
        d = new k();
        e = new i();
        if (zj.b.f23451a.compareAndSet(false, true) == true) goto L16;
    L14:
        com.bytedance.frameworks.baselib.network.http.cronet.b r5 = new com.bytedance.frameworks.baselib.network.http.cronet.b(6);
        Lazy r10 = com.bytedance.ies.xbridge.event.b.f6326a;
        Intrinsics.checkNotNullParameter("client_ai_forest_preload", "eventName");
        Intrinsics.checkNotNullParameter(r5, "subscriber");
        com.bytedance.ies.xbridge.event.b.d("client_ai_forest_preload", r5, System.currentTimeMillis(), UUID.randomUUID().toString());
        return;
    L16:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        Object r12 = Result.m124constructorimpl(Class.forName("com.bytedance.lynx.webview.TTWebSdk"));     // Catch: Throwable -> L6
    L9:
        if (Result.m131isSuccessimpl(r12) == false) goto L12;
        Class r13 = (Class) r12;
        zj.a r14 = new zj.a();
        com.bytedance.ies.bullet.base.utils.logger.a.g("TTWebPredictor", "GlobalInterceptor.registerMonitor(ttWebInterceptor)", null, 12);
        com.bytedance.forest.interceptor.b.b(r14);
    L12:
        if (Result.m127exceptionOrNullimpl(r12) == null) goto L14;
        com.bytedance.ies.bullet.base.utils.logger.a.d("TTWebPredictor", "no ttwebview sdk loaded into app", null, 12);
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static Forest a() {
        Application r5 = com.bytedance.ies.bullet.core.h.g.f5316b;
        if (r5 == null) goto L20;
        if (f != null) goto L18;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        f = new Forest(r5, c.f5394b);     // Catch: Throwable -> L8
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L13;
        f0.g(112, "ForestLoader", "Init forest instance failed!", r12);
        throw r12;
    L13:
        if (Result.m131isSuccessimpl(r11) == false) goto L18;
        Unit r13 = (Unit) r11;
        ArrayList r14 = com.bytedance.forest.interceptor.b.f4306a;
        com.bytedance.forest.interceptor.b.b(e);
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L18:
        return f;
    L20:
        throw new IllegalStateException("MUST attach application via BulletSdk#init!");
    }

    public static w b(String r10, String r11, Scene r12, String r13, wc.g r14, Function1 r15, int r16) {
        Forest r17 = a();
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        wc.g r18 = null;
    L11:
        if ((r16 & 64) == 0) goto L13;
        Function1 r19 = null;
    L14:
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r12, "scene");
        if (j(r17, r10) == true) goto L17;
        return null;
    L17:
        j r20 = d.a(r10, false, r5, r12, r13, r18);
        com.bytedance.forest.model.t r21 = r20.d;
        if (r19 == null) goto L20;
        r19.invoke(r21);
    L20:
        c(r21.f4420u, r13);
        Intrinsics.checkNotNull(r17);
        com.bytedance.forest.model.s r22 = r17.createSyncRequest(r20.a(r17), r21);
        if (r22 != null) goto L23;
        return null;
    L23:
        return r22.a();
    L13:
        r19 = r15;
        goto L14
    L9:
        r18 = r14;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public static void c(String r5, String r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L26;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length() == 0) goto L27;
        LinkedHashMap r11 = f5399c;
        monitor-enter(r11);
        Set r12 = (Set) r11.get(r5);     // Catch: Throwable -> L15
        if (r12 != null) goto L17;
        r12 = new LinkedHashSet();     // Catch: Throwable -> L15
    L17:
        r12.add(r10);     // Catch: Throwable -> L15
        r11.put(r5, r12);     // Catch: Throwable -> L15
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r11);
        return;
    L15:
        th = move-exception;
        throw th;
    L27:
        return;
    }

    public static void d(String r11, String r12, Scene r13, final String r14, wc.g r15, ForestPostProcessor r16, Function1 r17, final Function1 r18, int r19) {
        final Forest r10 = a();
        if ((r19 & 256) == 0) goto L5;
        Function1 r20 = null;
    L6:
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r16, "processor");
        Intrinsics.checkNotNullParameter(r18, "callback");
        if (j(r10, r11) == true) goto L9;
        return;
    L9:
        j r5 = d.a(r11, false, r12, r13, r14, r15);
        com.bytedance.forest.model.t r21 = r5.d;
        if (r20 == null) goto L12;
        r20.invoke(r21);
    L12:
        Intrinsics.checkNotNull(r10);
        final String r22 = r5.a(r10);
        final com.bytedance.forest.postprocessor.e r23 = new com.bytedance.forest.postprocessor.e(r21, r16);
        c(r23.f4420u, r14);
        new ForestLoader$loadAsyncWithProcessor$1(r10, r22, r23, r14, r18).invoke();
        return;
    L5:
        r20 = r17;
        goto L6
    }

    public static void e(String r10, String r11, Scene r12, final String r13, wc.g r14, Function1 r15, final Function1 r16, int r17) {
        final Forest r18 = a();
        if ((r17 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r17 & 32) == 0) goto L9;
        wc.g r19 = null;
    L11:
        if ((r17 & 128) == 0) goto L13;
        Function1 r20 = null;
    L14:
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r12, "scene");
        Intrinsics.checkNotNullParameter(r16, "callback");
        if (j(r18, r10) == true) goto L17;
        return;
    L17:
        final j r21 = d.a(r10, false, r5, r12, r13, r19);
        com.bytedance.forest.model.t r22 = r21.d;
        if (r20 == null) goto L20;
        r20.invoke(r22);
    L20:
        c(r22.f4420u, r13);
        Intrinsics.checkNotNull(r18);
        final String r23 = r21.a(r18);
        new ForestLoader$loadAsync$1(r18, r23, r21, r13, r16).invoke();
        return;
    L13:
        r20 = r15;
        goto L14
    L9:
        r19 = r14;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public static void f(String r10, final boolean r11, final String r12, PreloadType r13, boolean r14, String r15, wc.g r16) {
        final Forest r5 = a();
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r15, "from");
        if (r5 != null) goto L7;
        f0.g(112, "ForestLoader", "Neither argument nor default of forest is NULL!", null);
        return;
    L7:
        if (r15.length() != 0) goto L10;
        f0.g(112, "ForestLoader", "from is NULL!", null);
        return;
    L10:
        f0.h("ForestLoader", 60, "invoke preload from ".concat(r15), false);
        if (k(r10) == true) goto L14;
        return;
    L14:
        if (g.f5400a[r13.ordinal()] != 1) goto L17;
        Scene r17 = Scene.f4351k;
    L16:
        Scene r18 = r17;
        final j r19 = d.a(r10, true, null, r18, r12, r16);
        com.bytedance.forest.model.t r20 = r19.d;
        ((Map) r20.f4421v.getValue()).put("x-forest-preload-from", r15);
        if (r14 == false) goto L21;
        r20.A = NetWorker.f4465a;
    L21:
        c(r20.f4420u, r12);
        final String r21 = r19.a(r5);
        h(new ForestLoader$preload$5(r5, r21, r19, r11, r12));
        return;
    L17:
        r17 = Scene.f4345a;
        goto L16
    }

    public static void g(String r10, final boolean r11, final String r12, String r13, wc.g r14, ForestPostProcessor r15) {
        PreloadType r5 = PreloadType.f4333a;
        final Forest r16 = a();
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r13, "from");
        Intrinsics.checkNotNullParameter(r15, "processor");
        if (r16 != null) goto L7;
        f0.g(112, "ForestLoader", "Neither argument nor default of forest is NULL!", null);
        return;
    L7:
        if (r13.length() != 0) goto L11;
        f0.g(112, "ForestLoader", "from is NULL!", null);
        return;
    L11:
        if (k(r10) == true) goto L14;
        return;
    L14:
        if (g.f5400a[0] != 1) goto L17;
        Scene r17 = Scene.f4351k;
    L16:
        Scene r18 = r17;
        final j r19 = d.a(r10, true, null, r18, r12, r14);
        com.bytedance.forest.model.t r110 = r19.d;
        ((Map) r110.f4421v.getValue()).put("x-forest-preload-from", r13);
        r110.A = NetWorker.f4465a;
        final String r20 = r19.a(r16);
        final com.bytedance.forest.postprocessor.e r21 = new com.bytedance.forest.postprocessor.e(r110, r15);
        c(r21.f4420u, r12);
        h(new ForestLoader$preloadWithProcessor$4(r16, r20, r21, r11, r12, r19));
        return;
    L17:
        r17 = Scene.f4345a;
        goto L16
    }

    public static void h(Function0 r5) {
        ut.e.f22462b.c(new com.bytedance.android.anniex.monitor.b(5, r5));
    }

    public static void i(final JSONObject r13, String r14) {
        PreloadType r5 = PreloadType.f4334b;
        final Forest r10 = a();
        Intrinsics.checkNotNullParameter("pia_preload", "from");
        Intrinsics.checkNotNullParameter(r5, "type");
        if (r10 != null) goto L6;
        f0.g(112, "ForestLoader", "Neither argument nor default of forest is NULL!", null);
        return;
    L6:
        f0.h("ForestLoader", 60, "invoke preload from ".concat("pia_preload"), false);
        if (k("") == true) goto L10;
        return;
    L10:
        if (g.f5400a[1] != 1) goto L13;
        Scene r11 = Scene.f4351k;
    L12:
        Scene r12 = r11;
        final j r15 = d.a("", true, null, r12, r14, null);
        com.bytedance.forest.model.t r16 = r15.d;
        ((Map) r16.f4421v.getValue()).put("x-forest-preload-from", "pia_preload");
        c(r16.f4420u, r14);
        final String r17 = r15.a(r10);
        h(new ForestLoader$preload$2(r10, r17, r15, r13));
        return;
    L13:
        r11 = Scene.f4345a;
        goto L12
    }

    public static boolean j(Forest r5, String r10) {
        if (r5 != null) goto L10;
        f0.g(112, "ForestLoader", "Neither argument nor default of forest is NULL!", null);
        if (com.bytedance.ies.bullet.core.h.g.f5315a == true) goto L8;
        return false;
    L8:
        throw new IllegalArgumentException("Neither argument nor default of forest is NULL!");
    L10:
        if (k(r10) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean k(String r5) {
        if (Uri.parse(r5).isHierarchical() == true) goto L6;
        f0.g(112, "ForestLoader", r5 + " is not a hierarchical uri", null);
        return false;
    L6:
        return true;
    }

    public static void l(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L63;
        ConcurrentHashMap r10 = f5397a.h(r5);
        if (r10 == null) goto L25;
        Set r11 = r10.entrySet();
        if (r11 == null) goto L25;
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L25;
        com.bytedance.forest.model.s r13 = (com.bytedance.forest.model.s) ((Map.Entry) r12.next()).getValue();
        if (r13.e == Status.f4357b) goto L17;
        if (r13.e != Status.f4356a) goto L12;
    L17:
        r13.e = Status.d;
        com.bytedance.forest.chain.a r14 = r13.d;
        if (r14 == null) goto L12;
        if (r14.f4242b == true) goto L12;
        r14.f4242b = true;
        ResourceFetcher r15 = r14.f4241a;
        if (r15 == null) goto L12;
        r15.cancel();
    L25:
        f5398b.h(r5);
        d.f5410a.h(r5);
        LinkedHashMap r16 = f5399c;
        monitor-enter(r16);
        Iterator r17 = r16.entrySet().iterator();     // Catch: Throwable -> L35
    L29:
        if (r17.hasNext() == false) goto L38;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L35
        String r19 = (String) r18.getKey();     // Catch: Throwable -> L35
        Set r20 = (Set) r18.getValue();     // Catch: Throwable -> L35
        r20.remove(r5);     // Catch: Throwable -> L35
        if (r20.isEmpty() == false) goto L29;
        Forest r21 = a();     // Catch: Throwable -> L35
        if (r21 == null) goto L37;
        r21.closeSession(r19);     // Catch: Throwable -> L35
    L37:
        r17.remove();     // Catch: Throwable -> L35
        goto L29
    L38:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r16);
        return;
    L35:
        th = move-exception;
        throw th;
    }
}
