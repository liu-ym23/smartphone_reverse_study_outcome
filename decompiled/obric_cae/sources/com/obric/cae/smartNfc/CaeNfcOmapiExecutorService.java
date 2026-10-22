package com.obric.cae.smartNfc;

import android.content.Context;
import com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor;
import com.obric.cae.smartNfc.omapi.OmapiManager;
import com.obric.cae.smartNfc.omapi.action.GetCplcAction;

/* JADX INFO: loaded from: classes2.dex */
public class CaeNfcOmapiExecutorService extends ICaeNfcOmapiExecutor.Stub {
    private static final String CAE_NFC_ACCESS_PERM_ERROR = "NFC_ACCESS permission required";
    private final Context mContext;
    private OmapiManager mOmapiManager;

    public CaeNfcOmapiExecutorService(Context r8) {
        this.mContext = r8;
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor
    public String getEseId() {
        this.mContext.enforceCallingOrSelfPermission(NfcConstants.CAE_NFC_ACCESS_PERM, CAE_NFC_ACCESS_PERM_ERROR);
        return getEseIdInternal();
    }

    public String getEseIdInternal() {
        if (this.mOmapiManager != null) goto L6;
        this.mOmapiManager = new OmapiManager(this.mContext);
    L6:
        return (String) this.mOmapiManager.execute(new GetCplcAction());
    }
}
