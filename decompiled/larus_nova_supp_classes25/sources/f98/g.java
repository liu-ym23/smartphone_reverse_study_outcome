package f98;

import android.util.Base64;
import com.larus.avlink.e.DoraImageManager;
import com.larus.avlink.e.model.VisionIntentionSource;
import com.larus.utils.l0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final int a(Integer r2) {
        com.larus.avlink.e.l r0 = com.larus.avlink.e.l.a;
        if (com.larus.avlink.e.l.c() == true) goto L17;
        if (r2 != null) goto L8;
    L10:
        if (r2 == null) goto L16;
        if (r2.intValue() != 7) goto L16;
        return VisionIntentionSource.LLM.getValue();
    L16:
        return VisionIntentionSource.UNKNOWN.getValue();
    L8:
        if (r2.intValue() != 1) goto L10;
        return VisionIntentionSource.ASR.getValue();
    L17:
        return VisionIntentionSource.UNKNOWN.getValue();
    }

    public static l b(final b49.h r9, final int r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        byte[] r0 = r9.b;
        if (r0 == null) goto L24;
        l r2 = new l();
        boolean r3 = true;
        r2.f(1);
        int r4 = 0;
        r2.g(Base64.encodeToString(r0, 0));
        r2.q(Integer.valueOf(r9.c));
        r2.k(Integer.valueOf(r9.d));
        if (r9.f != 1) goto L8;
        int r5 = 1;
    L9:
        r2.o(r5);
        r2.n(Long.valueOf(System.currentTimeMillis() / ((long) 1000)));
        if (r9.c <= 1080) goto L12;
        boolean r6 = true;
    L13:
        r2.l(r6);
        r2.m(String.valueOf(r9.a));
        r2.p(r0.length);
        r2.h((String) l0.a(null, new f(r9, r10)));
        r2.i(0);
        Map<String, com.larus.avlink.model.a> r11 = DoraImageManager.a;
        com.larus.avlink.model.a r12 = DoraImageManager.a(Integer.valueOf(r9.a));
        if (r12 != null) goto L16;
    L18:
        r3 = false;
    L19:
        r2.j(r3);
        com.larus.avlink.model.a r13 = DoraImageManager.a(Integer.valueOf(r9.a));
        if (r13 == null) goto L22;
        r4 = r13.L;
    L22:
        r2.e(r4);
        return r2;
    L16:
        if (r12.p != true) goto L18;
    L12:
        r6 = false;
        goto L13
    L8:
        r5 = 2;
        goto L9
    L24:
        return null;
    }
}
