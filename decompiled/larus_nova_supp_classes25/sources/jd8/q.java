package jd8;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q implements View.OnAttachStateChangeListener {
    public final /* synthetic */ com.larus.bmhome.chat.component.bottom.core.follow.a a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public q(com.larus.bmhome.chat.component.bottom.core.follow.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        final com.larus.bmhome.chat.component.bottom.core.follow.a r0 = this.a;
        r3.post(new p(r0));
    }
}
