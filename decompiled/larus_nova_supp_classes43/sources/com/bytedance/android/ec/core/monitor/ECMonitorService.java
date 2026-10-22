package com.bytedance.android.ec.core.monitor;

import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.apm.ApmAgent;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECMonitorService implements pi.b {
    public static final /* synthetic */ int b = 0;
    public volatile boolean a;

    public static final class a {
        public static void a(String r1, JSONObject r10, JSONObject r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r1, "serviceName");
            boolean r0 = ECServiceManager.a;
            pi.b r13 = (pi.b) ECServiceManager.c(pi.b.class);
            if (r13 == null) goto L6;
            r13.monitorEvent(r1, r10, r11, r12);
            return;
        }
    }

    static {
    }

    public ECMonitorService() {
    }

    public final void b(HashMap r10) {
        Intrinsics.checkNotNullParameter("event_mall_lynx_template_loaded", "event");
        Intrinsics.checkNotNullParameter(r10, "params");
        int r11 = d.a;
        Intrinsics.checkNotNullParameter("event_mall_lynx_template_loaded", "event");
        Intrinsics.checkNotNullParameter(r10, "params");
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L7;
        d.f("event_mall_lynx_template_loaded");
        d.e("event_mall_lynx_template_loaded", r10);
        return;
    }

    public final void a(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "errorDesc");
        int r14 = d.a;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "errorDesc");
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L17;
        StringBuilder r1 = new StringBuilder("lynx容器异常");
        if (r13 != null) goto L8;
        String r15 = "";
    L9:
        r1.append(r15);
        r1.append(",请排查一下问题，若误报或有任何问题可联系dingyuxun");
        d.f(r1.toString());
        HashMap r16 = new HashMap();
        r16.put(com.bytedance.android.ec.core.event.a.KEY_URL, r10);
        r16.put("error_desc", r11);
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        r16.put("scene", r12);
        if (r13 != null) goto L15;
        r13 = "";
    L15:
        r16.put(IHostStyleUIDepend.TOAST_TYPE_ERROR, r13);
        d.e("iesec_lynx_container_error_event", r16);
        return;
    L8:
        r15 = r13;
        goto L9
    }

    public final void monitorEvent(final String r10, final JSONObject r11, final JSONObject r12, final JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "serviceName");
        Single.fromCallable(new AnonymousClass1(this, r10, r11, r12, r13)).subscribeOn(Schedulers.io()).subscribe();
    }

    public static final void c(ECMonitorService r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        r10.getClass();
        ApmAgent.monitorEvent(r11, r12, r13, r14);
        SDKMonitorUtils.getInstance(String.valueOf(6688)).monitorEvent(r11, r12, r13, r14);
        Single.fromCallable(new h(r10, r11, r12, r13, r14)).subscribeOn(Schedulers.io()).subscribe();
    }
}
