package com.bytedance.android.live.ai.api.business.asr;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/ai/api/business/asr/AsrPredictResult;", "", "code", "", "message", "", "strategy", "Lcom/bytedance/android/live/ai/api/business/asr/AsrResultStrategy;", "(ILjava/lang/String;Lcom/bytedance/android/live/ai/api/business/asr/AsrResultStrategy;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getStrategy", "()Lcom/bytedance/android/live/ai/api/business/asr/AsrResultStrategy;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsrPredictResult {
    private final int code;
    private final String message;
    private final AsrResultStrategy strategy;

    public AsrPredictResult() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ AsrPredictResult copy$default(AsrPredictResult r0, int r1, String r2, AsrResultStrategy r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.strategy;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final AsrResultStrategy component3() {
        return this.strategy;
    }

    public final AsrPredictResult copy(int r2, String r3, AsrResultStrategy r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        return new AsrPredictResult(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AsrPredictResult) == false) goto L12;
        AsrPredictResult r4 = (AsrPredictResult) r3;
        if (this.code == r4.code) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategy, r4.strategy) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r0 = this.code * 31;
        String r1 = this.message;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        AsrResultStrategy r5 = this.strategy;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "AsrPredictResult(code=" + this.code + ", message=" + this.message + ", strategy=" + this.strategy + ")";
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final AsrResultStrategy getStrategy() {
        return this.strategy;
    }

    public AsrPredictResult(int r2, String r3, AsrResultStrategy r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.code = r2;
        this.message = r3;
        this.strategy = r4;
    }

    public /* synthetic */ AsrPredictResult(int r1, String r2, AsrResultStrategy r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = "";
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }
}
