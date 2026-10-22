package com.bytedance.ai.lynx;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$Gravity;
import com.bytedance.ai.debug.IAISDKDebugService$d;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.d0;
import com.ivy.ivykit.api.bridge.IIvyLynxBridgeService;
import com.ivy.ivykit.api.plugin.IIvyHybridMonitorService;
import com.ivy.ivykit.api.plugin.IIvyLynxBehaviorService;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.navigator.NavigationModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletLynxViewApi {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public AppletLynxViewApi() {
    }

    public static void c(LynxViewBuilder r10, Context r11, float r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "context");
        if (r12 != 1.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L22;
        com.bytedance.ai.utils.l r13 = com.bytedance.ai.utils.l.a;
        Intrinsics.checkNotNullParameter(r11, "context");
        if ((r11 instanceof Activity) == false) goto L10;
        WindowManager r14 = ((Activity) r11).getWindowManager();
    L11:
        if (r14 == null) goto L13;
        Display r15 = r14.getDefaultDisplay();
    L14:
        if (r15 == null) goto L23;
        Point r0 = new Point();     // Catch: Exception -> L17
        r15.getSize(r0);     // Catch: Exception -> L17
        r10.setScreenSize((int) (r0.x * r12), (int) (r0.y * r12));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AppletLynxView", "setViewZoom error: " + e);
        Unit r16 = Unit.INSTANCE;
        return;
    L23:
        return;
    L13:
        r15 = null;
        goto L14
    L10:
        Object r17 = r11.getSystemService("window");
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.view.WindowManager");
        r14 = (WindowManager) r17;
        goto L11
    L22:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static Object b(String r10, String r11, boolean r12, String r13, String r14, Continuation r15) {
        return BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AppletLynxViewApi$getTemplateBundle$2(r10, r11, r12, r13, r14, null), r15);
    }

    public static g a(Context r10, String r11, String r12, final String r13, LynxViewBuilder r14, Function0 r15, Function1 r16, int r17) {
        if ((r17 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r17 & 8) == 0) goto L9;
        r13 = null;
    L9:
        if ((r17 & 16) == 0) goto L12;
        r14 = null;
    L12:
        if ((r17 & 32) == 0) goto L15;
        r15 = i.a;
    L15:
        if ((r17 & 64) == 0) goto L17;
        r16 = null;
    L17:
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r15, "parentContainerContextProvider");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.b), null, null, new AppletLynxViewApi$createLynxView$2(r11, null), 3, null);
        boolean r18 = true;
        if (r14 != null) goto L20;
        LynxViewBuilder r19 = LynxView.builder();
        LynxGroup.a r0 = new LynxGroup.a();
        r0.d = true;
        r14 = r19.setLynxGroup(new LynxGroup(r0));
    L20:
        final LynxViewBuilder r20 = r14;
        r20.registerModule(NavigationModule.NAME, NavigationModule.class, null);
        IAISDKDebugService$d r110 = IAISDKDebugService.a.f(new h(r20));
        IIvyHybridMonitorService.Companion r1 = IIvyHybridMonitorService.a;
        Intrinsics.checkNotNull(r20);
        com.ivy.ivykit.api.plugin.b r21 = r1.c(r20);
        List r22 = new XElementBehavior().create();
        List r23 = IIvyLynxBehaviorService.a.a();
        ArrayList r24 = new ArrayList();
        Iterator r25 = r23.iterator();
    L22:
        if (r25.hasNext() == false) goto L26;
        Object r26 = r25.next();
        if ((r26 instanceof com.lynx.tasm.behavior.a) == false) goto L22;
        r24.add(r26);
        goto L22
    L26:
        r22.addAll(r24);
        r22.addAll(AISDKLynxBehaviorRegistry.getExtraBehaviors());
        r22.add(new j());
        r22.add(new AppletLynxViewApi$createLynxView$4(r13));
        r22.add(new m(r15));
        r20.addBehaviors(r22);
        r20.setEnableMTSModule(true);
        r20.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);
        r20.setTemplateResourceFetcher(new p(r10, r12, r13));
        r20.setResourceProvider("EXTERNAL_JS_SOURCE", new e(r12, r13));
        if (r16 == null) goto L29;
        r16.invoke(r20);
    L29:
        String r111 = UUID.randomUUID().toString();
        com.ivy.ivykit.api.bridge.g r112 = IIvyLynxBridgeService.a.a(r10, r111, r11, r20);
        j8a.a r113 = new g(r10, r111, r11, r20, r13);
        if (r21 == null) goto L32;
        r21.a(r113, r111);
    L32:
        com.ivy.ivykit.api.plugin.b r27 = r113.f;
        if (r27 == null) goto L35;
        r27.release();
    L35:
        r113.f = r21;
        com.ivy.ivykit.api.bridge.g r28 = r113.e;
        if (r28 == null) goto L38;
        r28.release();
    L38:
        r113.e = r112;
        if (r112 == null) goto L41;
        r112.a(r113);
    L41:
        IAISDKDebugService.Companion r29 = IAISDKDebugService.a;
        r29.D(r113.g);
        r113.g = r110;
        r29.i(r110, r113, null);
        if (r13 != null) goto L44;
    L47:
        boolean r30 = true;
    L48:
        if (r30 == true) goto L50;
        r29.E(r113, r13, IAISDKDebugService$Gravity.BOTTOM_LEFT, null, null);
    L50:
        if (r13 != null) goto L52;
    L55:
        boolean r31 = true;
    L56:
        if (r31 == true) goto L65;
        AIManager r32 = AIManager.a;
        d0 r33 = AIManager.m(r13);
        if (r33 == null) goto L65;
        Applet r34 = r33.g(r13);
        if (r34 == null) goto L65;
        if (r34.E != 1) goto L65;
    L66:
        com.bytedance.ai.resource.security.e.a.getClass();
        com.bytedance.ai.resource.security.e.d(r113, r18, r13, null);
        return r113;
    L65:
        r18 = false;
        goto L66
    L52:
        if (r13.length() == 0) goto L55;
        r31 = false;
        goto L56
    L44:
        if (StringsKt.isBlank(r13) == true) goto L47;
        r30 = false;
        goto L48
    }
}
