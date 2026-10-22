package com.larus.platform.model.upload;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\tHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;", "Ljava/io/Serializable;", "preQueryHit", "", "fingerprintMeta", "Lcom/larus/platform/model/upload/ResourceUploadFingerprintMeta;", "targetMeta", "Lcom/larus/platform/model/upload/ResourceUploadTargetMeta;", "registerUri", "", "<init>", "(Ljava/lang/Boolean;Lcom/larus/platform/model/upload/ResourceUploadFingerprintMeta;Lcom/larus/platform/model/upload/ResourceUploadTargetMeta;Ljava/lang/String;)V", "getPreQueryHit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFingerprintMeta", "()Lcom/larus/platform/model/upload/ResourceUploadFingerprintMeta;", "getTargetMeta", "()Lcom/larus/platform/model/upload/ResourceUploadTargetMeta;", "getRegisterUri", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Lcom/larus/platform/model/upload/ResourceUploadFingerprintMeta;Lcom/larus/platform/model/upload/ResourceUploadTargetMeta;Ljava/lang/String;)Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;", "equals", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ResourceUploadInstantInfo implements Serializable {
    private final ResourceUploadFingerprintMeta fingerprintMeta;
    private final Boolean preQueryHit;
    private final String registerUri;
    private final ResourceUploadTargetMeta targetMeta;

    public ResourceUploadInstantInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResourceUploadInstantInfo copy$default(ResourceUploadInstantInfo r0, Boolean r1, ResourceUploadFingerprintMeta r2, ResourceUploadTargetMeta r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.preQueryHit;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.fingerprintMeta;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.targetMeta;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.registerUri;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Boolean component1() {
        return this.preQueryHit;
    }

    public final ResourceUploadFingerprintMeta component2() {
        return this.fingerprintMeta;
    }

    public final ResourceUploadTargetMeta component3() {
        return this.targetMeta;
    }

    public final String component4() {
        return this.registerUri;
    }

    public final ResourceUploadInstantInfo copy(Boolean r2, ResourceUploadFingerprintMeta r3, ResourceUploadTargetMeta r4, String r5) {
        return new ResourceUploadInstantInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceUploadInstantInfo) == true) goto L8;
        return false;
    L8:
        ResourceUploadInstantInfo r6 = (ResourceUploadInstantInfo) r5;
        if (Intrinsics.areEqual(this.preQueryHit, r6.preQueryHit) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fingerprintMeta, r6.fingerprintMeta) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.targetMeta, r6.targetMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.registerUri, r6.registerUri) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.preQueryHit;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ResourceUploadFingerprintMeta r4 = this.fingerprintMeta;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ResourceUploadTargetMeta r7 = this.targetMeta;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.registerUri;
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
        return "ResourceUploadInstantInfo(preQueryHit=" + this.preQueryHit + ", fingerprintMeta=" + this.fingerprintMeta + ", targetMeta=" + this.targetMeta + ", registerUri=" + this.registerUri + ')';
    }

    public final ResourceUploadFingerprintMeta getFingerprintMeta() {
        return this.fingerprintMeta;
    }

    public final Boolean getPreQueryHit() {
        return this.preQueryHit;
    }

    public final String getRegisterUri() {
        return this.registerUri;
    }

    public final ResourceUploadTargetMeta getTargetMeta() {
        return this.targetMeta;
    }

    public ResourceUploadInstantInfo(Boolean r1, ResourceUploadFingerprintMeta r2, ResourceUploadTargetMeta r3, String r4) {
        this.preQueryHit = r1;
        this.fingerprintMeta = r2;
        this.targetMeta = r3;
        this.registerUri = r4;
    }

    public /* synthetic */ ResourceUploadInstantInfo(Boolean r2, ResourceUploadFingerprintMeta r3, ResourceUploadTargetMeta r4, String r5, int r6, DefaultConstructorMarker r7) {
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
