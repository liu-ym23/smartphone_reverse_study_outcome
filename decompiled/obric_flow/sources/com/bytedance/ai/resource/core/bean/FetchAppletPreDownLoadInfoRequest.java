package com.bytedance.ai.resource.core.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/FetchAppletPreDownLoadInfoRequest;", "", "parentAppId", "", "extraInfo", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;)V", "getParentAppId", "()Ljava/lang/String;", "getExtraInfo", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FetchAppletPreDownLoadInfoRequest {

    @SerializedName("extra_info")
    private final OpenPlatformExtraInfo extraInfo;

    @SerializedName("parent_app_id")
    private final String parentAppId;

    /* JADX WARN: Multi-variable type inference failed */
    public FetchAppletPreDownLoadInfoRequest() {
        Object[] r5 = 0 == true ? 1 : 0;
        this(null, r5, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FetchAppletPreDownLoadInfoRequest copy$default(FetchAppletPreDownLoadInfoRequest r5, String r10, OpenPlatformExtraInfo r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.parentAppId;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.extraInfo;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.parentAppId;
    }

    public final OpenPlatformExtraInfo component2() {
        return this.extraInfo;
    }

    public final FetchAppletPreDownLoadInfoRequest copy(String r5, OpenPlatformExtraInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "parentAppId");
        return new FetchAppletPreDownLoadInfoRequest(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FetchAppletPreDownLoadInfoRequest) == true) goto L8;
        return false;
    L8:
        FetchAppletPreDownLoadInfoRequest r10 = (FetchAppletPreDownLoadInfoRequest) r5;
        if (Intrinsics.areEqual(this.parentAppId, r10.parentAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraInfo, r10.extraInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final OpenPlatformExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final String getParentAppId() {
        return this.parentAppId;
    }

    public int hashCode() {
        int r5 = this.parentAppId.hashCode() * 31;
        OpenPlatformExtraInfo r10 = this.extraInfo;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public String toString() {
        return "FetchAppletPreDownLoadInfoRequest(parentAppId=" + this.parentAppId + ", extraInfo=" + this.extraInfo + ')';
    }

    public FetchAppletPreDownLoadInfoRequest(String r5, OpenPlatformExtraInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "parentAppId");
        this.parentAppId = r5;
        this.extraInfo = r10;
    }

    public /* synthetic */ FetchAppletPreDownLoadInfoRequest(String r5, OpenPlatformExtraInfo r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r5, r10);
    }
}
