package com.bytedance.ai.widget.cache;

import android.os.Trace;
import android.util.LruCache;
import b3.p;
import com.bytedance.ai.lynx.i;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.e0;
import com.bytedance.ai.resource.j;
import com.bytedance.ai.widget.contianer.h;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.ui.image.f0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.r;
import kotlinx.coroutines.s;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements b {
    public static final ConcurrentHashMap f = null;
    public static final ConcurrentHashMap g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap f2986h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicInteger f2987i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConversationWidgetData f2988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Widget f2990c;
    public volatile TemplateBundle d;
    public volatile byte[] e;

    static {
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        f2986h = new ConcurrentHashMap();
        f2987i = new AtomicInteger(0);
    }

    public e(ConversationWidgetData r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetData");
        this.f2988a = r5;
        this.f2989b = f2987i.incrementAndGet();
    }

    public static Object a(e r11, h r12, ContinuationImpl r13) {
        if ((r13 instanceof WidgetResourceLoader$awaitRunApplet$1) == false) goto L8;
        WidgetResourceLoader$awaitRunApplet$1 r5 = (WidgetResourceLoader$awaitRunApplet$1) r13;
        int r10 = r5.d;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.d = r10 - Integer.MIN_VALUE;
    L7:
        WidgetResourceLoader$awaitRunApplet$1 r14 = r5;
        Object r15 = r14.f2940b;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r14.d;
        String r18 = "";
        if (r17 == 0) goto L15;
        if (r17 != 1) goto L14;
        r12 = r14.f2939a;
        ResultKt.throwOnFailure(r15);
    L26:
        AppletRuntime r19 = (AppletRuntime) r15;
    L27:
        if (r19 != null) goto L31;
        Intrinsics.checkNotNullParameter("WidgetResourceLoader", "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L31;
        r110.e("WidgetResourceLoader", "createWidgetContainer runApplet failed");
    L31:
        p r111 = b3.h.f841a;
        String r112 = r12.a();
        if (r19 == null) goto L37;
        Applet r113 = r19.f2197h;
        if (r113 == null) goto L37;
        String r114 = r113.B;
        if (r114 == null) goto L37;
    L38:
        Pair r115 = TuplesKt.to("applet_res_from", r114);
        if (r19 == null) goto L44;
        String r116 = r19.s;
        if (r116 == null) goto L44;
        r18 = r116;
    L44:
        b3.h.e(r112, "applet_widget_timeline_full", MapsKt.mapOf(new Pair[]{r115, TuplesKt.to("main_js_res_from", r18)}));
        return Unit.INSTANCE;
    L37:
        r114 = "";
        goto L38
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        p r117 = b3.h.f841a;
        b3.h.h(r12.a(), "applet_widget_timeline_full");
        Lazy r118 = com.bytedance.ai.model.p.f2292a;
        String r119 = r12.f3052j;
        r19 = com.bytedance.ai.model.p.a(r119, r12.d, r12.f3047a);
        if (r19 != null) goto L27;
        Intrinsics.checkNotNullParameter("WidgetResourceLoader", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L20;
        r20.i("WidgetResourceLoader", "createWidgetContainer runApplet");
    L20:
        if (r119 != null) goto L22;
        String r21 = "";
    L23:
        String r22 = r12.a();
        Map r23 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("trace_id", r12.a()), TuplesKt.to("eventName", "applet_widget_timeline_full")});
        r14.f2939a = r12;
        r14.d = 1;
        r15 = com.bytedance.ai.model.p.c(r12.f3047a, r21, r12.d, r22, r23, r14);
        if (r15 != r16) goto L26;
        return r16;
    L22:
        r21 = r119;
    L8:
        r5 = new WidgetResourceLoader$awaitRunApplet$1(r11, r13);
        goto L7
    }

    public static final Object b(e r12, ContinuationImpl r13) {
        if ((r13 instanceof WidgetResourceLoader$loadWidgetFromPackage$1) == false) goto L7;
        WidgetResourceLoader$loadWidgetFromPackage$1 r5 = (WidgetResourceLoader$loadWidgetFromPackage$1) r13;
        int r10 = r5.f;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r10 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.d;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.f;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        String r16 = r5.f2976c;
        String r17 = r5.f2975b;
        e r18 = r5.f2974a;
        ResultKt.throwOnFailure(r14);
        String r19 = r16;
        r12 = r18;
    L21:
        Widget r110 = (Widget) r14;
        Trace.endSection();
        StringBuilder r20 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r20, r12.f2989b, ") loadWidgetFromPackage: end loading, packageName = ", r17, ", widgetId = ");
        String r111 = androidx.room.jarjarred.org.antlr.runtime.a.v(r20, r19, "WidgetResourceLoader", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L24;
        r21.i("WidgetResourceLoader", r111);
    L24:
        return r110;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        String r112 = r12.f2988a.getPackageName();
        ConversationWidgetData r22 = r12.f2988a;
        r19 = r22.getWidgetId();
        StringBuilder r23 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r23, r12.f2989b, ") loadWidgetFromPackage: start loading, packageName = ", r112, ", widgetId = ");
        String r24 = androidx.room.jarjarred.org.antlr.runtime.a.v(r23, r19, "WidgetResourceLoader", "tag");
        t0.d r113 = com.bytedance.ai.utils.c.f2846a;
        if (r113 == null) goto L17;
        r113.i("WidgetResourceLoader", r24);
    L17:
        Trace.beginSection("loadWidget_" + r19);
        j r25 = j.f2734a;
        Map r26 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message_id", r22.getMessageId()), TuplesKt.to("botId", r22.getBotId())});
        r5.f2974a = r12;
        r5.f2975b = r112;
        r5.f2976c = r19;
        r5.f = 1;
        Object r27 = r25.d(r112, r19, r26, r5);
        if (r27 != r11) goto L20;
        return r11;
    L20:
        r17 = r112;
        r14 = r27;
    L7:
        r5 = new WidgetResourceLoader$loadWidgetFromPackage$1(r12, r13);
        goto L8
    }

    public static void d(String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "conversationID");
        Intrinsics.checkNotNullParameter(r12, "botId");
        Intrinsics.checkNotNullParameter(r13, "msgId");
        u0.a r5 = s0.a.f21800c;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.f22194a == null) goto L9;
        Lazy r15 = com.bytedance.ai.model.p.f2292a;
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("trace_id", r13);
        r16.put("eventName", "applet_widget_timeline_full");
        Unit r17 = Unit.INSTANCE;
        com.bytedance.ai.model.p.d(r10, r11, r12, r13, r14, r16, new b2.c(r10, 4));
        return;
    }

    public static Object e(e r17, ContinuationImpl r18) {
        e r5 = r17;
        if ((r18 instanceof WidgetResourceLoader$loadRtsBytecode$1) == false) goto L7;
        WidgetResourceLoader$loadRtsBytecode$1 r10 = (WidgetResourceLoader$loadRtsBytecode$1) r18;
        int r11 = r10.f2945h;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.f2945h = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.f2945h;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        r r15 = (r) r10.f2944c;
        String r16 = r10.f2943b;
        e r19 = r10.f2942a;
        ResultKt.throwOnFailure(r12);
    L78:
        f2986h.remove(r16, r15);
        j0.e(r10.getContext());
        r19.getClass();
        return r19.e;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r r20 = r10.e;
        String r21 = r10.d;
        String r22 = (String) r10.f2944c;
        String r110 = r10.f2943b;
        e r111 = r10.f2942a;
        ResultKt.throwOnFailure(r12);
        r r112 = r20;
        r5 = r111;
    L63:
        byte[] r23 = (byte[]) r12;
        if (r23 == null) goto L70;
        String r24 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadRtsBytecode: hit awaitResult");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L68;
        r25.i("WidgetResourceLoader", r24);
    L68:
        r5.e = r23;
        return r23;
    L70:
        String r26 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadRtsBytecode: awaitResult is NULL");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L73;
        r27.e("WidgetResourceLoader", r26);
    L73:
        String r28 = r22;
    L74:
        WidgetResourceLoader$loadRtsBytecode$3 r29 = new WidgetResourceLoader$loadRtsBytecode$3(r5, r110, r28, null);
        r10.f2942a = r5;
        r10.f2943b = r21;
        r10.f2944c = r112;
        r10.d = null;
        r10.e = null;
        r10.f2945h = 2;
        if (r5.c(r112, r29, r10) != r13) goto L77;
    L76:
        return r13;
    L77:
        r16 = r21;
        r19 = r5;
        r15 = r112;
        goto L78
    L16:
        ResultKt.throwOnFailure(r12);
        r17.getClass();
        if (r5.e == null) goto L23;
        String r30 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadRtsBytecode: rtsBytecode is loaded");
        t0.d r31 = com.bytedance.ai.utils.c.f2846a;
        if (r31 == null) goto L22;
        r31.w("WidgetResourceLoader", r30);
    L22:
        return r5.e;
    L23:
        r110 = r5.f2988a.getPackageName();
        r28 = r5.f2988a.getWidgetId();
        boolean r32 = a.f2980a;
        Intrinsics.checkNotNullParameter(r110, "packageName");
        Intrinsics.checkNotNullParameter(r28, "widgetId");
        if (a.f2980a == true) goto L26;
        byte[] r33 = null;
    L27:
        r5.e = r33;
        if (r5.e == null) goto L35;
        StringBuilder r34 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r34, r5.f2989b, ") loadRtsBytecode: hit cache, packageName = ", r110, ", widgetId = ");
        String r35 = androidx.room.jarjarred.org.antlr.runtime.a.v(r34, r28, "WidgetResourceLoader", "tag");
        t0.d r36 = com.bytedance.ai.utils.c.f2846a;
        if (r36 == null) goto L33;
        r36.i("WidgetResourceLoader", r35);
    L33:
        return r5.e;
    L35:
        if (r5.f2990c != null) goto L40;
        String r37 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadRtsBytecode: widget is NULL");
        t0.d r38 = com.bytedance.ai.utils.c.f2846a;
        if (r38 == null) goto L39;
        r38.e("WidgetResourceLoader", r37);
    L39:
        return null;
    L40:
        Widget r39 = r5.f2990c;
        if (r39 == null) goto L43;
        String r40 = r39.f2268o;
    L45:
        if (Intrinsics.areEqual(r40, "relax") == true) goto L54;
        StringBuilder r41 = new StringBuilder("Loader(");
        r41.append(r5.f2989b);
        r41.append(") loadRtsBytecode: renderType is NOT lynx, it is ");
        Widget r42 = r5.f2990c;
        if (r42 == null) goto L49;
        String r43 = r42.f2268o;
    L50:
        String r44 = androidx.room.jarjarred.org.antlr.runtime.a.v(r41, r43, "WidgetResourceLoader", "tag");
        t0.d r45 = com.bytedance.ai.utils.c.f2846a;
        if (r45 == null) goto L53;
        r45.e("WidgetResourceLoader", r44);
    L53:
        return null;
    L49:
        r43 = null;
        goto L50
    L54:
        r21 = androidx.constraintlayout.motion.widget.a.m(r110, ':', r28);
        r112 = j0.a();
        r r113 = (r) f2986h.putIfAbsent(r21, r112);
        if (r113 == null) goto L74;
        String r114 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadRtsBytecode: other loader is loading");
        t0.d r115 = com.bytedance.ai.utils.c.f2846a;
        if (r115 == null) goto L59;
        r115.i("WidgetResourceLoader", r114);
    L59:
        WidgetResourceLoader$loadRtsBytecode$2$awaitResult$1 r116 = new WidgetResourceLoader$loadRtsBytecode$2$awaitResult$1(r113, null);
        r10.f2942a = r5;
        r10.f2943b = r110;
        r10.f2944c = r28;
        r10.d = r21;
        r10.e = r112;
        r10.f2945h = 1;
        Object r46 = e2.b(5000, r116, r10);
        if (r46 == r13) goto L76;
        r22 = r28;
        r12 = r46;
        goto L63
    L43:
        r40 = null;
        goto L45
    L26:
        r33 = (byte[]) a.d.get(a.a(r110, r28));
    L7:
        r10 = new WidgetResourceLoader$loadRtsBytecode$1(r5, r18);
        goto L8
    }

    public static Object f(e r17, ContinuationImpl r18) {
        e r5 = r17;
        if ((r18 instanceof WidgetResourceLoader$loadTemplateBundle$1) == false) goto L7;
        WidgetResourceLoader$loadTemplateBundle$1 r10 = (WidgetResourceLoader$loadTemplateBundle$1) r18;
        int r11 = r10.f2957h;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.f2957h = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.f2957h;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        r r15 = (r) r10.f2956c;
        String r16 = r10.f2955b;
        e r19 = r10.f2954a;
        ResultKt.throwOnFailure(r12);
    L78:
        g.remove(r16, r15);
        j0.e(r10.getContext());
        r19.getClass();
        return r19.d;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r r20 = r10.e;
        String r21 = r10.d;
        String r22 = (String) r10.f2956c;
        String r110 = r10.f2955b;
        e r111 = r10.f2954a;
        ResultKt.throwOnFailure(r12);
        r r112 = r20;
        r5 = r111;
    L63:
        TemplateBundle r23 = (TemplateBundle) r12;
        if (r23 == null) goto L70;
        String r24 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadTemplateJs: hit awaitResult");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L68;
        r25.i("WidgetResourceLoader", r24);
    L68:
        r5.d = r23;
        return r23;
    L70:
        String r26 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadTemplateJs: awaitResult is NULL");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L73;
        r27.e("WidgetResourceLoader", r26);
    L73:
        String r28 = r22;
    L74:
        WidgetResourceLoader$loadTemplateBundle$3 r29 = new WidgetResourceLoader$loadTemplateBundle$3(r5, r110, r28, null);
        r10.f2954a = r5;
        r10.f2955b = r21;
        r10.f2956c = r112;
        r10.d = null;
        r10.e = null;
        r10.f2957h = 2;
        if (r5.c(r112, r29, r10) != r13) goto L77;
    L76:
        return r13;
    L77:
        r16 = r21;
        r19 = r5;
        r15 = r112;
        goto L78
    L16:
        ResultKt.throwOnFailure(r12);
        r17.getClass();
        if (r5.d == null) goto L23;
        String r30 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadTemplateJs: templateBundle is loaded");
        t0.d r31 = com.bytedance.ai.utils.c.f2846a;
        if (r31 == null) goto L22;
        r31.w("WidgetResourceLoader", r30);
    L22:
        return r5.d;
    L23:
        r110 = r5.f2988a.getPackageName();
        r28 = r5.f2988a.getWidgetId();
        boolean r32 = a.f2980a;
        Intrinsics.checkNotNullParameter(r110, "packageName");
        Intrinsics.checkNotNullParameter(r28, "widgetId");
        if (a.f2980a == true) goto L26;
        TemplateBundle r33 = null;
    L27:
        r5.d = r33;
        if (r5.d == null) goto L35;
        StringBuilder r34 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r34, r5.f2989b, ") loadTemplateBundle: hit cache, packageName = ", r110, ", widgetId = ");
        String r35 = androidx.room.jarjarred.org.antlr.runtime.a.v(r34, r28, "WidgetResourceLoader", "tag");
        t0.d r36 = com.bytedance.ai.utils.c.f2846a;
        if (r36 == null) goto L33;
        r36.i("WidgetResourceLoader", r35);
    L33:
        return r5.d;
    L35:
        if (r5.f2990c != null) goto L40;
        String r37 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadTemplateJs: widget is NULL");
        t0.d r38 = com.bytedance.ai.utils.c.f2846a;
        if (r38 == null) goto L39;
        r38.e("WidgetResourceLoader", r37);
    L39:
        return null;
    L40:
        Widget r39 = r5.f2990c;
        if (r39 == null) goto L43;
        String r40 = r39.f2268o;
    L45:
        if (Intrinsics.areEqual(r40, "lynx") == true) goto L54;
        StringBuilder r41 = new StringBuilder("Loader(");
        r41.append(r5.f2989b);
        r41.append(") loadTemplateBundle: renderType is NOT lynx, it is ");
        Widget r42 = r5.f2990c;
        if (r42 == null) goto L49;
        String r43 = r42.f2268o;
    L50:
        String r44 = androidx.room.jarjarred.org.antlr.runtime.a.v(r41, r43, "WidgetResourceLoader", "tag");
        t0.d r45 = com.bytedance.ai.utils.c.f2846a;
        if (r45 == null) goto L53;
        r45.e("WidgetResourceLoader", r44);
    L53:
        return null;
    L49:
        r43 = null;
        goto L50
    L54:
        r21 = androidx.constraintlayout.motion.widget.a.m(r110, ':', r28);
        r112 = j0.a();
        r r113 = (r) g.putIfAbsent(r21, r112);
        if (r113 == null) goto L74;
        String r114 = f4.a.b(new StringBuilder("Loader("), r5.f2989b, ") loadTemplateJs: other loader is loading");
        t0.d r115 = com.bytedance.ai.utils.c.f2846a;
        if (r115 == null) goto L59;
        r115.i("WidgetResourceLoader", r114);
    L59:
        WidgetResourceLoader$loadTemplateBundle$2$awaitResult$1 r116 = new WidgetResourceLoader$loadTemplateBundle$2$awaitResult$1(r113, null);
        r10.f2954a = r5;
        r10.f2955b = r110;
        r10.f2956c = r28;
        r10.d = r21;
        r10.e = r112;
        r10.f2957h = 1;
        Object r46 = e2.b(5000, r116, r10);
        if (r46 == r13) goto L76;
        r22 = r28;
        r12 = r46;
        goto L63
    L43:
        r40 = null;
        goto L45
    L26:
        r33 = (TemplateBundle) a.f2982c.get(a.a(r110, r28));
    L7:
        r10 = new WidgetResourceLoader$loadTemplateBundle$1(r5, r18);
        goto L8
    }

    public static Object g(e r11, ContinuationImpl r12) {
        if ((r12 instanceof WidgetResourceLoader$loadTemplateBundleFromPackage$1) == false) goto L7;
        WidgetResourceLoader$loadTemplateBundleFromPackage$1 r5 = (WidgetResourceLoader$loadTemplateBundleFromPackage$1) r12;
        int r10 = r5.f;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r10 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.d;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.f;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        String r16 = r5.f2965c;
        String r17 = r5.f2964b;
        e r18 = r5.f2963a;
        ResultKt.throwOnFailure(r13);
        String r19 = r16;
        r11 = r18;
    L30:
        TemplateBundle r110 = (TemplateBundle) r13;
        String r111 = r17;
    L31:
        Trace.endSection();
        StringBuilder r20 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r20, r11.f2989b, ") loadTemplateBundleFromPackage: end loading, packageName = ", r111, ", widgetId = ");
        String r112 = androidx.room.jarjarred.org.antlr.runtime.a.v(r20, r19, "WidgetResourceLoader", "tag");
        t0.d r113 = com.bytedance.ai.utils.c.f2846a;
        if (r113 == null) goto L34;
        r113.i("WidgetResourceLoader", r112);
    L34:
        return r110;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r111 = r11.f2988a.getPackageName();
        r19 = r11.f2988a.getWidgetId();
        StringBuilder r21 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r21, r11.f2989b, ") loadTemplateBundleFromPackage: start loading, packageName = ", r111, ", widgetId = ");
        String r22 = androidx.room.jarjarred.org.antlr.runtime.a.v(r21, r19, "WidgetResourceLoader", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L17;
        r23.i("WidgetResourceLoader", r22);
    L17:
        StringBuilder r24 = new StringBuilder("loadTemplateBundle_");
        Widget r25 = r11.f2990c;
        r110 = null;
        if (r25 == null) goto L20;
        String r26 = r25.F;
    L21:
        r24.append(r26);
        Trace.beginSection(r24.toString());
        Widget r27 = r11.f2990c;
        if (r27 == null) goto L31;
        String r28 = r27.f2276x;
        if (r28 != null) goto L26;
        r28 = "";
    L26:
        LruCache r114 = e0.f2711a;
        String r29 = e0.d(r27, r27.G);
        r5.f2963a = r11;
        r5.f2964b = r111;
        r5.f2965c = r19;
        r5.f = 1;
        Object r30 = i.b(r28, r29, r5);
        if (r30 != r14) goto L29;
        return r14;
    L29:
        r17 = r111;
        r13 = r30;
        goto L30
    L20:
        r26 = null;
    L7:
        r5 = new WidgetResourceLoader$loadTemplateBundleFromPackage$1(r11, r12);
        goto L8
    }

    public static Object h(e r13, ContinuationImpl r14) {
        if ((r14 instanceof WidgetResourceLoader$loadWidget$1) == false) goto L7;
        WidgetResourceLoader$loadWidget$1 r5 = (WidgetResourceLoader$loadWidget$1) r14;
        int r10 = r5.f;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r10 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.d;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r5.f;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L15;
        if (r12 != 2) goto L14;
        r r16 = r5.f2968c;
        String r17 = r5.f2967b;
        e r18 = r5.f2966a;
        ResultKt.throwOnFailure(r15);
    L56:
        f.remove(r17, r16);
        j0.e(r5.getContext());
        r18.getClass();
        return r18.f2990c;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r r19 = r5.f2968c;
        String r20 = r5.f2967b;
        e r21 = r5.f2966a;
        ResultKt.throwOnFailure(r15);
        r r110 = r19;
        r13 = r21;
        Object r22 = r15;
    L42:
        Widget r23 = (Widget) r22;
        if (r23 == null) goto L49;
        String r111 = f4.a.b(new StringBuilder("Loader("), r13.f2989b, ") loadWidget: hit awaitResult");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L47;
        r24.i("WidgetResourceLoader", r111);
    L47:
        r13.f2990c = r23;
        return r23;
    L49:
        String r25 = f4.a.b(new StringBuilder("Loader("), r13.f2989b, ") loadWidget: awaitResult is NULL");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L52;
        r26.e("WidgetResourceLoader", r25);
    L52:
        WidgetResourceLoader$loadWidget$3 r27 = new WidgetResourceLoader$loadWidget$3(r13, null);
        r5.f2966a = r13;
        r5.f2967b = r20;
        r5.f2968c = r110;
        r5.f = 2;
        if (r13.c(r110, r27, r5) != r11) goto L55;
    L54:
        return r11;
    L55:
        r17 = r20;
        r18 = r13;
        r16 = r110;
        goto L56
    L16:
        ResultKt.throwOnFailure(r15);
        if (r13.f2990c == null) goto L23;
        String r112 = f4.a.b(new StringBuilder("Loader("), r13.f2989b, ") loadWidget: widget is loaded");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L22;
        r28.w("WidgetResourceLoader", r112);
    L22:
        return r13.f2990c;
    L23:
        String r113 = r13.f2988a.getPackageName();
        String r29 = r13.f2988a.getWidgetId();
        boolean r30 = a.f2980a;
        Intrinsics.checkNotNullParameter(r113, "packageName");
        Intrinsics.checkNotNullParameter(r29, "widgetId");
        if (a.f2980a == true) goto L26;
        Widget r31 = null;
    L27:
        r13.f2990c = r31;
        if (r13.f2990c == null) goto L34;
        StringBuilder r32 = new StringBuilder("Loader(");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r32, r13.f2989b, ") loadWidget: hit cache, packageName = ", r113, ", widgetId = ");
        String r114 = androidx.room.jarjarred.org.antlr.runtime.a.v(r32, r29, "WidgetResourceLoader", "tag");
        t0.d r33 = com.bytedance.ai.utils.c.f2846a;
        if (r33 == null) goto L33;
        r33.i("WidgetResourceLoader", r114);
    L33:
        return r13.f2990c;
    L34:
        r20 = androidx.constraintlayout.motion.widget.a.m(r113, ':', r29);
        r110 = j0.a();
        r r34 = (r) f.putIfAbsent(r20, r110);
        if (r34 == null) goto L52;
        String r35 = f4.a.b(new StringBuilder("Loader("), r13.f2989b, ") loadWidget: other loader is loading");
        t0.d r115 = com.bytedance.ai.utils.c.f2846a;
        if (r115 == null) goto L39;
        r115.i("WidgetResourceLoader", r35);
    L39:
        WidgetResourceLoader$loadWidget$2$awaitResult$1 r36 = new WidgetResourceLoader$loadWidget$2$awaitResult$1(r34, null);
        r5.f2966a = r13;
        r5.f2967b = r20;
        r5.f2968c = r110;
        r5.f = 1;
        r22 = e2.b(5000, r36, r5);
        if (r22 != r11) goto L42;
    L26:
        r31 = (Widget) a.f2981b.get(a.a(r113, r29));
    L7:
        r5 = new WidgetResourceLoader$loadWidget$1(r13, r14);
        goto L8
    }

    public final Object c(r r5, Function1 r10, ContinuationImpl r11) {
        if ((r11 instanceof WidgetResourceLoader$safeRun$1) == false) goto L7;
        WidgetResourceLoader$safeRun$1 r12 = (WidgetResourceLoader$safeRun$1) r11;
        int r13 = r12.e;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.e = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f2979c;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.e;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        r5 = r12.f2978b;
        e this = r12.f2977a;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L14
    L22:
        ((s) r5).N(r14);     // Catch: Exception -> L14
    L29:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r12.f2977a = this;     // Catch: Exception -> L14
        r12.f2978b = r5;     // Catch: Exception -> L14
        r12.e = 1;     // Catch: Exception -> L14
        r14 = r10.invoke(r12);     // Catch: Exception -> L14
        if (r14 != r15) goto L22;
        return r15;
    L14:
        e = move-exception;
        StringBuilder r17 = new StringBuilder("Loader(");
        r17.append(this.f2989b);
        r17.append(") safeRun: ");
        String r18 = f0.d(e, r17, "WidgetResourceLoader");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L27;
        r19.e("WidgetResourceLoader", r18, e);
    L27:
        ((s) r5).N(null);
    L7:
        r12 = new WidgetResourceLoader$safeRun$1(this, r11);
        goto L8
    }
}
