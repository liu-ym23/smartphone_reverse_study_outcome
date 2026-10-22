package com.ss.android.lark.inline.ai.ui.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.b {
    public c() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(com.ss.android.lark.keyboard.edittext2.edittors.a r2, hob.c r3) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r3, "data");
        return new InlineAIAtSpanHolder(r2, r3);
    }
}
