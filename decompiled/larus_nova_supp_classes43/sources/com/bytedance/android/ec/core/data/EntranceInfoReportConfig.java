package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/data/EntranceInfoReportConfig;", "Ljava/io/Serializable;", "reportCount", "", "enable", "", "(ILjava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getReportCount", "()I", "setReportCount", "(I)V", "component1", "component2", "copy", "(ILjava/lang/Boolean;)Lcom/bytedance/android/ec/core/data/EntranceInfoReportConfig;", "equals", "other", "", "hashCode", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceInfoReportConfig implements Serializable {

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("report_count")
    private int reportCount;

    public EntranceInfoReportConfig() {
        Boolean r0 = null;
        int r10 = 0;
        this(r10, r0, 3, r0);
    }

    public static /* synthetic */ EntranceInfoReportConfig copy$default(EntranceInfoReportConfig r0, int r1, Boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.reportCount;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.enable;
    L9:
        return r0.copy(r1, r10);
    }

    public final int component1() {
        return this.reportCount;
    }

    public final Boolean component2() {
        return this.enable;
    }

    public final EntranceInfoReportConfig copy(int r10, Boolean r11) {
        return new EntranceInfoReportConfig(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof EntranceInfoReportConfig) == false) goto L10;
        EntranceInfoReportConfig r11 = (EntranceInfoReportConfig) r10;
        if (this.reportCount == r11.reportCount) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enable, r11.enable) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = this.reportCount * 31;
        Boolean r1 = this.enable;
        if (r1 == null) goto L5;
        int r10 = r1.hashCode();
    L7:
        return r0 + r10;
    L5:
        r10 = 0;
        goto L7
    }

    public String toString() {
        return "EntranceInfoReportConfig(reportCount=" + this.reportCount + ", enable=" + this.enable + ")";
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final int getReportCount() {
        return this.reportCount;
    }

    public final void setReportCount(int r1) {
        this.reportCount = r1;
    }

    public EntranceInfoReportConfig(int r1, Boolean r10) {
        this.reportCount = r1;
        this.enable = r10;
    }

    public /* synthetic */ EntranceInfoReportConfig(int r1, Boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = 5;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = Boolean.FALSE;
    L8:
        this(r1, r10);
    }
}
