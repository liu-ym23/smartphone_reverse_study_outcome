package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bmhome/rc/FileResourceMeta;", "", "fileName", "", "md5", "identifier", ShareType.URL, "size", "", "parseExtra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getMd5", "getIdentifier", "getUrl", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getParseExtra", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/bmhome/rc/FileResourceMeta;", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileResourceMeta {

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("identifier")
    private final String identifier;

    @SerializedName("md5")
    private final String md5;

    @SerializedName("parse_extra")
    private final String parseExtra;

    @SerializedName("size")
    private final Long size;

    @SerializedName(ShareType.URL)
    private final String url;

    public FileResourceMeta() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FileResourceMeta copy$default(FileResourceMeta r4, String r5, String r6, String r7, String r8, Long r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.fileName;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.md5;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.identifier;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.url;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.size;
    L17:
        Long r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.parseExtra;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.fileName;
    }

    public final String component2() {
        return this.md5;
    }

    public final String component3() {
        return this.identifier;
    }

    public final String component4() {
        return this.url;
    }

    public final Long component5() {
        return this.size;
    }

    public final String component6() {
        return this.parseExtra;
    }

    public final FileResourceMeta copy(String r9, String r10, String r11, String r12, Long r13, String r14) {
        return new FileResourceMeta(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FileResourceMeta) == true) goto L8;
        return false;
    L8:
        FileResourceMeta r6 = (FileResourceMeta) r5;
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.md5, r6.md5) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.identifier, r6.identifier) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.size, r6.size) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.parseExtra, r6.parseExtra) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.fileName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.md5;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.identifier;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.url;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.size;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.parseExtra;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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
        return "FileResourceMeta(fileName=" + this.fileName + ", md5=" + this.md5 + ", identifier=" + this.identifier + ", url=" + this.url + ", size=" + this.size + ", parseExtra=" + this.parseExtra + ')';
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getParseExtra() {
        return this.parseExtra;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public FileResourceMeta(String r1, String r2, String r3, String r4, Long r5, String r6) {
        this.fileName = r1;
        this.md5 = r2;
        this.identifier = r3;
        this.url = r4;
        this.size = r5;
        this.parseExtra = r6;
    }

    public /* synthetic */ FileResourceMeta(String r6, String r7, String r8, String r9, Long r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        r10 = 0L;
    L21:
        Long r4 = r10;
        if ((r12 & 32) == 0) goto L24;
        String r15 = null;
    L25:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L24:
        r15 = r11;
        goto L25
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
