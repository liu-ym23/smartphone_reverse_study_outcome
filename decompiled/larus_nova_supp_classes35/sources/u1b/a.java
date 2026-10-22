package u1b;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IDependency;
import com.ss.android.lark.chameleon.IMonitorDependency;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonReport;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import swb.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final Map<String, C0305a> a = null;
    public static Boolean b;

    /* JADX INFO: renamed from: u1b.a$a, reason: collision with other inner class name */
    public static final class C0305a {
        public final ChameleonConfig a;
        public final long b;
        public ChameleonPluginHost c;
        public final Map<String, Pair<Long, Long>> d;
        public final Map<String, Object> e;
        public boolean f;

        public C0305a(String r4, ChameleonConfig r5) {
            long r0 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r4, "session");
            Intrinsics.checkNotNullParameter(r5, "chameleonConfig");
            this.a = r5;
            this.b = r0;
            this.d = new LinkedHashMap();
            this.e = new LinkedHashMap();
        }

        public static /* synthetic */ void e(C0305a r2, String r3) {
            r2.d(r3, System.currentTimeMillis());
        }

        public final void c(String r4, long r5) {
            Intrinsics.checkNotNullParameter(r4, "stage");
            Pair r0 = (Pair) ((LinkedHashMap) this.d).get(r4);
            if (r0 == null) goto L6;
            this.d.put(r4, new Pair(r0.getFirst(), Long.valueOf(r5)));
            return;
        }

        public final void d(String r5, long r6) {
            Intrinsics.checkNotNullParameter(r5, "stage");
            this.d.put(r5, new Pair(Long.valueOf(r6), 0L));
        }

        public static /* synthetic */ void b(C0305a r2, String r3, int r4) {
            r2.a(r3, r4, System.currentTimeMillis());
        }

        public final void a(String r9, int r10, long r11) {
            Intrinsics.checkNotNullParameter(r9, ChameleonOpenTracker.ParamKey.RESULT);
            if (this.f == false) goto L5;
            return;
        L5:
            this.f = true;
            JSONObject r1 = new JSONObject();
            r1.put(ChameleonOpenTracker.ParamKey.RESULT, r9);
            r1.put("code", r10);
            r1.put(ChameleonOpenTracker.ParamKey.APP_NAME, this.a.getBizName());
            PreloadConfig r12 = this.a.getPreloadConfig();
            if (r12 == null) goto L10;
            PreloadPolicy r13 = r12.getPolicy();
            if (r13 == null) goto L10;
        L11:
            r1.put(ChameleonOpenTracker.ParamKey.PRELOAD_TYPE, r13.ordinal());
            Lazy r14 = TTWebViewUtil.a;
            TTWebViewUtil.a.d(null);
            r1.put(ChameleonOpenTracker.ParamKey.IS_TT_WEBVIEW, 0);
            TTWebViewUtil.a.b().p();
            r1.put(ChameleonOpenTracker.ParamKey.TT_WEBVIEW_VERSION, BuildConfig.FLAVOR);
            r1.put(ChameleonOpenTracker.ParamKey.COST, r11 - this.b);
            r1.put("recovery", Intrinsics.areEqual(a.b, Boolean.TRUE));
            Iterator r15 = ((LinkedHashMap) this.d).entrySet().iterator();
        L13:
            if (r15.hasNext() == false) goto L22;
            Map.Entry r16 = (Map.Entry) r15.next();
            if (((Number) ((Pair) r16.getValue()).getFirst()).longValue() <= 0) goto L13;
            if (((Number) ((Pair) r16.getValue()).getSecond()).longValue() <= ((Number) ((Pair) r16.getValue()).getFirst()).longValue()) goto L13;
            long r2 = ((Number) ((Pair) r16.getValue()).getFirst()).longValue() - this.b;
            if (r2 <= 0) goto L21;
            r1.put(((String) r16.getKey()) + "_stage_start", r2);
        L21:
            r1.put(((String) r16.getKey()) + "_stage_cost", ((Number) ((Pair) r16.getValue()).getSecond()).longValue() - ((Number) ((Pair) r16.getValue()).getFirst()).longValue());
            goto L13
        L22:
            Iterator r17 = ((LinkedHashMap) this.e).entrySet().iterator();
        L24:
            if (r17.hasNext() == false) goto L26;
            Map.Entry r18 = (Map.Entry) r17.next();
            r1.put((String) r18.getKey(), r18.getValue());
            goto L24
        L26:
            ChameleonPluginHost r19 = this.c;
            if (r19 == null) goto L42;
            IDependency r110 = this.a.getDependency();
            if (r110 == null) goto L42;
            IMonitorDependency r111 = r110.getMonitorDependency();
            if (r111 == null) goto L42;
            Map<String, Object> r112 = r111.getBizParams(r19);
            if (r112 == null) goto L42;
            Iterator<Map.Entry<String, Object>> r113 = r112.entrySet().iterator();
        L36:
            if (r113.hasNext() == false) goto L42;
            Map.Entry<String, Object> r114 = r113.next();
            String r0 = r114.getKey();
            Object r115 = r114.getValue();
            if (r1.has(r0) == true) goto L36;
            r1.put(r0, r115);     // Catch: Exception -> L41
        L41:
            j.f(ChameleonReport.TAG, "skip invalid biz param: " + r0);
        L42:
            j.e(ChameleonReport.TAG, "openFinish, eventName = webapp_open_finish_dev param is " + r1);
            b.b(ChameleonOpenTracker.Event.Chameleon_OPEN_FINISH_DEV, r1);
            a.b = null;
            return;
        L10:
            r13 = PreloadPolicy.NO_PRELOAD;
            goto L11
        }
    }

    static {
        a = new LinkedHashMap();
    }

    public static C0305a a(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return (C0305a) ((LinkedHashMap) a).get(r1);
    }

    @JvmStatic
    public static final String b(ChameleonConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "chameleonConfig");
        ThreadLocal r0 = q.a;
        SecureRandom r1 = (SecureRandom) r0.get();
        if (r1 != null) goto L5;
        r1 = new SecureRandom();
        r0.set(r1);
    L5:
        byte[] r2 = new byte[16];
        r1.nextBytes(r2);
        byte r3 = (byte) (r2[6] & 15);
        r2[6] = r3;
        r2[6] = (byte) (r3 | 64);
        byte r4 = (byte) (r2[8] & 63);
        r2[8] = r4;
        r2[8] = (byte) (r4 | 128);
        long r5 = 0;
        int r6 = 0;
        long r7 = 0;
    L6:
        if (r6 >= 8) goto L8;
        r7 = (r7 << 8) | ((long) (r2[r6] & 255));
        r6 = r6 + 1;
        goto L6
    L8:
        int r8 = 8;
    L9:
        if (r8 >= 16) goto L11;
        r5 = (r5 << 8) | ((long) (r2[r8] & 255));
        r8 = r8 + 1;
        goto L9
    L11:
        String r9 = new UUID(r7, r5).toString();
        a.put(r9, new C0305a(r9, r10));
        return r9;
    }
}
