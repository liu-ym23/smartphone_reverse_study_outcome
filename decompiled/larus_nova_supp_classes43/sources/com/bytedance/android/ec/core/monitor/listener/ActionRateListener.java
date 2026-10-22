package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.hybrid.list.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class ActionRateListener {
    public final boolean a;
    public JSONObject b;
    public JSONObject c;
    public long d;
    public boolean e;
    public String f;
    public final String g;
    public final String h;
    public final Function0<Unit> i;

    public static final class a {
    }

    static {
    }

    public final void d() {
        e(this.b);
    }

    public final void g() {
        h(this.b);
    }

    public final void a(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        JSONObject r0 = this.b;     // Catch: Exception -> L5
        x0.b(r0, r10, false);     // Catch: Exception -> L5
        this.b = r0;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void b(Pair<String, String>... r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Iterator r11 = SequencesKt.filter(ArraysKt.asSequence(r10), ActionRateListener$appendCategory$1.INSTANCE).iterator();     // Catch: Exception -> L8
    L5:
        if (r11.hasNext() == false) goto L15;
        Pair r0 = (Pair) r11.next();     // Catch: Exception -> L8
        this.b.put((String) r0.getFirst(), r0.getSecond());     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void e(JSONObject r10) {
        Set<String> r0 = ECProcessMonitor.a;
        String r1 = this.g;
        String r11 = this.f;
        if (r11 != null) goto L5;
        r11 = this.h;
    L5:
        JSONObject r12 = this.c;
        Intrinsics.checkNotNullParameter(this, "listener");
        Intrinsics.checkNotNullParameter(r1, "pageName");
        Intrinsics.checkNotNullParameter(r11, "actionName");
        boolean r13 = this.a;
        if (r10 == null) goto L8;
        JSONObject r14 = x0.a(r10);
    L9:
        JSONObject r15 = r14;
        r15.put("event_type", "rate");
        r15.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r1);
        r15.put("action_name", r11);
        r15.put("rate_type", "start");
        Unit r16 = Unit.INSTANCE;
        ECProcessMonitor.i(r13, 0, "ec_full_trade_process_monitor", r15, null, r12, ECProcessMonitor.r(r1, ""));
        this.d = System.currentTimeMillis();
        return;
    L8:
        r14 = new JSONObject();
        goto L9
    }

    public final void f(Map<String, ? extends Object> r10) {
        JSONObject r0 = x0.a(this.b);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        if (r10 == null) goto L12;
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r12 = r11.next();     // Catch: Throwable -> L15
        if (r12.getValue() == null) goto L7;
        r0.put(r12.getKey(), r12.getValue());     // Catch: Throwable -> L15
        goto L7
    L11:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(r13);     // Catch: Throwable -> L15
    L17:
        e(r0);
        return;
    L12:
        r13 = null;
    L15:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final void h(JSONObject r10) {
        Set<String> r0 = ECProcessMonitor.a;
        String r1 = this.g;
        String r11 = this.f;
        if (r11 != null) goto L5;
        r11 = this.h;
    L5:
        JSONObject r12 = this.c;
        Intrinsics.checkNotNullParameter(this, "listener");
        Intrinsics.checkNotNullParameter(r1, "pageName");
        Intrinsics.checkNotNullParameter(r11, "actionName");
        boolean r13 = this.a;
        if (r10 == null) goto L8;
        JSONObject r14 = x0.a(r10);
    L9:
        r14.put("event_type", "rate");
        r14.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r1);
        r14.put("action_name", r11);
        r14.put("rate_type", "success");
        Unit r15 = Unit.INSTANCE;
        ECProcessMonitor.i(r13, 0, "ec_full_trade_process_monitor", r14, null, r12, ECProcessMonitor.r(r1, ""));
        if (this.d > 0) goto L12;
    L17:
        this.i.invoke();
        return;
    L12:
        if (this.e == false) goto L17;
        String r16 = this.g;
        String r17 = this.f;
        if (r17 != null) goto L16;
        r17 = this.h;
    L16:
        ECProcessMonitor.j(r16, r17, System.currentTimeMillis() - this.d, r10, this.c);
        goto L17
    L8:
        r14 = new JSONObject();
        goto L9
    }

    public final void i(Map<String, ? extends Object> r10) {
        JSONObject r0 = x0.a(this.b);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        if (r10 == null) goto L12;
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r12 = r11.next();     // Catch: Throwable -> L15
        if (r12.getValue() == null) goto L7;
        r0.put(r12.getKey(), r12.getValue());     // Catch: Throwable -> L15
        goto L7
    L11:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(r13);     // Catch: Throwable -> L15
    L17:
        h(r0);
        return;
    L12:
        r13 = null;
    L15:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public ActionRateListener(String r10, String r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        Intrinsics.checkNotNullParameter(r11, "actionName");
        Intrinsics.checkNotNullParameter(r12, "fullFill");
        this.g = r10;
        this.h = r11;
        this.i = r12;
        Set<String> r13 = ECProcessMonitor.a;
        this.a = ECProcessMonitor.q("rate");
        this.b = new JSONObject();
        this.c = new JSONObject();
        this.e = true;
    }

    public static void c(ActionRateListener r10, JSONObject r11, JSONObject r12, boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r11 = new JSONObject();
    L5:
        String r1 = null;
        if ((r14 & 2) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 4) == 0) goto L11;
        r13 = false;
    L11:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "categoryInfo");
        JSONObject r15 = r10.b;     // Catch: Exception -> L28
        x0.b(r15, r11, false);     // Catch: Exception -> L28
        if (r13 == true) goto L24;
        kc.a r16 = com.bytedance.android.bcm.api.b.c(null, CollectionsKt.arrayListOf(new String[]{"ecom_entrance"}));     // Catch: Exception -> L28
        if (r16 == null) goto L23;
        List<kc.a.C0174a> r17 = r16.a;     // Catch: Exception -> L28
        if (r17 == null) goto L23;
        List<kc.a.C0174a> r18 = r17;     // Catch: Exception -> L28
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));     // Catch: Exception -> L28
        Iterator<T> r20 = r18.iterator();     // Catch: Exception -> L28
    L20:
        if (r20.hasNext() == false) goto L22;
        r19.add(((kc.a.C0174a) r20.next()).c);     // Catch: Exception -> L28
        goto L20
    L22:
        r1 = k.d(r19);     // Catch: Exception -> L28
    L23:
        r15.put("btm_list", r1);     // Catch: Exception -> L28
    L24:
        Unit r21 = Unit.INSTANCE;     // Catch: Exception -> L28
        r10.b = r15;     // Catch: Exception -> L28
        if (r12 == null) goto L34;
        JSONObject r22 = r10.c;     // Catch: Exception -> L28
        x0.b(r22, r12, false);     // Catch: Exception -> L28
        r10.c = r22;     // Catch: Exception -> L28
        return;
    L34:
        return;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
