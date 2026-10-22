package com.bytedance.android.live.browser.rts.jsbridge.service;

import android.content.Context;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.newmethods.ca;
import com.bytedance.android.live.browser.jsbridge.newmethods.j9;
import com.bytedance.android.live.browser.rts.jsbridge.api.IIESLiveRTSJSBService;
import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.android.live.liveinteract.utils.x;
import com.bytedance.android.livesdk.jsbridge.methods.CloseLiveRoomMethod;
import com.bytedance.android.livesdk.jsbridge.methods.e5;
import com.bytedance.android.livesdk.jsbridge.methods.h0;
import com.bytedance.android.livesdk.jsbridge.methods.l0;
import com.bytedance.android.livesdk.jsbridge.methods.v2;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p30.g;
import p30.h;
import p30.i;
import p30.k;
import p30.l;
import p30.m;
import p30.n;
import p30.o;
import p30.p;
import p30.q;
import p30.r;
import w20.k8;
import w20.se;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class IIESLiveRTSJSBServiceInner implements IIESLiveRTSJSBService {
    private Context context;

    public IIESLiveRTSJSBServiceInner() {
        Context r0 = null;
        this(r0, 1, r0);
    }

    public IIESLiveRTSJSBServiceInner(Context r1) {
    }

    private final Map<String, Object> dataToMap(Object r2) {
        if ((r2 instanceof JSONObject) == false) goto L7;
        int r0 = mm0.c.a;
        return mm0.c.e((JSONObject) r2);
    L7:
        if ((r2 instanceof JsonObject) == true) goto L9;
        return null;
    L9:
        return UtilsKt.i((JsonObject) r2);
    }

    public IIESLiveRTSJSBService getJsbHybridServiceInstance(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // p30.j
    public void getEnableLiveHistoryRTS(h r3, final Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Function1<i, Unit> r1 = new C03111(r4);
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        CallContext r5 = new CallContext();     // Catch: Exception -> L5
        l0 r6 = new l0();     // Catch: Exception -> L5
        r6.setProxy(new c(r5, r1));     // Catch: Exception -> L5
        r6.j(new JsonObject(), r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        Unit r7 = (Unit) r1.invoke(new i(RTSLiveJSBResponseCode.FAILED, Boolean.FALSE));
        return;
    }

    public /* synthetic */ IIESLiveRTSJSBServiceInner(Context r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    @Override // p30.j
    public void closeLiveRoomRTS(p30.a r3, final Function1<? super p30.b, Unit> r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Function1<p30.b, Unit> r1 = new AnonymousClass1(r4);
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        CallContext r6 = new CallContext();     // Catch: Exception -> L8
        if (r5 == null) goto L6;
        r6.a = r5;     // Catch: Exception -> L8
    L6:
        CloseLiveRoomMethod r7 = new CloseLiveRoomMethod();     // Catch: Exception -> L8
        h0 r0 = new h0();     // Catch: Exception -> L8
        r0.b(r3.a);     // Catch: Exception -> L8
        r7.setProxy(new a(r6, r1));     // Catch: Exception -> L8
        r7.j(r0, r6);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        if (e.getMessage() == null) goto L15;
        Unit r8 = (Unit) r1.invoke(new p30.b(RTSLiveJSBResponseCode.FAILED));
        return;
    }

    public void communityLiveAppointmentStatusRTS(p30.c r2, final Function1<? super p30.d, Unit> r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Function1<p30.d, Unit> r0 = new C03091(r3);
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r0, "callback");
        new k8();     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        RTSLiveJSBResponseCode r5 = RTSLiveJSBResponseCode.FAILED;
        Unit r6 = (Unit) r0.invoke(new p30.d(0));
        throw null;
    L12:
        throw null;
    }

    @Override // p30.j
    public void getClientSettingRTS(final p30.f r3, final Function1<Object, Unit> r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "completion");
        Function1<g, Unit> r1 = new C03101(r3, r4);
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        ca.c r6 = new ca.c();     // Catch: Exception -> L8
        r6.key = r3.a;     // Catch: Exception -> L8
        r6.type = r3.getType();     // Catch: Exception -> L8
        r6.path = r3.b;     // Catch: Exception -> L8
        CallContext r7 = new CallContext();     // Catch: Exception -> L8
        if (r5 == null) goto L6;
        r7.a = r5;     // Catch: Exception -> L8
    L6:
        ca r8 = new ca();     // Catch: Exception -> L8
        r8.setProxy(new b(r7, r1));     // Catch: Exception -> L8
        r8.j(r6, r7);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        if (e.getMessage() == null) goto L15;
        Unit r9 = (Unit) r1.invoke(new g("", RTSLiveJSBResponseCode.FAILED, String.valueOf(e.getMessage())));
        return;
    }

    public void openLiveNotificationPanelRTS(k r2, final Function1<? super l, Unit> r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Function1<l, Unit> r0 = new C03121(r3);
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r0, "callback");
        new v2();     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        RTSLiveJSBResponseCode r5 = RTSLiveJSBResponseCode.FAILED;
        Unit r6 = (Unit) r0.invoke(new l(0));
        throw null;
    L12:
        throw null;
    }

    public void openTimeScheduleRTS(m r3, final Function1<? super n, Unit> r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Function1<n, Unit> r1 = new C03131(r4);
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        j9.a r6 = new j9.a(r3.getType());     // Catch: Exception -> L8
        CallContext r7 = new CallContext();     // Catch: Exception -> L8
        if (r5 == null) goto L6;
        r7.a = r5;     // Catch: Exception -> L8
    L6:
        j9 r8 = new j9();     // Catch: Exception -> L8
        r8.setProxy(new d(r7, r1));     // Catch: Exception -> L8
        r8.l(r6, r7);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("error", String.valueOf(e.getMessage()))});
        if (e.getMessage() == null) goto L15;
        RTSLiveJSBResponseCode r11 = RTSLiveJSBResponseCode.FAILED;
        Unit r12 = (Unit) r1.invoke(new n(r9));
        return;
    }

    public void shareLiveRTS(o r2, final Function1<? super p, Unit> r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Function1<p, Unit> r0 = new C03141(r3);
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r0, "callback");
        new se();     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        RTSLiveJSBResponseCode r5 = RTSLiveJSBResponseCode.FAILED;
        Unit r6 = (Unit) r0.invoke(new p(null));
        throw null;
    L12:
        throw null;
    }

    @Override // p30.j
    public void userActionRTS(q r7, final Function1<? super r, Unit> r8, Context r9) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Function1<r, Unit> r1 = new C03151(r8);
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        CallContext r11 = new CallContext();     // Catch: Exception -> L11
        if (r9 == null) goto L6;
        r11.a = r9;     // Catch: Exception -> L11
    L6:
        e5 r12 = new e5();     // Catch: Exception -> L11
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L11
        x.a(r2, "type", r7.getType());     // Catch: Exception -> L11
        Map<String, Object> r13 = r7.b;     // Catch: Exception -> L11
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("params");     // Catch: Exception -> L11
    L9:
        x.a(r2, "args", new JSONObject(new HashMap(r13)));     // Catch: Exception -> L11
        r12.setProxy(new f(r11, r1));     // Catch: Exception -> L11
        r12.invoke(r2, r11);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        if (e.getMessage() == null) goto L21;
        RTSLiveJSBResponseCode r14 = RTSLiveJSBResponseCode.FAILED;
        String r15 = e.getMessage();
        if (r15 != null) goto L17;
        r15 = "";
    L17:
        Unit r16 = (Unit) r1.invoke(new r(r14, r15));
        return;
    }
}
