package com.bytedance.ai.applet.components.view;

import android.content.Context;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.applet.render.core.lynx.g;
import com.bytedance.ai.applet.render.core.lynx.i;
import com.bytedance.ai.applet.render.core.relax.RelaxRenderView$RenderMode;
import com.bytedance.ai.lynx.AISDKLynxBehaviorRegistry;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.models.OAppletWrap;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.l0;
import com.lynx.tasm.t;
import com.lynx.tasm.u;
import j1.e;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static i a(Context r10, q7.a r11, g r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "loader");
        u0.a r5 = s0.a.f21800c;
        if (r5 == null) goto L6;
        String r13 = r5.f22202m;
        if (r13 == null) goto L6;
    L7:
        if (r12 != null) goto L9;
        r12 = new g(r10);
    L9:
        Intrinsics.checkNotNullParameter(r13, "bid");
        r12.f16660b = r13;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        Intrinsics.checkNotNullParameter(r11, "loader");
        r12.e = r11;
        List<com.lynx.tasm.behavior.a> r14 = new XElementBehavior().create();
        Intrinsics.checkNotNullParameter(r14, "bundle");
        l0 r15 = r12.f1766c;
        r15.c(r14);
        List r16 = CollectionsKt.toList(com.ivy.ivykit.plugin.impl.render.c.f9523a.values());
        Intrinsics.checkNotNullParameter(r16, "bundle");
        r15.c(r16);
        List<com.lynx.tasm.behavior.a> r17 = AISDKLynxBehaviorRegistry.getExtraBehaviors();
        Intrinsics.checkNotNullParameter(r17, "bundle");
        r15.c(r17);
        b r18 = new b("animax-view", false, false, false, 0);
        Intrinsics.checkNotNullParameter(r18, "bundle");
        r15.f10899b.b(r18);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        a r19 = new a(0);
        Intrinsics.checkNotNullParameter(r19, "checker");
        r12.f = r19;
        i r20 = r12.a();
        com.bytedance.ai.lynx.i.c(r20.getLynxBDXBridge(), r20, r20.getViewUuid(), r13);
        return r20;
    L6:
        r13 = "";
        goto L7
    }

    public static g1.b b(Context r11, RenderType r12, Widget r13, com.bytedance.ai.widget.cache.b r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "widget");
        Intrinsics.checkNotNullParameter(r14, "loader");
        u0.a r5 = s0.a.f21800c;
        String r10 = "";
        if (r5 == null) goto L6;
        String r15 = r5.f22202m;
        if (r15 == null) goto L6;
    L7:
        RelaxRenderView$RenderMode r16 = null;
        BuildersKt.launch$default(h0.a(t2.b.f22090b), null, null, new RenderViewFactory$createWidgetRenderView$1(r15, null), 3, null);
        int r17 = r12.ordinal();
        if (r17 != 0) goto L10;
        Intrinsics.checkNotNullParameter(r11, "context");
        j1.a r18 = new j1.a(r11);
        u0.a r19 = s0.a.f21800c;
        if (r19 == null) goto L54;
        String r110 = r19.f22202m;
        if (r110 == null) goto L54;
        r10 = r110;
    L54:
        Intrinsics.checkNotNullParameter(r10, "bid");
        r18.f16660b = r10;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        String r111 = (String) r18.f16660b;
        if (r111 == null) goto L59;
        return new e(r11, r111);
    L59:
        throw new IllegalArgumentException("Bid is required");
    L10:
        if (r17 != 1) goto L12;
        StringBuilder r112 = new StringBuilder("createWidgetLynxRenderView, appletId:");
        r112.append(r13.f2259b);
        r112.append(", widgetId:");
        String r20 = r13.F;
        if (com.bytedance.ai.utils.c.l(r20) == true) goto L35;
        r20 = r13.f2258a;
    L35:
        r112.append(r20);
        r112.append(", runtimeVersion:");
        a1.a.f43a.i("RenderViewFactory", androidx.room.jarjarred.org.antlr.runtime.a.w(r112, r13.C, "RenderViewFactory", "tag", "msg"));
        r14.getClass();
        g r113 = new g(r11);
        boolean r21 = ym.a.e(r13.C);
        String r22 = r13.f2259b;
        l0 r23 = r113.f1766c;
        if (r21 == false) goto L38;
        String r24 = "createWidgetLynxRenderView: create lynx group, appletId=" + r22;
        Intrinsics.checkNotNullParameter("RenderViewFactory", "tag");
        Intrinsics.checkNotNullParameter(r24, "msg");
        a1.a.f43a.i("RenderViewFactory", r24);
        t r25 = new t();
        Intrinsics.checkNotNullParameter(r25, "<this>");
        u r26 = new u(r25);
        Intrinsics.checkNotNull(r26);
        Intrinsics.checkNotNullParameter(r26, "group");
        r23.f10900c.f10894c = r26;
    L38:
        Intrinsics.checkNotNullParameter(r113, "lynxBuild");
        ConversationWidgetData r27 = ((com.bytedance.ai.widget.cache.e) r14).f2988a;
        OAppletWrap r28 = r27.getOAppletWrap();
        if (r28 == null) goto L43;
        String r29 = r28.getGroupName();
        if (r29 == null) goto L43;
        t r30 = new t();
        r30.f10963c = r29;
        r30.d = r29;
        u r31 = new u(r30);
        Intrinsics.checkNotNullParameter(r31, "group");
        r23.f10900c.f10894c = r31;
    L43:
        OAppletWrap r32 = r27.getOAppletWrap();
        if (r32 == null) goto L47;
        r113.g = r32.getMonitorEnable();
    L47:
        return a(r11, new e1.b(r14, r13.f2276x, r22), r113);
    L12:
        if (r17 != 2) goto L30;
        Intrinsics.checkNotNullParameter(r11, "context");
        com.bytedance.ai.applet.render.core.relax.c r114 = new com.bytedance.ai.applet.render.core.relax.c(r11);
        r114.d = RelaxRenderView$RenderMode.f1783b;
        u0.a r115 = s0.a.f21800c;
        if (r115 == null) goto L19;
        String r116 = r115.f22202m;
        if (r116 == null) goto L19;
        r10 = r116;
    L19:
        Intrinsics.checkNotNullParameter(r10, "bid");
        r114.f16660b = r10;
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        String r117 = AISDKSettingConfigManager.INSTANCE.getRELAX_CONFIG().getValue().c();
        RelaxRenderView$RenderMode[] r118 = RelaxRenderView$RenderMode.values();
        int r33 = r118.length;
        int r34 = 0;
    L20:
        if (r34 >= r33) goto L25;
        RelaxRenderView$RenderMode r35 = r118[r34];
        if (Intrinsics.areEqual(r35.f1785a, r117) == true) goto L23;
        r34 = r34 + 1;
        goto L20
    L23:
        r16 = r35;
    L25:
        if (r16 != null) goto L27;
        r16 = RelaxRenderView$RenderMode.f1783b;
    L27:
        Intrinsics.checkNotNullParameter(r16, "mode");
        r114.d = r16;
        mn.i r119 = new mn.i(r14);
        Intrinsics.checkNotNullParameter(r119, "loader");
        r114.f1791c = r119;
        return r114.a();
    L30:
        throw new NoWhenBranchMatchedException();
    L6:
        r15 = "";
        goto L7
    }
}
