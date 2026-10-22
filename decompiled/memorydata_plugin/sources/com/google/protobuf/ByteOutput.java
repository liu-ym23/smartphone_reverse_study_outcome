package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteOutput {
    public ByteOutput() {
    }

    public abstract void write(byte r1);

    public abstract void write(ByteBuffer r1);

    public abstract void write(byte[] r1, int r2, int r3);

    public abstract void writeLazy(ByteBuffer r1);

    public abstract void writeLazy(byte[] r1, int r2, int r3);
}
