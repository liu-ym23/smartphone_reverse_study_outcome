package com.ss.android.lark.forwardv2.sharefile;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.m0;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements RxScheduledExecutor.Producer {
    public final /* synthetic */ FileShareEnhancedView a;

    public a(FileShareEnhancedView r1) {
        this.a = r1;
    }

    public final Object produce() {
        PolarisFileWrapper r0 = m0.b(LarkContext.getApplication(), this.a.a, true);
        if (r0 != null) goto L5;
    L8:
        String r1 = c1.d(LarkContext.getApplication(), this.a.a);
    L10:
        return new PolarisFileWrapper(r1);
    L5:
        if (r0.canRead() == false) goto L8;
        r1 = r0.getAbsolutePath();
        goto L10
    }
}
