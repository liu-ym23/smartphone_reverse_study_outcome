package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusRequest;", "Ljava/io/Serializable;", "appKey", "", "versionTag", "checkTypeEnum", "Lcom/bytedance/ai/bridge/remote/model/CheckType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/CheckType;)V", "getAppKey", "()Ljava/lang/String;", "getVersionTag", "getCheckTypeEnum", "()Lcom/bytedance/ai/bridge/remote/model/CheckType;", "checkType", "", "getCheckType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPrivacyOrLoginStatusRequest implements Serializable {
    public final transient CheckType a;

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("check_type")
    private final Integer checkType;

    @SerializedName("version_tag")
    private final String versionTag;

    public CheckPrivacyOrLoginStatusRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CheckPrivacyOrLoginStatusRequest copy$default(CheckPrivacyOrLoginStatusRequest r0, String r1, String r10, CheckType r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.appKey;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.versionTag;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.a;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.versionTag;
    }

    public final CheckType component3() {
        return this.a;
    }

    public final CheckPrivacyOrLoginStatusRequest copy(String r10, String r11, CheckType r12) {
        return new CheckPrivacyOrLoginStatusRequest(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CheckPrivacyOrLoginStatusRequest) == true) goto L8;
        return false;
    L8:
        CheckPrivacyOrLoginStatusRequest r11 = (CheckPrivacyOrLoginStatusRequest) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.versionTag, r11.versionTag) == true) goto L15;
        return false;
    L15:
        if (this.a == r11.a) goto L17;
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
        String r12 = this.versionTag;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        CheckType r15 = this.a;
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
        return "CheckPrivacyOrLoginStatusRequest(appKey=" + this.appKey + ", versionTag=" + this.versionTag + ", checkTypeEnum=" + this.a + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final Integer getCheckType() {
        return this.checkType;
    }

    public final CheckType getCheckTypeEnum() {
        return this.a;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public CheckPrivacyOrLoginStatusRequest(String r1, String r10, CheckType r11) {
        this.appKey = r1;
        this.versionTag = r10;
        this.a = r11;
        if (r11 == null) goto L5;
        Integer r12 = Integer.valueOf(r11.getValue());
    L6:
        this.checkType = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    public /* synthetic */ CheckPrivacyOrLoginStatusRequest(String r10, String r11, CheckType r12, int r13, DefaultConstructorMarker r14) {
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
