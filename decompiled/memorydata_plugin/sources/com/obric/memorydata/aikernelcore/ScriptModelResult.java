package com.obric.memorydata.aikernelcore;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/aikernelcore/ScriptModelResult;", "", "result", "", "logId", "resultCode", "", "resultMsg", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getResult", "()Ljava/lang/String;", "getLogId", "getResultCode", "()I", "getResultMsg", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScriptModelResult {
    private final String logId;
    private final String result;
    private final int resultCode;
    private final String resultMsg;

    public ScriptModelResult(String r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "logId");
        Intrinsics.checkNotNullParameter(r5, "resultMsg");
        this.result = r2;
        this.logId = r3;
        this.resultCode = r4;
        this.resultMsg = r5;
    }

    public static /* synthetic */ ScriptModelResult copy$default(ScriptModelResult r0, String r1, String r2, int r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.result;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.logId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.resultCode;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.resultMsg;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.result;
    }

    public final String component2() {
        return this.logId;
    }

    public final int component3() {
        return this.resultCode;
    }

    public final String component4() {
        return this.resultMsg;
    }

    public final ScriptModelResult copy(String r1, String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Intrinsics.checkNotNullParameter(r2, "logId");
        Intrinsics.checkNotNullParameter(r4, "resultMsg");
        return new ScriptModelResult(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScriptModelResult.class) == true) goto L8;
        return false;
    L8:
        ScriptModelResult r6 = (ScriptModelResult) ZeusTransformUtils.preCheckCast(r5, ScriptModelResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.result, r6.result) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L15;
        return false;
    L15:
        if (this.resultCode == r6.resultCode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resultMsg, r6.resultMsg) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getResult() {
        return this.result;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public int hashCode() {
        return (((((this.result.hashCode() * 31) + this.logId.hashCode()) * 31) + Integer.hashCode(this.resultCode)) * 31) + this.resultMsg.hashCode();
    }

    public String toString() {
        return "ScriptModelResult(result=" + this.result + ", logId=" + this.logId + ", resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ')';
    }
}
