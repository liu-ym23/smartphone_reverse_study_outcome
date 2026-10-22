package com.lynx.react.bridge.mapbuffer;

import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ReadableCompactArrayBuffer extends d implements com.lynx.react.bridge.mapbuffer.a {

    public class a implements Iterator<com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a> {
        public final c a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public final com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a next() {
            return (com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a) this.a.next();
        }

        public a(ReadableCompactArrayBuffer r2) {
            r2.getClass();
            this.a = new c(r2);
        }
    }

    @Override // com.lynx.react.bridge.mapbuffer.d
    public final int a(int r1) {
        return (r1 * 8) + 8;
    }

    @Override // java.lang.Iterable
    public final Iterator<com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a> iterator() {
        return new a(this);
    }

    public ReadableCompactArrayBuffer(ByteBuffer r2, int r3) {
        super(r2, r3, 0, 0);
    }

    public static ReadableCompactArrayBuffer fromByteBufferWithCount(byte[] r1, int r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new ReadableCompactArrayBuffer(ByteBuffer.wrap(r1), r2);
    }
}
