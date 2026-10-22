package com.bytedance.android.monitorV2.lynx;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import androidx.room.RoomDatabase;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.h;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.salamander.anniex.q;
import com.bytedance.salamander.anniex.u;
import com.lynx.tasm.LynxView;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import l9.o;
import oo.j;
import org.json.JSONObject;
import x4.f;
import x4.g;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements j5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f3639b = 0;

    static {
        f3638a = b.f3634a;
        long r5 = 1000;
        f3639b = ((System.currentTimeMillis() * r5) * r5) - SystemClock.elapsedRealtimeNanos();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(LynxView r5, final g5.d r10, com.bytedance.android.monitorV2.event.a r11) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "lynxNativeErrorData");
        d5.b.f("LynxViewMonitor", "reportError: errorCode: " + r10.f17057c);
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = "nativeError";
        final Function0<Unit> r13 = new LynxViewMonitor$reportError$mappingV2$1(r10, r12);
        final Ref.IntRef r14 = new Ref.IntRef();
        r14.element = 201;
        new LynxViewMonitor$reportError$mappingV3$1(r10, r12, r14, r13).invoke();
        String r15 = (String) r12.element;
        r10.f22098a = r15;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r11.f3557a = r15;
        r11.f3550m = r10;
        com.lynx.tasm.behavior.d r16 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k;
        Intrinsics.checkNotNull(r11);
        r16.h(r5, r11);
        r16.g(r5, r11, r10.f17057c, r10.d);
        if (Intrinsics.areEqual(r11.f3557a, "js_exception") == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r10.f17056b, "lynx_error_custom") == true) goto L13;
        String r17 = (String) r16.a(r5, null).f3688c.f12570h;
        if (r17 == null) goto L14;
        String r18 = r10.d;
        if (r18 == null) goto L15;
        q r19 = c4.a.f1115a;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        r19.f7275c.h(new u(r18, r14.element));
        return;
    L15:
        return;
    L14:
        return;
    }

    public static void e(LynxView r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r11, "o");
        Intrinsics.checkNotNullParameter(r5, "view");
        com.lynx.tasm.behavior.d r12 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k;
        if (r12.a(r5, null).f3688c.f12567a == true) goto L5;
        return;
    L5:
        h.e().a().d().getClass();
        if (Switches.f3587b.f3600a == false) goto L11;
        h.e().a().d().getClass();
        if (Switches.g.f3600a == false) goto L12;
        ((g5.b) r12.a(r5, null).f3691j.getValue()).s(r10, r11);
        return;
    L12:
        return;
    }

    public static void f(LynxView r5, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "eventType");
        Intrinsics.checkNotNullParameter(r11, "inputJsonObject");
        d5.b.f("LynxViewMonitor", "handleNativeInfo: eventTYpe: " + r10);
        com.lynx.tasm.behavior.d r12 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k;
        Intrinsics.checkNotNullParameter(r10, "eventType");
        Intrinsics.checkNotNullParameter(r11, "data");
        m5.c r13 = new m5.c(r10, r11);
        Intrinsics.checkNotNullParameter(r10, "eventType");
        r12.h(r5, j.c(r10, r13, null));
    }

    public static void g(LynxView r5, x4.c r10) {
        Intrinsics.checkNotNullParameter(r10, "customInfo");
        Handler r11 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new LynxViewMonitor$reportCustom$1(r5, r10));
    }

    public static void h(final LynxView r5, final f r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "errorData");
        d5.b.f("LynxViewMonitor", "reportJsbError");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter("jsbError", "eventType");     // Catch: Throwable -> L8
        final com.bytedance.android.monitorV2.event.a r12 = j.c("jsbError", r10, null);     // Catch: Throwable -> L8
        boolean r13 = Switches.f3591j.f3600a;     // Catch: Throwable -> L8
        r12.d(!r13, HybridEvent$TerminateType.f3540a);     // Catch: Throwable -> L8
        if (r13 == false) goto L13;
        r12.c("jsb_error_extra", null);     // Catch: Throwable -> L8
        Handler r14 = com.bytedance.android.monitorV2.executor.b.f3573a;     // Catch: Throwable -> L8
        Function0<Unit> r15 = new LynxViewMonitor$reportJsbError$1$1(r5, r12, r10);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r15, "runnable");     // Catch: Throwable -> L8
        com.bytedance.android.monitorV2.executor.b.f3573a.post(new com.bytedance.android.monitorV2.executor.a(0, r15));     // Catch: Throwable -> L8
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L13:
        return;
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static void i(LynxView r5, g r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "infoData");
        com.lynx.tasm.behavior.d r11 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k;
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter("jsbPerf", "eventType");
        d5.b.f("LynxViewMonitor", "reportJsbInfo");
        Intrinsics.checkNotNullParameter("jsbPerf", "eventType");
        com.bytedance.android.monitorV2.event.a r12 = j.c("jsbPerf", r10, null);
        h.e().a().d().getClass();
        boolean r13 = Switches.f3591j.f3600a;
        r12.d(!r13, HybridEvent$TerminateType.f3540a);
        if (r13 == true) goto L5;
        return;
    L5:
        r11.h(r5, r12);
    }

    @Override // j5.d
    public final void a(String r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "field");
        Intrinsics.checkNotNullParameter(r10, "value");
    }

    @Override // j5.d
    public final void b(View r5, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
        if ((r5 instanceof LynxView) == false) goto L6;
        f((LynxView) r5, r10, r11);
        return;
    L6:
        d5.b.e("LynxViewMonitor", "handleNativeInfo: view not match LynxView");
    }

    @Override // j5.d
    public final void c(View r5, x4.c r10) {
        Intrinsics.checkNotNullParameter(r10, "customInfo");
        boolean r11 = r5 instanceof LynxView;
        if (r11 == true) goto L6;
        if (r5 == null) goto L6;
        d5.b.e("LynxViewMonitor", "customReport: view not match LynxView");
        return;
    L6:
        if (r11 == false) goto L8;
        LynxView r12 = (LynxView) r5;
    L9:
        Intrinsics.checkNotNullParameter(r10, "customInfo");
        Handler r13 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new LynxViewMonitor$reportCustom$1(r12, r10));
        return;
    L8:
        r12 = null;
        goto L9
    }

    @Override // j5.d
    public final void a(View r5, String r10, x4.a r11, j5.c r12) {
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Intrinsics.checkNotNullParameter(r11, "base");
        Intrinsics.checkNotNullParameter(r12, "error");
        StringBuilder r13 = new StringBuilder("reportContainerError, errorCode: ");
        int r14 = r12.f18238a;
        r13.append(r14);
        d5.b.f("LynxViewMonitor", r13.toString());
        x4.b r15 = new x4.b();
        Intrinsics.checkNotNullParameter("containerError", "eventType");
        com.bytedance.android.monitorV2.event.a r16 = j.c("containerError", r15, null);
        r16.f3560h = r11;
        r16.f3551n = new x4.a(1, MapsKt.mapOf(new Pair[]{TuplesKt.to("container_load_error_code", Integer.valueOf(r14)), TuplesKt.to("container_load_error_msg", r12.f18239b)}));
        if (r5 != null) goto L11;
        com.bytedance.android.monitorV2.webview.a r17 = new com.bytedance.android.monitorV2.webview.a();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r12.d, "bid");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r17, "monitor");     // Catch: Throwable -> L7
        g5.b r18 = new g5.b();     // Catch: Throwable -> L7
        r18.f = r12.f18240c;     // Catch: Throwable -> L7
        r18.f17050j = RoomDatabase.MAX_BIND_PARAMETER_CNT;     // Catch: Throwable -> L7
        Activity r19 = o.a(null);     // Catch: Throwable -> L7
        if (r19 == null) goto L9;
        r18.d = r19.getClass().getName();     // Catch: Throwable -> L7
    L9:
        Intrinsics.checkNotNullParameter(r18, "<set-?>");     // Catch: Throwable -> L7
        r16.f = r18;     // Catch: Throwable -> L7
        com.bytedance.android.monitorV2.lynx.impl.d.f3683k.h((LynxView) r5, r16);     // Catch: Throwable -> L7
        return;
    L11:
        com.lynx.tasm.behavior.d r20 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k;     // Catch: Throwable -> L7
        g5.b r21 = (g5.b) r20.a((LynxView) r5, null).f3691j.getValue();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r21, "<set-?>");     // Catch: Throwable -> L7
        r16.f = r21;     // Catch: Throwable -> L7
        r16.f3560h = j5.b.g(r5);     // Catch: Throwable -> L7
        r20.h((LynxView) r5, r16);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        r16.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", th);
    }

    @Override // j5.d
    public final x4.d a(View r5) {
        if ((r5 instanceof LynxView) == false) goto L5;
        LynxView r10 = (LynxView) r5;
    L6:
        if (r10 == null) goto L16;
        com.bytedance.android.monitorV2.lynx.impl.e r11 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k.a((LynxView) r5, null).e;
        if (r11 == null) goto L14;
        x4.d r12 = r11.f3699n;
        if (r12 == null) goto L14;
        return r12;
    L14:
        return new x4.d(new x4.h());
    L16:
        return new x4.d(new x4.h());
    L5:
        r10 = null;
        goto L6
    }
}
