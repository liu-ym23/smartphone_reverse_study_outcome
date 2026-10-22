package com.obric.aikernel.middleware.impl.tracker;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.c;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.ChargingStateListener;
import com.obric.aikernel.middleware.api.appcontext.receiver.e;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.multiproc.MultiProcBridge;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.runtime.utils.a;
import com.obric.aikernel.utils.AppUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import u7.b;

/* JADX INFO: loaded from: classes2.dex */
public final class TrackerImpl implements ITrackerApi {
    public static final TrackerImpl INSTANCE = null;
    private static volatile String cachedProcessName;
    private static final CopyOnWriteArraySet<b> trackIntercept = null;

    static {
        INSTANCE = new TrackerImpl();
        trackIntercept = new CopyOnWriteArraySet();
    }

    private TrackerImpl() {
    }

    public static final /* synthetic */ String access$queryProcessName(TrackerImpl r10) {
        return r10.queryProcessName();
    }

    private final JSONObject appendCommonParams(JSONObject r10) {
        if (r10 != null) goto L4;
        r10 = new JSONObject();
    L4:
        String r11 = "";
        if (r10.has("aik_network_type") == true) goto L18;
        TrackerImpl$appendCommonParams$1$1 r12 = TrackerImpl$appendCommonParams$1$1.INSTANCE;
        String r13 = AppUtils.f5573a.b();     // Catch: RuntimeException -> L9
    L15:
        r10.put("aik_network_type", r13);
    L9:
        e = move-exception;
        if (a.a(e) == false) goto L16;
        if (r12 == null) goto L14;
        r12.invoke(e);
    L14:
        r13 = "";
        goto L15
    L16:
        throw e;
    L18:
        if (r10.has("sys_elapsed_mills") == true) goto L20;
        r10.put("sys_elapsed_mills", SystemClock.elapsedRealtime());
    L20:
        boolean r14 = false;
        if (r10.has("screen_on") == true) goto L34;
        TrackerImpl$appendCommonParams$1$3 r15 = TrackerImpl$appendCommonParams$1$3.INSTANCE;
        boolean r16 = e.f4540a.d();     // Catch: RuntimeException -> L25
    L31:
        r10.put("screen_on", r16);
    L25:
        e = move-exception;
        if (a.a(e) == false) goto L32;
        if (r15 == null) goto L30;
        r15.invoke(e);
    L30:
        r16 = false;
        goto L31
    L32:
        throw e;
    L34:
        if (r10.has("post_charging") == true) goto L46;
        TrackerImpl$appendCommonParams$1$5 r17 = TrackerImpl$appendCommonParams$1$5.INSTANCE;
        r14 = ChargingStateListener.f4508a.e();     // Catch: RuntimeException -> L38
    L43:
        r10.put("post_charging", r14);
    L38:
        e = move-exception;
        if (a.a(e) == false) goto L44;
        if (r17 == null) goto L43;
        r17.invoke(e);
        goto L43
    L44:
        throw e;
    L46:
        if (r10.has("os_device_id") == true) goto L59;
        TrackerImpl$appendCommonParams$1$7 r18 = TrackerImpl$appendCommonParams$1$7.INSTANCE;
        String r19 = AppContext.INSTANCE.getServerDeviceId();     // Catch: RuntimeException -> L50
    L56:
        r10.put("os_device_id", r19);
    L50:
        e = move-exception;
        if (a.a(e) == false) goto L57;
        if (r18 == null) goto L55;
        r18.invoke(e);
    L55:
        r19 = "";
        goto L56
    L57:
        throw e;
    L59:
        if (r10.has("process_name") == true) goto L72;
        TrackerImpl$appendCommonParams$1$9 r20 = TrackerImpl$appendCommonParams$1$9.INSTANCE;
        String r21 = INSTANCE.resolveCachedProcessName(TrackerImpl$appendCommonParams$1$10$1.INSTANCE);     // Catch: RuntimeException -> L63
    L69:
        r10.put("process_name", r21);
    L63:
        e = move-exception;
        if (a.a(e) == false) goto L70;
        if (r20 == null) goto L68;
        r20.invoke(e);
    L68:
        r21 = "";
        goto L69
    L70:
        throw e;
    L72:
        if (r10.has("build_info") == true) goto L84;
        TrackerImpl$appendCommonParams$1$11 r22 = TrackerImpl$appendCommonParams$1$11.INSTANCE;
        r11 = AppContext.INSTANCE.getBuildInfo();     // Catch: RuntimeException -> L76
    L81:
        r10.put("build_info", r11);
    L76:
        e = move-exception;
        if (a.a(e) == false) goto L82;
        if (r22 == null) goto L81;
        r22.invoke(e);
        goto L81
    L82:
        throw e;
    L84:
        if (r10.has("product") == true) goto L86;
        r10.put("product", Build.PRODUCT);
    L86:
        return r10;
    }

    @JvmStatic
    public static final TrackerImpl getInst() {
        return INSTANCE;
    }

    private final String queryProcessName() {
        C03511 r10 = C03511.INSTANCE;
        int r11 = Process.myPid();     // Catch: RuntimeException -> L25
        Object r12 = AppContext.INSTANCE.getContext().getSystemService("activity");     // Catch: RuntimeException -> L25
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: RuntimeException -> L25
        List<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r12).getRunningAppProcesses();     // Catch: RuntimeException -> L25
        String r14 = null;
        if (r13 == null) goto L16;
        Intrinsics.checkNotNullExpressionValue(r13, "runningAppProcesses");     // Catch: RuntimeException -> L25
        Iterator<T> r15 = r13.iterator();     // Catch: RuntimeException -> L25
    L7:
        if (r15.hasNext() == false) goto L14;
        Object r16 = r15.next();     // Catch: RuntimeException -> L25
        if (((ActivityManager.RunningAppProcessInfo) r16).pid != r11) goto L11;
        boolean r17 = true;
    L12:
        if (r17 == false) goto L7;
    L15:
        ActivityManager.RunningAppProcessInfo r18 = (ActivityManager.RunningAppProcessInfo) r16;     // Catch: RuntimeException -> L25
    L17:
        if (r18 == null) goto L19;
        r14 = r18.processName;     // Catch: RuntimeException -> L25
    L19:
        if (r14 == null) goto L39;
        Intrinsics.checkNotNullExpressionValue(r14, "processInfo?.processName…rn@safeCatchDeadSystem \"\"");     // Catch: RuntimeException -> L25
        List r19 = StringsKt.split$default(r14, new String[]{":"}, false, 0, 6, null);     // Catch: RuntimeException -> L25
        if (r19.size() <= 1) goto L40;
        return (String) r19.get(1);
    L40:
        return "";
    L39:
        return "";
    L11:
        r17 = false;
        goto L12
    L14:
        r16 = null;
        goto L15
    L16:
        r18 = null;
    L25:
        e = move-exception;
        if (a.a(e) == false) goto L31;
        if (r10 == null) goto L42;
        r10.invoke(e);
        return "";
    L42:
        return "";
    L31:
        throw e;
    }

    private final String resolveCachedProcessName(Function0<String> r10) {
        String r11 = cachedProcessName;
        boolean r12 = true;
        if (r11 != null) goto L5;
    L13:
        String r13 = r10.invoke();
        if (r13.length() > 0) goto L17;
        r12 = false;
    L17:
        if (r12 == false) goto L19;
        cachedProcessName = r13;
    L19:
        return r13;
    L5:
        if (r11.length() <= 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L11;
        r11 = null;
    L11:
        if (r11 == null) goto L13;
        return r11;
    L7:
        r14 = false;
        goto L8
    }

    private final void sendTrackerData(u7.a r10) {
        onEvent(r10.a(), r10.b());
    }

    public final void clearCachedProcessNameForTest$middleware_impl_release() {
        cachedProcessName = null;
    }

    @Override // com.obric.aikernel.middleware.api.traker.ITrackerApi
    public void flush() {
        com.bytedance.applog.a.c();
    }

    @Override // com.obric.aikernel.middleware.api.traker.ITrackerApi
    public void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        AIKLog.INSTANCE.d(ITrackerApi.TAG, "monitorEvent " + r10 + ", category = " + r11 + ", metric = " + r12 + ", extra = " + r13);
        c.h(r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.middleware.api.traker.ITrackerApi
    public void onEvent(final String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        final JSONObject r12 = appendCommonParams(r11);
        MultiProcBridge.b(MultiProcBridge.f4548a, ITrackerApi.TAG, NotificationCompat.CATEGORY_EVENT, new AnonymousClass1(r10, r12), new AnonymousClass2(r10, r12), null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, u7.a] */
    public final void onEvent(u7.a r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = r10;
        Iterator<T> r12 = trackIntercept.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        b r13 = (b) r12.next();
        u7.a r14 = (u7.a) r11.element;
        if (r14 == null) goto L11;
        ?? r15 = r13.a(r14);
        if (r15 == 0) goto L19;
        r11.element = r15;
        goto L4
    L19:
        return;
    L11:
        return;
    L12:
        u7.a r16 = (u7.a) r11.element;
        if (r16 == null) goto L20;
        sendTrackerData(r16);
        return;
    }

    @Override // com.obric.aikernel.middleware.api.traker.ITrackerApi
    public void registerIntercept(b r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "intercept");
        CopyOnWriteArraySet<b> r12 = trackIntercept;
        if (r11 == false) goto L5;
        r12.add(r10);
        return;
    L5:
        r12.remove(r10);
    }

    public final String resolveCachedProcessNameForTest$middleware_impl_release(Function0<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "resolveProcessName");
        return resolveCachedProcessName(r10);
    }
}
