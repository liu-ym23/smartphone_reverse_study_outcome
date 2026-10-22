package com.ss.android.lark.inline.ai.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c0 implements PromptsRecyclerView.b {
    public final /* synthetic */ SubPromptsPanelController a;
    public final /* synthetic */ View b;

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView.b
    public final void a(boolean r2) {
        RecyclerView r0 = this.a.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("promptsRv");
        r0 = null;
    L6:
        if (r0.getVisibility() != 0) goto L13;
        View r1 = this.b;
        if (r2 == false) goto L10;
        int r3 = 0;
    L11:
        r1.setVisibility(r3);
        return;
    L10:
        r3 = 8;
        goto L11
    }

    public c0(SubPromptsPanelController r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
