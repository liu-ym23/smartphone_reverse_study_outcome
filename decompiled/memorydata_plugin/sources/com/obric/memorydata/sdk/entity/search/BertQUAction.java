package com.obric.memorydata.sdk.entity.search;

import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/BertQUAction;", "", "actionName", "", ChatMessage.TYPE_QUERY, "inputParams", "", "Lcom/obric/memorydata/sdk/entity/search/ParamItem;", "isStandardQuery", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "getActionName", "()Ljava/lang/String;", "getQuery", "getInputParams", "()Ljava/util/Map;", "()Z", "setStandardQuery", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BertQUAction {
    private final String actionName;
    private final Map<String, ParamItem> inputParams;
    private boolean isStandardQuery;
    private final String query;

    public BertQUAction(String r3, String r4, Map<String, ParamItem> r5, boolean r6) {
        Map<String, ParamItem> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "actionName");
        Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_QUERY);
        this.actionName = r3;
        this.query = r4;
        this.inputParams = r7;
        this.isStandardQuery = r6;
    }

    public static /* synthetic */ BertQUAction copy$default(BertQUAction r1, String r2, String r3, Map r4, boolean r5, int r6, Object r7) {
        Map<String, ParamItem> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.actionName;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.query;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.inputParams;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.isStandardQuery;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final String component1() {
        return this.actionName;
    }

    public final String component2() {
        return this.query;
    }

    public final Map<String, ParamItem> component3() {
        return this.inputParams;
    }

    public final boolean component4() {
        return this.isStandardQuery;
    }

    public final BertQUAction copy(String r2, String r3, Map<String, ParamItem> r4, boolean r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        return new BertQUAction(r2, r3, r1, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BertQUAction.class) == true) goto L8;
        return false;
    L8:
        BertQUAction r6 = (BertQUAction) ZeusTransformUtils.preCheckCast(r5, BertQUAction.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.actionName, r6.actionName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputParams, r6.inputParams) == true) goto L18;
        return false;
    L18:
        if (this.isStandardQuery == r6.isStandardQuery) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final Map<String, ParamItem> getInputParams() {
        return this.inputParams;
    }

    public final String getQuery() {
        return this.query;
    }

    public int hashCode() {
        int r0 = ((this.actionName.hashCode() * 31) + this.query.hashCode()) * 31;
        Map<String, ParamItem> r1 = this.inputParams;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.isStandardQuery);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final boolean isStandardQuery() {
        return this.isStandardQuery;
    }

    public final void setStandardQuery(boolean r1) {
        this.isStandardQuery = r1;
    }

    public String toString() {
        return "BertQUAction(actionName=" + this.actionName + ", query=" + this.query + ", inputParams=" + this.inputParams + ", isStandardQuery=" + this.isStandardQuery + ')';
    }
}
