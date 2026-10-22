package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 implements ILiveWrappedVideoSink {
    public final /* synthetic */ RtcManager a;
    public final /* synthetic */ boolean b;

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
        if (this.b == false) goto L11;
        uf2.x r4 = this.a.G;
        if (r4 == null) goto L12;
        r5.timestampUs();
        r4.n();
        return;
    L12:
        return;
    }

    public j0(RtcManager r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
