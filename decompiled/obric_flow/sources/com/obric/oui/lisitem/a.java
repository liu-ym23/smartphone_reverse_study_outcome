package com.obric.oui.lisitem;

import android.net.Uri;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.RemoteViews;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.metrics.MetricsType;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.utils.m;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.common.reflect.w;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.p;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.slider.TickMarkSeekBar;
import com.obric.oui.swipeaction.OSwipeActionLayout;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.oui.window.permission.WebViewActivity;
import com.obric.widget.host.internal.DefaultHostedWidget;
import fi.j;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import obric.flow.overlay.AssistantOverlayService;
import s9.h;
import u9.f;
import u9.g;
import u9.l;
import vn.e;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13599b;

    public /* synthetic */ a(e8.a r5, ThreadPoolExecutor r10) {
        this.f13598a = 26;
        this.f13599b = r10;
    }

    private final void a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    private final void b() {
        u9.c r5 = (u9.c) this.f13599b;
        r5.getClass();
        long r10 = SystemClock.uptimeMillis();
        int r11 = -1;
        f r12 = null;
        boolean r13 = false;
        ?? r14 = r5.f22279l;     // Catch: IOException -> L132
        monitor-enter(r14);     // Catch: IOException -> L132
    L123:
        th = th;
        Object r15 = null;
        ?? r16 = r14;
    L122:
        ?? r17 = r16;
    L205:
        monitor-exit(r17);     // Catch: Throwable -> L130
        throw th;     // Catch: IOException -> L86
    L130:
        th = th;
        goto L205
    L6:
        if (r5.f22280m.get() < r5.f22278k.size()) goto L8;
    L125:
        r5.f22287u.removeCallbacksAndMessages(null);     // Catch: Throwable -> L123
        r14 = r14;
        monitor-exit(r14);     // Catch: Throwable -> L123
    L218:
        return;
    L8:
        if (r5.f22283p != null) goto L125;
        if (r5.f22286t.getCount() == 0) goto L125;
        if (r5.d == true) goto L125;
        String r18 = (String) r5.f22278k.get(r5.f22280m.get());     // Catch: Throwable -> L123
        Logger.d("c", "ConstructURLConnection and execute index: " + r5.f22280m.get() + " url: " + r18);     // Catch: Throwable -> L120
        HttpURLConnection r19 = l.c(r18, r5.e, r5.f22275h, r5.f22273b);     // Catch: Throwable -> L120
    L118:
        th = th;
    L21:
        r17 = r14;
        goto L205
    L17:
        if (r5.f22289w == true) goto L184;
    L22:
        r19.setRequestProperty("transaction-id", r5.f22276i);     // Catch: Throwable -> L118
        r5.f22280m.incrementAndGet();     // Catch: Throwable -> L118
        r5.f22281n.add(r19);     // Catch: Throwable -> L116
        String r20 = r19.getURL().getHost();     // Catch: Throwable -> L118
        u9.b r110 = new u9.b();     // Catch: Throwable -> L116
        r110.f22268a = -1;     // Catch: Throwable -> L116
        r110.f22269b = r20;     // Catch: Throwable -> L116
        r110.f22270c = System.currentTimeMillis();     // Catch: Throwable -> L116
        r110.e = 0;     // Catch: Throwable -> L116
        r110.f = -1;     // Catch: Throwable -> L116
        r110.f22268a = r19.hashCode();     // Catch: Throwable -> L111
        r5.f22285r.add(r110);     // Catch: Throwable -> L113
        monitor-exit(r14);     // Catch: Throwable -> L111
        Request r21 = r5.e;     // Catch: IOException -> L109
        if (r21 == null) goto L36;
        j r22 = r21.getBody();     // Catch: IOException -> L86
        if (r22 == null) goto L34;
        r22.writeTo(r19.getOutputStream());     // Catch: IOException -> L86
    L34:
        sj.d r23 = h.f21879a;     // Catch: IOException -> L86
        int r24 = r19.getResponseCode();     // Catch: IOException -> L86
    L37:
        r110.f = r24;     // Catch: IOException -> L109
        r110.d = System.currentTimeMillis();     // Catch: IOException -> L109
        String r25 = r19.getHeaderField("tt-api-source-5xx");     // Catch: IOException -> L109
        String r111 = r5.f22277j;     // Catch: IOException -> L109
        if (r24 < 200) goto L42;
        if (r24 >= 300) goto L42;
    L74:
        Object r26 = r5.f22279l;     // Catch: IOException -> L86
        monitor-enter(r26);     // Catch: IOException -> L86
    L79:
        th = move-exception;
        throw th;     // Catch: IOException -> L86
    L77:
        if (r5.f22283p != null) goto L81;
        r5.f22283p = r19;     // Catch: Throwable -> L79
        r5.f = r18;     // Catch: Throwable -> L79
        Logger.d("c", "Find winner connection countdown.");     // Catch: Throwable -> L79
        r5.f22286t.countDown();     // Catch: Throwable -> L79
        ?? r27 = "Find winner connection countdown.";
    L82:
        monitor-exit(r26);     // Catch: Throwable -> L79
        r14 = r27;
        goto L218
    L81:
        r19.disconnect();     // Catch: Throwable -> L79
        r5.f22281n.remove(r19);     // Catch: Throwable -> L79
        r27 = r24;
    L42:
        if (r25 != null) goto L216;
    L48:
        if (r24 >= 300) goto L50;
    L54:
        g r28 = g.a();     // Catch: IOException -> L46
        r28.getClass();     // Catch: IOException -> L46
        if (r24 != 0) goto L57;
    L72:
        boolean r29 = false;
    L73:
        if (r29 == true) goto L74;
        String r112 = r19.getResponseMessage();     // Catch: IOException -> L109
        int r113 = r5.e.getMaxLength();     // Catch: Throwable -> L92
        InputStream r30 = r19.getInputStream();     // Catch: Throwable -> L92 Exception -> L94
    L91:
        InputStream r114 = r30;
        String r115 = l.i(r19, "Content-Type");     // Catch: Throwable -> L92
        r19.getHeaderFields();     // Catch: Throwable -> L92
        u9.b r116 = r110;
        HttpURLConnection r117 = r19;
        l.p(false, r113, r114, r115, r18, r5.f22272a);     // Catch: Throwable -> L99
    L108:
        throw new HttpResponseException(r24, r112);     // Catch: IOException -> L104
    L104:
        e = e;
    L105:
        r110 = r116;
        r19 = r117;
    L134:
        Object r31 = r5.f22279l;
        monitor-enter(r31);
        Class r32 = u9.c.B;     // Catch: Throwable -> L183
        if (r32 == null) goto L207;
        if (r32.isInstance(e) == false) goto L207;
        r11 = ((Integer) Reflect.on(e).call("getCronetInternalErrorCode").get()).intValue();     // Catch: Throwable -> L183
        Logger.d("c", "cronet error code: " + r11);     // Catch: Throwable -> L183
    L207:
    L144:
        th = move-exception;
        throw th;
    L142:
        if (r5.f22284q != null) goto L146;
        r5.f22284q = r19;     // Catch: Throwable -> L144
    L146:
        if (r19 == null) goto L151;
        r19.disconnect();     // Catch: Throwable -> L144
        if (r110 == null) goto L150;
        r110.g = r5.d(e, r18, r19, false);     // Catch: Throwable -> L144
        r110.e = r11;     // Catch: Throwable -> L144
        r110.d = System.currentTimeMillis();     // Catch: Throwable -> L144
    L150:
        r5.f22281n.remove(r19);     // Catch: Throwable -> L144
    L151:
        int r33 = r5.s + 1;     // Catch: Throwable -> L144
        r5.s = r33;     // Catch: Throwable -> L144
        if (r33 < r5.f22278k.size()) goto L156;
        Logger.d("c", "Try all urls failed countdown.");     // Catch: Throwable -> L144
        r5.f22286t.countDown();     // Catch: Throwable -> L144
        monitor-exit(r31);     // Catch: Throwable -> L144
        return;
    L156:
        g r34 = g.a();     // Catch: Throwable -> L144
        String r35 = r5.f22277j;     // Catch: Throwable -> L144
        r34.getClass();     // Catch: Throwable -> L144
        if (r11 != 0) goto L159;
    L172:
        if (r13 == false) goto L177;
        Logger.d("c", "inBlockErrorCode countdown.");     // Catch: Throwable -> L144
        r5.f22286t.countDown();     // Catch: Throwable -> L144
        monitor-exit(r31);     // Catch: Throwable -> L144
        return;
    L177:
        if ((SystemClock.uptimeMillis() - r10) >= r5.f22288v) goto L179;
        Message r36 = Message.obtain();     // Catch: Throwable -> L144
        r36.what = 1;     // Catch: Throwable -> L144
        r36.obj = r5;     // Catch: Throwable -> L144
        r5.f22287u.sendMessage(r36);     // Catch: Throwable -> L144
    L179:
        monitor-exit(r31);     // Catch: Throwable -> L144
        return;
    L159:
        if (TextUtils.isEmpty(r35) == true) goto L172;
        Iterator r37 = r34.f22314b.iterator();     // Catch: Throwable -> L144
    L163:
        if (r37.hasNext() == false) goto L167;
        f r118 = (f) r37.next();     // Catch: Throwable -> L144
        if (r118.f22305i.equals(r35) == false) goto L163;
        r12 = r118;
    L167:
        if (r12 == null) goto L172;
        HashSet r38 = r12.f;     // Catch: Throwable -> L144
        if (r38 == null) goto L172;
        r13 = r38.contains(Integer.valueOf(r11));     // Catch: Throwable -> L144
    L99:
        th = th;
    L186:
        th.printStackTrace();     // Catch: IOException -> L104
        StringBuilder r119 = new StringBuilder("reason = ");     // Catch: IOException -> L104
        if (r112 != null) goto L106;
        r112 = "";
    L106:
        r119.append(r112);     // Catch: IOException -> L104
        r119.append("  exception = ");     // Catch: IOException -> L104
        r119.append(th.getMessage());     // Catch: IOException -> L104
        r112 = r119.toString();     // Catch: IOException -> L104
        goto L108
    L94:
        r30 = r19.getErrorStream();     // Catch: Throwable -> L92
    L92:
        th = th;
        r116 = r110;
        r117 = r19;
        goto L186
    L57:
        if (TextUtils.isEmpty(r111) == true) goto L72;
        Iterator r39 = r28.f22314b.iterator();     // Catch: IOException -> L46
    L61:
        if (r39.hasNext() == false) goto L65;
        f r120 = (f) r39.next();     // Catch: IOException -> L46
        if (r120.f22305i.equals(r111) == false) goto L61;
    L66:
        if (r120 == null) goto L72;
        HashSet r40 = r120.f;     // Catch: IOException -> L46
        if (r40 == null) goto L72;
        r29 = r40.contains(Integer.valueOf(r24));     // Catch: IOException -> L46
    L46:
        e = e;
        r116 = r110;
        r117 = r19;
        goto L105
    L65:
        r120 = null;
        goto L66
    L50:
        if (r24 >= 600) goto L54;
        if (u9.c.A == true) goto L54;
    L216:
        if (r25.equals(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L48;
    L36:
        r24 = -1;
    L109:
        e = e;
    L113:
        th = th;
    L115:
        r17 = r14;
    L111:
        th = th;
        r17 = r14;
    L116:
        th = th;
        goto L115
    L184:
        r19.setRequestProperty("x-tt-bp-rs", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L20
    L20:
        th = th;
    L120:
        th = th;
        r15 = null;
        r16 = r14;
    L86:
        e = e;
    L132:
        e = e;
        r18 = null;
        r110 = null;
        r19 = null;
        goto L134
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r5 = "";
        ViewGroup.MarginLayoutParams r10 = null;
        o1.c r11 = null;
        r11 = null;
        final int r12 = 1;
        switch(this.f13598a) {
            case 0: goto L303;
            case 1: goto L301;
            case 2: goto L299;
            case 3: goto L297;
            case 4: goto L295;
            case 5: goto L291;
            case 6: goto L289;
            case 7: goto L282;
            case 8: goto L280;
            case 9: goto L276;
            case 10: goto L274;
            case 11: goto L272;
            case 12: goto L267;
            case 13: goto L265;
            case 14: goto L263;
            case 15: goto L190;
            case 16: goto L188;
            case 17: goto L88;
            case 18: goto L84;
            case 19: goto L82;
            case 20: goto L80;
            case 21: goto L67;
            case 22: goto L65;
            case 23: goto L56;
            case 24: goto L29;
            case 25: goto L16;
            case 26: goto L366;
            case 27: goto L14;
            case 28: goto L12;
            default: goto L4;
        };
    L4:
        e r13 = (e) this.f13599b;
        int r14 = r13.f22607b;
        if (r14 == 3) goto L363;
        if (r14 == 2) goto L364;
        r13.f22607b = 2;
        on.h r15 = r13.f22635o;
        if (((Boolean) r13.d.get("onStart")).booleanValue() == false) goto L365;
        r13.f("onStart", r13.c(r15));
        return;
    L365:
        return;
    L364:
        return;
    L363:
        return;
    L12:
        v0.c.a((v0.c) this.f13599b);
        return;
    L14:
        b();
        return;
    L16:
        sn.a r16 = (sn.a) this.f13599b;
        vn.d r17 = r16.f21959h;
        if (r17 == null) goto L367;
        LinkedList r18 = r16.f21957b;
        OverScroller r19 = r17.f22618a;
        if (r19.computeScrollOffset() == false) goto L368;
        int r20 = r19.getCurrX();
        int r21 = r19.getCurrY();
        int r22 = r20 - r17.f22620c;
        int r110 = r21 - r17.d;
        r17.f22620c = r20;
        r17.d = r21;
        r17.f22625l = r17.b(r18, r17.f22625l);
        r17.c(null, r18, 0.0f, 0.0f, null);
        rn.a r23 = r17.f22625l;
        if (r23 == null) goto L25;
        r17.e = r23.getGestureArenaMemberId();
        r17.d(r17.f22625l, r22, r110, null, null, null);
        if (r19.isFinished() == false) goto L369;
        r17.d(r17.f22625l, Float.MIN_VALUE, Float.MIN_VALUE, null, r18, null);
        return;
    L369:
        return;
    L25:
        r17.e = 0;
        if (r19.isFinished() == true) goto L371;
        r19.abortAnimation();
        return;
    L371:
        return;
    L368:
        return;
    L367:
        return;
    L29:
        fn.c r24 = (fn.c) this.f13599b;
        AtomicBoolean r25 = (AtomicBoolean) r24.d;
        if (r25.compareAndSet(false, true) == false) goto L372;
        Keva r26 = (Keva) r24.f16949c;
        Set<Map.Entry<String, ?>> r27 = r26.getAll().entrySet();
        int r28 = (int) (((double) r24.f16947a) * 0.25d);
        PriorityQueue r29 = new PriorityQueue(r28, new androidx.room.vo.a(7));
        kn.c r30 = new kn.c();
        r30.f18689b = null;
        Iterator<Map.Entry<String, ?>> r31 = r27.iterator();
    L34:
        if (r31.hasNext() == false) goto L50;
        r30.f18689b = r31.next();
        if (r29.size() < r28) goto L37;
        Map.Entry r32 = (Map.Entry) r29.peek();
        if (r32 == null) goto L34;
        long r33 = ((Long) r32.getValue()).longValue();
        Map.Entry r34 = r30.f18689b;
        if (r34 != null) goto L43;
    L46:
        Long r35 = -1L;
    L48:
        if (r33 <= r35.longValue()) goto L34;
        r29.poll();
        r29.offer(r30);
        goto L34
    L43:
        if ((r34.getValue() instanceof Long) == false) goto L46;
        r35 = (Long) r30.f18689b.getValue();
        goto L48
    L37:
        r29.offer(r30);
        goto L34
    L50:
        Iterator r36 = r29.iterator();
    L52:
        if (r36.hasNext() == false) goto L54;
        Map.Entry r37 = (Map.Entry) r36.next();
        ((Keva) r24.f16948b).erase((String) r37.getKey());
        r26.erase((String) r37.getKey());
        goto L52
    L54:
        r25.set(false);
        return;
    L372:
        return;
    L56:
        int r38 = AssistantOverlayService.f20527h;
        AssistantOverlayService r39 = (AssistantOverlayService) this.f13599b;
        Intrinsics.checkNotNullParameter(r39, "this$0");
        CardFeedLayout r40 = r39.f20529b;
        if (r40 == null) goto L61;
        WindowInsetsController r41 = r40.getWindowInsetsController();
        if (r41 == null) goto L61;
        r41.show(WindowInsets.Type.navigationBars());
    L61:
        CardFeedLayout r42 = r39.f20529b;
        if (r42 == null) goto L373;
        r42.n("AssistantOverlayService", r42.getLeft(), r42.getTop(), r42.getRight(), r42.getBottom());
        return;
    L373:
        return;
    L65:
        obric.flow.miniappwidget.a r43 = (obric.flow.miniappwidget.a) this.f13599b;
        Intrinsics.checkNotNullParameter(r43, "$it");
        r43.c();
        return;
    L67:
        ConcurrentHashMap r44 = o1.e.f20389a;
        Class r45 = (Class) this.f13599b;
        if (r44.contains(r45) == true) goto L375;
        Class r46 = o1.e.a(r45, AIBridgeParamModel.class);
        if (r46 == null) goto L77;
        Class r47 = o1.e.a(r45, AIBridgeResultModel.class);
        if (r47 == null) goto L77;
        r11 = new o1.c(r46, r47, o1.e.b(r46), o1.e.b(r47), new LinkedHashMap());
    L77:
        if (r11 == null) goto L374;
        r44.put(r45, r11);
        o1.e.f20390b.put(r11.f20386b, r45);
        return;
    L374:
        return;
    L375:
        return;
    L80:
        MatrixTeaManager.b((MatrixTeaManager) this.f13599b);
        return;
    L82:
        ((nh.f) this.f13599b).release();
        return;
    L84:
        WebView r48 = (WebView) ((mh.f) this.f13599b).f20102c.get();
        if (r48 == null) goto L376;
        r48.removeJavascriptInterface("pia_props");
        return;
    L376:
        return;
    L88:
        final HtmlPlugin r49 = (HtmlPlugin) this.f13599b;
        r49.getClass();
        Intrinsics.checkNotNullParameter("[HTML] start load main document.", "message");
        com.bytedance.pia.core.utils.j.y("[HTML] start load main document.", null);
        r49.f20236b.f20246q.a("request_html.start", System.currentTimeMillis());
        w r50 = r49.f20236b.f20247r;
        EventName r111 = EventName.g;
        r50.getClass();
        com.bytedance.pia.core.tracing.d r112 = new com.bytedance.pia.core.tracing.d(r50, r111, System.currentTimeMillis());
        r112.d.put("url", r49.f20236b.g.toString());
        r112.a();
        nh.d r51 = r49.f20236b;
        com.bytedance.pia.core.tracing.b r52 = r51.s;
        boolean r53 = r51.k();
        Uri r113 = r49.f20236b.g;
        if (r113 != null) goto L91;
        String r114 = null;
    L92:
        r52.f7110i = r114;
        r52.f7107b = r53;
        nh.d r54 = r49.f20236b;
        com.bytedance.pia.core.tracing.b r55 = r54.s;
        com.bytedance.pia.core.setting.a r56 = r54.d;
        Lazy r115 = Settings.B;
        boolean r116 = p.a().m();
        r55.getClass();
        if (r56 == null) goto L106;
        if (((Set) r56.e.getValue()).contains("prefetch") == true) goto L98;
        r55.f7111j = 1;
    L98:
        if (((Set) r56.e.getValue()).contains("nsr") == false) goto L100;
        if (r116 == false) goto L100;
    L102:
        if (((Set) r56.e.getValue()).contains("snapshot") == false) goto L104;
        if (r116 == true) goto L106;
    L104:
        r55.f7112k = 1;
    L100:
        r55.f7113l = 1;
    L106:
        if (r49.f20236b.k() == true) goto L108;
    L186:
        Intrinsics.checkNotNullParameter("[HTML] try load main document from resource loader.", "message");
        com.bytedance.pia.core.utils.j.y("[HTML] try load main document from resource loader.", null);
        HashMap r57 = new HashMap();
        nh.d r58 = r49.f20236b;
        r57.put("User-Agent", r58.f20242m);
        final int r59 = 0;
        r58.f20240k.a(new ai.p(r49, r57), new mh.d(r49, r59), new mh.d(r49, r12));
        return;
    L108:
        if (p.a().m() == false) goto L186;
        Intrinsics.checkNotNullParameter("[HTML] try load main document from cache.", "message");
        com.bytedance.pia.core.utils.j.y("[HTML] try load main document from cache.", null);
        jh.c.d();
    L122:
        th = move-exception;
        String r60 = "[HTML] Query Cache Exception. (URL: " + r49.f20236b.g + ", Error: " + th + ')';
        Intrinsics.checkNotNullParameter(r60, "message");
        com.bytedance.pia.core.utils.j.C(r60, null);
    L127:
        i4.a r61 = r49.e;
        if (r61 != null) goto L136;
        com.bytedance.pia.core.tracing.b r62 = r49.f20236b.s;
        r62.d = 3;
        if (r62.f7113l != (-1)) goto L133;
        r62.f7113l = 3;
    L133:
        if (r62.f7112k != (-1)) goto L155;
        r62.f7112k = 3;
    L155:
        boolean r63 = false;
    L156:
        if (r63 == false) goto L158;
        w r64 = r49.f20236b.f20247r;
        EventName r65 = EventName.f7094h;
        r64.getClass();
        com.bytedance.pia.core.tracing.d r66 = new com.bytedance.pia.core.tracing.d(r64, r65, System.currentTimeMillis());
        r66.d.put("mode", "piaCache");
        r66.a();
        String r67 = (String) r49.e.f17503c;
        r49.d = new lh.d("text/html", "UTF-8", 200, "OK", null, LoadFrom.f6955a, new ByteArrayInputStream(r67.getBytes()));
        JsonObject r68 = com.bytedance.pia.core.utils.j.t(r67);
        Intrinsics.checkNotNullParameter("[HTML] load main document from cache success.", "message");
        com.bytedance.pia.core.utils.j.y("[HTML] load main document from cache success.", null);
        r49.f20236b.g("event-on-manifest-in-html-ready", new Object[]{r68});
        nh.d r69 = r49.f20236b;
        r69.s.d(r67, null, null, r69.d);
        r49.h(r67, null);
        goto L186
    L158:
        i4.a r70 = r49.e;
        if (r70 == null) goto L186;
        nh.d r71 = r49.f20236b;
        com.bytedance.pia.core.tracing.b r72 = r71.s;
        r72.d = 5;
        if (r72.f7113l != (-1)) goto L164;
        r72.f7113l = 5;
    L164:
        if (r72.f7112k != (-1)) goto L166;
        r72.f7112k = 5;
    L166:
        Uri r73 = r71.g;
        String r74 = (String) r70.f17502b;
        Lazy r75 = Settings.B;
        if (p.a().m() == false) goto L186;
        if (jh.c.e.get() == false) goto L186;
        if (r73 == null) goto L186;
        if (p.a().m() == false) goto L183;
        String r76 = com.bytedance.pia.core.utils.j.k(r73, null);
        if (r76 == null) goto L183;
        if (r76.length() == 0) goto L183;
        Keva r77 = jh.c.a(r76);
    L184:
        if (r77 == null) goto L186;
        jh.c.j(r77, r74);
    L183:
        r77 = null;
        goto L184
    L136:
        if (((jh.a) r61.d).d() == null) goto L155;
        if (((jh.a) r61.d).d().booleanValue() == true) goto L155;
        JsonObject r78 = ((jh.a) r61.d).f();     // Catch: Throwable -> L342
        if (r78 != null) goto L350;
        r63 = ((Set) r49.f20236b.d.e.getValue()).contains("cache");     // Catch: Throwable -> L342
        goto L156
    L350:
        r5 = r78.get("type").getAsString();     // Catch: Throwable -> L343
    L146:
        if ("nsr".equals(r5) == false) goto L151;
        if (((Set) r49.f20236b.d.e.getValue()).contains("nsr") == false) goto L151;
    L154:
        r63 = true;
    L151:
        if ("snapshot".equals(r5) == false) goto L155;
        if (((Set) r49.f20236b.d.e.getValue()).contains("snapshot") == false) goto L155;
    L111:
        if (((Set) r49.f20236b.d.e.getValue()).contains("cache") == false) goto L113;
    L124:
        r49.e = jh.c.b(r49.f20236b.g);     // Catch: Throwable -> L122
    L347:
        goto L127
    L113:
        if (((Set) r49.f20236b.d.e.getValue()).contains("snapshot") == true) goto L124;
        if (((Set) r49.f20236b.d.e.getValue()).contains("nsr") == true) goto L124;
        Uri r79 = r49.f20236b.g;     // Catch: Throwable -> L122
        if (p.a().m() == false) goto L347;
        if (jh.c.e.get() == false) goto L347;
        m.b(new com.lynx.tasm.ui.image.h(r79, 29));     // Catch: Throwable -> L122
        goto L347
    L91:
        r52.getClass();
        r114 = r113.getHost() + r113.getPath();
        goto L92
    L188:
        ((m1.a) this.f13599b).invoke();
        return;
    L190:
        m.m r80 = (m.m) this.f13599b;
        ArrayList r81 = r80.f19890c;
        if (r81.isEmpty() == false) goto L193;
        r80.h();
        return;
    L193:
        m.l r82 = (m.l) r81.get(0);
        int r83 = r82.f19882a;
        String r117 = r82.f19883b;
        if (r83 != 1) goto L197;
        String r84 = "BertCloudModel";
    L196:
        String r118 = r84;
        String r85 = m.m.g;
        boolean r86 = m.m.f19886i;
        if (r86 == false) goto L243;
        Log.d(r85, "doExecute. mCmd=" + r82.f19882a + " txt=" + r117);
    L344:
        String r87 = r80.f19889b.performStringInference(r118, r117, r80.f, "", true);     // Catch: Exception -> L248
        if (r86 == false) goto L250;
        Log.d(r85, "doExecute result=" + r87);     // Catch: Exception -> L248
    L251:
        r81.remove(0);     // Catch: Exception -> L248
        int r88 = r82.f19882a;     // Catch: Exception -> L248
        if (r88 != 1) goto L254;
        r80.g(r82, r87);     // Catch: Exception -> L248
    L259:
        r80.f19888a.post(r80.d);     // Catch: Exception -> L248
        return;
    L254:
        if (r88 != 2) goto L256;
        r80.i(r82, r87);     // Catch: Exception -> L248
        goto L259
    L256:
        if (r88 != 3) goto L258;
        Log.d(r85, "handleType3.");     // Catch: Exception -> L248
        m.m.c(r82, false, null);     // Catch: Exception -> L248
        goto L259
    L258:
        m.m.f(r82, r87);     // Catch: Exception -> L248
        goto L259
    L250:
        Log.d(r85, "doExecute.");     // Catch: Exception -> L248
    L248:
        e = move-exception;
        kotlin.collections.a.m(e, "doExecute e=", r85);
        m.m.c(r82, false, null);
        r81.remove(0);
        r80.h();
        return;
    L243:
        Log.d(r85, "doExecute.");
        goto L344
    L197:
        if (r83 != 2) goto L199;
        r84 = "BertClassifyCloudModel";
        goto L196
    L199:
        if (r83 != 3) goto L202;
        r84 = "BgeCloudModel";
        goto L196
    L202:
        if (r83 == 40) goto L210;
        if (r83 == 41) goto L210;
        if (r83 == 42) goto L210;
        if (r83 != 7) goto L209;
        String r89 = "# 注意\n无详细地址则输出文本中地标名称，不要输出文本中未提到的地址信息</s>\n<s><|Assistant|>\n";
    L211:
        StringBuilder r90 = new StringBuilder();
        int r119 = r82.f19882a;
        if (r119 != 5) goto L214;
    L238:
        r5 = "<s><|User|>\n# 备选意图列表：\n\n# 请根据用户问题，匹配上面的备选意图，严格按照备选意图格式输出提取到的槽值，只输出JSON，不要输出其他格式。如果没有匹配项，则输出{\"意图\":\"NA\"}。\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟\n当前用户问题：\n";
    L239:
        r117 = androidx.constraintlayout.motion.widget.a.u(r90, r5, r117, "\n", r89);
        r84 = "QualLLM16B";
        goto L196
    L214:
        if (r119 == 6) goto L238;
        if (r119 != 7) goto L217;
        r5 = "<s><|User|>\n请对下列文本做地址提取，直接输出地址\n# 文本：\n";
        goto L239
    L217:
        if (r119 != 50) goto L219;
        r5 = "<s><|User|>\n# 你是一个短信内容提取专家，请按照输出格式和输出模板要求归纳总结提取短信内容中的相关字段信息。\n## 输出格式：\n- 按照模板格式输出JSON数组，不要输出其他。\n- 未提及的字段，则输出空字符串\n- 如果一个键的值有多项，则用英文逗号`,`隔开\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟，短信内容未提及的字段不要填写\n- “原”和“现”分别对应行程调整前后的信息\n- 有多人次行程信息时，JSON数组输出多个字典，每个字典中“姓名”键值至多有一个\n## 输出模板：\n```json\n[{\"开始时间\": \"\", \"地点\": \"\", \"主题\": \"\", \"议题\": \"\"}]\n```\n# 短信内容如下:\n";
        goto L239
    L219:
        if (r119 != 80) goto L221;
        r5 = "<s><|User|>\n你是一名短信信息提取专家。请从我提供的快递类短信中提取以下字段：\n\n1. 快递公司：快递服务的平台或公司，例如“顺丰速运”、“京东快递”、“菜鸟驿站”等；\n2. 快递地址：短信中提到的取件地点或地址；\n3. 取件码：取件码识别规则：\n- 仅当短信中出现以下结构时，识别为取件码：\n  a) 明确包含“取件码”“提货码”“取货码”“验证码”等关键词后的字母或数字；\n  b) 或出现“请凭XXX(去|取件|领取)”等表述，其中XXX符合取件码格式；\n- 取件码格式：仅可包含英文字母(A-Z、a–z)、数字(0–9)、短横线“-”，例如：8472、A1B3、JD-105。\n注意事项：\n- “物流单号”“运单号”“订单号”“运单尾号”“单号”等不是取件码，请不要将这些数字识别为取件码；\n要求：\n- 若短信中未提及某字段，请输出空字符串；\n- 输出必须是标准 JSON（不要使用```json```等代码块格式），字段顺序固定为：\n  {\"res\":[{\"快递公司\":\"\",\"快递地址\":\"\",\"取件码\":\"\"}]}\n- 只输出 JSON，不要添加任何额外文字、符号或注释。\n\n示例：\n短信：您有快件已投递至菜鸟驿站（阳光花园北门店），取件码：8472，请尽快领取。\n输出：{\"res\":[{\"快递公司\":\"菜鸟\",\"快递地址\":\"菜鸟驿站阳光花园北门店\",\"取件码\":\"8472\"}]}\n\n短信：顺丰速运：您有快递到达A区1号楼自提柜，取件码A1B3。\n输出：{\"res\":[{\"快递公司\":\"顺丰速运\",\"快递地址\":\"A区1号楼自提柜\",\"取件码\":\"A1B3\"}]}\n\n短信：快件到达自提点，请凭短信取件。\n输出：{\"res\":[{\"快递公司\":\"\",\"快递地址\":\"\",\"取件码\":\"\"}]}\n\n# 短信内容如下：";
        goto L239
    L221:
        if (r119 == 81) goto L234;
        switch(r119) {
            case 20: goto L233;
            case 21: goto L232;
            case 22: goto L231;
            default: goto L223;
        };
    L223:
        String r91 = "<s><|User|>\n# 你是一个短信内容提取专家，请按照输出格式和输出模板要求归纳总结提取短信内容中的相关字段信息。\n## 输出格式：\n- 按照模板格式输出JSON数组，不要输出其他。\n- 未提及的字段，则输出空字符串\n- 如果一个键的值有多项，则用英文逗号`,`隔开\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟，短信内容未提及的字段不要填写\n- “原”和“现”分别对应行程调整前后的信息\n- 有多人次行程信息时，JSON数组输出多个字典，每个字典中“姓名”键值至多有一个\n## 输出模板：\n```json\n[{\"乘车人姓名\": \"\", \"出发站\": \"\", \"到达站\": \"\", \"出发时间\": \"\", \"到达时间\": \"\", \"车次\": \"\", \"车厢号\": \"\", \"座位号\": \"\", \"检票口\": \"\"}]\n```\n# 短信内容如下:\n";
        switch(r119) {
            case 30: goto L228;
            case 31: goto L230;
            case 32: goto L228;
            default: goto L225;
        };
    L225:
        r91 = "<s><|User|>\n# 你是一个短信内容提取专家，请按照输出格式和输出模板要求归纳总结提取短信内容中的相关字段信息。\n## 输出格式：\n- 按照模板格式输出JSON数组，不要输出其他。\n- 未提及的字段，则输出空字符串\n- 如果一个键的值有多项，则用英文逗号`,`隔开\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟，短信内容未提及的字段不要填写\n- “原”和“现”分别对应行程调整前后的信息\n- 有多人次行程信息时，JSON数组输出多个字典，每个字典中“姓名”键值至多有一个\n- 酒店名称根据短信内容提取例如“7天酒店”“广州白云机场亚朵酒店”“希尔顿酒店(太古里店)”等\n## 输出模板：\n```json\n[{\"入住人姓名\": \"\", \"酒店名称\": \"\", \"入住日期\": \"\", \"退房日期\": \"\", \"入住晚数\": \"\", \"房间类型\": \"\"}]\n```\n# 短信内容如下:\n";
        switch(r119) {
            case 40: goto L228;
            case 41: goto L229;
            case 42: goto L228;
            default: goto L239;
        };
    L229:
        r5 = "<s><|User|>\n# 你是一个短信内容提取专家，请按照输出格式和输出模板要求归纳总结提取短信内容中的相关字段信息。\n## 输出格式：\n- 按照模板格式输出JSON数组，不要输出其他。\n- 未提及的字段，则输出空字符串\n- 如果一个键的值有多项，则用英文逗号`,`隔开\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟，短信内容未提及的字段不要填写\n- “原”和“现”分别对应行程调整前后的信息\n- 有多人次行程信息时，JSON数组输出多个字典，每个字典中“姓名”键值至多有一个\n- 酒店名称根据短信内容提取例如“7天酒店”“广州白云机场亚朵酒店”“希尔顿酒店(太古里店)”等\n## 输出模板：\n```json\n[{\"入住人姓名\": \"\", \"酒店名称\": \"\", \"原入住日期\": \"\", \"原退房日期\": \"\", \"原房间类型\": \"\", \"现入住日期\": \"\", \"现退房日期\": \"\", \"现房间类型\": \"\"}]\n```\n# 短信内容如下:\n";
    L228:
        r5 = r91;
        goto L239
    L230:
        r5 = "<s><|User|>\n# 你是一个短信内容提取专家，请按照输出格式和输出模板要求归纳总结提取短信内容中的相关字段信息。\n## 输出格式：\n- 按照模板格式输出JSON数组，不要输出其他。\n- 未提及的字段，则输出空字符串\n- 如果一个键的值有多项，则用英文逗号`,`隔开\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟，短信内容未提及的字段不要填写\n- “原”和“现”分别对应行程调整前后的信息\n- 有多人次行程信息时，JSON数组输出多个字典，每个字典中“姓名”键值至多有一个\n## 输出模板：\n```json\n[{\"乘车人姓名\": \"\", \"原出发站\": \"\", \"原到达站\": \"\", \"原出发时间\": \"\", \"原到达时间\": \"\", \"原车次\": \"\", \"原车厢号\": \"\", \"原座位号\": \"\", \"原检票口\": \"\", \"现出发站\": \"\", \"现到达站\": \"\", \"现出发时间\": \"\", \"现到达时间\": \"\", \"现车次\": \"\", \"现车厢号\": \"\", \"现座位号\": \"\", \"现检票口\": \"\"}]\n```\n# 短信内容如下:\n";
        goto L239
    L231:
        r5 = "<s><|User|>\n# 你是一个短信内容提取专家，请按照输出格式和输出模板要求归纳总结提取短信内容中的相关字段信息。\n## 输出格式：\n- 按照模板格式输出JSON数组，不要输出其他。\n- 未提及的字段，则输出空字符串\n- 如果一个键的值有多项，则用英文逗号`,`隔开\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟，短信内容未提及的字段不要填写\n- “原”和“现”分别对应行程调整前后的信息\n- 有多人次行程信息时，JSON数组输出多个字典，每个字典中“姓名”键值至多有一个\n## 输出模板：\n```json\n[{\"乘机人姓名\": \"\", \"出发地\": \"\", \"到达地\": \"\", \"出发时间\": \"\", \"到达时间\": \"\", \"航空公司\": \"\", \"航班号\": \"\"}]\n```\n# 短信内容如下:\n";
        goto L239
    L232:
        r5 = "<s><|User|>\n# 你是一个短信内容提取专家，请按照输出格式和输出模板要求归纳总结提取短信内容中的相关字段信息。\n## 输出格式：\n- 按照模板格式输出JSON数组，不要输出其他。\n- 未提及的字段，则输出空字符串\n- 如果一个键的值有多项，则用英文逗号`,`隔开\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟，短信内容未提及的字段不要填写\n- “原”和“现”分别对应行程调整前后的信息\n- 有多人次行程信息时，JSON数组输出多个字典，每个字典中“姓名”键值至多有一个\n## 输出模板：\n```json\n[{\"乘机人姓名\": \"\", \"原出发地\": \"\", \"原到达地\": \"\", \"原出发时间\": \"\", \"原到达时间\": \"\", \"原航班号\": \"\", \"现出发地\": \"\", \"现到达地\": \"\", \"现出发时间\": \"\", \"现到达时间\": \"\", \"现航班号\": \"\"}]\n```\n# 短信内容如下:\n";
        goto L239
    L233:
        r5 = "<s><|User|>\n# 你是一个短信内容提取专家，请按照输出格式和输出模板要求归纳总结提取短信内容中的相关字段信息。\n## 输出格式：\n- 按照模板格式输出JSON数组，不要输出其他。\n- 未提及的字段，则输出空字符串\n- 如果一个键的值有多项，则用英文逗号`,`隔开\n- 日期时间表示格式为 “YYYY-MM-DD HH:MM”，YYYY年、MM月、DD日、HH小时、MM分钟，短信内容未提及的字段不要填写\n- “原”和“现”分别对应行程调整前后的信息\n- 有多人次行程信息时，JSON数组输出多个字典，每个字典中“姓名”键值至多有一个\n## 输出模板：\n```json\n[{\"乘机人姓名\": \"\", \"出发地\": \"\", \"到达地\": \"\", \"出发时间\": \"\", \"到达时间\": \"\", \"航班号\": \"\"}]\n```\n# 短信内容如下:\n";
        goto L239
    L234:
        r5 = "<s><|User|>\n你是一名关键词提取的专家，我将给你一条还款短信，请提取其中的还款日期和还款金额，以json形式返回给我。\n请直接输出结果,结果中不要出现json的字样，输出格式如下：\n{\"res\":[{'还款金额'：xx,'还款日期'：xx,'还款平台':xx}]}\n短信内容如下:\n";
        goto L239
    L209:
        r89 = "</s>\n<s><|Assistant|>\n";
    L210:
        r89 = "注意：\n请将酒店名称写全，包含括号中详细地址\n</s>\n<s><|Assistant|>\n";
        goto L211
    L263:
        JsWorker.a((JsWorker) this.f13599b);
        return;
    L265:
        ((ko.l) this.f13599b).a();
        return;
    L267:
        kh.c r92 = (kh.c) this.f13599b;
        if (r92.d == true) goto L379;
        r92.d = true;
        HashMap r93 = r92.e;
        r93.put("url", r92.f18642b);
        r93.put("pia_sdk_version", "2.0.0");
        m.b(new kh.b(r92, MetricsType.f7036b, r93));
        return;
    L379:
        return;
    L272:
        j1.e r94 = (j1.e) this.f13599b;
        r94.d.f9542a.release();
        r94.f18225b.a("did destroy");
        r94.f18226c.f17015a.g();
        return;
    L274:
        ((hu.a) this.f13599b).c();
        return;
    L276:
        WebMessagePort r95 = (WebMessagePort) ((l9.l) this.f13599b).f19575c;
        if (r95 == null) goto L380;
        r95.close();
        return;
    L380:
        return;
    L280:
        gu.b r96 = (gu.b) this.f13599b;
        r96.getClass();
        r96.updateAppWidget(new RemoteViews(r96.getAppWidgetInfo().provider.getPackageName(), 0));
        return;
    L282:
        gh.c r97 = (gh.c) this.f13599b;
        if (r97.d == true) goto L382;
        r97.d = true;
        com.bytedance.pia.core.utils.a r98 = r97.e;
        r98.d = true;
        r98.a();
        r98.f7139a.set(null);
        hh.a r99 = r97.f;
        if (r99 == null) goto L381;
        r99.close();
        return;
    L381:
        return;
    L382:
        return;
    L289:
        DefaultHostedWidget.a((DefaultHostedWidget) this.f13599b);
        return;
    L291:
        WebViewActivity r100 = (WebViewActivity) this.f13599b;
        if (r100.f14919w == false) goto L383;
        Log.w("WebViewActivity", "reload timeout, keep showing error page");
        r100.x();
        return;
    L383:
        return;
    L295:
        OCTitleBar.a((OCTitleBar) this.f13599b);
        return;
    L297:
        OSwipeActionLayout.a((OSwipeActionLayout) this.f13599b);
        return;
    L299:
        TickMarkSeekBar.a((TickMarkSeekBar) this.f13599b);
        return;
    L301:
        WheelView.a((WheelView) this.f13599b);
        return;
    L303:
        int r101 = OCardListItem.I;
        OCardListItem r102 = (OCardListItem) this.f13599b;
        Intrinsics.checkNotNullParameter(r102, "this$0");
        int r103 = r102.f13558w;
        if (r103 == (-1)) goto L307;
        int r104 = r102.f13559x;
        if (r104 == (-1)) goto L307;
    L334:
        View r105 = r102.f13556u;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L337;
        r10 = (ViewGroup.MarginLayoutParams) r106;
    L337:
        if (r10 == null) goto L340;
        r10.setMargins(r103, r10.topMargin, r104, r10.bottomMargin);
    L340:
        r105.setLayoutParams(r10);
        return;
    L307:
        OUIFrameLayout r107 = r102.e;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L310;
        r108 = null;
    L310:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        if (r109 == null) goto L313;
        int r120 = r109.leftMargin;
    L314:
        int r121 = r107.getPaddingLeft();
        ViewGroup.LayoutParams r122 = r107.getLayoutParams();
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == true) goto L317;
        r122 = null;
    L317:
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
        if (r123 == null) goto L320;
        int r124 = r123.rightMargin;
    L321:
        int r125 = r107.getPaddingRight();
        int r126 = r120 + r121;
        FrameLayout r127 = r102.f13546j;
        if (r127.getVisibility() != 0) goto L324;
        r126 = r126 + r127.getWidth();
    L324:
        FrameLayout r128 = r102.f13547k;
        if (r128.getVisibility() != 0) goto L328;
        r126 = r126 + r128.getWidth();
    L328:
        if (r127.getVisibility() == 8) goto L330;
    L332:
        int r129 = r126;
    L333:
        int r210 = r129;
        r104 = com.lynx.tasm.utils.a.B(8, r102) + (r124 + r125);
        r103 = r210;
        goto L334
    L330:
        if (r128.getVisibility() != 8) goto L332;
        r129 = r102.f13550n.getPaddingLeft() + r126;
        goto L333
    L320:
        r124 = 0;
        goto L321
    L313:
        r120 = 0;
        goto L314
    }

    public /* synthetic */ a(Object r5, int r10) {
        this.f13598a = r10;
        this.f13599b = r5;
    }
}
