package nu;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public interface l extends c0, ReadableByteChannel {
    String A(Charset r5);

    ByteString C();

    int D(u r5);

    int E();

    long H();

    InputStream I();

    void a(j r5, long r10);

    String c(long r5);

    j h();

    String o();

    x peek();

    long r();

    byte readByte();

    void readFully(byte[] r5);

    int readInt();

    long readLong();

    short readShort();

    boolean request(long r5);

    void s(long r5);

    void skip(long r5);

    String u(long r5);

    ByteString v(long r5);

    byte[] w();

    boolean y();

    long z(j r5);
}
