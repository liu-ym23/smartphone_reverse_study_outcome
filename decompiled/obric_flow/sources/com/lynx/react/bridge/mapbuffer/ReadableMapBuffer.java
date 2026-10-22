package com.lynx.react.bridge.mapbuffer;

import androidx.annotation.AnyThread;
import com.lynx.tasm.base.CalledByNative;
import java.nio.ByteBuffer;
import java.util.Iterator;
import qm.d;
import qm.e;

/* JADX INFO: loaded from: classes2.dex */
@AnyThread
public class ReadableMapBuffer extends d implements Iterable {
    @CalledByNative
    public static ReadableMapBuffer fromByteBufferWithCount(byte[] r5, int r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new ReadableMapBuffer(ByteBuffer.wrap(r5), r10, 4);
    }

    @Override // qm.d
    public final int b(int r5) {
        return (r5 * 12) + 8;
    }

    public final int d(int r5, MapBuffer$DataType r10) {
        int r11 = e(r5);
        if (r11 != (-1)) goto L5;
        return -1;
    L5:
        int r12 = r11 * 12;
        MapBuffer$DataType r13 = MapBuffer$DataType.values()[this.f21527a.getShort(r12 + 10)];
        if (r13 != r10) goto L10;
        return r12 + 12;
    L10:
        throw new RuntimeException("Expected " + r10 + " for key: " + r5 + ", found " + r13 + " instead.");
    }

    public final int e(int r10) {
        int r5 = this.f21528b - 1;
        int r11 = 0;
    L3:
        if (r11 > r5) goto L10;
        int r12 = (r11 + r5) >> 1;
        short r13 = this.f21527a.getShort((r12 * 12) + 8);
        if (r13 < r10) goto L6;
        if (r13 <= r10) goto L9;
        r5 = r12 - 1;
        goto L3
    L9:
        return r12;
    L6:
        r11 = r12 + 1;
        goto L3
    L10:
        return -1;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this);
    }
}
