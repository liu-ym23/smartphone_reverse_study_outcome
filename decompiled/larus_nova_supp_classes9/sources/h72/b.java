package h72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    @JvmStatic
    public static final Integer a() {
        RoomContext r0 = d.e(RoomContext.class, RoomContext.class);
        if (r0 == null) goto L7;
        j r1 = r0.getVoiceTalkRoomSubScene();
        if (r1 == null) goto L7;
        f r2 = (f) r1.getValue();
    L8:
        if (r2 == null) goto L12;
        i r3 = r2.t();
        if (r3 == null) goto L12;
        int r4 = r3.a;
    L14:
        if (r4 == 10) goto L16;
        return null;
    L16:
        return Integer.valueOf(s1.j(2131169127));
    L12:
        r4 = 0;
    L7:
        r2 = null;
        goto L8
    }

    static {
    }
}
