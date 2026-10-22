package com.larus.bmhome.chat.api;

import android.os.SystemClock;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.x1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.q4;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static final /* synthetic */ int r = 0;
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Function0<Boolean> e;
    public final Function0<Boolean> f;
    public final Function0<Boolean> g;
    public final Function0<String> h;
    public final Function0<List<Pair<String, Object>>> i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public Long p;
    public Job q;

    public static final class a {
    }

    static {
    }

    public static q4 c() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.D();
        x1 r1 = x1.a;
        return kc9.f.a();
    L6:
        return new q4(false, false, false);
    }

    public final void b() {
        Job r0 = this.q;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.q = null;
    }

    public final void a(JSONObject r9) {
        r9.put("mixed_feed", this.b ? 1 : 0);
        r9.put("side_bar", this.c ? 1 : 0);
        r9.put("is_flow_feed", this.d ? 1 : 0);
        AccountService r0 = AccountService.a;
        r9.put("is_login", r0.isLogin().booleanValue() ? 1 : 0);
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        int r3 = 0;
    L8:
        r9.put("is_new_install", r3);
        r9.put("is_new_user", r0.isNewUser() ? 1 : 0);
        q4 r4 = c();
        if (r4.c == false) goto L12;
        String r5 = "office_sdk_user_ready";
    L18:
        r9.put("office_sdk_status", r5);
        r9.put("migrate_status", ((Boolean) this.g.invoke()).booleanValue() ? 1 : 0);
        com.larus.platform.exp.q r6 = com.larus.platform.exp.q.a;
        r9.put("init_im_enable", r6.b() ? 1 : 0);
        LarkSocialExp.a.getClass();
        r9.put("im_enable", LarkSocialExp.f() ? 1 : 0);
        r6.a();
        r9.put("boot_type", com.larus.platform.exp.q.d.get());
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L28;
        r7.r();
        Long r8 = Long.valueOf(mc9.a.a.g());
        if (r8.longValue() <= 0) goto L23;
        r2 = true;
    L23:
        if (r2 == true) goto L26;
        r8 = null;
    L26:
        if (r8 == null) goto L28;
        long r10 = r8.longValue();
        long r11 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r10, 0);
    L29:
        r9.put("cold_start_time", r11);
        r9.put("previous_page", this.h.invoke());
        Iterator r12 = ((Iterable) this.i.invoke()).iterator();
    L31:
        if (r12.hasNext() == false) goto L35;
        Pair r13 = (Pair) r12.next();
        String r14 = (String) r13.component1();
        Object r15 = r13.component2();
        if (r9.has(r14) == true) goto L31;
        r9.put(r14, r15);
        goto L31
    L35:
        return;
    L28:
        r11 = -1;
        goto L29
    L12:
        if (r4.b == false) goto L15;
        r5 = "office_sdk_global_ready";
        goto L18
    L15:
        if (r4.a == false) goto L17;
        r5 = "office_sdk_init_triggered";
        goto L18
    L17:
        r5 = "office_sdk_not_init_triggered";
        goto L18
    L5:
        if (r1.o0() != true) goto L7;
        r3 = 1;
        goto L8
    }

    public final void d(LifecycleCoroutineScope r8) {
        Intrinsics.checkNotNullParameter(r8, "lifecycleScope");
        if (this.m == false) goto L5;
        return;
    L5:
        this.m = true;
        this.o = SystemClock.elapsedRealtime();
        q4 r0 = c();
        this.q = BuildersKt.launch$default(r8, Dispatchers.getMain(), null, new DouBaoConversationFeedMonitor$markPageCreate$1(this, null), 2, null);
        FLogger.a.i("DouBaoConversationFeedMonitor", "markPageCreate scene=" + this.a + " initState=" + r0);
    }

    public final void f(int r6) {
        FLogger.a.i("DouBaoConversationFeedMonitor", "scene=" + this.a + " conv size=" + r6);
        JSONObject r0 = new JSONObject();
        r0.put("scene", this.a);
        r0.put("is_flow_feed", this.d ? 1 : 0);
        Iterator r1 = ((Iterable) this.i.invoke()).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Pair r2 = (Pair) r1.next();
        String r3 = (String) r2.component1();
        Object r4 = r2.component2();
        if (r0.has(r3) == true) goto L4;
        r0.put(r3, r4);
        goto L4
    L9:
        if (r6 <= 0) goto L11;
        r0.put("result", 1);
    L12:
        com.larus.platform.service.o.a.reportEvent("feed_list_show_monitor", r0);
        return;
    L11:
        r0.put("result", 0);
        r0.put("err_code", "-1");
        r0.put("err_msg", "result is empty");
        goto L12
    }

    public final void g(int r9) {
        if (this.j == false) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime();
        this.p = Long.valueOf(r0);
        JSONObject r2 = new JSONObject();
        r2.put("scene", this.a);
        r2.put("duration_ms", RangesKt.coerceAtLeast(r0 - this.o, 0));
        r2.put("launch_duration_ms", RangesKt.coerceAtLeast(r0 - ((Number) AppHost.a.getAppStartTime().getFirst()).longValue(), 0));
        e(r2, r9);
        a(r2);
        FLogger.a.i("DouBaoConversationFeedMonitor", "report event=cvs_list_first_in payload=" + r2);
        com.larus.platform.service.o.a.reportEvent("cvs_list_first_in", r2);
        this.j = true;
    }

    public final void h(int r12) {
        this.n = true;
        b();
        if (this.k == false) goto L5;
        return;
    L5:
        long r1 = SystemClock.elapsedRealtime();
        Long r3 = this.p;
        if (r3 == null) goto L8;
        long r4 = r3.longValue();
    L9:
        JSONObject r5 = new JSONObject();
        r5.put("scene", this.a);
        r5.put("duration_ms", RangesKt.coerceAtLeast(r1 - this.o, 0));
        r5.put("launch_duration_ms", RangesKt.coerceAtLeast(r1 - ((Number) AppHost.a.getAppStartTime().getFirst()).longValue(), 0));
        r5.put("wait_loaded_interval_ms", RangesKt.coerceAtLeast(r1 - r4, 0));
        e(r5, r12);
        a(r5);
        FLogger.a.i("DouBaoConversationFeedMonitor", "report event=cvs_list_first_visible payload=" + r5);
        com.larus.platform.service.o.a.reportEvent("cvs_list_first_visible", r5);
        this.k = true;
        return;
    L8:
        r4 = r1;
        goto L9
    }

    public static void e(JSONObject r3, int r4) {
        if (z2.a.d1() != 3) goto L5;
        int r0 = 1;
    L6:
        r3.put("is_landing_to_cvs_list", r0);
        r3.put("cvs_list_size", r4);
        r3.put("cvs_list_load_count", 0);
        r3.put("cvs_total_size", 0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public /* synthetic */ o(String r13, boolean r14, Function0 r15, Function0 r16, com.larus.larkfeed.impl.mixedfeed.d r17, Function0 r18, int r19) {
        if ((r19 & 2) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r19 & 16) == 0) goto L9;
        Function0 r7 = new l();
    L11:
        if ((r19 & 32) == 0) goto L13;
        Function0 r8 = new l();
    L15:
        if ((r19 & 64) == 0) goto L17;
        com.larus.larkfeed.impl.mixedfeed.d r9 = new l();
    L19:
        if ((r19 & 128) == 0) goto L21;
        Function0 r10 = new m();
    L23:
        if ((r19 & 256) == 0) goto L25;
        Function0 r0 = new n();
    L26:
        this(r13, r4, false, false, r7, r8, r9, r10, r0);
        return;
    L25:
        r0 = null;
        goto L26
    L21:
        r10 = r18;
        goto L23
    L17:
        r9 = r17;
        goto L19
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(String r2, boolean r3, boolean r4, boolean r5, Function0<Boolean> r6, Function0<Boolean> r7, Function0<Boolean> r8, Function0<String> r9, Function0<? extends List<? extends Pair<String, ? extends Object>>> r10) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r6, "feedContainerExistsProvider");
        Intrinsics.checkNotNullParameter(r7, "feedEmptyProvider");
        Intrinsics.checkNotNullParameter(r8, "migrateFinishedProvider");
        Intrinsics.checkNotNullParameter(r9, "previousPageProvider");
        Intrinsics.checkNotNullParameter(r10, "tagsProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.o = SystemClock.elapsedRealtime();
    }
}
