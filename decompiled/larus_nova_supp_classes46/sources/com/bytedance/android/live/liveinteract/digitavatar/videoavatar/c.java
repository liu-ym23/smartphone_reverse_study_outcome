package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final VideoShowMode a;

    public c() {
        this(VideoShowMode.AUDIO, null);
    }

    public c(VideoShowMode r1, b r2) {
        Intrinsics.checkNotNullParameter(r1, "showMode");
        this.a = r1;
    }
}
