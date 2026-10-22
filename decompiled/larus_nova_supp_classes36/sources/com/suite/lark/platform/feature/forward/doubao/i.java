package com.suite.lark.platform.feature.forward.doubao;

import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public static final i a = null;
    public static volatile ForwardDoubaoContent b;

    static {
        a = new i();
    }

    public i() {
    }

    public final void update(ForwardDoubaoContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        b = r2;
    }
}
