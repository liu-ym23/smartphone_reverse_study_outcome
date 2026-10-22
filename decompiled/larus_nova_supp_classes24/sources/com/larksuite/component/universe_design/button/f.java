package com.larksuite.component.universe_design.button;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements Drawable.Callback {
    public final /* synthetic */ UDButton a;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "who");
        Intrinsics.checkNotNullParameter(r2, "what");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r2, "who");
        Intrinsics.checkNotNullParameter(r3, "what");
    }

    public f(UDButton r1) {
        this.a = r1;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        this.a.invalidate();
    }
}
