package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ ECImageMainHandlerOpt.URIStruct d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ yl.a g;

    public r(long r1, long r10, long r11, ECImageMainHandlerOpt.URIStruct r12, boolean r13, boolean r14, yl.a r15) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    public final void a() {
        long r0 = this.a;
        long r10 = this.b;
        double r11 = (r0 - r10) / 1000000.0d;
        long r12 = this.c;
        double r1 = (r12 - r0) / 1000000.0d;
        double r13 = (r12 - r10) / 1000000.0d;
        int r14 = ECMonitorService.b;
        JSONObject r15 = new JSONObject();
        String r16 = this.d.b("biz_tag");
        if (r16 == null) goto L5;
        r15.put("biz_tag", r16);
    L5:
        String r17 = this.d.b("scene_tag");
        if (r17 == null) goto L8;
        r15.put("scene_tag", r17);
    L8:
        r15.put(com.bytedance.android.ec.core.event.a.KEY_URL, this.d.toString());
        r15.put(com.bytedance.android.ec.core.event.a.KEY_IS_SUCCESS, this.e);
        r15.put("is_asynchronous", this.f);
        String r18 = this.g.a;
        if (r18 == null) goto L11;
        r15.put("hit_rule_key", r18);
    L11:
        Unit r19 = Unit.INSTANCE;
        JSONObject r20 = new JSONObject();
        r20.put("obtain_duration", r11);
        r20.put("new_result_duration", r1);
        r20.put("total_duration", r13);
        ECMonitorService.a.a("ecom_image_main_handler_opt_monitor", r15, r20, new JSONObject());
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
