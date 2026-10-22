package com.bytedance.android.annie.business.container;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.FragmentCustomMonitorKey;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.bridge.p;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements ia.e {
    public FragmentActivity a;
    public final ia.c b;
    public AnnieXLiveContext c;
    public w8.d d;
    public Disposable e;
    public p f;
    public com.bytedance.android.annie.bridge.method.permission.b g;
    public final List<HybridFragment.a> h;
    public final String i;
    public boolean j;
    public final Boolean k;
    public boolean l;
    public final Lazy m;
    public AnnieXLiveHybridComponent n;
    public com.bytedance.android.annie.business.ability.schema.model.b o;
    public ViewGroup p;
    public final j q;
    public final n r;
    public boolean s;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FragmentCustomMonitorKey.values().length];
            r0[FragmentCustomMonitorKey.RealOpenTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[FragmentCustomMonitorKey.IsContainerPreload.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[FragmentCustomMonitorKey.IsUserOpen.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[FragmentCustomMonitorKey.IsPrerender.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[FragmentCustomMonitorKey.HasReload.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Long r11 = (Long) r10;
            w8.d r12 = this.a.d;
            if (r12 == null) goto L6;
            r12.a(true);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ i a;

        public d(i r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            HybridLogger r0 = HybridLogger.a;
            k7.a.a("AnnieXLivePopAndPageComm", ((Throwable) r10).toString(), this.a.c);
        }
    }

    public static final class e<T> implements ValueCallback {
        public final /* synthetic */ i a;

        public e(i r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r10) {
            y6.e r0 = (y6.e) this.a.m.getValue();
            String r11 = com.bytedance.android.annie.container.fragment.n.e((String) r10);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r0.a = r11;
        }
    }

    public static final class f<T> implements ValueCallback {
        public final /* synthetic */ i a;

        public f(i r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r10) {
            y6.e r0 = (y6.e) this.a.m.getValue();
            String r11 = com.bytedance.android.annie.container.fragment.n.e((String) r10);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r0.c = r11;
        }
    }

    public static final class g<T> implements ValueCallback {
        public final /* synthetic */ i a;

        public g(i r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r10) {
            y6.e r0 = (y6.e) this.a.m.getValue();
            String r11 = com.bytedance.android.annie.container.fragment.n.e((String) r10);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r0.d = r11;
        }
    }

    static {
    }

    public final void c() {
        this.d = ((w8.c) e(w8.c.class)).k1(this.b, this.a);
        this.e = Observable.timer(1500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
    }

    public final void g() {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onDetach: " + this.i, this.c);
        Disposable r1 = this.e;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        w8.d r10 = this.d;
        if (r10 == null) goto L9;
        r10.a(false);
        return;
    }

    @Override // ia.e
    public final void onDestroy() {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onDestroy: " + this.i, this.c);
        s26.d r1 = s26.d.c;
        com.bytedance.android.anniex.base.service.c r10 = s26.d.c.d("caijing", com.bytedance.android.anniex.base.service.c.class);
        if (r10 == null) goto L5;
        r10.J0(null, this.b);
    L5:
        ia.c r11 = this.b;
        if ((r11 instanceof ia.e) == false) goto L8;
        ia.e r12 = (ia.e) r11;
    L9:
        if (r12 == null) goto L11;
        r12.onDestroy();
    L11:
        FragmentActivity r13 = this.a;
        if (r13 == null) goto L14;
        AnnieFragmentManager.f(this.b.getContainerId(), r13, 4);
    L14:
        this.a = null;
        this.c = null;
        this.e = null;
        this.d = null;
        return;
    L8:
        r12 = null;
        goto L9
    }

    @Override // ia.e
    public final void onPause() {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onPause: " + this.i, this.c);
        ia.c r1 = this.b;
        if ((r1 instanceof ia.e) == false) goto L5;
        ia.e r10 = (ia.e) r1;
    L6:
        if (r10 == null) goto L8;
        r10.onPause();
    L8:
        this.b.sendEvent(new m(false));
        w8.d r11 = this.d;
        if (r11 == null) goto L11;
        r11.a(false);
    L11:
        FragmentActivity r12 = this.a;
        if (r12 == null) goto L16;
        boolean r13 = true;
        if (r12.isFinishing() != true) goto L16;
    L17:
        if (r13 == false) goto L20;
        AnnieFragmentManager.e(this.b.getContainerId(), this.a, false);
        return;
    L20:
        return;
    L16:
        r13 = false;
        goto L17
    L5:
        r10 = null;
        goto L6
    }

    @Override // ia.e
    public final void onResume() {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onResume: " + this.i, this.c);
        ia.c r1 = this.b;
        if ((r1 instanceof ia.e) == false) goto L5;
        ia.e r10 = (ia.e) r1;
    L6:
        if (r10 == null) goto L8;
        r10.onResume();
    L8:
        this.b.sendEvent(new m(true));
        w8.d r11 = this.d;
        if (r11 == null) goto L11;
        r11.a(true);
    L11:
        s26.d r12 = s26.d.c;
        com.bytedance.android.anniex.base.service.c r13 = s26.d.c.d("caijing", com.bytedance.android.anniex.base.service.c.class);
        if (r13 == null) goto L15;
        r13.K0(null, this.b);
        return;
    L15:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // ia.e
    public final void onStart() {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onStart: " + this.i, this.c);
        ia.c r1 = this.b;
        if ((r1 instanceof ia.e) == false) goto L5;
        ia.e r10 = (ia.e) r1;
    L6:
        if (r10 == null) goto L9;
        r10.onStart();
        return;
    L9:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // ia.e
    public final void onStop() {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onStop: " + this.i, this.c);
        ia.c r1 = this.b;
        if ((r1 instanceof ia.e) == false) goto L5;
        ia.e r10 = (ia.e) r1;
    L6:
        if (r10 == null) goto L9;
        r10.onStop();
        return;
    L9:
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final void p() {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "release: " + this.i, this.c);
        ((ArrayList) this.h).clear();
        AnnieXLiveHybridComponent r1 = this.n;
        if (r1 == null) goto L5;
        r1.release();
    L5:
        this.n = null;
    }

    @Override // ia.e
    public final void a(View r10) {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onCreateView: " + this.i, this.c);
        ia.e r1 = null;
        if ((r10 instanceof ViewGroup) == false) goto L5;
        ViewGroup r11 = (ViewGroup) r10;
    L6:
        this.p = r11;
        ia.c r12 = this.b;
        if ((r12 instanceof ia.e) == false) goto L9;
        r1 = (ia.e) r12;
    L9:
        if (r1 == null) goto L12;
        r1.a(r10);
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final <T extends com.bytedance.android.annie.service.a> T e(Class<? extends T> r10) {
        AnnieXLiveContext r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.getBizKey();
        if (r1 == null) goto L6;
    L8:
        return (T) Annie.getService(r10, r1);
    L6:
        r1 = "host";
        goto L8
    }

    public final void f(WebView r10) {
        com.bytedance.android.annie.business.ability.schema.model.b r0 = this.o;
        boolean r1 = false;
        if (r0 == null) goto L13;
        y36.a r11 = r0.f;
        if (r11 == null) goto L9;
        Boolean r12 = (Boolean) ((y36.i) r11).b;
        if (r12 == null) goto L9;
        boolean r13 = r12.booleanValue();
    L11:
        if (r13 != true) goto L13;
        r1 = true;
    L9:
        r13 = false;
    L13:
        if (r1 == false) goto L19;
        y6.e r14 = (y6.e) this.m.getValue();
        String r15 = r10.getUrl();
        if (r15 != null) goto L17;
        r15 = "";
    L17:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r14.b = r15;
        r10.evaluateJavascript("document.title", new e(this));
        r10.evaluateJavascript("document.getElementsByName('description')[0].content", new f(this));
        r10.evaluateJavascript("document.getElementsByTagName('link')[0].href", new g(this));
        return;
    }

    @Override // ia.e
    public final void onActivityCreated(Bundle r10) {
        HybridLogger r0 = HybridLogger.a;
        Map r1 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, this.i));
        AnnieXLiveContext r11 = this.c;
        if (r11 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a r12 = r11.getLogContext();
    L6:
        HybridLogger.k("AnnieXLivePopAndPageComm", "on_activity_created", r1, r12);
        ia.c r13 = this.b;
        if ((r13 instanceof ia.e) == false) goto L9;
        ia.e r14 = (ia.e) r13;
    L10:
        if (r14 == null) goto L12;
        r14.onActivityCreated(r10);
    L12:
        s26.d r15 = s26.d.c;
        com.bytedance.android.anniex.base.service.c r16 = s26.d.c.d("caijing", com.bytedance.android.anniex.base.service.c.class);
        if (r16 == null) goto L16;
        r16.I0(null, this.b, r10);
        return;
    L16:
        return;
    L9:
        r14 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    @Override // ia.e
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onConfigurationChanged: " + this.i, this.c);
        ia.c r1 = this.b;
        if ((r1 instanceof ia.e) == false) goto L5;
        ia.e r11 = (ia.e) r1;
    L6:
        if (r11 == null) goto L9;
        r11.onConfigurationChanged(r10);
        return;
    L9:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void q(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m("AnnieXLivePopAndPageComm", "===setJSBridgeListener " + this.i + " ===", null, null, 12);
        AnnieXLiveHybridComponent r1 = this.n;
        if (r1 == null) goto L6;
        r1.setJSBridgeListener(r10);
        return;
    }

    @Override // ia.e
    public final void setUserVisibleHint(boolean r10) {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "setUserVisibleHint: " + this.i, this.c);
        ia.c r1 = this.b;
        if ((r1 instanceof ia.e) == false) goto L5;
        ia.e r11 = (ia.e) r1;
    L6:
        if (r11 == null) goto L9;
        r11.setUserVisibleHint(r10);
        return;
    L9:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // ia.e
    public final void b(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        HybridLogger r12 = HybridLogger.a;
        Map r13 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, this.i));
        AnnieXLiveContext r0 = this.c;
        com.bytedance.ies.bullet.base.utils.logger.a r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a r14 = r0.getLogContext();
    L6:
        HybridLogger.k("AnnieXLivePopAndPageComm", "on_view_created", r13, r14);
        ViewGroup r15 = this.p;
        if (r15 == null) goto L14;
        ia.c r16 = this.b;
        if ((r16 instanceof ia.e) == false) goto L11;
        ia.e r17 = (ia.e) r16;
    L12:
        if (r17 == null) goto L14;
        r17.b(r15, r11);
        Unit r18 = Unit.INSTANCE;
    L15:
        if (r18 != null) goto L21;
        Map r19 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "onViewCreated: rootView is null"));
        AnnieXLiveContext r20 = this.c;
        if (r20 == null) goto L19;
        r1 = r20.getLogContext();
    L19:
        HybridLogger.g("AnnieXLivePopAndPageComm", "rootView_is_null", r19, r1);
        return;
    L21:
        return;
    L11:
        r17 = null;
    L14:
        r18 = null;
        goto L15
    L5:
        r14 = null;
        goto L6
    }

    public final void n(JSBridgeManager r10, Fragment r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        Intrinsics.checkNotNullParameter(r11, "fragment");
        Iterator<T> r0 = ((w8.c) e(w8.c.class)).provideStateFulFragmentMethods(r11).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        List<HybridFragment.a> r12 = this.h;
        ArrayList r13 = (ArrayList) r12;
        r13.add(r1.getValue());
        r10.registerMethod((String) r1.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r1.getValue());
        goto L4
    L6:
        FragmentActivity r14 = this.a;
        if (r14 == null) goto L46;
        Iterator r15 = ((CopyOnWriteArraySet) a9.j.c).iterator();
    L10:
        if (r15.hasNext() == false) goto L33;
        y6.a r16 = (y6.a) r15.next();
        Map r17 = x26.a.a;
        w26.g r18 = (w26.g) x26.a.a(w26.g.class);
        if (r18 == null) goto L18;
        w26.e r19 = (w26.e) r18.n0(w26.e.class);
        if (r19 == null) goto L18;
        Boolean r20 = r19.S0();
        if (r20 == null) goto L18;
        boolean r21 = r20.booleanValue();
    L19:
        if (r21 == true) goto L20;
        if ((r11 instanceof HybridFragment) == false) goto L27;
        HybridFragment r22 = (HybridFragment) r11;
    L28:
        if (r22 == null) goto L10;
        Iterator r23 = r16.g(r14, r22).entrySet().iterator();
    L31:
        if (r23.hasNext() == false) goto L10;
        Map.Entry r24 = (Map.Entry) r23.next();
        List<HybridFragment.a> r25 = this.h;
        ArrayList r26 = (ArrayList) r25;
        r26.add(r24.getValue());
        r10.registerMethod((String) r24.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r24.getValue());
        goto L31
    L27:
        r22 = null;
        goto L28
    L20:
        Iterator r27 = r16.f(r14, r11).entrySet().iterator();
    L22:
        if (r27.hasNext() == false) goto L10;
        Map.Entry r28 = (Map.Entry) r27.next();
        List<HybridFragment.a> r29 = this.h;
        ArrayList r30 = (ArrayList) r29;
        r30.add(r28.getValue());
        r10.registerMethod((String) r28.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r28.getValue());
    L18:
        r21 = true;
        goto L19
    L33:
        p r31 = ((w8.c) e(w8.c.class)).X(r14, r11);
        this.f = r31;
        if (r31 == null) goto L47;
        r10.registerMethod("calendar", r31.provide());
        return;
    L47:
        return;
    }

    public i(FragmentActivity r10, ia.c r11, AnnieXLiveContext r12) {
        Intrinsics.checkNotNullParameter(r11, "container");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.h = new ArrayList();
        this.i = "unknown";
        this.k = AnnieConfigSettingKeys.DISABLE_WEB_VIEW_RETRY_RESOURCE.a();
        this.l = true;
        this.m = LazyKt.lazy(AnnieXLivePopAndPageComm$shareInfo$2.INSTANCE);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L16
        AnnieXLiveContext r14 = this.c;     // Catch: Throwable -> L16
        Uri r15 = null;
        if (r14 == null) goto L8;
        Uri r16 = r14.getUri();     // Catch: Throwable -> L16
        if (r16 == null) goto L8;
        String r17 = UriProtector.getQueryParameter(r16, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L16
    L9:
        if (r17 != null) goto L14;
        AnnieXLiveContext r18 = this.c;     // Catch: Throwable -> L16
        if (r18 == null) goto L13;
        r15 = r18.getUri();     // Catch: Throwable -> L16
    L13:
        r17 = String.valueOf(r15);     // Catch: Throwable -> L16
    L14:
        this.i = r17;     // Catch: Throwable -> L16
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        HybridLogger r19 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "init: " + this.i, this.c);
        new l();
        this.q = new j(this);
        this.r = new n(this);
        return;
    L8:
        r17 = null;
    L16:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public final void k(int r10, String[] r11, int[] r12) {
        Intrinsics.checkNotNullParameter(r11, "permissions");
        Intrinsics.checkNotNullParameter(r12, "grantResults");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        p r13 = this.f;     // Catch: Throwable -> L12
        if (r13 == null) goto L6;
        r13.onRequestPermissionsResult(r10, r11, r12);     // Catch: Throwable -> L12
    L6:
        com.bytedance.android.annie.bridge.method.permission.b r14 = this.g;     // Catch: Throwable -> L12
        if (r14 == null) goto L9;
        r14.onRequestPermissionsResult(r10, r11, r12);     // Catch: Throwable -> L12
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L12
    L14:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L20;
        HybridLogger r18 = HybridLogger.a;
        HybridLogger.i("AnnieXLivePopAndPageComm", "onRequestPermissionsResult===>" + r17.getMessage(), null, 12);
        return;
    L20:
        return;
    L9:
        r15 = null;
    L12:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // ia.e
    public final void onActivityResult(int r10, int r11, Intent r12) {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "onActivityResult: " + this.i, this.c);
        Iterator r1 = ((ArrayList) this.h).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((HybridFragment.a) r1.next()).onActivityResult(r10, r11, r12);
        goto L4
    L6:
        ia.c r13 = this.b;
        if ((r13 instanceof ia.e) == false) goto L9;
        ia.e r14 = (ia.e) r13;
    L10:
        if (r14 == null) goto L14;
        r14.onActivityResult(r10, r11, r12);
        return;
    L14:
        return;
    L9:
        r14 = null;
        goto L10
    }
}
