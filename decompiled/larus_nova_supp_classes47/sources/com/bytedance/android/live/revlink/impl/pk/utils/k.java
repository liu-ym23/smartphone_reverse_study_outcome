package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.profile.monitor.DataType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements d {
    public long a;
    public Long b;
    public int c;
    public i d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final com.bytedance.android.live.revlink.impl.global.c h;
    public final String i;

    @Override // com.bytedance.android.live.revlink.impl.pk.utils.d
    public final long a() {
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        long r2 = this.a;
        Long r4 = this.b;
        if (r4 == null) goto L5;
        long r5 = r4.longValue();
    L7:
        return r2 + (r1 - r5);
    L5:
        r5 = r1;
        goto L7
    }

    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        i r0 = this.d;
        if (r0 == null) goto L8;
        int r5 = r0.a;
    L9:
        if (r0 == null) goto L11;
        int r6 = r0.b;
    L12:
        if (r0 == null) goto L15;
        String r1 = r0.c;
        if (r1 == null) goto L15;
    L16:
        String r7 = r1;
        long r9 = this.a / 1000;
        int r2 = RangesKt.coerceAtLeast(this.c, 0);
        boolean r3 = this.g;
        mz0.n r4 = new mz0.n();
        t.a(r4, this.h, r5, r6, r7, this.i);
        Map<String, String> r8 = r4.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        String r10 = String.valueOf(r9);
        Intrinsics.checkNotNullParameter("show_time", "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        r8.put("show_time", r10);
        String r12 = String.valueOf(r2);
        Intrinsics.checkNotNullParameter("refresh_times", "key");
        Intrinsics.checkNotNullParameter(r12, "value");
        r8.put("refresh_times", r12);
        if (r3 == false) goto L19;
        String r13 = DataType.TRUE;
    L20:
        Intrinsics.checkNotNullParameter("is_switch", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r8.put("is_switch", r13);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_connection_invite_banner_close", r4.a, r4.b);
        return;
    L19:
        r13 = DataType.FALSE;
    L15:
        r1 = "";
        goto L16
    L11:
        r6 = 0;
        goto L12
    L8:
        r5 = 0;
        goto L9
    }

    public final void c() {
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        long r2 = this.a;
        Long r4 = this.b;
        if (r4 == null) goto L5;
        long r5 = r4.longValue();
    L6:
        this.a = r2 + RangesKt.coerceAtLeast(r1 - r5, 0);
        this.b = null;
        return;
    L5:
        r5 = r1;
        goto L6
    }

    public final void e() {
        i97.a r0 = i97.a.a;
        this.b = Long.valueOf(System.currentTimeMillis());
        this.f = true;
    }

    public final void d(int r9) {
        if (this.e == true) goto L19;
        if (r9 <= 0) goto L20;
        this.e = true;
        i r10 = this.d;
        if (r10 == null) goto L9;
        int r4 = r10.a;
    L10:
        if (r10 == null) goto L12;
        int r5 = r10.b;
    L13:
        if (r10 == null) goto L16;
        String r12 = r10.c;
        if (r12 == null) goto L16;
    L17:
        String r6 = r12;
        mz0.n r13 = new mz0.n();
        t.a(r13, this.h, r4, r5, r6, this.i);
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r1);
        ((mz0.i) ((f80.a) r1)).w3("livesdk_connection_anchor_list_slide", r13.a, r13.b);
        return;
    L16:
        r12 = "";
        goto L17
    L12:
        r5 = 0;
        goto L13
    L9:
        r4 = 0;
        goto L10
    L20:
        return;
    }

    public final void f(i r8) {
        Intrinsics.checkNotNullParameter(r8, "listExtraInfo");
        i r0 = this.d;
        if (r0 == null) goto L5;
        String r1 = r0.c;
    L7:
        if ((!Intrinsics.areEqual(r1, r8.c)) == false) goto L9;
        this.e = false;
    L9:
        this.d = r8;
        if (r8.d == false) goto L16;
        this.c++;
        int r3 = r8.a;
        int r4 = r8.b;
        String r9 = r8.c;
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        String r5 = r9;
        mz0.n r10 = new mz0.n();
        t.a(r10, this.h, r3, r4, r5, this.i);
        cy0.e.a.getClass();
        cy0.j r2 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r2).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r6);
        ((mz0.i) ((f80.a) r6)).w3("livesdk_connection_invite_banner_refresh", r10.a, r10.b);
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public k(com.bytedance.android.live.revlink.impl.global.c r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "page");
        this.h = r2;
        this.i = r3;
        this.c = -1;
    }
}
