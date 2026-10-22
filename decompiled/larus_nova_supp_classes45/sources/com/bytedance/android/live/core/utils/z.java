package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.abs.EpisodeCompatDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IVSCompatRoom;
import com.bytedance.android.livesdkapi.depend.model.live.abs.RoomCompatDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.RoomPreloadStage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z {
    public static final Room a = null;
    public static final Episode b = null;

    static {
        a = new Room();
        b = new Episode();
    }

    public static final y b(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$common");
        IRoom r0 = (IRoom) r3.get("data_room");
        Object r1 = r3.get("data_is_portrait");
        if (r1 != null) goto L5;
        r1 = Boolean.TRUE;
    L5:
        boolean r2 = ((Boolean) r1).booleanValue();
        Object r4 = r3.get("data_is_anchor");
        if (r4 != null) goto L9;
        r4 = Boolean.FALSE;
    L9:
        return new y(r0, r2, ((Boolean) r4).booleanValue());
    }

    public static final LiveMode c(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getLiveMode");
        return (LiveMode) r2.get("data_live_mode", LiveMode.UNDEFINED);
    }

    public static /* synthetic */ boolean f(DataCenter r1) {
        return e(r1, false);
    }

    public static final boolean g(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r5 != LiveMode.AUDIO) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean h(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r5 != LiveMode.MEDIA) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean i(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r5 != LiveMode.SCREEN_RECORD) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean j(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", LiveMode.VIDEO);
        if (r1 == true) goto L8;
        return false;
    L8:
        if (r5 != LiveMode.THIRD_PARTY) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean k(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r2 = LiveMode.VIDEO;
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", r2);
        if (r1 == false) goto L10;
        if (r5 != r2) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static final boolean l(DataCenter r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isMergeVSRoom");
        return o(r1).isMergeVSRoom();
    }

    public static /* synthetic */ boolean n(DataCenter r1) {
        return m(r1, true);
    }

    public static final Room o(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$room");
        return (Room) r2.get("data_room", a);
    }

    public static final RoomPreloadStage p(DataCenter r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (RoomPreloadStage) r2.get("data_preload_stage", null);
    }

    public static final IVSCompatRoom q(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$vsCompatRoomSafety");
        IVSCompatRoom r2 = (IVSCompatRoom) r5.get("data_vs_compat_room", null);
        if (r2 != null) goto L15;
        Room r3 = (Room) r5.get("data_room", null);
        if (r3 == null) goto L7;
        RoomCompatDelegate r4 = new RoomCompatDelegate(r3);
    L11:
        if (r4 == null) goto L24;
        r5.put("data_vs_compat_room", r4);
        return r4;
    L24:
        return null;
    L7:
        Episode r6 = (Episode) r5.get("data_vs_episode_data", null);
        if (r6 == null) goto L10;
        r4 = new EpisodeCompatDelegate(r6);
        goto L11
    L10:
        r4 = null;
        goto L11
    L15:
        Room r7 = (Room) r5.get("data_room", null);
        if (r7 == null) goto L18;
        RoomCompatDelegate r8 = new RoomCompatDelegate(r7);
        r5.put("data_vs_compat_room", r8);
        return r8;
    L18:
        Episode r1 = (Episode) r5.get("data_vs_episode_data", null);
        if (r1 != null) goto L21;
        return r2;
    L21:
        if ((!Intrinsics.areEqual(r2, r1)) == false) goto L27;
        EpisodeCompatDelegate r9 = new EpisodeCompatDelegate(r1);
        r5.put("data_vs_compat_room", r9);
        return r9;
    L27:
        return r2;
    }

    public static final String d(DataCenter r5, Long r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$getRoomUniqueKey");
        long r0 = o(r5).id;
        if (r0 <= 0) goto L7;
        r6 = Long.valueOf(r0);
    L7:
        if (((Boolean) r5.get("data_current_is_preview", Boolean.FALSE)).booleanValue() == false) goto L9;
        Integer r7 = (Integer) r5.get("data_current_unique_id_preview", 0);
    L10:
        StringBuilder r1 = new StringBuilder();
        r1.append(r6);
        r1.append('_');
        r1.append(r7);
        return r1.toString();
    L9:
        r7 = (Integer) r5.get("room_controller_unique_key", 0);
        goto L10
    }

    public static final boolean e(DataCenter r1, boolean r2) {
        if (r1 == null) goto L6;
        Boolean r3 = (Boolean) r1.get("data_is_anchor", Boolean.valueOf(r2));
        if (r3 == null) goto L6;
        return r3.booleanValue();
    L6:
        return false;
    }

    public static final boolean m(DataCenter r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$isPortrait");
        return ((Boolean) r1.get("data_is_portrait", Boolean.valueOf(r2))).booleanValue();
    }

    public static final Room a(DataCenter r8, IBaseStreamUrl r9, Long r11) {
        Object r0 = null;
        if (r8 == null) goto L5;
        Room r12 = o(r8);
    L6:
        Room r1 = new Room();
        if (r12 == null) goto L37;
        if (r9 != null) goto L10;
        EpisodeExtraInfo r13 = r12.getEpisodeComponentData();
        if (r13 == null) goto L35;
        List r14 = r13.getCameraInfos();
        if (r14 == null) goto L35;
        Iterator r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L29;
        Object r2 = r15.next();
        long r3 = ((IVSCameraInfo) r2).getCameraId();
        if (r11 != null) goto L24;
    L26:
        boolean r4 = false;
    L27:
        if (r4 == false) goto L19;
        r0 = r2;
        goto L29
    L24:
        if (r3 != r11.longValue()) goto L26;
        r4 = true;
    L29:
        IVSCameraInfo r5 = (IVSCameraInfo) r0;
        if (r5 == null) goto L35;
        IBaseStreamUrl r16 = r5.getStreamUrl();
        if (r16 == null) goto L35;
        StreamUrl r17 = (StreamUrl) com.bytedance.android.live.base.model.m.b(r16, StreamUrl.class);
        if (r17 == null) goto L35;
    L36:
        r1.setStreamUrl(r17);
        r1.setPlatform(r12.getPlatform());
        r1.clientVersion = r12.clientVersion;
        r1.id = r12.id;
        r1.setOwnerUserIdString(r12.getOwnerUserIdString());
    L35:
        r17 = r12.getStreamUrl();
        goto L36
    L10:
        if ((r9 instanceof StreamUrl) == true) goto L12;
        r9 = null;
    L12:
        r17 = (StreamUrl) r9;
    L37:
        return r1;
    L5:
        r12 = null;
        goto L6
    }
}
