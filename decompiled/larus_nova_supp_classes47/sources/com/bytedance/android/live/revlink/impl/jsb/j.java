package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.HandleBattleBgImageResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.v9;
import w20.w9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends wy0.b<w9, HandleBattleBgImageResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a c;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public j(com.bytedance.android.live.revlink.impl.global.c r1, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r2) {
        this.b = r1;
        this.c = r2;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(w9.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r4, CallContext r5) {
        w9 r6 = (w9) r4;
        Intrinsics.checkNotNullParameter(r6, "param");
        Intrinsics.checkNotNullParameter(r5, "callContext");
        com.bytedance.android.live.revlink.impl.pk.scopeservice.a r7 = this.c;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r0 = null;
        if (r7 != null) goto L8;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.b;
        if (r8 == null) goto L7;
        r7 = r8.K4();
        goto L8
    L7:
        r7 = null;
    L8:
        v9 r1 = new v9();
        r1.a = r6.e2();
        r1.b = r6.U8();
        r6.K0();
        r1.c = Boolean.valueOf(r6.N2());
        if (r7 == null) goto L11;
        r7.handleBattleBgImage(r1);
    L11:
        com.bytedance.android.live.revlink.impl.global.c r9 = this.b;
        if (r9 == null) goto L14;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r10 = r9.Q1();
    L15:
        if (r10 == null) goto L21;
        com.bytedance.android.live.revlink.impl.global.c r12 = this.b;
        if (r12 == null) goto L19;
        r0 = r12.Q1();
    L19:
        if (r0 == null) goto L21;
        r0.handleBattleBgImage(r1);
    L21:
        HandleBattleBgImageResultModel r13 = new HandleBattleBgImageResultModel();
        r13.a(HandleBattleBgImageResultModel.Code.Success);
        finishWithResult(r13);
        return;
    L14:
        r10 = null;
        goto L15
    }
}
