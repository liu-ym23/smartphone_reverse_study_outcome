package w31;

import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    static {
    }

    public static void a(HashMap r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L7;
        com.bytedance.android.live.revlink.impl.pk.service.d r1 = r0.h();
        if (r1 == null) goto L7;
        r3.put("channel_id", String.valueOf(r1.channelId()));
    L7:
        c r2 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r2 == null) goto L13;
        IPKLinkBizDataService r4 = r2.g();
        if (r4 == null) goto L14;
        r3.put("invitee_id", String.valueOf(r4.getGuestInfo().b));
        int r5 = UserListInviteType.a;
        r3.put("invitee_list", UserListInviteType.a(r4.getLinkTypeParams().b, null));
        return;
    L14:
        return;
    }
}
