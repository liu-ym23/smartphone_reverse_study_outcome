package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/officesdk/api/OfficeSDKDriveResult;", "", "isSuccess", "", "errorCode", "", "message", "cause", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "()Z", "getErrorCode", "()Ljava/lang/String;", "getMessage", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKDriveResult {
    public static final Companion Companion = null;
    private final Throwable cause;
    private final String errorCode;
    private final boolean isSuccess;
    private final String message;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/api/OfficeSDKDriveResult$Companion;", "", "<init>", "()V", "success", "Lcom/ss/android/lark/officesdk/api/OfficeSDKDriveResult;", "failure", "errorCode", "", "message", "cause", "", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final OfficeSDKDriveResult success() {
            return new OfficeSDKDriveResult(true, null, null, null, 14, null);
        }

        public final OfficeSDKDriveResult failure(String r3, String r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r3, "errorCode");
            return new OfficeSDKDriveResult(false, r3, r4, r5);
        }

        public static /* synthetic */ OfficeSDKDriveResult failure$default(Companion r1, String r2, String r3, Throwable r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L9;
            r4 = null;
        L9:
            return r1.failure(r2, r3, r4);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ OfficeSDKDriveResult copy$default(OfficeSDKDriveResult r0, boolean r1, String r2, String r3, Throwable r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.isSuccess;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.errorCode;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.message;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.cause;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.isSuccess;
    }

    public final String component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.message;
    }

    public final Throwable component4() {
        return this.cause;
    }

    public final OfficeSDKDriveResult copy(boolean r2, String r3, String r4, Throwable r5) {
        return new OfficeSDKDriveResult(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSDKDriveResult) == true) goto L8;
        return false;
    L8:
        OfficeSDKDriveResult r6 = (OfficeSDKDriveResult) r5;
        if (this.isSuccess == r6.isSuccess) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorCode, r6.errorCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cause, r6.cause) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.isSuccess == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.errorCode;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.message;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        Throwable r9 = this.cause;
        if (r9 == null) goto L19;
        r3 = r9.hashCode();
    L19:
        return r8 + r3;
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "OfficeSDKDriveResult(isSuccess=" + this.isSuccess + ", errorCode=" + this.errorCode + ", message=" + this.message + ", cause=" + this.cause + ')';
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public OfficeSDKDriveResult(boolean r1, String r2, String r3, Throwable r4) {
        this.isSuccess = r1;
        this.errorCode = r2;
        this.message = r3;
        this.cause = r4;
    }

    public /* synthetic */ OfficeSDKDriveResult(boolean r2, String r3, String r4, Throwable r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
