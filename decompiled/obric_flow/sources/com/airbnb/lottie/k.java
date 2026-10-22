package com.airbnb.lottie;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipInputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1277c;
    public final Object d;

    public /* synthetic */ k(Context r5, String r10, Object r11, int r12) {
        this.f1275a = r12;
        this.d = r5;
        this.f1276b = r10;
        this.f1277c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object r5 = null;
        switch(this.f1275a) {
            case 0: goto L82;
            case 1: goto L61;
            case 2: goto L54;
            case 3: goto L52;
            case 4: goto L35;
            case 5: goto L34;
            default: goto L4;
        };
    L4:
        Log.d("scc_sdk", "already send cloud service request, will wait for response");
        String r10 = (String) this.f1276b;
        if (vf.a.f22573c != null) goto L7;
        vf.a.f22573c = new com.bytedance.ies.bullet.service.base.c(17);
    L7:
        vf.a.f22573c.getClass();
        bi.e r11 = new bi.e("https://scc.bytedance.com/scc_sdk/url_scan_v4?scc_mode=coreless&scc_from=Bullet&scc_sdk_version=30", 5);
        r11.e = "POST";
        HashMap r12 = new HashMap();
        r11.d = r12;
        r12.put("Content-Type", "application/json");
        String r13 = (String) this.f1277c;
        JSONObject r14 = new JSONObject();
        r14.put("ts", System.currentTimeMillis());     // Catch: Exception -> L13
        r14.put("url", r10);     // Catch: Exception -> L13
        r14.put("sign", "");     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r13) == false) goto L11;
        r13 = "common";
    L11:
        r14.put("scene", r13);     // Catch: Exception -> L13
    L14:
        r11.f = r14.toString();
        r11.f930b = 5000;
        long r15 = SystemClock.uptimeMillis();
        com.bytedance.salamander.anniex.n r16 = vf.a.a().a(r11);
        ug.d r17 = (ug.d) this.d;
        r17.getClass();
        yf.b r18 = (yf.b) ((ConcurrentHashMap) r17.g).get(com.lynx.tasm.behavior.ui.utils.p.h(r10));
        if (r18 == null) goto L20;
        int r19 = r16.f7268b;
        long r20 = SystemClock.uptimeMillis() - r18.f23256c;
        ConcurrentHashMap r110 = r18.f23254a;
        r110.put("scc_cloudservice_check_delta", r20 + "");
        r110.put("scc_cloudservice_ttnet_code", r19 + "");
        r110.put("scc_cloudservice_backend_code", "-1");
        if (TextUtils.isEmpty("error") == true) goto L19;
        r110.put("scc_cloudservice_label", "error");
    L19:
        r110.put("scc_cloudservice_result", "{}");
    L20:
        long r21 = SystemClock.uptimeMillis() - r15;
        Log.e("scc_sdk", "cloud service response is error:" + r16);
        HashMap r22 = new HashMap();
        r22.put("scc_passed_time", r21 + "");
        r22.put("scc_logid", "");
        r22.put("scc_trace_id", "");
        monitor-enter(vf.a.class);
    L26:
        th = move-exception;
        throw th;
    L23:
        if (vf.a.f22572b != null) goto L28;
        monitor-exit(vf.a.class);     // Catch: Throwable -> L26
    L30:
        return null;
    L28:
        com.bytedance.ies.bullet.web.scc.a.a("scc_cloudservice_result", r22);     // Catch: Throwable -> L26
        monitor-exit(vf.a.class);     // Catch: Throwable -> L26
    L13:
        Log.e("scc_sdk", "CSRequestParams fail!");
        goto L14
    L35:
        tc.c r23 = tc.c.f22119c;
        tc.c r24 = tc.c.f22119c;
        com.bytedance.ies.bullet.core.e r25 = LynxBridgeModule.access$getBulletContext$p((LynxBridgeModule) this.d);
        if (r25 == null) goto L39;
        String r26 = r25.f;
        if (r26 == null) goto L39;
    L40:
        com.bytedance.ies.bullet.service.base.i r27 = (com.bytedance.ies.bullet.service.base.i) r24.a(com.bytedance.ies.bullet.service.base.i.class, r26);
        if (r27 == null) goto L106;
        LynxBridgeModule r28 = (LynxBridgeModule) this.d;
        com.bytedance.ies.bullet.core.kit.bridge.c r29 = (com.bytedance.ies.bullet.core.kit.bridge.c) this.f1277c;
        String r111 = (String) this.f1276b;
        com.bytedance.ies.bullet.service.base.x r30 = new com.bytedance.ies.bullet.service.base.x("bdx_monitor_bridge_duration");
        com.bytedance.ies.bullet.core.e r31 = LynxBridgeModule.access$getBulletContext$p(r28);
        if (r31 == null) goto L45;
        r5 = r31.f5303q;
    L45:
        r30.f6027j = r5;
        r30.f = r29.b();
        JSONObject r32 = new JSONObject();
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L48
        Result.m124constructorimpl(r32.put("method_name", r111));     // Catch: Throwable -> L48
    L50:
        r30.e = r32;
        r30.f6024c = "lynx";
        r30.f6026i = Boolean.TRUE;
        ((com.bytedance.ies.bullet.service.monitor.i) r27).d(r30);
        return r27;
    L48:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L50
    L106:
        return null;
    L39:
        r26 = "default_bid";
        goto L40
    L52:
        byte[] r35 = (byte[]) this.f1277c;
        ((com.bytedance.ies.bullet.lynx.h) this.d).g((String) this.f1276b, r35);
        return Unit.INSTANCE;
    L54:
        Activity r36 = ug.a.a((Context) this.d);
        Scenes r37 = (Scenes) this.f1277c;
        String r112 = (String) this.f1276b;
        if (r36 == null) goto L57;
        boolean r38 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, r112, "Callee " + r36.getComponentName().toShortString() + ": " + r36.hashCode() + " on " + r37.f5286a, "XView");
        r5 = Unit.INSTANCE;
    L57:
        if (r5 != null) goto L60;
        boolean r39 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, r112, "Callee unknown on ".concat(r37.f5286a), "XView");
    L60:
        return Unit.INSTANCE;
    L61:
        com.bytedance.android.anniex.worker.b r40 = com.bytedance.android.anniex.worker.b.f3505a;
        Uri r41 = Uri.parse((String) this.f1276b);
        Intrinsics.checkNotNullParameter(r41, "<this>");
        if (Intrinsics.areEqual(r41.getScheme(), "http") == false) goto L64;
    L71:
        String r42 = r41.toString();
    L72:
        String r43 = String.valueOf(r42);
        Intrinsics.checkNotNullParameter(r43, "url");
        String r44 = Uri.parse(r43).buildUpon().clearQuery().build().toString();
        KitType r45 = KitType.f6012c;
        KitType r46 = (KitType) this.d;
        if (r46 != r45) goto L76;
        String r47 = "web";
    L78:
        HashMap r48 = new HashMap();
        r48.put("current_page_url", r44);
        r48.put("engine_type", r47);
        r48.put("bid", (String) this.f1277c);
        com.bytedance.ies.xbridge.event.a r113 = new com.bytedance.ies.xbridge.event.a("page_first_visiable", System.currentTimeMillis());
        r113.f6325c = r48;
        com.bytedance.ies.xbridge.event.b.a(r113);
        com.bytedance.android.anniex.worker.b.d("page_first_visiable", r48);
    L81:
        return Unit.INSTANCE;
    L76:
        if (r46 != KitType.d) goto L79;
        r47 = "lynx";
        goto L78
    L79:
        int r114 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AnnieXJSWorkerManager", "kit_type:" + r46 + " can not be identified!", null, 12);
        goto L81
    L64:
        if (Intrinsics.areEqual(r41.getScheme(), IIvyAIPackageResourceService.SCHEMA) == true) goto L71;
        r42 = io.reactivex.exceptions.a.h(r41, "a_surl");
        if (r42 != null) goto L72;
        r42 = io.reactivex.exceptions.a.h(r41, "surl");
        if (r42 != null) goto L72;
        r42 = io.reactivex.exceptions.a.h(r41, "url");
        goto L72
    L82:
        String r49 = (String) this.f1276b;
        boolean r50 = r49.endsWith(".zip");     // Catch: IOException -> L92
        Context r51 = (Context) this.d;
        String r115 = (String) this.f1277c;
        if (r50 == false) goto L108;
        ZipInputStream r52 = new ZipInputStream(r51.getAssets().open(r49));     // Catch: IOException -> L92
        a0 r116 = n.d(r52, r115);     // Catch: Throwable -> L89
        u.f.b(r52);     // Catch: IOException -> L92
        return r116;
    L89:
        th = move-exception;
        u.f.b(r52);     // Catch: IOException -> L92
        throw th;     // Catch: IOException -> L92
    L108:
        return n.b(r51.getAssets().open(r49), r115);
    L92:
        e = move-exception;
        return new a0(e);
    L34:
        return ((com.google.common.cache.g) this.f1277c).f8716a.reload(this.d, this.f1276b).get();
    }

    public k(KitType r5, String r10, String r11) {
        this.f1275a = 1;
        this.f1276b = r10;
        this.d = r5;
        this.f1277c = r11;
    }

    public /* synthetic */ k(Object r5, Object r10, String r11, int r12) {
        this.f1275a = r12;
        this.d = r5;
        this.f1277c = r10;
        this.f1276b = r11;
    }

    public k(String r5, String r10, ug.d r11) {
        this.f1275a = 6;
        this.f1276b = r5;
        this.f1277c = r10;
        this.d = r11;
    }

    public k(com.google.common.cache.g r5, Object r10, Object r11) {
        this.f1275a = 5;
        this.f1277c = r5;
        this.d = r10;
        this.f1276b = r11;
    }
}
