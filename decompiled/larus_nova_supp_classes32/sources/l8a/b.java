package l8a;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class b extends AnimationBackendDelegate {
    public final int a;

    public final int getLoopCount() {
        return this.a;
    }

    public b(AnimationBackend r1, int r2) {
        super(r1);
        this.a = r2;
    }
}
