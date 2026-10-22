package o5;

import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f9664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationSubmitNotification f9665b;

    public d(Object r8, LocationSubmitNotification r10) {
        this.f9664a = r8;
        this.f9665b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.addSubmitNotification(this.f9664a, this.f9665b);
    }
}
