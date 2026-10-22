package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppVersionList;", "", "appKey", "", "formalVersions", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;)V", "getAppKey", "()Ljava/lang/String;", "getFormalVersions", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewAppVersionList {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("formal_versions")
    private final OpenPlatformPreviewVersionPage formalVersions;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPlatformPreviewAppVersionList() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OpenPlatformPreviewAppVersionList copy$default(OpenPlatformPreviewAppVersionList r0, String r1, OpenPlatformPreviewVersionPage r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.appKey;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.formalVersions;
    L9:
        return r0.copy(r1, r10);
    }

    public final String component1() {
        return this.appKey;
    }

    public final OpenPlatformPreviewVersionPage component2() {
        return this.formalVersions;
    }

    public final OpenPlatformPreviewAppVersionList copy(String r10, OpenPlatformPreviewVersionPage r11) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        return new OpenPlatformPreviewAppVersionList(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformPreviewAppVersionList) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewAppVersionList r11 = (OpenPlatformPreviewAppVersionList) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.formalVersions, r11.formalVersions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.appKey.hashCode() * 31;
        OpenPlatformPreviewVersionPage r1 = this.formalVersions;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return r0 + r10;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "OpenPlatformPreviewAppVersionList(appKey=" + this.appKey + ", formalVersions=" + this.formalVersions + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final OpenPlatformPreviewVersionPage getFormalVersions() {
        return this.formalVersions;
    }

    public OpenPlatformPreviewAppVersionList(String r10, OpenPlatformPreviewVersionPage r11) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        this.appKey = r10;
        this.formalVersions = r11;
    }

    public /* synthetic */ OpenPlatformPreviewAppVersionList(String r1, OpenPlatformPreviewVersionPage r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r1, r10);
    }
}
