package yha;

import com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u implements IWindowAnimationListener {
    public final /* synthetic */ t a;

    public u(t r1) {
        this.a = r1;
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener
    public final void onWindowAnimationStart(boolean r2, WindowAnimationType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a.s = !r2;
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener
    public final void onWindowAnimationEnd(boolean r1, WindowAnimationType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r1 == true) goto L6;
        this.a.s = false;
        return;
    }
}
