package com.bytedance.android.live.matchroom;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements Animator.AnimatorListener {
    public boolean a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Map.Entry c;
    public final /* synthetic */ List d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a == true) goto L8;
        boolean r3 = MatchRoomLandScapeAnimUtil.a;
        if (MatchRoomLandScapeAnimUtil.c != 0) goto L9;
        this.b.setClipToOutline(false);
        ALogger.i("MatchRoomAnimUtil", "hide end clipToOutline[false] onAnimationEnd for " + ((String) this.c.getKey()));
        return;
    L9:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.setClipToOutline(true);
    }

    public k(View r1, Map.Entry r2, List r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
