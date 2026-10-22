package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.ModifyAnchorTopOffsetResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.tb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p extends wy0.b<tb, ModifyAnchorTopOffsetResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c c;

    public static final class a {
    }

    static {
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public p(com.bytedance.android.live.revlink.impl.global.c r1, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c r2) {
        this.b = r1;
        this.c = r2;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(tb.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r2, CallContext r3) {
        tb r4 = (tb) r2;
        Intrinsics.checkNotNullParameter(r4, "param");
        Intrinsics.checkNotNullParameter(r3, "callContext");
        jy0.b.d("ModifyAnchorTopOffsetMethod", String.valueOf(r4.getOffset()));
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c r5 = this.c;
        if (r5 != null) goto L8;
        com.bytedance.android.live.revlink.impl.global.c r6 = this.b;
        if (r6 == null) goto L7;
        r5 = r6.p6();
        goto L8
    L7:
        r5 = null;
    L8:
        int r7 = r4.getOffset();
        if (r5 == null) goto L11;
        r5.j(r7);
    L11:
        finishWithSuccess();
    }
}
