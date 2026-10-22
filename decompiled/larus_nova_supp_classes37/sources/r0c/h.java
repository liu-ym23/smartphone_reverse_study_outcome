package r0c;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements LifecycleObserver {
    public final /* synthetic */ Lifecycle a;
    public final /* synthetic */ k b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.b.c();
        this.a.removeObserver(this);
    }

    public h(k r1, Lifecycle r2) {
        this.b = r1;
        this.a = r2;
    }
}
