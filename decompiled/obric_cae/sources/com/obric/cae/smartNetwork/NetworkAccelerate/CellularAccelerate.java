package com.obric.cae.smartNetwork.NetworkAccelerate;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public class CellularAccelerate {
    private static final String ACTION_CAE_CELLULAR_ACC = "com.obric.cae.ACTION_CAE_CELLULAR_ACC";
    private static final String ACTION_CAE_CELLULAR_ACC_PERMISSION = "com.obric.cae.permission.ACTION_CAE_CELLULAR_ACC_PERMISSION";
    public static final String CELLULAR_ACC_SCENE_TICKET_GRABBING = "TicketGrabbing";
    private static final String TAG = "CellularAccelerate";
    private final Context mContext;
    private int mLastEnableUid;

    public CellularAccelerate(Context r8) {
        this.mLastEnableUid = -1;
        this.mContext = r8.getApplicationContext();
    }

    public void disableCellularAcc() {
        int r8 = this.mLastEnableUid;
        if (r8 != (-1)) goto L5;
        return;
    L5:
        sendCellularAccBroadcast(r8, false, CELLULAR_ACC_SCENE_TICKET_GRABBING);
        this.mLastEnableUid = -1;
    }

    public void enableCellularAcc(int r8) {
        int r10 = this.mLastEnableUid;
        if (r10 != r8) goto L6;
        return;
    L6:
        if (r10 == (-1)) goto L8;
        sendCellularAccBroadcast(r10, false, CELLULAR_ACC_SCENE_TICKET_GRABBING);
        this.mLastEnableUid = -1;
    L8:
        sendCellularAccBroadcast(r8, true, CELLULAR_ACC_SCENE_TICKET_GRABBING);
        this.mLastEnableUid = r8;
    }

    public void foregroundAppManager(L4NetEvaluate.L4NetForegroundApp r8) {
        int r10 = r8.uid;
        int r11 = this.mLastEnableUid;
        if (r11 != r10) goto L6;
        return;
    L6:
        if (r11 == (-1)) goto L9;
        sendCellularAccBroadcast(r11, false, CELLULAR_ACC_SCENE_TICKET_GRABBING);
        this.mLastEnableUid = -1;
    L9:
        if (r8.strategy == L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING) goto L11;
        return;
    L11:
        sendCellularAccBroadcast(r10, true, CELLULAR_ACC_SCENE_TICKET_GRABBING);
        this.mLastEnableUid = r10;
    }

    public void sendCellularAccBroadcast(int r8, boolean r10, String r11) {
        CaeLog.i(TAG, "sendCellularAccBroadcast , enable: " + r10 + ", scene: " + r11 + ", uid: " + r8);
        Intent r12 = new Intent(ACTION_CAE_CELLULAR_ACC);
        r12.putExtra("enable", r10 ? 1 : 0);
        r12.putExtra("scene", r11);
        r12.putExtra("uid", r8);
        if (this.mContext == null) goto L11;
        r12.setPackage("com.bytedance.radioservice");     // Catch: Exception -> L6
        this.mContext.sendBroadcastAsUser(r12, UserHandle.CURRENT, ACTION_CAE_CELLULAR_ACC_PERMISSION);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        b.k(e, new StringBuilder("sendCellularAccBroadcast, failed: "), TAG);
        return;
    }
}
