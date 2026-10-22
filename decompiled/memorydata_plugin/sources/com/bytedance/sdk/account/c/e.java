package com.bytedance.sdk.account.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.crash.entity.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class e implements WeakHandler.IHandler, com.bytedance.sdk.account.a.d {
    private static volatile com.bytedance.sdk.account.a.d L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final com.ss.android.account.b.a f3108a = null;
    private static List<a> ay;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final com.ss.android.account.b.a f3109b = null;
    static final com.ss.android.account.b.a c = null;
    static final com.ss.android.account.b.a d = null;
    static final com.ss.android.account.b.a e = null;
    static final com.ss.android.account.b.a f = null;
    static final com.ss.android.account.b.a g = null;
    static final com.ss.android.account.b.a h = null;
    static final com.ss.android.account.b.a i = null;
    static final com.ss.android.account.b.a j = null;
    static final com.ss.android.account.b.a k = null;
    static final com.ss.android.account.b.a l = null;
    static final com.ss.android.account.b.a m = null;
    static final com.ss.android.account.b.a n = null;
    static final com.ss.android.account.b.a o = null;
    static final com.ss.android.account.b.a p = null;
    static final com.ss.android.account.b.a q = null;
    static final com.ss.android.account.b.a r = null;
    static final com.ss.android.account.b.a s = null;
    static final com.ss.android.account.b.a t = null;
    static final com.ss.android.account.b.a u = null;
    static final com.ss.android.account.b.a v = null;
    static final com.ss.android.account.b.a w = null;
    static final com.ss.android.account.b.a x = null;
    public static com.ss.android.account.b.a[] y;
    public long A;
    public String B;
    public String C;
    public int D;
    public int E;
    public int F;
    public int G;
    com.bytedance.sdk.account.h.a H;
    final Context I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    protected final WeakHandler f3110J;
    private final int K;
    private String M;
    private String N;
    private String O;
    private String P;
    private int Q;
    private String R;
    private String S;
    private int T;
    private String U;
    private int V;
    private int W;
    private boolean X;
    private boolean Y;
    private String Z;
    private String aa;
    private String ab;
    private String ac;
    private int ad;
    private int ae;
    private int af;
    private String ag;
    private long ah;
    private String ai;
    private boolean aj;
    private String ak;
    private String al;
    private int am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private long aq;
    private String ar;
    private String as;
    private boolean at;
    private Set<String> au;
    private final com.ss.android.account.b.a[] av;
    private boolean aw;
    private com.bytedance.common.utility.collection.b<com.bytedance.sdk.account.a.b> ax;
    protected com.bytedance.sdk.account.a.e z;

    private interface a {
        void a(com.bytedance.sdk.account.a.a.b r1);
    }

    private static class b implements a {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.sdk.account.c.e.a
        public void a(com.bytedance.sdk.account.a.a.b r3) {
            if (r3.i == 10001) goto L5;
            return;
        L5:
            if (r3.f3096b == false) goto L13;
            com.bytedance.sdk.account.a.d r2 = d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.account.d.a().b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            r2.a(false);
            if (ZeusTransformUtils.instanceOf(r3, com.bytedance.sdk.account.a.a.c.class) == false) goto L9;
            String r4 = ((com.bytedance.sdk.account.a.a.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.sdk.account.a.a.c.class, "com.obric.memorydata.plugin")).j;
        L10:
            e.a(r2, r4);
            return;
        L9:
            r4 = "";
            goto L10
        }
    }

    private static class c implements a {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.sdk.account.c.e.a
        public void a(com.bytedance.sdk.account.a.a.b r4) {
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.account.d.a().b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, com.bytedance.sdk.account.a.a.e.class) == false) goto L10;
            com.bytedance.sdk.account.h.a r5 = ((com.bytedance.sdk.account.a.a.e) ZeusTransformUtils.preCheckCast(r4, com.bytedance.sdk.account.a.a.e.class, "com.obric.memorydata.plugin")).j;
            if (r5 != null) goto L7;
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r5, com.bytedance.sdk.account.h.a.class) == false) goto L23;
        L20:
            d.a(r3).a(r5, true);
            return;
        L23:
            return;
        L10:
            if (ZeusTransformUtils.instanceOf(r4, com.bytedance.sdk.account.a.a.d.class) == false) goto L15;
            T r6 = ((com.bytedance.sdk.account.a.a.d) ZeusTransformUtils.preCheckCast(r4, com.bytedance.sdk.account.a.a.d.class, "com.obric.memorydata.plugin")).j;
            if (ZeusTransformUtils.instanceOf(r6, com.bytedance.sdk.account.e.a.a.class) == false) goto L24;
            r5 = ((com.bytedance.sdk.account.e.a.a) ZeusTransformUtils.preCheckCast(r6, com.bytedance.sdk.account.e.a.a.class, "com.obric.memorydata.plugin")).a();
            goto L20
        L24:
            return;
        L15:
            if (ZeusTransformUtils.instanceOf(r4, com.bytedance.sdk.account.a.d.b.class) == false) goto L25;
            r5 = ((com.bytedance.sdk.account.a.d.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.sdk.account.a.d.b.class, "com.obric.memorydata.plugin")).j;
            if (r5 != null) goto L19;
            return;
        L19:
            if (ZeusTransformUtils.instanceOf(r5, com.bytedance.sdk.account.h.a.class) == true) goto L20;
            return;
        }
    }

    static {
        com.ss.android.account.b.a r0 = new com.ss.android.account.b.a("sina_weibo");
        f3108a = r0;
        com.ss.android.account.b.a r1 = new com.ss.android.account.b.a("qq_weibo");
        f3109b = r1;
        com.ss.android.account.b.a r2 = new com.ss.android.account.b.a("renren_sns");
        c = r2;
        com.ss.android.account.b.a r3 = new com.ss.android.account.b.a("kaixin_sns");
        d = r3;
        com.ss.android.account.b.a r4 = new com.ss.android.account.b.a("qzone_sns");
        e = r4;
        com.ss.android.account.b.a r5 = new com.ss.android.account.b.a("mobile");
        f = r5;
        com.ss.android.account.b.a r6 = new com.ss.android.account.b.a("flyme");
        g = r6;
        com.ss.android.account.b.a r7 = new com.ss.android.account.b.a("telecom");
        h = r7;
        com.ss.android.account.b.a r8 = new com.ss.android.account.b.a(NotificationCompat.CATEGORY_EMAIL);
        i = r8;
        com.ss.android.account.b.a r9 = new com.ss.android.account.b.a("live_stream");
        j = r9;
        com.ss.android.account.b.a r10 = new com.ss.android.account.b.a("aweme");
        k = r10;
        com.ss.android.account.b.a r11 = new com.ss.android.account.b.a("aweme_v2");
        l = r11;
        com.ss.android.account.b.a r12 = new com.ss.android.account.b.a("google");
        m = r12;
        com.ss.android.account.b.a r13 = new com.ss.android.account.b.a("facebook");
        n = r13;
        com.ss.android.account.b.a r14 = new com.ss.android.account.b.a("twitter");
        o = r14;
        com.ss.android.account.b.a r15 = new com.ss.android.account.b.a("instagram");
        p = r15;
        com.ss.android.account.b.a r16 = new com.ss.android.account.b.a("line");
        q = r16;
        com.ss.android.account.b.a r17 = new com.ss.android.account.b.a("kakaotalk");
        r = r17;
        com.ss.android.account.b.a r18 = new com.ss.android.account.b.a("vk");
        s = r18;
        com.ss.android.account.b.a r19 = new com.ss.android.account.b.a("toutiao");
        t = r19;
        com.ss.android.account.b.a r110 = new com.ss.android.account.b.a("toutiao_v2");
        u = r110;
        com.ss.android.account.b.a r111 = new com.ss.android.account.b.a("flipchat");
        v = r111;
        com.ss.android.account.b.a r112 = new com.ss.android.account.b.a("gogokid");
        w = r112;
        com.ss.android.account.b.a r113 = new com.ss.android.account.b.a("tiktok");
        x = r113;
        y = new com.ss.android.account.b.a[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113};
        ay = new ArrayList();
    }

    private e(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.K = 1000;
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.R = "";
        this.S = "";
        this.U = "";
        this.A = 0;
        this.Z = "";
        this.aa = "";
        this.ab = "";
        this.ac = "";
        this.C = "";
        this.ag = "";
        this.ah = 0;
        this.ai = "";
        this.ak = "";
        this.al = "";
        this.ao = false;
        this.aq = 0;
        this.ar = "";
        this.as = "";
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.at = false;
        this.f3110J = new WeakHandler(Looper.getMainLooper(), this);
        this.ax = new com.bytedance.common.utility.collection.b();
        AnonymousClass1 r3 = null;
        ay.add(new c(r3));
        ay.add(new b(r3));
        this.I = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.aw = false;
        this.av = y;
        h();     // Catch: Exception -> L5
    L7:
        this.z = d.b(this.I);
        return;
    L5:
        e = move-exception;
        com.ss.android.c.a("BDAccountManager", e.getMessage());
        goto L7
    }

    static com.bytedance.sdk.account.a.d a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (L != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (L != null) goto L9;
        L = new e(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return L;
    }

    private void a(SharedPreferences.Editor r10) {
        SharedPreferences.Editor r11 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r10, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        com.ss.android.account.b.a[] r0 = this.av;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        com.ss.android.account.b.a r3 = r0[r2];
        if (this.ao == true) goto L8;
        r11.putString("_platform_" + r3.f14989b, "");
    L11:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r3.c == false) goto L11;
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L14
        r4.put("mName", r3.f14989b);     // Catch: Exception -> L14
        r4.put("mNickname", r3.d);     // Catch: Exception -> L14
        r4.put("mAvatar", r3.e);     // Catch: Exception -> L14
        r4.put("mPlatformUid", r3.f);     // Catch: Exception -> L14
        r4.put("mExpire", r3.j);     // Catch: Exception -> L14
        r4.put("mExpireIn", r3.k);     // Catch: Exception -> L14
        r4.put("isLogin", r3.c);     // Catch: Exception -> L14
        r4.put("mUserId", r3.l);     // Catch: Exception -> L14
        r4.put("mModifyTime", r3.i);     // Catch: Exception -> L14
        r4.put("mSecPlatformUid", r3.g);     // Catch: Exception -> L14
        r11.putString("_platform_" + r3.f14989b, r4.toString());     // Catch: Exception -> L14
        goto L11
    L12:
        r11.apply();
    }

    private void a(SharedPreferences r17) {
        String r8 = "mPlatformUid";
        String r9 = "mAvatar";
        SharedPreferences r12 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r17, SharedPreferences.class, "com.obric.memorydata.plugin");
        boolean r13 = false;
        int r14 = 0;
    L3:
        com.ss.android.account.b.a[] r0 = this.av;
        if (r14 >= r0.length) goto L52;
        r0[r14].c = r13;
        com.ss.android.account.b.a r1 = this.av[r14];
        if (TextUtils.isEmpty(r1.f14989b) == false) goto L9;
    L8:
        String r2 = r8;
        String r15 = r9;
    L51:
        r14 = r14 + 1;
        r8 = r2;
        r9 = r15;
        r13 = false;
        goto L3
    L9:
        String r16 = r12.getString("_platform_" + r1.f14989b, null);     // Catch: Exception -> L48
        if (TextUtils.isEmpty(r16) == true) goto L8;
        JSONObject r18 = new JSONObject(r16);     // Catch: Exception -> L48
        if (com.bytedance.common.utility.h.a(r18.optString("mName", ""), r1.f14989b) == false) goto L8;
        if (r18.has("mNickname") == false) goto L19;
        r1.d = r18.optString("mNickname", "");     // Catch: Exception -> L48
    L19:
        if (r18.has(r9) == false) goto L22;
        r1.e = r18.optString(r9, "");     // Catch: Exception -> L48
    L22:
        if (r18.has(r8) == false) goto L25;
        r1.f = r18.optString(r8, "");     // Catch: Exception -> L48
    L25:
        if (r18.has("mExpire") == false) goto L28;
        r2 = r8;
        r15 = r9;
        r1.j = r18.optLong("mExpire", r1.j);     // Catch: Exception -> L46
    L30:
        if (r18.has("mExpireIn") == false) goto L33;
        r1.k = r18.optLong("mExpireIn", r1.k);     // Catch: Exception -> L46
    L33:
        if (r18.has("isLogin") == false) goto L37;
        r1.c = r18.optBoolean("isLogin", false);     // Catch: Exception -> L46
    L37:
        if (r18.has("mUserId") == false) goto L40;
        r1.l = r18.optLong("mUserId", 0);     // Catch: Exception -> L46
    L40:
        if (r18.has("mModifyTime") == false) goto L43;
        r1.i = r18.optLong("mModifyTime");     // Catch: Exception -> L46
    L43:
        if (r18.has("mSecPlatformUid") == false) goto L51;
        r1.g = r18.optString("mSecPlatformUid");     // Catch: Exception -> L46
    L46:
        e = e;
    L50:
        e.printStackTrace();
        goto L51
    L28:
        r2 = r8;
        r15 = r9;
    L48:
        e = e;
        r2 = r8;
        r15 = r9;
        goto L50
    }

    private void a(com.bytedance.sdk.account.a.a.b r4) {
        Iterator<a> r3 = ay.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin")).a(r4);
        goto L4
    }

    static /* synthetic */ void a(com.bytedance.sdk.account.a.d r2, String r3) {
        b((com.bytedance.sdk.account.a.d) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.sdk.account.a.d.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ void a(e r0) {
        r0.f();
    }

    private boolean a(com.bytedance.sdk.account.h.a r8) {
        com.ss.android.account.b.a[] r7 = this.av;
        int r0 = r7.length;
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L15;
        com.ss.android.account.b.a r3 = r7[r1];
        com.ss.android.account.b.a r4 = (com.ss.android.account.b.a) ZeusTransformUtils.preCheckCast(r8.e().get(r3.f14989b), com.ss.android.account.b.a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
        if (r3.c == false) goto L9;
        r2 = true;
    L9:
        r3.a();
    L14:
        r1 = r1 + 1;
        goto L3
    L11:
        if (r3.c == true) goto L13;
        r3.c = true;
        r2 = true;
    L13:
        r3.j = r4.j;
        r3.k = r4.k;
        r3.d = r4.d;
        r3.e = r4.e;
        r3.f = r4.f;
        r3.l = r4.l;
        r3.i = r4.i;
        r3.g = r4.g;
        goto L14
    L15:
        return r2;
    }

    private static void b(com.bytedance.sdk.account.a.d r2, String r3) {
        com.bytedance.sdk.account.a.d r4 = (com.bytedance.sdk.account.a.d) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.sdk.account.a.d.class, "com.obric.memorydata.plugin");
        com.bytedance.sdk.account.a.a r0 = new com.bytedance.sdk.account.a.a(1);
        r0.c = d(r3);
        r4.a(r0);
    }

    private void b(h r1) {
        if (r1.f3117a == null) goto L8;
        com.bytedance.sdk.account.a.a.a r0 = r1.f3117a;
        r0.f(r1.f3118b);
        com.bytedance.sdk.account.a.c.a r2 = r0.f3105a;
        if (r2 == null) goto L9;
        r2.a();
        return;
    L9:
        return;
    }

    private void b(boolean r5) {
        com.bytedance.sdk.account.a.a r0 = new com.bytedance.sdk.account.a.a(0);
        r0.f3093b = r5;
        com.bytedance.common.utility.collection.b<com.bytedance.sdk.account.a.b> r6 = this.ax;
        monitor-enter(r6);
        Iterator<com.bytedance.sdk.account.a.b> r4 = this.ax.iterator();     // Catch: Throwable -> L10
    L6:
        if (r4.hasNext() == false) goto L8;
        ((com.bytedance.sdk.account.a.b) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.sdk.account.a.b.class, "com.obric.memorydata.plugin")).a(r0);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static int d(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return 0;
    L5:
        r6.hashCode();
        byte r2 = -1;
        switch(r6.hashCode()) {
            case -2085722047: goto L17;
            case -355378050: goto L13;
            case 90865289: goto L9;
            default: goto L20;
        };
    L20:
        switch(r2) {
            case 0: goto L24;
            case 1: goto L25;
            case 2: goto L27;
            default: goto L26;
        };
    L25:
        return 0;
    L26:
        return 3;
    L27:
        return 1;
    L24:
        return 2;
    L9:
        if (r6.equals("sdk_expired_logout") == false) goto L20;
        r2 = 2;
        goto L20
    L13:
        if (r6.equals("user_logout") == false) goto L20;
        r2 = 1;
        goto L20
    L17:
        if (r6.equals("cancel_account_logout") == false) goto L20;
        r2 = 0;
        goto L20
    }

    private void f() {
        if (this.f3110J == null) goto L9;
        long r0 = 600000;
        if (com.ss.android.account.d.b() == null) goto L7;
        r0 = com.ss.android.account.d.b().a();
    L7:
        this.f3110J.sendEmptyMessageDelayed(1000, r0);
        return;
    }

    private void g() {
        com.bytedance.sdk.account.a.a r0 = new com.bytedance.sdk.account.a.a(2);
        r0.f3093b = false;
        com.bytedance.common.utility.collection.b<com.bytedance.sdk.account.a.b> r1 = this.ax;
        monitor-enter(r1);
        Iterator<com.bytedance.sdk.account.a.b> r5 = this.ax.iterator();     // Catch: Throwable -> L10
    L6:
        if (r5.hasNext() == false) goto L8;
        ((com.bytedance.sdk.account.a.b) ZeusTransformUtils.preCheckCast(r5.next(), com.bytedance.sdk.account.a.b.class, "com.obric.memorydata.plugin")).a(r0);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void h() {
        if (this.aw == false) goto L5;
        return;
    L5:
        this.aw = true;
        SharedPreferences r1 = this.I.getSharedPreferences("com.bytedance.sdk.account_setting", 0);
        this.ao = r1.getBoolean("is_login", false);
        this.ah = r1.getLong(Header.KEY_USER_ID, 0);
        this.ai = r1.getString("sec_user_id", "");
        this.an = r1.getBoolean("is_new_user", false);
        this.al = r1.getString("session_key", "");
        this.aa = r1.getString("user_name", "");
        this.T = r1.getInt("user_gender", 0);
        this.ab = r1.getString("screen_name", "");
        this.ak = r1.getString("verified_content", "");
        this.aj = r1.getBoolean("user_verified", false);
        this.N = r1.getString("avatar_url", "");
        this.P = r1.getString("user_birthday", "");
        this.M = r1.getString("user_location", "");
        this.U = r1.getString("user_industry", "");
        this.S = r1.getString("user_email", "");
        this.Z = r1.getString("user_mobile", "");
        this.ag = r1.getString("user_decoration", "");
        this.R = r1.getString("user_description", "");
        this.X = r1.getBoolean("is_recommend_allowed", false);
        this.ac = r1.getString("recommend_hint_message", "");
        this.V = r1.getInt("is_blocked", 0);
        this.W = r1.getInt("is_blocking", 0);
        this.Y = r1.getBoolean("is_toutiao", false);
        this.ap = r1.getBoolean("user_has_pwd", false);
        this.am = r1.getInt("country_code", 0);
        this.aq = r1.getLong("pgc_mediaid", 0);
        this.ar = r1.getString("pgc_avatar_url", "");
        this.as = r1.getString("pgc_name", "");
        this.Q = r1.getInt("can_be_found_by_phone", 1);
        this.ad = r1.getInt("can_sync_share", 0);
        this.ae = r1.getInt("user_privacy_extend", 0);
        this.af = r1.getInt("user_privacy_extend_value", 2147483646);
        this.O = r1.getString("bg_img_url", "");
        this.B = r1.getString("multi_sids", "");
        this.E = r1.getInt("following_count", 0);
        this.F = r1.getInt("followers_count", 0);
        this.G = r1.getInt("visitors_count", 0);
        this.A = r1.getLong("media_id", 0);
        this.O = r1.getString("bg_img_url", "");
        this.D = r1.getInt("display_ocr_entrance", 0);
        this.C = r1.getString("user_auth_info", "");
        this.at = r1.getBoolean("is_visitor_account", false);
        this.au = r1.getStringSet("has_update_sec_uids", new HashSet());
        boolean r0 = this.ao;
        if (r0 == true) goto L8;
    L11:
        if (r0 == false) goto L13;
    L15:
        a(r1);
        long r2 = this.ah;
        if (r2 <= 0) goto L18;
        a(r2, this.al);
    L18:
        this.H = e();
        return;
    L13:
        if (this.ah <= 0) goto L15;
    L10:
        this.ah = 0;
        this.ai = "";
        goto L15
    L8:
        if (this.ah > 0) goto L11;
        this.ao = false;
        goto L10
    }

    void a(long r1, String r3) {
        com.bytedance.sdk.account.utils.b r0 = com.ss.android.account.d.a().f();     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.a(r1, r3);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.sdk.account.a.d
    public void a(com.bytedance.sdk.account.a.a r5) {
        com.bytedance.common.utility.collection.b<com.bytedance.sdk.account.a.b> r0 = this.ax;
        monitor-enter(r0);
        Iterator<com.bytedance.sdk.account.a.b> r4 = this.ax.iterator();     // Catch: Throwable -> L12
    L6:
        if (r4.hasNext() == false) goto L10;
        com.bytedance.sdk.account.a.b r1 = (com.bytedance.sdk.account.a.b) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.sdk.account.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L6;
        r1.a(r5);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void a(h r2) {
        if (r2.f3118b == 0) goto L6;
        a(r2.f3118b);
        b(r2);
        return;
    }

    @Override // com.bytedance.sdk.account.a.d
    public void a(com.bytedance.sdk.account.h.a r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        long r0 = r10.d();
        boolean r7 = false;
        boolean r8 = true;
        if (r0 <= 0) goto L7;
        this.H = r10;
        if (this.ao == true) goto L22;
        this.ao = true;
        CookieSyncManager.getInstance().sync();     // Catch: Throwable -> L19
    L21:
        boolean r2 = true;
    L24:
        if (r10.e == false) goto L27;
        this.an = true;
    L27:
        if (this.ah == r0) goto L30;
        this.ah = r0;
        r2 = true;
        r7 = true;
    L30:
        if (com.bytedance.common.utility.h.a(this.ai, r10.i) == true) goto L33;
        this.ai = r10.i;
        com.bytedance.sdk.account.save.b.a(this.I, r10.d() + "", r10.j(), null);
        r2 = true;
    L33:
        if (com.bytedance.common.utility.h.a(this.al, r10.g()) == true) goto L36;
        this.al = r10.g();
        r2 = true;
        r7 = true;
    L36:
        if (com.bytedance.common.utility.h.a(this.Z, r10.h()) == true) goto L39;
        this.Z = r10.h();
        r2 = true;
    L39:
        if (com.bytedance.common.utility.h.a(this.S, r10.i()) == true) goto L42;
        this.S = r10.i();
        r2 = true;
    L42:
        if (this.ap == r10.j) goto L45;
        this.ap = r10.j;
        r2 = true;
    L45:
        if (this.am == r10.d) goto L48;
        this.am = r10.d;
        r2 = true;
    L48:
        if (this.at == r10.k) goto L51;
        this.at = r10.k;
        r2 = true;
    L51:
        if (a(r10) == false) goto L54;
        r2 = true;
    L54:
        if (ZeusTransformUtils.instanceOf(r10, com.ss.android.account.b.class) == false) goto L148;
        com.ss.android.account.b r1 = (com.ss.android.account.b) ZeusTransformUtils.preCheckCast(r10, com.ss.android.account.b.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(this.aa, r1.o) == true) goto L59;
        this.aa = r1.o;
        r2 = true;
    L59:
        if (com.bytedance.common.utility.h.a(this.ab, r1.r) == true) goto L62;
        this.ab = r1.r;
        r2 = true;
    L62:
        if (com.bytedance.common.utility.h.a(this.ak, r1.s) == true) goto L65;
        this.ak = r1.s;
        r2 = true;
    L65:
        if (this.T == r1.K) goto L68;
        this.T = r1.K;
        r2 = true;
    L68:
        if (com.bytedance.common.utility.h.a(this.R, r1.p) == true) goto L71;
        this.R = r1.p;
        r2 = true;
    L71:
        if (com.bytedance.common.utility.h.a(this.N, r1.q) == true) goto L74;
        this.N = r1.q;
        r2 = true;
    L74:
        if (this.aj == r1.M) goto L77;
        this.aj = r1.M;
        r2 = true;
    L77:
        if (com.bytedance.common.utility.h.a(this.P, r1.N) == true) goto L80;
        this.P = r1.N;
        r2 = true;
    L80:
        if (com.bytedance.common.utility.h.a(this.M, r1.O) == true) goto L83;
        this.M = r1.O;
        r2 = true;
    L83:
        if (com.bytedance.common.utility.h.a(this.U, r1.P) == true) goto L86;
        this.U = r1.P;
        r2 = true;
    L86:
        if (this.Y == r1.S) goto L89;
        this.Y = r1.S;
        r2 = true;
    L89:
        if (this.W == r1.Q) goto L92;
        this.W = r1.Q;
        r2 = true;
    L92:
        if (this.V == r1.R) goto L95;
        this.V = r1.R;
        r2 = true;
    L95:
        if (this.X == r1.w) goto L98;
        this.X = r1.w;
        r2 = true;
    L98:
        if (com.bytedance.common.utility.h.a(this.ac, r1.x) == true) goto L101;
        this.ac = r1.x;
        r2 = true;
    L101:
        if (this.Q == r1.A) goto L104;
        this.Q = r1.A;
        r2 = true;
    L104:
        if (this.ae == r1.C) goto L107;
        this.ae = r1.C;
        r2 = true;
    L107:
        if (this.af == r1.D) goto L110;
        this.af = r1.D;
        r2 = true;
    L110:
        if (this.ad == r1.B) goto L113;
        this.ad = r1.B;
        r2 = true;
    L113:
        if (com.bytedance.common.utility.h.a(this.ag, r1.y) == true) goto L116;
        this.ag = r1.y;
        r2 = true;
    L116:
        if (this.A == r1.H) goto L119;
        this.A = r1.H;
        r2 = true;
    L119:
        if (com.bytedance.common.utility.h.a(this.ar, r1.u) == true) goto L122;
        this.ar = r1.u;
        r2 = true;
    L122:
        if (com.bytedance.common.utility.h.a(this.as, r1.v) == true) goto L125;
        this.as = r1.v;
        r2 = true;
    L125:
        if (this.aq == r1.t) goto L128;
        this.aq = r1.t;
        r2 = true;
    L128:
        if (TextUtils.isEmpty(this.O) == true) goto L134;
        if (TextUtils.isEmpty(r1.I) == true) goto L134;
        if (com.bytedance.common.utility.h.a(this.O, r1.I) == true) goto L134;
    L141:
        this.O = r1.I;
        r2 = true;
    L143:
        if (this.D == r1.f14987J) goto L146;
        this.D = r1.f14987J;
        r2 = true;
    L146:
        if (com.bytedance.common.utility.h.a(this.C, r1.z) == true) goto L148;
        this.C = r1.z;
        r2 = true;
    L134:
        if (TextUtils.isEmpty(this.O) == false) goto L138;
        if (TextUtils.isEmpty(r1.I) == false) goto L141;
    L138:
        if (TextUtils.isEmpty(this.O) == true) goto L143;
        if (TextUtils.isEmpty(r1.I) == false) goto L143;
    L148:
        this.ao = true;
        r7 = r7;
        r7 = r2;
    L149:
        if (r7 == false) goto L151;
        d();
    L151:
        if (r7 == false) goto L154;
        if (r11 == false) goto L154;
        b(r8);
    L154:
        if (r7 == false) goto L158;
        com.bytedance.sdk.account.save.entity.c r12 = com.bytedance.sdk.account.save.b.a(r10);
        if (r12 == null) goto L158;
        com.bytedance.sdk.account.save.b.a(r12, new AnonymousClass2(this));
    L158:
        if (r7 == false) goto L164;
        a(this.ah, this.al);
        return;
    L164:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L21
    L22:
        r2 = false;
        goto L24
    L7:
        if (this.ao == false) goto L13;
        this.an = false;
        this.ao = false;
        this.ah = 0;
        this.ai = "";
        this.aa = "";
        this.T = 0;
        this.ab = "";
        this.ak = "";
        this.N = "";
        this.P = "";
        this.M = "";
        this.U = "";
        this.ag = "";
        this.R = "";
        this.aj = false;
        this.X = false;
        this.al = "";
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.V = 0;
        this.W = 0;
        this.Y = false;
        this.ap = false;
        this.A = 0;
        this.O = "";
        this.D = 0;
        this.ar = "";
        this.aq = 0;
        this.as = "";
        this.C = "";
        this.at = false;
        this.H = null;
        com.ss.android.account.b.a[] r3 = this.av;
        int r4 = r3.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L11;
        r3[r5].a();
        r5 = r5 + 1;
        goto L9
    L11:
        r7 = true;
    L13:
        r8 = r7;
        goto L149
    }

    @Override // com.bytedance.sdk.account.a.d
    public void a(String r3) {
        this.B = r3;
        this.I.getSharedPreferences("com.bytedance.sdk.account_setting", 0).edit().putString("multi_sids", r3).apply();
    }

    @Override // com.bytedance.sdk.account.a.d
    public void a(boolean r5) {
        if (this.ao == false) goto L8;
        int r0 = 0;
        this.an = false;
        this.ao = false;
        this.ah = 0;
        this.al = "";
        this.ai = "";
        a(0, "");
        this.aa = "";
        this.T = 0;
        this.ab = "";
        this.ak = "";
        this.R = "";
        this.M = "";
        this.U = "";
        this.V = 0;
        this.W = 0;
        this.ag = "";
        this.P = "";
        this.aj = false;
        this.X = false;
        this.Y = false;
        this.am = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.ap = false;
        this.A = 0;
        this.O = "";
        this.S = "";
        this.Z = "";
        this.D = 0;
        this.ar = "";
        this.aq = 0;
        this.as = "";
        this.C = "";
        this.at = false;
        com.ss.android.account.b.a[] r1 = this.av;
        int r2 = r1.length;
    L5:
        if (r0 >= r2) goto L7;
        r1[r0].a();
        r0 = r0 + 1;
        goto L5
    L7:
        d();
    L8:
        if (r5 == false) goto L12;
        g();
        return;
    }

    @Override // com.bytedance.sdk.account.a.d
    public boolean a() {
        return this.ao;
    }

    @Override // com.bytedance.sdk.account.a.d
    public String b() {
        return this.B;
    }

    @Override // com.bytedance.sdk.account.a.d
    public void b(String r3) {
        if (this.au != null) goto L5;
        this.au = new HashSet();
    L5:
        this.au.add(r3);
        this.I.getSharedPreferences("com.bytedance.sdk.account_setting", 0).edit().putStringSet("has_update_sec_uids", this.au).apply();
    }

    Handler c() {
        return this.f3110J;
    }

    public void c(String r3) {
        if (a() == true) goto L6;
        f();
        return;
    L6:
        com.bytedance.sdk.account.a.e r0 = this.z;
        if (r0 == null) goto L10;
        r0.a(r3, new AnonymousClass1(this));
        return;
    }

    public void d() {
        SharedPreferences.Editor r0 = this.I.getSharedPreferences("com.bytedance.sdk.account_setting", 0).edit();
        a(r0);
        r0.remove("session");
        r0.putBoolean("is_login", this.ao);
        r0.putLong(Header.KEY_USER_ID, this.ah);
        r0.putString("sec_user_id", this.ai);
        r0.putString("session_key", this.al);
        r0.putString("user_name", this.aa);
        r0.putString("verified_content", this.ak);
        r0.putInt("user_gender", this.T);
        r0.putString("screen_name", this.ab);
        r0.putBoolean("user_verified", this.aj);
        r0.putString("avatar_url", this.N);
        r0.putBoolean("is_new_user", this.an);
        r0.putString("user_email", this.S);
        r0.putString("user_mobile", this.Z);
        r0.putInt("is_blocked", this.V);
        r0.putInt("is_blocking", this.W);
        r0.putBoolean("is_toutiao", this.Y);
        r0.putBoolean("user_has_pwd", this.ap);
        r0.putInt("country_code", this.am);
        r0.putString("user_location", this.M);
        r0.putString("user_industry", this.U);
        r0.putString("user_decoration", this.ag);
        r0.putString("user_birthday", this.P);
        r0.putLong("pgc_mediaid", this.aq);
        r0.putString("pgc_avatar_url", this.ar);
        r0.putString("pgc_name", this.as);
        r0.putString("user_description", this.R);
        r0.putBoolean("is_recommend_allowed", this.X);
        r0.putString("recommend_hint_message", this.ac);
        r0.putInt("can_be_found_by_phone", this.Q);
        r0.putInt("can_sync_share", this.ad);
        r0.putInt("following_count", this.E);
        r0.putInt("followers_count", this.F);
        r0.putInt("visitors_count", this.G);
        r0.putLong("media_id", this.A);
        r0.putString("bg_img_url", this.O);
        r0.putInt("display_ocr_entrance", this.D);
        r0.putString("user_auth_info", this.C);
        r0.putInt("user_privacy_extend", this.ae);
        r0.putInt("user_privacy_extend_value", this.af);
        r0.putBoolean("is_visitor_account", this.at);
        com.bytedance.common.utility.c.a.a(r0);
    }

    public com.ss.android.account.b e() {
        com.ss.android.account.b r0 = new com.ss.android.account.b();
        r0.f3123a = this.ah;
        r0.e = this.an;
        r0.f = this.al;
        r0.o = this.aa;
        r0.K = this.T;
        r0.r = this.ab;
        r0.s = this.ak;
        r0.q = this.N;
        r0.N = this.P;
        r0.M = this.aj;
        r0.O = this.M;
        r0.P = this.U;
        r0.y = this.ag;
        r0.p = this.R;
        r0.w = this.X;
        r0.x = this.ac;
        r0.A = this.Q;
        r0.B = this.ad;
        r0.I = this.O;
        r0.E = this.E;
        r0.F = this.F;
        r0.G = this.G;
        r0.H = this.A;
        r0.h = this.S;
        r0.z = this.C;
        r0.f14987J = this.D;
        r0.D = this.af;
        r0.C = this.ae;
        r0.R = this.V;
        r0.Q = this.W;
        r0.S = this.Y;
        r0.T = this.ap;
        r0.u = this.ar;
        r0.t = this.A;
        r0.v = this.as;
        r0.d = this.am;
        r0.i = this.ai;
        r0.k = this.at;
        com.ss.android.account.b.a[] r6 = this.av;
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        com.ss.android.account.b.a r3 = r6[r2];
        if (TextUtils.isEmpty(r3.f14989b) == true) goto L11;
        if (r3.c == false) goto L11;
        r0.e().put(r3.f14989b, r3);
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return r0;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r4) {
        if (r4.what != 100) goto L8;
        if (ZeusTransformUtils.instanceOf(r4.obj, h.class) == false) goto L8;
        a((h) ZeusTransformUtils.preCheckCast(r4.obj, h.class, "com.obric.memorydata.plugin"));
    L8:
        if (r4.what != 1000) goto L11;
        this.f3110J.removeMessages(1000);
        c("polling");
        return;
    }
}
