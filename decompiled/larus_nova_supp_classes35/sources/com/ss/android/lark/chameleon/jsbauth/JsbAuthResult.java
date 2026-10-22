package com.ss.android.lark.chameleon.jsbauth;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0013H\u0002J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleon/jsbauth/JsbAuthResult;", BuildConfig.FLAVOR, "passed", BuildConfig.FLAVOR, "errorCode", "Lcom/ss/android/lark/chameleon/jsbauth/AuthErrorCode;", "successCode", "Lcom/ss/android/lark/chameleon/jsbauth/AuthSuccessCode;", "<init>", "(ZLcom/ss/android/lark/chameleon/jsbauth/AuthErrorCode;Lcom/ss/android/lark/chameleon/jsbauth/AuthSuccessCode;)V", "(Lcom/ss/android/lark/chameleon/jsbauth/AuthErrorCode;)V", "(Lcom/ss/android/lark/chameleon/jsbauth/AuthSuccessCode;)V", "getPassed", "()Z", "getErrorCode", "()Lcom/ss/android/lark/chameleon/jsbauth/AuthErrorCode;", "getSuccessCode", "()Lcom/ss/android/lark/chameleon/jsbauth/AuthSuccessCode;", "status", BuildConfig.FLAVOR, "getStatus", "()Ljava/lang/String;", "obtainStatue", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JsbAuthResult {
    private final AuthErrorCode errorCode;
    private final boolean passed;
    private final AuthSuccessCode successCode;

    public static /* synthetic */ JsbAuthResult copy$default(JsbAuthResult r0, boolean r1, AuthErrorCode r2, AuthSuccessCode r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.passed;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.errorCode;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.successCode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.passed;
    }

    public final AuthErrorCode component2() {
        return this.errorCode;
    }

    public final AuthSuccessCode component3() {
        return this.successCode;
    }

    public final JsbAuthResult copy(boolean r2, AuthErrorCode r3, AuthSuccessCode r4) {
        return new JsbAuthResult(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JsbAuthResult) == true) goto L8;
        return false;
    L8:
        JsbAuthResult r6 = (JsbAuthResult) r5;
        if (this.passed == r6.passed) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorCode, r6.errorCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.successCode, r6.successCode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.passed == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        AuthErrorCode r2 = this.errorCode;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        AuthSuccessCode r6 = this.successCode;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "JsbAuthResult(passed=" + this.passed + ", errorCode=" + this.errorCode + ", successCode=" + this.successCode + ')';
    }

    private final String obtainStatue() {
        AuthSuccessCode r0 = this.successCode;
        if (r0 != null) goto L5;
        AuthErrorCode r1 = this.errorCode;
        if (r1 == null) goto L11;
        return "{ passed: " + this.passed + " errorCode: " + r1.getCode() + ", msg: " + r1.getMsg() + '}';
    L11:
        return "{passed: " + this.passed + '}';
    L5:
        return "{ passed: " + this.passed + " successCode: " + r0.getCode() + ", msg: " + r0.getMsg() + '}';
    }

    public final String getStatus() {
        return obtainStatue();
    }

    public final AuthErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final boolean getPassed() {
        return this.passed;
    }

    public final AuthSuccessCode getSuccessCode() {
        return this.successCode;
    }

    public JsbAuthResult(AuthErrorCode r8) {
        Intrinsics.checkNotNullParameter(r8, "errorCode");
        this(false, r8, null, 4, null);
    }

    public JsbAuthResult(AuthSuccessCode r8) {
        Intrinsics.checkNotNullParameter(r8, "successCode");
        this(true, null, r8, 2, null);
    }

    private JsbAuthResult(boolean r1, AuthErrorCode r2, AuthSuccessCode r3) {
        this.passed = r1;
        this.errorCode = r2;
        this.successCode = r3;
    }

    public /* synthetic */ JsbAuthResult(boolean r2, AuthErrorCode r3, AuthSuccessCode r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }
}
