package com.bytedance.android.anniex.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.ability.XBridgeHelper;
import com.bytedance.android.anniex.optimize.UsageLynxOptimize;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.forest.Forest;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.navigator.NavigationModule;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "千万不要这样用")
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AnnieXLynxView b(Context r10, ra.a r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "lynxModel");
        int r0 = e.a;
        Uri r1 = r11.b;
        Intrinsics.checkNotNullParameter(r1, "uri");
        boolean r12 = r1.getBooleanQueryParameter("use_motion", false);
        com.bytedance.android.monitorV2.lynx.jsb.a r13 = new com.bytedance.android.monitorV2.lynx.jsb.a(0);
        ra.b r14 = r11.f;
        String r15 = r11.g;
        String r16 = r11.c;
        Forest r17 = r11.t;
        ra.b.a r18 = ra.b.B;
        LynxViewBuilder r19 = r14.d(r15, r16, r17);
        r19.registerModule(NavigationModule.NAME, NavigationModule.class, null);
        r19.registerModule("hybridMonitor", LynxViewMonitorModule.class, r13);
        LynxBDXBridge r20 = XBridgeHelper.a(r10, r11, r19);
        int r21 = UsageLynxOptimize.a;
        UsageLynxOptimize.a(r11.f, r19, r11.a);
        AnnieXLynxView r22 = new AnnieXLynxView(r10, r11.g, r11.c, r19);
        if (r12 == false) goto L7;
        Intrinsics.checkNotNullParameter(r22, "annieXLynxView");
        com.bytedance.ies.bullet.lynx.impl.f r23 = new com.bytedance.ies.bullet.lynx.impl.f();
        LynxKryptonHelper r24 = LynxKryptonUtils.getLynxKryptonHelper(r22);
        if (r24 == null) goto L7;
        r24.registerService(com.bytedance.ies.bullet.lynx.impl.f.class, r23);
    L7:
        r22.x(r20, r11);
        r22.setViewZoom(r11.f.x);
        String r25 = r11.f.d;
        if (r25 == null) goto L10;
        r22.setGroupName(r25);
    L10:
        r13.a = r22;
        return r22;
    }

    public static ra.a a(Uri r17, String r18, ra.b r19, String r20) {
        Intrinsics.checkNotNullParameter(r17, "templateUri");
        Intrinsics.checkNotNullParameter(r18, "bid");
        Intrinsics.checkNotNullParameter(r19, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        if (Intrinsics.areEqual(r17.getScheme(), "http") == false) goto L5;
    L22:
        String r0 = r17.toString();
    L23:
        if (r0 != null) goto L26;
        r0 = r17.toString();
    L26:
        return new ra.a(r0, r17, r18, null, null, r19, r20, null, null, false, true, null, null, null, 31640);
    L5:
        if (Intrinsics.areEqual(r17.getScheme(), "https") == true) goto L22;
        String r1 = null;
        r0 = UriProtector.getQueryParameter(r17, "a_surl");     // Catch: Throwable -> L10
    L11:
        if (r0 != null) goto L23;
        r0 = UriProtector.getQueryParameter(r17, "surl");     // Catch: Throwable -> L15
    L16:
        if (r0 != null) goto L23;
        r1 = UriProtector.getQueryParameter(r17, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L20
    L21:
        r0 = r1;
    L15:
        r0 = null;
    L10:
        r0 = null;
        goto L11
    }
}
