package com.bytedance.ai.widget.cache;

import android.content.Context;
import android.net.Uri;
import android.os.Trace;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class WidgetResourceLoader implements b {
    public static final ConcurrentHashMap<String, CompletableDeferred<Widget>> e = null;
    public static final ConcurrentHashMap<String, CompletableDeferred<TemplateBundle>> f = null;
    public static final AtomicInteger g = null;
    public final ConversationWidgetData a;
    public final int b;
    public volatile Widget c;
    public volatile TemplateBundle d;

    public static final class a {
    }

    public /* synthetic */ WidgetResourceLoader() {
        throw null;
    }

    @Override // com.bytedance.ai.widget.cache.b
    public Object a(Continuation<? super Widget> r1) {
        return n(this, r1);
    }

    @Override // com.bytedance.ai.widget.cache.b
    public final Object c(Continuation<? super TemplateBundle> r1) {
        return k(this, r1);
    }

    @Override // com.bytedance.ai.widget.cache.b
    public TemplateData e() {
        return null;
    }

    @Override // com.bytedance.ai.widget.cache.b
    public Uri f() {
        return null;
    }

    @Override // com.bytedance.ai.widget.cache.b
    public Object g(Context r1, m r10, Continuation<? super Unit> r11) {
        return i(this, r10, r11);
    }

    public Object l(Continuation<? super TemplateBundle> r1) {
        return m(this, r1);
    }

    static {
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new AtomicInteger(0);
    }

    public WidgetResourceLoader(ConversationWidgetData r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetData");
        this.a = r10;
        this.b = g.incrementAndGet();
    }

    @Override // com.bytedance.ai.widget.cache.b
    public void b(ConversationWidgetData r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetData");
    }

    public static final Object h(WidgetResourceLoader r12, Continuation r13) {
        r12.getClass();
        if ((r13 instanceof WidgetResourceLoader$loadWidgetFromPackage$1) == false) goto L7;
        WidgetResourceLoader$loadWidgetFromPackage$1 r0 = (WidgetResourceLoader$loadWidgetFromPackage$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        String r15 = (String) r0.L$1;
        String r16 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L21:
        Widget r17 = (Widget) r14;
        Trace.endSection();
        com.bytedance.ai.applet.base.log.b r18 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r12.b + ") loadWidgetFromPackage: end loading, packageName = " + r16 + ", widgetId = " + r15);
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        String r19 = r12.a.getPackageName();
        String r20 = r12.a.getWidgetId();
        com.bytedance.ai.applet.base.log.b r21 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r12.b + ") loadWidgetFromPackage: start loading, packageName = " + r19 + ", widgetId = " + r20);
        StringBuilder r22 = new StringBuilder("loadWidget_");
        r22.append(r20);
        Trace.beginSection(r22.toString());
        AIManager r23 = AIManager.a;
        Map<String, Object> r24 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message_id", r12.a.getMessageId()), TuplesKt.to("botId", r12.a.getBotId())});
        String r25 = r12.a.getVersionTag();
        if (r25 == null) goto L17;
        r24.put("version_tag", r25);
    L17:
        Unit r26 = Unit.INSTANCE;
        r0.L$0 = r19;
        r0.L$1 = r20;
        r0.label = 1;
        Object r27 = r23.E(r19, r20, r24, r0);
        if (r27 == r10) goto L23;
        r15 = r20;
        r16 = r19;
        r14 = r27;
        goto L21
    L23:
        return r10;
    L7:
        r0 = new WidgetResourceLoader$loadWidgetFromPackage$1(r12, r13);
        goto L8
    }

    public static Object k(WidgetResourceLoader r20, Continuation<? super TemplateBundle> r21) {
        WidgetResourceLoader r0 = r20;
        if ((r21 instanceof WidgetResourceLoader$loadTemplateBundle$1) == false) goto L7;
        WidgetResourceLoader$loadTemplateBundle$1 r10 = (WidgetResourceLoader$loadTemplateBundle$1) r21;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        CompletableDeferred<TemplateBundle> r14 = (CompletableDeferred) r10.L$2;
        String r15 = (String) r10.L$1;
        WidgetResourceLoader r16 = (WidgetResourceLoader) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L61:
        f.remove(r15, r14);
        JobKt.ensureActive(r10.getContext());
        r16.getClass();
        return r16.d;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        CompletableDeferred<TemplateBundle> r17 = (CompletableDeferred) r10.L$5;
        String r18 = (String) r10.L$4;
        String r19 = (String) r10.L$3;
        String r110 = (String) r10.L$2;
        String r111 = (String) r10.L$1;
        WidgetResourceLoader r112 = (WidgetResourceLoader) r10.L$0;
        ResultKt.throwOnFailure(r1);
        CompletableDeferred<TemplateBundle> r113 = r17;
        r0 = r112;
    L50:
        TemplateBundle r22 = (TemplateBundle) r1;
        if (r22 == null) goto L54;
        com.bytedance.ai.applet.base.log.b r23 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r0.b + ") loadTemplateJs: hit awaitResult");
        r0.d = r22;
        return r22;
    L54:
        com.bytedance.ai.applet.base.log.b r24 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + r0.b + ") loadTemplateJs: awaitResult is NULL", null);
        String r114 = r19;
    L57:
        WidgetResourceLoader$loadTemplateBundle$3 r25 = new WidgetResourceLoader$loadTemplateBundle$3(r0, r111, r110, r114, null);
        r10.L$0 = r0;
        r10.L$1 = r18;
        r10.L$2 = r113;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.L$5 = null;
        r10.label = 2;
        if (r0.o(r113, r25, r10) != r12) goto L60;
        return r12;
    L60:
        r15 = r18;
        r16 = r0;
        r14 = r113;
        goto L61
    L16:
        ResultKt.throwOnFailure(r1);
        r20.getClass();
        if (r0.d == null) goto L20;
        com.bytedance.ai.applet.base.log.b r26 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("WidgetResourceLoader", "Loader(" + r0.b + ") loadTemplateJs: templateBundle is loaded", null);
        return r0.d;
    L20:
        r111 = r0.a.getPackageName();
        r110 = r0.a.getWidgetId();
        String r27 = r0.a.getVersionTag();
        ConcurrentHashMap<String, Widget> r28 = com.bytedance.ai.widget.cache.a.a;
        Intrinsics.checkNotNullParameter(r111, "packageName");
        Intrinsics.checkNotNullParameter(r110, "widgetId");
        if (com.bytedance.ai.widget.cache.a.c == false) goto L23;
        TemplateBundle r29 = null;
    L24:
        r0.d = r29;
        if (r0.d == null) goto L29;
        com.bytedance.ai.applet.base.log.b r30 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r0.b + ") loadTemplateBundle: hit cache, packageName = " + r111 + ", widgetId = " + r110 + ", versionTag = " + r27);
        return r0.d;
    L29:
        if (r0.c != null) goto L32;
        com.bytedance.ai.applet.base.log.b r31 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + r0.b + ") loadTemplateJs: widget is NULL", null);
        return null;
    L32:
        Widget r32 = r0.c;
        if (r32 == null) goto L35;
        String r33 = r32.o;
    L37:
        if (Intrinsics.areEqual(r33, "lynx") == true) goto L44;
        com.bytedance.ai.applet.base.log.b r34 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r35 = new StringBuilder("Loader(");
        r35.append(r0.b);
        r35.append(") loadTemplateBundle: renderType is NOT lynx, it is ");
        Widget r36 = r0.c;
        if (r36 == null) goto L41;
        String r37 = r36.o;
    L42:
        r35.append(r37);
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", r35.toString(), null);
        return null;
    L41:
        r37 = null;
        goto L42
    L44:
        r18 = j(r111, r110, r27);
        r113 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CompletableDeferred<TemplateBundle> r115 = f.putIfAbsent(r18, r113);
        if (r115 == null) goto L56;
        com.bytedance.ai.applet.base.log.b r116 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r0.b + ") loadTemplateJs: other loader is loading");
        WidgetResourceLoader$loadTemplateBundle$2$awaitResult$1 r117 = new WidgetResourceLoader$loadTemplateBundle$2$awaitResult$1(r115, null);
        r10.L$0 = r0;
        r10.L$1 = r111;
        r10.L$2 = r110;
        r10.L$3 = r27;
        r10.L$4 = r18;
        r10.L$5 = r113;
        r10.label = 1;
        Object r38 = TimeoutKt.c(5000, r117, r10);
        if (r38 != r12) goto L49;
        return r12;
    L49:
        r19 = r27;
        r1 = r38;
        goto L50
    L56:
        r114 = r27;
        goto L57
    L35:
        r33 = null;
        goto L37
    L23:
        r29 = com.bytedance.ai.widget.cache.a.b.get(com.bytedance.ai.widget.cache.a.b(r111, r110, r27));
    L7:
        r10 = new WidgetResourceLoader$loadTemplateBundle$1(r0, r21);
        goto L8
    }

    public static Object m(WidgetResourceLoader r13, Continuation<? super TemplateBundle> r14) {
        if ((r14 instanceof WidgetResourceLoader$loadTemplateBundleFromPackage$1) == false) goto L7;
        WidgetResourceLoader$loadTemplateBundleFromPackage$1 r0 = (WidgetResourceLoader$loadTemplateBundleFromPackage$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        WidgetResourceLoader$loadTemplateBundleFromPackage$1 r10 = r0;
        Object r15 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r10.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        String r16 = (String) r10.L$2;
        String r17 = (String) r10.L$1;
        WidgetResourceLoader r18 = (WidgetResourceLoader) r10.L$0;
        ResultKt.throwOnFailure(r15);
        String r19 = r16;
        r13 = r18;
    L31:
        TemplateBundle r20 = (TemplateBundle) r15;
        String r110 = r17;
    L32:
        Trace.endSection();
        com.bytedance.ai.applet.base.log.b r21 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r13.b + ") loadTemplateBundleFromPackage: end loading, packageName = " + r110 + ", widgetId = " + r19);
        return r20;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r110 = r13.a.getPackageName();
        r19 = r13.a.getWidgetId();
        com.bytedance.ai.applet.base.log.b r22 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r13.b + ") loadTemplateBundleFromPackage: start loading, packageName = " + r110 + ", widgetId = " + r19);
        StringBuilder r23 = new StringBuilder("loadTemplateBundle_");
        Widget r24 = r13.c;
        r20 = null;
        if (r24 == null) goto L17;
        String r25 = r24.K;
    L18:
        r23.append(r25);
        Trace.beginSection(r23.toString());
        Widget r26 = r13.c;
        if (r26 == null) goto L32;
        int r27 = AppletLynxViewApi.a;
        String r28 = r26.x;
        if (r28 != null) goto L23;
        r28 = "";
    L23:
        String r29 = AppletResourceTool.m(AppletResourceTool.a, r26, r26.L);
        if (r26.E != 1) goto L26;
        boolean r30 = true;
    L27:
        String r111 = r26.b;
        String r112 = r26.K;
        r10.L$0 = r13;
        r10.L$1 = r110;
        r10.L$2 = r19;
        r10.label = 1;
        Object r31 = AppletLynxViewApi.b(r28, r29, r30, r111, r112, r10);
        if (r31 != r11) goto L30;
        return r11;
    L30:
        r17 = r110;
        r15 = r31;
        goto L31
    L26:
        r30 = false;
        goto L27
    L17:
        r25 = null;
    L7:
        r0 = new WidgetResourceLoader$loadTemplateBundleFromPackage$1(r13, r14);
        goto L8
    }

    public static Object n(WidgetResourceLoader r14, Continuation<? super Widget> r15) {
        if ((r15 instanceof WidgetResourceLoader$loadWidget$1) == false) goto L7;
        WidgetResourceLoader$loadWidget$1 r0 = (WidgetResourceLoader$loadWidget$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L14;
        CompletableDeferred<Widget> r17 = (CompletableDeferred) r0.L$2;
        String r12 = (String) r0.L$1;
        WidgetResourceLoader r13 = (WidgetResourceLoader) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L42:
        e.remove(r12, r17);
        JobKt.ensureActive(r0.getContext());
        r13.getClass();
        return r13.c;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        CompletableDeferred<Widget> r18 = (CompletableDeferred) r0.L$3;
        String r19 = (String) r0.L$2;
        String r20 = (String) r0.L$1;
        WidgetResourceLoader r21 = (WidgetResourceLoader) r0.L$0;
        ResultKt.throwOnFailure(r16);
        CompletableDeferred<Widget> r110 = r18;
        r14 = r21;
        String r22 = r20;
        Object r23 = r16;
    L33:
        Widget r24 = (Widget) r23;
        if (r24 == null) goto L37;
        com.bytedance.ai.applet.base.log.b r111 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r14.b + ") loadWidget: hit awaitResult");
        r14.c = r24;
        return r24;
    L37:
        com.bytedance.ai.applet.base.log.b r25 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + r14.b + ") loadWidget: awaitResult is NULL", null);
    L38:
        WidgetResourceLoader$loadWidget$3 r26 = new WidgetResourceLoader$loadWidget$3(r14, r22, null);
        r0.L$0 = r14;
        r0.L$1 = r19;
        r0.L$2 = r110;
        r0.L$3 = null;
        r0.label = 2;
        if (r14.o(r110, r26, r0) != r10) goto L41;
        return r10;
    L41:
        r12 = r19;
        r13 = r14;
        r17 = r110;
        goto L42
    L16:
        ResultKt.throwOnFailure(r16);
        r14.getClass();
        if (r14.c == null) goto L20;
        com.bytedance.ai.applet.base.log.b r112 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("WidgetResourceLoader", "Loader(" + r14.b + ") loadWidget: widget is loaded", null);
        return r14.c;
    L20:
        String r113 = r14.a.getPackageName();
        String r27 = r14.a.getWidgetId();
        r22 = r14.a.getVersionTag();
        ConcurrentHashMap<String, Widget> r28 = com.bytedance.ai.widget.cache.a.a;
        Intrinsics.checkNotNullParameter(r113, "packageName");
        Intrinsics.checkNotNullParameter(r27, "widgetId");
        if (com.bytedance.ai.widget.cache.a.c == false) goto L23;
        Widget r29 = null;
    L24:
        r14.c = r29;
        if (r14.c == null) goto L28;
        com.bytedance.ai.applet.base.log.b r30 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r14.b + ") loadWidget: hit cache, packageName = " + r113 + ", widgetId = " + r27 + ", versionTag = " + r22);
        return r14.c;
    L28:
        r19 = j(r113, r27, r22);
        r110 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CompletableDeferred<Widget> r31 = e.putIfAbsent(r19, r110);
        if (r31 == null) goto L38;
        com.bytedance.ai.applet.base.log.b r114 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "Loader(" + r14.b + ") loadWidget: other loader is loading");
        WidgetResourceLoader$loadWidget$2$awaitResult$1 r115 = new WidgetResourceLoader$loadWidget$2$awaitResult$1(r31, null);
        r0.L$0 = r14;
        r0.L$1 = r22;
        r0.L$2 = r19;
        r0.L$3 = r110;
        r0.label = 1;
        r23 = TimeoutKt.c(5000, r115, r0);
        if (r23 != r10) goto L33;
        return r10;
    L23:
        r29 = com.bytedance.ai.widget.cache.a.a.get(com.bytedance.ai.widget.cache.a.b(r113, r27, r22));
    L7:
        r0 = new WidgetResourceLoader$loadWidget$1(r14, r15);
        goto L8
    }

    public static Object i(WidgetResourceLoader r16, m r17, Continuation r18) {
        m r0 = r17;
        if ((r18 instanceof WidgetResourceLoader$awaitRunApplet$1) == false) goto L7;
        WidgetResourceLoader$awaitRunApplet$1 r10 = (WidgetResourceLoader$awaitRunApplet$1) r18;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        WidgetResourceLoader$awaitRunApplet$1 r12 = r10;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r12.label;
        String r15 = "";
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        r0 = (m) r12.L$0;
        ResultKt.throwOnFailure(r1);
    L23:
        AppletRuntime r19 = (AppletRuntime) r1;
    L24:
        if (r19 != null) goto L26;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "createWidgetContainer runApplet failed", null);
    L26:
        i1 r20 = y0.a;
        String r21 = r0.a();
        Pair[] r22 = new Pair[2];
        if (r19 == null) goto L32;
        Applet r23 = r19.h;
        if (r23 == null) goto L32;
        String r24 = r23.B;
        if (r24 == null) goto L32;
    L33:
        r22[0] = TuplesKt.to("applet_res_from", r24);
        if (r19 == null) goto L39;
        String r25 = r19.t;
        if (r25 == null) goto L39;
        r15 = r25;
    L39:
        r22[1] = TuplesKt.to("main_js_res_from", r15);
        y0.l(r21, "applet_widget_timeline_full", MapsKt.mapOf(r22));
        return Unit.INSTANCE;
    L32:
        r24 = "";
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        i1 r26 = y0.a;
        y0.m(r17.a(), "applet_widget_timeline_full");
        AppletRuntimeManager r27 = AppletRuntimeManager.INSTANCE;
        String r28 = r0.k;
        String r29 = r0.d;
        String r30 = r0.a;
        r27.getClass();
        r19 = AppletRuntimeManager.i(r28, r29, r30);
        if (r19 != null) goto L24;
        com.bytedance.ai.applet.base.log.a.c("WidgetResourceLoader", "createWidgetContainer runApplet");
        String r31 = r0.a;
        String r32 = r0.k;
        if (r32 != null) goto L19;
        String r33 = "";
    L20:
        String r34 = r0.d;
        String r35 = r17.a();
        Map r36 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("trace_id", r17.a()), TuplesKt.to("eventName", "applet_widget_timeline_full")});
        r12.L$0 = r0;
        r12.label = 1;
        r1 = AppletRuntimeManager.a(r27, r31, r33, r34, r35, r36, r12);
        if (r1 != r13) goto L23;
        return r13;
    L19:
        r33 = r32;
    L7:
        r10 = new WidgetResourceLoader$awaitRunApplet$1(r16, r18);
        goto L8
    }

    public static String j(String r10, String r11, String r12) {
        String[] r0 = new String[3];
        r0[0] = r10;
        r0[1] = r11;
        if (r12 != null) goto L5;
    L7:
        r12 = null;
    L8:
        r0[2] = r12;
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r0), ":", null, null, 0, null, null, 62, null);
    L5:
        if ((true ^ StringsKt.isBlank(r12)) == false) goto L7;
        goto L7
    }

    public final <T> Object o(CompletableDeferred<T> r10, Function1<? super Continuation<? super T>, ? extends Object> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof WidgetResourceLoader$safeRun$1) == false) goto L7;
        WidgetResourceLoader$safeRun$1 r0 = (WidgetResourceLoader$safeRun$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L16;
        if (r15 != 1) goto L15;
        r10 = (CompletableDeferred) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L22
    L20:
        r10.complete(r13);     // Catch: Exception -> L22
    L25:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
        r0.L$0 = r10;     // Catch: Exception -> L22
        r0.label = 1;     // Catch: Exception -> L22
        r13 = r11.invoke(r0);     // Catch: Exception -> L22
        if (r13 != r14) goto L20;
        return r14;
    L22:
        e = move-exception;
        com.bytedance.ai.applet.base.log.b r16 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + this.b + ") safeRun: " + e.getMessage(), e);
        r10.complete(null);
    L7:
        r0 = new WidgetResourceLoader$safeRun$1(this, r12);
        goto L8
    }

    @Override // com.bytedance.ai.widget.cache.b
    public void d(final String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "conversationID");
        Intrinsics.checkNotNullParameter(r12, "botId");
        Intrinsics.checkNotNullParameter(r13, "msgId");
        h2.a r0 = f2.b.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L9;
        AppletRuntimeManager r1 = AppletRuntimeManager.INSTANCE;
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("trace_id", r13);
        r15.put("eventName", "applet_widget_timeline_full");
        Unit r16 = Unit.INSTANCE;
        Function1 r17 = new e(r10);
        r1.getClass();
        AppletRuntimeManager.n(r10, r11, r12, r13, r14, r15, r17);
        return;
    }
}
