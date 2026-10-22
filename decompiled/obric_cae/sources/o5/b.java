package o5;

import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationNotification f9660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9661b;

    public b(LocationNotification r8, Object r10) {
        this.f9660a = r8;
        this.f9661b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.addNotification(this.f9660a, this.f9661b);
    }
}
