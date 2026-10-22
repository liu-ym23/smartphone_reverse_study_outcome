package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ e0 a;

    public p(e0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        MutableLiveData<Boolean> r0 = this.a.m;
        Integer r4 = (Integer) sh6.c.b((sh6.b) r3);
        boolean r1 = true;
        if (r4 != null) goto L6;
    L7:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.a.F;
        if (r5 == null) goto L13;
        com.bytedance.android.live.revlink.impl.utils.b r6 = r5.getClearScreenLinkUtils();
        if (r6 == null) goto L13;
        if (r6.b() != true) goto L13;
    L21:
        r0.setValue(Boolean.valueOf(r1));
        return;
    L13:
        com.bytedance.android.live.revlink.impl.global.c r7 = this.a.F;
        if (r7 == null) goto L20;
        com.bytedance.android.live.revlink.impl.utils.b r8 = r7.getClearScreenLinkUtils();
        if (r8 == null) goto L20;
        if (r8.a() == true) goto L21;
    L20:
        r1 = false;
        goto L21
    L6:
        if (r4.intValue() == 1) goto L21;
        goto L7
    }
}
