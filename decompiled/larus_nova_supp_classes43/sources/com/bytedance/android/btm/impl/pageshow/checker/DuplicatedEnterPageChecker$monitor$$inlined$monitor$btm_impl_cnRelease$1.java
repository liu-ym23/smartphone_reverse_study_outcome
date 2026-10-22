package com.bytedance.android.btm.impl.pageshow.checker;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.quality.b;
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
import org.json.JSONObject;
import zc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DuplicatedEnterPageChecker$monitor$$inlined$monitor$btm_impl_cnRelease$1 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ DuplicatedEnterPageChecker$a b;
    public final /* synthetic */ String c;

    public DuplicatedEnterPageChecker$monitor$$inlined$monitor$btm_impl_cnRelease$1(DuplicatedEnterPageChecker$a r10, String r11) {
        this.a = 2501;
        this.b = r10;
        this.c = r11;
    }

    public final void a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L57
        JSONObject r10 = new JSONObject().put(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, this.a).put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, this.b.b);     // Catch: Throwable -> L57
        Lazy r11 = BtmFormatUtils.a;     // Catch: Throwable -> L57
        Triple r12 = new Triple(Integer.valueOf(this.a), r10.put("btm_page", BtmFormatUtils.b(this.b.c)).put("btm", BtmFormatUtils.e(this.b.a)).put("event_name", this.c), null);     // Catch: Throwable -> L57
        int r13 = ((Number) r12.component1()).intValue();     // Catch: Throwable -> L57
        final JSONObject r14 = (JSONObject) r12.component2();     // Catch: Throwable -> L57
        final JSONObject r15 = (JSONObject) r12.component3();     // Catch: Throwable -> L57
        j r16 = BtmSetting.d.c().d().i();     // Catch: Throwable -> L57
        String r17 = "";
        if (r16.e() == 1) goto L7;
    L43:
        g r18 = BtmHostDependManager.F.f();     // Catch: Throwable -> L57
        if (r18 == null) goto L46;
        r18.a("btmsdk_monitor", r14, r15);     // Catch: Throwable -> L57
    L46:
        Lazy r19 = BtmMonitor.a;     // Catch: Throwable -> L57
        String r0 = r14.optString("btm");     // Catch: Throwable -> L52
        if (r0 == null) goto L50;
        r17 = r0;
    L50:
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L52
        r20.put(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r14);     // Catch: Throwable -> L52
        r20.put("extraLog", r15);     // Catch: Throwable -> L52
        b.b(r13, r17, r20);     // Catch: Throwable -> L52
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L52
    L54:
        HashMap<Integer, Integer> r21 = com.bytedance.android.btm.impl.monitor.b.b;     // Catch: Throwable -> L57
        com.bytedance.android.btm.impl.monitor.b.b(r13, "BtmSDK_Monitor_" + r13);     // Catch: Throwable -> L57
        ALogger.i(ALogger.d, String.valueOf(r13), true, new AnonymousClass2(r14, r15), 4);     // Catch: Throwable -> L57
    L55:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L57
        return;
    L52:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L57
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L54
    L7:
        if (r16.d().containsKey(Integer.valueOf(r13)) == false) goto L43;
        i r23 = (i) r16.d().get(Integer.valueOf(r13));     // Catch: Throwable -> L57
        if (r23 != null) goto L12;
        r23 = r16.a();     // Catch: Throwable -> L57
    L12:
        k r110 = BtmMonitor.d(r23, r14);     // Catch: Throwable -> L57
        if (r110.a() >= 2) goto L15;
    L16:
        g r111 = BtmHostDependManager.F.f();     // Catch: Throwable -> L57
        if (r111 == null) goto L20;
        r111.a("btmsdk_monitor", r14, r15);     // Catch: Throwable -> L57
    L20:
        if (r23.b() != 1) goto L38;
        String r24 = r14.optString("btm");     // Catch: Throwable -> L57
        if (r24 == null) goto L24;
        r17 = r24;
    L24:
        LinkedHashMap r25 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator<String> r26 = r14.keys();     // Catch: Throwable -> L57
    L26:
        if (r26.hasNext() == false) goto L28;
        String r112 = r26.next();     // Catch: Throwable -> L57
        r25.put(r112, r14.opt(r112));     // Catch: Throwable -> L57
        goto L26
    L28:
        if (r15 == null) goto L33;
        Iterator<String> r27 = r15.keys();     // Catch: Throwable -> L57
    L31:
        if (r27.hasNext() == false) goto L33;
        String r113 = r27.next();     // Catch: Throwable -> L57
        r25.put(r113, r15.opt(r113));     // Catch: Throwable -> L57
    L33:
        r25.put("error_code_level", Integer.valueOf(r110.a()));     // Catch: Throwable -> L57
        r25.put("error_code_sdk_error", Integer.valueOf(r23.d()));     // Catch: Throwable -> L57
        if (r23.a().size() <= 1) goto L36;
        r25.put("error_code_param", r110.b());     // Catch: Throwable -> L57
        r25.put("error_code_value", r110.c());     // Catch: Throwable -> L57
    L36:
        b.a(r13, r17, r25);     // Catch: Throwable -> L57
    L38:
        if (r23.c() == 1) goto L40;
    L42:
        ALogger.d.h(String.valueOf(r13), true, Integer.valueOf(r110.a()), new AnonymousClass1(r14, r15));     // Catch: Throwable -> L57
        goto L55
    L40:
        if (r16.b() != 1) goto L42;
        HashMap<Integer, Integer> r28 = com.bytedance.android.btm.impl.monitor.b.b;     // Catch: Throwable -> L57
        com.bytedance.android.btm.impl.monitor.b.a(r13, "BtmSDK_Monitor_" + r13);     // Catch: Throwable -> L57
        goto L42
    L15:
        if (r16.c() == 0) goto L20;
    L57:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
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
