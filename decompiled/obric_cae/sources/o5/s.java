package o5;

import com.bytedance.bdlocation.client.BDLocationConfig;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.setRequestLocation(true);
    }
}
