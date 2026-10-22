package com.obric.memorydata.utils.c;

import android.os.Bundle;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.memory.ObricScenePerceptionCallback;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/utils/framework/ScenePerceptionPlatformProxy;", "", "<init>", "()V", "TAG", "", "cachedMemoryManager", "Lcom/obric/aiagent/product/platform/api/memory/IObricMemoryManager;", "callbacks", "", "", "Lcom/obric/memorydata/utils/framework/ScenePerceptionPlatformProxy$Callback;", "lastPlatformCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricScenePerceptionCallback;", "getMemoryManager", "hasScenePerceptionTransport", "", Ext.KEY_REQUEST, "type", "bundle", "Landroid/os/Bundle;", "registerCallback", "callback", "registerPlatformCallback", "", "memoryManager", "platformCallback", "unregisterCallback", "Callback", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IObricMemoryManager f13203b;
    private static final Map<Integer, a> c = null;
    private static ObricScenePerceptionCallback d;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/utils/framework/ScenePerceptionPlatformProxy$Callback;", "", "onResult", "", "type", "", "extras", "Landroid/os/Bundle;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void onResult(int r1, Bundle r2);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/utils/framework/ScenePerceptionPlatformProxy$registerCallback$platformCallback$1", "Lcom/obric/aiagent/product/platform/api/memory/ObricScenePerceptionCallback;", "onAction", "", "type", "", "extras", "Landroid/os/Bundle;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ObricScenePerceptionCallback {
        b() {
        }

        @Override // com.obric.aiagent.product.platform.api.memory.ObricScenePerceptionCallback
        public void onAction(int r7, Bundle r8) {
            Intrinsics.checkNotNullParameter(r8, "extras");
            c r6 = c.f13202a;
            monitor-enter(r6);
            a r0 = (a) ZeusTransformUtils.preCheckCast(c.a().get(Integer.valueOf(r7)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            monitor-exit(r6);
            if (r0 != null) goto L9;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "ignore scene perception callback, no consumer for type: " + r7, null, 4, null);
            return;
        L9:
            r0.onResult(r7, r8);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
        f13202a = new c();
        c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private c() {
    }

    private static final IObricMemoryManager a(Exception r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "fail to get IObricMemoryManager: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return null;
    }

    public static final /* synthetic */ Map a() {
        return c;
    }

    private final void a(IObricMemoryManager r10, ObricScenePerceptionCallback r11) {
        IObricMemoryManager r9 = (IObricMemoryManager) ZeusTransformUtils.wrapperContextForParams(r10, IObricMemoryManager.class, "com.obric.memorydata.plugin");
        Method[] r12 = r9.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(r12, "getMethods(...)");
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.memorydata.plugin");
        int r1 = r13.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L16;
        Object r5 = r13[r3];
        Method r6 = (Method) ZeusTransformUtils.preCheckCast(r5, Method.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6.getName(), "registerScenePerceptionCallback") == true) goto L8;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == true) goto L17;
        r3 = r3 + 1;
    L17:
        Method r14 = (Method) ZeusTransformUtils.preCheckCast(r5, Method.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L22;
        r14.invoke(r9, new Object[]{r11});
        return;
    L22:
        throw new IllegalStateException("registerScenePerceptionCallback is not supported by runtime SDK/ROM".toString());
    L8:
        if (r6.getParameterTypes().length != 1) goto L12;
        if (ZeusTransformUtils.instanceOf(r6.getParameterTypes()[0], r11) == false) goto L12;
        r7 = true;
        goto L13
    L16:
        r5 = null;
        goto L17
    }

    private final IObricMemoryManager b() {
        IObricMemoryManager r2 = f13203b;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return (IObricMemoryManager) ZeusTransformUtils.preCheckCast(y.a($$Lambda$c$dKUWlDP0eAsOlfMqwImCZHGKRjo.INSTANCE, $$Lambda$c$8XPNkQU33KsHVbDwh7kO99VYAm0.INSTANCE), IObricMemoryManager.class, "com.obric.memorydata.plugin");
    }

    private static final IObricMemoryManager c() {
        IPlatformService r0 = am.f13169a.a();
        if (r0 == null) goto L7;
        IObricMemoryManager r1 = r0.memoryManager();
        if (r1 == null) goto L7;
        f13203b = r1;
        return r1;
    L7:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "IObricMemoryManager is not initialized", null, 4, null);
        return null;
    }

    public static /* synthetic */ IObricMemoryManager lambda$8XPNkQU33KsHVbDwh7kO99VYAm0() {
        return c();
    }

    public static /* synthetic */ IObricMemoryManager lambda$dKUWlDP0eAsOlfMqwImCZHGKRjo(Exception r0) {
        return a(r0);
    }

    public final synchronized boolean a(int r13) {
        monitor-enter(this);
        Map<Integer, a> r0 = c;     // Catch: Throwable -> L48
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.remove(Integer.valueOf(r13)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        boolean r3 = true;
        if ((!r0.isEmpty()) == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "keep shared scene perception callback, removed type: " + r13 + ", remaining: " + r0.keySet(), false, 4, null);     // Catch: Throwable -> L48
        monitor-exit(this);
        return true;
    L9:
        if (d != null) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "unregister scene perception callback ignored, type: " + r13 + ", not registered", false, 4, null);     // Catch: Throwable -> L48
        monitor-exit(this);
        return true;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "unregister scene perception callback, last type: " + r13, false, 4, null);     // Catch: Throwable -> L48
        IObricMemoryManager r2 = b();     // Catch: Throwable -> L48
        if (r2 != null) goto L52;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "unregister scene perception callback error: service not available", null, 4, null);     // Catch: Throwable -> L48
        if (r1 == null) goto L18;
        r0.put(Integer.valueOf(r13), r1);     // Catch: Throwable -> L48
    L18:
        monitor-exit(this);
        return false;
    L52:
        Method[] r5 = r2.getClass().getMethods();     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r5, "getMethods(...)");     // Catch: Throwable -> L41
        Object[] r6 = (Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        int r7 = r6.length;     // Catch: Throwable -> L41
        int r8 = 0;
    L22:
        if (r8 >= r7) goto L35;
        Object r9 = r6[r8];     // Catch: Throwable -> L41
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(r9, Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        if (Intrinsics.areEqual(r10.getName(), "unregisterScenePerceptionCallback") == false) goto L31;
        Class<?>[] r11 = r10.getParameterTypes();     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r11, "getParameterTypes(...)");     // Catch: Throwable -> L41
        if (((Object[]) ZeusTransformUtils.preCheckCast(r11, Object[].class, "com.obric.memorydata.plugin")).length != 0) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == false) goto L31;
        boolean r14 = true;
    L32:
        if (r14 == true) goto L36;
        r8 = r8 + 1;     // Catch: Throwable -> L41
    L36:
        Method r15 = (Method) ZeusTransformUtils.preCheckCast(r9, Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        if (r15 == null) goto L40;
        r15.invoke(r2, new Object[0]);     // Catch: Throwable -> L41
        d = null;     // Catch: Throwable -> L41
    L46:
        monitor-exit(this);
        return r3;
    L40:
        throw new IllegalStateException("unregisterScenePerceptionCallback is not supported by runtime SDK/ROM".toString());     // Catch: Throwable -> L41
    L28:
        r12 = false;
    L31:
        r14 = false;
        goto L32
    L35:
        r9 = null;
    L41:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "unregister scene perception callback error: " + ExceptionsKt.stackTraceToString(th), null, 4, null);     // Catch: Throwable -> L48
        f13203b = null;     // Catch: Throwable -> L48
        if (r1 == null) goto L45;
        c.put(Integer.valueOf(r13), r1);     // Catch: Throwable -> L48
    L45:
        r3 = false;
    L48:
        th = move-exception;
        throw th;
    }

    public final boolean a(int r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r11, "bundle");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "request scene perception, type: " + r10, false, 4, null);
        IObricMemoryManager r9 = b();
        if (r9 != null) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "request scene perception error: service not available", null, 4, null);
        return false;
    L11:
        r9.doScenePerceptionAction(r10, r11);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "request scene perception error: " + ExceptionsKt.stackTraceToString(th), null, 4, null);
        f13203b = null;
        return false;
    }

    public final synchronized boolean a(int r11, a r12) {
        monitor-enter(this);
        a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        boolean r0 = false;
        if (r13 != null) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "register null scene perception callback, type: " + r11 + ", ignore", false, 4, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return false;
    L8:
        Integer r1 = Integer.valueOf(r11);     // Catch: Throwable -> L25
        Map<Integer, a> r2 = c;     // Catch: Throwable -> L25
        r2.put(r1, r13);     // Catch: Throwable -> L25
        if (d == null) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "reuse scene perception callback, type: " + r11 + ", types: " + r2.keySet(), false, 4, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return true;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "register scene perception callback, type: " + r11, false, 4, null);     // Catch: Throwable -> L25
        IObricMemoryManager r3 = b();     // Catch: Throwable -> L25
        if (r3 != null) goto L18;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "register scene perception callback error: service not available", null, 4, null);     // Catch: Throwable -> L25
        r2.remove(Integer.valueOf(r11), r13);     // Catch: Throwable -> L25
        monitor-exit(this);
        return false;
    L18:
        b r4 = new b();     // Catch: Throwable -> L25
        a(r3, (ObricScenePerceptionCallback) ZeusTransformUtils.preCheckCast(r4, ObricScenePerceptionCallback.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        d = (ObricScenePerceptionCallback) ZeusTransformUtils.preCheckCast(r4, ObricScenePerceptionCallback.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r0 = true;
    L23:
        monitor-exit(this);
        return r0;
    L21:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScenePerceptionPlatformProxy", "register scene perception callback error: " + ExceptionsKt.stackTraceToString(th), null, 4, null);     // Catch: Throwable -> L25
        f13203b = null;     // Catch: Throwable -> L25
        c.remove(Integer.valueOf(r11), r13);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
