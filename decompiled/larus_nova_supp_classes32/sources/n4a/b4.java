package n4a;

import android.os.Bundle;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b4 {
    public static void a(AMapLocation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Bundle r0 = r3.getExtras();
        if (r0 != null) goto L9;
        Bundle r1 = new Bundle();
        r1.putInt("realLocationType", r3.getLocationType());
        r3.setExtras(r1);
        return;
    L9:
        if (r0.containsKey("realLocationType") == true) goto L12;
        r0.putInt("realLocationType", r3.getLocationType());
        return;
    }
}
