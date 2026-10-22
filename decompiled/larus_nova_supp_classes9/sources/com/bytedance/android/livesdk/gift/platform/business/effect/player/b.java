package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import com.ss.ttm.player.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends AudioProcessor {
    public float a;

    public final void audioClose() {
    }

    public final void audioOpen(int r1, int r2, int r3, int r4) {
    }

    public final void audioRelease(int r1) {
    }

    public b() {
        this.a = 1.0f;
    }

    public final void audioProcess(ByteBuffer[] r6, int r7, long r8) {
        if (r6 != null) goto L4;
        return;
    L4:
        FloatBuffer[] r9 = new FloatBuffer[r6.length];
        int r0 = 0;
    L6:
        if (r0 >= r6.length) goto L14;
        ByteBuffer r1 = r6[r0];
        if (r1 == null) goto L13;
        r9[r0] = r1.order(ByteOrder.nativeOrder()).asFloatBuffer();
        int r2 = 0;
    L11:
        if (r2 >= r7) goto L13;
        float r3 = r9[r0].get(r2);
        r9[r0].put(r2, r3 * this.a);
        r2 = r2 + 1;
    L13:
        r0 = r0 + 1;
        goto L6
    }
}
