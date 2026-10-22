package oi0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.VideoChatDynamic1V7Info;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONObject;
import sh0.h0;
import sh0.i0;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements oi0.a {
    public boolean b;
    public final DataCenter c;

    public static final class a {
    }

    static {
    }

    @Override // oi0.a
    public final void w0(boolean r1) {
    }

    @Override // oi0.a
    public final void onDestroy() {
        ALogger.i("MicSeatStatusController#Audience", "onDestroy");
    }

    @Override // oi0.a
    public final void onCreate() {
        LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
        String r1 = null;
        if (r0 == null) goto L13;
        dc2.c r2 = r0.getTalkRoomListUserInfoPb();
        if (r2 == null) goto L13;
        IRoomLinkMicSyncData r3 = (IRoomLinkMicSyncData) r2.c();
        if (r3 == null) goto L13;
        ClientUIInfo r4 = r3.getClientUIInfo();
        if (r4 == null) goto L13;
        VideoChatDynamic1V7Info r5 = r4.getVideoChatDynamic1V7Info();
        if (r5 == null) goto L13;
        Long r6 = Long.valueOf(r5.getStatus());
    L14:
        boolean r7 = false;
        if (r6 == null) goto L20;
        oi0.a.a.getClass();
        if (r6.longValue() != 2) goto L19;
        r7 = true;
    L19:
        this.b = r7;
        ALogger.i("MicSeatStatusController#Audience", "onCreate, wrdsStatus: " + r6 + ", isCurrentMicSeatStash: " + this.b);
    L33:
        i0 r8 = j0.a(this.c);
        if (r8 == null) goto L39;
        int r9 = h0.a;
        r8.b("is_mic_seat_fold", Boolean.valueOf(this.b));
        return;
    L39:
        return;
    L20:
        Room r10 = m.i().getCurrentRoom();
        if (r10 == null) goto L37;
        z5 r11 = r10.getLinkerDetail();
        if (r11 == null) goto L37;
        r1 = r11.getClientUiInfo();
    L37:
        long r12 = JSONObjectProtectorUtils.getLong(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r1), "video_chat_dynamic_1v7"), "Status");     // Catch: Exception -> L30
        oi0.a.a.getClass();     // Catch: Exception -> L30
        if (r12 != 2) goto L28;
        r7 = true;
    L28:
        this.b = r7;     // Catch: Exception -> L30
    L32:
        ALogger.i("MicSeatStatusController#Audience", "onCreate, clientUiInfo: " + r1 + ", isCurrentMicSeatStash: " + this.b);
    L30:
        e = move-exception;
        ALogger.e("MicSeatStatusController#Audience", "onCreate parse clientUiInfo failed", e);
    L13:
        r6 = null;
        goto L14
    }

    public c(DataCenter r1) {
        this.c = r1;
    }

    @Override // oi0.a
    public final void onSeiUpdated(SeiAppData r5) {
        if (r5 == null) goto L14;
        long r0 = r5.getPositionStashStatus();
        oi0.a.a.getClass();
        if (r0 != 2) goto L6;
        boolean r6 = true;
    L8:
        if (this.b != r6) goto L10;
        return;
    L10:
        ALogger.i("MicSeatStatusController#Audience", "onSeiUpdated, status: " + r0 + ", isCurrentMicSeatStash: " + this.b);
        this.b = r6;
        i0 r7 = j0.e(this.c);
        if (r7 == null) goto L15;
        int r1 = h0.a;
        r7.b("is_mic_seat_fold", Boolean.valueOf(this.b));
        return;
    L15:
        return;
    L6:
        r6 = false;
        goto L8
    }
}
