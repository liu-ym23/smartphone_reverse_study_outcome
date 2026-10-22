package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IDependency;
import com.ss.android.lark.chameleon.IMonitorDependency;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.BlankScreenConfig;
import com.ss.android.lark.officewebview.quality.PixelCopyCropRectConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0002)1\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00107\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00108\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00109\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u0014H\u0002J\u0012\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u0005H\u0002J\b\u0010>\u001a\u000204H\u0002J\b\u0010?\u001a\u000204H\u0002J\b\u0010@\u001a\u000204H\u0002J\b\u0010A\u001a\u000204H\u0002J$\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00122\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010F\u001a\u00020\u0005H\u0002J\b\u0010G\u001a\u00020\u001eH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u0006I"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/BlankPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "tag", BuildConfig.FLAVOR, "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "manager", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/BlankScreenManager;", "blankSetting", "Lcom/ss/android/lark/officewebview/quality/BlankScreenConfig;", "enableDetection", BuildConfig.FLAVOR, "enableDetectionWhenAppear", "blankRateThreshold", BuildConfig.FLAVOR, "checkIntervalWhenPause", BuildConfig.FLAVOR, "checkIntervalWhenResume", "replaceWebview", "dropOnFastEntry", "checkEnterTimeWindow", BuildConfig.FLAVOR, "enablePixelCopyBlankCapture", "hasCheckBlank", "hasPendingBlankCheck", "webviewStatus", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/WebViewStatus;", "captureMethod", "openTime", "detectCount", "loadState", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/LoadState;", "isLoadSuccessByJS", "hasRenderGone", "appearBlankCheckRunnable", "Ljava/lang/Runnable;", "renderGoneListener", "com/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/BlankPlugin$renderGoneListener$1", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/BlankPlugin$renderGoneListener$1;", "exitTimesList", BuildConfig.FLAVOR, "thresholdMillis", "maxExits", "timeWindowMillis", "refreshObserver", "com/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/BlankPlugin$refreshObserver$1", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/BlankPlugin$refreshObserver$1;", "onAttachToHost", BuildConfig.FLAVOR, "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onResume", "onPause", "onDetachFromHost", "checkBlank", "minDurationMs", "checkBlankByOldDraw", "method", "scheduleBlankCheckWhenAppear", "cancelPendingBlankCheck", "refresh", "checkQuickExitAndRefresh", "report", "isBlank", "blankRate", ChameleonOpenTracker.ParamKey.ERRORMSG, "getWebViewUrl", "getWebViewStatus", "Companion", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlankPlugin extends AbsChameleonPlugin {
    private static final String CAPTURE_METHOD_OLD_DRAW = "old_draw";
    private static final String CAPTURE_METHOD_PIXEL_COPY = "pixel_copy";
    private static final String CAPTURE_METHOD_PIXEL_COPY_FALLBACK = "pixel_copy_fallback";
    public static final a Companion = null;
    private static final String PARAM_CAPTURE_METHOD = "capture_method";
    private static final String PARAM_IS_RENDER_GONE = "is_render_gone";
    private static final String PARAM_WEBVIEW_STATUS = "webview_status";
    private final Runnable appearBlankCheckRunnable;
    private final float blankRateThreshold;
    private final BlankScreenConfig blankSetting;
    private String captureMethod;
    private final int checkEnterTimeWindow;
    private final long checkIntervalWhenPause;
    private final long checkIntervalWhenResume;
    private int detectCount;
    private final boolean dropOnFastEntry;
    private final boolean enableDetection;
    private final boolean enableDetectionWhenAppear;
    private final boolean enablePixelCopyBlankCapture;
    private final List<Long> exitTimesList;
    private boolean hasCheckBlank;
    private boolean hasPendingBlankCheck;
    private boolean hasRenderGone;
    private boolean isLoadSuccessByJS;
    private LoadState loadState;
    private final com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.c manager;
    private final int maxExits;
    private long openTime;
    private final BlankPlugin$refreshObserver$1 refreshObserver;
    private final e renderGoneListener;
    private final boolean replaceWebview;
    private String tag;
    private final long thresholdMillis;
    private final long timeWindowMillis;
    private WebViewStatus webviewStatus;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BlankPlugin a;

        public b(BlankPlugin r1) {
            this.a = r1;
        }

        public final void a() {
            BlankPlugin.access$setHasPendingBlankCheck$p(this.a, false);
            if (BlankPlugin.access$getEnableDetection$p(this.a) == true) goto L5;
        L13:
            j.e(this.a.getTag(), "skip appear blank check, enableDetection:" + BlankPlugin.access$getEnableDetection$p(this.a) + " enableDetectionWhenAppear:" + BlankPlugin.access$getEnableDetectionWhenAppear$p(this.a));
            return;
        L5:
            if (BlankPlugin.access$getEnableDetectionWhenAppear$p(this.a) == false) goto L13;
            if (BlankPlugin.access$getHasCheckBlank$p(this.a) == false) goto L11;
            j.e(this.a.getTag(), "skip appear blank check, already checked");
            return;
        L11:
            j.e(this.a.getTag(), "run appear blank check");
            BlankPlugin r0 = this.a;
            BlankPlugin.access$checkBlank(r0, BlankPlugin.access$getCheckIntervalWhenResume$p(r0) * ((long) 1000));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.a {
        public final /* synthetic */ BlankPlugin a;

        public c(BlankPlugin r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.a
        public final void a(Float r7) {
            float r2 = r7.floatValue();
            if (r2 < BlankPlugin.access$getBlankRateThreshold$p(this.a)) goto L5;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L8;
            int r1 = BlankParam.BLANK.getType();
        L9:
            j.e(this.a.getTag(), "check result, isBlank:" + r8 + ",blankRate:" + r2 + ", result:" + r1 + ", loadState:" + BlankPlugin.access$getLoadState$p(this.a) + ", isSuccess:" + BlankPlugin.access$isLoadSuccessByJS$p(this.a) + ", webview:" + BlankPlugin.access$getWebviewStatus$p(this.a) + ", detectCount:" + BlankPlugin.access$getDetectCount$p(this.a) + ", hasRenderGone:" + BlankPlugin.access$getHasRenderGone$p(this.a) + ", threshold:" + BlankPlugin.access$getBlankRateThreshold$p(this.a) + ", ");
            if (r1 == BlankParam.NORMAL.getType()) goto L12;
            BlankPlugin.access$refresh(this.a);
        L12:
            BlankPlugin.access$setHasCheckBlank$p(this.a, false);
            BlankPlugin.report$default(this.a, r1, r2, null, 4, null);
            return;
        L8:
            r1 = BlankParam.NORMAL.getType();
            goto L9
        L5:
            r8 = false;
            goto L6
        }

        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.a
        public final void b(String r4) {
            j.b(this.a.getTag(), "blank check err: " + r4);
            BlankPlugin.access$setHasCheckBlank$p(this.a, false);
            BlankPlugin.access$report(this.a, BlankParam.ERROR.getType(), -1.0f, r4);
        }
    }

    public static final class d implements IChameleonLoader.LoadingCallback {
        public final /* synthetic */ BlankPlugin a;

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadStart() {
            BlankPlugin.access$setLoadState$p(this.a, LoadState.START);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadSuccess() {
            BlankPlugin.access$setLoadState$p(this.a, LoadState.SUCCESS);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadSuccessByJS() {
            BlankPlugin.access$setLoadSuccessByJS$p(this.a, true);
            BlankPlugin.access$setLoadState$p(this.a, LoadState.SUCCESS);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final boolean getKeepOnRelease() {
            return IChameleonLoader.LoadingCallback.DefaultImpls.getKeepOnRelease(this);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        @Deprecated(message = "已废弃，使用IRenderGoneListener")
        public final void onRenderProcessGone() {
            IChameleonLoader.LoadingCallback.DefaultImpls.onRenderProcessGone(this);
        }

        public d(BlankPlugin r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onPageStarted(String r2) {
            BlankPlugin.access$setLoadState$p(this.a, LoadState.PAGE_STARTED);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadFail(int r1, Throwable r2) {
            BlankPlugin.access$setLoadState$p(this.a, LoadState.FAIL);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadFailByJS(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, IPortraitService.TYPE);
            BlankPlugin.access$setLoadSuccessByJS$p(this.a, false);
            BlankPlugin.access$setLoadState$p(this.a, LoadState.FAIL);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onReceivedTitle(WebView r1, String r2) {
            IChameleonLoader.LoadingCallback.DefaultImpls.onReceivedTitle(this, r1, r2);
        }
    }

    public static final class e implements k.a {
        public final /* synthetic */ BlankPlugin a;

        public e(BlankPlugin r1) {
            this.a = r1;
        }

        public final void a(boolean r4, int r5) {
            BlankPlugin.access$setHasRenderGone$p(this.a, true);
            j.e(this.a.getTag(), "cml onRenderProcessGone didCrash:" + r4 + " rendererPriority:" + r5);
        }
    }

    static {
        Companion = new a();
    }

    private final void cancelPendingBlankCheck() {
        if (this.hasPendingBlankCheck == true) goto L5;
        return;
    L5:
        Lazy r0 = ThreadUtil.a;
        ThreadUtil.a.e(this.appearBlankCheckRunnable);
        this.hasPendingBlankCheck = false;
        j.e(this.tag, "cancel pending appear blank check");
    }

    private final void checkQuickExitAndRefresh() {
        if (this.dropOnFastEntry == true) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.openTime;
        j.e(this.tag, "checkQuickExitAndRefresh, " + r2);
        if (r2 >= this.thresholdMillis) goto L11;
        this.exitTimesList.add(Long.valueOf(r0));
        final long r1 = r0 - this.timeWindowMillis;
        CollectionsKt.removeAll(this.exitTimesList, new AnonymousClass1(r1));
        if (this.exitTimesList.size() < this.maxExits) goto L12;
        j.e(this.tag, "exit time limit and refresh");
        this.hasCheckBlank = false;
        this.exitTimesList.clear();
        return;
    L12:
        return;
    }

    private final String getWebViewUrl() {
        String r0 = BuildConfig.FLAVOR;
        ChameleonPluginHost r1 = getHost();     // Catch: Exception -> L22
        if (r1 == null) goto L10;
        k r2 = r1.getWeb();     // Catch: Exception -> L22
        if (r2 == null) goto L10;
        WebView r3 = r2.getWebView();     // Catch: Exception -> L22
        if (r3 == null) goto L10;
        String r4 = r3.getUrl();     // Catch: Exception -> L22
    L11:
        if (r4 != null) goto L26;
        ChameleonPluginHost r5 = getHost();     // Catch: Exception -> L22
        if (r5 == null) goto L21;
        ChameleonConfig r6 = r5.getChameleonConfig();     // Catch: Exception -> L22
        if (r6 == null) goto L21;
        String r7 = r6.getLoadUrl();     // Catch: Exception -> L22
        if (r7 == null) goto L21;
        r0 = r7;
    L21:
        return r0;
    L26:
        return r4;
    L10:
        r4 = null;
    L22:
        j.b(this.tag, "getWebViewUrl error");
        return BuildConfig.FLAVOR;
    }

    private final void refresh() {
        if (this.replaceWebview == true) goto L16;
        return;
    L16:
        ChameleonPluginHost r0 = getHost();     // Catch: Throwable -> L13
        if (r0 == null) goto L18;
        Fragment r1 = r0.getFragment();     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
        Lifecycle r2 = r1.getLifecycle();     // Catch: Throwable -> L13
        if (r2 == null) goto L20;
        r2.addObserver(this.refreshObserver);     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L13:
        th = move-exception;
        j.c(this.tag, "refresh:", th);
    }

    private final void scheduleBlankCheckWhenAppear() {
        if (this.hasCheckBlank == false) goto L7;
        j.e(this.tag, "scheduleBlankCheckWhenAppear skip, already checked");
        return;
    L7:
        if (this.hasPendingBlankCheck == false) goto L10;
        j.e(this.tag, "scheduleBlankCheckWhenAppear skip, task already pending");
        return;
    L10:
        this.hasPendingBlankCheck = true;
        j.e(this.tag, "scheduleBlankCheckWhenAppear delay:" + this.checkIntervalWhenResume + 's');
        Lazy r0 = ThreadUtil.a;
        ThreadUtil.a.d(this.appearBlankCheckRunnable, this.checkIntervalWhenResume * ((long) 1000));
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.BlankPlugin$refreshObserver$1] */
    public BlankPlugin() {
        this.tag = "CML_TAG_BlankPlugin";
        this.manager = new com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.c();
        WebViewOptimizeConfig r0 = ixb.a.a;
        if (r0 == null) goto L5;
        BlankScreenConfig r1 = r0.getBlankScreen();
    L6:
        this.blankSetting = r1;
        boolean r2 = false;
        if (r1 == null) goto L9;
        boolean r3 = r1.getEnableDetection();
    L10:
        this.enableDetection = r3;
        if (r1 == null) goto L13;
        boolean r4 = r1.getEnableDetectionWhenAppear();
    L14:
        this.enableDetectionWhenAppear = r4;
        if (r1 == null) goto L17;
        float r5 = r1.getBlankThreshold();
    L18:
        this.blankRateThreshold = r5;
        long r6 = 2;
        if (r1 == null) goto L21;
        long r7 = r1.getMinCheckInterval();
    L22:
        this.checkIntervalWhenPause = r7;
        if (r1 == null) goto L25;
        long r8 = r1.getMinCheckIntervalWhenAppear();
    L26:
        this.checkIntervalWhenResume = r8;
        if (r1 == null) goto L29;
        boolean r9 = r1.getReplaceWebview();
    L30:
        this.replaceWebview = r9;
        if (r1 == null) goto L33;
        boolean r10 = r1.getDropOnFastEntry();
    L34:
        this.dropOnFastEntry = r10;
        if (r1 == null) goto L37;
        int r11 = r1.getCheckEnterTimeWindow();
    L38:
        this.checkEnterTimeWindow = r11;
        if (r1 == null) goto L41;
        r2 = r1.getEnablePixelCopyBlankCapture();
    L41:
        this.enablePixelCopyBlankCapture = r2;
        this.webviewStatus = WebViewStatus.UN_KNOWN;
        this.captureMethod = CAPTURE_METHOD_OLD_DRAW;
        this.loadState = LoadState.NONE;
        this.appearBlankCheckRunnable = new b(this);
        this.renderGoneListener = new e(this);
        this.exitTimesList = new ArrayList();
        if (r1 == null) goto L44;
        r6 = r1.getMinCheckInterval();
    L44:
        this.thresholdMillis = r6 * ((long) 1000);
        this.maxExits = 3;
        this.timeWindowMillis = ((long) r11) * 1000;
        this.refreshObserver = new BlankPlugin$refreshObserver$1(this);
        return;
    L37:
        r11 = 30;
        goto L38
    L33:
        r10 = false;
        goto L34
    L29:
        r9 = false;
        goto L30
    L25:
        r8 = 3;
        goto L26
    L21:
        r7 = 2;
        goto L22
    L17:
        r5 = 0.99f;
        goto L18
    L13:
        r4 = true;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final WebViewStatus getWebViewStatus() {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L7;
        k r1 = r0.getWeb();
        if (r1 == null) goto L7;
        WebView r2 = r1.getWebView();
    L9:
        if ((r2 instanceof OfficeWebView) == false) goto L11;
        OfficeWebView r3 = (OfficeWebView) r2;
        if (r3.getWebViewIsDestroy() == false) goto L17;
        return WebViewStatus.DESTROY;
    L17:
        if (r3.isAttachedToWindow() == true) goto L21;
        return WebViewStatus.UN_ATTACHED;
    L21:
        if (r3.isShown() == true) goto L25;
        return WebViewStatus.UN_SHOWN;
    L25:
        return WebViewStatus.NORMAL;
    L11:
        return WebViewStatus.UN_KNOWN;
    L7:
        r2 = null;
        goto L9
    }

    public final String getTag() {
        return this.tag;
    }

    public static final /* synthetic */ float access$getBlankRateThreshold$p(BlankPlugin r0) {
        return r0.blankRateThreshold;
    }

    public static final /* synthetic */ long access$getCheckIntervalWhenResume$p(BlankPlugin r2) {
        return r2.checkIntervalWhenResume;
    }

    public static final /* synthetic */ int access$getDetectCount$p(BlankPlugin r0) {
        return r0.detectCount;
    }

    public static final /* synthetic */ boolean access$getEnableDetection$p(BlankPlugin r0) {
        return r0.enableDetection;
    }

    public static final /* synthetic */ boolean access$getEnableDetectionWhenAppear$p(BlankPlugin r0) {
        return r0.enableDetectionWhenAppear;
    }

    public static final /* synthetic */ boolean access$getHasCheckBlank$p(BlankPlugin r0) {
        return r0.hasCheckBlank;
    }

    public static final /* synthetic */ boolean access$getHasRenderGone$p(BlankPlugin r0) {
        return r0.hasRenderGone;
    }

    public static final /* synthetic */ LoadState access$getLoadState$p(BlankPlugin r0) {
        return r0.loadState;
    }

    public static final /* synthetic */ WebViewStatus access$getWebviewStatus$p(BlankPlugin r0) {
        return r0.webviewStatus;
    }

    public static final /* synthetic */ boolean access$isLoadSuccessByJS$p(BlankPlugin r0) {
        return r0.isLoadSuccessByJS;
    }

    public static final /* synthetic */ void access$refresh(BlankPlugin r0) {
        r0.refresh();
    }

    private final boolean checkBlank(long r8) {
        j.e(this.tag, "checkBlank");     // Catch: Exception -> L57
        long r3 = System.currentTimeMillis() - this.openTime;     // Catch: Exception -> L57
        if (r3 >= r8) goto L8;
        j.e(this.tag, "time too short, " + r3);     // Catch: Exception -> L57
        return false;
    L8:
        if (com.ss.android.lark.chameleonv2.container.webcontainer.util.d.a() == false) goto L11;
        j.e(this.tag, "low memory");     // Catch: Exception -> L57
        return false;
    L11:
        this.hasCheckBlank = true;     // Catch: Exception -> L57
        this.webviewStatus = getWebViewStatus();     // Catch: Exception -> L57
        j.e(this.tag, "checkBlank start");     // Catch: Exception -> L57
        PixelCopyCropRectConfig r1 = null;
        if (this.enablePixelCopyBlankCapture == true) goto L16;
        return checkBlankByOldDraw$default(this, null, 1, null);
    L16:
        if (Build.VERSION.SDK_INT >= 26) goto L19;
        j.e(this.tag, "pixel copy unsupported api, fallback old draw");     // Catch: Exception -> L57
        this.captureMethod = CAPTURE_METHOD_PIXEL_COPY_FALLBACK;     // Catch: Exception -> L57
        return checkBlankByOldDraw(CAPTURE_METHOD_PIXEL_COPY_FALLBACK);
    L19:
        ChameleonPluginHost r9 = getHost();     // Catch: Exception -> L57
        if (r9 == null) goto L24;
        k r10 = r9.getWeb();     // Catch: Exception -> L57
        if (r10 == null) goto L24;
        WebView r11 = r10.getWebView();     // Catch: Exception -> L57
    L25:
        if (r11 != null) goto L28;
        j.e(this.tag, "webView is null");     // Catch: Exception -> L57
        this.hasCheckBlank = false;     // Catch: Exception -> L57
        return false;
    L28:
        ChameleonPluginHost r0 = getHost();     // Catch: Exception -> L57
        if (r0 == null) goto L33;
        Fragment r2 = r0.getFragment();     // Catch: Exception -> L57
        if (r2 == null) goto L33;
        FragmentActivity r4 = r2.getActivity();     // Catch: Exception -> L57
    L34:
        if (r4 != null) goto L36;
    L55:
        j.e(this.tag, "activity not available for pixel copy");     // Catch: Exception -> L57
        this.hasCheckBlank = false;     // Catch: Exception -> L57
        return false;
    L36:
        if (r4.isFinishing() == true) goto L55;
        if (r4.isDestroyed() == true) goto L55;
        ChameleonPluginHost r5 = getHost();     // Catch: Exception -> L57
        if (r5 == null) goto L45;
        ChameleonConfig r6 = r5.getChameleonConfig();     // Catch: Exception -> L57
        if (r6 == null) goto L45;
        String r7 = r6.getBizName();     // Catch: Exception -> L57
    L46:
        if (r7 != null) goto L48;
        r7 = BuildConfig.FLAVOR;
    L48:
        BlankScreenConfig r12 = this.blankSetting;     // Catch: Exception -> L57
        if (r12 == null) goto L53;
        Map r13 = r12.getPixelCopyCropRectByBiz();     // Catch: Exception -> L57
        if (r13 == null) goto L53;
        r1 = (PixelCopyCropRectConfig) r13.get(r7);     // Catch: Exception -> L57
    L53:
        this.captureMethod = CAPTURE_METHOD_PIXEL_COPY;     // Catch: Exception -> L57
        this.manager.e(r11, r4.getWindow(), r1, r7);     // Catch: Exception -> L57
        return true;
    L45:
        r7 = null;
    L33:
        r4 = null;
    L24:
        r11 = null;
    L57:
        e = move-exception;
        this.hasCheckBlank = false;
        j.e(this.tag, "checkBlank error, e=" + e);
        return false;
    }

    private final boolean checkBlankByOldDraw(String r8) {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L5;
        ViewGroup r1 = r0.getContainer(ContainerType.Web.getValue());
    L6:
        if (r1 != null) goto L9;
        j.e(this.tag, "captureView is null");
        this.hasCheckBlank = false;
        return false;
    L9:
        this.captureMethod = r8;
        com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.c r9 = this.manager;
        r9.getClass();
        long r3 = System.currentTimeMillis();
        Bitmap r2 = com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.c.c(r1);     // Catch: Throwable -> L19
        if (r2 != null) goto L15;
        j.b("CML_TAG_BlankScreenManager", "checkBlankScreen error, capture view is null. ");     // Catch: Throwable -> L19
        com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.a r4 = r9.f;     // Catch: Throwable -> L19
        if (r4 == null) goto L25;
        r4.b("capture view is null");     // Catch: Throwable -> L19
    L25:
        return true;
    L15:
        r9.b = System.currentTimeMillis() - r3;     // Catch: Throwable -> L19
        r9.d(r2);     // Catch: Throwable -> L19
        r9.c = System.currentTimeMillis() - r3;     // Catch: Throwable -> L19
        j.e("CML_TAG_BlankScreenManager", "checkBlankScreen cap cost: " + r9.b + ", total cost: " + r9.c);     // Catch: Throwable -> L19
        com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.a r5 = r9.f;     // Catch: Throwable -> L19
        if (r5 == null) goto L25;
        r5.a(Float.valueOf(r9.a));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        j.b("CML_TAG_BlankScreenManager", "checkBlankScreen error. " + th.getMessage());
        com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.a r10 = r9.f;
        if (r10 == null) goto L29;
        r10.b(th.getMessage());
        return true;
    L29:
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public void onAttachToHost(ChameleonPluginHost r6) {
        super.onAttachToHost(r6);
        if (r6 == null) goto L9;
        ChameleonConfig r0 = r6.getChameleonConfig();
        if (r0 == null) goto L9;
        String r1 = r0.getBizName();
        if (r1 == null) goto L9;
        this.tag = "BlankPlugin_".concat(r1);
    L9:
        String r2 = this.tag;
        StringBuilder r3 = new StringBuilder("onAttachToHost, bizName:");
        Integer r4 = null;
        if (r6 == null) goto L14;
        ChameleonConfig r5 = r6.getChameleonConfig();
        if (r5 == null) goto L14;
        String r7 = r5.getBizName();
    L15:
        r3.append(r7);
        j.e(r2, r3.toString());
        this.manager.f = new c(this);
        String r8 = this.tag;
        StringBuilder r9 = new StringBuilder("blankSetting, enableDetection:");
        r9.append(this.enableDetection);
        r9.append(", enableDetectionWhenAppear:");
        r9.append(this.enableDetectionWhenAppear);
        r9.append(", blankRateThreshold:");
        r9.append(this.blankRateThreshold);
        r9.append(", checkInterval:");
        r9.append(this.checkIntervalWhenPause);
        r9.append(", checkIntervalWhenAppear:");
        r9.append(this.checkIntervalWhenResume);
        r9.append(", replaceWebview:");
        r9.append(this.replaceWebview);
        r9.append(", dropOnFastEntry:");
        r9.append(this.dropOnFastEntry);
        r9.append(", enablePixelCopyBlankCapture:");
        r9.append(this.enablePixelCopyBlankCapture);
        r9.append(", enableNearBlankPixelNormalize:");
        BlankScreenConfig r10 = this.blankSetting;
        if (r10 == null) goto L18;
        Boolean r11 = Boolean.valueOf(r10.getEnableNearBlankPixelNormalize());
    L19:
        r9.append(r11);
        r9.append(", nearBlankPixelColorThreshold:");
        BlankScreenConfig r12 = this.blankSetting;
        if (r12 == null) goto L22;
        r4 = Integer.valueOf(r12.getNearBlankPixelColorThreshold());
    L22:
        r9.append(r4);
        j.e(r8, r9.toString());
        if (r6 == null) goto L27;
        IChameleonLoader r13 = r6.getLoader();
        if (r13 == null) goto L27;
        r13.addLoadCallback(new d(this));
    L27:
        if (r6 == null) goto L32;
        k r14 = r6.getChameleonWeb();
        if (r14 == null) goto L33;
        r14.w(this.renderGoneListener);
        return;
    L33:
        return;
    L32:
        return;
    L18:
        r11 = null;
    L14:
        r7 = null;
        goto L15
    }

    public void onDetachFromHost(ChameleonPluginHost r3) {
        super.onDetachFromHost(r3);
        j.e(this.tag, "onDetachFromHost");
        cancelPendingBlankCheck();
        if (r3 == null) goto L7;
        k r0 = r3.getChameleonWeb();
        if (r0 == null) goto L7;
        r0.c(this.renderGoneListener);
    L7:
        if (r3 == null) goto L14;
        Fragment r4 = r3.getFragment();
        if (r4 == null) goto L15;
        Lifecycle r5 = r4.getLifecycle();
        if (r5 == null) goto L16;
        r5.removeObserver(this.refreshObserver);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void onPause(ChameleonPluginHost r5) {
        super.onPause(r5);
        j.e(this.tag, "onPause");
        if (this.enableDetection == true) goto L5;
    L8:
        checkQuickExitAndRefresh();
        return;
    L5:
        if (this.enableDetectionWhenAppear == false) goto L7;
        cancelPendingBlankCheck();
        goto L8
    L7:
        checkBlank(this.checkIntervalWhenPause * ((long) 1000));
        goto L8
    }

    public void onResume(ChameleonPluginHost r4) {
        super.onResume(r4);
        this.openTime = System.currentTimeMillis();
        CopyOnWriteArrayList<k.a> r5 = RenderGoneHelper.a;
        this.hasRenderGone = RenderGoneHelper.c;
        j.e(this.tag, "onResume, openTime:" + this.openTime);
        if (this.enableDetection == true) goto L5;
        return;
    L5:
        if (this.enableDetectionWhenAppear == false) goto L9;
        scheduleBlankCheckWhenAppear();
        return;
    }

    public final void setTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tag = r2;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
        onPause((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onResume(PluginHost r1) {
        onResume((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ boolean access$checkBlank(BlankPlugin r0, long r1) {
        return r0.checkBlank(r1);
    }

    public static final /* synthetic */ void access$setHasCheckBlank$p(BlankPlugin r0, boolean r1) {
        r0.hasCheckBlank = r1;
    }

    public static final /* synthetic */ void access$setHasPendingBlankCheck$p(BlankPlugin r0, boolean r1) {
        r0.hasPendingBlankCheck = r1;
    }

    public static final /* synthetic */ void access$setHasRenderGone$p(BlankPlugin r0, boolean r1) {
        r0.hasRenderGone = r1;
    }

    public static final /* synthetic */ void access$setLoadState$p(BlankPlugin r0, LoadState r1) {
        r0.loadState = r1;
    }

    public static final /* synthetic */ void access$setLoadSuccessByJS$p(BlankPlugin r0, boolean r1) {
        r0.isLoadSuccessByJS = r1;
    }

    private final void report(int r4, float r5, String r6) {
        JSONObject r0 = new JSONObject();
        ChameleonPluginHost r1 = getHost();
        if (r1 == null) goto L8;
        ChameleonConfig r2 = r1.getChameleonConfig();
        if (r2 == null) goto L8;
        String r3 = r2.getBizName();
        if (r3 == null) goto L8;
    L9:
        r0.put(ChameleonOpenTracker.ParamKey.APP_NAME, r3);
        r0.put(ChameleonOpenTracker.ParamKey.RESULT, r4);
        r0.put("blank_rate", Float.valueOf(r5));
        int r7 = 0;
        if (r6 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L19;
        r7 = -1;
    L19:
        r0.put("code", r7);
        r0.put("stay_time", System.currentTimeMillis() - this.openTime);
        r0.put("url", getWebViewUrl());
        r0.put(ChameleonOpenTracker.ParamKey.ERRORMSG, r6);
        int r9 = this.detectCount;
        this.detectCount = r9 + 1;
        r0.put("detect_count", r9);
        r0.put("load_state", this.loadState.getType());
        r0.put("is_success", this.isLoadSuccessByJS);
        r0.put(PARAM_IS_RENDER_GONE, this.hasRenderGone);
        r0.put(PARAM_WEBVIEW_STATUS, this.webviewStatus.getType());
        r0.put(PARAM_CAPTURE_METHOD, this.captureMethod);
        Map<String, u1b.a.C0305a> r10 = u1b.a.a;
        u1b.a.C0305a r11 = u1b.a.a(getSession());
        if (r11 == null) goto L37;
        ChameleonConfig r12 = r11.a;
        if (r12 == null) goto L37;
        IDependency r13 = r12.getDependency();
        if (r13 == null) goto L37;
        IMonitorDependency r14 = r13.getMonitorDependency();
        if (r14 == null) goto L37;
        Map<String, Object> r15 = r14.getBizParams((ChameleonPluginHost) getHost());
        if (r15 == null) goto L37;
        Iterator<Map.Entry<String, Object>> r16 = r15.entrySet().iterator();
    L31:
        if (r16.hasNext() == false) goto L37;
        Map.Entry<String, Object> r17 = r16.next();
        String r18 = r17.getKey();
        Object r19 = r17.getValue();
        if (r0.has(r18) == true) goto L31;
        r0.put(r18, r19);     // Catch: Exception -> L36
    L36:
        j.f(this.tag, "skip invalid biz param: " + r18);
    L37:
        u1b.b.b("webapp_blank_webview_dev", r0);
        return;
    L12:
        if (r6.length() == 0) goto L15;
        r8 = false;
    L8:
        r3 = BuildConfig.FLAVOR;
        goto L9
    }

    public static final /* synthetic */ void access$report(BlankPlugin r0, int r1, float r2, String r3) {
        r0.report(r1, r2, r3);
    }

    public static /* synthetic */ boolean checkBlankByOldDraw$default(BlankPlugin r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = CAPTURE_METHOD_OLD_DRAW;
    L6:
        return r0.checkBlankByOldDraw(r1);
    }

    public static /* synthetic */ void report$default(BlankPlugin r0, int r1, float r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = BuildConfig.FLAVOR;
    L5:
        r0.report(r1, r2, r3);
    }
}
