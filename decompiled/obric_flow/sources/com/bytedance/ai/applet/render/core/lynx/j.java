package com.bytedance.ai.applet.render.core.lynx;

import android.net.Uri;
import android.util.LruCache;
import b3.p;
import com.bytedance.ai.resource.e0;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.o0;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1775c;
    public final Object d;

    public j(i r5, g1.c r10, q7.a r11) {
        this.f1773a = 0;
        Intrinsics.checkNotNullParameter(r5, "renderView");
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "loader");
        this.f1774b = r5;
        this.f1775c = r10;
        this.d = r11;
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadSuccess() {
        switch(this.f1773a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Uri r5 = (Uri) this.f1775c;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        ((com.bytedance.ies.bullet.ui.common.loader.a) this.f1774b).f5349a.p(r5, (com.bytedance.ies.bullet.lynx.h) this.d);
        return;
    L6:
        i r10 = (i) this.f1774b;
        String r11 = r10.getTemplateUrl();
        if (r11 != null) goto L9;
        r11 = "";
    L9:
        ((com.bytedance.ai.widget.contianer.d) ((g1.c) this.f1775c)).getClass();
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "url");
        String r12 = "onPageFinished ".concat(r11);
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L13;
        r13.i("AppletWidgetContainer", r12);
        return;
    }

    @Override // com.lynx.tasm.o0
    public void onPageStart(String r5) {
        switch(this.f1773a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        i r10 = (i) this.f1774b;
        String r11 = r10.getTemplateUrl();
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        com.bytedance.ai.widget.contianer.d r12 = (com.bytedance.ai.widget.contianer.d) ((g1.c) this.f1775c);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "url");
        String r13 = "onPageStart ".concat(r11);
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L11;
        r14.i("AppletWidgetContainer", r13);
    L11:
        r12.f3044a.i(WidgetContainer.LifecycleEvent.f3033b);
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public final void onReceivedError(LynxError r5) {
        switch(this.f1773a) {
            case 0: goto L16;
            default: goto L4;
        };
    L4:
        com.bytedance.ies.bullet.lynx.h r10 = (com.bytedance.ies.bullet.lynx.h) this.d;
        r10.getClass();
        if (r5 != null) goto L7;
    L11:
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.f9995j != "fatal") goto L22;
        Throwable r11 = new Throwable(r5.toString());
        ((com.bytedance.ies.bullet.ui.common.loader.a) this.f1774b).r((Uri) this.f1775c, r11);
        return;
    L22:
        return;
    L7:
        if (r5.a() != 102) goto L11;
        if (r10.f5642k == null) goto L11;
        h.f.b(new com.airbnb.lottie.m(r10, 4), h.f.g);
        goto L11
    L16:
        Intrinsics.checkNotNullParameter(r5, "error");
        boolean r12 = CollectionsKt.listOf(new Integer[]{100, 102, 103, Integer.valueOf(LynxErrorCode.LYNX_ERROR_MAIN_FLOW)}).contains(Integer.valueOf(r5.a()));
        int r13 = r5.a();
        String r14 = r5.f9993h;
        if (r14 != null) goto L19;
        r14 = "";
    L19:
        ((com.bytedance.ai.widget.contianer.d) ((g1.c) this.f1775c)).b((i) this.f1774b, r12, r13, r14);
    }

    @Override // com.lynx.tasm.o0
    public void onRuntimeReady() {
        switch(this.f1773a) {
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Uri r5 = (Uri) this.f1775c;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        ((com.bytedance.ies.bullet.ui.common.loader.a) this.f1774b).f5349a.w(r5, (com.bytedance.ies.bullet.lynx.h) this.d);
    }

    @Override // com.lynx.tasm.o0
    public void onTimingSetup(Map r5) {
        switch(this.f1773a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        com.bytedance.ai.widget.contianer.d r10 = (com.bytedance.ai.widget.contianer.d) ((g1.c) this.f1775c);
        r10.getClass();
        Intrinsics.checkNotNullParameter((i) this.f1774b, "view");
        String r11 = "onTimingSetup " + r10 + ' ' + r5;
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L8;
        r12.i("AppletWidgetContainer", r11);
    L8:
        WidgetContainer.LifecycleEvent r13 = WidgetContainer.LifecycleEvent.d;
        AppletWidgetContainer r14 = r10.f3044a;
        r14.i(r13);
        p r15 = b3.h.f841a;
        String r16 = r14.v();
        Map r17 = null;
        if (r5 == null) goto L11;
        r17 = MapsKt.toMutableMap(r5);
    L11:
        b3.h.i(r16, r17);
    }

    @Override // com.lynx.tasm.o0
    public void onTimingUpdate(Map r10, Map r11, final String r12) {
        switch(this.f1773a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        com.bytedance.ai.widget.contianer.d r5 = (com.bytedance.ai.widget.contianer.d) ((g1.c) this.f1775c);
        r5.getClass();
        Intrinsics.checkNotNullParameter((i) this.f1774b, "view");
        p r13 = b3.h.f841a;
        final String r14 = r5.f3044a.v();
        Map r15 = null;
        if (r10 == null) goto L8;
        final Map r16 = MapsKt.toMutableMap(r10);
    L9:
        if (r11 == null) goto L11;
        r15 = MapsKt.toMutableMap(r11);
    L11:
        final Map r17 = r15;
        Intrinsics.checkNotNullParameter(r14, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L15;
        final int r18 = 0;
        b3.h.c(new b3.d(r14, r16, r17, r12, r18));
        return;
    L15:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L19;
        final int r19 = 1;
        b3.h.c(new b3.d(r14, r16, r17, r12, r19));
        return;
    L19:
        return;
    L8:
        r16 = null;
        goto L9
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public String shouldRedirectImageUrl(String r12) {
        switch(this.f1773a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        String r5 = null;
        if (r12 == null) goto L39;
        if (r12.length() == 0) goto L39;
        Uri r10 = Uri.parse(r12);
        q7.a r11 = (q7.a) this.d;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "url");
        LruCache r13 = e0.f2711a;
        String r14 = (String) r11.f21488b;
        u0.a r15 = s0.a.f21800c;
        String r16 = "";
        if (r15 == null) goto L15;
        String r17 = r15.f22202m;
        if (r17 == null) goto L15;
    L16:
        Intrinsics.checkNotNullParameter(r17, "bid");
        if (StringsKt.P(r12, "content://") != true) goto L19;
        String r18 = r12;
    L20:
        if (r18 != null) goto L22;
    L26:
        List r19 = CollectionsKt.listOf(new String[]{"http", IIvyAIPackageResourceService.SCHEMA, "file", "content", "res", "data"});
        String r20 = r10.getScheme();
        if (r20 == null) goto L31;
        r16 = r20;
    L31:
        if (r19.contains(r16) == false) goto L34;
        return r12;
    L34:
        if (Intrinsics.areEqual(r10.getScheme(), "bundle") == true) goto L38;
        if (Intrinsics.areEqual(r10.getScheme(), "relative") == true) goto L38;
        return r12;
    L38:
        return r10.getPath();
    L22:
        if (equals(r12) == true) goto L24;
        r5 = r18;
    L24:
        if (r5 == null) goto L26;
    L19:
        r18 = IIvyAIPackageResourceService.Companion.getImageUrl(r14, r12, r17);
    L15:
        r17 = "";
    L39:
        return r5;
    L5:
        return super.shouldRedirectImageUrl(r12);
    }

    public j(com.bytedance.ies.bullet.ui.common.loader.a r5, Uri r10, com.bytedance.ies.bullet.lynx.h r11) {
        this.f1773a = 1;
        this.f1774b = r5;
        this.f1775c = r10;
        this.d = r11;
    }
}
