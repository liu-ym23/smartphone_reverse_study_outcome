package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/service/bean/PromptItem;", "", "format", "", "formatType", "", "matchUiId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getFormat", "()Ljava/lang/String;", "getFormatType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMatchUiId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/canvas/service/bean/PromptItem;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptItem {

    @SerializedName("format")
    private final String format;

    @SerializedName("format_type")
    private final Integer formatType;

    @SerializedName("match_ui_id")
    private final String matchUiId;

    public PromptItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PromptItem copy$default(PromptItem r0, String r1, Integer r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.format;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.formatType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.matchUiId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.format;
    }

    public final Integer component2() {
        return this.formatType;
    }

    public final String component3() {
        return this.matchUiId;
    }

    public final PromptItem copy(String r2, Integer r3, String r4) {
        return new PromptItem(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PromptItem) == true) goto L8;
        return false;
    L8:
        PromptItem r6 = (PromptItem) r5;
        if (Intrinsics.areEqual(this.format, r6.format) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.formatType, r6.formatType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.matchUiId, r6.matchUiId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.format;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.formatType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.matchUiId;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PromptItem(format=" + this.format + ", formatType=" + this.formatType + ", matchUiId=" + this.matchUiId + ')';
    }

    public final String getFormat() {
        return this.format;
    }

    public final Integer getFormatType() {
        return this.formatType;
    }

    public final String getMatchUiId() {
        return this.matchUiId;
    }

    public PromptItem(String r1, Integer r2, String r3) {
        this.format = r1;
        this.formatType = r2;
        this.matchUiId = r3;
    }

    public /* synthetic */ PromptItem(String r2, Integer r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
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
