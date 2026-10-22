package com.ss.android.lark.inline.ai.ui;

import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b0 implements PromptsAdapter.b {
    public final /* synthetic */ SubPromptsPanelController a;

    public b0(SubPromptsPanelController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter.b
    public final void a(Prompt r2) {
        Intrinsics.checkNotNullParameter(r2, "prompt");
        this.a.b.q(r2);
        if (r2.getRightArrow() == true) goto L6;
        this.a.a(true, true);
        return;
    }

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter.b
    public final void b(Prompt r3) {
        Intrinsics.checkNotNullParameter(r3, "prompt");
        Log.i("SubPromptsPanelController", "RecentPrompt onDeleteClick");
        this.a.b.m(r3);
    }
}
