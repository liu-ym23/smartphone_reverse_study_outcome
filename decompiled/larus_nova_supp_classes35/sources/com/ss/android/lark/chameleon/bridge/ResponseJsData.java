package com.ss.android.lark.chameleon.bridge;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/ResponseJsData;", BuildConfig.FLAVOR, "status", "Lcom/ss/android/lark/chameleon/bridge/Status;", "callbackId", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "extraStr", "(Lcom/ss/android/lark/chameleon/bridge/Status;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getCallbackId", "()Ljava/lang/String;", "setCallbackId", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "getExtraStr", "setExtraStr", "getStatus", "()Lcom/ss/android/lark/chameleon/bridge/Status;", "setStatus", "(Lcom/ss/android/lark/chameleon/bridge/Status;)V", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResponseJsData {
    private String callbackId;
    private Object data;
    private Object extraStr;
    private Status status;

    public ResponseJsData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResponseJsData copy$default(ResponseJsData r0, Status r1, String r2, Object r3, Object r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.callbackId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extraStr;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Status component1() {
        return this.status;
    }

    public final String component2() {
        return this.callbackId;
    }

    public final Object component3() {
        return this.data;
    }

    public final Object component4() {
        return this.extraStr;
    }

    public final ResponseJsData copy(Status r2, String r3, Object r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "callbackId");
        return new ResponseJsData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResponseJsData) == true) goto L8;
        return false;
    L8:
        ResponseJsData r6 = (ResponseJsData) r5;
        if (this.status == r6.status) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.callbackId, r6.callbackId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraStr, r6.extraStr) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Status r0 = this.status;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.callbackId.hashCode()) * 31;
        Object r4 = this.data;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Object r7 = this.extraStr;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ResponseJsData(status=" + this.status + ", callbackId=" + this.callbackId + ", data=" + this.data + ", extraStr=" + this.extraStr + ')';
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final Object getData() {
        return this.data;
    }

    public final Object getExtraStr() {
        return this.extraStr;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setCallbackId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.callbackId = r2;
    }

    public final void setData(Object r1) {
        this.data = r1;
    }

    public final void setExtraStr(Object r1) {
        this.extraStr = r1;
    }

    public final void setStatus(Status r1) {
        this.status = r1;
    }

    public ResponseJsData(Status r2, String r3, Object r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "callbackId");
        this.status = r2;
        this.callbackId = r3;
        this.data = r4;
        this.extraStr = r5;
    }

    public /* synthetic */ ResponseJsData(Status r2, String r3, Object r4, Object r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = BuildConfig.FLAVOR;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
