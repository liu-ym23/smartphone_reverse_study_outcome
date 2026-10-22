package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a {
    public b a;

    public a() {
    }

    public abstract void b(Map<String, ? extends Object> r1);

    public final b a() {
        b r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskGraph");
    L5:
        return r0;
    }
}
