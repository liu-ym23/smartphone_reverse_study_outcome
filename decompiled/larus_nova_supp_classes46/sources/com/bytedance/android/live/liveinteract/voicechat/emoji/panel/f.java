package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarAuditStatus;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[VideoShowMode.values().length];
        a = r0;
        VideoShowMode r1 = VideoShowMode.AUDIO;
        r0[r1.ordinal()] = 1;
        VideoShowMode r2 = VideoShowMode.VIDEO;
        r0[r2.ordinal()] = 2;
        VideoShowMode r4 = VideoShowMode.DIGIT_AVATAR;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[VideoShowMode.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        int[] r5 = new int[DigitAvatarAuditStatus.values().length];
        c = r5;
        r5[DigitAvatarAuditStatus.NOT_PASS.ordinal()] = 1;
        r5[DigitAvatarAuditStatus.PASS.ordinal()] = 2;
        r5[DigitAvatarAuditStatus.AUDITING.ordinal()] = 3;
    }
}
