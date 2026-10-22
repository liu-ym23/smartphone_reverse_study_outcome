package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdinstall.util.Singleton;
import com.bytedance.crash.entity.EventBody;

/* JADX INFO: loaded from: classes.dex */
final class MeizuOaidImpl implements OaidApi {
    private Singleton<Boolean> isSupport;

    MeizuOaidImpl() {
        this.isSupport = new AnonymousClass1(this);
    }

    private String getOaid(Cursor r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isClosed() == false) goto L8;
        return null;
    L8:
        r10.moveToFirst();
        int r11 = r10.getColumnIndex(EventBody.KEY_VALUE);
        if (r11 >= 0) goto L11;
        return null;
    L11:
        return r10.getString(r11);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Meizu";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r10) {
        Uri r11 = Uri.parse("content://com.meizu.flyme.openidsdk/");
        Cursor r12 = r10.getContentResolver().query(r11, null, null, new String[]{Oaid.KEY_OAID_ID}, null);     // Catch: Throwable -> L13
        if (r12 != null) goto L27;
        if (r12 == null) goto L7;
        r12.close();
    L7:
        return null;
    L27:
        OaidApi.Result r13 = new OaidApi.Result();     // Catch: Throwable -> L11
        r13.oaid = getOaid(r12);     // Catch: Throwable -> L11
        r12.close();
        return r13;
    L11:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L19
        if (r12 == null) goto L18;
        r12.close();
    L18:
        return null;
    L19:
        th = move-exception;
        if (r12 == null) goto L22;
        r12.close();
    L22:
        throw th;
    L13:
        th = th;
        r12 = null;
        goto L25
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        return this.isSupport.get(new Object[]{r10}).booleanValue();
    }
}
