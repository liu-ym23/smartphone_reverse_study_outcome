package com.bytedance.android.livesdk.gift.platform.business.tray2.viewModel;

import com.bytedance.android.live.gift.tray.TrayMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[TrayMode.values().length];
        a = r0;
        r0[TrayMode.IDLE.ordinal()] = 1;
        r0[TrayMode.AUDIO_GIFT.ordinal()] = 2;
        r0[TrayMode.MULTI_PK.ordinal()] = 3;
        r0[TrayMode.PK.ordinal()] = 4;
        r0[TrayMode.EQUAL_VIDEO_TALK.ordinal()] = 5;
        r0[TrayMode.VIDEO_CHORUS.ordinal()] = 6;
        r0[TrayMode.PLATFORM.ordinal()] = 7;
        r0[TrayMode.GAME.ordinal()] = 8;
        r0[TrayMode.MEDIA.ordinal()] = 9;
        r0[TrayMode.VS_BAR.ordinal()] = 10;
    }
}
