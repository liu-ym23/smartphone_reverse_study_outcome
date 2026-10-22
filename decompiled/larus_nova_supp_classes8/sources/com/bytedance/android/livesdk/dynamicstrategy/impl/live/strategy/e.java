package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ju1.m;
import ju1.n;
import ju1.r;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import r52.f3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements iu1.b {
    public final PropertyOwner<n> a;
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        boolean r1 = false;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.e r2 = r0.user();
        if (r2 == null) goto L7;
        boolean r3 = r2.isLogin();
    L8:
        a0.e(this.b);
        a0.n(this.b);
        Lazy r4 = PublicScreenABHelper.a;
        if (r42.g.a(null, null) == false) goto L18;
        if (r3 == false) goto L18;
        if (TextUtils.isEmpty((String) f3.a.getValue()) == true) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L25;
        ju1.h r5 = mu1.b.d((String) f3.a.getValue());
        if (r5 == null) goto L25;
        if (TextUtils.equals(r5.b(), "public_screen_load_history_strategy") == false) goto L25;
        return r5;
    L25:
        return new m("public_screen_load_history_strategy", 7);
    L7:
        r3 = false;
        goto L8
    }

    public e(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = r4;
        this.a = new PropertyOwner(new n(7, true));
    }

    @Override // iu1.b
    public final void a(n r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        c(r2);
        this.a.a(r2);
    }

    @Override // iu1.b
    public final void b(n r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        c(r2);
        this.a.a(r2);
    }

    public final void c(n r4) {
        if ((r4 instanceof r) == true) goto L10;
        return;
    L10:
        String r0 = GsonHelper.get().toJson(((r) r4).e);     // Catch: Exception -> L7
    L8:
        int r1 = lu1.k.a;
        StringBuilder r2 = new StringBuilder("current state is ");
        r r5 = (r) r4;
        r2.append(Integer.valueOf(r5.c).intValue());
        r2.append(", factor state is: ");
        r2.append(r5.d);
        r2.append(", hit rules is: ");
        r2.append(r0);
        lu1.k.a(r2.toString());
        return;
    L7:
        r0 = null;
        goto L8
    }
}
