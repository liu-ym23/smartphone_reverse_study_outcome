package sia;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static String a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        BluetoothDevice r2 = b(r1);
        if (r2 == null) goto L11;
        String r3 = r2.getName();
        if (r3 == null) goto L11;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L11;
        if ((!StringsKt.isBlank(r4)) == false) goto L11;
        return r4;
    L11:
        return null;
    }

    public static BluetoothDevice b(Context r6) {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.isEnabled() == true) goto L8;
        return null;
    L8:
        CountDownLatch r2 = new CountDownLatch(1);
        BluetoothDevice[] r4 = new BluetoothDevice[1];
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
        Object r7 = Result.constructor-impl(Boolean.valueOf(r0.getProfileProxy(r6.getApplicationContext(), new a(r2, r4, r0), 1)));     // Catch: Throwable -> L11
    L13:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L17;
        r7 = r1;
    L17:
        if (((Boolean) r7).booleanValue() == true) goto L25;
        return null;
    L25:
        Result.constructor-impl(Boolean.valueOf(r2.await(500, TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L21
    L24:
        return r4[0];
    L21:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static String c(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        BluetoothDevice r12 = b(r11);
        if (r12 == null) goto L19;
        String r13 = r12.getAddress();
        if (r13 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r13)) == true) goto L10;
        r13 = null;
    L10:
        if (r13 != null) goto L12;
        return null;
    L12:
        if (StringsKt.isBlank(r13) == true) goto L22;
        byte[] r2 = MessageDigest.getInstance("SHA-256").digest(r13.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L16
        return ArraysKt.joinToString$default(r2, "", null, null, 0, null, new a(), 30, null);
    L23:
        return null;
    L22:
        return null;
    L19:
        return null;
    }
}
