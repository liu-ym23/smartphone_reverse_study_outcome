package com.bytedance.ai.lite.widget.cache;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ai.lite.model.objects.LiteWidget;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.cache.WidgetResourceLoader;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LiteWidgetResourceLoader extends WidgetResourceLoader {
    public ConversationWidgetData h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final void d(String r1, String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r1, "appletId");
        Intrinsics.checkNotNullParameter(r10, "conversationID");
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "msgId");
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final TemplateData e() {
        g.a.d("LiteWidgetResourceLoader", "getCustomTemplateData " + this.h.getWidgetData());
        String r0 = this.h.getWidgetData();
        if (r0 != null) goto L5;
        return null;
    L5:
        return TemplateData.fromString(r0);
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final Uri f() {
        if (f.g(this.h.getLiteTemplateUrl()) == true) goto L7;
        return null;
    L7:
        return UriProtector.parse(this.h.getLiteTemplateUrl());
    }

    public LiteWidgetResourceLoader(ConversationWidgetData r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetData");
        super(r10);
        this.h = r10;
        AppletResourceTool.s(AppletResourceTool.a);
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final Object a(Continuation<? super Widget> r10) {
        this.c = new LiteWidget(this.h.getPackageName(), this.h.getWidgetId());
        Widget r11 = this.c;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ai.lite.model.objects.LiteWidget");
        LiteWidget r12 = (LiteWidget) r11;
        r12.getClass();
        Intrinsics.checkNotNullParameter("lynx", "<set-?>");
        r12.o = "lynx";
        g.a.i("LiteWidgetResourceLoader", "loadWidget " + this.c);
        Widget r13 = this.c;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ai.lite.model.objects.LiteWidget");
        return (LiteWidget) r13;
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final void b(ConversationWidgetData r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetData");
        this.h = r10;
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader
    public final Object l(Continuation<? super TemplateBundle> r10) {
        if ((r10 instanceof LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1) == false) goto L7;
        LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1 r0 = (LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1 r11 = r0;
        Object r12 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L37:
        TemplateBundle r15 = (TemplateBundle) r12;
    L38:
        g.a.i("LiteWidgetResourceLoader", "Loader(" + this.b + ") loadTemplateBundleFromPackage: end loading, liteTemplateUrl=" + this.h.getLiteTemplateUrl());
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r15 = null;
        if (f.g(this.h.getLiteTemplateUrl()) == false) goto L17;
        Uri r16 = UriProtector.parse(this.h.getLiteTemplateUrl());
    L19:
        if (r16 == null) goto L27;
        String r17 = UriProtector.getQueryParameter(r16, "surl");
        if (r17 != null) goto L23;
        r17 = "";
    L23:
        Uri r18 = UriProtector.parse(r17);
        g r19 = g.a;
        r19.d("LiteWidgetResourceLoader", "check uri " + this.h.getLiteTemplateUrl() + " host=" + r18.getHost());
        int r20 = g5.a.a;
        if (g5.a.a(r18.getHost()) == true) goto L27;
        r19.e("LiteWidgetResourceLoader", "domain " + r18.getHost() + " not in list");
        return null;
    L27:
        String r110 = this.h.getLiteTemplateUrl();
        if (r110 == null) goto L38;
        int r21 = AppletLynxViewApi.a;
        Widget r22 = this.c;
        if (r22 == null) goto L33;
        String r23 = r22.x;
        if (r23 == null) goto L33;
    L34:
        r11.label = 1;
        r12 = AppletLynxViewApi.b(r23, r110, false, null, null, r11);
        if (r12 != r13) goto L37;
        return r13;
    L33:
        r23 = "";
        goto L34
    L17:
        r16 = null;
    L7:
        r0 = new LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1(this, r10);
        goto L8
    }

    @Override // com.bytedance.ai.widget.cache.WidgetResourceLoader, com.bytedance.ai.widget.cache.b
    public final Object g(Context r10, m r11, Continuation<? super Unit> r12) {
        i1 r13 = y0.a;
        y0.m(r11.a(), "applet_widget_timeline_full");
        y0.l(r11.a(), "applet_widget_timeline_full", MapsKt.mapOf(new Pair[]{TuplesKt.to("applet_res_from", ""), TuplesKt.to("main_js_res_from", "")}));
        return Unit.INSTANCE;
    }
}
