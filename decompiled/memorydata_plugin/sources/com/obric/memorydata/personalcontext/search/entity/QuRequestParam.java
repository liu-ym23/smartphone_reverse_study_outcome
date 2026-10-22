package com.obric.memorydata.personalcontext.search.entity;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.sdk.entity.search.RewriteQuery;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/QuRequestParam;", "", "quRequest", "", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "<init>", "(Ljava/util/List;)V", "getQuRequest", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QuRequestParam {

    @SerializedName("qu_request")
    private final List<RewriteQuery> quRequest;

    public QuRequestParam(List<RewriteQuery> r3) {
        List<RewriteQuery> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "quRequest");
        this.quRequest = r4;
    }

    public static /* synthetic */ QuRequestParam copy$default(QuRequestParam r1, List r2, int r3, Object r4) {
        List<RewriteQuery> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.quRequest;
    L6:
        return r1.copy(r5);
    }

    public final List<RewriteQuery> component1() {
        return this.quRequest;
    }

    public final QuRequestParam copy(List<RewriteQuery> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "quRequest");
        return new QuRequestParam(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, QuRequestParam.class) == true) goto L8;
        return false;
    L8:
        QuRequestParam r6 = (QuRequestParam) ZeusTransformUtils.preCheckCast(r5, QuRequestParam.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.quRequest, r6.quRequest) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final List<RewriteQuery> getQuRequest() {
        return this.quRequest;
    }

    public int hashCode() {
        return this.quRequest.hashCode();
    }

    public String toString() {
        return "QuRequestParam(quRequest=" + this.quRequest + ')';
    }
}
