package kta;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import f06.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class m implements o {
    public m() {
    }

    @Override // kta.o
    public final boolean a(Context r2) {
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kta.o
    public final o.a getOaid(Context r5) {
        Uri r0 = UriProtector.parse("content://cn.nubia.identity/identity");
        int r2 = Build.VERSION.SDK_INT;     // Catch: Exception -> L20
        ContentProviderClient r6 = b(r5.getContentResolver(), r0);     // Catch: Exception -> L20
        if (r6 != null) goto L6;
        return null;
    L6:
        Bundle r1 = r6.call("getOAID", null, null);     // Catch: Exception -> L20
        if (r2 < 24) goto L9;
        r6.close();     // Catch: Exception -> L20
    L10:
        if (r1 != null) goto L13;
        return null;
    L13:
        if (r1.getInt("code", -1) != 0) goto L16;
        o.a r7 = new o.a();     // Catch: Exception -> L20
        r7.a = r1.getString("id");     // Catch: Exception -> L20
        return r7;
    L16:
        String r8 = r1.getString("message");     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r8) == true) goto L19;
        ita.j.c(r8, null);     // Catch: Exception -> L20
    L19:
        return null;
    L9:
        r6.release();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static ContentProviderClient b(ContentResolver r12, Uri r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        f06.b r10 = new f06.b();
        d r11 = r8.b(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, "android.content.ContentProviderClient", r10);
        if (r11.a == false) goto L6;
        r8.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, null, r10, false);
        return (ContentProviderClient) r11.b;
    L6:
        ContentProviderClient r14 = r12.acquireContentProviderClient(r13);
        r8.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r12, r9, r14, r10, true);
        return r14;
    }
}
