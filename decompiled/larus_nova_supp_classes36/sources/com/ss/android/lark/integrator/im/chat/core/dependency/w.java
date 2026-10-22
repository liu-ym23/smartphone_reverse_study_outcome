package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import com.ss.android.lark.biz.im.api.l1;
import kotlin.jvm.internal.Intrinsics;
import w4b.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w implements e0 {
    public w() {
    }

    public final void a(Context r2, String r3, e0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "topicGroupId");
        Intrinsics.checkNotNullParameter(r4, "callback");
    }

    public final void b(Context r2, l1 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        whb.d.a(r2, r3);
    }
}
