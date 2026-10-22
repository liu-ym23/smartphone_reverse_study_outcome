package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w extends wy0.c<c, Object> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @Override // wy0.c
    public final Type j() {
        return this.a;
    }

    public w(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(c.class));
    }

    @Override // wy0.c
    public final Object k(vh7.j r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((c) r2, "param");
        Intrinsics.checkNotNullParameter(r3, "callContext");
        JsonObject r4 = new JsonObject();
        com.bytedance.android.live.revlink.impl.global.c r5 = this.b;
        if (r5 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = r5.Ig();
    L6:
        if (r6 == null) goto L9;
        PkBaseStateMachine.c r7 = r6.getCurPKBaseState();
        if (r7 == null) goto L9;
    L10:
        r7.getClass();
        Integer r8 = Integer.valueOf(r7 instanceof PkBaseStateMachine.c.C0130c ? 1 : 0);
        r4.add("is_pk", GsonProtectorUtils.toJsonTree(l97.a.a, r8));
        return r4;
    L9:
        r7 = PkBaseStateMachine.c.a.d;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
