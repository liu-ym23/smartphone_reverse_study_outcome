package k5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import x4.r;

/* JADX INFO: loaded from: classes.dex */
public final class f extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f8935a;

    public f(g r8) {
        this.f8935a = r8;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        g.f8938d = r5.e.d(this.f8935a.f8940a);
        g.f8938d.name();
        int r11 = r.f13543a;
    }
}
