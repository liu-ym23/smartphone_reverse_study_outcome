package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0<T, R> implements Function {
    public final /* synthetic */ boolean a;

    public e0(boolean r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        ExtraResponse r5 = (ExtraResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "response");
        k r6 = ((f) r5.data).getLotteryInfo();
        t r0 = null;
        if (r6 == null) goto L5;
        v.c r1 = v.a;
        t r7 = v.b(r6, 0);
    L6:
        f3.a(r7);
        if (r7 == null) goto L20;
        if (this.a == false) goto L13;
        boolean r2 = true;
        if (r7.b == 1) goto L13;
    L14:
        if (r2 == true) goto L16;
        r0 = r7;
    L16:
        if (r0 == null) goto L20;
        sh6.b r8 = sh6.c.a(r0);
        if (r8 == null) goto L20;
        return r8;
    L13:
        r2 = false;
    L20:
        return sh6.a.a;
    L5:
        r7 = null;
        goto L6
    }
}
