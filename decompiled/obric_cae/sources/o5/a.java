package o5;

import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationNotification f9658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9659b;

    public a(LocationNotification r8, int r10) {
        this.f9658a = r8;
        this.f9659b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.addNotification(this.f9658a, this.f9659b);
    }
}
