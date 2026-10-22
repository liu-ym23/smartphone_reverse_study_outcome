package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends g {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f1823r = "c";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DispatchStrategy f1824q;

    static {
    }

    public c() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g
    public BaseDispatchAction.DispatchResultEnum r(y2.c r10, String r11, List<String> r12) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1823r, "dispatch action " + this.f1824q.c());
    L5:
        BaseDispatchAction.DispatchResultEnum r13 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        Uri r14 = Uri.parse(r11);
        if (r14.getHost() != null) goto L8;
    L19:
        return r13;
    L8:
        if (i(r14) == false) goto L19;
        DispatchStrategy r15 = this.f1824q;
        if (r15 == null) goto L19;
        r13 = BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
        DispatchStrategy.DispatchStrategyType r16 = r15.c();
        DispatchStrategy.DispatchStrategyType r17 = DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY;
        DispatchStrategy r18 = this.f1824q;
        if (r16 != r17) goto L15;
        r18.a(r10);
        r12.set(0, r11);
        return r13;
    L15:
        String r19 = r18.d(r14);
        if (r11.equals(r19) == true) goto L18;
        r12.set(0, r19);
        goto L19
    L18:
        r12.set(0, r11);
        goto L19
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g
    public int s() {
        return this.f1824q.c().ordinal();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g
    protected boolean u(JSONObject r10, List<Boolean> r11, String r12, long r13) {
        k(r10);
        String r14 = r10.optString("service_name");
        if (TextUtils.isEmpty(r14) == true) goto L5;
        this.f1812l = r14;
    L5:
        int r15 = r10.optInt("dispatch_strategy", 0);
        JSONObject r16 = r10.optJSONObject("strategy_info");
        if (r15 >= 0) goto L8;
    L12:
        this.f1824q = null;
        return false;
    L8:
        if (r15 > 6) goto L12;
        DispatchStrategy r17 = DispatchStrategy.b(DispatchStrategy.DispatchStrategyType.values()[r15], r16, r12, r13, b());
        this.f1824q = r17;
        r11.set(0, Boolean.valueOf(r17.e()));
        return true;
    }
}
