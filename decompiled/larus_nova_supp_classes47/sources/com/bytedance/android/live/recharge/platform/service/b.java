package com.bytedance.android.live.recharge.platform.service;

import com.android.ttcjpaysdk.base.service.IHostApi;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements m, com.bytedance.android.scope.o {
    public final ConcurrentHashMap<String, ITTCJPayComponent> a;
    public final com.bytedance.android.live.wallet.d b;

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final JSONObject f0() {
        Intrinsics.checkNotNullParameter("recharge_panel", "scene");
        ITTCJPayComponent r0 = this.a.get("recharge_panel");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDynamicBizParams();
    }

    public final void onStart() {
        this.a.clear();
    }

    public final void onStop() {
        this.a.clear();
    }

    public b(com.bytedance.android.live.wallet.d r2) {
        Intrinsics.checkNotNullParameter(r2, "cjPayService");
        this.b = r2;
        this.a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final JSONObject I(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        ITTCJPayComponent r3 = this.a.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getPayParams();
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        ITTCJPayComponent r3 = this.a.remove(r2);
        if (r3 == null) goto L6;
        r3.release();
        return;
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final ITTCJPayComponent f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return this.a.get(r2);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final boolean w(JSONObject r3) {
        Intrinsics.checkNotNullParameter("recharge_panel", "scene");
        ITTCJPayComponent r0 = this.a.get("recharge_panel");
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.refresh(r3);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final ITTCJPayComponent L(IPayLifecycle r2, IHostApi r3) {
        return this.b.F(r2, r3);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final void X0(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        ITTCJPayComponent r4 = this.a.get(r2);
        if (r4 == null) goto L6;
        r4.confirm(r3);
        return;
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final void s1(String r2, ITTCJPayComponent r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "component");
        this.a.put(r2, r3);
    }
}
