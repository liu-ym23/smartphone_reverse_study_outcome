package com.obric.cae.smartNfc.omapi.action;

import android.aimedia.a;
import android.se.omapi.Channel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNfc.omapi.OmapiAction;
import com.obric.cae.smartNfc.omapi.OmapiSession;
import com.obric.cae.smartNfc.omapi.OmapiUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class GetCplcAction implements OmapiAction<String> {
    private static final byte[] CPLC_APDU = null;
    private static final byte[] ISD_AID = null;
    private static final String TAG = "NFC:GetCplcAction";

    static {
        ISD_AID = new byte[]{-96, 0, 0, 1, 81, 0, 0, 0};
        CPLC_APDU = new byte[]{0, -54, -97, 127, 0};
    }

    public GetCplcAction() {
    }

    @Override // com.obric.cae.smartNfc.omapi.OmapiAction
    public /* bridge */ /* synthetic */ String execute(OmapiSession r8) {
        return execute2(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.cae.smartNfc.omapi.OmapiAction
    /* JADX INFO: renamed from: execute, reason: avoid collision after fix types in other method */
    public String execute2(OmapiSession r8) {
        Channel r10 = 0;
        Channel r11 = r8.openLogicalChannel(ISD_AID);     // Catch: Throwable -> L36 IOException -> L38
        if (r11 != null) goto L12;
        CaeLog.e(TAG, "openLogicalChannel failed");     // Catch: IOException -> L34 Throwable -> L47
        if (r11 != null) goto L61;
    L11:
        return null;
    L61:
        r11.close();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        a.q("channel close error: ", e, TAG);
        goto L11
    L12:
        byte[] r12 = r11.transmit(CPLC_APDU);     // Catch: IOException -> L34 Throwable -> L47
        if (OmapiUtils.isSuccessSw(r12) == true) goto L21;
        CaeLog.e(TAG, "CPLC SW error: " + OmapiUtils.swToString(r12));     // Catch: IOException -> L34 Throwable -> L47
        r11.close();     // Catch: Exception -> L17
    L19:
        return null;
    L17:
        e = move-exception;
        a.q("channel close error: ", e, TAG);
        goto L19
    L21:
        int r13 = r12.length - 2;
        if (r13 <= 0) goto L67;
        String r14 = OmapiUtils.toHex(r12, r13);     // Catch: IOException -> L34 Throwable -> L47
        r11.close();     // Catch: Exception -> L31
    L33:
        return r14;
    L31:
        e = move-exception;
        a.q("channel close error: ", e, TAG);
        goto L33
    L67:
        r11.close();     // Catch: Exception -> L25
    L27:
        return null;
    L25:
        e = move-exception;
        a.q("channel close error: ", e, TAG);
    L34:
        IOException e10 = e;
    L40:
        CaeLog.e(TAG, "IO error: " + e10);     // Catch: Throwable -> L47
        if (r11 != null) goto L55;
    L46:
        return null;
    L55:
        r11.close();     // Catch: Exception -> L44
    L44:
        e = move-exception;
        a.q("channel close error: ", e, TAG);
        goto L46
    L47:
        th = move-exception;
        r10 = r8;
        th = th;
    L49:
        if (r10 != 0) goto L59;
    L54:
        throw th;
    L59:
        r10.close();     // Catch: Exception -> L52
    L52:
        e = move-exception;
        a.q("channel close error: ", e, TAG);
    L38:
        e = move-exception;
        e10 = e;
        r11 = null;
    L36:
        th = th;
        goto L49
    }
}
