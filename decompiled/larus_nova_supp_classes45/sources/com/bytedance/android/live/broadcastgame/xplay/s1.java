package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s1 implements com.bytedance.android.live.broadcastgame.api.xplay.g {
    public ByteBuffer a;
    public final IByteRtcVideoFrame b;

    public final String toString() {
        return "XplayVideoFrame(" + com.bytedance.android.live.broadcastgame.api.xplay.a.a(this.b) + ", yuvI420Buffer = " + this.a + ')';
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.g
    public final ByteBuffer a() {
        return this.a;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.g
    public final IByteRtcVideoFrame b() {
        return this.b;
    }

    public s1(IByteRtcVideoFrame r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcVideoFrame");
        this.b = r2;
    }
}
