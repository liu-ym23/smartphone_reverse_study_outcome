package com.obric.cae.libs.nfc;

import com.obric.cae.libs.bluetooth.a;
import com.obric.cae.libs.utils.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class CaeNfcOmapiExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICaeNfcOmapiExecutor f5446a;

    public CaeNfcOmapiExecutor(ICaeNfcOmapiExecutor r8) {
        this.f5446a = r8;
    }

    public String getEseId() {
        ICaeNfcOmapiExecutor r8 = this.f5446a;
        if (r8 != null) goto L11;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "getEseId: service is null");
        return null;
    L11:
        return r8.getEseId();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcOmapiExecutor");
        return null;
    }
}
