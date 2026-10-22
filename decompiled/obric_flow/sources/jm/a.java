package jm;

import ai.j0;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.android.monitorV2.i;
import com.bytedance.android.monitorV2.settings.f;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.bytedance.ies.bullet.core.j;
import com.bytedance.ies.web.jsbridge2.l;
import com.bytedance.ies.xelement.banner.BannerViewPager;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.model.SettingsRequestModel;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.g;
import com.bytedance.sync.SyncSDK;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.ui.image.v;
import com.obric.oui.optinput.OOtpInputView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.StringsKt;
import l9.t;
import l9.u;
import m.f0;
import mn.h;
import org.json.JSONObject;
import sj.k;
import z6.d;
import z6.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18353b;

    public /* synthetic */ a() {
        this.f18352a = 14;
    }

    private final void a() {
    L3:
        if (((ConcurrentLinkedQueue) ((e) this.f18353b).f23412c).isEmpty() == true) goto L16;
        Object r5 = ((e) this.f18353b).d;
        monitor-enter(r5);
        if (((Handler) ((e) this.f18353b).f23410a) == null) goto L11;
        ((Handler) ((e) this.f18353b).f23410a).sendMessageAtFrontOfQueue((Message) ((ConcurrentLinkedQueue) ((e) this.f18353b).f23412c).poll());     // Catch: Throwable -> L9
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L16:
        if (((ConcurrentLinkedQueue) ((e) this.f18353b).f23411b).isEmpty() == true) goto L28;
        Object r10 = ((e) this.f18353b).d;
        monitor-enter(r10);
        d r11 = (d) ((ConcurrentLinkedQueue) ((e) this.f18353b).f23411b).poll();     // Catch: Throwable -> L22
        if (((Handler) ((e) this.f18353b).f23410a) == null) goto L24;
        Handler r12 = (Handler) ((e) this.f18353b).f23410a;     // Catch: Throwable -> L22
        r11.getClass();     // Catch: Throwable -> L22
        r12.sendMessageAtTime(null, 0);     // Catch: Throwable -> L22
    L24:
        monitor-exit(r10);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f18352a) {
            case 0: goto L219;
            case 1: goto L207;
            case 2: goto L200;
            case 3: goto L198;
            case 4: goto L196;
            case 5: goto L190;
            case 6: goto L121;
            case 7: goto L117;
            case 8: goto L115;
            case 9: goto L110;
            case 10: goto L96;
            case 11: goto L94;
            case 12: goto L90;
            case 13: goto L88;
            case 14: goto L231;
            case 15: goto L79;
            case 16: goto L44;
            case 17: goto L39;
            case 18: goto L12;
            case 19: goto L229;
            case 20: goto L6;
            default: goto L4;
        };
    L4:
        zn.a.f23550b.a();
        return;
    L6:
        a();
        return;
    L12:
        long r5 = System.currentTimeMillis();
        z4.b r10 = (z4.b) this.f18353b;
        if (r10.e != null) goto L15;
        r10.c(r10.f);
    L15:
        com.obric.flow.cardlistpage.mvi.c r11 = ((z4.b) this.f18353b).e;
        r11.getClass();
        String r12 = com.bytedance.android.monitorV2.constant.a.b("monitor_setting_response", "");     // Catch: Throwable -> L18
        a5.d r13 = f0.b(r12);     // Catch: Throwable -> L18
        com.bytedance.android.monitorV2.constant.a.a("monitor_setting_response_fetch_time");     // Catch: Throwable -> L18
        r11.f11533c = r12;     // Catch: Throwable -> L18
        r11.f11532b = r13;     // Catch: Throwable -> L18
    L20:
        if (r13 == null) goto L22;
        ((z4.b) this.f18353b).f23392a = r13;
        f8.b.b();
    L22:
        a5.d r14 = ((z4.b) this.f18353b).e.c();
        if (r14 == null) goto L25;
        ((z4.b) this.f18353b).f23392a = r14;
        f8.b.h();
    L25:
        d5.b.f("HybridSettingRequestService", "_init from local");
        if (((z4.b) this.f18353b).f23392a.e == 0) goto L28;
        ((z4.b) this.f18353b).e.getClass();
        int r15 = (int) ((com.bytedance.android.monitorV2.constant.a.a("monitor_setting_response_fetch_time") + ((long) ((z4.b) this.f18353b).f23392a.d)) - (System.currentTimeMillis() / 1000));
        d5.b.f("HybridSettingRequestService", "_init local is not null, and durationUntilUpdate is" + r15 + " secs");
    L30:
        if (r15 > 0) goto L36;
        d5.b.f("HybridSettingRequestService_init", "monitor setting init right now");
        z4.b r16 = (z4.b) this.f18353b;
        r16.f23394c.submit(new com.bytedance.iesgurd.settings.b(4, true, r16));     // Catch: Throwable -> L34
    L37:
        HashMap r17 = new HashMap();
        r17.put("setting_init_type", "HybridSettingRequestService");
        HashMap r18 = new HashMap();
        r18.put("setting_init_time", Long.valueOf(System.currentTimeMillis() - r5));
        i.b(r17, r18, "setting_init_perf");
        d5.b.c("HybridSettingRequestService", "HybridSettingManagerImpl init JsonOptConfig.isJsonOptEnable(): false");
        d5.b.c("HybridSettingRequestService", "HybridSettingManagerImpl init cost: " + (System.currentTimeMillis() - r5));
        return;
    L34:
        th = move-exception;
        h.g("default_handle", th);
        goto L37
    L36:
        d5.b.f("HybridSettingRequestService_init", "monitor setting init after " + r15 + " secs");
        HashMap r19 = new HashMap();
        r19.put("setting_id", String.valueOf(((z4.b) this.f18353b).f23392a.e));
        i.b(r19, null, "startup_init");
        ((z4.b) this.f18353b).b(r15);
        goto L37
    L28:
        r15 = 0;
    L18:
        th = move-exception;
        h.g("startup_handle", th);
        r13 = null;
        goto L20
    L39:
        OOtpInputView r20 = (OOtpInputView) this.f18353b;
        if (r20.E == false) goto L271;
        r20.D = !r20.D;
        r20.invalidate();
        r20.postDelayed(this, 500);
        return;
    L271:
        return;
    L44:
        JSONObject r21 = new JSONObject();
        bj.a r110 = (bj.a) this.f18353b;
        if (StringsKt.isBlank(r110.d) == true) goto L47;
        Object r22 = r110.d;
    L48:
        r21.put("biz", r22);
        String r23 = r110.f932a;
        r21.put("method", r23);
        r21.put("bridge_name", r23);
        r21.put("bridge_type", "bdxbridge");
        int r24 = r110.c().ordinal();
        if (r24 != 0) goto L51;
        Object r25 = "lynx";
    L58:
        r21.put("container_type", r25);
        r21.put("success", r110.f940m);
        r21.put("code", r110.f938k);
        r21.put("message", r110.f939l);
        IDLXBridgeMethod.XBridgeThreadType r26 = r110.f941n;
        if (r26 == null) goto L61;
        Object r27 = r26.f7472a;
    L62:
        r21.put("thread_type", r27);
        r21.put("is_latch", false);
        JSONObject r28 = new JSONObject();
        long r29 = r110.f936i;
        long r30 = r110.f;
        r28.put("native_execute_duration", r29 - r30);
        r28.put("auth_execute_duration", r110.f949w - r110.f948v);
        Long r31 = r110.g;
        if (r31 == null) goto L65;
        r28.put("method_execute_duration", r110.f936i - r31.longValue());
    L65:
        Long r32 = r110.f935h;
        if (r32 == null) goto L68;
        r28.put("before_method_execute_duration", r32.longValue() - r30);
    L68:
        r28.put("native_callback_duration", r110.f936i - r110.f937j);
        JSONObject r33 = new JSONObject();
        r33.put("duration", r110.f949w - r110.f948v);
        JSONObject r34 = new JSONObject();
        wi.a.a(r34, r110);
        r34.put("auth_status", r110.s ? 1 : 0);
        ki.a.d.getClass();
        l r35 = new l("bdx_monitor_bridge_pv", 1);
        r35.f6292h = r21;
        r35.f6293i = r28;
        r35.f6290b = r110.d();
        r35.b(2);
        com.bytedance.android.monitorV2.h r36 = com.bytedance.android.monitorV2.h.e();
        x4.c r37 = r35.a();
        r36.getClass();
        com.bytedance.android.monitorV2.h.d(r37);
        if (r110.G == false) goto L72;
        l r38 = new l("bdx_monitor_bridge_auth", 1);
        r38.f6292h = r34;
        r38.f6293i = r33;
        r38.f6290b = r110.d();
        r38.b(2);
        com.bytedance.android.monitorV2.h r39 = com.bytedance.android.monitorV2.h.e();
        x4.c r40 = r38.a();
        r39.getClass();
        com.bytedance.android.monitorV2.h.d(r40);
    L72:
        if (r110.G == true) goto L75;
        return;
    L75:
        if (r110.s == true) goto L272;
        ((g) ki.a.d.f5320b).a("bdx auth failed, method: " + r23 + ", stage: jsb_auth, url: " + r110.d());
        JSONObject r41 = new JSONObject();
        wi.a.a(r41, r110);
        r41.put("type", "bdxbridge");
        r41.put("failed_reason", r110.f939l);
        r41.put("original_method_auth_type", com.bytedance.apm.util.a.b(r110.f946t).f7303a);
        r41.put("app_id", r110.f944q);
        r41.put("fe_auth_group", r110.A);
        ki.a.d.getClass();
        l r111 = new l("bdx_jsb_auth_error", 1);
        r111.f6292h = r41;
        r111.b(3);
        com.bytedance.android.monitorV2.h r42 = com.bytedance.android.monitorV2.h.e();
        x4.c r112 = r111.a();
        r42.getClass();
        com.bytedance.android.monitorV2.h.d(r112);
        return;
    L272:
        return;
    L61:
        r27 = null;
        goto L62
    L51:
        if (r24 == 1) goto L56;
        if (r24 != 2) goto L55;
        r25 = "worker";
        goto L58
    L55:
        throw new NoWhenBranchMatchedException();
    L56:
        r25 = "webview";
        goto L58
    L47:
        r22 = r110.e;
        goto L48
    L88:
        ((v6.e) this.f18353b).a();
        return;
    L90:
        uf.e r113 = (uf.e) this.f18353b;
        Surface r43 = r113.getSurface();
        of.e r114 = r113.f22339b;
        if (r114 == null) goto L276;
        r114.d(r43);
        return;
    L276:
        return;
    L94:
        fj.a.g(((WsChannelService) this.f18353b).getApplicationContext());
        return;
    L96:
        s8.g r115 = (s8.g) this.f18353b;
        Thread.currentThread().setName("MessageDispatcher");     // Catch: Throwable -> L106
    L98:
        Thread.currentThread();     // Catch: Throwable -> L106
        if (Thread.interrupted() == true) goto L108;
        s8.g.f21848h.getAndSet(true);     // Catch: Throwable -> L106
        r115.g((s8.i) r115.e.take());     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L106
    L108:
        s8.g.f21848h.getAndSet(false);
        return;
    L106:
        th = move-exception;
        th.printStackTrace();
        goto L108
    L110:
        Iterator r116 = ((CopyOnWriteArraySet) ((r6.a) this.f18353b).f21695a).iterator();
        if (r116.hasNext() == true) goto L113;
        return;
    L113:
        j0.A(r116.next());
        throw null;
    L115:
        SyncSDK.a((qj.b) this.f18353b);
        return;
    L117:
        BannerViewPager r117 = (BannerViewPager) this.f18353b;
        if (r117.getAdapter() == null) goto L277;
        r117.getAdapter().notifyDataSetChanged();
        return;
    L277:
        return;
    L121:
        pg.a r118 = (pg.a) this.f18353b;
        boolean r44 = r118.g.f21352c.f5319a;
        j r45 = r118.g.f21352c;
        StringBuilder r46 = new StringBuilder();
        j r47 = r118.g.f21352c;
        sg.a r48 = sg.a.b(ug.a.b());
        String r49 = r118.f;
        SharedPreferences r50 = (SharedPreferences) r48.f21902a;
        if (r50 != null) goto L124;
        String r51 = "";
    L126:
        if (TextUtils.isEmpty(r51) == true) goto L128;
        r46.append("&ctx_infos=");
        r46.append(r51);
    L128:
        String r52 = r46.toString();
        if (r44 == false) goto L278;
        System.currentTimeMillis();
        boolean r53 = true;
        r118.f21346h = true;
        if (TextUtils.isEmpty(r52) == true) goto L136;
        SettingsRequestModel r54 = new SettingsRequestModel();
        r54.urlParams = r52;
        if (r52.contains("pull_task_data") == false) goto L135;
        r54.isReturnCtxInfo = false;
    L137:
        j r55 = r118.g.f21352c;
        if (r53 == false) goto L140;
        qg.b r56 = null;
    L141:
        if (r56 != null) goto L143;
    L188:
        pg.a.f21341j.put(r118.f, Long.valueOf(System.currentTimeMillis()));
        pg.a.f21342k.put(r118.f, Boolean.FALSE);
        r118.f21346h = false;
        return;
    L143:
        if (r56.f21508a == false) goto L188;
        qg.c r57 = r56.f21509b;
        if (r57 == null) goto L163;
        com.bytedance.android.monitorV2.lynx.impl.a r58 = r118.d;
        pg.d r59 = r118.g;
        boolean r60 = ((Boolean) pg.a.f21342k.get(r118.f)).booleanValue();
        monitor-enter(r58);
        Iterator r61 = r58.f3652a.values().iterator();     // Catch: Throwable -> L152
    L150:
        if (r61.hasNext() == false) goto L154;
        ((ISettings) r61.next()).updateSettings(r57);     // Catch: Throwable -> L152
        goto L150
    L154:
        Context r62 = ug.a.b();     // Catch: Throwable -> L152
        ug.e r63 = ug.e.c(r62);     // Catch: Throwable -> L152
        String r64 = r57.f21513c;     // Catch: Throwable -> L152
        String r65 = (String) r59.f21352c.f5320b;     // Catch: Throwable -> L152
        SharedPreferences.Editor r66 = ((SharedPreferences) r63.f22361b).edit();     // Catch: Throwable -> L152
        if (TextUtils.isEmpty(r65) == false) goto L157;
        String r67 = "key_latest_update_token";
    L158:
        r66.putString(r67, r64).apply();     // Catch: Throwable -> L152
        ug.d.f(r62).i(r57, r59, r60);     // Catch: Throwable -> L152
        monitor-exit(r58);
        goto L163
    L157:
        r67 = td.d.b("key_latest_update_token_", r65);     // Catch: Throwable -> L152
    L152:
        th = move-exception;
        throw th;
    L163:
        sg.a r68 = sg.a.b(ug.a.b());
        String r69 = r118.f;
        String r70 = r56.f21510c;
        monitor-enter(r68);
        ((SharedPreferences) r68.f21902a).edit().putString("key_ctx_info_" + r69, r70).apply();     // Catch: Throwable -> L185
        monitor-exit(r68);
        sg.a r71 = sg.a.b(ug.a.b());
        String r72 = r118.f;
        long r73 = r56.d;
        monitor-enter(r71);
        ((SharedPreferences) r71.f21902a).edit().putLong("key_settings_time_" + r72, r73).apply();     // Catch: Throwable -> L182
        monitor-exit(r71);
        qg.c r74 = ug.d.f(ug.a.b()).e((String) r118.g.f21352c.f5320b);
        if (r74 == null) goto L188;
        Iterator r75 = r118.f21345c.entrySet().iterator();
    L175:
        if (r75.hasNext() == false) goto L188;
        Map.Entry r76 = (Map.Entry) r75.next();
        if (r76 == null) goto L175;
        if (((Boolean) r76.getValue()).booleanValue() == true) goto L180;
        ((f) r76.getKey()).a(r74);
        goto L175
    L180:
        r118.f21344b.post(new v(24, r76, false, r74));
    L182:
        th = move-exception;
        throw th;
    L185:
        th = move-exception;
        throw th;
    L140:
        r56 = r118.g.f21351b.a();
        goto L141
    L135:
        r54.isReturnCtxInfo = true;
    L136:
        r53 = false;
        goto L137
    L278:
        return;
    L124:
        r51 = r50.getString("key_ctx_info_" + r49, "");
        goto L126
    L190:
        ug.d r119 = (ug.d) this.f18353b;
        if (((AtomicBoolean) r119.f22358c).getAndSet(false) == false) goto L279;
        Logger.d("WsChannelSdk_ok", "Compensate for ping timeout, prepare to reconnect");
        k r120 = (k) r119.e;
        if (r120 == null) goto L280;
        ((j8.e) r120.f21937a).i();
        return;
    L280:
        return;
    L279:
        return;
    L196:
        ((FutureTask) this.f18353b).run();
        return;
    L198:
        LynxEngineProxy r121 = (LynxEngineProxy) this.f18353b;
        LynxEngineProxy.a(r121, r121.f10828a);
        r121.f10828a = 0;
        return;
    L200:
        Application r122 = (Application) this.f18353b;
        r122.startService(new Intent(r122, WsChannelService.class));     // Catch: Throwable -> L203
        return;
    L203:
        th = move-exception;
        th.printStackTrace();
        return;
    L219:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaX", "Mark main thread runnable run on main thread.");
        ((AnimaX) this.f18353b).d();
        return;
    L229:
        ((Runnable) ((LinkedTransferQueue) ((g8.g) this.f18353b).f17073b).take()).run();     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L229
    L231:
        ((w7.a) this.f18353b).run();     // Catch: Throwable -> L85
        return;
    L85:
        th = move-exception;
        io.reactivex.exceptions.a.n("APM-AsyncTask", "thread " + Thread.currentThread().getName() + " exception", th);
        return;
    L79:
        if (((h0) this.f18353b).f1510a == true) goto L274;
        io.reactivex.exceptions.a.i("oldAnr start");
        new b9.a(this).start();
        return;
    L274:
        return;
    L207:
        if (((u) this.f18353b).f19596c.isEmpty() == true) goto L213;
        if (((u) this.f18353b).d == null) goto L207;
        ((u) this.f18353b).d.sendMessageAtFrontOfQueue((Message) ((u) this.f18353b).f19596c.poll());     // Catch: Throwable -> L221
    L213:
        if (((u) this.f18353b).f19595b.isEmpty() == true) goto L218;
        t r77 = (t) ((u) this.f18353b).f19595b.poll();
        if (((u) this.f18353b).d == null) goto L213;
        ((u) this.f18353b).d.sendMessageAtTime(r77.f19592a, r77.f19593b);     // Catch: Throwable -> L222
        goto L213
    }

    public /* synthetic */ a(Object r5, int r10) {
        this.f18352a = r10;
        this.f18353b = r5;
    }

    public a(r6.a r5, String r10, String r11, JSONObject r12) {
        this.f18352a = 9;
        this.f18353b = r5;
    }
}
