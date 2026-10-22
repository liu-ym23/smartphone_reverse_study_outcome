package dx8;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.share.panel.ShareType;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    static {
    }

    public static String a(PolarisFileWrapper r9) {
        Intrinsics.checkNotNullParameter(r9, ShareType.FILE);
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L15
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(r9);     // Catch: Throwable -> L15
        byte[] r10 = new byte[8192];     // Catch: Throwable -> L15
    L17:
        int r2 = r1.read(r10);     // Catch: Throwable -> L12
        if (r2 <= 0) goto L7;
        r0.update(r10, 0, r2);     // Catch: Throwable -> L12
        goto L17
    L7:
        byte[] r11 = r0.digest();     // Catch: Throwable -> L12
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L12
        int r4 = r11.length;     // Catch: Throwable -> L12
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L10;
        byte r6 = r11[r5];     // Catch: Throwable -> L12
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L12
        r3.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r6)}, 1)));     // Catch: Throwable -> L12
        r5 = r5 + 1;     // Catch: Throwable -> L12
        goto L8
    L10:
        String r12 = r3.toString();     // Catch: Throwable -> L12
        r1.close();     // Catch: Throwable -> L15
        return r12;
    L12:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        return null;
    }
}
