package jf;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface f extends w, ReadableByteChannel {
    long F();

    void L(long r8);

    String P(long r8);

    g Q(long r8);

    boolean U();

    @Deprecated
    d b();

    String b0(Charset r8);

    void d(d r8, long r10);

    int i0();

    boolean j(g r8);

    String l(long r8);

    long o0();

    InputStream p0();

    byte readByte();

    void readFully(byte[] r8);

    int readInt();

    long readLong();

    short readShort();

    void skip(long r8);

    String y();
}
