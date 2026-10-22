package a3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.resource.core.net.AIPackageTTNET;
import com.bytedance.ai.resource.core.net.AISDKApiManager;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.settings.AISDKSettingsCore;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.ai.widget.GlobalWidgetCache$WidgetCacheMap;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.Keva;
import com.obric.widget.host.internal.HostedWidgetRuntimeBootstrap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f77a;

    public /* synthetic */ f(int r5) {
        this.f77a = r5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f77a) {
            case 0: goto L82;
            case 1: goto L80;
            case 2: goto L78;
            case 3: goto L77;
            case 4: goto L71;
            case 5: goto L69;
            case 6: goto L66;
            case 7: goto L65;
            case 8: goto L63;
            case 9: goto L61;
            case 10: goto L59;
            case 11: goto L57;
            case 12: goto L51;
            case 13: goto L49;
            case 14: goto L37;
            case 15: goto L36;
            case 16: goto L34;
            case 17: goto L32;
            case 18: goto L30;
            case 19: goto L24;
            case 20: goto L23;
            case 21: goto L21;
            case 22: goto L19;
            case 23: goto L17;
            case 24: goto L14;
            case 25: goto L12;
            case 26: goto L10;
            case 27: goto L9;
            case 28: goto L7;
            default: goto L4;
        };
    L4:
        AISDKSettingsCore.a();
        pg.a.b("flow_ai_sdk").d();
        return Unit.INSTANCE;
    L10:
        int r5 = AppletPopup.L;
        return Unit.INSTANCE;
    L12:
        int r10 = AppletPopup.L;
        return Unit.INSTANCE;
    L14:
        int r11 = AppletPopup.L;
        return new h3.c();
    L24:
        int r12 = AISDKSettingConfigManager.INSTANCE.getWIDGET_SETTINGS_CONFIG().getValue().c();
        String r13 = "globalCachePoolSize=" + r12;
        Intrinsics.checkNotNullParameter("WidgetGlobalCache", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L28;
        r14.i("WidgetGlobalCache", r13);
    L28:
        return new GlobalWidgetCache$WidgetCacheMap(r12);
    L37:
        u0.a r15 = s0.a.f21800c;
        if (r15 != null) goto L40;
    L42:
        if (r15 != null) goto L44;
    L46:
        String r16 = "ai_sdk_gecko_config_prod";
    L48:
        return Keva.getRepo(r16);
    L44:
        if (r15.f22205p != true) goto L46;
    L45:
        r16 = "ai_sdk_gecko_config_test";
        goto L48
    L40:
        if (r15.f22203n != true) goto L42;
    L49:
        Thread.sleep(1000);
        Process.killProcess(Process.myPid());
        return Unit.INSTANCE;
    L51:
        long r17 = AISDKSettingConfigManager.INSTANCE.getCUSTOM_UPDATE_INTERVAL().getValue().longValue();
        if (r17 >= WsConstants.EXIT_DELAY_TIME) goto L55;
        r17 = 3000;
    L55:
        return Long.valueOf(r17);
    L66:
        int r18 = AppletRuntime.f2196x;
        return Unit.INSTANCE;
    L78:
        HandlerThread r19 = new HandlerThread("ai_thread");
        r19.start();
        return r19;
    L80:
        HandlerThread r20 = new HandlerThread("AppletEventMonitorManager", 0);
        r20.start();
        return new Handler(r20.getLooper());
    L82:
        HandlerThread r21 = new HandlerThread("AIBridgeCommonMonitor", 0);
        r21.start();
        return new Handler(r21.getLooper());
    L7:
        return new ConcurrentHashMap();
    L9:
        return new Handler(m1.i.f19970i.getLooper());
    L17:
        return HostedWidgetRuntimeBootstrap.c();
    L19:
        return HostedWidgetRuntimeBootstrap.a();
    L21:
        return HostedWidgetRuntimeBootstrap.b();
    L23:
        return HostedWidgetRuntimeBootstrap.d();
    L30:
        return AISDKApiManager.c();
    L32:
        return AISDKApiManager.a();
    L34:
        return AIPackageTTNET.a();
    L36:
        return Keva.getRepo("AI_SDK_GECKO_BREAK_UPDATER");
    L57:
        return new com.bytedance.ai.resource.d();
    L59:
        return new Handler(Looper.getMainLooper());
    L61:
        return new Handler(Looper.getMainLooper());
    L63:
        return new Handler(Looper.getMainLooper());
    L65:
        return new com.bytedance.ai.core.manager.b();
    L69:
        return h0.a(new e1(Executors.newSingleThreadExecutor()));
    L71:
        if (com.bytedance.ttnet.utils.d.e("https://mini-program.doubao.com").b(com.bytedance.ai.bridge.method.payment.a.class) != null) goto L75;
        return null;
    L75:
        throw new ClassCastException();
    L77:
        return new Handler(((HandlerThread) c1.b.f1103b.getValue()).getLooper());
    }
}
