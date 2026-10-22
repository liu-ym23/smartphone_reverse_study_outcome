package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> {
    public final /* synthetic */ l a;

    public j(l r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
    public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "rendResult");
        this.a.b.setText(r3.a);
    }
}
