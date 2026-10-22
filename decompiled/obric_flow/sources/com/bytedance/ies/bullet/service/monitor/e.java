package com.bytedance.ies.bullet.service.monitor;

import android.util.Log;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.core.LoadStage;
import com.bytedance.ies.bullet.core.k;
import com.bytedance.ies.bullet.core.p;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.salamander.anniex.n;
import com.google.common.reflect.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends vc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6040a;

    public e(h r5) {
        this.f6040a = r5;
    }

    @Override // vc.b, vc.c
    public final void a(Map r10) {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        h r11 = this.f6040a;
        com.bytedance.ies.bullet.base.utils.logger.b r12 = (com.bytedance.ies.bullet.base.utils.logger.b) r11.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_timing_setup", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "on_timing_setup", null, r12);
        com.bytedance.android.anniex.base.service.f.l(r10, r11.e, r11.f);
        ConcurrentHashMap r13 = dd.c.f16640b;
        dd.c.c(r11.q(), "lynxview_firstscreen");
        r11.f6052n.addAndGet(1);
        r11.K();
        r11.o().d.b(null, com.bytedance.android.anniex.base.service.f.e(r11.e, r11.f));
    }

    @Override // vc.c
    public final void b(com.bytedance.ies.bullet.lynx.h r5) {
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        h r11 = this.f6040a;
        com.bytedance.ies.bullet.base.utils.logger.b r12 = (com.bytedance.ies.bullet.base.utils.logger.b) r11.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_first_screen", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "on_first_screen", null, r12);
        id.c r13 = r11.f6045c;
        r13.getClass();
        Intrinsics.checkNotNullParameter("lynx_first_screen", STGroup.DICT_KEY);
        r13.a("lynx_first_screen", Long.valueOf(System.currentTimeMillis()));
        id.a r14 = r11.d;
        com.lynx.tasm.utils.a.f(r11.f6045c, "render_template_start", "lynx_first_screen", r14, "lynx_render");
        id.a r15 = r11.d;
        com.lynx.tasm.utils.a.f(r11.f6045c, "containerInitTime", "lynx_first_screen", r15, "first_screen");
        r11.f6052n.addAndGet(2);
        r11.K();
    }

    @Override // vc.b, vc.c
    public final void c(w r5) {
        h r10 = this.f6040a;
        if (r10.f6047i.f889b == false) goto L10;
        if (r5 == null) goto L11;
        Log.i("Monitor-Callback", r10.q() + " onScrollStop");
        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onScollStop-stopFluencyMonitor");
        JSONObject r11 = new JSONObject();
        r11.put("tag_name", (String) r5.d);
        r11.put("stage", "after_fmp");
        String r12 = r10.o().d.f5324c.optString("sdk_type");
        if (r12 == null) goto L8;
        r11.put("sdk_type", r12);
    L8:
        r10.f6047i.b(r11);
        return;
    L11:
        return;
    }

    @Override // vc.b, vc.c
    public final void e(com.bytedance.ies.bullet.lynx.h r5, n r10) {
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r12 = MapsKt.mapOf(TuplesKt.to("message", String.valueOf(r10)));
        h r13 = this.f6040a;
        com.bytedance.ies.bullet.base.utils.logger.b r14 = (com.bytedance.ies.bullet.base.utils.logger.b) r13.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_received_error", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "Monitor-Callback", "on_received_error", r12, r14);
        ba.a r15 = r13.f6047i;
        if (r15.f889b == true) goto L5;
        return;
    L5:
        if (r15.f888a != true) goto L12;
        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onReceivedError-stopFluencyMonitor");
        JSONObject r16 = new JSONObject();
        r16.put("stage", "before_fmp");
        String r17 = r13.o().d.f5324c.optString("sdk_type");
        if (r17 == null) goto L9;
        r16.put("sdk_type", r17);
    L9:
        r15.b(r16);
        return;
    }

    @Override // vc.b, vc.c
    public final void g(com.bytedance.ies.bullet.lynx.h r5, String r10) {
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r12 = MapsKt.mapOf(TuplesKt.to("url", r10));
        h r13 = this.f6040a;
        com.bytedance.ies.bullet.base.utils.logger.b r14 = (com.bytedance.ies.bullet.base.utils.logger.b) r13.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_page_start", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "on_page_start", r12, r14);
        id.c r15 = r13.f6045c;
        r15.getClass();
        Intrinsics.checkNotNullParameter("lynx_page_start", STGroup.DICT_KEY);
        r15.a("lynx_page_start", Long.valueOf(System.currentTimeMillis()));
        ConcurrentHashMap r16 = dd.c.f16640b;
        dd.c.c(r13.q(), "view_page_start");
        if (r13.f6047i.f889b == false) goto L6;
        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onPageStart-startMonitor");
        JSONObject r17 = new JSONObject();
        r17.put("stage", "before_fmp");
        r13.f6047i.a(r17);
        return;
    }

    @Override // vc.b, vc.c
    public final void h(com.bytedance.ies.bullet.lynx.h r5) {
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r11 = MapsKt.mapOf(TuplesKt.to("message", null));
        h r12 = this.f6040a;
        com.bytedance.ies.bullet.base.utils.logger.b r13 = (com.bytedance.ies.bullet.base.utils.logger.b) r12.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_received_error", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "Monitor-Callback", "on_received_error", r11, r13);
        ba.a r14 = r12.f6047i;
        if (r14.f889b == true) goto L5;
        return;
    L5:
        if (r14.f888a != true) goto L12;
        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onReceivedError-stopFluencyMonitor");
        JSONObject r15 = new JSONObject();
        r15.put("stage", "before_fmp");
        String r16 = r12.o().d.f5324c.optString("sdk_type");
        if (r16 == null) goto L9;
        r15.put("sdk_type", r16);
    L9:
        r14.b(r15);
        return;
    }

    @Override // vc.b, vc.c
    public final void i(Map r10, Map r11, String r12) {
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        h r14 = this.f6040a;
        com.bytedance.ies.bullet.base.utils.logger.b r15 = (com.bytedance.ies.bullet.base.utils.logger.b) r14.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_timing_update", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "on_timing_update", null, r15);
        id.c r16 = r14.e;
        id.a r5 = r14.f;
        com.bytedance.android.anniex.base.service.f.l(r10, r16, r5);
        com.bytedance.android.anniex.base.service.f.m(r10, r11, r16, r5);
        com.bytedance.android.anniex.base.service.f.q(r10, r11, r14.g, r14.f6046h);
        ConcurrentHashMap r17 = dd.c.f16640b;
        dd.c.c(r14.q(), "lynxview_firstscreen");
        ba.a r18 = r14.f6047i;
        if (r18.f889b == false) goto L8;
        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onTimingUpdate-stopFluencyMonitor");
        JSONObject r19 = new JSONObject();
        r19.put("stage", "before_fmp");
        String r20 = r14.o().d.f5324c.optString("sdk_type");
        if (r20 == null) goto L7;
        r19.put("sdk_type", r20);
    L7:
        r18.b(r19);
    L8:
        AtomicInteger r21 = r14.f6052n;
        r21.addAndGet(1);
        Log.i("Monitor-Callback", r14.q() + " onUpdate " + r21.get());
        if (r21.get() <= 2) goto L15;
        LinkedHashMap r22 = cd.a.f1171a;
        if (cd.a.a(r14.q()).a(p.class) == null) goto L15;
        throw new ClassCastException();
    L15:
        r14.o().d.b(null, com.bytedance.android.anniex.base.service.f.e(r16, r5));
        if (r10 == null) goto L32;
        Object r23 = r10.get(LynxMonitorService.KEY_UPDATE_TIMING);
        if ((r23 instanceof Map) == false) goto L20;
        Map r24 = (Map) r23;
    L21:
        if (r24 == null) goto L23;
        boolean r25 = r24.containsKey("__lynx_timing_actual_fmp");
    L24:
        if (r25 == true) goto L27;
        r10 = null;
    L27:
        if (r10 == null) goto L33;
        com.bytedance.ies.bullet.core.c r26 = r14.o().f5308w;
        r26.getClass();
        Intrinsics.checkNotNullParameter("update", "<set-?>");
        r26.f5281l = "update";
        k r27 = r14.o().d;
        LoadStage r28 = LoadStage.f;
        r27.getClass();
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r27.e = r28;
        k r29 = r14.o().d;
        r29.getClass();
        Intrinsics.checkNotNullParameter("data_update", "<set-?>");
        r29.f = "data_update";
        Regex r30 = hd.b.f17301a;
        hd.b.a(r14.o());
        if (r14.f6051m == false) goto L34;
        hd.b.b(r14.o(), "update");
        return;
    L34:
        return;
    L33:
        return;
    L23:
        r25 = false;
        goto L24
    L20:
        r24 = null;
        goto L21
    }

    @Override // vc.b, vc.c
    public final void j(com.bytedance.ies.bullet.lynx.h r5, String r10) {
        StringBuilder r11 = new StringBuilder();
        h r12 = this.f6040a;
        r11.append(r12.q());
        r11.append(" onLoadFailed: ");
        r11.append(r10);
        Log.i("Monitor-Callback", r11.toString());
        ba.a r13 = r12.f6047i;
        if (r13.f889b == true) goto L5;
        return;
    L5:
        if (r13.f888a != true) goto L12;
        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onLoadFailed-stopFluencyMonitor");
        JSONObject r14 = new JSONObject();
        r14.put("stage", "before_fmp");
        String r15 = r12.o().d.f5324c.optString("sdk_type");
        if (r15 == null) goto L9;
        r14.put("sdk_type", r15);
    L9:
        r13.b(r14);
        return;
    }

    @Override // vc.b, vc.c
    public final void k(w r5) {
        if (r5 == null) goto L7;
        StringBuilder r10 = new StringBuilder();
        h r11 = this.f6040a;
        r10.append(r11.q());
        r10.append(" onScrollStart");
        Log.i("Monitor-Callback", r10.toString());
        ba.a r12 = r11.f6047i;
        if (r12.f889b == false) goto L8;
        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onScollStart-startFluencyMonitor");
        JSONObject r13 = new JSONObject();
        r13.put("tag_name", (String) r5.d);
        r13.put("stage", "after_fmp");
        r12.a(r13);
        return;
    L8:
        return;
    }

    @Override // vc.b, vc.c
    public final void m(com.bytedance.ies.bullet.lynx.h r5) {
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        h r11 = this.f6040a;
        com.bytedance.ies.bullet.base.utils.logger.b r12 = (com.bytedance.ies.bullet.base.utils.logger.b) r11.o().f5292b.getValue();
        Intrinsics.checkNotNullParameter("Monitor-Callback", "moduleTag");
        Intrinsics.checkNotNullParameter("on_load_success", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "Monitor-Callback", "on_load_success", null, r12);
        id.c r13 = r11.f6045c;
        r13.getClass();
        Intrinsics.checkNotNullParameter("lynx_load_success", STGroup.DICT_KEY);
        r13.a("lynx_load_success", Long.valueOf(System.currentTimeMillis()));
    }
}
