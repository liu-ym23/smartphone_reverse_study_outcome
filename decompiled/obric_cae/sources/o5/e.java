package o5;

import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationSubmitNotification f9666a;

    public e(LocationSubmitNotification r8) {
        this.f9666a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.removeSubmitNotification(this.f9666a);
    }
}
