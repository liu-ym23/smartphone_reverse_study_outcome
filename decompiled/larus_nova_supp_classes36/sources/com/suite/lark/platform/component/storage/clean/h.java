package com.suite.lark.platform.component.storage.clean;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public final HashMap<Class<? extends f>, m<? extends f>> a;

    public h() {
        this.a = new HashMap();
    }

    public final void a(m r3) {
        Intrinsics.checkNotNullParameter(r3, "eraser");
        this.a.put(r3.a(), r3);
    }
}
