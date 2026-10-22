package dk0;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import hd0.c;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "dressId");
        HashMap r0 = new HashMap();
        Integer r1 = (Integer) ((ge1.a) c.f()).b;
        if (r1 != null) goto L6;
    L11:
        r0.put("user_type", "user");
    L12:
        r0.put("to_user_id", r4);
        r0.put("decorate_type", "voice_wave");
        r0.put("decorate_id", r5);
        j0.l().sendLog("livesdk_guest_head_decorate_show", r0, new Object[]{IRoom.class});
        return;
    L6:
        if (r1.intValue() != 2) goto L11;
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L10;
        r0.put("user_type", "anchor");
        goto L12
    L10:
        r0.put("user_type", "guest");
        goto L12
    }
}
