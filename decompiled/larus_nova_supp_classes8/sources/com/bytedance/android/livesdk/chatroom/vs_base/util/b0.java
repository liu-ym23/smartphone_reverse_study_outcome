package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 {
    public static final Boolean a = null;

    static {
        a = (Boolean) VSSettingKeys.LIVE_VS_USE_STREAM_ORIENTATION.getValue();
    }

    public static int a(IVSCameraInfo r3) {
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (a.booleanValue() == false) goto L23;
        IBaseStreamUrl r0 = r3.getStreamUrl();
        if (r0 != null) goto L10;
    L11:
        IBaseStreamUrl r1 = r3.getStreamUrl();
        if (r1 != null) goto L14;
    L16:
        IBaseStreamUrl r4 = r3.getStreamUrl();
        if (r4 == null) goto L19;
        Integer r5 = Integer.valueOf(r4.getStreamOrientation());
    L21:
        return c(r5);
    L19:
        r5 = null;
        goto L21
    L14:
        if (r1.getVrType() != 2) goto L16;
    L15:
        return 2;
    L10:
        if (r0.getVrType() == 1) goto L15;
    L23:
        return r3.getStyle();
    }

    public static int b(IRoom r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        Integer r4 = null;
        if (a.booleanValue() == false) goto L15;
        IBaseStreamUrl r0 = r6.getStreamUrl();
        if (r0 == null) goto L10;
        r4 = Integer.valueOf(r0.getStreamOrientation());
    L10:
        int r1 = c(r4);
        if (r6.getVRType() != 1) goto L13;
    L14:
        return 2;
    L13:
        if (r6.getVRType() == 2) goto L14;
        return r1;
    L15:
        IEpisodeExtraInfo r2 = r6.getEpisodeComponentData();
        if (r2 == null) goto L30;
        if (r2.getStyle() != 0) goto L30;
        IEpisodeExtraInfo r3 = r6.getEpisodeComponentData();
        if ((r3 instanceof EpisodeExtraInfo) == true) goto L22;
        r3 = null;
    L22:
        EpisodeExtraInfo r5 = (EpisodeExtraInfo) r3;
        if (r5 == null) goto L30;
        IBaseStreamUrl r7 = r6.getStreamUrl();
        if (r7 == null) goto L27;
        Integer r8 = Integer.valueOf(r7.getStreamOrientation());
    L28:
        r5.setStyle(c(r8));
        goto L30
    L27:
        r8 = null;
    L30:
        if (r6.getVRType() != 1) goto L32;
    L33:
        Integer r9 = r6.getEpisodeComponentData();
        if ((r9 instanceof EpisodeExtraInfo) == false) goto L37;
        r4 = r9;
    L37:
        EpisodeExtraInfo r10 = (EpisodeExtraInfo) r4;
        if (r10 == null) goto L40;
        r10.setStyle(2);
    L40:
        IEpisodeExtraInfo r11 = r6.getEpisodeComponentData();
        if (r11 != null) goto L43;
        return 0;
    L43:
        return r11.getStyle();
    L32:
        if (r6.getVRType() != 2) goto L40;
        goto L33
    }

    public static int c(Integer r3) {
        if (r3 != null) goto L6;
    L8:
        if (r3 != null) goto L11;
    L13:
        return 0;
    L11:
        if (r3.intValue() != 2) goto L13;
        return 1;
    L6:
        if (r3.intValue() != 1) goto L8;
        return 2;
    }
}
