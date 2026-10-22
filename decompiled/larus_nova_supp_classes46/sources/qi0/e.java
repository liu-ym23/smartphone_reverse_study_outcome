package qi0;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.q;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.VideoChatDynamic1V7Info;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static int a(int r2) {
        if (r2 != 16) goto L6;
        return 8;
    L6:
        if (r2 != 65) goto L8;
        return 8;
    L8:
        return 0;
    }

    @JvmStatic
    public static final boolean b() {
        if (je0.d.r() == true) goto L20;
        Integer r0 = je0.d.h();
        if (r0 != null) goto L8;
    L9:
        Integer r1 = je0.d.h();
        if (r1 == null) goto L15;
        if (r1.intValue() == 65) goto L20;
    L15:
        if (d() == true) goto L20;
        if (e() == true) goto L20;
        return false;
    L8:
        if (r0.intValue() != 16) goto L9;
    L20:
        return true;
    }

    @JvmStatic
    public static final boolean c() {
        Room r0 = m.i().getCurrentRoom();
        if (r0 == null) goto L8;
        RoomExtra r1 = r0.getExtra();
        if (r1 == null) goto L8;
        if (r1.isGroupLiveGame() != true) goto L8;
        return true;
    L8:
        Room r2 = m.i().getCurrentRoom();
        if (r2 == null) goto L15;
        z5 r3 = r2.getLinkerDetail();
        if (r3 == null) goto L15;
        if (r3.getUiLayout() != 65) goto L15;
        return true;
    L15:
        return false;
    }

    @JvmStatic
    public static final boolean d() {
        LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
        if (r0 == null) goto L15;
        dc2.c r1 = r0.getTalkRoomListUserInfoPb();
        if (r1 == null) goto L15;
        IRoomLinkMicSyncData r2 = (IRoomLinkMicSyncData) r1.c();
        if (r2 == null) goto L15;
        q r3 = r2.getLinkerBaseInfo();
        if (r3 == null) goto L15;
        List<Long> r4 = r3.getPlayModes();
        if (r4 == null) goto L15;
        if (r4.contains(Long.valueOf(38)) != true) goto L15;
        return true;
    L15:
        return false;
    }

    @JvmStatic
    public static final boolean e() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L6;
    L7:
        LinkMicRoomDataSyncModel r1 = LinkWRDSHelper.b();
        if (r1 == null) goto L20;
        dc2.c r2 = r1.getTalkRoomListUserInfoPb();
        if (r2 == null) goto L20;
        IRoomLinkMicSyncData r3 = (IRoomLinkMicSyncData) r2.c();
        if (r3 == null) goto L20;
        ClientUIInfo r4 = r3.getClientUIInfo();
        if (r4 == null) goto L20;
        VideoChatDynamic1V7Info r5 = r4.getVideoChatDynamic1V7Info();
        if (r5 == null) goto L20;
        if (r5.getMixType() != 2) goto L20;
    L21:
        return true;
    L20:
        return false;
    L6:
        if (r0.intValue() == 16) goto L21;
        goto L7
    }

    static {
    }
}
