package com.larus.audio.audiov3.task.sami.v2.flow;

import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import g58.n;
import kotlin.jvm.internal.Intrinsics;
import r78.a;
import r78.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements SAMICoreCallBackListener {
    public final b a;

    public c(n r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    public final void onMessageReceived(SAMICoreCallBackEventType r6, SAMICoreBlock r7) {
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "data");
        this.a.a(r6.getValue(), new a(r7.dataType.getValue(), r7.numberAudioData, r7.audioData, r7.userContext));
    }
}
