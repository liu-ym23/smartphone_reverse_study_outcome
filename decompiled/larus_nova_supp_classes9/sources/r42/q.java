package r42;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q {
    static {
    }

    public static void a(String r4) {
        HashMap r0 = new HashMap();
        if (r4 != null) goto L5;
        r4 = BuildConfig.FLAVOR;
    L5:
        r0.put("history_comment_type", r4);
        j0.l().sendLog("livesdk_history_comment_click", r0, new Object[]{new x(), IRoom.class});
    }
}
