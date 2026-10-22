package com.larus.bmhome.rc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mr9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/rc/PrepareUploadResult;", "", "resourceUploadToken", "Lcom/larus/platform/model/upload/ResourceUploadToken;", "failReason", "", "<init>", "(Lcom/larus/platform/model/upload/ResourceUploadToken;Ljava/lang/String;)V", "getResourceUploadToken", "()Lcom/larus/platform/model/upload/ResourceUploadToken;", "getFailReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrepareUploadResult {
    private final String failReason;
    private final m resourceUploadToken;

    public PrepareUploadResult() {
        m r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ PrepareUploadResult copy$default(PrepareUploadResult r0, m r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.resourceUploadToken;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.failReason;
    L9:
        return r0.copy(r1, r2);
    }

    public final m component1() {
        return this.resourceUploadToken;
    }

    public final String component2() {
        return this.failReason;
    }

    public final PrepareUploadResult copy(m r2, String r3) {
        return new PrepareUploadResult(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PrepareUploadResult) == true) goto L8;
        return false;
    L8:
        PrepareUploadResult r6 = (PrepareUploadResult) r5;
        if (Intrinsics.areEqual(this.resourceUploadToken, r6.resourceUploadToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.failReason, r6.failReason) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        m r0 = this.resourceUploadToken;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.failReason;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PrepareUploadResult(resourceUploadToken=" + this.resourceUploadToken + ", failReason=" + this.failReason + ')';
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final m getResourceUploadToken() {
        return this.resourceUploadToken;
    }

    public PrepareUploadResult(m r1, String r2) {
        this.resourceUploadToken = r1;
        this.failReason = r2;
    }

    public /* synthetic */ PrepareUploadResult(m r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
