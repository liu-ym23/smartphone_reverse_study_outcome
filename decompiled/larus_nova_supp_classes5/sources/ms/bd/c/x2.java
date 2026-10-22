package ms.bd.c;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import f06.b;
import f06.c;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class x2 {
    public final Context a;

    public final String a() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 <= 28) goto L18;
        ContentProviderClient r1 = b(this.a.getContentResolver(), UriProtector.parse((String) p2.a(16777217, 0, 0, "a78c74", new byte[]{115, 58, 69, 3, 13, 45, 118, 76, 38, 124, 115, 59, 5, 25, 29, 33, 107, 23, 39, 58, 116, 48, 69, 3, 1, 55, 123, 89, 96, 55, 117, 59, 95, 30, 28, 58})));     // Catch: Exception -> L19
        Bundle r4 = r1.call((String) p2.a(16777217, 0, 0, "6fdea0", new byte[]{32, 97, 3, 62, ByteCompanionObject.MAX_VALUE, 14, 17}), null, null);     // Catch: Exception -> L19
        if (r0 < 24) goto L8;
        r1.close();     // Catch: Exception -> L19
    L9:
        if (r4 != null) goto L12;
        return null;
    L12:
        if (r4.getInt((String) p2.a(16777217, 0, 0, "e72224", new byte[]{119, 58, 69, 67}), -1) == 0) goto L14;
        r4.getString((String) p2.a(16777217, 0, 0, "48a911", new byte[]{40, 63, 1, 94, 15, 33, 50}));     // Catch: Exception -> L19
        goto L16
    L14:
        return r4.getString((String) p2.a(16777217, 0, 0, "cda7ab", new byte[]{123, 98}));
    L8:
        r1.release();     // Catch: Exception -> L19
    L16:
        return null;
    L18:
        return null;
    }

    public x2(Context r1) {
        this.a = r1;
    }

    public static ContentProviderClient b(ContentResolver r12, Uri r13) {
        c r8 = new c();
        Object[] r9 = {r13};
        b r10 = new b();
        f06.d r11 = r8.b(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, "android.content.ContentProviderClient", r10);
        if (r11.a == false) goto L6;
        r8.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, null, r10, false);
        return (ContentProviderClient) r11.b;
    L6:
        ContentProviderClient r14 = r12.acquireContentProviderClient(r13);
        r8.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, r14, r10, true);
        return r14;
    }
}
