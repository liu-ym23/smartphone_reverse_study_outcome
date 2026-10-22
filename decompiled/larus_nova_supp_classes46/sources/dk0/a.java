package dk0;

import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "status");
        Intrinsics.checkNotNullParameter(r6, "toUser");
        HashMap r1 = new HashMap();
        if (TextUtils.equals(r5, "限时") == false) goto L6;
        r1.put("status", "limited");
    L8:
        r1.put("activity", r4);
        r1.put("request_page", r3);
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L11;
        r1.put("user_type", "anchor");
    L13:
        if (r2.a(r6) == false) goto L24;
        r1.put("to_user_id", r6);
        com.bytedance.live.datacontext.m r7 = m.i().getRoom();
        if (r7 == null) goto L19;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L19;
        String r9 = r8.getOwnerUserIdString();
    L21:
        if (Intrinsics.areEqual(r9, r6) == false) goto L23;
        r1.put("to_user_type", "anchor");
        goto L24
    L23:
        r1.put("to_user_type", "guest");
    L19:
        r9 = null;
    L24:
        j0.l().sendLog("livesdk_seat_panel_activity_entrance_show", r1, new Object[]{IRoom.class});
        return;
    L11:
        r1.put("user_type", "guest");
        goto L13
    L6:
        if (TextUtils.equals(r5, "奖励") == false) goto L8;
        r1.put("status", "reward");
        goto L8
    }
}
