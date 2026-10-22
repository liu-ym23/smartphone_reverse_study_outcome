package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import com.bytedance.android.livesdk.log.ContentDurationLogger;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y4 extends dq1.e {
    public final /* synthetic */ com.bytedance.android.livesdk.log.j a;
    public final /* synthetic */ ContentDurationLogger b;

    public y4(com.bytedance.android.livesdk.log.j r1, ContentDurationLogger r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // dq1.e
    public final void b(VSCameraInfo r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "targetCamera");
        com.bytedance.android.livesdk.log.j r3 = this.a;
        if (r3 == null) goto L5;
        r3.f();
    L5:
        ContentDurationLogger r4 = this.b;
        if (r4 == null) goto L9;
        r4.a();
        return;
    }
}
