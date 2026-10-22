package com.obric.memorydata.personalcontext.search.entity;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/SearchParamsAssistant;", "Lcom/obric/memorydata/personalcontext/search/entity/SearchParams;", "actions", "", "Lcom/obric/memorydata/personalcontext/search/entity/SearchAction;", "<init>", "(Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchParamsAssistant implements b {

    @SerializedName("actions")
    private final List<SearchAction> actions;

    public SearchParamsAssistant(List<SearchAction> r3) {
        List<SearchAction> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "actions");
        this.actions = r4;
    }

    public static /* synthetic */ SearchParamsAssistant copy$default(SearchParamsAssistant r1, List r2, int r3, Object r4) {
        List<SearchAction> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.actions;
    L6:
        return r1.copy(r5);
    }

    public final List<SearchAction> component1() {
        return this.actions;
    }

    public final SearchParamsAssistant copy(List<SearchAction> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "actions");
        return new SearchParamsAssistant(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SearchParamsAssistant.class) == true) goto L8;
        return false;
    L8:
        SearchParamsAssistant r6 = (SearchParamsAssistant) ZeusTransformUtils.preCheckCast(r5, SearchParamsAssistant.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final List<SearchAction> getActions() {
        return this.actions;
    }

    public int hashCode() {
        return this.actions.hashCode();
    }

    public String toString() {
        return "SearchParamsAssistant(actions=" + this.actions + ')';
    }
}
