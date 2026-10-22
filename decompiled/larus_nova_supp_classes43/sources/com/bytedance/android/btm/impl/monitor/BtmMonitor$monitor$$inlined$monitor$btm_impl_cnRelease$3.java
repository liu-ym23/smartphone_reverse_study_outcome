package com.bytedance.android.btm.impl.monitor;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.chain.BtmChainRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.setting.i;
import com.bytedance.android.btm.impl.setting.j;
import com.bytedance.android.btm.impl.setting.k;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import zc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmMonitor$monitor$$inlined$monitor$btm_impl_cnRelease$3 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ PageInfo b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ Throwable i;

    public BtmMonitor$monitor$$inlined$monitor$btm_impl_cnRelease$3(boolean r1, PageInfo r10, Object r11, int r12, Function1 r13, String r14, Function0 r15, boolean r16, Throwable r17) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
    }

    public final void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L93
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L93
        String r10 = null;
        PageInfo r11 = this.b;     // Catch: Throwable -> L96
        if (r11 == null) goto L9;
        String r12 = r11.getClassName();     // Catch: Throwable -> L96
        if (r12 == null) goto L9;
    L13:
        r1.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r12);     // Catch: Throwable -> L96
        r1.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, this.d);     // Catch: Throwable -> L96
        PageInfo r13 = this.b;     // Catch: Throwable -> L96
        if (r13 == null) goto L16;
        Integer r14 = Integer.valueOf(r13.getStep());     // Catch: Throwable -> L96
    L17:
        r1.put("step", r14);     // Catch: Throwable -> L96
        PageInfo r15 = this.b;     // Catch: Throwable -> L96
        if (r15 == null) goto L22;
        String r16 = r15.getPageBtm();     // Catch: Throwable -> L96
        if (r16 == null) goto L22;
    L23:
        r1.put("btm_page", r16);     // Catch: Throwable -> L96
        Lazy r17 = BtmFormatUtils.a;     // Catch: Throwable -> L96
        PageInfo r18 = this.b;     // Catch: Throwable -> L96
        if (r18 == null) goto L26;
        String r19 = r18.getBtmPre();     // Catch: Throwable -> L96
    L27:
        r1.put("btm_pre_page", BtmFormatUtils.b(r19));     // Catch: Throwable -> L96
        PageInfo r20 = this.b;     // Catch: Throwable -> L96
        if (r20 == null) goto L30;
        String r21 = r20.getBtmPre();     // Catch: Throwable -> L96
    L31:
        r1.put("btm_pre", BtmFormatUtils.g(r21));     // Catch: Throwable -> L96
        goto L32
    L30:
        r21 = null;
        goto L31
    L26:
        r19 = null;
    L22:
        r16 = "null";
        goto L23
    L16:
        r14 = null;
    L9:
        Object r22 = this.c;     // Catch: Throwable -> L96
        if (r22 == null) goto L12;
        r12 = r22.getClass().getCanonicalName();     // Catch: Throwable -> L96
        goto L13
    L12:
        r12 = null;
    L32:
        this.e.invoke(r1);     // Catch: Throwable -> L93
        JSONObject r23 = new JSONObject();     // Catch: Throwable -> L93
        r23.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, this.f);     // Catch: Throwable -> L97
        r23.put("lazy_msg", String.valueOf(this.g.invoke()));     // Catch: Throwable -> L97
        if (this.h == false) goto L36;
        r23.put("page_list", BtmMonitor.e());     // Catch: Throwable -> L97
    L36:
        BtmChainRecorder r24 = com.bytedance.android.btm.impl.b.e.c();     // Catch: Throwable -> L97
        PageInfo r25 = this.b;     // Catch: Throwable -> L97
        if (r25 == null) goto L39;
        r10 = r25.getBtmPre();     // Catch: Throwable -> L97
    L39:
        r23.put("btm_chain", r24.a(r10, 10));     // Catch: Throwable -> L97
    L40:
        Lazy r26 = BtmMonitor.a;     // Catch: Throwable -> L93
        BtmMonitor.f(this.i, r1, r23);     // Catch: Throwable -> L93
        Triple r27 = new Triple(Integer.valueOf(this.d), r1, r23);     // Catch: Throwable -> L93
        int r28 = ((Number) r27.component1()).intValue();     // Catch: Throwable -> L93
        final JSONObject r29 = (JSONObject) r27.component2();     // Catch: Throwable -> L93
        final JSONObject r30 = (JSONObject) r27.component3();     // Catch: Throwable -> L93
        j r31 = BtmSetting.d.c().d().i();     // Catch: Throwable -> L93
        String r32 = "";
        if (r31.e() == 1) goto L44;
    L80:
        g r33 = BtmHostDependManager.F.f();     // Catch: Throwable -> L93
        if (r33 == null) goto L100;
        r33.a("btmsdk_monitor", r29, r30);     // Catch: Throwable -> L93
    L100:
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L88
        String r35 = r29.optString("btm");     // Catch: Throwable -> L88
        if (r35 == null) goto L86;
        r32 = r35;
    L86:
        JSONObject r36 = new JSONObject();     // Catch: Throwable -> L88
        r36.put(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r29);     // Catch: Throwable -> L88
        r36.put("extraLog", r30);     // Catch: Throwable -> L88
        com.bytedance.android.btm.impl.quality.b.b(r28, r32, r36);     // Catch: Throwable -> L88
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L88
    L90:
        HashMap<Integer, Integer> r37 = b.b;     // Catch: Throwable -> L93
        b.b(r28, "BtmSDK_Monitor_" + r28);     // Catch: Throwable -> L93
        ALogger.i(ALogger.d, String.valueOf(r28), this.a, new AnonymousClass2(r29, r30), 4);     // Catch: Throwable -> L93
    L91:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L93
        return;
    L88:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L93
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L93
        goto L90
    L44:
        if (r31.d().containsKey(Integer.valueOf(r28)) == false) goto L80;
        i r39 = (i) r31.d().get(Integer.valueOf(r28));     // Catch: Throwable -> L93
        if (r39 != null) goto L49;
        r39 = r31.a();     // Catch: Throwable -> L93
    L49:
        k r110 = BtmMonitor.d(r39, r29);     // Catch: Throwable -> L93
        if (r110.a() >= 2) goto L52;
    L53:
        g r111 = BtmHostDependManager.F.f();     // Catch: Throwable -> L93
        if (r111 == null) goto L57;
        r111.a("btmsdk_monitor", r29, r30);     // Catch: Throwable -> L93
    L57:
        if (r39.b() != 1) goto L75;
        String r40 = r29.optString("btm");     // Catch: Throwable -> L93
        if (r40 == null) goto L61;
        r32 = r40;
    L61:
        LinkedHashMap r41 = new LinkedHashMap();     // Catch: Throwable -> L93
        Iterator<String> r42 = r29.keys();     // Catch: Throwable -> L93
    L63:
        if (r42.hasNext() == false) goto L65;
        String r112 = r42.next();     // Catch: Throwable -> L93
        r41.put(r112, r29.opt(r112));     // Catch: Throwable -> L93
        goto L63
    L65:
        if (r30 == null) goto L70;
        Iterator<String> r43 = r30.keys();     // Catch: Throwable -> L93
    L68:
        if (r43.hasNext() == false) goto L70;
        String r113 = r43.next();     // Catch: Throwable -> L93
        r41.put(r113, r30.opt(r113));     // Catch: Throwable -> L93
    L70:
        r41.put("error_code_level", Integer.valueOf(r110.a()));     // Catch: Throwable -> L93
        r41.put("error_code_sdk_error", Integer.valueOf(r39.d()));     // Catch: Throwable -> L93
        if (r39.a().size() <= 1) goto L73;
        r41.put("error_code_param", r110.b());     // Catch: Throwable -> L93
        r41.put("error_code_value", r110.c());     // Catch: Throwable -> L93
    L73:
        com.bytedance.android.btm.impl.quality.b.a(r28, r32, r41);     // Catch: Throwable -> L93
    L75:
        if (r39.c() == 1) goto L77;
    L79:
        ALogger.d.h(String.valueOf(r28), this.a, Integer.valueOf(r110.a()), new AnonymousClass1(r29, r30));     // Catch: Throwable -> L93
        goto L91
    L77:
        if (r31.b() != 1) goto L79;
        HashMap<Integer, Integer> r44 = b.b;     // Catch: Throwable -> L93
        b.a(r28, "BtmSDK_Monitor_" + r28);     // Catch: Throwable -> L93
        goto L79
    L52:
        if (r31.c() == 0) goto L57;
    L93:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
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
