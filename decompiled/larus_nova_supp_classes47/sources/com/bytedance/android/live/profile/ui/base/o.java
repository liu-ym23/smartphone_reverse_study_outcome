package com.bytedance.android.live.profile.ui.base;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o implements n {
    public final View a;

    @Override // com.bytedance.android.live.profile.ui.base.n
    public final int getBottom() {
        return this.a.getBottom();
    }

    @Override // com.bytedance.android.live.profile.ui.base.n
    public final ViewGroup.LayoutParams getLayoutParams() {
        return this.a.getLayoutParams();
    }

    public o(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.n
    public final void a(float r2) {
        this.a.setRotation(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.n
    public final void setLayoutParams(ViewGroup.LayoutParams r2) {
        this.a.setLayoutParams(r2);
    }
}
