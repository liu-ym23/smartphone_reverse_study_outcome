package com.ss.android.lark.chameleon;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIError;", "Lcom/bytedance/ee/util/io/NonProguard;", "errorCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, ChameleonOpenTracker.ParamKey.ERRORMSG, com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", "toString", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LKAPIError implements NonProguard {
    private final int errorCode;
    private final String errorMsg;

    public static /* synthetic */ LKAPIError copy$default(LKAPIError r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.errorCode;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.errorMsg;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final LKAPIError copy(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ChameleonOpenTracker.ParamKey.ERRORMSG);
        return new LKAPIError(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LKAPIError) == true) goto L8;
        return false;
    L8:
        LKAPIError r6 = (LKAPIError) r5;
        if (this.errorCode == r6.errorCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMsg, r6.errorMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.errorCode * 31) + this.errorMsg.hashCode();
    }

    public String toString() {
        return "LKAPIError(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public LKAPIError(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ChameleonOpenTracker.ParamKey.ERRORMSG);
        this.errorCode = r2;
        this.errorMsg = r3;
    }
}
