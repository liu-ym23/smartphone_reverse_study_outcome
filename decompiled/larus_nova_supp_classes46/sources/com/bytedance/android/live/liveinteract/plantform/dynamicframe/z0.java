package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.na0;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z0 {
    public static final long a = 0;
    public static final int b = 0;
    public static ih0.c c;
    public static final MultiLinkSimplePools<ih0.c> d = null;
    public static Disposable e;
    public static Disposable f;
    public static final z0 g = null;

    public static final class a implements Runnable {
        public final /* synthetic */ ih0.c a;

        public a(ih0.c r1) {
            this.a = r1;
        }

        public final void a() {
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card start");
            ih0.c r0 = this.a;
            if (r0 == null) goto L5;
            ih0.c.a.a(r0, null, null, 7);
        L5:
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card end");
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
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            f2.g();
            int r4 = z0.b;
            if (z0.d() == false) goto L11;
            ih0.c r5 = z0.c;
            if (r5 == null) goto L7;
            r5.J();
        L7:
            ih0.c r6 = z0.c;
            if (r6 == null) goto L10;
            r6.release();
        L10:
            z0.c = null;
        L14:
            ALogger.d("MultiLinkDynamicWidget", "清除渲染容器缓存");
            return;
        L11:
            ih0.c r7 = z0.d.acquire();
        L12:
            if (r7 == null) goto L14;
            r7.J();
            r7.release();
            r7 = z0.d.acquire();
            goto L12
        }
    }

    public z0() {
    }

    static {
        g = new z0();
        a = vm2.h.O().g();
        b = vm2.h.O().d();
        d = new MultiLinkSimplePools(vm2.h.O().f());
    }

    public static boolean c() {
        boolean r2 = false;
        if (d() == false) goto L12;
        StringBuilder r0 = new StringBuilder("有无AnnieCard缓存？ ");
        if (c == null) goto L7;
        boolean r4 = true;
    L8:
        r0.append(r4);
        ALogger.i("MultiLinkRenderWidgetReuseManager", r0.toString());
        if (c == null) goto L32;
        return true;
    L32:
        return false;
    L7:
        r4 = false;
        goto L8
    L12:
        StringBuilder r1 = new StringBuilder("有无AnnieCard复用池缓存？ ");
        MultiLinkSimplePools<ih0.c> r5 = d;
        if (r5.a.size() != 0) goto L15;
        boolean r6 = true;
    L16:
        r1.append(!r6);
        r1.append(" mHybridCardPool=");
        r1.append(r5.a());
        ALogger.i("MultiLinkRenderWidgetReuseManager", r1.toString());
        if (MultiLinkLoadWidgetUtils.g() == true) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L29;
        if (r5.a.size() != 0) goto L27;
        r2 = true;
    L27:
        return !r2;
    L29:
        if (r5.a() < b) goto L33;
        return true;
    L33:
        return false;
    L19:
        if (vm2.h.W().disablePreloadRenderWidget() == false) goto L21;
        r3 = true;
        goto L22
    L15:
        r6 = false;
        goto L16
    }

    public static boolean d() {
        if (vm2.h.O().i() == true) goto L5;
        return true;
    L5:
        if (vm2.h.O().f() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static void e(ih0.c r2) {
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == false) goto L5;
        Schedulers.io().scheduleDirect(new a(r2));
        return;
    L5:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
        ih0.c.a.a(r2, null, null, 7);
    }

    public static com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b a(z0 r7, Context r8, DataCenter r9) {
        r7.getClass();
        boolean r10 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        String r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.d();
        String r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.c();
        com.bytedance.live.datacontext.m r11 = o3.j(r9).getRoom();
        HybridCard r12 = null;
        if (r11 == null) goto L7;
        IRoom r13 = (IRoom) r11.getValue();
        if (r13 == null) goto L7;
        Long r2 = Long.valueOf(r13.getRoomId());
    L8:
        Uri r14 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r0, r1, r2, false, 0, false, 48);
        y0 r3 = new y0(r14, null);
        IBaseBrowserService r4 = jc1.k.f(IBaseBrowserService.class);
        if (r4 == null) goto L11;
        r12 = r4.getHybridCard(r8, r14, r3);
    L11:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b r15 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b(r12);
        r3.a = r15;
        return r15;
    L7:
        r2 = null;
        goto L8
    }

    public static void g(ih0.c r4, DataCenter r5, MessageHub r6) {
        ALogger.i("MultiLinkRenderWidgetReuseManager", "开始回收AnnieCard...AnnieCard=" + r4);
        JsonObject r0 = new JsonObject();
        r0.addProperty("lifecycle", "reset");
        if (r4 == null) goto L5;
        r4.sendJsEvent("renderWidgetLifecycle", r0);
    L5:
        ih0.c r1 = c;
        if (r1 == null) goto L9;
        r1.J();
    L9:
        if (d() == false) goto L18;
        ih0.c r2 = c;
        if (r2 != null) goto L14;
        c = r4;
        ALogger.e("MultiLinkRenderWidgetReuseManager", "回收AnnieCard...无AnnieCard缓存，回收后作为缓存！mHybridCard=" + c);
    L26:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "回收AnnieCard成功！");
        Disposable r3 = f;
        if (r3 == null) goto L29;
        r3.dispose();
    L29:
        f = RxUtilKt.h(Observable.timer(vm2.h.O().h(), TimeUnit.SECONDS)).subscribe(b.a);
        if (r4 == null) goto L44;
        View r7 = r4.getHybridView();
        if (r7 == null) goto L47;
        com.bytedance.live.datacontext.j r8 = o3.j(r5).w1();
        if (r8 == null) goto L37;
        ylc.e r9 = (ylc.e) r8.getValue();
    L38:
        com.bytedance.android.live.browser.utils.j.c(r7);
        int r10 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.i(r4);
        com.bytedance.android.live.browser.utils.n.d(r7, r5, r6);
        com.bytedance.android.live.browser.utils.n.a(r7, r9, r6);
        if (r5 == null) goto L45;
        HashMap r11 = (HashMap) r5.get("multilink_jsb_message_filter", null);
        if (r11 == null) goto L46;
        r11.clear();
        return;
    L46:
        return;
    L45:
        return;
    L37:
        r9 = null;
        goto L38
    L47:
        return;
    L44:
        return;
    L14:
        if ((!Intrinsics.areEqual(r2, r4)) == false) goto L26;
        ALogger.e("MultiLinkRenderWidgetReuseManager", "回收AnnieCard...有AnnieCard缓存，但与此处回收的AnnieCard不相符！mHybridCard=" + c + "，annieCard=hybridCard");
        if (r4 == null) goto L26;
        r4.release();
        goto L26
    L18:
        if (r4 == null) goto L26;
        MultiLinkSimplePools<ih0.c> r12 = d;
        if (r12.release(r4) == true) goto L23;
        r4.J();
        r4.release();
    L25:
        ALogger.e("MultiLinkRenderWidgetReuseManager", "回收AnnieCard...放入复用池！mHybridCardPool=" + r12.a());
        goto L26
    L23:
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV2() == false) goto L25;
        r4.J();
        r4.f1();
        goto L25
    }

    public final ih0.c b(Context r16, Long r17, DataCenter r18) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        ALogger.i("MultiLinkRenderWidgetReuseManager", "开始获取AnnieCard...mHybridCard=" + c);
        Disposable r2 = f;
        if (r2 == null) goto L5;
        r2.dispose();
    L5:
        long r4 = System.currentTimeMillis();
        boolean r3 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        String r7 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.d();
        String r8 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.c();
        com.bytedance.live.datacontext.m r5 = o3.j(r18).getRoom();
        if (r5 == null) goto L10;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L10;
        Long r9 = Long.valueOf(r6.getRoomId());
    L11:
        Uri r10 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r7, r8, r9, false, 0, false, 48);
        if (d() == true) goto L14;
        LinkedHashMap r11 = new LinkedHashMap();
        if (r17 != null) goto L37;
        com.bytedance.live.datacontext.m r12 = o3.j(r18).getRoom();
        if (r12 == null) goto L36;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L36;
        Long r14 = Long.valueOf(r13.getRoomId());
    L38:
        if (r14 == null) goto L40;
        r11.put("room_id", String.valueOf(r14.longValue()));
    L40:
        com.bytedance.live.datacontext.m r15 = o3.j(r18).getRoom();
        if (r15 == null) goto L45;
        IRoom r19 = (IRoom) r15.getValue();
        if (r19 == null) goto L45;
        String r20 = r19.getOwnerUserIdString();
    L46:
        String r110 = gh0.a.c();
        if (r20 == null) goto L50;
        r11.put("anchor_id", r20);
    L50:
        if (r2.a(r110) == true) goto L53;
        r110 = null;
    L53:
        if (r110 == null) goto L55;
        r11.put("user_id", r110);
    L55:
        MultiLinkSimplePools<ih0.c> r21 = d;
        ih0.c r111 = r21.acquire();
        if (r111 == null) goto L60;
        ALogger.i("MultiLinkRenderWidgetReuseManager", "有AnnieCard复用池缓存，直接使用，item=" + r111 + ", mHybridCardPool=" + r21.a());
        View r1 = r111.S0();
        if (r1 == null) goto L67;
        r1.setTag(2131389672, Boolean.TRUE);
    L67:
        r111.updateGlobalProps(r11);
        return r111;
    L60:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "无AnnieCard复用池缓存，开始创建");
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L63;
        y0 r112 = new y0(r10, null);
        int r22 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        ih0.c r23 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(r16, r10, r112, r4, r18, false);
        r112.a = r23;
    L64:
        r111 = r23;
        View r24 = r111.S0();
        if (r24 == null) goto L67;
        r24.setTag(2131389672, Boolean.FALSE);
        goto L67
    L63:
        r23 = a(this, r16, r18);
    L45:
        r20 = null;
    L36:
        r14 = null;
        goto L38
    L37:
        r14 = r17;
        goto L38
    L14:
        if (c != null) goto L22;
        ALogger.i("MultiLinkRenderWidgetReuseManager", "无AnnieCard缓存，开始创建");
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L18;
        y0 r25 = new y0(r10, null);
        int r26 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        ih0.c r27 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(r16, r10, r25, r4, r18, false);
        r25.a = r27;
    L19:
        c = r27;
        View r28 = r27.S0();
        if (r28 == null) goto L28;
        r28.setTag(2131389672, Boolean.FALSE);
    L28:
        return c;
    L18:
        r27 = a(this, r16, r18);
        goto L19
    L22:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "有AnnieCard缓存，直接使用，mHybridCard=" + c);
        ih0.c r29 = c;
        if (r29 == null) goto L28;
        View r30 = r29.S0();
        if (r30 == null) goto L28;
        r30.setTag(2131389672, Boolean.TRUE);
    L10:
        r9 = null;
        goto L11
    }

    public final void f(Context r17, DataCenter r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        if (vm2.h.O().i() == true) goto L5;
        return;
    L5:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "开始预加载AnnieCard...");
        long r4 = System.currentTimeMillis();
        boolean r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        String r9 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.d();
        String r10 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.c();
        com.bytedance.live.datacontext.m r2 = o3.j(r18).getRoom();
        if (r2 == null) goto L10;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L10;
        Long r11 = Long.valueOf(r3.getRoomId());
    L11:
        Uri r7 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r9, r10, r11, false, 0, r19, 16);
        if (b > 0) goto L15;
        return;
    L15:
        if (d() == false) goto L25;
        if (c != null) goto L23;
        y0 r12 = new y0(r7, null);
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L21;
        int r5 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        int r6 = e0.o;
        ih0.c r8 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(e0.a.a(r17), r7, r12, r4, r18, false);
        r12.a = r8;
    L22:
        c = r8;
        e(r8);
        ALogger.i("MultiLinkRenderWidgetReuseManager", "预加载AnnieCard成功！mHybridCard=" + c);
        return;
    L21:
        int r13 = e0.o;
        r8 = a(this, e0.a.a(r17), r18);
        goto L22
    L23:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "已有AnnieCard缓存！无需再预加载，mHybridCard=" + c);
        return;
    L25:
        if (c() == false) goto L27;
        return;
    L27:
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L29;
        y0 r14 = new y0(r7, null);
        int r15 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        int r16 = e0.o;
        ih0.c r20 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(e0.a.a(r17), r7, r14, r4, r18, false);
        r14.a = r20;
    L30:
        e(r20);
        if (d.release(r20) == true) goto L34;
        r20.J();
        r20.release();
        return;
    L34:
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV2() == false) goto L41;
        r20.J();
        r20.f1();
        return;
    L41:
        return;
    L29:
        int r21 = e0.o;
        r20 = a(this, e0.a.a(r17), r18);
    L10:
        r11 = null;
        goto L11
    }
}
