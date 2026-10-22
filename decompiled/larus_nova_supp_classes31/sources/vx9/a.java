package vx9;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements io.opentelemetry.sdk.trace.d {

    /* JADX INFO: renamed from: vx9.a$a, reason: collision with other inner class name */
    public static final class C0083a {
        public static final AtomicLong a = null;

        static {
            a = new AtomicLong(Random.Default.nextInt(0, Integer.MAX_VALUE));
        }

        public static long a() {
            AtomicLong r0 = a;
            long r1 = r0.addAndGet(1);
            if (r1 < 2147483647L) goto L6;
            r0.set(Random.Default.nextInt(0, Integer.MAX_VALUE));
            return a();
        L6:
            return r1;
        }
    }

    public static final class b {
    }

    static {
    }

    public a() {
    }

    public final String generateSpanId() {
    L2:
        long r0 = URandomKt.nextULong(Random.Default);
        if (r0 == 0) goto L2;
        return StringsKt.padStart(UStringsKt.toString-JSWoG40(r0, 16), 16, '0');
    }

    public final String generateTraceId() {
        long r0 = ULong.constructor-impl(ULong.constructor-impl(Long.MAX_VALUE) | 1);
        String r2 = o.a.getDeviceId();     // Catch: Exception -> L5
    L7:
        int r4 = 0;
        if (r2.length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        r2 = String.valueOf(System.currentTimeMillis());
    L13:
        byte[] r5 = MessageDigest.getInstance("SHA-256").digest(r2.getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r5);
        int r6 = r5.length;
        int r7 = 0;
    L14:
        if (r4 >= r6) goto L16;
        r7 = ((r7 + r5[r4]) & 255) << 5;
        r4 = r4 + 1;
        goto L14
    L16:
        String r8 = StringsKt.padStart(UStringsKt.toString-JSWoG40(ULong.constructor-impl(ULong.constructor-impl((((long) r7) << 32) + C0083a.a()) & r0), 16), 16, '0');
    L17:
        long r9 = URandomKt.nextULong(Random.Default);
        if (r9 == 0) goto L17;
        return r8 + StringsKt.padStart(UStringsKt.toString-JSWoG40(ULong.constructor-impl(r0 & r9), 16), 16, '0');
    L10:
        r3 = false;
    L5:
        e = move-exception;
        FLogger.a.e("IdsGenerator", "getDeviceId failed:" + e);
        r2 = "";
        goto L7
    }
}
