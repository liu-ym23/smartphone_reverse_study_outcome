package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaRequest;", "Ljava/io/Serializable;", "appKeys", "", "", "<init>", "(Ljava/util/List;)V", "getAppKeys", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatchGetAppMetaRequest implements Serializable {

    @SerializedName("app_keys")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> appKeys;

    public BatchGetAppMetaRequest() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchGetAppMetaRequest copy$default(BatchGetAppMetaRequest r0, List r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r1 = r0.appKeys;
    L6:
        return r0.copy(r1);
    }

    public final List<String> component1() {
        return this.appKeys;
    }

    public final BatchGetAppMetaRequest copy(List<String> r10) {
        return new BatchGetAppMetaRequest(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BatchGetAppMetaRequest) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.appKeys, ((BatchGetAppMetaRequest) r10).appKeys) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.appKeys;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "BatchGetAppMetaRequest(appKeys=" + this.appKeys + ')';
    }

    public final List<String> getAppKeys() {
        return this.appKeys;
    }

    public BatchGetAppMetaRequest(List<String> r1) {
        this.appKeys = r1;
    }

    public /* synthetic */ BatchGetAppMetaRequest(List r1, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        this(r1);
    }
}
