package qw0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r4) {
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
}
