package com.obric.memorydata.union.build;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/union/build/SemanticBuildResultItemV2;", "", "code", "", "message", "newEntityId", "oldEntityIdList", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCode", "()Ljava/lang/String;", "getMessage", "getNewEntityId", "getOldEntityIdList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticBuildResultItemV2 {
    private final String code;
    private final String message;

    @SerializedName("new_entity_id")
    private final String newEntityId;

    @SerializedName("old_entity_id_list")
    private final List<String> oldEntityIdList;

    public SemanticBuildResultItemV2(String r3, String r4, String r5, List<String> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "code");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.code = r3;
        this.message = r4;
        this.newEntityId = r5;
        this.oldEntityIdList = r7;
    }

    public /* synthetic */ SemanticBuildResultItemV2(String r2, String r3, String r4, List r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = null;
    L8:
        this(r2, r3, r4, r8);
    }

    public static /* synthetic */ SemanticBuildResultItemV2 copy$default(SemanticBuildResultItemV2 r1, String r2, String r3, String r4, List r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.code;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.message;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.newEntityId;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.oldEntityIdList;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.newEntityId;
    }

    public final List<String> component4() {
        return this.oldEntityIdList;
    }

    public final SemanticBuildResultItemV2 copy(String r2, String r3, String r4, List<String> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "code");
        Intrinsics.checkNotNullParameter(r3, "message");
        return new SemanticBuildResultItemV2(r2, r3, r4, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticBuildResultItemV2.class) == true) goto L8;
        return false;
    L8:
        SemanticBuildResultItemV2 r6 = (SemanticBuildResultItemV2) ZeusTransformUtils.preCheckCast(r5, SemanticBuildResultItemV2.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.code, r6.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.newEntityId, r6.newEntityId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.oldEntityIdList, r6.oldEntityIdList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getNewEntityId() {
        return this.newEntityId;
    }

    public final List<String> getOldEntityIdList() {
        return this.oldEntityIdList;
    }

    public int hashCode() {
        int r0 = ((this.code.hashCode() * 31) + this.message.hashCode()) * 31;
        String r1 = this.newEntityId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<String> r5 = this.oldEntityIdList;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SemanticBuildResultItemV2(code=" + this.code + ", message=" + this.message + ", newEntityId=" + this.newEntityId + ", oldEntityIdList=" + this.oldEntityIdList + ')';
    }
}
