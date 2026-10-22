package androidx.lifecycle;

import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class i implements LifecycleEventObserver {
    public final /* synthetic */ k a;

    public /* synthetic */ i(k r1) {
        this.a = r1;
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        LifecycleKt.eventFlow.1.c(this.a, r2, r3);
    }
}
