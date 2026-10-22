package ff0;

import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.config.sz;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static boolean a;
    public static final boolean b = false;

    static {
        b = ((Boolean) sz.a.getValue()).booleanValue();
    }

    public static boolean b() {
        if (vm2.d.I().getMouthEnable() == true) goto L5;
    L9:
        return false;
    L5:
        if (vm2.d.I().getVadEnable() == false) goto L9;
        if (a == true) goto L9;
        return true;
    }

    public static String a(Throwable r1) {
        if ((r1 instanceof CustomApiServerException) == false) goto L6;
        return ((CustomApiServerException) r1).getXTtLogId();
    L6:
        if ((r1 instanceof ResponseNoDataException) == false) goto L11;
        BaseResponse r2 = ((ResponseNoDataException) r1).getResponse();
        if (r2 == null) goto L11;
        String r3 = r2.logId;
        if (r3 == null) goto L11;
        return r3;
    L11:
        return "";
    }
}
