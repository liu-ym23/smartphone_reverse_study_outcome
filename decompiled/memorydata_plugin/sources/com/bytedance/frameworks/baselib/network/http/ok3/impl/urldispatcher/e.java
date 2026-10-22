package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends i {
    private static final String j = "e";
    private DispatchStrategy k;

    static {
    }

    public e() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.i
    public BaseDispatchAction.DispatchResultEnum a(k r6, String r7, List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(j, "dispatch action " + this.k.b());
    L5:
        BaseDispatchAction.DispatchResultEnum r0 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        Uri r1 = Uri.parse(r7);
        if (r1.getHost() != null) goto L8;
    L19:
        return r0;
    L8:
        if (a(r1) == false) goto L19;
        if (this.k == null) goto L19;
        r0 = BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
        DispatchStrategy.DispatchStrategyType r2 = this.k.b();
        DispatchStrategy.DispatchStrategyType r3 = DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY;
        DispatchStrategy r5 = this.k;
        if (r2 != r3) goto L15;
        r5.a(r6);
        r9.set(0, r7);
        return r0;
    L15:
        String r10 = r5.a(r1);
        if (r7.equals(r10) == true) goto L18;
        r9.set(0, r10);
        goto L19
    L18:
        r9.set(0, r7);
        goto L19
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.i
    public boolean a(JSONObject r10, List<Boolean> r11, String r12, long r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        a(r10);
        String r0 = r10.optString("service_name");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.h = r0;
    L5:
        int r1 = r10.optInt("dispatch_strategy", 0);
        JSONObject r4 = r10.optJSONObject("strategy_info");
        if (r1 >= 0) goto L8;
    L12:
        this.k = null;
        return false;
    L8:
        if (r1 > 6) goto L12;
        DispatchStrategy r15 = DispatchStrategy.a(DispatchStrategy.DispatchStrategyType.values()[r1], r4, r12, r13, a());
        this.k = r15;
        r14.set(0, Boolean.valueOf(r15.a()));
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.i
    public int e() {
        return this.k.b().ordinal();
    }
}
