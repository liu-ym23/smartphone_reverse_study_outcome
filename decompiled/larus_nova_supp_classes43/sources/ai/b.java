package ai;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.vmsdk.JsWorkerWrapper;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.core.vmsdk.module.BaseWorkerBridgeModule;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o;
import io.reactivex.subjects.MaybeSubject;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends com.bytedance.ies.web.jsbridge2.b {
    public final CopyOnWriteArrayList<BaseWorkerBridgeModule> n;
    public final CopyOnWriteArrayList<JsWorkerWrapper> o;
    public final Set<String> p;
    public final Context q;
    public final a r;

    public final void j(o r1) {
    }

    public final String h() {
        return VmSdkSetting.a().c();
    }

    public final void p() {
        super.p();
        Iterator<BaseWorkerBridgeModule> r0 = this.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().release();
        goto L4
    L6:
        this.n.clear();
        this.o.clear();
    }

    public Context getContext(o r1) {
        if (r1 == null) goto L6;
        Context r10 = r1.getContext();
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.q;
    }

    public final void k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        r(new JSONObject(r10));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void l(JSONObject r1) {
        r(r1);
    }

    public final void o(c0 r10) {
        Intrinsics.checkNotNullParameter(r10, "call");
        if (((com.bytedance.ies.web.jsbridge2.b) this).f == false) goto L5;
        return;
    L5:
        a r0 = this.r;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "js2JavaCall");
        r0.a.put(r10.f, new MaybeSubject());
        if (this.p.contains(r10.d) == false) goto L8;
        i(r10);
        return;
    L8:
        super.o(r10);
    }

    public final void r(JSONObject r10) {
        Object r0 = r10.remove("__event_id");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r10.remove("__params") == null) goto L14;
        Iterator<JsWorkerWrapper> r11 = this.o.iterator();
    L12:
        if (r11.hasNext() == false) goto L16;
        JsWorkerWrapper r12 = r11.next();
        JSONObject r13 = new JSONObject();
        r13.put(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r1);
        r13.put("code", 1);
        r13.put("data", r12);
        Unit r14 = Unit.INSTANCE;
        r12.e(r13.toString());
        goto L12
    L16:
        return;
    }

    public b(Context r10, a r11) {
        Intrinsics.checkNotNullParameter(r10, "androidContext");
        Intrinsics.checkNotNullParameter(r11, "methodListenerStore");
        this.q = r10;
        this.r = r11;
        this.n = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
        this.p = new LinkedHashSet();
    }

    public final void m(String r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        JSONObject r0 = new JSONObject(r10);     // Catch: Exception -> L5
    L7:
        n(r0, r11);
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r0 = null;
        goto L7
    }

    public final void n(JSONObject r10, c0 r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r10 != null) goto L6;
        return;
    L6:
        a r0 = this.r;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        Intrinsics.checkNotNullParameter(r11, "js2JavaCall");
        String r12 = r11.f;
        Intrinsics.checkNotNullParameter(r12, "callbackId");
        MaybeSubject<JSONObject> r1 = r0.a.get(r12);
        if (r1 == null) goto L18;
        MaybeSubject<JSONObject> r13 = r1;
        JSONObject r14 = r10.optJSONObject("__params");
        if (r14 == null) goto L11;
        JSONObject r15 = new JSONObject(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RESULT, r14), TuplesKt.to("__callback_id", r11.f), TuplesKt.to("__type", "jsb")}));
    L12:
        r13.onSuccess(r15);
        Iterator<T> r16 = this.n.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        ((BaseWorkerBridgeModule) r16.next()).invokeCallback(r10, r11);
        goto L14
    L16:
        return;
    L11:
        r15 = new JSONObject();
        goto L12
    L18:
        throw new IllegalArgumentException(("failed to find call with __callback_id: " + r12).toString());
    }
}
