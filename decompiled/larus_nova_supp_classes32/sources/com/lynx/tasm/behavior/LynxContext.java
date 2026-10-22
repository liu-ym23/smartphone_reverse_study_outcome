package com.lynx.tasm.behavior;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClientV2;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.render.NativePaintingContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.frame.LynxFrameView;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxLayoutProxy;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.fluency.FluencyTraceHelper;
import com.lynx.tasm.fontface.FontFace;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.q1;
import com.lynx.tasm.recording.LynxFrameRecorder;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.t1;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class LynxContext extends r implements i {
    public static final int INSTANCE_ID_DEFAULT = -1;
    private static final String TAG = "LynxContext";
    private static final String UIAPPEAREVENT = "uiappear";
    private static final String UIDISAPPEAREVENT = "uidisappear";
    private static ILynxTextService sLynxTextService = null;
    private static boolean sSupportUsageHint = true;
    private int embeddedMode;
    private w7a.a.b fontLoader;
    private f8a.a genericResourceFetcher;
    private boolean hasCustomGenericFetcher;
    private boolean hasCustomMediaFetcher;
    private boolean hasCustomTemplateFetcher;
    private boolean isFallbackProcess;
    private com.lynx.tasm.group.d lynxViewGroup;
    private m mAsyncImageInterceptor;
    private WeakReference<UIBody.UIBodyView> mBodyView;
    private final Map<String, ReadableMap> mCSSFontFaces;
    private JavaOnlyMap mCSSKeyframes;
    private h mClaySnapshotProvider;
    private Map<String, Object> mContextData;
    private boolean mEnableAsyncImageCallback;
    private Boolean mEnableAsyncLoadImage;
    private boolean mEnableAutoExpose;
    private boolean mEnableEngineReuse;
    private boolean mEnableImageResourceHint;
    private boolean mEnableImageSmallDiskCache;
    private boolean mEnableVSyncAligned;
    private EventEmitter mEventEmitter;
    private com.lynx.tasm.behavior.ui.h mExposure;
    private Map<String, com.lynx.jsbridge.d> mExtensionModules;
    private FluencyTraceHelper mFluencyTraceHelper;
    private Float mFontScale;
    private boolean mForceDarkAllowed;
    private boolean mForceImageAsyncRequest;
    private final LynxFrameRecorder.d mFrameCallback;
    private Object mFrescoCallerContext;
    private Map<String, String> mImageCustomParams;
    private v7a.h mImageFetcher;
    private m mImageInterceptor;
    private boolean mInPreLoad;
    private int mInstanceId;
    private WeakReference<d0> mIntersectionObserverManager;
    private String mJSGroupThreadName;
    private WeakReference<JSProxy> mJSProxy;
    private WeakReference<LynxLayoutProxy> mLayoutProxy;
    private boolean mLayoutThreadChanged;
    private com.lynx.tasm.g mListNodeInfoFetcher;
    private LynxBooleanOption mLongTaskMonitorEnabled;
    private Object mLynxExtraData;
    private t mLynxFrameViewProvider;
    private u7a.h mLynxImageConfig;
    private WeakReference<LynxUIOwner> mLynxUIOwner;
    private q1 mLynxViewClient;
    private WeakReference<LynxViewClientV2> mLynxViewClientV2;
    private t1 mPageConfig;
    private Map<String, FontFace> mParsedFontFace;
    private List<r0> mPatchFinishListeners;
    private WeakReference<PerformanceController> mPerfController;
    private int mPlatformMeasureHeightCache;
    private int mPlatformMeasureWidthCache;
    private boolean mPrefetchImageOnCreate;
    private WeakReference<v0> mShadowNodeOwnerRef;
    private Map<String, Object> mSharedData;
    private String mTemplateUrl;
    private b1 mTouchEventDispatcher;
    private UIBody mUIBody;
    private DisplayMetrics mVirtualScreenMetrics;
    private g8a.a mediaResourceFetcher;
    private d8a.f providerRegistry;
    private String tapSlop;
    private h8a.a templateResourceFetcher;

    public class a implements Runnable {
        public final /* synthetic */ WeakReference a;

        @Override // java.lang.Runnable
        public final void run() {
            LynxViewClientV2 r0 = (LynxViewClientV2) this.a.get();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.c();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(WeakReference r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ JSONObject b;

        @Override // java.lang.Runnable
        public final void run() {
            LynxViewClientV2 r0 = (LynxViewClientV2) this.a.get();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(WeakReference r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ LynxContext b;

        @Override // java.lang.Runnable
        public final void run() {
            LynxContext.access$100(this.b).s(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LynxContext r1, HashMap r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ LynxContext a;

        @Override // java.lang.Runnable
        public final void run() {
            LynxContext.access$100(this.a).p();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(LynxContext r1) {
            this.a = r1;
        }
    }

    public static final class e implements LynxFrameRecorder.d {
        public final WeakReference<LynxContext> a;

        public e(LynxContext r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.lynx.tasm.recording.LynxFrameRecorder.d
        public final void a(JSONObject r2) {
            LynxContext r0 = this.a.get();
            if (r0 == null) goto L6;
            LynxContext.access$200(r0, r2);
            return;
        }
    }

    public static /* synthetic */ void a(LynxContext r0, int r1, com.lynx.tasm.base.e r2) {
        r0.lambda$findShadowNodeAndRunTask$0(r1, r2);
    }

    public h getClaySnapshotProvider() {
        return null;
    }

    public boolean getEnableAutoConcurrency() {
        return false;
    }

    public v7a.h getImageFetcher() {
        return null;
    }

    public t getLynxFrameViewProvider() {
        return null;
    }

    public u7a.h getLynxImageConfig() {
        return null;
    }

    public String getLynxSessionID() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public abstract void handleException(Exception r1);

    public void handleException(Exception r1, int r2) {
    }

    public void handleException(Exception r1, int r2, JSONObject r3) {
    }

    public void handleException(Exception r1, JSONObject r2) {
    }

    public void handleLynxError(LynxError r1) {
    }

    public void setClaySnapshotProvider(h r1) {
    }

    public void setEnableAutoConcurrency(boolean r1) {
    }

    public void setImageFetcher(v7a.h r1) {
    }

    public void setLynxFrameViewProvider(t r1) {
    }

    public void setLynxImageConfig(u7a.h r1) {
    }

    private void syncFrameRecorderCallback() {
        int r0 = this.mInstanceId;
        if (r0 != (-1)) goto L5;
        return;
    L5:
        LynxFrameRecorder r1 = LynxFrameRecorder.k;
        LynxFrameRecorder.d r2 = this.mFrameCallback;
        if (r2 != null) goto L8;
        r1.f.remove(Integer.valueOf(r0));
        return;
    L8:
        r1.f.put(Integer.valueOf(r0), r2);
    }

    public void EnsureEventDispatcher() {
        if (this.mTouchEventDispatcher == null) goto L5;
        return;
    L5:
        UIBody.UIBodyView r0 = getUIBodyView();
        if (r0 != null) goto L8;
        return;
    L8:
        ILynxUIRenderer r1 = r0.getLynxUIRendererInternal();
        if (r1 != null) goto L11;
        return;
    L11:
        if ((r1 instanceof LynxUIRenderer) == false) goto L15;
        ((LynxUIRenderer) r1).a();
        return;
    }

    public void clearExposure() {
        com.lynx.tasm.behavior.ui.h r0 = this.mExposure;
        if (r0 == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.behavior.ui.i(r0));
        return;
    }

    public void destory() {
        com.lynx.tasm.behavior.ui.h r0 = this.mExposure;
        if (r0 == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.behavior.ui.i(r0));
    L6:
        if (getEnableNewIntersectionObserver() == false) goto L13;
        WeakReference<d0> r1 = this.mIntersectionObserverManager;
        if (r1 == null) goto L14;
        d0 r2 = r1.get();
        if (r2 == null) goto L15;
        UIThreadUtils.runOnUiThreadImmediately(new c0(r2));
        return;
    L15:
        return;
    L14:
        return;
    }

    public boolean enableEventThrough() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.b;
    }

    public boolean getAutoExpose() {
        if (this.mEnableAutoExpose == false) goto L10;
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L9;
        LLog.e(TAG, "PageConfig is null.GetAutoExpose get default true!");
        return true;
    L9:
        return r0.a;
    L10:
        return false;
    }

    public boolean getCssAlignWithLegacyW3c() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.p;
    }

    public boolean getDefaultOverflowVisible() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.c;
    }

    public boolean getDefaultTextIncludePadding() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.A;
    }

    public boolean getEnableAutoNonFlatten() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.X;
    }

    public boolean getEnableCreateViewAsync() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.n;
    }

    public boolean getEnableDisexposureWhenLynxHidden() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.C;
    }

    public boolean getEnableEventRefactor() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.B;
    }

    public boolean getEnableExposureUIMargin() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.M;
    }

    public boolean getEnableExposureWhenLayout() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.D;
    }

    public boolean getEnableExposureWhenReload() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.E;
    }

    public boolean getEnableFiberArch() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.J;
    }

    public boolean getEnableFlattenTranslateZ() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.F;
    }

    public boolean getEnableLoadImageFromService() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.j;
    }

    public double getEnableLynxScrollFluency() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return -1.0d;
    L5:
        return r0.P;
    }

    public boolean getEnableNativeInteraction() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.V;
    }

    public boolean getEnableNewIntersectionObserver() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.I;
    }

    public boolean getEnableNewSticky() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.T;
    }

    public boolean getEnableTransformedTouchPosition() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.S;
    }

    public boolean getEnableVsyncAlignedFlush() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.o;
    }

    public FluencyTraceHelper getFluencyTraceHelper() {
        if (this.mFluencyTraceHelper != null) goto L6;
        this.mFluencyTraceHelper = new FluencyTraceHelper(this);
    L6:
        return this.mFluencyTraceHelper;
    }

    public float getFontScale() {
        if (this.mFontScale != null) goto L6;
        this.mFontScale = Float.valueOf(getResources().getConfiguration().fontScale);
    L6:
        return this.mFontScale.floatValue();
    }

    public f8a.a getGenericResourceFetcher() {
        if (this.hasCustomGenericFetcher == false) goto L7;
        return null;
    L7:
        return this.genericResourceFetcher;
    }

    public d0 getIntersectionObserverManager() {
        WeakReference<d0> r0 = this.mIntersectionObserverManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public int getLongPressDuration() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.N;
    }

    public com.lynx.tasm.behavior.ui.accessibility.d getLynxAccessibilityWrapper() {
        UIBody r0 = this.mUIBody;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLynxAccessibilityWrapper();
    }

    public LynxUIOwner getLynxUIOwner() {
        return this.mLynxUIOwner.get();
    }

    public int getMapContainerType() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.O;
    }

    public g8a.a getMediaResourceFetcher() {
        if (this.hasCustomMediaFetcher == false) goto L7;
        return null;
    L7:
        return this.mediaResourceFetcher;
    }

    public int getObserverFrameRate() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return 20;
    L5:
        return r0.L;
    }

    public String getPageVersion() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L7;
        LLog.e(TAG, "PageConfig is null.GetPageVersion get default error;");
        return "error";
    L7:
        return r0.d;
    }

    public PerformanceController getPerfController() {
        WeakReference<PerformanceController> r0 = this.mPerfController;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public Long getRuntimeId() {
        JSProxy r0 = this.mJSProxy.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.b);
    }

    public h8a.a getTemplateResourceFetcher() {
        if (this.hasCustomTemplateFetcher == false) goto L7;
        return null;
    L7:
        return this.templateResourceFetcher;
    }

    public UIBody.UIBodyView getUIBodyView() {
        WeakReference<UIBody.UIBodyView> r0 = this.mBodyView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public void initUIExposure() {
        this.mExposure = new com.lynx.tasm.behavior.ui.h();
        LynxUIOwner r0 = this.mLynxUIOwner.get();
        if (r0 == null) goto L17;
        com.lynx.tasm.behavior.ui.h r1 = this.mExposure;
        UIBody r2 = r0.getRootUI();
        r1.getClass();
        r1.a = new WeakReference(r2);
        if (r2 == null) goto L7;
        LynxContext r3 = r2.getLynxContext();
    L8:
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        r1.A = r4;
        if (r4 == true) goto L17;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.behavior.ui.i(r1));
        goto L17
    L10:
        if (r3.isFragmentLayerRenderOn() == false) goto L13;
        r4 = false;
        goto L14
    L7:
        r3 = null;
    L17:
        WeakReference r5 = new WeakReference(this);
        com.lynx.tasm.behavior.ui.h r6 = this.mExposure;
        r6.B = new com.lynx.tasm.behavior.ui.h.d(r5);
        r6.l(this);
    }

    public boolean isAsyncInitTTVideoEngine() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.l;
    }

    public boolean isAsyncRedirect() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.e;
    }

    public boolean isEmbeddedModeOn() {
        if ((this.embeddedMode & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isEnableAsyncLoadImage() {
        Boolean r0 = this.mEnableAsyncLoadImage;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isEnableAsyncRequestImage() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.h;
    }

    public boolean isEnableCheckLocalImage() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.g;
    }

    public boolean isEnableNewGesture() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.G;
    }

    public boolean isFragmentLayerRenderOn() {
        if ((this.embeddedMode & 8) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLayoutInElementModeOn() {
        if ((this.embeddedMode & 12) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNewClipModeEnabled() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.y;
    }

    public boolean isSyncImageAttach() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.f;
    }

    public boolean isTextBoringLayoutEnabled() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.x;
    }

    public boolean isTextLayoutCacheEnabled() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.R;
    }

    public boolean isTextOverflowEnabled() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.w;
    }

    public boolean isTextRefactorEnabled() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.v;
    }

    public boolean isTextServiceModeOn() {
        if ((this.embeddedMode & 16) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTouchMoving() {
        b1 r0 = this.mTouchEventDispatcher;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.q;
    }

    public boolean isUseImagePostProcessor() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.i;
    }

    public boolean isUseNewSwiper() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.k;
    }

    public void onAttachedToWindow() {
        com.lynx.tasm.behavior.ui.h r0 = this.mExposure;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public void onGestureRecognized() {
        b1 r0 = this.mTouchEventDispatcher;
        if (r0 == null) goto L8;
        r0.s = true;
        if (r0.h.isEmpty() == true) goto L9;
        r0.g(8);
        return;
    L9:
        return;
    }

    public void reset() {
        Map<String, ReadableMap> r0 = this.mCSSFontFaces;
        monitor-enter(r0);
        this.mCSSFontFaces.clear();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        b1 r1 = this.mTouchEventDispatcher;
        if (r1 == null) goto L9;
        r1.c = null;
        r1.i = null;
        r1.j.clear();
    L9:
        com.lynx.tasm.behavior.ui.h r2 = this.mExposure;
        if (r2 == null) goto L13;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.behavior.ui.i(r2));
    L13:
        if (getEnableNewIntersectionObserver() == false) goto L25;
        WeakReference<d0> r3 = this.mIntersectionObserverManager;
        if (r3 == null) goto L26;
        d0 r4 = r3.get();
        if (r4 == null) goto L27;
        UIThreadUtils.runOnUiThreadImmediately(new c0(r4));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void resumeExposure() {
        if (this.mExposure == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new d(this));
        return;
    }

    public boolean useRelativeKeyboardHeightApi() {
        t1 r0 = this.mPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.z;
    }

    public boolean enableEventReporter() {
        return !isEmbeddedModeOn();
    }

    public boolean enableTiming() {
        return !isEmbeddedModeOn();
    }

    @Override // com.lynx.tasm.behavior.r
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        LynxView r0 = getLynxView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBaseInspectorOwner();
    }

    public UIBody.UIBodyView getBodyView() {
        return getUIBodyView();
    }

    @Override // com.lynx.tasm.behavior.r
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public LynxView getLynxView() {
        UIBody.UIBodyView r0 = getUIBodyView();
        if ((r0 instanceof LynxView) == false) goto L7;
        return (LynxView) r0;
    L7:
        if ((r0 instanceof LynxFrameView) == true) goto L9;
        return null;
    L9:
        return ((LynxFrameView) r0).getRootView();
    }

    public m getAsyncImageInterceptor() {
        return this.mAsyncImageInterceptor;
    }

    public Map getContextData() {
        return this.mContextData;
    }

    public boolean getEnableImageResourceHint() {
        return this.mEnableImageResourceHint;
    }

    public boolean getEnableImageSmallDiskCache() {
        return this.mEnableImageSmallDiskCache;
    }

    public boolean getEnableVSyncAligned() {
        return this.mEnableVSyncAligned;
    }

    public EventEmitter getEventEmitter() {
        return this.mEventEmitter;
    }

    public com.lynx.tasm.behavior.ui.h getExposure() {
        return this.mExposure;
    }

    public Map<String, com.lynx.jsbridge.d> getExtensionModules() {
        return this.mExtensionModules;
    }

    public w7a.a.b getFontLoader() {
        return this.fontLoader;
    }

    public boolean getForceDarkAllowed() {
        return this.mForceDarkAllowed;
    }

    public Object getFrescoCallerContext() {
        return this.mFrescoCallerContext;
    }

    public Map<String, String> getImageCustomParam() {
        return this.mImageCustomParams;
    }

    public int getInstanceId() {
        return this.mInstanceId;
    }

    public String getJSGroupThreadName() {
        return this.mJSGroupThreadName;
    }

    public com.lynx.tasm.g getListNodeInfoFetcher() {
        return this.mListNodeInfoFetcher;
    }

    public LynxBooleanOption getLongTaskMonitorEnabled() {
        return this.mLongTaskMonitorEnabled;
    }

    public Object getLynxExtraData() {
        return this.mLynxExtraData;
    }

    public q1 getLynxViewClient() {
        return this.mLynxViewClient;
    }

    public List<r0> getPatchFinishListeners() {
        return this.mPatchFinishListeners;
    }

    public int getPlatformMeasureHeightCache() {
        return this.mPlatformMeasureHeightCache;
    }

    public int getPlatformMeasureWidthCache() {
        return this.mPlatformMeasureWidthCache;
    }

    public d8a.f getProviderRegistry() {
        return this.providerRegistry;
    }

    public com.lynx.tasm.group.d getRuntimeCacheManager() {
        return this.lynxViewGroup;
    }

    public DisplayMetrics getScreenMetrics() {
        return this.mVirtualScreenMetrics;
    }

    public String getTapSlop() {
        return this.tapSlop;
    }

    public String getTemplateUrl() {
        return this.mTemplateUrl;
    }

    public ILynxTextService getTextService() {
        return sLynxTextService;
    }

    public b1 getTouchEventDispatcher() {
        return this.mTouchEventDispatcher;
    }

    public UIBody getUIBody() {
        return this.mUIBody;
    }

    public boolean hasLayoutThreadChanged() {
        return this.mLayoutThreadChanged;
    }

    public m imageInterceptor() {
        return this.mImageInterceptor;
    }

    public boolean isEnableAsyncImageCallback() {
        return this.mEnableAsyncImageCallback;
    }

    public boolean isEnginePoolEnabled() {
        return this.mEnableEngineReuse;
    }

    public boolean isFallbackProcess() {
        return this.isFallbackProcess;
    }

    public boolean isForceImageAsyncRequest() {
        return this.mForceImageAsyncRequest;
    }

    public boolean isInPreLoad() {
        return this.mInPreLoad;
    }

    public boolean isPrefetchImageOnCreate() {
        return this.mPrefetchImageOnCreate;
    }

    public static /* synthetic */ com.lynx.tasm.behavior.ui.h access$100(LynxContext r0) {
        return r0.mExposure;
    }

    private void notifyLynxFrame(JSONObject r3) {
        WeakReference<LynxViewClientV2> r0 = this.mLynxViewClientV2;
        if (r0 != null) goto L5;
        return;
    L5:
        LynxEventReporter.runOnReportThread(new b(r0, r3));
    }

    public void addUIToExposedMap(LynxBaseUI r2) {
        addUIToExposedMap(r2, null, null, null);
    }

    public LynxBaseUI findLynxUIByComponentId(String r2) {
        LynxUIOwner r0 = this.mLynxUIOwner.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findLynxUIByComponentId(r2);
    }

    public LynxBaseUI findLynxUIByName(String r2) {
        LynxUIOwner r0 = this.mLynxUIOwner.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findLynxUIByName(r2);
    }

    public LynxBaseUI findLynxUIBySign(int r2) {
        LynxUIOwner r0 = this.mLynxUIOwner.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getNode(r2);
    }

    public ShadowNode findShadowNodeBySign(int r2) {
        v0 r0 = this.mShadowNodeOwnerRef.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.g.a(r2);
    }

    public com.lynx.jsbridge.d getExtensionModuleByKey(String r2) {
        return this.mExtensionModules.get(r2);
    }

    public FontFace getFontFace(String r6) {
        String[] r7 = r6.split(",");
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L26;
        String r2 = com.lynx.tasm.utils.c.d(r7[r1]);
        if (TextUtils.isEmpty(r2) == true) goto L20;
        monitor-enter(com.lynx.tasm.utils.c.class);
    L23:
        th = move-exception;
        throw th;
    L10:
        if (this.mParsedFontFace != null) goto L12;
        this.mParsedFontFace = new HashMap();     // Catch: Throwable -> L23
    L12:
        FontFace r4 = this.mParsedFontFace.get(r2);     // Catch: Throwable -> L23
        if (r4 != null) goto L21;
        FontFace r5 = com.lynx.tasm.utils.c.b(this, r2);     // Catch: Throwable -> L23
        if (r5 != null) goto L16;
        monitor-exit(com.lynx.tasm.utils.c.class);     // Catch: Throwable -> L23
        goto L20
    L16:
        this.mParsedFontFace.put(r2, r5);     // Catch: Throwable -> L23
        monitor-exit(com.lynx.tasm.utils.c.class);     // Catch: Throwable -> L23
        return r5;
    L21:
        monitor-exit(com.lynx.tasm.utils.c.class);     // Catch: Throwable -> L23
        return r4;
    L20:
        r1 = r1 + 1;     // Catch: Throwable -> L23
        goto L3
    L26:
        return null;
    }

    public Map getFontFaces(String r4) {
        Map<String, ReadableMap> r0 = this.mCSSFontFaces;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mCSSFontFaces.containsKey(r4) == false) goto L7;
        ReadableMap r5 = this.mCSSFontFaces.get(r4);     // Catch: Throwable -> L14
    L8:
        if (r5 == null) goto L12;
        HashMap<String, Object> r6 = r5.asHashMap();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r6;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return null;
    L7:
        r5 = null;
        goto L8
    }

    public com.lynx.jsbridge.c getJSModule(String r3) {
        WeakReference<JSProxy> r0 = this.mJSProxy;
        if (r0 != null) goto L5;
        return null;
    L5:
        JSProxy r1 = r0.get();
        if (r1 != null) goto L8;
        return null;
    L8:
        return new com.lynx.jsbridge.c(r3, r1);
    }

    public ReadableMap getKeyframes(String r3) {
        JavaOnlyMap r0 = this.mCSSKeyframes;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.hasKey(r3) == true) goto L8;
        return null;
    L8:
        return this.mCSSKeyframes.getMap(r3);
    }

    public Object getSharedData(String r2) {
        Map<String, Object> r0 = this.mSharedData;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    public void markFallbackProcess(boolean r1) {
        this.isFallbackProcess = r1;
        if (r1 == false) goto L5;
        return;
    L5:
        if (getUIBodyView() == null) goto L9;
        getUIBodyView().clearNodeIndexImageMap();
        getUIBodyView().markNeedRemoveExistingViews();
        getUIBodyView().removeExistingViews();
        return;
    }

    public void notifyResourceLoaded(LynxViewClientV2.a r2) {
        WeakReference<LynxViewClientV2> r3 = this.mLynxViewClientV2;
        if (r3 != null) goto L5;
        return;
    L5:
        LynxEventReporter.runOnReportThread(new a(r3));
    }

    public void onGestureRecognized(LynxBaseUI r2) {
        b1 r0 = this.mTouchEventDispatcher;
        if (r0 == null) goto L8;
        HashSet<Integer> r1 = r0.u;
        if (r1 == null) goto L9;
        r1.add(Integer.valueOf(r2.getSign()));
        return;
    L9:
        return;
    }

    public void onPageConfigDecoded(t1 r2) {
        this.mPageConfig = r2;
        PerformanceController r0 = getPerfController();
        if (r0 == null) goto L9;
        if (r2 != null) goto L6;
        Boolean r3 = null;
    L7:
        r0.j = r3;
        return;
    L6:
        r3 = Boolean.valueOf(r2.Q);
        goto L7
    }

    public void onPropsChanged(LynxBaseUI r2) {
        b1 r0 = this.mTouchEventDispatcher;
        if (r0 == null) goto L8;
        HashSet<Integer> r1 = r0.v;
        if (r1 == null) goto L9;
        r1.add(Integer.valueOf(r2.getSign()));
        return;
    L9:
        return;
    }

    public void onRootViewDraw(Canvas r2) {
        com.lynx.tasm.behavior.ui.h r3 = this.mExposure;
        if (r3 == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new f0(r3));
    L6:
        if (getEnableNewIntersectionObserver() == false) goto L13;
        WeakReference<d0> r4 = this.mIntersectionObserverManager;
        if (r4 == null) goto L14;
        d0 r5 = r4.get();
        if (r5 == null) goto L15;
        UIThreadUtils.runOnUiThreadImmediately(new f0(r5));
        return;
    L15:
        return;
    L14:
        return;
    }

    public void registerPatchFinishListener(r0 r2) {
        if (this.mPatchFinishListeners != null) goto L5;
        this.mPatchFinishListeners = new ArrayList();
    L5:
        this.mPatchFinishListeners.add(r2);
    }

    public void removeAnimationKeyframe(String r2) {
        JavaOnlyMap r0 = this.mCSSKeyframes;
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }

    public void removeUIFromExposedMap(LynxBaseUI r2) {
        removeUIFromExposedMap(r2, null);
    }

    public void reportModuleCustomError(String r4) {
        this.mLynxViewClient.onReceivedError(new LynxError(r4, 99800));
    }

    public void reportResourceError(String r4) {
        q1 r0 = this.mLynxViewClient;
        if (r0 == null) goto L6;
        r0.onReceivedError(new LynxError(r4, 39800));
        return;
    }

    public void runOnJSThread(Runnable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        JSProxy r0 = this.mJSProxy.get();
        if (r0 != null) goto L7;
        return;
    L7:
        r0.h(r2);
    }

    public void runOnLayoutThread(Runnable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        WeakReference<LynxLayoutProxy> r0 = this.mLayoutProxy;
        if (r0 != null) goto L7;
        return;
    L7:
        LynxLayoutProxy r1 = r0.get();
        if (r1 != null) goto L10;
        return;
    L10:
        r1.c(r2);
    }

    public void runOnTasmThread(Runnable r2) {
        UIBody.UIBodyView r0 = getUIBodyView();
        if (r0 == null) goto L6;
        r0.runOnTasmThread(r2);
        return;
    }

    public void setAsyncImageInterceptor(m r1) {
        this.mAsyncImageInterceptor = r1;
    }

    @Override // com.lynx.tasm.behavior.r, android.content.MutableContextWrapper
    public /* bridge */ /* synthetic */ void setBaseContext(Context r1) {
        super.setBaseContext(r1);
    }

    public void setContextData(HashMap<String, Object> r1) {
        this.mContextData = r1;
    }

    public void setEmbeddedMode(int r1) {
        this.embeddedMode = r1;
    }

    public void setEnableAsyncImageCallback(boolean r1) {
        this.mEnableAsyncImageCallback = r1;
    }

    public void setEnableAsyncLoadImage(boolean r1) {
        this.mEnableAsyncLoadImage = Boolean.valueOf(r1);
    }

    public void setEnableAutoExpose(boolean r1) {
        this.mEnableAutoExpose = r1;
    }

    public void setEnableImageResourceHint(boolean r1) {
        this.mEnableImageResourceHint = r1;
    }

    public void setEnableImageSmallDiskCache(boolean r1) {
        this.mEnableImageSmallDiskCache = r1;
    }

    public void setEnableReuseEngine(boolean r1) {
        this.mEnableEngineReuse = r1;
    }

    public void setEnableVSyncAligned(boolean r1) {
        this.mEnableVSyncAligned = r1;
    }

    public void setEventEmitter(EventEmitter r1) {
        this.mEventEmitter = r1;
    }

    public void setFontFaces(ReadableMap r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<String, ReadableMap> r0 = this.mCSSFontFaces;
        monitor-enter(r0);
        ReadableMapKeySetIterator r1 = r6.keySetIterator();     // Catch: Throwable -> L15
    L8:
        if (r1.hasNextKey() == false) goto L13;
        String r2 = r1.nextKey();     // Catch: Throwable -> L15
        ReadableMap r3 = r6.getMap(r2);     // Catch: Throwable -> L15
        if (r3 == null) goto L8;
        this.mCSSFontFaces.put(r2, r3);     // Catch: Throwable -> L15
        goto L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void setFontLoader(w7a.a.b r1) {
        this.fontLoader = r1;
    }

    public void setForceDarkAllowed(boolean r5) {
        this.mForceDarkAllowed = r5;
        if (r5 == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        return;
    L7:
        if (sSupportUsageHint == true) goto L9;
        return;
    L9:
        if (LynxFlattenUI.sSetUsageHint == null) goto L15;
        return;
    L15:
        LynxFlattenUI.sSetUsageHint = RenderNode.class.getMethod("setUsageHint", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L13
        return;
    L13:
        sSupportUsageHint = false;
        LLog.e(TAG, "NoSuchMethodException: setUsageHint");
    }

    public void setForceImageAsyncRequest(boolean r1) {
        this.mForceImageAsyncRequest = r1;
    }

    public void setFrescoCallerContext(Object r1) {
        this.mFrescoCallerContext = r1;
    }

    public void setGenericResourceFetcher(f8a.a r1) {
        this.genericResourceFetcher = r1;
    }

    public void setHasCustomGenericFetcher(boolean r3) {
        LLog.i(TAG, "setHasCustomGenericFetcher: " + r3);
        this.hasCustomGenericFetcher = r3;
    }

    public void setHasCustomMediaFetcher(boolean r3) {
        LLog.i(TAG, "setHasCustomMediaFetcher: " + r3);
        this.hasCustomMediaFetcher = r3;
    }

    public void setHasCustomTemplateFetcher(boolean r3) {
        LLog.i(TAG, "setHasCustomTemplateFetcher: " + r3);
        this.hasCustomTemplateFetcher = r3;
    }

    public void setImageCustomParam(Map<String, String> r1) {
        this.mImageCustomParams = r1;
    }

    public void setImageInterceptor(m r1) {
        this.mImageInterceptor = r1;
    }

    public void setInPreLoad(boolean r2) {
        this.mInPreLoad = r2;
        EventEmitter r0 = this.mEventEmitter;
        if (r0 == null) goto L6;
        r0.setInPreLoad(r2);
        return;
    }

    public void setInstanceId(int r3) {
        int r0 = this.mInstanceId;
        if (r0 == (-1)) goto L6;
        if (r0 == r3) goto L6;
        LynxFrameRecorder r1 = LynxFrameRecorder.k;
        r1.x(r0);
        int r2 = this.mInstanceId;
        r1.f.remove(Integer.valueOf(r2));
    L6:
        this.mInstanceId = r3;
        if (isEmbeddedModeOn() == true) goto L10;
        syncFrameRecorderCallback();
        return;
    }

    public void setIntersectionObserverManager(d0 r2) {
        this.mIntersectionObserverManager = new WeakReference(r2);
    }

    public void setJSGroupThreadName(String r1) {
        this.mJSGroupThreadName = r1;
    }

    public void setJSProxy(JSProxy r2) {
        this.mJSProxy = new WeakReference(r2);
    }

    public void setKeyframes(ReadableMap r2) {
        if (this.mCSSKeyframes != null) goto L5;
        this.mCSSKeyframes = new JavaOnlyMap();
    L5:
        if (r2 == null) goto L8;
        this.mCSSKeyframes.merge(r2);
        return;
    }

    public void setLayoutProxy(LynxLayoutProxy r2) {
        this.mLayoutProxy = new WeakReference(r2);
    }

    public void setLayoutThreadChanged(boolean r1) {
        this.mLayoutThreadChanged = r1;
    }

    public void setListNodeInfoFetcher(com.lynx.tasm.g r1) {
        this.mListNodeInfoFetcher = r1;
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption r1) {
        this.mLongTaskMonitorEnabled = r1;
    }

    public void setLynxExtraData(Object r1) {
        this.mLynxExtraData = r1;
    }

    public void setLynxUIOwner(LynxUIOwner r2) {
        this.mLynxUIOwner = new WeakReference(r2);
    }

    public void setLynxView(LynxView r1) {
        setUIBodyView(r1);
    }

    public void setLynxViewClient(q1 r1) {
        this.mLynxViewClient = r1;
    }

    public void setLynxViewClientV2(LynxViewClientV2 r2) {
        this.mLynxViewClientV2 = new WeakReference(r2);
    }

    public void setMediaResourceFetcher(g8a.a r1) {
        this.mediaResourceFetcher = r1;
    }

    public void setPerfController(PerformanceController r2) {
        if (r2 == null) goto L5;
        this.mPerfController = new WeakReference(r2);
        return;
    }

    public void setPlatformMeasureHeightCache(int r1) {
        this.mPlatformMeasureHeightCache = r1;
    }

    public void setPlatformMeasureWidthCache(int r1) {
        this.mPlatformMeasureWidthCache = r1;
    }

    public void setPrefetchImageOnCreate(boolean r1) {
        this.mPrefetchImageOnCreate = r1;
    }

    public void setProviderRegistry(d8a.f r1) {
        this.providerRegistry = r1;
    }

    public void setRuntimeCacheManager(com.lynx.tasm.group.d r1) {
        this.lynxViewGroup = r1;
    }

    public void setShadowNodeOwner(v0 r2) {
        this.mShadowNodeOwnerRef = new WeakReference(r2);
    }

    public void setTapSlop(String r1) {
        this.tapSlop = r1;
    }

    public void setTemplateResourceFetcher(h8a.a r1) {
        this.templateResourceFetcher = r1;
    }

    public void setTemplateUrl(String r1) {
        this.mTemplateUrl = r1;
    }

    public void setTouchEventDispatcher(b1 r1) {
        this.mTouchEventDispatcher = r1;
    }

    public void setUIBody(UIBody r1) {
        this.mUIBody = r1;
    }

    public void setUIBodyView(UIBody.UIBodyView r3) {
        if (r3 == null) goto L4;
        boolean r0 = true;
    L5:
        setHasLynxViewAttached(r0);
        LLog.i("LynxUIRenderer", "lynxContext setUIBodyView" + r3 + this);
        this.mBodyView = new WeakReference(r3);
        return;
    L4:
        r0 = false;
        goto L5
    }

    public void stopExposure(HashMap<String, Object> r2) {
        if (this.mExposure == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new c(this, r2));
        return;
    }

    public void unregisterPatchFinishListener(r0 r2) {
        List<r0> r0 = this.mPatchFinishListeners;
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }

    public void onGestureRecognized(int r2) {
        b1 r0 = this.mTouchEventDispatcher;
        if (r0 == null) goto L8;
        HashSet<Integer> r1 = r0.u;
        if (r1 == null) goto L9;
        r1.add(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    public LynxContext(Context r2, DisplayMetrics r3) {
        super(r2);
        this.mCSSKeyframes = null;
        this.mCSSFontFaces = new HashMap();
        this.mTouchEventDispatcher = null;
        this.mPerfController = null;
        this.mTemplateUrl = null;
        this.mJSGroupThreadName = null;
        this.mLynxViewClient = null;
        this.mLynxViewClientV2 = null;
        this.mBodyView = null;
        this.mExposure = null;
        this.mFrescoCallerContext = null;
        this.mEnableImageSmallDiskCache = false;
        this.mPrefetchImageOnCreate = false;
        this.mEnableAsyncImageCallback = false;
        this.mEnableImageResourceHint = false;
        this.mLongTaskMonitorEnabled = LynxBooleanOption.UNSET;
        this.mInstanceId = -1;
        this.mForceImageAsyncRequest = false;
        this.mExtensionModules = new HashMap();
        this.embeddedMode = 0;
        this.isFallbackProcess = false;
        this.mLayoutThreadChanged = false;
        this.mEnableEngineReuse = false;
        this.tapSlop = "50px";
        this.mFrameCallback = new e(this);
        this.mVirtualScreenMetrics = r3;
        if (sLynxTextService != null) goto L6;
        sLynxTextService = (ILynxTextService) i8a.n.c().a(ILynxTextService.class);
        return;
    }

    public static /* synthetic */ void access$200(LynxContext r0, JSONObject r1) {
        r0.notifyLynxFrame(r1);
    }

    private void lambda$findShadowNodeAndRunTask$0(int r2, com.lynx.tasm.base.e r3) {
        v0 r0 = this.mShadowNodeOwnerRef.get();
        if (r0 == null) goto L6;
        r3.accept(r0.g.a(r2));
        return;
    }

    public LynxBaseUI findLynxUIByIdSelector(String r2, LynxBaseUI r3) {
        LynxUIOwner r0 = this.mLynxUIOwner.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findLynxUIByIdSelector(r2, r3);
    }

    public void findShadowNodeAndRunTask(final int r2, final com.lynx.tasm.base.e<ShadowNode> r3) {
        runOnLayoutThread(new s(this, r2, r3));
    }

    public <T> T getSharedData(String r3, Class<T> r4) {
        Map<String, Object> r0 = this.mSharedData;
        if (r0 != null) goto L5;
        return null;
    L5:
        Object r5 = r0.get(r3);
        if (r4.isInstance(r5) == true) goto L8;
        return null;
    L8:
        return r4.cast(r5);
    }

    public void putSharedData(String r2, Object r3) {
        if (this.mSharedData != null) goto L5;
        this.mSharedData = new HashMap();
    L5:
        this.mSharedData.put(r2, r3);
    }

    public void removeUIFromExposedMap(LynxBaseUI r3, String r4) {
        if (r4 == null) goto L4;
    L13:
        if (r4 != null) goto L17;
        if (r3.getExposureID() != null) goto L17;
        return;
    L17:
        if (this.mExposure != null) goto L19;
        initUIExposure();
    L19:
        this.mExposure.o(r3, r4);
        return;
    L4:
        if (r3.getEvents() == null) goto L13;
        if (r3.getEvents().containsKey(UIAPPEAREVENT) == true) goto L10;
        if (r3.getEvents().containsKey(UIDISAPPEAREVENT) == false) goto L13;
    L10:
        if (this.mExposure != null) goto L12;
        initUIExposure();
    L12:
        this.mExposure.o(r3, String.valueOf(r3.getSign()));
        goto L13
    }

    public void sendGlobalEvent(String r3, JavaOnlyArray r4) {
        LLog.i(TAG, "LynxContext sendGlobalEvent " + r3 + " with this: " + toString());
        com.lynx.jsbridge.c r0 = getJSModule("GlobalEventEmitter");
        if (r0 != null) goto L6;
        LLog.e(TAG, "LynxContext sendGlobalEvent failed since eventEmitter is null with this: " + toString());
        return;
    L6:
        JavaOnlyArray r1 = new JavaOnlyArray();
        r1.pushString(r3);
        r1.pushArray(r4);
        r0.a("emit", r1);
    }

    public void sendKeyEvent(int r4, String r5) {
        com.lynx.jsbridge.c r0 = getJSModule("GlobalEventEmitter");
        if (r0 != null) goto L6;
        LLog.e("Lynx", "sendGlobalEvent error, can't get GlobalEventEmitter");
        return;
    L6:
        JavaOnlyArray r1 = new JavaOnlyArray();
        r1.pushString(r5);
        JavaOnlyArray r2 = new JavaOnlyArray();
        r2.pushString(r5);
        r2.pushInt(r4);
        r1.pushArray(r2);
        r0.a("emit", r1);
    }

    public void setExtensionModuleForKey(com.lynx.jsbridge.d r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mExtensionModules.put(r3, r2);
    }

    public void setPlatformEventRootActive(int r7, boolean r8) {
        LynxUIOwner r0 = this.mLynxUIOwner.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.getPaintingContext() instanceof NativePaintingContext) == false) goto L14;
        NativePaintingContext r1 = (NativePaintingContext) r0.getPaintingContext();
        long r2 = r1.a;
        if (r2 != 0) goto L9;
        return;
    L9:
        if (r1.c == true) goto L16;
        r1.nativeSetPlatformEventRootActive(r2, r7, r8);
        return;
    L16:
        return;
    }

    public void updateScreenSize(int r2, int r3) {
        DisplayMetrics r0 = this.mVirtualScreenMetrics;
        r0.widthPixels = r2;
        r0.heightPixels = r3;
        com.lynx.tasm.behavior.ui.h r4 = this.mExposure;
        if (r4 == null) goto L6;
        r4.l(this);
        return;
    }

    public boolean isPlatformEventTargetEventThrough(int r9, float r10, float r11) {
        LynxUIOwner r0 = this.mLynxUIOwner.get();
        if (r0 != null) goto L5;
        return false;
    L5:
        if ((r0.getPaintingContext() instanceof NativePaintingContext) == false) goto L14;
        NativePaintingContext r2 = (NativePaintingContext) r0.getPaintingContext();
        long r3 = r2.a;
        if (r3 != 0) goto L9;
        return false;
    L9:
        if (r2.c == false) goto L12;
        return false;
    L12:
        return r2.nativeIsPlatformEventTargetEventThrough(r3, r9, r10, r11);
    L14:
        return false;
    }

    public void reportResourceError(String r2, String r3, LynxError r4) {
        if (this.mLynxViewClient == null) goto L8;
        if (r4 == null) goto L9;
        r4.setTemplateUrl(this.mTemplateUrl);
        r4.addCustomInfo(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, r2);
        r4.addCustomInfo("type", r3);
        this.mLynxViewClient.onReceivedError(r4);
        return;
    L9:
        return;
    }

    public void setPlatformEventRootOffset(int r8, float r9, float r10) {
        LynxUIOwner r0 = this.mLynxUIOwner.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.getPaintingContext() instanceof NativePaintingContext) == false) goto L14;
        NativePaintingContext r1 = (NativePaintingContext) r0.getPaintingContext();
        long r2 = r1.a;
        if (r2 != 0) goto L9;
        return;
    L9:
        if (r1.c == true) goto L16;
        r1.nativeSetPlatformEventRootOffset(r2, r8, r9, r10);
        return;
    L16:
        return;
    }

    public void reportResourceError(String r2, String r3, String r4) {
        reportResourceError(39800, r2, r3, r4);
    }

    public void addUIToExposedMap(LynxBaseUI r5, String r6, JavaOnlyMap r7, JavaOnlyMap r8) {
        if (r6 == null) goto L4;
    L13:
        if (r6 != null) goto L17;
        if (r5.getExposureID() != null) goto L17;
        return;
    L17:
        if (this.mExposure != null) goto L19;
        initUIExposure();
    L19:
        this.mExposure.m(r5, r6, r7, r8);
        return;
    L4:
        if (r5.getEvents() == null) goto L13;
        if (r5.getEvents().containsKey(UIAPPEAREVENT) == true) goto L10;
        if (r5.getEvents().containsKey(UIDISAPPEAREVENT) == false) goto L13;
    L10:
        if (this.mExposure != null) goto L12;
        initUIExposure();
    L12:
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("sendCustom", Boolean.TRUE);
        this.mExposure.m(r5, String.valueOf(r5.getSign()), null, r0);
        goto L13
    }

    public void reportResourceError(int r2, String r3, String r4, String r5) {
        reportResourceError(r3, r4, new LynxError(r2, r5));
    }

    public void invokeUIMethod(String r8, ReadableArray r9, String r10, ReadableMap r11, Callback r12) {
        LynxUIOwner r1 = this.mLynxUIOwner.get();
        if (r1 == null) goto L6;
        r1.invokeUIMethod(r8, r9, r10, r11, r12);
        return;
    }
}
