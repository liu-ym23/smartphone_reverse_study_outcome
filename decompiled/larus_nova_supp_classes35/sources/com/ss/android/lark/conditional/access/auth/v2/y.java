package com.ss.android.lark.conditional.access.auth.v2;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y {
    public static com.ss.android.lark.storage.kv.repo.a a;
    public static com.ss.android.lark.storage.kv.repo.a b;
    public static com.ss.android.lark.storage.kv.repo.a c;
    public static int d;
    public static int e;
    public static int f;
    public static final ScheduledExecutorService g = null;
    public static j h;

    public y() {
    }

    static {
        e = ChameleonWebViewClient.DEFAULT_SAFE_TIME;
        g = CoreThreadPool.getDefault().getSingleScheduledThreadPool("dynamic_point_thread");
    }

    public static boolean b() {
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.a == true) goto L5;
    L7:
        return false;
    L5:
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.b == true) goto L7;
        return true;
    }

    public static void c() {
        a = com.ss.android.lark.security.compliance.infra.storage.d.b("file_auth_policy", 2);
        c = com.ss.android.lark.security.compliance.infra.storage.d.b("file_auth_policy_object", 2);
        if (w4c.c.a().j() == false) goto L6;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "initStorage(), disableDynamicCache is true");
        return;
    L6:
        boolean r0 = com.ss.android.lark.security.compliance.api.model.filepolicy.g.a;
        com.ss.android.lark.security.compliance.api.model.filepolicy.g.a = idb.f.a().isEnable("lark.security.file_messenger_share_optimization");
        com.ss.android.lark.security.compliance.api.model.filepolicy.g.b = w4c.c.a().I();
        com.ss.android.lark.security.compliance.api.model.filepolicy.g.c = w4c.c.a().H();
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "initStorage(), isImShareOptEnabled=" + com.ss.android.lark.security.compliance.api.model.filepolicy.g.a + ", enableImReadPolicyCenter=" + com.ss.android.lark.security.compliance.api.model.filepolicy.g.b + ", enableImReadInvalidDataOpt=" + com.ss.android.lark.security.compliance.api.model.filepolicy.g.c + ", enableImFileReadOpt=" + com.ss.android.lark.security.compliance.api.model.filepolicy.g.a);
        if (b() == false) goto L9;
        String r2 = u4c.a.a;
        u4c.a.a("file_auth_im_share_opt", MapsKt.mapOf(new Pair("enabled", 1)), null, null, 0, 28);
        ScsLogger.d("SecurityPolicy_PolicyStorage", "im file read opt enabled");
        h = new j(w4c.c.a().v().a(), ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d());
        return;
    L9:
        String r3 = u4c.a.a;
        int r10 = 0;
        u4c.a.a("file_auth_im_share_opt", MapsKt.mapOf(new Pair("enabled", 0)), null, null, 0, 28);
        ScsLogger.d("SecurityPolicy_PolicyStorage", "im file read opt disabled");
        com.ss.android.lark.storage.kv.repo.a r4 = com.ss.android.lark.security.compliance.infra.storage.d.b("imFileRead_repo", 2);
        b = r4;
        d = r4.getInt("IM_FILE_READ_HEAD", 0);
        com.ss.android.lark.storage.kv.repo.a r5 = b;
        if (r5 == null) goto L12;
        r10 = r5.getInt("IM_FILE_READ_COUNT", 0);
    L12:
        f = r10;
        com.ss.android.lark.storage.kv.repo.a r6 = b;
        int r7 = ChameleonWebViewClient.DEFAULT_SAFE_TIME;
        if (r6 == null) goto L15;
        r7 = r6.getInt("IM_FILE_READ_MAX_CAPACITY", ChameleonWebViewClient.DEFAULT_SAFE_TIME);
    L15:
        e = r7;
        int r8 = w4c.c.a().w().a();
        if (r8 == e) goto L24;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "initStorage(), imFileReadCurrentMaxCapacity is " + e + ", newSize is " + r8);
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.a == true) goto L25;
        int r9 = e;
        int r11 = w4c.c.a().w().a();
        Ref.IntRef r12 = new Ref.IntRef();
        r12.element = d;
        com.ss.android.lark.storage.kv.repo.a r13 = b;
        if (r13 == null) goto L26;
        g.execute(new m(r9, r12, r13, r11));
        return;
    L26:
        return;
    L25:
        return;
    }

    public static final Pair a(int r4) {
        if (b() == true) goto L22;
        com.ss.android.lark.storage.kv.repo.a r0 = b;
        if (r0 == null) goto L19;
        String r5 = "index_" + r4;
        if (r0.a(r5, String.class) == false) goto L20;
        String r6 = r0.getString(r5, null);
        if (r6 != null) goto L13;
        r6 = BuildConfig.FLAVOR;
    L13:
        if (r6.length() <= 0) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L18;
        return null;
    L18:
        return TuplesKt.to(r6, r0.getJSONObject(r6, d.class));
    L15:
        r2 = false;
        goto L16
    L20:
        return null;
    L19:
        return null;
    L22:
        return null;
    }
}
