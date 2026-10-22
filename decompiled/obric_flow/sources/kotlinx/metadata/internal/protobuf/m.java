package kotlinx.metadata.internal.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f19190a;

    public m() {
        this.f19190a = e.f19154a;
    }

    public abstract GeneratedMessageLite a();

    public abstract m b(f r5, i r10);

    public abstract m c(GeneratedMessageLite r5);

    public final m e(byte[] r5) {
        int r10 = r5.length;
        f r11 = new f(r5, r10);     // Catch: IOException -> L7 InvalidProtocolBufferException -> L9
        r11.d(r10);     // Catch: IOException -> L7 InvalidProtocolBufferException -> L11
        b(r11, i.f19174b);     // Catch: IOException -> L7 InvalidProtocolBufferException -> L9
        r11.a(0);     // Catch: IOException -> L7 InvalidProtocolBufferException -> L9
        return this;
    L11:
        e = move-exception;
        throw new IllegalArgumentException(e);     // Catch: IOException -> L7 InvalidProtocolBufferException -> L9
    L7:
        e = move-exception;
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
    L9:
        e = move-exception;
        throw e;
    }
}
