package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends d0, WritableByteChannel {
    e O(ByteString r10);

    e W(long r10);

    OutputStream Y();

    d b();

    @Override // okio.d0, java.io.Flushable
    void flush();

    e h();

    e j(long r10);

    e m(int r10);

    e t(String r10);

    e write(byte[] r10);

    e write(byte[] r10, int r11, int r12);

    e writeByte(int r10);

    e writeInt(int r10);

    e writeShort(int r10);

    long y(f0 r10);

    e z(long r10);
}
