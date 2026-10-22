package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.core.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiLinkEnterCheck;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkEnterCheck {
    public long a;
    public boolean b;
    public long c;
    public boolean d;
    public long e;
    public boolean f;
    public long g;
    public long h;
    public long i;
    public final CompositeDisposable j;
    public Function0<Unit> k;
    public final com.bytedance.android.live.revlink.impl.global.c l;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (this.i != 0) goto L5;
    L12:
        return false;
    L5:
        if (this.h == 0) goto L12;
        u41.b r0 = u41.b.i;
        r0.getClass();
        long r1 = ((Number) u41.b.d.getValue(r0, u41.b.a[2])).longValue();
        if (Math.abs(this.h - this.g) > r1) goto L10;
    L11:
        return true;
    L10:
        if (Math.abs(this.i - this.g) > r1) goto L12;
        goto L11
    }

    public final void c() {
        if (this.b == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L7;
        return;
    L7:
        if (this.f == true) goto L9;
        return;
    L9:
        if (this.i == 0) goto L43;
        long r0 = this.a;
        long r2 = this.c;
        boolean r4 = true;
        if (r0 == r2) goto L14;
        boolean r1 = true;
    L16:
        if (this.e != r2) goto L19;
        r4 = false;
    L19:
        if (r1 == false) goto L21;
        int r3 = MultiLinkEnterCheck.k;
        int r5 = 2;
    L22:
        if (r4 == false) goto L24;
        int r6 = MultiLinkEnterCheck.k;
        r5 = r5 | 4;
    L24:
        if (r5 > 0) goto L26;
    L28:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("error_code", String.valueOf(r5));
        r7.put("preload_battle_id", String.valueOf(this.a));
        r7.put("p1_battle_id", String.valueOf(this.c));
        r7.put("backup_battle_id", String.valueOf(this.e));
        r7.put("near_mode_change", String.valueOf(b()));
        if (r5 <= 0) goto L38;
        u41.d r8 = u41.d.n;
        r8.getClass();
        if (((Boolean) u41.d.m.getValue(r8, u41.d.a[11])).booleanValue() == true) goto L38;
        com.bytedance.android.live.revlink.impl.global.c r9 = this.l;
        if (r9 == null) goto L35;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r10 = r9.getMultiLinkMonitor();
    L36:
        if (r10 == null) goto L38;
        Intrinsics.checkNotNullParameter(r7, "map");
        JSONObject r12 = new JSONObject(r7);
        r10.c(r12);
        r10.I("multi_pk_enter_diff_check", r12, false);
        goto L38
    L35:
        r10 = null;
    L38:
        jy0.b.c("link_preload", r7.toString(), null, 4);
        return;
    L26:
        if (b() == false) goto L28;
        int r13 = MultiLinkEnterCheck.k;
        r5 = r5 | 1;
        goto L28
    L21:
        r5 = 0;
        goto L22
    L14:
        r1 = false;
        goto L16
    }

    public final void d() {
        u41.d r0 = u41.d.n;
        r0.getClass();
        if (((Boolean) u41.d.j.getValue(r0, u41.d.a[8])).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.h != 0) goto L8;
        return;
    L8:
        if (this.i != 0) goto L10;
        return;
    L10:
        if (this.g != 0) goto L13;
        return;
    L13:
        if (b() == false) goto L20;
        jy0.b.c("link_preload", "start tryWRDSBackup for pk", null, 4);
        Function0<Unit> r1 = this.k;
        if (r1 == null) goto L21;
        Unit r2 = (Unit) r1.invoke();
        return;
    L21:
        return;
    }

    public PkEnterCheck(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.l = r1;
        this.j = new CompositeDisposable();
    }

    public final void a(Function0<Unit> r2) {
        this.k = r2;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.l;
        if (r3 == null) goto L5;
        ProfitInteractionDataContext r4 = r3.vj();
    L6:
        if (r4 == null) goto L13;
        com.bytedance.live.datacontext.m<Long> r5 = r4.getLinkStartTimeStamp();
        if (r5 == null) goto L14;
        Disposable r6 = b0.a(r5, new PkEnterCheck$attach$1(this));
        if (r6 == null) goto L15;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6, this.j);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
