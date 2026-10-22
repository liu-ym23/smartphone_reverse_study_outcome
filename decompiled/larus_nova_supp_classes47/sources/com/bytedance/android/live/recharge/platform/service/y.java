package com.bytedance.android.live.recharge.platform.service;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.core.c, p {
    public WeakReference<Activity> a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public static long E1() {
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L11;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L11;
        vh7.c r2 = r1.getOwner();
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r2, "$this$mainOrNull");
        iy0.c r3 = (iy0.c) r2.castToOrNull(iy0.c.class);
        if (r3 == null) goto L11;
        return r3.getId();
    L11:
        return 0;
    }

    public final Activity getActivity() {
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        Context r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L7:
        if ((r2 instanceof Activity) == false) goto L10;
        r1 = r2;
    L10:
        Activity r3 = (Activity) r1;
        if (r3 == null) goto L13;
        return r3;
    L13:
        return this.a.get();
    L5:
        r2 = null;
        goto L7
    }

    public y() {
        this.a = new WeakReference(null);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.p
    public final void j(Context r3) {
        if ((r3 instanceof Activity) == true) goto L5;
        r3 = null;
    L5:
        this.a = new WeakReference((Activity) r3);
    }
}
