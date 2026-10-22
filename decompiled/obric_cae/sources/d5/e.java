package d5;

import android.annotation.SuppressLint;
import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.CloudServiceConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e extends d {
    public e() {
        super(true, false);
    }

    @Override // d5.d
    @SuppressLint({"MissingPermission"})
    public final boolean a(JSONObject r8) {
        r8.put("os", LocationInfoConst.SYSTEM);
        r8.put(CloudServiceConstants.OCloud.HEADER_OS_VERSION, Build.VERSION.RELEASE);
        r8.put("os_api", Build.VERSION.SDK_INT);
        String r10 = Build.BRAND;
        if (r10.equals("Pico") == false) goto L5;
        Object r11 = k5.j.a();
    L6:
        r8.put("device_model", r11);
        r8.put(LocationMonitorConst.DEVICE_BRAND, r10);
        r8.put("device_manufacturer", Build.MANUFACTURER);
        r8.put("cpu_abi", Build.CPU_ABI);
        return true;
    L5:
        r11 = Build.MODEL;
        goto L6
    }
}
