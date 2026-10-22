package com.larus.platform.api.fileselect;

import com.google.gson.Gson;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/larus/platform/api/fileselect/DriveUplinkInfo;", "Ljava/io/Serializable;", "url", "", "fileToken", "fileName", "fileType", "", "ccmType", "uplinkWay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getFileToken", "getFileName", "getFileType", "()I", "getCcmType", "getUplinkWay", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DriveUplinkInfo implements Serializable {
    private final int ccmType;
    private final String fileName;
    private final String fileToken;
    private final int fileType;
    private final String uplinkWay;
    private final String url;

    public DriveUplinkInfo() {
        this(null, null, null, 0, 0, null, 63, null);
    }

    public static /* synthetic */ DriveUplinkInfo copy$default(DriveUplinkInfo r4, String r5, String r6, String r7, int r8, int r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.url;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.fileToken;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.fileName;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.fileType;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.ccmType;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.uplinkWay;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.fileToken;
    }

    public final String component3() {
        return this.fileName;
    }

    public final int component4() {
        return this.fileType;
    }

    public final int component5() {
        return this.ccmType;
    }

    public final String component6() {
        return this.uplinkWay;
    }

    public final DriveUplinkInfo copy(String r9, String r10, String r11, int r12, int r13, String r14) {
        return new DriveUplinkInfo(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DriveUplinkInfo) == true) goto L8;
        return false;
    L8:
        DriveUplinkInfo r6 = (DriveUplinkInfo) r5;
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileToken, r6.fileToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L18;
        return false;
    L18:
        if (this.fileType == r6.fileType) goto L21;
        return false;
    L21:
        if (this.ccmType == r6.ccmType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.uplinkWay, r6.uplinkWay) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.fileToken;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.fileName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((r6 + r8) * 31) + this.fileType) * 31) + this.ccmType) * 31;
        String r10 = this.uplinkWay;
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
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L15;
        return "";
    L15:
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final int getCcmType() {
        return this.ccmType;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final String getUplinkWay() {
        return this.uplinkWay;
    }

    public final String getUrl() {
        return this.url;
    }

    public DriveUplinkInfo(String r1, String r2, String r3, int r4, int r5, String r6) {
        this.url = r1;
        this.fileToken = r2;
        this.fileName = r3;
        this.fileType = r4;
        this.ccmType = r5;
        this.uplinkWay = r6;
    }

    public /* synthetic */ DriveUplinkInfo(String r6, String r7, String r8, int r9, int r10, String r11, int r12, DefaultConstructorMarker r13) {
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
        int r3 = 0;
    L19:
        if ((r12 & 16) == 0) goto L21;
        int r4 = 12;
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
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
