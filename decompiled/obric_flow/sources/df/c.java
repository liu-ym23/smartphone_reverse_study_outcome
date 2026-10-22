package df;

import ai.p;
import android.content.Context;
import android.text.TextUtils;
import av.i;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdkmonitor.f;
import com.bytedance.geckox.AppSettingsManager$IGeckoAppSettings;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.IGeckoGlobalInit;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.model.Common;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.ui.image.f0;
import com.lynx.tasm.utils.j;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f16648a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f16649b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f16650c = null;
    public static final ConcurrentHashMap d = null;
    public static final Common e = null;
    public static GeckoGlobalConfig f;
    public static boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static p f16651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f16652i = null;

    static {
        f16652i = new c();
        f16648a = new AtomicBoolean(false);
        f16649b = new AtomicBoolean(false);
        f16650c = new AtomicBoolean(false);
        d = new ConcurrentHashMap();
        e = new Common();
        g = true;
    }

    public static void b(GeckoGlobalConfig r10) {
        int r5 = 0;
        AtomicBoolean r11 = f16650c;
        if (r11.get() == false) goto L5;
        return;
    L5:
        GeckoLogger.a("GeckoGlobalManager init");
        f = r10;
        Context r12 = r10.getContext();
        r11.set(true);
        System.currentTimeMillis();
        we.a r13 = bb.c.f895a;
        za.c r14 = za.b.f23424a;
        r14.getClass();
        GeckoGlobalConfig.IMonitorConfig r15 = r10.getMonitorConfig();
        if (r15 != null) goto L9;
    L30:
        f16651h = new p(17);
        AppSettingsManager$IGeckoAppSettings r16 = com.bytedance.geckox.b.f4736a.a();
        if (r16 == null) goto L61;
        if (r16.isProbeEnable() != true) goto L61;
        i.f799c = com.bytedance.geckox.utils.d.f4794a.e(r12, "tlb_probe", null);
        GeckoLogger.a("[gecko probe] request interceptor registered,old probe:" + i.f799c);
        wa.a r17 = new wa.a(r5);
        CopyOnWriteArrayList r18 = com.bytedance.ttnet.utils.d.f7541a;
        monitor-enter(com.bytedance.ttnet.utils.d.class);
        String r19 = wa.a.class.getName();     // Catch: Throwable -> L39
        if (com.bytedance.ttnet.utils.d.f7542b.containsKey(r19) == true) goto L41;
        com.bytedance.ttnet.utils.c r20 = new com.bytedance.ttnet.utils.c();     // Catch: Throwable -> L39
        r20.f7540a = r17;     // Catch: Throwable -> L39
        com.bytedance.ttnet.utils.d.f7541a.add(r20);     // Catch: Throwable -> L39
        com.bytedance.ttnet.utils.d.f7542b.put(r19, r20);     // Catch: Throwable -> L39
        ei.b r21 = r20;
    L42:
        f0.u(com.bytedance.ttnet.utils.d.f7543c, r21);     // Catch: Throwable -> L39
        f0.u(com.bytedance.ttnet.utils.d.d, r21);     // Catch: Throwable -> L39
        monitor-exit(com.bytedance.ttnet.utils.d.class);
    L54:
        if (com.bytedance.geckox.p.d() == false) goto L56;
        com.bytedance.gkfs.a.c(r12);
    L56:
        com.lynx.tasm.behavior.utils.d.d = new File(r12.getFilesDir(), "gecko_offline_res_x");
        File r22 = com.lynx.tasm.behavior.utils.d.d;
        if (r22 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("fileRoot");
    L59:
        com.lynx.tasm.behavior.utils.d.e = new File(r22, "pending_delete");
        com.lynx.tasm.behavior.utils.d.f10794c = true;
        e.init(r10);
        GeckoLogger.a("GeckoGlobalManager init finish");
        return;
    L41:
        r21 = (ei.b) com.bytedance.ttnet.utils.d.f7542b.get(r19);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    L61:
        JSONObject r23 = new JSONObject();     // Catch: Throwable -> L50
        r23.put("event_type", "registerProbeListener_error");     // Catch: Throwable -> L50
        r23.put("probe", "");     // Catch: Throwable -> L50
        j.g("geckosdk_probe_debug_stats", r23);     // Catch: Throwable -> L50
    L52:
        GeckoLogger.a("[gecko probe] disabled");
    L50:
        th = move-exception;
        GeckoLogger.a("uploadProbeEvent error: " + th.getMessage(), th);
        goto L52
    L9:
        if (r14.f23426b.compareAndSet(false, true) == false) goto L30;
        if (r15.isOversea() == false) goto L14;
        int r24 = 3261;
    L13:
        String r25 = String.valueOf(r24);
        JSONObject r26 = new JSONObject();
        r26.put(WsConstants.KEY_DEVICE_ID, r10.getDeviceId());     // Catch: JSONException -> L19
        r26.put("host_aid", r10.getAppId());     // Catch: JSONException -> L19
        r26.put(WsConstants.KEY_SDK_VERSION, "5.2.4");     // Catch: JSONException -> L19
        r26.put("app_version", r10.getAppVersion());     // Catch: JSONException -> L19
        String r27 = r15.getChannel();     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r27) == true) goto L21;
        r26.put(LynxMonitorService.KEY_CHANNEL, r27);     // Catch: JSONException -> L19
    L21:
        String r28 = r15.getUpdateVersionCode();     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r28) == true) goto L24;
        r26.put("update_version_code", r28);     // Catch: JSONException -> L19
    L24:
        String r29 = r15.getPackageId();     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r29) == true) goto L27;
        r26.put(Constant.PACKAGE_NAME, r29);     // Catch: JSONException -> L19
    L27:
        f.e(r25, Collections.singletonList(r15.getMonitorHost() + "/monitor/collect/"));     // Catch: JSONException -> L19
        f.d(r25, Collections.singletonList(r15.getMonitorHost() + "/monitor/appmonitor/v2/settings"));     // Catch: JSONException -> L19
        f.c(r12.getApplicationContext(), r25, r26, new za.a(r15));     // Catch: JSONException -> L19
        r14.f23425a = f.b(r25);     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        GeckoLogger.a("monitor init failed:" + e.getMessage());
        goto L30
    L14:
        r24 = 3262;
        goto L13
    }

    public static Context c() {
        GeckoGlobalConfig r5 = f;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getContext();
    }

    public final synchronized void a() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (f16650c.get() == true) goto L15;
        ServiceManager r5 = ServiceManager.a();     // Catch: Throwable -> L13
        IGeckoGlobalInit r10 = (IGeckoGlobalInit) r5.a(IGeckoGlobalInit.class, r5.f16217b, true);     // Catch: Throwable -> L13
        if (r10 == null) goto L15;
        GeckoGlobalConfig r11 = r10.getGeckoGlobalConfig();     // Catch: Throwable -> L13
        if (r11 == null) goto L15;
        b(r11);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L15:
        monitor-exit(this);
    }

    public final GlobalConfigSettings d() {
        a();
        if (f16650c.get() == true) goto L5;
        return null;
    L5:
        return com.bytedance.iesgurd.settings.d.f6692a;
    }
}
