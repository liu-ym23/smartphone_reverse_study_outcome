package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ q0(PromptCell r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        PromptCell r10 = this.a;
        if ((r5 - r3) != (r9 - r7)) goto L5;
        Keva r11 = PromptCell.Y;
        return;
    L5:
        if (r10.y == true) goto L7;
        return;
    L7:
        if (r10.D().f == true) goto L18;
        PromptSpan r12 = r10.e;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r12 = null;
    L12:
        if (r12.getVisibility() != 0) goto L20;
        r10.O();
        return;
    L20:
        return;
    }
}
