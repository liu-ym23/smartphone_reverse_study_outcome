package st0;

import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends e {
    public final boolean d;

    public d() {
        this(false, false, false, 7);
    }

    public d(boolean r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = false;
    L11:
        o r7 = os0.b.a();
        if (r7 == null) goto L24;
        m r8 = r7.getRoom();
        if (r8 == null) goto L24;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L24;
        IRoomAuthStatus r10 = r9.getRoomAuthStatus();
        if (r10 == null) goto L24;
        if (r10.isShopFansClubMode() != true) goto L24;
        if (r5 == false) goto L23;
        String r12 = "购物粉丝团&会员";
    L27:
        super(1, r12, r3);
        this.d = r4;
        return;
    L23:
        r12 = "购物粉丝团";
    L24:
        if (r5 == false) goto L26;
        r12 = "粉丝团&会员";
        goto L27
    L26:
        r12 = "粉丝团";
        goto L27
    }
}
