package tyb;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.SystemClock;
import com.bytedance.bdturing.BdTuringConfig;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import jc4.g;
import jc4.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final a a = null;
    public static volatile boolean b;
    public static final Object c = null;
    public static final AtomicBoolean d = null;
    public static b e;

    /* JADX INFO: renamed from: tyb.a$a, reason: collision with other inner class name */
    public static final class C0194a implements com.bytedance.bdturing.setting.b {
        public final com.bytedance.bdturing.setting.b a;

        public C0194a(com.bytedance.bdturing.setting.b r1) {
            this.a = r1;
        }

        public final JSONObject a(String r10, JSONObject r11) {
            Intrinsics.checkNotNullParameter(r10, "service");
            Intrinsics.checkNotNullParameter(r11, "jsonObj");
            com.bytedance.bdturing.setting.b r0 = this.a;
            if (r0 == null) goto L8;
            JSONObject r1 = r0.a(r10, r11);
            if (r1 == null) goto L8;
            r11 = r1;
        L8:
            a.a.getClass();
            if (Intrinsics.areEqual("verify", r10) == false) goto L67;
            JSONObject r12 = r11.optJSONObject("host");
            if (r12 != null) goto L14;
            PassportLog.b("n_action_bdturing", "UpdateServiceUrl, opt host failed");
            goto L67
        L14:
            gpb.a r2 = (gpb.a) ApiUtils.getApi(gpb.a.class);
            int r3 = 0;
            String r5 = null;
            if (com.ss.android.lark.passport.a.a() == true) goto L70;
            Integer r4 = null;
        L32:
            if (r4 == null) goto L34;
            int r6 = r4.intValue();
        L36:
            if (r6 != 2) goto L38;
            String r7 = EnvConst$UNIT.BOE_CN;
        L39:
            List r8 = jcb.b.c().p0("passport_turing_verify_url", r6, r7, "feishu");
            if (r8 == null) goto L42;
            r5 = (String) CollectionsKt.firstOrNull(r8);
        L42:
            if (r5 != null) goto L44;
            r5 = "";
        L44:
            String r9 = StringsKt.trimEnd(StringsKt.trim(r5).toString(), new char[]{'/'});
            if (StringsKt.startsWith(r9, "http://", true) == false) goto L47;
        L50:
            Log.i("n_action_bdturing", "turing page host:" + r9);
            if (StringsKt.isBlank(r9) == false) goto L53;
            PassportLog.b("n_action_bdturing", "UpdateServiceUrl, turing's host is blank");
            goto L67
        L53:
            LinkedHashSet r13 = new LinkedHashSet();
            BdTuringConfig.RegionType[] r14 = BdTuringConfig.RegionType.values();
            ArrayList r15 = new ArrayList(r14.length);
            int r16 = r14.length;
        L54:
            if (r3 >= r16) goto L56;
            r15.add(r14[r3].getName());
            r3 = r3 + 1;
            goto L54
        L56:
            r13.addAll(r15);
            CollectionsKt.addAll(r13, SequencesKt.asSequence(r12.keys()));
            PassportLog.d("n_action_bdturing", "UpdateServiceUrl, turing's host is " + r9);
            Iterator r17 = r13.iterator();
        L58:
            if (r17.hasNext() == false) goto L67;
            String r18 = (String) r17.next();
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L62
            r12.put(r18, r9);     // Catch: Throwable -> L62
            PassportLog.d("n_action_bdturing", "UpdateServiceUrl, update " + r18 + "'s host");     // Catch: Throwable -> L62
            Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L62
        L64:
            Throwable r21 = Result.exceptionOrNull-impl(r20);
            if (r21 == null) goto L58;
            PassportLog.c("n_action_bdturing", "UpdateServiceUrl, put region " + r18 + " failed", r21);
        L62:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L64
        L47:
            if (StringsKt.startsWith(r9, "https://", true) == true) goto L50;
            r9 = "https://" + r9;
            goto L50
        L38:
            r7 = "eu_nc";
            goto L39
        L34:
            r6 = r2.envType();
            goto L36
        L70:
            Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L26
            Integer r24 = Integer.valueOf(LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getInt("custom_env_value", -1));     // Catch: Throwable -> L26
            if (r24.intValue() == (-1)) goto L20;
            boolean r25 = true;
        L21:
            if (r25 == true) goto L24;
            r24 = null;
        L24:
            Object r26 = Result.constructor-impl(r24);     // Catch: Throwable -> L26
        L29:
            if (Result.isFailure-impl(r26) == false) goto L31;
            r26 = null;
        L31:
            r4 = (Integer) r26;
            goto L32
        L20:
            r25 = false;
        L26:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r26 = Result.constructor-impl(ResultKt.createFailure(th));
        L67:
            return r11;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: tyb.a$b$a, reason: collision with other inner class name */
        public static final class C0195a extends b {
            public final int a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0195a) == true) goto L9;
                return false;
            L9:
                if (this.a == ((C0195a) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a;
            }

            public final String toString() {
                return "Challenge(challengeId=" + this.a + ')';
            }

            public C0195a(int r1) {
                this.a = r1;
            }
        }

        /* JADX INFO: renamed from: tyb.a$b$b, reason: collision with other inner class name */
        public static final class C0196b extends b {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0196b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0196b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Decision(riskInfo=" + this.a + ')';
            }

            public C0196b(String r2) {
                Intrinsics.checkNotNullParameter(r2, "riskInfo");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    public static final class c implements ComponentCallbacks2 {
        public final /* synthetic */ a a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r1) {
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r2) {
            Intrinsics.checkNotNullParameter(r2, "newConfig");
            this.a.getClass();
            a.e();
        }
    }

    public a() {
    }

    static {
        a = new a();
        c = new Object();
        d = new AtomicBoolean(false);
    }

    public static void e() {
        BdTuringConfig r0 = qb4.b.c.a.a;
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        a.getClass();
        String r3 = d(2131105554);
        if (r3 == null) goto L8;
        r2.put("slidingSlotBgColor", r3);
    L8:
        String r4 = d(2131105548);
        if (r4 == null) goto L11;
        r2.put("feedbackBtnBgColor", r4);
    L11:
        r2.put("feedbackBtnBgOpacity", "0.34");
        String r5 = d(2131105548);
        if (r5 == null) goto L14;
        r2.put("feedbackOnSelectedIconColor", r5);
    L14:
        Unit r6 = Unit.INSTANCE;
        r1.put("theme", r2);
        r0.setTheme(r1, 2);
    }

    public static boolean f() {
        if (b == false) goto L5;
        return true;
    L5:
        qb4.b r0 = qb4.b.c.a;
        Intrinsics.checkNotNull(r0);
        monitor-enter(r0);
        BdTuringConfig r2 = r0.a;     // Catch: Throwable -> L44
        if (r2 == null) goto L12;
        if (r0.b == false) goto L12;
    L13:
        monitor-exit(r0);
        if (r2 != null) goto L17;
        return false;
    L17:
        Object r1 = c;
        monitor-enter(r1);
    L41:
        th = move-exception;
        throw th;
    L20:
        if (b == false) goto L23;
        monitor-exit(r1);
        return true;
    L23:
        a r3 = a;     // Catch: Throwable -> L41
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L30
        r3.getClass();     // Catch: Throwable -> L30
        com.bytedance.bdturing.setting.b r5 = r2.getServiceInterceptor();     // Catch: Throwable -> L30
        if ((r5 instanceof C0194a) == true) goto L28;
        r2.setServiceInterceptor(new C0194a(r5));     // Catch: Throwable -> L30
    L28:
        r3.c();     // Catch: Throwable -> L30
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L33:
        if (Result.isSuccess-impl(r6) == false) goto L35;
        Unit r7 = (Unit) r6;     // Catch: Throwable -> L41
        b = true;     // Catch: Throwable -> L41
        PassportLog.d("n_action_bdturing", "bound to host BDTuring instance");     // Catch: Throwable -> L41
    L35:
        Throwable r8 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L41
        if (r8 == null) goto L38;
        PassportLog.c("n_action_bdturing", "bind to host BDTuring instance failed", r8);     // Catch: Throwable -> L41
    L38:
        boolean r9 = b;     // Catch: Throwable -> L41
        monitor-exit(r1);
        return r9;
    L30:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L41
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
    L12:
        r2 = null;
    L44:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Application r0 = LarkContext.getApplication();
        if (d.compareAndSet(false, true) == true) goto L15;
    L13:
        e();
        return;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        r0.registerComponentCallbacks(new c(this));     // Catch: Throwable -> L6
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L13;
        d.set(false);
        throw r3;
    L6:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static String d(int r6) {
        Application r0 = LarkContext.getApplication();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Integer.valueOf(UDColorUtils.getColor(r0, r6)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r7) == false) goto L10;
        r7 = null;
    L10:
        Integer r8 = (Integer) r7;
        if (r8 == null) goto L14;
        int r9 = r8.intValue();
        return "#" + String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.red(r9))}, 1)) + String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.green(r9))}, 1)) + String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.blue(r9))}, 1));
    L14:
        return null;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final void a(a r1, String r2) {
        r1.getClass();
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L5
        r3.put("result_value", r2);     // Catch: Throwable -> L5
        Statistics.sendEvent("turing_verify_result", r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        PassportLog.b("n_action_bdturing", "turingVerifyResult " + th.getMessage());
    }

    public static final void b(a r8, b r9, long r10) {
        if (e == r9) goto L5;
        r8.getClass();
        return;
    L5:
        r8.getClass();
        String r1 = null;
        if (f() == false) goto L78;
        e = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L17
        if ((r9 instanceof b.C0196b) == false) goto L12;
        m r12 = new m(((b.C0196b) r9).a);     // Catch: Throwable -> L17
    L14:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L17
    L20:
        if (Result.isSuccess-impl(r13) == false) goto L75;
        jc4.a r14 = (jc4.a) r13;
        a r15 = a;
        r15.getClass();
        Activity r16 = AppLifecycle.a.a.f();
        if (r16 == null) goto L74;
        Statistics.sendEvent("passport_turing_show");
        qb4.b r2 = qb4.b.c.a;
        BdTuringConfig r3 = r2.a;
        if (r3 == null) goto L83;
        epb.a r4 = (epb.a) ApiUtils.getApi(epb.a.class);
        if (r4 == null) goto L29;
        String r5 = r4.getInstallId();
    L30:
        String r6 = "";
        if (r5 != null) goto L33;
        r5 = "";
    L33:
        if (r4 == null) goto L35;
        r1 = r4.getDeviceId();
    L35:
        if (r1 == null) goto L38;
        r6 = r1;
    L38:
        String r7 = r3.getDeviceId();
        boolean r17 = true;
        if (r7 != null) goto L41;
    L44:
        boolean r18 = true;
    L45:
        if (r18 == true) goto L47;
    L52:
        String r19 = r3.getInstallId();
        if (r19 != null) goto L55;
    L58:
        boolean r20 = true;
    L59:
        if (r20 == true) goto L61;
    L66:
        yob.e.a().getClass();
        int r21 = com.ss.android.lark.language.service.impl.a.f;
        r3.setLanguage(com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting().getLanguage());
        goto L83
    L61:
        if (r5.length() > 0) goto L64;
        r17 = false;
    L64:
        if (r17 == false) goto L66;
        r3.setInstallId(r5);
        goto L66
    L55:
        if (r19.length() == 0) goto L58;
        r20 = false;
        goto L59
    L47:
        if (r6.length() <= 0) goto L49;
        boolean r22 = true;
    L50:
        if (r22 == false) goto L52;
        r3.setDeviceId(r6);
        goto L52
    L49:
        r22 = false;
        goto L50
    L41:
        if (r7.length() == 0) goto L44;
        r18 = false;
        goto L45
    L29:
        r5 = null;
    L83:
        r2.i(r16, r14, new d(r15, r16, r2));     // Catch: Throwable -> L69
        Object r23 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L71:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L75;
        PassportLog.c("n_action_bdturing", "show turing dialog failed", r24);
    L69:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L71
    L74:
        PassportLog.b("n_action_bdturing", "async get last top activity is null");
    L75:
        Throwable r25 = Result.exceptionOrNull-impl(r13);
        if (r25 == null) goto L87;
        PassportLog.c("n_action_bdturing", "create turing request failed", r25);
        return;
    L87:
        return;
    L12:
        if ((r9 instanceof b.C0195a) == false) goto L16;
        r12 = new g(((b.C0195a) r9).a);     // Catch: Throwable -> L17
        goto L14
    L16:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L78:
        long r27 = SystemClock.elapsedRealtime() - r10;
        if (r27 < 5000) goto L81;
        e = null;
        PassportLog.b("n_action_bdturing", "wait for host BDTuring initialization timeout, request: " + r9.getClass().getSimpleName() + ", elapsedTime: " + r27);
        return;
    L81:
        UICallbackExecutor.executeDelayed(new e(r9, r10), 100);
    }
}
