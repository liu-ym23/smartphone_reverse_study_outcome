package com.lynx.react.bridge.mapbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class d {
    public final ByteBuffer a;
    public int b;
    public final int c;
    public final int d;
    public int e;

    public class a implements MapBuffer.a {
        public final int a;
        public final /* synthetic */ d b;

        @Override // com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a
        public final int a() {
            d r0 = this.b;
            int r1 = this.a + r0.d;
            return r0.a.getInt(r1);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a, com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a
        public final double b() {
            d r0 = this.b;
            int r1 = this.a + r0.d;
            return r0.a.getDouble(r1);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a, com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a
        public final long c() {
            d r0 = this.b;
            int r1 = this.a + r0.d;
            return r0.a.getLong(r1);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a
        public final boolean e() {
            d r0 = this.b;
            int r1 = this.a + r0.d;
            if (r0.a.getInt(r1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a
        public final ReadableMapBuffer f() {
            d r0 = this.b;
            return new ReadableMapBuffer(ByteBuffer.wrap(r0.c(this.a + r0.d)), -1);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a
        public final int getKey() {
            d r0 = this.b;
            int r1 = this.a;
            return r0.a.getShort(r1);
        }

        @Override // com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a
        public final String getString() {
            d r0 = this.b;
            return new String(r0.c(this.a + r0.d), Charset.defaultCharset());
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a
        public MapBuffer.DataType getType() {
            MapBuffer.DataType[] r0 = MapBuffer.DataType.values();
            d r1 = this.b;
            int r2 = this.a + r1.c;
            return r0[r1.a.getShort(r2)];
        }

        public a(d r1, int r2) {
            this.b = r1;
            this.a = 0;
            this.a = r2;
        }
    }

    public abstract int a(int r1);

    public final int hashCode() {
        this.a.rewind();
        return this.a.hashCode();
    }

    public final int count() {
        return this.b;
    }

    public final byte[] c(int r4) {
        int r0 = this.e + this.a.getInt(r4);
        int r5 = this.a.getInt(r0);
        byte[] r1 = new byte[r5];
        ByteBuffer r2 = this.a;
        r2.position(r0 + 4);
        this.a.get(r1, 0, r5);
        return r1;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        d r6 = (d) r5;
        if (this.b == r6.b) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.a, r6.a) == false) goto L15;
        return true;
    }

    public d(ByteBuffer r2, int r3, int r4, int r5) {
        this.c = 0;
        this.d = 0;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        if (r2 == null) goto L9;
        r2.order(ByteOrder.nativeOrder());
        if (this.b != (-1)) goto L7;
        r2.position(2);
        this.b = r2.getShort(r2.position());
    L7:
        this.e = a(this.b);
        return;
    }
}
