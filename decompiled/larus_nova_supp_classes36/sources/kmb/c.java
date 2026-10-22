package kmb;

import android.content.Context;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.StrategyConfig;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ApiUtils;
import e1c.g;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements qzb.a {
    public static final c a = null;
    public static final Gson b = null;
    public static final AtomicBoolean c = null;
    public static final AtomicBoolean d = null;

    public static final class a implements e1c.b.a {
        public a() {
        }

        public final void g(o1c.c<?, ?> r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
        }

        public final void c(o1c.c<?, ?> r4) {
            Intrinsics.checkNotNullParameter(r4, "task");
            JSONObject r0 = new JSONObject();
            r0.put("taskName", r4.getClass().getSimpleName());
            r0.put("biz", r4.getBiz().getValue());
            r0.put("triggerCondition", r4.p0().toString());
            r0.put("disabled_reason", r4.R().b);
            Map r5 = r4.R().c;
            if (r5 == null) goto L10;
            Iterator r6 = r5.entrySet().iterator();
        L6:
            if (r6.hasNext() == false) goto L10;
            Map.Entry r1 = (Map.Entry) r6.next();
            if (r1.getValue() == null) goto L6;
            r0.put((String) r1.getKey(), r1.getValue());
        L10:
            Statistics.sendEvent("perf_preload_task_disable_dev", r0);
        }

        public final void d(o1c.c<?, ?> r4) {
            Intrinsics.checkNotNullParameter(r4, "task");
            JSONObject r0 = new JSONObject();
            r0.put("taskName", r4.getClass().getSimpleName());
            r0.put("biz", r4.getBiz().getValue());
            r0.put("triggerCondition", r4.p0().toString());
            r0.put("executeFrequency", r4.f0());
            Statistics.sendEvent("perf_preload_task_trigger_dev", r0);
        }

        public final void e(o1c.c<?, ?> r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "task");
            JSONObject r5 = new JSONObject();
            r5.put("taskName", r3.getClass().getSimpleName());
            r5.put("biz", r3.getBiz().getValue());
            Statistics.sendEvent("perf_preload_task_execute_dev", r5);
        }

        public final void m(o1c.c r4, Map r5) {
            Intrinsics.checkNotNullParameter(r4, "task");
            JSONObject r0 = new JSONObject();
            r0.put("taskName", r4.getClass().getSimpleName());
            r0.put("biz", r4.getBiz().getValue());
            r0.put("itemSize", 1);
            if (r5 == null) goto L6;
            Object r1 = r5.get("first_hit_interval");
            if (r1 == null) goto L6;
        L7:
            r0.put("first_hit_interval", r1);
            Object r6 = InvRouter.UNKNOWN;
            if (r5 == null) goto L11;
            Object r2 = r5.get("source_type");
            if (r2 == null) goto L11;
        L12:
            r0.put("source_type", r2);
            if (r5 == null) goto L18;
            Object r7 = r5.get("unique_id");
            if (r7 == null) goto L18;
            r6 = r7;
        L18:
            r0.put("unique_id", r6);
            Statistics.sendEvent("perf_preload_task_hit_dev", r0);
            return;
        L11:
            r2 = InvRouter.UNKNOWN;
        L6:
            r1 = 0;
            goto L7
        }

        public final void b(o1c.c<?, ?> r4, int r5, Map<String, ? extends Object> r6) {
            Intrinsics.checkNotNullParameter(r4, "task");
            JSONObject r0 = new JSONObject();
            r0.put("taskName", r4.getClass().getSimpleName());
            r0.put("biz", r4.getBiz().getValue());
            Object r7 = 0;
            if (r6 == null) goto L6;
            Object r2 = r6.get("executeTime");
            if (r2 == null) goto L6;
        L7:
            r0.put("executeTime", r2);
            if (r6 == null) goto L13;
            Object r8 = r6.get("source_type");
            if (r8 == null) goto L13;
            r7 = r8;
        L13:
            r0.put("source_type", r7);
            r0.put("cacheSize", r5);
            Statistics.sendEvent("perf_preload_task_success_dev", r0);
            return;
        L6:
            r2 = r7;
            goto L7
        }

        public final void k(o1c.c r4, boolean r5, Map r6) {
            Intrinsics.checkNotNullParameter(r4, "task");
            JSONObject r0 = new JSONObject();
            r0.put("taskName", r4.getClass().getSimpleName());
            r0.put("biz", r4.getBiz().getValue());
            r0.put("itemSize", 1);
            r0.put("is_hit_cache", r5 ? 1 : 0);
            if (r6 == null) goto L6;
            Object r7 = r6.get("source_type");
            if (r7 == null) goto L6;
        L7:
            r0.put("source_type", r7);
            Statistics.sendEvent("perf_preload_task_get_cache_dev", r0);
            return;
        L6:
            r7 = InvRouter.UNKNOWN;
            goto L7
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = new Gson();
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
    }

    public final void a(Context r11) {
        if (r11 != null) goto L55;
        return;
    L55:
        Boolean r2 = (Boolean) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(d.class, true);     // Catch: Exception -> L10
        if (r2 == null) goto L12;
        boolean r3 = r2.booleanValue();     // Catch: Exception -> L10
    L53:
        boolean r4 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.new.preload.task.manager");     // Catch: Exception -> L16
    L18:
        e1c.c.b.set(r3);
        e1c.c.a.set(r4);
        AtomicBoolean r5 = e1c.c.c;
        if (r3 == false) goto L22;
        if (r4 == false) goto L22;
        boolean r6 = true;
    L23:
        r5.set(r6);
        AtomicReference r7 = e1c.c.d;
        StrategyConfig r8 = null;
        String r9 = (String) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(b.class, true);     // Catch: Exception -> L26
    L28:
        if (r9 != null) goto L30;
    L33:
        boolean r10 = true;
    L34:
        if (r10 == false) goto L59;
    L40:
        r7.set(r8);
        Log.i("OfficeSDKPreloadInitializer", "initPreloadConfig, abEnabled:" + r3 + ", fgEnabled:" + r4 + ", enabled:" + e1c.c.c.get());
        if (c.compareAndSet(false, true) == true) goto L57;
    L48:
        boolean r12 = e1c.d.m;
        e1c.d r13 = e1c.d.b.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r11, "context");
        r13.l = r11.getApplicationContext();
        r13.k = CoreThreadPool.newThreadHandler("PreloadTaskManager", new g(r13));
        if (d.compareAndSet(false, true) == false) goto L51;
        a r14 = new a();
        Intrinsics.checkNotNullParameter(r14, "callback");
        r13.e.add(r14);
    L51:
        StrategyConfig r15 = com.ss.android.lark.preload.c.a();
        Log.i("OfficeSDKPreloadInitializer", "init finish, strategy config = { hitRate:" + r15.getHitRateDisableValue() + ", bizFrequency:" + r15.getBizFrequencyDisableValue() + '}');
        return;
    L57:
        xzb.a r16 = (xzb.a) ApiUtils.getApi(xzb.a.class);     // Catch: Exception -> L46
        if (r16 == null) goto L48;
        r16.registerUserSwitchListener(this);     // Catch: Exception -> L46
    L46:
        e = move-exception;
        c.set(false);
        Log.e("OfficeSDKPreloadInitializer", "registerUserSwitchListener error: " + e.getMessage());
        goto L48
    L59:
        r8 = (StrategyConfig) b.fromJson(r9, StrategyConfig.class);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        Log.e("OfficeSDKPreloadInitializer", "getStrategyConfig parse error: " + e.getMessage());
        goto L40
    L30:
        if (r9.length() == 0) goto L33;
        r10 = false;
    L26:
        e = move-exception;
        Log.e("OfficeSDKPreloadInitializer", "getPreloadDisableConfig error: " + e.getMessage());
        r9 = null;
    L22:
        r6 = false;
    L16:
        e = move-exception;
        Log.e("OfficeSDKPreloadInitializer", "isPreloadTaskManagerFGEnabled error: " + e.getMessage());
        r4 = false;
    L12:
        r3 = true;
    L10:
        e = move-exception;
        Log.e("OfficeSDKPreloadInitializer", "isNewPreloadManagerEnabled error: " + e.getMessage());
        goto L12
    }
}
