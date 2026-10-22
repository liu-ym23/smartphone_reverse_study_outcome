package com.lynx.debugrouter;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.View;
import com.bytedance.librarian.a;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.debugrouter.app.MessageHandler;
import com.lynx.debugrouter.base.report.DebugRouterMetaInfo;
import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.base.usb.USBTransTemplateUtil;
import com.lynx.debugrouter.log.LLog;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DebugRouter {
    private static final String TAG = "DebugRouter";
    private static boolean mIsNativeLibraryLoaded;
    private static volatile DebugRouter sInstance;
    private static final WeakHashMap<View, Integer> viewMap = null;
    private final Map<DebugRouterGlobalHandler, Integer> mGlobalHandlers;
    private final Map<DebugRouterSessionHandler, Integer> mSessionHandlers;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static /* synthetic */ Class access$001(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    private native int nativeAddNativeGlobalHandler(GlobalHandlerDelegate r1);

    private native void nativeAddNativeMessageHandler(MessageHandlerDelegate r1);

    private native int nativeAddNativeSessionHandler(SessionHandlerDelegate r1);

    private native void nativeAddStateListener(NativeStateListenerDelegate r1);

    private native void nativeConnect(String r1, String r2);

    private native void nativeConnectAsync(String r1, String r2);

    private native void nativeCreateDebugRouter();

    private native void nativeDisableDebugChannel();

    private native void nativeDisconnect();

    private native void nativeDisconnectAsync();

    private native void nativeEnableAllSessions();

    private native void nativeEnableDebugChannel();

    private native void nativeEnableSingleSession(int r1);

    private native String nativeGetAppInfoByKey(String r1);

    private native String nativeGetConfig(String r1, String r2);

    private native int nativeGetConnectionState();

    private native String nativeGetRoomId();

    private native String nativeGetServerUrl();

    private native int nativeGetUSBPort();

    private native boolean nativeHandleSchema(String r1);

    private native boolean nativeIsDebugChannelEnabled();

    private native boolean nativeIsValidSchema(String r1);

    private native int nativePlug(NativeSlotDelegate r1);

    private native void nativePull(int r1);

    private native boolean nativeRemoveNativeGlobalHandler(int r1);

    private native boolean nativeRemoveNativeMessageHandler(String r1);

    private native boolean nativeRemoveNativeSessionHandler(int r1);

    private native void nativeSend(String r1);

    private native void nativeSendAsync(String r1);

    private native void nativeSendData(String r1, int r2, String r3, int r4, boolean r5);

    private native void nativeSendDataAsync(String r1, int r2, String r3, int r4, boolean r5);

    private native void nativeSetAppInfo(String r1, String r2);

    private native void nativeSetConfig(String r1, String r2);

    private native void nativeSetReportDelegate(NativeReportDelegate r1);

    public String getVersion() {
        return BuildConfig.DEBUGROUTER_VERSION;
    }

    static {
        viewMap = new WeakHashMap();
    }

    private String getCurrentProcessName() {
        Method r1 = INVOKESTATIC_com_lynx_debugrouter_DebugRouter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r2 instanceof String) == false) goto L12;
        return (String) r2;
    L12:
        return "android";
    L7:
        th = move-exception;
        th.printStackTrace();
        return "android";
    }

    public static DebugRouter getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(DebugRouter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DebugRouter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DebugRouter.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void initAppInfo() {
        String r0 = Build.MANUFACTURER;
        String r1 = Build.MODEL;
        if (r1.startsWith(r0) == false) goto L5;
        String r2 = r1;
    L6:
        String r3 = getCurrentProcessName();
        nativeSetAppInfo("App", r3);
        nativeSetAppInfo("AppVersion", "1.0");
        nativeSetAppInfo("AppProcessName", r3);
        nativeSetAppInfo("manufacturer", r0);
        nativeSetAppInfo("model", r1);
        nativeSetAppInfo("deviceModel", r2);
        nativeSetAppInfo("osVersion", Build.VERSION.RELEASE);
        nativeSetAppInfo("debugRouterVersion", getVersion());
        nativeSetAppInfo("debugRouterId", UUID.randomUUID().toString());
        nativeSetReportDelegate(new NativeReportDelegate());
        return;
    L5:
        r2 = r0 + " " + r1;
        goto L6
    }

    public static void loadNativeLibrary() {
        if (mIsNativeLibraryLoaded == true) goto L11;
        INVOKESTATIC_com_lynx_debugrouter_DebugRouter_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxdebugrouter");     // Catch: Throwable -> L6
        mIsNativeLibraryLoaded = true;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.toString();
        return;
    }

    public void disconnect() {
        LLog.i(TAG, "disconnect");
        nativeDisconnect();
    }

    private DebugRouter() {
        this.mSessionHandlers = new ConcurrentHashMap();
        this.mGlobalHandlers = new ConcurrentHashMap();
        loadNativeLibrary();
        LLog.addDebugLoggingDelegate();
        DebugRouterReportServiceUtil.init(new DebugRouterMetaInfo(getVersion(), getCurrentProcessName()));
        DebugRouterReportServiceUtil.report("DebugRouterInit", null, null, null);
        nativeCreateDebugRouter();
        initAppInfo();
        addMessageHandler(new CallStaticVoidMethodHandler());
        addMessageHandler(new OpenUsbTransTemplateSwitchHandler());
        addMessageHandler(new ReceiveTemplateByUsbHandler());
        addStateListener(new DebugRouterStateListener());
        USBTransTemplateUtil.INSTANCE.addInterceptor();
    }

    public static int getUSBPort() {
        return getInstance().nativeGetUSBPort();
    }

    public ConnectionState getConnectionState() {
        int r0 = nativeGetConnectionState();
        if (r0 == (-1)) goto L11;
        if (r0 == 1) goto L9;
        return ConnectionState.DISCONNECTED;
    L9:
        return ConnectionState.CONNECTED;
    L11:
        return ConnectionState.DISCONNECTED;
    }

    public String getRoomId() {
        return nativeGetRoomId();
    }

    public String getServerUrl() {
        return nativeGetServerUrl();
    }

    public boolean isDebugChannelEnabled() {
        return nativeIsDebugChannelEnabled();
    }

    public static boolean isNativeLibraryLoaded() {
        return mIsNativeLibraryLoaded;
    }

    public void disableDebugChannel() {
        nativeDisableDebugChannel();
    }

    public void disconnectAsync() {
        nativeDisconnectAsync();
    }

    public void enableAllSessions() {
        nativeEnableAllSessions();
    }

    public void enableDebugChannel() {
        nativeEnableDebugChannel();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_debugrouter_DebugRouter_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    private String checkNetworkStatus(Context r3) {
        if (r3 != null) goto L14;
        return NameKeys.UnloadStrategy_No_Strategy;
    L14:
        ConnectivityManager r4 = (ConnectivityManager) r3.getSystemService("connectivity");     // Catch: Throwable -> L13
        if (r4 != null) goto L8;
        return NameKeys.UnloadStrategy_No_Strategy;
    L8:
        NetworkInfo r5 = r4.getActiveNetworkInfo();     // Catch: Throwable -> L13
        if (r5 != null) goto L11;
        return NameKeys.UnloadStrategy_No_Strategy;
    L11:
        return r5.getTypeName();
    L13:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public void addGlobalHandler(DebugRouterGlobalHandler r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = nativeAddNativeGlobalHandler(new GlobalHandlerDelegate(r3));
        this.mGlobalHandlers.put(r3, Integer.valueOf(r0));
    }

    public void addMessageHandler(MessageHandler r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        nativeAddNativeMessageHandler(new MessageHandlerDelegate(r2));
    }

    public void addSessionHandler(DebugRouterSessionHandler r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = nativeAddNativeSessionHandler(new SessionHandlerDelegate(r3));
        this.mSessionHandlers.put(r3, Integer.valueOf(r0));
    }

    public void addStateListener(StateListener r2) {
        if (r2 == null) goto L5;
        nativeAddStateListener(new NativeStateListenerDelegate(r2));
        return;
    }

    public void enableSingleSession(int r1) {
        nativeEnableSingleSession(r1);
    }

    public String getAppInfoByKey(String r1) {
        return nativeGetAppInfoByKey(r1);
    }

    public int getSessionIdByView(View r2) {
        WeakHashMap<View, Integer> r0 = viewMap;
        monitor-enter(r0);
        Integer r3 = r0.get(r2);     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        int r4 = 0;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = r3.intValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public View getViewBySessionId(int r5) {
        WeakHashMap<View, Integer> r0 = viewMap;
        monitor-enter(r0);
        Iterator<Map.Entry<View, Integer>> r1 = r0.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r1.hasNext() == false) goto L12;
        Map.Entry<View, Integer> r2 = r1.next();     // Catch: Throwable -> L15
        if (r2.getValue().intValue() != r5) goto L6;
        View r6 = r2.getKey();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r6;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean handleSchema(String r1) {
        DebugRouterReport.reportHandleSchema(r1);
        return nativeHandleSchema(r1);
    }

    public boolean isValidSchema(String r1) {
        return nativeIsValidSchema(r1);
    }

    public int plug(DebugRouterSlot r4) {
        LLog.i(TAG, "plug session " + r4.getTemplateUrl());
        int r0 = nativePlug(new NativeSlotDelegate(r4));
        View r5 = r4.getTemplateView();
        if (r5 == null) goto L12;
        WeakHashMap<View, Integer> r1 = viewMap;
        monitor-enter(r1);
        r1.put(r5, Integer.valueOf(r0));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        return r0;
    }

    public void pull(int r3) {
        LLog.i(TAG, "pull session " + r3);
        nativePull(r3);
    }

    public boolean removeGlobalHandler(DebugRouterGlobalHandler r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Integer r4 = this.mGlobalHandlers.remove(r3);
        if (r4 != null) goto L8;
        return false;
    L8:
        return nativeRemoveNativeGlobalHandler(r4.intValue());
    }

    public boolean removeMessageHandler(MessageHandler r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return nativeRemoveNativeMessageHandler(r1.getName());
    }

    public boolean removeSessionHandler(DebugRouterSessionHandler r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Integer r4 = this.mSessionHandlers.remove(r3);
        if (r4 != null) goto L8;
        return false;
    L8:
        return nativeRemoveNativeSessionHandler(r4.intValue());
    }

    public void send(String r2) {
        if (r2 != null) goto L5;
        LLog.i(TAG, "send: message == null");
        return;
    L5:
        nativeSend(r2);
    }

    public void sendAsync(String r1) {
        nativeSendAsync(r1);
    }

    public synchronized void setAppInfo(Map<String, String> r2) {
        monitor-enter(this);
        setAppInfo(null, r2);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void connect(String r3, String r4) {
        LLog.i(TAG, "connect url:" + r3 + ", room:" + r4);
        nativeConnect(r3, r4);
    }

    public void connectAsync(String r3, String r4) {
        LLog.i(TAG, "connectAsync url:" + r3 + ", room:" + r4);
        nativeConnectAsync(r3, r4);
    }

    public Boolean getConfig(String r1, Boolean r2) {
        String r3 = nativeGetConfig(r1, r2.toString());
        if ("true".equals(r3) == false) goto L7;
        return Boolean.TRUE;
    L7:
        if ("false".equals(r3) == true) goto L9;
        LLog.w(TAG, "getConfig: value is illegal");
        return Boolean.FALSE;
    L9:
        return Boolean.FALSE;
    }

    public synchronized void setAppInfo(Context r4, Map<String, String> r5) {
        monitor-enter(this);
        Iterator<String> r0 = r5.keySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        String r1 = r0.next();     // Catch: Throwable -> L10
        nativeSetAppInfo(r1, r5.get(r1));     // Catch: Throwable -> L10
        goto L5
    L7:
        nativeSetAppInfo(CloudControlInf.NETWORK, checkNetworkStatus(r4));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setConfig(String r1, Boolean r2) {
        nativeSetConfig(r1, r2.toString());
    }

    public void setSessionIdOfView(View r2, int r3) {
        WeakHashMap<View, Integer> r0 = viewMap;
        monitor-enter(r0);
        r0.put(r2, Integer.valueOf(r3));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_debugrouter_DebugRouter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r5 = access$001(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$001(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }

    public void sendData(String r2, int r3, String r4) {
        sendData(r2, r3, r4, -1);
    }

    public void sendDataAsync(String r2, int r3, String r4) {
        sendDataAsync(r2, r3, r4, -1);
    }

    public void sendData(String r2, int r3, JSONObject r4) {
        sendData(r2, r3, r4, -1);
    }

    public void sendDataAsync(String r2, int r3, JSONObject r4) {
        sendDataAsync(r2, r3, r4, -1);
    }

    public void sendData(String r7, int r8, JSONObject r9, int r10) {
        sendData(r7, r8, r9.toString(), r10, true);
    }

    public void sendDataAsync(String r7, int r8, JSONObject r9, int r10) {
        nativeSendDataAsync(r7, r8, r9.toString(), r10, true);
    }

    public void sendData(String r7, int r8, String r9, int r10) {
        sendData(r7, r8, r9, r10, false);
    }

    public void sendDataAsync(String r7, int r8, String r9, int r10) {
        nativeSendDataAsync(r7, r8, r9, r10, false);
    }

    private void sendData(String r1, int r2, String r3, int r4, boolean r5) {
        if (r3 != null) goto L5;
        LLog.i(TAG, "sendData: message == null");
        return;
    L5:
        nativeSendData(r1, r2, r3, r4, r5);
    }
}
