package com.ss.android.lark.inline.ai.ui;

import com.ss.android.lark.inline.ai.ui.images.InlineAIImageRecyclerView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z implements InlineAIImageRecyclerView.ImageAdapter.a {
    public final /* synthetic */ InlineAIPanelController a;

    @Override // com.ss.android.lark.inline.ai.ui.images.InlineAIImageRecyclerView.ImageAdapter.a
    public final void d() {
        this.a.b.d();
    }

    public z(InlineAIPanelController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.ui.images.InlineAIImageRecyclerView.ImageAdapter.a
    public final void e(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.a.b.o(r2);
    }

    @Override // com.ss.android.lark.inline.ai.ui.images.InlineAIImageRecyclerView.ImageAdapter.a
    public final void c(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a.b.c(r2, r3);
    }
}
