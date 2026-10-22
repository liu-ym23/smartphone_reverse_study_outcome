package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.RevenueGetRevenueInteractDataResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.od;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends wy0.b<od, RevenueGetRevenueInteractDataResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a c;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public i(com.bytedance.android.live.revlink.impl.global.c r1, com.bytedance.android.live.revlink.impl.lynxcontainer.a r2) {
        this.b = r1;
        this.c = r2;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(od.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r4, CallContext r5) {
        od r6 = (od) r4;
        Intrinsics.checkNotNullParameter(r6, "param");
        Intrinsics.checkNotNullParameter(r5, "callContext");
        RevenueGetRevenueInteractDataResultModel r7 = new RevenueGetRevenueInteractDataResultModel();
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        List<String> r1 = null;
        if (r0 != null) goto L8;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.b;
        if (r2 == null) goto L7;
        r0 = r2.Bi();
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        finishWithFailure();
    L10:
        if (r0 == null) goto L15;
        Intrinsics.checkNotNullParameter(r6, "$this$dataEx");
        List r8 = r6.getTags();
        if (r8 == null) goto L14;
        r1 = CollectionsKt.toList(r8);
    L14:
        r0.c(r1);
    L15:
        RevenueGetRevenueInteractDataResultModel.Code r9 = RevenueGetRevenueInteractDataResultModel.Code.Success;
        finishWithResult(r7);
    }
}
