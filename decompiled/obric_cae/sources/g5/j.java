package g5;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class j implements m {
    @Override // g5.m
    public final m.a a(Context r8) {
        Uri r10 = Uri.parse("content://cn.nubia.identity/identity");
        ContentProviderClient r11 = r8.getContentResolver().acquireContentProviderClient(r10);     // Catch: Exception -> L17
        if (r11 != null) goto L6;
        return null;
    L6:
        Bundle r12 = r11.call("getOAID", null, null);     // Catch: Exception -> L17
        r11.close();     // Catch: Exception -> L17
        if (r12 != null) goto L10;
        return null;
    L10:
        if (r12.getInt("code", -1) != 0) goto L14;
        m.a r13 = new m.a();     // Catch: Exception -> L17
        r13.f7667a = r12.getString("id");     // Catch: Exception -> L17
        return r13;
    L14:
        if (TextUtils.isEmpty(r12.getString("message")) == true) goto L16;
        int r14 = x4.r.f13543a;     // Catch: Exception -> L17
    L16:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // g5.m
    public final boolean b(Context r8) {
        return true;
    }

    @Override // g5.m
    public final String getName() {
        return "Nubia";
    }
}
