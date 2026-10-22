package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.bytedance.android.livesdk.r3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnAttachStateChangeListener {
    public final /* synthetic */ UserInfoBasicElement a;
    public final /* synthetic */ AccessibilityManagerCompat.TouchExplorationStateChangeListener b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        r3.o(this.a.getContext(), this.b);
    }

    public a(UserInfoBasicElement r1, b r2) {
        this.a = r1;
        this.b = r2;
    }
}
