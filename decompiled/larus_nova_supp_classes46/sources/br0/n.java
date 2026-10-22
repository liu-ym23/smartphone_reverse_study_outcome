package br0;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame.LiveMgXplayRtcContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends lr0.a {
    public final LiveMgXplayRtcContextService b;
    public final MiniGameContext c;

    public n(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
        this.c = r2;
        this.b = (LiveMgXplayRtcContextService) this.c.getService(LiveMgXplayRtcContextService.class);
    }

    public final Bundle onEvent(Bundle r7) {
        if (r7 == null) goto L11;
        byte[] r0 = r7.getByteArray("buffer");
        if (r0 == null) goto L12;
        int r1 = r7.getInt("bufferOffset");
        int r2 = r7.getInt("samples");
        int r3 = r7.getInt("sampleRate");
        int r8 = r7.getInt("channel");
        if (v.a() == false) goto L8;
        this.b.getClass();
        ALogger.d("OnLiveXplayAudioFrameEventListener", "buffer = " + r0[99] + ", samples = " + r2 + ", sampleRate = " + r3 + ", channels = " + r8 + ", renderSink = null");
    L8:
        ByteBuffer r9 = ByteBuffer.allocateDirect(r0.length - r1);
        r9.put(r0, r1, r0.length - r1);
        r9.flip();
        this.b.getClass();
        return null;
    L12:
        return null;
    L11:
        return null;
    }
}
