package com.bytedance.android.btm.impl.monitor;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
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
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;
import zc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmMonitor$monitor$$inlined$monitor$btm_impl_cnRelease$2 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ int b;
    public final /* synthetic */ PageInfo c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ Function0 f;
    public final /* synthetic */ Function2 g;
    public final /* synthetic */ Throwable h;

    public BtmMonitor$monitor$$inlined$monitor$btm_impl_cnRelease$2(boolean r1, int r10, PageInfo r11, String r12, Function1 r13, Function0 r14, Function2 r15, Throwable r16) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
    }

    public final void a() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L79
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L79
        r11.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, this.b);     // Catch: Throwable -> L82
        PageInfo r12 = this.c;     // Catch: Throwable -> L82
        if (r12 == null) goto L9;
        String r13 = r12.getPageBtm();     // Catch: Throwable -> L82
        if (r13 == null) goto L9;
    L10:
        r11.put("btm_page", r13);     // Catch: Throwable -> L82
        r11.put("btm", this.d);     // Catch: Throwable -> L82
        Lazy r14 = BtmFormatUtils.a;     // Catch: Throwable -> L82
        PageInfo r15 = this.c;     // Catch: Throwable -> L82
        String r16 = null;
        if (r15 == null) goto L13;
        String r17 = r15.getBtmPre();     // Catch: Throwable -> L82
    L14:
        r11.put("btm_pre_page", BtmFormatUtils.b(r17));     // Catch: Throwable -> L82
        PageInfo r18 = this.c;     // Catch: Throwable -> L82
        if (r18 == null) goto L17;
        r16 = r18.getBtmPre();     // Catch: Throwable -> L82
    L17:
        r11.put("btm_pre", BtmFormatUtils.g(r16));     // Catch: Throwable -> L82
        goto L18
    L13:
        r17 = null;
    L9:
        r13 = "null";
    L18:
        this.e.invoke(r11);     // Catch: Throwable -> L79
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L79
        r19.put("lazy_msg", String.valueOf(this.f.invoke()));     // Catch: Throwable -> L83
    L20:
        this.g.invoke(r19, "extra");     // Catch: Throwable -> L79
        Lazy r20 = BtmMonitor.a;     // Catch: Throwable -> L79
        BtmMonitor.f(this.h, r11, r19);     // Catch: Throwable -> L79
        PageInfo r21 = this.c;     // Catch: Throwable -> L79
        if (r21 != null) goto L23;
    L25:
        r11.optString("btm_page");     // Catch: Throwable -> L79
    L26:
        Triple r0 = new Triple(Integer.valueOf(this.b), r11, r19);     // Catch: Throwable -> L79
        int r22 = ((Number) r0.component1()).intValue();     // Catch: Throwable -> L79
        final JSONObject r23 = (JSONObject) r0.component2();     // Catch: Throwable -> L79
        final JSONObject r1 = (JSONObject) r0.component3();     // Catch: Throwable -> L79
        j r24 = BtmSetting.d.c().d().i();     // Catch: Throwable -> L79
        String r25 = "";
        if (r24.e() == 1) goto L30;
    L66:
        g r26 = BtmHostDependManager.F.f();     // Catch: Throwable -> L79
        if (r26 == null) goto L84;
        r26.a("btmsdk_monitor", r23, r1);     // Catch: Throwable -> L79
    L84:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L74
        String r28 = r23.optString("btm");     // Catch: Throwable -> L74
        if (r28 == null) goto L72;
        r25 = r28;
    L72:
        JSONObject r29 = new JSONObject();     // Catch: Throwable -> L74
        r29.put(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r23);     // Catch: Throwable -> L74
        r29.put("extraLog", r1);     // Catch: Throwable -> L74
        com.bytedance.android.btm.impl.quality.b.b(r22, r25, r29);     // Catch: Throwable -> L74
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L74
    L76:
        HashMap<Integer, Integer> r30 = b.b;     // Catch: Throwable -> L79
        b.b(r22, "BtmSDK_Monitor_" + r22);     // Catch: Throwable -> L79
        ALogger.i(ALogger.d, String.valueOf(r22), this.a, new AnonymousClass2(r23, r1), 4);     // Catch: Throwable -> L79
    L77:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L79
        return;
    L74:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L79
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L79
        goto L76
    L30:
        if (r24.d().containsKey(Integer.valueOf(r22)) == false) goto L66;
        i r32 = (i) r24.d().get(Integer.valueOf(r22));     // Catch: Throwable -> L79
        if (r32 != null) goto L35;
        r32 = r24.a();     // Catch: Throwable -> L79
    L35:
        k r110 = BtmMonitor.d(r32, r23);     // Catch: Throwable -> L79
        if (r110.a() >= 2) goto L38;
    L39:
        g r111 = BtmHostDependManager.F.f();     // Catch: Throwable -> L79
        if (r111 == null) goto L43;
        r111.a("btmsdk_monitor", r23, r1);     // Catch: Throwable -> L79
    L43:
        if (r32.b() != 1) goto L61;
        String r33 = r23.optString("btm");     // Catch: Throwable -> L79
        if (r33 == null) goto L47;
        r25 = r33;
    L47:
        LinkedHashMap r34 = new LinkedHashMap();     // Catch: Throwable -> L79
        Iterator<String> r35 = r23.keys();     // Catch: Throwable -> L79
    L49:
        if (r35.hasNext() == false) goto L51;
        String r112 = r35.next();     // Catch: Throwable -> L79
        r34.put(r112, r23.opt(r112));     // Catch: Throwable -> L79
        goto L49
    L51:
        if (r1 == null) goto L56;
        Iterator<String> r36 = r1.keys();     // Catch: Throwable -> L79
    L54:
        if (r36.hasNext() == false) goto L56;
        String r113 = r36.next();     // Catch: Throwable -> L79
        r34.put(r113, r1.opt(r113));     // Catch: Throwable -> L79
    L56:
        r34.put("error_code_level", Integer.valueOf(r110.a()));     // Catch: Throwable -> L79
        r34.put("error_code_sdk_error", Integer.valueOf(r32.d()));     // Catch: Throwable -> L79
        if (r32.a().size() <= 1) goto L59;
        r34.put("error_code_param", r110.b());     // Catch: Throwable -> L79
        r34.put("error_code_value", r110.c());     // Catch: Throwable -> L79
    L59:
        com.bytedance.android.btm.impl.quality.b.a(r22, r25, r34);     // Catch: Throwable -> L79
    L61:
        if (r32.c() == 1) goto L63;
    L65:
        ALogger.d.h(String.valueOf(r22), this.a, Integer.valueOf(r110.a()), new AnonymousClass1(r23, r1));     // Catch: Throwable -> L79
        goto L77
    L63:
        if (r24.b() != 1) goto L65;
        HashMap<Integer, Integer> r37 = b.b;     // Catch: Throwable -> L79
        b.a(r22, "BtmSDK_Monitor_" + r22);     // Catch: Throwable -> L79
        goto L65
    L38:
        if (r24.c() == 0) goto L43;
    L23:
        if (r21.getPageBtm() == null) goto L25;
    L79:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
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
