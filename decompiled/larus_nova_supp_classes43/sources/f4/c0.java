package f4;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0 extends WindowInsetsAnimation.Callback {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ Function0<Unit> d;

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets r10, List<WindowInsetsAnimation> r11) {
        Intrinsics.checkNotNullParameter(r10, "insets");
        Intrinsics.checkNotNullParameter(r11, "runningAnimations");
        return r10;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        super.onEnd(r10);
        if (this.a.compareAndSet(false, true) == false) goto L6;
        this.b.removeCallbacks(this.c);
        this.d.invoke();
        return;
    }

    public c0(AtomicBoolean r1, View r10, a0 r11, z r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        super(1);
    }
}
