package d31;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.vm.g;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.badger.collect.impl.constants.Constants;
import cy0.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ int o = 0;
    public long a;
    public long b;
    public int c;
    public long d;
    public int e;
    public int f;
    public float g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final com.bytedance.android.live.revlink.impl.global.c n;

    public static final class a {
    }

    static {
    }

    public final String a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.n;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r2 = r0.getLinkPlayHelper();
    L7:
        if (r2 != null) goto L9;
    L11:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.n;
        if (r3 == null) goto L14;
        r1 = r3.getLinkPlayHelper();
    L14:
        if (r1 != null) goto L16;
    L18:
        return "link_participate";
    L16:
        if (r1.c() != true) goto L18;
        return "pk_participate";
    L9:
        if (r2.d() != true) goto L11;
        return "pve_participate";
    L5:
        r2 = null;
        goto L7
    }

    public final void c() {
        if (this.d > 0) goto L5;
        return;
    L5:
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis() - this.d;
        if (r1 <= 0) goto L13;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.n;
        if (r2 == null) goto L10;
        f r3 = r2.y2();
    L11:
        if (r3 == null) goto L13;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("current_scene", String.valueOf(0));
        r4.put(Constants.Keys.duration, String.valueOf(r1));
        Unit r5 = Unit.INSTANCE;
        r3.g("linking_invite_panel_load", r4);
        goto L13
    L10:
        r3 = null;
    L13:
        this.d = -1;
    }

    public final void e() {
        if (this.b > 0) goto L5;
        return;
    L5:
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis() - this.b;
        this.e = 0;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.n;
        if (r3 == null) goto L8;
        f r4 = r3.y2();
    L10:
        if (r4 == null) goto L12;
        r4.g("linking_invite_panel_open", MapsKt.mapOf(new Pair[]{TuplesKt.to(Constants.Keys.duration, String.valueOf(r1)), TuplesKt.to("last_show_interval", String.valueOf(r1)), TuplesKt.to("last_show_type", String.valueOf(this.m)), TuplesKt.to("current_scene", String.valueOf(0))}));
    L12:
        this.m = 1;
        if (this.i == false) goto L19;
        this.i = false;
        if (this.h == false) goto L18;
        this.k++;
        goto L19
    L18:
        this.l++;
    L19:
        this.b = System.currentTimeMillis();
        return;
    L8:
        r4 = null;
        goto L10
    }

    public e(LinkFakeGlobalService r3) {
        this.n = r3;
        this.a = -1;
        this.b = -1;
        this.f = -1;
    }

    public final void b(int r8) {
        if (this.a > 0) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.global.c r0 = this.n;
        if (r0 == null) goto L8;
        f r1 = r0.y2();
    L10:
        if (r1 == null) goto L12;
        i97.a r3 = i97.a.a;
        r1.g("linking_invite_panel_first_trigger", MapsKt.mapOf(new Pair[]{TuplesKt.to(Constants.Keys.duration, String.valueOf(System.currentTimeMillis() - this.a)), TuplesKt.to("count", String.valueOf(this.c)), TuplesKt.to("position", String.valueOf(r8))}));
    L12:
        this.a = -1;
        this.c = 0;
        return;
    L8:
        r1 = null;
        goto L10
    }

    public final void g(String r6) {
        Intrinsics.checkNotNullParameter(r6, "inviteMode");
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.n;
        d r2 = null;
        if (r1 == null) goto L5;
        d r3 = r1.getRevLinkLogHelper();
    L6:
        if (r3 == null) goto L9;
        String r4 = r3.a();
        if (r4 == null) goto L9;
    L10:
        r0.put("connection_anchor_cnt", r4);
        r0.put("source", a());
        r0.put("invite_mode", r6);
        com.bytedance.android.live.revlink.impl.global.c r7 = this.n;
        if (r7 == null) goto L13;
        g r8 = r7.getMultiAnchorLinkContextObj();
    L14:
        if (r8 == null) goto L16;
        Long r9 = Long.valueOf(r8.a());
    L17:
        r0.put("channel_id", String.valueOf(r9));
        com.bytedance.android.live.revlink.impl.global.c r10 = this.n;
        if (r10 == null) goto L20;
        r2 = r10.getRevLinkLogHelper();
    L20:
        if (r2 == null) goto L22;
        r2.r(r0);
    L22:
        n r12 = new n();
        Map<String, String> r5 = r12.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r5.putAll(r0);
        m r13 = new m();
        r13.b(LogCommon.ROOM);
        ((ArrayList) r12.b).addAll(r13.a);
        cy0.e.a.getClass();
        j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r15);
        ((i) ((f80.a) r15)).w3("livesdk_npk_show", r12.a, r12.b);
        return;
    L16:
        r9 = null;
        goto L17
    L13:
        r8 = null;
    L9:
        r4 = "";
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static void f(e r2, int r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        r3 = 0;
    L5:
        if (r3 != 0) goto L8;
        r2.m = 0;
        i97.a r5 = i97.a.a;
        r2.b = System.currentTimeMillis();
        return;
    L8:
        if (r3 != 1) goto L10;
        r2.m = 2;
        i97.a r6 = i97.a.a;
        r2.b = System.currentTimeMillis();
        return;
    L10:
        if (r3 != 2) goto L13;
        r2.j++;
        r2.i = true;
        return;
    L13:
        if (r3 != 3) goto L31;
        b51.b r7 = b51.b.c0;
        if (r7.g().getEnable() == true) goto L17;
        return;
    L17:
        if (r7.g().K3() == true) goto L20;
        return;
    L20:
        if (r2.i == false) goto L26;
        r2.i = false;
        if (r2.h == false) goto L25;
        r2.k++;
        goto L26
    L25:
        r2.l++;
    L26:
        LinkedHashMap r8 = new LinkedHashMap();
        int r9 = r2.j;
        r2.getClass();
        r8.put("prediction_count", String.valueOf(r9 + 0));
        r2.getClass();
        r8.put("need_open_count", String.valueOf(0));
        r8.put("need_open_true_count", String.valueOf(r2.k));
        r8.put("not_open_count", String.valueOf(r2.j));
        r8.put("not_open_true_count", String.valueOf(r2.l));
        n r10 = new n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r12.putAll(r8);
        m r13 = new m();
        r13.b(LogCommon.ROOM);
        ((ArrayList) r10.b).addAll(r13.a);
        cy0.e.a.getClass();
        j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r15);
        ((i) ((f80.a) r15)).w3("livesdk_rd_revenue_interact_cache_predict", r10.a, r10.b);
        return;
    }

    public final void d(int r7, int r8, long r9) {
        if (r9 >= 0) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.global.c r0 = this.n;
        if (r0 == null) goto L8;
        f r1 = r0.y2();
    L9:
        if (r1 == null) goto L31;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("current_scene", String.valueOf(r7));
        if (r8 == 1) goto L27;
        if (r8 != 2) goto L15;
        r2.put("ratio", String.valueOf(this.g));
        if ((this.e & 4) != 4) goto L29;
        r2.put("status", DataType.TRUE);
        this.e &= -5;
    L29:
        r2.put("position", String.valueOf(r8));
        r2.put(Constants.Keys.duration, String.valueOf(r9));
        Unit r10 = Unit.INSTANCE;
        r1.g("linking_invite_panel_piece_load", r2);
        return;
    L15:
        if (r8 != 3) goto L29;
        int r4 = this.f;
        if (r4 < 0) goto L21;
        r2.put("count", String.valueOf(r4));
        this.f = -1;
    L21:
        if ((this.e & 2) != 2) goto L29;
        r2.put("status", DataType.TRUE);
        this.e &= -3;
        goto L29
    L27:
        if ((this.e & 1) != 1) goto L29;
        r2.put("status", DataType.TRUE);
        this.e &= -2;
        goto L29
    L31:
        return;
    L8:
        r1 = null;
        goto L9
    }
}
