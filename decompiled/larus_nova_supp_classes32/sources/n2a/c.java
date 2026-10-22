package n2a;

import android.webkit.CookieManager;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.settings.value.e10;
import com.larus.settings.value.ge;
import com.larus.settings.value.q4;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.sdk.r;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.IObricEnvService;
import com.obric.assistant.spi.launch.ObricLazyInitSettingsServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.DataLoaderListener;
import com.ss.ttvideoengine.LibraryLoaderProxy;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.download.Downloader;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qt9.l4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final c a = null;
    public static final Object b = null;
    public static volatile boolean c;

    public static final class a implements DataLoaderListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final String apiStringForFetchVideoModel(Map<String, String> r1, String r2, Resolution r3) {
            return NameKeys.UnloadStrategy_No_Strategy;
        }

        public final String authStringForFetchVideoModel(String r1, Resolution r2) {
            return NameKeys.UnloadStrategy_No_Strategy;
        }

        public final String getCheckSumInfo(String r1) {
            return NameKeys.UnloadStrategy_No_Strategy;
        }

        public final boolean loadLibrary(String r1) {
            return false;
        }

        public final void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress r1) {
        }

        public final /* synthetic */ void onMultiNetworkSwitch(String r1, String r2) {
            DataLoaderListener.-CC.$default$onMultiNetworkSwitch(this, r1, r2);
        }

        public final void onNotify(int r1, long r2, long r4, String r6) {
        }

        public final void onNotifyCDNLog(DataLoaderCDNLog r1) {
        }

        public final void onNotifyCDNLog(JSONObject r1) {
        }

        public final /* synthetic */ void onStartComplete() {
            DataLoaderListener.-CC.$default$onStartComplete(this);
        }

        public final HashMap<String, String> getCustomHttpHeaders(String r4) {
            String r5 = CookieManager.getInstance().getCookie(r4);
            Pair[] r0 = new Pair[2];
            r0[0] = new Pair("Cookie", r5);
            String r1 = AccountService.a.getXTTToken();
            if (r1 != null) goto L5;
            r1 = NameKeys.UnloadStrategy_No_Strategy;
        L5:
            r0[1] = new Pair("X-Tt-Token", r1);
            return MapsKt.hashMapOf(r0);
        }

        public final void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo r4) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("onTaskProgress type is ");
            if (r4 == null) goto L5;
            int r5 = r4.mTaskType;
        L6:
            r1.append(r5);
            r0.d("dataLoader", r1.toString());
            return;
        L5:
            r5 = -1;
            goto L6
        }

        public final void dataLoaderError(String r4, int r5, Error r6) {
            FLogger.a.e("dataLoader", "dataLoaderError: videoId = " + r4 + " , errorType = " + r5 + " error = " + r6);
        }

        public final void onLogInfo(int r4, String r5, JSONObject r6) {
            FLogger.a.d("dataLoader", "onLogInfo:what = " + r4 + " logType = " + r5 + " log = " + r6);
            if (r5 == null) goto L7;
            if (r6 == null) goto L8;
            IApplog.a.onMiscEvent(r5, r6);
            return;
        L8:
            return;
        }

        public final void onLogInfoToMonitor(int r1, String r2, JSONObject r3) {
            if (r2 == null) goto L6;
            if (r3 == null) goto L7;
            IApplog.a.onMiscEvent(r2, r3);
            return;
        L7:
            return;
        }
    }

    public static final class b implements LibraryLoaderProxy {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @JvmStatic
        public static void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "libName");
            FLogger r0 = FLogger.a;
            r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
            com.bytedance.librarian.a.c(r4);
            r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
        }

        public final boolean loadLibrary(String r5) {
            if (r5 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L21;
            return false;
        L21:
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
            a(r5);     // Catch: Throwable -> L13
            Object r2 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L13
        L15:
            Throwable r3 = Result.exceptionOrNull-impl(r2);
            if (r3 == null) goto L20;
            FLogger.a.e("InitTTVideoEngineTask", "load mdl library failed, name=" + r5, r3);
            r2 = Boolean.FALSE;
        L20:
            return ((Boolean) r2).booleanValue();
        L13:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        L5:
            if (r5.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = new Object();
    }

    public static void a() {
        if (ObricLazyInitSettingsServiceDelegate.a.b() == true) goto L7;
        b();
        return;
    L7:
        if (c == false) goto L9;
        return;
    L9:
        Object r0 = b;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (c == false) goto L15;
        monitor-exit(r0);
        return;
    L15:
        a.getClass();     // Catch: Throwable -> L18
        b();     // Catch: Throwable -> L18
        c = true;     // Catch: Throwable -> L18
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
    }

    public static void b() {
        StringBuilder r0 = new StringBuilder();
        AppHost.Companion r1 = AppHost.a;
        r0.append(r1.getApplication().getCacheDir().getAbsolutePath());
        r0.append("/videoCache");
        TTVideoEngine.setStringValue(0, r0.toString());
        TTVideoEngine.setStringValue(SpeechEvent.SERVER_UPLINK_EVENT_UPDATE_UI_CONTEXT, r1.getApplication().getCacheDir().getAbsolutePath() + "/videoDownload");
        HashMap r2 = new HashMap();
        r2.put("appid", Integer.valueOf(r1.getAppId()));
        r2.put("appname", r1.getAppName());
        r2.put("appchannel", r1.getBuildChannel());
        r2.put("appversion", r1.getVersionName());
        r2.put("deviceid", o.a.getDeviceId());
        TTVideoEngine.setAppInfo(r1.getApplication(), r2);
        TTVideoEngine.setIntValue(1, 314572800);
        TTVideoEngine.setDataLoaderListener(a.a);
        TTVideoEngine.setIntValue(105, 0);
        TTVideoEngine.setIntValue(103, 0);
        TTVideoEngine.setIntValue(104, 0);
        DataLoaderHelper.getDataLoader().setBackUpIP("v3-tt.ixigua.com", "8.8.8.8,8.8.8.8");
        TTVideoEngine.setIntValue(106, 0);
        TTVideoEngine.setIntValue(1117, 1);
        TTVideoEngine.setIntValue(1501, 1);
        TTVideoEngine.setStringValue(108, "dns.google.com");
        TTVideoEngine.setStringValue(107, "34.102.215.99");
        TTVideoEngine.setTTDNSServerHost("34.102.215.99");
        TTVideoEngine.enableNewMDLFetcher(true);
        e10 r3 = e10.a;
        int r4 = l0.a;
        boolean r5 = ((Boolean) l0.a(Boolean.FALSE, new ge())).booleanValue();
        TTVideoEngine.setIntValue(1154, r5 ? 1 : 0);
        if (r5 == false) goto L5;
        TTVideoEngine.setIntValue(9013, 1);
        DataLoaderHelper.getDataLoader().setLoadProxy(b.a);
    L5:
        FLogger.a.i("InitTTVideoEngineTask", "configMdlVersion enableMdl2=" + r5);
        e10 r6 = e10.a;
        if (Intrinsics.areEqual(((l4) l0.a(new l4(0), new q4())).a(), Boolean.TRUE) == false) goto L11;
        TTVideoEngine.setIntValue(472, 1);
        IObricEnvService r7 = (IObricEnvService) ServiceManager.get().getService(IObricEnvService.class);
        if (r7 == null) goto L10;
        r7.a(new n2a.a());
    L10:
        TTVideoEngineLog.setListener(new n2a.b());
    L11:
        VideoEventManager.instance.setListener(d.a);
        TTVideoEngine.startDataLoader(r1.getApplication());     // Catch: Throwable -> L22
    L23:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L15
        Downloader.getInstance().setMaxDownloadOperationCount(1);     // Catch: Throwable -> L15
        Downloader.getInstance().setLimitFreeDiskSize(1073741824);     // Catch: Throwable -> L15
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L20;
        FLogger.a.e("InitTTVideoEngineTask", "Downloader config failed", r10);
    L20:
        TTNetWorkListener.getInstance().setIntValue(1, 100);
        TTNetWorkListener.getInstance().setIntValue(2, 5000);
        TTVideoEngine.setReportLogByEngine(true, AppHost.a.getApplication());
        TTVideoEngine.addEngineStateListener(r.a);
        FLogger.a.i("BackgroundLazyInit", "TTVideoEngine init completed");
        return;
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
