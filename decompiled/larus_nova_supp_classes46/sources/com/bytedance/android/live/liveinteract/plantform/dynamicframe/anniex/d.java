package com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements com.bytedance.android.anniex.ui.e {
    public final /* synthetic */ c a;

    public final void c(AnnieXLynxView r1) {
    }

    public final void d(Uri r1, AnnieXLynxView r2) {
    }

    public final void e(AnnieXLynxView r1) {
    }

    public final void f(AnnieXLynxView r1) {
    }

    public final void g(AnnieXLynxView r1, LynxError r2) {
    }

    public final void j(AnnieXLynxView r1, JSONObject r2) {
    }

    public final void k(AnnieXLynxView r1, String r2) {
    }

    public final void l(q1.b r1) {
    }

    public final void m(AnnieXLynxView r1, JSONObject r2) {
    }

    public final void o(q1.b r1) {
    }

    public final void onModuleMethodInvoked(String r1, String r2, int r3) {
    }

    public final void onTimingSetup(Map<String, Object> r1) {
    }

    public final void onTimingUpdate(Map<String, Object> r1, Map<String, Long> r2, String r3) {
    }

    public final void q(AnnieXLynxView r1, String r2) {
    }

    public final String shouldRedirectImageUrl(String r1) {
        return null;
    }

    public d(c r1) {
        this.a = r1;
    }

    public final void a(TemplateBundle r2) {
        Intrinsics.checkNotNullParameter(r2, "templateBundle");
        Intrinsics.checkNotNullParameter(r2, "templateBundle");
    }

    public final void p(AnnieXLynxView r3) {
        c r0 = this.a;
        Boolean r1 = Boolean.TRUE;
        r0.d = r1;
        if (r1 == null) goto L5;
        r0.c.onNext(r1);
    L5:
        f r2 = this.a.j;
        if (r2 == null) goto L9;
        r2.onRuntimeReady(r3);
        return;
    }

    public final void b(AnnieXLynxView r3, String r4) {
        c r0 = this.a;
        Boolean r1 = Boolean.FALSE;
        r0.d = r1;
        if (r1 == null) goto L5;
        r0.c.onNext(r1);
    L5:
        f r2 = this.a.j;
        if (r2 == null) goto L9;
        r2.onLoadFailed(r3, r4);
        return;
    }

    public final void n(Uri r2, AnnieXLynxView r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r2, "uri");
        f r0 = this.a.j;
        if (r0 == null) goto L6;
        r0.onLoadStart(r2, r3);
        return;
    }

    public final void onLoadFail(Uri r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "e");
        com.bytedance.android.anniex.ui.e.b.b(r2, r3);
    }

    public final void onTemplateReady(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "resFrom");
        Intrinsics.checkNotNullParameter(r1, "resFrom");
    }

    public final void loadImage(Context r1, String r2, String r3, float r4, float r5, Transformer r6, m.a r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r7, "handler");
        com.bytedance.android.anniex.ui.e.b.a(r1, r7);
    }
}
