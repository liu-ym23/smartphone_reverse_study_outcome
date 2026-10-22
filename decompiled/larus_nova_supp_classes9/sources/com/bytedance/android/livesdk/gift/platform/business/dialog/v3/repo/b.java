package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements com.bytedance.android.scope.o, dy0.c {
    public final HashMap<Long, com.bytedance.android.livesdk.gift.platform.core.model.e0> a;
    public h1 b;
    public final HashMap<Long, h1> c;
    public boolean d;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final yz0.k f() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
    }

    public b() {
        GsonHelper.get();
        this.a = new HashMap();
        this.c = new HashMap();
    }

    public final h1 a() {
        yz0.k r0 = f();
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return this.c.get(Long.valueOf(r1.getId()));
    L5:
        r1 = null;
        goto L6
    }

    public final com.bytedance.android.livesdk.gift.platform.core.model.e0 g() {
        yz0.k r0 = f();
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        if (this.a.containsKey(Long.valueOf(r1.getId())) == true) goto L11;
        return null;
    L11:
        return this.a.get(Long.valueOf(r1.getId()));
    L5:
        r1 = null;
        goto L6
    }

    public final void h(h1 r5) {
        Intrinsics.checkNotNullParameter(r5, "gift");
        yz0.k r0 = f();
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        if (r1 == null) goto L9;
        this.c.put(Long.valueOf(r1.getId()), r5);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
