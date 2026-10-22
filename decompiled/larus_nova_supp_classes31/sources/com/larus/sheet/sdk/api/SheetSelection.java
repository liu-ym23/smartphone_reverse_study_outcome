package com.larus.sheet.sdk.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J]\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/larus/sheet/sdk/api/SheetSelection;", "", "sheetId", "", "sheetName", "ranges", "", "charts", "floatImages", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getSheetId", "()Ljava/lang/String;", "getSheetName", "getRanges", "()Ljava/util/List;", "getCharts", "getFloatImages", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetSelection {

    @SerializedName("charts")
    private final List<String> charts;

    @SerializedName("float_images")
    private final List<String> floatImages;

    @SerializedName("ranges")
    private final List<String> ranges;

    @SerializedName("sheet_id")
    private final String sheetId;

    @SerializedName("sheet_name")
    private final String sheetName;

    public SheetSelection() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SheetSelection copy$default(SheetSelection r3, String r4, String r5, List r6, List r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.sheetId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.sheetName;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.ranges;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.charts;
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.floatImages;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.sheetId;
    }

    public final String component2() {
        return this.sheetName;
    }

    public final List<String> component3() {
        return this.ranges;
    }

    public final List<String> component4() {
        return this.charts;
    }

    public final List<String> component5() {
        return this.floatImages;
    }

    public final SheetSelection copy(String r8, String r9, List<String> r10, List<String> r11, List<String> r12) {
        return new SheetSelection(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SheetSelection) == true) goto L8;
        return false;
    L8:
        SheetSelection r6 = (SheetSelection) r5;
        if (Intrinsics.areEqual(this.sheetId, r6.sheetId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sheetName, r6.sheetName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ranges, r6.ranges) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.charts, r6.charts) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.floatImages, r6.floatImages) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.sheetId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sheetName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.ranges;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.charts;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.floatImages;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "SheetSelection(sheetId=" + this.sheetId + ", sheetName=" + this.sheetName + ", ranges=" + this.ranges + ", charts=" + this.charts + ", floatImages=" + this.floatImages + ')';
    }

    public final List<String> getCharts() {
        return this.charts;
    }

    public final List<String> getFloatImages() {
        return this.floatImages;
    }

    public final List<String> getRanges() {
        return this.ranges;
    }

    public final String getSheetId() {
        return this.sheetId;
    }

    public final String getSheetName() {
        return this.sheetName;
    }

    public SheetSelection(String r1, String r2, List<String> r3, List<String> r4, List<String> r5) {
        this.sheetId = r1;
        this.sheetName = r2;
        this.ranges = r3;
        this.charts = r4;
        this.floatImages = r5;
    }

    public /* synthetic */ SheetSelection(String r5, String r6, List r7, List r8, List r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        List r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        List r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        List r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
