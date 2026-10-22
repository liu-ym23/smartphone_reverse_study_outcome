package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.LynxEnv;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.framwork.core.sdkmonitor.e f5687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f5688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f5689c = null;

    static {
        n r5 = new n();
        JSONObject r10 = com.lynx.tasm.utils.d.k("host_aid", "7059");
        r10.put("app_version", LynxEnv.inst().getLynxVersion());
        r10.put("update_version_code", LynxEnv.inst().getLynxVersion());
        r5.f5690a = r10;
        r5.f5691b = CollectionsKt.listOf("https://mon.snssdk.com/monitor/appmonitor/v2/settings");
        r5.f5692c = CollectionsKt.listOf("https://mon.snssdk.com/monitor/collect");
        f5689c = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.bytedance.ies.bullet.lynx.init.n] */
    public static final void a(Application r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        ?? r12 = f5689c;
        r11.element = r12;
        JSONObject r13 = r12.f5690a;
        if (r13 == null) goto L9;
        String r14 = com.bytedance.ies.bullet.kit.resourceloader.g.a("default_bid").d().e;
        if (r10 == false) goto L7;
        String r15 = "lynx_debug_channel";
    L8:
        r13.put(LynxMonitorService.KEY_CHANNEL, r15);
        r13.put(WsConstants.KEY_DEVICE_ID, r14);
        goto L9
    L7:
        r15 = "lynx_channel";
    L9:
        List r16 = ((n) r11.element).f5691b;
        if (r16 == null) goto L12;
        com.bytedance.framwork.core.sdkmonitor.f.d("7059", r16);
    L12:
        List r17 = ((n) r11.element).f5692c;
        if (r17 == null) goto L15;
        com.bytedance.framwork.core.sdkmonitor.f.e("7059", r17);
    L15:
        JSONObject r18 = ((n) r11.element).f5690a;
        if (r18 != null) goto L18;
        r18 = new JSONObject();
    L18:
        r18.put(WsConstants.KEY_SDK_VERSION, "9.0.0");
        com.bytedance.framwork.core.sdkmonitor.f.c(r5, "7059", r18, new j());
        f5687a = com.bytedance.framwork.core.sdkmonitor.f.b("7059");
        HandlerThread r19 = new HandlerThread("lynx_sdk_monitor");
        r19.start();
        f5688b = new Handler(r19.getLooper());
    }
}
