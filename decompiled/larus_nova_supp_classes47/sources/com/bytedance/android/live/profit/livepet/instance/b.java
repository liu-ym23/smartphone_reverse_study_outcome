package com.bytedance.android.live.profit.livepet.instance;

import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import cy0.e;
import cy0.j;
import e33.k;
import java.util.Map;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o {
    public final com.bytedance.android.live.revenue.common.reactive.c a;
    public final com.bytedance.android.live.revenue.common.reactive.c b;
    public final ru0.a c;
    public final g d;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        jy0.b.d("LivePet/InstanceManager", "unloading pet instance");
        LivePetInstance r0 = (LivePetInstance) this.a.b;
        if (r0 != null) goto L5;
        return;
    L5:
        LivePetInstance.State r1 = r0.a();
        LivePetInstance.State r2 = LivePetInstance.State.Destroyed;
        if (r1 == r2) goto L16;
        r0.a.setValue(r2);
        jy0.b.a("LivePet/Instance", "instance destroy");
        ru0.b r3 = r0.b;
        if (r3 != null) goto L11;
    L15:
        r0.b = null;
        goto L16
    L11:
        if (l.b(r3) != true) goto L15;
        ru0.b r4 = r0.b;
        if (r4 == null) goto L15;
        l.c(r4);
    L16:
        this.a.setValue(null);
    }

    public final void onStop() {
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(c r12) {
        Intrinsics.checkNotNullParameter(r12, "loadParams");
        String r2 = null;
        if (((LivePetInstance) this.a.b) == null) goto L6;
        jy0.b.c("LivePet/InstanceManager", "petInstance already exists", null, 4);
        return;
    L6:
        jy0.b.d("LivePet/InstanceManager", "loading pet instance, scheme = " + r12.b);
        LivePetInstance r0 = new LivePetInstance(r12);
        ru0.a r13 = this.c;
        Intrinsics.checkNotNullParameter(r13, "scope");
        if (r0.a() != LivePetInstance.State.Uninitialized) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L32;
        jy0.b.a("LivePet/Instance", "instance create");
        c r4 = r0.d;
        long r5 = r4.a;
        String r6 = r4.b;
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        Intrinsics.checkNotNullParameter(r6, "scheme");
        n r7 = new n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        String r9 = String.valueOf(r5);
        Intrinsics.checkNotNullParameter("pet_type", "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.put("pet_type", r9);
        Intrinsics.checkNotNullParameter("scheme", "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        r8.put("scheme", r6);
        e.a.getClass();
        j r10 = e.a.a;
        m.e.getClass();
        Object r14 = m.b(r10).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r14);
        ((i) ((f80.a) r14)).w3("livesdk_pet_open_container_tech", r7.a, r7.b);
        u0 r15 = u0.f;
        r0.c = t0.b();
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(r0, "instance");
        ru0.b r16 = new ru0.b(r13);
        Intrinsics.checkNotNullParameter(r16, "scope");
        Intrinsics.checkNotNullParameter(r0, "value");
        r16.e = r0;
        Object r17 = k.a;
        if (r0 != r17) goto L18;
        r2 = "instance";
    L26:
        if (r2 != null) goto L30;
        l.a(r16);
        Unit r18 = Unit.INSTANCE;
        r0.b = r16;
        r0.a.setValue(LivePetInstance.State.Created);
        this.a.setValue(r0);
        return;
    L30:
        throw new UninitializedPropertyAccessException(r2);
    L18:
        if (r16.f != r17) goto L21;
        r2 = "revenueInstance";
        goto L26
    L21:
        if (r16.g != r17) goto L24;
        r2 = "revenueInstanceExt";
        goto L26
    L24:
        if (r16.h != r17) goto L26;
        r2 = "roomInstance";
        goto L26
    L32:
        throw new IllegalStateException(("Unexpected state " + r0.a()).toString());
    L9:
        r3 = false;
        goto L10
    }

    public b(ru0.a r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.c = r2;
        this.d = r3;
        com.bytedance.android.live.revenue.common.reactive.c r4 = new com.bytedance.android.live.revenue.common.reactive.c(null);
        this.a = r4;
        this.b = r4;
    }
}
