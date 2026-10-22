package fd;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static boolean a(Context r8) {
        String r10 = Application.getProcessName();
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.contains(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L9;
        return false;
    L9:
        if (r10.equals(r8.getPackageName()) == false) goto L12;
        return true;
    L12:
        if (r10.equals(r8.getApplicationInfo().processName) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
