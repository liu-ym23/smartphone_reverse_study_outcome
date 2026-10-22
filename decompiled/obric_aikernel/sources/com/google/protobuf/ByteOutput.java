package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ByteOutput {
    public ByteOutput() {
    }

    public abstract void write(byte r10);

    public abstract void write(ByteBuffer r10);

    public abstract void write(byte[] r10, int r11, int r12);

    public abstract void writeLazy(ByteBuffer r10);

    public abstract void writeLazy(byte[] r10, int r11, int r12);
}
