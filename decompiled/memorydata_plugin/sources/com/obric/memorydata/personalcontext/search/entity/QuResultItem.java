package com.obric.memorydata.personalcontext.search.entity;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/QuResultItem;", "", "actionName", "", "isStandardQuery", "", "inputParams", "", "Lcom/obric/memorydata/personalcontext/search/entity/ValueWrapper;", "<init>", "(Ljava/lang/String;ZLjava/util/Map;)V", "getActionName", "()Ljava/lang/String;", "()Z", "getInputParams", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QuResultItem {

    @SerializedName("actionName")
    private final String actionName;

    @SerializedName("inputParams")
    private final Map<String, ValueWrapper> inputParams;

    @SerializedName("isStandardQuery")
    private final boolean isStandardQuery;

    public QuResultItem(String r3, boolean r4, Map<String, ValueWrapper> r5) {
        Map<String, ValueWrapper> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "actionName");
        this.actionName = r3;
        this.isStandardQuery = r4;
        this.inputParams = r6;
    }

    public static /* synthetic */ QuResultItem copy$default(QuResultItem r1, String r2, boolean r3, Map r4, int r5, Object r6) {
        Map<String, ValueWrapper> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.actionName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.isStandardQuery;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r7 = r1.inputParams;
    L12:
        return r1.copy(r2, r3, r7);
    }

    public final String component1() {
        return this.actionName;
    }

    public final boolean component2() {
        return this.isStandardQuery;
    }

    public final Map<String, ValueWrapper> component3() {
        return this.inputParams;
    }

    public final QuResultItem copy(String r2, boolean r3, Map<String, ValueWrapper> r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "actionName");
        return new QuResultItem(r2, r3, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, QuResultItem.class) == true) goto L8;
        return false;
    L8:
        QuResultItem r6 = (QuResultItem) ZeusTransformUtils.preCheckCast(r5, QuResultItem.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.actionName, r6.actionName) == true) goto L12;
        return false;
    L12:
        if (this.isStandardQuery == r6.isStandardQuery) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputParams, r6.inputParams) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final Map<String, ValueWrapper> getInputParams() {
        return this.inputParams;
    }

    public int hashCode() {
        int r0 = ((this.actionName.hashCode() * 31) + Boolean.hashCode(this.isStandardQuery)) * 31;
        Map<String, ValueWrapper> r2 = this.inputParams;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final boolean isStandardQuery() {
        return this.isStandardQuery;
    }

    public String toString() {
        return "QuResultItem(actionName=" + this.actionName + ", isStandardQuery=" + this.isStandardQuery + ", inputParams=" + this.inputParams + ')';
    }
}
