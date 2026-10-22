package androidx.lifecycle;

import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class g implements LifecycleEventObserver {
    public final /* synthetic */ z0 a;

    public /* synthetic */ g(StateFlowImpl r1) {
        this.a = r1;
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Lifecycle.e(this.a, r2, r3);
    }
}
