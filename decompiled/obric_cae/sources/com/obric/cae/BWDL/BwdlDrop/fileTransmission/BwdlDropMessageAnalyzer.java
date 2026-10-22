package com.obric.cae.BWDL.BwdlDrop.fileTransmission;

import android.content.Context;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropDatabase;
import com.obric.cae.log.CaeLog;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropMessageAnalyzer {
    private static final String TAG = "BwdlDropMessageAnalyzer";
    private Context mContext;
    private BwdlDropDatabase mDataBase;

    public BwdlDropMessageAnalyzer(Context r8) {
        this.mContext = r8;
        this.mDataBase = new BwdlDropDatabase(r8);
    }

    public void processBwdlDropEvent(int r8, byte[] r10) {
        BwdlDropManager r11 = BwdlDropManager.getInstance(this.mContext);
        String r12 = new String(r10, "UTF-8");     // Catch: UnsupportedEncodingException -> L5
    L7:
        BwdlDropActionFrame r13 = new BwdlDropActionFrame(r12);
        String r14 = r13.getActionName();
        JSONObject r15 = r13.getExtra();
        BwdlDropDeviceManager r16 = r11.getOrCreateDeviceManager(r8);
        String r17 = TAG;
        CaeLog.d(r17, "actionName:" + r14);
        r14.getClass();
        byte r18 = -1;
        switch(r14.hashCode()) {
            case -892481550: goto L23;
            case 82001897: goto L19;
            case 832221671: goto L15;
            case 1501060884: goto L11;
            default: goto L26;
        };
    L26:
        switch(r18) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L29;
            case 3: goto L28;
            default: goto L45;
        };
    L28:
        BwdlDropManager.getInstance(this.mContext).connectDataLink(BwdlDropConstant.DATA_LINK_TYPES);
        return;
    L29:
        BwdlDropSession r19 = JsonConvertHelper.parseFileShareRequest(this.mContext, r15, r16);
        if (r19 != null) goto L32;
        return;
    L32:
        r16.setBwdlDropSession(r19);
        r19.notifyObserversStatusChange(1);
        if (r16.getDataLink() != null) goto L35;
        BwdlDropManager.getInstance(this.mContext).connectDataLink(BwdlDropConstant.DATA_LINK_TYPES);
        return;
    L35:
        r11.launchIncomingFileConfirmActivity(r16.getDeviceId(), r19);
        return;
    L36:
        String r20 = JsonConvertHelper.parseFileShareResp(r15);
        CaeLog.d(r17, "shareResp:" + r20);
    L37:
        r11.updateTransferStatus(r20, r16.getBwdlDropSession());
        return;
    L38:
        r20 = JsonConvertHelper.parseTransferStatus(r15);
        goto L37
    L45:
        return;
    L11:
        if (r14.equals(BwdlDropConstant.TRANSFER_NOTIFY) == false) goto L26;
        r18 = 3;
        goto L26
    L15:
        if (r14.equals(BwdlDropConstant.SEND_REQUEST) == false) goto L26;
        r18 = 2;
        goto L26
    L19:
        if (r14.equals(BwdlDropConstant.SEND_RESPONSE) == false) goto L26;
        r18 = 1;
        goto L26
    L23:
        if (r14.equals("status") == false) goto L26;
        r18 = 0;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "UnsupportedEncodingException:" + e.getMessage());
        r12 = null;
        goto L7
    }
}
