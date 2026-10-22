package y69;

import android.os.Bundle;
import by7.h;
import com.ixigua.lib.track.TrackParams;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final String a(DoraBaseFragment r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        boolean r0 = true;
        if (r5 == null) goto L15;
        String r6 = r5.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
        if (r6 == null) goto L15;
        if (r6.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L15;
        return r6;
    L9:
        r3 = false;
    L15:
        TrackParams r7 = h.e(r4);
        if (r7 == null) goto L31;
        HashMap r8 = r7.getParams();
        if (r8 == null) goto L32;
        Object r9 = r8.get("current_page");
        if (r9 == null) goto L33;
        String r10 = r9.toString();
        if (r10 != null) goto L24;
        return null;
    L24:
        if (r10.length() > 0) goto L27;
        r0 = false;
    L27:
        if (r0 == true) goto L29;
        return null;
    L29:
        return r10;
    L33:
        return null;
    L32:
        return null;
    L31:
        return null;
    }
}
