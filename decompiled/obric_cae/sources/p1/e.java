package p1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<Object> f9919a;

    public e(f<Object> r8) {
        this.f9919a = r8;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        he.i.f(r8, "context");
        he.i.f(r10, "intent");
        this.f9919a.g(r10);
    }
}
