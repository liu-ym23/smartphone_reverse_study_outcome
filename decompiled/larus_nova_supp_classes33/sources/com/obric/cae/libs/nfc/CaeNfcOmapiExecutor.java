package com.obric.cae.libs.nfc;

import com.obric.cae.libs.utils.LogUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CaeNfcOmapiExecutor {
    public final ICaeNfcOmapiExecutor a;

    public String getEseId() {
        ICaeNfcOmapiExecutor r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "getEseId: service is null");
        return null;
    L11:
        return r0.getEseId();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcOmapiExecutor");
        return null;
    }

    public CaeNfcOmapiExecutor(ICaeNfcOmapiExecutor r1) {
        this.a = r1;
    }
}
