package com.bytedance.ai.bridge.remote.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/FailedKey;", "Ljava/io/Serializable;", "appKey", "", "errorCode", "", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMessage", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ai/bridge/remote/model/FailedKey;", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FailedKey implements Serializable {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName(a.KEY_ERROR_CODE)
    private final Integer errorCode;

    @SerializedName("error_message")
    private final String errorMessage;

    public FailedKey() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FailedKey copy$default(FailedKey r0, String r1, Integer r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.appKey;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.errorCode;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.errorMessage;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final String component1() {
        return this.appKey;
    }

    public final Integer component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final FailedKey copy(String r10, Integer r11, String r12) {
        return new FailedKey(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FailedKey) == true) goto L8;
        return false;
    L8:
        FailedKey r11 = (FailedKey) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorCode, r11.errorCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorMessage, r11.errorMessage) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.appKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        Integer r12 = this.errorCode;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.errorMessage;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "FailedKey(appKey=" + this.appKey + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public FailedKey(String r1, Integer r10, String r11) {
        this.appKey = r1;
        this.errorCode = r10;
        this.errorMessage = r11;
    }

    public /* synthetic */ FailedKey(String r10, Integer r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
