package com.bytedance.android.monitorV2.lynx.impl;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher$DataType;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.google.common.reflect.w;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.LynxView;
import com.obric.oui.constraintlayout.core.widgets.analyzer.f;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import oo.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends um.a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.lynx.tasm.behavior.d f3683k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f3684l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final WeakHashMap f3685m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final WeakHashMap f3686n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final WeakHashMap f3687o = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f3688c;
    public WeakReference d;
    public e e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f3691j;

    static {
        f3683k = new com.lynx.tasm.behavior.d(4);
        f3684l = LazyKt.lazy(LynxViewDataManager$Companion$defaultLynxViewDataManager$2.f3645a);
        f3685m = new WeakHashMap();
        f3686n = new WeakHashMap();
        f3687o = new WeakHashMap();
    }

    public d(LynxView r5) {
        super(r5);
        Intrinsics.checkNotNullParameter("__hybrid_default", "bid");
        this.f3688c = new f("__hybrid_default", new com.bytedance.android.monitorV2.webview.a());
        this.f3691j = LazyKt.lazy(new LynxViewDataManager$commonProps$2(this));
        android.support.v4.media.c r10 = fj.a.f16916b;
        if (r10 == null) goto L9;
        com.bytedance.android.monitorV2.settings.d r11 = (com.bytedance.android.monitorV2.settings.d) r10.e(com.bytedance.android.monitorV2.settings.d.class);
        if (r11 == null) goto L9;
        if (r11.c() != true) goto L9;
        return;
    L9:
        LynxView r12 = F();
        if (r12 == null) goto L13;
        r12.addOnAttachStateChangeListener(this);
        return;
    }

    public final LynxView F() {
        LynxView r5 = (LynxView) ((WeakReference) this.f22372b).get();
        if (r5 != null) goto L5;
        d5.b.e("LynxViewDataManager", "get webView from weakRef: null");
    L5:
        return r5;
    }

    public final void G(final String r10) {
        if (H() == false) goto L37;
        if (r10 == null) goto L39;
        Lazy r5 = this.f3691j;
        g5.b r11 = (g5.b) r5.getValue();
        boolean r12 = false;
        if (((g5.b) r5.getValue()).f22973a == null) goto L9;
        boolean r13 = true;
    L10:
        r11.f22977i = Boolean.valueOf(r13);
        ((g5.b) r5.getValue()).f22973a = r10;
        g5.b r14 = (g5.b) r5.getValue();
        if (sk.a.f21938a != 0) goto L13;
        sk.a.f21938a = System.currentTimeMillis();
    L13:
        r14.e = sk.a.f21938a;
        if (this.f == true) goto L16;
    L17:
        e r15 = this.e;
        if (r15 == null) goto L20;
        r15.I();
    L20:
        e r16 = new e(this);
        this.e = r16;
        LynxView r17 = r16.F();
        if (r17 == null) goto L23;
        j5.b.e(r17, r16);
    L23:
        g5.b r18 = (g5.b) r5.getValue();
        StringBuilder r19 = new StringBuilder();
        r19.append(System.currentTimeMillis());
        r19.append('-');
        r19.append(UUID.randomUUID());
        r18.f22974b = r19.toString();
    L24:
        this.f = false;
        e r20 = this.e;
        if (r20 == null) goto L30;
        LynxView r21 = r20.F();
        if (r21 == null) goto L30;
        StringBuilder r22 = com.lynx.tasm.utils.e.b("onPageStart: ", r10, ", view: ");
        r22.append(r20.F());
        d5.b.f("LynxViewMonitor", r22.toString());
        g5.e r23 = r20.f3695j;
        g5.c r24 = r20.f3694i;
        r23.f17058b = r24;
        r20.f3696k = r21.getTemplateUrl();
        long r25 = System.currentTimeMillis();
        r24.f17053a = r25;
        r24.f17055c = r25;
        r24.g = 1;
        r20.f3699n.s(1);
        com.bytedance.android.monitorV2.event.a r110 = j.c("navigationStart", new x4.j(), new LynxViewNavigationDataManager$onPageStart$pvEvent$1(r10));
        w r26 = r20.f3697l;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        ((com.bytedance.android.monitorV2.dataprocessor.b) r26.f9376b).c((TypedDataDispatcher$DataType) r26.d, r110, true);
    L30:
        final LynxView r111 = F();
        if (r111 == null) goto L38;
        this.g = r111.isAttachedToWindow();
        if (r111.getVisibility() != 0) goto L35;
        r12 = true;
    L35:
        this.f3689h = r12;
        c.a(r111);
        Lazy r27 = com.bytedance.android.monitorV2.executor.d.f3576a;
        com.bytedance.android.monitorV2.executor.d.a(new LynxViewDataManager$onPageStart$lambda$1$$inlined$runAsyncQuietly$1(r111));
        return;
    L38:
        return;
    L16:
        if (((g5.b) r5.getValue()).f22977i.booleanValue() == false) goto L24;
    L9:
        r13 = false;
        goto L10
    L39:
        return;
    }

    public final boolean H() {
        if (Switches.f3587b.f3600a == true) goto L5;
        return false;
    L5:
        if (Switches.g.f3600a == true) goto L7;
        return false;
    L7:
        if (this.f3688c.f12567a == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        if (H() == false) goto L29;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        String r11 = null;
        if ((r5 instanceof LynxView) == false) goto L10;
        LynxView r12 = (LynxView) r5;     // Catch: Throwable -> L8
    L11:
        if (r12 == null) goto L13;
        r11 = r12.getTemplateUrl();     // Catch: Throwable -> L8
    L13:
        Object r13 = Result.m124constructorimpl(Boolean.valueOf(Intrinsics.areEqual(Uri.parse(r11).getQueryParameter("disable_final_detect_when_detached"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST)));     // Catch: Throwable -> L8
    L16:
        Boolean r14 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r13) == false) goto L20;
        r13 = r14;
    L20:
        if (((Boolean) r13).booleanValue() == true) goto L30;
        e r15 = this.e;
        if (r15 == null) goto L28;
        r15.I();
        return;
    L28:
        return;
    L30:
        return;
    L10:
        r12 = null;
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
