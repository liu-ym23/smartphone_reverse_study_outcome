package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public interface f extends f0, ReadableByteChannel {
    String E();

    int H();

    byte[] L(long r10);

    short R();

    long T();

    void U(long r10);

    long Z();

    d b();

    int b0(w r10);

    InputStream d();

    String e(long r10);

    ByteString g(long r10);

    boolean n();

    String q(long r10);

    byte readByte();

    int readInt();

    short readShort();

    void skip(long r10);

    String w(Charset r10);
}
