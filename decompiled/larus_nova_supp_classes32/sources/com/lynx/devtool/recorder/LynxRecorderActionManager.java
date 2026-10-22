package com.lynx.devtool.recorder;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import android.util.Base64InputStream;
import android.util.DisplayMetrics;
import android.util.JsonReader;
import android.util.JsonToken;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.BuildConfig;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.a2;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.o1;
import com.lynx.tasm.q1;
import com.lynx.tasm.s0;
import com.lynx.tasm.utils.LynxViewBuilderProperty;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.InflaterInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderActionManager {
    private static final int END_TESTBENCH = 10;
    private static final int IS_FLATTEN_NODE = 8;
    private static final int IS_VIRTUAL_NODE = 2;
    private static final int LOAD_TEMPLATE = 4;
    private static final int LOAD_TEMPLATE_BUNDLE = 9;
    private static final int ON_TESTBENCH_COMPLETE = 14;
    private static final int RELOAD_TEMPLATE = 7;
    private static final int SEND_EVENT_ANDROID = 6;
    private static final int SEND_GLOBAL_EVENT = 5;
    private static final int SET_GLOBAL_PROPS = 3;
    private static final int SET_THREAD_STRATEGY = 2;
    private static final int SWITCH_ENGINE_FROM_UI_THREAD = 15;
    private static final String TAG = "LynxRecorderActionManager";
    private static final int UPDATE_FONT_SCALE = 11;
    private static final int UPDATE_META_DATA = 13;
    private static final int UPDATE_PRE_DATA = 0;
    private static final int UPDATE_VIEW_PORT = 1;
    private static final HashMap<String, Integer> mCanMockFuncMap = null;
    private static final HashSet<String> mReloadFuncSet = null;
    public static final int sEndForAll = 1;
    public static final int sEndForFirstScreen = 0;
    private int mBackgroundColor;
    private final ArrayList<LynxRecorderActionCallback> mCallbacks;
    private JSONArray mComponentList;
    private JSONObject mConfig;
    private final Context mContext;
    private boolean mCreateWhenReload;
    private LynxRecorderReplayDataProviderInternal mDataProvider;
    private int mDelayEndInterval;
    private float mDensity;
    private boolean mDisableOptPushStyleToBundle;
    private boolean mDisableUpdateViewport;
    private LynxRecorderFetcher mDynamicFetcher;
    private int mEmbeddedMode;
    private boolean mEnableAirStrictMode;
    private boolean mEnableNativeScheduleCreateViewAsync;
    private boolean mEnableSizeOptimization;
    private boolean mEnableUnifyFixedBehavior;
    private boolean mForbidTimeFreeze;
    private TemplateData mGlobalPropCacheCloned;
    private TemplateData mGlobalProps;
    private JSONObject mGlobalPropsCache;
    private final Handler mHandler;
    private final Intent mIntent;
    private boolean mLandScape;
    private TemplateData mLoadTemplateData;
    private String mLoadTemplateURL;
    private LynxDebugInfoRecorderDelegate mLynxDebugInfoRecorderDelegate;
    private LynxGroup mLynxGroup;
    private LynxView mLynxView;
    private boolean mPreDecode;
    private List<String> mPreloadScripts;
    private byte[] mPreloadedTemplateSource;
    private float mRawFontScale;
    private String mRawUrl;
    private ArrayList<ReloadAction> mReloadList;
    private final AtomicInteger mReplayGeneration;
    private boolean mReplayGesture;
    private boolean mSSRLoaded;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mSourceURL;
    private long mStartTime;
    private LynxRecorderReplayStateView mStateView;
    private TemplateBundle mTemplateBundle;
    private a2 mTemplateBundleOptions;
    private JSONObject mTemplateBundleParams;
    private int mThreadMode;
    private JSONObject mThreadStrategyData;
    private String mUrl;
    private TestBenchLynxViewClient mViewClient;
    private final ViewGroup mViewGroup;
    private byte[] templateSource;

    /* JADX INFO: renamed from: com.lynx.devtool.recorder.LynxRecorderActionManager$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$android$util$JsonToken = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$android$util$JsonToken = r0;
            r0[JsonToken.BEGIN_OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$android$util$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$android$util$JsonToken[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$android$util$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$android$util$JsonToken[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public class InnerCallback implements d8a.b.a {
        private final int mReplayGeneration;
        final /* synthetic */ LynxRecorderActionManager this$0;

        public static /* synthetic */ void a(InnerCallback r0, byte[] r1) {
            r0.lambda$onSuccess$0(r1);
        }

        private /* synthetic */ void lambda$onSuccess$0(byte[] r3) {
            ParsedRecordData r4 = LynxRecorderActionManager.access$500(r3);     // Catch: OutOfMemoryError -> L4 Exception -> L6
            LynxRecorderActionManager.access$600(this.this$0, r4, this.mReplayGeneration);     // Catch: OutOfMemoryError -> L4 Exception -> L6
        L12:
            return;
        L6:
            e = move-exception;
            LynxRecorderActionManager.access$700(this.this$0, e, this.mReplayGeneration);
            return;
        L4:
            e = move-exception;
            LynxRecorderActionManager.access$700(this.this$0, e, this.mReplayGeneration);
        }

        @Override // d8a.b.a
        public void onFailed(String r2) {
            LynxRecorderActionManager.access$200(this.this$0, "onFailed");
            if (LynxRecorderActionManager.access$300(this.this$0, this.mReplayGeneration) == true) goto L5;
            return;
        L5:
            LynxRecorderActionManager.access$400(this.this$0).setReplayState(5);
        }

        @Override // d8a.b.a
        public void onSuccess(final byte[] r3) {
            LynxRecorderActionManager.access$200(this.this$0, "onSuccess");
            if (LynxRecorderActionManager.access$300(this.this$0, this.mReplayGeneration) == true) goto L5;
            return;
        L5:
            LynxRecorderActionManager.access$400(this.this$0).setReplayState(1);
            ThreadUtils.getThreadPool().execute(new f(this, r3));
        }

        public InnerCallback(LynxRecorderActionManager r1, int r2) {
            this.this$0 = r1;
            this.mReplayGeneration = r2;
        }
    }

    public class LynxDebugInfoRecorderDelegate implements h6a.a {
        private final Map<String, String> debugInfoDict;
        final /* synthetic */ LynxRecorderActionManager this$0;

        public LynxDebugInfoRecorderDelegate(LynxRecorderActionManager r1) {
            this.this$0 = r1;
            this.debugInfoDict = new HashMap();
        }

        @Override // h6a.a
        public String getDebugInfo(String r2) {
            return this.debugInfoDict.get(r2);
        }

        public void setDebugInfo(String r2, String r3) {
            this.debugInfoDict.put(r2, r3);
        }
    }

    public class LynxRecorderReplayDataProviderInternal implements LynxRecorderReplayDataProvider {
        public JSONObject callbackData;
        public JSONArray functionCall;
        public JSONArray jsbIgnoredInfo;
        public JSONObject jsbSettings;
        public JSONObject sharedData;
        final /* synthetic */ LynxRecorderActionManager this$0;

        @Override // com.lynx.devtool.recorder.LynxRecorderReplayDataProvider
        public JSONObject getCallbackData() {
            return this.callbackData;
        }

        @Override // com.lynx.devtool.recorder.LynxRecorderReplayDataProvider
        public JSONArray getFunctionCall() {
            return this.functionCall;
        }

        @Override // com.lynx.devtool.recorder.LynxRecorderReplayDataProvider
        public JSONArray getJsbIgnoredInfo() {
            return this.jsbIgnoredInfo;
        }

        @Override // com.lynx.devtool.recorder.LynxRecorderReplayDataProvider
        public JSONObject getJsbSettings() {
            return this.jsbSettings;
        }

        @Override // com.lynx.devtool.recorder.LynxRecorderReplayDataProvider
        public JSONObject getSharedData() {
            return this.sharedData;
        }

        private LynxRecorderReplayDataProviderInternal(LynxRecorderActionManager r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ LynxRecorderReplayDataProviderInternal(LynxRecorderActionManager r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static class ParsedRecordData {
        JSONArray actionList;
        JSONObject callbackData;
        JSONArray componentList;
        JSONObject config;
        JSONArray debugInfo;
        JSONArray functionCall;
        JSONArray jsbIgnoredInfo;
        JSONObject jsbSettings;
        JSONObject sharedData;

        private ParsedRecordData() {
        }

        public /* synthetic */ ParsedRecordData(AnonymousClass1 r1) {
            this();
        }
    }

    public interface RecordedInputStreamProvider {
        InputStream open() throws IOException;
    }

    public class ReloadAction {
        private long mDelayTime;
        private int mFunctionID;
        private JSONObject mParams;
        final /* synthetic */ LynxRecorderActionManager this$0;

        public void run() {
            Message r0 = new Message();
            r0.obj = this.mParams;
            r0.what = this.mFunctionID;
            LynxRecorderActionManager.access$000(this.this$0).sendMessageDelayed(r0, this.mDelayTime);
        }

        public long getDelayTime() {
            return this.mDelayTime;
        }

        public ReloadAction(LynxRecorderActionManager r1, JSONObject r2, int r3, long r4) {
            this.this$0 = r1;
            this.mParams = r2;
            this.mFunctionID = r3;
            this.mDelayTime = r4;
        }
    }

    public class TestBenchLynxViewClient extends q1 {
        final /* synthetic */ LynxRecorderActionManager this$0;

        @Override // com.lynx.tasm.q1
        public void onFirstScreen() {
            super.onFirstScreen();
            this.this$0.reloadAction();
            this.this$0.onReplayFinish(0);
        }

        private TestBenchLynxViewClient(LynxRecorderActionManager r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ TestBenchLynxViewClient(LynxRecorderActionManager r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static /* synthetic */ void a(LynxRecorderActionManager r0, int r1, String r2) {
        r0.lambda$downloadRecordedFile$4(r1, r2);
    }

    public static /* synthetic */ void b(LynxRecorderActionManager r0, int r1, Throwable r2) {
        r0.lambda$onRecordedFileParseFailed$2(r1, r2);
    }

    public static /* synthetic */ InputStream c(byte[] r0) {
        return lambda$parseRecordedBody$0(r0);
    }

    public static /* synthetic */ void d(LynxRecorderActionManager r0, int r1, ParsedRecordData r2) {
        r0.lambda$handleParsedRecordData$1(r1, r2);
    }

    public static /* synthetic */ InputStream e(LynxRecorderActionManager r0, String r1) {
        return r0.lambda$null$3(r1);
    }

    private int getLynxViewLayoutParams(int r2, int r3) {
        if (r2 == 1073741824) goto L6;
        return -2;
    L6:
        return r3;
    }

    private int getMeasureMode(int r2) {
        if (r2 != 1) goto L5;
        return 1073741824;
    L5:
        if (r2 == 2) goto L8;
        return 0;
    L8:
        return Integer.MIN_VALUE;
    }

    static {
        HashMap<String, Integer> r0 = new HashMap();
        mCanMockFuncMap = r0;
        r0.put("setGlobalProps", 3);
        r0.put("updateViewPort", 1);
        r0.put("loadTemplate", 4);
        r0.put("loadTemplateBundle", 9);
        r0.put("setThreadStrategy", 2);
        r0.put("updateDataByPreParsedData", 0);
        r0.put("sendGlobalEvent", 5);
        r0.put("sendEventAndroid", 6);
        r0.put("reloadTemplate", 7);
        r0.put("updateFontScale", 11);
        r0.put("updateMetaData", 13);
        r0.put("switchEngineFromUIThread", Integer.valueOf(SWITCH_ENGINE_FROM_UI_THREAD));
        HashSet<String> r1 = new HashSet();
        mReloadFuncSet = r1;
        r1.add("sendGlobalEvent");
        r1.add("updateDataByPreParsedData");
        r1.add("sendEventAndroid");
    }

    private void avoidLynxViewBeingNull() {
        if (this.mLynxView != null) goto L6;
        this.mLynxView = buildFakeLynxView();
        return;
    }

    private int createReplayGeneration() {
        return this.mReplayGeneration.incrementAndGet();
    }

    private boolean enableJSRuntime() {
        JSONObject r0 = this.mThreadStrategyData;
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.has("enableJSRuntime") == false) goto L18;
    L13:
        e = move-exception;
        e.printStackTrace();
        return true;
    L8:
        if (JSONObjectProtectorUtils.getBoolean(this.mThreadStrategyData, "enableJSRuntime") == false) goto L19;
        if (this.mEnableAirStrictMode == true) goto L19;
        return true;
    L19:
        return false;
    L18:
        return true;
    }

    private String getDumpFilePath() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US);
        r0.setTimeZone(TimeZone.getTimeZone("UTC"));
        return new PolarisFileWrapper(this.mContext.getExternalFilesDir(null), "lynx-testbench-" + r0.format(new Date())).getPath();
    }

    private boolean hasScreenSizeInfo() {
        JSONObject r0 = this.mConfig;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.has("screenWidth") == false) goto L9;
        if (this.mConfig.has("screenHeight") == false) goto L9;
        return true;
    }

    private void invalidateReplayGeneration() {
        this.mReplayGeneration.incrementAndGet();
    }

    private boolean needSetContainerSize() {
        JSONObject r0 = this.mConfig;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.has("setContainerSize") == false) goto L7;
        return true;
    }

    private String replayTimeEnvJScript() {
        InputStream r3 = this.mContext.getAssets().open("lynx_recorder.js");     // Catch: IOException -> L37
        byte[] r4 = new byte[r3.available()];     // Catch: IOException -> L37
        r3.read(r4);     // Catch: IOException -> L37
        String r5 = new String(r4).replace("###LYNX_RECORDER_REPLAY_TIME###", String.valueOf(this.mStartTime));     // Catch: IOException -> L37
        PolarisFileWrapper r6 = new PolarisFileWrapper(this.mContext.getFilesDir(), "lynx_recorder.js");     // Catch: IOException -> L37
        if (r6.exists() == false) goto L9;
        if (r6.delete() == true) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        if (r6.createNewFile() == false) goto L36;
        PolarisFileOutputStreamWrapper r0 = null;
        PolarisFileOutputStreamWrapper r7 = new PolarisFileOutputStreamWrapper(r6);     // Catch: Throwable -> L21 IOException -> L22
        r7.write(r5.getBytes());     // Catch: Throwable -> L18 IOException -> L19
        String r1 = "file://" + r6.getPath();     // Catch: Throwable -> L18 IOException -> L19
        r7.close();     // Catch: IOException -> L15
    L17:
        return r1;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: IOException -> L37
    L19:
        IOException e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r7 != null) goto L42;
    L30:
        return NameKeys.UnloadStrategy_No_Strategy;
    L42:
        r7.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: IOException -> L37
    L18:
        r0 = r7;
        goto L31
    L22:
        e = move-exception;
        r7 = null;
        e = e;
    L31:
        if (r0 == null) goto L36;
        r0.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: IOException -> L37
    L36:
        return NameKeys.UnloadStrategy_No_Strategy;
    L37:
        e = move-exception;
        e.printStackTrace();
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public String[] getTestBenchPreloadScripts() {
        return (String[]) this.mPreloadScripts.toArray(new String[0]);
    }

    public void load() {
        if (this.mCreateWhenReload == false) goto L6;
        create();
        return;
    L6:
        if (this.mLoadTemplateURL == null) goto L15;
        TemplateData r0 = this.mLoadTemplateData;
        if (r0 == null) goto L16;
        this.mLoadTemplateData = r0.deepClone();
        r0.recycle();
        if (this.mSourceURL == null) goto L12;
        LynxEnv.inst().getTemplateProvider().loadTemplate(this.mSourceURL, new AnonymousClass7(this));
        return;
    L12:
        this.mLynxView.renderTemplateWithBaseUrl(this.templateSource, this.mLoadTemplateData, this.mLoadTemplateURL);
        return;
    L16:
        return;
    }

    public void onPause() {
        this.mLynxView.onEnterBackground();
    }

    public void onResume() {
        this.mLynxView.onEnterForeground();
    }

    public void onTestBenchComplete() {
        Iterator<LynxRecorderActionCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onTestBenchComplete();
        goto L4
    }

    public void reloadAction() {
        long r0 = 1000;
        int r2 = 0;
    L4:
        if (r2 >= this.mReloadList.size()) goto L9;
        ((ReloadAction) ListProtector.get(this.mReloadList, r2)).run();
        if (r2 != (this.mReloadList.size() - 1)) goto L8;
        r0 = ((ReloadAction) ListProtector.get(this.mReloadList, r2)).getDelayTime() + ((long) this.mDelayEndInterval);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        Message r3 = Message.obtain();
        r3.what = 10;
        if (r0 < AutoEndConversationTime.AFTER_60_SECONDS) goto L12;
        r0 = 5000;
    L12:
        this.mHandler.sendMessageDelayed(r3, r0);
    }

    private LynxView buildFakeLynxView() {
        if (this.mLynxView != null) goto L26;
        LynxViewBuilder r1 = new LynxViewBuilder();     // Catch: JSONException -> L23
        r1.setEnableJSRuntime(enableJSRuntime());     // Catch: JSONException -> L23
        r1.setEnableAirStrictMode(enableAir());     // Catch: JSONException -> L23
        r1.setPresetMeasuredSpec(0, 0);     // Catch: JSONException -> L23
        addExtraComponent(r1);     // Catch: JSONException -> L23
        r1.registerModule("LynxRecorderReplayDataModule", LynxRecorderReplayDataModule.class, this.mDataProvider);     // Catch: JSONException -> L23
        r1.registerModule("LynxRecorderOpenUrlModule", LynxRecorderOpenUrlModule.class);     // Catch: JSONException -> L23
        if (BuildConfig.enable_frozen_mode.booleanValue() == false) goto L7;
        r1.setThreadStrategyForRendering(ThreadStrategyForRendering.ALL_ON_UI);     // Catch: JSONException -> L23
    L8:
        LynxRecorderSourceProvider r2 = new LynxRecorderSourceProvider();     // Catch: JSONException -> L23
        JSONObject r3 = this.mConfig;     // Catch: JSONException -> L23
        if (r3 != null) goto L11;
    L13:
        r1.setResourceProvider("EXTERNAL_JS_SOURCE", r2);     // Catch: JSONException -> L23
        r1.setDynamicComponentFetcher(this.mDynamicFetcher);     // Catch: JSONException -> L23
        float r0 = this.mRawFontScale;     // Catch: JSONException -> L23
        if (r0 == (-1.0f)) goto L17;
        r1.setFontScale(r0);     // Catch: JSONException -> L23
    L17:
        if (this.mForbidTimeFreeze == true) goto L19;
        this.mPreloadScripts.add(replayTimeEnvJScript());     // Catch: JSONException -> L23
    L19:
        onLynxViewWillBuild(this, r1);     // Catch: JSONException -> L23
        LynxView r4 = r1.build(this.mContext);     // Catch: JSONException -> L23
        this.mLynxView = r4;     // Catch: JSONException -> L23
        r4.getLynxContext().setLynxView(this.mLynxView);     // Catch: JSONException -> L23
        TestBenchLynxViewClient r5 = new TestBenchLynxViewClient(this, null);     // Catch: JSONException -> L23
        this.mViewClient = r5;     // Catch: JSONException -> L23
        this.mLynxView.addLynxViewClient(r5);     // Catch: JSONException -> L23
        this.mThreadStrategyData = null;     // Catch: JSONException -> L23
        onLynxViewDidBuild(this.mLynxView, this.mIntent, this.mContext, this.mViewGroup);     // Catch: JSONException -> L23
        if (this.mLynxView.getBaseInspectorOwner() == null) goto L26;
        this.mLynxView.getBaseInspectorController().setDebugInfoInterceptor(this.mLynxDebugInfoRecorderDelegate);     // Catch: JSONException -> L23
        goto L26
    L11:
        if (r3.has("urlRedirect") == false) goto L13;
        r2.setUrlRedirect(JSONObjectProtectorUtils.getJSONObject(this.mConfig, "urlRedirect"));     // Catch: JSONException -> L23
        goto L13
    L7:
        r1.setThreadStrategyForRendering(getThreadStrategy(this.mThreadMode, 0));     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L26:
        return this.mLynxView;
    }

    private void create() {
        destroy();
        final int r0 = createReplayGeneration();
        LynxView r1 = this.mLynxView;
        if (r1 == null) goto L5;
        this.mViewGroup.removeView(r1);
        this.mLynxView = null;
    L5:
        this.mStateView.setReplayState(0);
        this.mViewGroup.addView(this.mStateView);
        if (this.mSourceURL == null) goto L8;
        LynxEnv.inst().getTemplateProvider().loadTemplate(this.mSourceURL, new AnonymousClass2(this, r0));
        return;
    L8:
        downloadRecordedFile(r0);
    }

    private boolean enableAir() {
        return !enableJSRuntime();
    }

    private void endTestbench() {
        final String r0 = getDumpFilePath();
        Runnable r1 = new AnonymousClass6(this, r0);
        this.mHandler.postDelayed(r1, 1000);
    }

    public void destroy() {
        invalidateReplayGeneration();
        TemplateData r0 = this.mLoadTemplateData;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        TemplateData r1 = this.mGlobalPropCacheCloned;
        if (r1 == null) goto L8;
        r1.recycle();
    L8:
        TemplateData r2 = this.mGlobalProps;
        if (r2 == null) goto L11;
        r2.recycle();
    L11:
        LynxView r3 = this.mLynxView;
        if (r3 == null) goto L14;
        r3.destroy();
    L14:
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public JSONArray getComponentList() {
        return this.mComponentList;
    }

    public Context getContext() {
        return this.mContext;
    }

    public LynxGroup getLynxGroup() {
        return this.mLynxGroup;
    }

    public String getRawUrl() {
        return this.mRawUrl;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderActionManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ Handler access$000(LynxRecorderActionManager r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ void access$1300(LynxRecorderActionManager r0) {
        r0.endTestbench();
    }

    public static /* synthetic */ LynxView access$2300(LynxRecorderActionManager r0) {
        return r0.mLynxView;
    }

    public static /* synthetic */ TemplateData access$2400(LynxRecorderActionManager r0) {
        return r0.mLoadTemplateData;
    }

    public static /* synthetic */ String access$2500(LynxRecorderActionManager r0) {
        return r0.mLoadTemplateURL;
    }

    public static /* synthetic */ LynxRecorderReplayStateView access$400(LynxRecorderActionManager r0) {
        return r0.mStateView;
    }

    public static /* synthetic */ ParsedRecordData access$500(byte[] r0) throws IOException, JSONException {
        return parseRecordedBody(r0);
    }

    private void addExtraComponent(LynxViewBuilder r13) {
        if (this.mComponentList != null) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        r0.addAll(new com.lynx.tasm.behavior.d().create());
        if (LynxEnv.inst().getBehaviorBundle() == null) goto L8;
        r0.addAll(LynxEnv.inst().getBehaviorBundle().create());
    L8:
        HashMap r1 = new HashMap();
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        com.lynx.tasm.behavior.a r3 = (com.lynx.tasm.behavior.a) r2.next();
        r1.put(r3.getName(), r3);
        goto L10
    L12:
        int r4 = 0;
    L14:
        if (r4 >= this.mComponentList.length()) goto L30;
        JSONObject r5 = JSONArrayProtectorUtils.getJSONObject(this.mComponentList, r4);     // Catch: JSONException -> L27
        final String r7 = JSONObjectProtectorUtils.getString(r5, "Name");     // Catch: JSONException -> L27
        int r6 = JSONObjectProtectorUtils.getInt(r5, "Type");     // Catch: JSONException -> L27
        if (r1.containsKey(r7) == false) goto L19;
    L29:
        r4 = r4 + 1;
        goto L14
    L19:
        if ((r6 & 2) == 0) goto L22;
        r13.addBehavior(new AnonymousClass4(this, r7));     // Catch: JSONException -> L27
        goto L29
    L22:
        if ((r6 & 8) == 0) goto L24;
        final boolean r8 = true;
    L25:
        final boolean r9 = false;
        final boolean r10 = false;
        final boolean r11 = true;
        r13.addBehavior(new AnonymousClass5(this, r7, r8, r9, r10, r11));     // Catch: JSONException -> L27
        goto L29
    L24:
        r8 = false;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    private void applyParsedRecordData(ParsedRecordData r5) throws JSONException {
        mainThreadChecker("applyParsedRecordData");
        JSONObject r0 = r5.config;
        if (r0 == null) goto L10;
        this.mConfig = r0;
        JSONArray r1 = r5.jsbIgnoredInfo;
        if (r1 == null) goto L7;
        this.mDataProvider.jsbIgnoredInfo = r1;
    L7:
        JSONObject r2 = r5.jsbSettings;
        if (r2 == null) goto L10;
        this.mDataProvider.jsbSettings = r2;
    L10:
        JSONArray r3 = r5.debugInfo;
        if (r3 == null) goto L16;
        r3.length();
        int r4 = 0;
    L14:
        if (r4 >= r5.debugInfo.length()) goto L16;
        JSONObject r6 = JSONArrayProtectorUtils.getJSONObject(r5.debugInfo, r4);
        String r7 = JSONObjectProtectorUtils.getString(r6, LynxEventReporter.PROP_NAME_URL);
        String r8 = JSONObjectProtectorUtils.getString(r6, LynxAccessibilityModule.MSG_CONTENT);
        this.mLynxDebugInfoRecorderDelegate.setDebugInfo(r7, r8);
        r4 = r4 + 1;
    L16:
        JSONObject r9 = r5.sharedData;
        if (r9 == null) goto L19;
        this.mDataProvider.sharedData = r9;
    L19:
        JSONArray r10 = r5.functionCall;
        if (r10 == null) goto L22;
        this.mDataProvider.functionCall = r10;
    L22:
        JSONObject r11 = r5.callbackData;
        if (r11 == null) goto L25;
        this.mDataProvider.callbackData = r11;
    L25:
        JSONArray r12 = r5.componentList;
        if (r12 == null) goto L28;
        mockComponent(r12);
    L28:
        JSONArray r13 = r5.actionList;
        if (r13 != null) goto L31;
        return;
    L31:
        if (checkFile(r13) == false) goto L33;
        this.mDynamicFetcher.parse(r5.actionList);
        this.mStateView.setReplayState(2);
        handleActionList(r5.actionList);
        return;
    L33:
        this.mStateView.setReplayState(4);
    }

    private TemplateData buildTemplateData(JSONObject r4) {
        TemplateData r0 = TemplateData.fromString(r4.toString());
        String r1 = JSONObjectProtectorUtils.getString(r4, "preprocessorName");     // Catch: JSONException -> L9
        boolean r5 = JSONObjectProtectorUtils.getBoolean(r4, "readOnly");     // Catch: JSONException -> L9
        if (r1.isEmpty() == true) goto L6;
        r0.markState(r1);     // Catch: JSONException -> L9
    L6:
        if (r5 == false) goto L11;
        r0.markReadOnly();     // Catch: JSONException -> L9
    L11:
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private boolean checkFile(JSONArray r6) {
        int r1 = 0;
    L4:
        if (r1 >= r6.length()) goto L15;
        JSONObject r2 = JSONArrayProtectorUtils.getJSONObject(r6, r1);     // Catch: JSONException -> L12
        String r3 = JSONObjectProtectorUtils.getString(r2, "Function Name");     // Catch: JSONException -> L12
        if (r3.equals("loadTemplate") == false) goto L8;
    L9:
        this.mTemplateBundleParams = JSONObjectProtectorUtils.getJSONObject(r2, "Params");     // Catch: JSONException -> L12
        return true;
    L8:
        if (r3.equals("loadTemplateBundle") == true) goto L9;
    L14:
        r1 = r1 + 1;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L15:
        return false;
    }

    private void downloadRecordedFile(final int r4) {
        if (this.mUrl.startsWith("asset:///") == false) goto L5;
        final String r0 = this.mUrl.replace("asset:///", NameKeys.UnloadStrategy_No_Strategy);
        this.mStateView.setReplayState(1);
        ThreadUtils.getThreadPool().execute(new d(this, r4, r0));
        return;
    L5:
        new LynxRecorderTemplateProvider().loadTemplate(this.mUrl, new InnerCallback(this, r4));
    }

    private int[] getContainerSize(int[] r6) {
        JSONObject r0 = this.mConfig.optJSONObject("setContainerSize");
        if (r0 != null) goto L6;
        return r6;
    L6:
        return new int[]{r0.optInt("width", r6[0]), r0.optInt("height", r6[1])};
    }

    private int[] getMeasureSpec(JSONObject r10) {
        int r0 = JSONObjectProtectorUtils.getInt(r10, "layoutWidthMode");     // Catch: Exception -> L14
        int r1 = JSONObjectProtectorUtils.getInt(r10, "layoutHeightMode");     // Catch: Exception -> L14
        int r2 = JSONObjectProtectorUtils.getInt(r10, "preferredLayoutHeight");     // Catch: Exception -> L14
        int r11 = JSONObjectProtectorUtils.getInt(r10, "preferredLayoutWidth");     // Catch: Exception -> L14
        if (hasScreenSizeInfo() == false) goto L8;
        int r3 = JSONObjectProtectorUtils.getInt(this.mConfig, "screenWidth");     // Catch: Exception -> L14
        int r4 = JSONObjectProtectorUtils.getInt(this.mConfig, "screenHeight");     // Catch: Exception -> L14
        if (r3 == 0) goto L8;
        if (r4 == 0) goto L8;
        r2 = (int) Math.ceil((((double) r2) / ((double) r4)) * ((double) this.mScreenHeight));     // Catch: Exception -> L14
        r11 = (int) Math.ceil((((double) r11) / ((double) r3)) * ((double) this.mScreenWidth));     // Catch: Exception -> L14
    L8:
        int r5 = View.MeasureSpec.makeMeasureSpec(r2, getMeasureMode(r1));     // Catch: Exception -> L14
        int r6 = View.MeasureSpec.makeMeasureSpec(r11, getMeasureMode(r0));     // Catch: Exception -> L14
        int r12 = getLynxViewLayoutParams(getMeasureMode(r0), r11);     // Catch: Exception -> L14
        int r7 = getLynxViewLayoutParams(getMeasureMode(r1), r2);     // Catch: Exception -> L14
        if (this.mLandScape == false) goto L13;
        return new int[]{r5, r6, r7, r12};
    L13:
        return new int[]{r6, r5, r12, r7};
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void handleActionList(JSONArray r15) {
        if (this.mPreDecode == false) goto L5;
        preDecodeTemplate(this.mTemplateBundleParams);
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r15.length()) goto L38;
        JSONObject r2 = JSONArrayProtectorUtils.getJSONObject(r15, r1);     // Catch: JSONException -> L35
        String r3 = JSONObjectProtectorUtils.getString(r2, "Function Name");     // Catch: JSONException -> L35
        if (r3.equals("loadTemplate") == true) goto L11;
    L13:
        long r4 = JSONObjectProtectorUtils.getLong(r2, "Record Time") * 1000;     // Catch: JSONException -> L35
        if (r2.has("RecordMillisecond") == false) goto L16;
        r4 = JSONObjectProtectorUtils.getLong(r2, "RecordMillisecond");     // Catch: JSONException -> L35
    L16:
        JSONObject r9 = JSONObjectProtectorUtils.getJSONObject(r2, "Params");     // Catch: JSONException -> L35
        HashMap<String, Integer> r5 = mCanMockFuncMap;     // Catch: JSONException -> L35
        if (r5.containsKey(r3) == true) goto L20;
    L37:
        r1 = r1 + 1;
        goto L7
    L20:
        if (r3.equals("sendEventAndroid") == false) goto L25;
        if (this.mReplayGesture == false) goto L37;
    L25:
        if (this.mStartTime != 0) goto L27;
        this.mStartTime = r4;     // Catch: JSONException -> L35
    L27:
        long r6 = r4 - this.mStartTime;     // Catch: JSONException -> L35
        if (mReloadFuncSet.contains(r3) == false) goto L30;
        this.mReloadList.add(new ReloadAction(this, r9, r5.get(r3).intValue(), r6));     // Catch: JSONException -> L35
    L32:
        if (r1 != (r15.length() - 1)) goto L37;
        Message r7 = Message.obtain();     // Catch: JSONException -> L35
        r7.what = ON_TESTBENCH_COMPLETE;     // Catch: JSONException -> L35
        this.mHandler.sendMessageDelayed(r7, r6);     // Catch: JSONException -> L35
        goto L37
    L30:
        dispatchAction(r3, r9, r6);     // Catch: JSONException -> L35
        goto L32
    L11:
        if (this.mPreDecode == false) goto L13;
        r3 = "loadTemplateBundle";
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    }

    private void initialLynxView(JSONObject r9) {
        Boolean r1 = BuildConfig.enable_frozen_mode;
        if (r1.booleanValue() == false) goto L6;
        LynxEnv.inst().setCreateViewAsync(false);
    L6:
        if (r9.has("threadStrategy") == false) goto L10;
        this.mThreadStrategyData = r9;
        return;
    L10:
        if (this.mThreadStrategyData == null) goto L12;
    L50:
        int[] r10 = getMeasureSpec(r9);     // Catch: Exception -> L47
        LynxView r4 = this.mLynxView;     // Catch: Exception -> L47
        if (r4 != null) goto L33;
        LynxViewBuilder r5 = new LynxViewBuilder();     // Catch: Exception -> L47
        r5.setEnableJSRuntime(enableJSRuntime());     // Catch: Exception -> L47
        r5.setEnableAirStrictMode(enableAir());     // Catch: Exception -> L47
        r5.setPresetMeasuredSpec(r10[0], r10[1]);     // Catch: Exception -> L47
        addExtraComponent(r5);     // Catch: Exception -> L47
        r5.registerModule("LynxRecorderReplayDataModule", LynxRecorderReplayDataModule.class, this.mDataProvider);     // Catch: Exception -> L47
        r5.registerModule("LynxRecorderOpenUrlModule", LynxRecorderOpenUrlModule.class);     // Catch: Exception -> L47
        if (r1.booleanValue() == false) goto L19;
        r5.setThreadStrategyForRendering(ThreadStrategyForRendering.ALL_ON_UI);     // Catch: Exception -> L47
    L20:
        r5.setEmbeddedMode(this.mEmbeddedMode);     // Catch: Exception -> L47
        LynxRecorderSourceProvider r2 = new LynxRecorderSourceProvider();     // Catch: Exception -> L47
        JSONObject r3 = this.mConfig;     // Catch: Exception -> L47
        if (r3 != null) goto L23;
    L25:
        r5.setResourceProvider("EXTERNAL_JS_SOURCE", r2);     // Catch: Exception -> L47
        r5.setDynamicComponentFetcher(this.mDynamicFetcher);     // Catch: Exception -> L47
        float r0 = this.mRawFontScale;     // Catch: Exception -> L47
        if (r0 == (-1.0f)) goto L29;
        r5.setFontScale(r0);     // Catch: Exception -> L47
    L29:
        if (this.mForbidTimeFreeze == true) goto L31;
        this.mPreloadScripts.add(replayTimeEnvJScript());     // Catch: Exception -> L47
    L31:
        onLynxViewWillBuild(this, r5);     // Catch: Exception -> L47
        LynxView r6 = r5.build(this.mContext);     // Catch: Exception -> L47
        this.mLynxView = r6;     // Catch: Exception -> L47
        r6.getLynxContext().setLynxView(this.mLynxView);     // Catch: Exception -> L47
        TestBenchLynxViewClient r7 = new TestBenchLynxViewClient(this, null);     // Catch: Exception -> L47
        this.mViewClient = r7;     // Catch: Exception -> L47
        this.mLynxView.addLynxViewClient(r7);     // Catch: Exception -> L47
        this.mThreadStrategyData = null;     // Catch: Exception -> L47
        onLynxViewDidBuild(this.mLynxView, this.mIntent, this.mContext, this.mViewGroup);     // Catch: Exception -> L47
    L39:
        if (hasScreenSizeInfo() == false) goto L44;
        if (this.mEnableSizeOptimization == false) goto L44;
        updateViewLayoutParams(r10[2], r10[3]);     // Catch: Exception -> L47
    L44:
        if (this.mLynxView.getBaseInspectorOwner() == null) goto L52;
        this.mLynxView.getBaseInspectorController().setDebugInfoInterceptor(this.mLynxDebugInfoRecorderDelegate);     // Catch: Exception -> L47
        return;
    L52:
        return;
    L23:
        if (r3.has("urlRedirect") == false) goto L25;
        r2.setUrlRedirect(JSONObjectProtectorUtils.getJSONObject(this.mConfig, "urlRedirect"));     // Catch: Exception -> L47
        goto L25
    L19:
        r5.setThreadStrategyForRendering(getThreadStrategy(this.mThreadMode, JSONObjectProtectorUtils.getInt(this.mThreadStrategyData, "threadStrategy")));     // Catch: Exception -> L47
        goto L20
    L33:
        if (this.mDisableUpdateViewport == true) goto L36;
        r4.updateViewport(r10[0], r10[1]);     // Catch: Exception -> L47
    L36:
        if (needSetContainerSize() == false) goto L39;
        int[] r8 = getContainerSize(new int[]{View.MeasureSpec.getSize(r10[0]), View.MeasureSpec.getSize(r10[1])});     // Catch: Exception -> L47
        setViewLayoutParams(this.mViewGroup, r8[0], r8[1]);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        if (this.mLynxView != null) goto L50;
    }

    private static boolean isJsonRecordedStream(RecordedInputStreamProvider r4) throws IOException {
        InputStream r5 = r4.open();
        PushbackInputStream r0 = new PushbackInputStream(new BufferedInputStream(r5), 3);     // Catch: Throwable -> L29
        skipUtf8Bom(r0);     // Catch: Throwable -> L21
    L5:
        int r1 = r0.read();     // Catch: Throwable -> L21
        boolean r3 = true;
        if (r1 == (-1)) goto L17;
        if (Character.isWhitespace((char) r1) == true) goto L5;
        if (r1 == 123) goto L13;
        r3 = false;
    L13:
        r0.close();     // Catch: Throwable -> L29
        if (r5 == null) goto L16;
        r5.close();
    L16:
        return r3;
    L17:
        r0.close();     // Catch: Throwable -> L29
        if (r5 == null) goto L20;
        r5.close();
    L20:
        return true;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r5 != null) goto L47;
    L37:
        throw th;
    L47:
        r5.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.addSuppressed(th);
        goto L37
    }

    private boolean isReplayGenerationActive(int r2) {
        if (r2 != this.mReplayGeneration.get()) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ InputStream lambda$null$3(String r2) throws IOException {
        return this.mContext.getAssets().open(r2);
    }

    private static /* synthetic */ InputStream lambda$parseRecordedBody$0(byte[] r1) throws IOException {
        return new ByteArrayInputStream(r1);
    }

    private void loadTemplate(JSONObject r7) {
        avoidLynxViewBeingNull();
        String r1 = r7.optString(LynxEventReporter.PROP_NAME_URL);     // Catch: JSONException -> L38
        if (r1.isEmpty() == false) goto L6;
        r1 = LynxRecorderEnv.getInstance().lynxRecorderUrlPrefix;     // Catch: JSONException -> L38
    L6:
        JSONObject r2 = this.mGlobalPropsCache;     // Catch: JSONException -> L38
        if (r2 == null) goto L9;
        TemplateData r3 = TemplateData.fromString(r2.toString());     // Catch: JSONException -> L38
        this.mGlobalPropCacheCloned = r3;     // Catch: JSONException -> L38
        this.mLynxView.updateMetaData(new o1(null, r3));     // Catch: JSONException -> L38
    L9:
        byte[] r4 = this.mPreloadedTemplateSource;     // Catch: JSONException -> L38
        if (r4 == null) goto L12;
        this.templateSource = r4;     // Catch: JSONException -> L38
    L13:
        TemplateData r5 = buildTemplateData(JSONObjectProtectorUtils.getJSONObject(r7, "templateData"));     // Catch: JSONException -> L38
        this.mLoadTemplateURL = r1;     // Catch: JSONException -> L38
        LynxRecorderReplayStateView r6 = this.mStateView;     // Catch: JSONException -> L38
        if (r6 == null) goto L19;
        ViewGroup r8 = this.mViewGroup;     // Catch: JSONException -> L38
        if (r8 == null) goto L19;
        r8.removeView(r6);     // Catch: JSONException -> L38
    L19:
        if (r7.has("isCSR") == false) goto L21;
        boolean r9 = JSONObjectProtectorUtils.getBoolean(r7, "isCSR");     // Catch: JSONException -> L38
    L22:
        if (r9 == false) goto L36;
        this.mLoadTemplateData = r5.deepClone();     // Catch: JSONException -> L38
        r5.recycle();     // Catch: JSONException -> L38
        if (this.mSSRLoaded == true) goto L35;
        s0.a r10 = new s0.a();     // Catch: JSONException -> L38
        r10.b = this.templateSource;     // Catch: JSONException -> L38
        r10.a = r1;     // Catch: JSONException -> L38
        r10.d = this.mLoadTemplateData;     // Catch: JSONException -> L38
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L38
        if (this.mDisableOptPushStyleToBundle == false) goto L29;
        r0.put("enableOptPushStyleToBundle", false);     // Catch: JSONException -> L38
    L29:
        if (this.mEnableNativeScheduleCreateViewAsync == false) goto L32;
        r0.put("enableNativeScheduleCreateViewAsync", true);     // Catch: JSONException -> L38
    L32:
        if (this.mEnableUnifyFixedBehavior == false) goto L34;
        r0.put("enableUnifyFixedBehavior", true);     // Catch: JSONException -> L38
    L34:
        HashMap r11 = new HashMap();     // Catch: JSONException -> L38
        r11.put(LynxViewBuilderProperty.PLATFORM_CONFIG.getKey(), r0.toString());     // Catch: JSONException -> L38
        r10.i = r11;     // Catch: JSONException -> L38
        this.mLynxView.loadTemplate(r10.b());     // Catch: JSONException -> L38
        return;
    L35:
        s0.a r12 = new s0.a();     // Catch: JSONException -> L38
        r12.f = LynxLoadMode.HYDRATE_SSR;     // Catch: JSONException -> L38
        r12.a = r1;     // Catch: JSONException -> L38
        r12.b = this.templateSource;     // Catch: JSONException -> L38
        r12.d = this.mLoadTemplateData;     // Catch: JSONException -> L38
        this.mLynxView.loadTemplate(r12.b());     // Catch: JSONException -> L38
        return;
    L36:
        Map<Object, Object> r13 = r5.toMap();     // Catch: JSONException -> L38
        s0.a r14 = new s0.a();     // Catch: JSONException -> L38
        r14.f = LynxLoadMode.RENDER_SSR;     // Catch: JSONException -> L38
        r14.a = r1;     // Catch: JSONException -> L38
        r14.b = this.templateSource;     // Catch: JSONException -> L38
        r14.d = TemplateData.fromMap(r13);     // Catch: JSONException -> L38
        this.mLynxView.loadTemplate(r14.b());     // Catch: JSONException -> L38
        this.mSSRLoaded = true;     // Catch: JSONException -> L38
        return;
    L21:
        r9 = true;
        goto L22
    L12:
        this.templateSource = Base64.decode(JSONObjectProtectorUtils.getString(r7, "source"), 0);     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    }

    private void loadTemplateBundle(JSONObject r6) {
        avoidLynxViewBeingNull();
        String r0 = r6.optString(LynxEventReporter.PROP_NAME_URL);     // Catch: JSONException -> L32
        if (r0.isEmpty() == false) goto L6;
        r0 = LynxRecorderEnv.getInstance().lynxRecorderUrlPrefix;     // Catch: JSONException -> L32
    L6:
        JSONObject r1 = this.mGlobalPropsCache;     // Catch: JSONException -> L32
        if (r1 == null) goto L9;
        TemplateData r2 = TemplateData.fromString(r1.toString());     // Catch: JSONException -> L32
        this.mGlobalPropCacheCloned = r2;     // Catch: JSONException -> L32
        this.mLynxView.updateMetaData(new o1(null, r2));     // Catch: JSONException -> L32
    L9:
        TemplateData r3 = buildTemplateData(JSONObjectProtectorUtils.getJSONObject(r6, "templateData"));     // Catch: JSONException -> L32
        this.mLoadTemplateURL = r0;     // Catch: JSONException -> L32
        LynxRecorderReplayStateView r4 = this.mStateView;     // Catch: JSONException -> L32
        if (r4 == null) goto L14;
        ViewGroup r5 = this.mViewGroup;     // Catch: JSONException -> L32
        if (r5 == null) goto L14;
        r5.removeView(r4);     // Catch: JSONException -> L32
    L14:
        this.mLoadTemplateData = r3.deepClone();     // Catch: JSONException -> L32
        r3.recycle();     // Catch: JSONException -> L32
        if (this.mTemplateBundle != null) goto L30;
        byte[] r7 = this.mPreloadedTemplateSource;     // Catch: JSONException -> L32
        if (r7 == null) goto L19;
        this.templateSource = r7;     // Catch: JSONException -> L32
    L20:
        s0.a r8 = new s0.a();     // Catch: JSONException -> L32
        r8.c = TemplateBundle.c(this.templateSource, this.mTemplateBundleOptions);     // Catch: JSONException -> L32
        r8.a = r0;     // Catch: JSONException -> L32
        r8.d = this.mLoadTemplateData;     // Catch: JSONException -> L32
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L32
        if (this.mDisableOptPushStyleToBundle == false) goto L24;
        r9.put("enableOptPushStyleToBundle", false);     // Catch: JSONException -> L32
    L24:
        if (this.mEnableNativeScheduleCreateViewAsync == false) goto L27;
        r9.put("enableNativeScheduleCreateViewAsync", true);     // Catch: JSONException -> L32
    L27:
        if (this.mEnableUnifyFixedBehavior == false) goto L29;
        r9.put("enableUnifyFixedBehavior", true);     // Catch: JSONException -> L32
    L29:
        HashMap r10 = new HashMap();     // Catch: JSONException -> L32
        r10.put(LynxViewBuilderProperty.PLATFORM_CONFIG.getKey(), r9.toString());     // Catch: JSONException -> L32
        r8.i = r10;     // Catch: JSONException -> L32
        this.mLynxView.loadTemplate(r8.b());     // Catch: JSONException -> L32
        return;
    L19:
        this.templateSource = Base64.decode(JSONObjectProtectorUtils.getString(r6, "source"), 0);     // Catch: JSONException -> L32
        goto L20
    L30:
        this.mLynxView.renderTemplateBundle(this.mTemplateBundle, this.mLoadTemplateData, r0);     // Catch: JSONException -> L32
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
    }

    private void mainThreadChecker(String r4) {
        if (ThreadMethodProxy.currentThread().equals(ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L6;
        return;
    L6:
        throw new IllegalThreadStateException("Callback " + r4 + "must be fired on main thread.");
    }

    private void mockComponent(JSONArray r1) {
        this.mComponentList = r1;
    }

    private static InputStream openBase64DecodedPayloadStream(RecordedInputStreamProvider r2) throws IOException {
        PushbackInputStream r0 = new PushbackInputStream(new BufferedInputStream(r2.open()), 3);
        skipUtf8Bom(r0);
        return new Base64InputStream(r0, 0);
    }

    private static ParsedRecordData parseRecordedBody(final byte[] r1) throws IOException, JSONException {
        return parseRecordedStream(new c(r1));
    }

    private static ParsedRecordData parseRecordedJsonStream(InputStream r6) throws IOException, JSONException {
        InputStreamReader r0 = new InputStreamReader(r6, StandardCharsets.UTF_8);     // Catch: Throwable -> L55
        JsonReader r1 = new JsonReader(r0);     // Catch: Throwable -> L47
        r1.setLenient(true);     // Catch: Throwable -> L47
        ParsedRecordData r3 = new ParsedRecordData(null);     // Catch: Throwable -> L47
        r1.beginObject();     // Catch: Throwable -> L47
    L5:
        if (r1.hasNext() == false) goto L42;
        String r4 = r1.nextName();     // Catch: Throwable -> L47
        switch(r4.hashCode()) {
            case -1102729144: goto L28;
            case -107576219: goto L25;
            case 93784731: goto L22;
            case 208679375: goto L19;
            case 235228213: goto L16;
            case 308959777: goto L13;
            case 2024042338: goto L10;
            default: goto L30;
        };     // Catch: Throwable -> L47
    L30:
        byte r5 = -1;
    L31:
        switch(r5) {
            case 0: goto L39;
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            default: goto L32;
        };     // Catch: Throwable -> L47
    L33:
        r3.actionList = readJsonArrayOrNull(r1, r4);     // Catch: Throwable -> L47
        goto L5
    L34:
        r3.componentList = readJsonArrayOrNull(r1, r4);     // Catch: Throwable -> L47
        goto L5
    L35:
        r3.callbackData = readJsonObjectOrNull(r1, r4);     // Catch: Throwable -> L47
        goto L5
    L36:
        r3.functionCall = readJsonArrayOrNull(r1, r4);     // Catch: Throwable -> L47
        goto L5
    L37:
        r3.sharedData = readJsonObjectOrNull(r1, r4);     // Catch: Throwable -> L47
        goto L5
    L38:
        r3.debugInfo = readJsonArrayOrNull(r1, r4);     // Catch: Throwable -> L47
        goto L5
    L39:
        JSONObject r7 = readConfigObjectOrNull(r1);     // Catch: Throwable -> L47
        r3.config = r7;     // Catch: Throwable -> L47
        if (r7 == null) goto L5;
        r3.jsbIgnoredInfo = r7.optJSONArray("jsbIgnoredInfo");     // Catch: Throwable -> L47
        r3.jsbSettings = r3.config.optJSONObject("jsbSettings");     // Catch: Throwable -> L47
        goto L5
    L32:
        r1.skipValue();     // Catch: Throwable -> L47
        goto L5
    L10:
        if (r4.equals("Config") == false) goto L30;
        r5 = 0;
        goto L31
    L13:
        if (r4.equals("Component List") == false) goto L30;
        r5 = 5;
        goto L31
    L16:
        if (r4.equals("Invoked Method Data") == false) goto L30;
        r5 = 3;
        goto L31
    L19:
        if (r4.equals("SharedData") == false) goto L30;
        r5 = 2;
        goto L31
    L22:
        if (r4.equals("Debug Info") == false) goto L30;
        r5 = 1;
        goto L31
    L25:
        if (r4.equals("Callback") == false) goto L30;
        r5 = 4;
        goto L31
    L28:
        if (r4.equals("Action List") == false) goto L30;
        r5 = 6;
        goto L31
    L42:
        r1.endObject();     // Catch: Throwable -> L47
        r0.close();     // Catch: Throwable -> L55
        if (r6 == null) goto L46;
        r6.close();
    L46:
        return r3;
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L52
    L54:
        throw th;     // Catch: Throwable -> L55
    L52:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        if (r6 != null) goto L64;
    L63:
        throw th;
    L64:
        r6.close();     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        th.addSuppressed(th);
        goto L63
    }

    private static ParsedRecordData parseRecordedStream(RecordedInputStreamProvider r1) throws IOException, JSONException {
        if (isJsonRecordedStream(r1) == false) goto L23;
        return parseRecordedJsonStream(openRecordedPayloadStream(r1, false));
    L23:
        return parseRecordedJsonStream(openRecordedPayloadStream(r1, true));
    L13:
        e = move-exception;
        return parseRecordedJsonStream(openBase64DecodedPayloadStream(r1));
    L20:
        e = move-exception;
        e.addSuppressed(e);
        throw e;
    }

    private void preDecodeTemplate(JSONObject r2) {
        byte[] r0 = this.mPreloadedTemplateSource;     // Catch: JSONException -> L8
        if (r0 == null) goto L5;
        this.templateSource = r0;     // Catch: JSONException -> L8
    L6:
        this.mTemplateBundle = TemplateBundle.c(this.templateSource, this.mTemplateBundleOptions);     // Catch: JSONException -> L8
        return;
    L5:
        this.templateSource = Base64.decode(JSONObjectProtectorUtils.getString(r2, "source"), 0);     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    private void preprocessGlobalPropsArrayData(JSONArray r4) throws JSONException {
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L12;
        Object r1 = r4.get(r0);
        if ((r1 instanceof JSONObject) == false) goto L9;
        preprocessGlobalPropsDictData((JSONObject) r1);
    L11:
        r0 = r0 + 1;
        goto L4
    L9:
        if ((r1 instanceof JSONArray) == false) goto L11;
        preprocessGlobalPropsArrayData((JSONArray) r1);
        goto L11
    }

    private void preprocessGlobalPropsDictData(JSONObject r5) throws JSONException {
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L17;
        String r1 = r0.next();
        Object r2 = r5.get(r1);
        if ((r2 instanceof JSONObject) == true) goto L7;
        if ((r2 instanceof JSONArray) == true) goto L10;
        if (r1.equals("screenHeight") == true) goto L13;
        if (r1.equals("screenWidth") == false) goto L4;
        r5.put(r1, (int) Math.ceil(this.mScreenWidth / this.mDensity));
        goto L4
    L13:
        r5.put(r1, (int) Math.ceil(this.mScreenHeight / this.mDensity));
        goto L4
    L10:
        preprocessGlobalPropsArrayData((JSONArray) r2);
        goto L4
    L7:
        preprocessGlobalPropsDictData((JSONObject) r2);
        goto L4
    }

    private static JSONObject readConfigObjectOrNull(JsonReader r3) throws IOException, JSONException {
        JsonToken r0 = r3.peek();
        if (r0 != JsonToken.NULL) goto L7;
        r3.nextNull();
        return null;
    L7:
        if (r0 != JsonToken.STRING) goto L14;
        if ("null".equals(r3.nextString()) == false) goto L12;
        return null;
    L12:
        throw new JSONException("Expected object for key \"Config\"");
    L14:
        return readJsonObjectOrNull(r3, "Config");
    }

    private static Object readJsonValue(JsonReader r3) throws IOException, JSONException {
        JsonToken r0 = r3.peek();
        switch(AnonymousClass8.$SwitchMap$android$util$JsonToken[r0.ordinal()]) {
            case 1: goto L20;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        r3.nextNull();
        return JSONObject.NULL;
    L14:
        JSONArray r1 = new JSONArray();
        r3.beginArray();
    L16:
        if (r3.hasNext() == false) goto L18;
        r1.put(readJsonValue(r3));
        goto L16
    L18:
        r3.endArray();
        return r1;
    L20:
        JSONObject r2 = new JSONObject();
        r3.beginObject();
    L22:
        if (r3.hasNext() == false) goto L24;
        r2.put(r3.nextName(), readJsonValue(r3));
        goto L22
    L24:
        r3.endObject();
        return r2;
    L5:
        throw new IOException("Unsupported json token: " + r0);
    L9:
        return Boolean.valueOf(r3.nextBoolean());
    L11:
        return CastDoubleProtector.valueOf(r3.nextString());
    L13:
        return r3.nextString();
    }

    private void reloadTemplate(JSONObject r3) {
        String r0 = JSONObjectProtectorUtils.getJSONObject(r3, "value").toString();     // Catch: JSONException -> L4
        String r4 = JSONObjectProtectorUtils.getString(r3, "preprocessorName");     // Catch: JSONException -> L4
        TemplateData r1 = TemplateData.fromString(r0);     // Catch: JSONException -> L4
        r1.markState(r4);     // Catch: JSONException -> L4
        r1.markReadOnly();     // Catch: JSONException -> L4
        this.mLynxView.reloadTemplate(r1);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void sendEventAndroid(JSONObject r4) {
        JSONObject r0 = this.mConfig;
        if (r0 != null) goto L5;
    L15:
        LynxRecorderEventSend.sendEventAndroid(r4, this.mLynxView, 1.0f, 1.0f);
        return;
    L5:
        if (r0.has("screenWidth") == false) goto L15;
        if (this.mConfig.has("screenHeight") == false) goto L15;
        int r1 = JSONObjectProtectorUtils.getInt(this.mConfig, "screenWidth");     // Catch: JSONException -> L13
        int r2 = JSONObjectProtectorUtils.getInt(this.mConfig, "screenHeight");     // Catch: JSONException -> L13
        if (r1 == 0) goto L19;
        if (r2 == 0) goto L20;
        LynxRecorderEventSend.sendEventAndroid(r4, this.mLynxView, this.mScreenWidth / r1, this.mScreenHeight / r2);     // Catch: JSONException -> L13
        return;
    L20:
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    private void sendGlobalEvent(JSONObject r2) {
        LynxRecorderEventSend.sendGlobalEvent(r2, this.mLynxView);
    }

    private void setGlobalProps(JSONObject r4) {
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.mLynxView != null) goto L6;
        this.mGlobalPropsCache = JSONObjectProtectorUtils.getJSONObject(r4, "global_props");     // Catch: JSONException -> L12
        return;
    L6:
        this.mGlobalPropsCache = null;     // Catch: JSONException -> L12
        JSONObject r5 = JSONObjectProtectorUtils.getJSONObject(r4, "global_props");     // Catch: JSONException -> L12
        if (this.mEnableSizeOptimization == false) goto L9;
        preprocessGlobalPropsDictData(r5);     // Catch: JSONException -> L12
    L9:
        TemplateData r6 = TemplateData.fromString(r5.toString());     // Catch: JSONException -> L12
        this.mGlobalProps = r6;     // Catch: JSONException -> L12
        this.mLynxView.updateMetaData(new o1(null, r6));     // Catch: JSONException -> L12
    }

    private static void skipUtf8Bom(PushbackInputStream r5) throws IOException {
        int r0 = r5.read();
        if (r0 == 239) goto L7;
        if (r0 == (-1)) goto L18;
        r5.unread(r0);
        return;
    L18:
        return;
    L7:
        int r1 = r5.read();
        int r3 = r5.read();
        if (r1 == 187) goto L10;
    L12:
        if (r3 == (-1)) goto L14;
        r5.unread(r3);
    L14:
        if (r1 == (-1)) goto L16;
        r5.unread(r1);
    L16:
        r5.unread(r0);
        return;
    L10:
        if (r3 != 191) goto L12;
    }

    private void switchEngineFromUIThread(JSONObject r2) {
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.mLynxView != null) goto L6;
        return;
    L6:
        if (JSONObjectProtectorUtils.getBoolean(r2, LynxViewpagerItem.BIND_ON_ATTACH) == false) goto L8;
        this.mLynxView.attachEngineToUIThread();     // Catch: JSONException -> L10
    L13:
        return;
    L8:
        this.mLynxView.detachEngineFromUIThread();     // Catch: JSONException -> L10
        goto L13
    }

    private void updateDataPreData(JSONObject r5) {
        String r1 = JSONObjectProtectorUtils.getJSONObject(r5, "value").toString();     // Catch: JSONException -> L10
        String r2 = JSONObjectProtectorUtils.getString(r5, "preprocessorName");     // Catch: JSONException -> L10
        if (r5.has("updatePageOption") == true) goto L6;
    L8:
        this.mLynxView.updateData(r1, r2);     // Catch: JSONException -> L10
        return;
    L6:
        if (JSONObjectProtectorUtils.getBoolean(JSONObjectProtectorUtils.getJSONObject(r5, "updatePageOption"), "reset_page_data") == false) goto L8;
        TemplateData r6 = TemplateData.fromString(r1);     // Catch: JSONException -> L10
        this.mLynxView.resetData(r6);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    private void updateMetaData(JSONObject r5) {
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.mLynxView != null) goto L5;
        return;
    L5:
        JSONObject r0 = JSONObjectProtectorUtils.getJSONObject(r5, "templateData");     // Catch: JSONException -> L12
        JSONObject r6 = JSONObjectProtectorUtils.getJSONObject(r5, "global_props");     // Catch: JSONException -> L12
        String r1 = JSONObjectProtectorUtils.getString(r0, "preprocessorName");     // Catch: JSONException -> L12
        boolean r2 = JSONObjectProtectorUtils.getBoolean(r0, "readOnly");     // Catch: JSONException -> L12
        TemplateData r3 = TemplateData.fromString(JSONObjectProtectorUtils.getJSONObject(r0, "value").toString());     // Catch: JSONException -> L12
        if (r1.equals(NameKeys.UnloadStrategy_No_Strategy) == true) goto L8;
        r3.markState(r1);     // Catch: JSONException -> L12
    L8:
        if (r2 == false) goto L10;
        r3.markReadOnly();     // Catch: JSONException -> L12
    L10:
        TemplateData r7 = TemplateData.fromString(r6.toString());     // Catch: JSONException -> L12
        this.mLynxView.updateMetaData(new o1(r3, r7));     // Catch: JSONException -> L12
    }

    public void onExceptionOccurred(String r3) {
        this.mLynxView.getLynxContext().handleException(new Exception(r3));
    }

    public void onReplayFinish(int r3) {
        Iterator<LynxRecorderActionCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReplayFinish(r3);
        goto L4
    }

    public void registerCallback(LynxRecorderActionCallback r2) {
        this.mCallbacks.add(r2);
    }

    public void setLynxGroup(LynxGroup r1) {
        this.mLynxGroup = r1;
    }

    public void startWithUrl(String r8) {
        if (r8.startsWith(LynxRecorderEnv.getInstance().lynxRecorderUrlPrefix) == true) goto L6;
        this.mStateView.setReplayState(6);
        this.mViewGroup.addView(this.mStateView);
        return;
    L6:
        this.mRawUrl = r8;
        QueryMapUtils r0 = new QueryMapUtils();
        r0.parse(r8);
        this.mUrl = r0.getString(LynxEventReporter.PROP_NAME_URL);
        this.mSourceURL = r0.getString("source");
        if (this.mUrl != null) goto L9;
        return;
    L9:
        this.mReplayGesture = r0.getBoolean("gesture", false);
        this.mPreDecode = r0.getBoolean("enablePreDecode", false);
        this.mThreadMode = r0.getInt(LynxEventReporter.PROP_NAME_THREAD_MODE, -1);
        this.mDelayEndInterval = r0.getInt("delayEndInterval", 3500);
        this.mEnableAirStrictMode = r0.getBoolean("enableAirStrict", false);
        this.mLandScape = r0.getBoolean("landscape", false);
        this.mDisableUpdateViewport = r0.getBoolean("disableUpdateViewport", false);
        this.mCreateWhenReload = r0.getBoolean("createWhenReload", false);
        if (r0.getInt("disable_opt_push_style_to_bundle", 0) != 1) goto L12;
        boolean r9 = true;
    L13:
        this.mDisableOptPushStyleToBundle = r9;
        if (r0.getInt("enable_unify_fixed_behavior", 0) != 1) goto L16;
        boolean r10 = true;
    L17:
        this.mEnableUnifyFixedBehavior = r10;
        if (r0.getInt("enable_native_schedule_create_view_async", 0) != 1) goto L20;
        boolean r11 = true;
    L21:
        this.mEnableNativeScheduleCreateViewAsync = r11;
        this.mEmbeddedMode = r0.getInt("embedded_mode", 0);
        int[] r3 = {255, 255, 255, 255};
        String r4 = r0.getString("backgroundColor");
        if (r4 != null) goto L33;
    L31:
        int r12 = Color.argb(r3[3], r3[0], r3[1], r3[2]);
        this.mBackgroundColor = r12;
        this.mViewGroup.setBackgroundColor(r12);
        this.mEnableSizeOptimization = r0.getBoolean("enableSizeOptimization", false);
        this.mForbidTimeFreeze = r0.getBoolean("forbidTimeFreeze", false);
        create();
        return;
    L33:
        String[] r5 = r4.split("_");     // Catch: IllegalArgumentException -> L29
        int r6 = 0;
    L25:
        if (r6 >= r5.length) goto L31;
        if (r6 >= 4) goto L31;
        r3[r6] = CastIntegerProtector.parseInt(r5[r6]);     // Catch: IllegalArgumentException -> L29
        r6 = r6 + 1;
    L29:
        e = move-exception;
        e.toString();
        goto L31
    L20:
        r11 = false;
        goto L21
    L16:
        r10 = false;
        goto L17
    L12:
        r9 = false;
        goto L13
    }

    public void updateFontScale(JSONObject r5) {
        String r0 = r5.optString("type", "unknown");
        float r6 = (float) r5.optDouble("scale", -1.0d);
        if (r0.equals("updateFontScale") == false) goto L7;
        LynxView r1 = this.mLynxView;
        if (r1 == null) goto L7;
        r1.updateFontScale(r6);
        return;
    L7:
        this.mRawFontScale = r6;
    }

    public static /* synthetic */ void access$1000(LynxRecorderActionManager r0, JSONObject r1) {
        r0.setGlobalProps(r1);
    }

    public static /* synthetic */ void access$1100(LynxRecorderActionManager r0, JSONObject r1) {
        r0.loadTemplate(r1);
    }

    public static /* synthetic */ void access$1200(LynxRecorderActionManager r0, JSONObject r1) {
        r0.loadTemplateBundle(r1);
    }

    public static /* synthetic */ void access$1400(LynxRecorderActionManager r0, JSONObject r1) {
        r0.updateDataPreData(r1);
    }

    public static /* synthetic */ void access$1500(LynxRecorderActionManager r0, JSONObject r1) {
        r0.sendGlobalEvent(r1);
    }

    public static /* synthetic */ void access$1600(LynxRecorderActionManager r0, JSONObject r1) {
        r0.sendEventAndroid(r1);
    }

    public static /* synthetic */ void access$1700(LynxRecorderActionManager r0, JSONObject r1) {
        r0.reloadTemplate(r1);
    }

    public static /* synthetic */ void access$1800(LynxRecorderActionManager r0, JSONObject r1) {
        r0.updateMetaData(r1);
    }

    public static /* synthetic */ void access$1900(LynxRecorderActionManager r0, JSONObject r1) {
        r0.switchEngineFromUIThread(r1);
    }

    public static /* synthetic */ void access$200(LynxRecorderActionManager r0, String r1) {
        r0.mainThreadChecker(r1);
    }

    public static /* synthetic */ byte[] access$2002(LynxRecorderActionManager r0, byte[] r1) {
        r0.mPreloadedTemplateSource = r1;
        return r1;
    }

    public static /* synthetic */ void access$2100(LynxRecorderActionManager r0, int r1) {
        r0.downloadRecordedFile(r1);
    }

    public static /* synthetic */ boolean access$300(LynxRecorderActionManager r0, int r1) {
        return r0.isReplayGenerationActive(r1);
    }

    public static /* synthetic */ void access$900(LynxRecorderActionManager r0, JSONObject r1) {
        r0.initialLynxView(r1);
    }

    private ThreadStrategyForRendering getThreadStrategy(int r3, int r4) {
        ThreadStrategyForRendering r0 = ThreadStrategyForRendering.ALL_ON_UI;
        if (r3 >= r0.id()) goto L5;
    L7:
        r3 = r4;
    L9:
        if (r3 == 1) goto L20;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L16;
        return r0;
    L16:
        return ThreadStrategyForRendering.MULTI_THREADS;
    L18:
        return ThreadStrategyForRendering.PART_ON_LAYOUT;
    L20:
        return ThreadStrategyForRendering.MOST_ON_TASM;
    L5:
        if (r3 > ThreadStrategyForRendering.MULTI_THREADS.id()) goto L7;
        goto L7
    }

    private void handleParsedRecordData(final ParsedRecordData r2, final int r3) {
        UIThreadUtils.runOnUiThreadImmediately(new e(this, r3, r2));
    }

    private /* synthetic */ void lambda$downloadRecordedFile$4(final int r2, final String r3) {
        if (isReplayGenerationActive(r2) == true) goto L5;
        return;
    L5:
        RecordedInputStreamProvider r0 = new b(this, r3);
        InputStream r4 = r0.open();     // Catch: IOException -> L16
        if (r4 == null) goto L21;
        r4.close();     // Catch: IOException -> L16
    L21:
        handleParsedRecordData(parseRecordedStream(r0), r2);     // Catch: OutOfMemoryError -> L11 Exception -> L13
    L24:
        return;
    L13:
        e = move-exception;
        onRecordedFileParseFailed(e, r2);
        return;
    L11:
        e = move-exception;
        onRecordedFileParseFailed(e, r2);
        return;
    L16:
        e = move-exception;
        UIThreadUtils.runOnUiThreadImmediately(new AnonymousClass3(this, r2, e));
    }

    private /* synthetic */ void lambda$handleParsedRecordData$1(int r1, ParsedRecordData r2) {
        if (isReplayGenerationActive(r1) == true) goto L9;
        return;
    L9:
        applyParsedRecordData(r2);     // Catch: JSONException -> L7
        return;
    L7:
        this.mStateView.setReplayState(3);
    }

    private /* synthetic */ void lambda$onRecordedFileParseFailed$2(int r1, Throwable r2) {
        if (isReplayGenerationActive(r1) == true) goto L5;
        return;
    L5:
        this.mStateView.setReplayState(3);
    }

    private void onRecordedFileParseFailed(final Throwable r2, final int r3) {
        UIThreadUtils.runOnUiThreadImmediately(new a(this, r3, r2));
    }

    private static InputStream openRecordedPayloadStream(RecordedInputStreamProvider r2, boolean r3) throws IOException {
        PushbackInputStream r0 = new PushbackInputStream(new BufferedInputStream(r2.open()), 3);
        skipUtf8Bom(r0);
        if (r3 == true) goto L6;
        return r0;
    L6:
        return new InflaterInputStream(new Base64InputStream(r0, 0));
    }

    private static JSONArray readJsonArrayOrNull(JsonReader r2, String r3) throws IOException, JSONException {
        if (r2.peek() != JsonToken.NULL) goto L6;
        r2.nextNull();
        return null;
    L6:
        Object r4 = readJsonValue(r2);
        if ((r4 instanceof JSONArray) == false) goto L11;
        return (JSONArray) r4;
    L11:
        throw new JSONException("Expected array for key \"" + r3 + "\"");
    }

    private static JSONObject readJsonObjectOrNull(JsonReader r2, String r3) throws IOException, JSONException {
        if (r2.peek() != JsonToken.NULL) goto L6;
        r2.nextNull();
        return null;
    L6:
        Object r4 = readJsonValue(r2);
        if ((r4 instanceof JSONObject) == false) goto L11;
        return (JSONObject) r4;
    L11:
        throw new JSONException("Expected object for key \"" + r3 + "\"");
    }

    private void updateViewLayoutParams(int r2, int r3) {
        ViewGroup.LayoutParams r0 = this.mLynxView.getLayoutParams();
        r0.width = r2;
        r0.height = r3;
        this.mLynxView.setLayoutParams(r0);
    }

    public void onLynxViewWillBuild(LynxRecorderActionManager r3, LynxViewBuilder r4) {
        Iterator<LynxRecorderActionCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onLynxViewWillBuild(r3, r4);
        goto L4
    }

    public void updateScreenSize(int r2, int r3) {
        this.mLynxView.updateScreenMetrics(r2, r3);
    }

    public static /* synthetic */ void access$600(LynxRecorderActionManager r0, ParsedRecordData r1, int r2) {
        r0.handleParsedRecordData(r1, r2);
    }

    public static /* synthetic */ void access$700(LynxRecorderActionManager r0, Throwable r1, int r2) {
        r0.onRecordedFileParseFailed(r1, r2);
    }

    private void setViewLayoutParams(View r3, int r4, int r5) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0.width == r4) goto L5;
    L6:
        r0.width = r4;
        r0.height = r5;
        r3.setLayoutParams(r0);
        return;
    L5:
        if (r0.height != r5) goto L6;
    }

    public void dispatchAction(String r2, JSONObject r3, long r4) {
        Integer r5 = mCanMockFuncMap.get(r2);
        if (r5 != null) goto L5;
        return;
    L5:
        Message r0 = Message.obtain();
        r0.obj = r3;
        r0.what = r5.intValue();
        this.mHandler.sendMessageDelayed(r0, r4);
    }

    public LynxRecorderActionManager(Intent r4, Context r5, ViewGroup r6, LynxGroup r7) {
        this.mEmbeddedMode = 0;
        this.mReplayGeneration = new AtomicInteger(0);
        this.mStartTime = 0;
        this.mContext = r5;
        this.mLynxView = null;
        this.mIntent = r4;
        this.mUrl = null;
        this.mViewGroup = r6;
        this.mCallbacks = new ArrayList();
        this.mThreadStrategyData = null;
        this.mGlobalPropsCache = null;
        this.mConfig = null;
        this.mReloadList = new ArrayList();
        this.mLoadTemplateData = null;
        this.mLoadTemplateURL = null;
        this.mViewClient = null;
        this.mTemplateBundle = null;
        this.mTemplateBundleOptions = new a2(5, true, null);
        this.mDataProvider = new LynxRecorderReplayDataProviderInternal(this, null);
        this.mTemplateBundleParams = null;
        this.mReplayGesture = false;
        this.mPreDecode = false;
        this.mThreadMode = -1;
        this.mStateView = new LynxRecorderReplayStateView(r5);
        this.mDelayEndInterval = 3500;
        this.mRawFontScale = -1.0f;
        this.mDynamicFetcher = new LynxRecorderFetcher();
        this.mLynxDebugInfoRecorderDelegate = new LynxDebugInfoRecorderDelegate(this);
        this.mLynxGroup = r7;
        DisplayMetrics r8 = INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderActionManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r5.getResources());
        this.mScreenWidth = r8.widthPixels;
        this.mScreenHeight = r8.heightPixels;
        this.mDensity = r8.density;
        this.mEnableSizeOptimization = false;
        this.mForbidTimeFreeze = false;
        this.mPreloadScripts = new ArrayList();
        final Looper r9 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r9);
    }

    private void onLynxViewDidBuild(LynxView r3, Intent r4, Context r5, ViewGroup r6) {
        Iterator<LynxRecorderActionCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onLynxViewDidBuild(r3, r4, r5, r6);
        goto L4
    }
}
