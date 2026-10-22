package com.obric.aikernel.runtime;

import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.collection.LruCache;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.config.RequestParams;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s7.j;

/* JADX INFO: loaded from: classes2.dex */
public final class AIKModelInterceptManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AIKModelInterceptManager f5301a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5302b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f5303c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HandlerThread f5304d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Handler f5305e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f5306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f5307g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final LruCache<String, ConcurrentHashMap<String, d>> f5308h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final b f5309i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ContentObserver f5310j = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f5313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final j f5314d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d f5315e;

        public a(String r10, String r11, long r12, j r13, d r14) {
            Intrinsics.checkNotNullParameter(r10, "pkgName");
            Intrinsics.checkNotNullParameter(r11, "bizKey");
            Intrinsics.checkNotNullParameter(r13, "quotaConfig");
            Intrinsics.checkNotNullParameter(r14, "state");
            this.f5311a = r10;
            this.f5312b = r11;
            this.f5313c = r12;
            this.f5314d = r13;
            this.f5315e = r14;
        }

        public final String a() {
            return this.f5312b;
        }

        public final String b() {
            return this.f5311a;
        }

        public final j c() {
            return this.f5314d;
        }

        public final long d() {
            return this.f5313c;
        }

        public final d e() {
            return this.f5315e;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.f5311a, r11.f5311a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5312b, r11.f5312b) == true) goto L15;
            return false;
        L15:
            if (this.f5313c == r11.f5313c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f5314d, r11.f5314d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f5315e, r11.f5315e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f5311a.hashCode() * 31) + this.f5312b.hashCode()) * 31) + Long.hashCode(this.f5313c)) * 31) + this.f5314d.hashCode()) * 31) + this.f5315e.hashCode();
        }

        public String toString() {
            return "QuotaScope(pkgName=" + this.f5311a + ", bizKey=" + this.f5312b + ", quotaWindowMs=" + this.f5313c + ", quotaConfig=" + this.f5314d + ", state=" + this.f5315e + ')';
        }
    }

    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = SystemClock.elapsedRealtime();
            Object r11 = AIKModelInterceptManager.c();
            monitor-enter(r11);
            Iterator r12 = AIKModelInterceptManager.b().snapshot().entrySet().iterator();     // Catch: Throwable -> L22
        L6:
            if (r12.hasNext() == false) goto L16;
            Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L22
            String r14 = (String) r13.getKey();     // Catch: Throwable -> L22
            ConcurrentHashMap r15 = (ConcurrentHashMap) r13.getValue();     // Catch: Throwable -> L22
            Set r16 = r15.entrySet();     // Catch: Throwable -> L22
            Intrinsics.checkNotNullExpressionValue(r16, "bizQuotaMap.entries");     // Catch: Throwable -> L22
            Iterator r17 = CollectionsKt.toList(r16).iterator();     // Catch: Throwable -> L22
        L9:
            if (r17.hasNext() == false) goto L6;
            Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L22
            Intrinsics.checkNotNullExpressionValue(r18, "bizEntries");     // Catch: Throwable -> L22
            String r19 = (String) r18.getKey();     // Catch: Throwable -> L22
            d.b r20 = ((d) r18.getValue()).b(r10);     // Catch: Throwable -> L22
            if (r20.b().a() >= 5) goto L12;
            AIKLog.INSTANCE.d(AIKModelInterceptManager.g(), "Cleanup prune quota window: pkg=" + r14 + ", biz=" + r19 + ", removed=" + r20.a() + ", snapshot=" + r20.b());     // Catch: Throwable -> L22
            goto L9
        L12:
            r15.remove(r19);     // Catch: Throwable -> L22
            AIKLog r21 = AIKLog.INSTANCE;     // Catch: Throwable -> L22
            r21.d(AIKModelInterceptManager.g(), "Cleanup remove state: pkg=" + r14 + ", biz=" + r19 + " (continuous empty 5 times)");     // Catch: Throwable -> L22
            if (r15.isEmpty() == false) goto L9;
            AIKModelInterceptManager.b().remove(r14);     // Catch: Throwable -> L22
            r21.d(AIKModelInterceptManager.g(), "Cleanup remove empty bizMap: pkg=" + r14 + " (no active biz)");     // Catch: Throwable -> L22
            goto L9
        L16:
            Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r11);
            if (AIKModelInterceptManager.e().isInterrupted() == true) goto L36;
            AIKModelInterceptManager.d().postDelayed(this, AIKModelInterceptManager.f5301a.j());
            return;
        L36:
            return;
        L22:
            th = move-exception;
            throw th;
        }
    }

    public static final class c extends ContentObserver {
        c() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            AIKModelInterceptManager r11 = AIKModelInterceptManager.f5301a;     // Catch: Settings.SettingNotFoundException -> L4
            AIKModelInterceptManager.h(Settings.Global.getInt(AppContext.INSTANCE.getContext().getContentResolver(), "low_temp_power_level"));     // Catch: Settings.SettingNotFoundException -> L4
        L6:
            AIKLog.INSTANCE.d(AIKModelInterceptManager.g(), "onChange: powerCurrentObserver=" + AIKModelInterceptManager.f());
            return;
        L4:
            e = move-exception;
            AIKModelInterceptManager r12 = AIKModelInterceptManager.f5301a;
            AIKModelInterceptManager.h(-1);
            AIKLog.INSTANCE.e(AIKModelInterceptManager.g(), "onChange: read low_temp_power_level failed", e);
            goto L6
        }
    }

    static {
        AIKModelInterceptManager r10 = new AIKModelInterceptManager();
        f5301a = r10;
        String r11 = r10.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r11, "AIKModelInterceptManager.javaClass.simpleName");
        f5302b = r11;
        f5303c = ((long) AppSettingsManager.INSTANCE.getModelQuotaConfigs().e()) * 1000;
        HandlerThread r12 = new HandlerThread("AIKModelQuotaResetThread");
        r12.start();
        f5304d = r12;
        f5305e = new Handler(r12.getLooper());
        f5306f = -1;
        f5307g = new Object();
        f5308h = new LruCache(100);
        f5309i = new b();
        c r13 = new c();
        f5310j = r13;
        AppContext r14 = AppContext.INSTANCE;     // Catch: Exception -> L5
        r14.getContext().getContentResolver().registerContentObserver(Settings.Global.getUriFor("low_temp_power_level"), false, r13);     // Catch: Exception -> L5
        f5306f = Settings.Global.getInt(r14.getContext().getContentResolver(), "low_temp_power_level");     // Catch: Exception -> L5
    L7:
        f5305e.postDelayed(f5309i, f5303c);
        return;
    L5:
        e = move-exception;
        AIKLog.INSTANCE.e(f5302b, "init powerCurrentObserver error " + e.getMessage() + ", " + ExceptionsKt.stackTraceToString(e));
        goto L7
    }

    private AIKModelInterceptManager() {
    }

    public static /* synthetic */ d a(Function1 r10, Object r11) {
        return m(r10, r11);
    }

    public static final /* synthetic */ LruCache b() {
        return f5308h;
    }

    public static final /* synthetic */ Object c() {
        return f5307g;
    }

    public static final /* synthetic */ Handler d() {
        return f5305e;
    }

    public static final /* synthetic */ HandlerThread e() {
        return f5304d;
    }

    public static final /* synthetic */ int f() {
        return f5306f;
    }

    public static final /* synthetic */ String g() {
        return f5302b;
    }

    public static final /* synthetic */ void h(int r10) {
        f5306f = r10;
    }

    private final a l(y6.b r10, RequestParams r11) {
        if (r10.e().isEmpty() == false) goto L5;
        return null;
    L5:
        s7.d r12 = AppSettingsManager.INSTANCE.getModelQuotaConfigs();
        if (r12.f() == true) goto L8;
        return null;
    L8:
        final String r13 = e8.a.j(r11.getBackend());
        int r14 = r11.getBackend().getInt(IdlKeys.Args_Priority);
        String r15 = com.obric.aikernel.utils.b.a(r11.getBackend());
        String r16 = e8.a.e(r11.getBackend());
        final String r17 = com.obric.aikernel.runtime.c.a(r16, r15, r14);
        j r18 = r12.d(r16, r15, r14);
        final long r19 = 1000 * ((long) r18.i(r12.e()));
        Object r20 = f5307g;
        monitor-enter(r20);
        LruCache<String, ConcurrentHashMap<String, d>> r21 = f5308h;     // Catch: Throwable -> L17
        ConcurrentHashMap<String, d> r22 = r21.get(r13);     // Catch: Throwable -> L17
        if (r22 != null) goto L13;
        r22 = new ConcurrentHashMap();     // Catch: Throwable -> L17
        r21.put(r13, r22);     // Catch: Throwable -> L17
    L13:
        Intrinsics.checkNotNullExpressionValue(r22, "appQuotaCache.get(pkgNam…me, it)\n                }");     // Catch: Throwable -> L17
        final Function1<String, d> r23 = new AIKModelInterceptManager$resolveQuotaScope$quotaState$1$1(r17, r13, r19);     // Catch: Throwable -> L17
        d r24 = r22.computeIfAbsent(r17, new com.obric.aikernel.runtime.b(r23));     // Catch: Throwable -> L17
        r24.g(r19);     // Catch: Throwable -> L17
        d r25 = r24;     // Catch: Throwable -> L17
        monitor-exit(r20);
        Intrinsics.checkNotNullExpressionValue(r25, "synchronized(cacheLock) …)\n            }\n        }");
        return new a(r13, r17, r19, r18, r25);
    L17:
        th = move-exception;
        throw th;
    }

    private static final d m(Function1 r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "$tmp0");
        return (d) r10.invoke(r11);
    }

    public final Integer i(y6.b r10, RequestParams r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "pkg");
        Intrinsics.checkNotNullParameter(r11, "params");
        boolean r13 = AppSettingsManager.INSTANCE.getModelQuotaConfigs().f();
        String r14 = r11.getBackend().getString(IdlKeys.MethodName);
        AppContext r15 = AppContext.INSTANCE;
        if (com.obric.aikernel.runtime.c.c(r14, r15.isAdminMode(), r15.isDebug(), h7.a.f9194a.b()) == false) goto L7;
        AIKLog.INSTANCE.i(f5302b, "compensateAcceptedRequestCount skipped by debug switch for " + r10.c() + '@' + r10.h());
        return null;
    L7:
        if (com.obric.aikernel.runtime.c.b(r11.getBackend().getString(IdlKeys.MethodName), !r10.e().isEmpty(), r13, r12) == true) goto L17;
        return null;
    L17:
        a r16 = l(r10, r11);     // Catch: Exception -> L14
        if (r16 != null) goto L12;
        return null;
    L12:
        int r17 = r16.e().d(r12, SystemClock.elapsedRealtime());     // Catch: Exception -> L14
        AIKLog.INSTANCE.i(f5302b, "compensateAcceptedRequestCount pkg:" + r16.b() + ", biz:" + r16.a() + ", additionalCount=" + r12 + ", compensatedCount=" + r17 + ", snapshot=" + r16.e());     // Catch: Exception -> L14
        return Integer.valueOf(r17);
    L14:
        e = move-exception;
        AIKLog.INSTANCE.e(f5302b, "compensateAcceptedRequestCount error:" + ExceptionsKt.stackTraceToString(e));
        return null;
    }

    public final long j() {
        return f5303c;
    }

    public final Pair<Integer, Bundle> k(y6.b r14, RequestParams r15) {
        Intrinsics.checkNotNullParameter(r14, "pkg");
        Intrinsics.checkNotNullParameter(r15, "params");
        String r10 = r15.getBackend().getString(IdlKeys.MethodName);
        if (StringsKt.equals$default(r10, IdlKeys.Method_RunBiz, false, 2, null) == false) goto L5;
        AppContext r11 = AppContext.INSTANCE;
        if (com.obric.aikernel.runtime.c.c(r10, r11.isAdminMode(), r11.isDebug(), h7.a.f9194a.b()) == false) goto L11;
        ApiPerfDetails.Companion.b(r15.getBackend()).putInt("model_quota_state", 1);
        AIKLog.INSTANCE.i(f5302b, "interceptInferRequest skipped by debug switch for " + r14.c() + '@' + r14.h());
        return new Pair(1, null);
    L11:
        if (AppSettingsManager.INSTANCE.getModelQuotaConfigs().b() == true) goto L13;
    L32:
        a r13 = l(r14, r15);     // Catch: Exception -> L29
        if (r13 == null) goto L19;
        d.a r16 = r13.e().f(r13.c().h(), r13.c().g(), r13.d(), SystemClock.elapsedRealtime());     // Catch: Exception -> L29
        AIKLog.INSTANCE.e(f5302b, "interceptInferRequest pkg:" + r13.b() + ", biz:" + r13.a() + ", attemptCount=" + r16.a() + ", windowCount=" + r16.c().b() + ", state=" + r16.d() + ", remain=" + r16.b() + ", config:" + r13.c() + ", snapshot=" + r16.c());     // Catch: Exception -> L29
        int r17 = r16.d();     // Catch: Exception -> L29
        if (r17 != 2) goto L24;
        ApiPerfDetails.a r18 = ApiPerfDetails.Companion;     // Catch: Exception -> L29
        r18.b(r15.getBackend()).putInt("model_quota_count", r16.a());     // Catch: Exception -> L29
        r18.b(r15.getBackend()).putInt("model_quota_state", 2);     // Catch: Exception -> L29
        return new Pair(2, null);
    L24:
        if (r17 == 4) goto L26;
        ApiPerfDetails.a r19 = ApiPerfDetails.Companion;     // Catch: Exception -> L29
        r19.b(r15.getBackend()).putInt("model_quota_count", r16.a());     // Catch: Exception -> L29
        r19.b(r15.getBackend()).putInt("model_quota_state", 1);     // Catch: Exception -> L29
        return new Pair(1, null);
    L26:
        ApiPerfDetails.a r110 = ApiPerfDetails.Companion;     // Catch: Exception -> L29
        r110.b(r15.getBackend()).putInt("model_quota_count", r16.a());     // Catch: Exception -> L29
        r110.b(r15.getBackend()).putInt("model_quota_state", 4);     // Catch: Exception -> L29
        Bundle r111 = e8.a.B(new Bundle(), 120, "Failed to run inference. Request cannot be processed. Your app is out of usage quota (try again later)", false, 4, null);     // Catch: Exception -> L29
        r111.putLong(IdlKeys.Args_Timeout, r16.b());     // Catch: Exception -> L29
        return new Pair(4, r111);
    L19:
        return new Pair(1, null);
    L29:
        e = move-exception;
        AIKLog.INSTANCE.e(f5302b, "interceptInferRequest error:" + ExceptionsKt.stackTraceToString(e));
        return new Pair(1, null);
    L13:
        if (f5306f <= 0) goto L32;
        ApiPerfDetails.Companion.b(r15.getBackend()).putInt("model_quota_state", 8);
        return new Pair(8, e8.a.B(new Bundle(), 121, "Failed to run inference. Request cannot be processed. OS Power Restriction is on", false, 4, null));
    L5:
        return new Pair(1, null);
    }
}
