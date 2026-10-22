package com.bytedance.android.live.livepullstream;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.live.livepullstream.service.h;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.t9;
import com.bytedance.android.livesdk.player.LiveStatusErrorView;
import com.bytedance.android.livesdkapi.model.AdaptiveGradingConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.ss.videoarch.liveplayer.i;
import gl0.d;
import gl0.f;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tb1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class PullStreamService implements IPullStreamService {
    private static final String REASON_LOAD_SO_EXCEPTION = "load_exception";
    private static final String REASON_LOAD_SO_FAILED = "load_failed";
    private static final String REASON_LOAD_SUCCESS = "load_success";
    private static final String REASON_NULL_CONTEXT = "null_context";
    private static final String REASON_NULL_HOST_PLUGIN = "null_host_plugin";
    private static final String REASON_PULING_INSTALL_FAILED = "plugin_install_failed";
    private static final String REASON_PULING_INSTALL_SUCCESS = "plugin_install_success";
    private static final int SO_LOAD_FAILED = -1;
    private static final int SO_LOAD_SUCCESS = 0;
    private static final String SO_PLUGIN_TAG = "pull-stream-plugin-load";

    public class a implements IHostPlugin.Callback {
        public final /* synthetic */ PullStreamService a;

        public a(PullStreamService r1) {
            this.a = r1;
        }

        public final void onCancel(String r4) {
            PullStreamService.access$000(this.a, r4, PullStreamService.REASON_PULING_INSTALL_FAILED, false);
            ALogger.d(PullStreamService.SO_PLUGIN_TAG, "pull stream so plugin install failed!");
        }

        public final void onSuccess(String r4) {
            PullStreamService.access$000(this.a, r4, PullStreamService.REASON_PULING_INSTALL_SUCCESS, true);
            ALogger.d(PullStreamService.SO_PLUGIN_TAG, "pull stream so plugin install success!");
        }
    }

    public class b implements IHostPlugin.Callback {
        public final /* synthetic */ PullStreamService a;

        public b(PullStreamService r1) {
            this.a = r1;
        }

        public final void onCancel(String r4) {
            PullStreamService.access$000(this.a, r4, PullStreamService.REASON_PULING_INSTALL_FAILED, false);
            ALogger.d(PullStreamService.SO_PLUGIN_TAG, "bmf so plugin install failed!");
        }

        public final void onSuccess(String r4) {
            PullStreamService.access$000(this.a, r4, PullStreamService.REASON_PULING_INSTALL_SUCCESS, true);
            ALogger.d(PullStreamService.SO_PLUGIN_TAG, "bmf so plugin install success!");
        }
    }

    public PullStreamService() {
        k.l(IPullStreamService.class, this);
        if (c.a == false) goto L10;
        if (c.c == true) goto L10;
        if (LiveInitSettingKeys.get_LIVE_ENABLE_PULL_STREAM_SO_PLUGIN() == false) goto L10;
        ALogger.d(SO_PLUGIN_TAG, "setupLibraryLoader for douyin!");
        i.setupLibraryLoader(new fl0.a(this));
        return;
    L10:
        if (c.c == true) goto L12;
        return;
    L12:
        if (LiveInitSettingKeys.get_LIVE_LITE_ENABLE_PLUGIN_ENV_LOAD() == false) goto L17;
        ALogger.d(SO_PLUGIN_TAG, "setupLibraryLoader for dylite!");
        i.setupLibraryLoader(new fl0.b(this));
        return;
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public void tryInstallBMFPlugin() {
        if (LiveInitSettingKeys.get_LIVE_ENABLE_BMF_PLUGIN() == false) goto L5;
    L8:
        PluginType r4 = PluginType.LiveBMFSo;
        if (r4.isInstalled() == false) goto L11;
        return;
    L11:
        ALogger.d(SO_PLUGIN_TAG, "start install bmf so !");
        IHostPlugin r2 = k.f(IHostPlugin.class);
        if (r2 != null) goto L15;
        ALogger.d(SO_PLUGIN_TAG, "null IHostPlugin");
        return;
    L15:
        Application r3 = jc1.a.b();
        if (r3 != null) goto L19;
        ALogger.d(SO_PLUGIN_TAG, "null context");
        return;
    L19:
        r2.check(r3, r4, "", new b(this), false);
        return;
    L5:
        if (((AdaptiveGradingConfig) t9.a.getValue()).enable() == true) goto L8;
        ALogger.d(SO_PLUGIN_TAG, "live_enable_bmf_plugin: false ! tryInstallPullStreamPlugin failed");
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public void tryInstallPullStreamPlugin() {
        if (LiveInitSettingKeys.get_LIVE_ENABLE_PULL_STREAM_SO_PLUGIN() == true) goto L6;
        ALogger.d(SO_PLUGIN_TAG, "live_enable_pull_stream_so_plugin: false ! tryInstallPullStreamPlugin failed");
        return;
    L6:
        PluginType r4 = PluginType.PullSo;
        if (r4.isInstalled() == false) goto L9;
        return;
    L9:
        ALogger.d(SO_PLUGIN_TAG, "start install pull stream so !");
        IHostPlugin r2 = k.f(IHostPlugin.class);
        if (r2 != null) goto L13;
        ALogger.d(SO_PLUGIN_TAG, "null IHostPlugin");
        return;
    L13:
        Application r3 = jc1.a.b();
        if (r3 != null) goto L17;
        ALogger.d(SO_PLUGIN_TAG, "null context");
        return;
    L17:
        r2.check(r3, r4, "", new a(this), false);
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public gl0.c getLivePlayerOptimizer() {
        return com.bytedance.android.live.livepullstream.service.c.b;
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public f getStreamStrategyOptimizer() {
        return h.d;
    }

    public int loadLibrary(String r3) {
        return loadLibrary(0, r3, null);
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public ILivePlayerClient getLivePlayerClient(long r2, Bundle r4) {
        Boolean r0 = com.bytedance.android.live.livepullstream.service.c.a;
        return LivePlatformPlayerManager.c(r2, com.bytedance.android.live.livepullstream.service.c.d(r4)).player();
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public d getLiveStatusErrorView(Context r2, ILivePlayerScene r3) {
        return new LiveStatusErrorView(r2, r3);
    }

    public boolean loadPluginLibrary(String r10, String r11) {
        ALogger.d(SO_PLUGIN_TAG, "loadPluginLibrary!");
        IHostPlugin r3 = k.f(IHostPlugin.class);
        if (r3 != null) goto L6;
        monitorSoLoad(r10, REASON_NULL_HOST_PLUGIN, false);
        ALogger.d(SO_PLUGIN_TAG, "null IHostPlugin");
        return false;
    L6:
        Application r5 = jc1.a.b();
        if (r5 != null) goto L23;
        monitorSoLoad(r10, REASON_NULL_CONTEXT, false);
        ALogger.d(SO_PLUGIN_TAG, "null context");
        return false;
    L23:
    L17:
        th = move-exception;
        if (v.a() == true) goto L22;
        monitorSoLoad(r10, REASON_LOAD_SO_EXCEPTION, false);
        ALogger.d(SO_PLUGIN_TAG, "load " + r10 + " so failed! " + th.getMessage());
        return false;
    L22:
        throw th;
    L12:
        if (r3.loadLibrary(4, r5, r11, r10, null) == false) goto L15;
        monitorSoLoad(r10, REASON_LOAD_SUCCESS, true);     // Catch: Throwable -> L17
        ALogger.d(SO_PLUGIN_TAG, "load " + r10 + " so success!");     // Catch: Throwable -> L17
        return true;
    L15:
        ALogger.d(SO_PLUGIN_TAG, "load " + r10 + " so failed!");     // Catch: Throwable -> L17
        monitorSoLoad(r10, REASON_LOAD_SO_FAILED, false);     // Catch: Throwable -> L17
        return false;
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public boolean prePullStream(long r2, Bundle r4) {
        return com.bytedance.android.live.livepullstream.service.c.b.c(r2, r4);
    }

    private void monitorSoLoad(String r7, String r8, boolean r9) {
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L4
        r3.put("name", r7);     // Catch: JSONException -> L4
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L4
        r4.put("result", r9);     // Catch: JSONException -> L4
        r4.put("desc", r8);     // Catch: JSONException -> L4
        LiveTracingMonitor.e("ttlive_pull_stream_so_load", LiveTracingMonitor.EventModule.PULL_STREAM, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r3, r4, null);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        ALogger.d(SO_PLUGIN_TAG, "report so load log failed " + e.getMessage());
    }

    public int loadLibrary(int r11, String r12, ClassLoader r13) {
        if (LiveInitSettingKeys.get_LIVE_ENABLE_PULL_STREAM_SO_PLUGIN() == true) goto L6;
        ALogger.i(SO_PLUGIN_TAG, "live_enable_pull_stream_so_plugin: false ! load $soName failed");
        return -1;
    L6:
        ALogger.i(SO_PLUGIN_TAG, "loadLibrary " + r12 + " so");
        IHostPlugin r3 = k.f(IHostPlugin.class);
        if (r3 != null) goto L10;
        monitorSoLoad(r12, REASON_NULL_HOST_PLUGIN, false);
        ALogger.i(SO_PLUGIN_TAG, "null IHostPlugin");
        return -1;
    L10:
        Application r5 = jc1.a.b();
        if (r5 != null) goto L14;
        monitorSoLoad(r12, REASON_NULL_CONTEXT, false);
        ALogger.i(SO_PLUGIN_TAG, "null context");
        return -1;
    L14:
        PluginType r4 = PluginType.PullSo;
        if (r4.isInstalled() == false) goto L26;
        ALogger.i(SO_PLUGIN_TAG, "start load " + r12 + " so , current is full pkg : " + r3.isFull());
    L23:
        th = move-exception;
        monitorSoLoad(r12, REASON_LOAD_SO_EXCEPTION, false);
        ALogger.i(SO_PLUGIN_TAG, "load " + r12 + " so failed! " + th.getMessage());
        return -1;
    L18:
        if (r3.loadLibrary(r11, r5, r4.getPackageName(), r12, r13) == false) goto L21;
        monitorSoLoad(r12, REASON_LOAD_SUCCESS, true);     // Catch: Throwable -> L23
        ALogger.i(SO_PLUGIN_TAG, "load " + r12 + " so success!");     // Catch: Throwable -> L23
        return 0;
    L21:
        ALogger.i(SO_PLUGIN_TAG, "load " + r12 + " so failed!");     // Catch: Throwable -> L23
        monitorSoLoad(r12, REASON_LOAD_SO_FAILED, false);     // Catch: Throwable -> L23
        return -1;
    L26:
        ALogger.i(SO_PLUGIN_TAG, "load " + r12 + " failed! plugin not install");
        return -1;
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public boolean preCreateSurface(Context r2, long r3, Bundle r5) {
        return com.bytedance.android.live.livepullstream.service.c.b.b(r2, r3, r5);
    }

    @Override // com.bytedance.android.live.livepullstream.api.IPullStreamService
    public void useSurfaceControl(Context r2, long r3, Bundle r5) {
        Boolean r0 = com.bytedance.android.live.livepullstream.service.c.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "bundle");
        LivePlatformPlayerManager.c(r3, com.bytedance.android.live.livepullstream.service.c.d(r5)).l(r2, r5);
    }

    public static /* synthetic */ void access$000(PullStreamService r0, String r1, String r2, boolean r3) {
        r0.monitorSoLoad(r1, r2, r3);
    }
}
