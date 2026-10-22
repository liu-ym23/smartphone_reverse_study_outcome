package e92;

import com.bytedance.android.livesdk.chatroom.RoomContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static boolean a() {
        RoomContext.Companion.getClass();
        RoomContext r0 = RoomContext.a.a(null, 0);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getCleanMode();
        if (r1 == null) goto L9;
        if (((Number) r1.getValue()).intValue() != 2) goto L9;
        boolean r2 = true;
    L10:
        boolean r3 = wt2.a.a();
        if (r2 == false) goto L15;
        if (r3 == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    static {
    }
}
