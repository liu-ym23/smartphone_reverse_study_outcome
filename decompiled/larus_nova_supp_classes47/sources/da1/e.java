package da1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.message.model.lk;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ c a;

    public e(c r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        sh6.b r8 = (sh6.b) r7;
        c r0 = this.a;
        dh1.a r1 = (dh1.a) sh6.c.b(r8);
        if (r1 == null) goto L5;
        long r4 = r1.a;
    L7:
        if (r4 <= 0) goto L9;
        boolean r2 = true;
    L10:
        r0.l = r2;
        StringBuilder r3 = new StringBuilder("rtcRoomInfo  onValueChanged RoomId: ");
        dh1.a r9 = (dh1.a) sh6.c.b(r8);
        Long r5 = null;
        if (r9 == null) goto L13;
        Long r10 = Long.valueOf(r9.a);
    L14:
        r3.append(r10);
        r3.append(", startShowRtcInfo: ");
        r3.append(this.a.l);
        ALogger.i("LiveWatchPresenterKt", r3.toString());
        c r12 = this.a;
        if (r12.l == true) goto L33;
        vlc.d r13 = ((n) r12).d;
        if (r13 == null) goto L26;
        lk r14 = bc2.d.a(r13, "WebcastRoomRankMessage");
        if (r14 == null) goto L26;
        c r6 = this.a;
        DataCenter r15 = ((n) r6).c;
        if (r15 == null) goto L25;
        IRoom r16 = a0.n(r15);
        if (r16 == null) goto L25;
        r5 = Long.valueOf(r16.getRoomId());
    L25:
        r6.l0(r14, r5);
    L26:
        vlc.d r17 = ((n) this.a).d;
        if (r17 == null) goto L31;
        mk r18 = bc2.d.a(r17, "WebcastRoomStatsMessage");
        if (r18 == null) goto L31;
        this.a.j0(r18);
    L31:
        c r19 = this.a;
        r19.j = 0;
        r19.k = 0;
        return;
    L33:
        return;
    L13:
        r10 = null;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = 0;
        goto L7
    }
}
