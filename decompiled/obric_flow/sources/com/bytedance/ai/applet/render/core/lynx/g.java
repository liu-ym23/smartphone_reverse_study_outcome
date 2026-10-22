package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.sdk.xbridge.cn.platform.lynx.XBridgeLynxModule;
import com.lynx.tasm.l0;
import com.lynx.tasm.navigator.NavigationModule;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends dk.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0 f1766c;
    public final String d;
    public q7.a e;
    public com.bytedance.ai.applet.components.view.a f;
    public boolean g;

    public g(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        l0 r10 = new l0();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "lynxViewBuilder");
        super(r5);
        this.f1766c = r10;
        this.d = UUID.randomUUID().toString();
        this.g = true;
    }

    public final i a() {
        q7.a r5 = this.e;
        if (r5 == null) goto L9;
        h5.b r10 = new h5.b();
        l2.a r11 = new l2.a();
        f r12 = new f(r11, this.f);
        Intrinsics.checkNotNullParameter(LynxAppletModelClass.class, "module");
        l0 r13 = this.f1766c;
        r13.a(LynxAppletModelClass.class, r12, "AppletBridgeModule");
        String r14 = NavigationModule.NAME;
        Intrinsics.checkNotNullParameter(NavigationModule.class, "module");
        r13.a(NavigationModule.class, null, r14);
        Intrinsics.checkNotNullParameter(LynxViewMonitorModule.class, "module");
        r13.a(LynxViewMonitorModule.class, r10, "hybridMonitor");
        String r15 = this.d;
        Context r16 = (Context) this.f16659a;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r17 = new com.bytedance.sdk.xbridge.cn.platform.lynx.a(r16, r15);
        Intrinsics.checkNotNullParameter(r13, "lynxViewBuilder");
        r13.a(XBridgeLynxModule.class, r17, "bridge");
        r13.f10898a = Float.valueOf(r16.getResources().getDisplayMetrics().density);
        r13.f10908o = r16.getResources().getConfiguration().fontScale;
        r13.f10915w = new l(r16, r5);
        r13.b("EXTERNAL_JS_SOURCE", new n(r5));
        String r18 = this.d;
        i r19 = new i((Context) this.f16659a, this.f1766c, r5, r18, r17, r11);
        r10.f17282a = r19;
        if (this.g == false) goto L7;
        Intrinsics.checkNotNullParameter("aisdk_hybrid_bid", "bid");
        com.obric.oui.constraintlayout.core.widgets.analyzer.f r110 = new com.obric.oui.constraintlayout.core.widgets.analyzer.f("aisdk_hybrid_bid", new com.bytedance.android.monitorV2.webview.a());
        r110.f12568b = false;
        r110.d = "AISDK";
        qo.a.h(r19, r110);
        com.bytedance.android.monitorV2.lynx.d.f3638a.getClass();
        com.bytedance.android.monitorV2.lynx.d.e(r19, "container_name", "AISDK");
        com.bytedance.android.monitorV2.lynx.d.e(r19, "render_type", LynxMonitorService.DEFAULT_PID);
        BuildersKt.launch$default(h0.a(Dispatchers.getIO()), null, null, new LynxRenderView$initMonitorConfig$1(r19, null), 3, null);
    L7:
        return r19;
    L9:
        throw new IllegalArgumentException("ResourceLoader is required");
    }
}
