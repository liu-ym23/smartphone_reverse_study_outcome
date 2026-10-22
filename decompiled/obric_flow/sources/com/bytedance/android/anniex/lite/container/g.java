package com.bytedance.android.anniex.lite.container;

import android.net.Uri;
import android.util.LruCache;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.solutions.card.AirActionConstant$AirSolutionLifecycle;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements x3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.a f3246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnieXLiteContainer f3247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnnieXLynxView f3248c;
    public b4.c d;
    public WeakReference e;

    public g(AnnieXLiteContainer r5, a4.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieXContext");
        Intrinsics.checkNotNullParameter(r5, "iContainer");
        this.f3246a = r10;
        this.f3247b = r5;
    }

    @Override // x3.a
    public final void a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        AnnieXLynxView r10 = this.f3248c;
        if (r10 == null) goto L6;
        r10.updateData(r5);
        return;
    }

    @Override // x3.a
    public final View b() {
        return this.f3248c;
    }

    @Override // x3.a
    public final void c(com.bytedance.ies.bullet.core.kit.bridge.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        AnnieXLynxView r10 = this.f3248c;
        if (r10 == null) goto L6;
        AnnieXLynxView.i(r10, r5.getName(), r5.getParams());
        return;
    }

    @Override // x3.a
    public final void enterBackground() {
        AnnieXLynxView r5 = this.f3248c;
        if (r5 == null) goto L14;
        ym.g r10 = null;
        AnnieXLynxView.i(r5, "viewDisappeared", null);
        r5.onEnterBackground();
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r11 = r5.f3466c;
        if (r11 == null) goto L7;
        r10 = r11.g;
    L7:
        if (r10 == null) goto L10;
        r10.f23298a = false;
    L10:
        xd.c.e.set(true);
        g4.a r12 = r5.d;
        if (r12 == null) goto L15;
        r12.a(AirActionConstant$AirSolutionLifecycle.f3460b);
        return;
    L15:
        return;
    }

    @Override // x3.a
    public final void enterForeground() {
        AnnieXLynxView r5 = this.f3248c;
        if (r5 == null) goto L8;
        JSONObject r10 = new JSONObject();
        r10.put("isViewFirstAppeared", r5.f3473n);
        Unit r11 = Unit.INSTANCE;
        AnnieXLynxView.i(r5, "viewAppeared", r10);
        r5.onEnterForeground();
        r5.f3473n = false;
        xd.c.e.set(false);
        g4.a r12 = r5.d;
        if (r12 == null) goto L9;
        r12.a(AirActionConstant$AirSolutionLifecycle.f3459a);
        return;
    L9:
        return;
    }

    @Override // x3.a
    public final void release() {
        AnnieXLynxView r5 = this.f3248c;
        if (r5 == null) goto L5;
        r5.destroy();
    L5:
        WeakReference r10 = this.e;
        if (r10 == null) goto L17;
        v3.a r11 = (v3.a) r10.get();
        if (r11 == null) goto L17;
        b4.c r12 = this.d;
        if (r12 == null) goto L15;
        Uri r13 = r12.f860b;
        if (r13 == null) goto L15;
        String r14 = r13.toString();
        if (r14 == null) goto L15;
    L16:
        r11.h(r14, this.f3247b);
    L15:
        r14 = "";
    L17:
        this.e = null;
    }

    @Override // x3.a
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        AnnieXLynxView r10 = this.f3248c;
        if (r10 == null) goto L6;
        r10.updateData(r5);
        return;
    }

    @Override // x3.a
    public final void b(String r11, Map r12, rb.b r13, v3.a r14) {
        Intrinsics.checkNotNullParameter(r11, "schema");
        Uri r15 = Uri.parse(this.f3246a.e);
        String r5 = this.f3246a.f90b;
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        y3.a.f23235a.a(r5);
        a4.a r10 = this.f3246a;
        String r16 = r10.f91c;
        String r17 = r10.f90b;
        LruCache r18 = com.bytedance.android.anniex.lite.a.f3222a;
        Intrinsics.checkNotNullParameter(r16, "bid");
        Intrinsics.checkNotNullParameter(r15, "schema");
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        TraceEvent.c("AnnieXLynxModelBuilder:preBuild");
        b4.c r19 = (b4.c) com.bytedance.android.anniex.lite.a.f3222a.get(r17);     // Catch: Throwable -> L7
        if (r19 != null) goto L9;
        r19 = com.bytedance.android.anniex.lite.a.a(r15, r16, r17);     // Catch: Throwable -> L7
    L9:
        TraceEvent.a(0, "AnnieXLynxModelBuilder:preBuild");
        this.d = r19;
        FragmentActivity r110 = this.f3246a.g;
        h r20 = null;
        if (r110 == null) goto L17;
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r19, "lynxModel");
        TraceEvent.c("AnnieXApi:createLynxViewFromEngine");
        LinkedHashMap r21 = com.bytedance.android.anniex.monitor.c.f3335a;     // Catch: Throwable -> L14
        com.bytedance.android.anniex.monitor.c.y(r19.f);     // Catch: Throwable -> L14
        TraceEvent.c("AnnieXLynxView:init");     // Catch: Throwable -> L14
        com.bytedance.android.anniex.engine.a.f3211a.b(r19.f861c, r19.f);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(com.bytedance.android.anniex.assemble.a.f3108a, "<this>");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r110, "context");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r19, "lynxModel");     // Catch: Throwable -> L14
        AnnieXLynxView r111 = q3.a.a(r110, r19);     // Catch: Throwable -> L14
        TraceEvent.a(0, "AnnieXApi:createLynxViewFromEngine");
    L18:
        this.f3248c = r111;
        if (r111 == null) goto L21;
        r111.setViewScene$anniex_release(this.f3246a.f89a);
    L21:
        LinkedHashMap r112 = com.bytedance.android.anniex.monitor.c.f3335a;
        a4.a r113 = this.f3246a;
        com.bytedance.android.anniex.monitor.c.r(r113.f90b, r113.f89a.f5286a);
        tc.c r114 = tc.c.f22119c;
        tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.utils.b.class, this.f3246a.f91c);
        xq.b.t();
        if (this.d != null) goto L26;
        if (r14 == null) goto L26;
        r14.a(100, "create AnnieX model error");
    L26:
        if (this.f3248c != null) goto L29;
        if (r14 == null) goto L29;
        r14.a(200, "create AnnieXWebkit error");
    L29:
        if (r14 == null) goto L36;
        b4.c r115 = this.d;
        if (r115 == null) goto L34;
        String r116 = r115.f859a;
        if (r116 == null) goto L34;
    L35:
        r14.f(r116, this.f3247b);
    L34:
        r116 = "";
    L36:
        AnnieXLynxView r117 = this.f3248c;
        if (r117 != null) goto L39;
    L56:
        b4.c r118 = this.d;
        if (r118 == null) goto L74;
        TemplateData r22 = r118.d;
        if (r12 == null) goto L64;
        Iterator r119 = r12.entrySet().iterator();
    L62:
        if (r119.hasNext() == false) goto L64;
        Map.Entry r23 = (Map.Entry) r119.next();
        r22.i((String) r23.getKey(), r23.getValue());
    L64:
        r22.d = true;
        AnnieXLynxView r120 = this.f3248c;
        if (r120 == null) goto L74;
        if (r14 == null) goto L68;
        r20 = new h(this.f3246a, r14, this.f3247b);
    L68:
        Intrinsics.checkNotNullParameter(r118, "annieXLynxModel");
        TraceEvent.c("AnnieXLynxView:load");
        r120.d(r118, r13, r20);     // Catch: Throwable -> L71
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L71
        TraceEvent.a(0, "AnnieXLynxView:load");
    L71:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:load");
        throw th;
    L74:
        this.e = new WeakReference(r14);
        AnnieXLynxView r122 = this.f3248c;
        if (r122 == null) goto L91;
        rb.b r123 = r122.getBridgeContextProviderFactory$anniex_release();
        if (r123 == null) goto L92;
        this.f3247b.onEngineReady(r123);
        return;
    L92:
        return;
    L91:
        return;
    L39:
        if (r117.getIsFromEngine() != true) goto L56;
        b4.c r124 = this.d;
        if (r124 == null) goto L74;
        if (this.f3248c == null) goto L52;
        if (r14 == null) goto L46;
        a4.a r125 = this.f3246a;
        AnnieXLiteContainer r24 = this.f3247b;
        Intrinsics.checkNotNullParameter(r125, "annieXContext");
        Intrinsics.checkNotNullParameter(r14, "originLifeCycle");
        Intrinsics.checkNotNullParameter(r24, "iContainer");
    L46:
        Intrinsics.checkNotNullParameter(r124, "annieXLynxModel");
        TraceEvent.c("AnnieXLynxView:flushAllStickyEvents");
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L49
        TraceEvent.a(0, "AnnieXLynxView:flushAllStickyEvents");
    L49:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:flushAllStickyEvents");
        throw th;
    L52:
        if (r12 == null) goto L74;
        AnnieXLynxView r127 = this.f3248c;
        if (r127 == null) goto L74;
        AnnieXLynxView.i(r127, "annie.updateRenderData", r12);
    L14:
        th = move-exception;
        TraceEvent.a(0, "AnnieXApi:createLynxViewFromEngine");
        throw th;
    L17:
        r111 = null;
    L7:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxModelBuilder:preBuild");
        throw th;
    }

    @Override // x3.a
    public final boolean a() {
        AnnieXLynxView r5 = this.f3248c;
        if (r5 == null) goto L28;
        b4.c r10 = this.d;
        if (r10 != null) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L34;
        Intrinsics.checkNotNull(r10);
        int r11 = AnnieXLynxView.s;
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        TraceEvent.c("AnnieXLynxView:reloadTemplate");
        r5.o(r10);     // Catch: Throwable -> L25
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L25
        TraceEvent.a(0, "AnnieXLynxView:reloadTemplate");
        WeakReference r13 = this.e;
        if (r13 == null) goto L32;
        v3.a r14 = (v3.a) r13.get();
        if (r14 == null) goto L33;
        b4.c r15 = this.d;
        if (r15 == null) goto L21;
        Uri r16 = r15.f860b;
        if (r16 == null) goto L21;
        String r17 = r16.toString();
        if (r17 == null) goto L21;
    L22:
        r14.j(r17, this.f3247b);
        return true;
    L21:
        r17 = "";
        goto L22
    L33:
        return true;
    L32:
        return true;
    L25:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:reloadTemplate");
        throw th;
    L34:
        return false;
    L28:
        return false;
    }
}
