package com.bytedance.android.btm.impl;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.tool.BtmDebugTool;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.HybridContainerFinder;
import com.bytedance.android.btm.impl.page.PageWoods;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer1_outer.NativeStateWriter;
import com.bytedance.android.btm.impl.page.lifecycle.layer2.FilterDispatcher;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.pageshow.EnterPageLog;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.startnode.StartNodeManager;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import java.util.Map;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RegisterBtmPageHelper {
    public static final String a = "RegisterBtmPageHelper_handleViewV2";
    public static final String b = "RegisterBtmPageHelper_handleV2core";

    public RegisterBtmPageHelper() {
    }

    static {
        a = "RegisterBtmPageHelper_handleViewV2";
        b = "RegisterBtmPageHelper_handleV2core";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.android.btm.impl.page.model.d] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.bytedance.android.btm.impl.page.model.PageInfo] */
    public static void c(Object r15, String r16, ResumeFilterReason r17) {
        int r0 = f.a[r17.ordinal()];
        xc.a r10 = null;
        if (r0 != 1) goto L5;
    L16:
        String r1 = BtmPageRecorder.a;
        PageInfoStack r11 = BtmPageRecorder.k(r15);
        if (r11 == null) goto L27;
        PageInfo r12 = r11.current();
        if (r12 == null) goto L28;
        h r13 = PageWoods.a(r15);
        if (r13 == null) goto L24;
        r10 = r13.l(r15);
    L24:
        ?? r14 = r10;
        boolean r18 = BtmPageLifecycleCallbackV2.a;
        ResumeFuncOrigin r19 = ResumeFuncOrigin.HybridRegister;
        BtmPageLifecycleCallbackV2.g(r15, r11, r12, r14, r13, r19);
        r12.onlyResume(r19);
        EnterPageLog r20 = EnterPageLog.a;
        EnterPageLog.c(r12, r19);
        return;
    L28:
        return;
    L27:
        return;
    L5:
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L16;
        if (r0 == 4) goto L16;
        if (r0 == 5) goto L16;
        String r21 = BtmPageRecorder.a;
        PageInfo r22 = BtmPageRecorder.j(r15);
        if (r22 == null) goto L15;
        r10 = r22.copy();
    L15:
        BtmMonitor.k(BtmMonitor.c, 1120, "btm = " + r16 + ", reason = " + r17, r15, r10, false, false, null, false, null, null, 1008);
    }

    public static void a(Object r19, final String r20, String r21, String r22) {
        final String r10 = r19.getClass().getName();
        String r0 = BtmPageRecorder.a;
        PageInfoStack r1 = BtmPageRecorder.k(r19);
        ALogger r11 = ALogger.d;
        String r12 = b;
        ALogger.m(r11, r12, new RegisterBtmPageHelper$handleV2Core$1(r10, r20));
        if (r1 == null) goto L27;
        PageInfo r13 = r1.current();
        d(r19, r20, r13, r22);
        if (r1.isContainer() == true) goto L7;
        return;
    L7:
        String r14 = r13.getPageBtm();
        if (r14 != null) goto L10;
    L13:
        boolean r15 = true;
    L14:
        if (r15 == false) goto L20;
        ALogger.m(r11, r12, RegisterBtmPageHelper$handleV2Core$2.INSTANCE);
        r13.parsePageBtm(r20);
        if (BtmSetting.d.c().b().O() == 1) goto L18;
    L19:
        EnterPageLog r16 = EnterPageLog.a;
        EnterPageLog.c(r13, ResumeFuncOrigin.HybridRegister);
        return;
    L18:
        if (r1.getPageState() == BtmPageLifecycle.State.RESUMED) goto L19;
        return;
    L20:
        Lazy r17 = BtmFormatUtils.a;
        if (BtmFormatUtils.f(r13.getPageBtm(), r20) == true) goto L26;
        String r18 = HybridContainerFinder.a;
        if (HybridContainerFinder.b(r19) == true) goto L25;
        Lazy r23 = BtmMonitor.a;
        BtmMonitor.j(2011, r13, null, null, new RegisterBtmPageHelper$handleV2Core$3(r20), null, 188);
    L25:
        PageInfoStack.onFEJump$default(r1, r19, r20, false, null, 12, null);
        return;
    L26:
        ALogger.m(r11, r12, new RegisterBtmPageHelper$handleV2Core$4(r20));
        return;
    L10:
        if (r14.length() == 0) goto L13;
        r15 = false;
        goto L14
    L27:
        com.bytedance.android.btm.impl.page.model.c r24 = BtmPageRecorder.h(r19);
        if (r24 == null) goto L34;
        long r25 = r24.a;
        final long r26 = SystemClock.elapsedRealtime() - r25;
        final BtmPageLifecycle.State r27 = r24.b;
        if (r26 <= BtmSetting.d.c().c().s()) goto L32;
    L33:
        g$a.a(BtmMonitor.c, 2015, null, r19, new RegisterBtmPageHelper$handleV2Core$5(r26, r27, r20), 26);
        goto L34
    L32:
        if (r27 != BtmPageLifecycle.State.RESUMED) goto L33;
    L34:
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.k(r19, r20, r21);
        BtmSetting r28 = BtmSetting.d;
        if (r28.c().b().C() != 1) goto L37;
        NativeStateWriter.e(r19);
    L37:
        String r29 = FilterDispatcher.a;
        final ResumeFilterReason r30 = FilterDispatcher.e(r19, ResumeFuncOrigin.HybridRegister);
        int r31 = r28.c().b().y();
        if (r31 != 1) goto L40;
        if (r30 != null) goto L47;
        StartNodeManager.d(r19, true);
    L47:
        ALogger.m(r11, r12, new RegisterBtmPageHelper$handleV2Core$6(r10, r20, r30));
        return;
    L40:
        if (r31 == 2) goto L42;
        StartNodeManager.d(r19, true);
        goto L47
    L42:
        if (r30 != null) goto L44;
        StartNodeManager.d(r19, true);
        goto L47
    L44:
        c(r19, r20, r30);
        goto L47
    }

    public static boolean b(View r16, final String r17, final String r18, Map r19) {
        final String r10 = r16.getClass().getName();
        Object r11 = HybridContainerFinder.c.a(r16);
        ALogger.m(ALogger.d, a, new RegisterBtmPageHelper$handleView$1(r17, r18, r10));
        boolean r12 = true;
        if (BtmHostDependManager.F.c() == false) goto L35;
        String r13 = BtmPageRecorder.a;
        PageInfo r14 = BtmPageRecorder.j(r11);
        if (r14 == null) goto L7;
        String r15 = r14.getPageBtm();
    L8:
        if (r15 != null) goto L10;
    L13:
        boolean r110 = true;
    L14:
        if (r110 == true) goto L35;
        Lazy r111 = BtmDebugTool.a;
        JSONObject r112 = new JSONObject();
        r112.put("pageType", "Register");     // Catch: Throwable -> L91
        if (r18 != null) goto L19;
    L22:
        boolean r113 = true;
    L23:
        if (r113 == true) goto L25;
        r112.put("source_btm_token", r18);     // Catch: Throwable -> L91
    L25:
        if (r14 == null) goto L27;
        String r20 = r14.getPageBtm();     // Catch: Throwable -> L91
    L28:
        r112.put("page_btm", r20);     // Catch: Throwable -> L91
        r112.put("isHybridContainer", "1");     // Catch: Throwable -> L91
        r112.put("btm", r17);     // Catch: Throwable -> L91
        r112.put("btmOriginPage", r16.toString());     // Catch: Throwable -> L91
        if (r11 == null) goto L31;
        String r21 = r11.toString();     // Catch: Throwable -> L91
    L32:
        r112.put("finalPage", r21);     // Catch: Throwable -> L91
        r112.put("finalPageOriginBtm", r17);     // Catch: Throwable -> L91
        goto L33
    L31:
        r21 = null;
        goto L32
    L27:
        r20 = null;
        goto L28
    L19:
        if (r18.length() == 0) goto L22;
        r113 = false;
    L33:
        BtmDebugTool.c(r112);
        goto L35
    L10:
        if (r15.length() == 0) goto L13;
        r110 = false;
        goto L14
    L7:
        r15 = null;
    L35:
        if (r17.length() != 0) goto L37;
        boolean r22 = true;
    L39:
        if (r22 == false) goto L57;
        ALogger.m(ALogger.d, a, RegisterBtmPageHelper$handleView$3.INSTANCE);
        if (BtmHostDependManager.F.c() == false) goto L56;
        String r0 = BtmPageRecorder.a;
        PageInfo r1 = BtmPageRecorder.j(r11);
        Lazy r23 = BtmDebugTool.a;
        JSONObject r24 = new JSONObject();
        r24.put("pageType", "CreateOrConsumption");     // Catch: Throwable -> L92
        r24.put("type", "consume");     // Catch: Throwable -> L92
        if (r18 != null) goto L46;
    L49:
        if (r12 == true) goto L51;
        r24.put("source_btm_token", r18);     // Catch: Throwable -> L92
    L51:
        if (r1 == null) goto L53;
        String r25 = r1.getPageBtm();     // Catch: Throwable -> L92
    L54:
        r24.put("page_btm", r25);     // Catch: Throwable -> L92
        r24.put("success", 0);     // Catch: Throwable -> L92
        r24.put("reason", "consume_6");     // Catch: Throwable -> L92
        goto L55
    L53:
        r25 = null;
        goto L54
    L46:
        if (r18.length() == 0) goto L49;
        r12 = false;
    L55:
        BtmDebugTool.c(r24);
    L56:
        return false;
    L57:
        if (r18 != null) goto L59;
    L62:
        boolean r26 = true;
    L63:
        if (r26 == true) goto L65;
    L69:
        if (r11 == null) goto L76;
        a(r11, r17, r18, r10);
        if (r19 != null) goto L73;
    L75:
        return true;
    L73:
        if ((!r19.isEmpty()) == false) goto L75;
        b.a.setPageEventParams(PageFinder.via(r11), r19);
        goto L75
    L76:
        ALogger.m(ALogger.d, a, RegisterBtmPageHelper$handleView$6.INSTANCE);
        if (BtmHostDependManager.F.c() == false) goto L103;
        Lazy r27 = BtmDebugTool.a;
        JSONObject r28 = new JSONObject();
        r28.put("pageType", "CreateOrConsumption");     // Catch: Throwable -> L94
        r28.put("type", "consume");     // Catch: Throwable -> L94
        r28.put("page_btm", r17);     // Catch: Throwable -> L94
        if (r18 != null) goto L82;
    L85:
        if (r12 == true) goto L87;
        r28.put("source_btm_token", r18);     // Catch: Throwable -> L94
    L87:
        r28.put("success", 0);     // Catch: Throwable -> L94
        r28.put("reason", "consume_7");     // Catch: Throwable -> L94
        goto L88
    L82:
        if (r18.length() == 0) goto L85;
        r12 = false;
    L88:
        BtmDebugTool.c(r28);
        return false;
    L103:
        return false;
    L65:
        if (BtmHostDependManager.F.c() == false) goto L69;
        Lazy r29 = BtmDebugTool.a;
        JSONObject r30 = new JSONObject();
        r30.put("pageType", "CreateOrConsumption");     // Catch: Throwable -> L93
        r30.put("type", "consume");     // Catch: Throwable -> L93
        r30.put("page_btm", r17);     // Catch: Throwable -> L93
        r30.put("success", 0);     // Catch: Throwable -> L93
        r30.put("reason", "consume_1");     // Catch: Throwable -> L93
    L68:
        BtmDebugTool.c(r30);
        goto L69
    L59:
        if (r18.length() == 0) goto L62;
        r26 = false;
        goto L63
    L37:
        r22 = false;
        goto L39
    }

    public static void d(final Object r10, final String r11, final PageInfo r12, final String r13) {
        if (BtmSetting.d.c().c().c().contains(BtmFormatUtils.c(r11)) == false) goto L5;
        return;
    L5:
        g$a.a(BtmMonitor.c, 2316, null, null, new RegisterBtmPageHelper$pageRepeatRegisterMonitor$1(r13, r10, r12, r11), 30);
    }
}
