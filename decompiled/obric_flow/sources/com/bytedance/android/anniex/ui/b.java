package com.bytedance.android.anniex.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import com.bytedance.android.anniex.lite.container.h;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback$ErrStage;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.j;
import com.lynx.tasm.n0;
import com.lynx.tasm.p0;
import com.lynx.tasm.utils.e;
import com.lynx.tasm.y;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc.g;
import xc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3496c;
    public final WeakReference d;
    public Uri e;
    public WeakReference f;

    public b(AnnieXLynxView r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "bid");
        this.f3495b = r10;
        this.f3496c = r11;
        if (r5 == null) goto L5;
        WeakReference r12 = new WeakReference(r5);
    L6:
        this.d = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public final void loadImage(Context r5, String r10, String r11, float r12, float r13, Transformer r14, j r15) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r15, "handler");
        super.loadImage(r5, r10, r11, r12, r13, r14, r15);
        WeakReference r16 = this.f;
        if (r16 != null) goto L5;
        return;
    L5:
        if (((h) r16.get()) == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r15, "handler");
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onDataUpdated() {
        super.onDataUpdated();
        WeakReference r5 = this.f;
        if (r5 != null) goto L5;
        return;
    L5:
        if (((h) r5.get()) == null) goto L11;
        WeakReference r10 = this.d;
        if (r10 == null) goto L12;
        AnnieXLynxView r11 = (AnnieXLynxView) r10.get();
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onDestroy() {
        WeakReference r5 = this.f;
        if (r5 == null) goto L6;
        h r10 = (h) r5.get();
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onFirstLoadPerfReady(y r5) {
        WeakReference r10 = this.f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (((h) r10.get()) == null) goto L11;
        WeakReference r11 = this.d;
        if (r11 == null) goto L12;
        AnnieXLynxView r12 = (AnnieXLynxView) r11.get();
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onFirstScreen() {
        super.onFirstScreen();
        WeakReference r5 = this.f;
        if (r5 == null) goto L10;
        h r10 = (h) r5.get();
        if (r10 == null) goto L10;
        WeakReference r11 = this.d;
        if (r11 == null) goto L9;
        AnnieXLynxView r12 = (AnnieXLynxView) r11.get();
    L9:
        String r13 = r10.f3249a.e;
        AnnieXLiteContainer r14 = r10.f3251c;
        r10.f3250b.c(r13, r14);
    L10:
        LinkedHashMap r15 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.s(this.f3495b);
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onLoadFailed(String r5) {
        super.onLoadFailed(r5);
        WeakReference r10 = this.f;
        if (r10 == null) goto L11;
        h r11 = (h) r10.get();
        if (r11 == null) goto L12;
        WeakReference r12 = this.d;
        if (r12 == null) goto L9;
        AnnieXLynxView r13 = (AnnieXLynxView) r12.get();
    L9:
        String r14 = r11.f3249a.e;
        Throwable r15 = new Throwable(r5);
        r11.f3250b.g(r14, r11.f3251c, r15);
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        WeakReference r5 = this.d;
        if (r5 == null) goto L45;
        AnnieXLynxView r10 = (AnnieXLynxView) r5.get();
        if (r10 == null) goto L45;
        String r11 = this.f3496c;
        Intrinsics.checkNotNullParameter(r11, "bid");
        TraceEvent.c("AnnieXLynxView:addTagView");
        mb.b r12 = mb.a.a(r11);     // Catch: Throwable -> L12
        com.bytedance.android.anniex.utils.a r13 = null;
        if (com.bytedance.ies.bullet.core.h.g.f5315a == true) goto L10;
    L14:
        r12 = null;
    L15:
        if (r12 != null) goto L18;
    L41:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L12
        TraceEvent.a(0, "AnnieXLynxView:addTagView");
        goto L45
    L18:
        if (c.f3497a[r10.f3469j.ordinal()] != 1) goto L20;
        String r15 = "annieX_card";
    L21:
        String r16 = r12.f20056b;     // Catch: Throwable -> L12
        if (r16 != null) goto L24;
    L27:
        String r17 = "";
    L28:
        String r18 = r15 + '_' + r17 + r10.f3468i;     // Catch: Throwable -> L12
        if (r10.getForeground() != null) goto L36;
        TraceEvent.c("AnnieXLynxView:init_debug_tag");     // Catch: Throwable -> L12
        r10.setForeground(new com.bytedance.android.anniex.utils.a());     // Catch: Throwable -> L33
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L33
        TraceEvent.a(0, "AnnieXLynxView:init_debug_tag");     // Catch: Throwable -> L12
        goto L36
    L33:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:init_debug_tag");     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L36:
        Drawable r20 = r10.getForeground();     // Catch: Throwable -> L12
        if ((r20 instanceof com.bytedance.android.anniex.utils.a) == false) goto L39;
        r13 = (com.bytedance.android.anniex.utils.a) r20;     // Catch: Throwable -> L12
    L39:
        if (r13 == null) goto L41;
        Intrinsics.checkNotNullParameter(r18, MessageIndication.CONTENT_TYPE_TEXT);     // Catch: Throwable -> L12
        r13.d = r18;     // Catch: Throwable -> L12
        r13.invalidateSelf();     // Catch: Throwable -> L12
        goto L41
    L24:
        if (r16.length() == 0) goto L27;
        r17 = r12.f20056b + " - ";     // Catch: Throwable -> L12
        goto L28
    L20:
        r15 = "annieX_card_".concat(r10.f3469j.f5286a);     // Catch: Throwable -> L12
        goto L21
    L10:
        if (r12.f20055a == false) goto L14;
    L12:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:addTagView");
        throw th;
    L45:
        WeakReference r21 = this.f;
        if (r21 == null) goto L52;
        h r22 = (h) r21.get();
        if (r22 == null) goto L52;
        if (r5 == null) goto L51;
        AnnieXLynxView r23 = (AnnieXLynxView) r5.get();
    L51:
        r22.f3250b.j(r22.f3249a.e, r22.f3251c);
    L52:
        LinkedHashMap r24 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.z(this.f3495b);
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0, com.lynx.tasm.j
    public final void onModuleMethodInvoked(String r5, String r10, int r11) {
        super.onModuleMethodInvoked(r5, r10, r11);
        WeakReference r12 = this.f;
        if (r12 == null) goto L6;
        h r13 = (h) r12.get();
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onPageStart(String r5) {
        super.onPageStart(r5);
        WeakReference r10 = this.f;
        if (r10 != null) goto L5;
    L9:
        if (r5 == null) goto L11;
        this.e = Uri.parse(r5);
    L11:
        LinkedHashMap r11 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.E(this.f3495b);
        return;
    L5:
        if (((h) r10.get()) == null) goto L9;
        WeakReference r12 = this.d;
        if (r12 == null) goto L9;
        AnnieXLynxView r13 = (AnnieXLynxView) r12.get();
        goto L9
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onPageUpdate() {
        super.onPageUpdate();
        WeakReference r5 = this.f;
        if (r5 != null) goto L5;
        return;
    L5:
        if (((h) r5.get()) == null) goto L11;
        WeakReference r10 = this.d;
        if (r10 == null) goto L12;
        AnnieXLynxView r11 = (AnnieXLynxView) r10.get();
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onReceivedError(String r5) {
        super.onReceivedError(r5);
        WeakReference r10 = this.f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (((h) r10.get()) == null) goto L11;
        WeakReference r11 = this.d;
        if (r11 == null) goto L12;
        AnnieXLynxView r12 = (AnnieXLynxView) r11.get();
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onRuntimeReady() {
        super.onRuntimeReady();
        WeakReference r5 = this.f;
        if (r5 == null) goto L11;
        h r10 = (h) r5.get();
        if (r10 == null) goto L12;
        WeakReference r11 = this.d;
        if (r11 == null) goto L9;
        AnnieXLynxView r12 = (AnnieXLynxView) r11.get();
    L9:
        String r13 = r10.f3249a.e;
        AnnieXLiteContainer r14 = r10.f3251c;
        r10.f3250b.k(r13, r14);
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onScrollStart(n0 r5) {
        super.onScrollStart(r5);
        WeakReference r10 = this.f;
        if (r10 == null) goto L6;
        h r11 = (h) r10.get();
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onScrollStop(n0 r5) {
        super.onScrollStop(r5);
        WeakReference r10 = this.f;
        if (r10 == null) goto L6;
        h r11 = (h) r10.get();
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onTemplateBundleReady(TemplateBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "bundle");
        WeakReference r10 = this.f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (((h) r10.get()) == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "templateBundle");
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onTimingSetup(Map r5) {
        super.onTimingSetup(r5);
        WeakReference r10 = this.f;
        if (r10 == null) goto L5;
        h r11 = (h) r10.get();
    L5:
        LinkedHashMap r12 = com.bytedance.android.anniex.monitor.c.f3335a;
        String r13 = this.f3495b;
        WeakReference r14 = this.d;
        if (r14 == null) goto L10;
        AnnieXLynxView r15 = (AnnieXLynxView) r14.get();
        if (r15 == null) goto L10;
        LynxDevtool r16 = r15.q();
    L11:
        com.bytedance.android.anniex.monitor.c.m(r13, r5, r16);
        return;
    L10:
        r16 = null;
        goto L11
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onTimingUpdate(Map r5, Map r10, String r11) {
        super.onTimingUpdate(r5, r10, r11);
        WeakReference r12 = this.f;
        if (r12 == null) goto L5;
        h r13 = (h) r12.get();
    L5:
        LinkedHashMap r14 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.n(this.f3495b, r5, r10, r11);
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0
    public final void onUpdatePerfReady(y r5) {
        WeakReference r10 = this.f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (((h) r10.get()) == null) goto L11;
        WeakReference r11 = this.d;
        if (r11 == null) goto L12;
        AnnieXLynxView r12 = (AnnieXLynxView) r11.get();
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public final String shouldRedirectImageUrl(String r15) {
        WeakReference r5 = this.f;
        if (r5 == null) goto L5;
        h r10 = (h) r5.get();
    L5:
        Uri r11 = Uri.parse(r15);
        long r12 = System.currentTimeMillis();
        StringBuilder r13 = e.b("redirectWithPipeline URL:", r15, ",defaultCache:");
        boolean r14 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        r13.append(com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b);
        com.bytedance.ies.bullet.base.utils.b.m(r13.toString());
        String r16 = "";
        if (r15 != null) goto L8;
    L45:
        String r17 = r15;
    L46:
        if (r17 != null) goto L48;
    L53:
        if (r15 != null) goto L55;
    L72:
        return null;
    L55:
        if (r15.length() == 0) goto L72;
        List r18 = CollectionsKt.listOf(new String[]{"http", IIvyAIPackageResourceService.SCHEMA, "file", "content", "res", "data"});
        String r19 = r11.getScheme();
        if (r19 == null) goto L62;
        r16 = r19;
    L62:
        if (r18.contains(r16) == false) goto L65;
    L69:
        return r15;
    L65:
        if (Intrinsics.areEqual(r11.getScheme(), "bundle") == true) goto L71;
        if (Intrinsics.areEqual(r11.getScheme(), "relative") == false) goto L69;
    L71:
        return r11.getPath();
    L48:
        if (equals(r15) == false) goto L51;
        r17 = null;
    L51:
        if (r17 == null) goto L53;
        return r17;
    L8:
        if (r15.length() == 0) goto L45;
        if (StringsKt.P(r15, "file://") == true) goto L45;
        if (StringsKt.P(r15, "data:") == true) goto L45;
        r17 = com.bytedance.ies.bullet.preloadv2.redirect.a.a(r15);
        if (r17 == null) goto L19;
        com.bytedance.ies.bullet.preloadv2.redirect.a.d(this.f3496c, r15, r17, true, System.currentTimeMillis() - r12);
        goto L46
    L19:
        if (StringsKt.P(r15, "base64:") == true) goto L31;
        zm.c r20 = f.f5397a;
        Scene r21 = Scene.f;
        String r110 = this.f3495b;
        g r111 = new g("");
        String r22 = this.f3496c;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r111.f22838c = r22;
        Unit r23 = Unit.INSTANCE;
        w r24 = f.b(r15, null, r21, r110, r111, AnnieXDefaultLynxViewClient$redirectWithPipeline$3.f3463a, 5);
        if (r24 == null) goto L31;
        String r25 = r24.f4443t;
        if (r25 != null) goto L25;
    L30:
        String r26 = null;
    L32:
        if (r26 != null) goto L34;
    L38:
        GeckoXAdapter.Companion r27 = GeckoXAdapter.Companion;
        if (r27.isCDNMultiVersionResource(r15) == false) goto L42;
        r26 = r27.addCommonParamsForCDNMultiVersionURL(r15);
    L42:
        if (com.bytedance.ies.bullet.preloadv2.redirect.a.f5886b == false) goto L44;
        com.bytedance.ies.bullet.base.utils.b.m("redirectWithPipeline putRedirectPath URL:" + r15 + ",redirectUrl:" + r26);
        com.bytedance.ies.bullet.preloadv2.redirect.a.c(r15, r26);
    L44:
        com.bytedance.ies.bullet.preloadv2.redirect.a.d(this.f3496c, r15, r26, false, System.currentTimeMillis() - r12);
        r17 = r26;
        goto L46
    L34:
        if (r26.length() == 0) goto L38;
        if (Intrinsics.areEqual(r26, r15) == false) goto L42;
    L25:
        if (StringsKt.isBlank(r25) == false) goto L28;
        r25 = null;
    L28:
        if (r25 == null) goto L30;
        r26 = "file://".concat(r25);
    L31:
        r26 = r15;
        goto L32
    }

    @Override // com.lynx.tasm.p0, com.lynx.tasm.o0, com.lynx.tasm.j
    public final void onReceivedError(LynxError r10) {
        super.onReceivedError(r10);
        WeakReference r5 = this.f;
        WeakReference r11 = this.d;
        if (r5 != null) goto L5;
    L8:
        ConcurrentHashMap r12 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r13 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r13 == null) goto L15;
        d r14 = (d) r13.a(d.class);
        if (r14 == null) goto L15;
        Boolean r15 = r14.l0();
        if (r15 == null) goto L15;
        boolean r16 = r15.booleanValue();
    L16:
        AnnieXLynxView r17 = null;
        if (r16 == false) goto L28;
        if (r10 == null) goto L28;
        if (r11 == null) goto L23;
        AnnieXLynxView r18 = (AnnieXLynxView) r11.get();
        if (r18 == null) goto L23;
        a0 r19 = r18.getResourceInfo$anniex_release();
    L25:
        if (r10.a() != 102) goto L28;
        if (r19 == null) goto L28;
        h.f.b(new a(0, r19, this), h.f.g);
    L23:
        r19 = null;
    L28:
        if (r10 != null) goto L30;
        return;
    L30:
        if (r10.f9995j == "fatal") goto L32;
        return;
    L32:
        if (this.e == null) goto L50;
        WeakReference r20 = this.f;
        if (r20 == null) goto L38;
        h r21 = (h) r20.get();
        if (r21 == null) goto L38;
        Uri r22 = this.e;
        Intrinsics.checkNotNull(r22);
        Throwable r23 = new Throwable(r10.toString());
        Intrinsics.checkNotNullParameter(r22, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r23, "e");
        r21.f3250b.g(r22.toString(), r21.f3251c, r23);
    L38:
        WeakReference r24 = this.f;
        if (r24 == null) goto L41;
        h r25 = (h) r24.get();
    L41:
        LinkedHashMap r26 = com.bytedance.android.anniex.monitor.c.f3335a;
        String r27 = this.f3496c;
        String r28 = this.f3495b;
        AbsBulletMonitorCallback$ErrStage r29 = AbsBulletMonitorCallback$ErrStage.f6030c;
        String r30 = r10.e();
        if (r30 != null) goto L44;
        r30 = "";
    L44:
        if (r11 == null) goto L46;
        r17 = (AnnieXLynxView) r11.get();
    L46:
        com.bytedance.android.anniex.monitor.c.i(r27, r29, r28, r30, r17);
        return;
    L50:
        return;
    L15:
        r16 = true;
        goto L16
    L5:
        if (((h) r5.get()) == null) goto L8;
        if (r11 == null) goto L8;
        AnnieXLynxView r31 = (AnnieXLynxView) r11.get();
        goto L8
    }
}
