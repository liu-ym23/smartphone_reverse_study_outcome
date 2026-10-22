package com.ttnet.org.chromium.base.compat;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import com.ttnet.org.chromium.base.Callback;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ApiHelperForQ$1 extends TelephonyManager.CellInfoCallback {
    final /* synthetic */ Callback val$callback;

    public ApiHelperForQ$1(Callback r1) {
        this.val$callback = r1;
    }

    @Override // android.telephony.TelephonyManager.CellInfoCallback
    public void onCellInfo(List<CellInfo> r2) {
        this.val$callback.onResult(r2);
    }
}
