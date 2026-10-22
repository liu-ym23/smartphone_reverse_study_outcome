package iw0;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static void b(Map r4) {
        k r0 = (k) f.d(j.C0.a(), k.class);
        String r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = r0.getRoom();
    L6:
        if (r2 == null) goto L8;
        Long r3 = Long.valueOf(r2.getId());
    L9:
        HashMap r5 = (HashMap) r4;
        r5.put("room_id", String.valueOf(r3));
        if (r2 == null) goto L14;
        IBaseUser r6 = r2.getOwner();
        if (r6 == null) goto L14;
        r1 = r6.getIdString();
    L14:
        r5.put("anchor_id", String.valueOf(r1));
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final void a(Throwable r4) {
        HashMap r0 = new HashMap();
        b(r0);
        if (r4 != null) goto L5;
    L7:
        LiveSlardarMonitor.monitorStatus("ttlive_income_exchange_error", 11, r0);
        int r5 = v.a;
        v.d("ttlive_exchange", r0);
        return;
    L5:
        if ((r4 instanceof ApiException) == false) goto L7;
        r0.put("error_code", String.valueOf(((ApiException) r4).getErrorCode()));
        r0.put("error_message", String.valueOf(r4.getMessage()));
        goto L7
    }
}
