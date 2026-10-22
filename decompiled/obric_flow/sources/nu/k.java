package nu;

import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public interface k extends a0, WritableByteChannel {
    k B(long r5);

    k F(ByteString r5);

    long G(c0 r5);

    @Override // nu.a0, java.io.Flushable
    void flush();

    j h();

    k i();

    k j(long r5);

    k k();

    k l(String r5);

    k t(long r5);

    k write(byte[] r5);

    k write(byte[] r5, int r10, int r11);

    k writeByte(int r5);

    k writeInt(int r5);

    k writeShort(int r5);

    k x(int r5);
}
