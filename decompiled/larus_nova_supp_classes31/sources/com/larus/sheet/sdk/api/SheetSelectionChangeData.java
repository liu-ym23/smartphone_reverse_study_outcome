package com.larus.sheet.sdk.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/sheet/sdk/api/SheetSelectionChangeData;", "", "spreadsheetVersion", "", "spreadsheetToken", "", "selected", "Lcom/larus/sheet/sdk/api/SheetUserSelection;", "<init>", "(ILjava/lang/String;Lcom/larus/sheet/sdk/api/SheetUserSelection;)V", "getSpreadsheetVersion", "()I", "getSpreadsheetToken", "()Ljava/lang/String;", "getSelected", "()Lcom/larus/sheet/sdk/api/SheetUserSelection;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetSelectionChangeData {

    @SerializedName("selected")
    private final SheetUserSelection selected;

    @SerializedName("spreadsheet_token")
    private final String spreadsheetToken;

    @SerializedName("spreadsheet_version")
    private final int spreadsheetVersion;

    public SheetSelectionChangeData() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ SheetSelectionChangeData copy$default(SheetSelectionChangeData r0, int r1, String r2, SheetUserSelection r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.spreadsheetVersion;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.spreadsheetToken;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.selected;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.spreadsheetVersion;
    }

    public final String component2() {
        return this.spreadsheetToken;
    }

    public final SheetUserSelection component3() {
        return this.selected;
    }

    public final SheetSelectionChangeData copy(int r2, String r3, SheetUserSelection r4) {
        return new SheetSelectionChangeData(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SheetSelectionChangeData) == true) goto L8;
        return false;
    L8:
        SheetSelectionChangeData r6 = (SheetSelectionChangeData) r5;
        if (this.spreadsheetVersion == r6.spreadsheetVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.spreadsheetToken, r6.spreadsheetToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selected, r6.selected) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.spreadsheetVersion * 31;
        String r1 = this.spreadsheetToken;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        SheetUserSelection r5 = this.selected;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SheetSelectionChangeData(spreadsheetVersion=" + this.spreadsheetVersion + ", spreadsheetToken=" + this.spreadsheetToken + ", selected=" + this.selected + ')';
    }

    public final SheetUserSelection getSelected() {
        return this.selected;
    }

    public final String getSpreadsheetToken() {
        return this.spreadsheetToken;
    }

    public final int getSpreadsheetVersion() {
        return this.spreadsheetVersion;
    }

    public SheetSelectionChangeData(int r1, String r2, SheetUserSelection r3) {
        this.spreadsheetVersion = r1;
        this.spreadsheetToken = r2;
        this.selected = r3;
    }

    public /* synthetic */ SheetSelectionChangeData(int r2, String r3, SheetUserSelection r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
