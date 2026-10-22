package com.obric.systemopt;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SysPowerKit {
    private static final String CLASS_POWER_ADVISOR = "android.os.PowerAdvisorManager";
    private static final String CLASS_POWER_LISTENER = "android.os.PowerAdvisorManager$PowerListener";
    public static final int POWER_OVER_USING = 1;
    public static final String PWR_OVERUSE_ACTION_NAME = "ActionName";
    public static final int PWR_OVERUSE_ALARM = 7;
    public static final int PWR_OVERUSE_ANINATION_LEAK = 11;
    public static final int PWR_OVERUSE_AP_SUSPEND_BLOCK = 14;
    public static final int PWR_OVERUSE_BLE_SCAN = 9;
    public static final int PWR_OVERUSE_CAMERA = 3;
    public static final String PWR_OVERUSE_COLLECT_APPLOG = "CollectAppLog";
    public static final int PWR_OVERUSE_CPU_LOAD = 1;
    public static final int PWR_OVERUSE_FLASH_LIGHT = 4;
    public static final int PWR_OVERUSE_GPS = 2;
    public static final int PWR_OVERUSE_KERNEL_WAKELOCK = 13;
    public static final int PWR_OVERUSE_KERNEL_WAKEUP = 12;
    public static final int PWR_OVERUSE_NET_PACKETS = 6;
    public static final String PWR_OVERUSE_PACKAGE_NAME = "PkgName";
    public static final int PWR_OVERUSE_PARTIAL_WAKELOCK = 5;
    public static final String PWR_OVERUSE_PID = "Pid";
    public static final int PWR_OVERUSE_SENSOR = 10;
    public static final String PWR_OVERUSE_STAT_TIME = "StatTime";
    public static final int PWR_OVERUSE_SUB_SYSTEM = 15;
    public static final String PWR_OVERUSE_THRESHOLD = "Threshold";
    public static final String PWR_OVERUSE_UID = "Uid";
    public static final int PWR_OVERUSE_WIFI_SCAN = 8;
    private static final String TAG = "SysPowerKit";
    private Method mAddPowerListenerMethod;
    private Method mApplyResourceUseMethod;
    private volatile c mExternalListener;
    private Method mGetInstanceMethod;
    private Object mListenerProxy;
    private Class<?> mPowerAdvisorClass;
    private Object mPowerAdvisorInstance;
    private Class<?> mPowerListenerInterface;
    private Method mRemovePowerListenerMethod;
    private Method mUnApplyResourceUseMethod;

    public class a implements InvocationHandler {
        public final /* synthetic */ SysPowerKit a;

        public a(SysPowerKit r1) {
            this.a = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r6, Method r7, Object[] r8) {
            String r9 = r7.getName();
            boolean r1 = true;
            int r3 = 0;
            if ("onPowerStateChanged".equals(r9) == false) goto L34;
            if (r8 != null) goto L6;
        L30:
            Bundle r10 = null;
            int r11 = 0;
        L31:
            SysPowerKit.access$200(this.a, r3, r11, r10);
            return null;
        L6:
            if (r8.length < 3) goto L30;
            Object r12 = r8[0];     // Catch: Throwable -> L27
            if ((r12 instanceof Integer) == false) goto L11;
            int r13 = ((Integer) r12).intValue();     // Catch: Throwable -> L27
        L59:
            Object r14 = r8[1];     // Catch: Throwable -> L25
            if ((r14 instanceof Integer) == false) goto L63;
            r3 = ((Integer) r14).intValue();     // Catch: Throwable -> L25
        L63:
            Object r15 = r8[2];     // Catch: Throwable -> L23
            if ((r15 instanceof Bundle) == false) goto L21;
            r10 = (Bundle) r15;     // Catch: Throwable -> L23
        L22:
            int r4 = r3;
            r3 = r13;
            r11 = r4;
            goto L31
        L21:
            r10 = null;
        L23:
            th = move-exception;
            int r5 = r3;
            r3 = r13;
            th = th;
            int r16 = r5;
        L29:
            FLogger.a.w(SysPowerKit.TAG, "listener proxy: failed to parse onPowerStateChanged args", th);
            r11 = r16;
            r10 = null;
        L25:
            th = move-exception;
            r3 = r13;
            th = th;
        L28:
            r16 = 0;
            goto L29
        L11:
            r13 = 0;
        L27:
            th = th;
            goto L28
        L34:
            if ("equals".equals(r9) == false) goto L45;
            if (r8 == null) goto L45;
            if (r8.length != 1) goto L45;
            if (r6 == r8[0]) goto L43;
            r1 = false;
        L43:
            return Boolean.valueOf(r1);
        L45:
            if ("hashCode".equals(r9) == false) goto L52;
            if (r8 == null) goto L50;
            if (r8.length != 0) goto L52;
        L50:
            return Integer.valueOf(System.identityHashCode(r6));
        L52:
            if ("toString".equals(r9) == false) goto L58;
            if (r8 != null) goto L55;
            return "SysPowerKit.SysPowerListenerProxy";
        L55:
            if (r8.length != 0) goto L58;
            return "SysPowerKit.SysPowerListenerProxy";
        L58:
            return null;
        }
    }

    public static class b {
        public static final SysPowerKit a = null;

        static {
            a = new SysPowerKit(null);
        }
    }

    public interface c {
        void a(int r1, int r2, Bundle r3);
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public synchronized void removePowerListener() {
        monitor-enter(this);
        Object r0 = this.mPowerAdvisorInstance;     // Catch: Throwable -> L25
        if (r0 != null) goto L8;
        FLogger.a.i(TAG, "removePowerListener: PowerAdvisor not available, no-op");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L8:
        Object r1 = this.mListenerProxy;     // Catch: Throwable -> L25
        if (r1 != null) goto L30;
        FLogger.a.i(TAG, "removePowerListener: no listener registered");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L30:
        this.mRemovePowerListenerMethod.invoke(r0, new Object[]{r1});     // Catch: Throwable -> L17
        FLogger.a.i(TAG, "removePowerListener: listener removed");     // Catch: Throwable -> L17
    L15:
        this.mExternalListener = null;     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        FLogger.a.w(TAG, "removePowerListener : failed to remove PowerListener", th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.mExternalListener = null;     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private Object createListenerProxy() {
        Class<?> r0 = this.mPowerListenerInterface;
        if (r0 == null) goto L7;
        a r1 = new a(this);
        return Proxy.newProxyInstance(r0.getClassLoader(), new Class[]{this.mPowerListenerInterface}, r1);
    L7:
        throw new IllegalStateException("PowerListener interface not initialized");
    }

    private void ensureInitialized() {
        this.mPowerAdvisorClass = INVOKESTATIC_com_obric_systemopt_SysPowerKit_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(CLASS_POWER_ADVISOR);     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mPowerListenerInterface = INVOKESTATIC_com_obric_systemopt_SysPowerKit_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(CLASS_POWER_LISTENER);     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mGetInstanceMethod = this.mPowerAdvisorClass.getMethod("getInstance", new Class[0]);     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mAddPowerListenerMethod = this.mPowerAdvisorClass.getMethod("addPowerListener", new Class[]{Context.class, this.mPowerListenerInterface, Integer.TYPE});     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mRemovePowerListenerMethod = this.mPowerAdvisorClass.getMethod("removePowerListener", new Class[]{this.mPowerListenerInterface});     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mApplyResourceUseMethod = this.mPowerAdvisorClass.getMethod("applyResourceUse", new Class[]{Context.class, String.class, Long.TYPE, String.class});     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mUnApplyResourceUseMethod = this.mPowerAdvisorClass.getMethod("unApplyResourceUse", new Class[]{Context.class, String.class});     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mPowerAdvisorInstance = this.mGetInstanceMethod.invoke(null, new Object[0]);     // Catch: Throwable -> L5 ClassNotFoundException -> L7
    L12:
        return;
    L7:
        FLogger.a.i(TAG, "ensureInitialized: PowerAdvisor not found, SDK will be no-op");
        return;
    L5:
        th = move-exception;
        FLogger.a.w(TAG, "ensureInitialized: unexpected error during reflection init", th);
    }

    private SysPowerKit() {
        ensureInitialized();
    }

    public static SysPowerKit getInstance() {
        return b.a;
    }

    public /* synthetic */ SysPowerKit(a r1) {
        this();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_systemopt_SysPowerKit_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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

    public boolean unApplyResourceUse(Context r7, String r8) {
        if (this.mPowerAdvisorInstance != null) goto L6;
        FLogger.a.i(TAG, "unApplyResourceUse: PowerAdvisor not available, no-op");
        return false;
    L6:
        if (r7 != null) goto L10;
        FLogger.a.w(TAG, "unApplyResourceUse: context is null");
        return false;
    L10:
        if (TextUtils.isEmpty(r8) == false) goto L24;
        FLogger.a.w(TAG, "unApplyResourceUse: targetPackageName is empty");
        return false;
    L24:
        boolean r9 = true;
        Object r1 = this.mUnApplyResourceUseMethod.invoke(this.mPowerAdvisorInstance, new Object[]{r7, r8});     // Catch: Throwable -> L21
        if ((r1 instanceof Boolean) == true) goto L16;
    L18:
        r9 = false;
    L19:
        FLogger.a.i(TAG, "unApplyResourceUse: target=" + r8 + ", result=" + r9);     // Catch: Throwable -> L21
        return r9;
    L16:
        if (((Boolean) r1).booleanValue() == false) goto L18;
    L21:
        th = move-exception;
        FLogger.a.w(TAG, "failed to call unApplyResourceUse", th);
        return false;
    }

    private void handlePowerReport(int r3, int r4, Bundle r5) {
        c r0 = this.mExternalListener;
        if (r0 != null) goto L6;
        FLogger.a.i(TAG, "handlePowerReport: no external listener, type=" + r3);
        return;
    L6:
        if (r5 != null) goto L14;
        FLogger.a.w(TAG, "handlePowerReport: extra is null, type=" + r3);
        return;
    L14:
        r0.a(r3, r4, r5);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        FLogger.a.w(TAG, "handlePowerReport: failed to dispatch to external listener", th);
    }

    public void addPowerListener(Context r7, int r8, c r9) {
        if (this.mPowerAdvisorInstance != null) goto L6;
        FLogger.a.i(TAG, "addPowerListener: PowerAdvisor not available, no-op");
        return;
    L6:
        if (r7 != null) goto L9;
        FLogger.a.w(TAG, "addPowerListener: context is null");
        return;
    L9:
        if (r9 != null) goto L12;
        FLogger.a.w(TAG, "addPowerListener: listener is null");
        return;
    L12:
        if (r8 != 0) goto L16;
        FLogger.a.i(TAG, "addPowerListener: no type selected, ignore");
        return;
    L16:
        if (this.mExternalListener == null) goto L20;
        FLogger.a.w(TAG, "addPowerListener: has already done");
        return;
    L20:
        if (this.mListenerProxy != null) goto L34;
        this.mListenerProxy = createListenerProxy();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        FLogger.a.w(TAG, "addPowerListener: failed to create listener proxy", th);
        return;
    L34:
        this.mAddPowerListenerMethod.invoke(this.mPowerAdvisorInstance, new Object[]{r7, this.mListenerProxy, Integer.valueOf(r8)});     // Catch: Throwable -> L29
        FLogger.a.i(TAG, "addPowerListener: typeMask=" + r8);     // Catch: Throwable -> L29
        this.mExternalListener = r9;
        return;
    L29:
        th = move-exception;
        FLogger.a.w(TAG, "addPowerListener: failed to add PowerListener", th);
    }

    public static /* synthetic */ void access$200(SysPowerKit r0, int r1, int r2, Bundle r3) {
        r0.handlePowerReport(r1, r2, r3);
    }

    public boolean applyResourceUse(Context r7, String r8, long r9, String r11) {
        if (this.mPowerAdvisorInstance != null) goto L6;
        FLogger.a.i(TAG, "applyResourceUse: PowerAdvisor not available, no-op");
        return false;
    L6:
        if (r7 != null) goto L10;
        FLogger.a.w(TAG, "applyResourceUse: context is null");
        return false;
    L10:
        if (TextUtils.isEmpty(r8) == false) goto L14;
        FLogger.a.w(TAG, "applyResourceUse: targetPackageName is empty");
        return false;
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L28;
        FLogger.a.w(TAG, "applyResourceUse: reason is empty");
        return false;
    L28:
        boolean r10 = true;
        Object r12 = this.mApplyResourceUseMethod.invoke(this.mPowerAdvisorInstance, new Object[]{r7, r8, Long.valueOf(r9), r11});     // Catch: Throwable -> L25
        if ((r12 instanceof Boolean) == true) goto L20;
    L22:
        r10 = false;
    L23:
        FLogger.a.i(TAG, "applyResourceUse: target=" + r8 + ", result=" + r10);     // Catch: Throwable -> L25
        return r10;
    L20:
        if (((Boolean) r12).booleanValue() == false) goto L22;
    L25:
        th = move-exception;
        FLogger.a.w(TAG, "failed to call applyResourceUse", th);
        return false;
    }
}
