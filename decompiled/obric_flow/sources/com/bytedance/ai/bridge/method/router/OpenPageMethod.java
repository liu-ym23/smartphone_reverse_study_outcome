package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.p;
import com.bytedance.ai.monitor.timeline.OpenFrom;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJc\u0010\u0017\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenPageMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageParamModel;", LynxResourceModule.PARAMS_KEY, "Lkotlin/Triple;", "", "", "getTraceSettings", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageParamModel;)Lkotlin/Triple;", "appletId", "botId", "conversationId", "", "", "traceInfo", "Lkotlin/Function1;", "Lcom/bytedance/ai/model/AppletRuntime;", "", "callback", "getAppletRuntime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ln1/c;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "Lo1/f;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageResultModel;", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageParamModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/router/j", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenPageMethod extends AbsOpenPageMethodIDL {
    public static final String ALIGN_LEFT = "left";
    public static final String APP_FLOATING = "floating";
    public static final String APP_FULL = "full";
    public static final String APP_POPUP = "popup";
    public static final double CENTER_POS = 0.5d;
    public static final j Companion = null;
    public static final String KEY_ALIGN = "align";
    public static final String KEY_POS = "pos";
    public static final String TAG = "OpenPageMethod";

    static {
        Companion = new j();
    }

    public OpenPageMethod() {
    }

    public static /* synthetic */ Unit b(o1.f r5, PageInfo r10, boolean r11, String r12, n1.c r13, AbsOpenPageMethodIDL.OpenPageParamModel r14, AppletRuntime r15) {
        return handle$lambda$4(r5, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit c(Function1 r5, AppletRuntime r10) {
        return getAppletRuntime$lambda$8(r5, r10);
    }

    public static /* synthetic */ Unit d(Function1 r5, AppletRuntime r10) {
        return getAppletRuntime$lambda$7$lambda$6(r5, r10);
    }

    private final void getAppletRuntime(String r13, String r14, String r15, n1.c r16, Map<String, Object> r17, Function1<? super AppletRuntime, Unit> r18) {
        String r5 = null;
        if (com.bytedance.ai.utils.c.l(r13) == false) goto L5;
        String r10 = r13;
    L9:
        n1.a r11 = (n1.a) r16;
        m1.j r12 = (m1.j) r11.b(m1.j.class);
        if (r12 == null) goto L12;
        ContainerType r19 = r12.d();
    L14:
        if (r19 != ContainerType.f1800b) goto L35;
        WidgetContainer r20 = (WidgetContainer) r11.b(WidgetContainer.class);
        if (r20 == null) goto L53;
        Lazy r21 = p.f2292a;
        if (r10 != null) goto L22;
        r10 = r20.getAppletId();
        if (r10 != null) goto L22;
        String r22 = "";
    L23:
        String r23 = r20.f3018a;
        if (r23 != null) goto L26;
        String r24 = "";
    L27:
        com.bytedance.ai.widget.contianer.h r25 = r20.f;
        if (r25 == null) goto L30;
        r5 = r25.d;
    L30:
        if (r5 != null) goto L32;
        String r26 = "";
    L33:
        p.e(r22, r24, r26, null, r17, new h(0, r18), 24);
        return;
    L32:
        r26 = r5;
        goto L33
    L26:
        r24 = r23;
    L22:
        r22 = r10;
        goto L23
    L53:
        return;
    L35:
        m1.j r27 = (m1.j) r11.b(m1.j.class);
        if (r27 == null) goto L38;
        String r28 = r27.b();
    L40:
        if (Intrinsics.areEqual(r10, r28) == false) goto L44;
        r18.invoke(r11.b(AppletRuntime.class));
        return;
    L44:
        if (com.bytedance.ai.utils.c.l(r10) == true) goto L46;
    L51:
        r18.invoke(null);
        return;
    L46:
        if (com.bytedance.ai.utils.c.l(r14) == false) goto L51;
        if (com.bytedance.ai.utils.c.l(r15) == false) goto L51;
        Lazy r29 = p.f2292a;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r15);
        Intrinsics.checkNotNull(r14);
        p.e(r10, r15, r14, null, r17, new h(1, r18), 24);
        return;
    L38:
        r28 = null;
        goto L40
    L12:
        r19 = null;
        goto L14
    L5:
        m1.j r30 = (m1.j) ((n1.a) r16).b(m1.j.class);
        if (r30 == null) goto L8;
        r10 = r30.b();
        goto L9
    L8:
        r10 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getAppletRuntime$default(OpenPageMethod r10, String r11, String r12, String r13, n1.c r14, Map r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        r15 = null;
    L5:
        r10.getAppletRuntime(r11, r12, r13, r14, r15, r16);
    }

    private static final Unit getAppletRuntime$lambda$7$lambda$6(Function1 r5, AppletRuntime r10) {
        r5.invoke(r10);
        return Unit.INSTANCE;
    }

    private static final Unit getAppletRuntime$lambda$8(Function1 r5, AppletRuntime r10) {
        r5.invoke(r10);
        return Unit.INSTANCE;
    }

    private final Triple<String, String, Boolean> getTraceSettings(n1.c r5, AbsOpenPageMethodIDL.OpenPageParamModel r10) {
        String r11 = "";
        if (Intrinsics.areEqual(r10.getMode(), APP_FULL) == false) goto L5;
    L8:
        n1.a r12 = (n1.a) r5;
        m1.j r13 = (m1.j) r12.b(m1.j.class);
        String r14 = null;
        if (r13 == null) goto L11;
        ContainerType r15 = r13.d();
    L13:
        if (r15 != ContainerType.f1800b) goto L22;
        WidgetContainer r16 = (WidgetContainer) r12.b(WidgetContainer.class);
        if (r16 == null) goto L21;
        String r17 = r16.getAppletId();
        if (r17 == null) goto L20;
        r11 = r17;
    L20:
        OpenFrom[] r18 = OpenFrom.f2394a;
        Pair r19 = new Pair(r11, "applet_view_open");
    L32:
        String r20 = (String) r19.getFirst();
        String r21 = (String) r19.getSecond();
        b3.p r22 = b3.h.f841a;
        String r23 = r10.getPageId();
        Intrinsics.checkNotNullParameter("jsb", "prefix");
        Intrinsics.checkNotNullParameter(r20, "appletId");
        Intrinsics.checkNotNullParameter(r23, "pageId");
        return new Triple("jsb_" + r20 + '_' + r23 + '_' + UUID.randomUUID(), r21, Boolean.TRUE);
    L21:
        OpenFrom[] r24 = OpenFrom.f2394a;
        r19 = new Pair("", "applet_view_open");
        goto L32
    L22:
        AppletRuntime r25 = (AppletRuntime) r12.b(AppletRuntime.class);
        if (r25 == null) goto L28;
        Applet r26 = r25.f2197h;
        if (r26 == null) goto L28;
        r14 = r26.i();
    L28:
        if (r14 == null) goto L31;
        r11 = r14;
    L31:
        OpenFrom[] r27 = OpenFrom.f2394a;
        r19 = new Pair(r11, "applet_main_open");
        goto L32
    L11:
        r15 = null;
        goto L13
    L5:
        if (Intrinsics.areEqual(r10.getMode(), APP_POPUP) == true) goto L8;
        return new Triple("", "", Boolean.FALSE);
    }

    private static final Unit handle$lambda$4(o1.f r10, PageInfo r11, boolean r12, String r13, n1.c r14, AbsOpenPageMethodIDL.OpenPageParamModel r15, AppletRuntime r16) {
        if (r16 != null) goto L5;
        r10.a("can not find the applet runtime");
        return Unit.INSTANCE;
    L5:
        Applet r5 = r16.f2197h;
        r11.setPackageName(r5.f2259b);
        if (r12 == false) goto L18;
        b3.p r17 = b3.h.f841a;
        String r18 = r5.B;
        String r19 = "";
        if (r18 != null) goto L10;
        r18 = "";
    L10:
        Pair r20 = TuplesKt.to("applet_res_from", r18);
        String r21 = r16.s;
        if (r21 != null) goto L13;
        r21 = "";
    L13:
        Pair r22 = TuplesKt.to("main_js_res_from", r21);
        String r23 = r5.f2259b;
        if (r23 == null) goto L17;
        r19 = r23;
    L17:
        b3.h.e(r13, "applet_page_timeline_full", MapsKt.mapOf(new Pair[]{r20, r22, TuplesKt.to("packageId", r19)}));
    L18:
        z2.d.b("applet_jsb_open_page", new k(r14, r15, r16, r11));
        BuildersKt.launch$default(h0.a(t2.b.d), null, null, new OpenPageMethod$handle$3$2(r16, r11, r10, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsOpenPageMethodIDL.OpenPageParamModel) r10, r11);
    }

    public void handle(final n1.c r32, final AbsOpenPageMethodIDL.OpenPageParamModel r33, final o1.f r34) {
        Intrinsics.checkNotNullParameter(r32, "bridgeContext");
        Intrinsics.checkNotNullParameter(r33, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r34, "callback");
        String r5 = "handle pageId=" + r33.getPageId() + " context=" + r33.getContext();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.i(TAG, r5);
    L5:
        String r11 = "handle pageId=" + r33.getPageId() + " pageData=" + r33.getPageData();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L8;
        r12.i(TAG, r11);
    L8:
        Triple<String, String, Boolean> r13 = getTraceSettings(r32, r33);
        final String r14 = r13.getFirst();
        String r15 = r13.getSecond();
        final boolean r16 = r13.getThird().booleanValue();
        String r17 = null;
        if (r16 == false) goto L11;
        b3.p r18 = b3.h.f841a;
        b3.h.b(r14, r33.getPageId(), r33.getMode(), r15);
        Map<String, Object> r19 = new LinkedHashMap();
        r19.put("trace_id", r14);
        r19.put("eventName", "applet_page_timeline_full");
        Map<String, Object> r20 = r19;
    L12:
        JsonElement r21 = r33.getContext().get("botId");
        if (r21 == null) goto L18;
        String r22 = r21.getAsString();
        if (r22 == null) goto L18;
        String r29 = r22;
    L19:
        JsonElement r23 = r33.getContext().get("conversationId");
        if (r23 == null) goto L25;
        String r24 = r23.getAsString();
        if (r24 == null) goto L25;
        String r30 = r24;
    L26:
        n1.a r25 = (n1.a) r32;
        m1.j r110 = (m1.j) r25.b(m1.j.class);
        if (r110 == null) goto L29;
        ContainerType r111 = r110.d();
    L30:
        ContainerType r112 = ContainerType.f1801c;
        if (r111 != r112) goto L33;
        w0.f r113 = (w0.f) r25.b(w0.f.class);
    L33:
        String r114 = r33.getMode();
        int r115 = r114.hashCode();
        double r116 = 0.5d;
        if (r115 == 3154575) goto L65;
        if (r115 == 106852524) goto L60;
        if (r115 == 2010122246) goto L41;
    L67:
        PageType r117 = PageType.FULL_PAGE;
    L63:
        PageType r118 = r117;
        double r119 = 0.5d;
        boolean r26 = false;
    L68:
        m1.j r120 = (m1.j) r25.b(m1.j.class);
        if (r120 == null) goto L71;
        ContainerType r121 = r120.d();
    L73:
        if (r121 != ContainerType.f1800b) goto L87;
        WidgetContainer r27 = (WidgetContainer) r25.b(WidgetContainer.class);
        if (r27 == null) goto L97;
        com.bytedance.ai.widget.contianer.h r28 = r27.f;
        if (r28 == null) goto L79;
        String r31 = r28.e;
    L80:
        if (r28 == null) goto L82;
        String r122 = r28.f3054l;
    L83:
        if (r28 == null) goto L86;
        String r210 = r28.f3055m;
    L85:
        String r123 = r31;
        String r211 = r122;
    L98:
        String r124 = r33.getPageId();
        String r125 = r33.getPageData();
        JavaOnlyMap r126 = ConvertUtils.toJavaOnlyMap(r33.getContext());
        JsonObject r35 = r33.getPageSettings();
        if (r35 == null) goto L103;
        JsonObject r36 = r35.getAsJsonObject();
        if (r36 == null) goto L103;
        JavaOnlyMap r127 = ConvertUtils.toJavaOnlyMap(r36);
    L104:
        JsonElement r37 = r33.getContext().get("replyFor");
        if (r37 == null) goto L110;
        String r38 = r37.getAsString();
        if (r38 == null) goto L110;
        String r212 = r38;
    L114:
        final PageInfo r39 = new PageInfo(r124, r125, r126, null, r118, r29, null, r127, r123, r119, r26, r212, r20, null, r211, r210, 8256, null);
        if (r16 == false) goto L117;
        b3.h.h(r14, "applet_page_timeline_full");
    L117:
        getAppletRuntime(r33.getAppletId(), r29, r30, r32, r20, new i(r34, r39, r16, r14, r32, r33));
        return;
    L110:
        JsonElement r40 = r33.getContext().get("questionId");
        if (r40 == null) goto L113;
        r17 = r40.getAsString();
    L113:
        r212 = r17;
    L103:
        r127 = null;
        goto L104
    L86:
        r210 = null;
        goto L85
    L82:
        r122 = null;
        goto L83
    L79:
        r31 = null;
    L97:
        r123 = null;
        r211 = null;
        r210 = null;
        goto L98
    L87:
        m1.j r41 = (m1.j) r25.b(m1.j.class);
        if (r41 == null) goto L90;
        ContainerType r42 = r41.d();
    L91:
        if (r42 != r112) goto L97;
        w0.f r43 = (w0.f) r25.b(w0.f.class);
        if (r43 == null) goto L97;
        PageInfo r44 = ((com.bytedance.ai.model.widgets.a) r43).f2330b;
        if (r44 == null) goto L97;
        r211 = null;
        r210 = null;
        r123 = r44.getMessageId();
        goto L98
    L90:
        r42 = null;
        goto L91
    L71:
        r121 = null;
        goto L73
    L41:
        if (r114.equals(APP_FLOATING) == false) goto L67;
        JsonObject r128 = r33.getPageSettings();
        if (r128 == null) goto L52;
        JsonElement r129 = r128.get(KEY_POS);
        if (r129 == null) goto L52;
        String r130 = r129.getAsString();
        if (r130 == null) goto L52;
        Double r131 = StringsKt.toDoubleOrNull(r130);
        if (r131 == null) goto L52;
        r116 = r131.doubleValue();
    L52:
        double r132 = RangesKt.a(r116);
        JsonObject r133 = r33.getPageSettings();
        if (r133 == null) goto L57;
        JsonElement r134 = r133.get(KEY_ALIGN);
        if (r134 == null) goto L57;
        String r135 = r134.getAsString();
    L58:
        r26 = Intrinsics.areEqual(r135, ALIGN_LEFT);
        r119 = r132;
        r118 = PageType.FLOATING_VIEW;
    L57:
        r135 = null;
        goto L58
    L60:
        if (r114.equals(APP_POPUP) == false) goto L67;
        r117 = PageType.POPUP_PAGE;
        goto L63
    L65:
        if (r114.equals(APP_FULL) == false) goto L67;
        r117 = PageType.FULL_PAGE;
        goto L63
    L29:
        r111 = null;
    L25:
        r30 = "";
    L18:
        r29 = "";
        goto L19
    L11:
        r20 = null;
        goto L12
    }
}
