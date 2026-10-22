package com.ss.android.lark.keyboard.event;

import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements q {
    public final InputSupportType a;

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return c.a.a(this);
    }

    public b(InputSupportType r2) {
        Intrinsics.checkNotNullParameter(r2, "inputType");
        this.a = r2;
    }
}
