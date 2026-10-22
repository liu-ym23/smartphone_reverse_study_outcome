package com.obric.memorydata.personalcontext.search.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/SearchResultEntry;", "", "type", "", OaidModel.KEY_ID, "", "inAppSearchParams", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "actionId", "<init>", "(IJLjava/util/List;I)V", "getType", "()I", "getId", "()J", "getInAppSearchParams", "()Ljava/util/List;", "getActionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchResultEntry {

    @SerializedName("actionId")
    private final int actionId;

    @SerializedName(OaidModel.KEY_ID)
    private final long id;

    @SerializedName("inAppSearchParams")
    private final List<InAppSearchEntityParam> inAppSearchParams;

    @SerializedName("type")
    private final int type;

    public SearchResultEntry(int r3, long r4, List<InAppSearchEntityParam> r6, int r7) {
        List<InAppSearchEntityParam> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "inAppSearchParams");
        this.type = r3;
        this.id = r4;
        this.inAppSearchParams = r8;
        this.actionId = r7;
    }

    public /* synthetic */ SearchResultEntry(int r7, long r8, List r10, int r11, int r12, DefaultConstructorMarker r13) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 8) == 0) goto L5;
        r11 = -1;
    L5:
        this(r7, r8, r4, r11);
    }

    public static /* synthetic */ SearchResultEntry copy$default(SearchResultEntry r6, int r7, long r8, List r10, int r11, int r12, Object r13) {
        List<InAppSearchEntityParam> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.type;
    L5:
        int r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.id;
    L8:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r14 = r6.inAppSearchParams;
    L11:
        List<InAppSearchEntityParam> r4 = r14;
        if ((r12 & 8) == 0) goto L15;
        r11 = r6.actionId;
    L15:
        return r6.copy(r1, r2, r4, r11);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.id;
    }

    public final List<InAppSearchEntityParam> component3() {
        return this.inAppSearchParams;
    }

    public final int component4() {
        return this.actionId;
    }

    public final SearchResultEntry copy(int r7, long r8, List<InAppSearchEntityParam> r10, int r11) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "inAppSearchParams");
        return new SearchResultEntry(r7, r8, r4, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SearchResultEntry.class) == true) goto L8;
        return false;
    L8:
        SearchResultEntry r10 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r9, SearchResultEntry.class, "com.obric.memorydata.plugin");
        if (this.type == r10.type) goto L12;
        return false;
    L12:
        if (this.id == r10.id) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inAppSearchParams, r10.inAppSearchParams) == true) goto L18;
        return false;
    L18:
        if (this.actionId == r10.actionId) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final long getId() {
        return this.id;
    }

    public final List<InAppSearchEntityParam> getInAppSearchParams() {
        return this.inAppSearchParams;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.type) * 31) + Long.hashCode(this.id)) * 31) + this.inAppSearchParams.hashCode()) * 31) + Integer.hashCode(this.actionId);
    }

    public String toString() {
        return "SearchResultEntry(type=" + this.type + ", id=" + this.id + ", inAppSearchParams=" + this.inAppSearchParams + ", actionId=" + this.actionId + ')';
    }
}
