package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.HandlePkLynxViewResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.a2;
import w20.x9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends wy0.b<x9, HandlePkLynxViewResultModel> {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final Type g;
    public final com.bytedance.android.live.revlink.impl.global.c h;
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a i;

    @Override // wy0.b
    public final Type k() {
        return this.g;
    }

    public k(com.bytedance.android.live.revlink.impl.global.c r1, com.bytedance.android.live.revlink.impl.lynxcontainer.a r2) {
        this.h = r1;
        this.i = r2;
        this.a = 1;
        this.b = 2;
        this.c = 3;
        this.d = 4;
        this.e = 11;
        this.f = 12;
        this.g = TypesJVMKt.getJavaType(Reflection.typeOf(x9.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r3, CallContext r4) {
        x9 r5 = (x9) r3;
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r4, "callContext");
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r6 = this.i;
        if (r6 != null) goto L8;
        com.bytedance.android.live.revlink.impl.global.c r7 = this.h;
        if (r7 == null) goto L7;
        r6 = r7.w2();
        goto L8
    L7:
        r6 = null;
    L8:
        int r0 = r5.getType();
        if (r0 != this.a) goto L13;
        if (r6 == null) goto L32;
        r6.i(a2.a(r5));
    L32:
        HandlePkLynxViewResultModel r8 = new HandlePkLynxViewResultModel();
        r8.a(HandlePkLynxViewResultModel.Code.Success);
        finishWithResult(r8);
        return;
    L13:
        if (r0 != this.b) goto L17;
        if (r6 == null) goto L32;
        r6.a(a2.a(r5));
        goto L32
    L17:
        if (r0 != this.c) goto L21;
        if (r6 == null) goto L32;
        r6.g(a2.a(r5));
        goto L32
    L21:
        if (r0 != this.d) goto L25;
        if (r6 == null) goto L32;
        r6.h(a2.a(r5));
        goto L32
    L25:
        if (r0 != this.e) goto L29;
        if (r6 == null) goto L32;
        a2.a(r5);
        r6.k();
        goto L32
    L29:
        if (r0 != this.f) goto L32;
        if (r6 == null) goto L32;
        a2.a(r5);
        r6.e();
        goto L32
    }
}
