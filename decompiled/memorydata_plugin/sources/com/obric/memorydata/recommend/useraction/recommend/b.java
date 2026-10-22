package com.obric.memorydata.recommend.useraction.recommend;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.recommend.context.ContextManager;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotContextData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotInputData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotOutputData;
import com.obric.memorydata.recommend.screenshotupload.i;
import com.obric.memorydata.recommend.screenshotupload.j;
import com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.h;
import com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.k;
import com.obric.memorydata.recommend.screenshotupload.sampling.g;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.sdk.screencapture.ScreenCaptureManager;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.obric.memorydata.sdk.screencapture.event.AppStateEvent;
import com.obric.memorydata.sdk.screencapture.event.InputMethodEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.obric.memorydata.sdk.screencapture.event.TouchInfo;
import com.obric.memorydata.sdk.screencapture.rule.AppStateEventRule;
import com.obric.memorydata.sdk.screencapture.rule.InputMethodEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenTouchEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.sdk.screencapture.rule.ViewTreeOption;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0006\u00105\u001a\u000206J\u0014\u00107\u001a\u0002062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\nJ\"\u00109\u001a\u0002062\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u000eH\u0002J\b\u0010;\u001a\u000206H\u0002J\b\u0010<\u001a\u000206H\u0002J\b\u0010=\u001a\u000206H\u0002J\b\u0010>\u001a\u000206H\u0002J\b\u0010?\u001a\u000206H\u0002J\b\u0010@\u001a\u000206H\u0002J\b\u0010A\u001a\u000206H\u0002J\b\u0010B\u001a\u000206H\u0002JN\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010K\u001a\u00020\u00122\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\nH\u0002J \u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\bH\u0002JN\u0010R\u001a\u0002062\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010G2\b\u0010J\u001a\u0004\u0018\u00010\u00052\u0006\u0010Q\u001a\u00020\b2\u0006\u0010K\u001a\u00020\u00122\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\nH\u0002J\u0010\u0010T\u001a\u0002062\u0006\u0010U\u001a\u00020\u0012H\u0002J\n\u0010V\u001a\u0004\u0018\u000103H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/memorydata/recommend/useraction/recommend/RecommendManager;", "", "<init>", "()V", "TAG", "", "RECOMMEND_SETTINGS_KEY", "VIEW_TREE_CACHE_VALID_DURATION_MS", "", "DEBUG_COLLECT_PACKAGES", "", "collectPackages", "enableApps", "blackActivityPrefixes", "", "buildScreenshotOption", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "onlyAppWindow", "", "buildViewTreeOption", "Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;", "buildViewTreeOptionIfEnabled", "buildTouchEventReaction", "Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", "buildAppCloseReaction", "buildImeEventReaction", "touchEventReaction", "appOpenReaction", "appCloseReaction", "imeEventReaction", "lastViewTreeContextEnabled", "screenshotReactions", "getScreenshotReactions", "()Ljava/util/List;", "reactions", "getReactions", "isStart", "scope", "Lkotlinx/coroutines/CoroutineScope;", "packageNameToJob", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Job;", "screenshotSamplingGate", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/ScreenshotSamplingGate;", "periodicScreenshotSampler", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampler;", "cameraForegroundSamplingController", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/CameraForegroundSamplingController;", "videoPlaybackSamplingController", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/VideoPlaybackSamplingController;", "aimediaCodecLifecycleMonitor", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaLifecycleMonitor;", "hasLoggedAIMediaUnavailable", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "updateAllTarget", Constants.KEY_LIST, "updateBlackActivity", "blackActivity", "refreshViewTreeReactionsIfNeeded", "rebuildScreenshotReactions", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "registerImeRule", "registerAppOpenRule", "registerAppCloseRule", "registerScreenTouchEvent", "processTouchEvent", "touchEvent", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "screenshot", "Landroid/graphics/Bitmap;", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "heifScreenshotPath", "isVertical", "viewTree", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "onAppOpen", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "eventTime", "onAppClose", "bitmap", "enableStateChange", "enable", "getAIMediaCodecLifecycleMonitor", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f12764b = null;
    private static List<String> c;
    private static Map<String, ? extends List<String>> d;
    private static ScreenEventReaction e;
    private static final ScreenEventReaction f = null;
    private static ScreenEventReaction g;
    private static ScreenEventReaction h;
    private static boolean i;
    private static boolean j;
    private static final al k = null;
    private static final ConcurrentHashMap<String, bx> l = null;
    private static final g m = null;
    private static final com.obric.memorydata.recommend.screenshotupload.sampling.b n = null;
    private static final com.obric.memorydata.recommend.screenshotupload.sampling.a o = null;
    private static final k p = null;
    private static h q;
    private static boolean r;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/recommend/useraction/recommend/RecommendManager$init$1", "Lcom/obric/memorydata/recommend/screenshotupload/MemoryRuleObserver$MemoryRuleListener;", "onMemoryRuleAppsChanged", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.recommend.screenshotupload.b.a {
        a() {
        }

        @Override // com.obric.memorydata.recommend.screenshotupload.b.a
        public void a() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "onMemoryRuleAppsChanged", false, 4, null);
            List<String> r8 = b.a(b.f12763a);
            b.f12763a.a(r8);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
            b.a(b.f12763a, true);
        L5:
            b.b().a();
            b.c().b();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.useraction.recommend.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/recommend/useraction/recommend/RecommendManager$init$3", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0687b implements SettingsChangeListener {
        C0687b() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r1) {
            Intrinsics.checkNotNullParameter(r1, "key");
            b.b(b.f12763a);
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/recommend/useraction/recommend/RecommendManager$registerAppCloseRule$1", "Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "onEvent", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.sdk.screencapture.b {
        c() {
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(int r7, String r8) {
            Intrinsics.checkNotNullParameter(r8, "errorMessage");
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "onError " + r7 + ", " + r8, null, 4, null);
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(ScreenEvent r12, ScreenData r13) {
            Intrinsics.checkNotNullParameter(r12, "event");
            Intrinsics.checkNotNullParameter(r13, "data");
            RunLog.INSTANCE.debug("RecommendManager", "onEvent " + r12);
            if (r12.getEventType() != ScreenEvent.EventType.APP_STATE) goto L8;
            AppStateEvent r11 = (AppStateEvent) ZeusTransformUtils.preCheckCast(r12, AppStateEvent.class, "com.obric.memorydata.plugin");
            if (r11.getState() != AppStateEvent.AppState.CLOSE) goto L9;
            b.a(b.f12763a, r11.getAppName(), r11.getPackageName(), r13.getScreenshot(), r13.getHeifScreenshotPath(), r12.getEventTime(), r13.isVertical(), r13.getViewTree());
            return;
        L9:
            return;
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/recommend/useraction/recommend/RecommendManager$registerAppOpenRule$1", "Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "onEvent", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.sdk.screencapture.b {
        d() {
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(int r7, String r8) {
            Intrinsics.checkNotNullParameter(r8, "errorMessage");
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "onError " + r7 + ", " + r8, null, 4, null);
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(ScreenEvent r4, ScreenData r5) {
            Intrinsics.checkNotNullParameter(r4, "event");
            Intrinsics.checkNotNullParameter(r5, "data");
            RunLog.INSTANCE.debug("RecommendManager", "onEvent " + r4);
            if (r4.getEventType() != ScreenEvent.EventType.APP_STATE) goto L8;
            AppStateEvent r3 = (AppStateEvent) ZeusTransformUtils.preCheckCast(r4, AppStateEvent.class, "com.obric.memorydata.plugin");
            if (r3.getState() != AppStateEvent.AppState.OPEN) goto L9;
            b.a(b.f12763a, r3.getAppName(), r3.getPackageName(), r4.getEventTime());
            return;
        L9:
            return;
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/recommend/useraction/recommend/RecommendManager$registerImeRule$1", "Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "onEvent", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements com.obric.memorydata.sdk.screencapture.b {
        e() {
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(int r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "errorMessage");
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(ScreenEvent r30, ScreenData r31) {
            Intrinsics.checkNotNullParameter(r30, "event");
            Intrinsics.checkNotNullParameter(r31, "data");
            RunLog.INSTANCE.debug("RecommendManager", "event " + r30 + " , time: " + r30.getEventTime() + ", package: " + r30.getPackageName());
            if (r30.getEventType() == ScreenEvent.EventType.INPUT_METHOD) goto L6;
            return;
        L6:
            if (((InputMethodEvent) ZeusTransformUtils.preCheckCast(r30, InputMethodEvent.class, "com.obric.memorydata.plugin")).getVisible() == false) goto L8;
            return;
        L8:
            i.f12559a.a(new ScreenshotData(new ScreenshotInputData(r30.getAppName(), r30.getPackageName(), r30.getEventTime(), TriggerUploadType.ImeHide, r31.getScreenshot(), r31.getHeifScreenshotPath(), null, r31.getViewTree(), r31.getHardwareBuffer(), null, null, null, null, r31.isVertical(), null, 24128, null), new ScreenshotOutputData(null, new ScreenshotContextData(r30.getEventTime(), com.obric.memorydata.recommend.context.b.a()), null, 5, null)));
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/recommend/useraction/recommend/RecommendManager$registerScreenTouchEvent$1", "Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "onEvent", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.obric.memorydata.sdk.screencapture.b {
        f() {
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(int r7, String r8) {
            Intrinsics.checkNotNullParameter(r8, "errorMessage");
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "onError " + r7 + ", " + r8, null, 4, null);
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(ScreenEvent r8, ScreenData r9) {
            Intrinsics.checkNotNullParameter(r8, "event");
            Intrinsics.checkNotNullParameter(r9, "data");
            RunLog.INSTANCE.debug("RecommendManager", "event " + r8 + " , time: " + r8.getEventTime() + ", package: " + r8.getPackageName());
            if (r8.getEventType() != ScreenEvent.EventType.TOUCH) goto L6;
            b.a(b.f12763a, (ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r8, ScreenTouchEvent.class, "com.obric.memorydata.plugin"), r9.getScreenshot(), r9.getHardwareBuffer(), r9.getHeifScreenshotPath(), r9.isVertical(), r9.getViewTree());
            return;
        }
    }

    static {
        b r0 = new b();
        f12763a = r0;
        f12764b = CollectionsKt.listOf(new String[]{"com.xingin.xhs", "com.sina.weibo", "com.sankuai.meituan", "tv.danmaku.bili", "com.quark.browser", "com.ss.android.article.news", "com.autonavi.minimap"});
        c = r0.e();
        d = MapsKt.mapOf(TuplesKt.to("com.larus.nova", CollectionsKt.listOf(BuildConfig.LIBRARY_PACKAGE_NAME)));
        e = r0.h();
        AppStateEventRule r1 = new AppStateEventRule(AppStateEvent.AppState.OPEN);
        r1.setTargetPackages(c);
        f = new ScreenEventReaction(null, (ScreenEventRule) ZeusTransformUtils.preCheckCast(r1, ScreenEventRule.class, "com.obric.memorydata.plugin"), null, 5, null);
        g = r0.i();
        h = r0.j();
        i = j.a();
        al r5 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        k = r5;
        l = new ConcurrentHashMap();
        Function1 r8 = null;
        g r2 = new g(null, r8, null, null, null, null, 63, null);
        m = r2;
        com.obric.memorydata.recommend.screenshotupload.sampling.b r3 = new com.obric.memorydata.recommend.screenshotupload.sampling.b(r5, com.obric.memorydata.recommend.screenshotupload.sampling.f.f12589a.a(), r2, null, null, 24, null);
        n = r3;
        o = new com.obric.memorydata.recommend.screenshotupload.sampling.a((com.obric.memorydata.recommend.screenshotupload.sampling.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.screenshotupload.sampling.c.class, "com.obric.memorydata.plugin"), null, null, null, null, null, false, WebSocketProtocol.PAYLOAD_SHORT, null);
        p = new k((com.obric.memorydata.recommend.screenshotupload.sampling.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.recommend.screenshotupload.sampling.c.class, "com.obric.memorydata.plugin"), null, null, null, null, null, false, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    private b() {
    }

    static /* synthetic */ ScreenshotOption a(b r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.a(r1);
    }

    private final ScreenshotOption a(boolean r1) {
        return com.obric.memorydata.recommend.screenshotupload.sampling.d.f12586a.a(r1);
    }

    public static final /* synthetic */ List a(b r0) {
        return r0.e();
    }

    private static final Unit a(com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        p.a(r1);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(b r7, ScreenTouchEvent r8, Bitmap r9, HardwareBuffer r10, String r11, boolean r12, List r13) {
        r7.a(r8, r9, r10, r11, r12, (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(b r0, String r1, String r2, long r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(b r10, String r11, String r12, Bitmap r13, String r14, long r15, boolean r17, List r18) {
        r10.a(r11, r12, r13, r14, r15, r17, (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(b r0, boolean r1) {
        r0.b(r1);
    }

    private final void a(ScreenTouchEvent r22, Bitmap r23, HardwareBuffer r24, String r25, boolean r26, List<ViewTreeNode> r27) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        String r2 = r22.getAppName();
        String r3 = r22.getPackageName();
        long r4 = r22.getEventTime();
        TriggerUploadType r6 = TriggerUploadType.Action;
        ScreenTouchEvent.TouchAction r12 = r22.getAction();
        com.obric.memorydata.recommend.useraction.recommend.a r13 = new com.obric.memorydata.recommend.useraction.recommend.a(r22.getTouchInfo().getX(), r22.getTouchInfo().getY());
        TouchInfo r1 = r22.getEndTouchInfo();
        if (r1 != null) goto L6;
        r1 = r22.getTouchInfo();
    L6:
        float r5 = r1.getX();
        TouchInfo r7 = r22.getEndTouchInfo();
        if (r7 != null) goto L10;
        r7 = r22.getTouchInfo();
    L10:
        ScreenshotData r0 = new ScreenshotData(new ScreenshotInputData(r2, r3, r4, r6, r23, r25, null, r10, r24, r12, r13, new com.obric.memorydata.recommend.useraction.recommend.a(r5, r7.getY()), r22.getScrollDirection(), r26, null, 16448, null), new ScreenshotOutputData(null, new ScreenshotContextData(r22.getEventTime(), com.obric.memorydata.recommend.context.b.a()), null, 5, null));
        i.f12559a.a(r0);
    }

    private final void a(String r28, String r29, long r30) {
        ScreenshotData r14 = new ScreenshotData(new ScreenshotInputData(r28, r29, r30, TriggerUploadType.AppOpen, null, null, null, null, null, null, null, null, null, false, null, 32752, null), new ScreenshotOutputData(null, new ScreenshotContextData(System.currentTimeMillis(), com.obric.memorydata.recommend.context.b.a()), null, 5, null));
        ((Map) ZeusTransformUtils.preCheckCast(l, Map.class, "com.obric.memorydata.plugin")).put(r29, kotlinx.coroutines.i.a(k, null, null, (Function2) ZeusTransformUtils.preCheckCast(new RecommendManager$onAppOpen$1(r14, r29, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
    }

    private final void a(String r23, String r24, Bitmap r25, String r26, long r27, boolean r29, List<ViewTreeNode> r30) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        ScreenshotData r12 = new ScreenshotData(new ScreenshotInputData(r23, r24, r27, TriggerUploadType.AppClose, r25, r26, null, r9, null, null, null, null, null, r29, null, 24384, null), new ScreenshotOutputData(null, new ScreenshotContextData(System.currentTimeMillis(), com.obric.memorydata.recommend.context.b.a()), null, 5, null));
        ConcurrentHashMap<String, bx> r0 = l;
        if (r0.get(r24) == null) goto L9;
        bx r1 = (bx) ZeusTransformUtils.preCheckCast(r0.get(r24), bx.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        bx.a.a(r1, null, 1, null);
    L7:
        r0.remove(r24);
        return;
    L9:
        i.f12559a.a(r12);
    }

    private final void a(Map<String, ? extends List<String>> r2) {
        Map<String, ? extends List<String>> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        d = r1;
        e.getRule().setBlackActivityPrefixes(r1);
        h.getRule().setBlackActivityPrefixes(r1);
        f.getRule().setBlackActivityPrefixes(r1);
        g.getRule().setBlackActivityPrefixes(r1);
    }

    public static final /* synthetic */ com.obric.memorydata.recommend.screenshotupload.sampling.a b() {
        return o;
    }

    public static final /* synthetic */ void b(b r0) {
        r0.m();
    }

    private final void b(boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "recommend enableStateChange: " + r8, false, 4, null);
        boolean r0 = false;
        if (r8 == false) goto L10;
        o();
        o.a(true);
        h r7 = u();
        k r9 = p;
        if (r7 == null) goto L7;
        r0 = true;
    L7:
        r9.a(r0);
        if (r7 == null) goto L15;
        r7.a();
        return;
    L15:
        return;
    L10:
        h r10 = q;
        if (r10 == null) goto L13;
        r10.b();
    L13:
        p.a(false);
        o.a(false);
        p();
    }

    public static final /* synthetic */ k c() {
        return p;
    }

    public static final /* synthetic */ ConcurrentHashMap d() {
        return l;
    }

    private final List<String> e() {
        List r3 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.screenshotupload.b.f12542a.b(), Iterable.class, "com.obric.memorydata.plugin"));
        if (AppContext.INSTANCE.isDebug() == false) goto L6;
        r3 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(f12764b, Iterable.class, "com.obric.memorydata.plugin"));
    L6:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final ViewTreeOption f() {
        return new ViewTreeOption(false, 1000);
    }

    private final ViewTreeOption g() {
        if (j.a() == true) goto L7;
        return null;
    L7:
        return f();
    }

    private final ScreenEventReaction h() {
        ScreenTouchEventRule r0 = new ScreenTouchEventRule(CollectionsKt.listOf(new ScreenTouchEvent.TouchAction[]{ScreenTouchEvent.TouchAction.TAP, ScreenTouchEvent.TouchAction.LONG_PRESS, ScreenTouchEvent.TouchAction.SCROLLED, ScreenTouchEvent.TouchAction.BACK_KEY, ScreenTouchEvent.TouchAction.DOUBLE_TAP}), 1);
        r0.setTargetPackages(c);
        r0.setBlackActivityPrefixes(d);
        return new ScreenEventReaction(null, (ScreenEventRule) ZeusTransformUtils.preCheckCast(r0, ScreenEventRule.class, "com.obric.memorydata.plugin"), new TaskOptions(a(this, false, 1, null), g()), 1, null);
    }

    private final ScreenEventReaction i() {
        AppStateEventRule r0 = new AppStateEventRule(AppStateEvent.AppState.CLOSE);
        r0.setTargetPackages(c);
        r0.setBlackActivityPrefixes(d);
        return new ScreenEventReaction(null, (ScreenEventRule) ZeusTransformUtils.preCheckCast(r0, ScreenEventRule.class, "com.obric.memorydata.plugin"), new TaskOptions(a(true), g()), 1, null);
    }

    private final ScreenEventReaction j() {
        InputMethodEventRule r0 = new InputMethodEventRule(false);
        r0.setTargetPackages(c);
        r0.setBlackActivityPrefixes(d);
        return new ScreenEventReaction(null, (ScreenEventRule) ZeusTransformUtils.preCheckCast(r0, ScreenEventRule.class, "com.obric.memorydata.plugin"), new TaskOptions(a(this, false, 1, null), g()), 1, null);
    }

    private final List<ScreenEventReaction> k() {
        return CollectionsKt.listOf(new ScreenEventReaction[]{e, h, g});
    }

    private final List<ScreenEventReaction> l() {
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(k(), Collection.class, "com.obric.memorydata.plugin"), f);
    }

    public static /* synthetic */ Unit lambda$3nOQJDYqTj4SXL_iizXdemjFUQ4(com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r0) {
        return a(r0);
    }

    private final synchronized void m() {
        monitor-enter(this);
        boolean r0 = j.a();     // Catch: Throwable -> L10
        if (i != r0) goto L7;
        monitor-exit(this);
        return;
    L7:
        i = r0;     // Catch: Throwable -> L10
        n();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void n() {
        List<ScreenEventReaction> r0 = k();
        boolean r1 = j;
        if (r1 == false) goto L8;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        ScreenCaptureManager.INSTANCE.unregister((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r2.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin"));
    L8:
        e = h();
        g = i();
        h = j();
        a(c);
        a(d);
        if (r1 == false) goto L11;
        t();
        s();
        q();
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "refresh screenshot reactions viewTreeEnabled=" + i + " registered=" + r1, false, 4, null);
    }

    private final synchronized void o() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (j == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        RunLog.INSTANCE.debug("RecommendManager", "begin");     // Catch: Throwable -> L10
        a(e());     // Catch: Throwable -> L10
        t();     // Catch: Throwable -> L10
        r();     // Catch: Throwable -> L10
        s();     // Catch: Throwable -> L10
        q();     // Catch: Throwable -> L10
        com.obric.memorydata.recommend.c.a.f12500a.c();     // Catch: Throwable -> L10
        ContextManager.INSTANCE.run();     // Catch: Throwable -> L10
        com.obric.memorydata.recommend.screenshotupload.a.b.f12540a.a();     // Catch: Throwable -> L10
        j = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private final synchronized void p() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (j == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        RunLog.INSTANCE.debug("RecommendManager", "stop");     // Catch: Throwable -> L14
        Iterator<ScreenEventReaction> r0 = l().iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        ScreenEventReaction r1 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r0.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        ScreenCaptureManager.INSTANCE.unregister(r1);     // Catch: Throwable -> L14
        goto L9
    L11:
        com.obric.memorydata.recommend.c.a.f12500a.d();     // Catch: Throwable -> L14
        ContextManager.INSTANCE.stop();     // Catch: Throwable -> L14
        j = false;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    private final void q() {
        ScreenCaptureManager.register$default(ScreenCaptureManager.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), h, (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.preCheckCast(new e(), com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin"), 0, 8, null);
    }

    private final void r() {
        ScreenCaptureManager.register$default(ScreenCaptureManager.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), f, (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.preCheckCast(new d(), com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin"), 0, 8, null);
    }

    private final void s() {
        ScreenCaptureManager.register$default(ScreenCaptureManager.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), g, (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.preCheckCast(new c(), com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin"), 0, 8, null);
    }

    private final void t() {
        ScreenCaptureManager.register$default(ScreenCaptureManager.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), e, (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.preCheckCast(new f(), com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin"), 0, 8, null);
    }

    private final synchronized h u() {
        monitor-enter(this);
        h r0 = q;     // Catch: Throwable -> L31
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.c r2 = null;
        if (com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.i.a(com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.i.f12574a, null, 1, null) == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "AIMedia events service available, enable video playback sampling", false, 4, null);     // Catch: Throwable -> L31
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Object r4 = Result.m1421constructorimpl(new com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.c(k, null, $$Lambda$b$3nOQJDYqTj4SXL_iizXdemjFUQ4.INSTANCE, 2, null));     // Catch: Throwable -> L17
    L19:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);     // Catch: Throwable -> L31
        if (r5 == null) goto L23;
        RunLog.INSTANCE.warn("RecommendManager", "create AIMedia monitor failed", r5);     // Catch: Throwable -> L31
    L23:
        if (Result.m1427isFailureimpl(r4) == false) goto L25;
        r4 = null;
    L25:
        com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.c r6 = (com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.c) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r6 == null) goto L28;
        q = (h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        r2 = r6;
    L28:
        h r7 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        monitor-exit(this);
        return r7;
    L17:
        th = move-exception;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L31
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
        goto L19
    L10:
        if (r == true) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "AIMedia events service unavailable, skip video playback sampling", false, 4, null);     // Catch: Throwable -> L31
        r = true;     // Catch: Throwable -> L31
    L12:
        monitor-exit(this);
        return null;
    L31:
        th = move-exception;
        throw th;
    }

    public final void a() {
        com.obric.memorydata.recommend.screenshotupload.b.f12542a.a((com.obric.memorydata.recommend.screenshotupload.b.a) ZeusTransformUtils.preCheckCast(new a(), com.obric.memorydata.recommend.screenshotupload.b.a.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.f((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(t.f12630a.e(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new RecommendManager$init$2(null), Function2.class, "com.obric.memorydata.plugin")), k);
        SettingsManager.INSTANCE.registerChangeListener("recommend_settings", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(new C0687b(), SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        boolean r1 = true;
        if (((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
    L8:
        b(r1);
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.a.a.f12495a, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        UserSettings.INSTANCE.registerAgreePrivacyListener((com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.a.a.f12495a, com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin"));
        a(d);
        return;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.screenshotupload.b.f12542a.b(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L8;
        r1 = false;
        goto L8
    }

    public final void a(List<String> r3) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, Constants.KEY_LIST);
        RunLog.INSTANCE.debug("RecommendManager", "updateEnableApps " + r2);
        c = r2;
        e.getRule().setTargetPackages(r2);
        h.getRule().setTargetPackages(r2);
        f.getRule().setTargetPackages(r2);
        g.getRule().setTargetPackages(r2);
    }
}
