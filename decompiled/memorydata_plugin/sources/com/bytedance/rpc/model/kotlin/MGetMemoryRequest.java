package com.bytedance.rpc.model.kotlin;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/MGetMemoryRequest;", "Ljava/io/Serializable;", "userParams", "Lcom/bytedance/rpc/model/kotlin/UserParams;", "definedFeatureKeys", "", "Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;", "queryWords", "", "enableAnn", "", "(Lcom/bytedance/rpc/model/kotlin/UserParams;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getDefinedFeatureKeys", "()Ljava/util/List;", "setDefinedFeatureKeys", "(Ljava/util/List;)V", "getEnableAnn", "()Ljava/lang/Boolean;", "setEnableAnn", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQueryWords", "setQueryWords", "getUserParams", "()Lcom/bytedance/rpc/model/kotlin/UserParams;", "setUserParams", "(Lcom/bytedance/rpc/model/kotlin/UserParams;)V", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/rpc/model/kotlin/UserParams;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Lcom/bytedance/rpc/model/kotlin/MGetMemoryRequest;", "equals", "other", "", "hashCode", "", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class MGetMemoryRequest implements Serializable {

    @SerializedName("defined_feature_keys")
    private List<? extends DefinedMemoryKey> definedFeatureKeys;

    @SerializedName("enable_ann")
    private Boolean enableAnn;

    @SerializedName("query_words")
    private List<String> queryWords;

    @SerializedName("user_params")
    private UserParams userParams;

    public MGetMemoryRequest() {
        this(null, null, null, null, 15, null);
    }

    public MGetMemoryRequest(UserParams r3, List<? extends DefinedMemoryKey> r4, List<String> r5, Boolean r6) {
        List<? extends DefinedMemoryKey> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.userParams = r3;
        this.definedFeatureKeys = r7;
        this.queryWords = r8;
        this.enableAnn = r6;
    }

    public /* synthetic */ MGetMemoryRequest(UserParams r3, List r4, List r5, Boolean r6, int r7, DefaultConstructorMarker r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r7 & 1) == 0) goto L6;
        r3 = (UserParams) ZeusTransformUtils.preCheckCast(null, UserParams.class, "com.obric.memorydata.plugin");
    L6:
        if ((r7 & 2) == 0) goto L9;
        r9 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
    L9:
        if ((r7 & 4) == 0) goto L12;
        r10 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = (Boolean) ZeusTransformUtils.preCheckCast(null, Boolean.class, "com.obric.memorydata.plugin");
    L14:
        this(r3, r9, r10, r6);
    }

    public static /* synthetic */ MGetMemoryRequest copy$default(MGetMemoryRequest r1, UserParams r2, List r3, List r4, Boolean r5, int r6, Object r7) {
        List<? extends DefinedMemoryKey> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.userParams;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.definedFeatureKeys;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = r1.queryWords;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.enableAnn;
    L15:
        return r1.copy(r2, r8, r9, r5);
    }

    public final UserParams component1() {
        return this.userParams;
    }

    public final List<DefinedMemoryKey> component2() {
        return this.definedFeatureKeys;
    }

    public final List<String> component3() {
        return this.queryWords;
    }

    public final Boolean component4() {
        return this.enableAnn;
    }

    public final MGetMemoryRequest copy(UserParams r2, List<? extends DefinedMemoryKey> r3, List<String> r4, Boolean r5) {
        return new MGetMemoryRequest(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, MGetMemoryRequest.class) == false) goto L15;
        MGetMemoryRequest r4 = (MGetMemoryRequest) ZeusTransformUtils.preCheckCast(r3, MGetMemoryRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.userParams, r4.userParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.definedFeatureKeys, r4.definedFeatureKeys) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.queryWords, r4.queryWords) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.enableAnn, r4.enableAnn) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        return false;
    }

    public final List<DefinedMemoryKey> getDefinedFeatureKeys() {
        return this.definedFeatureKeys;
    }

    public final Boolean getEnableAnn() {
        return this.enableAnn;
    }

    public final List<String> getQueryWords() {
        return this.queryWords;
    }

    public final UserParams getUserParams() {
        return this.userParams;
    }

    public int hashCode() {
        UserParams r0 = this.userParams;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<? extends DefinedMemoryKey> r4 = this.definedFeatureKeys;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.queryWords;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.enableAnn;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void setDefinedFeatureKeys(List<? extends DefinedMemoryKey> r3) {
        this.definedFeatureKeys = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setEnableAnn(Boolean r1) {
        this.enableAnn = r1;
    }

    public final void setQueryWords(List<String> r3) {
        this.queryWords = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setUserParams(UserParams r1) {
        this.userParams = r1;
    }

    public String toString() {
        return "MGetMemoryRequest(userParams=" + this.userParams + ", definedFeatureKeys=" + this.definedFeatureKeys + ", queryWords=" + this.queryWords + ", enableAnn=" + this.enableAnn + ")";
    }
}
