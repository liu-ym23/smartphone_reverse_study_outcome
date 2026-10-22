package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.HandlePkNativeViewResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.b2;
import w20.y9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends wy0.b<y9, HandlePkNativeViewResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a c;
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.g d;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    @Override // wy0.b
    public final void l(vh7.j r4, CallContext r5) {
        y9 r6 = (y9) r4;
        Intrinsics.checkNotNullParameter(r6, "param");
        Intrinsics.checkNotNullParameter(r5, "callContext");
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.g r2 = null;
        jy0.b.c("xuzr", "type: " + r6.getType() + ", data: " + r6.getData(), null, 4);
        if (z41.g.o.a() == false) goto L5;
        finishWithSuccess();
        return;
    L5:
        com.bytedance.android.live.revlink.impl.pk.scopeservice.a r7 = this.c;
        if (r7 != null) goto L12;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.b;
        if (r8 == null) goto L10;
        r7 = r8.K4();
        goto L12
    L10:
        r7 = null;
    L12:
        if (r6.getType() != 1) goto L22;
        List r0 = b2.a(r6);
        if (r0 == null) goto L31;
        Iterator r1 = r0.iterator();
    L17:
        if (r1.hasNext() == false) goto L31;
        String r3 = (String) r1.next();
        if (r7 == null) goto L17;
        r7.b(r3);
    L31:
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.g r9 = this.d;
        if (r9 != null) goto L37;
        com.bytedance.android.live.revlink.impl.global.c r10 = this.b;
        if (r10 == null) goto L36;
        r2 = r10.M2();
    L36:
        r9 = r2;
    L37:
        if (r9 == null) goto L39;
        r9.a(b2.a(r6), r6.Z4());
    L39:
        HandlePkNativeViewResultModel r12 = new HandlePkNativeViewResultModel();
        r12.a(HandlePkNativeViewResultModel.Code.Success);
        finishWithResult(r12);
        return;
    L22:
        if (r6.getType() != 2) goto L31;
        List r13 = b2.a(r6);
        if (r13 == null) goto L31;
        Iterator r14 = r13.iterator();
    L27:
        if (r14.hasNext() == false) goto L31;
        String r15 = (String) r14.next();
        if (r7 == null) goto L27;
        r7.a(r15);
        goto L27
    }

    public l(com.bytedance.android.live.revlink.impl.global.c r3, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r4, com.bytedance.android.live.revlink.impl.multianchor.dynamic.l r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(y9.class));
    }
}
