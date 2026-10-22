package com.larus.account.saas.core.ttaccount;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.SystemClock;
import com.bytedance.sdk.account.impl.d0;
import com.bytedance.sdk.account.impl.j;
import com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService;
import com.ss.android.token.p;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountGroupAuthServerService;", "Lcom/larus/account/saas/ttaccount/api/IAccountGroupAuthServerService;", "<init>", "()V", "a", "b", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountGroupAuthServerService implements IAccountGroupAuthServerService {
    public static final /* synthetic */ int c = 0;
    public final WeakHashMap<Activity, b> b;

    public static final class a {
    }

    public static final class b {
        public static final /* synthetic */ int q = 0;
        public final long a;
        public int b;
        public String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final boolean h;
        public final boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;
        public long n;
        public long o;
        public long p;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r9.h) goto L33;
            return false;
        L33:
            if (this.i == r9.i) goto L36;
            return false;
        L36:
            if (this.j == r9.j) goto L39;
            return false;
        L39:
            if (this.k == r9.k) goto L42;
            return false;
        L42:
            if (this.l == r9.l) goto L45;
            return false;
        L45:
            if (this.m == r9.m) goto L48;
            return false;
        L48:
            if (this.n == r9.n) goto L51;
            return false;
        L51:
            if (this.o == r9.o) goto L54;
            return false;
        L54:
            if (this.p == r9.p) goto L56;
            return false;
        L56:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v28 */
        /* JADX WARN: Type inference failed for: r0v29 */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r1v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v16, types: [int] */
        /* JADX WARN: Type inference failed for: r1v18, types: [int] */
        /* JADX WARN: Type inference failed for: r1v24, types: [int] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v8 */
        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
            boolean r2 = this.h;
            ?? r3 = 1;
            ?? r4 = r2;
            if (r2 == false) goto L5;
            r4 = 1;
        L5:
            int r5 = (r1 + r4) * 31;
            boolean r6 = this.i;
            ?? r7 = r6;
            if (r6 == false) goto L8;
            r7 = 1;
        L8:
            int r8 = (r5 + r7) * 31;
            boolean r9 = this.j;
            ?? r10 = r9;
            if (r9 == false) goto L11;
            r10 = 1;
        L11:
            long r11 = this.k;
            int r12 = (((r8 + r10) * 31) + ((int) (r11 ^ (r11 >>> 32)))) * 31;
            long r13 = this.l;
            int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
            boolean r15 = this.m;
            if (r15 == true) goto L15;
            r3 = r15;
        L15:
            int r16 = (r14 + r3) * 31;
            long r17 = this.n;
            int r19 = (r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31;
            long r20 = this.o;
            int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
            long r22 = this.p;
            return r21 + ((int) (r22 ^ (r22 >>> 32)));
        }

        public final String toString() {
            return "Session(startTime=" + this.a + ", clientAuthVersion=" + this.b + ", clientPkg=" + this.c + ", challenge=" + this.d + ", challengeMethod=" + this.e + ", aid=" + this.f + ", loginScene=" + this.g + ", isEnablePreGetToken=" + this.h + ", isColdBootLandingPage=" + this.i + ", waitingLogin=" + this.j + ", waitSdkInitDuration=" + this.k + ", requestGetTokenDuration=" + this.l + ", isTokenSdkInitBeforeGetToken=" + this.m + ", startWaitSdkTime=" + this.n + ", startRequestGetTokenTime=" + this.o + ", endRequestGetTokenTime=" + this.p + ')';
        }

        public b(long r2, int r4, String r5, String r6, String r7, String r8, String r9, boolean r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r5, "clientPkg");
            Intrinsics.checkNotNullParameter(r6, "challenge");
            Intrinsics.checkNotNullParameter(r7, "challengeMethod");
            Intrinsics.checkNotNullParameter(r8, "aid");
            Intrinsics.checkNotNullParameter(r9, "loginScene");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = false;
            this.k = 0;
            this.l = 0;
            this.m = false;
            this.n = 0;
            this.o = 0;
            this.p = 0;
        }
    }

    public static final class c implements com.ss.android.token.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ AccountGroupAuthServerService d;
        public final /* synthetic */ com.larus.account.saas.ttaccount.api.a e;

        public static final class a extends ua7.a<xa7.c> {
            public final /* synthetic */ Activity a;
            public final /* synthetic */ AccountGroupAuthServerService b;
            public final /* synthetic */ b c;
            public final /* synthetic */ long d;
            public final /* synthetic */ com.larus.account.saas.ttaccount.api.a e;

            public final void onResponse(ua7.b r19) {
                xa7.c r1 = (xa7.c) r19;
                if (this.a.isFinishing() == false) goto L5;
            L32:
                this.b.b.remove(this.a);
                return;
            L5:
                if (this.a.isDestroyed() == true) goto L32;
                b r2 = this.c;
                r2.p = System.currentTimeMillis();
                b r3 = this.c;
                r3.l = SystemClock.elapsedRealtime() - this.d;
                this.e.hideLoading();
                boolean r4 = false;
                if (r1 != null) goto L10;
            L12:
                boolean r5 = false;
            L13:
                if (r5 == false) goto L22;
                JSONObject r6 = r1.z;
                if (r6 == null) goto L22;
                String r8 = r6.optString("token");
                if (r8.length() <= 0) goto L19;
                r4 = true;
            L19:
                if (r4 == false) goto L21;
                AccountGroupAuthServerService r7 = this.b;
                Activity r9 = this.a;
                b r10 = this.c;
                int r11 = AccountGroupAuthServerService.c;
                r7.d(r9, r10, r8, 0, null);
                return;
            L21:
                AccountGroupAuthServerService r12 = this.b;
                Activity r13 = this.a;
                b r14 = this.c;
                int r15 = AccountGroupAuthServerService.c;
                r12.d(r13, r14, "", -3, "authToken is null");
                return;
            L22:
                if (r1 == null) goto L24;
                int r16 = ((ua7.b) r1).g;
            L25:
                StringBuilder r17 = new StringBuilder("server error:");
                r17.append(r16);
                r17.append(',');
                if (r1 == null) goto L28;
                String r20 = ((ua7.b) r1).i;
            L29:
                if (r20 != null) goto L31;
                r20 = "unknown";
            L31:
                r17.append(r20);
                String r21 = r17.toString();
                AccountGroupAuthServerService r22 = this.b;
                Activity r23 = this.a;
                b r24 = this.c;
                int r25 = AccountGroupAuthServerService.c;
                r22.d(r23, r24, "", r16, r21);
                return;
            L28:
                r20 = null;
                goto L29
            L24:
                r16 = -3;
                goto L25
            L10:
                if (((ua7.b) r1).c != true) goto L12;
                r5 = true;
                goto L13
            }

            public a(Activity r1, AccountGroupAuthServerService r2, b r3, long r4, com.larus.account.saas.ttaccount.api.a r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r6;
            }
        }

        public final void onError(String r8) {
            if (this.c.isFinishing() == false) goto L5;
        L9:
            this.d.b.remove(this.c);
            return;
        L5:
            if (this.c.isDestroyed() == true) goto L9;
            b r0 = this.a;
            r0.k = SystemClock.elapsedRealtime() - this.b;
            this.e.hideLoading();
            AccountGroupAuthServerService r1 = this.d;
            Activity r2 = this.c;
            b r3 = this.a;
            int r5 = AccountGroupAuthServerService.c;
            r1.d(r2, r3, "", -1, r8);
        }

        public final void onSuccess(Map<String, String> r11) {
            this.a.k = SystemClock.elapsedRealtime() - this.b;
            this.a.o = System.currentTimeMillis();
            if (r11 == null) goto L5;
            r11.put("x-uc-bypass-token", "1");
        L5:
            String r1 = zqa.c.b(zqa.c.a(this.c, this.a.c));
            long r6 = SystemClock.elapsedRealtime();
            d0 r9 = d0.c();
            d0 r10 = r9;
            r10.b("/passport/safe/get_token/", r11, MapsKt.mapOf(new Pair[]{TuplesKt.to("local_account_sdk_skip_network_check", "1"), TuplesKt.to("token_challenge", this.a.d), TuplesKt.to("token_challenge_method", this.a.e), TuplesKt.to("client_aid", this.a.f), TuplesKt.to("client_package", this.a.c), TuplesKt.to("client_signature", r1), TuplesKt.to("login_scene", this.a.g), TuplesKt.to("response_format_type", "app")}), new a(this.c, this.d, this.a, r6, this.e));
        }

        public c(b r1, long r2, Activity r4, AccountGroupAuthServerService r5, com.larus.account.saas.ttaccount.api.a r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public AccountGroupAuthServerService() {
        this.b = new WeakHashMap();
    }

    @Override // com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService
    public final void c(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        b r2 = this.b.get(r7);
        if (r2 != null) goto L6;
        r7.finish();
        return;
    L6:
        d(r7, r2, "", 30010, "豆包未同意隐私条款");
    }

    @Override // com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService
    public final void onDestroy(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.b.remove(r2);
    }

    @Override // com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService
    public final void b(Activity r23, com.larus.account.saas.ttaccount.api.a r24) {
        Intrinsics.checkNotNullParameter(r23, "activity");
        Intrinsics.checkNotNullParameter(r24, "delegate");
        int r1 = b.q;
        Intrinsics.checkNotNullParameter(r23, "activity");
        Intent r0 = r23.getIntent();
        boolean r9 = false;
        if (r0 != null) goto L5;
        b r11 = null;
    L30:
        if (r11 != null) goto L33;
        r23.finish();
        return;
    L33:
        this.b.put(r23, r11);
        if (r11.b < 2) goto L46;
        String r2 = r23.getCallingPackage();
        if (r2 != null) goto L38;
    L41:
        boolean r3 = true;
    L42:
        if (r3 == false) goto L44;
        com.larus.account.saas.runtime.internal.delegate.a.a.f("AccountSaasGroupAuthServer", "callingPackage is null, downgrade to clientAuthVersion=1");
        r11.b = 1;
        goto L46
    L44:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r11.c = r2;
        goto L46
    L38:
        if (r2.length() == 0) goto L41;
        r3 = false;
    L46:
        if (r11.b != 1) goto L59;
        if (r11.c.length() != 0) goto L50;
        boolean r4 = true;
    L51:
        if (r4 == false) goto L53;
    L57:
        r23.finish();
    L74:
        if (r9 == true) goto L77;
        return;
    L77:
        if (r24.d(r23) == false) goto L80;
        com.larus.account.saas.runtime.internal.delegate.a.a.d("AccountSaasGroupAuthServer", "group auth intercepted by host");
        return;
    L80:
        r24.a(r23);
        if (j.m(r23).isLogin() == false) goto L83;
        e(r23, r11, r24);
        return;
    L83:
        r11.j = true;
        r24.c();
        r24.b(r23, 10001);
        return;
    L53:
        if (r11.d.length() != 0) goto L55;
        boolean r5 = true;
    L56:
        if (r5 == false) goto L59;
    L55:
        r5 = false;
        goto L56
    L50:
        r4 = false;
    L59:
        if (Intrinsics.areEqual(r11.c, r23.getPackageName()) == false) goto L62;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("AccountSaasGroupAuthServer", "clientPkg should not be same as packageName");
        r23.finish();
        goto L74
    L62:
        if (r11.f.length() != 0) goto L64;
        boolean r6 = true;
    L65:
        if (r6 == false) goto L68;
        d(r23, r11, "", -8, "param invalid,aid is empty");
        goto L74
    L68:
        if (r11.e.length() != 0) goto L70;
        boolean r7 = true;
    L71:
        if (r7 == false) goto L73;
        d(r23, r11, "", -8, "param invalid,challenge method is empty");
        goto L74
    L73:
        r9 = true;
        goto L74
    L70:
        r7 = false;
        goto L71
    L64:
        r6 = false;
        goto L65
    L5:
        long r12 = SystemClock.elapsedRealtime();
        int r14 = r0.getIntExtra("client_auth_version", 1);
        String r8 = r0.getStringExtra("client_package");
        if (r8 != null) goto L8;
        String r15 = "";
    L9:
        String r10 = r0.getStringExtra("client_challenge");
        if (r10 != null) goto L12;
        String r16 = "";
    L13:
        String r13 = r0.getStringExtra("client_challenge_method");
        if (r13 != null) goto L16;
        String r17 = "";
    L17:
        String r19 = r0.getStringExtra("client_aid");
        if (r19 != null) goto L20;
        String r110 = "";
    L21:
        String r20 = r0.getStringExtra("login_scene");
        if (r20 != null) goto L24;
        String r111 = "";
    L25:
        boolean r21 = r0.getBooleanExtra("is_enable_pre_get_token", false);
        if (r0.getIntExtra("is_cold_boot_landing_page", 0) != 1) goto L28;
        boolean r22 = true;
    L29:
        r11 = new b(r12, r14, r15, r16, r17, r110, r111, r21, r22);
        goto L30
    L28:
        r22 = false;
        goto L29
    L24:
        r111 = r20;
        goto L25
    L20:
        r110 = r19;
        goto L21
    L16:
        r17 = r13;
        goto L17
    L12:
        r16 = r10;
        goto L13
    L8:
        r15 = r8;
        goto L9
    }

    public final void e(Activity r10, b r11, com.larus.account.saas.ttaccount.api.a r12) {
        r12.showLoading();
        r11.m = p.b;
        r11.n = System.currentTimeMillis();
        p.c(new c(r11, SystemClock.elapsedRealtime(), r10, this, r12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService
    public final void a(Activity r8, boolean r9, Integer r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        b r3 = this.b.get(r8);
        if (r3 != null) goto L6;
        return;
    L6:
        if ((r8 instanceof com.larus.account.saas.ttaccount.api.a) == false) goto L8;
        com.larus.account.saas.ttaccount.api.a r0 = (com.larus.account.saas.ttaccount.api.a) r8;
    L9:
        if (r0 != null) goto L13;
        this.b.remove(r8);
        r8.finish();
        return;
    L13:
        if (r3.j == true) goto L15;
        return;
    L15:
        r3.j = false;
        if (r9 == false) goto L18;
        r0.a(r8);
        if (j.m(r8).isLogin() == true) goto L30;
        d(r8, r3, "", -2, "not login");
        return;
    L30:
        if (r0.d(r8) == false) goto L33;
        com.larus.account.saas.runtime.internal.delegate.a.a.d("AccountSaasGroupAuthServer", "group auth intercepted by host after login");
        return;
    L33:
        e(r8, r3, r0);
        return;
    L18:
        if (r10 == null) goto L20;
        int r5 = r10.intValue();
    L21:
        if (r11 != null) goto L23;
        r11 = "user cancel";
    L23:
        d(r8, r3, "", r5, r11);
        return;
    L20:
        r5 = -10;
        goto L21
    L8:
        r0 = null;
        goto L9
    }

    public final void d(Activity r19, b r110, String r20, int r21, String r22) {
        Intent r4 = new Intent();
        if (r110.b != 1) goto L5;
        r4.setComponent(new ComponentName(r110.c, r110.c + ".auth.AccountGroupAuthCallbackActivity"));
    L5:
        r4.putExtra("server_auth_version", 3);
        com.bytedance.sdk.account.settings.common.a.a();
        r4.putExtra("server_app_enable_group_one_login_opt", com.bytedance.sdk.account.settings.common.a.w ? 1 : 0);
        r4.putExtra("server_app_auth_activity_on_create_time", r110.a);
        if (r20.length() <= 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        r4.putExtra("auth_token", r20);
    L11:
        r4.putExtra("code", r21);
        r4.putExtra("challenge", r110.d);
        if (r22 == null) goto L14;
        r4.putExtra("message", r22);
    L14:
        r4.putExtra("server_app_is_cold_launch", 0);
        r4.putExtra("server_app_start_request_get_token_time", r110.o);
        r4.putExtra("server_app_end_request_get_token_time", r110.p);
        r4.putExtra("server_app_auth_wait_sdk_init_time", r110.n);
        r4.putExtra("callback_result_scene", "default");
        r4.putExtra("duration_wait_get_token", 0);
        r4.putExtra("is_enable_pre_get_token", r110.h);
        r4.putExtra("is_cold_boot_landing_page", r110.i ? 1 : 0);
        JSONObject r12 = new JSONObject();
        r12.put("is_cold_start", 0);
        r12.put("duration", SystemClock.elapsedRealtime() - r110.a);
        r12.put("duration_from_app_start", 0);
        r12.put("duration_wait_sdk_init", r110.k);
        r12.put("duration_request_get_token", r110.l);
        r12.put("is_token_sdk_init", r110.m ? 1 : 0);
        com.bytedance.sdk.account.settings.common.a.a();
        r12.put("is_enable_group_one_login_opt", com.bytedance.sdk.account.settings.common.a.w ? 1 : 0);
        r12.put("server_auth_version", 3);
        r12.put("client_auth_version", r110.b);
        r12.put("error", r21);
        if (r22 != null) goto L17;
        String r2 = "";
    L18:
        r12.put("fail_info", r2);
        r12.put("callback_result_scene", "default");
        r12.put("duration_wait_get_token", 0);
        r12.put("is_enable_pre_get_token", r110.h ? 1 : 0);
        r12.put("is_cold_boot_landing_page", r110.i ? 1 : 0);
        com.bytedance.sdk.account.monitor.a.a("uc_share_login_server_app_auth_result", r12);
        if (r110.b != 1) goto L21;
        r19.startActivity(r4);
    L22:
        this.b.remove(r19);
        r19.finish();
        return;
    L21:
        r19.setResult(-1, r4);
        goto L22
    L17:
        r2 = r22;
        goto L18
    L8:
        r8 = false;
        goto L9
    }
}
