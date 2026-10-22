package com.ttnet.org.chromium.base;

import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TraceEvent$ATrace implements MessageQueue.IdleHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ATrace";
    private Method mAsyncTraceBeginMethod;
    private Method mAsyncTraceEndMethod;
    private Method mGetSystemPropertyMethod;
    private boolean mIdleHandlerRegistered;
    private Method mIsTraceTagEnabledMethod;
    private final AtomicBoolean mNativeTracingReady;
    private boolean mShouldWriteToSystemTrace;
    private Class<?> mSystemPropertiesClass;
    private Method mTraceBeginMethod;
    private Class<?> mTraceClass;
    private Method mTraceEndMethod;
    private final long mTraceTag;
    private final AtomicBoolean mTraceTagActive;
    private final AtomicBoolean mUiThreadReady;

    public static /* synthetic */ void a(TraceEvent$ATrace r0) {
        r0.lambda$onNativeTracingReady$0();
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ void b(TraceEvent$ATrace r0) {
        r0.lambda$onUiThreadReady$1();
    }

    private CategoryConfig getCategoryConfigFromATrace() {
        CategoryConfig r0 = new CategoryConfig(null);
        Integer r1 = getIntegerSystemProperty("debug.atrace.app_number");
        if (r1 != null) goto L5;
    L30:
        return r0;
    L5:
        if (r1.intValue() <= 0) goto L30;
        if (ContextUtils.getApplicationContext() == null) goto L30;
        String r2 = ContextUtils.getApplicationContext().getPackageName();
        int r4 = 0;
    L10:
        if (r4 >= r1.intValue()) goto L30;
        String r5 = getSystemProperty("debug.atrace.app_" + r4);
        if (r5 == null) goto L29;
        if (r5.startsWith(r2) == false) goto L29;
        String r6 = r5.substring(r2.length());
        if (r6.startsWith("/") == false) goto L29;
        String[] r7 = r6.substring(1).split(":");
        int r8 = r7.length;
        int r9 = 0;
    L20:
        if (r9 >= r8) goto L29;
        String r10 = r7[r9];
        if (r10.equals("-atrace") == false) goto L25;
        r0.shouldWriteToATrace = false;
    L28:
        r9 = r9 + 1;
        goto L20
    L25:
        if (r0.filter.length() <= 0) goto L27;
        r0.filter += ",";
    L27:
        r0.filter += r10;
    L29:
        r4 = r4 + 1;
        goto L10
    }

    private boolean pollConfig() {
        boolean r0 = this.mTraceTagActive.get();
        boolean r1 = isTraceTagEnabled(this.mTraceTag);
        if (r0 != r1) goto L5;
        return false;
    L5:
        this.mTraceTagActive.set(r1);
        if (r1 == true) goto L9;
        EarlyTraceEvent.disable();
        disableNativeATrace();
        this.mShouldWriteToSystemTrace = false;
        ThreadUtils.getUiThreadLooper().setMessageLogging(null);
        return true;
    L9:
        CategoryConfig r2 = getCategoryConfigFromATrace();
        this.mShouldWriteToSystemTrace = false;
        if (this.mNativeTracingReady.get() == false) goto L16;
        if (r2.shouldWriteToATrace == false) goto L14;
        enableNativeATrace(r2.filter);
    L20:
        if (r2.shouldWriteToATrace == true) goto L22;
        ThreadUtils.getUiThreadLooper().setMessageLogging(TraceEvent$LooperMonitorHolder.access$000());
    L22:
        return true;
    L14:
        setupATraceStartupTrace(r2.filter);
        goto L20
    L16:
        if (r2.shouldWriteToATrace == false) goto L18;
        this.mShouldWriteToSystemTrace = true;
        goto L20
    L18:
        EarlyTraceEvent.enable();
        goto L20
    }

    public boolean hasActiveSession() {
        return this.mTraceTagActive.get();
    }

    public void onNativeTracingReady() {
        this.mNativeTracingReady.set(true);
        this.mTraceTagActive.set(false);
        if (this.mUiThreadReady.get() == false) goto L6;
        ThreadUtils.postOnUiThread(new k(this));
        return;
    }

    public void onUiThreadReady() {
        this.mUiThreadReady.set(true);
        if (ThreadUtils.runningOnUiThread() == true) goto L6;
        ThreadUtils.postOnUiThread(new j(this));
        return;
    L6:
        startPolling();
    }

    public void traceEnd() {
        if (this.mShouldWriteToSystemTrace == true) goto L8;
        return;
    L8:
        this.mTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag)});     // Catch: Exception -> L7
        return;
    }

    private void disableNativeATrace() {
        TraceEventJni.get().stopATrace();
    }

    private void startPolling() {
        ThreadUtils.assertOnUiThread();
        if (this.mIdleHandlerRegistered == true) goto L5;
        Looper.myQueue().addIdleHandler(this);
        this.mIdleHandlerRegistered = true;
    L5:
        pollConfig();
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        pollConfig();
        return true;
    }

    static {
    }

    private /* synthetic */ void lambda$onNativeTracingReady$0() {
        pollConfig();
    }

    private /* synthetic */ void lambda$onUiThreadReady$1() {
        startPolling();
    }

    public TraceEvent$ATrace(long r10) {
        this.mNativeTracingReady = new AtomicBoolean();
        this.mUiThreadReady = new AtomicBoolean();
        this.mTraceTagActive = new AtomicBoolean();
        Class<?> r2 = INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$ATrace_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Trace");     // Catch: Exception -> L5
        this.mTraceClass = r2;     // Catch: Exception -> L5
        Class<?> r5 = Long.TYPE;     // Catch: Exception -> L5
        this.mIsTraceTagEnabledMethod = r2.getMethod("isTagEnabled", new Class[]{r5});     // Catch: Exception -> L5
        this.mTraceBeginMethod = this.mTraceClass.getMethod("traceBegin", new Class[]{r5, String.class});     // Catch: Exception -> L5
        this.mTraceEndMethod = this.mTraceClass.getMethod("traceEnd", new Class[]{r5});     // Catch: Exception -> L5
        Class<?> r3 = this.mTraceClass;     // Catch: Exception -> L5
        Class<?> r8 = Integer.TYPE;     // Catch: Exception -> L5
        this.mAsyncTraceBeginMethod = r3.getMethod("asyncTraceBegin", new Class[]{r5, String.class, r8});     // Catch: Exception -> L5
        this.mAsyncTraceEndMethod = this.mTraceClass.getMethod("asyncTraceEnd", new Class[]{r5, String.class, r8});     // Catch: Exception -> L5
        Class<?> r4 = INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$ATrace_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L5
        this.mSystemPropertiesClass = r4;     // Catch: Exception -> L5
        this.mGetSystemPropertyMethod = r4.getMethod("get", new Class[]{String.class});     // Catch: Exception -> L5
    L7:
        this.mTraceTag = r10;
        pollConfig();
        return;
    L5:
        e = move-exception;
        Log.w(TAG, "Reflection error", new Object[]{e});
        this.mIsTraceTagEnabledMethod = null;
        goto L7
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$ATrace_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private void enableNativeATrace(String r2) {
        TraceEventJni.get().startATrace(r2);
    }

    private Integer getIntegerSystemProperty(String r2) {
        String r3 = getSystemProperty(r2);
        if (r3 != null) goto L8;
        return null;
    L8:
        return Integer.decode(r3);
    L7:
        return null;
    }

    private String getSystemProperty(String r5) {
        return (String) this.mGetSystemPropertyMethod.invoke(this.mSystemPropertiesClass, new Object[]{r5});
    L4:
        return null;
    }

    private boolean isTraceTagEnabled(long r5) {
        return ((Boolean) this.mIsTraceTagEnabledMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(r5)})).booleanValue();
    L5:
        return false;
    }

    private void setupATraceStartupTrace(String r2) {
        TraceEventJni.get().setupATraceStartupTrace(r2);
    }

    public void traceBegin(String r6) {
        if (this.mShouldWriteToSystemTrace == true) goto L8;
        return;
    L8:
        this.mTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r6});     // Catch: Exception -> L7
        return;
    }

    public void asyncTraceBegin(String r6, int r7) {
        if (this.mShouldWriteToSystemTrace == true) goto L8;
        return;
    L8:
        this.mAsyncTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r6, Integer.valueOf(r7)});     // Catch: Exception -> L7
        return;
    }

    public void asyncTraceEnd(String r6, int r7) {
        if (this.mShouldWriteToSystemTrace == true) goto L8;
        return;
    L8:
        this.mAsyncTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r6, Integer.valueOf(r7)});     // Catch: Exception -> L7
        return;
    }
}
