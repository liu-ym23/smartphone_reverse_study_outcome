package com.bytedance.vmsdk.worker;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.FtsOptions;
import bk.c;
import com.bytedance.crash.upload.l;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.worker.network.WorkerDelegate;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.monitor.VmSdkMonitor;
import com.bytedance.vmsdk.net.Request;
import com.bytedance.vmsdk.net.Response;
import com.bytedance.vmsdk.registry.JavaScriptRegistry;
import ek.d;
import io.reactivex.internal.observers.h;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import m.f0;
import org.json.JSONException;
import org.json.JSONObject;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public class JsWorker {
    private static final String CACHE_PATH = "/woker_code_cache.bin";
    public static final String DEFAULT_BIZ_NAME = "unknown_android";
    private static final long QJS = 0;
    private static final String TAG = "VMSDK_JsWorker";
    private static final long V8 = 1;
    private static boolean isInitialised = false;
    private boolean isIcuInitialised;
    private mk.a mDevTool;
    private EngineType mEngineType;
    private IWorkerExceptionDelegate mExceptionDelegate;
    private c mInspectorClientNew;
    private JavaScriptRegistry mJavaScriptModuleRegistry;
    private JSModuleManager mModuleManager;
    private AtomicLong mNativeWorkerPtr;
    private lk.a mOnErrorCallback;
    private lk.a mOnMessageCallback;
    private int mSrcID;
    private lk.b mWorkerDelegate;

    public static final enum EngineType extends Enum<EngineType> {
        private static final /* synthetic */ EngineType[] $VALUES = null;
        public static final EngineType QUICKJS = null;
        public static final EngineType V8 = null;

        static {
            EngineType r5 = new EngineType("QUICKJS", 0);
            QUICKJS = r5;
            EngineType r10 = new EngineType("V8", 1);
            V8 = r10;
            $VALUES = new EngineType[]{r5, r10};
        }

        private EngineType(String r5, int r10) {
            super(r5, r10);
        }

        public static EngineType valueOf(String r5) {
            return (EngineType) Enum.valueOf(EngineType.class, r5);
        }

        public static EngineType[] values() {
            return (EngineType[]) $VALUES.clone();
        }
    }

    public JsWorker(b r12) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r12.d, r12.f7564a, null, false, r12.f7565b, r12.f7566c, false, false, false);
    }

    @CalledByNative
    private void Fetch(String r5, String r10, byte[] r11, long r12) {
        if (this.mWorkerDelegate == null) goto L16;
    L7:
        e = move-exception;
        Log.e(TAG, "fail to convert json: " + e.getMessage());
        return;
    L5:
        if (r10.isEmpty() == false) goto L9;
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L7
    L10:
        Log.d(TAG, "Fetch params: ".concat(r10));     // Catch: JSONException -> L7
        ((WorkerDelegate) this.mWorkerDelegate).a(new Request(r5, r13, r11), new l(this, r12, 2));     // Catch: JSONException -> L7
        return;
    L9:
        r13 = new JSONObject(r10);     // Catch: JSONException -> L7
        goto L10
    }

    @CalledByNative
    private String FetchJsWithUrlSync(String r5) {
        lk.b r10 = this.mWorkerDelegate;
        if (r10 == null) goto L18;
        WorkerDelegate r11 = (WorkerDelegate) r10;
        String r12 = null;
        Object r13 = null;
        if (r5 != null) goto L20;
    L16:
        androidx.constraintlayout.motion.widget.a.A("FetchJsWithUrlSync js: ", r12, TAG);
        return r12;
    L20:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L9
        Object r15 = Result.m124constructorimpl(j.l(r11.d.b(LoadFrom.f6957c, new uh.b(r5))));     // Catch: Throwable -> L9
    L12:
        if (Result.m130isFailureimpl(r15) == true) goto L15;
        r13 = r15;
    L15:
        r12 = (String) r13;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    L18:
        return "";
    }

    @CalledByNative
    private void SendInspectorResponse(String r5) {
        c r10 = this.mInspectorClientNew;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f956a == null) goto L17;
        d r11 = r10.f956a;
        r11.getClass();
        int r12 = ek.b.f16824a;
        byte[] r13 = r5.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L11
        int r14 = r13.length;
        ek.a r15 = new ek.a();
        r15.f16821a = true;
        r15.f16822b = 1;
        r15.f16823c = r14;
        r15.d = r13;
        r11.a(r15);
        return;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static /* synthetic */ void a(JsWorker r5) {
        r5.lambda$registerICU$0();
    }

    public static /* synthetic */ AtomicLong access$000(JsWorker r5) {
        return r5.mNativeWorkerPtr;
    }

    public static /* synthetic */ void access$100(long r5, long r10) {
        nativeInitQJSWebAssembly(r5, r10);
    }

    public static /* synthetic */ void access$200(long r5, Response r10, long r11) {
        nativeResolve(r5, r10, r11);
    }

    public static /* synthetic */ void access$300(long r5, String r10, long r11) {
        nativeReject(r5, r10, r11);
    }

    public static byte[] genCodeCache(String r5, EngineType r10) {
        if (r10 != EngineType.QUICKJS) goto L5;
        long r11 = 0;
    L7:
        return nativeGenCodeCache(r5, r11);
    L5:
        r11 = V8;
        goto L7
    }

    public static String getCacheFilePath(String r5) {
        return h.b(r5, CACHE_PATH);
    }

    public static long getWasmRegisterFunctionPtr() {
        return ((Long) Class.forName("com.bytedance.vmsdk.wasm.RegisterWebAssembly").getMethod("registerWebAssembly", null).invoke(null, null)).longValue();
    L4:
        e = move-exception;
        Log.e(TAG, "No webassembly found in the host [ " + e.getMessage() + ", " + e.getCause() + " ]");
        return 0;
    }

    private void init(JSModuleManager r17, EngineType r18, String r19, boolean r20, String r21, boolean r22, boolean r23, boolean r24, boolean r25) {
        if (isInitialised == true) goto L6;
        initialize();
    L6:
        if (r18 != EngineType.QUICKJS) goto L8;
        long r5 = 0;
    L9:
        this.mEngineType = r18;
        if (jk.a.m().i("vmsdk_enable_codecache") == true) goto L12;
        String r10 = null;
    L13:
        this.mNativeWorkerPtr.set(nativeCreateWorker(this, r5, r17, r10, r20, r21, r25));
        if (r23 == false) goto L16;
        registerICU();
    L16:
        this.mJavaScriptModuleRegistry = new JavaScriptRegistry();
        this.mModuleManager = r17;
        if (r22 == false) goto L27;
        mk.a r11 = new mk.a();
    L24:
        e = move-exception;
        f0.i(e, new StringBuilder("[Devtool] create WorkerInspectorDelegateImpl failed: "), "WorkerDevTool");
    L26:
        this.mDevTool = r11;
        this.mInspectorClientNew = new c(this);
        goto L27
    L20:
        if (Class.forName("com.bytedance.vmsdk.devtool.WorkerInspectorDelegateImpl").getConstructor(new Class[]{JsWorker.class}).newInstance(new Object[]{this}) == null) goto L26;
        throw new ClassCastException();     // Catch: Exception -> L24
    L27:
        if (r24 == false) goto L36;
        long r12 = getWasmRegisterFunctionPtr();
        if (r12 == 0) goto L36;
        initWebAssembly(r12, this.mEngineType);
    L36:
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L33
        r13.put("biz_name", r21);     // Catch: Throwable -> L33
        r13.put("init_worker", true);     // Catch: Throwable -> L33
        r13.put("vmsdk_android_version", "2.15.5-debugger");     // Catch: Throwable -> L33
        Log.d(TAG, "new jsworker: " + r13 + " vmsdk_android_version: 2.15.5-debugger");     // Catch: Throwable -> L33
        VmSdkMonitor.a();     // Catch: Throwable -> L33
        throw null;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Log.e(TAG, "vmsdk monitor data upload error: " + th.getMessage());
        return;
    L12:
        r10 = r19;
        goto L13
    L8:
        r5 = 1;
        goto L9
    }

    public static boolean initDevtool() {
        Long r5 = (Long) Class.forName("com.bytedance.vmsdk.devtool.DevtoolManager").getMethod("initialize", null).invoke(null, null);     // Catch: Throwable -> L10
        if (r5 != null) goto L6;
    L12:
        return false;
    L6:
        if (r5.longValue() == 0) goto L12;
        nativeInitInspectorFactory(r5.longValue());     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        Log.i(TAG, "[Devtool] Initialize devtool failed:", th);
        return false;
    }

    public static boolean initialize() {
        String[] r5 = {"quick", "napi", "worker"};
        int r10 = 0;
        boolean r11 = false;
    L4:
        if (r10 >= 3) goto L11;
        System.loadLibrary(r5[r10]);     // Catch: Throwable -> L8
    L10:
        r10 = r10 + 1;
    L8:
        th = move-exception;
        Log.d(TAG, "initialize error: " + th.getMessage());
        r11 = true;
        goto L10
    L11:
        initDevtool();
        boolean r12 = !r11;
        isInitialised = r12;
        return r12;
    }

    public static boolean initializeWithPlugin(String r5) {
    L9:
        th = move-exception;
        Log.d(TAG, "initializeWithPlugin error: " + th.getMessage());
        return false;
    L5:
        if (ak.a.d() == true) goto L29;
    L11:
        boolean r10 = false;
    L12:
        boolean r11 = ak.a.c(r5);     // Catch: Throwable -> L9
        if (isInitialised == true) goto L20;
        if (r10 == false) goto L18;
        if (r11 == false) goto L18;
        boolean r12 = true;
    L19:
        isInitialised = r12;
    L18:
        r12 = false;
    L20:
        if (r10 == false) goto L31;
        if (r11 == true) goto L23;
        return false;
    L23:
        return true;
    L31:
        return false;
    L29:
        System.loadLibrary("quick");     // Catch: Throwable -> L26
        Log.d("VmSdk", "loadQuickJsLibrary in host success");     // Catch: Throwable -> L9
        r10 = true;
        goto L12
    }

    public static boolean initializeWithPlugin2(String r5) {
        boolean r10 = ak.a.c(r5);     // Catch: Throwable -> L7
        if (isInitialised == true) goto L6;
        isInitialised = r10;
    L6:
        return r10;
    L7:
        th = move-exception;
        Log.d(TAG, "initializeWithPlugin error: " + th.getMessage());
        return false;
    }

    public static boolean initializeWithoutThrow() {
        String[] r5 = {"quick", "napi", "worker"};
        int r10 = 0;
    L4:
        if (r10 >= 3) goto L6;
        System.loadLibrary(r5[r10]);
        r10 = r10 + 1;
        goto L4
    L6:
        isInitialised = true;
        return true;
    }

    public static boolean isIsInitialised() {
        return isInitialised;
    }

    private /* synthetic */ void lambda$registerICU$0() {
        long r5 = nativeGetNapiEnv(this.mNativeWorkerPtr.get());
        if (r5 != 0) goto L12;
        Log.e(TAG, "napi_env is nullptr");
        return;
    L12:
        Class.forName("com.bytedance.vmsdk.icu.RegisterICU").getMethod("nativeRegisterICUInNapiEnv", new Class[]{Long.TYPE}).invoke(null, new Object[]{Long.valueOf(r5)});     // Catch: Exception -> L7
        Log.i(TAG, "register icu api in napi success");
        this.isIcuInitialised = true;
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "Register ICU api in Napi failed [ " + e.getClass().getSimpleName() + ", " + e.getMessage() + ", " + e.getCause() + " ]");
    }

    private native void nativeBind(long r5, int r10, int r11);

    private static native long nativeCreateWorker(JsWorker r5, long r10, JSModuleManager r11, String r12, boolean r13, String r14, boolean r15);

    private native void nativeEvaluateCodeCache(long r5, byte[] r10);

    private static native void nativeEvaluateJavaScript(long r5, String r10, String r11, boolean r12);

    private static native byte[] nativeGenCodeCache(String r5, long r10);

    private native long nativeGetNapiEnv(long r5);

    private static native void nativeInitInspector(long r5, long r10);

    private static native void nativeInitInspectorFactory(long r5);

    private static native void nativeInitQJSWebAssembly(long r5, long r10);

    private native Object nativeInvokeJavaScriptFunction(long r5, String r10, JavaOnlyArray r11, char r12);

    private native Object nativeInvokeJavaScriptModule(long r5, String r10, String r11, JavaOnlyArray r12, char r13);

    private native void nativeOnCloseInspectorSession(long r5);

    private native void nativeOnInspectorMessage(long r5, String r10);

    private native void nativeOnJSRunner(long r5, Runnable r10);

    private native void nativeOnJSRunnerAtFront(long r5, Runnable r10);

    private native void nativeOnJSRunnerDelay(long r5, Runnable r10, long r11);

    private native void nativeOnOpenInspectorSession(long r5);

    private native void nativeOnPlatformRunner(long r5, Runnable r10);

    private native void nativeOnWorkerRunner(long r5, Runnable r10);

    private static native void nativePostMessage(long r5, String r10);

    private static native void nativeRegisterDelegateFunction(long r5);

    private static native void nativeReject(long r5, String r10, long r11);

    private static native void nativeResolve(long r5, Response r10, long r11);

    private native void nativeSetExceptionDelegate(long r5, IWorkerExceptionDelegate r10);

    private native void nativeSetProperties(long r5, JavaOnlyMap r10);

    private native void nativeSetupLoader(long r5, String r10);

    private static native void nativeTerminate(long r5);

    private static native void nativeV8PipeInit(long r5, long[] r10);

    @CalledByNative
    private void onError(String r5) {
        lk.a r10 = this.mOnErrorCallback;
        if (r10 == null) goto L5;
        r10.a(r5);
    L5:
        Log.e(TAG, "Error from native: " + r5);
    }

    @CalledByNative
    private void onMessage(String r5) {
        lk.a r10 = this.mOnMessageCallback;
        if (r10 == null) goto L5;
        r10.a(r5);
    L5:
        androidx.constraintlayout.motion.widget.a.A("Message from native: ", r5, TAG);
    }

    public static boolean preLoadPlugin(String r5) {
        return ak.a.e(r5);
    }

    private void registerICU() {
        System.loadLibrary(FtsOptions.TOKENIZER_ICU);     // Catch: Exception -> L5
        postOnJSRunner(new com.obric.oui.lisitem.a(this, 14));
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "fail to load libicu.so: " + e.getMessage());
    }

    @Deprecated
    public static void v8pipeInit(long[] r5) {
    }

    @CalledByNative
    private boolean workDelegateExists() {
        if (this.mWorkerDelegate == null) goto L6;
        return true;
    L6:
        return false;
    }

    public EngineType EngineType() {
        return this.mEngineType;
    }

    public void bind(int r5, int r10) {
        this.mSrcID = r5;
        nativeBind(this.mNativeWorkerPtr.get(), r5, r10);
        Log.d(TAG, "JsWorker id : " + r5 + ", " + r10);
    }

    public void evaluateCodeCache(byte[] r5) {
        if (isRunning() == false) goto L6;
        nativeEvaluateCodeCache(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void evaluateJavaScript(String r5) {
        if (isRunning() == false) goto L6;
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r5, "default.js", false);
        return;
    }

    public void evaluateJavaScriptWithException(String r5, String r10) {
        if (isRunning() == false) goto L6;
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r5, r10, true);
        return;
    }

    public IWorkerExceptionDelegate getDelegate() {
        return this.mExceptionDelegate;
    }

    public c getInspectorClient() {
        return this.mInspectorClientNew;
    }

    public <T extends com.bytedance.vmsdk.registry.a> T getJavaScriptFunction(Class<T> r5) {
        return (T) this.mJavaScriptModuleRegistry.getJavaScriptFunction(this, r5);
    }

    public <T extends com.bytedance.vmsdk.registry.b> T getJavaScriptModule(Class<T> r5) {
        this.mJavaScriptModuleRegistry.getJavaScriptModule(this, r5);
        return null;
    }

    public JSModuleManager getModuleManager() {
        return this.mModuleManager;
    }

    public long getNapiEnv() {
        if (this.mNativeWorkerPtr.get() != 0) goto L5;
        return 0;
    L5:
        return nativeGetNapiEnv(this.mNativeWorkerPtr.get());
    }

    public long getNativePtr() {
        return this.mNativeWorkerPtr.get();
    }

    public int id() {
        return this.mSrcID;
    }

    public void initInspector(long r5) {
        nativeInitInspector(this.mNativeWorkerPtr.get(), r5);
    }

    public void initV8Pipe(long[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length <= 3) goto L8;
        nativeV8PipeInit(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void initWebAssembly(long r5, EngineType r10) {
        Log.w("vmsdk", "Wasm not enabled in worker");
    }

    public Object invokeJavaScriptFunction(String r10, JavaOnlyArray r11, char r12, boolean r13) {
        if (isRunning() == true) goto L5;
        return null;
    L5:
        return nativeInvokeJavaScriptFunction(this.mNativeWorkerPtr.get(), r10, r11, r12);
    }

    public Object invokeJavaScriptModule(String r10, String r11, JavaOnlyArray r12, char r13) {
        if (isRunning() == true) goto L5;
        return null;
    L5:
        return nativeInvokeJavaScriptModule(this.mNativeWorkerPtr.get(), r10, r11, r12, r13);
    }

    public boolean isIsIcuInitialised() {
        return this.isIcuInitialised;
    }

    public boolean isRunning() {
        if (this.mNativeWorkerPtr.get() == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public void onCloseInspectorSession() {
        if (isRunning() == false) goto L6;
        nativeOnCloseInspectorSession(this.mNativeWorkerPtr.get());
        return;
    }

    public void onInspectorMessage(String r5) {
        if (isRunning() == false) goto L6;
        nativeOnInspectorMessage(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void onOpenInspectorSession() {
        if (isRunning() == false) goto L6;
        nativeOnOpenInspectorSession(this.mNativeWorkerPtr.get());
        return;
    }

    public void postMessage(String r5) {
        if (isRunning() == false) goto L6;
        nativePostMessage(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void postOnJSRunner(Runnable r5) {
        if (isRunning() == false) goto L6;
        nativeOnJSRunner(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void postOnJSRunnerAtFront(Runnable r5) {
        if (isRunning() == false) goto L6;
        nativeOnJSRunnerAtFront(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void postOnJSRunnerDelay(Runnable r10, long r11) {
        if (this.mNativeWorkerPtr.get() == 0) goto L6;
        nativeOnJSRunnerDelay(this.mNativeWorkerPtr.get(), r10, r11);
        return;
    }

    public void postOnPlatformRunner(Runnable r5) {
        if (this.mNativeWorkerPtr.get() == 0) goto L6;
        nativeOnPlatformRunner(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void postOnWorkerRunner(Runnable r5) {
        if (isRunning() == false) goto L6;
        nativeOnWorkerRunner(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void registerModule(@NonNull String r5, @NonNull Class<? extends JSModule> r10, @Nullable Object r11) {
        if (this.mModuleManager != null) goto L5;
        return;
    L5:
        if (isRunning() == false) goto L9;
        this.mModuleManager.b(r10, r11, r5);
        return;
    }

    public void setDelegate(IWorkerExceptionDelegate r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.mNativeWorkerPtr.get() == 0) goto L8;
        this.mExceptionDelegate = r5;
        nativeSetExceptionDelegate(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void setGlobalProperties(JavaOnlyMap r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.size() > 0) goto L6;
        return;
    L6:
        if (isRunning() == false) goto L11;
        nativeSetProperties(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void setInspectorClient(c r5) {
        this.mInspectorClientNew = r5;
    }

    public void setOnErrorCallback(lk.a r5) {
        this.mOnErrorCallback = r5;
    }

    public void setOnMessageCallback(lk.a r5) {
        this.mOnMessageCallback = r5;
    }

    public void setWorkerDelegate(lk.b r5) {
        this.mWorkerDelegate = r5;
        if (r5 == null) goto L6;
        nativeRegisterDelegateFunction(this.mNativeWorkerPtr.get());
        return;
    }

    public void setupLoader(String r5) {
        if (isRunning() == false) goto L6;
        nativeSetupLoader(this.mNativeWorkerPtr.get(), r5);
        return;
    }

    public void terminate() {
        if (this.mOnMessageCallback == null) goto L6;
        this.mOnMessageCallback = null;
    L6:
        if (this.mOnErrorCallback == null) goto L9;
        this.mOnErrorCallback = null;
    L9:
        if (this.mDevTool == null) goto L11;
        this.mDevTool = null;
    L11:
        c r5 = this.mInspectorClientNew;
        if (r5 == null) goto L34;
        jk.a r10 = c.f955h;
        bk.a r11 = (bk.a) r10.d;
        ArrayList r12 = r11.f954b;
        monitor-enter(r12);
        r11.f954b.remove(r5);     // Catch: Throwable -> L31
        monitor-exit(r12);     // Catch: Throwable -> L31
        p r13 = (p) r10.e;
        dk.a r14 = r5.e;
        ek.c r15 = r5.f;
        monitor-enter(r13);
        int r16 = ((ArrayList) r13.f23312b).indexOf(r14);     // Catch: Throwable -> L26
        if (r16 >= 0) goto L22;
    L24:
        monitor-exit(r13);
        this.mInspectorClientNew = null;
        goto L34
    L22:
        if (r15 != ((ArrayList) r13.f23313c).get(r16)) goto L24;
        ((ArrayList) r13.f23312b).remove(r16);     // Catch: Throwable -> L26
        ((ArrayList) r13.f23313c).remove(r16);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L31:
        th = move-exception;
        throw th;
    L34:
        JSModuleManager r17 = this.mModuleManager;
        if (r17 == null) goto L38;
        r17.destroy();
        this.mModuleManager = null;
    L38:
        if (this.mNativeWorkerPtr.get() == 0) goto L47;
        isInitialised = false;
        long r18 = this.mNativeWorkerPtr.getAndSet(0);
        if (r18 == 0) goto L48;
        nativeTerminate(r18);
        return;
    L48:
        return;
    }

    public void evaluateJavaScript(String r5, String r10) {
        if (isRunning() == false) goto L6;
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r5, r10, false);
        return;
    }

    @Deprecated
    public JsWorker() {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        EngineType r5 = EngineType.QUICKJS;
        this.mEngineType = r5;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(null, r5, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r12) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        EngineType r5 = EngineType.QUICKJS;
        this.mEngineType = r5;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r12, r5, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r12, EngineType r13) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r12, r13, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r12, EngineType r13, boolean r14) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r12, r13, null, r14, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r12, EngineType r13, String r14) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r12, r13, h.b(r14, CACHE_PATH), false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r12, EngineType r13, String r14, boolean r15) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r12, r13, h.b(r14, CACHE_PATH), r15, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r11, EngineType r12, String r13, boolean r14, String r15) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r11, r12, h.b(r13, CACHE_PATH), r14, r15, false, false, false, false);
    }
}
