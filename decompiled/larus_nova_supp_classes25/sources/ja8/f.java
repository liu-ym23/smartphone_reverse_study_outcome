package ja8;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final void a(PolarisFileInputStreamWrapper r11, String r12) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "in");
        Intrinsics.checkNotNullParameter(r12, "outputDir");
        PolarisFileWrapper r1 = new PolarisFileWrapper(r12);
        if (r1.exists() == true) goto L6;
        r1.mkdirs();
    L6:
        if (r11.available() <= 0) goto L41;
        byte[] r2 = new byte[3];
        if (r11.read(r2) != 3) goto L40;
        if (r2[0] != 16) goto L40;
        if (r2[1] != 13) goto L40;
        if (r2[2] != 10) goto L40;
        Intrinsics.checkNotNullParameter(r11, "in");
        int r3 = r11.read();
        int r4 = r11.read();
        if (r3 == (-1)) goto L38;
        if (r4 == (-1)) goto L38;
        byte[] r5 = new byte[(r3 << 8) | r4];
        r11.read(r5);
        String r6 = new String(r5, StandardCharsets.UTF_8);
        Intrinsics.checkNotNullParameter(r11, "in");
        int r7 = r11.read();
        int r8 = r11.read();
        int r9 = r11.read();
        int r10 = r11.read();
        if ((((r7 | r8) | r9) | r10) < 0) goto L36;
        int r13 = (((r7 << 24) | (r8 << 16)) | (r9 << 8)) | r10;
        PolarisFileOutputStreamWrapper r14 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r1, r6));
        byte[] r15 = new byte[262144];     // Catch: Throwable -> L29
    L22:
        if (r13 <= 0) goto L28;
        int r16 = r11.read(r15, 0, (int) Math.min(262144, r13));     // Catch: Throwable -> L29
        if (r16 == (-1)) goto L27;
        r14.write(r15, 0, r16);     // Catch: Throwable -> L29
        r13 = r13 - r16;     // Catch: Throwable -> L29
        goto L22
    L27:
        throw new EOFException("Unexpected end of stream. Expected " + r13 + " more bytes");     // Catch: Throwable -> L29
    L28:
        r14.close();
    L29:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L34
    L36:
        throw new EOFException("eof exception or read failed");
    L38:
        throw new EOFException("eof exception or read failed");
    L40:
        throw new IOException("invalid file");
    }
}
