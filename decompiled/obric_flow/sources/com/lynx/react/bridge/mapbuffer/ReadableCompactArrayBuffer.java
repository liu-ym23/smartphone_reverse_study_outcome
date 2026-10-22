package com.lynx.react.bridge.mapbuffer;

import androidx.annotation.AnyThread;
import com.lynx.tasm.base.CalledByNative;
import java.nio.ByteBuffer;
import java.util.Iterator;
import qm.d;
import qm.e;

/* JADX INFO: loaded from: classes2.dex */
@AnyThread
public class ReadableCompactArrayBuffer extends d implements Iterable {
    @CalledByNative
    public static ReadableCompactArrayBuffer fromByteBufferWithCount(byte[] r5, int r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new ReadableCompactArrayBuffer(ByteBuffer.wrap(r5), r10, 0);
    }

    @Override // qm.d
    public final int b(int r5) {
        return (r5 * 8) + 8;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this);
    }
}
