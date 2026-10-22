package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class a extends TTHttpCallPriorityControl.a {
    public a() {
    }

    private int a(Request r5) {
        List<Header> r4 = r5.headers(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG);
        if (r4 != null) goto L5;
    L9:
        String r6 = "";
    L11:
        return j.a().a(r5.getUrl(), r6);
    L5:
        if (r4.size() < 1) goto L9;
        if (TextUtils.isEmpty(((Header) ZeusTransformUtils.preCheckCast(r4.get(0), Header.class, "com.obric.memorydata.plugin")).getValue()) == true) goto L9;
        r6 = ((Header) ZeusTransformUtils.preCheckCast(r4.get(0), Header.class, "com.obric.memorydata.plugin")).getValue();
        goto L11
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void a() {
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void b() {
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    TTHttpCallPriorityControl.ModeType c() {
        return TTHttpCallPriorityControl.ModeType.DEFAULT;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r10, Executor r11, Runnable r12) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.memorydata.plugin");
        long r5 = a(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeDefault", "get tag delay time " + r5 + " " + r10.getPath());
    L6:
        return this.f3294a.a(r10, true, r5, r7, r8);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r8) {
        long r5 = a(r8);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeDefault", "get tag delay time " + r5 + " " + r8.getPath());
    L5:
        this.f3294a.a(r8, true, false, r5);
    }
}
