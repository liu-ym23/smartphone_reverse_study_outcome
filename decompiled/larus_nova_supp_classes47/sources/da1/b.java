package da1;

import android.text.TextUtils;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.api.rank.IAudienceWidget;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.utils.p1;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RoomUserSeqMessage;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.live.datacontext.m;
import kotlin.Unit;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends n<IAudienceWidget> implements l {
    public static final /* synthetic */ int e = 0;

    public static final class a {
        public static boolean a() {
            return ((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_SERVER_CONTROL_MSEQ_USERS.getValue()).booleanValue();
        }
    }

    static {
    }

    public final void detachView() {
        super.detachView();
        vlc.d r0 = ((n) this).d;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public b() {
    }

    public final void c0(IWidget r5) {
        super.c0((IAudienceWidget) r5);
        if (a.a() == true) goto L23;
        vlc.d r6 = ((n) this).d;
        if (r6 == null) goto L7;
        r6.addMessageListener(MessageType.USER_SEQ.getIntType(), this);
    L7:
        Room r0 = null;
        long r1 = 0;
        MiddlewareRoomContext r7 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L12;
        m r8 = r7.getRoom();
        if (r8 == null) goto L12;
        r0 = (Room) r8.getValue();
    L12:
        if (r0 == null) goto L24;
        RoomUserSeqMessage r9 = new RoomUserSeqMessage();
        IRoomStats r3 = r0.getStats();
        if (r3 == null) goto L16;
        r1 = r3.getTotalUser();
    L16:
        r9.set_totalUser(r1);
        IRoomStats r2 = r0.getStats();
        if (r2 == null) goto L20;
        String r4 = r2.getTotalUserStr();
        if (r4 == null) goto L20;
    L21:
        r9.set_totalUserStr(r4);
        r9.set_mTotal(r0.getUserCount());
        r9.set_userCountStr(p1.b(r0));
        Unit r10 = Unit.INSTANCE;
        g0(r9);
        return;
    L20:
        r4 = "";
        goto L21
    L24:
        return;
    }

    public final void g0(RoomUserSeqMessage r12) {
        if (a.a() == true) goto L34;
        if (r12 != null) goto L6;
        return;
    L6:
        Room r1 = null;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        m r2 = r0.getRoom();
        if (r2 == null) goto L11;
        r1 = (Room) r2.getValue();
    L11:
        if (r1 == null) goto L17;
        RoomAuthStatus r3 = r1.getMRoomAuthStatus();
        if (r3 == null) goto L17;
        if (r3.countType != 1) goto L17;
        boolean r4 = true;
    L18:
        String r5 = "";
        if (r4 == false) goto L23;
        long r6 = r12.get_totalUser();
        String r13 = r12.get_totalUserStr();
        if (r13 == null) goto L27;
    L26:
        r5 = r13;
    L27:
        long r7 = r6;
        if (r7 >= 0) goto L30;
        return;
    L30:
        if (TextUtils.isEmpty(r5) == false) goto L32;
        r5 = DataType.FALSE;
    L32:
        String r9 = r5 + s1.B(2131914503);
        ((IAudienceWidget) ((q46.b) this).a).sn(false, r7, r9, r9);
        return;
    L23:
        r6 = r12.get_mTotal();
        r13 = r12.get_totalUserStr();
        if (r13 != null) goto L26;
    L17:
        r4 = false;
        goto L18
    }

    public final void onMessage(tlc.d r3) {
        if (((q46.b) this).a == null) goto L16;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.getIntType() != MessageType.USER_SEQ.getIntTypeExt()) goto L17;
        boolean r0 = r3 instanceof RoomUserSeqMessage;
        if (r0 == true) goto L11;
        return;
    L11:
        if (a.a() == true) goto L19;
        if (r0 == true) goto L14;
        r3 = null;
    L14:
        g0((RoomUserSeqMessage) r3);
        return;
    L19:
        return;
    L17:
        return;
    }
}
