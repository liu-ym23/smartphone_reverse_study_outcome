package com.bytedance.bdinstall.oaid;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class PicoOaidImpl implements OaidApi {

    static class PicoOaid extends OaidApi.Result {
        PicoOaid() {
        }
    }

    public PicoOaidImpl() {
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Pico";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    @RequiresApi(api = 24)
    public OaidApi.Result getOaid(Context r10) {
        PicoOaid r11 = new PicoOaid();
        ContentProviderClient r12 = null;
        ContentProviderClient r13 = r10.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.pico.idprovider"));     // Catch: Throwable -> L13 RemoteException -> L15
    L11:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r13 == null) goto L20;
        r13.close();
    L20:
        Bundle r14 = null;
    L21:
        if (r14 == null) goto L23;
        r11.oaid = r14.getString(Oaid.KEY_OAID_ID, null);
        r11.isTrackLimit = r14.getBoolean("forbidden", false);
    L23:
        return r11;
    L24:
        th = th;
        r12 = r13;
    L26:
        if (r12 == null) goto L28;
        r12.close();
    L28:
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 17) goto L8;
        r14 = r13.call("request_oaid", null, null);     // Catch: RemoteException -> L11 Throwable -> L24
    L9:
        if (r13 == null) goto L21;
        r13.close();
        goto L21
    L8:
        r14 = null;
        goto L9
    L15:
        e = e;
        r13 = null;
    L13:
        th = th;
        goto L26
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r10) {
        return true;
    }
}
