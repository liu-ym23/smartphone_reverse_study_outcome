package com.ss.android.lark.inline.ai.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d0 implements InlineAIDragView.d {
    public final /* synthetic */ SubPromptsPanelController a;

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void a(int r1) {
    }

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void b(boolean r1) {
    }

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void c() {
        Intrinsics.checkNotNullParameter("swipe_down", "closeType");
    }

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void d() {
        this.a.a(false, true);
    }

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void onClose() {
        Intrinsics.checkNotNullParameter("swipe_down", "closeType");
        this.a.a(false, false);
    }

    public d0(SubPromptsPanelController r1) {
        this.a = r1;
    }
}
