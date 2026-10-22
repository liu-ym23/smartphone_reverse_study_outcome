package cab;

import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Drawable.Callback {
    public final Function0<Unit> a;

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

    public a(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onInvalidateDrawable");
        this.a = r2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        this.a.invoke();
    }
}
