package ab;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.monitorV2.h;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.upload.n;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.ies.bullet.service.monitor.i;
import com.bytedance.ies.web.jsbridge2.l;
import com.bytedance.ies.web.jsbridge2.u;
import com.bytedance.pia.core.utils.m;
import com.bytedance.pia.core.worker.bridge.BridgeModule;
import com.bytedance.pia.nsr.f;
import com.bytedance.salamander.anniex.b0;
import com.bytedance.sdk.xbridge.cn.platform.web.e;
import com.bytedance.sliver.Sliver;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.common.reflect.w;
import com.lynx.animax.player.VideoAsset;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.base.log.LynxLog;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.tasm.EventEmitter$LynxEventType;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.t;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.y;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.q;
import com.lynx.tasm.r;
import com.lynx.tasm.s0;
import com.lynx.tasm.u0;
import com.lynx.tasm.ui.image.v;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rh.g;
import ug.d;
import x4.c;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f156c;

    public /* synthetic */ b(int r5, Object r10, Object r11) {
        this.f154a = r5;
        this.f155b = r10;
        this.f156c = r11;
    }

    private final void a() {
        i r5 = (i) this.f156c;
        x r12 = (x) this.f155b;
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Exception -> L6
        StringBuilder r11 = new StringBuilder("report ");     // Catch: Exception -> L6
        r11.append(r12.f6022a);     // Catch: Exception -> L6
        r11.append(", url ");     // Catch: Exception -> L6
        ad.a r13 = (ad.a) r12.f6027j;     // Catch: Exception -> L6
        if (r13 == null) goto L8;
        String r14 = r13.a();     // Catch: Exception -> L6
    L9:
        r11.append(r14);     // Catch: Exception -> L6
        r11.append(", fullUrl ");     // Catch: Exception -> L6
        ad.a r15 = (ad.a) r12.f6027j;     // Catch: Exception -> L6
        if (r15 == null) goto L12;
        String r16 = r15.f157a.toString();     // Catch: Exception -> L6
    L13:
        r11.append(r16);     // Catch: Exception -> L6
        r11.append(", category ");     // Catch: Exception -> L6
        r11.append((JSONObject) r12.e);     // Catch: Exception -> L6
        r11.append(" metrics  ");     // Catch: Exception -> L6
        r11.append((JSONObject) r12.f);     // Catch: Exception -> L6
        com.bytedance.ies.bullet.service.base.b.d(r11.toString(), LogLevel.f5954b, "Monitor-Report");     // Catch: Exception -> L6
        Lazy r17 = i.d;     // Catch: Exception -> L6
        r5.getClass();     // Catch: Exception -> L6
        if (((JSONObject) r12.e) != null) goto L17;
        r12.e = new JSONObject();     // Catch: Exception -> L6
    L17:
        if (((JSONObject) r12.f) != null) goto L20;
        r12.f = new JSONObject();     // Catch: Exception -> L6
    L20:
        if (((JSONObject) r12.g) != null) goto L22;
        r12.g = new JSONObject();     // Catch: Exception -> L6
    L22:
        ad.a r18 = (ad.a) r12.f6027j;     // Catch: Exception -> L6
        if (r18 == null) goto L26;
        String r19 = r18.a();     // Catch: Exception -> L6
        if (r19 == null) goto L26;
    L27:
        r12.f6023b = r19;     // Catch: Exception -> L6
        String r20 = r12.f6024c;     // Catch: Exception -> L6
        int r110 = 3;
        if (r20 != null) goto L37;
        ad.a r21 = (ad.a) r12.f6027j;     // Catch: Exception -> L6
        if (r21 == null) goto L38;
        int r22 = r21.b().ordinal();     // Catch: Exception -> L6
        if (r22 == 1) goto L36;
        if (r22 == 3) goto L35;
        r20 = "unknown";
        goto L37
    L35:
        r20 = "lynx";
        goto L37
    L36:
        r20 = "web";
        goto L37
    L38:
        String r23 = null;
    L39:
        JSONObject r24 = (JSONObject) r12.e;     // Catch: Exception -> L6
        w r111 = r5.f6054b;
        if (r24 == null) goto L43;
        i.e(r5, r24, r111, r23, r12.f6023b, (ad.a) r12.f6027j);     // Catch: Exception -> L6
    L43:
        JSONObject r25 = (JSONObject) r12.g;     // Catch: Exception -> L6
        int r26 = 0;
        if (r25 == null) goto L54;
        td.b.f(r25, null);     // Catch: Exception -> L6
        ad.a r27 = (ad.a) r12.f6027j;     // Catch: Exception -> L6
        if (r27 == null) goto L48;
        KitType r28 = r27.b();     // Catch: Exception -> L6
    L50:
        if (r28 == KitType.d) goto L53;
        r110 = 0;
    L53:
        r25.put(WsConstants.KEY_PLATFORM, r110);     // Catch: Exception -> L6
        goto L54
    L48:
        r28 = null;
    L54:
        Intrinsics.checkNotNullParameter(r12, "info");     // Catch: Exception -> L6
        String r29 = (String) r111.f9377c;     // Catch: Exception -> L6
        if (r29 != null) goto L57;
    L60:
        String r30 = "bullet_custom_bid";
    L62:
        if (Intrinsics.areEqual((Boolean) r12.f6026i, Boolean.TRUE) == false) goto L65;
        r26 = 2;
    L65:
        if (Intrinsics.areEqual(r5.f22117a, "BDUG_BID") == false) goto L67;
        r26 = 6;
    L67:
        l r31 = new l(r12.f6022a, 1);     // Catch: Exception -> L6
        r31.f6290b = r12.f6023b;     // Catch: Exception -> L6
        r31.f6292h = (JSONObject) r12.e;     // Catch: Exception -> L6
        r31.f6293i = (JSONObject) r12.f;     // Catch: Exception -> L6
        r31.f6294j = (JSONObject) r12.f6025h;     // Catch: Exception -> L6
        r31.f6296l = (JSONObject) r12.g;     // Catch: Exception -> L6
        r31.f6291c = r30;     // Catch: Exception -> L6
        r31.f = null;     // Catch: Exception -> L6
        r31.b(r26);     // Catch: Exception -> L6
        r31.e = (String) r12.d;     // Catch: Exception -> L6
        com.bytedance.ies.bullet.service.monitor.intercept.b.a(r111, r12, r30);     // Catch: Exception -> L6
        h r112 = h.e();     // Catch: Exception -> L6
        c r32 = r31.a();     // Catch: Exception -> L6
        r112.getClass();     // Catch: Exception -> L6
        h.d(r32);     // Catch: Exception -> L6
        return;
    L57:
        if (r29.length() == 0) goto L60;
        r30 = (String) r111.f9377c;     // Catch: Exception -> L6
    L37:
        r23 = r20;
    L26:
        r19 = r12.f6023b;     // Catch: Exception -> L6
        goto L27
    L12:
        r16 = null;
        goto L13
    L8:
        r14 = null;
    L6:
        e = move-exception;
        boolean r33 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(androidx.room.jarjarred.org.antlr.runtime.a.o(e, new StringBuilder("report failed, ")), LogLevel.d, "Monitor-Report");
    }

    private final void b() {
        r r5 = (r) this.f156c;
        com.lynx.tasm.i r10 = r5.e;
        on.b r11 = (on.b) this.f155b;
        String r12 = r11.f20780b;
        if (r10 != null) goto L5;
    L18:
        LynxLog.b(4, "EventEmitter", "sendCustomEvent event: " + r12 + " failed since mEngineProxy is null or in preload.");
    L19:
        q r13 = new q(r5, EventEmitter$LynxEventType.f9956a, r11, 0);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L22;
        r13.run();
        return;
    L22:
        r5.g.post(r13);
        return;
    L5:
        if (r5.f10940b == true) goto L18;
        if (r5.c(r11) == false) goto L9;
        return;
    L9:
        r11.a("timestamp", Long.valueOf(r11.e));
        WeakReference r14 = r5.d;
        if (r14 != null) goto L12;
    L16:
        LynxLog.b(4, "EventEmitter", "checkFallbackForLynxEvent event: " + r12 + " failed since mEventFallback is null.");
        return;
    L12:
        if (r14.get() == null) goto L16;
        ((LynxTemplateRender) ((com.lynx.tasm.c) r5.d.get())).getClass();
        LynxEngineProxy r15 = (LynxEngineProxy) r5.e.f10879a;
        if (r15 == null) goto L19;
        j.f(new v(21, r15, r11));
        goto L19
    }

    private final void c() {
        LynxTemplateRender r10 = (LynxTemplateRender) ((WeakReference) this.f155b).get();
        if (r10 == null) goto L50;
        r10.E = false;
        PerformanceController r5 = r10.Q;
        if (r5 == null) goto L51;
        com.lynx.tasm.behavior.i r11 = r10.O;
        if (r11 == null) goto L52;
        n0 r12 = ((LynxUIRenderer) r11).f10161b;
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.g != null) goto L17;
        HashMap r13 = null;
    L36:
        if (r13 == null) goto L53;
        LynxEventReporter.runOnReportThread(new a2.b(6, r5, r13));
        return;
    L53:
        return;
    L17:
        HashMap r14 = new HashMap();
        Iterator r15 = r12.g.entrySet().iterator();
    L19:
        if (r15.hasNext() == false) goto L35;
        LynxBaseUI r16 = (LynxBaseUI) ((Map.Entry) r15.next()).getValue();
        if (r16 != null) goto L22;
        LynxLog.b(4, "LynxUIOwner", "getMemoryUsage failed, the ui is null or not LynxBaseUI");
        goto L19
    L22:
        String r17 = r16.getTagName();
        if (r17 == null) goto L19;
        long r18 = r16.getMemoryUsageBytes();
        bo.a r19 = (bo.a) r14.get(r17);
        if (r19 != null) goto L28;
        r19 = new bo.a(r17);
        r14.put(r17, r19);
    L28:
        r19.f965c++;
        r19.f964b += r18;
        Map<String, String> r20 = r16.getMemoryUsageDetail();
        if (r20 == null) goto L19;
        if (r19.d != null) goto L33;
        r19.d = new HashMap();
    L33:
        r19.d.putAll(r20);
        goto L19
    L35:
        r13 = r14;
        goto L36
    L52:
        return;
    L51:
        return;
    }

    private final void d() {
        d r5 = (d) this.f156c;
        byte[] r10 = (byte[]) this.f155b;
        if (r10 != null) goto L5;
    L29:
        r5.a("Source is null!");
        return;
    L5:
        if (r10.length == 0) goto L29;
        if (LynxTemplateRender.a((LynxTemplateRender) r5.g) == null) goto L11;
        LynxDevtool r11 = LynxTemplateRender.a((LynxTemplateRender) r5.g);
        Object r12 = r5.d;
        r11.getClass();
    L11:
        if (LynxTemplateRender.a((LynxTemplateRender) r5.g) == null) goto L13;
        LynxTemplateRender.a((LynxTemplateRender) r5.g).getClass();
    L13:
        ((LynxTemplateRender) r5.g).Q.j("prepareTemplateEnd");
        if (((com.lynx.tasm.x) r5.f) != null) goto L27;
        TemplateData r13 = (TemplateData) r5.f22357b;
        if (r13 != null) goto L25;
        Map r14 = (Map) r5.e;
        if (r14 == null) goto L21;
        r13 = TemplateData.c(r14);
        goto L25
    L21:
        String r15 = (String) r5.f22358c;
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        r13 = TemplateData.b(r15);
    L25:
        ((LynxTemplateRender) r5.g).I(r10, r13);
        return;
    L27:
        p r16 = p.i("loadBundle", "loadBundleStart");
        ((LynxTemplateRender) r5.g).Q.getClass();
        com.lynx.tasm.x r17 = (com.lynx.tasm.x) r5.f;
        r17.f11192b = r10;
        ((LynxTemplateRender) r5.g).o(r17, r16);
    }

    private final void e() {
        com.lynx.tasm.behavior.w r5 = (com.lynx.tasm.behavior.w) this.f156c;
        ArrayList r10 = r5.f10805v;
        t r11 = (t) this.f155b;
        if (r10.contains(r11) == true) goto L19;
        ArrayList r12 = r5.f10805v;
        r12.add(r11);
        if (r12.size() != 1) goto L17;
        LynxContext r13 = r11.c();
        if (r13 == null) goto L14;
        DisplayMetrics r14 = DisplayMetricsHolder.b(r13);
        int r15 = r14.widthPixels;
        int[] r16 = r5.f10212t;
        boolean r17 = false;
        r16[0] = r15;
        r16[1] = r14.heightPixels;
        u0 r18 = r13.K;
        if (r18 == null) goto L12;
        r17 = r18.E;
    L12:
        r5.f10808y = r17;
    L14:
        if (r5.f10808y == false) goto L18;
        r5.c();
        return;
    L18:
        return;
    L17:
        return;
    }

    private final void f() {
        com.lynx.tasm.behavior.w r5 = (com.lynx.tasm.behavior.w) this.f156c;
        Iterator r10 = r5.f10805v.iterator();
    L4:
        if (r10.hasNext() == false) goto L18;
        t r11 = (t) r10.next();
        if (r11.f10366c != ((LynxBaseUI) this.f155b)) goto L4;
        r5.f10805v.remove(r11);
        if (r5.f10808y == true) goto L10;
        return;
    L10:
        if (r5.f10805v.isEmpty() == false) goto L17;
        r5.d();
        return;
    L17:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = false;
        r5 = false;
        int r10 = 1;
        switch(this.f154a) {
            case 0: goto L315;
            case 1: goto L279;
            case 2: goto L261;
            case 3: goto L255;
            case 4: goto L253;
            case 5: goto L246;
            case 6: goto L240;
            case 7: goto L237;
            case 8: goto L136;
            case 9: goto L320;
            case 10: goto L90;
            case 11: goto L88;
            case 12: goto L84;
            case 13: goto L79;
            case 14: goto L63;
            case 15: goto L61;
            case 16: goto L59;
            case 17: goto L57;
            case 18: goto L45;
            case 19: goto L40;
            case 20: goto L32;
            case 21: goto L29;
            case 22: goto L26;
            case 23: goto L24;
            case 24: goto L22;
            case 25: goto L20;
            case 26: goto L18;
            case 27: goto L16;
            case 28: goto L14;
            default: goto L4;
        };
    L4:
        y r11 = (y) this.f156c;
        HashMap r12 = r11.f10779v;
        String r13 = (String) this.f155b;
        if (r12.get(r13) != null) goto L8;
        return;
    L8:
        if (((LynxBaseUI) ((com.lynx.tasm.behavior.ui.x) r11.f10779v.get(r13)).f10775a.get()) == null) goto L11;
        r11.f10779v.remove(r13);
    L11:
        if (r11.f10779v.isEmpty() == false) goto L357;
        r11.getClass();
        j.f(new com.lynx.tasm.behavior.ui.l(r11, r10));
        return;
    L357:
        return;
    L14:
        f();
        return;
    L16:
        e();
        return;
    L18:
        ((s0) this.f156c).b((b0) this.f155b);
        return;
    L20:
        d();
        return;
    L22:
        ((LynxTemplateRender) this.f156c).V((com.lynx.tasm.x) this.f155b);
        return;
    L24:
        c();
        return;
    L26:
        b();
        return;
    L32:
        com.lynx.animax.player.i r14 = (com.lynx.animax.player.i) this.f156c;
        r14.f++;
        r14.f9676h = false;
        boolean r15 = r14.e;
        String r16 = (String) this.f155b;
        if (r15 == false) goto L35;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AbsVideoPlayer", "Error(" + r14.f + "): " + r16);
        return;
    L35:
        r14.e = true;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AbsVideoPlayer", "Error(" + r14.f + "): " + r16);
        IAnimaXMonitorService r17 = (IAnimaXMonitorService) ((com.lynx.animax.player.b) r14.f9677i.f9667c).c(IAnimaXMonitorService.class);
        if (r17 == null) goto L361;
        HashMap r18 = new HashMap();
        r18.put("code", 4);
        r18.put("msg", r16);
        r18.put("error_count", Integer.valueOf(r14.f));
        r17.reportError(new dm.a(r18));
        return;
    L361:
        return;
    L40:
        com.lynx.animax.player.a r19 = ((com.lynx.animax.player.i) this.f156c).f9681m;
        if (r19 == null) goto L43;
        r19.f9653m = null;
        r19.d();
    L43:
        ((CountDownLatch) this.f155b).countDown();
        return;
    L45:
        com.lynx.animax.player.a r20 = ((com.lynx.animax.player.i) this.f156c).f9681m;
        VideoAsset r21 = (VideoAsset) this.f155b;
        r20.f9654n = r21;
        if (r21 != null) goto L49;
        return;
    L49:
        if (r21.a() == true) goto L51;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "CodecManager", "attachAsset error: prepareFrameBuffer fail, reset mAsset");
        r20.f9654n = null;
        return;
    L51:
        long r22 = (long) r20.f9654n.getFrameRate();
        if (r22 > 0) goto L55;
        r22 = 30;
    L55:
        r20.f9652l = 1000000 / r22;
        return;
    L57:
        Sliver.access$300(((com.bytedance.sliver.b) this.f155b).f7514a);
        Sliver.onStep(((Thread) this.f156c) + " clear success");
        return;
    L59:
        ((e) this.f155b).k((String) this.f156c);
        return;
    L61:
        ((com.bytedance.sdk.xbridge.cn.auth.i) this.f155b).f7347a.a("XBridge-auth", (String) this.f156c);
        return;
    L63:
        g r23 = (g) this.f155b;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L66
        Object r25 = Result.m124constructorimpl(new rh.i(r23));     // Catch: Throwable -> L66
    L68:
        Throwable r26 = Result.m127exceptionOrNullimpl(r25);
        f r27 = (f) this.f156c;
        if (r26 == null) goto L72;
        r27.a(r26.toString());
    L72:
        if (Result.m130isFailureimpl(r25) == false) goto L74;
        r25 = null;
    L74:
        rh.i r28 = (rh.i) r25;
        if (r28 == null) goto L364;
        r28.f("!function(){var e=globalThis.NativeModules,t=e.get(\"BaseModule\");globalThis.location={href:t.getHref()},globalThis.navigator={userAgent:t.getUserAgent()},globalThis.NativeModules={get:function(l){var a=e.get(l);return\"BaseModule\"==l?Object.assign(a,{storeNSRHtml:function(e){t.terminateWithResult({html:e})}}):a}}}();");
        r28.f21770o.b(BridgeModule.class, r28.f21772q, "bridge");
        r28.c(new com.bytedance.pia.nsr.c(r27, r28, false ? 1 : 0));
        r28.f21762c.b(new rh.e(r28, com.bytedance.pia.nsr.d.f7184a, r10));
        r28.f(null);
        r28.h();
        ((Handler) m.f7156b.getValue()).postDelayed(new b(13, new WeakReference(r28), r27), 30000);
        return;
    L364:
        return;
    L66:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r25 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L68
    L79:
        rh.i r30 = (rh.i) ((WeakReference) this.f155b).get();
        if (r30 == null) goto L365;
        r30.b(null);
        ((f) this.f156c).a("Timeout!");
        return;
    L365:
        return;
    L88:
        a();
        return;
    L90:
        com.bytedance.ies.bullet.base.utils.logger.a.c("XPrefetch", "异步更新配置");
        com.bytedance.ies.bullet.prefetchv2.c.a((Uri) this.f155b, (String) this.f156c);
        return;
    L136:
        Request r31 = ((com.bytedance.forest.model.w) this.f156c).f4441q;
        LinkedHashMap r32 = new LinkedHashMap();
        r32.put("res_loader_name", "forest");
        r32.put("res_loader_version", "3.8.6.3-bugfix");
        com.bytedance.forest.b r33 = (com.bytedance.forest.b) this.f155b;
        com.bytedance.forest.model.w r34 = (com.bytedance.forest.model.w) this.f156c;
        Lazy r35 = com.bytedance.forest.b.f4230b;
        r33.getClass();
        LinkedHashMap r36 = new LinkedHashMap();
        r36.put("res_src", r31.getOriginUrl());
        r36.put("gecko_access_key", r31.getGeckoModel().f4389a);
        r36.put("gecko_channel", r31.getGeckoModel().f4390b);
        r36.put("gecko_bundle", r31.getGeckoModel().f4391c);
        r36.put("res_version", Long.valueOf(r34.f4449z));
        if (r34.f4442r == false) goto L139;
        String r37 = "success";
    L140:
        r36.put("res_state", r37);
        r36.put("gecko_sync_update", Boolean.valueOf(r31.getWaitGeckoUpdate()));
        r36.put("cdn_cache_enable", Boolean.valueOf(r31.getEnableCDNCache()));
        r36.put("load_to_memory", Boolean.valueOf(r31.getLoadToMemory()));
        String r38 = r31.getScene().name();
        Locale r110 = Locale.ENGLISH;
        if (r38 == null) goto L236;
        r36.put("res_scene", r38.toLowerCase(r110));
        String r39 = r31.getGeckoSource().name();
        if (r39 == null) goto L234;
        r36.put("gecko_config_from", r39.toLowerCase(r110));
        r36.put("res_trace_id", r31.getGroupId());
        r36.put("cold_start_unique_id", (String) com.bytedance.forest.b.f4230b.getValue());
        r36.put("is_async", Boolean.valueOf(r31.isASync()));
        if (r34.f4444u != ResourceFrom.d) goto L147;
        boolean r40 = true;
    L148:
        r36.put("is_memory", Boolean.valueOf(r40));
        if (r40 == false) goto L151;
        String r41 = r34.c(r34.f4445v);
    L152:
        r36.put("res_from", r41);
        String r42 = r34.g();
        if (r42 != null) goto L156;
        r42 = "unknown";
    L156:
        r36.put("res_type", r42);
        List<FetcherType> r43 = r31.getFetcherSequence();
        ArrayList r111 = new ArrayList(CollectionsKt.h(r43));
        Iterator<T> r44 = r43.iterator();
    L158:
        if (r44.hasNext() == false) goto L164;
        String r112 = ((FetcherType) r44.next()).name();
        Locale r113 = Locale.ENGLISH;
        if (r112 == null) goto L163;
        r111.add(r112.toLowerCase(r113));
        goto L158
    L163:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L164:
        r36.put("fetcher_list", r111);
        String r45 = r34.f4443t;
        if (r45 != null) goto L331;
    L170:
        r36.put("is_preload", Boolean.valueOf(r34.f4441q.isPreload()));
        String r114 = "";
        if (r31.getScene() == Scene.f) goto L173;
    L198:
        r36.put("is_preloaded", Boolean.valueOf(r34.f4436l));
        if ((r34 instanceof com.bytedance.forest.postprocessor.g) == true) goto L201;
    L203:
        r36.put("is_post_processed", Boolean.valueOf(r5));
        r36.put("is_request_reused", Boolean.valueOf(r34.f4437m));
        r36.put("enable_request_reuse", Boolean.valueOf(r34.f4441q.getEnableRequestReuse()));
        r36.put("has_been_paused", Boolean.valueOf(r34.f4430b));
        r36.put("is_cdn_cache_negotiation", Boolean.valueOf(r34.f4447x));
        r36.put("is_cdn_redirection", Boolean.valueOf(r34.f4448y));
        com.bytedance.forest.pollyfill.d r46 = r34.e;
        if (r46 == null) goto L206;
        Object r47 = Integer.valueOf(r46.f4526a);
    L207:
        r36.put("http_code", r47);
        r36.put("is_stream_loaded", Boolean.valueOf(r34.f4438n));
        r36.put("use_gkfs", Boolean.valueOf(r34.f4439o));
        com.bytedance.forest.utils.a r48 = r34.f4441q.getCacheKey$forest_release();
        if (r48 == null) goto L212;
        String r49 = r48.toString();
        if (r49 == null) goto L212;
        r114 = r49;
    L212:
        r36.put("cache_identity", r114);
        com.bytedance.forest.b r50 = (com.bytedance.forest.b) this.f155b;
        com.bytedance.forest.model.w r51 = (com.bytedance.forest.model.w) this.f156c;
        r50.getClass();
        LinkedHashMap r52 = new LinkedHashMap();
        r52.put("net_library_error_code", Integer.valueOf(r51.s.f4362c));
        r52.put("http_status_code", Integer.valueOf(r51.s.d));
        r52.put("res_loader_error_code", Integer.valueOf(r51.s.f4360a));
        r52.put("res_error_msg", r51.s.toString());
        r52.put("gecko_error_code", Integer.valueOf(r51.s.f4361b));
        r52.put("gecko_error_msg", r51.s.f4365j);
        r52.put("gecko_library_read_error_code", Integer.valueOf(r51.s.e));
        r52.put("gecko_library_read_error_msg", r51.s.f);
        r52.put("gecko_cdn_library_read_error_code", Integer.valueOf(r51.s.g));
        r52.put("gecko_cdn_library_read_error_msg", r51.s.f4363h);
        r52.put("builtin_error_msg", r51.s.f4366k);
        r52.put("cdn_error_msg", r51.s.f4367l);
        r52.put("memory_error", r51.s.f4364i);
        com.bytedance.forest.b r53 = (com.bytedance.forest.b) this.f155b;
        r53.getClass();
        LinkedHashMap r54 = new LinkedHashMap();
        r54.put("res_loader_info", r32);
        r54.put("res_info", r36);
        r54.put("res_load_perf", r53.f4232a.d);
        r54.put("res_load_error", r52);
        JSONObject r55 = new JSONObject(r36);
        Iterator r56 = r32.entrySet().iterator();
    L214:
        if (r56.hasNext() == false) goto L216;
        Map.Entry r57 = (Map.Entry) r56.next();
        r55.put((String) r57.getKey(), r57.getValue());
        goto L214
    L216:
        Iterator r58 = r52.entrySet().iterator();
    L218:
        if (r58.hasNext() == false) goto L220;
        Map.Entry r59 = (Map.Entry) r58.next();
        r55.put((String) r59.getKey(), r59.getValue());
        goto L218
    L220:
        boolean r60 = CollectionsKt.listOf(new Scene[]{Scene.f4345a, Scene.f4351k}).contains(r31.getScene());
        JSONObject r61 = new JSONObject(r31.getCustomParams());
        if (((com.bytedance.forest.model.w) this.f156c).f4442r == true) goto L227;
        if (r60 == false) goto L225;
        String r62 = "res_loader_error_template";
    L226:
        com.bytedance.forest.b.b((com.bytedance.forest.b) this.f155b, r62, r55, (com.bytedance.forest.model.w) this.f156c, r61, r54, 0);
        goto L227
    L225:
        r62 = "res_loader_error";
    L227:
        if (r60 == false) goto L230;
        String r63 = "res_loader_perf_template";
    L231:
        com.bytedance.forest.b.b((com.bytedance.forest.b) this.f155b, r63, r55, (com.bytedance.forest.model.w) this.f156c, r61, r54, 1);
        return;
    L230:
        r63 = "res_loader_perf";
        goto L231
    L206:
        r47 = "null";
        goto L207
    L201:
        if (((com.bytedance.forest.postprocessor.g) r34).D == false) goto L203;
        r5 = true;
        goto L203
    L173:
        if (r31.getEnableRequestReuse() == false) goto L198;
        if (r34.f4436l == true) goto L198;
        if (r31.isPreload() == true) goto L198;
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L181
        ImagePipeline r65 = Fresco.a().e();     // Catch: Throwable -> L181
        if (r34.f4442r == false) goto L183;
        Uri r66 = new Uri.Builder().scheme("file").authority("").path(r34.f4443t).build();     // Catch: Throwable -> L181
    L184:
        r65.getClass();     // Catch: Throwable -> L181
        if (r66 != null) goto L187;
        boolean r67 = false;
    L191:
        r34.f4436l = r67;     // Catch: Throwable -> L181
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L181
        goto L198
    L187:
        CloseableReference r68 = r65.e.a(r65.f.a(ImageRequestBuilder.a(r66).a(), null));     // Catch: Throwable -> L181
        r67 = CloseableReference.b(r68);     // Catch: Throwable -> L192
        if (r68 == null) goto L191;
        r68.close();     // Catch: Throwable -> L181
        goto L191
    L192:
        th = move-exception;
        if (r68 == null) goto L368;
        r68.close();     // Catch: Throwable -> L181
        throw th;     // Catch: Throwable -> L181
    L368:
        throw th;     // Catch: Throwable -> L181
    L183:
        r66 = Uri.parse(r31.getOriginUrl());     // Catch: Throwable -> L181
    L181:
        th = move-exception;
        Result.Companion r69 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L198
    L331:
        r36.put("res_size", Long.valueOf(new File(r45).length()));     // Catch: Exception -> L168
    L168:
        e = move-exception;
        com.bytedance.forest.utils.d.b(r33.f4232a.g, 6, "ResourceReporter", "get file length error", false, e, null, 40);
        Unit r70 = Unit.INSTANCE;
        goto L170
    L151:
        r41 = r34.c(r34.f4444u);
        goto L152
    L147:
        r40 = false;
        goto L148
    L234:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L236:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L139:
        r37 = MessageIndication.STATUS_FAILED;
        goto L140
    L237:
        n.c(this.f155b, (z8.f) this.f156c);
        return;
    L246:
        com.bytedance.assem.arch.threadpool.b r71 = (com.bytedance.assem.arch.threadpool.b) this.f155b;
        ((Runnable) this.f156c).run();     // Catch: Throwable -> L250
        Lazy r72 = com.bytedance.assem.arch.threadpool.b.f3941c;
        r71.a();
        return;
    L250:
        th = move-exception;
        Lazy r73 = com.bytedance.assem.arch.threadpool.b.f3941c;
        r71.a();
        throw th;
    L253:
        i6.a.i().b(new j6.c((String) this.f155b, (JSONObject) this.f156c));
        return;
    L255:
        a5.c r74 = com.bytedance.android.monitorV2.m.f3713a;
        com.bytedance.android.monitorV2.m.f3713a = (a5.c) this.f155b;
        if (((h) this.f156c).f3581a == null) goto L370;
        SharedPreferences r75 = ((h) this.f156c).f3581a.getSharedPreferences("monitor_sdk", 4);
        if (r75 == null) goto L371;
        h r76 = (h) this.f156c;
        r76.e = new com.bytedance.android.monitorV2.e(r76);
        r75.registerOnSharedPreferenceChangeListener(((h) this.f156c).e);
        com.bytedance.apm.util.a.d = r75.getBoolean("monitor_hdt_ignore_sample", false);
        return;
    L371:
        return;
    L370:
        return;
    L261:
        com.bytedance.android.anniex.container.m r77 = (com.bytedance.android.anniex.container.m) this.f156c;
        WebView r78 = (WebView) this.f155b;
        if (r78 != null) goto L264;
    L272:
        defpackage.b r79 = r77.e;
        if (r79 != null) goto L275;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r79 = null;
    L275:
        r79.getClass();
        if (Intrinsics.areEqual(null, OpenPageMethod.APP_POPUP) == true) goto L278;
        return;
    L278:
        throw null;
    L264:
        if (r78.canGoBack() != true) goto L272;
        defpackage.b r80 = r77.e;
        if (r80 != null) goto L268;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r80 = null;
    L268:
        r80.getClass();
        if (Intrinsics.areEqual(null, OpenPageMethod.APP_POPUP) == false) goto L372;
        throw null;
    L372:
        return;
    L279:
        LinkedList r81 = (LinkedList) this.f155b;
        c7.h r82 = (c7.h) this.f156c;
    L287:
        e = move-exception;
        if (com.bytedance.apm.j.f3887a == false) goto L374;
        e.printStackTrace();
        return;
    L374:
        return;
    L281:
        if (wn.f.j(r81) == true) goto L373;
        float r83 = com.bytedance.apm.util.e.f3910a;     // Catch: Exception -> L287
        int r84 = com.bytedance.apm.util.e.f3911b;     // Catch: Exception -> L287
        int r85 = r84 - 1;     // Catch: Exception -> L287
        int[] r86 = new int[r84];     // Catch: Exception -> L287
        Iterator r87 = r81.iterator();     // Catch: Exception -> L287
        int r115 = 0;
    L285:
        if (r87.hasNext() == false) goto L289;
        Integer r116 = (Integer) r87.next();     // Catch: Exception -> L287
        int r117 = (int) (100.0f * r83);     // Catch: Exception -> L287
        int r118 = Math.max(Math.min((((r117 - 1) + r116.intValue()) / r117) - 1, r85), 0);     // Catch: Exception -> L287
        r86[r118] = r86[r118] + 1;     // Catch: Exception -> L287
        r115 = r115 + (r116.intValue() / 100);     // Catch: Exception -> L287
        goto L285
    L289:
        JSONObject r119 = new JSONObject();     // Catch: Exception -> L287
        int r88 = 0;
    L290:
        if (r88 > r85) goto L295;
        if (r86[r88] <= 0) goto L294;
        r119.put(String.valueOf(r88), r86[r88]);     // Catch: Exception -> L287
    L294:
        r88 = r88 + 1;     // Catch: Exception -> L287
        goto L290
    L295:
        com.lynx.tasm.behavior.d r89 = r82.d;     // Catch: Exception -> L287
        if (r89 == null) goto L309;
        LinkedList r90 = new LinkedList();     // Catch: Exception -> L287
        Iterator<String> r91 = r119.keys();     // Catch: Exception -> L287
        if (r91 != null) goto L301;
    L308:
        r89.b();     // Catch: Exception -> L287
    L301:
        if (r91.hasNext() == false) goto L318;
        r90.add(r91.next());     // Catch: Exception -> L287
        goto L301
    L318:
        new JSONObject(r119, (String[]) r90.toArray(new String[0]));     // Catch: Exception -> L306
    L306:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L287
    L309:
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L287
        r120.put("scene", r82.f1138a);     // Catch: Exception -> L287
        JSONObject r92 = new JSONObject();     // Catch: Exception -> L287
        r92.put("total_scroll_time", r115);     // Catch: Exception -> L287
        r92.put("velocity", "0.0,0.0");     // Catch: Exception -> L287
        r92.put("distance", "0.0,0.0");     // Catch: Exception -> L287
        r92.put("drop_time_rate", (double) (1.0f - ((((float) r81.size()) * 1.0f) / ((float) ((int) (((float) r115) / r83))))));     // Catch: Exception -> L287
        j6.e r93 = new j6.e("fps_drop", r82.f1138a, r119, r120, r92);     // Catch: Exception -> L287
        JSONObject r94 = q7.a.k().m(true);     // Catch: Exception -> L287
        r93.d = r94;     // Catch: Exception -> L287
        r94.put("refresh_rate", r84);     // Catch: Exception -> L287
        i6.a.i().b(r93);     // Catch: Exception -> L287
        return;
    L373:
        return;
    L315:
        AtomicInteger r95 = hf.f.f17317a;
        hf.f.a((List) this.f155b, (com.bytedance.geckox.n) this.f156c);
        return;
    L320:
        LinkedList r96 = ((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4703a;     // Catch: Throwable -> L317
        monitor-enter(r96);     // Catch: Throwable -> L317
        LinkedList r97 = new LinkedList(((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4703a);     // Catch: Throwable -> L132
        ((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4703a.clear();     // Catch: Throwable -> L132
        monitor-exit(r96);     // Catch: Throwable -> L132
        Iterator r98 = r97.iterator();     // Catch: Throwable -> L317
    L98:
        if (r98.hasNext() == false) goto L105;
        com.bytedance.framwork.core.sdkmonitor.g r99 = (com.bytedance.framwork.core.sdkmonitor.g) r98.next();     // Catch: Throwable -> L317
        com.bytedance.framwork.core.sdkmonitor.b r100 = (com.bytedance.framwork.core.sdkmonitor.b) this.f156c;     // Catch: Throwable -> L317
        com.bytedance.framwork.core.sdkmonitor.e r101 = (com.bytedance.framwork.core.sdkmonitor.e) this.f155b;     // Catch: Throwable -> L317
        r100.getClass();     // Catch: Throwable -> L317
        if (r99 == null) goto L98;
        if (TextUtils.isEmpty(r99.f4731a) == true) goto L98;
        r101.q(r99.f4731a, r99.f4732b, r99.f4733c, r99.d, r99.e);     // Catch: Throwable -> L317
        goto L98
    L105:
        LinkedList r102 = ((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4704b;     // Catch: Throwable -> L317
        monitor-enter(r102);     // Catch: Throwable -> L317
        LinkedList r103 = new LinkedList(((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4704b);     // Catch: Throwable -> L129
        ((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4704b.clear();     // Catch: Throwable -> L129
        monitor-exit(r102);     // Catch: Throwable -> L129
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L317
    L111:
        if (r104.hasNext() == false) goto L117;
        if (r104.next() != null) goto L116;
        ((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).getClass();     // Catch: Throwable -> L317
        goto L111
    L116:
        throw new ClassCastException();     // Catch: Throwable -> L317
    L117:
        LinkedList r105 = ((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4705c;     // Catch: Throwable -> L317
        monitor-enter(r105);     // Catch: Throwable -> L317
        LinkedList r106 = new LinkedList(((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4705c);     // Catch: Throwable -> L126
        ((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).f4705c.clear();     // Catch: Throwable -> L126
        monitor-exit(r105);     // Catch: Throwable -> L126
        Iterator r107 = r106.iterator();     // Catch: Throwable -> L317
    L123:
        if (r107.hasNext() == false) goto L367;
        com.bytedance.framwork.core.sdkmonitor.a r108 = (com.bytedance.framwork.core.sdkmonitor.a) r107.next();     // Catch: Throwable -> L317
        ((com.bytedance.framwork.core.sdkmonitor.b) this.f156c).getClass();     // Catch: Throwable -> L317
        goto L123
    L367:
        return;
    L126:
        th = move-exception;
        throw th;     // Catch: Throwable -> L317
    L129:
        th = move-exception;
        throw th;     // Catch: Throwable -> L317
    L132:
        th = move-exception;
        throw th;     // Catch: Throwable -> L317
    L135:
        return;
    L29:
        if (((com.lynx.animax.player.i) this.f156c).f9681m == null) goto L359;
        ((Runnable) this.f155b).run();
        return;
    L359:
        return;
    L84:
        if (((u) this.f156c).d == true) goto L366;
        ((u) this.f156c).f6316j.evaluateJavascript((String) this.f155b, null);
        return;
    L366:
        return;
    L240:
        if (ym.m.q(com.bytedance.crash.n.f4057a) == false) goto L369;
        ec.b r109 = zm.p.f23512j;
        if (r109 == null) goto L244;
        r109.stopWatching();
    L244:
        String r121 = (String) this.f155b;
        ec.b r122 = new ec.b(r121, (com.bytedance.crash.f) this.f156c, r121);
        zm.p.f23512j = r122;
        r122.startWatching();
        return;
    }

    public /* synthetic */ b(int r5, Object r10, boolean r11, Object r12) {
        this.f154a = r5;
        this.f156c = r10;
        this.f155b = r12;
    }
}
