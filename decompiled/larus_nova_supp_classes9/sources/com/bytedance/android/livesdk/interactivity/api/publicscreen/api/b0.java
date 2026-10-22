package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 implements am3.c<InputFunctionList> {
    public b0() {
    }

    public static InputFunctionList a(am3.g r5) throws Exception {
        InputFunctionList r0 = new InputFunctionList();
        r0.list = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.list.add(c0.a(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
