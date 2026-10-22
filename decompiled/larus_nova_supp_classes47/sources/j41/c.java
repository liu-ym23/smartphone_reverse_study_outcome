package j41;

import android.graphics.Bitmap;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import fr2.e0;
import io.reactivex.disposables.CompositeDisposable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final CompositeDisposable a;
    public final i b;

    public c(i r1) {
        this.b = r1;
        this.a = new CompositeDisposable();
    }

    public static final void a(c r19, Bitmap r20, e0 r22) {
        r19.getClass();
        int[] r1 = new int[r20.getWidth() * r20.getHeight()];
        r20.getPixels(r1, 0, r20.getWidth(), 0, 0, r20.getWidth(), r20.getHeight());
        int r2 = r20.getWidth();
        int r3 = r20.getHeight();
        int r4 = r2 * r3;
        int r5 = (r4 * 3) / 2;
        byte[] r6 = new byte[r5];
        int r7 = (r4 * 5) / 4;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r12 = 0;
    L3:
        if (r9 >= r3) goto L29;
        int r13 = 0;
    L5:
        if (r13 >= r2) goto L28;
        int r14 = r1[r12];
        int r15 = (16711680 & r14) >> 16;
        int r16 = (65280 & r14) >> 8;
        int[] r17 = r1;
        int r18 = (r14 & 255) >> r8;
        int r23 = (((((r15 * 66) + (r16 * 129)) + (r18 * 25)) + 128) >> 8) + 16;
        int r24 = (((((r15 * (-38)) - (r16 * 74)) + (r18 * 112)) + 128) >> 8) + 128;
        int r110 = (((((r15 * 112) - (r16 * 94)) - (r18 * 18)) + 128) >> 8) + 128;
        int r111 = r10 + 1;
        if (r23 >= 0) goto L10;
        r23 = 0;
    L12:
        r6[r10] = (byte) r23;
        if ((r9 % 2) != 0) goto L27;
        if ((r12 % 2) != 0) goto L27;
        int r25 = r7 + 1;
        if (r110 >= 0) goto L19;
        r110 = 0;
    L21:
        r6[r7] = (byte) r110;
        int r26 = r4 + 1;
        if (r24 >= 0) goto L24;
        r24 = 0;
    L26:
        r6[r4] = (byte) r24;
        r4 = r26;
        r7 = r25;
        goto L27
    L24:
        if (r24 <= 255) goto L26;
        r24 = 255;
        goto L26
    L19:
        if (r110 <= 255) goto L21;
        r110 = 255;
    L27:
        r12 = r12 + 1;
        r13 = r13 + 1;
        r10 = r111;
        r1 = r17;
        r8 = 0;
        goto L5
    L10:
        if (r23 <= 255) goto L12;
        r23 = 255;
        goto L12
    L28:
        r9 = r9 + 1;
        r8 = 0;
        goto L3
    L29:
        ByteBuffer r27 = ByteBuffer.allocateDirect(r5);
        if (r27 == null) goto L32;
        r27.put(r6);
    L32:
        if (r27 == null) goto L34;
        r27.position(0);
    L34:
        if (r22 == null) goto L47;
        i r28 = r19.b;
        if (r28 == null) goto L38;
        String r29 = String.valueOf(r20.hashCode());
        vc0.a r30 = vc0.b.a(r22);
        i97.a r32 = i97.a.a;
        r28.S1(r29, r30, System.currentTimeMillis() * ((long) WebcastRedirectException.UNKNOWN));
    L38:
        i r0 = r19.b;
        if (r0 == null) goto L48;
        r0.o();
        return;
    L48:
        return;
    }
}
