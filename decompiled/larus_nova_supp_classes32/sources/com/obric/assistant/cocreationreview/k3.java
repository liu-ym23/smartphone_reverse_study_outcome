package com.obric.assistant.cocreationreview;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.widget.FrameLayout;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k3 extends WindowInsetsAnimation.Callback {
    public final /* synthetic */ CocreationReviewActivity a;

    public k3(CocreationReviewActivity r1) {
        this.a = r1;
        super(1);
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onEnd(r3);
        if ((r3.getTypeMask() & WindowInsets.Type.ime()) != 0) goto L5;
        return;
    L5:
        FrameLayout r4 = this.a.O;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r4 = null;
    L8:
        final CocreationReviewActivity r0 = this.a;
        r4.post(new j3(r0));
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets r2, List<WindowInsetsAnimation> r3) {
        Intrinsics.checkNotNullParameter(r2, "insets");
        Intrinsics.checkNotNullParameter(r3, "runningAnimations");
        CocreationReviewActivity r4 = this.a;
        Set<String> r0 = CocreationReviewActivity.P1;
        r4.e2(r2);
        return r2;
    }
}
