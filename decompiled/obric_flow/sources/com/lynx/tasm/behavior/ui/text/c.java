package com.lynx.tasm.behavior.ui.text;

import android.graphics.drawable.Drawable;
import com.lynx.tasm.utils.j;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10707a;

    public c(FlattenUIText r5) {
        this.f10707a = new WeakReference(r5);
        r5.getLynxContext().getClass();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        if (j.j() == false) goto L10;
        FlattenUIText r10 = (FlattenUIText) this.f10707a.get();
        if (r10 == null) goto L9;
        r10.invalidate();
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
        j.a().postAtTime(r10, r5, r11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r5, Runnable r10) {
        j.a().removeCallbacks(r10, r5);
    }
}
