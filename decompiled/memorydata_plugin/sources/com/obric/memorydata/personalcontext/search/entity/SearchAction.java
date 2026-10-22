package com.obric.memorydata.personalcontext.search.entity;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.sdk.entity.search.ParamItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/SearchAction;", "", "actionName", "", "inputParams", "", "Lcom/obric/memorydata/sdk/entity/search/ParamItem;", "actionId", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;I)V", "getActionName", "()Ljava/lang/String;", "getInputParams", "()Ljava/util/Map;", "getActionId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchAction {

    @SerializedName("actionId")
    private final int actionId;

    @SerializedName("actionName")
    private final String actionName;

    @SerializedName("inputParams")
    private final Map<String, ParamItem> inputParams;

    public SearchAction(String r3, Map<String, ParamItem> r4, int r5) {
        Map<String, ParamItem> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "actionName");
        Intrinsics.checkNotNullParameter(r6, "inputParams");
        this.actionName = r3;
        this.inputParams = r6;
        this.actionId = r5;
    }

    public /* synthetic */ SearchAction(String r2, Map r3, int r4, int r5, DefaultConstructorMarker r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = -1;
    L5:
        this(r2, r7, r4);
    }

    public static /* synthetic */ SearchAction copy$default(SearchAction r1, String r2, Map r3, int r4, int r5, Object r6) {
        Map<String, ParamItem> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.actionName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.inputParams;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.actionId;
    L12:
        return r1.copy(r2, r7, r4);
    }

    public final String component1() {
        return this.actionName;
    }

    public final Map<String, ParamItem> component2() {
        return this.inputParams;
    }

    public final int component3() {
        return this.actionId;
    }

    public final SearchAction copy(String r2, Map<String, ParamItem> r3, int r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r1, "inputParams");
        return new SearchAction(r2, r1, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SearchAction.class) == true) goto L8;
        return false;
    L8:
        SearchAction r6 = (SearchAction) ZeusTransformUtils.preCheckCast(r5, SearchAction.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.actionName, r6.actionName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inputParams, r6.inputParams) == true) goto L15;
        return false;
    L15:
        if (this.actionId == r6.actionId) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final Map<String, ParamItem> getInputParams() {
        return this.inputParams;
    }

    public int hashCode() {
        return (((this.actionName.hashCode() * 31) + this.inputParams.hashCode()) * 31) + Integer.hashCode(this.actionId);
    }

    public String toString() {
        return "SearchAction(actionName=" + this.actionName + ", inputParams=" + this.inputParams + ", actionId=" + this.actionId + ')';
    }
}
