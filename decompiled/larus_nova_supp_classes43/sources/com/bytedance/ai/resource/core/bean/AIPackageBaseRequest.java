package com.bytedance.ai.resource.core.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageBaseRequest;", "", "aid", "", "extraInfo", "Lcom/bytedance/ai/resource/core/bean/ExtraInfo;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/resource/core/bean/ExtraInfo;)V", "getAid", "()Ljava/lang/String;", "getExtraInfo", "()Lcom/bytedance/ai/resource/core/bean/ExtraInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageBaseRequest {
    private final String aid;
    private final ExtraInfo extraInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageBaseRequest() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AIPackageBaseRequest copy$default(AIPackageBaseRequest r0, String r1, ExtraInfo r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.aid;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.extraInfo;
    L9:
        return r0.copy(r1, r10);
    }

    public final String component1() {
        return this.aid;
    }

    public final ExtraInfo component2() {
        return this.extraInfo;
    }

    public final AIPackageBaseRequest copy(String r10, ExtraInfo r11) {
        return new AIPackageBaseRequest(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AIPackageBaseRequest) == true) goto L8;
        return false;
    L8:
        AIPackageBaseRequest r11 = (AIPackageBaseRequest) r10;
        if (Intrinsics.areEqual(this.aid, r11.aid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraInfo, r11.extraInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.aid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        ExtraInfo r12 = this.extraInfo;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AIPackageBaseRequest(aid=" + this.aid + ", extraInfo=" + this.extraInfo + ')';
    }

    public final String getAid() {
        return this.aid;
    }

    public final ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public AIPackageBaseRequest(String r1, ExtraInfo r10) {
        this.aid = r1;
        this.extraInfo = r10;
    }

    public /* synthetic */ AIPackageBaseRequest(String r10, ExtraInfo r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
