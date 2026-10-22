package com.lynx.clay.embedding.android;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ k b;
    public final /* synthetic */ SurfaceSnapshotController c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        if (this.a == true) goto L14;
        SurfaceSnapshotController r4 = this.c;
        if (r4.c == this.b) goto L7;
        return;
    L7:
        if (r4.e != SurfaceSnapshotController.OverlayState.FADING_OUT) goto L16;
        FlutterSurfaceView r0 = r4.b;
        if (r0 == null) goto L12;
        SurfaceSnapshotTracker r1 = r0.b;
        r1.j();
        r1.d = false;
        r1.i();
        r1.a.animate().cancel();
        r1.a.setAlpha(1.0f);
    L12:
        r4.h();
        return;
    L16:
        return;
    }

    public s(SurfaceSnapshotController r1, k r2) {
        this.c = r1;
        this.b = r2;
        this.a = false;
    }
}
