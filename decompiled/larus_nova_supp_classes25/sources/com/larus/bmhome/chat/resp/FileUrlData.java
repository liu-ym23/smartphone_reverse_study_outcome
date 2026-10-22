package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/resp/FileUrlData;", "", "uri", "", "mainUrl", "backUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getMainUrl", "getBackUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FileUrlData {

    @SerializedName("back_url")
    private final String backUrl;

    @SerializedName("main_url")
    private final String mainUrl;

    @SerializedName("uri")
    private final String uri;

    public FileUrlData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FileUrlData copy$default(FileUrlData r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.uri;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.mainUrl;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.backUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.mainUrl;
    }

    public final String component3() {
        return this.backUrl;
    }

    public final FileUrlData copy(String r2, String r3, String r4) {
        return new FileUrlData(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FileUrlData) == true) goto L8;
        return false;
    L8:
        FileUrlData r6 = (FileUrlData) r5;
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mainUrl, r6.mainUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backUrl, r6.backUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.uri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.mainUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.backUrl;
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
        return "FileUrlData(uri=" + this.uri + ", mainUrl=" + this.mainUrl + ", backUrl=" + this.backUrl + ')';
    }

    public final String getBackUrl() {
        return this.backUrl;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final String getUri() {
        return this.uri;
    }

    public FileUrlData(String r1, String r2, String r3) {
        this.uri = r1;
        this.mainUrl = r2;
        this.backUrl = r3;
    }

    public /* synthetic */ FileUrlData(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
