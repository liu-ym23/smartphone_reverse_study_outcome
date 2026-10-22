package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.monitor.timeline.OpenFrom;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import d3.a0;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J*\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\\\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00050\u0018H\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenPageMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageResultModel;", "getTraceSettings", "Lkotlin/Triple;", "", "", "getAppletRuntime", "appletId", "botId", "conversationId", "traceInfo", "", "", "Lkotlin/Function1;", "Lcom/bytedance/ai/model/AppletRuntime;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPageMethod extends AbsOpenPageMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public OpenPageMethod() {
    }

    /* JADX WARN: Type inference failed for: r13v3, types: [com.bytedance.ai.bridge.method.router.j] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r35, ParamModel r36, final f3.h r37) {
        final AbsOpenPageMethodIDL.a r10 = (AbsOpenPageMethodIDL.a) r36;
        Intrinsics.checkNotNullParameter(r35, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r37, "callback");
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("OpenPageMethod", "handle pageId=" + r10.getPageId() + " context=" + r10.getContext());
        r0.i("OpenPageMethod", "handle pageId=" + r10.getPageId() + " pageData=" + r10.getPageData());
        if (Intrinsics.areEqual(r10.getMode(), "full") == false) goto L5;
    L7:
        a0 r1 = r35.getContainerContext();
        if (r1 == null) goto L10;
        ContainerType r11 = r1.getContainerType();
    L12:
        if (r11 != ContainerType.WIDGET) goto L20;
        WidgetContainer r12 = (WidgetContainer) r35.d(WidgetContainer.class);
        if (r12 == null) goto L19;
        String r13 = r12.getAppletId();
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        Pair r14 = new Pair(r13, OpenFrom.APPLET_VIEW_OPEN.getFrom());
    L30:
        String r15 = (String) r14.getFirst();
        String r16 = (String) r14.getSecond();
        i1 r17 = y0.a;
        Triple r18 = new Triple(y0.a("jsb", r15, r10.getPageId()), r16, Boolean.TRUE);
    L31:
        final String r19 = (String) r18.getFirst();
        String r20 = (String) r18.getSecond();
        final boolean r110 = ((Boolean) r18.getThird()).booleanValue();
        if (r110 == false) goto L34;
        i1 r111 = y0.a;
        y0.e(r19, r10.getPageId(), r10.getMode(), r20);
        LinkedHashMap r21 = new LinkedHashMap();
        r21.put("trace_id", r19);
        r21.put("eventName", "applet_page_timeline_full");
        LinkedHashMap r112 = r21;
    L35:
        JsonElement r22 = r10.getContext().get("botId");
        if (r22 == null) goto L39;
        String r23 = r22.getAsString();
        if (r23 == null) goto L39;
    L40:
        JsonElement r113 = r10.getContext().get("conversationId");
        if (r113 == null) goto L46;
        String r114 = r113.getAsString();
        if (r114 == null) goto L46;
        String r32 = r114;
    L47:
        a0 r115 = r35.getContainerContext();
        if (r115 == null) goto L50;
        ContainerType r116 = r115.getContainerType();
    L51:
        ContainerType r117 = ContainerType.PAGE;
        if (r116 != r117) goto L58;
        k2.j r118 = (k2.j) r35.d(k2.j.class);
        if (r118 == null) goto L58;
        k2.t r119 = r118.getFloatingSpeakerController();
        if (r119 == null) goto L58;
        r23 = r119.getBotId();
    L58:
        String r33 = r23;
        String r24 = r10.getMode();
        int r120 = r24.hashCode();
        double r121 = 0.5d;
        if (r120 == 3154575) goto L89;
        if (r120 == 106852524) goto L85;
        if (r120 == 2010122246) goto L66;
    L91:
        PageType r25 = PageType.FULL_PAGE;
    L92:
        PageType r122 = r25;
        double r26 = 0.5d;
        boolean r27 = false;
    L93:
        a0 r28 = r35.getContainerContext();
        if (r28 == null) goto L96;
        ContainerType r29 = r28.getContainerType();
    L97:
        ContainerType r30 = ContainerType.WIDGET;
        if (r29 != r30) goto L109;
        WidgetContainer r31 = (WidgetContainer) r35.d(WidgetContainer.class);
        if (r31 == null) goto L119;
        String r34 = r31.l();
        com.bytedance.ai.widget.contianer.m r38 = r31.g;
        if (r38 == null) goto L104;
        String r123 = r38.o;
    L105:
        if (r38 == null) goto L107;
        String r39 = r38.p;
    L108:
        String r210 = r39;
        String r211 = r34;
        String r212 = r123;
    L121:
        String r124 = r10.getPageId();
        String r125 = r10.getPageData();
        JavaOnlyMap r126 = ConvertUtils.toJavaOnlyMap(r10.getContext());
        JsonObject r40 = r10.getPageSettings();
        if (r40 == null) goto L126;
        JsonObject r41 = r40.getAsJsonObject();
        if (r41 == null) goto L126;
        ReadableMap r213 = ConvertUtils.toJavaOnlyMap(r41);
    L127:
        JsonElement r42 = r10.getContext().get("replyFor");
        if (r42 == null) goto L131;
        String r43 = r42.getAsString();
        if (r43 == null) goto L131;
    L134:
        String r214 = r43;
    L136:
        final PageInfo r44 = new PageInfo(r124, r125, r126, null, r122, r33, null, r213, r211, r26, r27, r214, r112, null, r212, r210, 8256, null);
        if (r110 == false) goto L139;
        i1 r45 = y0.a;
        y0.m(r19, "applet_page_timeline_full");
    L139:
        String r127 = r10.getAppletId();
        final ?? r128 = new j(r37, r44, r110, r19, r35, r10);
        if (com.bytedance.ai.utils.f.g(r127) == false) goto L142;
        String r46 = r127;
    L146:
        a0 r47 = r35.getContainerContext();
        if (r47 == null) goto L149;
        ContainerType r48 = r47.getContainerType();
    L150:
        if (r48 != r30) goto L167;
        WidgetContainer r49 = (WidgetContainer) r35.d(WidgetContainer.class);
        if (r49 == null) goto L183;
        AppletRuntimeManager r129 = AppletRuntimeManager.INSTANCE;
        if (r46 != null) goto L158;
        r46 = r49.getAppletId();
        if (r46 != null) goto L158;
        r46 = "";
    L158:
        String r50 = r49.b;
        if (r50 != null) goto L161;
        String r130 = "";
    L162:
        String r51 = r49.getBotId();
        if (r51 != null) goto L165;
        String r131 = "";
    L166:
        AppletRuntimeManager.o(r129, r46, r130, r131, null, null, r112, new k(r128), 24);
        return;
    L165:
        r131 = r51;
        goto L166
    L161:
        r130 = r50;
        goto L162
    L183:
        return;
    L167:
        a0 r52 = r35.getContainerContext();
        if (r52 == null) goto L170;
        String r53 = r52.getAppletId();
    L172:
        if (Intrinsics.areEqual(r46, r53) == false) goto L175;
        r128.invoke(r35.d(AppletRuntime.class));
        return;
    L175:
        if (com.bytedance.ai.utils.f.g(r46) == true) goto L177;
    L181:
        r128.invoke(null);
        return;
    L177:
        if (com.bytedance.ai.utils.f.g(r33) == false) goto L181;
        if (com.bytedance.ai.utils.f.g(r32) == false) goto L181;
        AppletRuntimeManager r132 = AppletRuntimeManager.INSTANCE;
        Intrinsics.checkNotNull(r46);
        Intrinsics.checkNotNull(r32);
        Intrinsics.checkNotNull(r33);
        AppletRuntimeManager.o(r132, r46, r32, r33, null, null, r112, new l(r128), 24);
        return;
    L170:
        r53 = null;
        goto L172
    L149:
        r48 = null;
        goto L150
    L142:
        a0 r54 = r35.getContainerContext();
        if (r54 == null) goto L145;
        r46 = r54.getAppletId();
        goto L146
    L145:
        r46 = null;
    L131:
        JsonElement r55 = r10.getContext().get("questionId");
        if (r55 == null) goto L135;
        r43 = r55.getAsString();
        goto L134
    L135:
        r214 = null;
    L126:
        r213 = null;
        goto L127
    L107:
        r39 = null;
        goto L108
    L104:
        r123 = null;
    L119:
        String r56 = null;
    L120:
        r211 = r56;
        r212 = null;
        r210 = null;
        goto L121
    L109:
        a0 r57 = r35.getContainerContext();
        if (r57 == null) goto L112;
        ContainerType r58 = r57.getContainerType();
    L113:
        if (r58 != r117) goto L119;
        k2.j r59 = (k2.j) r35.d(k2.j.class);
        if (r59 == null) goto L119;
        PageInfo r60 = r59.getPageInfo();
        if (r60 == null) goto L119;
        r56 = r60.getMessageId();
        goto L120
    L112:
        r58 = null;
        goto L113
    L96:
        r29 = null;
        goto L97
    L66:
        if (r24.equals("floating") == false) goto L91;
        JsonObject r61 = r10.getPageSettings();
        if (r61 == null) goto L77;
        JsonElement r62 = r61.get("pos");
        if (r62 == null) goto L77;
        String r63 = r62.getAsString();
        if (r63 == null) goto L77;
        Double r64 = StringsKt.toDoubleOrNull(r63);
        if (r64 == null) goto L77;
        r121 = r64.doubleValue();
    L77:
        double r65 = RangesKt.coerceIn(r121, 0.0d, 1.0d);
        JsonObject r66 = r10.getPageSettings();
        if (r66 == null) goto L82;
        JsonElement r67 = r66.get("align");
        if (r67 == null) goto L82;
        String r68 = r67.getAsString();
    L83:
        r26 = r65;
        r27 = Intrinsics.areEqual(r68, "left");
        r122 = PageType.FLOATING_VIEW;
    L82:
        r68 = null;
        goto L83
    L85:
        if (r24.equals(com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L91;
        r25 = PageType.POPUP_PAGE;
        goto L92
    L89:
        if (r24.equals("full") == false) goto L91;
        r25 = PageType.FULL_PAGE;
        goto L92
    L50:
        r116 = null;
    L46:
        r32 = "";
    L39:
        r23 = "";
        goto L40
    L34:
        r112 = null;
        goto L35
    L19:
        r14 = new Pair("", OpenFrom.APPLET_VIEW_OPEN.getFrom());
        goto L30
    L20:
        AppletRuntime r69 = (AppletRuntime) r35.d(AppletRuntime.class);
        if (r69 == null) goto L25;
        Applet r70 = r69.h;
        if (r70 == null) goto L25;
        String r71 = r70.o();
    L27:
        if (r71 != null) goto L29;
        r71 = "";
    L29:
        r14 = new Pair(r71, OpenFrom.APPLET_MAIN_OPEN.getFrom());
    L25:
        r71 = null;
        goto L27
    L10:
        r11 = null;
        goto L12
    L5:
        if (Intrinsics.areEqual(r10.getMode(), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == true) goto L7;
        r18 = new Triple("", "", Boolean.FALSE);
        goto L31
    }
}
