package wt1;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends AnimationBackendDelegate {
    public final int a;

    public final int getLoopCount() {
        return this.a;
    }

    public a(AnimationBackend r1) {
        super(r1);
        this.a = Integer.MAX_VALUE;
    }
}
