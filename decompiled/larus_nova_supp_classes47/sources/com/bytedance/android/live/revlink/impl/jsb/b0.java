package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.SendDataToTargetLynxResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.ae;
import w20.be;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 extends wy0.b<be, SendDataToTargetLynxResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a c;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public b0(com.bytedance.android.live.revlink.impl.global.c r1, com.bytedance.android.live.revlink.impl.lynxcontainer.a r2) {
        this.b = r1;
        this.c = r2;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(be.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r5, CallContext r6) {
        be r7 = (be) r5;
        Intrinsics.checkNotNullParameter(r7, "param");
        Intrinsics.checkNotNullParameter(r6, "callContext");
        SendDataToTargetLynxResultModel r8 = new SendDataToTargetLynxResultModel();
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        List r1 = null;
        if (r0 != null) goto L8;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.b;
        if (r2 == null) goto L7;
        r0 = r2.w2();
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullParameter(r7, "$this$toSendDataToTargetLynxParam");
        ae r3 = new ae();
        r3.a = r7.getFrom();
        Intrinsics.checkNotNullParameter(r7, "$this$toEx");
        List r4 = r7.getTo();
        if (r4 == null) goto L12;
        r1 = CollectionsKt.toList(r4);
    L12:
        r3.b = r1;
        r3.c = r7.getData();
        int r9 = r0.m(r3);
    L14:
        if (r9 != 0) goto L16;
        SendDataToTargetLynxResultModel.Code r10 = SendDataToTargetLynxResultModel.Code.Success;
    L17:
        r8.a(r10);
        finishWithResult(r8);
        return;
    L16:
        r10 = SendDataToTargetLynxResultModel.Code.Failed;
        goto L17
    L13:
        r9 = 0;
        goto L14
    }
}
