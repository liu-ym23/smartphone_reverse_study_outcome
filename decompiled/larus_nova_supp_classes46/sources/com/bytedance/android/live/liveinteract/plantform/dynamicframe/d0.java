package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.na0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 {
    public static final int a = 0;
    public static final long b = 0;
    public static final MultiLinkSimplePools<ih0.c> c = null;
    public static Disposable d;
    public static Disposable e;
    public static final d0 f = null;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            f2.g();
            ih0.c r4 = d0.c.acquire();
        L3:
            if (r4 == null) goto L5;
            r4.J();
            r4.release();
            r4 = d0.c.acquire();
            goto L3
        L5:
            ALogger.i("MultiLinkHybridCardReuseManager", "清除主容器缓存");
        }
    }

    public d0() {
    }

    static {
        f = new d0();
        a = vm2.h.O().b();
        b = vm2.h.O().c();
        c = new MultiLinkSimplePools(2);
    }

    public static com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b a(d0 r8, Context r9, DataCenter r10) {
        r8.getClass();
        boolean r11 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        String r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f();
        String r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.e();
        com.bytedance.live.datacontext.m r12 = o3.j(r10).getRoom();
        if (r12 == null) goto L7;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L7;
        Long r2 = Long.valueOf(r13.getRoomId());
    L8:
        Uri r14 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r0, r1, r2, false, 0, false, 48);
        i r3 = new i(r10, r14, true, null);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b r15 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b(jc1.k.n(IBaseBrowserService.class).getHybridCard(r9, r14, r3));
        r3.a = r15;
        return r15;
    L7:
        r2 = null;
        goto L8
    }

    public static void d(ih0.c r5, DataCenter r6, MessageHub r7) {
        ALogger.i("MultiLinkHybridCardReuseManager", "开始回收AnnieCard...AnnieCard=" + r5);
        if (vm2.h.O().a() == true) goto L38;
        if (r5 == null) goto L29;
        r5.release();
    L29:
        long r2 = b;
        Disposable r8 = e;
        if (r8 == null) goto L32;
        r8.dispose();
    L32:
        e = RxUtilKt.h(Observable.timer(r2, TimeUnit.SECONDS)).subscribe(new c0(r6));
    L33:
        ALogger.i("MultiLinkHybridCardReuseManager", "回收AnnieCard成功！");
        Disposable r9 = d;
        if (r9 == null) goto L36;
        r9.dispose();
    L36:
        d = RxUtilKt.h(Observable.timer(vm2.h.O().j(), TimeUnit.SECONDS)).subscribe(a.a);
        return;
    L38:
        JsonObject r0 = new JsonObject();     // Catch: JSONException -> L8
        r0.addProperty("lifecycle", "reset");     // Catch: JSONException -> L8
        r0.addProperty("source", PbRequest.SwitchType.FEED);     // Catch: JSONException -> L8
        if (r5 == null) goto L10;
        r5.sendJsEvent("logicWidgetLifecycle", r0);     // Catch: JSONException -> L8
    L10:
        if (r5 == null) goto L26;
        View r1 = r5.getHybridView();
        if (r1 == null) goto L40;
        com.bytedance.live.datacontext.j r3 = o3.j(r6).w1();
        if (r3 == null) goto L17;
        ylc.e r4 = (ylc.e) r3.getValue();
    L18:
        com.bytedance.android.live.browser.utils.j.c(r1);
        int r10 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.i(r5);
        com.bytedance.android.live.browser.utils.n.d(r1, r6, r7);
        com.bytedance.android.live.browser.utils.n.a(r1, r4, r7);
        MultiLinkSimplePools<ih0.c> r11 = c;
        if (r11.release(r5) == true) goto L21;
        r5.J();
        r5.release();
    L21:
        ALogger.e("MultiLinkRenderWidgetReuseManager", "逻辑容器完全复用-回收AnnieCard...放入复用池！mHybridCardPool=" + r11.a());
        ALogger.i("MultiLinkHybridCardReuseManager", "逻辑容器完全复用-回收AnnieCard成功！mHybridCardPool=" + r11.a());
        if (r6 == null) goto L33;
        HashMap r12 = (HashMap) r6.get("multilink_jsb_message_filter", null);
        if (r12 == null) goto L33;
        r12.clear();
        goto L33
    L17:
        r4 = null;
        goto L18
    L40:
        return;
    L26:
        return;
    L8:
        e = move-exception;
        ALogger.e("MultiLinkHybridCardReuseManager", "逻辑容器完全复用-" + e.toString());
        goto L10
    }

    public final ih0.c b(Context r16, Long r17, DataCenter r18) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        ALogger.i("MultiLinkHybridCardReuseManager", "开始获取AnnieCard...");
        Disposable r3 = d;
        if (r3 == null) goto L5;
        r3.dispose();
    L5:
        long r4 = System.currentTimeMillis();
        boolean r6 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        String r7 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f();
        String r8 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.e();
        com.bytedance.live.datacontext.m r9 = o3.j(r18).getRoom();
        String r14 = null;
        if (r9 == null) goto L10;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L10;
        Long r11 = Long.valueOf(r10.getRoomId());
    L11:
        Uri r12 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r7, r8, r11, false, 0, false, 48);
        MultiLinkSimplePools<ih0.c> r13 = c;
        if (r13.a() >= a) goto L20;
        i r15 = new i(r18, r12, false, null);
        ALogger.i("MultiLinkHybridCardReuseManager", "无AnnieCard缓存，开始创建");
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L16;
        int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        ih0.c r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(r16, r12, r15, r4, r18, false);
    L17:
        r15.a = r0;
        View r2 = r0.S0();
        if (r2 == null) goto L62;
        r2.setTag(2131389672, Boolean.FALSE);
        return r0;
    L62:
        return r0;
    L16:
        r0 = a(this, r16, r18);
        goto L17
    L20:
        LinkedHashMap r5 = new LinkedHashMap();
        com.bytedance.live.datacontext.m r19 = o3.j(r18).getRoom();
        if (r19 == null) goto L25;
        IRoom r20 = (IRoom) r19.getValue();
        if (r20 == null) goto L25;
        String r21 = r20.getOwnerUserIdString();
    L26:
        String r22 = gh0.a.c();
        if (r17 != null) goto L34;
        com.bytedance.live.datacontext.m r23 = o3.j(r18).getRoom();
        if (r23 == null) goto L33;
        IRoom r24 = (IRoom) r23.getValue();
        if (r24 == null) goto L33;
        Long r25 = Long.valueOf(r24.getRoomId());
    L35:
        if (r25 == null) goto L37;
        r5.put("room_id", String.valueOf(r25.longValue()));
    L37:
        if (r21 == null) goto L40;
        r5.put("anchor_id", r21);
    L40:
        if (r2.a(r22) == false) goto L42;
        r14 = r22;
    L42:
        if (r14 == null) goto L44;
        r5.put("user_id", r14);
    L44:
        ih0.c r26 = r13.acquire();
        ALogger.i("MultiLinkHybridCardReuseManager", "有AnnieCard缓存，直接使用，mHybridCard=" + r26 + ", roomId=" + r17 + ", anchorId=" + r21 + ", userId=" + r22);
        if (r26 == null) goto L47;
        r26.updateGlobalProps(r5);
    L47:
        int r27 = MultiSceneEnterRoomStatisticsUtils.u;
        com.bytedance.live.datacontext.m r28 = o3.j(r18).getRoom();
        if (r28 == null) goto L52;
        IRoom r29 = (IRoom) r28.getValue();
        if (r29 == null) goto L52;
        long r30 = r29.getRoomId();
    L53:
        MultiSceneEnterRoomStatisticsUtils r31 = MultiSceneEnterRoomStatisticsUtils.a.a(r18, Long.valueOf(r30));
        if (r31 == null) goto L56;
        r31.recordSubElementShow("lynx_container_load", System.currentTimeMillis());
    L56:
        if (r26 == null) goto L61;
        View r32 = r26.S0();
        if (r32 == null) goto L61;
        r32.setTag(2131389672, Boolean.TRUE);
    L61:
        return r26;
    L52:
        r30 = 0;
    L33:
        r25 = null;
        goto L35
    L34:
        r25 = r17;
    L25:
        r21 = null;
    L10:
        r11 = null;
        goto L11
    }

    public final void c(Context r17, DataCenter r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        if (vm2.h.O().k() == true) goto L5;
        return;
    L5:
        ALogger.i("MultiLinkHybridCardReuseManager", "开始预加载AnnieCard...");
        long r3 = System.currentTimeMillis();
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        String r8 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f();
        String r9 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.e();
        com.bytedance.live.datacontext.m r1 = o3.j(r18).getRoom();
        if (r1 == null) goto L10;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L10;
        Long r10 = Long.valueOf(r2.getRoomId());
    L11:
        Uri r4 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r8, r9, r10, false, 0, r19, 16);
        i r11 = new i(r18, r4, true, null);
        MultiLinkSimplePools<ih0.c> r12 = c;
        if (r12.a() < a) goto L14;
        ALogger.i("MultiLinkHybridCardReuseManager", "已有AnnieCard缓存！无需再预加载，mHybridCardPoolSize=" + r12.a());
        return;
    L14:
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L16;
        int r5 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        int r6 = e0.o;
        ih0.c r7 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(e0.a.a(r17), r4, r11, r3, r18, false);
    L17:
        r11.a = r7;
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == true) goto L22;
        if (r19 == true) goto L22;
        r11.c = System.currentTimeMillis();
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
        ih0.c.a.a(r7, null, null, 7);
    L23:
        r12.release(r7);
        ALogger.i("MultiLinkHybridCardReuseManager", "预加载AnnieCard成功！mHybridCardPoolSize=" + r12.a());
        return;
    L22:
        Schedulers.io().scheduleDirect(new b0(r11, r7));
        goto L23
    L16:
        int r13 = e0.o;
        r7 = a(this, e0.a.a(r17), r18);
    L10:
        r10 = null;
        goto L11
    }
}
