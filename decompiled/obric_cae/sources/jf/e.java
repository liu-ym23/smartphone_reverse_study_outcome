package jf;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends v, WritableByteChannel {
    e N(long r8);

    e T(int r8);

    long X(w r8);

    d b();

    e d0(long r8);

    e f();

    @Override // jf.v, java.io.Flushable
    void flush();

    e h(long r8);

    e l0(int r8, int r10, byte[] r11);

    OutputStream n0();

    e p(String r8);

    e s(g r8);

    e write(byte[] r8);

    e writeByte(int r8);

    e writeInt(int r8);

    e writeShort(int r8);
}
