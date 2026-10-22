package z1;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    void onError(BDLocationException r8);

    void onLocationChanged(BDLocation r8);
}
