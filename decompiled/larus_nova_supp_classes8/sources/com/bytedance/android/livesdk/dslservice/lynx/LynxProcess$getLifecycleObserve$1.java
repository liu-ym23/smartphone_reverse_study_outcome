package com.bytedance.android.livesdk.dslservice.lynx;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.anniex.ui.e;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdk.dslservice.util.n;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.q1;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yt1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LynxProcess$getLifecycleObserve$1 implements e {
    public final /* synthetic */ String a;
    public final /* synthetic */ m b;

    public final void c(AnnieXLynxView r1) {
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

    public final void p(AnnieXLynxView r1) {
    }

    public final void q(AnnieXLynxView r1, String r2) {
    }

    public final String shouldRedirectImageUrl(String r1) {
        return null;
    }

    public final void a(TemplateBundle r2) {
        Intrinsics.checkNotNullParameter(r2, "templateBundle");
        Intrinsics.checkNotNullParameter(r2, "templateBundle");
    }

    public final void e(AnnieXLynxView r2) {
        n.e.d(new LynxProcess$getLifecycleObserve$1$onFirstScreen$1(this));
    }

    public final void f(AnnieXLynxView r2) {
        n.e.d(new LynxProcess$getLifecycleObserve$1$onDataUpdated$1(this));
    }

    public LynxProcess$getLifecycleObserve$1(String r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(AnnieXLynxView r3, final String r4) {
        n.e.d(new LynxProcess$getLifecycleObserve$1$onLoadFailed$1(this, r4));
        m r5 = this.b;
        if (r5 == null) goto L8;
        if (r4 != null) goto L6;
        r4 = "UnKnow";
    L6:
        r5.b(DSLType.Lynx, r4, null);
        return;
    }

    public final void d(Uri r3, AnnieXLynxView r4) {
        n.e.d(new LynxProcess$getLifecycleObserve$1$onLoadUriSuccess$1(this));
        m r5 = this.b;
        if (r5 == null) goto L6;
        r5.a(null, false, "");
        return;
    }

    public final void g(AnnieXLynxView r2, final LynxError r3) {
        n.e.d(new LynxProcess$getLifecycleObserve$1$onReceivedError$1(this, r3));
    }

    public final void n(Uri r1, AnnieXLynxView r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        Intrinsics.checkNotNullParameter(r1, "uri");
    }

    public final void onLoadFail(Uri r2, final Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "e");
        e.b.b(r2, r3);
        n.e.d(new LynxProcess$getLifecycleObserve$1$onLoadFail$1(this, r3));
    }

    public final void onTemplateReady(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "resFrom");
        Intrinsics.checkNotNullParameter(r1, "resFrom");
    }

    public final void loadImage(Context r1, String r2, String r3, float r4, float r5, Transformer r6, com.lynx.tasm.behavior.m.a r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r7, "handler");
        e.b.a(r1, r7);
    }
}
