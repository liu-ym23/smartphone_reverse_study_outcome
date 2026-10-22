package com.larus.bmhome.miniartifact.listpage.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "Ljava/io/Serializable;", "inputPreviewWebUrl", "", "<init>", "(Ljava/lang/String;)V", "getInputPreviewWebUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputEntrance implements Serializable {

    @SerializedName("input_preview_web_url")
    private final String inputPreviewWebUrl;

    public InputEntrance() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ InputEntrance copy$default(InputEntrance r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.inputPreviewWebUrl;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.inputPreviewWebUrl;
    }

    public final InputEntrance copy(String r2) {
        return new InputEntrance(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof InputEntrance) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.inputPreviewWebUrl, ((InputEntrance) r4).inputPreviewWebUrl) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.inputPreviewWebUrl;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "InputEntrance(inputPreviewWebUrl=" + this.inputPreviewWebUrl + ')';
    }

    public final String getInputPreviewWebUrl() {
        return this.inputPreviewWebUrl;
    }

    public InputEntrance(String r1) {
        this.inputPreviewWebUrl = r1;
    }

    public /* synthetic */ InputEntrance(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
