package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q2 {
    public static final boolean a(Room r1) {
        if (r1 == null) goto L12;
        EpisodeExtraInfo r2 = r1.getEpisodeComponentData();
        if (r2 == null) goto L12;
        VSLinkedRoomInfo r3 = r2.getVsLinkedRoomInfo();
        if (r3 == null) goto L12;
        List r4 = r3.getRooms();
        if (r4 == null) goto L12;
        if ((!r4.isEmpty()) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean b(Room r1) {
        if (r1 == null) goto L10;
        EpisodeExtraInfo r2 = r1.getEpisodeComponentData();
        if (r2 == null) goto L10;
        List r3 = r2.getCameraInfos();
        if (r3 == null) goto L10;
        if ((!r3.isEmpty()) != true) goto L10;
        return true;
    L10:
        return false;
    }

    public static final boolean c(Room r3) {
        Object r0 = null;
        if (r3 == null) goto L15;
        EpisodeExtraInfo r4 = r3.getEpisodeComponentData();
        if (r4 == null) goto L15;
        List r5 = r4.getCameraInfos();
        if (r5 == null) goto L15;
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        if (((IVSCameraInfo) r1).isPaidCamera() == false) goto L10;
        r0 = r1;
    L14:
        r0 = (IVSCameraInfo) r0;
    L15:
        if (r0 == null) goto L17;
        return true;
    L17:
        return false;
    }
}
