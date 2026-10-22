package g5;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class r implements m {

    public static class a extends m.a {
    }

    @Override // g5.m
    public final m.a a(Context r8) {
        a r10 = new a();
        ContentProviderClient r11 = null;
        ContentProviderClient r12 = r8.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.pico.idprovider"));     // Catch: Throwable -> L9 RemoteException -> L11
        Bundle r13 = r12.call("request_oaid", null, null);     // Catch: RemoteException -> L7 Throwable -> L20
        if (r12 == null) goto L17;
        r12.close();
    L17:
        if (r13 == null) goto L19;
        r10.f7667a = r13.getString("oaid", null);
        r10.f7668b = r13.getBoolean("forbidden", false);
    L19:
        return r10;
    L7:
        e = e;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L20
        if (r12 == null) goto L16;
        r12.close();
    L16:
        r13 = null;
    L20:
        th = th;
        r11 = r12;
    L22:
        if (r11 == null) goto L24;
        r11.close();
    L24:
        throw th;
    L11:
        e = e;
        r12 = null;
    L9:
        th = th;
        goto L22
    }

    @Override // g5.m
    public final boolean b(Context r8) {
        return true;
    }

    @Override // g5.m
    public final String getName() {
        return "Pico";
    }
}
