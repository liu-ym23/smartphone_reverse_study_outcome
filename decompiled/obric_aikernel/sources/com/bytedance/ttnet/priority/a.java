package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class a extends TTHttpCallPriorityControl.a {
    public a() {
    }

    private int l(n4.c r10) {
        List<n4.b> r11 = r10.H("x-tt-request-tag");
        if (r11 != null) goto L5;
    L9:
        String r12 = "";
    L11:
        return h.l().c(r10.G(), r12);
    L5:
        if (r11.size() < 1) goto L9;
        if (TextUtils.isEmpty(r11.get(0).b()) == true) goto L9;
        r12 = r11.get(0).b();
        goto L11
    }

    @Override // s4.b
    public void a(n4.c r10, RetrofitMetrics r11) {
        long r12 = l(r10);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeDefault", "get tag delay time " + r12 + " " + r10.A());
    L5:
        this.f2871a.h(r10, true, false, r12, r11);
    }

    @Override // s4.b
    public boolean d(n4.c r10, RetrofitMetrics r11, Executor r12, Runnable r13) {
        long r14 = l(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeDefault", "get tag delay time " + r14 + " " + r10.A());
    L6:
        return this.f2871a.g(r10, true, r14, r13, r12, r11);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void i() {
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void j() {
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    TTHttpCallPriorityControl.ModeType k() {
        return TTHttpCallPriorityControl.ModeType.DEFAULT;
    }
}
