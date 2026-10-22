package com.bytedance.android.live.profit.util;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T, R> implements Function {
    public final /* synthetic */ j a;

    public i(j r1) {
        this.a = r1;
    }

    public final Object apply(Object r8) {
        BaseResponse r9 = (BaseResponse) r8;
        Intrinsics.checkNotNullParameter(r9, "resp");
        j r0 = this.a;
        long r2 = 0;
        if (r0.c.element != 0) goto L9;
        Ref.LongRef r1 = r0.d;
        py.j r3 = ((IBaseUser) r9.data).getFollowInfo();
        if (r3 == null) goto L7;
        long r4 = r3.getFollowerCount();
    L8:
        r1.element = r4;
        goto L9
    L7:
        r4 = 0;
    L9:
        py.j r10 = ((IBaseUser) r9.data).getFollowInfo();
        if (r10 == null) goto L12;
        r2 = r10.getFollowerCount();
    L12:
        j r12 = this.a;
        long r5 = r12.d.element;
        Ref.IntRef r6 = r12.e;
        int r7 = r6.element;
        long r13 = r2 - r5;
        if (r13 <= r7) goto L16;
        r7 = (int) r13;
    L16:
        r6.element = r7;
        r12.c.element++;
        return Integer.valueOf(r7);
    }
}
