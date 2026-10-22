package com.ss.android.lark.keyboard.event;

import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r implements m {
    public final ImeStateDetail a;

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return c.a.a(this);
    }

    public r(ImeStateDetail r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
    }
}
