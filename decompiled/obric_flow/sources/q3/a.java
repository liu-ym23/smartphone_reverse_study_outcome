package q3;

import android.graphics.Point;
import android.net.Uri;
import android.view.Display;
import androidx.fragment.app.FragmentActivity;
import b4.c;
import b4.d;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.anniex.utils.e;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.ies.bullet.service.base.i;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.krypton.CanvasRuntimeMediator;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.l0;
import com.lynx.tasm.navigator.NavigationModule;
import com.obric.oui.constraintlayout.core.widgets.analyzer.f;
import h5.b;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static AnnieXLynxView a(FragmentActivity r17, c r18) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "lynxModel");
        TraceEvent.c("AnnieXApi:createLynxView");
        String r10 = r18.f861c;     // Catch: Throwable -> L40
        Uri r11 = r18.f860b;
        d r12 = r18.e;
        String r13 = r18.f;
        if (Intrinsics.areEqual(r10, "Loki") == false) goto L10;
        AnnieXLynxView r5 = e.a(r17, r18);     // Catch: Throwable -> L40
        String r14 = "AnnieXApi:createLynxView";
        long r15 = 0;
    L38:
        TraceEvent.a(r15, r14);
        return r5;
    L10:
        com.bytedance.android.anniex.monitor.c.y(r13);     // Catch: Throwable -> L40
        b r16 = new b();     // Catch: Throwable -> L40
        l0 r19 = r12.b(r13);     // Catch: Throwable -> L40
        TraceEvent.c("LynxViewBuilder:registerModule");     // Catch: Throwable -> L40
        r19.a(NavigationModule.class, null, NavigationModule.NAME);     // Catch: Throwable -> L40
        r19.a(LynxViewMonitorModule.class, r16, "hybridMonitor");     // Catch: Throwable -> L40
        com.bytedance.android.anniex.assemble.a.b(com.bytedance.android.anniex.utils.b.class, r10);     // Catch: Throwable -> L40
        TraceEvent.a(0, "LynxViewBuilder:registerModule");     // Catch: Throwable -> L40
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r20 = jm.c.c(r17, r18, r19);     // Catch: Throwable -> L42
        float r21 = r12.f882v;
        if (r21 != 1.0f) goto L15;
        String r110 = "AnnieXApi:createLynxView";
    L30:
        TraceEvent.a(0, "LynxViewBuilderParams:toLynxViewBuilder");     // Catch: Throwable -> L23
        TraceEvent.c("AnnieXLynxView:init");     // Catch: Throwable -> L23
        r5 = new AnnieXLynxView(r17, r13, r10, r19);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);     // Catch: Throwable -> L23
        if (r11.getBooleanQueryParameter("use_motion", false) == false) goto L33;
        com.bytedance.android.anniex.utils.c.a(r5);     // Catch: Throwable -> L23
    L33:
        r5.l(r20, r18);     // Catch: Throwable -> L23
        b(r17, r5);     // Catch: Throwable -> L23
        c(r10, r5, !r11.getBooleanQueryParameter("use_card_mode", true), r13);     // Catch: Throwable -> L23
        r16.f17282a = r5;     // Catch: Throwable -> L23
        r5.setViewZoom(r21);     // Catch: Throwable -> L23
        String r22 = r12.d;     // Catch: Throwable -> L23
        if (r22 == null) goto L36;
        r5.setGroupName(r22);     // Catch: Throwable -> L23
    L36:
        com.bytedance.android.anniex.assemble.a.b(com.bytedance.android.anniex.utils.b.class, r10);     // Catch: Throwable -> L23
        r15 = 0;
        TraceEvent.a(0, "AnnieXLynxView:init");     // Catch: Throwable -> L23
        com.bytedance.android.anniex.monitor.c.g(r5, r13);     // Catch: Throwable -> L23
        r14 = r110;
        goto L38
    L15:
        int r23 = r12.f872k;     // Catch: Throwable -> L40
        r110 = "AnnieXApi:createLynxView";
        int r24 = r12.f873l;
        if (r23 != (-1)) goto L27;
        if (r24 != (-1)) goto L27;
        Display r25 = nb.a.e(r17);     // Catch: Throwable -> L23
        if (r25 == null) goto L30;
        Point r26 = new Point();     // Catch: Throwable -> L23 Exception -> L25
        r25.getSize(r26);     // Catch: Throwable -> L23 Exception -> L25
        int r27 = (int) (r26.x * r21);     // Catch: Throwable -> L23 Exception -> L25
        int r28 = (int) (r26.y * r21);     // Catch: Throwable -> L23 Exception -> L25
        r19.f10911r = r27;     // Catch: Throwable -> L23 Exception -> L25
        r19.s = r28;     // Catch: Throwable -> L23 Exception -> L25
    L25:
        e = move-exception;
        int r29 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Throwable -> L23
        com.bytedance.ies.bullet.base.utils.logger.a.d("AnnieX", ": " + e, null, 12);     // Catch: Throwable -> L23
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L27:
        if (r23 == (-1)) goto L30;
        if (r24 == (-1)) goto L30;
        r19.f10911r = (int) (r23 * r21);     // Catch: Throwable -> L23
        r19.s = (int) (r24 * r21);     // Catch: Throwable -> L23
    L23:
        th = th;
        String r31 = r110;
    L44:
        TraceEvent.a(0, r31);
        throw th;
    L42:
        th = th;
    L8:
        r31 = "AnnieXApi:createLynxView";
    L40:
        th = th;
        goto L8
    }

    public static void b(FragmentActivity r10, AnnieXLynxView r11) {
        TraceEvent.c("AnnieXApi:initCanvasSettings");
        LynxKryptonHelper r12 = LynxKryptonUtils.getLynxKryptonHelper(r11);     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        kc.b r5 = new kc.b(r10);     // Catch: Throwable -> L9
        r12.f10496b.put(KryptonVideoPlayerService.class, r5);     // Catch: Throwable -> L9
        CanvasRuntimeMediator r13 = r12.f10495a;     // Catch: Throwable -> L9
        if (r13 == null) goto L11;
        r13.f10493a.put(KryptonVideoPlayerService.class, r5);     // Catch: Throwable -> L9
    L11:
        tc.c r14 = tc.c.f22119c;     // Catch: Throwable -> L14
        tc.c r15 = tc.c.f22119c;     // Catch: Throwable -> L14
        r15.getClass();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.lynx.d.class, "clazz");     // Catch: Throwable -> L14
        com.bytedance.ies.bullet.lynx.d r16 = (com.bytedance.ies.bullet.lynx.d) r15.a(com.bytedance.ies.bullet.lynx.d.class, "default_bid");     // Catch: Throwable -> L14
        TraceEvent.a(0, "AnnieXApi:initCanvasSettings");
        return;
    L9:
        th = move-exception;
        int r17 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Throwable -> L14
        com.bytedance.ies.bullet.base.utils.logger.a.d("AnnieX", "take it easy. just check ttvideo engine sdk is not exist: " + th, null, 12);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        TraceEvent.a(0, "AnnieXApi:initCanvasSettings");
        throw th;
    }

    public static final void c(String r5, AnnieXLynxView r10, boolean r11, String r12) {
        TraceEvent.c("AnnieXApi:initMonitorConfig");
        tc.c r13 = tc.c.f22119c;     // Catch: Throwable -> L6
        rc.c r14 = (i) tc.c.f22119c.a(i.class, r5);     // Catch: Throwable -> L6
        if (r14 != null) goto L8;
        Lazy r15 = com.bytedance.ies.bullet.service.monitor.i.d;     // Catch: Throwable -> L6
        r14 = m.b();     // Catch: Throwable -> L6
    L8:
        f r16 = new f((String) ((com.bytedance.ies.bullet.service.monitor.i) r14).f6054b.f9377c);     // Catch: Throwable -> L6
        r16.d = null;     // Catch: Throwable -> L6
        r16.f12567a = true;     // Catch: Throwable -> L6
        r16.f12568b = r11;     // Catch: Throwable -> L6
        r16.f12570h = r12;     // Catch: Throwable -> L6
        qo.a.h(r10, r16);     // Catch: Throwable -> L6
        TraceEvent.a(0, "AnnieXApi:initMonitorConfig");
        return;
    L6:
        th = move-exception;
        TraceEvent.a(0, "AnnieXApi:initMonitorConfig");
        throw th;
    }
}
