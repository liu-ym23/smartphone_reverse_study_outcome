package com.ss.android.lark.inline.ai.ui;

import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x implements PromptsAdapter.b {
    public final /* synthetic */ InlineAIPanelController a;

    public x(InlineAIPanelController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter.b
    public final void a(Prompt r3) {
        Intrinsics.checkNotNullParameter(r3, "prompt");
        Log.i("InlineAIPanelController", "click prompt");
        if (r3.getRightArrow() == false) goto L5;
        this.a.i();
    L5:
        this.a.D.setText(null);
        this.a.b.q(r3);
    }

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter.b
    public final void b(Prompt r3) {
        Intrinsics.checkNotNullParameter(r3, "prompt");
        Log.i("InlineAIPanelController", "RecentPrompt onDeleteClick");
        this.a.b.m(r3);
    }
}
