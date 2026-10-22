package com.lynx.tasm;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper;
import com.lynx.jsbridge.IModuleCreator;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxExposureModule;
import com.lynx.jsbridge.LynxFetchModule;
import com.lynx.jsbridge.LynxIntersectionObserverModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.jsbridge.LynxSetModule;
import com.lynx.jsbridge.LynxTextInfoModule;
import com.lynx.jsbridge.LynxUIMethodModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.frame.LynxFrameView;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.LynxLayoutProxy;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.fluency.FluencyTraceHelper;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.performance.fsp.FSPTracer;
import com.lynx.tasm.performance.longtasktiming.LynxLongTaskMonitor;
import com.lynx.tasm.recording.LynxFrameRecorder;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import com.lynx.tasm.service.security.ILynxSecurityService;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.LynxViewBuilderProperty;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxTemplateRender implements com.lynx.tasm.h, com.lynx.tasm.i, EventEmitter.b {
    private static final String EVENT_NAME_LYNX_OPEN_PAGE = "lynxsdk_open_page";
    public static final String RENDER_PHASE_SETUP = "setup";
    public static final String RENDER_PHASE_UPDATE = "update";
    private static final String TAG = "LynxTemplateRender";
    private static final boolean VSYNC_ALIGNED_FLUSH_EXP_SWITCH = false;
    private List<Map<String, Object>> componentsData;
    private TemplateData globalProps;
    private boolean mAsyncRender;
    protected UIBody.UIBodyView mBodyView;
    private com.lynx.tasm.group.d mCacheManager;
    private SparseArray<d0> mCallbackSparseArray;
    private com.lynx.tasm.base.c mCleanupReference;
    private final r1 mClient;
    private final s1 mClientV2;
    private Context mContext;
    private boolean mDestroying;
    private LynxDevtool mDevTool;
    private int mEmbeddedMode;
    private AtomicInteger mEmbeddedPipelineCounter;
    private boolean mEnableAirStrictMode;
    private boolean mEnableCacheEngine;
    private boolean mEnableGenericResourceFetcher;
    private boolean mEnableJSRuntime;
    private boolean mEnablePendingJsTask;
    private boolean mEnableReuseEngine;
    private boolean mEnableSkipUpdateViewportOnInitWhenMeasureSpecEmpty;
    private boolean mEnableSyncFlush;
    private boolean mEnableUIFlush;
    private LynxEngineProxy mEngineProxy;
    private long mFirstMeasureTime;
    private float mFontScale;
    private boolean mForceLayoutOnBackgroundThread;
    private LynxGroup mGroup;
    private boolean mHasDestroy;
    private boolean mHasEnvPrepared;
    private boolean mHasFragmentLayerRenderSyncFlushed;
    private boolean mHasPageStart;
    private boolean mHasSubmittedViewport;
    private long mInitEnd;
    private long mInitStart;
    private com.lynx.tasm.behavior.d0 mIntersectionObserverManager;
    private AtomicBoolean mIsDestroyed;
    private boolean mIsEngineFromReuse;
    private volatile boolean mIsMemoryCollecting;
    private JSProxy mJSProxy;
    private volatile LynxLayoutProxy mLayoutProxy;
    private LynxResourceLoader mLoader;
    private com.lynx.tasm.j mLogicExecutor;
    private LynxBooleanOption mLongTaskMonitorEnabled;
    private LynxContext mLynxContext;
    private LynxEngine mLynxEngineRef;
    private AtomicInteger mLynxGetDataCounter;
    protected com.lynx.tasm.q mLynxRuntimeOptions;
    private ILynxUIRenderer mLynxUIRender;
    private LynxViewBuilder mLynxViewBuilder;
    private com.lynx.tasm.group.b mLynxViewConfigProvider;
    private com.lynx.tasm.group.c mLynxViewGroup;
    private LynxModuleFactory mMainThreadModuleFactory;
    private boolean mMarkEngineInUseFlag;
    private t0 mMemoryUsageFetcher;
    protected LynxModuleFactory mModuleFactory;
    private volatile NativeFacade mNativeFacade;
    private long mNativeLifecycle;
    private long mNativePtr;
    private final Object mNativeShellLifecycleLock;
    private Map<String, String> mOriginLynxViewConfig;
    private p mPageLoadListener;
    private PerformanceController mPerformanceController;
    private int mPreHeightMeasureSpec;
    private int mPreWidthMeasureSpec;
    private volatile String mRenderPhase;
    private q0 mReportHelper;
    private LynxResourceLoader mResourceLoader;
    private LynxBackgroundRuntime mRuntime;
    private LynxSSRHelper mSSRHelper;
    private boolean mShouldUpdateViewport;
    private volatile StaticPageHost mStaticPageHost;
    private WeakReference<TasmPlatformInvoker> mTasmPlatformInvoker;
    private final z1 mTemplateAssembler;
    private TemplateBundle mTemplateBundle;
    private TemplateData mTemplateData;
    private d8a.b mTemplateProvider;
    private k8a.a mTheme;
    private ThreadStrategyForRendering mThreadStrategyForRendering;
    private String mUrl;
    private y6a.r mViewLayoutTick;
    private boolean mVsyncAlignedFlushEnabled;
    private boolean mWillContentSizeChange;
    private Map<Double, PlatformCallBack> platformCallBackMap;
    private volatile boolean reload;
    private List<TemplateData> updatedDataList;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RenderPhaseName {
    }

    public class a implements LynxEventReporter.PropsBuilder {
        public final /* synthetic */ LynxError a;
        public final /* synthetic */ LynxTemplateRender b;

        @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
        public final Map<String, Object> build() {
            HashMap r0 = new HashMap();
            r0.put(LynxResourceModule.CODE_KEY, Integer.valueOf(this.a.getErrorCode()));
            if (this.a.getLevel() != null) goto L5;
            String r1 = NameKeys.UnloadStrategy_No_Strategy;
        L6:
            r0.put(LynxUIOverlay.PROP_LEVEL, r1);
            r0.put("summary_message", this.a.getSummaryMessage());
            return r0;
        L5:
            r1 = this.a.getLevel();
            goto L6
        }

        public a(LynxTemplateRender r1, LynxError r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ LynxTemplateRender a;

        @Override // java.lang.Runnable
        public final void run() {
            LynxTemplateRender.access$2600(this.a).b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LynxTemplateRender r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ThreadStrategyForRendering.values().length];
            b = r0;
            r0[ThreadStrategyForRendering.MOST_ON_TASM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            b[ThreadStrategyForRendering.MULTI_THREADS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L22:
            b[ThreadStrategyForRendering.ALL_ON_UI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L28:
            b[ThreadStrategyForRendering.PART_ON_LAYOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r2 = new int[LynxResourceResponse.ResponseState.values().length];
            a = r2;
            r2[LynxResourceResponse.ResponseState.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L20:
            a[LynxResourceResponse.ResponseState.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public class d implements com.lynx.jsbridge.b {
        public final WeakReference<Context> a;
        public final /* synthetic */ LynxTemplateRender b;

        @Override // com.lynx.jsbridge.b
        public final void b() {
        }

        @Override // com.lynx.jsbridge.b
        public final WeakReference a() {
            return this.a;
        }

        public d(LynxTemplateRender r2) {
            this.b = r2;
            this.a = new WeakReference(LynxTemplateRender.access$200(r2));
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ q1 a;
        public final /* synthetic */ LynxTemplateRender b;

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        L18:
            return;
        L3:
            if (this.a != null) goto L5;
            return;
        L5:
            if (LynxTemplateRender.access$300(this.b) == false) goto L7;
        L8:
            LLog.i("LynxModuleFactory", "lynx invoke onLynxViewAndJSRuntimeDestroy");     // Catch: Throwable -> L10
            this.a.onLynxViewAndJSRuntimeDestroy();     // Catch: Throwable -> L10
            return;
        L7:
            if (LynxTemplateRender.access$400(this.b) == true) goto L8;
        }

        public e(LynxTemplateRender r1, q1 r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class f extends LynxModuleFactory.a {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ LynxTemplateRender b;

        public f(LynxTemplateRender r1, e r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class g implements com.lynx.jsbridge.b {
        public final WeakReference<Context> a;
        public final /* synthetic */ LynxTemplateRender b;

        @Override // com.lynx.jsbridge.b
        public final void b() {
        }

        @Override // com.lynx.jsbridge.b
        public final WeakReference a() {
            return this.a;
        }

        public g(LynxTemplateRender r2) {
            this.b = r2;
            this.a = new WeakReference(LynxTemplateRender.access$200(r2));
        }
    }

    public class h extends PlatformCallBack {
        public final /* synthetic */ LynxTemplateRender a;
        public final /* synthetic */ LynxTemplateRender b;

        @Override // com.lynx.tasm.PlatformCallBack
        public final void a(Object r3) {
            if ((r3 instanceof Number) == false) goto L5;
            final int r4 = ((Number) r3).intValue();
        L6:
            final LynxTemplateRender r0 = this.a;
            UIThreadUtils.runOnUiThread(new g1(r4, r0));
            return;
        L5:
            r4 = 0;
            goto L6
        }

        public h(LynxTemplateRender r1, LynxTemplateRender r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class i extends PlatformCallBack {
        public final /* synthetic */ LynxTemplateRender a;

        public i(LynxTemplateRender r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.PlatformCallBack
        public final void a(Object r2) {
            if ((r2 instanceof String) == false) goto L5;
            final String r3 = (String) r2;
        L6:
            UIThreadUtils.runOnUiThread(new h1(r3));
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public class j implements e8a.a<byte[]> {
        public final /* synthetic */ q a;
        public final /* synthetic */ LynxTemplateRender b;

        @Override // e8a.a
        public final void onResponse(LynxResourceResponse<byte[]> r3) {
            int r0 = c.a[r3.a.ordinal()];
            if (r0 != 1) goto L5;
            this.a.onSuccess(r3.b);
            return;
        L5:
            if (r0 != 2) goto L11;
            this.a.onFailed(r3.c.getMessage());
            return;
        }

        public j(LynxTemplateRender r1, q r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ s0 a;
        public final /* synthetic */ LynxTemplateRender b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.loadTemplate(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public k(LynxTemplateRender r1, s0 r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TemplateData c;
        public final /* synthetic */ LynxTemplateRender d;

        @Override // java.lang.Runnable
        public final void run() {
            this.d.renderSSR(this.a, this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public l(LynxTemplateRender r1, byte[] r2, String r3, TemplateData r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static class m implements Runnable {
        public long a;

        @Override // java.lang.Runnable
        public final void run() {
            long r0 = this.a;     // Catch: Throwable -> L7
            if (r0 == 0) goto L10;
            LynxTemplateRender.access$3900(r0);     // Catch: Throwable -> L7
            this.a = 0;     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }

        public m(long r1) {
            this.a = r1;
        }
    }

    public static class n implements Runnable {
        public long a;
        public long b;
        public volatile NativeFacade c;
        public LynxTemplateRender d;

        public final void a() {
            LynxTemplateRender r0 = this.d;
            if (this.b == 0) goto L19;
            if (this.a == 0) goto L19;
            if (r0 == null) goto L19;
            Object r1 = LynxTemplateRender.access$3500(r0);
            monitor-enter(r1);
        L15:
            th = move-exception;
            throw th;
        L10:
            if (LynxTemplateRender.access$3600(this.b) == false) goto L12;
            LynxTemplateRender.access$3700(this.a);     // Catch: Throwable -> L15
            this.a = 0;     // Catch: Throwable -> L15
            this.b = 0;     // Catch: Throwable -> L15
            this.d = null;     // Catch: Throwable -> L15
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L15
            goto L19
        L12:
            UIThreadUtils.runOnUiThread(this, 1);     // Catch: Throwable -> L15
        L19:
            if (this.c == null) goto L27;
            NativeFacade r2 = this.c;
            q1 r3 = r2.b;
            if (r3 == null) goto L23;
            r3.onDestroy();
            r2.b = null;
        L23:
            this.c = null;
            return;
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

        public n(long r4, long r6, LynxTemplateRender r8, NativeFacade r9) {
            this.a = r4;
            this.b = r6;
            if (r6 != 0) goto L5;
        L7:
            r8 = null;
        L8:
            this.d = r8;
            this.c = r9;
            return;
        L5:
            if (r4 == 0) goto L7;
            goto L7
        }
    }

    public class o implements d8a.b.a {
        public final String a;
        public final s0 b;
        public final /* synthetic */ LynxTemplateRender c;

        public class a implements Runnable {
            public final /* synthetic */ byte[] a;
            public final /* synthetic */ o b;

            public final void a() {
                byte[] r0 = this.a;
                if (r0 != null) goto L5;
            L21:
                this.b.onFailed("Source is null!");
                return;
            L5:
                if (r0.length == 0) goto L21;
                if (LynxTemplateRender.access$900(this.b.c) == null) goto L11;
                LynxTemplateRender.access$900(this.b.c).attachToDebugBridge(this.b.a);
            L11:
                if (LynxTemplateRender.access$900(this.b.c) == null) goto L13;
                LynxTemplateRender.access$900(this.b.c).onTemplateLoadSuccess(this.a);
            L13:
                LynxTemplateRender.access$1000(this.b.c).p("prepareTemplateEnd", null);
                o r1 = this.b;
                if (r1.b != null) goto L16;
                r1.getClass();
                this.b.getClass();
                this.b.getClass();
                TemplateData r2 = TemplateData.fromString(NameKeys.UnloadStrategy_No_Strategy);
                o r3 = this.b;
                LynxTemplateRender r4 = r3.c;
                r4.renderTemplateWithBaseUrl(this.a, r2, LynxTemplateRender.access$1200(r4, r3.a)[0]);
                return;
            L16:
                y7a.h r5 = y7a.h.a("loadBundle", "loadBundleStart", LynxTemplateRender.access$1000(r1.c).e);
                if (LynxTemplateRender.access$1000(this.b.c).e == false) goto L19;
                LynxTemplateRender.access$1000(this.b.c).p("loadBundleStart", null);
            L19:
                o r6 = this.b;
                s0 r7 = r6.b;
                r7.b = this.a;
                LynxTemplateRender.access$1300(r6.c, r6.b, r5);
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

            public a(o r1, byte[] r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ o c;

            @Override // java.lang.Runnable
            public final void run() {
                LynxError r0 = new LynxError(10203, "Error occurred while fetching app bundle resource");     // Catch: Throwable -> L4
                r0.setRootCause(this.a);     // Catch: Throwable -> L4
                r0.setCallStack(this.b);     // Catch: Throwable -> L4
                this.c.c.onErrorOccurred(r0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(o r1, String r2, String r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public final void a(TemplateBundle r5) {
            if (r5.i() == true) goto L7;
            onFailed("template bundle is invalid.");
            return;
        L7:
            if (LynxTemplateRender.access$900(this.c) == null) goto L10;
            LynxTemplateRender.access$900(this.c).attachToDebugBridge(this.a);
        L10:
            if (LynxTemplateRender.access$900(this.c) == null) goto L12;
            LynxTemplateRender.access$900(this.c).onLoadFromBundle(r5, null, this.a);
        L12:
            LynxTemplateRender.access$1000(this.c).p("prepareTemplateEnd", null);
            if (this.b != null) goto L15;
            TemplateData r0 = TemplateData.fromString(NameKeys.UnloadStrategy_No_Strategy);
            this.c.renderTemplateBundle(r5, r0, this.a);
            return;
        L15:
            y7a.h r1 = y7a.h.a("loadBundle", "loadBundleStart", LynxTemplateRender.access$1000(this.c).e);
            if (LynxTemplateRender.access$1000(this.c).e == false) goto L18;
            LynxTemplateRender.access$1000(this.c).p("loadBundleStart", null);
        L18:
            this.b.d = r5;
            LynxTemplateRender.access$1300(this.c, this.b, r1);
        }

        @Override // d8a.b.a
        public final void onFailed(String r3) {
            UIThreadUtils.runOnUiThreadImmediately(new b(this, r3, CallStackUtil.a(new Throwable("Fetch template resource failed"))));
        }

        @Override // d8a.b.a
        public final void onSuccess(byte[] r2) {
            UIThreadUtils.runOnUiThreadImmediately(new a(this, r2));
        }

        public o(LynxTemplateRender r1, String r2, s0 r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class p implements com.lynx.tasm.base.f {
        public final /* synthetic */ LynxTemplateRender a;

        public p(LynxTemplateRender r1) {
            this.a = r1;
        }
    }

    public class q implements d8a.b.a {
        public final TemplateData a;
        public final String b;
        public final /* synthetic */ LynxTemplateRender c;

        public class a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ q c;

            @Override // java.lang.Runnable
            public final void run() {
                LynxError r0 = new LynxError(10203, "Error occurred while fetching app bundle resource");     // Catch: Throwable -> L4
                r0.setRootCause(this.a);     // Catch: Throwable -> L4
                r0.setCallStack(this.b);     // Catch: Throwable -> L4
                this.c.c.onErrorOccurred(r0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(q r1, String r2, String r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        @Override // d8a.b.a
        public final void onFailed(String r3) {
            UIThreadUtils.runOnUiThreadImmediately(new a(this, r3, CallStackUtil.a(new Throwable("Fetch template resource failed"))));
        }

        @Override // d8a.b.a
        public final void onSuccess(byte[] r4) {
            if (LynxTemplateRender.access$900(this.c) == null) goto L6;
            LynxTemplateRender.access$900(this.c).attachToDebugBridge(this.b);
        L6:
            if (LynxTemplateRender.access$900(this.c) == null) goto L8;
            LynxTemplateRender.access$900(this.c).onTemplateLoadSuccess(r4);
        L8:
            LynxTemplateRender.access$1000(this.c).p("prepareTemplateEnd", null);
            this.c.renderSSR(r4, this.b, this.a);
        }

        public q(LynxTemplateRender r1, String r2, TemplateData r3) {
            this.c = r1;
            this.a = r3;
            this.b = r2;
        }
    }

    public static class r extends q1 {
        public long a;

        @Override // com.lynx.tasm.q1
        public final void onDataUpdated() {
            LLog.d(LynxTemplateRender.TAG, "onDataUpdated time:" + (System.currentTimeMillis() - this.a));
        }

        @Override // com.lynx.tasm.q1
        public final void onFirstScreen() {
            LLog.d(LynxTemplateRender.TAG, "onFirstScreen time: " + (System.currentTimeMillis() - this.a));
        }

        @Override // com.lynx.tasm.q1
        public final void onLoadSuccess() {
            LLog.d(LynxTemplateRender.TAG, "onLoadSuccess time: " + (System.currentTimeMillis() - this.a));
        }

        @Override // com.lynx.tasm.q1
        public final void onPageUpdate() {
            LLog.d(LynxTemplateRender.TAG, "onPageUpdate time:" + (System.currentTimeMillis() - this.a));
        }

        public r() {
            this.a = 0;
        }

        @Override // com.lynx.tasm.q1
        public final void onPageStart(String r3) {
            this.a = System.currentTimeMillis();
        }
    }

    public static final class s extends LynxContext {
        public final WeakReference<LynxTemplateRender> a;

        @Override // com.lynx.tasm.behavior.LynxContext, com.lynx.tasm.behavior.i
        public final void handleException(Exception r4) {
            LynxTemplateRender r0 = this.a.get();
            if (r0 == null) goto L6;
            LynxTemplateRender.access$000(r0, 990100, r4, null);
            return;
        }

        @Override // com.lynx.tasm.behavior.LynxContext
        public final void handleLynxError(LynxError r2) {
            LynxTemplateRender r0 = this.a.get();
            if (r0 == null) goto L6;
            r0.onErrorOccurred(r2);
            return;
        }

        @Override // com.lynx.tasm.behavior.LynxContext
        public final void runOnLayoutThread(Runnable r2) {
            LynxTemplateRender r0 = this.a.get();
            if (r0 == null) goto L6;
            LynxTemplateRender.access$100(r0, r2);
            return;
        }

        @Override // com.lynx.tasm.behavior.LynxContext
        public final void handleException(Exception r3, JSONObject r4) {
            LynxTemplateRender r0 = this.a.get();
            if (r0 == null) goto L6;
            LynxTemplateRender.access$000(r0, 990100, r3, r4);
            return;
        }

        @Override // com.lynx.tasm.behavior.LynxContext
        public final void handleException(Exception r3, int r4) {
            LynxTemplateRender r0 = this.a.get();
            if (r0 == null) goto L6;
            LynxTemplateRender.access$000(r0, r4, r3, null);
            return;
        }

        public s(Context r1, DisplayMetrics r2, LynxTemplateRender r3) {
            super(r1, r2);
            this.a = new WeakReference(r3);
        }

        @Override // com.lynx.tasm.behavior.LynxContext
        public final void handleException(Exception r2, int r3, JSONObject r4) {
            LynxTemplateRender r0 = this.a.get();
            if (r0 == null) goto L6;
            LynxTemplateRender.access$000(r0, r3, r2, r4);
            return;
        }
    }

    public class t implements NativeFacade.c {
        public final /* synthetic */ LynxTemplateRender a;

        @Override // com.lynx.tasm.NativeFacade.c
        public final void k() {
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void g() {
            if (LynxTemplateRender.access$2200(this.a) == null) goto L6;
            LynxSSRHelper r0 = LynxTemplateRender.access$2200(this.a);
            r0.getClass();
            r0.a = LynxSSRHelper.SSRHydrateStatus.SUCCESSFUL;
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void o() {
            LynxTemplateRender.access$3400(this.a);
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void onDataUpdated() {
            LLog.i(LynxTemplateRender.TAG, "TASMCallback.onDataUpdated " + LynxTemplateRender.access$1900(this.a));
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1600(this.a, "Client.onDataUpdated");
            LynxTemplateRender.access$1500(this.a).onDataUpdated();
            LynxTemplateRender.access$1700(this.a, "Client.onDataUpdated");
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void onRuntimeReady() {
            LLog.i(LynxTemplateRender.TAG, "TASMCallback.onRuntimeReady " + LynxTemplateRender.access$1900(this.a));
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1600(this.a, "Client.onRuntimeReady");
            LynxTemplateRender.access$1500(this.a).onRuntimeReady();
            LynxTemplateRender.access$1700(this.a, "Client.onRuntimeReady");
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void onUpdateDataWithoutChange() {
            LLog.i(LynxTemplateRender.TAG, "TemplateRenderCallback.onUpdateDataWithoutChange " + LynxTemplateRender.access$1900(this.a));
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1600(this.a, "Client.onUpdateDataWithoutChange");
            LynxTemplateRender.access$1500(this.a).onUpdateDataWithoutChange();
            LynxTemplateRender.access$1700(this.a, "Client.onUpdateDataWithoutChange");
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void q() {
            LynxTemplateRender r0 = this.a;
            LynxTemplateRender.access$3300(r0, LynxTemplateRender.access$2800(r0), LynxTemplateRender.access$2900(this.a));
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void r() {
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1600(this.a, "Client.onTASMFinishedByNative");
            LynxTemplateRender.access$1500(this.a).onTASMFinishedByNative();
            LynxTemplateRender.access$2700(this.a);
            LynxTemplateRender.access$1700(this.a, "Client.onTASMFinishedByNative");
            return;
        }

        public t(LynxTemplateRender r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void a(TemplateBundle r3) {
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1600(this.a, "Client.onTemplateBundleReady");
            LynxTemplateRender.access$1500(this.a).onTemplateBundleReady(r3);
            LynxTemplateRender.access$1700(this.a, "Client.onTemplateBundleReady");
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void e(k8a.a r2) {
            if (LynxTemplateRender.access$2400(this.a) != null) goto L5;
            LynxTemplateRender.access$2402(this.a, r2);
            return;
        L5:
            k8a.a r0 = LynxTemplateRender.access$2400(this.a);
            r0.getClass();
            r0.a = r2.a;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void f(HashMap<String, Object> r3) {
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1600(this.a, "Client.onDynamicComponentPerf");
            LynxTemplateRender.access$1500(this.a).onDynamicComponentPerfReady(r3);
            LynxTemplateRender.access$1700(this.a, "Client.onDynamicComponentPerf");
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void h(int r10) {
            LLog.i(LynxTemplateRender.TAG, "TASMCallback.onLoaded templateSize:" + r10 + " " + LynxTemplateRender.access$1900(this.a));
            w6a.h r0 = w6a.h.a.a;
            UIBody.UIBodyView r1 = this.a.mBodyView;
            r0.getClass();
            AtomicInteger r2 = new AtomicInteger(0);
            Iterator<LynxUI> r3 = r0.c.keySet().iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            LynxUI r4 = r3.next();
            if (r4.getLynxContext().getUIBody().getBodyView() != r1) goto L4;
            r2.incrementAndGet();
            r4.execEnterAnim(new w6a.f(r2));
            goto L4
        L8:
            r2.get();
            if (LynxTemplateRender.access$1500(this.a) == null) goto L11;
            LynxTemplateRender.access$2000(this.a, r10);
        L11:
            LynxUIOwner r11 = ((LynxUIRenderer) LynxTemplateRender.access$1400(this.a)).b;
            if (r11 != null) goto L14;
        L37:
            LynxTemplateRender.access$2102(this.a, LynxTemplateRender.RENDER_PHASE_UPDATE);
            return;
        L14:
            if (LynxTemplateRender.access$1000(this.a) == null) goto L37;
            PerformanceController r5 = LynxTemplateRender.access$1000(this.a);
            k1 r6 = new k1(this, r11);
            if (r5.l() == false) goto L37;
            if (r5.i != null) goto L21;
            r5.i = new FSPTracer(r5);
        L21:
            final FSPTracer r12 = r5.i;
            if (r12.b() == false) goto L37;
            if (r12.b.get() == true) goto L37;
            if (r12.a != null) goto L29;
            r12.a = new z7a.a();
        L29:
            z7a.a r7 = r12.a;
            if (r7.j == true) goto L33;
            TraceEvent.beginSection(0, "FSPConfig.parse");
            HashMap<String, String> r8 = LynxEnv.inst().getFSPConfig();
            r7.a = z7a.a.a(r8, "min_content_fill_percentage_x", 30);
            r7.b = z7a.a.a(r8, "min_content_fill_percentage_y", 30);
            r7.c = z7a.a.a(r8, "min_content_fill_percentage_total_area", 30);
            r7.d = z7a.a.a(r8, "min_container_fill_percentage_container_area", 1);
            r7.e = z7a.a.a(r8, "acceptable_pixel_diff_per_sec", 10);
            r7.f = z7a.a.a(r8, "acceptable_area_diff_per_sec", 100);
            r7.g = z7a.a.a(r8, "min_diff_interval_ms", 300);
            r7.h = z7a.a.a(r8, "hard_timeout_ms", 10000);
            r7.i = z7a.a.a(r8, "snapshotIntervalMs", 17);
            r7.j = true;
            TraceEvent.endSection(0, "FSPConfig.parse", r8);
        L33:
            r12.b.set(true);
            r12.c(r6);
            int r9 = r12.a.h;
            if (r9 <= 0) goto L37;
            LynxEventReporter.delayRunOnReportThread(new z7a.f(r12), r9);
            goto L37
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void i(Map<String, Object> r4) {
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1500(this.a).onCallJSBFinished(r4);
        L6:
            if (LynxDevtoolGlobalHelper.getInstance().isRemoteDebugAvailable() == true) goto L8;
            return;
        L8:
            if (LynxTemplateRender.access$200(this.a) == null) goto L10;
            int r0 = LynxTemplateRender.access$200(this.a).getInstanceId();
        L11:
            LynxDevtoolGlobalHelper.getInstance().onPerfMetricsEvent("lynxsdk_jsb_timing", new JSONObject(r4), r0);
            return;
        L10:
            r0 = -1;
            goto L11
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void j(boolean r3) {
            LLog.i(LynxTemplateRender.TAG, "TASMCallback.onPageChanged isFirstScreen:" + r3 + " " + LynxTemplateRender.access$1900(this.a));
            if (r3 == false) goto L13;
            p r4 = LynxTemplateRender.access$2300(this.a);
            r4.getClass();
            LLog.i(LynxTemplateRender.TAG, "onFirstScreen");
            ILynxUIRenderer r0 = LynxTemplateRender.access$1400(r4.a);
            if (r0 == null) goto L22;
            LynxUIOwner r1 = ((LynxUIRenderer) r0).b;
            if (r1 == null) goto L22;
            r1.setFirstLayout();
        L22:
            UIThreadUtils.runOnUiThread(new i1(r4));     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            th.printStackTrace();
            return;
        L13:
            p r5 = LynxTemplateRender.access$2300(this.a);
            r5.getClass();
            LLog.i(LynxTemplateRender.TAG, "onPageUpdate");     // Catch: Throwable -> L19
            UIThreadUtils.runOnUiThread(new j1(r5));     // Catch: Throwable -> L19
            if (LynxTemplateRender.access$900(r5.a) == null) goto L17;
            LynxTemplateRender.access$900(r5.a).onPageUpdate();     // Catch: Throwable -> L19
        L17:
            LynxTemplateRender.access$1800(r5.a);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void n(JavaOnlyMap r2) {
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1500(this.a).onJSBInvoked(r2);
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void onErrorOccurred(LynxError r3) {
            StringBuilder r0 = new StringBuilder("TASMCallback.onErrorOccurred errorCode:");
            if (r3 == null) goto L5;
            Object r1 = Integer.valueOf(r3.getErrorCode());
        L6:
            r0.append(r1);
            r0.append(" ");
            r0.append(LynxTemplateRender.access$1900(this.a));
            LLog.i(LynxTemplateRender.TAG, r0.toString());
            this.a.onErrorOccurred(r3);
            return;
        L5:
            r1 = "null";
            goto L6
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void onReceiveMessageEvent(ReadableMap r2) {
            if (LynxTemplateRender.access$900(this.a) == null) goto L6;
            LynxTemplateRender.access$900(this.a).onReceiveMessageEvent(r2);
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void t(t1 r3) {
            if (this.a.isEnableReuseEngine() == true) goto L5;
        L7:
            t1.a(r3, LynxTemplateRender.access$200(this.a), LynxTemplateRender.access$1400(this.a));
            return;
        L5:
            if (LynxTemplateRender.access$2600(this.a) == null) goto L7;
            LynxTemplateRender.access$2600(this.a).h = r3;
            goto L7
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void b(int r4, JavaOnlyMap r5) {
            if (this.a.enableAirStrictMode() == false) goto L8;
            if (LynxTemplateRender.access$3100(this.a) == null) goto L11;
            j7a.a.a.getClass();
            ByteBuffer r6 = j7a.a.b(r5);
            LynxEngineProxy r0 = LynxTemplateRender.access$3100(this.a);
            r0.getClass();
            UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.k(r0, r4, "__Card__", r6));
            return;
        L11:
            return;
        L8:
            if (LynxTemplateRender.access$3200(this.a) == null) goto L13;
            LynxTemplateRender.access$3200(this.a).d(r4, r5);
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final String d(String r2, String r3) {
            d8a.m r4 = LynxEnv.inst().getThemeResourceProviderProvider();
            if (r4 == null) goto L14;
            if (r3 != null) goto L12;
        L6:
            LynxTemplateRender.access$2400(this.a);     // Catch: Throwable -> L8
            LynxTemplateRender.access$2500(this.a);     // Catch: Throwable -> L8
            return r4.a();
        L8:
            th = move-exception;
            LLog.d(LynxTemplateRender.TAG, "translateResourceForTheme exception " + th.toString());
            return null;
        L12:
            r3.isEmpty();     // Catch: Throwable -> L8
            goto L6
        L14:
            return null;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void c(String r9, String r10, int r11) {
            LynxTemplateRender.access$3000(LynxTemplateRender.access$2800(this.a), LynxTemplateRender.access$2900(this.a), r9, r10, r11);
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void l(long r2, boolean r4, long r5) {
            if (LynxTemplateRender.access$200(this.a) != null) goto L5;
            return;
        L5:
            if (LynxTemplateRender.access$200(this.a).getLynxUIOwner() == null) goto L11;
            LynxBaseUI r3 = LynxTemplateRender.access$200(this.a).getLynxUIOwner().findLynxUIBySign((int) r2);
            if (r3 == null) goto L12;
            r3.onEventCapture(r4, r5);
            return;
        L12:
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void m(long r2, boolean r4, long r5) {
            if (LynxTemplateRender.access$200(this.a) != null) goto L5;
            return;
        L5:
            if (LynxTemplateRender.access$200(this.a).getLynxUIOwner() == null) goto L11;
            LynxBaseUI r3 = LynxTemplateRender.access$200(this.a).getLynxUIOwner().findLynxUIBySign((int) r2);
            if (r3 == null) goto L12;
            r3.onEventBubble(r4, r5);
            return;
        L12:
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void p(String r3, String r4, int r5) {
            if (LynxTemplateRender.access$1500(this.a) == null) goto L6;
            LynxTemplateRender.access$1600(this.a, "Client.onModuleMethodInvoked");
            LynxTemplateRender.access$1500(this.a).onModuleMethodInvoked(r3, r4, r5);
            LynxTemplateRender.access$1700(this.a, "Client.onModuleMethodInvoked");
            return;
        }

        @Override // com.lynx.tasm.NativeFacade.c
        public final void s(long r2, boolean r4, long r5) {
            if (LynxTemplateRender.access$200(this.a) != null) goto L5;
            return;
        L5:
            if (LynxTemplateRender.access$200(this.a).getLynxUIOwner() == null) goto L11;
            LynxBaseUI r3 = LynxTemplateRender.access$200(this.a).getLynxUIOwner().findLynxUIBySign((int) r2);
            if (r3 == null) goto L12;
            r3.onEventFire(r4, r5);
            return;
        L12:
            return;
        }
    }

    public static class u implements Runnable {
        public final WeakReference<LynxTemplateRender> a;

        @Override // java.lang.Runnable
        public final void run() {
            LynxTemplateRender r0 = this.a.get();     // Catch: Throwable -> L20
            if (r0 == null) goto L23;
            LynxTemplateRender.access$3802(r0, false);     // Catch: Throwable -> L20
            final PerformanceController r1 = LynxTemplateRender.access$1000(r0);     // Catch: Throwable -> L20
            if (r1 == null) goto L27;
            ILynxUIRenderer r2 = LynxTemplateRender.access$1400(r0);     // Catch: Throwable -> L20
            if (r2 == null) goto L28;
            LynxUIOwner r3 = ((LynxUIRenderer) r2).b;     // Catch: Throwable -> L20
            if (r3 == null) goto L29;
            final HashMap<String, a8a.a> r4 = r3.getMemoryUsage();     // Catch: Throwable -> L20
            if (r1.e == true) goto L30;
            if (r4 == null) goto L31;
            r1.q(new y7a.c(r1, r4));     // Catch: Throwable -> L20
            return;
        L31:
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L23:
            return;
        L20:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L32;
            throw th;
        }

        public u(LynxTemplateRender r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static /* synthetic */ void a(LynxTemplateRender r0, LynxTemplateRenderMemoryUsageFetcher.InstanceMemoryUsageQuery r1) {
        r0.lambda$queryNativeMemoryUsageForGlobalCollectorAsync$6(r1);
    }

    public static /* synthetic */ void b(LynxTemplateRender r1, PlatformCallBack r2) {
        r1.lambda$getLynxElementRoot$1(null, r2);
    }

    public static /* synthetic */ void c(LynxTemplateRender r0) {
        r0.reloadAndInitUIThreadPart();
    }

    public static /* synthetic */ void d(o r0, LynxResourceResponse r1) {
        lambda$loadTemplateWithGenericResourceFetcher$5(r0, r1);
    }

    private void destroyNative() {
        this.mDestroying = true;
        LLog.i(TAG, "destroyNative url " + getTemplateUrl() + " in " + toString());
        LynxDevtool r1 = this.mDevTool;
        if (r1 == null) goto L6;
        r1.destroy();
        this.mDevTool = null;
    L6:
        if (this.mNativePtr == 0) goto L13;
        LynxContext r2 = this.mLynxContext;
        if (r2 != null) goto L10;
    L12:
        destroyLynxEngine();
        goto L13
    L10:
        if (r2.enableEventReporter() == false) goto L12;
        LynxEventReporter.clearCache(this.mLynxContext.getInstanceId());
    L13:
        this.mHasDestroy = true;
        this.mDestroying = false;
    }

    private void disableEngineBeReused() {
        this.mEnableReuseEngine = false;
        LynxEngine r0 = this.mLynxEngineRef;
        if (r0 == null) goto L6;
        r0.b();
        this.mLynxEngineRef = null;
        return;
    }

    public static /* synthetic */ void e() {
        lambda$null$2(null);
    }

    public static /* synthetic */ void f(LynxTemplateRender r1, int r2, PlatformCallBack r3) {
        r1.lambda$lynxElementToJSONString$3(r2, null, r3);
    }

    public static /* synthetic */ void g() {
        lambda$null$0(null);
    }

    private native void nativeAttachEngineToUIThread(long r1, long r3);

    private static native void nativeAttachRuntime(long r0, long r2, long r4);

    private native void nativeClearPipelineTimingInfo(long r1, long r3);

    private static native long nativeCreate(long r0, Object r2, Object r3, Object r4, int r5, boolean r6, boolean r7, int r8, int r9, float r10, String r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, String r18, Object r19, long r20, long r22, boolean r24, boolean r25, boolean r26, boolean r27, int r28, boolean r29, boolean r30, long r31, Object r33);

    private static native void nativeDestroy(long r0);

    private native void nativeDetachEngineFromUIThread(long r1, long r3);

    private static native void nativeDispatchMessageEvent(long r0, long r2, ReadableMap r4);

    private static native void nativeEnforceRelayoutOnCurrentThreadWithUpdatedViewport(long r0, long r2, int r4, int r5, int r6, int r7);

    private static native void nativeFlush(long r0, long r2);

    private static native JavaOnlyMap nativeGetAllJsSource(long r0, long r2);

    private native JavaOnlyMap nativeGetAllTimingInfo(long r1, long r3);

    private native void nativeGetDataAsync(long r1, long r3, int r5);

    private static native int nativeGetInstanceId(long r0, long r2);

    private static native long nativeGetListEngineProxy(long r0, long r2);

    private static native JavaOnlyMap nativeGetListPlatformInfo(long r0, long r2, int r4);

    public static native void nativeGetLynxElementRoot(long r0, long r2, PlatformCallBack r4);

    private static native Object nativeGetPageDataByKey(long r0, long r2, String[] r4);

    private native void nativeGetSessionStorageItem(long r1, long r3, String r5, PlatformCallBack r6);

    private static native void nativeInitRuntime(long r0, LynxResourceLoader r2, LynxModuleFactory r3, String r4, String[] r5, String r6, int r7, long r8);

    private static native long nativeLifecycleCreate();

    private static native void nativeLifecycleDestroy(long r0);

    private static native boolean nativeLifecycleTryTerminate(long r0);

    private static native void nativeLoadSSRDataByPreParsedData(long r0, long r2, byte[] r4, long r5, boolean r7, String r8, TemplateData r9);

    private static native void nativeLoadTemplateBufferByPreParsedData(long r0, long r2, String r4, ByteBuffer r5, boolean r6, boolean r7, long r8, boolean r10, String r11, TemplateData r12, int r13, ReadableMap r14);

    private static native void nativeLoadTemplateBundleByPreParsedData(long r0, long r2, String r4, long r5, boolean r7, long r8, boolean r10, String r11, TemplateData r12, int r13, ReadableMap r14);

    private static native void nativeLoadTemplateByPreParsedData(long r0, long r2, String r4, byte[] r5, boolean r6, boolean r7, long r8, boolean r10, String r11, TemplateData r12, int r13, ReadableMap r14);

    public static native void nativeLynxElementToJSONString(long r0, long r2, int r4, PlatformCallBack r5);

    private static native void nativeMarkDirty(long r0, long r2);

    private static native int nativeObtainChild(long r0, long r2, int r4, int r5, long r6, boolean r8);

    private static native void nativeObtainChildAsync(long r0, long r2, int r4, int r5, long r6);

    private static native void nativeOnEnterBackground(long r0, long r2);

    private static native void nativeOnEnterForeground(long r0, long r2);

    private static native void nativeOnLynxEngineCreated(long r0, long r2);

    private static native void nativePreloadLazyBundles(long r0, long r2, String[] r4);

    private static native void nativeProcessRender(long r0, long r2);

    private static native void nativeQueryNativeMemoryUsageAsync(long r0, long r2, Object r4);

    private static native void nativeRebuildLynxEngine(long r0, long r2, long r4, Object r6, Object r7);

    private static native void nativeRecycleChild(long r0, long r2, int r4, int r5);

    private static native void nativeRecycleChildAsync(long r0, long r2, int r4, int r5);

    private static native boolean nativeRegisterLazyBundle(long r0, long r2, String r4, long r5);

    private static native void nativeReloadTemplate(long r0, long r2, long r4, long r6, String r8, boolean r9, Object r10, TemplateData r11, ReadableMap r12);

    private static native void nativeRemoveChild(long r0, long r2, int r4, int r5);

    private static native void nativeRenderChild(long r0, long r2, int r4, int r5, long r6);

    private static native void nativeResetDataByPreParsedData(long r0, long r2, long r4, String r6, boolean r7, TemplateData r8);

    private native void nativeScrollByListContainer(long r1, long r3, int r5, float r6, float r7, float r8, float r9);

    private native void nativeScrollStopped(long r1, long r3, int r5);

    private native void nativeScrollToPosition(long r1, long r3, int r5, int r6, float r7, int r8, boolean r9);

    private static native void nativeSendGlobalEventToLepus(long r0, long r2, String r4, ByteBuffer r5, int r6);

    private static native void nativeSendSsrGlobalEvent(long r0, long r2, String r4, ByteBuffer r5, int r6);

    private native void nativeSetContextHasAttached(long r1, long r3);

    private static native void nativeSetEnableBytecode(long r0, long r2, boolean r4, String r5);

    private static native void nativeSetEnableUIFlush(long r0, long r2, boolean r4);

    private native void nativeSetExtensionDelegate(long r1, long r3, long r5);

    private static native void nativeSetFontScale(long r0, long r2, float r4);

    private native void nativeSetLongTaskMonitorDisabled(long r1, long r3, boolean r5);

    private static native void nativeSetPlatformConfig(long r0, long r2, String r4);

    private native void nativeSetSSRTimingData(long r1, long r3, String r5, long r6);

    private native void nativeSetSessionStorageItem(long r1, long r3, String r5, long r6, boolean r8);

    private static native boolean nativeShouldSendEventToMainThread(long r0, long r2);

    private static native void nativeStartRuntime(long r0, long r2);

    private native double nativeSubscribeSessionStorage(long r1, long r3, String r5, PlatformCallBack r6);

    private static native void nativeSyncFetchLayoutResult(long r0, long r2);

    private static native void nativeSyncPackageExternalPath(long r0, String r2);

    private static native void nativeTriggerEventBus(long r0, long r2, String r4, ByteBuffer r5, int r6);

    private native void nativeUnsubscribeSessionStorage(long r1, long r3, String r5, double r6);

    private static native void nativeUpdateChild(long r0, long r2, int r4, int r5, int r6, long r7);

    private static native void nativeUpdateColorScheme(long r0, long r2, int r4, boolean r5);

    private static native void nativeUpdateConfig(long r0, long r2, ByteBuffer r4, int r5);

    private static native void nativeUpdateDataByPreParsedData(long r0, long r2, long r4, String r6, boolean r7, TemplateData r8, boolean r9);

    private static native void nativeUpdateFontScale(long r0, long r2, float r4);

    private static native void nativeUpdateGlobalProps(long r0, long r2, long r4);

    private static native void nativeUpdateI18nResource(long r0, long r2, String r4, String r5, int r6);

    private static native void nativeUpdateMetaData(long r0, long r2, long r4, String r6, boolean r7, TemplateData r8, long r9);

    private static native void nativeUpdateScreenMetrics(long r0, long r2, int r4, int r5, float r6, long r7);

    private static native void nativeUpdateViewport(long r0, long r2, int r4, int r5, int r6, int r7, float r8, long r9, boolean r11);

    private synchronized void recycleGlobalPropsSafely() {
        monitor-enter(this);
        TemplateData r0 = this.globalProps;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.recycle();     // Catch: Throwable -> L8
        this.globalProps = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void reloadAndInit() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasDestroy == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L8:
        if (this.reload == true) goto L12;
        this.reload = true;     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L21
        LynxContext r0 = this.mLynxContext;
        if (r0 == null) goto L17;
        r0.clearExposure();
    L17:
        if (UIThreadUtils.runOnUiThreadSync(new e1(this)) == true) goto L19;
        return;
    L19:
        reloadAndInitInternal();
    }

    private synchronized void reloadAndInitInternal() {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasDestroy == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.reload == false) goto L27;
        onTraceEventBegin("TemplateRender.reloadAndInit");     // Catch: Throwable -> L30
        this.mHasPageStart = false;     // Catch: Throwable -> L30
        this.mSSRHelper = null;     // Catch: Throwable -> L30
        this.mRenderPhase = RENDER_PHASE_SETUP;     // Catch: Throwable -> L30
        TemplateData r2 = this.globalProps;     // Catch: Throwable -> L30
        if (r2 == null) goto L12;
        this.globalProps = r2.deepClone();     // Catch: Throwable -> L30
    L12:
        int r6 = -1;
        if (this.mNativePtr == 0) goto L20;
        LynxContext r3 = this.mLynxContext;     // Catch: Throwable -> L30
        if (r3 != null) goto L17;
    L19:
        destroyLynxEngine();     // Catch: Throwable -> L30
        goto L20
    L17:
        if (r3.enableEventReporter() == false) goto L19;
        r6 = this.mLynxContext.getInstanceId();     // Catch: Throwable -> L30
        LynxEventReporter.removeGenericInfo(r6);     // Catch: Throwable -> L30
    L20:
        int r4 = this.mPreWidthMeasureSpec;     // Catch: Throwable -> L30
        int r5 = this.mPreHeightMeasureSpec;     // Catch: Throwable -> L30
        this.mPreWidthMeasureSpec = 0;     // Catch: Throwable -> L30
        this.mPreHeightMeasureSpec = 0;     // Catch: Throwable -> L30
        ILynxUIRenderer r0 = lynxUIRenderer();     // Catch: Throwable -> L30
        if (r0 == null) goto L23;
        com.lynx.tasm.behavior.b1 r1 = ((LynxUIRenderer) r0).c;     // Catch: Throwable -> L30
    L23:
        LynxContext r7 = this.mLynxContext;     // Catch: Throwable -> L30
        if (r7 == null) goto L26;
        r7.reset();     // Catch: Throwable -> L30
    L26:
        createLynxEngine(r6);     // Catch: Throwable -> L30
        updateViewport(r4, r5);     // Catch: Throwable -> L30
        setMsTiming("createLynxStart", this.mInitStart, null);     // Catch: Throwable -> L30
        setMsTiming("createLynxEnd", this.mInitEnd, null);     // Catch: Throwable -> L30
        onTraceEventEnd("TemplateRender.reloadAndInit");     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L27:
        this.reload = true;     // Catch: Throwable -> L30
        goto L28
    }

    public boolean hasLogicExecutor() {
        return false;
    }

    public native void nativeDetachLynxEngineWrapper(long r1, long r3);

    public native void nativeReattachLynxEngineWrapper(long r1, long r3, long r5, long r7);

    public void onEnterBackground() {
        onEnterBackground(true);
    }

    public void onEnterForeground() {
        onEnterForeground(true);
    }

    public void onLynxEvent(ReadableMap r1) {
    }

    public void onTouchEvent(MotionEvent r1) {
    }

    static {
        VSYNC_ALIGNED_FLUSH_EXP_SWITCH = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.VSYNC_ALIGNED_FLUSH_EXP_KEY, false);
    }

    private String buildInstanceLogContext() {
        if (TextUtils.isEmpty(this.mUrl) == true) goto L5;
        String r0 = this.mUrl;
    L6:
        LynxContext r1 = this.mLynxContext;
        if (r1 == null) goto L9;
        String r2 = String.valueOf(r1.getInstanceId());
    L11:
        return "instanceId:" + r2 + " url:" + r0;
    L9:
        r2 = "null";
        goto L11
    L5:
        r0 = NameKeys.UnloadStrategy_No_Strategy;
        goto L6
    }

    private y6a.f createLayoutTickForCurrentStrategy() {
        if (this.mThreadStrategyForRendering != ThreadStrategyForRendering.ALL_ON_UI) goto L7;
        y6a.r r0 = new y6a.r(this.mBodyView);
        this.mViewLayoutTick = r0;
        return r0;
    L7:
        return new y6a.d(this.mLynxContext);
    }

    private void destroyLynxEngine() {
        Object r0 = this.mNativeShellLifecycleLock;
        monitor-enter(r0);
    L52:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDestroyed.compareAndSet(false, true) == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L52
        return;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L52
        boolean r1 = shouldCacheLynxEngine();
        unregisterMemoryUsageFetcherIfNeeded();
        ILynxUIRenderer r2 = this.mLynxUIRender;
        if (r2 == null) goto L14;
        if (r1 == true) goto L14;
        ((LynxUIRenderer) r2).l();
    L14:
        if (this.mNativeFacade == null) goto L22;
        NativeFacade r3 = this.mNativeFacade;
        LynxModuleFactory r4 = r3.i;
        if (r4 == null) goto L22;
        if (r3.g == false) goto L20;
        r4.d();
    L21:
        r3.i = null;
        goto L22
    L20:
        r4.destroy();
    L22:
        UIThreadUtils.runOnUiThreadImmediately(new n(this.mNativePtr, this.mNativeLifecycle, this, this.mNativeFacade));
        if (r1 == false) goto L30;
        LynxEngine r5 = this.mLynxEngineRef;
        LynxTemplateRender r6 = r5.a.get();
        if (r5.b == 0) goto L28;
        if (r6 == null) goto L28;
        r6.detachLynxEngineWrapper();
        r5.a.clear();
    L28:
        this.mCacheManager.e();
    L38:
        Map<Double, PlatformCallBack> r7 = this.platformCallBackMap;
        if (r7 == null) goto L41;
        r7.clear();
    L41:
        JSProxy r8 = this.mJSProxy;
        if (r8 == null) goto L44;
        r8.f();
        this.mJSProxy = null;
    L44:
        LynxEngineProxy r9 = this.mEngineProxy;
        if (r9 == null) goto L47;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.d(r9));
    L47:
        LynxLayoutProxy r10 = this.mLayoutProxy;
        this.mLayoutProxy = null;
        if (r10 == null) goto L50;
        r10.a();
    L50:
        this.mTasmPlatformInvoker = null;
        this.mNativeFacade = null;
        this.mNativeLifecycle = 0;
        this.mNativePtr = 0;
        return;
    L30:
        if (this.mEnableReuseEngine == false) goto L38;
        LynxEngine r11 = this.mLynxEngineRef;
        if (r11 == null) goto L38;
        if (r11.d() == false) goto L36;
    L37:
        UIThreadUtils.runOnUiThreadImmediately(new b(this));
        goto L38
    L36:
        if (this.mLynxEngineRef.c() == true) goto L38;
        goto L37
    }

    private void doSyncFlush() {
        onTraceEventBegin("LynxTemplateRender.syncFlush");
        UIThreadUtils.assertOnUiThread();
        if (this.mEmbeddedMode <= 0) goto L9;
        if (this.mHasSubmittedViewport == true) goto L9;
        LLog.i(TAG, "Skip syncFlush without a submitted viewport.");
        onTraceEventEnd("LynxTemplateRender.syncFlush");
        return;
    L9:
        if (this.mAsyncRender == true) goto L11;
    L15:
        onTraceEventEnd("LynxTemplateRender.syncFlush");
        return;
    L11:
        if (this.mIsDestroyed.get() == true) goto L15;
        LLog.i(TAG, "syncFlush wait layout finish");
        long r1 = this.mNativePtr;
        if (r1 == 0) goto L15;
        nativeFlush(r1, this.mNativeLifecycle);
        goto L15
    }

    private void ensureLynxEngine() {
        if (this.mLynxEngineRef != null) goto L5;
        this.mLynxEngineRef = new LynxEngine(this.mTemplateBundle, this);
        ILynxUIRenderer r0 = lynxUIRenderer();
        this.mLynxUIRender = r0;
        LynxEngine r1 = this.mLynxEngineRef;
        r1.f = r0;
        r1.getClass();
        r1.a = new WeakReference(this);
        return;
    L5:
        setupReusedLynxEngine();
    }

    private boolean getAutoExpose() {
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getAutoExpose() == false) goto L7;
        return true;
    }

    private boolean getEnableVsyncAlignedFlush() {
        if (this.mVsyncAlignedFlushEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (isVsyncAlignedFlushPageConfigEnabled() == false) goto L7;
        return true;
    }

    private String getGroupID() {
        LynxGroup r0 = this.mGroup;
        if (r0 == null) goto L6;
        return r0.getID();
    L6:
        return LynxGroup.SINGNLE_GROUP;
    }

    private String getJSGroupThreadNameIfNeed() {
        LynxGroup r0 = this.mGroup;
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        if (r0.enableJSGroupThread() == true) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return this.mGroup.getJSGroupThreadNameOrDefault();
    }

    private LynxView getLynxView() {
        UIBody.UIBodyView r0 = this.mBodyView;
        if ((r0 instanceof LynxView) == false) goto L7;
        return (LynxView) r0;
    L7:
        if ((r0 instanceof LynxFrameView) == true) goto L9;
        return null;
    L9:
        return ((LynxFrameView) r0).getRootView();
    }

    private LynxLayoutProxy getOrCreateLayoutProxy() {
        LynxLayoutProxy r0 = this.mLayoutProxy;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = this.mNativeShellLifecycleLock;
        monitor-enter(r1);
        LynxLayoutProxy r2 = this.mLayoutProxy;     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r2;
    L10:
        if (this.mIsDestroyed.get() == true) goto L14;
        long r3 = this.mNativePtr;     // Catch: Throwable -> L16
        if (r3 == 0) goto L14;
        r2 = new LynxLayoutProxy(r3);     // Catch: Throwable -> L16
        this.mLynxContext.setLayoutProxy(r2);     // Catch: Throwable -> L16
        this.mLayoutProxy = r2;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private String[] getPreloadJSPath() {
        LynxGroup r0 = this.mGroup;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPreloadJSPaths();
    }

    private void initEngineAndLayoutProxies() {
        this.mEngineProxy = new LynxEngineProxy(this.mNativePtr);
        NativeFacade r0 = this.mNativeFacade;
        LynxEngineProxy r1 = this.mEngineProxy;
        r0.getClass();
        r0.e = new WeakReference(r1);
        if (this.mLynxContext != null) goto L6;
        LLog.e(TAG, "mLynxContext is null, can not set LayoutProxy");
        return;
    }

    private void initPiper() {
        TraceEvent.beginSection("TemplateRender.initPiper");
        initPiperInternal();
        TraceEvent.endSection("TemplateRender.initPiper");
    }

    private void initPiperInternal() {
        LynxGroup r0 = this.mLynxRuntimeOptions.c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        LLog.i(TAG, "force use quick js engine");
    L13:
        long r2 = this.mNativePtr;
        LynxResourceLoader r4 = this.mResourceLoader;
        LynxModuleFactory r5 = this.mModuleFactory;
        String r6 = getGroupID();
        String[] r7 = getPreloadJSPath();
        com.lynx.tasm.q r3 = this.mLynxRuntimeOptions;
        nativeInitRuntime(r2, r4, r5, r6, r7, r3.b, r3.a(this.mEnablePendingJsTask), ((LynxUIRenderer) lynxUIRenderer()).j());
        String r8 = getJSGroupThreadNameIfNeed();
        WeakReference<LynxContext> r9 = this.mNativeFacade.f;
        this.mJSProxy = new JSProxy(this.mNativePtr, r9, r8);
        NativeFacade r10 = this.mNativeFacade;
        JSProxy r11 = this.mJSProxy;
        r10.getClass();
        new WeakReference(r11);
        if (r9.get() == null) goto L17;
        LLog.i(TAG, "set JSGroupThreadName to lynx context: " + r8);
        r9.get().setJSGroupThreadName(r8);
        return;
    L17:
        return;
    L12:
        LLog.i(TAG, "useQuickJSEngine is false");
        goto L13
    L5:
        if (r0.enableV8() == false) goto L8;
        r1 = false;
        goto L10
    }

    private boolean isThreadStrategySupportVsyncAlignedFlush() {
        ThreadStrategyForRendering r0 = this.mThreadStrategyForRendering;
        if (r0 != ThreadStrategyForRendering.ALL_ON_UI) goto L5;
    L8:
        return true;
    L5:
        if (r0 == ThreadStrategyForRendering.PART_ON_LAYOUT) goto L8;
        return false;
    }

    private boolean isVsyncAlignedFlushPageConfigEnabled() {
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getEnableVsyncAlignedFlush() == false) goto L7;
        return true;
    }

    private void markEngineIdle() {
        if (this.mEnableReuseEngine == false) goto L10;
        LynxEngine r0 = this.mLynxEngineRef;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.mMarkEngineInUseFlag == false) goto L12;
        this.mMarkEngineInUseFlag = false;
        r0.e(LynxEngine.LynxEngineState.READY_BE_REUSED);
        return;
    L12:
        return;
    }

    private boolean markEngineInUse() {
        if (this.mEnableReuseEngine == true) goto L5;
    L7:
        LynxEngine r0 = this.mLynxEngineRef;
        if (r0 != null) goto L10;
    L13:
        return false;
    L10:
        if (r0.d() == false) goto L13;
        this.mMarkEngineInUseFlag = true;
        return true;
    L5:
        if (this.mLynxEngineRef != null) goto L7;
        return false;
    }

    private void onLoadTemplateFromSSRPage() {
        LynxSSRHelper r0 = this.mSSRHelper;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a != LynxSSRHelper.SSRHydrateStatus.STARTED) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L12;
        this.reload = false;
        LynxSSRHelper r2 = this.mSSRHelper;
        r2.getClass();
        r2.a = LynxSSRHelper.SSRHydrateStatus.EXECUTING;
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void onThreadStrategyUpdated() {
        ThreadStrategyForRendering r0 = this.mThreadStrategyForRendering;
        if (r0 != ThreadStrategyForRendering.MULTI_THREADS) goto L5;
    L8:
        boolean r1 = true;
    L9:
        this.mAsyncRender = r1;
        LynxContext r2 = this.mLynxContext;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.enableEventReporter() == false) goto L14;
        LynxEventReporter.updateGenericInfo(LynxEventReporter.PROP_NAME_THREAD_MODE, Integer.valueOf(this.mThreadStrategyForRendering.id()), this.mLynxContext.getInstanceId());
    L14:
        ThreadStrategyForRendering r3 = this.mThreadStrategyForRendering;
        if (r3 != ThreadStrategyForRendering.MOST_ON_TASM) goto L17;
    L18:
        this.mLynxContext.setLayoutThreadChanged(true);
        return;
    L17:
        if (r3 == ThreadStrategyForRendering.ALL_ON_UI) goto L18;
        return;
    L5:
        if (r0 == ThreadStrategyForRendering.MOST_ON_TASM) goto L8;
        r1 = false;
        goto L9
    }

    private void recreateLynxUIRenderer() {
        ((com.lynx.tasm.behavior.l0) this.mLynxViewConfigProvider.getUIRendererCreator()).getClass();
        LynxUIRenderer r0 = new LynxUIRenderer();
        this.mLynxUIRender = r0;
        this.mBodyView.setLynxUIRendererInternal(r0);
    }

    private void recycleUpdatedDataList() {
        Iterator<TemplateData> r0 = this.updatedDataList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().recycle();
        goto L4
    L6:
        this.updatedDataList.clear();
    }

    private void registerMemoryUsageFetcherIfNeeded() {
        boolean r1 = true;
        if ((this.mEmbeddedMode & 1) > 0) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        if (this.mMemoryUsageFetcher != null) goto L11;
        this.mMemoryUsageFetcher = new LynxTemplateRenderMemoryUsageFetcher(this);
    L11:
        n0 r0 = n0.c;
        t0 r2 = this.mMemoryUsageFetcher;
        r0.a.add(new n0.a(r2));
    }

    private void setUpBackgroundThreadModuleFactory() {
        com.lynx.tasm.group.c r0 = this.mLynxViewGroup;
        if (r0 != null) goto L5;
    L11:
        LynxBackgroundRuntime r1 = this.mRuntime;
        if (r1 == null) goto L14;
        this.mModuleFactory = r1.b;
    L15:
        e r2 = new e(this, this.mLynxContext.getLynxViewClient());
        this.mModuleFactory.g = new f(this, r2);
        g r3 = new g(this);
        if (this.mRuntime == null) goto L24;
        IModuleCreator r4 = this.mModuleFactory.c;
        if (r4 == null) goto L25;
        com.lynx.jsbridge.a r5 = (com.lynx.jsbridge.a) r4;
        r5.b = r3;
        Iterator<LynxModuleWrapper> r6 = r5.a.values().iterator();
    L22:
        if (r6.hasNext() == false) goto L25;
        r6.next().f = r3;
    L25:
        setUserModules(this.mModuleFactory);
        setLynxInternalModules(this.mModuleFactory);
        z5a.b r7 = new z5a.b();
        r7.a = new WeakReference(this.mLynxContext);
        this.mModuleFactory.c(LynxFetchModule.NAME, LynxFetchModule.class, r7);
    L26:
        this.mNativeFacade.i = this.mModuleFactory;
        return;
    L24:
        this.mModuleFactory.c = new com.lynx.jsbridge.a(r3);
        goto L25
    L14:
        LynxModuleFactory r8 = new LynxModuleFactory();
        this.mModuleFactory = r8;
        r8.f = this.mLynxRuntimeOptions.m;
        goto L15
    L5:
        if (r0.h() == null) goto L11;
        LLog.v(TAG, "NativeModule:LynxTemplateRender setUpBackgroundThreadModuleFactory mLynxViewGroup: " + this.mLynxViewGroup);
        LynxModuleFactory r9 = this.mLynxViewGroup.h();
        this.mModuleFactory = r9;
        IModuleCreator r10 = r9.c;
        if (r10 != null) goto L9;
        com.lynx.jsbridge.b r11 = null;
    L10:
        String.valueOf(this.mLynxContext.getInstanceId());
        new WeakReference(this.mLynxContext);
        r11.b();
        goto L26
    L9:
        r11 = ((com.lynx.jsbridge.a) r10).b;
        goto L10
    }

    private void setUpExtensionModules() {
        Map<String, com.lynx.jsbridge.d> r0 = this.mLynxContext.getExtensionModules();
        Iterator<String> r1 = r0.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        com.lynx.jsbridge.d r2 = r0.get(r1.next());
        long r8 = r2.getExtensionDelegatePtr();
        if (r8 == 0) goto L7;
        nativeSetExtensionDelegate(this.mNativePtr, this.mNativeLifecycle, r8);
        r2.setUp();
        goto L4
    L7:
        LLog.e(TAG, "Fail to get extension delegate");
        goto L4
    }

    private void setUpMainThreadModuleFactory() {
        if (this.mLynxViewBuilder.isEnableMTSModule() == true) goto L5;
        return;
    L5:
        this.mMainThreadModuleFactory = new LynxModuleFactory();
        d r0 = new d(this);
        LynxModuleFactory r1 = this.mMainThreadModuleFactory;
        r1.c = new com.lynx.jsbridge.a(r0);
        setLynxInternalModules(this.mMainThreadModuleFactory);
        setUserModules(this.mMainThreadModuleFactory);
    }

    private void setupReusedLynxEngine() {
        this.mLynxEngineRef.e(LynxEngine.LynxEngineState.ON_REUSING);
        LynxEngine r0 = this.mLynxEngineRef;
        LynxTemplateRender r1 = r0.a.get();
        if (r0.b == 0) goto L6;
        if (r1 == null) goto L6;
        r1.detachLynxEngineWrapper();
        r0.a.clear();
    L6:
        ILynxUIRenderer r2 = this.mLynxEngineRef.f;
        this.mLynxUIRender = r2;
        LynxUIRenderer r3 = (LynxUIRenderer) r2;
        r3.c(this.mBodyView, this.mLynxContext, this.mContext);
        LynxEngine r4 = this.mLynxEngineRef;
        r4.getClass();
        r4.a = new WeakReference(this);
        WeakReference<TasmPlatformInvoker> r5 = new WeakReference(this.mLynxEngineRef.g);
        this.mTasmPlatformInvoker = r5;
        if (r5.get() == null) goto L9;
        TasmPlatformInvoker r6 = this.mTasmPlatformInvoker.get();
        NativeFacade r7 = this.mNativeFacade;
        r6.getClass();
        r6.a = new WeakReference(r7);
    L9:
        setupReusedEngineConfig();
    }

    private boolean shouldCacheLynxEngine() {
        if (this.mEnableCacheEngine == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mCacheManager == null) goto L11;
        LynxEngine r0 = this.mLynxEngineRef;
        if (r0 == null) goto L11;
        if (r0.c() == false) goto L11;
        return true;
    }

    private TasmPlatformInvoker tasmPlatformInvoker() {
        WeakReference<TasmPlatformInvoker> r0 = this.mTasmPlatformInvoker;
        if (r0 != null) goto L5;
    L7:
        TasmPlatformInvoker r1 = new TasmPlatformInvoker(this.mNativeFacade);
        this.mTasmPlatformInvoker = new WeakReference(r1);
        return r1;
    L5:
        if (r0.get() == null) goto L7;
        TasmPlatformInvoker r2 = this.mTasmPlatformInvoker.get();
        NativeFacade r3 = this.mNativeFacade;
        r2.getClass();
        r2.a = new WeakReference(r3);
        return r2;
    }

    private void tryRegisterLynxEngineReused() {
        if (this.mEnableCacheEngine == false) goto L9;
        LynxEngine r0 = this.mLynxEngineRef;
        if (r0 == null) goto L9;
        r0.e(LynxEngine.LynxEngineState.READY_BE_REUSED);
        return;
    L9:
        if (this.mEnableReuseEngine == true) goto L12;
        return;
    L12:
        if (this.mLynxContext == null) goto L19;
        ILynxUIRenderer r1 = this.mLynxUIRender;
        if (r1 == null) goto L19;
        if (((LynxUIRenderer) r1).g() == null) goto L19;
        this.mLynxContext.setPlatformMeasureWidthCache(((LynxUIRenderer) this.mLynxUIRender).g().getWidth());
        this.mLynxContext.setPlatformMeasureHeightCache(((LynxUIRenderer) this.mLynxUIRender).g().getHeight());
    L19:
        if (this.mLynxEngineRef != null) goto L21;
        return;
    L21:
        if (this.mEmbeddedPipelineCounter.decrementAndGet() != 0) goto L34;
        LynxEngine r2 = this.mLynxEngineRef;
        r2.getClass();
        r2.e(LynxEngine.LynxEngineState.READY_BE_REUSED);
        com.lynx.tasm.u r3 = com.lynx.tasm.u.b.a;
        r3.getClass();
        LinkedList<LynxEngine> r4 = r3.a(r2.c);
        if (TraceEvent.isTracingStarted() == false) goto L25;
        HashMap r5 = new HashMap();
        r5.put("engineQueue", r4.toString());
        r5.put("registerEngine", String.valueOf(r2));
        r5.put("templateBundle", String.valueOf(r2.c));
        TraceEvent.beginSection("LynxEnginePool.registerReuseEngineWrapper", r5);
    L25:
        monitor-enter(r3);
    L31:
        th = move-exception;
        throw th;
    L27:
        if (r4.contains(r2) == true) goto L29;
        r4.offer(r2);     // Catch: Throwable -> L31
    L29:
        monitor-exit(r3);     // Catch: Throwable -> L31
        new WeakReference(r4);
        LLog.i("LynxEnginePool", "registerReuseEngineWrapper EngineQueue Cache: " + r4 + ", bundle:" + r2.c);
        TraceEvent.endSection("LynxEnginePool.registerReuseEngineWrapper");
        return;
    L34:
        LLog.e(TAG, "Can not call registerLynxEngineReused, because next pipeline is running. mEmbeddedPipelineCounter:" + this.mEmbeddedPipelineCounter.get());
    }

    private void tryReuseLynxEngineFromPool() {
        if (this.mThreadStrategyForRendering != ThreadStrategyForRendering.MOST_ON_TASM) goto L5;
        return;
    L5:
        onTraceEventBegin("TemplateRender.tryReuseLynxEngineFromPool");
        com.lynx.tasm.u r0 = com.lynx.tasm.u.b.a;
        TemplateBundle r1 = this.mTemplateBundle;
        ThreadStrategyForRendering r2 = this.mThreadStrategyForRendering;
        LinkedList<LynxEngine> r3 = r0.a(r1);
        LLog.i("LynxEnginePool", "pollEngine EngineQueue Cache: " + r3 + ", bundle:" + r1);
        if (TraceEvent.isTracingStarted() == false) goto L8;
        HashMap r4 = new HashMap();
        r4.put("engineQueue", r3.toString());
        r4.put("templateBundle", String.valueOf(r1));
        TraceEvent.beginSection("LynxEnginePool.pollEngineFromPool", r4);
    L8:
        monitor-enter(r0);
        LynxEngine r5 = null;
        int r6 = 0;
        LynxEngine r7 = null;
    L36:
    L33:
        th = move-exception;
        throw th;
    L11:
        if (r6 >= r3.size()) goto L21;
        LynxEngine r8 = r3.get(r6);     // Catch: Throwable -> L33
        if (r2 != r8.e) goto L18;
        if (r8.d() == false) goto L18;
        r3.remove(r6);     // Catch: Throwable -> L33
        TraceEvent.endSection("pollEngineFromPool");     // Catch: Throwable -> L33
        r5 = r8;
    L18:
        if (r8.a() == false) goto L20;
        r7 = r8;
    L20:
        r6 = r6 + 1;     // Catch: Throwable -> L33
    L21:
        if (r5 != null) goto L26;
        if (r7 == null) goto L26;
        if (r7.d() == false) goto L26;
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L33
        TraceEvent.endSection("LynxEnginePool.pollEngineFromPool");
        this.mLynxEngineRef = r7;
        if (r7 == null) goto L31;
        setupReusedLynxEngine();
        this.mIsEngineFromReuse = true;
    L31:
        onTraceEventEnd("TemplateRender.tryReuseLynxEngineFromPool");
        return;
    L26:
        r7 = r5;
        goto L27
    }

    private void unregisterMemoryUsageFetcherIfNeeded() {
        if (this.mMemoryUsageFetcher != null) goto L5;
        return;
    L5:
        n0 r0 = n0.c;
        t0 r1 = this.mMemoryUsageFetcher;
        r0.a.remove(new n0.a(r1));
    }

    private void updateMemoryUsage() {
        if (this.mIsMemoryCollecting == false) goto L6;
        return;
    L6:
        if (PerformanceController.m() == true) goto L8;
        return;
    L8:
        this.mIsMemoryCollecting = true;
        if (PerformanceController.m < 0) goto L11;
        long r0 = PerformanceController.m;
    L19:
        u r2 = new u(this);
        UIThreadUtils.runOnUiThread(r2, r0 * 1000);
        return;
    L11:
        String r1 = LynxEnv.inst().getMemoryAcquisitionDelaySec();
        if (r1 != null) goto L14;
    L18:
        r0 = 2;
        goto L19
    L14:
        if (r1.isEmpty() == true) goto L18;
        r0 = CastLongProtector.parseLong(r1);     // Catch: NumberFormatException -> L22
        PerformanceController.m = r0;     // Catch: NumberFormatException -> L21
        goto L19
    }

    public void attachEngineToUIThread() {
        if (this.mNativePtr != 0) goto L5;
        return;
    L5:
        if (UIThreadUtils.isOnUiThread() == true) goto L9;
        LLog.e(TAG, "attachEngineToUIThread should be called on ui thread, url: " + this.mUrl);
        return;
    L9:
        if (checkEngineFallbackAndLoad(false) == false) goto L12;
        onThreadStrategyUpdated();
        return;
    L12:
        int r0 = c.b[this.mThreadStrategyForRendering.ordinal()];
        if (r0 != 1) goto L15;
        ThreadStrategyForRendering r1 = ThreadStrategyForRendering.ALL_ON_UI;
        this.mThreadStrategyForRendering = r1;
        if (this.mEnableReuseEngine == true) goto L21;
    L23:
        nativeAttachEngineToUIThread(this.mNativePtr, this.mNativeLifecycle);
        onThreadStrategyUpdated();
        markEngineIdle();
        return;
    L21:
        if (this.mLynxEngineRef == null) goto L23;
        markEngineInUse();
        this.mLynxEngineRef.e = r1;
        goto L23
    L15:
        if (r0 == 2) goto L17;
        return;
    L17:
        this.mThreadStrategyForRendering = ThreadStrategyForRendering.PART_ON_LAYOUT;
        goto L23
    }

    @Override // com.lynx.tasm.h
    public void destroy() {
        onTraceEventBegin("LynxTemplateRender.destroy");
        monitor-enter(this);
        this.mDestroying = true;     // Catch: Throwable -> L27
        StaticPageHost r1 = this.mStaticPageHost;     // Catch: Throwable -> L27
        this.mStaticPageHost = null;     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        LynxContext r3 = this.mLynxContext;
        if (r3 == null) goto L10;
        r3.clearExposure();
        int r4 = this.mLynxContext.getInstanceId();
        LynxFrameRecorder r5 = LynxFrameRecorder.k;
        r5.x(r4);
        r5.f.remove(Integer.valueOf(r4));
    L10:
        if (r1 == null) goto L12;
        r1.a();
    L12:
        recycleUpdatedDataList();
        recycleGlobalPropsSafely();
        destroyNative();
        onTraceEventBegin("Client.onReportComponentInfo");
        this.mClient.onReportComponentInfo(new HashSet());
        onTraceEventEnd("Client.onReportComponentInfo");
        i8a.b r2 = (i8a.b) i8a.n.c().a(i8a.b.class);
        if (r2 == null) goto L15;
        r2.onLynxViewDestroy(this.mLynxContext);
    L15:
        LynxContext r6 = this.mLynxContext;
        if (r6 != null) goto L18;
    L20:
        this.mLynxContext = null;
        ILynxUIRenderer r7 = this.mLynxUIRender;
        if (r7 == null) goto L25;
        LynxUIOwner r8 = ((LynxUIRenderer) r7).b;
        if (r8 == null) goto L25;
        r8.destroy();
    L25:
        LLog.i(TAG, formatLynxMessage("destroy"));
        onTraceEventEnd("LynxTemplateRender.destroy");
        return;
    L18:
        if (r6.getProviderRegistry() == null) goto L20;
        ((HashMap) this.mLynxContext.getProviderRegistry().a).clear();
    L27:
        th = move-exception;
        throw th;
    }

    public void detachEngineFromUIThread() {
        if (this.mNativePtr != 0) goto L5;
        return;
    L5:
        if (UIThreadUtils.isOnUiThread() == true) goto L8;
        LLog.e(TAG, "detachEngineFromUIThread should be called on ui thread, url: " + this.mUrl);
        return;
    L8:
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L10:
        if (this.mThreadStrategyForRendering == ThreadStrategyForRendering.ALL_ON_UI) goto L12;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L31
        if (checkEngineFallbackAndLoad(true) == false) goto L23;
        onThreadStrategyUpdated();
        return;
    L23:
        int r0 = c.b[this.mThreadStrategyForRendering.ordinal()];
        if (r0 != 3) goto L26;
        this.mThreadStrategyForRendering = ThreadStrategyForRendering.MOST_ON_TASM;
        disableEngineBeReused();
    L30:
        nativeDetachEngineFromUIThread(this.mNativePtr, this.mNativeLifecycle);
        onThreadStrategyUpdated();
        return;
    L26:
        if (r0 == 4) goto L28;
        return;
    L28:
        this.mThreadStrategyForRendering = ThreadStrategyForRendering.MULTI_THREADS;
        goto L30
    L12:
        if (this.mStaticPageHost == null) goto L18;
        if (this.mStaticPageHost.d() == false) goto L18;
        LLog.e(TAG, "Static page direct load does not support switching to MOST_ON_TASM");     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
    }

    public void detachLynxEngineWrapper() {
        if (this.mEnableReuseEngine == false) goto L5;
    L7:
        onTraceEventBegin("TemplateRender.detachLynxEngineWrapper");
        if (getLynxContext() == null) goto L13;
        if (getLynxContext().getUIBody() == null) goto L13;
        getLynxContext().getUIBody().detachUIBodyView();
    L13:
        if (this.mLynxEngineRef == null) goto L20;
        unregisterMemoryUsageFetcherIfNeeded();
        this.mLynxUIRender = null;
        UIBody.UIBodyView r2 = this.mBodyView;
        if (r2 == null) goto L17;
        r2.setLynxUIRendererInternal(null);
    L17:
        this.mLynxEngineRef = null;
        this.mTasmPlatformInvoker = null;
        LLog.i(TAG, this + ", call detachLynxEngineWrapper");
        long r1 = this.mNativePtr;
        if (r1 == 0) goto L20;
        nativeDetachLynxEngineWrapper(r1, this.mNativeLifecycle);
    L20:
        onTraceEventEnd("TemplateRender.detachLynxEngineWrapper");
        return;
    L5:
        if (this.mEnableCacheEngine == true) goto L7;
    }

    public Map<String, Object> getAllJsSource() {
        long r0 = this.mNativePtr;
        if (r0 != 0) goto L7;
        return null;
    L7:
        return nativeGetAllJsSource(r0, this.mNativeLifecycle);
    }

    public HashMap<String, Object> getAllTimingInfo() {
        long r0 = this.mNativePtr;
        if (r0 != 0) goto L5;
        return null;
    L5:
        return nativeGetAllTimingInfo(r0, this.mNativeLifecycle);
    }

    public long getListEngineProxy() {
        return nativeGetListEngineProxy(this.mNativePtr, this.mNativeLifecycle);
    }

    public UIGroup<UIBody.UIBodyView> getLynxRootUI() {
        ILynxUIRenderer r0 = this.mLynxUIRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((LynxUIRenderer) r0).g();
    }

    public LynxViewBuilder getLynxViewBuilder() {
        LynxViewBuilder r0 = new LynxViewBuilder().setLynxViewGroup(this.mLynxViewBuilder.lynxViewGroup);
        LynxViewBuilder r1 = r0.setUIRendererCreator(this.mLynxViewBuilder.getUIRendererCreator()).setFontLoader(this.mLynxViewBuilder.fontLoader);
        this.mLynxViewBuilder.getClass();
        r1.setImageFetcher(null).setFontScale(this.mLynxViewBuilder.getFontScale()).setColorScheme(this.mLynxViewBuilder.getColorScheme()).setEnablePreUpdateData(true).setEnableMultiAsyncThread(this.mLynxViewBuilder.isEnableMultiAsyncThread()).setLynxGroup(this.mLynxViewBuilder.getLynxGroup()).setDynamicComponentFetcher(this.mLynxViewBuilder.fetcher).setEnableUnifiedPipeline(this.mLynxViewBuilder.isEnableUnifiedPipeline()).setEnableGenericResourceFetcher(this.mLynxViewBuilder.getLynxRuntimeOptions().k);
        r0.mergeLynxRuntimeOptions(this.mLynxViewBuilder.getLynxRuntimeOptions()).setScreenSize(this.mLynxViewBuilder.getScreenWidth(), this.mLynxViewBuilder.getScreenHeight()).setThreadStrategyForRendering(this.mLynxViewBuilder.getThreadStrategy());
        r0.setCustomBehaviorRegistry(this.mLynxViewBuilder.getBehaviorRegistry());
        Float r2 = this.mLynxViewBuilder.getDensity();
        if (r2 == null) goto L5;
        r0.setDensity(r2.floatValue());
    L5:
        return r0;
    }

    public String getPageVersion() {
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0.getPageVersion();
    }

    public TemplateData getTemplateData() {
        return this.mTemplateData.shallowClone();
    }

    public String getTemplateUrl() {
        String r0 = this.mUrl;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0;
    }

    public boolean isEnableReuseEngine() {
        if (this.mEnableReuseEngine == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mEnableCacheEngine == true) goto L8;
        return false;
    }

    public ILynxUIRenderer lynxUIRenderer() {
        if (this.mLynxUIRender != null) goto L9;
        UIBody.UIBodyView r0 = this.mBodyView;
        if (r0 == null) goto L7;
        this.mLynxUIRender = r0.getLynxUIRendererInternal();
        goto L9
    L7:
        ((com.lynx.tasm.behavior.l0) this.mLynxViewConfigProvider.getUIRendererCreator()).getClass();
        this.mLynxUIRender = new LynxUIRenderer();
    L9:
        return this.mLynxUIRender;
    }

    public void onAttachedToWindow() {
        if (this.mEnableReuseEngine == true) goto L5;
    L9:
        String r0 = "lynxview onAttachedToWindow " + this;
        LLog.i(TAG, r0);
        onTraceEventBegin(r0);
        onEnterForeground(false);
        ILynxUIRenderer r1 = this.mLynxUIRender;
        if (r1 == null) goto L17;
        LynxUIOwner r2 = ((LynxUIRenderer) r1).b;
        if (r2 == null) goto L17;
        UIBody r3 = r2.getRootUI();
        if (r3 == null) goto L17;
        r3.onAttach();
    L17:
        LynxContext r4 = this.mLynxContext;
        if (r4 == null) goto L20;
        r4.onAttachedToWindow();
    L20:
        onTraceEventEnd(r0);
        return;
    L5:
        if (this.mLynxEngineRef == null) goto L9;
        if (this.mThreadStrategyForRendering != ThreadStrategyForRendering.MOST_ON_TASM) goto L9;
        disableEngineBeReused();
        goto L9
    }

    public void onDetachedFromWindow() {
        String r0 = "lynxview onDetachedFromWindow " + toString();
        LLog.i(TAG, r0);
        onTraceEventBegin(r0);
        if (this.mLynxUIRender == null) goto L10;
        TraceEvent.beginSection("Client.onReportComponentInfo");
        this.mClient.onReportComponentInfo(new HashSet());
        TraceEvent.endSection("Client.onReportComponentInfo");
        LynxUIOwner r1 = ((LynxUIRenderer) this.mLynxUIRender).b;
        if (r1 == null) goto L10;
        UIBody r2 = r1.getRootUI();
        if (r2 == null) goto L10;
        r2.onDetach();
    L10:
        onEnterBackground(false);
        onTraceEventEnd(r0);
    }

    public void pauseRootLayoutAnimation() {
        ILynxUIRenderer r0 = this.mLynxUIRender;
        if (r0 == null) goto L8;
        LynxUIOwner r1 = ((LynxUIRenderer) r0).b;
        if (r1 == null) goto L9;
        r1.pauseRootLayoutAnimation();
        return;
    L9:
        return;
    }

    public void processRender() {
        onTraceEventBegin("TemplateRender.processRender");
        if (this.mNativePtr != 0) goto L5;
    L7:
        onTraceEventEnd("TemplateRender.processRender");
        return;
    L5:
        if (this.mEnableUIFlush == true) goto L7;
        setEnableUIFlush(true);
        nativeProcessRender(this.mNativePtr, this.mNativeLifecycle);
        goto L7
    }

    public void resumeRootLayoutAnimation() {
        ILynxUIRenderer r0 = this.mLynxUIRender;
        if (r0 == null) goto L8;
        LynxUIOwner r1 = ((LynxUIRenderer) r0).b;
        if (r1 == null) goto L9;
        r1.resumeRootLayoutAnimation();
        return;
    L9:
        return;
    }

    public void startLynxRuntime() {
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L6;
        this.mEnablePendingJsTask = false;
        nativeStartRuntime(r0, this.mNativeLifecycle);
        return;
    }

    public void syncFlush() {
        if ((this.mEmbeddedMode & 8) <= 0) goto L6;
        LLog.i(TAG, "Skip syncFlush in Fragment Layer.");
        return;
    L6:
        doSyncFlush();
    }

    private void prepareLynxEngineIfNeeded() {
        if (checkIfEnvPrepared() == true) goto L7;
        onErrorOccurred(10202, "LynxEnv has not been prepared successfully!");
        return;
    L7:
        if (this.mSSRHelper == null) goto L9;
        onLoadTemplateFromSSRPage();
    L9:
        this.mWillContentSizeChange = true;
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L12;
        nativeMarkDirty(r0, this.mNativeLifecycle);
    L12:
        reloadAndInit();
        updateGenericInfoURL(this.mUrl);
        if (this.mNativeFacade == null) goto L18;
        NativeFacade r1 = this.mNativeFacade;
        r1.b = this.mClient;
        dispatchOnPageStart(this.mUrl);
        LynxDevtool r2 = this.mDevTool;
        if (r2 == null) goto L19;
        r2.attachToDebugBridge(this.mUrl);
        return;
    L19:
        return;
    }

    private void reloadAndInitUIThreadPart() {
        ILynxUIRenderer r0 = lynxUIRenderer();
        if (r0 == null) goto L7;
        UIThreadUtils.assertOnUiThread();
        LynxUIOwner r1 = ((LynxUIRenderer) r0).b;
        if (r1 == null) goto L7;
        r1.reset();
    L7:
        UIBody.UIBodyView r2 = this.mBodyView;
        if (r2 == null) goto L11;
        r2.removeAllViews();
        return;
    }

    private void reuseLynxEngine() {
        tryReuseLynxEngineFromPool();
        if (this.mLynxEngineRef != null) goto L5;
        ensureLynxEngine();
        this.mIsEngineFromReuse = false;
    L5:
        TemplateData r0 = this.mTemplateData;
        if (r0 == null) goto L9;
        r0.setEnableJSData(false);
        return;
    }

    private void setupReusedEngineConfig() {
        if (isEnableReuseEngine() == true) goto L5;
        return;
    L5:
        LynxEngine r0 = this.mLynxEngineRef;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.c() == false) goto L15;
        TemplateBundle r1 = this.mTemplateBundle;
        if (r1 == null) goto L12;
        t1 r2 = r1.e;
    L13:
        t1.a(r2, this.mLynxContext, this.mLynxUIRender);
        goto L15
    L12:
        r2 = this.mLynxEngineRef.h;
    L15:
        if (this.mLynxEngineRef.c() == true) goto L21;
        WeakReference<TasmPlatformInvoker> r3 = this.mTasmPlatformInvoker;
        if (r3 == null) goto L22;
        LynxEngine r4 = this.mLynxEngineRef;
        r4.g = r3.get();
        return;
    L22:
        return;
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroyNative();
    }

    public boolean shouldSendEventToMainThread() {
        if (checkIfEnvPrepared() == false) goto L9;
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L9;
        if (nativeShouldSendEventToMainThread(r0, this.mNativeLifecycle) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean checkIfEnvPrepared() {
        return this.mHasEnvPrepared;
    }

    public boolean enableAirStrictMode() {
        return this.mEnableAirStrictMode;
    }

    public boolean enableJSRuntime() {
        return this.mEnableJSRuntime;
    }

    public LynxDevtool getDevTool() {
        return this.mDevTool;
    }

    public LynxEngineProxy getEngineProxy() {
        return this.mEngineProxy;
    }

    public long getFirstMeasureTime() {
        return this.mFirstMeasureTime;
    }

    public LynxContext getLynxContext() {
        return this.mLynxContext;
    }

    public PerformanceController getPerformanceController() {
        return this.mPerformanceController;
    }

    public String getRenderPhase() {
        return this.mRenderPhase;
    }

    public k8a.a getTheme() {
        return this.mTheme;
    }

    public final ThreadStrategyForRendering getThreadStrategyForRendering() {
        return this.mThreadStrategyForRendering;
    }

    public LynxTemplateRender(LynxViewBuilder r5) {
        this.mTemplateAssembler = new z1();
        this.reload = false;
        this.mHasDestroy = false;
        this.mDestroying = false;
        this.mClient = new r1();
        this.mClientV2 = new s1();
        this.mFirstMeasureTime = -1;
        this.updatedDataList = new CopyOnWriteArrayList();
        this.mIsMemoryCollecting = false;
        this.mEnablePendingJsTask = false;
        this.mEnableGenericResourceFetcher = false;
        this.mShouldUpdateViewport = true;
        this.mFontScale = 1.0f;
        this.mLongTaskMonitorEnabled = LynxBooleanOption.UNSET;
        this.mEnableUIFlush = true;
        this.mVsyncAlignedFlushEnabled = true;
        this.mReportHelper = new q0();
        this.mPerformanceController = new PerformanceController();
        this.mRenderPhase = RENDER_PHASE_SETUP;
        this.mHasSubmittedViewport = false;
        this.mHasFragmentLayerRenderSyncFlushed = false;
        this.mForceLayoutOnBackgroundThread = LynxEnv.inst().shouldForceLayoutOnBackgroundThread();
        this.mNativeShellLifecycleLock = new Object();
        this.platformCallBackMap = new HashMap();
        this.mIsDestroyed = new AtomicBoolean(true);
        this.mCleanupReference = null;
        this.mNativePtr = 0;
        this.mLynxGetDataCounter = new AtomicInteger(0);
        this.mCallbackSparseArray = new SparseArray();
        this.mEmbeddedPipelineCounter = new AtomicInteger(0);
        this.mTemplateData = TemplateData.fromMap(new HashMap());
        init(null, null, r5);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_tasm_LynxTemplateRender_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ PerformanceController access$1000(LynxTemplateRender r0) {
        return r0.mPerformanceController;
    }

    public static /* synthetic */ ILynxUIRenderer access$1400(LynxTemplateRender r0) {
        return r0.mLynxUIRender;
    }

    public static /* synthetic */ r1 access$1500(LynxTemplateRender r0) {
        return r0.mClient;
    }

    public static /* synthetic */ void access$1800(LynxTemplateRender r0) {
        r0.updateMemoryUsage();
    }

    public static /* synthetic */ String access$1900(LynxTemplateRender r0) {
        return r0.buildInstanceLogContext();
    }

    public static /* synthetic */ LynxContext access$200(LynxTemplateRender r0) {
        return r0.mLynxContext;
    }

    public static /* synthetic */ LynxSSRHelper access$2200(LynxTemplateRender r0) {
        return r0.mSSRHelper;
    }

    public static /* synthetic */ p access$2300(LynxTemplateRender r0) {
        return r0.mPageLoadListener;
    }

    public static /* synthetic */ k8a.a access$2400(LynxTemplateRender r0) {
        return r0.mTheme;
    }

    public static /* synthetic */ LynxView access$2500(LynxTemplateRender r0) {
        return r0.getLynxView();
    }

    public static /* synthetic */ LynxEngine access$2600(LynxTemplateRender r0) {
        return r0.mLynxEngineRef;
    }

    public static /* synthetic */ void access$2700(LynxTemplateRender r0) {
        r0.tryRegisterLynxEngineReused();
    }

    public static /* synthetic */ long access$2800(LynxTemplateRender r2) {
        return r2.mNativePtr;
    }

    public static /* synthetic */ long access$2900(LynxTemplateRender r2) {
        return r2.mNativeLifecycle;
    }

    public static /* synthetic */ boolean access$300(LynxTemplateRender r0) {
        return r0.mDestroying;
    }

    public static /* synthetic */ LynxEngineProxy access$3100(LynxTemplateRender r0) {
        return r0.mEngineProxy;
    }

    public static /* synthetic */ JSProxy access$3200(LynxTemplateRender r0) {
        return r0.mJSProxy;
    }

    public static /* synthetic */ com.lynx.tasm.j access$3400(LynxTemplateRender r0) {
        r0.getClass();
        return null;
    }

    public static /* synthetic */ Object access$3500(LynxTemplateRender r0) {
        return r0.mNativeShellLifecycleLock;
    }

    public static /* synthetic */ boolean access$3600(long r0) {
        return nativeLifecycleTryTerminate(r0);
    }

    public static /* synthetic */ void access$3700(long r0) {
        nativeDestroy(r0);
    }

    public static /* synthetic */ void access$3900(long r0) {
        nativeLifecycleDestroy(r0);
    }

    public static /* synthetic */ boolean access$400(LynxTemplateRender r0) {
        return r0.mHasDestroy;
    }

    public static /* synthetic */ LynxDevtool access$900(LynxTemplateRender r0) {
        return r0.mDevTool;
    }

    private boolean checkEnableGenericResourceFetcher(LynxBooleanOption r2) {
        if (r2 != LynxBooleanOption.UNSET) goto L7;
        return LynxEnv.inst().enableGenericResourceFetcher();
    L7:
        if (r2 != LynxBooleanOption.TRUE) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean checkEngineFallbackAndLoad(boolean r2) {
        if (this.mEnableReuseEngine == true) goto L5;
        return false;
    L5:
        if (this.mLynxEngineRef != null) goto L10;
        fallbackNewEngine(r2);
        s0.a r3 = new s0.a();
        r3.a(LynxLoadOption.RENDER_FOR_RECREATE_ENGINE);
        r3.d = this.mTemplateData;
        r3.a = this.mUrl;
        r3.c = this.mTemplateBundle;
        loadTemplate(r3.b());
        ((LynxUIRenderer) this.mLynxUIRender).b.performMeasure();
        ((LynxUIRenderer) this.mLynxUIRender).b.performLayout();
        return true;
    L10:
        return false;
    }

    private void createLynxEngine(int r47) {
        if (checkIfEnvPrepared() == true) goto L6;
        return;
    L6:
        if (this.mIsDestroyed.compareAndSet(true, false) == true) goto L8;
        return;
    L8:
        TraceEvent.beginSection("TemplateRender.createLynxEngine");
        y6a.f r10 = createLayoutTickForCurrentStrategy();
        LLog.i(TAG, "mEnableGenericResourceFetcher: " + this.mEnableGenericResourceFetcher + " render: " + this);
        if (this.mEnableGenericResourceFetcher == false) goto L11;
        this.mLynxContext.setGenericResourceFetcher(this.mLynxViewConfigProvider.getLynxGenericResourceFetcher());
        this.mLynxContext.setMediaResourceFetcher(this.mLynxViewConfigProvider.getLynxMediaResourceFetcher());
        this.mLynxContext.setTemplateResourceFetcher(this.mLynxViewConfigProvider.getLynxTemplateResourceFetcher());
    L11:
        this.mPageLoadListener = new p(this);
        this.mGroup = this.mLynxViewBuilder.getLynxGroup();
        this.mLoader = new LynxResourceLoader(null, this.mLynxViewBuilder.fetcher, this, this.mLynxContext.getTemplateResourceFetcher(), this.mLynxContext.getGenericResourceFetcher());
        this.mLynxContext.setEnableAutoExpose(this.mLynxViewConfigProvider.isEnableAutoExpose());
        this.mNativeFacade = new NativeFacade(this.mLynxViewBuilder.isEnableJSRuntime());
        this.mNativeFacade.a = new t(this);
        DisplayMetrics r0 = this.mLynxContext.getScreenMetrics();
        LynxBackgroundRuntime r1 = this.mRuntime;
        if (r1 != null) goto L14;
        long r11 = 0;
    L15:
        LynxGroup r2 = this.mGroup;
        if (r2 != null) goto L18;
        long r31 = 0;
    L19:
        LynxUIRenderer r3 = (LynxUIRenderer) lynxUIRenderer();
        r3.k(this.mLynxContext, this.mThreadStrategyForRendering, this.mLynxViewConfigProvider.getBehaviorRegistry(), r10);
        TasmPlatformInvoker r30 = tasmPlatformInvoker();
        if (this.mLynxViewConfigProvider.isEnableVSyncAlignedMessageLoop() == false) goto L22;
    L25:
        boolean r4 = true;
    L26:
        setUpMainThreadModuleFactory();
        NativeFacade r13 = this.mNativeFacade;
        PerformanceController r5 = this.mPerformanceController;
        if (r5.e == false) goto L29;
        PerformanceController r14 = null;
    L30:
        LynxResourceLoader r6 = this.mLoader;
        int r16 = this.mThreadStrategyForRendering.id();
        boolean r17 = this.mLynxViewConfigProvider.isEnableLayoutSafepoint();
        boolean r12 = this.mLynxViewBuilder.enableLayoutOnly;
        int r7 = r0.widthPixels;
        int r8 = r0.heightPixels;
        float r9 = r0.density;
        String r22 = LynxEnv.inst().getLocale();
        boolean r23 = this.mLynxViewBuilder.isEnableJSRuntime();
        boolean r24 = this.mLynxViewConfigProvider.isEnableMultiAsyncThread();
        boolean r25 = this.mLynxViewConfigProvider.isEnablePreUpdateData();
        boolean r27 = this.mLynxViewConfigProvider.isEnableAsyncHydration();
        LynxGroup r15 = this.mGroup;
        if (r15 != null) goto L33;
    L35:
        boolean r28 = false;
    L36:
        String r29 = getJSGroupThreadNameIfNeed();
        long r33 = r3.j();
        if (this.mLongTaskMonitorEnabled != LynxBooleanOption.FALSE) goto L39;
        boolean r36 = true;
    L40:
        boolean r18 = this.mForceLayoutOnBackgroundThread;
        boolean r38 = this.mLynxViewConfigProvider.isEnableUnifiedPipeline();
        int r19 = this.mEmbeddedMode;
        boolean r41 = this.mLynxViewBuilder.isDebuggable();
        LynxEngine r110 = this.mLynxEngineRef;
        if (r110 != null) goto L43;
        long r42 = 0;
    L44:
        LynxModuleFactory r20 = this.mMainThreadModuleFactory;
        if (r20 == null) goto L47;
        LynxModuleFactory r44 = r20;
    L48:
        this.mNativePtr = nativeCreate(r11, r13, r14, r6, r16, r17, r12, r7, r8, r9, r22, r23, r24, r25, r4, r27, r28, r29, r30, r31, r33, false, r36, r18, r38, r19, false, r41, r42, r44);
        NativeFacade r21 = this.mNativeFacade;
        if (r3.b == null) goto L51;
        r3.b.attachNativeFacade(r21);
    L51:
        long r26 = this.mNativePtr;
        com.lynx.tasm.behavior.l r32 = r3.e;
        if (r32 == null) goto L54;
        r32.d(r26);
    L54:
        this.mNativeLifecycle = nativeLifecycleCreate();
        this.mCleanupReference = new com.lynx.tasm.base.c(this, new m(this.mNativeLifecycle));
        this.mLynxContext.setListNodeInfoFetcher(new com.lynx.tasm.l(this));
        this.mLynxContext.setEnableVSyncAligned(r4);
        LynxDevtool r34 = this.mDevTool;
        if (r34 == null) goto L57;
        r34.onTemplateAssemblerCreated(this.mNativePtr);
    L57:
        d8a.f r35 = new d8a.f();
        Iterator<Map.Entry<String, d8a.k>> r37 = LynxEnv.inst().getResourceProvider().entrySet().iterator();
    L59:
        if (r37.hasNext() == false) goto L63;
        Map.Entry<String, d8a.k> r39 = r37.next();
        String r40 = r39.getKey();
        d8a.k r43 = r39.getValue();
        if (TextUtils.isEmpty(r40) == true) goto L59;
        ((HashMap) r35.a).put(r40, r43);
        goto L59
    L63:
        Iterator r45 = ((HashMap) this.mLynxRuntimeOptions.e).entrySet().iterator();
    L65:
        if (r45.hasNext() == false) goto L69;
        Map.Entry r46 = (Map.Entry) r45.next();
        String r48 = (String) r46.getKey();
        d8a.k r49 = (d8a.k) r46.getValue();
        if (TextUtils.isEmpty(r48) == true) goto L65;
        ((HashMap) r35.a).put(r48, r49);
        goto L65
    L69:
        this.mLynxContext.setProviderRegistry(r35);
        this.mLynxContext.setFontLoader(this.mLynxViewBuilder.fontLoader);
        LynxContext r50 = this.mLynxContext;
        this.mLynxViewBuilder.getClass();
        r50.setImageFetcher(null);
        this.mLynxContext.setLynxExtraData(this.mLynxViewBuilder.lynxModuleExtraData);
        NativeFacade r51 = this.mNativeFacade;
        LynxContext r52 = this.mLynxContext;
        r51.getClass();
        r51.f = new WeakReference(r52);
        int r53 = nativeGetInstanceId(this.mNativePtr, this.mNativeLifecycle);
        if (r53 < 0) goto L74;
        this.mLynxContext.setInstanceId(r53);
        PerformanceController r54 = this.mPerformanceController;
        r54.h = r53;
        c8a.b r55 = r54.a;
        if (r55 == null) goto L74;
        r55.g = r53;
    L74:
        registerMemoryUsageFetcherIfNeeded();
        UIBody.UIBodyView r56 = this.mBodyView;
        if (r56 == null) goto L77;
        r56.setInstanceId(this.mLynxContext.getInstanceId());
        r1 r57 = this.mClient;
        this.mLynxContext.getInstanceId();
        r57.getClass();
        s1 r58 = this.mClientV2;
        this.mLynxContext.getInstanceId();
        r58.getClass();
    L77:
        LynxContext r59 = this.mLynxContext;
        if (r59 == null) goto L83;
        if (r59.enableEventReporter() == false) goto L83;
        LynxEventReporter.updateGenericInfo(LynxEventReporter.PROP_NAME_THREAD_MODE, Integer.valueOf(this.mThreadStrategyForRendering.id()), this.mLynxContext.getInstanceId());
        LynxEventReporter.moveExtraParams(r47, this.mLynxContext.getInstanceId());
    L83:
        if (this.mLynxContext != null) goto L85;
    L99:
        this.mIntersectionObserverManager = new com.lynx.tasm.behavior.d0(this.mLynxContext, this.mJSProxy);
        this.mLynxContext.setIntersectionObserverManager(this.mIntersectionObserverManager);
        initEngineAndLayoutProxies();
        b0 r60 = new b0(this.mEngineProxy);
        r60.addObserver(this.mIntersectionObserverManager);
        r60.registerEventReporter(this.mNativeFacade);
        r60.registerEventFallback(this);
        this.mLynxContext.setEventEmitter(r60);
        setThemeInternal(this.mTheme);
        updateGlobalPropsInternal(this.globalProps);
        float r61 = this.mFontScale;
        if (r61 == 1.0f) goto L102;
        nativeSetFontScale(this.mNativePtr, this.mNativeLifecycle, r61);
    L102:
        LynxColorScheme r62 = this.mLynxViewConfigProvider.getColorScheme();
        if (r62 == LynxColorScheme.LIGHT) goto L105;
        nativeUpdateColorScheme(this.mNativePtr, this.mNativeLifecycle, r62.id(), true);
    L105:
        nativeOnLynxEngineCreated(this.mNativePtr, ((LynxUIRenderer) lynxUIRenderer()).j());
        TraceEvent.endSection("TemplateRender.createLynxEngine");
        return;
    L85:
        if (enableJSRuntime() == false) goto L87;
    L88:
        setUpBackgroundThreadModuleFactory();
    L90:
        if (enableJSRuntime() == false) goto L99;
        this.mResourceLoader = new LynxResourceLoader(this.mLynxRuntimeOptions, this.mLynxViewBuilder.fetcher, this, this.mLynxContext.getTemplateResourceFetcher(), this.mLynxContext.getGenericResourceFetcher());
        if (this.mRuntime == null) goto L94;
        attachPiper(this.mRuntime, this.mModuleFactory);
        this.mRuntime = null;
    L95:
        setUpExtensionModules();
        LynxDevtool r63 = this.mDevTool;
        if (r63 == null) goto L98;
        r63.onRegisterModule(this.mModuleFactory);
    L98:
        this.mLynxContext.setJSProxy(this.mJSProxy);
        goto L99
    L94:
        initPiper();
        goto L95
    L87:
        if (this.mLynxViewBuilder.isEnableLepusModule() == false) goto L90;
    L47:
        r44 = null;
        goto L48
    L43:
        r42 = r110.b;
        goto L44
    L39:
        r36 = false;
        goto L40
    L33:
        if (r15.enableJSGroupThread() == false) goto L35;
        r28 = true;
        goto L36
    L29:
        r14 = r5;
        goto L30
    L22:
        if (LynxEnv.inst().enableVSyncAlignedMessageLoopGlobal() == true) goto L25;
        r4 = false;
        goto L26
    L18:
        r31 = r2.getWhiteBoardPtr();
        goto L19
    L14:
        r11 = r1.f;
        goto L15
    }

    private static Object decodeByteBuffer(ByteBuffer r1) {
        if (r1 == null) goto L5;
        j7a.a.a.getClass();
        return j7a.a.a(r1);
    L5:
        return null;
    }

    private void dispatchLoadSuccess(int r2) {
        LLog.i(TAG, "dispatchLoadSuccess templateSize in " + toString());
        if (this.mClient != null) goto L5;
        return;
    L5:
        onTraceEventBegin("Client.onLoadSuccess");
        this.mClient.onLoadSuccess();
        onTraceEventEnd("Client.onLoadSuccess");
    }

    private void dispatchOnPageStart(String r4) {
        LLog.i(TAG, "dispatchOnPageStart url " + r4 + " in " + toString());
        if (this.mHasPageStart == false) goto L5;
        return;
    L5:
        if (this.mClient == null) goto L15;
        this.mHasPageStart = true;
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L10;
    L12:
        TraceEvent.instant(1, "StartLoad");
        onTraceEventBegin("Client.onPageStart");
        this.mClient.onPageStart(r4);
        LynxViewClientV2.LynxPipelineInfo r5 = new LynxViewClientV2.LynxPipelineInfo();
        LynxViewClientV2.LynxPipelineInfo.LynxPipelineOrigin.LYNX_FIRST_SCREEN.getValue();
        this.mClientV2.b(getLynxView(), r5);
        onTraceEventEnd("Client.onPageStart");
        return;
    L10:
        if (r0.enableEventReporter() == false) goto L12;
        LynxEventReporter.onEvent(EVENT_NAME_LYNX_OPEN_PAGE, null, this.mLynxContext.getInstanceId());
        goto L12
    }

    private synchronized void fallbackNewEngine(boolean r13) {
        monitor-enter(this);
    L54:
        th = move-exception;
        throw th;
    L5:
        if (UIThreadUtils.isOnUiThread() == true) goto L10;
        LLog.e(TAG, "fallbackNewEngine should be called on ui thread, url: " + this.mUrl);     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L10:
        if (this.mHasDestroy == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        onTraceEventBegin("TemplateRender.fallbackNewEngine");     // Catch: Throwable -> L54
        LLog.i(TAG, "call fallbackNewEngine enable_async:" + r13);     // Catch: Throwable -> L54
        this.mEnableReuseEngine = false;     // Catch: Throwable -> L54
        this.reload = false;     // Catch: Throwable -> L54
        this.mHasPageStart = false;     // Catch: Throwable -> L54
        this.mSSRHelper = null;     // Catch: Throwable -> L54
        this.mRenderPhase = RENDER_PHASE_SETUP;     // Catch: Throwable -> L54
        LynxContext r2 = this.mLynxContext;     // Catch: Throwable -> L54
        if (r2 == null) goto L16;
        r2.clearExposure();     // Catch: Throwable -> L54
    L16:
        TemplateData r3 = this.globalProps;     // Catch: Throwable -> L54
        if (r3 == null) goto L20;
        this.globalProps = r3.deepClone();     // Catch: Throwable -> L54
    L20:
        if (this.mNativePtr != 0) goto L22;
    L24:
        int r4 = this.mPreWidthMeasureSpec;     // Catch: Throwable -> L54
        int r5 = this.mPreHeightMeasureSpec;     // Catch: Throwable -> L54
        this.mPreWidthMeasureSpec = 0;     // Catch: Throwable -> L54
        this.mPreHeightMeasureSpec = 0;     // Catch: Throwable -> L54
        this.mLynxEngineRef = null;     // Catch: Throwable -> L54
        this.mIsEngineFromReuse = false;     // Catch: Throwable -> L54
        recreateLynxUIRenderer();     // Catch: Throwable -> L54
        LynxContext r0 = this.mLynxContext;     // Catch: Throwable -> L54
        if (r0 == null) goto L27;
        r0.reset();     // Catch: Throwable -> L54
    L27:
        ILynxUIRenderer r1 = this.mLynxUIRender;     // Catch: Throwable -> L54
        if (r1 == null) goto L32;
        ((LynxUIRenderer) r1).m(this.mLynxContext, this.mLynxViewConfigProvider.getBehaviorRegistry(), this.mBodyView, this.mLongTaskMonitorEnabled);     // Catch: Throwable -> L54
        LynxDevtool r6 = this.mDevTool;     // Catch: Throwable -> L54
        if (r6 == null) goto L32;
        r6.attachLynxUIOwner(((LynxUIRenderer) this.mLynxUIRender).b);     // Catch: Throwable -> L54
    L32:
        if (r13 == false) goto L34;
        ThreadStrategyForRendering r14 = ThreadStrategyForRendering.MOST_ON_TASM;     // Catch: Throwable -> L54
    L35:
        this.mThreadStrategyForRendering = r14;     // Catch: Throwable -> L54
        if (this.mNativePtr != 0) goto L38;
    L50:
        createLynxEngine(-1);     // Catch: Throwable -> L54
    L51:
        updateViewport(r4, r5);     // Catch: Throwable -> L54
        this.mLynxContext.markFallbackProcess(true);     // Catch: Throwable -> L54
        onTraceEventEnd("TemplateRender.fallbackNewEngine");     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L38:
        if (LynxEnv.inst().enableFallbackNewEngineRebuild() == false) goto L50;
        TasmPlatformInvoker r10 = tasmPlatformInvoker();     // Catch: Throwable -> L54
        y6a.f r15 = createLayoutTickForCurrentStrategy();     // Catch: Throwable -> L54
        ((LynxUIRenderer) this.mLynxUIRender).k(this.mLynxContext, this.mThreadStrategyForRendering, this.mLynxViewConfigProvider.getBehaviorRegistry(), r15);     // Catch: Throwable -> L54
        long r7 = this.mNativePtr;     // Catch: Throwable -> L54
        long r8 = this.mNativeLifecycle;     // Catch: Throwable -> L54
        long r9 = ((LynxUIRenderer) this.mLynxUIRender).j();     // Catch: Throwable -> L54
        LynxModuleFactory r16 = this.mMainThreadModuleFactory;     // Catch: Throwable -> L54
        if (r16 == null) goto L42;
        LynxModuleFactory r11 = r16;
    L43:
        nativeRebuildLynxEngine(r7, r8, r9, r10, r11);     // Catch: Throwable -> L54
        ILynxUIRenderer r17 = this.mLynxUIRender;     // Catch: Throwable -> L54
        NativeFacade r12 = this.mNativeFacade;     // Catch: Throwable -> L54
        LynxUIRenderer r18 = (LynxUIRenderer) r17;     // Catch: Throwable -> L54
        if (r18.b == null) goto L46;
        r18.b.attachNativeFacade(r12);     // Catch: Throwable -> L54
    L46:
        ILynxUIRenderer r19 = this.mLynxUIRender;     // Catch: Throwable -> L54
        long r20 = this.mNativePtr;     // Catch: Throwable -> L54
        com.lynx.tasm.behavior.l r110 = ((LynxUIRenderer) r19).e;     // Catch: Throwable -> L54
        if (r110 == null) goto L49;
        r110.d(r20);     // Catch: Throwable -> L54
    L49:
        initEngineAndLayoutProxies();     // Catch: Throwable -> L54
        b0 r111 = new b0(this.mEngineProxy);     // Catch: Throwable -> L54
        r111.addObserver(this.mIntersectionObserverManager);     // Catch: Throwable -> L54
        r111.registerEventReporter(this.mNativeFacade);     // Catch: Throwable -> L54
        r111.registerEventFallback(this);     // Catch: Throwable -> L54
        this.mLynxContext.setEventEmitter(r111);     // Catch: Throwable -> L54
        nativeOnLynxEngineCreated(this.mNativePtr, ((LynxUIRenderer) lynxUIRenderer()).j());     // Catch: Throwable -> L54
        goto L51
    L42:
        r11 = null;
        goto L43
    L34:
        r14 = ThreadStrategyForRendering.ALL_ON_UI;     // Catch: Throwable -> L54
        goto L35
    L22:
        if (LynxEnv.inst().enableFallbackNewEngineRebuild() == true) goto L24;
        destroyLynxEngine();     // Catch: Throwable -> L54
        goto L24
    }

    private String formatLynxMessage(String r4) {
        long r0 = System.currentTimeMillis();
        StringBuilder r2 = new StringBuilder();
        r2.append(String.valueOf(r0));
        r2.append(" ");
        r2.append(r4);
        r2.append(" LynxView ");
        LynxContext r5 = this.mLynxContext;
        if (r5 != null) goto L5;
    L7:
        String r6 = this.mUrl;
        if (r6 == null) goto L11;
        r2.append(r6);
    L11:
        return r2.toString();
    L5:
        if (TextUtils.isEmpty(r5.getLynxSessionID()) == true) goto L7;
        r2.append(this.mLynxContext.getLynxSessionID());
        r2.append(" ");
        goto L7
    }

    private void init(Context r8) {
        TraceEvent.beginSection("TemplateRender.initWithContext");
        this.reload = false;
        this.mHasPageStart = false;
        this.mHasDestroy = false;
        this.mDestroying = false;
        this.mLynxContext.setImageInterceptor(this.mClient);
        this.mLynxContext.setLynxViewClient(this.mClient);
        this.mLynxContext.setLynxViewClientV2(this.mClientV2);
        ILynxUIRenderer r2 = lynxUIRenderer();
        LynxUIRenderer r3 = (LynxUIRenderer) r2;
        r3.m(this.mLynxContext, this.mLynxViewConfigProvider.getBehaviorRegistry(), this.mBodyView, this.mLongTaskMonitorEnabled);
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L9;
        LynxBackgroundRuntime r4 = this.mRuntime;
        if (r4 == null) goto L7;
        this.mDevTool = r4.e;
        this.mDevTool.attach(getLynxView(), this);
    L8:
        this.mDevTool.attachLynxUIOwner(r3.b);
        new WeakReference(this);
        goto L9
    L7:
        this.mDevTool = new LynxDevtool(getLynxView(), this, this.mLynxViewConfigProvider.isDebuggable());
    L9:
        createLynxEngine(-1);
        if (r8 != null) goto L15;
        LynxUIOwner r9 = r3.b;
        if (r9 == null) goto L14;
        r9.setContextFree(true);
    L14:
        setEnableUIFlush(false);
    L15:
        TraceEvent.endSection("TemplateRender.initWithContext");
    }

    private void initLynxEngineWithLoadMeta(s0 r8) {
        if (this.mNativePtr == 0) goto L31;
        boolean r1 = true;
        if ((r8.h & LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH.id()) == 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        setEnableUIFlush(false);
    L10:
        Map<String, String> r2 = r8.i;
        if (r2 != null) goto L13;
    L14:
        r2 = this.mOriginLynxViewConfig;
    L15:
        if (r2 == null) goto L20;
        String r3 = r2.get(LynxViewBuilderProperty.PLATFORM_CONFIG.getKey());
        if (r3 == null) goto L20;
        nativeSetPlatformConfig(this.mNativePtr, this.mNativeLifecycle, r3);
    L20:
        if (this.mStaticPageHost != null) goto L32;
        com.lynx.tasm.group.c r4 = this.mLynxViewGroup;
        if (r4 == null) goto L24;
        updateGlobalProps(r4.getGlobalProps());
    L24:
        TemplateData r9 = r8.f;
        if (r9 != null) goto L28;
        r1 = false;
    L28:
        if (r1 == false) goto L33;
        updateGlobalProps(r9);
        return;
    L33:
        return;
    L32:
        return;
    L13:
        if (r2.isEmpty() == false) goto L15;
    L7:
        r0 = false;
        goto L8
    }

    private synchronized void internalMergeGlobalPropsSafely(TemplateData r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.globalProps != null) goto L6;
        this.globalProps = TemplateData.fromMap(new HashMap());     // Catch: Throwable -> L11
    L6:
        this.globalProps.updateWithTemplateData(r2);     // Catch: Throwable -> L11
        LynxDevtool r3 = this.mDevTool;     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        r3.onGlobalPropsChanged(this.globalProps);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    private static /* synthetic */ void lambda$null$0(com.lynx.tasm.s r0) {
        r0.a();
    }

    private static /* synthetic */ void lambda$null$2(com.lynx.tasm.s r0) {
        r0.a();
    }

    private /* synthetic */ void lambda$queryNativeMemoryUsageForGlobalCollectorAsync$6(LynxTemplateRenderMemoryUsageFetcher.InstanceMemoryUsageQuery r8) {
        long r0 = this.mNativePtr;
        long r2 = this.mNativeLifecycle;
        if (r0 != 0) goto L5;
    L15:
        nativeQueryNativeMemoryUsageAsync(0, 0, r8);
        return;
    L5:
        if (r2 == 0) goto L15;
        if (this.mIsDestroyed.get() == true) goto L15;
        if (this.mHasDestroy == true) goto L15;
        if (this.mDestroying == true) goto L15;
        nativeQueryNativeMemoryUsageAsync(r0, r2, r8);
    }

    private void loadTemplateWithLynxViewGroup(o r1) {
        this.mLynxViewGroup.g();
    }

    private void notifyExtensionModulesTemplateLoad(String r4) {
        if (this.mLynxViewBuilder.isEnableJSRuntime() == true) goto L6;
        LLog.e(TAG, "notifyExtensionModulesTemplateLoad failed, isEnableJSRuntime is false");
        return;
    L6:
        Map<String, com.lynx.jsbridge.d> r0 = this.mLynxContext.getExtensionModules();
        Iterator<String> r1 = r0.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r0.get(r1.next()).onTemplateLoad(r4);
        goto L8
    }

    private void onEnterBackground(boolean r6) {
        LLog.i(TAG, "onEnterBackground. force: " + r6);
        LynxDevtool r0 = this.mDevTool;
        if (r0 == null) goto L6;
        r0.onEnterBackground();
    L6:
        if (this.mNativePtr == 0) goto L11;
        if (r6 == false) goto L9;
    L10:
        nativeOnEnterBackground(this.mNativePtr, this.mNativeLifecycle);
        goto L11
    L9:
        if (getAutoExpose() == true) goto L10;
    L11:
        ILynxUIRenderer r7 = this.mLynxUIRender;
        if (r7 == null) goto L17;
        LynxUIOwner r8 = ((LynxUIRenderer) r7).b;
        if (r8 == null) goto L18;
        r8.onEnterBackground();
        return;
    L18:
        return;
    }

    private void onEnterForeground(boolean r6) {
        LLog.i(TAG, "onEnterForeground. force: " + r6);
        LynxDevtool r0 = this.mDevTool;
        if (r0 == null) goto L6;
        r0.onEnterForeground();
    L6:
        if (this.mNativePtr == 0) goto L11;
        if (r6 == false) goto L9;
    L10:
        nativeOnEnterForeground(this.mNativePtr, this.mNativeLifecycle);
        goto L11
    L9:
        if (getAutoExpose() == true) goto L10;
    L11:
        ILynxUIRenderer r7 = this.mLynxUIRender;
        if (r7 == null) goto L17;
        LynxUIOwner r8 = ((LynxUIRenderer) r7).b;
        if (r8 == null) goto L18;
        r8.onEnterForeground();
        return;
    L18:
        return;
    }

    private void onTraceEventBegin(String r4) {
        if (TraceEvent.isTracingStarted() == true) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        LynxContext r1 = this.mLynxContext;
        if (r1 == null) goto L12;
        r0.put("instance_id", String.valueOf(r1.getInstanceId()));
        if (this.mLynxContext.getLynxView() == null) goto L10;
        String r2 = this.mLynxContext.getLynxView().toString();
    L11:
        r0.put("lynx_view", r2);
        goto L12
    L10:
        r2 = "null";
    L12:
        TraceEvent.beginSection(1, r4, r0);
    }

    private void onTraceEventEnd(String r3) {
        if (TraceEvent.isTracingStarted() == true) goto L5;
        return;
    L5:
        TraceEvent.endSection(1, r3);
    }

    private void postRenderOrUpdateData(TemplateData r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (LynxEnv.inst().enableDataListFix() == false) goto L6;
        r3.bindContext(this.mLynxContext);
    L6:
        this.updatedDataList.add(r3);
        LLog.i(TAG, "retain TemplateData for lifecycle, url=" + getTemplateUrl() + ", data=" + r3 + ", listSize=" + this.updatedDataList.size() + ", bindContextEnabled=" + LynxEnv.inst().enableDataListFix());
    }

    private boolean prepareStaticPageLoad(s0 r10) {
        TemplateData r2 = r10.e;
        TemplateData r0 = r10.f;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        TemplateData r7 = null;
        if (r3 == false) goto L9;
        TemplateData r5 = r0;
    L10:
        com.lynx.tasm.group.c r1 = this.mLynxViewGroup;
        if (r1 != null) goto L13;
        TemplateData r4 = null;
    L15:
        if (this.mStaticPageHost == null) goto L17;
    L23:
        monitor-enter(this);
    L80:
        th = move-exception;
        throw th;
    L25:
        if (this.mHasDestroy == false) goto L27;
    L78:
        monitor-exit(this);     // Catch: Throwable -> L80
        return false;
    L27:
        if (this.mDestroying == true) goto L78;
        StaticPageHost r6 = this.mStaticPageHost;     // Catch: Throwable -> L80
        if (r6 != null) goto L32;
    L36:
        ConcurrentHashMap<Integer, WeakReference<StaticPageHost>> r8 = StaticPageHost.i;     // Catch: Throwable -> L80
        if (r2 != null) goto L39;
    L42:
        boolean r9 = true;
    L43:
        if (r9 == true) goto L48;
        LLog.e(TAG, "Static page direct load requires static page initial data");     // Catch: Throwable -> L80
        monitor-exit(this);     // Catch: Throwable -> L80
        return false;
    L48:
        if (this.mThreadStrategyForRendering != ThreadStrategyForRendering.MOST_ON_TASM) goto L50;
    L75:
        LLog.e(TAG, "Static page direct data does not support the current rendering configuration");     // Catch: Throwable -> L80
        monitor-exit(this);     // Catch: Throwable -> L80
        return false;
    L50:
        if (this.mEnableReuseEngine == true) goto L75;
        if (this.mEnableCacheEngine == true) goto L75;
        LynxLoadMode r11 = r10.g;     // Catch: Throwable -> L80
        if (r11 == LynxLoadMode.RENDER_SSR) goto L75;
        if (r11 == LynxLoadMode.HYDRATE_SSR) goto L75;
        int r12 = this.mLynxContext.getInstanceId();     // Catch: Throwable -> L80
        if (r12 >= 0) goto L63;
        LLog.e(TAG, "Static page direct data requires a valid Lynx instance id");     // Catch: Throwable -> L80
        monitor-exit(this);     // Catch: Throwable -> L80
        return false;
    L63:
        if (r6 != null) goto L65;
        r6 = new StaticPageHost(new a1(this));     // Catch: Throwable -> L80
        this.mStaticPageHost = r6;     // Catch: Throwable -> L80
    L65:
        Map<String, Object> r13 = r6.f(r12, r2, this.globalProps, r4, r5);     // Catch: Throwable -> L80
        if (r13 == null) goto L69;
        r7 = TemplateData.createForStaticPage(r13);     // Catch: Throwable -> L80
    L69:
        this.globalProps = r7;     // Catch: Throwable -> L80
        LynxDevtool r14 = this.mDevTool;     // Catch: Throwable -> L80
        if (r14 == null) goto L73;
        if (r7 == null) goto L73;
        r14.onGlobalPropsChanged(r7);     // Catch: Throwable -> L80
    L73:
        monitor-exit(this);     // Catch: Throwable -> L80
        return true;
    L39:
        if (TemplateData.isForStaticPage(r2) == true) goto L42;
        r9 = false;
        goto L43
    L32:
        if (r6.d() == false) goto L36;
        LLog.e(TAG, "Repeated loadTemplate is not supported for a static page direct load");     // Catch: Throwable -> L80
        monitor-exit(this);     // Catch: Throwable -> L80
        return false;
    L17:
        if (TemplateData.isForStaticPage(r2) == true) goto L23;
        if (TemplateData.isForStaticPage(r5) == true) goto L23;
        if (TemplateData.isForStaticPage(r4) == true) goto L23;
        return true;
    L13:
        r4 = r1.getGlobalProps();
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private boolean prepareUpdateData(TemplateData r7) {
        if (checkIfEnvPrepared() == true) goto L5;
    L19:
        return false;
    L5:
        if (this.mNativePtr == 0) goto L19;
        if (r7 != null) goto L11;
        LLog.e(TAG, "updateData with null TemplateData");
        return false;
    L11:
        r7.flush();
        if (r7.getNativePtr() != 0) goto L15;
        LLog.e(TAG, "updateData with TemplateData after flush is nullptr");
        return false;
    L15:
        this.mWillContentSizeChange = true;
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L18;
        nativeMarkDirty(r0, this.mNativeLifecycle);
    L18:
        return true;
    }

    private String[] processUrl(String r8) {
        ArrayList r0 = new ArrayList();
        String[] r1 = r8.split("=|&");
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        int r3 = 0;
    L3:
        int r4 = r3 + 1;
        if (r4 >= r1.length) goto L17;
        if (r1[r3].equalsIgnoreCase("compile_path") == false) goto L8;
    L15:
        r8 = r1[r4];
    L16:
        r3 = r3 + 2;
        goto L3
    L8:
        if (r1[r3].equalsIgnoreCase("compilePath") == true) goto L15;
        if (r1[r3].equalsIgnoreCase("post_url") == false) goto L13;
    L14:
        r2 = r1[r4];
        goto L16
    L13:
        if (r1[r3].equalsIgnoreCase("postUrl") == false) goto L16;
    L17:
        r0.add(r8);
        r0.add(r2);
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    private void renderSSRWithMetaData(s0 r3) {
        byte[] r0 = r3.b;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        renderSSR(r3.b, r3.a, r3.e);
        return;
    L11:
        if (r3.a.isEmpty() == true) goto L13;
        String r2 = r3.a;
        renderSSRUrlInternal(r2, new q(this, r2, r3.e));
        return;
    L13:
        LLog.e(TAG, "SSR rendering failed: Binary data is invalid or URL is empty.");
        return;
    L5:
        if (r0.length <= 0) goto L7;
        r1 = true;
        goto L8
    }

    private void runOnLayoutThread(Runnable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        LynxLayoutProxy r0 = getOrCreateLayoutProxy();
        if (r0 == null) goto L8;
        r0.c(r2);
        return;
    }

    private void setLynxInternalModules(LynxModuleFactory r4) {
        r4.c(LynxIntersectionObserverModule.NAME, LynxIntersectionObserverModule.class, null);
        r4.c(LynxUIMethodModule.NAME, LynxUIMethodModule.class, null);
        r4.c(LynxTextInfoModule.NAME, LynxTextInfoModule.class, null);
        r4.c(LynxAccessibilityModule.NAME, LynxAccessibilityModule.class, null);
        r4.c(LynxSetModule.NAME, LynxSetModule.class, null);
        r4.c(LynxResourceModule.NAME, LynxResourceModule.class, null);
        r4.c(LynxExposureModule.NAME, LynxExposureModule.class, null);
    }

    private void setThemeInternal(k8a.a r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        HashMap r0 = new HashMap();
        r0.put("theme", r8.a);
        j7a.a.a.getClass();
        ByteBuffer r5 = j7a.a.b(r0);
        if (r5 == null) goto L8;
        nativeUpdateConfig(this.mNativePtr, this.mNativeLifecycle, r5, r5.position());
        return;
    }

    private void setUrl(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        this.mUrl = r3;
        LynxEnv.inst().setLastUrl(this.mUrl);
        LynxContext r0 = this.mLynxContext;
        if (r0 == null) goto L8;
        r0.setTemplateUrl(this.mUrl);
    L8:
        notifyExtensionModulesTemplateLoad(r3);
    }

    private void setUserModules(LynxModuleFactory r2) {
        r2.d = this.mLynxViewBuilder.lynxModuleExtraData;
        r2.a(this.mLynxRuntimeOptions.d);
    }

    private boolean tryRenderByReuseLynxRender(TemplateData r15) {
        onTraceEventBegin("LynxTemplateRender.tryRenderByReuseLynxRender");
        LynxEngine r1 = this.mLynxEngineRef;
        if (r1 != null) goto L28;
        tryReuseLynxEngineFromPool();
        if (this.mLynxEngineRef == null) goto L26;
        LLog.i(TAG, "call nativeReattachLynxEngineWrapper." + this);
        long r6 = this.mNativePtr;
        long r8 = this.mNativeLifecycle;
        long r10 = this.mLynxEngineRef.b;
        LynxEngineProxy r2 = this.mEngineProxy;
        if (r2 == null) goto L9;
        long r4 = r2.a;
    L10:
        nativeReattachLynxEngineWrapper(r6, r8, r10, r4);
        registerMemoryUsageFetcherIfNeeded();
        updateGenericInfoURL(this.mUrl);
        ThreadStrategyForRendering r3 = this.mThreadStrategyForRendering;
        if (r3 != ThreadStrategyForRendering.ALL_ON_UI) goto L16;
        if (r3 == this.mLynxEngineRef.e) goto L16;
        attachEngineToUIThread();
    L16:
        if ((this.mBodyView instanceof LynxView) == true) goto L18;
    L24:
        dispatchOnPageStart(this.mUrl);
        updateData(r15, true);
        onTraceEventEnd("LynxTemplateRender.tryRenderByReuseLynxRender");
        return true;
    L18:
        if (getLynxView() == null) goto L24;
        if (getLynxView().getCurrentWidthMeasureSpec() < 0) goto L24;
        if (getLynxView().getCurrentHeightMeasureSpec() < 0) goto L24;
        updateViewport(getLynxView().getCurrentWidthMeasureSpec(), getLynxView().getCurrentHeightMeasureSpec(), false);
        goto L24
    L9:
        r4 = 0;
        goto L10
    L26:
        fallbackNewEngine(false);
    L40:
        onTraceEventEnd("LynxTemplateRender.tryRenderByReuseLynxRender");
        return false;
    L28:
        if (r1.c() == false) goto L40;
        if ((this.mBodyView instanceof LynxView) == true) goto L32;
    L38:
        updateGenericInfoURL(this.mUrl);
        dispatchOnPageStart(this.mUrl);
        updateData(r15, true);
        onTraceEventEnd("LynxTemplateRender.tryRenderByReuseLynxRender");
        return true;
    L32:
        if (getLynxView() == null) goto L38;
        if (getLynxView().getCurrentWidthMeasureSpec() < 0) goto L38;
        if (getLynxView().getCurrentHeightMeasureSpec() < 0) goto L38;
        updateViewport(getLynxView().getCurrentWidthMeasureSpec(), getLynxView().getCurrentHeightMeasureSpec(), false);
        goto L38
    }

    private void updateGenericInfoURL(String r5) {
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getInstanceId();
        HashMap r2 = new HashMap();
        r2.put(LynxEventReporter.PROP_NAME_THREAD_MODE, Integer.valueOf(this.mThreadStrategyForRendering.id()));
        if (r5 == null) goto L10;
        r2.put(LynxEventReporter.PROP_NAME_URL, r5);
        r2.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r5);
        q0 r3 = this.mReportHelper;
        if (r3 == null) goto L10;
        r3.a("last_lynx_url", r5);
    L10:
        LynxEventReporter.updateGenericInfo(r2, r1);
    }

    public void addLynxViewClient(q1 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mClient.a(r2);
    }

    public void addLynxViewClientV2(LynxViewClientV2 r3) {
        s1 r0 = this.mClientV2;
        if (r3 != null) goto L5;
        r0.getClass();
        return;
    L5:
        if (r0.a.contains(r3) == true) goto L9;
        r0.a.add(r3);
        return;
    }

    public void addRuntimeLifecycleListener(com.lynx.jsbridge.g r2) {
        if (r2 == null) goto L8;
        JSProxy r0 = this.mJSProxy;
        if (r0 == null) goto L8;
        r0.a(r2);
        return;
    L8:
        LLog.w(TAG, "add a null lifecycle listener or js proxy is null.");
    }

    public boolean attachLynxView(LynxView r8) {
        if (this.mBodyView == null) goto L6;
        LLog.e(TAG, "already attached " + r8);
        return false;
    L6:
        Context r0 = r8.getContext();
        this.mContext = r0;
        Activity r1 = com.lynx.tasm.utils.a.getActivity(r0);
        if (TraceEvent.isTracingStarted() == false) goto L13;
        HashMap r3 = new HashMap();
        if (r1 == null) goto L11;
        String r5 = r1.toString();
    L12:
        r3.put("curActivity", r5);
        TraceEvent.beginSection("TemplateRender.attachLynxView", r3);
        goto L13
    L11:
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        LLog.i(TAG, "LynxTemplateRender(" + this + ") is attached on lynxView:" + r8);
        ILynxUIRenderer r2 = lynxUIRenderer();
        this.mBodyView = r8;
        r8.setLynxUIRendererInternal(r2);
        LynxDevtool r4 = this.mDevTool;
        if (r4 == null) goto L16;
        r4.attachContext(this.mContext);
    L16:
        y6a.r r6 = this.mViewLayoutTick;
        if (r6 == null) goto L19;
        r6.a = this.mBodyView;
    L19:
        this.mBodyView.setTimingCollector(this.mPerformanceController);
        LynxUIRenderer r7 = (LynxUIRenderer) r2;
        r7.c(r8, this.mLynxContext, this.mContext);
        if (r1 == null) goto L26;
        LynxUIOwner r9 = r7.b;
        if (r9 == null) goto L24;
        r9.setContextFree(false);
    L24:
        nativeSetContextHasAttached(this.mNativePtr, this.mNativeLifecycle);
    L26:
        if (this.mDevTool == null) goto L29;
        this.mDevTool.attach(r8);
    L29:
        if (TraceEvent.isTracingStarted() == false) goto L33;
        TraceEvent.endSection("TemplateRender.attachLynxView");
        return true;
    L33:
        return true;
    }

    public boolean blockNativeEvent(MotionEvent r5) {
        ILynxUIRenderer r0 = this.mLynxUIRender;
        if (r0 == null) goto L23;
        com.lynx.tasm.behavior.b1 r1 = ((LynxUIRenderer) r0).c;
        if (r1 == null) goto L16;
        EventTarget r2 = r1.c;
        if (r2 == null) goto L16;
    L9:
        if (r2 == null) goto L16;
        if (r2.parent() == r2) goto L16;
        if (r2.blockNativeEvent(r5) == true) goto L14;
        r2 = r2.parent();
        goto L9
    L14:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L24;
        return true;
    L24:
        return false;
    L16:
        r6 = false;
        goto L17
    L23:
        return false;
    }

    @Override // com.lynx.tasm.EventEmitter.b
    public void checkFallbackForLynxEvent(boolean r1) {
        checkEngineFallbackAndLoad(r1);
    }

    public boolean consumeSlideEvent(MotionEvent r3) {
        ILynxUIRenderer r0 = this.mLynxUIRender;
        if (r0 == null) goto L11;
        com.lynx.tasm.behavior.b1 r1 = ((LynxUIRenderer) r0).c;
        if (r1 == null) goto L7;
        boolean r4 = r1.e(r3);
    L8:
        if (r4 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r4 = false;
        goto L8
    L11:
        return false;
    }

    public void dispatchMessageEvent(ReadableMap r6) {
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L6;
        nativeDispatchMessageEvent(r0, this.mNativeLifecycle, r6);
        return;
    }

    public boolean dispatchTouchEvent(MotionEvent r9) {
        checkEngineFallbackAndLoad(false);
        PerformanceController r1 = this.mPerformanceController;
        if (r1 != null) goto L5;
    L18:
        ILynxUIRenderer r2 = this.mLynxUIRender;
        if (r2 == null) goto L29;
        LynxUIRenderer r3 = (LynxUIRenderer) r2;
        r3.a();
        com.lynx.tasm.behavior.b1 r4 = r3.c;
        if (r4 != null) goto L23;
    L25:
        boolean r10 = false;
    L26:
        if (r10 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        if (r4.x(r9, null) == false) goto L25;
        r10 = true;
        goto L26
    L29:
        return false;
    L5:
        if (r1.l() == false) goto L18;
        FSPTracer r5 = r1.i;
        if (r5 == null) goto L18;
        if (r5.b() == false) goto L18;
        if (r5.b.get() == false) goto L18;
        FSPTracer.ResultStatus r6 = FSPTracer.ResultStatus.CANCEL_BY_USER_INTERACTION;
        r5.b.set(false);
        long r7 = PerformanceController.j();
        if (r7 <= 0) goto L18;
        r5.a(r6, r5.c, r7);
        goto L18
    }

    public LynxBaseUI findUIByIdSelector(String r3) {
        ILynxUIRenderer r0 = this.mLynxUIRender;
        if (r0 == null) goto L8;
        LynxUIOwner r1 = ((LynxUIRenderer) r0).b;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.findLynxUIByIdSelector(r3);
    L8:
        return null;
    }

    public LynxBaseUI findUIByIndex(int r3) {
        ILynxUIRenderer r0 = this.mLynxUIRender;
        if (r0 == null) goto L8;
        LynxUIOwner r1 = ((LynxUIRenderer) r0).b;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.findLynxUIByIndex(r3);
    L8:
        return null;
    }

    public LynxBaseUI findUIByName(String r3) {
        ILynxUIRenderer r0 = this.mLynxUIRender;
        if (r0 == null) goto L8;
        LynxUIOwner r1 = ((LynxUIRenderer) r0).b;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.findLynxUIByName(r3);
    L8:
        return null;
    }

    public View findViewByIdSelector(String r2) {
        LynxBaseUI r3 = findUIByIdSelector(r2);
        if ((r3 instanceof LynxUI) == true) goto L5;
        return null;
    L5:
        return ((LynxUI) r3).getView();
    }

    public View findViewByName(String r2) {
        LynxBaseUI r3 = findUIByName(r2);
        if ((r3 instanceof LynxUI) == true) goto L5;
        return null;
    L5:
        return ((LynxUI) r3).getView();
    }

    public void getCurrentData(d0 r8) {
        if (checkIfEnvPrepared() == true) goto L5;
    L9:
        r8.onFail("LynxView Not Initialized Yet");
        return;
    L5:
        if (this.mNativePtr == 0) goto L9;
        int r6 = this.mLynxGetDataCounter.incrementAndGet();
        this.mCallbackSparseArray.put(r6, r8);
        nativeGetDataAsync(this.mNativePtr, this.mNativeLifecycle, r6);
    }

    public com.lynx.jsbridge.c getJSModule(String r2) {
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getJSModule(r2);
    }

    public JavaOnlyMap getListPlatformInfo(int r5) {
        return nativeGetListPlatformInfo(this.mNativePtr, this.mNativeLifecycle, r5);
    }

    public void getLynxElementRoot(com.lynx.tasm.s<Object> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        final h r3 = new h(this, this);
        UIThreadUtils.runOnUiThread(new y0(this, r3));
    }

    public Map<String, Object> getPageDataByKey(String[] r6) {
        if (checkIfEnvPrepared() == false) goto L11;
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L13;
        Object r7 = nativeGetPageDataByKey(r0, this.mNativeLifecycle, r6);
        HashMap r1 = new HashMap();
        if ((r7 instanceof Map) == false) goto L10;
        r1.putAll((Map) r7);
    L10:
        return r1;
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.lynx.tasm.h
    public void loadTemplate(s0 r7) {
        if (this.mHasDestroy == false) goto L5;
        return;
    L5:
        onTraceEventBegin("LynxTemplateRender.loadTemplateWithMeta");
        if (this.mAsyncRender == false) goto L10;
        if (this.reload == true) goto L10;
    L14:
        if (prepareStaticPageLoad(r7) == true) goto L17;
        onTraceEventEnd("LynxTemplateRender.loadTemplateWithMeta");
        return;
    L17:
        boolean r3 = true;
        if (r7.g != LynxLoadMode.PRE_PAINTING) goto L23;
        UIBody.UIBodyView r1 = this.mBodyView;
        if (r1 == null) goto L22;
        r1.setShouldInterceptRequestLayout(true);
    L22:
        this.mLynxContext.setInPreLoad(true);
    L23:
        LynxLoadMode r2 = r7.g;
        if (r2 != LynxLoadMode.RENDER_SSR) goto L27;
        renderSSRWithMetaData(r7);
        onTraceEventEnd("LynxTemplateRender.loadTemplateWithMeta");
        return;
    L27:
        LynxSSRHelper r4 = this.mSSRHelper;
        if (r4 != null) goto L30;
    L37:
        y7a.h r5 = y7a.h.a("loadBundle", "loadBundleStart", this.mPerformanceController.e);
        PerformanceController r6 = this.mPerformanceController;
        if (r6.e == false) goto L40;
        r6.p("loadBundleStart", null);
    L40:
        setUrl(r7.a);
        renderWithLoadMeta(r7, r5);
        LLog.i(TAG, formatLynxMessage("renderTemplate"));
        if (this.mStaticPageHost == null) goto L43;
    L45:
        onTraceEventEnd("LynxTemplateRender.loadTemplateWithMeta");
        return;
    L43:
        if (r7.e == null) goto L45;
        postRenderOrUpdateData(r7.e);
        goto L45
    L30:
        if (r4.a == LynxSSRHelper.SSRHydrateStatus.PENDING) goto L33;
        r3 = false;
    L33:
        if (r3 == false) goto L37;
        if (r2 != LynxLoadMode.HYDRATE_SSR) goto L37;
        r4.getClass();
        r4.a = LynxSSRHelper.SSRHydrateStatus.STARTED;
    L10:
        if (UIThreadUtils.isOnUiThread() == true) goto L14;
        UIThreadUtils.runOnUiThread(new k(this, r7));
        onTraceEventEnd("LynxTemplateRender.loadTemplateWithMeta");
    }

    public void markHostPlatformTiming(String r2) {
        PerformanceController r0 = this.mPerformanceController;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public void onDispatchInputEvent(InputEvent r2) {
        LynxDevtool r0 = this.mDevTool;
        if (r0 == null) goto L6;
        r0.onRootViewInputEvent(r2);
        return;
    }

    @Override // com.lynx.tasm.i
    public void onErrorOccurred(LynxError r5) {
        if (r5 != null) goto L5;
    L29:
        LLog.e(TAG, "receive invalid error");
        return;
    L5:
        if (r5.isValid() == false) goto L29;
        r5.setTemplateUrl(this.mUrl);
        LynxContext r1 = this.mLynxContext;
        if (r1 == null) goto L10;
        r5.setCardVersion(r1.getPageVersion());
    L10:
        showErrorMessage(r5);
        LynxSSRHelper r2 = this.mSSRHelper;
        if (r2 == null) goto L16;
        r5.getType();
        r2.getClass();
        if (r5.getErrorCode() != 102) goto L16;
        r2.a = LynxSSRHelper.SSRHydrateStatus.FAILED;
    L16:
        if (r5.isLogBoxOnly() == true) goto L27;
        LynxContext r3 = this.mLynxContext;
        if (r3 != null) goto L20;
    L26:
        dispatchError(r5.getType(), r5);
        goto L27
    L20:
        if (r3.enableEventReporter() == false) goto L26;
        LynxContext r4 = this.mLynxContext;
        if (r4 != null) goto L24;
        int r6 = -1;
    L25:
        LynxEventReporter.onEvent(LynxEventReporter.LYNX_SDK_ERROR_EVENT, r6, new a(this, r5));
        goto L26
    L24:
        r6 = r4.getInstanceId();
    L27:
        LLog.e(TAG, "LynxTemplateRender " + toString() + ": onErrorOccurred type " + r5.getType() + ",errCode:" + r5.getErrorCode() + ",detail:" + r5.getMsg());
    }

    public boolean onInterceptTouchEvent(MotionEvent r4) {
        ILynxUIRenderer r5 = this.mLynxUIRender;
        if (r5 == null) goto L16;
        LynxUIRenderer r6 = (LynxUIRenderer) r5;
        r6.a();
        com.lynx.tasm.behavior.b1 r7 = r6.c;
        if (r7 != null) goto L7;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == false) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (r7.x == false) goto L9;
        boolean r9 = r7.I;
    L10:
        if (r9 == false) goto L12;
        r8 = true;
        goto L13
    L9:
        r9 = false;
        goto L10
    L16:
        return false;
    }

    public void onRootViewDraw(Canvas r2) {
        LynxContext r0 = this.mLynxContext;
        if (r0 == null) goto L6;
        r0.onRootViewDraw(r2);
        return;
    }

    public void preloadLazyBundles(String[] r5) {
        nativePreloadLazyBundles(this.mNativePtr, this.mNativeLifecycle, r5);
    }

    public void putExtraParamsForReportingEvents(Map<String, Object> r3) {
        onTraceEventBegin("LynxTemplateRender.putExtraParamsForReportEvents");
        LynxContext r1 = this.mLynxContext;
        if (r1 != null) goto L5;
    L7:
        onTraceEventEnd("LynxTemplateRender.putExtraParamsForReportEvents");
        return;
    L5:
        if (r1.enableEventReporter() == false) goto L7;
        LynxEventReporter.putExtraParams(r3, this.mLynxContext.getInstanceId());
        goto L7
    }

    public void queryNativeMemoryUsageForGlobalCollectorAsync(final LynxTemplateRenderMemoryUsageFetcher.InstanceMemoryUsageQuery r2) {
        UIThreadUtils.runOnUiThread(new z0(this, r2));
    }

    public void removeLynxViewClient(q1 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r1 r0 = this.mClient;
        if (r0 == null) goto L8;
        r0.a.remove(r2);
        return;
    }

    public void removeLynxViewClientV2(LynxViewClientV2 r2) {
        this.mClientV2.a.remove(r2);
    }

    public void resetData(TemplateData r12) {
        onTraceEventBegin("LynxTemplateRender.resetData");
        if (prepareUpdateData(r12) == false) goto L9;
        if (r12 == null) goto L8;
        LynxDevtool r1 = this.mDevTool;
        if (r1 == null) goto L8;
        r1.onTemplateDataReset(r12);
    L8:
        nativeResetDataByPreParsedData(this.mNativePtr, this.mNativeLifecycle, r12.getNativePtr(), r12.processorName(), r12.isReadOnly(), r12);
    L9:
        postRenderOrUpdateData(r12);
        LLog.i(TAG, formatLynxMessage("reset"));
        onTraceEventEnd("LynxTemplateRender.resetData");
    }

    public void runOnTasmThread(Runnable r3) {
        LynxEngineProxy r0 = this.mEngineProxy;
        if (r0 != null) goto L6;
        LLog.i(TAG, "runOnTasmThread failed, engine proxy is null.");
        return;
    L6:
        r0.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.e(r0, r3));
    }

    public void scrollStopped(int r7) {
        nativeScrollStopped(this.mNativePtr, this.mNativeLifecycle, r7);
    }

    public void sendCustomEvent(com.lynx.tasm.event.a r5) {
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L7;
        LLog.e(TAG, "sendCustomEvent event: " + r5.getName() + " failed since mLynxContext is null.");
        return;
    L7:
        if (r0.getEventEmitter() != null) goto L10;
        LLog.e(TAG, "sendCustomEvent event: " + r5.getName() + " failed since mLynxContext.getEventEmitter() is null.");
        return;
    L10:
        r0.getEventEmitter().sendCustomEvent(r5);
    }

    public void setAsyncImageInterceptor(com.lynx.tasm.behavior.m r2) {
        LynxContext r0 = this.mLynxContext;
        if (r0 == null) goto L6;
        r0.setAsyncImageInterceptor(r2);
        return;
    }

    public void setAttachLynxPageUICallback(UIBody.UIBodyView.a r2) {
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getLynxUIOwner() == null) goto L9;
        this.mLynxContext.getLynxUIOwner().setAttachLynxPageUICallback(r2);
        return;
    }

    public void setEnableUIFlush(boolean r6) {
        long r0 = this.mNativePtr;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (this.mEnableUIFlush == r6) goto L9;
        this.mEnableUIFlush = r6;
        nativeSetEnableUIFlush(r0, this.mNativeLifecycle, r6);
        return;
    }

    public void setExtraTiming(final b2 r4) {
        onTraceEventBegin("LynxTemplateRender.setExtraTiming");
        final PerformanceController r1 = this.mPerformanceController;
        if (r1.e == true) goto L6;
        r1.q(new y7a.e(r1, r4));
    L6:
        onTraceEventEnd("LynxTemplateRender.setExtraTiming");
    }

    public void setFluencyTracerEnabled(LynxBooleanOption r3) {
        LynxContext r0 = this.mLynxContext;
        if (r0 == null) goto L9;
        FluencyTraceHelper r1 = r0.getFluencyTraceHelper();
        if (r1.f == r3) goto L10;
        r1.f = r3;
        r1.d();
        return;
    L10:
        return;
    }

    public void setImageInterceptor(com.lynx.tasm.behavior.m r2) {
        LynxContext r0 = this.mLynxContext;
        if (r0 == null) goto L6;
        r0.setImageInterceptor(r2);
        return;
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption r7) {
        UIThreadUtils.assertOnUiThread();
        this.mLongTaskMonitorEnabled = r7;
        long r1 = this.mNativePtr;
        if (r1 == 0) goto L10;
        long r3 = this.mNativeLifecycle;
        if (r7 != LynxBooleanOption.FALSE) goto L7;
        boolean r5 = true;
    L8:
        nativeSetLongTaskMonitorDisabled(r1, r3, r5);
        return;
    L7:
        r5 = false;
        goto L8
    }

    public void setTheme(k8a.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        k8a.a r0 = this.mTheme;
        if (r0 != null) goto L7;
        this.mTheme = r6;
    L9:
        if (checkIfEnvPrepared() == true) goto L11;
        return;
    L11:
        if (this.mNativePtr == 0) goto L16;
        setThemeInternal(r6);
        return;
    L16:
        return;
    L7:
        r0.a = r6.a;
        goto L9
    }

    public void showErrorMessage(LynxError r2) {
        LynxDevtool r0 = this.mDevTool;
        if (r0 == null) goto L6;
        r0.showErrorMessage(r2);
        return;
    }

    public void updateColorScheme(LynxColorScheme r8) {
        if (checkIfEnvPrepared() == false) goto L10;
        long r1 = this.mNativePtr;
        if (r1 == 0) goto L11;
        if (r8 == null) goto L12;
        nativeUpdateColorScheme(r1, this.mNativeLifecycle, r8.id(), false);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void updateFontScale(float r6) {
        if (checkIfEnvPrepared() == false) goto L9;
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L10;
        nativeUpdateFontScale(r0, this.mNativeLifecycle, r6);
        return;
    L10:
        return;
    }

    public void updateGlobalProps(TemplateData r7) {
        LLog.d(TAG, "updateGlobalProps with url: " + getTemplateUrl());
        onTraceEventBegin("TemplateRender.setGlobalProps");
        if (checkIfEnvPrepared() == true) goto L5;
    L8:
        onTraceEventEnd("TemplateRender.setGlobalProps");
        return;
    L5:
        if (this.mNativePtr == 0) goto L8;
        if (r7 == null) goto L8;
        internalMergeGlobalPropsSafely(r7);
        updateGlobalPropsInternal(this.globalProps);
        goto L8
    }

    public synchronized void updateGlobalPropsInternal(TemplateData r7) {
        monitor-enter(this);
        if (r7 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        r7.flush();     // Catch: Throwable -> L14
        long r4 = r7.getNativePtr();     // Catch: Throwable -> L14
        if (r4 != 0) goto L11;
        LLog.e(TAG, "updateGlobalProps with zero templateData");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        nativeUpdateGlobalProps(this.mNativePtr, this.mNativeLifecycle, r4);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.h
    public void updateMetaData(o1 r19) {
        LynxContext r10 = this.mLynxContext;
        if (r10 != null) goto L5;
        return;
    L5:
        onTraceEventBegin("LynxTemplateRender.updateMetaData");
        if (r10.isEmbeddedModeOn() == false) goto L8;
        this.mPerformanceController.p("updateDataStart", NameKeys.UnloadStrategy_No_Strategy);
    L8:
        TemplateData r12 = r19.a;
        TemplateData r13 = r19.b;
        if (shouldHandleStaticPageMetaData(r12, r13) == false) goto L12;
        handleStaticPageMetaData(r12, r13);
        onTraceEventEnd("LynxTemplateRender.updateMetaData");
        return;
    L12:
        LynxContext r0 = this.mLynxContext;
        if (r12 == null) goto L18;
        LynxDevtool r1 = this.mDevTool;
        if (r1 == null) goto L18;
        r1.onTemplateDataChanged(r12);
    L18:
        if (this.mEnableReuseEngine == true) goto L20;
        String r16 = "LynxTemplateRender.updateMetaData";
        TemplateData r17 = r12;
        boolean r14 = false;
        String r11 = TAG;
    L38:
        if (r10.isInPreLoad() == false) goto L43;
        LLog.i(r11, "updateData after pre load, url:" + this.mUrl);
        UIBody.UIBodyView r2 = this.mBodyView;
        if (r2 == null) goto L42;
        r2.setShouldInterceptRequestLayout(r14);
    L42:
        r10.setInPreLoad(r14);
    L43:
        if (r13 == null) goto L45;
        internalMergeGlobalPropsSafely(r13);
        TemplateData r3 = this.globalProps;
    L46:
        TemplateData r4 = r17;
        if (this.mNativePtr == 0) goto L49;
        updateMetaDataInternal(r4, r3);
    L49:
        postRenderOrUpdateData(r4);
        postRenderOrUpdateData(r3);
        onTraceEventEnd(r16);
        return;
    L45:
        r3 = null;
        goto L46
    L20:
        if (this.mLynxEngineRef != null) goto L34;
        tryReuseLynxEngineFromPool();
        if (this.mLynxEngineRef != null) goto L25;
        fallbackNewEngine(false);
        renderTemplateBundle(this.mTemplateBundle, this.mTemplateData, this.mUrl);
        onTraceEventEnd("LynxTemplateRender.updateMetaData");
        return;
    L25:
        LLog.i(TAG, "call nativeReattachLynxEngineWrapper");
        long r5 = this.mNativePtr;
        long r6 = this.mNativeLifecycle;
        long r7 = this.mLynxEngineRef.b;
        LynxEngineProxy r8 = this.mEngineProxy;
        if (r8 == null) goto L28;
        long r15 = r8.a;
    L29:
        r16 = "LynxTemplateRender.updateMetaData";
        r17 = r12;
        r14 = false;
        r11 = TAG;
        nativeReattachLynxEngineWrapper(r5, r6, r7, r15);
        registerMemoryUsageFetcherIfNeeded();
        ThreadStrategyForRendering r9 = this.mThreadStrategyForRendering;
        if (r9 == ThreadStrategyForRendering.ALL_ON_UI) goto L32;
    L35:
        this.mEmbeddedPipelineCounter.incrementAndGet();
        goto L38
    L32:
        if (r9 == this.mLynxEngineRef.e) goto L35;
        attachEngineToUIThread();
        goto L35
    L28:
        r15 = 0;
        goto L29
    L34:
        r16 = "LynxTemplateRender.updateMetaData";
        r17 = r12;
        r14 = false;
        r11 = TAG;
        goto L35
    }

    public void setTheme(ByteBuffer r8) {
        if (checkIfEnvPrepared() == false) goto L9;
        long r1 = this.mNativePtr;
        if (r1 == 0) goto L10;
        nativeUpdateConfig(r1, this.mNativeLifecycle, r8, r8.position());
        return;
    L10:
        return;
    }

    public LynxTemplateRender(Context r5, LynxViewBuilder r6) {
        this.mTemplateAssembler = new z1();
        this.reload = false;
        this.mHasDestroy = false;
        this.mDestroying = false;
        this.mClient = new r1();
        this.mClientV2 = new s1();
        this.mFirstMeasureTime = -1;
        this.updatedDataList = new CopyOnWriteArrayList();
        this.mIsMemoryCollecting = false;
        this.mEnablePendingJsTask = false;
        this.mEnableGenericResourceFetcher = false;
        this.mShouldUpdateViewport = true;
        this.mFontScale = 1.0f;
        this.mLongTaskMonitorEnabled = LynxBooleanOption.UNSET;
        this.mEnableUIFlush = true;
        this.mVsyncAlignedFlushEnabled = true;
        this.mReportHelper = new q0();
        this.mPerformanceController = new PerformanceController();
        this.mRenderPhase = RENDER_PHASE_SETUP;
        this.mHasSubmittedViewport = false;
        this.mHasFragmentLayerRenderSyncFlushed = false;
        this.mForceLayoutOnBackgroundThread = LynxEnv.inst().shouldForceLayoutOnBackgroundThread();
        this.mNativeShellLifecycleLock = new Object();
        this.platformCallBackMap = new HashMap();
        this.mIsDestroyed = new AtomicBoolean(true);
        this.mCleanupReference = null;
        this.mNativePtr = 0;
        this.mLynxGetDataCounter = new AtomicInteger(0);
        this.mCallbackSparseArray = new SparseArray();
        this.mEmbeddedPipelineCounter = new AtomicInteger(0);
        this.mTemplateData = TemplateData.fromMap(new HashMap());
        init(r5, null, r6);
    }

    public static /* synthetic */ void access$100(LynxTemplateRender r0, Runnable r1) {
        r0.runOnLayoutThread(r1);
    }

    public static /* synthetic */ String[] access$1200(LynxTemplateRender r0, String r1) {
        return r0.processUrl(r1);
    }

    public static /* synthetic */ void access$1600(LynxTemplateRender r0, String r1) {
        r0.onTraceEventBegin(r1);
    }

    public static /* synthetic */ void access$1700(LynxTemplateRender r0, String r1) {
        r0.onTraceEventEnd(r1);
    }

    public static /* synthetic */ void access$2000(LynxTemplateRender r0, int r1) {
        r0.dispatchLoadSuccess(r1);
    }

    public static /* synthetic */ String access$2102(LynxTemplateRender r0, String r1) {
        r0.mRenderPhase = r1;
        return r1;
    }

    public static /* synthetic */ k8a.a access$2402(LynxTemplateRender r0, k8a.a r1) {
        r0.mTheme = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3802(LynxTemplateRender r0, boolean r1) {
        r0.mIsMemoryCollecting = r1;
        return r1;
    }

    private void attachPiper(LynxBackgroundRuntime r8, LynxModuleFactory r9) {
        this.mNativeFacade.i = r9;
        nativeAttachRuntime(this.mNativePtr, this.mNativeLifecycle, r8.f);
        String r10 = getJSGroupThreadNameIfNeed();
        WeakReference<LynxContext> r11 = this.mNativeFacade.f;
        this.mJSProxy = new JSProxy(this.mNativePtr, r11, r10);
        NativeFacade r0 = this.mNativeFacade;
        JSProxy r1 = this.mJSProxy;
        r0.getClass();
        new WeakReference(r1);
        LynxContext r12 = r11.get();
        if (r12 == null) goto L6;
        LLog.i(TAG, "set JSGroupThreadName to lynx context: " + r10);
        r12.setJSGroupThreadName(r10);
        return;
    }

    private void dispatchError(int r5, LynxError r6) {
        onTraceEventBegin("TemplateRender.dispatchError");
        int r1 = r6.getErrorCode();
        if (r1 != 102) goto L5;
        this.mClient.onLoadFailed(r6.getMsg());
    L6:
        this.mClient.onReceivedError(r6);
        if (r1 != 201) goto L10;
        this.mClient.onReceivedJSError(r6);
    L13:
        onTraceEventEnd("TemplateRender.dispatchError");
        return;
    L10:
        if (r5 != (-1)) goto L12;
        this.mClient.onReceivedNativeError(r6);
        goto L13
    L12:
        this.mClient.onReceivedJavaError(r6);
        goto L13
    L5:
        this.mClient.onReceivedError(r6.getMsg());
        goto L6
    }

    private void enforceRelayoutOnCurrentThreadWithUpdatedViewport(int r9, int r10) {
        int r5 = MeasureMode.fromMeasureSpec(r9);
        int r4 = View.MeasureSpec.getSize(r9);
        int r7 = MeasureMode.fromMeasureSpec(r10);
        int r6 = View.MeasureSpec.getSize(r10);
        nativeEnforceRelayoutOnCurrentThreadWithUpdatedViewport(this.mNativePtr, this.mNativeLifecycle, r4, r5, r6, r7);
        this.mPreWidthMeasureSpec = r9;
        this.mPreHeightMeasureSpec = r10;
    }

    private boolean getBooleanFromLynxViewConfig(LynxEnvKey r2, boolean r3) {
        Map<String, String> r0 = this.mOriginLynxViewConfig;
        if (r0 != null) goto L5;
        return r3;
    L5:
        String r4 = r0.get(r2.getDescription());
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return r3;
    L8:
        String r5 = r4.trim();
        if ("1".equals(r5) == false) goto L11;
        return true;
    L11:
        if ("true".equalsIgnoreCase(r5) == false) goto L14;
        return true;
    L14:
        if ("0".equals(r5) == false) goto L16;
        return false;
    L16:
        if ("false".equalsIgnoreCase(r5) == true) goto L23;
        return r3;
    L23:
        return false;
    }

    private void getDataBack(ByteBuffer r2, int r3) {
        d0 r4 = this.mCallbackSparseArray.get(r3);
        j7a.a.a.getClass();
        Object r5 = j7a.a.a(r2);
        if ((r5 instanceof Map) == false) goto L5;
        r4.a(JavaOnlyMap.from((Map) r5));
        return;
    L5:
        r4.onFail("LynxView GetData Failed");
    }

    private void handleStaticPageMetaData(TemplateData r3, TemplateData r4) {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasDestroy == false) goto L6;
    L32:
        monitor-exit(this);     // Catch: Throwable -> L34
        return;
    L6:
        if (this.mDestroying == true) goto L32;
        if (r3 != null) goto L10;
    L11:
        if (r4 != null) goto L13;
    L17:
        StaticPageHost r0 = this.mStaticPageHost;     // Catch: Throwable -> L34
        if (r0 == null) goto L20;
    L25:
        Map<String, Object> r5 = r0.h(r3, r4);     // Catch: Throwable -> L34
        if (r4 == null) goto L30;
        TemplateData r6 = TemplateData.createForStaticPage(r5);     // Catch: Throwable -> L34
        this.globalProps = r6;     // Catch: Throwable -> L34
        LynxDevtool r7 = this.mDevTool;     // Catch: Throwable -> L34
        if (r7 == null) goto L30;
        r7.onGlobalPropsChanged(r6);     // Catch: Throwable -> L34
    L30:
        monitor-exit(this);     // Catch: Throwable -> L34
        return;
    L20:
        if (this.mHasPageStart == false) goto L24;
        LLog.e(TAG, "Static page direct metadata must be set before loadTemplate");     // Catch: Throwable -> L34
        monitor-exit(this);     // Catch: Throwable -> L34
        return;
    L24:
        r0 = new StaticPageHost(new a1(this));     // Catch: Throwable -> L34
        this.mStaticPageHost = r0;     // Catch: Throwable -> L34
        goto L25
    L13:
        if (TemplateData.isForStaticPage(r4) == true) goto L17;
    L14:
        LLog.e(TAG, "Static page direct data cannot be mixed with standard TemplateData");     // Catch: Throwable -> L34
        monitor-exit(this);     // Catch: Throwable -> L34
        return;
    L10:
        if (TemplateData.isForStaticPage(r3) == false) goto L14;
        goto L11
    }

    private /* synthetic */ void lambda$getLynxElementRoot$1(com.lynx.tasm.s r7, PlatformCallBack r8) {
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L9;
        long r4 = this.mNativeLifecycle;
        if (r4 == 0) goto L9;
        nativeGetLynxElementRoot(r0, r4, r8);
        return;
    L9:
        UIThreadUtils.runOnUiThread(new d1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void lambda$loadTemplateWithGenericResourceFetcher$5(o r2, LynxResourceResponse r3) {
        int r0 = c.a[r3.a.ordinal()];
        if (r0 != 1) goto L5;
        TemplateBundle r1 = ((h8a.b) r3.b).b;
        if (r1 != null) goto L11;
    L13:
        ((h8a.b) r3.b).getClass();
        r2.onSuccess(((h8a.b) r3.b).a);
        return;
    L11:
        if (r1.i() == false) goto L13;
        r2.a(r1);
        return;
    L5:
        if (r0 != 2) goto L17;
        r2.onFailed(r3.c.getMessage());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void lambda$loadTemplateWithLynxViewGroup$4(o r2, LynxResourceResponse r3) {
        int r0 = c.a[r3.a.ordinal()];
        if (r0 != 1) goto L5;
        r2.a((TemplateBundle) r3.b);
        return;
    L5:
        if (r0 != 2) goto L11;
        r2.onFailed(r3.c.getMessage());
        return;
    }

    private void legacyLoadTemplateWithProvider(String r3, d8a.b.a r4) {
        if (TextUtils.isEmpty(r3) == true) goto L7;
        dispatchOnPageStart(this.mUrl);
        this.mPerformanceController.p("prepareTemplateStart", null);
        this.mTemplateProvider.loadTemplate(this.mUrl, r4);
        return;
    L7:
        throw new IllegalArgumentException("LynxTemplateRender template url is null or TemplateProvider is not init");
    }

    private void loadTemplateWithGenericResourceFetcher(String r4, final o r5) {
        h8a.a r0 = this.mLynxContext.getTemplateResourceFetcher();
        if (r0 == null) goto L6;
        r0.b(new LynxResourceRequest(r4, LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate), new f1(r5));
        return;
    }

    private void maybeSyncLayoutResultDuringLayoutOnBackgroundThread(int r5, int r6) {
        if (this.mWillContentSizeChange == true) goto L9;
        updateViewport(r5, r6);
        if (getEnableVsyncAlignedFlush() == false) goto L18;
        nativeFlush(this.mNativePtr, this.mNativeLifecycle);
        return;
    L18:
        return;
    L9:
        if (this.mPreWidthMeasureSpec == r5) goto L11;
    L16:
        this.mShouldUpdateViewport = false;
        enforceRelayoutOnCurrentThreadWithUpdatedViewport(r5, r6);
        this.mWillContentSizeChange = false;
        return;
    L11:
        if (this.mPreHeightMeasureSpec != r6) goto L16;
        if (this.mShouldUpdateViewport == true) goto L16;
        nativeSyncFetchLayoutResult(this.mNativePtr, this.mNativeLifecycle);
        this.mWillContentSizeChange = false;
    }

    private void renderSSRUrlInternal(String r5, q r6) {
        if (checkIfEnvPrepared() == true) goto L6;
        onErrorOccurred(10202, "LynxEnv has not been prepared successfully!");
        return;
    L6:
        onTraceEventBegin("LynxTemplateRender.renderSSRUrlInternal");
        String[] r1 = processUrl(r5);
        setUrl(r1[0]);
        updateGenericInfoURL(r1[0]);
        LLog.i(TAG, formatLynxMessage("renderTemplate"));
        h8a.a r2 = this.mLynxContext.getTemplateResourceFetcher();
        if (r2 == null) goto L9;
        r2.a(new LynxResourceRequest(r5, LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate), new j(this, r6));
    L10:
        onTraceEventEnd("LynxTemplateRender.renderSSRUrlInternal");
        return;
    L9:
        legacyLoadTemplateWithProvider(r5, r6);
        goto L10
    }

    private void renderTemplateUrlInternal(String r9, o r10) {
        if (checkIfEnvPrepared() == true) goto L6;
        onErrorOccurred(10202, "LynxEnv has not been prepared successfully!");
        return;
    L6:
        onTraceEventBegin("LynxTemplateRender.renderTemplate");
        if (r9 == null) goto L16;
        String[] r1 = processUrl(r9);
        LynxDevtool r2 = this.mDevTool;
        if (r2 == null) goto L16;
        s0 r3 = r10.b;
        if (r3 == null) goto L13;
        TemplateData r4 = r3.e;
    L14:
        r2.onLoadFromURL(r1[0], r1[1], r4, null, null);
        goto L16
    L13:
        r4 = null;
    L16:
        if (this.mLynxContext != null) goto L19;
        LLog.e(TAG, "renderTemplate error, can't get LynxContext in " + toString());
        return;
    L19:
        com.lynx.tasm.group.c r5 = this.mLynxViewGroup;
        if (r5 == null) goto L25;
        if (r5.getLynxTemplateResourceFetcher() == null) goto L25;
        loadTemplateWithLynxViewGroup(r10);
    L28:
        LLog.i(TAG, formatLynxMessage("renderTemplate"));
        onTraceEventEnd("LynxTemplateRender.renderTemplate");
        return;
    L25:
        if (this.mLynxContext.getTemplateResourceFetcher() == null) goto L27;
        loadTemplateWithGenericResourceFetcher(r9, r10);
        goto L28
    L27:
        legacyLoadTemplateWithProvider(r9, r10);
        goto L28
    }

    private void renderWithLoadMeta(s0 r14, y7a.h r15) {
        LynxLoadMode r0 = r14.g;
        boolean r2 = true;
        if (LynxLoadMode.PRE_PAINTING != r0) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (this.mLynxContext != null) goto L14;
        LLog.e(TAG, "renderWithLoadMeta with null LynxContext");
        return;
    L14:
        if (this.mEnableReuseEngine == true) goto L18;
        if (this.mEnableCacheEngine == true) goto L18;
    L21:
        if (this.mLynxContext.isEmbeddedModeOn() == true) goto L23;
    L31:
        TemplateBundle r1 = r14.d;
        if (r1 != null) goto L34;
    L36:
        boolean r3 = false;
    L38:
        if (r3 == true) goto L90;
        TemplateBundle r4 = this.mTemplateBundle;
        if (r4 == null) goto L45;
        if (r4.i() == true) goto L90;
    L45:
        if (r14.c == null) goto L47;
        boolean r5 = true;
    L49:
        if (r5 == true) goto L51;
        byte[] r6 = r14.b;
        if (r6 != null) goto L65;
    L67:
        boolean r7 = false;
    L68:
        if (r7 == true) goto L70;
        StringBuilder r16 = new StringBuilder("LoadMeta with url, pre-painting: ");
        r16.append(r8);
        r16.append(" ,pre-painting with draw:");
        if (LynxLoadMode.PRE_PAINTING_DRAW == r0) goto L88;
        r2 = false;
    L88:
        r16.append(r2);
        r16.append(" url: ");
        r16.append(r14.a);
        LLog.i(TAG, r16.toString());
        String r17 = r14.a;
        renderTemplateUrlInternal(r17, new o(this, r17, r14));
        return;
    L70:
        if (this.mEnableReuseEngine == false) goto L72;
        this.mEmbeddedPipelineCounter.incrementAndGet();
    L72:
        LynxDevtool r9 = this.mDevTool;
        if (r9 == null) goto L75;
        r9.onLoadFromLocalFile(r14.b, r14.e, r14.a);
    L75:
        prepareLynxEngineIfNeeded();
        initLynxEngineWithLoadMeta(r14);
        if ((r14.h & LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE.id()) == 0) goto L78;
        boolean r10 = true;
    L79:
        StringBuilder r11 = new StringBuilder("LoadMeta with binary, pre-painting: ");
        r11.append(r8);
        r11.append(" ,pre-painting with draw:");
        if (LynxLoadMode.PRE_PAINTING_DRAW == r0) goto L83;
        r2 = false;
    L83:
        r11.append(r2);
        r11.append(" enableRecycleTemplateBundle: ");
        r11.append(r10);
        LLog.i(TAG, r11.toString());
        loadTemplate(r14.b, r14.e, r14.a, r8, r10, new t(this), r15);
        return;
    L78:
        r10 = false;
        goto L79
    L65:
        if (r6.length <= 0) goto L67;
        r7 = true;
        goto L68
    L51:
        if (this.mEnableReuseEngine == false) goto L53;
        this.mEmbeddedPipelineCounter.incrementAndGet();
    L53:
        prepareLynxEngineIfNeeded();
        initLynxEngineWithLoadMeta(r14);
        if ((r14.h & LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE.id()) == 0) goto L56;
        boolean r12 = true;
    L57:
        StringBuilder r13 = new StringBuilder("LoadMeta with ByteBuffer, pre-painting: ");
        r13.append(r8);
        r13.append(" ,pre-painting with draw:");
        if (LynxLoadMode.PRE_PAINTING_DRAW == r0) goto L61;
        r2 = false;
    L61:
        r13.append(r2);
        r13.append(" enableRecycleTemplateBundle: ");
        r13.append(r12);
        LLog.i(TAG, r13.toString());
        loadTemplateByteBuffer(r14.c, r14.e, r14.a, r8, r14.h, r12, new t(this), r15);
        return;
    L56:
        r12 = false;
        goto L57
    L47:
        r5 = false;
    L90:
        if (this.mEnableReuseEngine == false) goto L92;
        this.mEmbeddedPipelineCounter.incrementAndGet();
    L92:
        TemplateBundle r18 = r14.d;
        if (r18 != null) goto L95;
    L97:
        boolean r19 = false;
    L98:
        if (r19 == false) goto L100;
        TemplateBundle r20 = r14.d;
    L101:
        LynxDevtool r21 = this.mDevTool;
        if (r21 == null) goto L104;
        r21.onLoadFromBundle(r20, r14.e, r14.a);
    L104:
        prepareLynxEngineIfNeeded();
        initLynxEngineWithLoadMeta(r14);
        if ((r14.h & LynxLoadOption.DUMP_ELEMENT.id()) == 0) goto L107;
        boolean r22 = true;
    L108:
        StringBuilder r23 = new StringBuilder("LoadMeta with bundle, pre-painting: ");
        r23.append(r8);
        r23.append(" ,pre-painting with draw:");
        if (LynxLoadMode.PRE_PAINTING_DRAW == r0) goto L112;
        r2 = false;
    L112:
        r23.append(r2);
        r23.append(" enableDumpElementTree: ");
        r23.append(r22);
        LLog.i(TAG, r23.toString());
        TemplateBundle r24 = r20;
        loadTemplateBundle(r24, r14.a, r14.e, r8, r14.h, new t(this), r15);
        return;
    L107:
        r22 = false;
        goto L108
    L100:
        r20 = this.mTemplateBundle;
        goto L101
    L95:
        if (r18.i() == false) goto L97;
        r19 = true;
        goto L98
    L34:
        if (r1.i() == false) goto L36;
        r3 = true;
        goto L38
    L23:
        if (getLynxView() == null) goto L31;
        if ((this.mBodyView instanceof LynxView) == false) goto L31;
        if (getLynxView().getCurrentWidthMeasureSpec() < 0) goto L31;
        if (getLynxView().getCurrentHeightMeasureSpec() < 0) goto L31;
        updateViewport(getLynxView().getCurrentWidthMeasureSpec(), getLynxView().getCurrentHeightMeasureSpec(), false);
    L18:
        if (tryRenderByReuseLynxRender(r14.e) == false) goto L21;
        return;
    L5:
        if (LynxLoadMode.PRE_PAINTING_DRAW == r0) goto L8;
        r8 = false;
        goto L10
    }

    private boolean shouldHandleStaticPageMetaData(TemplateData r2, TemplateData r3) {
        if (this.mStaticPageHost == null) goto L5;
    L10:
        return true;
    L5:
        if (TemplateData.isForStaticPage(r2) == true) goto L10;
        if (TemplateData.isForStaticPage(r3) == true) goto L10;
        return false;
    }

    private void updateMetaDataInternal(TemplateData r12, TemplateData r13) {
        if (r12 != null) goto L6;
        if (r13 != null) goto L6;
        LLog.e(TAG, "updateMetaData with null data and null globalProps.");
        return;
    L6:
        long r0 = 0;
        if (r12 == null) goto L9;
        r12.flush();
        long r2 = r12.getNativePtr();
        String r6 = r12.processorName();
        boolean r7 = r12.isReadOnly();
        long r4 = r2;
    L10:
        if (r13 == null) goto L12;
        r13.flush();
        r0 = r13.getNativePtr();
    L12:
        nativeUpdateMetaData(this.mNativePtr, this.mNativeLifecycle, r4, r6, r7, r12, r0);
        return;
    L9:
        r4 = 0;
        r6 = null;
        r7 = false;
        goto L10
    }

    public void getSessionStorageItem(String r9, PlatformCallBack r10) {
        LLog.d(TAG, "getSessionStorageItem with key: " + r9);
        if (TextUtils.isEmpty(r9) == true) goto L8;
        long r2 = this.mNativePtr;
        if (r2 == 0) goto L9;
        nativeGetSessionStorageItem(r2, this.mNativeLifecycle, r9, r10);
        return;
    L9:
        return;
    }

    public void lynxElementToJSONString(final int r2, com.lynx.tasm.s<String> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        final i r4 = new i(this);
        UIThreadUtils.runOnUiThread(new b1(this, r2, r4));
    }

    public void onErrorOccurred(int r4, String r5) {
        onErrorOccurred(new LynxError(r4, r5, null, "error"));
    }

    public void onMeasure(int r14, int r15) {
        markEngineInUse();
        LynxContext r0 = this.mLynxContext;
        int r1 = 0;
        if (r0 == null) goto L5;
        boolean r2 = LynxLongTaskMonitor.b("LynxTemplateRender.Measure", r0.getInstanceId(), this.mLongTaskMonitorEnabled);
    L7:
        if (this.mFirstMeasureTime != (-1)) goto L9;
        long r3 = System.currentTimeMillis();
    L10:
        boolean r9 = true;
        Rect r10 = null;
        if (this.mForceLayoutOnBackgroundThread == false) goto L16;
        if (this.mAsyncRender == true) goto L16;
        maybeSyncLayoutResultDuringLayoutOnBackgroundThread(r14, r15);
    L47:
        if (this.mFirstMeasureTime != (-1)) goto L49;
        this.mFirstMeasureTime = System.currentTimeMillis() - r3;
    L49:
        if (r2 == false) goto L51;
        LynxLongTaskMonitor.a();
    L51:
        ILynxUIRenderer r4 = this.mLynxUIRender;
        if (r4 == null) goto L96;
        LynxUIRenderer r5 = (LynxUIRenderer) r4;
        WeakReference<LynxContext> r6 = r5.a;
        if (r6 == null) goto L56;
        LynxContext r7 = r6.get();
    L57:
        if (r7 == null) goto L59;
        UIBody.UIBodyView r8 = r7.getUIBodyView();
    L61:
        if (r5.b == null) goto L95;
        if (r8 == null) goto L95;
        if (r7 != null) goto L66;
    L68:
        r9 = false;
    L69:
        if (r9 == true) goto L71;
        r5.b.performMeasure();
    L71:
        int r11 = View.MeasureSpec.getMode(r14);
        if (r8.getRenderer() == null) goto L75;
        r10 = r8.getRenderer().a;
    L75:
        if (r11 == Integer.MIN_VALUE) goto L79;
        if (r11 == 0) goto L79;
        int r16 = View.MeasureSpec.getSize(r14);
    L84:
        int r12 = View.MeasureSpec.getMode(r15);
        if (r12 == Integer.MIN_VALUE) goto L89;
        if (r12 == 0) goto L89;
        int r17 = View.MeasureSpec.getSize(r15);
    L94:
        r8.innerSetMeasuredDimension(r16, r17);
    L89:
        if (r9 == false) goto L92;
        if (r10 == null) goto L93;
        r1 = r10.height();
    L93:
        r17 = r1;
        goto L94
    L92:
        r1 = r5.b.getRootHeight();
    L79:
        if (r9 == false) goto L83;
        if (r10 == null) goto L82;
        r16 = r10.width();
        goto L84
    L82:
        r16 = 0;
        goto L84
    L83:
        r16 = r5.b.getRootWidth();
        goto L84
    L66:
        if (r7.isFragmentLayerRenderOn() == false) goto L68;
    L95:
        LLog.e("LynxUIRenderer", "performInnerMeasure failed, mLynxUIOwner:" + r5.b + ", bodyView:" + r8);
        goto L96
    L59:
        r8 = null;
        goto L61
    L56:
        r7 = null;
    L96:
        markEngineIdle();
        return;
    L16:
        if (this.mEnableSyncFlush == true) goto L18;
    L25:
        updateViewport(r14, r15);
        if (this.mThreadStrategyForRendering != ThreadStrategyForRendering.PART_ON_LAYOUT) goto L32;
        long r13 = this.mNativePtr;
        if (r13 == 0) goto L32;
        if (this.mWillContentSizeChange == false) goto L32;
        nativeSyncFetchLayoutResult(r13, this.mNativeLifecycle);
        this.mWillContentSizeChange = false;
    L32:
        y6a.r r18 = this.mViewLayoutTick;
        if (r18 == null) goto L44;
        r18.getClass();
        if (TraceEvent.isTracingStarted() == false) goto L37;
        TraceEvent.beginSection("ViewLayoutTick.triggerLayout");
    L37:
        Runnable r19 = r18.b;
        if (r19 == null) goto L40;
        r19.run();
    L40:
        r18.b = null;
        if (TraceEvent.isTracingStarted() == false) goto L44;
        TraceEvent.endSection("ViewLayoutTick.triggerLayout");
    L44:
        if (getEnableVsyncAlignedFlush() == false) goto L47;
        nativeFlush(this.mNativePtr, this.mNativeLifecycle);
        this.mWillContentSizeChange = false;
        goto L47
    L18:
        if ((this.mEmbeddedMode & 8) > 0) goto L20;
        syncFlush();
        goto L25
    L20:
        if (this.reload == false) goto L25;
        if (this.mHasFragmentLayerRenderSyncFlushed == true) goto L25;
        this.mHasFragmentLayerRenderSyncFlushed = true;
        doSyncFlush();
        goto L25
    L9:
        r3 = 0;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    public void prepareForRenderSSR(byte[] r14, String r15) {
        setUrl(r15);
        updateGenericInfoURL(r15);
        LLog.i(TAG, formatLynxMessage("renderTemplate"));
        if (checkIfEnvPrepared() == true) goto L6;
        onErrorOccurred(140201, "LynxEnv has not been prepared successfully!");
        return;
    L6:
        this.mWillContentSizeChange = true;
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L9;
        nativeMarkDirty(r0, this.mNativeLifecycle);
    L9:
        reloadAndInit();
        LynxSSRHelper r1 = new LynxSSRHelper();
        this.mSSRHelper = r1;
        r1.a = LynxSSRHelper.SSRHydrateStatus.PENDING;
        LynxContext r2 = this.mLynxContext;
        if (r2 != null) goto L12;
    L14:
        long r6 = this.mNativePtr;
        if (r6 == 0) goto L18;
        nativeSetSSRTimingData(r6, this.mNativeLifecycle, r15, r14.length);
        return;
    L18:
        return;
    L12:
        if (r2.enableEventReporter() == false) goto L14;
        LynxEventReporter.updateGenericInfo(LynxEventReporter.PROP_NAME_ENABLE_SSR, Boolean.TRUE, this.mLynxContext.getInstanceId());
        goto L14
    }

    public void processLayout(String r2, TemplateData r3) {
        setEnableUIFlush(false);
        renderTemplateUrl(r2, r3);
    }

    public void processLayoutWithSSRUrl(String r2, TemplateData r3) {
        setEnableUIFlush(false);
        renderSSRUrl(r2, r3);
    }

    public void recycleChild(int r7, int r8) {
        nativeRecycleChild(this.mNativePtr, this.mNativeLifecycle, r7, r8);
    }

    public void recycleChildAsync(int r7, int r8) {
        nativeRecycleChildAsync(this.mNativePtr, this.mNativeLifecycle, r7, r8);
    }

    public boolean registerLazyBundle(String r11, TemplateBundle r12) {
        String r1 = null;
        if (TextUtils.isEmpty(r11) == false) goto L6;
        String r13 = "url is empty";
    L5:
        String r9 = r1;
        r1 = r13;
        String r14 = r9;
    L15:
        if (r1 == null) goto L21;
        LynxError r0 = new LynxError(160104, r1);
        r0.setRootCause(r14);
        r0.addCustomInfo("component_url", r11);
        if (this.mNativeFacade == null) goto L23;
        this.mNativeFacade.reportError(r0);
        return false;
    L23:
        return false;
    L21:
        return true;
    L6:
        if (r12 != null) goto L9;
        r13 = "bundle is null";
        goto L5
    L9:
        if (r12.i() == true) goto L12;
        r1 = r12.b;
        r13 = "bundle is invalid";
        goto L5
    L12:
        if (nativeRegisterLazyBundle(this.mNativePtr, this.mNativeLifecycle, r11, r12.a) == true) goto L14;
        r13 = "input bundle is not from a valid template bundle.";
        goto L5
    L14:
        r14 = null;
        goto L15
    }

    public void reloadTemplate(TemplateData r18, TemplateData r19) {
        LLog.d(TAG, "reloadTemplate with url: " + getTemplateUrl());
        onTraceEventBegin("LynxTemplateRender.reloadTemplate");
        y7a.h r1 = y7a.h.a("reloadBundleFromNative", "reloadBundleStart", this.mPerformanceController.e);
        if (prepareUpdateData(r18) == false) goto L16;
        if (r19 == null) goto L6;
        this.globalProps = r19;
    L6:
        LynxViewClientV2.LynxPipelineInfo r2 = new LynxViewClientV2.LynxPipelineInfo();
        LynxViewClientV2.LynxPipelineInfo.LynxPipelineOrigin.LYNX_RELOAD.getValue();
        this.mClientV2.b(getLynxView(), r2);
        if (r19 == null) goto L9;
        r19.flush();
        long r3 = r19.getNativePtr();
    L10:
        long r7 = r3;
        LynxContext r4 = this.mLynxContext;
        if (r4 != null) goto L13;
    L15:
        r1.b("ffiStart");
        nativeReloadTemplate(this.mNativePtr, this.mNativeLifecycle, r18.getNativePtr(), r7, r18.processorName(), r18.isReadOnly(), r19, r18, r1.c());
        goto L16
    L13:
        if (r4.getEnableExposureWhenReload() == false) goto L15;
        this.mLynxContext.stopExposure(null);
        this.mLynxContext.resumeExposure();
        goto L15
    L9:
        r3 = 0;
    L16:
        postRenderOrUpdateData(r18);
        LLog.i(TAG, formatLynxMessage("reload"));
        onTraceEventEnd("LynxTemplateRender.reloadTemplate");
    }

    public void removeChild(int r7, int r8) {
        nativeRemoveChild(this.mNativePtr, this.mNativeLifecycle, r7, r8);
    }

    public void renderSSRUrl(String r2, Map<String, Object> r3) {
        renderSSRUrlInternal(r2, new q(this, r2, TemplateData.fromMap(r3)));
    }

    public void renderTemplate(byte[] r2, Map<String, Object> r3) {
        s0.a r0 = new s0.a();
        r0.b = r2;
        TemplateData r4 = TemplateData.fromMap(r3);
        r4.markReadOnly();
        r0.d = r4;
        loadTemplate(r0.b());
    }

    public void renderTemplateUrl(String r2, String r3) {
        s0.a r0 = new s0.a();
        r0.a = r2;
        r0.d = TemplateData.fromString(r3);
        loadTemplate(r0.b());
    }

    public void sendGlobalEvent(String r11, JavaOnlyArray r12) {
        LynxSSRHelper r0 = this.mSSRHelper;
        if (r0 == null) goto L31;
        LynxSSRHelper.SSRHydrateStatus r1 = r0.a;
        if (r1 != LynxSSRHelper.SSRHydrateStatus.PENDING) goto L7;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L31;
        if (checkIfEnvPrepared() == true) goto L19;
    L25:
        this.mSSRHelper.getClass();
        if (r12 != null) goto L29;
        r12 = new JavaOnlyArray();
    L29:
        r12.pushString("from_ssr_cache");
        goto L31
    L19:
        if (this.mNativePtr == 0) goto L25;
        j7a.a.a.getClass();
        ByteBuffer r8 = j7a.a.b(r12);
        long r3 = this.mNativePtr;
        long r5 = this.mNativeLifecycle;
        if (r8 != null) goto L23;
        int r9 = 0;
    L24:
        nativeSendSsrGlobalEvent(r3, r5, r11, r8, r9);
        goto L25
    L23:
        r9 = r8.position();
        goto L24
    L7:
        if (r1 == LynxSSRHelper.SSRHydrateStatus.STARTED) goto L14;
        if (r1 == LynxSSRHelper.SSRHydrateStatus.EXECUTING) goto L14;
        if (r1 == LynxSSRHelper.SSRHydrateStatus.FAILED) goto L14;
        r2 = false;
    L31:
        if (checkIfEnvPrepared() == false) goto L35;
        LynxContext r4 = this.mLynxContext;
        if (r4 == null) goto L35;
        r4.sendGlobalEvent(r11, r12);
    L36:
        LynxContext r6 = this.mLynxContext;
        if (r6 != null) goto L39;
        return;
    L39:
        if (r6.isEmbeddedModeOn() == false) goto L43;
        JavaOnlyMap r7 = new JavaOnlyMap();
        r7.putString("method", "sendGlobalEvent");
        r7.putString(EasyGoDbTable.Server.NAME, r11);
        r7.putArray(LynxResourceModule.PARAMS_KEY, r12);
        onLynxEvent(r7);
        return;
    L43:
        return;
    L35:
        LLog.e(TAG, "sendGlobalEvent error, can't get GlobalEventEmitter in " + toString());
        goto L36
    }

    public void sendGlobalEventToLepus(String r9, List<Object> r10) {
        if (checkIfEnvPrepared() == true) goto L5;
    L11:
        LLog.e(TAG, "sendGlobalEventToLepus error, Env not prepared in " + toString());
        return;
    L5:
        if (this.mNativePtr == 0) goto L11;
        j7a.a.a.getClass();
        ByteBuffer r6 = j7a.a.b(r10);
        long r1 = this.mNativePtr;
        long r3 = this.mNativeLifecycle;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        nativeSendGlobalEventToLepus(r1, r3, r9, r6, r7);
        return;
    L9:
        r7 = r6.position();
        goto L10
    }

    public void setEnableBytecode(boolean r8, String r9) {
        com.lynx.tasm.q r0 = this.mLynxRuntimeOptions;
        if (Boolean.TRUE.equals(r0.a) == r8) goto L5;
    L7:
        com.lynx.tasm.q r1 = this.mLynxRuntimeOptions;
        r1.a = Boolean.valueOf(r8);
        this.mLynxRuntimeOptions.b = r9;
        long r2 = this.mNativePtr;
        if (r2 == 0) goto L11;
        nativeSetEnableBytecode(r2, this.mNativeLifecycle, r8, r9);
        return;
    L11:
        return;
    L5:
        if (Objects.equals(this.mLynxRuntimeOptions.b, r9) == false) goto L7;
    }

    public void setSessionStorageItem(String r12, TemplateData r13) {
        LLog.d(TAG, "setSessionStorageItem with key: " + r12);
        if (this.mNativePtr == 0) goto L13;
        if (r13 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L15;
        r13.flush();
        if (r13.getNativePtr() != 0) goto L11;
        LLog.e(TAG, "setSessionStorageItem with zero data! key: " + r12);
        return;
    L11:
        nativeSetSessionStorageItem(this.mNativePtr, this.mNativeLifecycle, r12, r13.getNativePtr(), r13.isReadOnly());
        return;
    L15:
        return;
    }

    public void ssrHydrateUrl(String r4, TemplateData r5) {
        LynxSSRHelper r0 = this.mSSRHelper;
        if (r0 != null) goto L5;
    L10:
        renderTemplateUrl(r4, r5);
        return;
    L5:
        if (r0.a != LynxSSRHelper.SSRHydrateStatus.PENDING) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r0.getClass();
        r0.a = LynxSSRHelper.SSRHydrateStatus.STARTED;
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public double subscribeSessionStorage(String r9, PlatformCallBack r10) {
        LLog.d(TAG, "subscribeSessionStorage with key: " + r9);
        if (TextUtils.isEmpty(r9) == true) goto L8;
        long r2 = this.mNativePtr;
        if (r2 == 0) goto L10;
        double r0 = nativeSubscribeSessionStorage(r2, this.mNativeLifecycle, r9, r10);
        this.platformCallBackMap.put(Double.valueOf(r0), r10);
        return r0;
    L10:
        return -1.0d;
    L8:
        return -1.0d;
    }

    public void triggerEventBus(String r9, List<Object> r10) {
        if (checkIfEnvPrepared() == true) goto L5;
    L11:
        LLog.e(TAG, "triggerEventBus error, Env not prepared in " + toString());
        return;
    L5:
        if (this.mNativePtr == 0) goto L11;
        j7a.a.a.getClass();
        ByteBuffer r6 = j7a.a.b(r10);
        long r1 = this.mNativePtr;
        long r3 = this.mNativeLifecycle;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        nativeTriggerEventBus(r1, r3, r9, r6, r7);
        return;
    L9:
        r7 = r6.position();
        goto L10
    }

    public void unsubscribeSessionStorage(String r10, double r11) {
        LLog.d(TAG, "unsubscribeSessionStorage with key: " + r10);
        if (TextUtils.isEmpty(r10) == true) goto L10;
        long r2 = this.mNativePtr;
        if (r2 != 0) goto L7;
        return;
    L7:
        if ((-1.0d) == r11) goto L12;
        nativeUnsubscribeSessionStorage(r2, this.mNativeLifecycle, r10, r11);
        this.platformCallBackMap.remove(Double.valueOf(r11));
        return;
    L12:
        return;
    }

    public void updateData(TemplateData r13, boolean r14) {
        onTraceEventBegin("LynxTemplateRender.updateData");
        if (r13 == null) goto L8;
        LynxDevtool r1 = this.mDevTool;
        if (r1 == null) goto L8;
        r1.onTemplateDataChanged(r13);
    L8:
        if (this.mEnableReuseEngine == false) goto L10;
        this.mEmbeddedPipelineCounter.incrementAndGet();
    L10:
        LynxContext r2 = this.mLynxContext;
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.isInPreLoad() == false) goto L20;
        LLog.i(TAG, "updateData after pre load, url:" + this.mUrl);
        UIBody.UIBodyView r3 = this.mBodyView;
        if (r3 == null) goto L18;
        r3.setShouldInterceptRequestLayout(false);
    L18:
        r2.setInPreLoad(false);
    L20:
        if (prepareUpdateData(r13) == false) goto L22;
        r13.markConsumed();
        nativeUpdateDataByPreParsedData(this.mNativePtr, this.mNativeLifecycle, r13.getNativePtr(), r13.processorName(), r13.isReadOnly(), r13, r14);
    L22:
        postRenderOrUpdateData(r13);
        onTraceEventEnd("LynxTemplateRender.updateData");
    }

    public void updateScreenMetrics(int r12, int r13) {
        LynxContext r0 = this.mLynxContext;
        if (this.mNativePtr == 0) goto L14;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r12 == r0.getScreenMetrics().widthPixels) goto L9;
    L10:
        this.mShouldUpdateViewport = true;
        r0.updateScreenSize(r12, r13);
        nativeUpdateScreenMetrics(this.mNativePtr, this.mNativeLifecycle, r12, r13, r0.getScreenMetrics().density, ((LynxUIRenderer) this.mLynxUIRender).j());
        LynxDevtool r1 = this.mDevTool;
        if (r1 == null) goto L16;
        r1.updateScreenMetrics(r12, r13, r0.getScreenMetrics().density);
        return;
    L16:
        return;
    L9:
        if (r13 != r0.getScreenMetrics().heightPixels) goto L10;
        return;
    }

    public void updateViewport(int r2, int r3) {
        updateViewport(r2, r3, true);
    }

    public void renderSSRUrl(String r2, TemplateData r3) {
        renderSSRUrlInternal(r2, new q(this, r2, r3));
    }

    public void renderTemplate(byte[] r2, TemplateData r3) {
        s0.a r0 = new s0.a();
        r0.b = r2;
        r0.d = r3;
        loadTemplate(r0.b());
    }

    public void renderTemplateUrl(String r2, Map<String, Object> r3) {
        s0.a r0 = new s0.a();
        r0.a = r2;
        r0.d = TemplateData.fromMap(r3);
        loadTemplate(r0.b());
    }

    public void ssrHydrateUrl(String r4, Map<String, Object> r5) {
        LynxSSRHelper r0 = this.mSSRHelper;
        if (r0 != null) goto L5;
    L10:
        renderTemplateUrl(r4, r5);
        return;
    L5:
        if (r0.a != LynxSSRHelper.SSRHydrateStatus.PENDING) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r0.getClass();
        r0.a = LynxSSRHelper.SSRHydrateStatus.STARTED;
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public void updateData(Map<String, Object> r1, String r2) {
        TemplateData r3 = TemplateData.fromMap(r1);
        r3.markState(r2);
        r3.markReadOnly();
        updateData(r3, false);
        LLog.i(TAG, formatLynxMessage(RENDER_PHASE_UPDATE));
    }

    public void renderTemplateUrl(String r2, TemplateData r3) {
        s0.a r0 = new s0.a();
        r0.a = r2;
        r0.d = r3;
        loadTemplate(r0.b());
    }

    public void updateData(String r1, String r2) {
        TemplateData r3 = TemplateData.fromString(r1);
        r3.markState(r2);
        r3.markReadOnly();
        updateData(r3, false);
    }

    public LynxTemplateRender(Context r4, UIBody.UIBodyView r5, LynxViewBuilder r6) {
        this.mTemplateAssembler = new z1();
        this.reload = false;
        this.mHasDestroy = false;
        this.mDestroying = false;
        this.mClient = new r1();
        this.mClientV2 = new s1();
        this.mFirstMeasureTime = -1;
        this.updatedDataList = new CopyOnWriteArrayList();
        this.mIsMemoryCollecting = false;
        this.mEnablePendingJsTask = false;
        this.mEnableGenericResourceFetcher = false;
        this.mShouldUpdateViewport = true;
        this.mFontScale = 1.0f;
        this.mLongTaskMonitorEnabled = LynxBooleanOption.UNSET;
        this.mEnableUIFlush = true;
        this.mVsyncAlignedFlushEnabled = true;
        this.mReportHelper = new q0();
        this.mPerformanceController = new PerformanceController();
        this.mRenderPhase = RENDER_PHASE_SETUP;
        this.mHasSubmittedViewport = false;
        this.mHasFragmentLayerRenderSyncFlushed = false;
        this.mForceLayoutOnBackgroundThread = LynxEnv.inst().shouldForceLayoutOnBackgroundThread();
        this.mNativeShellLifecycleLock = new Object();
        this.platformCallBackMap = new HashMap();
        this.mIsDestroyed = new AtomicBoolean(true);
        this.mCleanupReference = null;
        this.mNativePtr = 0;
        this.mLynxGetDataCounter = new AtomicInteger(0);
        this.mCallbackSparseArray = new SparseArray();
        this.mEmbeddedPipelineCounter = new AtomicInteger(0);
        this.mTemplateData = TemplateData.fromMap(new HashMap());
        init(r4, r5, r6);
    }

    public static /* synthetic */ void access$1300(LynxTemplateRender r0, s0 r1, y7a.h r2) {
        r0.renderWithLoadMeta(r1, r2);
    }

    public static /* synthetic */ void access$3300(LynxTemplateRender r0, long r1, long r3) {
        r0.nativeClearPipelineTimingInfo(r1, r3);
    }

    private void init(Context r8, UIBody.UIBodyView r9, LynxViewBuilder r10) {
        TraceEvent.beginSection("TemplateRender.init");
        ILynxTrailService r1 = (ILynxTrailService) i8a.n.c().a(ILynxTrailService.class);
        if ((r1 instanceof ILynxTrailServiceExtension) == false) goto L5;
        ((ILynxTrailServiceExtension) r1).parseLynxViewBuilder(r10);
    L5:
        this.mInitStart = System.currentTimeMillis();
        this.mContext = r8;
        this.mBodyView = r9;
        this.mLynxViewConfigProvider = r10;
        r10.getLogicExecutor();
        com.lynx.tasm.group.c r11 = r10.lynxViewGroup;
        this.mLynxViewGroup = r11;
        if ((r11 instanceof com.lynx.tasm.group.d) == false) goto L8;
        this.mCacheManager = (com.lynx.tasm.group.d) r11;
    L8:
        this.mLynxViewBuilder = r10;
        if (r11 != null) goto L11;
    L13:
        int r12 = this.mLynxViewConfigProvider.getEmbeddedMode();
        this.mEmbeddedMode = r12;
        PerformanceController r2 = this.mPerformanceController;
        boolean r3 = true;
        if ((r12 & 1) <= 0) goto L16;
        boolean r13 = true;
    L17:
        r2.e = r13;
        r2.k();
        PerformanceController r14 = this.mPerformanceController;
        s1 r4 = this.mClientV2;
        r14.getClass();
        WeakReference<y7a.a> r5 = new WeakReference(r4);
        r14.c = r5;
        c8a.b r15 = r14.a;
        if (r15 == null) goto L20;
        r15.h = r5;
    L20:
        int r16 = this.mEmbeddedMode;
        if ((r16 & 2) > 0) goto L23;
    L28:
        boolean r17 = false;
    L29:
        if (r17 == true) goto L31;
    L33:
        boolean r18 = false;
    L34:
        this.mEnableReuseEngine = r18;
        this.mThreadStrategyForRendering = this.mLynxViewConfigProvider.getThreadStrategy();
        com.lynx.tasm.group.d r19 = this.mCacheManager;
        if (r19 == null) goto L40;
        if (r19.a() == false) goto L40;
        this.mEnableCacheEngine = true;
        this.mLynxEngineRef = this.mCacheManager.b();
        ensureLynxEngine();
    L43:
        this.mRuntime = r10.lynxBackgroundRuntime;
        this.mTemplateProvider = r10.templateProvider;
        this.mEnableSyncFlush = this.mLynxViewConfigProvider.isEnableSyncFlush();
        this.mEnableJSRuntime = this.mLynxViewConfigProvider.isEnableJSRuntime();
        this.mEnableGenericResourceFetcher = checkEnableGenericResourceFetcher(this.mLynxViewConfigProvider.isEnableGenericResourceFetcher());
        this.mEnableAirStrictMode = this.mLynxViewConfigProvider.isEnableAirStrictMode();
        r10.lynxBackgroundRuntime = null;
        if (this.mBodyView == null) goto L46;
        this.mBodyView.setTimingCollector(this.mPerformanceController);
    L46:
        this.mLynxRuntimeOptions = new com.lynx.tasm.q(this.mLynxViewConfigProvider.getLynxRuntimeOptions());
        ThreadStrategyForRendering r6 = this.mThreadStrategyForRendering;
        ThreadStrategyForRendering r7 = ThreadStrategyForRendering.MULTI_THREADS;
        if (r6 != r7) goto L49;
    L52:
        boolean r20 = true;
    L53:
        this.mAsyncRender = r20;
        if (this.mForceLayoutOnBackgroundThread == false) goto L59;
        if (r20 == true) goto L58;
        r7 = ThreadStrategyForRendering.PART_ON_LAYOUT;
    L58:
        this.mThreadStrategyForRendering = r7;
    L59:
        this.mHasEnvPrepared = LynxEnv.inst().isNativeLibraryLoaded();
        if (VSYNC_ALIGNED_FLUSH_EXP_SWITCH == true) goto L62;
    L66:
        boolean r21 = false;
    L67:
        this.mVsyncAlignedFlushEnabled = r21;
        this.mFontScale = this.mLynxViewConfigProvider.getFontScale();
        this.mOriginLynxViewConfig = r10.lynxViewConfig;
        this.mEnablePendingJsTask = this.mLynxViewConfigProvider.isEnablePendingJsTask();
        DisplayMetricsHolder.updateOrInitDisplayMetrics(r8, this.mLynxViewConfigProvider.getDensity());
        DisplayMetrics r22 = DisplayMetricsHolder.getScreenDisplayMetrics();
        int r23 = this.mLynxViewConfigProvider.getScreenWidth();
        int r24 = this.mLynxViewConfigProvider.getScreenHeight();
        if (r23 == (-1)) goto L72;
        if (r24 == (-1)) goto L72;
        r22.widthPixels = r23;
        r22.heightPixels = r24;
    L72:
        if (r8 == null) goto L74;
        Context r25 = r8;
    L75:
        s r26 = new s(r25, r22, this);
        this.mLynxContext = r26;
        r26.setRuntimeCacheManager(this.mCacheManager);
        z1 r27 = this.mTemplateAssembler;
        LynxContext r28 = this.mLynxContext;
        r27.getClass();
        new WeakReference(r28);
        this.mLynxContext.setEmbeddedMode(this.mEmbeddedMode);
        LynxContext r29 = this.mLynxContext;
        if (this.mEnableReuseEngine == false) goto L78;
    L81:
        boolean r30 = true;
    L82:
        r29.setEnableReuseEngine(r30);
        this.mLynxContext.setPerfController(this.mPerformanceController);
        this.mLynxContext.setTapSlop(r10.getTapSlop());
        this.mLynxContext.setUIBodyView(this.mBodyView);
        this.mLynxContext.setForceDarkAllowed(this.mLynxViewConfigProvider.getForceDarkAllowed());
        this.mLynxContext.setContextData(this.mLynxViewConfigProvider.getContextData());
        this.mEnableSkipUpdateViewportOnInitWhenMeasureSpecEmpty = getBooleanFromLynxViewConfig(LynxEnvKey.ENABLE_SKIP_UPDATE_VIEWPORT_ON_INIT_WHEN_MEASURE_SPEC_EMPTY, LynxEnv.inst().enableSkipUpdateViewportOnInitWhenMeasureSpecEmpty());
        Map<String, String> r110 = this.mLynxViewBuilder.mImageCustomParam;
        if (r110 == null) goto L85;
        this.mLynxContext.setImageCustomParam(r110);
    L85:
        this.mLynxViewBuilder.getClass();
        if (this.mEnableJSRuntime == false) goto L90;
        i8a.b r111 = (i8a.b) i8a.n.c().a(i8a.b.class);
        if (r111 == null) goto L90;
        r111.onLynxViewSetup(this.mLynxContext, this.mLynxRuntimeOptions.c, this.mLynxViewConfigProvider.getBehaviorRegistry());
    L90:
        LynxEnv.inst().initNativeUIThread();
        init(r8);
        int r31 = this.mLynxViewConfigProvider.getPresetWidthMeasureSpec();
        int r112 = this.mLynxViewConfigProvider.getPresetHeightMeasureSpec();
        if (this.mForceLayoutOnBackgroundThread == false) goto L96;
        if (r31 != 0) goto L96;
        if (r112 != 0) goto L96;
        r31 = View.MeasureSpec.makeMeasureSpec(INVOKEVIRTUAL_com_lynx_tasm_LynxTemplateRender_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mLynxContext.getResources()).widthPixels, 1073741824);
    L96:
        if (this.mEnableReuseEngine == false) goto L101;
        if (this.mIsEngineFromReuse == false) goto L101;
    L109:
        r3 = false;
    L110:
        if (r3 == false) goto L112;
        updateViewport(r31, r112);
    L112:
        this.mClient.a(LynxEnv.inst().getLynxViewClient());
        this.mClient.a(new r());
        setupReusedEngineConfig();
        this.mInitEnd = System.currentTimeMillis();
        setMsTiming("createLynxStart", this.mInitStart, null);
        setMsTiming("createLynxEnd", this.mInitEnd, null);
        LLog.i(TAG, formatLynxMessage("create"));
        TraceEvent.endSection("TemplateRender.init");
        return;
    L101:
        if ((this.mEmbeddedMode & 4) <= 0) goto L106;
        if (this.mLynxViewConfigProvider.hasPresetMeasureSpec() == false) goto L109;
    L106:
        if (this.mEnableSkipUpdateViewportOnInitWhenMeasureSpecEmpty == false) goto L110;
        if (r31 != 0) goto L110;
        if (r112 != 0) goto L110;
    L78:
        if (this.mEnableCacheEngine == true) goto L81;
        r30 = false;
        goto L82
    L74:
        r25 = LynxEnv.inst().getAppContext();
        goto L75
    L62:
        if (LynxEnv.inst().getVsyncAlignedFlushGlobalSwitch() == false) goto L66;
        if (isThreadStrategySupportVsyncAlignedFlush() == false) goto L66;
        r21 = true;
        goto L67
    L49:
        if (r6 == ThreadStrategyForRendering.MOST_ON_TASM) goto L52;
        r20 = false;
    L40:
        if (this.mEnableReuseEngine == false) goto L42;
        reuseLynxEngine();
        goto L43
    L42:
        this.mLynxUIRender = lynxUIRenderer();
        goto L43
    L31:
        if (this.mTemplateBundle == null) goto L33;
        r18 = true;
        goto L34
    L23:
        if ((r16 & 1) <= 0) goto L25;
        boolean r32 = true;
    L26:
        if (r32 == false) goto L28;
        r17 = true;
        goto L29
    L25:
        r32 = false;
        goto L26
    L16:
        r13 = false;
        goto L17
    L11:
        if (r11.c() == false) goto L13;
        this.mTemplateBundle = this.mLynxViewGroup.d();
        goto L13
    }

    private /* synthetic */ void lambda$lynxElementToJSONString$3(int r7, com.lynx.tasm.s r8, PlatformCallBack r9) {
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L10;
        long r4 = this.mNativeLifecycle;
        if (r4 == 0) goto L10;
        if (r7 == 0) goto L10;
        nativeLynxElementToJSONString(r0, r4, r7, r9);
        return;
    L10:
        UIThreadUtils.runOnUiThread(new c1());
    }

    private void loadSSRData(byte[] r12, TemplateData r13, NativeFacade.c r14) {
        NativeFacade r0 = this.mNativeFacade;
        long r1 = this.mNativePtr;
        long r3 = this.mNativeLifecycle;
        if (r0 == null) goto L17;
        long r6 = 0;
        if (r1 == 0) goto L17;
        if (r3 == 0) goto L17;
        if (r12 != null) goto L12;
        LLog.e(TAG, "Load ssr data  with null template");
        return;
    L12:
        if (r13 == null) goto L14;
        r13.flush();
        long r5 = r13.getNativePtr();
        String r7 = r13.processorName();
        boolean r8 = r13.isReadOnly();
        String r9 = r7;
        r6 = r5;
    L15:
        r0.a = r14;
        nativeLoadSSRDataByPreParsedData(r1, r3, r12, r6, r8, r9, r13);
        return;
    L14:
        r8 = false;
        r9 = null;
    L17:
        LLog.e(TAG, "Load ssr data before inited");
    }

    private void onExceptionOccurred(int r9, Throwable r10, JSONObject r11) {
        if (r10 != null) goto L5;
        LLog.e(TAG, "receive null exception");
        return;
    L5:
        String r0 = CallStackUtil.a(r10);
        LynxError r7 = new LynxError(r9, r10.getMessage(), null, "error", -3);
        r7.setCallStack(r0);
        r7.setUserDefineInfo(r11);
        onErrorOccurred(r7);
    }

    private void setMsTiming(final String r9, final long r10, final String r12) {
        final PerformanceController r6 = this.mPerformanceController;
        if (r6.e == true) goto L7;
        r6.q(new y7a.b(r6, r9, r10, r12));
        return;
    }

    public void obtainChildAsync(int r9, int r10, long r11) {
        nativeObtainChildAsync(this.mNativePtr, this.mNativeLifecycle, r9, r10, r11);
    }

    public void processLayoutWithTemplateBundle(TemplateBundle r2, TemplateData r3, String r4) {
        setEnableUIFlush(false);
        renderTemplateBundle(r2, r3, r4);
    }

    public void renderChild(int r9, int r10, long r11) {
        nativeRenderChild(this.mNativePtr, this.mNativeLifecycle, r9, r10, r11);
    }

    public void renderSSR(byte[] r5, String r6, TemplateData r7) {
        if (this.mHasDestroy == false) goto L5;
        return;
    L5:
        LynxDevtool r0 = this.mDevTool;
        if (r0 == null) goto L9;
        r0.onLoadFromLocalFile(r5, r7, r6);
    L9:
        if (this.mAsyncRender == false) goto L13;
        if (this.reload == true) goto L13;
    L16:
        prepareForRenderSSR(r5, r6);
        if (this.mNativePtr == 0) goto L19;
        loadSSRData(r5, r7, new t(this));
    L19:
        postRenderOrUpdateData(r7);
        return;
    L13:
        if (UIThreadUtils.isOnUiThread() == true) goto L16;
        UIThreadUtils.runOnUiThread(new l(this, r5, r6, r7));
    }

    public void renderTemplateBundle(TemplateBundle r2, TemplateData r3, String r4) {
        s0.a r0 = new s0.a();
        r0.c = r2;
        r0.d = r3;
        r0.a = r4;
        loadTemplate(r0.b());
    }

    public void renderTemplateWithBaseUrl(byte[] r2, TemplateData r3, String r4) {
        s0.a r0 = new s0.a();
        r0.b = r2;
        r0.d = r3;
        r0.a = r4;
        loadTemplate(r0.b());
        LLog.i(TAG, formatLynxMessage("renderTemplate"));
    }

    public void ssrHydrateWithBaseUrl(byte[] r4, TemplateData r5, String r6) {
        LynxSSRHelper r0 = this.mSSRHelper;
        if (r0 != null) goto L5;
    L10:
        renderTemplateWithBaseUrl(r4, r5, r6);
        return;
    L5:
        if (r0.a != LynxSSRHelper.SSRHydrateStatus.PENDING) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r0.getClass();
        r0.a = LynxSSRHelper.SSRHydrateStatus.STARTED;
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public void updateViewport(int r17, int r18, boolean r19) {
        if (checkIfEnvPrepared() == true) goto L5;
        return;
    L5:
        if (this.mNativePtr != 0) goto L8;
        return;
    L8:
        if (this.mPreWidthMeasureSpec != r17) goto L16;
        if (this.mPreHeightMeasureSpec != r18) goto L16;
        if (this.mShouldUpdateViewport == true) goto L16;
        LLog.i(TAG, "updateViewport is unnecessary, because the size of the cache are the same as the size to be set.");
        return;
    L16:
        if (this.mShouldUpdateViewport == false) goto L18;
        this.mShouldUpdateViewport = false;
    L18:
        int r9 = MeasureMode.fromMeasureSpec(r17);
        int r8 = View.MeasureSpec.getSize(r17);
        int r11 = MeasureMode.fromMeasureSpec(r18);
        int r10 = View.MeasureSpec.getSize(r18);
        nativeUpdateViewport(this.mNativePtr, this.mNativeLifecycle, r8, r9, r10, r11, this.mLynxContext.getScreenMetrics().density, ((LynxUIRenderer) this.mLynxUIRender).j(), r19);
        this.mHasSubmittedViewport = true;
        this.mPreWidthMeasureSpec = r17;
        this.mPreHeightMeasureSpec = r18;
    }

    public void renderSSR(byte[] r1, String r2, Map<String, Object> r3) {
        TemplateData r4 = TemplateData.fromMap(r3);
        r4.markReadOnly();
        renderSSR(r1, r2, r4);
    }

    public void renderTemplateWithBaseUrl(byte[] r1, String r2, String r3) {
        TemplateData r4 = TemplateData.fromString(r2);
        r4.markReadOnly();
        setUrl(r3);
        renderTemplateWithBaseUrl(r1, r4, r3);
        LLog.i(TAG, formatLynxMessage("renderTemplate"));
    }

    public void ssrHydrateWithBaseUrl(byte[] r4, Map<String, Object> r5, String r6) {
        LynxSSRHelper r0 = this.mSSRHelper;
        if (r0 != null) goto L5;
    L10:
        renderTemplateWithBaseUrl(r4, r5, r6);
        return;
    L5:
        if (r0.a != LynxSSRHelper.SSRHydrateStatus.PENDING) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r0.getClass();
        r0.a = LynxSSRHelper.SSRHydrateStatus.STARTED;
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public void renderTemplateWithBaseUrl(byte[] r1, Map<String, Object> r2, String r3) {
        TemplateData r4 = TemplateData.fromMap(r2);
        r4.markReadOnly();
        renderTemplateWithBaseUrl(r1, r4, r3);
        LLog.i(TAG, formatLynxMessage("renderTemplate"));
    }

    public static /* synthetic */ void access$000(LynxTemplateRender r0, int r1, Throwable r2, JSONObject r3) {
        r0.onExceptionOccurred(r1, r2, r3);
    }

    public int obtainChild(int r10, int r11, long r12, boolean r14) {
        return nativeObtainChild(this.mNativePtr, this.mNativeLifecycle, r10, r11, r12, r14);
    }

    public void updateChild(int r10, int r11, int r12, long r13) {
        nativeUpdateChild(this.mNativePtr, this.mNativeLifecycle, r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$3000(long r0, long r2, String r4, String r5, int r6) {
        nativeUpdateI18nResource(r0, r2, r4, r5, r6);
    }

    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (this.mEnableReuseEngine == true) goto L5;
    L7:
        ILynxUIRenderer r6 = this.mLynxUIRender;
        if (r6 == null) goto L31;
        LynxUIRenderer r7 = (LynxUIRenderer) r6;
        if (r7.b != null) goto L12;
        LLog.e("LynxUIRenderer", "onLayout failed, mLynxUIOwner is null");
        return;
    L12:
        WeakReference<LynxContext> r8 = r7.a;
        if (r8 == null) goto L15;
        LynxContext r9 = r8.get();
    L16:
        if (r9 != null) goto L18;
    L22:
        boolean r10 = false;
    L23:
        if (r10 == true) goto L35;
        if (r9 == null) goto L29;
        boolean r11 = LynxLongTaskMonitor.b("LynxTemplateRender.Layout", r9.getInstanceId(), r7.h);
        r7.b.performLayout();
        if (r11 == false) goto L33;
        LynxLongTaskMonitor.a();
        return;
    L33:
        return;
    L29:
        r7.b.performLayout();
        return;
    L35:
        return;
    L18:
        if (r9.isFragmentLayerRenderOn() == false) goto L22;
        if (r9.getUIBodyView() == null) goto L22;
        r10 = true;
        goto L23
    L15:
        r9 = null;
        goto L16
    L31:
        return;
    L5:
        if (this.mLynxEngineRef != null) goto L7;
    }

    public void scrollByListContainer(int r11, float r12, float r13, float r14, float r15) {
        nativeScrollByListContainer(this.mNativePtr, this.mNativeLifecycle, r11, r12, r13, r14, r15);
    }

    public void scrollToPosition(int r11, int r12, float r13, int r14, boolean r15) {
        nativeScrollToPosition(this.mNativePtr, this.mNativeLifecycle, r11, r12, r13, r14, r15);
    }

    private void loadTemplate(byte[] r11, TemplateData r12, String r13, boolean r14, boolean r15, NativeFacade.c r16, y7a.h r17) {
        if (r11 != null) goto L5;
        LLog.e(TAG, "Load Template with null template");
        return;
    L5:
        nativeLoadTemplate(r13, r11, null, r14, r15, r12, 0, r17, r16);
    }

    private void loadTemplateBundle(TemplateBundle r17, String r18, TemplateData r19, boolean r20, int r21, NativeFacade.c r22, y7a.h r23) {
        NativeFacade r2 = this.mNativeFacade;
        long r3 = this.mNativePtr;
        long r6 = this.mNativeLifecycle;
        if (r2 != null) goto L5;
    L30:
        LLog.e(TAG, "LoadTemplateBundle before inited");
        return;
    L5:
        if (r3 == 0) goto L30;
        if (r6 == 0) goto L30;
        if (r17 != null) goto L11;
    L24:
        LLog.e(TAG, "LoadTemplateBundle with null bundle or invalid bundle");
        LynxError r4 = new LynxError(10205, "LoadTemplateBundle with null bundle or invalid bundle");
        if (r17 != null) goto L27;
        String r1 = "bundle is null";
    L28:
        r4.setRootCause(r1);
        r2.reportError(r4);
        return;
    L27:
        r1 = r17.b;
        goto L28
    L11:
        if (r17.i() == false) goto L24;
        if (r19 == null) goto L15;
        r19.flush();
        long r11 = r19.getNativePtr();
        String r13 = r19.processorName();
        boolean r14 = r19.isReadOnly();
        r19.markConsumed();
    L17:
        if (r11 != 0) goto L19;
        LLog.e(TAG, "LoadTemplateBundle with zero templateData");
    L19:
        r2.c = r18;
        r2.a = r22;
        r2.d = r17.c;
        LynxDevtool r5 = this.mDevTool;
        if (r5 == null) goto L22;
        r5.attachToDebugBridge(r18);
    L22:
        t1.a(r17.e, this.mLynxContext, this.mLynxUIRender);
        r23.b("ffiStart");
        nativeLoadTemplateBundleByPreParsedData(r3, r6, r18, r17.a, r20, r11, r14, r13, r19, r21, r23.c());
        return;
    L15:
        r13 = null;
        r14 = false;
        r11 = 0;
        goto L17
    }

    private void loadTemplateByteBuffer(ByteBuffer r11, TemplateData r12, String r13, boolean r14, int r15, boolean r16, NativeFacade.c r17, y7a.h r18) {
        if (r11 != null) goto L5;
        LLog.e(TAG, "Load Template with null template");
        return;
    L5:
        nativeLoadTemplate(r13, null, r11, r14, r16, r12, r15, r18, r17);
    }

    private void nativeLoadTemplate(String r21, byte[] r22, ByteBuffer r23, boolean r24, boolean r25, TemplateData r26, int r27, y7a.h r28, NativeFacade.c r29) {
        NativeFacade r10 = this.mNativeFacade;
        long r11 = this.mNativePtr;
        long r13 = this.mNativeLifecycle;
        if (r10 == null) goto L29;
        long r16 = 0;
        if (r11 == 0) goto L29;
        if (r13 == 0) goto L29;
        ILynxSecurityService r1 = (ILynxSecurityService) i8a.n.c().a(ILynxSecurityService.class);
        if (r1 == null) goto L15;
        r28.b("verifyTasmStart");
        j8a.b r2 = r1.verifyTASM(getLynxView(), r22, r23, r21, ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE);
        r28.b("verifyTasmEnd");
        if (r2.a == true) goto L15;
        r10.reportError(new LynxError(10701, r2.b));
        return;
    L15:
        LynxDevtool r3 = this.mDevTool;
        if (r3 == null) goto L18;
        r3.attachToDebugBridge(r21);
    L18:
        r10.c = r21;
        r10.a = r29;
        if (r26 == null) goto L21;
        r26.flush();
        long r4 = r26.getNativePtr();
        String r5 = r26.processorName();
        boolean r6 = r26.isReadOnly();
        r26.markConsumed();
        r16 = r4;
        String r19 = r5;
        boolean r18 = r6;
    L22:
        r28.b("ffiStart");
        if (r23 == null) goto L25;
        r10.d = r23.position();
        nativeLoadTemplateBufferByPreParsedData(r11, r13, r21, r23, r24, r25, r16, r18, r19, r26, r27, r28.c());
        return;
    L25:
        if (r22 == null) goto L27;
        r10.d = r22.length;
        nativeLoadTemplateByPreParsedData(r11, r13, r21, r22, r24, r25, r16, r18, r19, r26, r27, r28.c());
        return;
    L27:
        LLog.e(TAG, "loadTemplate with empty template or buffer.");
        return;
    L21:
        r19 = null;
        r18 = false;
    L29:
        LLog.e(TAG, "Load Template before inited");
    }
}
