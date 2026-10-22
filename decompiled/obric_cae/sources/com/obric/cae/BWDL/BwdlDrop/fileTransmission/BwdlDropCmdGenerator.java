package com.obric.cae.BWDL.BwdlDrop.fileTransmission;

import android.content.Context;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropCmdGenerator {
    private static final String TAG = "BwdlDropCmdGenerator";
    private static String taskId = "0";

    public BwdlDropCmdGenerator() {
    }

    public static byte[] buildFileTransferNotify(Context r8) {
        BwdlDropActionFrame r10 = new BwdlDropActionFrame(1, BwdlDropConstant.TRANSFER_NOTIFY, JsonConvertHelper.buildSendNotify(BwdlDropUtils.getDeviceName(r8)));
        byte[] r11 = new byte[0];
        return r10.toString().getBytes("UTF-8");
    L5:
        e = move-exception;
        CaeLog.e(TAG, "UnsupportedEncodingException:" + e.getMessage());
        return r11;
    }

    public static byte[] buildFileTransferReq(Context r8, BwdlDropSession r10) {
        BwdlDropActionFrame r11 = new BwdlDropActionFrame(1, BwdlDropConstant.SEND_REQUEST, JsonConvertHelper.buildSendRequest(r10, BwdlDropUtils.getDeviceName(r8)));
        byte[] r12 = new byte[0];
        return r11.toString().getBytes("UTF-8");
    L5:
        e = move-exception;
        CaeLog.e(TAG, "UnsupportedEncodingException:" + e.getMessage());
        return r12;
    }

    public static byte[] buildFileTransferResp(String r8) {
        BwdlDropActionFrame r10 = new BwdlDropActionFrame(2, BwdlDropConstant.SEND_RESPONSE, JsonConvertHelper.buildSendResponse(taskId, r8));
        byte[] r11 = new byte[0];
        return r10.toString().getBytes("UTF-8");
    L5:
        e = move-exception;
        CaeLog.e(TAG, "UnsupportedEncodingException:" + e.getMessage());
        return r11;
    }

    public static byte[] buildTransferFail(int r8, String r10) {
        BwdlDropActionFrame r11 = new BwdlDropActionFrame(2, "status", JsonConvertHelper.buildTransferError(taskId, r8, r10));
        byte[] r12 = new byte[0];
        return r11.toString().getBytes("UTF-8");
    L5:
        e = move-exception;
        CaeLog.e(TAG, "UnsupportedEncodingException:" + e.getMessage());
        return r12;
    }

    public static byte[] buildTransferSuccess(int r8) {
        byte[] r10 = new byte[0];
        return new BwdlDropActionFrame(2, "status", JsonConvertHelper.buildTransferSuccess(taskId)).toString().getBytes("UTF-8");
    L5:
        e = move-exception;
        CaeLog.e(TAG, "UnsupportedEncodingException:" + e.getMessage());
        return r10;
    }
}
