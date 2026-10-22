package com.lynx.canvas.capi;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BitmapDecodeResult {
    private final ByteBuffer mBuffer;
    private final int mHeight;
    private final int mWidth;

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public BitmapDecodeResult(ByteBuffer r1, int r2, int r3) {
        this.mBuffer = r1;
        this.mWidth = r2;
        this.mHeight = r3;
    }
}
