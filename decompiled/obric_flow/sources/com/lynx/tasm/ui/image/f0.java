package com.lynx.tasm.ui.image;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.WebView;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort$JSInterface;
import com.bytedance.ai.bridge.method.net.core.RequestMethod;
import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.common.utility.Logger;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.buffer.impl.MMapBuffer;
import com.bytedance.geckox.logger.GeckoLogger;
import com.ss.android.agilelogger.ALog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r13v4, types: [T, java.lang.String] */
    public static c2.a a(RequestMethod r13, c2.b r14, IHostNetworkDepend r15) {
        Intrinsics.checkNotNullParameter(r13, "method");
        Intrinsics.checkNotNullParameter(r14, "request");
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        LinkedHashMap r5 = new LinkedHashMap();
        Ref.IntRef r10 = new Ref.IntRef();
        r10.element = -1;
        Ref.IntRef r11 = new Ref.IntRef();
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = "";
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        Triple r19 = l(r14);     // Catch: Throwable -> L10
        String r20 = (String) r19.getFirst();     // Catch: Throwable -> L10
        String r110 = (String) r19.getSecond();     // Catch: Throwable -> L10
        Map r21 = (Map) r19.getThird();     // Catch: Throwable -> L10
        p(r14);     // Catch: Throwable -> L10
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L10
        r22.put("isCustomizedCookie", Boolean.valueOf(r14.f1109b));     // Catch: Throwable -> L10
        r22.put("needAddCommonParams", Boolean.valueOf(r14.f1108a));     // Catch: Throwable -> L10
        IAppletRetrofit r111 = r15.createRetrofit(r20, false, r22);     // Catch: Throwable -> L10
        if (r111 != null) goto L6;
    L12:
        int r112 = r13.ordinal();     // Catch: Throwable -> L10
        if (r112 != 0) goto L15;
    L18:
        ?? r113 = "call is null, method is " + r13.name();     // Catch: Throwable -> L10
        r16.element = r113;     // Catch: Throwable -> L10
        Logger.d("HostNetworkDependImpl", r113);     // Catch: Throwable -> L10
    L22:
        return new c2.a(r5, r10, r12, r16, r17, r11, r18);
    L15:
        if (r112 != 1) goto L18;
        q(r14);     // Catch: Throwable -> L10
        goto L18
    L6:
        if (r111.create(c2.d.class) == null) goto L12;
        throw new ClassCastException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r16.element = "request for string cause exception";
        r17.element = th;
        Logger.e("HostNetworkDependImpl", (String) r16.element, th);
        goto L22
    }

    public static j1.g b(WebView r10) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        WeakHashMap r5 = WebViewAIBridgePort$JSInterface.f1797c;
        Intrinsics.checkNotNullParameter(r10, "webView");
        boolean r11 = Intrinsics.areEqual(c1.b.c().getLooper(), Looper.myLooper());
        if (r11 == true) goto L6;
        Intrinsics.checkNotNullParameter("ThreadUtils", "tag");
        Intrinsics.checkNotNullParameter("checkMainThread not in main thread", "msg");
        a1.a.f43a.e("ThreadUtils", "checkMainThread not in main thread", null);
    L6:
        if (r11 == true) goto L8;
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("RTSInterface initialize must be called on main thread", "msg");
        a1.a.f43a.e("ai_bridge", "RTSInterface initialize must be called on main thread", null);
    L12:
        WebViewAIBridgePort$JSInterface r12 = (WebViewAIBridgePort$JSInterface) WebViewAIBridgePort$JSInterface.f1797c.get(r10);
        if (r12 != null) goto L16;
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("[WebViewAIBridgePort] must call JSInterface::initialize before create WebViewAIBridgePort", "msg");
        a1.a.f43a.e("ai_bridge", "[WebViewAIBridgePort] must call JSInterface::initialize before create WebViewAIBridgePort", null);
        return null;
    L16:
        AtomicReference r13 = r12.f1798a;
        l2.a r14 = new l2.a();
    L18:
        if (r13.compareAndSet(null, r14) == true) goto L19;
        if (r13.get() == null) goto L18;
        r12.f1799b = (l2.a) r13.get();
        l2.a r15 = (l2.a) r13.getAndSet(null);
    L23:
        if (r15 != null) goto L25;
        return null;
    L25:
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("[WebViewAIBridgePort] WebViewAIBridgePort create success", "msg");
        a1.a.f43a.d("ai_bridge", "[WebViewAIBridgePort] WebViewAIBridgePort create success");
        return new j1.g(new WeakReference(r10), r15);
    L19:
        r12.f1799b = (l2.a) r13.get();
        r15 = (l2.a) r13.get();
        goto L23
    L8:
        WeakHashMap r16 = WebViewAIBridgePort$JSInterface.f1797c;
        if (r16.get(r10) != null) goto L12;
        WebViewAIBridgePort$JSInterface r17 = new WebViewAIBridgePort$JSInterface();
        r10.addJavascriptInterface(r17, "AppletBridgeModule");
        r16.put(r10, r17);
        goto L12
    }

    public static Object c(rc.f r5, Class r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        rc.a r11 = (rc.a) r5.getServiceContext();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "clazz");
        zm.z r12 = r11.f21720c;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r10, "clazz");
        tc.b r13 = (tc.b) ((ConcurrentHashMap) r12.f23549a).get(r10);
        if (r13 == null) goto L12;
        Object r14 = r13.f22118a;
        if (r14 == null) goto L12;
        if (r10.isAssignableFrom(r14.getClass()) == true) goto L10;
        r14 = null;
    L10:
        if (r14 == null) goto L12;
        return r14;
    L12:
        return null;
    }

    public static String d(Exception r5, StringBuilder r10, String r11) {
        r10.append(r5.getMessage());
        String r12 = r10.toString();
        Intrinsics.checkNotNullParameter(r11, "tag");
        return r12;
    }

    public static la.a e(long r5, File r10) {
        if (r5 <= 0) goto L24;
        df.c.f16652i.a();
        GeckoGlobalConfig r11 = df.c.f;
        if (r11 != null) goto L12;
    L26:
        return new MMapBuffer(r5, r10);
    L15:
        e = move-exception;
        GeckoLogger.b("mmap failed: " + r10.exists() + '-' + r10.length() + '-' + r5 + '-' + e.getMessage());
    L22:
        return new a7.c(r5, r10);
    L19:
        e = move-exception;
        throw new RuntimeException("RAFBuffer failed! file: " + r10.getAbsolutePath() + '-' + e.getMessage(), e);
    L12:
        if (r11.isUseMMap() == false) goto L22;
    L24:
        return new i4.a(r10, 14);
    L6:
        e = move-exception;
        throw new IOException("create FileBuffer failed! file:" + r10.getAbsolutePath() + " caused by:" + e.getMessage(), e);
    }

    public static /* synthetic */ void f(int r10, String r11, String r12) {
        if ((r10 & 4) == 0) goto L6;
        boolean r13 = false;
    L7:
        k(r11, r12, r13, null, "", null);
        return;
    L6:
        r13 = true;
        goto L7
    }

    public static /* synthetic */ void g(int r10, String r11, String r12, Throwable r13) {
        if ((r10 & 4) == 0) goto L5;
        r13 = null;
    L5:
        j(r11, r12, r13, true, null, "", null);
    }

    public static /* synthetic */ void h(String r10, int r11, String r12, boolean r13) {
        if ((r11 & 4) == 0) goto L5;
        r13 = false;
    L5:
        o(r10, r12, r13, null, "", null);
    }

    public static void i(String r5, String r10, Throwable r11) {
        Log.e("Forest_" + r5, r10, r11);
    }

    public static void j(String r5, String r10, Throwable r11, boolean r12, Function3 r13, String r14, HashMap r15) {
        if (r15 == null) goto L4;
        HashMap r16 = r15;
    L5:
        r16.put("name", r14);
        r16.put("message", r10);
        String r17 = r16.toString();
        if (r12 == false) goto L16;
        if (r13 != null) goto L19;
    L12:
        ALog.e("Forest_" + r5, r17, r11);     // Catch: Throwable -> L14
    L18:
        return;
    L14:
        Log.e("Forest_" + r5, r17, r11);
        return;
    L19:
        if (r14.length() <= 0) goto L12;
        if (r15 == null) goto L12;
        r13.invoke(6, "Forest_" + r5, r16);     // Catch: Throwable -> L14
        goto L18
    L16:
        Log.e("Forest_" + r5, r17, r11);
        return;
    L4:
        r16 = new HashMap(2);
        goto L5
    }

    public static void k(String r5, String r10, boolean r11, Function3 r12, String r13, HashMap r14) {
        if (r14 != null) goto L5;
        r14 = new HashMap(2);
    L5:
        r14.put("name", r13);
        r14.put("message", r10);
        String r15 = r14.toString();
        if (r11 == false) goto L15;
        if (r12 != null) goto L18;
    L11:
        ALog.d("Forest_" + r5, r15);     // Catch: Throwable -> L13
    L17:
        return;
    L13:
        Log.d("Forest_" + r5, r15);
        return;
    L18:
        if (r13.length() <= 0) goto L11;
        r12.invoke(3, "Forest_" + r5, r14);     // Catch: Throwable -> L13
        goto L17
    L15:
        Log.d("Forest_" + r5, r15);
    }

    public static Triple l(c2.b r5) {
        LinkedHashMap r10 = new LinkedHashMap();
        Pair r11 = com.bytedance.frameworks.baselib.network.http.util.c.c(new ym.p((String) r5.f1110c, 3).m(), r10);
        return new Triple((String) r11.first, (String) r11.second, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r12v4, types: [T, java.lang.String] */
    public static ug.d m(RequestMethod r12, c2.b r13, IHostNetworkDepend r14) {
        Intrinsics.checkNotNullParameter(r12, "method");
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "hostNetworkDepend");
        LinkedHashMap r5 = new LinkedHashMap();
        Ref.IntRef r10 = new Ref.IntRef();
        r10.element = -1;
        Ref.IntRef r11 = new Ref.IntRef();
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = "";
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        Triple r18 = l(r13);     // Catch: Throwable -> L10
        String r19 = (String) r18.getFirst();     // Catch: Throwable -> L10
        String r110 = (String) r18.getSecond();     // Catch: Throwable -> L10
        Map r20 = (Map) r18.getThird();     // Catch: Throwable -> L10
        p(r13);     // Catch: Throwable -> L10
        LinkedHashMap r21 = new LinkedHashMap();     // Catch: Throwable -> L10
        r21.put("isCustomizedCookie", Boolean.valueOf(r13.f1109b));     // Catch: Throwable -> L10
        r21.put("needAddCommonParams", Boolean.valueOf(r13.f1108a));     // Catch: Throwable -> L10
        IAppletRetrofit r111 = r14.createRetrofit(r19, false, r21);     // Catch: Throwable -> L10
        if (r111 != null) goto L6;
    L12:
        int r112 = r12.ordinal();     // Catch: Throwable -> L10
        if (r112 != 0) goto L15;
    L25:
        ?? r113 = "call is null, method is " + r12.name();     // Catch: Throwable -> L10
        r16.element = r113;     // Catch: Throwable -> L10
        Logger.d("HostNetworkDependImpl", r113);     // Catch: Throwable -> L10
    L29:
        return new ug.d(r5, r10, r15, r16, r17, r11, 1);
    L15:
        if (r112 != 1) goto L17;
        q(r13);     // Catch: Throwable -> L10
        goto L25
    L17:
        if (r112 != 2) goto L19;
        q(r13);     // Catch: Throwable -> L10
        goto L25
    L19:
        if (r112 == 3) goto L25;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L10
    L6:
        if (r111.create(c2.d.class) == null) goto L12;
        throw new ClassCastException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r16.element = "request for string cause exception";
        r17.element = th;
        Logger.e("HostNetworkDependImpl", (String) r16.element, th);
        goto L29
    }

    public static /* synthetic */ void n(int r5, String r10, String r11) {
        if ((r5 & 1) == 0) goto L5;
        r10 = null;
    L5:
        i(r10, r11, null);
    }

    public static void o(String r5, String r10, boolean r11, Function3 r12, String r13, HashMap r14) {
        if (r14 == null) goto L4;
        HashMap r15 = r14;
    L5:
        r15.put("name", r13);
        r15.put("message", r10);
        String r16 = r15.toString();
        if (r11 == false) goto L13;
        if (r12 != null) goto L17;
    L12:
        ALog.i("Forest_" + r5, r16);     // Catch: Throwable -> L15
    L16:
        goto L13
    L17:
        if (r13.length() <= 0) goto L12;
        if (r14 == null) goto L12;
        r12.invoke(4, "Forest_" + r5, r15);     // Catch: Throwable -> L15
    L13:
        Log.i("Forest_" + r5, r16);
        return;
    L4:
        r15 = new HashMap(2);
        goto L5
    }

    public static void p(c2.b r5) {
        ArrayList r10 = new ArrayList();
        LinkedHashMap r11 = (LinkedHashMap) r5.e;
        if (r11 == null) goto L8;
        Iterator r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry r13 = (Map.Entry) r12.next();
        r10.add(new bi.c((String) r13.getKey(), (String) r13.getValue()));
    L8:
        String r14 = (String) r5.d;
        if (r14 == null) goto L13;
        r10.add(new bi.c("Content-Type", r14));
        return;
    }

    public static void q(c2.b r5) {
        if (((byte[]) r5.f) != null) goto L5;
        return;
    L5:
        if (((String) r5.d) != null) goto L9;
        TextUtils.isEmpty(null);
        return;
    }

    public static final void r(String r5) {
        if (r5 != null) goto L4;
        r5 = "null";
    L4:
        Intrinsics.checkNotNullParameter("debugging", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.d("debugging", r5);
    }

    public static boolean s(String r5, List r10) {
        if (com.bytedance.common.utility.b.b(r5) == true) goto L22;
        if (r10 != null) goto L6;
    L9:
        boolean r11 = true;
    L10:
        if (r11 == true) goto L22;
        Iterator r12 = r10.iterator();
    L14:
        if (r12.hasNext() == false) goto L22;
        String r13 = (String) r12.next();
        if (com.bytedance.common.utility.b.b(r13) == true) goto L14;
        if (r5.endsWith(r13) == false) goto L14;
        return true;
    L6:
        if (r10.size() == 0) goto L9;
        r11 = false;
    L22:
        return false;
    }

    public static boolean t() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void u(com.bytedance.frameworks.baselib.network.http.util.a r5, ei.b r10) {
        if (r5 == null) goto L32;
        monitor-enter(r5);
        int r11 = r5.f4690b;     // Catch: Throwable -> L29
        monitor-exit(r5);
        if (r11 <= 0) goto L46;
        monitor-enter(r5);
        Map r12 = r5.f4689a;     // Catch: Throwable -> L26
        monitor-exit(r5);
        Collection r13 = r12.values();
        monitor-enter(r12);
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L20
    L14:
        if (r14.hasNext() == false) goto L22;
        CopyOnWriteArrayList r15 = ((ai.h0) r14.next()).f216h;     // Catch: Throwable -> L20
        if (r15 == null) goto L14;
        if (r15.contains(r10) == true) goto L14;
        r15.add(r10);     // Catch: Throwable -> L20
        goto L14
    L22:
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L26:
        th = move-exception;
        throw th;
    L46:
        return;
    L29:
        th = move-exception;
        throw th;
    }
}
