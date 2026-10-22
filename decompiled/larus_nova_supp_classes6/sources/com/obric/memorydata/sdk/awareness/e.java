package com.obric.memorydata.sdk.awareness;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.capabilitykit.PackageUtils;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.ResultCallback;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.ohr.OhrHandStateBridge$listener$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public static final e a = null;
    public static volatile IContextAwarenessService b;
    public static volatile h c;
    public static IBinder d;
    public static IBinder.DeathRecipient e;
    public static final List<ResultCallback<Boolean>> f = null;
    public static volatile Context g;
    public static volatile int h;
    public static final ConcurrentHashMap<String, Set<j<?>>> i = null;
    public static final ConcurrentHashMap<String, IFeatureChangeListener> j = null;
    public static final ConcurrentHashMap<String, Set<i>> k = null;
    public static final ConcurrentHashMap<String, IEventChangeListener> l = null;
    public static final ConcurrentHashMap<b, Set<k>> m = null;
    public static final ConcurrentHashMap<b, IFeatureDurationListener> n = null;

    public static final class a {
        public final Context a;
        public final ServiceConnection b;
        public final IBinder c;
        public final IBinder.DeathRecipient d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Context r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
            IBinder r4 = this.c;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            IBinder.DeathRecipient r7 = this.d;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "BindingSnapshot(context=" + this.a + ", connection=" + this.b + ", binder=" + this.c + ", deathRecipient=" + this.d + ')';
        }

        public final Context getContext() {
            return this.a;
        }

        public a(Context r2, ServiceConnection r3, IBinder r4, IBinder.DeathRecipient r5) {
            Intrinsics.checkNotNullParameter(r3, "connection");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public e() {
    }

    public final synchronized void g() {
        monitor-enter(this);
        tka.c.a("release ContextAwarenessService");     // Catch: Throwable -> L8
        a r1 = i(null, null);     // Catch: Throwable -> L8
        b = null;     // Catch: Throwable -> L8
        c = null;     // Catch: Throwable -> L8
        d = null;     // Catch: Throwable -> L8
        e = null;     // Catch: Throwable -> L8
        g = null;     // Catch: Throwable -> L8
        List<ResultCallback<Boolean>> r0 = f;     // Catch: Throwable -> L8
        List r2 = CollectionsKt.toList(r0);     // Catch: Throwable -> L8
        ((ArrayList) r0).clear();     // Catch: Throwable -> L8
        a(r2, 404, "ContextAwarenessService released");     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        pka.b.a(new com.obric.memorydata.sdk.awareness.a(r1));     // Catch: Throwable -> L8
        pka.b.a(new b(r1));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        a = new e();
        f = new ArrayList();
        h = 64;
        i = new ConcurrentHashMap();
        j = new ConcurrentHashMap();
        k = new ConcurrentHashMap();
        l = new ConcurrentHashMap();
        m = new ConcurrentHashMap();
        n = new ConcurrentHashMap();
    }

    public static boolean e(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ServiceInfo r1 = h(r5);
        boolean r2 = false;
        if (r1 != null) goto L5;
        return false;
    L5:
        int r3 = tka.a.a;
        ComponentName r4 = new ComponentName(r1.packageName, r1.name);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "componentName");
        PackageManager r6 = r5.getPackageManager();
        Intrinsics.checkNotNull(r6);
        String r0 = r4.getPackageName();
        Intrinsics.checkNotNullParameter(r6, "pm");
        Intrinsics.checkNotNullParameter(r0, "packageName");
        boolean r7 = !r6.getApplicationInfo(r0, 0).enabled;
    L9:
        if (r7 == true) goto L35;
        int r8 = r6.getComponentEnabledSetting(r4);
        if (r8 == 0) goto L26;
        if (r8 != 1) goto L36;
        return true;
    L36:
        return false;
    L26:
        boolean r9 = r6.getActivityInfo(r4, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L18 Exception -> L25
    L17:
        r2 = r9;
        return r2;
    L18:
        r9 = r6.getServiceInfo(r4, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L20 Exception -> L25
    L20:
        r9 = r6.getReceiverInfo(r4, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L22 Exception -> L25
    L22:
        r9 = r6.getProviderInfo(r4, 0).enabled;     // Catch: Exception -> L25
    L37:
        return r2;
    L35:
        return false;
    L8:
        r7 = true;
        goto L9
    }

    public static ServiceInfo h(Context r5) {
        Iterator<T> r6 = r5.getPackageManager().queryIntentServices(new Intent("com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE").setPackage(PackageUtils.NOVA_PKG_NAME), 0).iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Object r0 = r6.next();
        ServiceInfo r4 = ((ResolveInfo) r0).serviceInfo;
        if (r4 != null) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == false) goto L4;
    L14:
        ResolveInfo r1 = (ResolveInfo) r0;
        if (r1 != null) goto L17;
        return null;
    L17:
        return r1.serviceInfo;
    L8:
        if (Intrinsics.areEqual(r4.packageName, PackageUtils.NOVA_PKG_NAME) == false) goto L10;
        r7 = true;
        goto L11
    L13:
        r0 = null;
        goto L14
    }

    public static boolean l(e r6) {
        r6.getClass();
        long r0 = System.currentTimeMillis();
    L4:
        if (b != null) goto L12;
        if ((System.currentTimeMillis() - r0) >= 10000) goto L12;
        Thread.sleep(50);     // Catch: InterruptedException -> L10
    L12:
        if (b == null) goto L14;
        return true;
    L14:
        return false;
    }

    public final <T> MemoryResponse<T> b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "featureName");
        Context r0 = g;
        if (r0 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", 4);
    L7:
        if (e(r0) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", 4);
    L11:
        if (b != null) goto L29;
        if (l(this) == true) goto L29;
        return new MemoryResponse(406, "Bind service timeout", 4);
    L29:
        IContextAwarenessService r2 = b;     // Catch: RemoteException -> L26
        Intrinsics.checkNotNull(r2);     // Catch: RemoteException -> L26
        MemoryResponse<T> r7 = r2.getFeature(r6);     // Catch: RemoteException -> L26
        if (r7 != null) goto L22;
        return new MemoryResponse(400, "Response is null", 4);
    L22:
        if (r7.a() == false) goto L25;
        return r7;
    L25:
        return new MemoryResponse(r7.a, r7.b, 4);
    L26:
        e = move-exception;
        e.printStackTrace();
        return new MemoryResponse(400, "RemoteException: " + e.getMessage(), 4);
    }

    public final MemoryResponse f(OhrHandStateBridge$listener$1 r13) {
        Intrinsics.checkNotNullParameter("ohr_hand", "featureName");
        Intrinsics.checkNotNullParameter(r13, "listener");
        Context r1 = g;
        if (r1 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", 4);
    L7:
        if (e(r1) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", 4);
    L11:
        if (b == null) goto L13;
    L16:
        ConcurrentHashMap<String, Set<j<?>>> r2 = i;
        Set<j<?>> r4 = r2.get("ohr_hand");
        if (r4 != null) goto L22;
        r4 = new LinkedHashSet();
        Set<j<?>> r3 = r2.putIfAbsent("ohr_hand", r4);
        if (r3 == null) goto L22;
        r4 = r3;
    L22:
        Set<j<?>> r5 = r4;
        r5.add(r13);
        ConcurrentHashMap<String, IFeatureChangeListener> r6 = j;
        boolean r7 = false;
        if (r6.containsKey("ohr_hand") == true) goto L25;
        IFeatureChangeListener r8 = new ContextAwareness.registerFeature.remoteListener.1();
        IContextAwarenessService r9 = b;     // Catch: RemoteException -> L47
        if (r9 == null) goto L30;
        MemoryResponse r10 = r9.registerFeature("ohr_hand", r8);     // Catch: RemoteException -> L47
    L31:
        if (r10 != null) goto L33;
    L35:
        if (r7 == false) goto L37;
        r6.put("ohr_hand", r8);     // Catch: RemoteException -> L47
        return new MemoryResponse(r10.a, r10.b, 4);
    L37:
        tka.c.b("ContextAwareness", "registerFeature ohr_hand failed, featureName: ", null);     // Catch: RemoteException -> L47
        r5.remove(r13);     // Catch: RemoteException -> L47
        if (r10 == null) goto L40;
        int r11 = r10.a;     // Catch: RemoteException -> L47
    L41:
        if (r10 == null) goto L44;
        String r12 = r10.b;     // Catch: RemoteException -> L47
        if (r12 == null) goto L44;
    L52:
        return new MemoryResponse(r11, r12, 4);
    L44:
        r12 = "registerFeature return null";
        goto L52
    L40:
        r11 = 400;
        goto L41
    L33:
        if (r10.a() != true) goto L35;
        r7 = true;
        goto L35
    L30:
        r10 = null;
    L47:
        e = move-exception;
        e.printStackTrace();
        tka.c.b("ContextAwareness", "registerFeature failed", e);
        r5.remove(r13);
        return new MemoryResponse(400, e.getMessage(), 4);
    L25:
        return new MemoryResponse(0, null, 6);
    L13:
        if (l(this) == true) goto L16;
        return new MemoryResponse(406, "Bind service timeout", 4);
    }

    public final MemoryResponse j(OhrHandStateBridge$listener$1 r5) {
        Intrinsics.checkNotNullParameter("ohr_hand", "featureName");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Context r0 = g;
        if (r0 != null) goto L7;
        return new MemoryResponse(404, "Context is null, please call init first", 4);
    L7:
        if (e(r0) == true) goto L11;
        return new MemoryResponse(407, "ContextAwarenessService is disabled", 4);
    L11:
        if (b == null) goto L13;
    L16:
        Set<j<?>> r1 = i.get("ohr_hand");
        if (r1 == null) goto L19;
        r1.remove(r5);
    L19:
        Set<j<?>> r2 = r1;
        if (r2 != null) goto L22;
    L25:
        boolean r3 = true;
    L26:
        MemoryResponse r4 = null;
        if (r3 == false) goto L39;
        IFeatureChangeListener r6 = j.remove("ohr_hand");
        if (r6 == null) goto L39;
        IContextAwarenessService r7 = b;     // Catch: RemoteException -> L35
        if (r7 == null) goto L33;
        r4 = r7.unregisterFeature("ohr_hand", r6);     // Catch: RemoteException -> L35
    L33:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.memorydata.sdk.MemoryResponse<java.lang.Void>");     // Catch: RemoteException -> L35
        return r4;
    L35:
        e = move-exception;
        e.printStackTrace();
        tka.c.b("ContextAwareness", "unregisterFeature failed", e);
        return new MemoryResponse(400, e.getMessage(), 4);
    L39:
        return new MemoryResponse(0, null, 6);
    L22:
        if (r2.isEmpty() == true) goto L25;
        r3 = false;
        goto L26
    L13:
        if (l(this) == true) goto L16;
        return new MemoryResponse(406, "Bind service timeout", 4);
    }

    public static void c(ServiceConnection r2, IBinder r3) {
        a r4 = i(r2, r3);
        if (r4 != null) goto L5;
        return;
    L5:
        pka.b.a(new com.obric.memorydata.sdk.awareness.a(r4));
        pka.b.a(new b(r4));
        if (g != null) goto L8;
        tka.c.b("ContextAwareness", "Context is null, cannot reconnect.", null);
        return;
    L8:
        new Handler(Looper.getMainLooper()).postDelayed(new d(), InteractorReportInitializer.REPORT_EVENT_DELAY_MS);
    }

    public static a i(ServiceConnection r5, IBinder r6) {
        e r0 = a;
        monitor-enter(r0);
        h r1 = c;     // Catch: Throwable -> L18
        a r2 = null;
        if (r1 == null) goto L16;
        if (r5 == null) goto L10;
        if (r5 != r1) goto L16;
    L10:
        if (r6 != null) goto L12;
    L14:
        a r7 = new a(g, r1, d, e);     // Catch: Throwable -> L18
        b = null;     // Catch: Throwable -> L18
        c = null;     // Catch: Throwable -> L18
        d = null;     // Catch: Throwable -> L18
        e = null;     // Catch: Throwable -> L18
        r2 = r7;
        goto L16
    L12:
        if (r6 == d) goto L14;
    L16:
        monitor-exit(r0);
        return r2;
    L18:
        th = move-exception;
        throw th;
    }

    public static void a(List r2, int r3, String r4) {
        Iterator r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        ResultCallback r0 = (ResultCallback) r5.next();
        if (r3 != 0) goto L8;
        boolean r1 = true;
    L9:
        r0.onResult(r3, r4, Boolean.valueOf(r1));
        goto L4
    L8:
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.os.Bundle, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static Bundle k(Context r21, Uri r22, Bundle r23) {
        ContentResolver r10 = r21.getContentResolver();
        ArrayList r11 = new ArrayList();
        Object[] r12 = {r22};
        f06.b r14 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r5 = r9[r7];
        int r18 = r7;
        int r19 = r8;
        f06.a[] r20 = r9;
        f06.d r4 = r5.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r10, r12, "android.content.ContentProviderClient", r14);     // Catch: Exception -> L41
        if (r4.a == true) goto L12;
        r11.add(r5);     // Catch: Exception -> L41
        goto L14
    L12:
        Bundle r6 = 0;
    L17:
        if (r4.a == false) goto L19;
        ContentProviderClient r0 = (ContentProviderClient) r4.b;
    L20:
        ContentProviderClient r13 = r0;
        if (r13 != 0) goto L44;
        tka.c.d("ContextAwareness", "acquire awareness provider client failed method=report_awareness_event");
        return r6;
    L44:
        Bundle r1 = r13.call("report_awareness_event", r6, r23);     // Catch: Throwable -> L27 Exception -> L29 DeadObjectException -> L33
    L26:
        Bundle r15 = r1;
        r13.close();
        return r15;
    L27:
        th = move-exception;
        r13.close();
        throw th;
    L33:
        e = move-exception;
        tka.b r16 = tka.c.a;     // Catch: Throwable -> L27
        tka.c.b("ContextAwareness", "awareness provider died during call method=report_awareness_event", e);     // Catch: Throwable -> L27
        int r17 = l.a;     // Catch: Throwable -> L27
        r1 = l.a(404, "Provider 进程已死亡，请稍后重试");     // Catch: Throwable -> L27
    L29:
        e = move-exception;
        tka.b r24 = tka.c.a;     // Catch: Throwable -> L27
        tka.c.b("ContextAwareness", "awareness provider call failed method=report_awareness_event", e);     // Catch: Throwable -> L27
        r13.close();
        return r6;
    L19:
        r0 = r10.acquireUnstableContentProviderClient(r22);
    L14:
        r7 = r18 + 1;
        r8 = r19;
        r9 = r20;
        goto L8
    L15:
        r6 = 0;
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static void d(e r7, final Context r8, ResultCallback r9, int r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r10 = 64;
    L9:
        monitor-enter(r7);
        Intrinsics.checkNotNullParameter(r8, "context");     // Catch: Throwable -> L59
        g = r8.getApplicationContext();     // Catch: Throwable -> L59
        h = r10;     // Catch: Throwable -> L59
        Context r2 = g;     // Catch: Throwable -> L59
        boolean r3 = false;
        if (r2 == null) goto L15;
        ApplicationInfo r4 = r2.getApplicationInfo();     // Catch: Throwable -> L59
        if (r4 == null) goto L15;
        int r5 = r4.flags;     // Catch: Throwable -> L59
    L17:
        if ((r5 & 2) == 0) goto L19;
        boolean r6 = true;
    L20:
        tka.b r12 = tka.c.a;     // Catch: Throwable -> L59
        if ((tka.c.a instanceof tka.b) == false) goto L24;
        tka.c.a = new tka.b(r6);     // Catch: Throwable -> L59
    L24:
        if (e(r8) == true) goto L31;
        tka.c.b("ContextAwareness", "ContextAwarenessService is disabled", null);     // Catch: Throwable -> L59
        if (r9 == null) goto L28;
        r9.onResult(407, "ContextAwarenessService is disabled", Boolean.FALSE);     // Catch: Throwable -> L59
    L28:
        monitor-exit(r7);
        return;
    L31:
        if (b == null) goto L37;
        tka.c.a("service already connected");     // Catch: Throwable -> L59
        if (r9 == null) goto L35;
        r9.onResult(0, "ContextAwarenessService is ready", Boolean.TRUE);     // Catch: Throwable -> L59
    L35:
        monitor-exit(r7);
        return;
    L37:
        if (r9 == null) goto L40;
        ((ArrayList) f).add(r9);     // Catch: Throwable -> L59
    L40:
        if (c != null) goto L56;
        c = new h();     // Catch: Throwable -> L59
        ServiceInfo r13 = h(r8);     // Catch: Throwable -> L59
        if (r13 != null) goto L46;
        tka.c.b("ContextAwareness", "No service found for action: com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE in com.larus.nova", null);     // Catch: Throwable -> L59
        c = null;     // Catch: Throwable -> L59
        List<ResultCallback<Boolean>> r14 = f;     // Catch: Throwable -> L59
        List r15 = CollectionsKt.toList(r14);     // Catch: Throwable -> L59
        ((ArrayList) r14).clear();     // Catch: Throwable -> L59
        a(r15, 404, "No service found for action");     // Catch: Throwable -> L59
        monitor-exit(r7);
        return;
    L46:
        final Intent r16 = new Intent("com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE").setPackage(r13.packageName);     // Catch: Throwable -> L59
        final h r17 = c;     // Catch: Throwable -> L59
        if (r17 == null) goto L54;
        final int r18 = r10 | 1;     // Catch: Throwable -> L59
        Boolean r19 = (Boolean) pka.b.a(new c(r8, r16, r17, r18));     // Catch: Throwable -> L59
        if (r19 == null) goto L51;
        r3 = r19.booleanValue();     // Catch: Throwable -> L59
    L51:
        tka.c.a("bindService result: " + r3 + ", flags=" + r18 + ", component=" + r16.getComponent() + ", package=" + r13.packageName);     // Catch: Throwable -> L59
        if (r3 == true) goto L54;
        tka.c.b("ContextAwareness", "bindService failed, package=" + r13.packageName, null);     // Catch: Throwable -> L59
        c = null;     // Catch: Throwable -> L59
        a.getClass();     // Catch: Throwable -> L59
        List<ResultCallback<Boolean>> r20 = f;     // Catch: Throwable -> L59
        List r21 = CollectionsKt.toList(r20);     // Catch: Throwable -> L59
        ((ArrayList) r20).clear();     // Catch: Throwable -> L59
        a(r21, 404, "bindService failed");     // Catch: Throwable -> L59
    L54:
        monitor-exit(r7);
        return;
    L56:
        tka.c.a("service binding in progress, callback queued");     // Catch: Throwable -> L59
        monitor-exit(r7);
        return;
    L19:
        r6 = false;
    L15:
        r5 = 0;
    L59:
        th = move-exception;
        throw th;
    }
}
