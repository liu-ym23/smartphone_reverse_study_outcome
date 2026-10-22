package com.ss.android.lark.chameleonv2.lkapi.resource;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Ipc$ResourceUploadProgressPayload;", "Lcom/bytedance/ee/util/io/NonProguard;", "progress", BuildConfig.FLAVOR, "uploadId", BuildConfig.FLAVOR, "rate", "status", "token", "<init>", "(Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProgress", "()Ljava/lang/Number;", "getUploadId", "()Ljava/lang/String;", "getRate", "getStatus", "getToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IResource$Ipc$ResourceUploadProgressPayload implements NonProguard {
    private final Number progress;
    private final String rate;
    private final String status;
    private final String token;
    private final String uploadId;

    public static /* synthetic */ IResource$Ipc$ResourceUploadProgressPayload copy$default(IResource$Ipc$ResourceUploadProgressPayload r3, Number r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.progress;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.uploadId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.rate;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.status;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.token;
    L17:
        Number r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Number component1() {
        return this.progress;
    }

    public final String component2() {
        return this.uploadId;
    }

    public final String component3() {
        return this.rate;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.token;
    }

    public final IResource$Ipc$ResourceUploadProgressPayload copy(Number r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "progress");
        Intrinsics.checkNotNullParameter(r9, "uploadId");
        Intrinsics.checkNotNullParameter(r11, "status");
        Intrinsics.checkNotNullParameter(r12, "token");
        return new IResource$Ipc$ResourceUploadProgressPayload(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IResource$Ipc$ResourceUploadProgressPayload) == true) goto L8;
        return false;
    L8:
        IResource$Ipc$ResourceUploadProgressPayload r6 = (IResource$Ipc$ResourceUploadProgressPayload) r5;
        if (Intrinsics.areEqual(this.progress, r6.progress) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadId, r6.uploadId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rate, r6.rate) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.progress.hashCode() * 31) + this.uploadId.hashCode()) * 31;
        String r1 = this.rate;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.status.hashCode()) * 31) + this.token.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ResourceUploadProgressPayload(progress=" + this.progress + ", uploadId=" + this.uploadId + ", rate=" + this.rate + ", status=" + this.status + ", token=" + this.token + ')';
    }

    public final Number getProgress() {
        return this.progress;
    }

    public final String getRate() {
        return this.rate;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    public IResource$Ipc$ResourceUploadProgressPayload(Number r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "progress");
        Intrinsics.checkNotNullParameter(r3, "uploadId");
        Intrinsics.checkNotNullParameter(r5, "status");
        Intrinsics.checkNotNullParameter(r6, "token");
        this.progress = r2;
        this.uploadId = r3;
        this.rate = r4;
        this.status = r5;
        this.token = r6;
    }
}
