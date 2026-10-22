package wda;

import android.bluetooth.BluetoothDevice;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tha.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    static {
    }

    public static String a() {
        IBluetoothHeadSetAPI r0 = c.a();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
        return null;
    L11:
        IBluetoothHeadSetAPI r3 = c.a();
        if (r3 == null) goto L32;
        BluetoothDevice r4 = r3.g();
        if (r4 == null) goto L33;
        String r5 = r4.getAddress();
        if (r5 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r5)) == true) goto L21;
        r5 = null;
    L21:
        if (r5 != null) goto L23;
        return null;
    L23:
        if (r5.length() != 0) goto L25;
        r1 = true;
    L25:
        if (r1 == true) goto L36;
        byte[] r6 = MessageDigest.getInstance("SHA-256").digest(r5.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L29
        return ArraysKt.joinToString$default(r6, "", null, null, 0, null, new a(), 30, null);
    L37:
        return null;
    L36:
        return null;
    L33:
        return null;
    L32:
        return null;
    L5:
        if (r0.a() != true) goto L7;
        r2 = true;
        goto L9
    }
}
