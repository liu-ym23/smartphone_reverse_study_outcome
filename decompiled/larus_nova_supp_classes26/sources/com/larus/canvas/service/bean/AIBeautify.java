package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/canvas/service/bean/AIBeautify;", "Ljava/io/Serializable;", "maskUrl", "", "isExpand", "", "isErase", "isQualityImprove", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "()Ljava/lang/Boolean;", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/canvas/service/bean/AIBeautify;", "equals", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBeautify implements Serializable {

    @SerializedName("isErase")
    public final Boolean isErase;

    @SerializedName("isExpand")
    public final Boolean isExpand;

    @SerializedName("isQualityImprove")
    public final Boolean isQualityImprove;

    @SerializedName("mask_url")
    public final String maskUrl;

    public AIBeautify() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AIBeautify copy$default(AIBeautify r0, String r1, Boolean r2, Boolean r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.maskUrl;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.isExpand;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.isErase;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isQualityImprove;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.maskUrl;
    }

    public final Boolean component2() {
        return this.isExpand;
    }

    public final Boolean component3() {
        return this.isErase;
    }

    public final Boolean component4() {
        return this.isQualityImprove;
    }

    public final AIBeautify copy(String r2, Boolean r3, Boolean r4, Boolean r5) {
        return new AIBeautify(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIBeautify) == true) goto L8;
        return false;
    L8:
        AIBeautify r6 = (AIBeautify) r5;
        if (Intrinsics.areEqual(this.maskUrl, r6.maskUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isExpand, r6.isExpand) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isErase, r6.isErase) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isQualityImprove, r6.isQualityImprove) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.maskUrl;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isExpand;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.isErase;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isQualityImprove;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AIBeautify(maskUrl=" + this.maskUrl + ", isExpand=" + this.isExpand + ", isErase=" + this.isErase + ", isQualityImprove=" + this.isQualityImprove + ')';
    }

    public AIBeautify(String r1, Boolean r2, Boolean r3, Boolean r4) {
        this.maskUrl = r1;
        this.isExpand = r2;
        this.isErase = r3;
        this.isQualityImprove = r4;
    }

    public /* synthetic */ AIBeautify(String r2, Boolean r3, Boolean r4, Boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
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
