package com.bytedance.android.live.openplatform.api.utils;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Room r2) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        if (b(r2.getRoomStamps()) == true) goto L5;
        return false;
    L5:
        if (((wc1) de0.a.getValue()).m() != 1) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r3 = false;
        goto L8
    }

    public static boolean b(List r3) {
        if (r3 == null) goto L13;
        RoomStampInfo r4 = (RoomStampInfo) CollectionsKt.getOrNull(r3, 0);
        if (r4 == null) goto L13;
        if (r4.getType() != 4) goto L13;
        if (r4.getStatus() != 0) goto L11;
    L12:
        return true;
    L11:
        if (r4.getStatus() == 1) goto L12;
    L13:
        return false;
    }
}
