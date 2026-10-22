package com.bytedance.ai.widget.contianer;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import b3.p;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.lynx.k;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.s;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.resource.e0;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.settings.provider.LynxThreadStrategy;
import com.bytedance.ai.settings.provider.LynxViewReusedConfig;
import com.bytedance.ai.settings.provider.WidgetReusedSettings;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.models.OAppletWrap;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.ThreadStrategyForRendering;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import m1.i;
import m1.j;
import org.json.JSONException;
import org.json.JSONObject;
import w2.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/widget/contianer/AppletWidgetContainer;", "Lcom/bytedance/ai/widget/contianer/WidgetContainer;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
@SourceDebugExtension({"SMAP\nAppletWidgetContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppletWidgetContainer.kt\ncom/bytedance/ai/widget/contianer/AppletWidgetContainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,883:1\n1755#2,3:884\n216#3,2:887\n216#3,2:889\n216#3,2:891\n1#4:893\n432#5:894\n432#5:895\n*S KotlinDebug\n*F\n+ 1 AppletWidgetContainer.kt\ncom/bytedance/ai/widget/contianer/AppletWidgetContainer\n*L\n543#1:884,3\n702#1:887,2\n705#1:889,2\n813#1:891,2\n246#1:894\n247#1:895\n*E\n"})
public final class AppletWidgetContainer extends WidgetContainer {
    public int A;
    public String B;
    public final LinearLayout C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final kotlinx.coroutines.internal.c K;
    public Job L;
    public Job M;
    public final c N;
    public final com.bytedance.ai.model.widgets.h O;
    public final bf.b P;
    public final e Q;
    public final d R;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Context f2991t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e1.a f2992u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.ai.widget.cache.b f2993v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public g1.b f2994w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Job f2995x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Widget f2996y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public i1.a f2997z;

    public AppletWidgetContainer(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f2991t = r5;
        this.f2992u = new e1.a(r5);
        LinearLayout r10 = new LinearLayout(r5);
        r10.setOrientation(1);
        r10.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.C = r10;
        final int r11 = 0;
        this.D = LazyKt.lazy(new b(this, r11));
        final int r12 = 1;
        this.E = LazyKt.lazy(new b(this, r12));
        final int r13 = 2;
        this.F = LazyKt.lazy(new b(this, r13));
        final int r14 = 3;
        this.G = LazyKt.lazy(new b(this, r14));
        final int r15 = 4;
        this.H = LazyKt.lazy(new b(this, r15));
        final int r16 = 5;
        this.I = LazyKt.lazy(new b(this, r16));
        final int r17 = 6;
        this.J = LazyKt.lazy(new b(this, r17));
        this.K = h0.a(Dispatchers.getMain().plus(j0.b()));
        this.N = new c(this, 0);
        this.O = new com.bytedance.ai.model.widgets.h(this, 2);
        this.P = new bf.b(this, 1);
        this.Q = new e(this);
        this.R = new d(this);
    }

    public static int o(Integer r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return (int) ((r5.floatValue() * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    @Override // w0.i
    public final View a() {
        throw null;
    }

    @Override // com.bytedance.ai.widget.contianer.f
    public final void b(q r10) {
        if (r10 == null) goto L29;
        this.g = r10;
        ViewParent r11 = this.C.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L7;
        ViewGroup r12 = (ViewGroup) r11;
    L8:
        if (r12 == null) goto L30;
        Widget r5 = this.f2996y;
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.J == false) goto L23;
        GradientDrawable r13 = new GradientDrawable();
        int r14 = 0;
        r13.setShape(0);
        q r15 = this.g;
        if (r15 == null) goto L18;
        int r16 = r15.f22703b;
    L19:
        if (r15 == null) goto L21;
        r14 = r15.f22704c;
    L21:
        r13.setStroke(r16, r14);
        r13.setCornerRadius(0.0f);
        r12.setForeground(r13);
        goto L23
    L18:
        r16 = 1;
    L23:
        if (this.g != null) goto L25;
    L27:
        r12.setOutlineProvider(new br.c(this, 1));
        r12.setClipToOutline(true);
        return;
    L25:
        if (r5.K != 3) goto L27;
        return;
    L30:
        return;
    L7:
        r12 = null;
        goto L8
    }

    @Override // com.bytedance.ai.widget.contianer.WidgetContainer, w0.i
    public final View d() {
        g1.b r5 = this.f2994w;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.a();
    }

    public final Object p(Widget r10, com.bytedance.ai.widget.cache.b r11, g1.b r12, ContinuationImpl r13) {
        if ((r13 instanceof AppletWidgetContainer$renderByNewView$1) == false) goto L7;
        AppletWidgetContainer$renderByNewView$1 r5 = (AppletWidgetContainer$renderByNewView$1) r13;
        int r14 = r5.d;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.f3016b;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.d;
        if (r17 != 0) goto L11;
        ResultKt.throwOnFailure(r15);
        p r18 = b3.h.f841a;
        b3.h.d(v());
        LruCache r19 = e0.f2711a;
        String r110 = e0.d(r10, r10.G);
        k r20 = k.f2188a;
        u0.a r21 = s0.a.f21800c;
        String r22 = "";
        if (r21 == null) goto L21;
        String r23 = r21.f22202m;
        if (r23 == null) goto L21;
    L22:
        Map r24 = k.b(r23);
        Map r25 = k.a(this.f2991t);
        if (r25 == null) goto L28;
        Iterator r26 = r25.entrySet().iterator();
    L26:
        if (r26.hasNext() == false) goto L28;
        Map.Entry r27 = (Map.Entry) r26.next();
        r24.put(r27.getKey(), r27.getValue());
    L28:
        h r28 = this.f;
        if (r28 == null) goto L36;
        Map r29 = r28.f3053k;
        if (r29 == null) goto L36;
        Iterator r30 = r29.entrySet().iterator();
    L34:
        if (r30.hasNext() == false) goto L36;
        Map.Entry r31 = (Map.Entry) r30.next();
        r24.put(r31.getKey(), r31.getValue());
    L36:
        r24.put("__AI_SDK_VERSION__", "0.90.0-rc.37-miniapp");
        AtomicBoolean r32 = s0.a.f21798a;
        r12.setGlobalProperties(r24);
        Map r33 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("url", r110)});
        if ((r12 instanceof com.bytedance.ai.applet.render.core.relax.f) == false) goto L43;
        r33.put("render_mode", ((com.bytedance.ai.applet.render.core.relax.f) r12).f1792a.f1785a);
        String r34 = AISDKSettingConfigManager.INSTANCE.getRELAX_CONFIG().getValue().b();
        if (r34 == null) goto L42;
        r22 = r34;
    L42:
        r33.put("relax_extra_settings", r22);
    L43:
        p r35 = b3.h.f841a;
        b3.h.f(v(), r33);
        r11.getClass();
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r36 = com.bytedance.ai.utils.c.f2846a;
        if (r36 == null) goto L46;
        r36.i("AppletWidgetContainer", "renderByNewView: load default template data");
    L46:
        r12.setViewContext(s(r10));
        r12.setViewData(w());
        r5.f3015a = this;
        r5.d = 2;
        if (r12.a(r110, new JSONObject(), r5) != r16) goto L49;
        return r16;
    L49:
        p r37 = b3.h.f841a;
        b3.h.g(this.v());
        return Unit.INSTANCE;
    L21:
        r23 = "";
        goto L22
    L11:
        if (r17 == 1) goto L16;
        if (r17 == 2) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        AppletWidgetContainer this = r5.f3015a;
        ResultKt.throwOnFailure(r15);
    L7:
        r5 = new AppletWidgetContainer$renderByNewView$1(this, r13);
        goto L8
    }

    public final Object q(Widget r24, com.bytedance.ai.widget.cache.b r25, ContinuationImpl r26) {
        AppletWidgetContainer r5 = this;
        if ((r26 instanceof AppletWidgetContainer$bindDataByType$1) == false) goto L7;
        AppletWidgetContainer$bindDataByType$1 r10 = (AppletWidgetContainer$bindDataByType$1) r26;
        int r11 = r10.d;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.d = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f3005b;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.d;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        r5 = r10.f3004a;
        ResultKt.throwOnFailure(r12);
    L126:
        if (r5.f3026m != null) goto L128;
        r5.f3026m = new com.bytedance.ai.widget.f(r5);
    L128:
        final com.bytedance.ai.widget.f r15 = r5.f3026m;
        e1.a r16 = r5.f2992u;
        if (r15 == null) goto L160;
        h r17 = r5.f;
        if (r17 == null) goto L133;
        String r18 = r17.f3047a;
    L134:
        e1.a r19 = r15.e;
        if (r19 == null) goto L137;
        r19.setOnTouchListener(null);
    L137:
        e1.a r20 = r15.e;
        if (r20 == null) goto L140;
        r20.setOnLongClickListener(null);
    L140:
        r15.e = r16;
        r15.d = r18;
        if (r15.b() == true) goto L143;
        r15.a();
    L143:
        e1.a r21 = r15.e;
        if (r21 == null) goto L147;
        r21.setOnTouchListener(new com.bytedance.ai.widget.d(r15));
    L147:
        if (CollectionsKt.contains(com.bytedance.ai.widget.f.f3059i, r15.d) == false) goto L152;
        r15.f3062c = true;
        if (r15.b() == true) goto L152;
        r15.a();
    L152:
        if (r15.b() == false) goto L160;
        e1.a r22 = r15.e;
        if (r22 == null) goto L160;
        t0.b r23 = com.bytedance.ai.model.p.f2294c;
        if (r23 == null) goto L158;
        View.OnLongClickListener r27 = r23.obtainWidgetLongClickListener(r15.f3060a);
    L159:
        r22.setOnLongClickListener(r27);
        goto L160
    L158:
        r27 = null;
        goto L159
    L133:
        r18 = null;
    L160:
        r16.setLongPressController(r5.f3026m);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        p r28 = b3.h.f841a;
        String r29 = v();
        Intrinsics.checkNotNullParameter(r29, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        long r110 = System.currentTimeMillis();
        String r111 = androidx.room.jarjarred.org.antlr.runtime.a.r("onPrepareComponentStart: ", r29, ", applet_widget_timeline_full", "AppletEventMonitorManager", "tag");
        t0.d r30 = com.bytedance.ai.utils.c.f2846a;
        if (r30 == null) goto L18;
        r30.d("AppletEventMonitorManager", r111);
    L18:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L20;
        Object r112 = r13;
        b3.h.c(new a3.b(r29, r110, 26));
    L23:
        String r31 = r24.f2268o;
        Intrinsics.checkNotNullParameter(r31, "<this>");
        RenderType r32 = RenderType.f1752c;
        if (Intrinsics.areEqual(r31, "webview") == true) goto L34;
        r32 = RenderType.d;
        if (Intrinsics.areEqual(r31, "lynx") == true) goto L34;
        r32 = RenderType.e;
        if (Intrinsics.areEqual(r31, "relax") == true) goto L34;
        r32 = null;
    L34:
        if (r32 != null) goto L39;
        String r33 = ug.a.c(new StringBuilder("renderType is NULL, "), r24.f2268o, " is not support", "AppletWidgetContainer");
        t0.d r113 = com.bytedance.ai.utils.c.f2846a;
        if (r113 == null) goto L38;
        r113.e("AppletWidgetContainer", r33);
    L38:
        AppletWidgetContainer$bindDataByType$1 r114 = r10;
        Object r115 = "applet_page_timeline_full";
        String r116 = ", applet_widget_timeline_full";
        String r210 = "AppletEventMonitorManager";
        g1.b r34 = null;
    L73:
        if (r34 != null) goto L79;
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r35 = com.bytedance.ai.utils.c.f2846a;
        if (r35 == null) goto L77;
        r35.e("AppletWidgetContainer", "createRenderView failed, renderView is NULL");
    L77:
        r5.i(WidgetContainer.LifecycleEvent.f3034c);
        p r36 = b3.h.f841a;
        String r37 = v();
        AppletErrorCode r38 = AppletErrorCode.f2378b;
        b3.h.a(407, r37, "createRenderView failed, renderView is NULL", "applet_widget_timeline_full");
        return Unit.INSTANCE;
    L79:
        r5.f2994w = r34;
        String r39 = r34.getRenderType().f1753a.toUpperCase(Locale.getDefault());
        if ((r34 instanceof com.bytedance.ai.applet.render.core.relax.f) == false) goto L84;
        r39 = r39 + '-' + ((com.bytedance.ai.applet.render.core.relax.f) r34).f1792a.f1785a;
        String r40 = com.lynx.tasm.behavior.utils.d.c("bindDataByType: badge = ", r39, "AppletWidgetContainer");
        t0.d r117 = com.bytedance.ai.utils.c.f2846a;
        if (r117 == null) goto L84;
        r117.i("AppletWidgetContainer", r40);
    L84:
        Intrinsics.checkNotNullParameter(r34.d(), "view");
        Intrinsics.checkNotNullParameter(r39, "badge");
        r34.setViewClient(r5.R);
        r34.setOnTouchEventListener(r5.Q);
        r34.d().addOnLayoutChangeListener(r5.N);
        r34.d().addOnAttachStateChangeListener(r5.P);
        r34.d().setOnFocusChangeListener(r5.O);
        View r41 = r34.d();
        e1.a r42 = r5.f2992u;
        int r118 = -1;
        r42.addView(r41, -1, -2);
        LinearLayout r43 = r5.C;
        Integer r119 = r24.L;
        if (r119 != null) goto L88;
        int r44 = -2;
        int r120 = 1;
    L92:
        r43.addView(r42, r118, r44);
        if (r119 != null) goto L96;
    L98:
        i r45 = r34.getBridge();
        r5.f3025l = r45;
        n1.a r46 = r45.g;
        com.bytedance.ai.model.widgets.i r47 = new com.bytedance.ai.model.widgets.i(r24, r5);
        r46.getClass();
        Intrinsics.checkNotNullParameter(j.class, "clazz");
        RefType r121 = RefType.f1803a;
        r46.c(j.class, r47, r121);
        s r48 = new s(r5, 6);
        n1.a r49 = r45.g;
        r49.getClass();
        Intrinsics.checkNotNullParameter(s.class, "clazz");
        r49.c(s.class, r48, r121);
        r49.c(WidgetContainer.class, r5, RefType.f1804b);
        if (r34.getRenderType() != RenderType.e) goto L101;
        o1.b r50 = new o1.b(1);
        Intrinsics.checkNotNullParameter(r50, "methodSeeker");
        r45.f19974c.add(r50);
    L101:
        com.bytedance.ai.utils.c.g(r5.f3019b, Lifecycle.Event.ON_CREATE);
        p r51 = b3.h.f841a;
        String r52 = v();
        Intrinsics.checkNotNullParameter(r52, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        long r53 = System.currentTimeMillis();
        String r122 = r210;
        String r123 = androidx.room.jarjarred.org.antlr.runtime.a.r("onPrepareComponentEnd: ", r52, r116, r122, "tag");
        t0.d r124 = com.bytedance.ai.utils.c.f2846a;
        if (r124 == null) goto L105;
        r124.d(r122, r123);
    L105:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L108;
        b3.h.c(new a3.b(r52, r53, 10));
    L110:
        b3.h.d(v());
        if (r34.e() == false) goto L119;
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r54 = com.bytedance.ai.utils.c.f2846a;
        if (r54 == null) goto L115;
        r54.i("AppletWidgetContainer", "bindDataByType: renderView is reused");
    L115:
        b3.h.d(v());
        String r125 = v();
        Map r126 = MapsKt.mapOf(TuplesKt.to("isReused", 1));
        Intrinsics.checkNotNullParameter(r125, "traceId");
        Intrinsics.checkNotNullParameter(r126, "eventInfo");
        b3.h.c(new b3.a(r125, System.currentTimeMillis(), r126, 2));
        r5.i(WidgetContainer.LifecycleEvent.f3033b);
        b3.h.f(v(), MapsKt.emptyMap());
        r25.getClass();
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r55 = com.bytedance.ai.utils.c.f2846a;
        if (r55 == null) goto L118;
        r55.i("AppletWidgetContainer", "renderByReusedView: reload default template data");
    L118:
        r34.setViewContext(s(r24));
        r34.setViewData(w());
        r34.a(new JSONObject());
        b3.h.g(v());
        String r56 = v();
        LinkedHashMap r57 = new LinkedHashMap();
        HashMap r58 = new HashMap();
        r58.put("draw_end", Long.valueOf(System.currentTimeMillis()));
        Unit r59 = Unit.INSTANCE;
        r57.put(LynxMonitorService.KEY_SETUP_TIMING, r58);
        b3.h.i(r56, r57);
        r5.i(WidgetContainer.LifecycleEvent.d);
        goto L126
    L119:
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r60 = com.bytedance.ai.utils.c.f2846a;
        if (r60 == null) goto L122;
        r60.i("AppletWidgetContainer", "bindDataByType: renderView is new created");
    L122:
        AppletWidgetContainer$bindDataByType$1 r61 = r114;
        r61.f3004a = r5;
        r61.d = 1;
        Object r62 = r112;
        if (r5.p(r24, r25, r34, r61) != r62) goto L126;
        return r62;
    L108:
        if (Intrinsics.areEqual("applet_widget_timeline_full", r115) == false) goto L110;
        b3.h.c(new a3.b(r52, r53, 11));
        goto L110
    L96:
        if (r119.intValue() != r120) goto L98;
        FrameLayout.LayoutParams r63 = new FrameLayout.LayoutParams(r44, r44);
        r63.gravity = 8388659;
        r63.setMargins(o(Boxing.boxInt(8)), o(Boxing.boxInt(8)), 0, 0);
        Lazy r64 = r5.J;
        ((LinearLayout) r64.getValue()).setElevation(TypedValue.applyDimension(1, 3.0f, ((LinearLayout) r64.getValue()).getResources().getDisplayMetrics()));
        r42.addView((LinearLayout) r64.getValue(), r63);
        ((LinearLayout) r64.getValue()).bringToFront();
        goto L98
    L88:
        if (r119.intValue() != 0) goto L91;
        LinearLayout.LayoutParams r127 = new LinearLayout.LayoutParams(-1, -2);
        r127.setMargins(o(Boxing.boxInt(16)) + 17, o(Boxing.boxInt(12)), o(Boxing.boxInt(16)), o(Boxing.boxInt(12)));
        r43.addView((LinearLayout) r5.F.getValue(), r127);
        r118 = -1;
        r120 = 1;
        r43.addView((View) r5.G.getValue(), new LinearLayout.LayoutParams(-1, 1));
    L90:
        r44 = -2;
        goto L92
    L91:
        r120 = 1;
        goto L90
    L39:
        boolean r128 = r32.f1754b;
        Context r129 = r5.f2991t;
        if (r128 == false) goto L71;
        LynxViewReusedConfig r130 = com.bytedance.ai.widget.cache.d.f2985a;
        String r131 = r24.f2259b;
        Intrinsics.checkNotNullParameter(r131, "appletId");
        String r65 = r24.F;
        r114 = r10;
        Intrinsics.checkNotNullParameter(r65, "widgetId");
        List r66 = com.bytedance.ai.widget.cache.d.f2985a.a();
        if (r66 == null) goto L52;
        Iterator r67 = r66.iterator();
    L45:
        if (r67.hasNext() == false) goto L52;
        WidgetReusedSettings r132 = (WidgetReusedSettings) r67.next();
        Iterator r133 = r67;
        if (Intrinsics.areEqual(r132.getAppletId(), r131) == false) goto L51;
        if (Intrinsics.areEqual(r132.getWidgetId(), r65) == false) goto L51;
    L53:
        if (r132 == null) goto L55;
        int r68 = r132.getReusedMaxSize();
    L56:
        r115 = "applet_page_timeline_full";
        if (r68 <= 0) goto L70;
        r116 = ", applet_widget_timeline_full";
        r210 = "AppletEventMonitorManager";
        StringBuilder r134 = androidx.constraintlayout.motion.widget.a.y("createRenderView: packageName = ", r131, ", widgetId = ", r65, ", maxSize = ");
        r134.append(r68);
        String r135 = r134.toString();
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r136 = com.bytedance.ai.utils.c.f2846a;
        if (r136 == null) goto L61;
        r136.i("AppletWidgetContainer", r135);
    L61:
        i1.c r137 = new i1.c(r129, new String[]{r131, r65});
        LinkedHashMap r69 = i1.b.f17481a;
        Intrinsics.checkNotNullParameter(r137, STGroup.DICT_KEY);
        LinkedHashMap r70 = i1.b.f17481a;
        i1.a r138 = (i1.a) r70.get(r137);
        if (r138 != null) goto L64;
        r138 = new i1.a(r68);
        r70.put(r137, r138);
    L64:
        r5.f2997z = r138;
        StringBuilder r71 = new StringBuilder("acquireRenderView: pool size = ");
        ArrayDeque r72 = r138.f17479b;
        r71.append(r72.size());
        String r73 = r71.toString();
        Intrinsics.checkNotNullParameter("RenderViewPool", "tag");
        Intrinsics.checkNotNullParameter(r73, "msg");
        a1.a.f43a.i("RenderViewPool", r73);
        if (r72.isEmpty() == false) goto L67;
        r34 = null;
    L68:
        if (r34 != null) goto L73;
    L72:
        r34 = com.bytedance.ai.applet.components.view.c.b(r129, r32, r24, r25);
        goto L73
    L67:
        r34 = (g1.b) r72.removeLast();
    L70:
        r116 = ", applet_widget_timeline_full";
        r210 = "AppletEventMonitorManager";
        goto L72
    L55:
        r68 = 0;
    L51:
        r67 = r133;
    L52:
        r132 = null;
        goto L53
    L71:
        r114 = r10;
        r115 = "applet_page_timeline_full";
        goto L70
    L20:
        r112 = r13;
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L23;
        b3.h.c(new a3.b(r29, r110, 27));
    L7:
        r10 = new AppletWidgetContainer$bindDataByType$1(r5, r26);
        goto L8
    }

    public final Object r(h r30, ContinuationImpl r31) {
        AppletWidgetContainer r5 = this;
        h r10 = r30;
        if ((r31 instanceof AppletWidgetContainer$bindData$1) == false) goto L7;
        AppletWidgetContainer$bindData$1 r11 = (AppletWidgetContainer$bindData$1) r31;
        int r12 = r11.g;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.g = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.e;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.g;
        String r16 = "";
        if (r15 == 0) goto L20;
        if (r15 == 1) goto L19;
        if (r15 == 2) goto L18;
        if (r15 == 3) goto L17;
        if (r15 != 4) goto L16;
        ResultKt.throwOnFailure(r13);
    L118:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Widget r17 = r11.d;
        com.bytedance.ai.widget.cache.b r18 = r11.f3000c;
        h r19 = r11.f2999b;
        AppletWidgetContainer r20 = r11.f2998a;
        ResultKt.throwOnFailure(r13);
    L55:
        Applet r21 = (Applet) r13;
        if (r21 == null) goto L69;
        r20.B = r21.J;
        String r22 = r21.f2258a;
        Lazy r23 = r20.E;
        if (r22 != null) goto L60;
    L63:
        ((TextView) r23.getValue()).setVisibility(8);
    L65:
        if (r22.length() <= 0) goto L67;
        ((TextView) r23.getValue()).setText(r22);
        ((TextView) r23.getValue()).setMaxLines(1);
        ((TextView) r23.getValue()).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) r23.getValue()).setVisibility(0);
    L68:
        r20.t(r21, (ImageView) r20.D.getValue(), r20.L);
        r20.t(r21, (ImageView) r20.H.getValue(), r20.M);
        ((TextView) r20.I.getValue()).setText(r22);
        ((LinearLayout) r20.J.getValue()).setContentDescription(r22);
    L72:
        h r24 = r20.f;
        StringBuilder r25 = new StringBuilder("getThreadStrategy strategy=");
        AISDKSettingConfigManager r26 = AISDKSettingConfigManager.INSTANCE;
        r25.append(r26.getWIDGET_SETTINGS_CONFIG().getValue().b());
        r25.append(" cache_limit=");
        r25.append(r26.getWIDGET_SETTINGS_CONFIG().getValue().a());
        String r27 = r25.toString();
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L75;
        r28.i("WidgetContainer", r27);
    L75:
        List r29 = r26.getWIDGET_SETTINGS_CONFIG().getValue().b();
        if (r29 == null) goto L107;
        Iterator r32 = r29.iterator();
    L79:
        if (r32.hasNext() == false) goto L107;
        LynxThreadStrategy r33 = (LynxThreadStrategy) r32.next();
        List<String> r34 = r33.getWidgets();
        if (r34 == null) goto L79;
        Iterator<T> r35 = r34.iterator();
    L84:
        if (r35.hasNext() == false) goto L79;
        String r36 = (String) r35.next();
        String r110 = (String) CollectionsKt.getOrNull(StringsKt.K(r36, new String[]{"@"}, 0, 6), 0);
        String r37 = (String) CollectionsKt.getOrNull(StringsKt.K(r36, new String[]{"@"}, 0, 6), 1);
        if (r24 == null) goto L88;
        String r111 = r24.f3047a;
    L90:
        if (Intrinsics.areEqual(r110, r111) == false) goto L84;
        if (r24 == null) goto L93;
        String r112 = r24.f3048b;
    L95:
        if (Intrinsics.areEqual(r37, r112) == false) goto L84;
        ThreadStrategyForRendering[] r38 = ThreadStrategyForRendering.values();
        int r39 = r33.getThreadStrategy();
        if (r39 >= 0) goto L99;
    L101:
        ThreadStrategyForRendering r40 = ThreadStrategyForRendering.f10065b;
    L103:
        if (r33.getAsyncCreateView() <= 0) goto L105;
        boolean r41 = true;
    L106:
        Pair r42 = new Pair(Boolean.valueOf(r41), r40);
    L108:
        boolean r43 = ((Boolean) r42.getFirst()).booleanValue();
        String r44 = "asyncCreateView = " + r43;
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r45 = com.bytedance.ai.utils.c.f2846a;
        if (r45 == null) goto L111;
        r45.i("AppletWidgetContainer", r44);
    L111:
        if (r43 == false) goto L114;
        r20.f2995x = BuildersKt.launch$default(h0.a(t2.b.d), null, null, new AppletWidgetContainer$bindData$5(r20, r17, r18, null), 3, null);
        return Unit.INSTANCE;
    L114:
        r11.f2998a = null;
        r11.f2999b = null;
        r11.f3000c = null;
        r11.d = null;
        r11.g = 4;
        if (r20.q(r17, r18, r11) != r14) goto L118;
    L116:
        return r14;
    L105:
        r41 = false;
        goto L106
    L99:
        if (r39 >= r38.length) goto L101;
        r40 = r38[r39];
        goto L103
    L93:
        r112 = null;
        goto L95
    L88:
        r111 = null;
    L107:
        r42 = new Pair(Boolean.FALSE, ThreadStrategyForRendering.f10065b);
        goto L108
    L67:
        ((TextView) r23.getValue()).setVisibility(8);
        goto L68
    L60:
        if (r22.length() == 0) goto L63;
        ((TextView) r23.getValue()).setText(r22);
        ((TextView) r23.getValue()).setMaxLines(1);
        ((TextView) r23.getValue()).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) r23.getValue()).setVisibility(0);
        goto L65
    L69:
        String r46 = androidx.room.jarjarred.org.antlr.runtime.a.v(new StringBuilder("bindData: loadApplet failed, appletId:"), r19.f3047a, "AppletWidgetContainer", "tag");
        t0.d r47 = com.bytedance.ai.utils.c.f2846a;
        if (r47 == null) goto L72;
        r47.e("AppletWidgetContainer", r46);
        goto L72
    L18:
        r17 = r11.d;
        r18 = r11.f3000c;
        r19 = r11.f2999b;
        r20 = r11.f2998a;
        ResultKt.throwOnFailure(r13);
    L52:
        com.bytedance.ai.resource.j r48 = com.bytedance.ai.resource.j.f2734a;
        String r49 = r19.f3047a;
        r11.f2998a = r20;
        r11.f2999b = r19;
        r11.f3000c = r18;
        r11.d = r17;
        r11.g = 3;
        r13 = r48.f(r49, null, r11);
        if (r13 != r14) goto L55;
    L19:
        com.bytedance.ai.widget.cache.b r50 = r11.f3000c;
        r10 = r11.f2999b;
        AppletWidgetContainer r51 = r11.f2998a;
        ResultKt.throwOnFailure(r13);
        com.bytedance.ai.widget.cache.b r52 = r50;
        r5 = r51;
    L32:
        Widget r53 = (Widget) r13;
        if (r53 != null) goto L39;
        String r54 = "widget is NULL, packageName = " + r10.f3047a + ", widgetId = " + r10.f3048b;
        p r55 = b3.h.f841a;
        String r56 = r10.a();
        AppletErrorCode r57 = AppletErrorCode.f2378b;
        b3.h.a(LynxErrorCode.LYNX_ERROR_CODE_UPDATE, r56, r54, "applet_widget_timeline_full");
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r58 = com.bytedance.ai.utils.c.f2846a;
        if (r58 == null) goto L37;
        r58.e("AppletWidgetContainer", r54);
    L37:
        r5.i(WidgetContainer.LifecycleEvent.f3034c);
        return Unit.INSTANCE;
    L39:
        AtomicBoolean r113 = s0.a.f21798a;
        p r114 = b3.h.f841a;
        String r115 = r10.a();
        String r116 = r53.B;
        if (r116 == null) goto L43;
        r16 = r116;
    L43:
        Map r59 = MapsKt.mapOf(new Pair[]{TuplesKt.to("widget_res_from", r16), TuplesKt.to("version_code", Boxing.boxLong(r53.f2260c)), TuplesKt.to("render_type", r53.f2268o)});
        Intrinsics.checkNotNullParameter(r115, "traceId");
        Intrinsics.checkNotNullParameter(r59, "eventInfo");
        b3.h.c(new b3.a(r115, System.currentTimeMillis(), r59, 3));
        r5.f2996y = r53;
        r53.g();
        if (ym.a.e(r53.C) == true) goto L51;
        StringBuilder r60 = new StringBuilder("bindData: runtimeVersion is invalid, packageName = ");
        r60.append(r10.f3047a);
        r60.append(", widgetId = ");
        String r61 = androidx.room.jarjarred.org.antlr.runtime.a.v(r60, r10.f3048b, "AppletWidgetContainer", "tag");
        t0.d r62 = com.bytedance.ai.utils.c.f2846a;
        if (r62 == null) goto L48;
        r62.i("AppletWidgetContainer", r61);
    L48:
        r11.f2998a = r5;
        r11.f2999b = r10;
        r11.f3000c = r52;
        r11.d = r53;
        r11.g = 2;
        com.bytedance.ai.widget.cache.e r63 = (com.bytedance.ai.widget.cache.e) r52;
        r63.getClass();
        if (com.bytedance.ai.widget.cache.e.a(r63, r10, r11) == r14) goto L116;
    L51:
        r20 = r5;
        r17 = r53;
        com.bytedance.ai.widget.cache.b r210 = r52;
        r19 = r10;
        r18 = r210;
        goto L52
    L20:
        ResultKt.throwOnFailure(r13);
        String r64 = r10.f3047a;
        String r117 = r10.f3052j;
        if (r117 != null) goto L23;
        String r211 = "";
    L24:
        OAppletWrap r118 = r10.f3056n;
        ConversationWidgetData r65 = new ConversationWidgetData(r64, r10.f3048b, r10.e, r10.d, r211, null, r10.f3049c, null, r118, 128, null);
        r5.f = r10;
        r5.A = r5.f3021h.getInt(r30.a(), 0);
        String r66 = r30.a();
        String r119 = r10.e;
        String r120 = r10.f3047a;
        String r121 = r10.f3048b;
        new com.bytedance.ai.widget.p(r119, r66, r120, r121);
        t0.b r67 = com.bytedance.ai.model.p.f2294c;
        if (r67 == null) goto L28;
        r52 = r67.createWidgetResourceLoader(r65, null);
        if (r52 == null) goto L28;
    L29:
        r5.f2993v = r52;
        p r68 = b3.h.f841a;
        String r69 = r30.a();
        Map r70 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Constant.APPID, r121), TuplesKt.to("packageId", r120)});
        Intrinsics.checkNotNullParameter(r69, "traceId");
        Intrinsics.checkNotNullParameter(r70, "eventInfo");
        b3.h.c(new b3.a(r69, System.currentTimeMillis(), r70, 6));
        r11.f2998a = r5;
        r11.f2999b = r10;
        r11.f3000c = r52;
        r11.g = 1;
        r13 = com.bytedance.ai.widget.cache.e.h((com.bytedance.ai.widget.cache.e) r52, r11);
        if (r13 != r14) goto L32;
    L28:
        r52 = new com.bytedance.ai.widget.cache.e(r65);
        goto L29
    L23:
        r211 = r117;
    L7:
        r11 = new AppletWidgetContainer$bindData$1(r5, r31);
        goto L8
    }

    public final Map s(Widget r19) {
        AtomicBoolean r5 = s0.a.f21798a;
        Pair r10 = TuplesKt.to("viewId", this.e);
        h r11 = this.f;
        if (r11 == null) goto L6;
        String r12 = r11.f3047a;
        if (r12 == null) goto L6;
    L7:
        Pair r13 = TuplesKt.to("appletId", r12);
        h r14 = this.f;
        if (r14 == null) goto L11;
        String r15 = r14.f3048b;
        if (r15 == null) goto L11;
    L12:
        Pair r16 = TuplesKt.to("pageName", r15);
        h r17 = this.f;
        if (r17 == null) goto L16;
        String r18 = r17.d;
        if (r18 == null) goto L16;
    L17:
        Pair r20 = TuplesKt.to("botId", r18);
        h r21 = this.f;
        if (r21 == null) goto L21;
        String r22 = r21.e;
        if (r22 == null) goto L21;
    L22:
        Pair r23 = TuplesKt.to("msgId", r22);
        h r24 = this.f;
        if (r24 == null) goto L26;
        String r25 = r24.f3051i;
        if (r25 == null) goto L26;
    L27:
        Pair r26 = TuplesKt.to("mixtureCardId", r25);
        Pair r27 = TuplesKt.to("replyFor", "");
        Pair r110 = TuplesKt.to("conversationId", this.f3018a);
        h r28 = this.f;
        if (r28 == null) goto L30;
        Object r29 = r28.f3050h.get("createTime");
    L31:
        Pair r111 = TuplesKt.to("msgCreateTime", r29);
        ArrayList r30 = r19.O;
        Intrinsics.checkNotNullParameter(r30, "settingsList");
        LinkedHashMap r112 = new LinkedHashMap();
        u0.a r113 = s0.a.f21800c;
        if (r113 == null) goto L62;
        Application r114 = r113.f22194a;
        if (r114 == null) goto L62;
        Handler r115 = pg.e.f21353a;
        qg.c r31 = ug.d.f(r114).e("");
        if (r31 == null) goto L38;
        JSONObject r32 = r31.f21511a;
    L40:
        if (r32 != null) goto L44;
        Intrinsics.checkNotNullParameter("AppSettingsUtils", "tag");
        t0.d r33 = com.bytedance.ai.utils.c.f2846a;
        if (r33 == null) goto L62;
        r33.e("AppSettingsUtils", "appSetting is null");
        goto L62
    L44:
        Iterator r116 = r30.iterator();
    L46:
        if (r116.hasNext() == false) goto L62;
        String r117 = (String) r116.next();
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L50
        Object r35 = Result.m124constructorimpl(r32.get(r117));     // Catch: Throwable -> L50
    L52:
        Throwable r118 = Result.m127exceptionOrNullimpl(r35);
        if (r118 == null) goto L59;
        String r36 = String.valueOf(r118.getMessage());
        Intrinsics.checkNotNullParameter("AppSettingsUtils", "tag");
        t0.d r37 = com.bytedance.ai.utils.c.f2846a;
        if (r37 == null) goto L58;
        r37.e("AppSettingsUtils", r36);
    L58:
        r35 = null;
    L59:
        if (r35 == null) goto L61;
        r112.put(r117, r35);
    L61:
        r32 = r32;
    L50:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r35 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L52
    L38:
        r32 = null;
    L62:
        Pair r120 = TuplesKt.to("appSettings", r112);
        Pair r121 = TuplesKt.to("lang", "zh");
        h r38 = this.f;
        if (r38 == null) goto L65;
        String r39 = r38.f3054l;
    L66:
        Map r40 = MapsKt.mutableMapOf(new Pair[]{r10, r13, r16, r20, r23, r26, r27, r110, r111, r120, r121, TuplesKt.to("mcpName", r39)});
        h r41 = this.f;
        if (r41 == null) goto L74;
        Map r42 = r41.g;
        if (r42 == null) goto L74;
        Iterator r43 = r42.entrySet().iterator();
    L72:
        if (r43.hasNext() == false) goto L74;
        Map.Entry r44 = (Map.Entry) r43.next();
        r40.put((String) r44.getKey(), (String) r44.getValue());
    L74:
        r40.put("extra", null);
        return r40;
    L65:
        r39 = null;
        goto L66
    L30:
        r29 = null;
    L26:
        r25 = "";
    L21:
        r22 = "";
    L16:
        r18 = "";
    L11:
        r15 = "";
    L6:
        r12 = "";
        goto L7
    }

    public final void t(Applet r10, ImageView r11, Job r12) {
        Icons r5 = r10.g;
        if (r5 == null) goto L5;
        String r13 = r5.get3x();
    L6:
        if (r13 != null) goto L8;
    L20:
        r11.setVisibility(8);
        return;
    L8:
        if (r13.length() == 0) goto L20;
        if (r12 == null) goto L12;
        r12.cancel(null);
    L12:
        Job r14 = BuildersKt.launch$default(this.K, Dispatchers.getMain().getImmediate(), null, new AppletWidgetContainer$loadIcon$newJob$1(r11, r10, r13, null), 2, null);
        if (Intrinsics.areEqual(r11, (ImageView) this.D.getValue()) == false) goto L17;
        this.L = r14;
        return;
    L17:
        if (Intrinsics.areEqual(r11, (ImageView) this.H.getValue()) == false) goto L22;
        this.M = r14;
        return;
    L22:
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final void u() {
        ((g) this.f3027n.getValue()).postDelayed(new androidx.fragment.app.d(this, 12), 2000);
        h0.c(this.f3022i.f2844b, null);
        Intrinsics.checkNotNullParameter("CoroutineDebouncer", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.i("CoroutineDebouncer", "Debouncer cancel");
    L5:
        this.f3030q = null;
        this.d.clear();
        Widget r10 = this.f2996y;
        if (r10 == null) goto L8;
        r10.h();
    L8:
        p r11 = b3.h.f841a;
        String r12 = v();
        Intrinsics.checkNotNullParameter(r12, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        b3.h.c(new b3.e(true, r12));
        String r13 = v();
        Intrinsics.checkNotNullParameter(r13, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        String r14 = ug.a.c(new StringBuilder("removeEvent: "), r13, ", applet_widget_timeline_full", "AppletEventMonitorManager");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L11;
        r15.d("AppletEventMonitorManager", r14);
    L11:
        b3.h.c(new a3.a(r13, 3));
        Job r16 = this.f2995x;
        if (r16 == null) goto L14;
        r16.cancel(null);
    L14:
        g1.b r17 = this.f2994w;
        if (r17 == null) goto L37;
        r17.c();
        r17.b();
        r17.d().removeOnLayoutChangeListener(this.N);
        r17.d().removeOnAttachStateChangeListener(this.P);
        r17.d().setOnFocusChangeListener(null);
        i1.a r18 = this.f2997z;
        if (r18 == null) goto L33;
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L21;
        r19.i("AppletWidgetContainer", "onHostDestroy: releaseRenderView");
    L21:
        Intrinsics.checkNotNullParameter(r17, "view");
        if (r18.f17480c == false) goto L25;
        Intrinsics.checkNotNullParameter("RenderViewPool", "tag");
        Intrinsics.checkNotNullParameter("releaseRenderView: pool is destroyed", "msg");
        a1.a.f43a.w("RenderViewPool", "releaseRenderView: pool is destroyed");
        r17.destroy();
        goto L37
    L25:
        if (r18.f17479b.size() >= r18.f17478a) goto L32;
        ViewParent r20 = r17.d().getParent();
        if (r20 != null) goto L29;
    L31:
        r17.setReused(true);
        Intrinsics.checkNotNullParameter("RenderViewPool", "tag");
        Intrinsics.checkNotNullParameter("releaseRenderView: add pool", "msg");
        a1.a.f43a.i("RenderViewPool", "releaseRenderView: add pool");
        r18.f17479b.add(r17);
        goto L37
    L29:
        if ((r20 instanceof ViewGroup) == false) goto L31;
        ((ViewGroup) r20).removeView(r17.d());
        goto L31
    L32:
        Intrinsics.checkNotNullParameter("RenderViewPool", "tag");
        Intrinsics.checkNotNullParameter("releaseRenderView: destroy", "msg");
        a1.a.f43a.i("RenderViewPool", "releaseRenderView: destroy");
        r17.destroy();
        goto L37
    L33:
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L36;
        r21.i("AppletWidgetContainer", "onHostDestroy: destroyRenderView");
    L36:
        r17.destroy();
    L37:
        this.f2994w = null;
        com.bytedance.ai.widget.cache.b r22 = this.f2993v;
        if (r22 == null) goto L45;
        com.bytedance.ai.widget.cache.e r23 = (com.bytedance.ai.widget.cache.e) r22;
        String r24 = f4.a.b(new StringBuilder("Loader("), r23.f2989b, ") release:");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L42;
        r25.i("WidgetResourceLoader", r24);
    L42:
        TemplateBundle r26 = r23.d;
        if (r26 == null) goto L45;
        r26.e();
    L45:
        com.bytedance.ai.utils.c.g(this.f3019b, Lifecycle.Event.ON_DESTROY);
    }

    public final String v() {
        h r5 = this.f;
        if (r5 == null) goto L8;
        String r10 = r5.a();
        if (r10 == null) goto L10;
        return r10;
    L10:
        return "";
    L8:
        return "";
    }

    public final JSONObject w() {
        h r5 = this.f;     // Catch: JSONException -> L7
        if (r5 == null) goto L9;
        String r10 = r5.f3049c;     // Catch: JSONException -> L7
        if (r10 == null) goto L9;
    L10:
        return new JSONObject(r10);
    L9:
        r10 = "{}";
    L7:
        e = move-exception;
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L16;
        r11.e("AppletWidgetContainer", "getWidgetData: JSONException", e);
    L16:
        return new JSONObject();
    }
}
