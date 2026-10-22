package com.larus.platform.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007HÆ\u0003Jp\u0010\u0019\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/platform/api/FirstFramePreloadVideoData;", "Ljava/io/Serializable;", "preLoadFirstRequestItemIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "preLoadFirstRequestItemIdToRequestIdMap", "", "innerLoadMoreRequestFromSecondRun", "", "preLoadFirstRequestItemIdToChannelIdMap", "<init>", "(Ljava/util/ArrayList;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Map;)V", "getPreLoadFirstRequestItemIdList", "()Ljava/util/ArrayList;", "getPreLoadFirstRequestItemIdToRequestIdMap", "()Ljava/util/Map;", "getInnerLoadMoreRequestFromSecondRun", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPreLoadFirstRequestItemIdToChannelIdMap", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/ArrayList;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/larus/platform/api/FirstFramePreloadVideoData;", "equals", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FirstFramePreloadVideoData implements Serializable {

    @SerializedName("innerLoadMoreRequestFromSecondRun")
    private final Boolean innerLoadMoreRequestFromSecondRun;

    @SerializedName("preLoadFirstRequestItemIdList")
    private final ArrayList<String> preLoadFirstRequestItemIdList;

    @SerializedName("preLoadFirstRequestItemIdToChannelIdMap")
    private final Map<String, String> preLoadFirstRequestItemIdToChannelIdMap;

    @SerializedName("preLoadFirstRequestItemIdToRequestIdMap")
    private final Map<String, String> preLoadFirstRequestItemIdToRequestIdMap;

    public FirstFramePreloadVideoData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirstFramePreloadVideoData copy$default(FirstFramePreloadVideoData r0, ArrayList r1, Map r2, Boolean r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.preLoadFirstRequestItemIdList;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.preLoadFirstRequestItemIdToRequestIdMap;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.innerLoadMoreRequestFromSecondRun;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.preLoadFirstRequestItemIdToChannelIdMap;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final ArrayList<String> component1() {
        return this.preLoadFirstRequestItemIdList;
    }

    public final Map<String, String> component2() {
        return this.preLoadFirstRequestItemIdToRequestIdMap;
    }

    public final Boolean component3() {
        return this.innerLoadMoreRequestFromSecondRun;
    }

    public final Map<String, String> component4() {
        return this.preLoadFirstRequestItemIdToChannelIdMap;
    }

    public final FirstFramePreloadVideoData copy(ArrayList<String> r2, Map<String, String> r3, Boolean r4, Map<String, String> r5) {
        return new FirstFramePreloadVideoData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FirstFramePreloadVideoData) == true) goto L8;
        return false;
    L8:
        FirstFramePreloadVideoData r6 = (FirstFramePreloadVideoData) r5;
        if (Intrinsics.areEqual(this.preLoadFirstRequestItemIdList, r6.preLoadFirstRequestItemIdList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preLoadFirstRequestItemIdToRequestIdMap, r6.preLoadFirstRequestItemIdToRequestIdMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.innerLoadMoreRequestFromSecondRun, r6.innerLoadMoreRequestFromSecondRun) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preLoadFirstRequestItemIdToChannelIdMap, r6.preLoadFirstRequestItemIdToChannelIdMap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        ArrayList<String> r0 = this.preLoadFirstRequestItemIdList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.preLoadFirstRequestItemIdToRequestIdMap;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.innerLoadMoreRequestFromSecondRun;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.preLoadFirstRequestItemIdToChannelIdMap;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "FirstFramePreloadVideoData(preLoadFirstRequestItemIdList=" + this.preLoadFirstRequestItemIdList + ", preLoadFirstRequestItemIdToRequestIdMap=" + this.preLoadFirstRequestItemIdToRequestIdMap + ", innerLoadMoreRequestFromSecondRun=" + this.innerLoadMoreRequestFromSecondRun + ", preLoadFirstRequestItemIdToChannelIdMap=" + this.preLoadFirstRequestItemIdToChannelIdMap + ')';
    }

    public final Boolean getInnerLoadMoreRequestFromSecondRun() {
        return this.innerLoadMoreRequestFromSecondRun;
    }

    public final ArrayList<String> getPreLoadFirstRequestItemIdList() {
        return this.preLoadFirstRequestItemIdList;
    }

    public final Map<String, String> getPreLoadFirstRequestItemIdToChannelIdMap() {
        return this.preLoadFirstRequestItemIdToChannelIdMap;
    }

    public final Map<String, String> getPreLoadFirstRequestItemIdToRequestIdMap() {
        return this.preLoadFirstRequestItemIdToRequestIdMap;
    }

    public FirstFramePreloadVideoData(ArrayList<String> r1, Map<String, String> r2, Boolean r3, Map<String, String> r4) {
        this.preLoadFirstRequestItemIdList = r1;
        this.preLoadFirstRequestItemIdToRequestIdMap = r2;
        this.innerLoadMoreRequestFromSecondRun = r3;
        this.preLoadFirstRequestItemIdToChannelIdMap = r4;
    }

    public /* synthetic */ FirstFramePreloadVideoData(ArrayList r2, Map r3, Boolean r4, Map r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
