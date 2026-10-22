package com.obric.assistant.system;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lha.a;
import lha.b;
import lha.c;
import lha.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0002J\u001c\u0010!\u001a\u00020\b2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010$\u001a\u00020\rH\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\bH\u0003J\b\u0010)\u001a\u00020*H\u0003J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020'H\u0002J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\n2\u0006\u0010,\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/assistant/system/DeviceLockedStateServiceImpl;", "Lcom/obric/assistant/system/IDeviceLockedStateService;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/system/IDeviceLockedStateListener;", "stateLock", "", "hasInit", "", "deviceLockedStateListener", "deviceLockedStateListenerBinder", "Landroid/os/IBinder;", "keyGuardManager", "Landroid/app/KeyguardManager;", "getKeyGuardManager", "()Landroid/app/KeyguardManager;", "keyGuardManager$delegate", "Lkotlin/Lazy;", "isDeviceLocked", "deviceLockedTime", "", "init", "", "getDeviceLockedTime", "registerDeviceLockedStateListener", "listener", "unregisterDeviceLockedStateListener", "registerSystemDeviceLockedStateListener", "findRegisterDeviceLockedStateListenerMethod", "Ljava/lang/reflect/Method;", "trustManager", "createDeviceLockedStateListener", "listenerClass", "Ljava/lang/Class;", "binder", "createDeviceLockedStateListenerBinder", "listenerDescriptor", "", "getTrustManager", "resolveDeviceId", "", "refreshDeviceLockedState", "reason", "updateDeviceLockedState", "currentState", "queryDeviceLockedState", "fallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceLockedStateServiceImpl implements IDeviceLockedStateService {
    public static final /* synthetic */ int h = 0;
    public final CopyOnWriteArrayList<d> a;
    public final Object b;
    public volatile boolean c;
    public volatile Object d;
    public final Lazy e;
    public volatile boolean f;
    public volatile long g;

    static {
    }

    public final int g() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        Field r2 = d().getClass().getDeclaredField("mContext");     // Catch: Throwable -> L20
        r2.setAccessible(true);     // Catch: Throwable -> L20
        Object r3 = r2.get(d());     // Catch: Throwable -> L20
        Integer r4 = null;
        if ((r3 instanceof Context) == false) goto L6;
        Context r5 = (Context) r3;     // Catch: Throwable -> L20
    L7:
        if (r5 == null) goto L11;
        Method r6 = r5.getClass().getMethod("getDeviceId", new Class[0]);     // Catch: Throwable -> L20
        if (r6 == null) goto L11;
        Object r7 = r6.invoke(r5, new Object[0]);     // Catch: Throwable -> L20
    L13:
        if ((r7 instanceof Integer) == false) goto L15;
        r4 = (Integer) r7;     // Catch: Throwable -> L20
    L15:
        if (r4 == null) goto L17;
        int r8 = r4.intValue();     // Catch: Throwable -> L20
    L18:
        Object r9 = Result.constructor-impl(Integer.valueOf(r8));     // Catch: Throwable -> L20
    L22:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L26;
        FLogger.a.w("DeviceLockedStateService", "resolveDeviceId failed: " + r10.getMessage(), r10);
    L26:
        if (Result.isFailure-impl(r9) == false) goto L29;
        r9 = 0;
    L29:
        return ((Number) r9).intValue();
    L17:
        r8 = 0;
    L11:
        r7 = null;
        goto L13
    L6:
        r5 = null;
    L20:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public final KeyguardManager d() {
        return (KeyguardManager) this.e.getValue();
    }

    public final Object e() {
        Object r0 = AppHost.a.getApplication().getSystemService("trust");
        if (r0 == null) goto L5;
        return r0;
    L5:
        Field r1 = d().getClass().getDeclaredField("mTrustManager");
        r1.setAccessible(true);
        Object r2 = r1.get(d());
        if (r2 == null) goto L9;
        return r2;
    L9:
        throw new IllegalStateException("TrustManager is null".toString());
    }

    public final void init() {
        if (this.c == false) goto L6;
        FLogger.a.i("DeviceLockedStateService", "init ignored, already initialized");
        return;
    L6:
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L8:
        if (this.c == false) goto L10;
        boolean r0 = false;
    L12:
        monitor-exit(this);
        if (r0 == true) goto L15;
        return;
    L15:
        FLogger r1 = FLogger.a;
        r1.i("DeviceLockedStateService", "init");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
        Object r6 = e();     // Catch: Throwable -> L21
        Method r7 = c(r6);     // Catch: Throwable -> L21
        Class r8 = (Class) ArraysKt.first(r7.getParameterTypes());     // Catch: Throwable -> L21
        String r9 = r8.getName();     // Catch: Throwable -> L21
        if (StringsKt.isBlank(r9) == false) goto L19;
        r9 = "com.android.internal.policy.IDeviceLockedStateListener";
    L19:
        final c r10 = new c(r9, this);     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L21
        Object r11 = Proxy.newProxyInstance(r8.getClassLoader(), new Class[]{r8}, new b(this, r10));     // Catch: Throwable -> L21
        int r12 = g();     // Catch: Throwable -> L21
        r7.invoke(r6, new Object[]{r11, Integer.valueOf(r12)});     // Catch: Throwable -> L21
        this.d = r11;     // Catch: Throwable -> L21
        r1.i("DeviceLockedStateService", "registerDeviceLockedStateListener success, method=" + r7 + ", deviceId=" + r12);     // Catch: Throwable -> L21
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L26;
        FLogger.a.w("DeviceLockedStateService", "registerDeviceLockedStateListener failed: " + r3.getMessage(), r3);
    L26:
        boolean r4 = f(this.f);
        FLogger.a.i("DeviceLockedStateService", "refreshDeviceLockedState reason=init, currentState=" + r4);
        h(r4, "init");
        return;
    L21:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L10:
        this.c = true;     // Catch: Throwable -> L28
        r0 = true;
        goto L12
    }

    public DeviceLockedStateServiceImpl() {
        this.a = new CopyOnWriteArrayList();
        this.b = new Object();
        this.e = LazyKt.lazy(new a());
        boolean r0 = f(false);
        FLogger.a.i("DeviceLockedStateService", "init isDeviceLocked=" + r0);
        this.f = r0;
        if (this.f == false) goto L5;
        long r1 = AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000);
    L6:
        this.g = r1;
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final long b() {
        return this.g;
    }

    public final boolean isDeviceLocked() {
        return this.f;
    }

    public static Method c(Object r8) {
        Method[] r0 = r8.getClass().getMethods();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        Method r4 = r0[r3];
        if (Intrinsics.areEqual(r4.getName(), "registerDeviceLockedStateListener") == true) goto L7;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == true) goto L16;
        r3 = r3 + 1;
    L16:
        if (r4 == null) goto L19;
        return r4;
    L19:
        throw new IllegalStateException("method registerDeviceLockedStateListener not found in ".concat(r8.getClass().getName()).toString());
    L7:
        if (r4.getParameterTypes().length != 2) goto L11;
        r6 = true;
        if (Intrinsics.areEqual(r4.getParameterTypes()[1], Integer.TYPE) == false) goto L11;
    L15:
        r4 = null;
        goto L16
    }

    public final void a(ClearContextInKeyguardServiceImpl.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.addIfAbsent(r2);
    }

    public final boolean f(boolean r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT < 22) goto L5;
        boolean r1 = d().isDeviceLocked();     // Catch: Throwable -> L8
    L6:
        Object r2 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L15;
        FLogger.a.w("DeviceLockedStateService", "queryDeviceLockedState failed: " + r3.getMessage(), r3);
        r2 = Boolean.valueOf(r5);
    L15:
        return ((Boolean) r2).booleanValue();
    L5:
        r1 = d().isKeyguardLocked();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void h(boolean r9, String r10) {
        Object r2 = this.b;
        monitor-enter(r2);
        boolean r3 = this.f;     // Catch: Throwable -> L27
        if (r9 != r3) goto L7;
        FLogger.a.i("DeviceLockedStateService", "deviceLockedStateUnchanged reason=" + r10 + ", state=" + r9);     // Catch: Throwable -> L27
        boolean r11 = false;
    L12:
        monitor-exit(r2);
        if (r11 == true) goto L15;
        return;
    L15:
        Iterator<d> r12 = this.a.iterator();
    L17:
        if (r12.hasNext() == false) goto L26;
        d r0 = r12.next();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        r0.onChange(r9);     // Catch: Throwable -> L21
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L17;
        FLogger.a.w("DeviceLockedStateService", "notifyDeviceLockedStateChanged failed: " + r5.getMessage(), r5);
    L21:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L26:
        return;
    L7:
        this.f = r9;     // Catch: Throwable -> L27
        if (r9 == false) goto L10;
        this.g = AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000);     // Catch: Throwable -> L27
    L10:
        FLogger.a.i("DeviceLockedStateService", "deviceLockedStateChanged reason=" + r10 + ", previous=" + r3 + ", current=" + r9);     // Catch: Throwable -> L27
        r11 = true;
    L27:
        th = move-exception;
        throw th;
    }
}
