package com.bytedance.ai.widget;

import android.content.Context;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.ai.ex.widget.WidgetRenderService$createWidget$context$1;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.settings.provider.RelaxConfig;
import com.bytedance.ai.settings.provider.WidgetCacheLimit;
import com.bytedance.ai.settings.provider.WidgetDegradeSetting;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.models.OAppletWrap;
import com.bytedance.keva.Keva;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements x0.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l f3079j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ArrayDeque f3080k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w2.q f3081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GlobalWidgetCache$WidgetCacheMap f3083c;
    public final HashMap d;
    public final HashMap e;
    public final HashSet f;
    public final q g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f3084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f3085i;

    static {
        f3079j = new l();
        f3080k = new ArrayDeque();
    }

    public o() {
        this.f3082b = new HashMap();
        GlobalWidgetCache$WidgetCacheMap r5 = new GlobalWidgetCache$WidgetCacheMap(5);
        this.f3083c = r5;
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashSet();
        this.g = new q();
        this.f3084h = new HashMap();
        n r10 = new n(this);
        this.f3085i = r10;
        com.bytedance.ai.resource.j r11 = com.bytedance.ai.resource.j.f2734a;
        Intrinsics.checkNotNullParameter(r10, "listener");
        com.bytedance.ai.resource.j.f2735b.add(r10);
        h r12 = new h(this, 0);
        Intrinsics.checkNotNullParameter(r12, "callback");
        r5.f2913b = r12;
    }

    public static void g(com.bytedance.ai.widget.contianer.f r5, HashMap r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (Intrinsics.areEqual((com.bytedance.ai.widget.contianer.f) r13.getValue(), r5) == false) goto L4;
        r11.put(r13.getKey(), r13.getValue());
        goto L4
    L8:
        Object r14 = CollectionsKt.firstOrNull(r11.keySet());
        if (r14 == null) goto L17;
        WidgetContainer r15 = (WidgetContainer) r5;
        r15.k();
        ((AppletWidgetContainer) r15).u();
        r10.remove(r14);
        return;
    }

    public final int a(HashMap r5, k r10, int r11, int r12) {
        if (r11 > r12) goto L4;
        return r11;
    L4:
        Iterator r13 = r5.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        com.bytedance.ai.widget.contianer.f r14 = (com.bytedance.ai.widget.contianer.f) ((Map.Entry) r13.next()).getValue();
        if (((Boolean) r10.invoke(r14)).booleanValue() == false) goto L10;
        WidgetContainer r15 = (WidgetContainer) r14;
        r15.k();
        ((AppletWidgetContainer) r15).u();
        r13.remove();
        this.e.remove(r15);
        r11 = r11 - 1;
    L10:
        if (r11 > r12) goto L6;
    L11:
        String r16 = "removeCacheToLimit clear end count=" + r11;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L14;
        r17.i("WidgetManager", r16);
    L14:
        return r11;
    }

    public final LinearLayout b(com.bytedance.ai.widget.contianer.f r5, w2.r r10) {
        if (r5 != null) goto L5;
        return null;
    L5:
        this.f3082b.put(r10.a(), r5);
        WidgetContainer r11 = (WidgetContainer) r5;
        WidgetRenderService$createWidget$context$1 r12 = r10.g;
        Intrinsics.checkNotNullParameter(r12, "widgetLifeObserver");
        r11.d.add(r12);
        String r13 = "resendLifecycleEvent " + r11 + ' ' + r11.f3023j;
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L8;
        r14.d("WidgetContainer", r13);
    L8:
        WidgetContainer.LifecycleEvent r15 = r11.f3023j;
        if (r15 == null) goto L11;
        r11.i(r15);
    L11:
        LinearLayout r16 = ((AppletWidgetContainer) r5).C;
        h(r10, r5, r16);
        return r16;
    }

    public final com.bytedance.ai.widget.contianer.f c(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        Iterator r10 = this.f3082b.values().iterator();
    L3:
        Object r11 = null;
        if (r10.hasNext() == false) goto L8;
        Object r12 = r10.next();
        com.bytedance.ai.widget.contianer.f r13 = (com.bytedance.ai.widget.contianer.f) r12;
        Intrinsics.checkNotNull(r13);
        if (((Boolean) r5.invoke(r13)).booleanValue() == false) goto L3;
    L9:
        com.bytedance.ai.widget.contianer.f r14 = (com.bytedance.ai.widget.contianer.f) r12;
        if (r14 != null) goto L19;
        Iterator r15 = this.d.values().iterator();
    L13:
        if (r15.hasNext() == false) goto L17;
        Object r16 = r15.next();
        com.bytedance.ai.widget.contianer.f r17 = (com.bytedance.ai.widget.contianer.f) r16;
        Intrinsics.checkNotNull(r17);
        if (((Boolean) r5.invoke(r17)).booleanValue() == false) goto L13;
    L18:
        r14 = (com.bytedance.ai.widget.contianer.f) r16;
        goto L19
    L17:
        r16 = null;
    L19:
        if (r14 != null) goto L28;
        Iterator<T> r18 = this.f3083c.values().iterator();
    L22:
        if (r18.hasNext() == false) goto L26;
        Object r19 = r18.next();
        com.bytedance.ai.widget.contianer.f r20 = (com.bytedance.ai.widget.contianer.f) r19;
        Intrinsics.checkNotNull(r20);
        if (((Boolean) r5.invoke(r20)).booleanValue() == false) goto L22;
    L27:
        r14 = (com.bytedance.ai.widget.contianer.f) r19;
        goto L28
    L26:
        r19 = null;
    L28:
        if (r14 != null) goto L37;
        Iterator r21 = this.f3084h.values().iterator();
    L31:
        if (r21.hasNext() == false) goto L36;
        Object r22 = r21.next();
        com.bytedance.ai.widget.contianer.f r23 = (com.bytedance.ai.widget.contianer.f) r22;
        Intrinsics.checkNotNull(r23);
        if (((Boolean) r5.invoke(r23)).booleanValue() == false) goto L31;
        r11 = r22;
    L36:
        return (com.bytedance.ai.widget.contianer.f) r11;
    L37:
        return r14;
    L8:
        r12 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16, types: [T, android.widget.LinearLayout] */
    public final Object d(w2.r r31, String r32, String r33, ContinuationImpl r34) {
        o r5 = this;
        w2.r r10 = r31;
        if ((r34 instanceof WidgetManager$buildLoginWidget$1) == false) goto L8;
        WidgetManager$buildLoginWidget$1 r11 = (WidgetManager$buildLoginWidget$1) r34;
        int r12 = r11.f2921h;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L8;
        r11.f2921h = r12 - Integer.MIN_VALUE;
    L7:
        WidgetManager$buildLoginWidget$1 r13 = r11;
        Object r14 = r13.f;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.f2921h;
        if (r16 == 0) goto L15;
        if (r16 != 1) goto L14;
        Ref.ObjectRef r17 = r13.e;
        String r18 = r13.d;
        String r19 = r13.f2920c;
        w2.r r20 = r13.f2919b;
        o r21 = r13.f2918a;
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r110 = r17;
        String r22 = r18;
        Object r23 = r14;
        String r24 = r19;
        r10 = r20;
        o r25 = r21;
        String r26 = "WidgetManager";
        String r27 = "tag";
        WidgetManager$buildLoginWidget$1 r28 = r13;
    L36:
        com.bytedance.ai.widget.contianer.f r29 = (com.bytedance.ai.widget.contianer.f) r23;
        j0.e(r28.getContext());
        if (r29 == null) goto L40;
        ?? r30 = ((AppletWidgetContainer) r29).C;
        r110.element = r30;
        r10.getClass();
        r25.f3082b.put(r10.a(), r29);
        r25.h(r10, r29, r30);
    L40:
        if (r110.element == 0) goto L56;
        if (r29 == null) goto L56;
        HashMap r35 = r25.e;
        String r111 = r10.a();
        String r112 = r10.f22707c;
        if (r112 != null) goto L45;
        String r113 = "";
    L46:
        WidgetInfo r114 = r10.e;
        if (r114 == null) goto L49;
        String r115 = r114.getWidgetId();
    L50:
        r35.put(r29, new m(r111, r113, r115, "", Boxing.boxInt(0), r10.e));
        h r36 = new h(r25, 2);
        WidgetContainer r37 = (WidgetContainer) r29;
        if (r37.f3030q == null) goto L53;
    L55:
        r37.f3030q = r36;
        goto L56
    L53:
        if (r37.f3028o.isEmpty() == false) goto L55;
        r36.invoke(r37);
        goto L55
    L49:
        r115 = null;
        goto L50
    L45:
        r113 = r112;
    L56:
        WidgetInfo r38 = r10.e;
        if (r38 == null) goto L59;
        String r39 = r38.getMixtureCardId();
    L61:
        if (com.bytedance.ai.utils.c.l(r39) == false) goto L85;
        if (r24.length() <= 0) goto L85;
        if (r22.length() <= 0) goto L85;
        Keva r40 = com.bytedance.ai.widget.cache.c.f2983a;
        if (Intrinsics.areEqual(r10.f22705a, null) == false) goto L85;
        Intrinsics.checkNotNullParameter(r26, r27);
        t0.d r41 = com.bytedance.ai.utils.c.f2846a;
        if (r41 == null) goto L71;
        r41.i(r26, "bindSystemWidget: last message is mixture, save it");
    L71:
        String r42 = r10.f22706b;
        if (r42 != null) goto L74;
        String r116 = "";
    L75:
        String r43 = r10.d;
        if (r43 != null) goto L78;
        String r44 = "";
    L79:
        WidgetInfo r45 = r10.e;
        if (r45 == null) goto L82;
        String r117 = r45.getAppType();
    L83:
        OAppletWrap r118 = r10.f22711k;
        com.bytedance.ai.widget.cache.c.b(new ConversationWidgetData(r24, r22, r10.f22705a, r44, r116, null, null, r117, r118, 64, null));
        goto L85
    L82:
        r117 = null;
        goto L83
    L78:
        r44 = r43;
        goto L79
    L74:
        r116 = r42;
    L85:
        Trace.endSection();
        View r46 = (View) r110.element;
        if (r46 == null) goto L93;
        ViewParent r47 = r46.getParent();
        if ((r47 instanceof ViewGroup) == false) goto L90;
        ViewGroup r48 = (ViewGroup) r47;
    L91:
        if (r48 == null) goto L93;
        r48.removeView(r46);
        goto L93
    L90:
        r48 = null;
    L93:
        String r49 = "buildLoginWidget: view to return: " + r110.element;
        Intrinsics.checkNotNullParameter(r26, r27);
        t0.d r50 = com.bytedance.ai.utils.c.f2846a;
        if (r50 == null) goto L97;
        r50.d(r26, r49);
    L97:
        return r110.element;
    L59:
        r39 = null;
        goto L61
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        String r51 = "buildLoginWidget: applet: " + r32 + ", widget: " + r33;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r52 = com.bytedance.ai.utils.c.f2846a;
        if (r52 == null) goto L18;
        r52.i("WidgetManager", r51);
    L18:
        Ref.ObjectRef r53 = new Ref.ObjectRef();
        WidgetInfo r54 = r10.e;
        if (r54 == null) goto L21;
        WidgetInfo r55 = WidgetInfo.copy$default(r54, r32, r33, null, null, null, null, null, null, null, null, null, 2040, null);
    L22:
        r10.e = r55;
        r26 = "WidgetManager";
        r27 = "tag";
        Intrinsics.checkNotNullParameter(r26, r27);
        t0.d r56 = com.bytedance.ai.utils.c.f2846a;
        if (r56 == null) goto L25;
        r56.d(r26, "buildLoginWidget: view is null, create it.");
    L25:
        WidgetInfo r57 = r10.e;
        if (r57 != null) goto L28;
    L32:
        r28 = r13;
        r28.f2918a = r5;
        r28.f2919b = r10;
        r28.f2920c = r32;
        r28.d = r33;
        r28.e = r53;
        r28.f2921h = 1;
        r23 = r5.f(r10, r28);
        if (r23 != r15) goto L35;
        return r15;
    L35:
        r110 = r53;
        r22 = r33;
        r24 = r32;
        r25 = r5;
        goto L36
    L28:
        if (Intrinsics.areEqual(r57.getAppType(), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L32;
        String r58 = r57.getAppletId();
        if (r58 == null) goto L32;
        com.bytedance.ai.resource.j.l(r58);
        goto L32
    L21:
        r55 = null;
    L8:
        r11 = new WidgetManager$buildLoginWidget$1(r5, r34);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [T, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r6v14, types: [T, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r6v17, types: [T, android.widget.LinearLayout] */
    public final Object e(w2.r r25, Continuation r26) {
        o r5 = this;
        w2.r r10 = r25;
        int r11 = 1;
        if ((r26 instanceof WidgetManager$bindWidget$1) == false) goto L7;
        WidgetManager$bindWidget$1 r12 = (WidgetManager$bindWidget$1) r26;
        int r13 = r12.f;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.d;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.f;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Ref.ObjectRef r17 = r12.f2917c;
        r10 = r12.f2916b;
        o r18 = r12.f2915a;
        ResultKt.throwOnFailure(r14);
        Object r19 = r14;
        Ref.ObjectRef r20 = r17;
        o r21 = r18;
    L83:
        com.bytedance.ai.widget.contianer.f r22 = (com.bytedance.ai.widget.contianer.f) r19;
        j0.e(r12.getContext());
        o r23 = r21;
        if (r22 == null) goto L86;
        ?? r24 = ((AppletWidgetContainer) r22).C;
        r20.element = r24;
        r10.getClass();
        r21.f3082b.put(r10.a(), r22);
        r21.h(r10, r22, r24);
        r23 = r21;
    L86:
        r10.getClass();
        com.bytedance.ai.widget.contianer.f r27 = (com.bytedance.ai.widget.contianer.f) r23.f3082b.get(r10.a());
        if (r20.element == 0) goto L103;
        if (r27 == null) goto L103;
        HashMap r28 = r23.e;
        String r110 = r10.a();
        String r111 = r10.f22707c;
        if (r111 != null) goto L92;
        String r112 = "";
    L93:
        WidgetInfo r113 = r10.e;
        if (r113 == null) goto L96;
        String r114 = r113.getWidgetId();
    L97:
        r28.put(r27, new m(r110, r112, r114, "", Boxing.boxInt(0), r10.e));
        h r29 = new h(r23, r11);
        WidgetContainer r30 = (WidgetContainer) r27;
        if (r30.f3030q == null) goto L100;
    L102:
        r30.f3030q = r29;
        goto L103
    L100:
        if (r30.f3028o.isEmpty() == false) goto L102;
        r29.invoke(r30);
        goto L102
    L96:
        r114 = null;
        goto L97
    L92:
        r112 = r111;
    L103:
        WidgetInfo r31 = r10.e;
        if (r31 == null) goto L106;
        String r32 = r31.getMixtureCardId();
    L108:
        if (com.bytedance.ai.utils.c.l(r32) == false) goto L145;
        WidgetInfo r33 = r10.e;
        if (r33 == null) goto L115;
        String r34 = r33.getAppletId();
        if (r34 == null) goto L115;
        String r115 = r34;
    L116:
        WidgetInfo r35 = r10.e;
        if (r35 == null) goto L122;
        String r36 = r35.getWidgetId();
        if (r36 == null) goto L122;
        String r116 = r36;
    L124:
        if (r115.length() <= 0) goto L145;
        if (r116.length() <= 0) goto L145;
        Keva r37 = com.bytedance.ai.widget.cache.c.f2983a;
        Integer r38 = null;
        if (Intrinsics.areEqual(r10.f22705a, null) == false) goto L146;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r39 = com.bytedance.ai.utils.c.f2846a;
        if (r39 == null) goto L132;
        r39.i("WidgetManager", "bindWidget: last message is mixture, save it");
    L132:
        String r40 = r10.f22706b;
        if (r40 != null) goto L135;
        String r117 = "";
    L136:
        String r41 = r10.d;
        if (r41 != null) goto L139;
        String r118 = "";
    L140:
        WidgetInfo r42 = r10.e;
        if (r42 == null) goto L143;
        String r119 = r42.getAppType();
    L144:
        OAppletWrap r43 = r10.f22711k;
        com.bytedance.ai.widget.cache.c.b(new ConversationWidgetData(r115, r116, r10.f22705a, r118, r117, null, null, r119, r43, 64, null));
        goto L146
    L143:
        r119 = null;
        goto L144
    L139:
        r118 = r41;
        goto L140
    L135:
        r117 = r40;
    L146:
        Trace.endSection();
        StringBuilder r44 = new StringBuilder("bindWidget: render view's width: ");
        View r45 = (View) r20.element;
        if (r45 == null) goto L149;
        Integer r46 = Boxing.boxInt(r45.getWidth());
    L150:
        r44.append(r46);
        r44.append(", height: ");
        View r47 = (View) r20.element;
        if (r47 == null) goto L153;
        Integer r48 = Boxing.boxInt(r47.getHeight());
    L154:
        r44.append(r48);
        String r49 = r44.toString();
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r50 = com.bytedance.ai.utils.c.f2846a;
        if (r50 == null) goto L158;
        r50.d("WidgetManager", r49);
    L158:
        return r20.element;
    L153:
        r48 = r38;
        goto L154
    L149:
        r46 = r38;
    L122:
        r116 = "";
    L115:
        r115 = "";
    L145:
        r38 = null;
        goto L146
    L106:
        r32 = null;
        goto L108
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Trace.beginSection("bindWidget");
        String r51 = "bindWidget msgId=" + r10.f22705a + " parent=" + r10.f + " enableCache=true";
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r52 = com.bytedance.ai.utils.c.f2846a;
        if (r52 == null) goto L17;
        r52.i("WidgetManager", r51);
    L17:
        r20 = new Ref.ObjectRef();
        WidgetInfo r120 = r10.e;
        if (r120 == null) goto L49;
        RelaxConfig r53 = n3.a.f20200a;
        String r54 = r120.getAppletId();
        String r121 = r120.getWidgetId();
        if (r54 == null) goto L39;
        if (r121 == null) goto L39;
        List r122 = n3.a.f20200a.a();
        if (r122 == null) goto L33;
        Iterator r123 = r122.iterator();
    L27:
        if (r123.hasNext() == false) goto L33;
        WidgetDegradeSetting r124 = (WidgetDegradeSetting) r123.next();
        if (Intrinsics.areEqual(r124.a(), r54) == false) goto L27;
        if (Intrinsics.areEqual(r124.c(), r121) == false) goto L27;
    L34:
        if (r124 == null) goto L42;
        String r55 = "getDegradeWidgetId: setting = " + r124;
        Intrinsics.checkNotNullParameter("RelaxDegradeSettings", "tag");
        t0.d r125 = com.bytedance.ai.utils.c.f2846a;
        if (r125 == null) goto L38;
        r125.i("RelaxDegradeSettings", r55);
    L38:
        String r126 = r124.b();
    L43:
        if (r126 == null) goto L48;
        String r56 = "degradeWidgetIfNeed " + r120.getWidgetId();
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r127 = com.bytedance.ai.utils.c.f2846a;
        if (r127 == null) goto L47;
        r127.d("WidgetManager", r56);
    L47:
        r120 = WidgetInfo.copy$default(r120, null, r126, null, null, null, null, null, null, null, null, null, 2045, null);
    L48:
        r10.e = r120;
    L42:
        r126 = null;
    L33:
        r124 = null;
    L39:
        Intrinsics.checkNotNullParameter("RelaxDegradeSettings", "tag");
        t0.d r57 = com.bytedance.ai.utils.c.f2846a;
        if (r57 == null) goto L42;
        r57.e("RelaxDegradeSettings", "getDegradeWidgetId: appletId or widgetId is null");
    L49:
        com.bytedance.ai.applet.login.j.d(r25);
        HashMap r58 = r5.f3082b;
        if (r58.containsKey(r25.a()) == false) goto L59;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r128 = com.bytedance.ai.utils.c.f2846a;
        if (r128 == null) goto L54;
        r128.d("WidgetManager", "bindWidget already on screen");
    L54:
        com.bytedance.ai.widget.contianer.f r59 = (com.bytedance.ai.widget.contianer.f) r58.get(r25.a());
        if (r59 == null) goto L57;
        T r60 = ((AppletWidgetContainer) r59).C;
    L58:
        r20.element = r60;
    L71:
        r23 = r5;
        if (r20.element != 0) goto L86;
        WidgetInfo r61 = r10.e;
        if (r61 != null) goto L76;
    L80:
        r12.f2915a = r5;
        r12.f2916b = r10;
        r12.f2917c = r20;
        r12.f = 1;
        r19 = r5.f(r10, r12);
        r21 = r5;
        if (r19 != r15) goto L83;
        return r15;
    L76:
        if (Intrinsics.areEqual(r61.getAppType(), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L80;
        String r62 = r61.getAppletId();
        if (r62 == null) goto L80;
        com.bytedance.ai.resource.j.l(r62);
        goto L80
    L57:
        r60 = 0;
        goto L58
    L59:
        HashMap r63 = r5.d;
        if (r63.containsKey(r25.a()) == false) goto L65;
        com.bytedance.ai.widget.contianer.f r64 = (com.bytedance.ai.widget.contianer.f) r63.remove(r25.a());
        String r129 = "bindWidget use cached widget " + r64;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r130 = com.bytedance.ai.utils.c.f2846a;
        if (r130 == null) goto L64;
        r130.d("WidgetManager", r129);
    L64:
        r20.element = r5.b(r64, r10);
        goto L71
    L65:
        String r65 = r25.a();
        GlobalWidgetCache$WidgetCacheMap r131 = r5.f3083c;
        if (r131.containsKey(r65) == false) goto L71;
        com.bytedance.ai.widget.contianer.f r66 = (com.bytedance.ai.widget.contianer.f) r131.remove(r25.a());
        String r132 = "bindWidget use exist from recycled " + r66;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r133 = com.bytedance.ai.utils.c.f2846a;
        if (r133 == null) goto L70;
        r133.d("WidgetManager", r132);
    L70:
        r20.element = r5.b(r66, r10);
    L7:
        r12 = new WidgetManager$bindWidget$1(r5, r26);
        goto L8
    }

    public final Object f(w2.r r33, ContinuationImpl r34) {
        int r5 = 0;
        if ((r34 instanceof WidgetManager$createWidgetContainer$1) == false) goto L7;
        WidgetManager$createWidgetContainer$1 r10 = (WidgetManager$createWidgetContainer$1) r34;
        int r11 = r10.d;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.d = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f2923b;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.d;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        AppletWidgetContainer r15 = r10.f2922a;
        ResultKt.throwOnFailure(r12);
    L122:
        Trace.endSection();
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        FrameLayout r16 = r33.f;
        if (r16 == null) goto L18;
        Context r17 = r16.getContext();
        if (r17 == null) goto L18;
    L26:
        b3.p r18 = b3.h.f841a;
        final String r19 = r33.a();
        final LinkedHashMap r110 = r33.f22709i;
        WidgetInfo r20 = r33.e;
        if (r20 == null) goto L29;
        String r21 = r20.getMixtureCardId();
    L30:
        final boolean r111 = com.bytedance.ai.utils.c.l(r21);
        Intrinsics.checkNotNullParameter(r19, "traceId");
        final long r112 = System.currentTimeMillis();
        b3.h.c(new b3.c(r19, r110, r111, r112));
        u0.a r22 = s0.a.f21800c;
        if (r22 != null) goto L33;
    L34:
        return null;
    L33:
        if (r22.f22194a == null) goto L34;
        WidgetInfo r23 = r33.e;
        String r24 = r33.f22706b;
        if (r24 != null) goto L38;
    L126:
        String r25 = "invalid render context " + r33;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L129;
        r26.w("WidgetManager", r25);
    L129:
        return null;
    L38:
        if (r24.length() == 0) goto L126;
        if (r23 == null) goto L42;
        String r27 = r23.getAppletId();
    L43:
        if (r27 == null) goto L126;
        if (r23.getWidgetId() == null) goto L126;
        l r28 = f3079j;
        String r113 = r23.getAppletId();
        String r114 = r23.getWidgetId();
        monitor-enter(r28);
        Intrinsics.checkNotNullParameter(r113, "packageName");     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r114, "widgetId");     // Catch: Throwable -> L59
        List r115 = AISDKSettingConfigManager.INSTANCE.getWIDGET_SETTINGS_CONFIG().getValue().a();     // Catch: Throwable -> L59
        if (r115 == null) goto L65;
        Iterator r116 = r115.iterator();     // Catch: Throwable -> L59
    L53:
        if (r116.hasNext() == false) goto L61;
        Object r117 = r116.next();     // Catch: Throwable -> L59
        WidgetCacheLimit r118 = (WidgetCacheLimit) r117;     // Catch: Throwable -> L59
        if (Intrinsics.areEqual(r118.getPackageName(), r113) == false) goto L53;
        if (Intrinsics.areEqual(r118.getWidgetId(), r114) == false) goto L53;
    L62:
        WidgetCacheLimit r119 = (WidgetCacheLimit) r117;     // Catch: Throwable -> L59
        if (r119 == null) goto L65;
        int r29 = r119.getInstanceLimit() - 3;     // Catch: Throwable -> L59
    L66:
        if (r29 < 0) goto L104;
        if (r115 == null) goto L73;
        ArrayList r120 = new ArrayList(CollectionsKt.h(r115));     // Catch: Throwable -> L59
        Iterator r121 = r115.iterator();     // Catch: Throwable -> L59
    L71:
        if (r121.hasNext() == false) goto L74;
        r120.add(((WidgetCacheLimit) r121.next()).getPackageName());     // Catch: Throwable -> L59
    L74:
        Iterator<E> r122 = f3080k.iterator();     // Catch: Throwable -> L59
        int r123 = 0;
    L76:
        if (r122.hasNext() == false) goto L94;
        o r124 = (o) ((WeakReference) r122.next()).get();     // Catch: Throwable -> L59
        if (r124 == null) goto L76;
        k r30 = new k(r120, r114, r5);     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r30, "filterCallback");     // Catch: Throwable -> L59
        Set r31 = r124.e.keySet();     // Catch: Throwable -> L59
        if ((r31 instanceof Collection) == true) goto L82;
    L84:
        Iterator r32 = r31.iterator();     // Catch: Throwable -> L59
        int r125 = 0;
    L86:
        if (r32.hasNext() == false) goto L93;
        Iterator r126 = r32;
        com.bytedance.ai.widget.contianer.f r35 = (com.bytedance.ai.widget.contianer.f) r32.next();     // Catch: Throwable -> L59
        Intrinsics.checkNotNull(r35);     // Catch: Throwable -> L59
        if (((Boolean) r30.invoke(r35)).booleanValue() == false) goto L92;
        r125 = r125 + 1;     // Catch: Throwable -> L59
        if (r125 >= 0) goto L92;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L59
    L92:
        r32 = r126;
    L93:
        r123 = r123 + r125;     // Catch: Throwable -> L59
        r5 = 0;
        goto L76
    L82:
        if (r31.isEmpty() == false) goto L84;
        r125 = 0;
        goto L93
    L94:
        String r36 = "removeGlobalCacheIfLimit cacheLimit=" + r29 + " count=" + r123 + " cacheLimitLis=" + r115;     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");     // Catch: Throwable -> L59
        t0.d r127 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L59
        if (r127 == null) goto L97;
        r127.i("WidgetManager", r36);     // Catch: Throwable -> L59
    L97:
        Iterator<E> r37 = f3080k.iterator();     // Catch: Throwable -> L59
    L98:
        if (r37.hasNext() == false) goto L104;
        o r38 = (o) ((WeakReference) r37.next()).get();     // Catch: Throwable -> L59
        if (r38 == null) goto L98;
        k r128 = new k(r120, r114, 1);     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r128, "filterCallback");     // Catch: Throwable -> L59
        r123 = r38.a(r38.d, r128, r38.a(r38.f3083c, r128, r123, r29), r29);     // Catch: Throwable -> L59
        goto L98
    L73:
        r120 = null;
    L104:
        monitor-exit(r28);
        Trace.beginSection("createWidgetContainer");
        String r39 = r33.d;
        if (r39 != null) goto L108;
        Lazy r40 = com.bytedance.ai.model.p.f2292a;
        r39 = com.bytedance.ai.model.p.h(r33.f22706b);
    L108:
        String r210 = r39;
        AppletWidgetContainer r41 = new AppletWidgetContainer(r17);
        Job r42 = (Job) r10.getContext().get(Job.Key);
        if (r42 == null) goto L111;
        r42.invokeOnCompletion(new j(r41, 0));
    L111:
        WidgetRenderService$createWidget$context$1 r43 = r33.g;
        Intrinsics.checkNotNullParameter(r43, "widgetLifeObserver");
        r41.d.add(r43);
        StringBuilder r44 = new StringBuilder("createWidgetContainer widget=");
        r44.append(r41);
        r44.append(" widgetData=");
        WidgetInfo r45 = r33.e;
        if (r45 == null) goto L114;
        String r46 = r45.getWidgetData();
    L115:
        String r47 = androidx.room.jarjarred.org.antlr.runtime.a.v(r44, r46, "WidgetManager", "tag");
        t0.d r48 = com.bytedance.ai.utils.c.f2846a;
        if (r48 == null) goto L118;
        r48.d("WidgetManager", r47);
    L118:
        r41.f3018a = r33.f22706b;
        Lazy r49 = com.bytedance.ai.model.p.f2292a;
        r41.i(WidgetContainer.LifecycleEvent.f3032a);
        new WeakReference(this.g);
        com.bytedance.ai.widget.contianer.h r50 = new com.bytedance.ai.widget.contianer.h(r23.getAppletId(), r23.getWidgetId(), r23.getWidgetData(), r210, r33.f22705a, r33.f22707c, r33.f22708h, r33.f22709i, r23.getMixtureCardId(), r33.f22706b, r33.f22710j, r23.getMcpName(), r23.getFullScreenRefresh(), r33.f22711k, 65536);
        r10.f2922a = r41;
        r10.d = 1;
        if (r41.r(r50, r10) != r13) goto L121;
        return r13;
    L121:
        r15 = r41;
        goto L122
    L114:
        r46 = null;
        goto L115
    L61:
        r117 = null;
    L65:
        r29 = -1;
    L59:
        th = move-exception;
        throw th;
    L42:
        r27 = null;
        goto L43
    L29:
        r21 = null;
    L18:
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r51 = com.bytedance.ai.utils.c.f2846a;
        if (r51 == null) goto L21;
        r51.w("WidgetManager", "createWidgetContainer: parent is null");
    L21:
        t0.b r52 = com.bytedance.ai.model.p.f2294c;
        if (r52 == null) goto L131;
        r17 = r52.currentActivity();
        if (r17 != null) goto L26;
    L131:
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r53 = com.bytedance.ai.utils.c.f2846a;
        if (r53 == null) goto L134;
        r53.e("WidgetManager", "createWidgetContainer: currentActivity is null");
    L134:
        return null;
    L7:
        r10 = new WidgetManager$createWidgetContainer$1(this, r34);
        goto L8
    }

    public final void h(w2.r r5, com.bytedance.ai.widget.contianer.f r10, LinearLayout r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (r5.f == null) goto L31;
        String r12 = "attachView msg=" + r5.a() + " view=" + r11 + " widgetContainer=" + r10;
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L11;
        r13.d("WidgetManager", r12);
    L11:
        if (r11.getParent() == null) goto L16;
        String r14 = "attachView view already has parent, remove it " + r11.getParent();
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L15;
        r15.w("WidgetManager", r14);
    L15:
        com.bytedance.ies.bullet.pool.util.a.b(r11);
    L16:
        RelativeLayout.LayoutParams r16 = new RelativeLayout.LayoutParams(-1, -2);
        WidgetInfo r17 = r5.e;
        int r18 = 0;
        if (r17 == null) goto L19;
        boolean r19 = Intrinsics.areEqual(r17.getBorder(), Boolean.TRUE);
    L20:
        if (r19 == false) goto L25;
        w2.q r20 = this.f3081a;
        if (r20 == null) goto L24;
        r18 = r20.f22702a;
    L24:
        r16.setMargins(r18, r18, r18, r18);
    L25:
        Unit r21 = Unit.INSTANCE;
        r5.f.addView(r11, r16);
        if (r10 == null) goto L29;
        r10.b(this.f3081a);
        return;
    L29:
        return;
    L19:
        r19 = false;
        goto L20
    }

    public final void i() {
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.i("WidgetManager", "onHostDestroy");
    L5:
        Iterator r10 = this.f3082b.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry r11 = (Map.Entry) r10.next();
        ((WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r11.getValue())).k();
        ((AppletWidgetContainer) ((com.bytedance.ai.widget.contianer.f) r11.getValue())).u();
        goto L7
    L9:
        this.f3082b.clear();
        Iterator r12 = this.d.entrySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        Map.Entry r13 = (Map.Entry) r12.next();
        ((WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r13.getValue())).k();
        ((AppletWidgetContainer) ((com.bytedance.ai.widget.contianer.f) r13.getValue())).u();
        goto L11
    L13:
        this.d.clear();
        Iterator<Map.Entry<String, com.bytedance.ai.widget.contianer.f>> r14 = this.f3083c.entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        Map.Entry<String, com.bytedance.ai.widget.contianer.f> r15 = r14.next();
        ((WidgetContainer) r15.getValue()).k();
        ((AppletWidgetContainer) r15.getValue()).u();
        goto L15
    L17:
        this.f3083c.clear();
        Iterator r16 = this.f3084h.entrySet().iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        Map.Entry r17 = (Map.Entry) r16.next();
        ((WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r17.getValue())).k();
        ((AppletWidgetContainer) ((com.bytedance.ai.widget.contianer.f) r17.getValue())).u();
        goto L19
    L21:
        this.f3084h.clear();
        this.e.clear();
        com.bytedance.ai.resource.j r18 = com.bytedance.ai.resource.j.f2734a;
        n r19 = this.f3085i;
        Intrinsics.checkNotNullParameter(r19, "listener");
        com.bytedance.ai.resource.j.f2735b.remove(r19);
        l r20 = f3079j;
        monitor-enter(r20);
        CollectionsKt.removeAll(f3080k, new h(this, 3));     // Catch: Throwable -> L34
        monitor-exit(r20);
        this.g.getClass();
        boolean r21 = com.bytedance.ai.widget.cache.a.f2980a;
        Intrinsics.checkNotNullParameter("FixedWidgetCachePool", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L28;
        r22.d("FixedWidgetCachePool", "clear: ");
    L28:
        Iterator r23 = com.bytedance.ai.widget.cache.a.f2981b.values().iterator();
    L30:
        if (r23.hasNext() == false) goto L32;
        ((Widget) r23.next()).h();
        goto L30
    L32:
        com.bytedance.ai.widget.cache.a.f2981b.clear();
        com.bytedance.ai.widget.cache.a.f2982c.clear();
        com.bytedance.ai.widget.cache.a.d.clear();
        return;
    L34:
        th = move-exception;
        throw th;
    }
}
