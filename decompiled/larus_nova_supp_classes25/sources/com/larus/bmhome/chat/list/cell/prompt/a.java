package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ a(PromptCell r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final PromptCell r0 = this.a;
        Keva r1 = PromptCell.Y;
        if (r0.D().d() == true) goto L10;
        r0.Z();
        PromptSpan r2 = r0.e;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r2 = null;
    L8:
        r2.post(new c0(r0));
        return;
    }
}
