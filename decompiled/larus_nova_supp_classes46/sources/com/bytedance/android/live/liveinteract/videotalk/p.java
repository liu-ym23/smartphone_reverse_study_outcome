package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class p {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[MediaOperation.Type.values().length];
        a = r0;
        r0[MediaOperation.Type.CAMERA.ordinal()] = 1;
        r0[MediaOperation.Type.MIC.ordinal()] = 2;
        int[] r1 = new int[MediaOperation.Action.values().length];
        MediaOperation.Action r2 = MediaOperation.Action.OPEN;
        r1[r2.ordinal()] = 1;
        MediaOperation.Action r4 = MediaOperation.Action.CLOSE;
        r1[r4.ordinal()] = 2;
        int[] r3 = new int[MediaOperation.Action.values().length];
        r3[r2.ordinal()] = 1;
        r3[r4.ordinal()] = 2;
        int[] r5 = new int[VideoShowMode.values().length];
        b = r5;
        r5[VideoShowMode.VIDEO.ordinal()] = 1;
        r5[VideoShowMode.AUDIO.ordinal()] = 2;
        r5[VideoShowMode.DIGIT_AVATAR.ordinal()] = 3;
    }
}
