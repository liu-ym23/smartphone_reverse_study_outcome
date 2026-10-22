package com.bytedance.badger.collect.impl.pseudo.model;

import com.bytedance.badger.collect.impl.constants.Constants;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class PseudoCodeResult {
    public String data;
    public boolean enableSimCardListen;
    public Integer errorCode;
    public String errorMsg;

    public String toString() {
        return "PseudoCodeResult{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', data='" + this.data + "', enableSimCardListen=" + this.enableSimCardListen + '}';
    }

    public static PseudoCodeResult failed(String r3) {
        return new PseudoCodeResult(Constants.StatusCode.FAILED, r3, "");
    }

    public static PseudoCodeResult success(String r3) {
        return new PseudoCodeResult(Constants.StatusCode.SUCCESS, "", r3);
    }

    public static PseudoCodeResult failed(String r3, boolean r4) {
        return new PseudoCodeResult(Constants.StatusCode.FAILED, r3, "", r4);
    }

    private PseudoCodeResult(Integer r2, String r3, String r4) {
        this.enableSimCardListen = false;
        this.errorCode = r2;
        this.errorMsg = r3;
        this.data = r4;
    }

    public PseudoCodeResult(Integer r1, String r2, String r3, boolean r4) {
        this.errorCode = r1;
        this.errorMsg = r2;
        this.data = r3;
        this.enableSimCardListen = r4;
    }
}
