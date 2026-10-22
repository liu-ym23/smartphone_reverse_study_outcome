package com.larus.sheet.sdk.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/sheet/sdk/api/SheetUserSelection;", "", "sheets", "", "Lcom/larus/sheet/sdk/api/SheetSelection;", "activeSheetName", "", "activeSheetId", "plainText", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSheets", "()Ljava/util/List;", "getActiveSheetName", "()Ljava/lang/String;", "getActiveSheetId", "getPlainText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetUserSelection {

    @SerializedName("active_sheet_id")
    private final String activeSheetId;

    @SerializedName("active_sheet_name")
    private final String activeSheetName;

    @SerializedName("plain_text")
    private final String plainText;

    @SerializedName("sheets")
    private final List<SheetSelection> sheets;

    public SheetUserSelection() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SheetUserSelection copy$default(SheetUserSelection r0, List r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.sheets;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.activeSheetName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.activeSheetId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.plainText;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<SheetSelection> component1() {
        return this.sheets;
    }

    public final String component2() {
        return this.activeSheetName;
    }

    public final String component3() {
        return this.activeSheetId;
    }

    public final String component4() {
        return this.plainText;
    }

    public final SheetUserSelection copy(List<SheetSelection> r2, String r3, String r4, String r5) {
        return new SheetUserSelection(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SheetUserSelection) == true) goto L8;
        return false;
    L8:
        SheetUserSelection r6 = (SheetUserSelection) r5;
        if (Intrinsics.areEqual(this.sheets, r6.sheets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activeSheetName, r6.activeSheetName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.activeSheetId, r6.activeSheetId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.plainText, r6.plainText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<SheetSelection> r0 = this.sheets;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.activeSheetName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.activeSheetId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.plainText;
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
        return "SheetUserSelection(sheets=" + this.sheets + ", activeSheetName=" + this.activeSheetName + ", activeSheetId=" + this.activeSheetId + ", plainText=" + this.plainText + ')';
    }

    public final String getActiveSheetId() {
        return this.activeSheetId;
    }

    public final String getActiveSheetName() {
        return this.activeSheetName;
    }

    public final String getPlainText() {
        return this.plainText;
    }

    public final List<SheetSelection> getSheets() {
        return this.sheets;
    }

    public SheetUserSelection(List<SheetSelection> r1, String r2, String r3, String r4) {
        this.sheets = r1;
        this.activeSheetName = r2;
        this.activeSheetId = r3;
        this.plainText = r4;
    }

    public /* synthetic */ SheetUserSelection(List r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
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
