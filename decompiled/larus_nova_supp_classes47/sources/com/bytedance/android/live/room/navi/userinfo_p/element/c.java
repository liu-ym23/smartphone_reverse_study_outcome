package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.view.View;
import com.bytedance.android.livesdk.r3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnAttachStateChangeListener {
    public final /* synthetic */ UserInfoBasicElement a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public c(UserInfoBasicElement r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        r3.o(this.a.getContext(), this.a.h);
    }
}
