package com.bytedance.android.live.saas.middleware.alog;

import android.content.Context;
import com.bytedance.android.live.saas.middleware.alog.impl.ALogDefaultImp;
import com.bytedance.android.live.saas.middleware.alog.impl.DebugInfoLog;
import com.bytedance.android.live.saas.middleware.alog.impl.ImportantLog;
import com.bytedance.android.live.saas.middleware.console.Console;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/alog/BDLiveALogSDK;", "", "()V", "TAG", "", "isInternalInit", "", "mLogUtil", "Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;", "getMLogUtil", "()Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;", "setMLogUtil", "(Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;)V", "getProp", "key", "aLogService", "init", "", "context", "Landroid/content/Context;", "debug", "aLogConfig", "Lcom/bytedance/android/live/saas/middleware/alog/ALogConfig;", "initALog", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BDLiveALogSDK {
    public static final BDLiveALogSDK INSTANCE = null;
    public static final String TAG = "BDLiveALogSDK";
    private static volatile boolean isInternalInit;
    private static ILogProtocol mLogUtil;

    private BDLiveALogSDK() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        INSTANCE = new BDLiveALogSDK();
    }

    public final ILogProtocol getMLogUtil() {
        return mLogUtil;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_saas_middleware_alog_BDLiveALogSDK_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    private final void initALog(ILogProtocol r3) {
        Boolean r0 = Boolean.valueOf(isInternalInit);
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isInternalInit == true) goto L7;
        mLogUtil = r3;     // Catch: Throwable -> L10
        isInternalInit = true;     // Catch: Throwable -> L10
        Console.i(TAG, "ALog init success");     // Catch: Throwable -> L10
    L7:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public final void setMLogUtil(ILogProtocol r1) {
        mLogUtil = r1;
    }

    public final String getProp(String r10, ILogProtocol r12) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r12, "aLogService");
        String r2 = "";
        Class r3 = INVOKESTATIC_com_bytedance_android_live_saas_middleware_alog_BDLiveALogSDK_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L12
        Object r4 = r3.getDeclaredMethod("get", new Class[]{String.class}).invoke(r3, new Object[]{r10});     // Catch: Exception -> L12
        if (r4 == null) goto L11;
        String r5 = (String) r4;     // Catch: Exception -> L12
        r12.d(TAG, "key is:" + r10 + " prop is: " + r5);     // Catch: Exception -> L8
        return r5;
    L8:
        e = e;
        r2 = r5;
    L13:
        r12.e(TAG, "read the content of build.prop exception.", e);
        return r2;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L12
    L12:
        e = e;
        goto L13
    }

    public final void init(Context r2, boolean r3, ALogConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "aLogConfig");
        ILogProtocol r5 = new ImportantLog(new ALogDefaultImp(r3, r2));
        if (Intrinsics.areEqual(getProp("debug.ttlive.debug.enable", r5), "true") == false) goto L5;
        r5 = new DebugInfoLog(r5);
    L5:
        initALog(r5);
    }
}
