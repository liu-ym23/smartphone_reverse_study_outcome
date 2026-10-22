package com.bytedance.ai.bridge.remote.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PrivacyAcceptRequest;", "Ljava/io/Serializable;", "appKey", "", "requestId", "deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "getRequestId", "getDeviceId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyAcceptRequest implements Serializable {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName(a.KEY_REQUEST_ID)
    private final String requestId;

    public PrivacyAcceptRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PrivacyAcceptRequest copy$default(PrivacyAcceptRequest r0, String r1, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.appKey;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.requestId;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.deviceId;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.requestId;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final PrivacyAcceptRequest copy(String r10, String r11, String r12) {
        return new PrivacyAcceptRequest(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PrivacyAcceptRequest) == true) goto L8;
        return false;
    L8:
        PrivacyAcceptRequest r11 = (PrivacyAcceptRequest) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r11.requestId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deviceId, r11.deviceId) == true) goto L17;
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
        String r12 = this.requestId;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.deviceId;
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
        return "PrivacyAcceptRequest(appKey=" + this.appKey + ", requestId=" + this.requestId + ", deviceId=" + this.deviceId + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public PrivacyAcceptRequest(String r1, String r10, String r11) {
        this.appKey = r1;
        this.requestId = r10;
        this.deviceId = r11;
    }

    public /* synthetic */ PrivacyAcceptRequest(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
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
