package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0010\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/rc/ResourceSignUrlRequestV2;", "", "params", "", "Lcom/larus/bmhome/rc/ResourceSignUrlParamV2;", "encrypted", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getParams", "()Ljava/util/List;", "getEncrypted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/bmhome/rc/ResourceSignUrlRequestV2;", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceSignUrlRequestV2 {

    @SerializedName("encrypted")
    private final Boolean encrypted;

    @SerializedName("params")
    private final List<ResourceSignUrlParamV2> params;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceSignUrlRequestV2() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceSignUrlRequestV2 copy$default(ResourceSignUrlRequestV2 r0, List r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.params;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.encrypted;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<ResourceSignUrlParamV2> component1() {
        return this.params;
    }

    public final Boolean component2() {
        return this.encrypted;
    }

    public final ResourceSignUrlRequestV2 copy(List<ResourceSignUrlParamV2> r2, Boolean r3) {
        return new ResourceSignUrlRequestV2(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceSignUrlRequestV2) == true) goto L8;
        return false;
    L8:
        ResourceSignUrlRequestV2 r6 = (ResourceSignUrlRequestV2) r5;
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.encrypted, r6.encrypted) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<ResourceSignUrlParamV2> r0 = this.params;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.encrypted;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ResourceSignUrlRequestV2(params=" + this.params + ", encrypted=" + this.encrypted + ')';
    }

    public final Boolean getEncrypted() {
        return this.encrypted;
    }

    public final List<ResourceSignUrlParamV2> getParams() {
        return this.params;
    }

    public ResourceSignUrlRequestV2(List<ResourceSignUrlParamV2> r1, Boolean r2) {
        this.params = r1;
        this.encrypted = r2;
    }

    public /* synthetic */ ResourceSignUrlRequestV2(List r1, Boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Boolean.TRUE;
    L8:
        this(r1, r2);
    }
}
