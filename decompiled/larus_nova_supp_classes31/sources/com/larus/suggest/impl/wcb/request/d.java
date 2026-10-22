package com.larus.suggest.impl.wcb.request;

import com.larus.suggest.impl.wcb.render.q;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ WcbRequestPipeline a;
    public final /* synthetic */ f b;
    public final /* synthetic */ q c;

    public /* synthetic */ d(WcbRequestPipeline r1, f r2, q r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        WcbRequestPipeline r0 = this.a;
        f r1 = this.b;
        q r2 = this.c;
        if (r0.e(r1) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L11;
        FLogger.a.i("WcbLog", "[pipeline] transaction.inactive chat=" + r1.d + " exec=" + r1.e + " currentExec=" + r0.g + " active=" + r2.isActive());
    L11:
        return Boolean.valueOf(r3);
    L5:
        if (r2.isActive() == false) goto L7;
        r3 = true;
        goto L8
    }
}
