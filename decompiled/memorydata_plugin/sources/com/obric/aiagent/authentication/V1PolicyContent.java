package com.obric.aiagent.authentication;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/authentication/V1PolicyContent;", "", EventBody.KEY_CATEGORY, "", "policies", "", "Lcom/obric/aiagent/authentication/ProcessPolicies;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getCategory", "()Ljava/lang/String;", "getPolicies", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class V1PolicyContent {
    private final String category;
    private final List<ProcessPolicies> policies;

    public V1PolicyContent(String r3, List<ProcessPolicies> r4) {
        List<ProcessPolicies> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.category = r3;
        this.policies = r5;
    }

    public static /* synthetic */ V1PolicyContent copy$default(V1PolicyContent r1, String r2, List r3, int r4, Object r5) {
        List<ProcessPolicies> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.category;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.policies;
    L9:
        return r1.copy(r2, r6);
    }

    public final String component1() {
        return this.category;
    }

    public final List<ProcessPolicies> component2() {
        return this.policies;
    }

    public final V1PolicyContent copy(String r2, List<ProcessPolicies> r3) {
        return new V1PolicyContent(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, V1PolicyContent.class) == true) goto L8;
        return false;
    L8:
        V1PolicyContent r6 = (V1PolicyContent) ZeusTransformUtils.preCheckCast(r5, V1PolicyContent.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.category, r6.category) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.policies, r6.policies) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getCategory() {
        return this.category;
    }

    public final List<ProcessPolicies> getPolicies() {
        return this.policies;
    }

    public int hashCode() {
        String r0 = this.category;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<ProcessPolicies> r4 = this.policies;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "V1PolicyContent(category=" + this.category + ", policies=" + this.policies + ')';
    }
}
