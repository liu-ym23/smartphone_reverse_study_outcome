package com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import uf2.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ILiveWrappedVideoSink {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ x b;

    public final void a(fg2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "frame");
        int r0 = (((r5.width() + 8) - 1) / 8) * 8;
        int r1 = (((r5.height() + 4) - 1) / 4) * 4;
        ByteBuffer r2 = ByteBuffer.allocateDirect((r0 * r1) + ((((r0 + 1) / 2) * ((r1 + 1) / 2)) * 2));
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r3 = ILiveWrappedLivePusher.a.b();
        if (r3 == null) goto L5;
        r3.getYuvHelper();
    L5:
        r2.position(0);
        if (this.a == false) goto L11;
        x r4 = this.b;
        if (r4 == null) goto L12;
        r5.timestampUs();
        r4.n();
        return;
    L12:
        return;
    }

    public c(boolean r1, x r2) {
        this.a = r1;
        this.b = r2;
    }
}
