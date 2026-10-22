package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/ExchangeCodeRequest;", "Ljava/io/Serializable;", "appKey", "", "code", "deviceId", "versionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "getCode", "getDeviceId", "getVersionTag", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExchangeCodeRequest implements Serializable {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("code")
    private final String code;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("version_tag")
    private final String versionTag;

    public ExchangeCodeRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ExchangeCodeRequest copy$default(ExchangeCodeRequest r0, String r1, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.appKey;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.code;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.deviceId;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.versionTag;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final String component4() {
        return this.versionTag;
    }

    public final ExchangeCodeRequest copy(String r10, String r11, String r12, String r13) {
        return new ExchangeCodeRequest(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ExchangeCodeRequest) == true) goto L8;
        return false;
    L8:
        ExchangeCodeRequest r11 = (ExchangeCodeRequest) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.code, r11.code) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deviceId, r11.deviceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.versionTag, r11.versionTag) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.appKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.code;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.deviceId;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.versionTag;
        if (r18 == null) goto L19;
        r1 = r18.hashCode();
    L19:
        return r17 + r1;
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ExchangeCodeRequest(appKey=" + this.appKey + ", code=" + this.code + ", deviceId=" + this.deviceId + ", versionTag=" + this.versionTag + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public ExchangeCodeRequest(String r1, String r10, String r11, String r12) {
        this.appKey = r1;
        this.code = r10;
        this.deviceId = r11;
        this.versionTag = r12;
    }

    public /* synthetic */ ExchangeCodeRequest(String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
