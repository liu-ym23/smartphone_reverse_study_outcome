package com.larksuite.framework.callback.Entity;

import android.text.TextUtils;
import com.larus.audio.call.dora.CommandStatus;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ErrorResult extends Throwable {
    public static final ErrorResult TIMEOUT_ERROR = null;
    private static b sCodeCompat;
    private int bizCode;
    private int code;
    private String debugMsg;
    private String displayMsg;
    private String displayTitle;
    private String extra;
    private byte[] extraRaw;
    private String logId;
    private Exception mException;
    private int regulateCode;
    private String serverRequestId;
    private int status;

    public static final class a {
        public int a;
        public int b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public Exception h;
        public String i;
        public byte[] j;

        public final ErrorResult a() {
            ErrorResult r0 = new ErrorResult(0);
            ErrorResult.access$002(r0, this.b);
            ErrorResult.access$102(r0, -9999);
            ErrorResult.access$202(r0, this.a);
            ErrorResult.access$302(r0, this.h);
            ErrorResult.access$402(r0, this.e);
            ErrorResult.access$502(r0, this.c);
            ErrorResult.access$602(r0, this.d);
            ErrorResult.access$702(r0, this.f);
            ErrorResult.access$802(r0, 0);
            ErrorResult.access$902(r0, this.g);
            ErrorResult.access$1002(r0, this.i);
            ErrorResult.access$1102(r0, this.j);
            return r0;
        }

        public a() {
            this.b = -1;
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.h = new Exception("unknown error");
        }
    }

    public interface b {
    }

    static {
        TIMEOUT_ERROR = new ErrorResult(CommandStatus.DORA_NOISE_CONTROL, "Time out");
        sCodeCompat = null;
    }

    public int getErrorCode() {
        com.ss.android.lark.sdk.b r0 = sCodeCompat;
        if (r0 == null) goto L9;
        int r1 = this.code;
        r0.getClass();
        Integer r2 = (Integer) com.ss.android.lark.sdk.b.b.get(Integer.valueOf(r1));
        if (r2 != null) goto L7;
        return r1;
    L7:
        return r2.intValue();
    L9:
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format(Locale.US, "ErrorResult: code=%d, dbg=%s, display=%s, reqId=%s, rc=%d, e=%s", new Object[]{Integer.valueOf(this.code), this.debugMsg, this.displayMsg, this.serverRequestId, Integer.valueOf(this.regulateCode), this.mException});
    }

    public String getErrorMsg() {
        return getDisplayMsg();
    }

    public int getBizCode() {
        return this.bizCode;
    }

    public int getCode() {
        return this.code;
    }

    public String getDebugMsg() {
        return this.debugMsg;
    }

    public String getDisplayMsg() {
        return this.displayMsg;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public Exception getException() {
        return this.mException;
    }

    public String getExtra() {
        return this.extra;
    }

    public byte[] getExtraRaw() {
        return this.extraRaw;
    }

    public String getLogId() {
        return this.logId;
    }

    public int getRegulateCode() {
        return this.regulateCode;
    }

    public String getServerRequestId() {
        return this.serverRequestId;
    }

    public int getStatus() {
        return this.status;
    }

    public ErrorResult(int r4) {
        this.bizCode = -9999;
        this.mException = new Exception("unknown error");
        this.code = r4;
        this.mException = new Exception("errorCode  = " + r4);
    }

    public static void setCodeCompat(b r0) {
        sCodeCompat = r0;
    }

    public void copyFrom(ErrorResult r2) {
        this.debugMsg = r2.debugMsg;
        this.code = r2.code;
        this.bizCode = r2.bizCode;
        this.status = r2.status;
        this.displayMsg = r2.displayMsg;
        this.displayTitle = r2.displayTitle;
        this.serverRequestId = r2.serverRequestId;
        this.regulateCode = r2.regulateCode;
        this.mException = r2.mException;
    }

    public String getDisplayMsg(String r2) {
        if (TextUtils.isEmpty(this.displayMsg) == false) goto L6;
        return r2;
    L6:
        return getDisplayMsg();
    }

    public void setErrorCode(int r1) {
        this.code = r1;
    }

    public ErrorResult(Exception r3) {
        this.bizCode = -9999;
        this.mException = new Exception("unknown error");
        if (r3 == null) goto L6;
        this.debugMsg = r3.getLocalizedMessage();
        this.mException = r3;
        return;
    }

    public ErrorResult(String r3) {
        this.bizCode = -9999;
        this.mException = new Exception("unknown error");
        this.debugMsg = r3;
        this.mException = new Exception(r3);
    }

    public ErrorResult(int r3, String r4) {
        this.bizCode = -9999;
        this.mException = new Exception("unknown error");
        this.code = r3;
        this.debugMsg = r4;
        this.mException = new Exception(r4);
    }

    public static /* synthetic */ int access$002(ErrorResult r0, int r1) {
        r0.code = r1;
        return r1;
    }

    public static /* synthetic */ String access$1002(ErrorResult r0, String r1) {
        r0.extra = r1;
        return r1;
    }

    public static /* synthetic */ int access$102(ErrorResult r0, int r1) {
        r0.bizCode = r1;
        return r1;
    }

    public static /* synthetic */ byte[] access$1102(ErrorResult r0, byte[] r1) {
        r0.extraRaw = r1;
        return r1;
    }

    public static /* synthetic */ int access$202(ErrorResult r0, int r1) {
        r0.status = r1;
        return r1;
    }

    public static /* synthetic */ Exception access$302(ErrorResult r0, Exception r1) {
        r0.mException = r1;
        return r1;
    }

    public static /* synthetic */ String access$402(ErrorResult r0, String r1) {
        r0.displayTitle = r1;
        return r1;
    }

    public static /* synthetic */ String access$502(ErrorResult r0, String r1) {
        r0.debugMsg = r1;
        return r1;
    }

    public static /* synthetic */ String access$602(ErrorResult r0, String r1) {
        r0.displayMsg = r1;
        return r1;
    }

    public static /* synthetic */ String access$702(ErrorResult r0, String r1) {
        r0.serverRequestId = r1;
        return r1;
    }

    public static /* synthetic */ int access$802(ErrorResult r0, int r1) {
        r0.regulateCode = r1;
        return r1;
    }

    public static /* synthetic */ String access$902(ErrorResult r0, String r1) {
        r0.logId = r1;
        return r1;
    }

    public ErrorResult(String r3, Exception r4) {
        this.bizCode = -9999;
        this.mException = new Exception("unknown error");
        this.debugMsg = r3;
        if (r4 == null) goto L6;
        this.mException = r4;
        return;
    }

    public ErrorResult(int r2, String r3, String r4, String r5, Exception r6) {
        this.bizCode = -9999;
        this.mException = new Exception("unknown error");
        this.code = r2;
        this.debugMsg = r3;
        this.displayMsg = r5;
        if (r6 == null) goto L6;
        this.mException = r6;
        return;
    }
}
