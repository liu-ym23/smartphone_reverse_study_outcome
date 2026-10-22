package com.bytedance.android.livesdk.dslservice.lynxair;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.q1;
import io.reactivex.subjects.SingleSubject;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yt1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LynxAirDSLProcess$getLifecycleObserve$3 implements com.bytedance.android.anniex.ui.e {
    public final /* synthetic */ LynxAirDSLProcess a;
    public final /* synthetic */ m b;
    public final /* synthetic */ a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ SingleSubject e;
    public final /* synthetic */ Long f;

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
        com.bytedance.android.livesdk.dslservice.util.m.h.d(new LynxAirDSLProcess$getLifecycleObserve$3$onFirstScreen$1(this));
        this.e.onSuccess("");
    }

    public final void f(AnnieXLynxView r2) {
        com.bytedance.android.livesdk.dslservice.util.m.h.d(new LynxAirDSLProcess$getLifecycleObserve$3$onDataUpdated$1(this));
        this.e.onSuccess("");
    }

    public final void onTimingSetup(Map<String, Object> r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L25
        if (((Boolean) dt2.c.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        Unit r1 = null;
        if (r6 == null) goto L8;
        Object r7 = r6.get("setup_timing");     // Catch: Throwable -> L25
    L10:
        if ((r7 instanceof HashMap) == true) goto L12;
        r7 = null;
    L12:
        HashMap r8 = (HashMap) r7;     // Catch: Throwable -> L25
        if (r8 == null) goto L16;
        Long r9 = (Long) r8.get("load_template_end");     // Catch: Throwable -> L25
        if (r9 == null) goto L16;
    L17:
        long r2 = r9.longValue();     // Catch: Throwable -> L25
        Long r10 = this.f;     // Catch: Throwable -> L25
        if (r10 == null) goto L23;
        long r3 = r10.longValue();     // Catch: Throwable -> L25
        com.bytedance.android.livesdk.dslservice.util.m r11 = com.bytedance.android.livesdk.dslservice.util.m.h;     // Catch: Throwable -> L25
        long r4 = r2 - r3;     // Catch: Throwable -> L25
        String r5 = this.d;     // Catch: Throwable -> L25
        String r12 = this.c.f;     // Catch: Throwable -> L25
        if (r12 != null) goto L22;
        r12 = "UnKnown";
    L22:
        r11.i(r4, r5, r12);     // Catch: Throwable -> L25
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Result.constructor-impl(r1);     // Catch: Throwable -> L25
        return;
    L16:
        r9 = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L25
        goto L17
    L8:
        r7 = null;
    L25:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void b(AnnieXLynxView r2, final String r3) {
        com.bytedance.android.livesdk.dslservice.util.m.h.d(new LynxAirDSLProcess$getLifecycleObserve$3$onLoadFailed$1(this, r3));
        if (this.e.hasThrowable() == true) goto L9;
        SingleSubject r4 = this.e;
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r4.onError(new Exception(r3));
        return;
    }

    public final void d(Uri r1, AnnieXLynxView r2) {
        com.bytedance.android.livesdk.dslservice.util.m.h.d(new LynxAirDSLProcess$getLifecycleObserve$3$onLoadUriSuccess$1(this));
        if (((Boolean) dt2.c.a.getValue()).booleanValue() == true) goto L6;
        this.e.onSuccess("");
        return;
    }

    public final void g(AnnieXLynxView r2, final LynxError r3) {
        com.bytedance.android.livesdk.dslservice.util.m.h.d(new LynxAirDSLProcess$getLifecycleObserve$3$onReceivedError$1(this, r3));
        if (this.e.hasThrowable() == true) goto L11;
        SingleSubject r4 = this.e;
        if (r3 == null) goto L8;
        String r5 = r3.toString();
        if (r5 == null) goto L8;
    L9:
        r4.onError(new Exception(r5));
        return;
    L8:
        r5 = "";
        goto L9
    }

    public final void n(Uri r1, AnnieXLynxView r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        Intrinsics.checkNotNullParameter(r1, "uri");
    }

    public final void onLoadFail(Uri r2, final Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "e");
        com.bytedance.android.anniex.ui.e.b.b(r2, r3);
        com.bytedance.android.livesdk.dslservice.util.m.h.d(new LynxAirDSLProcess$getLifecycleObserve$3$onLoadFail$1(this, r3));
        if (this.e.hasThrowable() == true) goto L6;
        this.e.onError(r3);
        return;
    }

    public final void onTemplateReady(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "resFrom");
        if (this.a.h == false) goto L24;
        m r4 = this.b;
        if (r4 == null) goto L7;
        r4.onFetchSuccess();
    L7:
        a r5 = this.c;
        switch(r2.hashCode()) {
            case -1785310379: goto L20;
            case -318613945: goto L17;
            case 98349: goto L14;
            case 98230121: goto L11;
            default: goto L22;
        };
    L22:
        r5.f = r2;
        return;
    L11:
        if (r2.equals("gecko") == false) goto L22;
        r2 = "LocalRawData";
        goto L22
    L14:
        if (r2.equals("cdn") == false) goto L22;
        r2 = "RemoteData";
        goto L22
    L17:
        if (r2.equals("externalTemplateBundle") == false) goto L22;
        r2 = "NodeCache";
        goto L22
    L20:
        if (r2.equals("cdnCache") == false) goto L22;
        r2 = "LocalCdnCacheData";
        goto L22
    }

    public LynxAirDSLProcess$getLifecycleObserve$3(LynxAirDSLProcess r1, m r2, a r3, String r4, SingleSubject r5, Long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void loadImage(Context r1, String r2, String r3, float r4, float r5, Transformer r6, com.lynx.tasm.behavior.m.a r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r7, "handler");
        com.bytedance.android.anniex.ui.e.b.a(r1, r7);
    }
}
