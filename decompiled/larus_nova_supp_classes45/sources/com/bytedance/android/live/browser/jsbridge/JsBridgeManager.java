package com.bytedance.android.live.browser.jsbridge;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.base.ResultCodeEnumSerializer;
import com.bytedance.android.live.browser.jsbridge.newmethods.GetVisualEventTrackingSettingsMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.OpenLiveEffectPanelMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.ShowPaidLiveTicketEditPageMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.ShowStikerMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.ac;
import com.bytedance.android.live.browser.jsbridge.newmethods.ad;
import com.bytedance.android.live.browser.jsbridge.newmethods.b4;
import com.bytedance.android.live.browser.jsbridge.newmethods.b9;
import com.bytedance.android.live.browser.jsbridge.newmethods.bb;
import com.bytedance.android.live.browser.jsbridge.newmethods.c4;
import com.bytedance.android.live.browser.jsbridge.newmethods.c6;
import com.bytedance.android.live.browser.jsbridge.newmethods.c9;
import com.bytedance.android.live.browser.jsbridge.newmethods.ca;
import com.bytedance.android.live.browser.jsbridge.newmethods.cd;
import com.bytedance.android.live.browser.jsbridge.newmethods.d4;
import com.bytedance.android.live.browser.jsbridge.newmethods.d5;
import com.bytedance.android.live.browser.jsbridge.newmethods.d8;
import com.bytedance.android.live.browser.jsbridge.newmethods.dc;
import com.bytedance.android.live.browser.jsbridge.newmethods.dd;
import com.bytedance.android.live.browser.jsbridge.newmethods.e4;
import com.bytedance.android.live.browser.jsbridge.newmethods.e5;
import com.bytedance.android.live.browser.jsbridge.newmethods.e7;
import com.bytedance.android.live.browser.jsbridge.newmethods.eb;
import com.bytedance.android.live.browser.jsbridge.newmethods.f6;
import com.bytedance.android.live.browser.jsbridge.newmethods.f9;
import com.bytedance.android.live.browser.jsbridge.newmethods.fa;
import com.bytedance.android.live.browser.jsbridge.newmethods.fb;
import com.bytedance.android.live.browser.jsbridge.newmethods.fc;
import com.bytedance.android.live.browser.jsbridge.newmethods.g5;
import com.bytedance.android.live.browser.jsbridge.newmethods.g6;
import com.bytedance.android.live.browser.jsbridge.newmethods.g8;
import com.bytedance.android.live.browser.jsbridge.newmethods.g9;
import com.bytedance.android.live.browser.jsbridge.newmethods.gb;
import com.bytedance.android.live.browser.jsbridge.newmethods.ge;
import com.bytedance.android.live.browser.jsbridge.newmethods.hc;
import com.bytedance.android.live.browser.jsbridge.newmethods.hd;
import com.bytedance.android.live.browser.jsbridge.newmethods.i5;
import com.bytedance.android.live.browser.jsbridge.newmethods.i9;
import com.bytedance.android.live.browser.jsbridge.newmethods.id;
import com.bytedance.android.live.browser.jsbridge.newmethods.j9;
import com.bytedance.android.live.browser.jsbridge.newmethods.kb;
import com.bytedance.android.live.browser.jsbridge.newmethods.l3;
import com.bytedance.android.live.browser.jsbridge.newmethods.l8;
import com.bytedance.android.live.browser.jsbridge.newmethods.m3;
import com.bytedance.android.live.browser.jsbridge.newmethods.m5;
import com.bytedance.android.live.browser.jsbridge.newmethods.m8;
import com.bytedance.android.live.browser.jsbridge.newmethods.m9;
import com.bytedance.android.live.browser.jsbridge.newmethods.mb;
import com.bytedance.android.live.browser.jsbridge.newmethods.mc;
import com.bytedance.android.live.browser.jsbridge.newmethods.n3;
import com.bytedance.android.live.browser.jsbridge.newmethods.n9;
import com.bytedance.android.live.browser.jsbridge.newmethods.o3;
import com.bytedance.android.live.browser.jsbridge.newmethods.o4;
import com.bytedance.android.live.browser.jsbridge.newmethods.o6;
import com.bytedance.android.live.browser.jsbridge.newmethods.o8;
import com.bytedance.android.live.browser.jsbridge.newmethods.o9;
import com.bytedance.android.live.browser.jsbridge.newmethods.p3;
import com.bytedance.android.live.browser.jsbridge.newmethods.p9;
import com.bytedance.android.live.browser.jsbridge.newmethods.qb;
import com.bytedance.android.live.browser.jsbridge.newmethods.rb;
import com.bytedance.android.live.browser.jsbridge.newmethods.s6;
import com.bytedance.android.live.browser.jsbridge.newmethods.sb;
import com.bytedance.android.live.browser.jsbridge.newmethods.sc;
import com.bytedance.android.live.browser.jsbridge.newmethods.t4;
import com.bytedance.android.live.browser.jsbridge.newmethods.tb;
import com.bytedance.android.live.browser.jsbridge.newmethods.tc;
import com.bytedance.android.live.browser.jsbridge.newmethods.ud;
import com.bytedance.android.live.browser.jsbridge.newmethods.v3;
import com.bytedance.android.live.browser.jsbridge.newmethods.v4;
import com.bytedance.android.live.browser.jsbridge.newmethods.v8;
import com.bytedance.android.live.browser.jsbridge.newmethods.v9;
import com.bytedance.android.live.browser.jsbridge.newmethods.w4;
import com.bytedance.android.live.browser.jsbridge.newmethods.wd;
import com.bytedance.android.live.browser.jsbridge.newmethods.x2;
import com.bytedance.android.live.browser.jsbridge.newmethods.x7;
import com.bytedance.android.live.browser.jsbridge.newmethods.x8;
import com.bytedance.android.live.browser.jsbridge.newmethods.x9;
import com.bytedance.android.live.browser.jsbridge.newmethods.y8;
import com.bytedance.android.live.browser.jsbridge.newmethods.yd;
import com.bytedance.android.live.browser.jsbridge.newmethods.z6;
import com.bytedance.android.live.browser.jsbridge.newmethods.z8;
import com.bytedance.android.live.browser.jsbridge.newmethods.zb;
import com.bytedance.android.live.browser.jsbridge.newmethods.zd;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.config.s8;
import com.bytedance.android.livesdk.config.t30;
import com.bytedance.android.livesdk.config.t8;
import com.bytedance.android.livesdk.config.v00;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService;
import com.bytedance.android.livesdk.interactivity.api.IVirtualInteractService;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.hybridapi.IMiddlewareJsBridgeManager;
import com.bytedance.android.livesdkapi.jsb.ExternalJsBridgeMethodInjector;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeRegister;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeManager implements IJsBridgeManager {
    public static final Lazy n = null;
    public final HashSet<BaseJsBridgeMethodFactory> a;
    public final WeakReference<Context> b;
    public WeakReference<AlertDialog> c;
    public final ILiveHybridContainer d;
    public final List<String> e;
    public com.bytedance.ies.web.jsbridge2.d0 f;
    public com.bytedance.ies.web.jsbridge2.f0 g;
    public final com.bytedance.android.live.browser.jsbridge.l h;
    public com.bytedance.android.live.browser.v i;
    public final IMiddlewareJsBridgeManager j;
    public final Activity k;
    public final int l;
    public final Function1<JsBridgeManager, Unit> m;

    public static final class a {
    }

    public static final class a0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a0 a = null;

        static {
            a = new a0();
        }

        public a0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fa();
        }
    }

    public static final class a1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a1 a = null;

        static {
            a = new a1();
        }

        public a1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IVirtualInteractService.class).getCreateActorMethod();
        }
    }

    public static final class a2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a2 a = null;

        static {
            a = new a2();
        }

        public a2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m9();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.q {
        public b() {
        }

        public final <T> String a(T r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            Class<?> r0 = r4.getClass();
            if (Intrinsics.areEqual(r0, JsonObject.class) == true) goto L15;
            if (Intrinsics.areEqual(r0, JsonArray.class) == true) goto L15;
            if (Intrinsics.areEqual(r0, String.class) == false) goto L11;
            return r4.toString();
        L11:
            if ((r4 instanceof aa) == false) goto L18;
            GsonBuilder r1 = GsonHelper.builder();
            r1.registerTypeHierarchyAdapter(z9.class, new ResultCodeEnumSerializer());
            return GsonProtectorUtils.toJson(r1.create(), r4);
        L18:
            return GsonProtectorUtils.toJson(GsonHelper.get(), r4);
        L15:
            return r4.toString();
        }

        public final <T> T b(String r2, Type r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "type");
            return (T) GsonProtectorUtils.fromJson(GsonHelper.get(), r2, r3);
        }
    }

    public static final class b0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JsBridgeManager a;

        public b0(JsBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g30.a(this.a.d);
        }
    }

    public static final class b1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b1 a = null;

        static {
            a = new b1();
        }

        public b1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IVirtualInteractService.class).getInteractionCommandMethod();
        }
    }

    public static final class b2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b2 a = null;

        static {
            a = new b2();
        }

        public b2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new w4();
        }
    }

    public static final class c implements h8.b {
        public c() {
        }

        public final void f(Map r4) {
            Intrinsics.checkNotNullParameter("livesdk_live_jsbridge_call", "eventName");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_jsbridge_call", r4, new Object[0]);
        }
    }

    public static final class c0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c0 a = null;

        static {
            a = new c0();
        }

        public c0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.j2();
        }
    }

    public static final class c1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c1 a = null;

        static {
            a = new c1();
        }

        public c1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new c9();
        }
    }

    public static final class c2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c2 a = null;

        static {
            a = new c2();
        }

        public c2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new dd();
        }
    }

    public static final class d extends com.bytedance.ies.web.jsbridge2.a {
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.b c;

        public final View b() {
            return this.c.g();
        }

        public d(com.bytedance.ies.web.jsbridge2.b r1) {
            this.c = r1;
        }
    }

    public static final class d0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d0 a = null;

        static {
            a = new d0();
        }

        public d0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new i9();
        }
    }

    public static final class d1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d1 a = null;

        static {
            a = new d1();
        }

        public d1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g9();
        }
    }

    public static final class d2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d2 a = null;

        static {
            a = new d2();
        }

        public d2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d5();
        }
    }

    public static final class e implements h8.b {
        public e() {
        }

        public final void f(Map r4) {
            Intrinsics.checkNotNullParameter("livesdk_live_jsbridge_call", "eventName");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_jsbridge_call", r4, new Object[0]);
        }
    }

    public static final class e0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e0 a = null;

        static {
            a = new e0();
        }

        public e0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g30.b();
        }
    }

    public static final class e1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e1 a = null;

        static {
            a = new e1();
        }

        public e1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f9();
        }
    }

    public static final class e2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e2 a = null;

        static {
            a = new e2();
        }

        public e2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new t4();
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.q {
        public f() {
        }

        public final <T> String a(T r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            Class<?> r0 = r4.getClass();
            if (Intrinsics.areEqual(r0, JsonObject.class) == true) goto L15;
            if (Intrinsics.areEqual(r0, JsonArray.class) == true) goto L15;
            if (Intrinsics.areEqual(r0, String.class) == false) goto L11;
            return r4.toString();
        L11:
            if ((r4 instanceof aa) == false) goto L18;
            GsonBuilder r1 = GsonHelper.builder();
            r1.registerTypeHierarchyAdapter(z9.class, new ResultCodeEnumSerializer());
            return GsonProtectorUtils.toJson(r1.create(), r4);
        L18:
            return GsonProtectorUtils.toJson(GsonHelper.get(), r4);
        L15:
            return r4.toString();
        }

        public final <T> T b(String r2, Type r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "type");
            return (T) GsonProtectorUtils.fromJson(GsonHelper.get(), r2, r3);
        }
    }

    public static final class f0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f0 a = null;

        static {
            a = new f0();
        }

        public f0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new x2();
        }
    }

    public static final class f1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f1 a = null;

        static {
            a = new f1();
        }

        public f1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e5();
        }
    }

    public static final class f2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f2 a = null;

        static {
            a = new f2();
        }

        public f2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.r1();
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ GeolocationPermissions.Callback b;

        public g(String r1, GeolocationPermissions.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            if (r4 != (-2)) goto L9;
            GeolocationPermissions.Callback r5 = this.b;
            if (r5 == null) goto L7;
            r5.invoke(this.a, false, false);
        L7:
            r3.dismiss();
            return;
        L9:
            if (r4 != (-1)) goto L16;
            GeolocationPermissions.Callback r6 = this.b;
            if (r6 == null) goto L13;
            r6.invoke(this.a, true, true);
        L13:
            r3.dismiss();
            return;
        }
    }

    public static final class g0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g0 a = null;

        static {
            a = new g0();
        }

        public g0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new kb();
        }
    }

    public static final class g1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g1 a = null;

        static {
            a = new g1();
        }

        public g1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new c9();
        }
    }

    public static final class g2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g2 a = null;

        static {
            a = new g2();
        }

        public g2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d4();
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m3();
        }
    }

    public static final class h0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h0 a = null;

        static {
            a = new h0();
        }

        public h0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.z();
        }
    }

    public static final class h1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h1 a = null;

        static {
            a = new h1();
        }

        public h1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new sc();
        }
    }

    public static final class h2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h2 a = null;

        static {
            a = new h2();
        }

        public h2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new eb();
        }
    }

    public static final class i implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ShowPaidLiveTicketEditPageMethod();
        }
    }

    public static final class i0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i0 a = null;

        static {
            a = new i0();
        }

        public i0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new qb();
        }
    }

    public static final class i1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i1 a = null;

        static {
            a = new i1();
        }

        public i1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new OpenLiveEffectPanelMethod();
        }
    }

    public static final class i2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i2 a = null;

        static {
            a = new i2();
        }

        public i2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.y1();
        }
    }

    public static final class j implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g8();
        }
    }

    public static final class j0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j0 a = null;

        static {
            a = new j0();
        }

        public j0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.y();
        }
    }

    public static final class j1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JsBridgeManager a;

        public j1(JsBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new b4(this.a.d);
        }
    }

    public static final class j2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j2 a = null;

        static {
            a = new j2();
        }

        public j2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new b9();
        }
    }

    public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ge();
        }
    }

    public static final class k0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k0 a = null;

        static {
            a = new k0();
        }

        public k0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new zb();
        }
    }

    public static final class k1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k1 a = null;

        static {
            a = new k1();
        }

        public k1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new id();
        }
    }

    public static final class k2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k2 a = null;

        static {
            a = new k2();
        }

        public k2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.a0();
        }
    }

    public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new n9();
        }
    }

    public static final class l0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l0 a = null;

        static {
            a = new l0();
        }

        public l0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new x8();
        }
    }

    public static final class l1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l1 a = null;

        static {
            a = new l1();
        }

        public l1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.w1();
        }
    }

    public static final class l2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l2 a = null;

        static {
            a = new l2();
        }

        public l2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new n3();
        }
    }

    public static final class m implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.aa();
        }
    }

    public static final class m0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m0 a = null;

        static {
            a = new m0();
        }

        public m0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new y8();
        }
    }

    public static final class m1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m1 a = null;

        static {
            a = new m1();
        }

        public m1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new s6();
        }
    }

    public static final class m2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m2 a = null;

        static {
            a = new m2();
        }

        public m2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new o3();
        }
    }

    public static final class n implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new gb();
        }
    }

    public static final class n0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n0 a = null;

        static {
            a = new n0();
        }

        public n0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getCanShowMethod();
        }
    }

    public static final class n1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n1 a = null;

        static {
            a = new n1();
        }

        public n1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f6();
        }
    }

    public static final class n2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n2 a = null;

        static {
            a = new n2();
        }

        public n2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p3();
        }
    }

    public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.m0();
        }
    }

    public static final class o0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o0 a = null;

        static {
            a = new o0();
        }

        public o0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m5();
        }
    }

    public static final class o1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o1 a = null;

        static {
            a = new o1();
        }

        public o1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new x7();
        }
    }

    public static final class o2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o2 a = null;

        static {
            a = new o2();
        }

        public o2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new mc();
        }
    }

    public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.h0();
        }
    }

    public static final class p0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p0 a = null;

        static {
            a = new p0();
        }

        public p0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m8();
        }
    }

    public static final class p1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p1 a = null;

        static {
            a = new p1();
        }

        public p1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.c2();
        }
    }

    public static final class p2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p2 a = null;

        static {
            a = new p2();
        }

        public p2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ut2.d();
        }
    }

    public static final class q implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new dc();
        }
    }

    public static final class q0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q0 a = null;

        static {
            a = new q0();
        }

        public q0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ca();
        }
    }

    public static final class q1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q1 a = null;

        static {
            a = new q1();
        }

        public q1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.u1();
        }
    }

    public static final class q2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q2 a = null;

        static {
            a = new q2();
        }

        public q2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new c4();
        }
    }

    public static final class r implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new j9();
        }
    }

    public static final class r0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r0 a = null;

        static {
            a = new r0();
        }

        public r0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new l8();
        }
    }

    public static final class r1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r1 a = null;

        static {
            a = new r1();
        }

        public r1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.o1();
        }
    }

    public static final class r2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r2 a = null;

        static {
            a = new r2();
        }

        public r2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new v8();
        }
    }

    public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ac();
        }
    }

    public static final class s0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s0 a = null;

        static {
            a = new s0();
        }

        public s0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m8();
        }
    }

    public static final class s1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s1 a = null;

        static {
            a = new s1();
        }

        public s1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new c6();
        }
    }

    public static final class s2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s2 a = null;

        static {
            a = new s2();
        }

        public s2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new sb();
        }
    }

    public static final class t implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t a = null;

        static {
            a = new t();
        }

        public t() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new cd();
        }
    }

    public static final class t0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t0 a = null;

        static {
            a = new t0();
        }

        public t0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ad();
        }
    }

    public static final class t1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t1 a = null;

        static {
            a = new t1();
        }

        public t1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g5();
        }
    }

    public static final class t2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t2 a = null;

        static {
            a = new t2();
        }

        public t2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new z6();
        }
    }

    public static final class u implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u a = null;

        static {
            a = new u();
        }

        public u() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new x9();
        }
    }

    public static final class u0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u0 a = null;

        static {
            a = new u0();
        }

        public u0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new rb();
        }
    }

    public static final class u1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JsBridgeManager a;

        public u1(JsBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.n1(this.a);
        }
    }

    public static final class u2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u2 a = null;

        static {
            a = new u2();
        }

        public u2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e7();
        }
    }

    public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.q0();
        }
    }

    public static final class v0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v0 a = null;

        static {
            a = new v0();
        }

        public v0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p9();
        }
    }

    public static final class v1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v1 a = null;

        static {
            a = new v1();
        }

        public v1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new o4();
        }
    }

    public static final class v2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v2 a = null;

        static {
            a = new v2();
        }

        public v2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e4();
        }
    }

    public static final class w implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w a = null;

        static {
            a = new w();
        }

        public w() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new hd();
        }
    }

    public static final class w0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w0 a = null;

        static {
            a = new w0();
        }

        public w0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IBarrageService.class).createShowCarnivalTrayContentMethod();
        }
    }

    public static final class w1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w1 a = null;

        static {
            a = new w1();
        }

        public w1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new i5();
        }
    }

    public static final class w2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w2 a = null;

        static {
            a = new w2();
        }

        public w2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new l3();
        }
    }

    public static final class x implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JsBridgeManager a;

        public x(JsBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            com.bytedance.ies.web.jsbridge2.d0 r1 = this.a.f;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("_jsBridge2");
        L6:
            return new bb(r1);
        }
    }

    public static final class x0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final x0 a = null;

        static {
            a = new x0();
        }

        public x0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IBarrageService.class).createShowCarnivalRedPacketEggMethod();
        }
    }

    public static final class x1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final x1 a = null;

        static {
            a = new x1();
        }

        public x1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new GetVisualEventTrackingSettingsMethod();
        }
    }

    public static final class y implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final y a = null;

        static {
            a = new y();
        }

        public y() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fc();
        }
    }

    public static final class y0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final y0 a = null;

        static {
            a = new y0();
        }

        public y0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getRequestShowMethod();
        }
    }

    public static final class y1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final y1 a = null;

        static {
            a = new y1();
        }

        public y1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getPaidPreviewVisibilityOptionsMethod();
        }
    }

    public static final class z implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final z a = null;

        static {
            a = new z();
        }

        public z() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new v9();
        }
    }

    public static final class z0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final z0 a = null;

        static {
            a = new z0();
        }

        public z0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IImageRecognitionService.class).createImageRecognitionMethod();
        }
    }

    public static final class z1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final z1 a = null;

        static {
            a = new z1();
        }

        public z1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new hc();
        }
    }

    public JsBridgeManager() {
        throw null;
    }

    static {
        n = LazyKt.lazy(JsBridgeManager$Companion$publicFuncList$2.INSTANCE);
    }

    public final com.bytedance.ies.web.jsbridge2.d0 getJsBridge2() {
        com.bytedance.ies.web.jsbridge2.d0 r3 = this.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_jsBridge2");
    L5:
        return r3;
    }

    public final com.bytedance.ies.web.jsbridge2.f0 getSupportJsBridge() {
        com.bytedance.ies.web.jsbridge2.f0 r3 = this.g;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_supportJsBridge");
    L5:
        return r3;
    }

    public final void onGeolocationPermissionsHidePrompt() {
        WeakReference<AlertDialog> r3 = this.c;
        if (r3 == null) goto L13;
        AlertDialog r4 = r3.get();
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.isShowing() == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L15;
        a(r4);
        return;
    L15:
        return;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> registerDefaultStatefulMethods() {
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("openTimeSchedule", r.a), TuplesKt.to("community.liveAppointmentStatus", c0.a), TuplesKt.to("checkDesktopGuideCanShow", n0.a), TuplesKt.to("ug.requestShowDesktopGuide", y0.a), TuplesKt.to("getContainerID", new j1(this)), TuplesKt.to("canIUse", new u1(this)), TuplesKt.to("changeVsCameraView", f2.a), TuplesKt.to("getCurrentCameraId", q2.a), TuplesKt.to("format.openSchema", w2.a), TuplesKt.to("format.sendLog", h.a), TuplesKt.to("showPaidLiveTicketEditPage", i.a), TuplesKt.to("observeShakeMobile", j.a), TuplesKt.to("openZmCert", k.a), TuplesKt.to("openHostVerify", l.a), TuplesKt.to("liveLoading", m.a), TuplesKt.to("webcastAlertModal", n.a), TuplesKt.to("alert", o.a), TuplesKt.to("alertCheckDialog", p.a), TuplesKt.to("setFansStatus", q.a), TuplesKt.to("setAppointmentStatus", s.a), TuplesKt.to("startAnimationEvent", t.a), TuplesKt.to("preloadReplay", u.a), TuplesKt.to("authorization", v.a), TuplesKt.to("commercialComponentOperation", w.a), TuplesKt.to("requestOrientationPermission", new x(this)), TuplesKt.to("setMemoryByContainer", y.a), TuplesKt.to("preDownloadGame", z.a), TuplesKt.to("refreshActivityBannerNumber", a0.a), TuplesKt.to("setTitle", new b0(this)), TuplesKt.to("openTicketPriceInputPanel", d0.a), TuplesKt.to("createChatGroup", e0.a), TuplesKt.to("openFansGroupSettingDirect", f0.a), TuplesKt.to("liveSaveHighlightVideo", g0.a), TuplesKt.to("adLiveUpdateFeed", h0.a), TuplesKt.to("sendAdLog", i0.a), TuplesKt.to("adInfo", j0.a), TuplesKt.to("sendThirdTrack", k0.a), TuplesKt.to("openPaidRightsFullView", l0.a), TuplesKt.to("openPanelInRoom", m0.a), TuplesKt.to("imageToast", o0.a), TuplesKt.to("openAnchorShowAddDialog", p0.a), TuplesKt.to("getClientSetting", q0.a), TuplesKt.to("openAnchorInputDialog", r0.a), TuplesKt.to("openAnchorShowAddDialog", s0.a), TuplesKt.to("showToast", t0.a), TuplesKt.to("sendCommerceEvent", u0.a), TuplesKt.to("live.operateInteractPlugin", v0.a), TuplesKt.to("showCarnivalTrayContent", w0.a), TuplesKt.to("showCarnivalRedPacketEgg", x0.a), TuplesKt.to("imageRecognition", z0.a), TuplesKt.to("createActor", a1.a), TuplesKt.to("interactionCommand", b1.a), TuplesKt.to("getStarInfo", c1.a), TuplesKt.to("openExplainCardSettingDialog", d1.a), TuplesKt.to("notifyClearMountData", e1.a), TuplesKt.to("getPersonCardInfo", f1.a), TuplesKt.to("getStarInfo", g1.a), TuplesKt.to("showAnchorColumnPosterDialog", h1.a), TuplesKt.to("openLiveEffectPanel", i1.a), TuplesKt.to("updateLivePanelEffect", k1.a), TuplesKt.to("checkEffectInUsed", l1.a), TuplesKt.to("live.openLiveEffectSelectPanel", m1.a), TuplesKt.to("live.getLiveEffectInfo", n1.a), TuplesKt.to("live.updateNotifyGiftMessageChannel", o1.a), TuplesKt.to("closeAnchorStatusCenterPanel", p1.a), TuplesKt.to("checkAnchorEffectInUsed", q1.a), TuplesKt.to("canLoadFromLoki", r1.a), TuplesKt.to("live.getInteractToolInfo", s1.a), TuplesKt.to("getRevenueLotteryLogParams", t1.a), TuplesKt.to("getDynamicSettings", v1.a), TuplesKt.to("getVisualEventTrackingEditor", w1.a), TuplesKt.to("getVisualEventTrackingSettings", x1.a), TuplesKt.to("paidPreviewVisibilityOptions", y1.a), TuplesKt.to("setMessageBoardData", z1.a), TuplesKt.to("openVSMessageBoardInputPanel", a2.a), TuplesKt.to("getMessageBoardData", b2.a), TuplesKt.to("streamBottomOffset", c2.a), TuplesKt.to("getMuteStatus", d2.a), TuplesKt.to("getLiveFoldState", e2.a), TuplesKt.to("getCurrentDegradeInfo", g2.a), TuplesKt.to("requestPinWidget", h2.a), TuplesKt.to("checkWidgetInstallation", i2.a), TuplesKt.to("closeShelfManagementPage", j2.a), TuplesKt.to("adTrackInfoFromCid", k2.a), TuplesKt.to("gcpLoadPerfAddExtraParams", l2.a), TuplesKt.to("gcpLoadPerfFinishLoadWithError", m2.a), TuplesKt.to("gcpLoadPerfLoad", n2.a), TuplesKt.to("shareItem", o2.a), TuplesKt.to("urgeGiftSend", p2.a), TuplesKt.to("openLiveMicroApp", r2.a), TuplesKt.to("sendLiveMicroAppLog", s2.a), TuplesKt.to("live.startDiscoveryService", t2.a), TuplesKt.to("live.stopDiscoveryService", u2.a), TuplesKt.to("__getCurrentState", v2.a)});
        r3.putAll(this.j.registerDefaultStatefulMethods(this.d, getActivity(), getJsBridge2(), this));
        return r3;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> registerDefaultStatelessMethods() {
        Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("getXTtToken", new v3()), TuplesKt.to("sendLogV3", new tb()), TuplesKt.to("open_webview_action", new o9()), TuplesKt.to("setBannerVisibility", new com.bytedance.android.live.browser.jsbridge.newmethods.s0()), TuplesKt.to("sendPokemon", new g6()), TuplesKt.to("statusNotification", new d8()), TuplesKt.to("resetHostVerify", new fb()), TuplesKt.to("saveLocalData", new mb()), TuplesKt.to("openCashVerify", new o8()), TuplesKt.to("addRedDot", new com.bytedance.android.live.browser.jsbridge.newmethods.b0()), TuplesKt.to("openPanel", new z8()), TuplesKt.to("fansClubMsgGuide", new tc()), TuplesKt.to("openFaceStickerPanel", new ShowStikerMethod()), TuplesKt.to("webcastBroadcast", new com.bytedance.android.live.browser.jsbridge.newmethods.v0()), TuplesKt.to("GetMaixuRoomStatus", new v4()), TuplesKt.to("getMaixuRoomStatus", new v4()), TuplesKt.to("isInstalledApp", new com.bytedance.android.live.browser.jsbridge.newmethods.v1()), TuplesKt.to("liveDownloadMedia", new com.bytedance.android.live.browser.jsbridge.newmethods.r2()), TuplesKt.to("bindSourceParams", new com.bytedance.android.live.browser.jsbridge.newmethods.t0()), TuplesKt.to("reportStarEvent", new o6()), TuplesKt.to("shareScreen", jc1.k.n(ILiveShareService.class).getShareScreenMethod()), TuplesKt.to("dismissFinishPage", new com.bytedance.android.live.browser.jsbridge.newmethods.n2()), TuplesKt.to("reportAppLog", new tb())});
        r3.putAll(this.j.registerDefaultStatelessMethods(this.d, getActivity(), getJsBridge2(), this));
        return r3;
    }

    public final void d() {
        com.bytedance.ies.web.jsbridge2.d0 r3 = getJsBridge2();
        r3.e = getSupportJsBridge();
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r4 = registerDefaultStatelessMethods().entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r5 = r4.next();
        registerMethod(r5.getKey(), r5.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r6 = registerDefaultStatefulMethods().entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r7 = r6.next();
        registerMethod(r7.getKey(), r7.getValue());
        goto L8
    L10:
        int r8 = com.bytedance.android.live.browser.jsbridge.i0.a;
        Activity r9 = getActivity();
        int r11 = this.l;
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(this, "jsBridgeManager");
        g66.c r12 = new g66.c();
        r12.f(Context.class, r9);
        r12.d(p56.c.class, new com.bytedance.android.live.browser.jsbridge.h0());
        r12.d(XBridgeMethod.b.class, new com.bytedance.android.live.browser.jsbridge.e0(this));
        r12.d(p56.b.class, new com.bytedance.android.live.browser.jsbridge.f0(this));
        ArrayList<Class<? extends Object>> r13 = com.bytedance.android.live.browser.b0.a;
        com.bytedance.android.live.browser.b0.a(com.bytedance.ies.xbridge.event.bridge.c.class);
        com.bytedance.android.live.browser.b0.a(com.bytedance.ies.xbridge.event.bridge.e.class);
        com.bytedance.android.live.browser.b0.a(com.bytedance.ies.xbridge.event.bridge.f.class);
        com.bytedance.android.live.browser.jsbridge.i0.b();
        List r14 = com.bytedance.android.annie.xbridge.mix.s.a;
        Iterator r15 = ((LinkedHashMap) com.bytedance.android.annie.xbridge.mix.s.a()).entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        Map.Entry r16 = (Map.Entry) r15.next();
        registerMethod((String) r16.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r16.getValue());
        goto L12
    L14:
        XBridgeRegister r17 = new XBridgeRegister();
        Iterator<Class<? extends Object>> r18 = com.bytedance.android.live.browser.b0.a.iterator();
    L16:
        if (r18.hasNext() == false) goto L22;
        Class<? extends Object> r19 = r18.next();
        if (r19 == null) goto L21;
        XBridgeMethod r21 = (XBridgeMethod) r19.newInstance();
        r17.a(r21.getName(), new com.bytedance.android.live.browser.jsbridge.g0(r21, r12));
        goto L16
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<out com.bytedance.ies.xbridge.XBridgeMethod>");
    L22:
        Iterator r22 = MapsKt.toMap(((XBridgeRegister.a) r17.a.getValue()).a).entrySet().iterator();
    L24:
        if (r22.hasNext() == false) goto L26;
        Map.Entry r23 = (Map.Entry) r22.next();
        String r24 = (String) r23.getKey();
        registerMethod(r24, new com.bytedance.android.live.browser.jsbridge.d0(r24, r23, this, r11));
        goto L24
    L26:
        zd r25 = new zd(getJsBridge2(), null);
        Intrinsics.checkNotNullParameter(this, "jsBridgeManager");
        registerMethod("connectLongLink", new ud(r25));
        registerMethod("disconnectLongLink", new wd(r25));
        registerMethod("registerLongLinkMessageType", new yd(r25));
        Iterator r26 = ExternalJsBridgeMethodInjector.INSTANCE.getStatelessMethodsProviders().iterator();
    L28:
        if (r26.hasNext() == false) goto L33;
        Iterator r27 = ((Map) ((Function0) r26.next()).invoke()).entrySet().iterator();
    L31:
        if (r27.hasNext() == false) goto L28;
        Map.Entry r28 = (Map.Entry) r27.next();
        registerMethod((String) r28.getKey(), (com.bytedance.ies.web.jsbridge2.g) r28.getValue());
        goto L31
    L33:
        Iterator r29 = ExternalJsBridgeMethodInjector.INSTANCE.getStatefulMethodsProviders().iterator();
    L35:
        if (r29.hasNext() == false) goto L40;
        Iterator r31 = ((Map) ((Function0) r29.next()).invoke()).entrySet().iterator();
    L38:
        if (r31.hasNext() == false) goto L35;
        Map.Entry r32 = (Map.Entry) r31.next();
        registerMethod((String) r32.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r32.getValue());
        goto L38
    L40:
        Iterator r33 = ExternalJsBridgeMethodInjector.INSTANCE.getLegacyMethodsProviders().iterator();
    L42:
        if (r33.hasNext() == false) goto L47;
        Iterator r34 = ((Map) ((Function0) r33.next()).invoke()).entrySet().iterator();
    L45:
        if (r34.hasNext() == false) goto L42;
        Map.Entry r35 = (Map.Entry) r34.next();
        registerMethod((String) r35.getKey(), (n56.c) r35.getValue());
        goto L45
    L47:
        com.bytedance.android.live.browser.v r36 = this.i;
        if (r36 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L50:
        Iterator<T> r37 = r36.getFactoryCollection().iterator();
    L52:
        if (r37.hasNext() == false) goto L65;
        BaseJsBridgeMethodFactory r38 = (BaseJsBridgeMethodFactory) r37.next();
        this.a.add(r38);
        Iterator r39 = r38.provideStatelessMethods(this).entrySet().iterator();
    L55:
        if (r39.hasNext() == false) goto L57;
        Map.Entry r41 = (Map.Entry) r39.next();
        registerMethod((String) r41.getKey(), (com.bytedance.ies.web.jsbridge2.g) r41.getValue());
        goto L55
    L57:
        Iterator r42 = r38.provideStatefulMethods(this).entrySet().iterator();
    L59:
        if (r42.hasNext() == false) goto L61;
        Map.Entry r43 = (Map.Entry) r42.next();
        registerMethod((String) r43.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r43.getValue());
        goto L59
    L61:
        Iterator r44 = r38.provideLegacyMethods(this).entrySet().iterator();
    L63:
        if (r44.hasNext() == false) goto L52;
        Map.Entry r45 = (Map.Entry) r44.next();
        registerMethod((String) r45.getKey(), (n56.c) r45.getValue());
        goto L63
    }

    public final void release() {
        getJsBridge2().e();
        n56.a r3 = getSupportJsBridge().b;
        r3.a = null;
        n56.a.a r4 = r3.h;
        if (r4 == null) goto L5;
        r4.removeCallbacksAndMessages(null);
    L5:
        r3.f = null;
        this.a.clear();
        this.m.invoke(this);
        ILiveHybridContainer r5 = this.d;
        if (r5 == null) goto L9;
        String r6 = r5.getContainerId();
        if (r6 == null) goto L9;
    L10:
        EventCenter.release(r6);
        return;
    L9:
        r6 = getJsBridge2().toString();
        goto L10
    }

    public Activity getActivity() {
        return this.k;
    }

    public final ILiveHybridContainer getContainer() {
        return this.d;
    }

    public final IJsBridgeMethodFactory getExposedMethodFactory() {
        return this.h;
    }

    public final List<String> getMethodNameList() {
        return this.e;
    }

    public static void a(AlertDialog r3) {
        Handler r4 = DialogLancet.resolveDialogHandler(r3);
        if (r4 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r5 == null) goto L17;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r4.getLooper()) goto L8;
        r4.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void registerFromFactory(BaseJsBridgeMethodFactory r4) {
        Intrinsics.checkNotNullParameter(r4, "factory");
        if (this.a.add(r4) == true) goto L5;
        return;
    L5:
        Iterator r3 = r4.provideLegacyMethods(this).entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        Map.Entry r5 = (Map.Entry) r3.next();
        registerMethod((String) r5.getKey(), (n56.c) r5.getValue());
        goto L7
    L9:
        Iterator r6 = r4.provideStatelessMethods(this).entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r7 = (Map.Entry) r6.next();
        registerMethod((String) r7.getKey(), (com.bytedance.ies.web.jsbridge2.g) r7.getValue());
        goto L11
    L13:
        Iterator r8 = r4.provideStatefulMethods(this).entrySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        Map.Entry r9 = (Map.Entry) r8.next();
        registerMethod((String) r9.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r9.getValue());
        goto L15
    }

    public final void unregisterFromFactory(BaseJsBridgeMethodFactory r3) {
        Intrinsics.checkNotNullParameter(r3, "factory");
        if (this.a.remove(r3) == true) goto L5;
        return;
    L5:
        Iterator r4 = SetsKt.plus(SetsKt.plus(r3.provideLegacyMethods(this).keySet(), r3.provideStatelessMethods(this).keySet()), r3.provideStatefulMethods(this).keySet()).iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        String r5 = (String) r4.next();
        getJsBridge2().g(r5);
        goto L7
    }

    public final void c(Activity r4, com.bytedance.ies.web.jsbridge2.b r5) {
        d r3 = new d(r5);
        com.bytedance.ies.web.jsbridge2.d0.a r6 = com.bytedance.ies.web.jsbridge2.d0.g;
        com.bytedance.ies.web.jsbridge2.o r7 = new com.bytedance.ies.web.jsbridge2.o(r3);
        r7.f = r4;
        r7.c = r5;
        LocalTestManager.a(new Class[]{wy.a.class});
        r7.g = false;
        r7.h = true;
        r7.d = "ToutiaoJSBridge";
        com.bytedance.android.live.browser.v r8 = this.i;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        r7.l.addAll(r8.getSafeHostList());
        int r9 = y20.a.a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == false) goto L14;
        r7.o = true;
    L14:
        if (((Boolean) v00.a.getValue()).booleanValue() == false) goto L16;
        r7.j.add(new h8.a(new e()));
    L16:
        Unit r12 = Unit.INSTANCE;
        r7.c(new f());
        r7.i = false;
        r7.k = "webcast";
        this.f = r7.a();
        this.g = new com.bytedance.ies.web.jsbridge2.f0(null, getJsBridge2());
        if (((Boolean) t30.a.getValue()).booleanValue() == false) goto L19;
        jc1.k.n(IHostWebView.class).initXBridge();
    L19:
        d();
        return;
    L8:
        if (((Boolean) t8.a.getValue()).booleanValue() == true) goto L10;
        r11 = true;
        goto L11
    }

    public final void onGeolocationPermissionsShowPrompt(String r6, GeolocationPermissions.Callback r7) {
        if (StringUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        Activity r3 = ContextUtil.contextToActivity(this.b.get());
        if (r3 != null) goto L8;
        return;
    L8:
        WeakReference<AlertDialog> r4 = this.c;
        if (r4 == null) goto L18;
        AlertDialog r5 = r4.get();
        if (r5 == null) goto L18;
        if (r5.isShowing() == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        a(r5);
    L18:
        AlertDialog.Builder r8 = new AlertDialog.Builder(r3);
        r8.setTitle(2131917077);
        r8.setMessage(r3.getString(2131917076, new Object[]{r6}));
        g r9 = new g(r6, r7);
        r8.setNegativeButton(2131917075, r9);
        r8.setPositiveButton(2131917074, r9);
        r8.setCancelable(false);
        this.c = new WeakReference(r8.show());
    }

    public final void registerMethod(String r3, com.bytedance.ies.web.jsbridge2.f.b r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "provider");
        getJsBridge2().c(r3, r4);
        ((ArrayList) this.e).add(r3);
    }

    public final <T> void sendJsEvent(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (getJsBridge2().f == true) goto L6;
        getJsBridge2().f(r3, r4);
        return;
    }

    public final <P, R> void registerMethod(String r3, com.bytedance.ies.web.jsbridge2.g<P, R> r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "method");
        getJsBridge2().d(r3, r4);
        ((ArrayList) this.e).add(r3);
    }

    public final void registerMethod(String r3, n56.c r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "method");
        getSupportJsBridge().d(r3, r4);
        ((ArrayList) this.e).add(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsBridgeManager(IMiddlewareJsBridgeManager r3, Activity r4, int r5, Function1<? super JsBridgeManager, Unit> r6) {
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.a = new HashSet();
        this.b = new WeakReference(getActivity());
        this.e = new ArrayList();
        this.h = new com.bytedance.android.live.browser.jsbridge.l();
        BrowserServiceImpl.Companion.getClass();
        com.bytedance.android.live.browser.v r7 = (com.bytedance.android.live.browser.v) ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a().a.e.get();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        this.i = r7;
    }

    public final void b(Activity r7, WebView r8, WebViewClient r9, WebChromeClient r11) {
        com.bytedance.ies.web.jsbridge2.d0.a r3 = com.bytedance.ies.web.jsbridge2.d0.g;
        com.bytedance.ies.web.jsbridge2.o r4 = new com.bytedance.ies.web.jsbridge2.o(r8);
        r4.f = r7;
        r4.c(new b());
        kjc.c r5 = new kjc.c();
        if (2 != kjc.a.a()) goto L6;
        r5.a.a = Unit.INSTANCE;
        r5.b = true;
    L6:
        if (r5.b == true) goto L8;
        kjc.b r6 = r5.a;
        r4.j.add(new n30.c(r8));
        r6.a = Unit.INSTANCE;
    L8:
        Object r12 = r5.a.a;
        boolean r13 = false;
        LocalTestManager.a(new Class[]{wy.a.class});
        r4.g = false;
        r4.h = true;
        com.bytedance.android.live.browser.v r14 = this.i;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L11:
        r4.l.addAll(r14.getSafeHostList());
        r4.j.add(new xq7.a(r8));
        if (((Boolean) v00.a.getValue()).booleanValue() == false) goto L14;
        r4.j.add(new h8.a(new c()));
    L14:
        r4.d = "ToutiaoJSBridge";
        int r15 = y20.a.a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L17;
    L19:
        if (r13 == false) goto L21;
        r4.o = true;
    L21:
        r4.k = "webcast";
        Unit r16 = Unit.INSTANCE;
        this.f = r4.a();
        com.bytedance.ies.web.jsbridge2.f0 r17 = new com.bytedance.ies.web.jsbridge2.f0(r8, getJsBridge2());
        n56.a r18 = r17.b;
        r18.b = "bytedance";
        r18.i(r9);
        WebView r19 = r17.b.a;
        if (r19 == null) goto L24;
        r19.setWebChromeClient(r11);
    L24:
        com.bytedance.android.live.browser.v r21 = this.i;
        if (r21 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L27:
        List<String> r22 = r21.getSafeHostList();
        r17.b.c = r22;
        r17.a.i.b.a.addAll(r22);
        List r23 = (List) n.getValue();
        r17.b.d = r23;
        r17.a.i.b.b.addAll(r23);
        Iterator r24 = r23.iterator();
    L29:
        if (r24.hasNext() == false) goto L33;
        com.bytedance.ies.web.jsbridge2.e r25 = (com.bytedance.ies.web.jsbridge2.e) ((ConcurrentHashMap) r17.d).get((String) r24.next());
        if (r25 == null) goto L29;
        r25.a = PermissionGroup.PUBLIC;
        goto L29
    L33:
        this.g = r17;
        if (((Boolean) s8.a.getValue()).booleanValue() == false) goto L39;
        com.bytedance.ies.web.jsbridge2.d0 r26 = (com.bytedance.ies.web.jsbridge2.d0) jc1.k.n(IHostWebView.class).createJsBridge2(r7, getJsBridge2());
        if (r26 == null) goto L39;
        getJsBridge2().b(r26);
    L39:
        if (((Boolean) t30.a.getValue()).booleanValue() == false) goto L41;
        jc1.k.n(IHostWebView.class).initXBridge();
    L41:
        d();
        return;
    L17:
        if (((Boolean) t8.a.getValue()).booleanValue() == true) goto L19;
        r13 = true;
        goto L19
    }

    public JsBridgeManager(IMiddlewareJsBridgeManager r3, ILiveHybridContainer r4, com.bytedance.ies.web.jsbridge2.b r5, int r6, Function1<? super JsBridgeManager, Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "middlewareJsBridgeManager");
        Intrinsics.checkNotNullParameter(r4, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r5, "bridgeImpl");
        Intrinsics.checkNotNullParameter(r7, "onRelease");
        this(r3, r4.getCurrentActivity(), r6, r7);
        this.d = r4;
        c(getActivity(), r5);
    }

    public JsBridgeManager(IMiddlewareJsBridgeManager r3, ILiveHybridContainer r4, WebView r5, WebViewClient r6, WebChromeClient r7, int r8, Function1<? super JsBridgeManager, Unit> r9) {
        Intrinsics.checkNotNullParameter(r3, "middlewareJsBridgeManager");
        Intrinsics.checkNotNullParameter(r4, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r5, "webView");
        Intrinsics.checkNotNullParameter(r6, "webViewClient");
        Intrinsics.checkNotNullParameter(r7, "webChromeClient");
        Intrinsics.checkNotNullParameter(r9, "onRelease");
        this(r3, r4.getCurrentActivity(), r8, r9);
        this.d = r4;
        b(getActivity(), r5, r6, r7);
    }
}
