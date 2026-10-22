package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarAuditStatus;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    public final VideoShowMode[] a;
    public VideoShowMode b;
    public final DigitAvatarAuditStatus c;

    public m(VideoShowMode[] r2, VideoShowMode r3, DigitAvatarAuditStatus r4) {
        Intrinsics.checkNotNullParameter(r2, "supportModes");
        Intrinsics.checkNotNullParameter(r3, "selectMode");
        Intrinsics.checkNotNullParameter(r4, "auditStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
