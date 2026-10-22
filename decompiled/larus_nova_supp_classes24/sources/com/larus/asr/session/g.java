package com.larus.asr.session;

import com.larus.asr.ChatBottomSpeakerComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public final p a;
    public volatile ComponentAsrSession b;

    public g(ChatBottomSpeakerComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        this.a = r2;
    }
}
