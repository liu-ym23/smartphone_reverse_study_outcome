package jw1;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.MatchData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MainCameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    public static final boolean b(Room r5) {
        Long r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L9;
        Long r3 = Long.valueOf(r2.id);
    L10:
        if (r5 == null) goto L13;
        r4 = Long.valueOf(r5.id);
    L13:
        return Intrinsics.areEqual(r3, r4);
    L9:
        r3 = null;
        goto L10
    }

    public static final void a(Room r6, int r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r6, "room");
        Intrinsics.checkNotNullParameter(r8, "extra");
        EpisodeExtraInfo r0 = r6.getEpisodeComponentData();
        py.k r1 = null;
        if (r0 == null) goto L7;
        MainCameraMatchInfo r2 = r0.getMainCameraMatchInfo();
        if (r2 == null) goto L7;
        MatchData r3 = r2.getMatchData();
    L8:
        String r4 = "1";
        if (r3 == null) goto L11;
        r8.put("is_game_data", "1");
    L13:
        if (r7 != 1) goto L23;
        EpisodeExtraInfo r5 = r6.getEpisodeExtra2();
        if (r5 == null) goto L19;
        VSConfigDrawer r9 = r5.getVsConfigDrawer();
        if (r9 == null) goto L19;
        r1 = r9.drawerLabel;
    L19:
        if (r1 != null) goto L22;
        r4 = "0";
    L22:
        r8.put("is_tag", r4);
    L35:
        if (r7 == 1) goto L45;
        if (r7 != 2) goto L48;
        EpisodeExtraInfo r10 = r6.getEpisodeComponentData();
        if (r10 == null) goto L48;
        List r11 = r10.getCameraInfos();
        if (r11 == null) goto L48;
        IVSCameraInfo r12 = (IVSCameraInfo) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L48;
        long r13 = r12.getCameraId();
    L49:
        r8.put("vs_machine_id", String.valueOf(r13));
        if (r7 == 1) goto L54;
        if (r7 == 2) goto L53;
        String r14 = "others";
    L55:
        r8.put("vs_machine_type", r14);
        return;
    L53:
        r14 = "others_game";
        goto L55
    L54:
        r14 = "major";
    L48:
        r13 = 0;
        goto L49
    L45:
        EpisodeExtraInfo r15 = r6.getEpisodeComponentData();
        if (r15 == null) goto L48;
        r13 = r15.getDefaultCameraId();
        goto L49
    L23:
        EpisodeExtraInfo r16 = r6.getEpisodeComponentData();
        if (r16 == null) goto L30;
        List r17 = r16.getCameraInfos();
        if (r17 == null) goto L30;
        IVSCameraInfo r18 = (IVSCameraInfo) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L30;
        r1 = r18.getLabel();
    L30:
        if (r1 != null) goto L33;
        r4 = "0";
    L33:
        r8.put("is_tag", r4);
        goto L35
    L11:
        r8.put("is_game_data", "0");
    L7:
        r3 = null;
        goto L8
    }
}
