package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class ByteOutput {
    public ByteOutput() {
    }

    public abstract void write(byte r8);

    public abstract void write(ByteBuffer r8);

    public abstract void write(byte[] r8, int r10, int r11);

    public abstract void writeLazy(ByteBuffer r8);

    public abstract void writeLazy(byte[] r8, int r10, int r11);
}
