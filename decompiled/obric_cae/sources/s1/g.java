package s1;

import android.net.wifi.WifiManager;
import androidx.work.impl.WorkDatabase;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfoDao;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11976b;

    public /* synthetic */ g(Object r8, int r10) {
        this.f11975a = r10;
        this.f11976b = r8;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int r8 = this.f11975a;
        Object r10 = this.f11976b;
        switch(r8) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L12;
        };
    L9:
        androidx.lifecycle.s r11 = (androidx.lifecycle.s) r10;
        he.i.f(r11, "this$0");
        return Integer.valueOf(t2.b.e((WorkDatabase) r11.f2194b, "next_alarm_manager_id"));
    L6:
        return Boolean.valueOf(BdLocationManager.f((BdLocationManager) r10));
    L8:
        return ((WifiManager) r10).getScanResults();
    L12:
        return ((CarkeyAppInfoDao) r10).getAll();
    }
}
