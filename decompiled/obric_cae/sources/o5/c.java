package o5;

import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationNotification f9662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9663b;

    public c(LocationNotification r8, int r10) {
        this.f9662a = r8;
        this.f9663b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.removeNotification(this.f9662a, this.f9663b);
    }
}
