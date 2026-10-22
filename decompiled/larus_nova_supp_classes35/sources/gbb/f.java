package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    static {
    }

    public static String a(byte[] r7) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        byte r4 = r7[r3];
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r0.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r4)}, 1)));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    @JvmStatic
    public static final String b(PolarisFileWrapper r3) {
        Intrinsics.checkNotNullParameter(r3, "file");
        PolarisFileInputStreamWrapper r0 = null;
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(r3);     // Catch: Throwable -> L12 Exception -> L14
        byte[] r4 = new byte[8];     // Catch: Throwable -> L8 Exception -> L10
        r1.read(r4);     // Catch: Throwable -> L8 Exception -> L10
        String r5 = a(r4);     // Catch: Throwable -> L8 Exception -> L10
        r1.close();
        return r5;
    L10:
        e = e;
        r0 = r1;
    L15:
        Log.e("Diskcache", "read file header failed", e);     // Catch: Throwable -> L12
        if (r0 == null) goto L29;
        r0.close();
        return BuildConfig.FLAVOR;
    L29:
        return BuildConfig.FLAVOR;
    L8:
        th = th;
    L21:
        if (r1 == null) goto L23;
        r1.close();
    L23:
        throw th;
    L14:
        e = e;
    L12:
        th = th;
        r1 = r0;
        goto L21
    }
}
