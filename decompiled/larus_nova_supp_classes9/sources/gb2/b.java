package gb2;

import com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom;
import com.bytedance.android.livesdkapi.depend.model.live.ClientComponent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final ClientComponent a(IRoom r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$clientComponentData");
        Intrinsics.checkNotNullParameter(r1, "$this$communityMainRoomOrNull");
        ICommunityMainRoom r2 = (ICommunityMainRoom) r1.castToOrNull(ICommunityMainRoom.class);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getClientComponentData();
    }

    public static final RoomPublicScreenInfo b(IRoom r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$publicScreenInfo");
        Intrinsics.checkNotNullParameter(r1, "$this$communityMainRoomOrNull");
        ICommunityMainRoom r2 = (ICommunityMainRoom) r1.castToOrNull(ICommunityMainRoom.class);
        if (r2 == null) goto L7;
        IRoomPlatformComponentsData r3 = r2.getRoomPlatformComponentsData();
        if (r3 == null) goto L7;
        return r3.getPublicScreenInfo();
    L7:
        return null;
    }

    public static final RoomAvator c(IRoom r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$roomAvatar");
        Intrinsics.checkNotNullParameter(r1, "$this$communityMainRoomOrNull");
        ICommunityMainRoom r2 = (ICommunityMainRoom) r1.castToOrNull(ICommunityMainRoom.class);
        if (r2 == null) goto L7;
        IRoomPlatformComponentsData r3 = r2.getRoomPlatformComponentsData();
        if (r3 == null) goto L7;
        return r3.getRoomAvator();
    L7:
        return null;
    }
}
