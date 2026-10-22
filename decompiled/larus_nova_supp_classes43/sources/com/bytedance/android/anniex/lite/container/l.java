package com.bytedance.android.anniex.lite.container;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.TemplateData;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements na.a {
    public final qa.a a;
    public final ia.c b;
    public AnnieXLynxView c;
    public ra.a d;
    public na.c e;
    public WeakReference<com.bytedance.android.anniex.base.lifecycle.a> f;

    @Override // na.a
    public final void a() {
    }

    @Override // na.a
    public final boolean canGoBack() {
        return false;
    }

    @Override // na.a
    public final void goBack() {
    }

    @Override // na.a
    public final void enterBackground() {
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L6;
        r0.F();
        return;
    }

    @Override // na.a
    public final void enterForeground() {
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L6;
        r0.H();
        return;
    }

    @Override // na.a
    public final void release() {
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        na.c r1 = this.e;
        if (r1 == null) goto L8;
        r1.onRelease();
    L8:
        WeakReference<com.bytedance.android.anniex.base.lifecycle.a> r10 = this.f;
        if (r10 == null) goto L20;
        com.bytedance.android.anniex.base.lifecycle.a r11 = r10.get();
        if (r11 == null) goto L20;
        ra.a r12 = this.d;
        if (r12 == null) goto L18;
        Uri r13 = r12.b;
        if (r13 == null) goto L18;
        String r14 = r13.toString();
        if (r14 == null) goto L18;
    L19:
        r11.f(r14, this.b);
    L18:
        r14 = "";
    L20:
        this.f = null;
        this.c = null;
        this.e = null;
    }

    @Override // na.a
    public final boolean reload() {
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L26;
        ra.a r10 = this.d;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L26;
        Intrinsics.checkNotNull(r10);
        AnnieXLynxView.J(r0, r10, null, 6);
        WeakReference<com.bytedance.android.anniex.base.lifecycle.a> r1 = this.f;
        if (r1 == null) goto L25;
        com.bytedance.android.anniex.base.lifecycle.a r12 = r1.get();
        if (r12 == null) goto L25;
        ra.a r13 = this.d;
        if (r13 == null) goto L23;
        Uri r14 = r13.b;
        if (r14 == null) goto L23;
        String r15 = r14.toString();
        if (r15 == null) goto L23;
    L24:
        r12.i(r15, this.b);
    L23:
        r15 = "";
    L25:
        return true;
    L7:
        r11 = false;
    L26:
        return false;
    }

    @Override // na.a
    public final View d() {
        return this.c;
    }

    @Override // na.a
    public final void c(Activity r10) {
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L6;
        r0.o(r10);
        return;
    }

    @Override // na.a
    public final void e(Activity r10) {
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L6;
        r0.K(r10);
        return;
    }

    @Override // na.a
    public final void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r10.getName();
        Object r11 = r10.getParams();
        int r12 = AnnieXLynxView.B;
        r0.O(r1, r11, true);
        return;
    }

    @Override // na.a
    public final void updateData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L6;
        r0.updateData(r10);
        return;
    }

    @Override // na.a
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "globalProps");
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L6;
        r0.updateGlobalProps(r10);
        return;
    }

    @Override // na.a
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        AnnieXLynxView r0 = this.c;
        if (r0 == null) goto L6;
        r0.updateData(r10);
        return;
    }

    public l(qa.a r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, "annieXContext");
        Intrinsics.checkNotNullParameter(r11, "iContainer");
        this.a = r10;
        this.b = r11;
    }

    @Override // na.a
    public final void b(String r10, Map r11, m16.b r12, AnnieXLiteContainer.b r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Uri r0 = UriProtector.parse(this.a.e);
        String r1 = this.a.b;
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Object r14 = com.bytedance.android.anniex.lite.flow.base.a.a.a(r1);
        m r15 = null;
        if ((r14 instanceof na.c) == false) goto L5;
        na.c r16 = (na.c) r14;
    L6:
        this.e = r16;
        qa.a r17 = this.a;
        String r18 = r17.c;
        String r19 = r17.b;
        if (r16 == null) goto L10;
        ra.a r20 = r16.c(r18, r0, r19, null);
        if (r20 == null) goto L10;
    L11:
        this.d = r20;
        ra.a r21 = this.d;
        if (r21 == null) goto L16;
        Context r22 = this.a.getContext();
        if (r22 == null) goto L16;
        int r23 = com.bytedance.android.anniex.api.b.a;
        AnnieXLynxView r24 = com.bytedance.android.anniex.api.b.f(r22, r21, null);
    L17:
        this.c = r24;
        boolean r25 = false;
        if (r24 != null) goto L20;
    L22:
        boolean r26 = false;
    L23:
        if (r26 == false) goto L27;
        na.c r27 = this.e;
        if (r27 == null) goto L27;
        r27.a();
    L27:
        AnnieXLynxView r28 = this.c;
        if (r28 == null) goto L30;
        r28.setViewScene$anniex_release(this.a.a);
    L30:
        Map<String, i36.d> r29 = MonitorManager.a;
        qa.a r30 = this.a;
        MonitorManager.h(r30.b, r30.a.getTag());
        s26.d r31 = s26.d.c;
        v16.a r32 = s26.d.c.d(this.a.c, v16.b.class);
        if ((r32 instanceof v16.a) == false) goto L33;
        v16.a r33 = r32;
    L35:
        if (com.bytedance.ies.bullet.service.base.h.u0() == true) goto L39;
        r33 = null;
    L39:
        if (this.d != null) goto L43;
        if (r13 == null) goto L43;
        Intrinsics.checkNotNullParameter("create AnnieX model error", "errorMessage");
    L43:
        if (this.c != null) goto L46;
        if (r13 == null) goto L46;
        Intrinsics.checkNotNullParameter("create AnnieXWebkit error", "errorMessage");
    L46:
        if (r13 == null) goto L53;
        ra.a r34 = this.d;
        if (r34 == null) goto L51;
        String r35 = r34.a;
        if (r35 == null) goto L51;
    L52:
        r13.e(r35, this.b);
    L51:
        r35 = "";
    L53:
        AnnieXLynxView r36 = this.c;
        if (r36 != null) goto L56;
    L58:
        if (r25 == false) goto L70;
        ra.a r37 = this.d;
        if (r37 == null) goto L89;
        AnnieXLynxView r38 = this.c;
        if (r38 == null) goto L66;
        if (r13 == null) goto L65;
        r15 = new m(this.a, r13, this.b);
    L65:
        r38.r(r15, r12, r37);
    L66:
        if (r11 == null) goto L89;
        AnnieXLynxView r39 = this.c;
        if (r39 == null) goto L89;
        int r40 = AnnieXLynxView.B;
        r39.O("annie.updateRenderData", r11, true);
    L89:
        this.f = new WeakReference(r13);
        AnnieXLynxView r41 = this.c;
        if (r41 == null) goto L100;
        m16.b r42 = r41.getBridgeContextProviderFactory$anniex_release();
        if (r42 == null) goto L101;
        this.b.onEngineReady(r42);
        return;
    L101:
        return;
    L100:
        return;
    L70:
        ra.a r43 = this.d;
        if (r43 == null) goto L89;
        TemplateData r44 = r43.d;
        if (r11 == null) goto L80;
        Iterator r45 = r11.entrySet().iterator();
    L76:
        if (r45.hasNext() == false) goto L80;
        Map.Entry r46 = (Map.Entry) r45.next();
        if (r44 == null) goto L76;
        r44.put((String) r46.getKey(), r46.getValue());
    L80:
        if (r44 == null) goto L82;
        r44.markConcurrent();
    L82:
        if (r33 == null) goto L84;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
    L84:
        AnnieXLynxView r47 = this.c;
        if (r47 == null) goto L89;
        if (r13 == null) goto L88;
        r15 = new m(this.a, r13, this.b);
    L88:
        r47.A(r43, r12, r15);
        goto L89
    L56:
        if (r36.getIsFromEngine() != true) goto L58;
        r25 = true;
        goto L58
    L33:
        r33 = null;
        goto L35
    L20:
        if (r24.getIsFromEngine() == true) goto L22;
        r26 = true;
    L16:
        r24 = null;
    L10:
        com.bytedance.android.anniex.lite.b.a.getClass();
        r20 = com.bytedance.android.anniex.lite.b.b(r18, r0, r19, null);
        goto L11
    L5:
        r16 = null;
        goto L6
    }
}
