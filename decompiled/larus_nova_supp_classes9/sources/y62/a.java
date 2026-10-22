package y62;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.settings.config.v;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import r52.l1;
import r52.m1;
import r52.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final boolean a = false;
    public static final boolean b = false;
    public static final v c = null;
    public static final int d = 0;
    public static final float e = 0.0f;
    public static final int f = 0;

    static {
        a = ((Boolean) m1.a.getValue()).booleanValue();
        b = ((Boolean) l1.a.getValue()).booleanValue();
        v r0 = (v) n1.a.getValue();
        c = r0;
        d = r0.d();
        e = s1.G(s1.y());
        f = r0.a();
    }

    public static boolean a(IRoom r8, boolean r9) {
        if (r8 == null) goto L23;
        IRoomAuthStatus r10 = r8.getRoomAuthStatus();
        if (r10 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.service.model.c r11 = (com.bytedance.android.livesdk.interactivity.service.model.c) r10.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r11 == null) goto L9;
        long r3 = r11.getMyLiveEntrance();
    L11:
        if (r3 != 1) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == true) goto L19;
        return false;
    L19:
        if (a == false) goto L26;
        if (r9 == false) goto L27;
        return true;
    L27:
        return false;
    L26:
        return false;
    L13:
        if (r3 == 0) goto L16;
        r1 = false;
        goto L17
    L9:
        r3 = 0;
        goto L11
    L24:
        return false;
    L23:
        return false;
    }
}
