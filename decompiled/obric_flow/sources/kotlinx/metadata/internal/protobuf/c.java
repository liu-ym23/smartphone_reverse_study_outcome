package kotlinx.metadata.internal.protobuf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f19147a = null;

    static {
        f19147a = i.f19174b;
    }

    public static void b(z r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isInitialized() == false) goto L6;
        return;
    L6:
        if ((r5 instanceof b) == false) goto L8;
        UninitializedMessageException r10 = ((b) r5).newUninitializedMessageException();
    L10:
        throw r10.asInvalidProtocolBufferException().setUnfinishedMessage(r5);
    L8:
        r10 = new UninitializedMessageException(r5);
        goto L10
    }

    public final z c(InputStream r10, i r11) {
        int r5 = r10.read();     // Catch: IOException -> L37
        if (r5 != (-1)) goto L6;
        z r12 = null;
    L27:
        b(r12);
        return r12;
    L6:
        if ((r5 & 128) == 0) goto L25;
        r5 = r5 & 127;     // Catch: IOException -> L37
        int r13 = 7;
    L10:
        if (r13 >= 32) goto L20;
        int r14 = r10.read();     // Catch: IOException -> L37
        if (r14 == (-1)) goto L18;
        r5 = r5 | ((r14 & 127) << r13);     // Catch: IOException -> L37
        if ((r14 & 128) == 0) goto L25;
        r13 = r13 + 7;     // Catch: IOException -> L37
        goto L10
    L18:
        throw InvalidProtocolBufferException.truncatedMessage();     // Catch: IOException -> L37
    L20:
        if (r13 >= 64) goto L36;
        int r15 = r10.read();     // Catch: IOException -> L37
        if (r15 == (-1)) goto L34;
        if ((r15 & 128) == 0) goto L25;
        r13 = r13 + 7;
        goto L20
    L34:
        throw InvalidProtocolBufferException.truncatedMessage();     // Catch: IOException -> L37
    L36:
        throw InvalidProtocolBufferException.malformedVarint();     // Catch: IOException -> L37
    L25:
        f r16 = new f(new a(r10, r5));
        r12 = (z) a(r16, r11);
        r16.a(0);     // Catch: InvalidProtocolBufferException -> L29
    L29:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    L37:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage());
    }

    public final z d(InputStream r5, i r10) {
        f r11 = new f(r5);
        z r12 = (z) a(r11, r10);
        r11.a(0);     // Catch: InvalidProtocolBufferException -> L6
        b(r12);
        return r12;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }

    public final z e(e r5, i r10) {
        f r11 = r5.j();
        z r12 = (z) a(r11, r10);
        r11.a(0);     // Catch: InvalidProtocolBufferException -> L6
        b(r12);
        return r12;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }

    public final z f(f r5, i r10) {
        z r11 = (z) a(r5, r10);
        b(r11);
        return r11;
    }

    public final z g(byte[] r5, i r10) {
        int r11 = r5.length;
        f r12 = new f(r5, r11);
        r12.d(r11);     // Catch: InvalidProtocolBufferException -> L11
        z r13 = (z) a(r12, r10);
        r12.a(0);     // Catch: InvalidProtocolBufferException -> L8
        b(r13);
        return r13;
    L8:
        e = move-exception;
        throw e.setUnfinishedMessage(r13);
    L11:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
