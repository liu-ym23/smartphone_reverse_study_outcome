package e84;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements m {

    public static class a extends m$a {
        public a() {
        }
    }

    public s() {
    }

    public final boolean a(Context r1) {
        return true;
    }

    public final String getName() {
        return "Pico";
    }

    public final m$a getOaid(Context r4) {
        a r0 = new a();
        ContentProviderClient r1 = null;
        ContentProviderClient r5 = b(r4.getContentResolver(), Uri.parse("content://com.pico.idprovider"));     // Catch: Throwable -> L9 RemoteException -> L11
        Bundle r2 = r5.call("request_oaid", null, null);     // Catch: RemoteException -> L7 Throwable -> L20
        if (r5 == null) goto L17;
        r5.close();
    L17:
        if (r2 == null) goto L19;
        r0.a = r2.getString("oaid", null);
        r0.b = r2.getBoolean("forbidden", false);
    L19:
        return r0;
    L7:
        e = e;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L20
        if (r5 == null) goto L16;
        r5.close();
    L16:
        r2 = null;
    L20:
        th = th;
        r1 = r5;
    L22:
        if (r1 == null) goto L24;
        r1.close();
    L24:
        throw th;
    L11:
        e = e;
        r5 = null;
    L9:
        th = th;
        goto L22
    }

    public static ContentProviderClient b(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
