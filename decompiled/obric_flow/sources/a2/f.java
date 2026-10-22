package a2;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends WindowInsetsAnimation.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f60a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f61b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f62c;
    public final /* synthetic */ a d;

    public f(AtomicBoolean r5, View r10, b r11, a r12) {
        this.f60a = r5;
        this.f61b = r10;
        this.f62c = r11;
        this.d = r12;
        super(1);
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        super.onEnd(r5);
        if (this.f60a.compareAndSet(false, true) == false) goto L6;
        b r10 = this.f62c;
        this.f61b.removeCallbacks(r10);
        this.d.invoke();
        return;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets r5, List r10) {
        Intrinsics.checkNotNullParameter(r5, "insets");
        Intrinsics.checkNotNullParameter(r10, "runningAnimations");
        return r5;
    }
}
