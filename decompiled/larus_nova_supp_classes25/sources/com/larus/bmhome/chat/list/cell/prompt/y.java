package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.layout.item.PromptSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ PromptCell b;

    public /* synthetic */ y(String r1, PromptCell r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        PromptCell r1 = this.b;
        if (Intrinsics.areEqual(r0, r1.v) == true) goto L5;
        return;
    L5:
        if (r1.D().f == true) goto L19;
        PromptSpan r2 = r1.e;
        PromptSpan r3 = null;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r2 = null;
    L10:
        if (r2.getVisibility() != 0) goto L20;
        PromptSpan r4 = r1.e;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("span");
    L16:
        r1.K(r3.getPromptContentHeight());
        return;
    L15:
        r3 = r4;
        goto L16
    L20:
        return;
    }
}
