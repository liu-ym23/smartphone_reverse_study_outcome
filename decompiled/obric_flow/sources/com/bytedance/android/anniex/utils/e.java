package com.bytedance.android.anniex.utils;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.ies.bullet.secure.g;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.l0;
import com.lynx.tasm.navigator.NavigationModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static AnnieXLynxView a(FragmentActivity r10, b4.c r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "lynxModel");
        Uri r5 = r11.f860b;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        boolean r12 = r5.getBooleanQueryParameter("use_motion", false);
        h5.b r13 = new h5.b();
        b4.d r14 = r11.e;
        String r15 = r11.f;
        l0 r16 = r14.b(r15);
        r16.a(NavigationModule.class, null, NavigationModule.NAME);
        r16.a(LynxViewMonitorModule.class, r13, "hybridMonitor");
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r17 = jm.c.c(r10, r11, r16);
        AnnieXLynxView r18 = new AnnieXLynxView(r10, r15, r11.f861c, r16);
        if (r12 == false) goto L5;
        c.a(r18);
    L5:
        r18.l(r17, r11);
        r18.setViewZoom(r14.f882v);
        String r19 = r14.d;
        if (r19 == null) goto L8;
        r18.setGroupName(r19);
    L8:
        r13.f17282a = r18;
        return r18;
    }

    public static final String b(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        String r5 = r10.getScheme();
        String r11 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        String r12 = r10.getAuthority();
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        String r13 = r10.getPath();
        if (r13 == null) goto L13;
        r11 = r13;
    L13:
        if (Intrinsics.areEqual(r5, "http") == false) goto L15;
    L39:
        return "_unknown";
    L15:
        if (Intrinsics.areEqual(r5, IIvyAIPackageResourceService.SCHEMA) == true) goto L39;
        if (StringsKt.k(r12, "_popup") == false) goto L21;
        return "_popup";
    L21:
        if (StringsKt.k(r12, "_page") == false) goto L23;
    L38:
        return "_page";
    L23:
        if (Intrinsics.areEqual(r12, "lynxview") == true) goto L38;
        if (Intrinsics.areEqual(r12, "webview") == true) goto L38;
        if (StringsKt.k(r11, "_popup") == false) goto L31;
        return "_popup";
    L31:
        if (StringsKt.k(r11, "_page") == true) goto L38;
        if (Intrinsics.areEqual(r11, "lynxview") == true) goto L38;
        if (Intrinsics.areEqual(r11, "webview") == true) goto L38;
        return "_unknown";
    }

    public static final String c(Uri r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        String r5 = io.reactivex.exceptions.a.h(r11, "ssr_url");
        Object r10 = null;
        if (r5 != null) goto L45;
        return null;
    L45:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L15
        Uri r15 = Uri.parse(r5);     // Catch: Throwable -> L15
        Uri.Builder r16 = r15.buildUpon();     // Catch: Throwable -> L15
        boolean r17 = false;
        if (io.reactivex.exceptions.a.h(r15, "appended_global_props") != null) goto L25;
        String r18 = io.reactivex.exceptions.a.h(r11, "append_global_props");     // Catch: Throwable -> L15
        if (r18 != null) goto L10;
    L17:
        List r19 = null;
    L18:
        if (r19 == null) goto L25;
        if (r19.isEmpty() == true) goto L25;
        if (g.b(r15) == false) goto L25;
        r16.appendQueryParameter("appended_global_props", new JSONObject(o3.a.d(r11, r12, r13, r19)).toString());     // Catch: Throwable -> L15
        goto L25
    L10:
        if (r18.length() > 0) goto L13;
        r18 = null;
    L13:
        if (r18 == null) goto L17;
        r19 = StringsKt.K(r18, new String[]{","}, 0, 6);     // Catch: Throwable -> L15
    L25:
        r16.appendQueryParameter("disable_offline", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(io.reactivex.exceptions.a.h(r15, "append_common_params"), "0") == false) goto L28;
    L30:
        String r110 = r16.build().toString();     // Catch: Throwable -> L15
        if (r17 == false) goto L33;
        StringBuilder r111 = new StringBuilder(r110);     // Catch: Throwable -> L15
        g.a(r15, r111);     // Catch: Throwable -> L15
        r110 = r111.toString();     // Catch: Throwable -> L15
    L33:
        Object r112 = Result.m124constructorimpl(r110);     // Catch: Throwable -> L15
    L37:
        if (Result.m130isFailureimpl(r112) == true) goto L40;
        r10 = r112;
    L40:
        String r20 = (String) r10;
        if (r20 != null) goto L44;
        return r5;
    L44:
        return r20;
    L28:
        if (Intrinsics.areEqual(io.reactivex.exceptions.a.h(r11, "append_common_params"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L30;
        r17 = true;
    L15:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    public static void d(b4.c r10, final AnnieXLynxView r11, com.bytedance.sdk.xbridge.cn.platform.lynx.a r12, rb.b r13) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r13, "providerFactory");
        Function2<String, Object, Unit> r14 = new WebcastContainerInitializerInAnnieX$initializeWithAnnieXLynxModelInLynx$1(r11);
        Uri r5 = r10.f860b;
        defpackage.c.b(r11, r12, r13, r10.f, r5, r14);
    }

    public static final void e(LynxView r5, String r10, JavaOnlyArray r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        if (r5.enableJSRuntime() == false) goto L6;
        r5.sendGlobalEvent(r10, r11);
        return;
    L6:
        r5.triggerEventBus(r10, r11);
    }

    public static final boolean f(d r11, Uri r12) {
        Intrinsics.checkNotNullParameter(r11, "pageOptContainer");
        Intrinsics.checkNotNullParameter(r12, "schema");
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r13 = (xc.d) r10.a(xc.d.class);
        if (r13 == null) goto L10;
        Boolean r14 = r13.B0();
        if (r14 == null) goto L10;
        boolean r15 = r14.booleanValue();
    L9:
        boolean r16 = r15;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r17 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r17 == null) goto L18;
        xc.d r18 = (xc.d) r17.a(xc.d.class);
        if (r18 == null) goto L18;
        List r19 = r18.W();
        if (r19 == null) goto L18;
    L17:
        List r20 = r19;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r21 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r21 == null) goto L26;
        xc.d r22 = (xc.d) r21.a(xc.d.class);
        if (r22 == null) goto L26;
        List r23 = r22.a0();
        if (r23 == null) goto L26;
    L28:
        return g(r11, r12, r16, r20, r23, "flow");
    L26:
        r23 = new ArrayList();
    L18:
        r19 = new ArrayList();
    L10:
        r15 = true;
        goto L9
    }

    public static final boolean g(d r5, Uri r10, boolean r11, List r12, List r13, String r14) {
        if (r11 == true) goto L5;
        return false;
    L5:
        String r15 = io.reactivex.exceptions.a.b(r10, "default_bid");
        if (r15 != null) goto L8;
        r15 = r10.toString();
    L8:
        Iterator r16 = r12.iterator();
    L10:
        if (r16.hasNext() == false) goto L15;
        if (StringsKt.g(r15, (String) r16.next()) == false) goto L10;
        return false;
    L15:
        if (Intrinsics.areEqual(r5.f3502a, r14) == false) goto L17;
        return true;
    L17:
        Iterator r17 = r13.iterator();
    L19:
        if (r17.hasNext() == false) goto L24;
        if (StringsKt.g(r15, (String) r17.next()) == false) goto L19;
        r5.f3502a = r14;
        return true;
    L24:
        return false;
    }

    public static final boolean h(String r5) {
        if (Intrinsics.areEqual(r5, "flow") == false) goto L14;
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L11;
        xc.d r12 = (xc.d) r11.a(xc.d.class);
        if (r12 == null) goto L11;
        Boolean r13 = r12.D0();
        if (r13 == null) goto L11;
        boolean r14 = r13.booleanValue();
    L12:
        if (r14 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        r14 = true;
        goto L12
    L14:
        return false;
    }

    public static final String i(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r10 = j(r5);
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        if (r10.length() != 0) goto L24;
        String r11 = io.reactivex.exceptions.a.h(r5, LynxMonitorService.KEY_CHANNEL);
        String r12 = io.reactivex.exceptions.a.h(r5, "bundle");
        if (r11 == null) goto L19;
        if (r11.length() == 0) goto L19;
        if (r12 == null) goto L19;
        if (r12.length() == 0) goto L19;
        return androidx.constraintlayout.motion.widget.a.m(r11, '_', r12);
    L19:
        if (r10.length() == 0) goto L21;
        return r10;
    L21:
        return r5.toString();
    L24:
        return Uri.parse(r10).buildUpon().clearQuery().toString();
    }

    public static final String j(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.getScheme(), "http") == true) goto L15;
        if (Intrinsics.areEqual(r5.getScheme(), IIvyAIPackageResourceService.SCHEMA) == true) goto L15;
        String r10 = io.reactivex.exceptions.a.h(r5, "a_surl");
        if (r10 != null) goto L13;
        r10 = io.reactivex.exceptions.a.h(r5, "surl");
        if (r10 != null) goto L13;
        return io.reactivex.exceptions.a.h(r5, "url");
    L13:
        return r10;
    L15:
        return r5.toString();
    }

    public static final boolean k(d r11, Uri r12) {
        Intrinsics.checkNotNullParameter(r11, "pageOptContainer");
        Intrinsics.checkNotNullParameter(r12, "schema");
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L10;
        xc.d r13 = (xc.d) r10.a(xc.d.class);
        if (r13 == null) goto L10;
        Boolean r14 = r13.I0();
        if (r14 == null) goto L10;
        boolean r15 = r14.booleanValue();
    L9:
        boolean r16 = r15;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r17 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r17 == null) goto L18;
        xc.d r18 = (xc.d) r17.a(xc.d.class);
        if (r18 == null) goto L18;
        List r19 = r18.c0();
        if (r19 == null) goto L18;
    L17:
        List r20 = r19;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r21 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r21 == null) goto L26;
        xc.d r22 = (xc.d) r21.a(xc.d.class);
        if (r22 == null) goto L26;
        List r23 = r22.e0();
        if (r23 == null) goto L26;
    L28:
        return g(r11, r12, r16, r20, r23, "lite_page");
    L26:
        r23 = new ArrayList();
    L18:
        r19 = new ArrayList();
    L10:
        r15 = true;
        goto L9
    }
}
