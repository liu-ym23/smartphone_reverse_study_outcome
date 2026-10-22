package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q implements Function0 {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ q(PromptCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final PromptCell r0 = this.a;
        Keva r1 = PromptCell.Y;
        if (com.larus.bmhome.chat.helper.f.a == true) goto L9;
        com.larus.bmhome.chat.helper.f.a = true;
        PromptSpan r2 = r0.e;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r2 = null;
    L7:
        r2.post(new z(r0));
    L9:
        return Unit.INSTANCE;
    }
}
