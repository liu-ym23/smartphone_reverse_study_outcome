package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.eventbus.VSCameraChangeEvent;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x4 extends dq1.e {
    public x4() {
    }

    @Override // dq1.e
    public final void a(VSCameraInfo r9, VSCameraInfo r10, Bundle r11, boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "targetCamera");
        int r0 = a5.a;
        if (r9 == null) goto L7;
        VSJumpCameraEvent.Companion r1 = VSJumpCameraEvent.Companion;
        VSJumpCameraEvent r14 = VSJumpCameraEvent.Companion.createEvent$default(r1, r9, null, false, null, 14, null);
        VSJumpCameraEvent r15 = r1.createEvent(r10, r11, r12, r13);
        xs2.b.a().post(new VSCameraChangeEvent(r14, r15));
        return;
    }
}
