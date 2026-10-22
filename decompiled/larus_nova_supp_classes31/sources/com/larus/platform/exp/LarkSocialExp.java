package com.larus.platform.exp;

import com.bytedance.keva.Keva;
import com.larus.platform.api.IForwardCapabilityService;
import com.larus.platform.model.LarkSocialImModuleState;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.m2;
import hq9.n2;
import hq9.p2;
import hq9.s2;
import hq9.v2;
import hq9.x2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarkSocialExp {
    public static final LarkSocialExp a = null;
    public static final Object b = null;
    public static final CopyOnWriteArrayList<Function2<Boolean, Boolean, Unit>> c = null;
    public static final CopyOnWriteArrayList<Function2<Boolean, Boolean, Unit>> d = null;
    public static final StateFlowImpl e = null;
    public static volatile v2 f;
    public static volatile LarkSocialImModuleState g;
    public static volatile v2 h;
    public static volatile v2 i;
    public static volatile com.larus.platform.api.c j;
    public static volatile com.larus.platform.api.c k;
    public static volatile Function2<? super String, ? super JSONObject, Unit> l;
    public static final Lazy m = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            LarkSocialExp r0 = LarkSocialExp.a;
            LarkSocialExp.j = r2;
            LarkSocialExp.a.n("onUserDidOnline");
        }

        public final void b(com.larus.platform.api.c r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            LarkSocialExp r0 = LarkSocialExp.a;
            r0.getClass();
            v2 r1 = LarkSocialExp.a();
            if (r1 != null) goto L5;
        L8:
            LarkSocialExp.k = r5;
            LarkSocialExp.f = null;
            LarkSocialExp.h = null;
            r0.n("office_user_unavailable");
            r0.n("onUserDidOffline");
            return;
        L5:
            if (Intrinsics.areEqual(r1.a, r5.b) == true) goto L8;
            FLogger.a.w("LarkSocialExp", "ignore stale account offline currentGeneration=" + r1.b);
        }
    }

    public static final class b {
        public final boolean a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "EligibilityEvaluation(desiredEnabled=" + this.a + ", cachedSnapshotUid=" + this.b + ')';
        }

        public b(boolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final boolean c;
        public final boolean d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L10;
            r2 = 1237;
        L10:
            int r4 = (r3 + r2) * 31;
            String r5 = this.e;
            if (r5 != null) goto L13;
            int r6 = 0;
        L15:
            return r4 + r6;
        L13:
            r6 = r5.hashCode();
            goto L15
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "ImInitializationContext(uid=" + this.a + ", secUid=" + this.b + ", isLogin=" + this.c + ", isEnterpriseAccount=" + this.d + ", tenantId=" + this.e + ')';
        }

        public c(String r2, String r3, boolean r4, boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "uid");
            Intrinsics.checkNotNullParameter(r3, "secUid");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public LarkSocialExp() {
    }

    static {
        a = new LarkSocialExp();
        b = new Object();
        c = new CopyOnWriteArrayList();
        d = new CopyOnWriteArrayList();
        e = j1.a(new m2(0));
        g = LarkSocialImModuleState.NOT_LOADED;
        m = LazyKt.lazy(new j());
        AccountService.a.E(new a());
    }

    public static v2 a() {
        v2 r0 = z2.a.c0();
        if (r0 != null) goto L5;
        return null;
    L5:
        AccountService r2 = AccountService.a;
        if (r2.isLogin().booleanValue() == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L14;
        return r0;
    L14:
        return null;
    L8:
        if (Intrinsics.areEqual(r0.a, r2.getUserId()) == false) goto L10;
        r3 = true;
        goto L11
    }

    public static boolean b() {
        IForwardCapabilityService r0 = (IForwardCapabilityService) ServiceManager.get().getService(IForwardCapabilityService.class);
        if (r0 == null) goto L6;
        r0.d();
    L6:
        return e();
    }

    public static Keva d() {
        return (Keva) m.getValue();
    }

    public static boolean e() {
        return ((m2) e.getValue()).d;
    }

    public static boolean f() {
        return ((m2) e.getValue()).c;
    }

    public final boolean c() {
        int r0 = p2.a;
        s2 r1 = (s2) p2.a(b, new LarkSocialExp$enableInitIM$decision$1(this), new m(), new n());
        FLogger.a.d("LarkSocialExp", "enableInitIM enabled=" + r1.c + " settings=" + r1.a + " fg=" + r1.b);
        return r1.c;
    }

    public final int m() {
        if (c() == true) goto L5;
        return 0;
    L5:
        if (d().contains("key_lark_social_im_prewarm_boot_type_device") == false) goto L7;
        int r0 = d().getInt("key_lark_social_im_prewarm_boot_type_device", 0);
    L9:
        return r0;
    L7:
        r0 = z2.a.q1().a();
        d().storeInt("key_lark_social_im_prewarm_boot_type_device", r0);
        FLogger.a.i("LarkSocialExp", "migrate legacy IM boot type to device prewarm=" + r0);
        goto L9
    }

    public static boolean g(String r4) {
        Intrinsics.checkNotNullParameter(r4, "doubaoUid");
        if (StringsKt.isBlank(r4) == false) goto L6;
        FLogger.a.w("LarkSocialExp", "isImFeatureOpenedByFg doubaoUid is blank");
        return false;
    L6:
        e.a.getClass();
        boolean r5 = e.a(r4);
        FLogger.a.d("LarkSocialExp", "isImFeatureOpenedByFg return " + r5);
        return r5;
    }

    public final void i(v2 r8) {
        v2 r0 = a();
        long r1 = -1;
        if (r8 != null) goto L5;
    L15:
        g = LarkSocialImModuleState.FAILED;
        v2 r3 = null;
        h = null;
        if (r8 != null) goto L18;
    L20:
        i = r3;
        StringBuilder r2 = new StringBuilder("im_failed generation=");
        if (r8 == null) goto L23;
        r1 = r8.b;
    L23:
        r2.append(r1);
        n(r2.toString());
        return;
    L18:
        if (Intrinsics.areEqual(r8, r0) == false) goto L20;
        r3 = r8;
        goto L20
    L5:
        if (Intrinsics.areEqual(r8, r0) == true) goto L15;
        if (g != LarkSocialImModuleState.READY) goto L15;
        if (Intrinsics.areEqual(h, r0) == false) goto L15;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("ignore stale IM failure generation=");
        r5.append(r8.b);
        r5.append(" currentGeneration=");
        if (r0 == null) goto L13;
        r1 = r0.b;
    L13:
        r5.append(r1);
        r4.w("LarkSocialExp", r5.toString());
    }

    public final void j(v2 r4) {
        g = LarkSocialImModuleState.LOADING;
        h = null;
        i = null;
        StringBuilder r0 = new StringBuilder("im_loading generation=");
        if (r4 == null) goto L5;
        long r1 = r4.b;
    L6:
        r0.append(r1);
        n(r0.toString());
        return;
    L5:
        r1 = -1;
        goto L6
    }

    public final void k(v2 r4) {
        g = LarkSocialImModuleState.READY;
        a.getClass();
        if (Intrinsics.areEqual(r4, a()) == false) goto L5;
        v2 r0 = r4;
    L6:
        h = r0;
        i = null;
        n("im_ready generation=" + r4.b);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void l(v2 r7) {
        if (r7 != null) goto L4;
    L8:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("ignore stale Office user ready generation=");
        long r2 = -1;
        if (r7 == null) goto L11;
        long r4 = r7.b;
    L12:
        r1.append(r4);
        r1.append(" currentGeneration=");
        v2 r8 = a();
        if (r8 == null) goto L15;
        r2 = r8.b;
    L15:
        r1.append(r2);
        r0.w("LarkSocialExp", r1.toString());
        return;
    L11:
        r4 = -1;
        goto L12
    L4:
        if (Intrinsics.areEqual(r7, a()) == false) goto L8;
        f = r7;
        n("office_user_ready");
    }

    public final m2 n(String r15) {
        int r0 = p2.a;
        Triple r1 = (Triple) p2.a(b, new LarkSocialExp$recomputeState$transition$1(this), new k(), new l());
        m2 r2 = (m2) r1.component1();
        m2 r3 = (m2) r1.component2();
        x2 r4 = (x2) r1.component3();
        boolean r5 = true;
        if (r2.c == false) goto L12;
        if (r4 == null) goto L12;
        if (d().getBoolean("key_lark_social_im_prewarm_device", false) == true) goto L9;
        d().storeBoolean("key_lark_social_im_prewarm_device", true);
    L9:
        int r6 = r4.b.a();
        if (d().getInt("key_lark_social_im_prewarm_boot_type_device", 0) == r6) goto L12;
        d().storeInt("key_lark_social_im_prewarm_boot_type_device", r6);
    L12:
        if (r3 == null) goto L102;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("state changed reason=");
        r8.append(r15);
        r8.append(" desired=");
        r8.append(r3.c);
        r8.append("->");
        r8.append(r2.c);
        r8.append(" active=");
        r8.append(r3.d);
        r8.append("->");
        r8.append(r2.d);
        r8.append(" sessionGeneration=");
        v2 r9 = r2.b;
        long r10 = -1;
        if (r9 == null) goto L16;
        long r11 = r9.b;
    L17:
        r8.append(r11);
        r8.append(" officeGeneration=");
        v2 r12 = r2.e;
        if (r12 == null) goto L20;
        long r13 = r12.b;
    L21:
        r8.append(r13);
        r8.append(" im=");
        r8.append(r2.f);
        r8.append(" imReadyGeneration=");
        v2 r14 = r2.g;
        if (r14 == null) goto L24;
        long r16 = r14.b;
    L25:
        r8.append(r16);
        r8.append(" imFailureGeneration=");
        v2 r17 = r2.h;
        if (r17 == null) goto L28;
        long r18 = r17.b;
    L29:
        r8.append(r18);
        r7.i("LarkSocialExp", r8.toString());
        boolean r19 = r3.c;
        boolean r110 = r2.c;
        if (r19 == r110) goto L99;
        h(c, r19, r110, "desired");
        JSONObject r20 = new JSONObject();
        r20.put("enable_change", r3.c + "->" + r2.c);
        r20.put("active_enabled", r2.d);
        v2 r111 = r2.b;
        String r112 = null;
        if (r111 == null) goto L34;
        String r113 = r111.a;
    L35:
        String r114 = "";
        if (r113 != null) goto L38;
        r113 = "";
    L38:
        r20.put("uid", r113);
        v2 r115 = r2.b;
        if (r115 == null) goto L41;
        long r116 = r115.b;
    L42:
        r20.put("generation", r116);
        r20.put("snapshot_state", r2.a.name());
        if (r4 == null) goto L45;
        String r117 = r4.e;
    L46:
        if (r117 != null) goto L48;
        r117 = "";
    L48:
        r20.put("settings_revision", r117);
        if (r4 == null) goto L51;
        r10 = r4.f;
    L51:
        r20.put("settings_request_id", r10);
        if (r4 == null) goto L54;
        Boolean r118 = Boolean.valueOf(r4.d);
    L55:
        r20.put("social_next_feature_gating", r118);
        if (r4 == null) goto L60;
        n2 r119 = r4.b;
        if (r119 == null) goto L60;
        Boolean r120 = Boolean.valueOf(r119.b());
    L61:
        r20.put("lark_social_config_enable", r120);
        v2 r121 = r2.b;
        if (r121 == null) goto L68;
        String r122 = r121.a;
        if (r122 == null) goto L68;
        a.getClass();
        if (d().getBoolean(o("key_lark_social_im_invited", r122), false) != true) goto L68;
        boolean r123 = true;
    L69:
        r20.put("has_passive_invite_cache", r123);
        v2 r124 = r2.b;
        if (r124 == null) goto L76;
        String r125 = r124.a;
        if (r125 == null) goto L76;
        a.getClass();
        if (d().getBoolean(o("key_lark_social_contact_schema", r125), false) != true) goto L76;
    L77:
        r20.put("has_contact_schema_cache", r5);
        com.larus.platform.api.c r126 = j;
        if (r126 == null) goto L80;
        String r127 = r126.b;
    L81:
        if (r127 != null) goto L83;
        r127 = "";
    L83:
        r20.put("last_online_account", r127);
        com.larus.platform.api.c r128 = k;
        if (r128 == null) goto L86;
        r112 = r128.b;
    L86:
        if (r112 == null) goto L89;
        r114 = r112;
    L89:
        r20.put("last_offline_account", r114);
        Function2<? super String, ? super JSONObject, Unit> r129 = l;
        if (r129 != null) goto L103;
        r7.w("LarkSocialExp", "monitorEnableStateChanged skipped, monitorReporter is null");
        goto L99
    L103:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L94
        r129.invoke("dev_lark_im_switch_change_event", r20);     // Catch: Throwable -> L94
        Object r130 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L94
    L96:
        Throwable r131 = Result.exceptionOrNull-impl(r130);
        if (r131 == null) goto L99;
        FLogger.a.e("LarkSocialExp", "monitorEnableStateChanged report failed", r131);
    L94:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r130 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L96
    L80:
        r127 = null;
    L76:
        r5 = false;
    L68:
        r123 = false;
    L60:
        r120 = null;
        goto L61
    L54:
        r118 = null;
        goto L55
    L45:
        r117 = null;
        goto L46
    L41:
        r116 = -1;
        goto L42
    L34:
        r113 = null;
    L99:
        boolean r132 = r3.d;
        boolean r23 = r2.d;
        if (r132 == r23) goto L102;
        h(d, r132, r23, "active");
        goto L102
    L28:
        r18 = -1;
        goto L29
    L24:
        r16 = -1;
        goto L25
    L20:
        r13 = -1;
        goto L21
    L16:
        r11 = -1;
    L102:
        return r2;
    }

    public static String o(String r1, String r2) {
        return r1 + '_' + r2;
    }

    public static void h(List r4, boolean r5, boolean r6, String r7) {
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        Function2 r0 = (Function2) r8.next();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        r0.invoke(Boolean.valueOf(r5), Boolean.valueOf(r6));     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L4;
        FLogger.a.e("LarkSocialExp", "notify " + r7 + " state failed", r3);
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
