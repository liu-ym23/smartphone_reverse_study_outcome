package com.bytedance.android.anniex.engine;

import android.content.MutableContextWrapper;
import com.bytedance.android.anniex.ability.f;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.h;
import com.lynx.tasm.o1;
import com.lynx.tasm.s0;
import com.lynx.tasm.t;
import i36.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLynxEngine implements h {
    public final MutableContextWrapper a;
    public final LynxTemplateRender b;
    public LynxBDXBridge c;
    public com.bytedance.android.monitorV2.lynx.jsb.a d;
    public boolean e;
    public final long f;
    public int g;
    public long h;
    public final a i;
    public d1 j;
    public final Lazy k;
    public final int l;

    public final void updateMetaData(o1 r1) {
        throw null;
    }

    public final void destroy() {
        com.bytedance.ies.bullet.secure.a r0 = (com.bytedance.ies.bullet.secure.a) this.k.getValue();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.b.destroy();
    }

    public static void c(String r10) {
        TraceEvent.beginSection("AnnieXLynxEngine:setNpthLastUrl");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        HashMap r11 = new HashMap();     // Catch: Throwable -> L12
        if (r10 == null) goto L9;
        List r12 = StringsKt.split$default(r10, new String[]{"?"}, false, 0, 6, null);     // Catch: Throwable -> L12
        if (r12 == null) goto L9;
        String r13 = (String) r12.get(0);     // Catch: Throwable -> L12
        if (r13 == null) goto L9;
    L10:
        r11.put("last_lynx_url", r13);     // Catch: Throwable -> L12
        r11.put("lynx_sdk_version", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L12
        Npth.addTags(r11);     // Catch: Throwable -> L12
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L17
        TraceEvent.endSection("AnnieXLynxEngine:setNpthLastUrl");
        return;
    L9:
        r13 = "";
    L17:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxEngine:setNpthLastUrl");
        throw th;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        goto L14
    }

    public final void loadTemplate(s0 r10) {
        Intrinsics.checkNotNullParameter(r10, "metaData");
        this.b.loadTemplate(r10);
    }

    public final void a(ra.a r10, String r11, p r12) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("res_from", r11);
        if (r12 == null) goto L5;
        r0.put("geckoId", String.valueOf(((d1) r12).f));
        r0.put("geckoChannel", ((d1) r12).u);
    L5:
        UGLogger.c r13 = UGLogger.a;
        StringBuilder r14 = new StringBuilder("annieXLynxModel.globalProps is not null: ");
        if (r10.d == null) goto L8;
        boolean r15 = true;
    L9:
        r14.append(r15);
        UGLogger.d(r14.toString());
        TemplateData r16 = r10.d;
        if (r16 == null) goto L27;
        Iterator r17 = r0.entrySet().iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r17.next();
        r16.put((String) r1.getKey(), r1.getValue());
        goto L13
    L15:
        ConcurrentHashMap<String, Object> r18 = f.a;
        Map r19 = f.o(this.a, r10.g);
        if (r19 == null) goto L21;
        Iterator r20 = r19.entrySet().iterator();
    L19:
        if (r20.hasNext() == false) goto L21;
        Map.Entry r21 = (Map.Entry) r20.next();
        r16.put((String) r21.getKey(), r21.getValue());
    L21:
        Boolean r22 = Boolean.FALSE;
        r16.put("isColdStart", r22);
        r16.put("isPreCreate", r22);
        r16.put("isAsyncLayout", r22);
        r16.put("isFromEngine", Boolean.TRUE);
        r16.markConcurrent();
        Intrinsics.checkNotNullParameter(r16, "props");
        TraceEvent.beginSection("LynxView:updateGlobalProps");
        UGLogger.d("updateGlobalProps");     // Catch: Throwable -> L24
        this.b.updateMetaData(new o1(null, r16));     // Catch: Throwable -> L24
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L24
        TraceEvent.endSection("LynxView:updateGlobalProps");
        return;
    L24:
        th = move-exception;
        TraceEvent.endSection("LynxView:updateGlobalProps");
        throw th;
    L27:
        return;
    L8:
        r15 = false;
        goto L9
    }

    public final void b(String r10, String r11, final String r12) {
        TraceEvent.beginSection("AnnieXLynxEngine:onLoadFail");
        final a r1 = this.i;     // Catch: Throwable -> L6
        r1.getClass();     // Catch: Throwable -> L6
        r1.z(new AnnieXDefaultLynxEngineClient$onEngineLoadFailed$1(r1, r12));     // Catch: Throwable -> L6
        HybridLogger.i("XResourceLoader", r12, null, 12);     // Catch: Throwable -> L6
        Map<String, d> r13 = MonitorManager.a;     // Catch: Throwable -> L6
        MonitorManager.p(r10, r11, AbsBulletMonitorCallback.ErrStage.RL, r12, null);     // Catch: Throwable -> L6
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.endSection("AnnieXLynxEngine:onLoadFail");
        return;
    L6:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxEngine:onLoadFail");
        throw th;
    }

    public AnnieXLynxEngine(String r10, MutableContextWrapper r11, t r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "contextWrapper");
        Intrinsics.checkNotNullParameter(r12, "builder");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        this.a = r11;
        this.f = System.currentTimeMillis();
        this.g = 5;
        this.h = 15000;
        this.k = LazyKt.lazy(new AnnieXLynxEngine$argusDelegate$2(this));
        this.l = r11.getResources().getConfiguration().orientation;
        TraceEvent.beginSection("LynxEngineBuilder.build");
        LynxTemplateRender r0 = new LynxTemplateRender(r12);
        TraceEvent.endSection("LynxEngineBuilder.build");
        this.b = r0;
        a r14 = new a(r10, r13);
        this.i = r14;
        r14.j = true;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.lynx.tasm.LynxTemplateRender");
        r0.addLynxViewClient(r14);
    }
}
