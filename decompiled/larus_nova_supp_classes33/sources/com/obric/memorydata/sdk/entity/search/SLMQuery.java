package com.obric.memorydata.sdk.entity.search;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/SLMQuery;", "", "role", "", "content", "rewriteContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getContent", "getRewriteContent", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SLMQuery {

    @SerializedName("content")
    private final String content;

    @SerializedName("rewriteContent")
    private final String rewriteContent;

    @SerializedName("role")
    private final String role;

    public static /* synthetic */ SLMQuery copy$default(SLMQuery r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.role;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.rewriteContent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.role;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.rewriteContent;
    }

    public final SLMQuery copy(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "role");
        Intrinsics.checkNotNullParameter(r3, "content");
        return new SLMQuery(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SLMQuery) == true) goto L8;
        return false;
    L8:
        SLMQuery r6 = (SLMQuery) r5;
        if (Intrinsics.areEqual(this.role, r6.role) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rewriteContent, r6.rewriteContent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.role.hashCode() * 31) + this.content.hashCode()) * 31;
        String r1 = this.rewriteContent;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SLMQuery(role=" + this.role + ", content=" + this.content + ", rewriteContent=" + this.rewriteContent + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getRewriteContent() {
        return this.rewriteContent;
    }

    public final String getRole() {
        return this.role;
    }

    public SLMQuery(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "role");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.role = r2;
        this.content = r3;
        this.rewriteContent = r4;
    }
}
