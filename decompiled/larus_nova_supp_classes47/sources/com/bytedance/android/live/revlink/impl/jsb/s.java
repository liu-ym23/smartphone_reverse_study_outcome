package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.ObserveRevenueInteractDataResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.zb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s extends wy0.b<zb, ObserveRevenueInteractDataResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a b;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public s(com.bytedance.android.live.revlink.impl.lynxcontainer.a r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(zb.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r4, CallContext r5) {
        zb r6 = (zb) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        ObserveRevenueInteractDataResultModel r1 = new ObserveRevenueInteractDataResultModel();
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r2 = this.b;
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r5.d != null) goto L5;
        finishWithFailure();
    L5:
        if (r2 != null) goto L8;
        r1.a(ObserveRevenueInteractDataResultModel.Code.Failed);
        finishWithResult(r1);
        Unit r0 = Unit.INSTANCE;
    L8:
        if (r6.getType() != 0) goto L12;
        List<String> r7 = CollectionsKt.toList(r6.getTags());
        if (r2 == null) goto L14;
        r2.d(r5, r7);
    L14:
        r1.a(ObserveRevenueInteractDataResultModel.Code.Success);
        finishWithResult(r1);
        return;
    L12:
        if (r2 == null) goto L14;
        r2.l(r5);
        goto L14
    }
}
