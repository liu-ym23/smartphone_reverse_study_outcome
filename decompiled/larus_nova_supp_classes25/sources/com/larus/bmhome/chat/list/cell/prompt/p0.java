package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ p0(PromptCell r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        PromptCell r10 = this.a;
        if (r10.u == true) goto L5;
        return;
    L5:
        if (r10.D().f == true) goto L18;
        PromptSpan r11 = r10.e;
        PromptSpan r12 = null;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r11 = null;
    L10:
        if (r11.getVisibility() != 0) goto L19;
        PromptSpan r13 = r10.e;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("span");
    L15:
        r10.K(r12.getPromptContentHeight());
        return;
    L14:
        r12 = r13;
        goto L15
    L19:
        return;
    }
}
