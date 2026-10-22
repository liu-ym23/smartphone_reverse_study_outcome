package l2a;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends TransitionSet {
    public d() {
        setOrdering(0);
        ChangeBounds r0 = new ChangeBounds();
        r0.setDuration(150);
        r0.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        addTransition(r0);
        Transition r1 = new a(true);
        r1.setDuration(150);
        r1.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        addTransition(r1);
    }
}
