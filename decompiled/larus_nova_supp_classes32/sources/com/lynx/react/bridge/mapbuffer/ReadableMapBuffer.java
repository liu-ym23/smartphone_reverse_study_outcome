package com.lynx.react.bridge.mapbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ReadableMapBuffer extends d implements MapBuffer {

    public class a implements Iterator<MapBuffer.a> {
        public final c a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public final MapBuffer.a next() {
            return (MapBuffer.a) this.a.next();
        }

        public a(ReadableMapBuffer r2) {
            r2.getClass();
            this.a = new c(r2);
        }
    }

    @Override // com.lynx.react.bridge.mapbuffer.d
    public final int a(int r1) {
        return (r1 * 12) + 8;
    }

    @Override // java.lang.Iterable
    public final Iterator<MapBuffer.a> iterator() {
        return new a(this);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final ReadableMapBuffer b(int r3) {
        return new ReadableMapBuffer(ByteBuffer.wrap(c(e(r3, MapBuffer.DataType.ARRAY))), -1);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final boolean contains(int r2) {
        if (d(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final int d(int r7) {
        int r0 = this.b - 1;
        int r2 = 0;
    L3:
        if (r2 > r0) goto L10;
        int r3 = (r2 + r0) >> 1;
        short r4 = this.a.getShort((r3 * 12) + 8);
        if (r4 < r7) goto L6;
        if (r4 <= r7) goto L9;
        r0 = r3 - 1;
        goto L3
    L9:
        return r3;
    L6:
        r2 = r3 + 1;
        goto L3
    L10:
        return -1;
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final boolean getBoolean(int r2) {
        int r3 = e(r2, MapBuffer.DataType.BOOL);
        if (this.a.getInt(r3) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final double getDouble(int r3) {
        int r4 = e(r3, MapBuffer.DataType.DOUBLE);
        return this.a.getDouble(r4);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final int getInt(int r2) {
        int r3 = e(r2, MapBuffer.DataType.INT);
        return this.a.getInt(r3);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final long getLong(int r3) {
        int r4 = e(r3, MapBuffer.DataType.LONG);
        return this.a.getLong(r4);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final String getString(int r3) {
        return new String(c(e(r3, MapBuffer.DataType.STRING)), Charset.defaultCharset());
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public MapBuffer.DataType getType(int r2) {
        int r3 = ((d(r2) * 12) + 8) + 2;
        short r4 = this.a.getShort(r3);
        return MapBuffer.DataType.values()[r4];
    }

    public ReadableMapBuffer(ByteBuffer r3, int r4) {
        super(r3, r4, 2, 4);
    }

    public static ReadableMapBuffer fromByteBufferWithCount(byte[] r1, int r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new ReadableMapBuffer(ByteBuffer.wrap(r1), r2);
    }

    public final int e(int r5, MapBuffer.DataType r6) {
        int r0 = d(r5);
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        int r1 = (r0 * 12) + 8;
        MapBuffer.DataType r2 = MapBuffer.DataType.values()[this.a.getShort(r1 + 2)];
        if (r2 != r6) goto L10;
        return r1 + 4;
    L10:
        throw new RuntimeException("Expected " + r6 + " for key: " + r5 + ", found " + r2 + " instead.");
    }
}
