package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n0 implements Function0 {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ n0(PromptCell r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.list.cell.prompt.d0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.chat.list.cell.prompt.e0] */
    public final Object invoke() {
        final PromptCell r0 = this.a;
        Keva r1 = PromptCell.Y;
        PromptSpan r2 = r0.e;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r2 = null;
    L6:
        return new s1(r2, (ICoreInputAbility) r0.l.getValue(), (va8.o) r0.m.getValue(), new d0(r0), new e0(r0));
    }
}
