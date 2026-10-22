package l2a;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends TransitionSet {
    public c() {
        setOrdering(0);
        ChangeBounds r1 = new ChangeBounds();
        r1.setDuration(150);
        r1.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
        addTransition(r1);
        Transition r2 = new a(false);
        r2.setDuration(150);
        r2.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
        addTransition(r2);
    }
}
