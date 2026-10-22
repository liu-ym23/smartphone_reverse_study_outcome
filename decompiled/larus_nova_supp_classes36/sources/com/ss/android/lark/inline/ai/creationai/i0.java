package com.ss.android.lark.inline.ai.creationai;

import android.text.TextUtils;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.creationai.quickPrompt.QuickPromptAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i0 implements QuickPromptAdapter.b {
    public final /* synthetic */ g0 a;

    public i0(g0 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.creationai.quickPrompt.QuickPromptAdapter.b
    public final void a(MenuItem r3) {
        Intrinsics.checkNotNullParameter(r3, "menuItem");
        if (TextUtils.equals(r3.getType(), "dataset") == false) goto L5;
        this.a.b.o(r3);
        return;
    L5:
        this.a.b.n(r3);
    }
}
