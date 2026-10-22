package com.bytedance.android.live.recharge.platform.service;

import com.android.ttcjpaysdk.base.service.IHostApi;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface m extends com.bytedance.android.live.recharge.core.c {
    JSONObject I(String r1);

    ITTCJPayComponent L(IPayLifecycle r1, IHostApi r2);

    void X0(String r1, JSONObject r2);

    void a(String r1);

    ITTCJPayComponent f(String r1);

    JSONObject f0();

    void s1(String r1, ITTCJPayComponent r2);

    boolean w(JSONObject r1);
}
