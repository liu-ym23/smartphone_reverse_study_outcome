package com.obric.sva.framework.impl.internal;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManagerGlobal;
import android.os.Handler;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.framework.log.AiagentLog;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import una.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0007J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/sva/framework/impl/internal/PowerUpWrapper;", "", "<init>", "()V", "TAG", "", "ACTION_SCREEN_POWER_UP", "ACTION_SCREEN_POWER_DOWN", "POWER_SCREEN_MODE_NORMAL", "", "SCREEN_POWER_UP_DURATION", "", "mPowerUpTimer", "Ljava/util/Timer;", "mPowerUpScreen", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mPowerUpScreenHandler", "Landroid/os/Handler;", "powerUpScreen", "", "context", "Landroid/content/Context;", "packageName", "resetPowerUpMode", "powerDown", "", "startPowerUpTimer", "stopPowerUpTimer", "resetPowerAsync", "powerOff", "setState", "state", "getState", "setHandler", "handler", "impl_release"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PowerUpWrapper {
    public static final String ACTION_SCREEN_POWER_DOWN = "com.obric.assistant.sva.sdk.SCREEN_POWER_DOWN";
    public static final String ACTION_SCREEN_POWER_UP = "com.obric.assistant.sva.sdk.SCREEN_POWER_UP";
    public static final PowerUpWrapper INSTANCE = null;
    public static final int POWER_SCREEN_MODE_NORMAL = 2;
    public static final long SCREEN_POWER_UP_DURATION = 1000;
    public static final String TAG = "PowerUpWrapper";
    private static final AtomicBoolean mPowerUpScreen = null;
    private static Handler mPowerUpScreenHandler;
    private static Timer mPowerUpTimer;

    private PowerUpWrapper() {
    }

    public static /* synthetic */ void a(boolean r0) {
        resetPowerAsync$lambda$0(r0);
    }

    @JvmStatic
    public static final void resetPowerUpMode(boolean r0) {
    }

    static {
        INSTANCE = new PowerUpWrapper();
        mPowerUpScreen = new AtomicBoolean(false);
    }

    public final boolean getState() {
        return mPowerUpScreen.get();
    }

    public final void startPowerUpTimer() {
        AiagentLog.d(TAG, "startPowerUpTimer: enter");
        PthreadTimer r0 = new PthreadTimer("owerUpWrapper");
        mPowerUpTimer = r0;
        r0.schedule(new startPowerUpTimer.1(), 1000);
    }

    public final synchronized void stopPowerUpTimer() {
        monitor-enter(this);
        Timer r1 = mPowerUpTimer;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L10
        r1.cancel();     // Catch: Throwable -> L10
        Timer r2 = mPowerUpTimer;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L10
        AiagentLog.d(TAG, "stopPowerUpTimer: numPurgedTasks= " + r2.purge());     // Catch: Throwable -> L10
    L7:
        mPowerUpTimer = null;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static final void resetPowerAsync$lambda$0(boolean r0) {
        resetPowerUpMode(r0);
    }

    public final void resetPowerAsync(boolean r3) {
        Handler r0 = mPowerUpScreenHandler;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        Handler r1 = mPowerUpScreenHandler;
        if (r1 == null) goto L9;
        r1.post(new a(r3));
        return;
    }

    public final void setHandler(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        mPowerUpScreenHandler = r2;
    }

    public final void setState(boolean r2) {
        mPowerUpScreen.set(r2);
    }

    @JvmStatic
    public static final void powerUpScreen(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "packageName");
        mPowerUpScreen.set(true);     // Catch: Throwable -> L6 IllegalAccessException -> L8 InvocationTargetException -> L11 NoSuchMethodException -> L14
        Intent r2 = new Intent(ACTION_SCREEN_POWER_UP);     // Catch: Throwable -> L6 IllegalAccessException -> L8 InvocationTargetException -> L11 NoSuchMethodException -> L14
        r2.setPackage(r7);     // Catch: Throwable -> L6 IllegalAccessException -> L8 InvocationTargetException -> L11 NoSuchMethodException -> L14
        r6.sendBroadcast(r2);     // Catch: Throwable -> L6 IllegalAccessException -> L8 InvocationTargetException -> L11 NoSuchMethodException -> L14
        DisplayManagerGlobal.class.getMethod("setDisplayPowerMode", new Class[]{Integer.TYPE}).invoke(DisplayManagerGlobal.getInstance(), new Object[]{2});     // Catch: Throwable -> L6 IllegalAccessException -> L8 InvocationTargetException -> L11 NoSuchMethodException -> L14
        AiagentLog.i(TAG, "powerUpScreen end executing");
        INSTANCE.startPowerUpTimer();
        return;
    L6:
        th = move-exception;
        AiagentLog.i(TAG, "powerUpScreen end executing");
        INSTANCE.startPowerUpTimer();
        throw th;
    L8:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L6
    L14:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L6
    }
}
