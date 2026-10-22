package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010#J\u0086\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\rJ\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\rHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0013R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0013R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0013R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006?"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/IntentDebugReport;", "Landroid/os/Parcelable;", "isAppIntent", "", "intentDomain", "intentName", "intentParameters", "firstIntentResult", "engineResultCode", "engineErrorMsg", "costTime", "actionResult", "resultCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "()Ljava/lang/String;", "getIntentDomain", "setIntentDomain", "(Ljava/lang/String;)V", "getIntentName", "setIntentName", "getIntentParameters", "setIntentParameters", "getFirstIntentResult", "setFirstIntentResult", "getEngineResultCode", "setEngineResultCode", "getEngineErrorMsg", "setEngineErrorMsg", "getCostTime", "setCostTime", "getActionResult", "setActionResult", "getResultCode", "()Ljava/lang/Integer;", "setResultCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/aiagent/assistant/idl/bean/IntentDebugReport;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IntentDebugReport implements Parcelable {
    public static final Parcelable.Creator<IntentDebugReport> CREATOR = null;

    @SerializedName("ACTION_RESULT")
    private String actionResult;

    @SerializedName("COST_TIME")
    private String costTime;

    @SerializedName("ENGINE_ERROR_MSG")
    private String engineErrorMsg;

    @SerializedName("ENGINE_RESULT_CODE")
    private String engineResultCode;

    @SerializedName("PC_SEARCH_RESULT")
    private String firstIntentResult;

    @SerializedName("DOMAIN")
    private String intentDomain;

    @SerializedName("INTENT_NAME")
    private String intentName;

    @SerializedName("INTENT_PARAMETERS")
    private String intentParameters;

    @SerializedName("IS_APP_INTENT")
    private final String isAppIntent;

    @SerializedName("RESULT_CODE")
    private Integer resultCode;

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IntentDebugReport) == true) goto L8;
        return false;
    L8:
        IntentDebugReport r6 = (IntentDebugReport) r5;
        if (Intrinsics.areEqual(this.isAppIntent, r6.isAppIntent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intentDomain, r6.intentDomain) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.intentName, r6.intentName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.intentParameters, r6.intentParameters) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.firstIntentResult, r6.firstIntentResult) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.engineResultCode, r6.engineResultCode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.engineErrorMsg, r6.engineErrorMsg) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.costTime, r6.costTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.actionResult, r6.actionResult) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.resultCode, r6.resultCode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r0 = this.isAppIntent;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.intentDomain;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.intentName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.intentParameters;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.firstIntentResult;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.engineResultCode;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.engineErrorMsg;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.costTime;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.actionResult;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.resultCode;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "IntentDebugReport(isAppIntent=" + this.isAppIntent + ", intentDomain=" + this.intentDomain + ", intentName=" + this.intentName + ", intentParameters=" + this.intentParameters + ", firstIntentResult=" + this.firstIntentResult + ", engineResultCode=" + this.engineResultCode + ", engineErrorMsg=" + this.engineErrorMsg + ", costTime=" + this.costTime + ", actionResult=" + this.actionResult + ", resultCode=" + this.resultCode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.isAppIntent);
        r2.writeString(this.intentDomain);
        r2.writeString(this.intentName);
        r2.writeString(this.intentParameters);
        r2.writeString(this.firstIntentResult);
        r2.writeString(this.engineResultCode);
        r2.writeString(this.engineErrorMsg);
        r2.writeString(this.costTime);
        r2.writeString(this.actionResult);
        Integer r4 = this.resultCode;
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        r2.writeInt(r5);
        return;
    L5:
        r2.writeInt(1);
        r5 = r4.intValue();
        goto L6
    }

    public IntentDebugReport() {
        this("", "", "", "", "", "", "", "", "", 0);
    }

    public final String a() {
        return this.actionResult;
    }

    public final String b() {
        return this.costTime;
    }

    public final String c() {
        return this.engineResultCode;
    }

    public final String d() {
        return this.firstIntentResult;
    }

    public final String e() {
        return this.intentDomain;
    }

    public final String g() {
        return this.intentName;
    }

    public final String h() {
        return this.intentParameters;
    }

    public final Integer i() {
        return this.resultCode;
    }

    public final String j() {
        return this.isAppIntent;
    }

    public IntentDebugReport(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, Integer r10) {
        this.isAppIntent = r1;
        this.intentDomain = r2;
        this.intentName = r3;
        this.intentParameters = r4;
        this.firstIntentResult = r5;
        this.engineResultCode = r6;
        this.engineErrorMsg = r7;
        this.costTime = r8;
        this.actionResult = r9;
        this.resultCode = r10;
    }
}
