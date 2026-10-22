package com.larus.bmhome.chat.markdown.ugc;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/markdown/ugc/MarkdownUgcExtraData;", "", "videoScene", "", "recommendTitle", "", "query", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reqId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getVideoScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRecommendTitle", "()Ljava/lang/String;", "getQuery", "()Ljava/util/ArrayList;", "getReqId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Lcom/larus/bmhome/chat/markdown/ugc/MarkdownUgcExtraData;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownUgcExtraData {

    @SerializedName("query")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final ArrayList<String> query;

    @SerializedName("recommend_title")
    private final String recommendTitle;

    @SerializedName("text_area_req_id")
    private final String reqId;

    @SerializedName("video_scene")
    private final Integer videoScene;

    public MarkdownUgcExtraData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarkdownUgcExtraData copy$default(MarkdownUgcExtraData r0, Integer r1, String r2, ArrayList r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.videoScene;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.recommendTitle;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.query;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.reqId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.videoScene;
    }

    public final String component2() {
        return this.recommendTitle;
    }

    public final ArrayList<String> component3() {
        return this.query;
    }

    public final String component4() {
        return this.reqId;
    }

    public final MarkdownUgcExtraData copy(Integer r2, String r3, ArrayList<String> r4, String r5) {
        return new MarkdownUgcExtraData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MarkdownUgcExtraData) == true) goto L8;
        return false;
    L8:
        MarkdownUgcExtraData r6 = (MarkdownUgcExtraData) r5;
        if (Intrinsics.areEqual(this.videoScene, r6.videoScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recommendTitle, r6.recommendTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reqId, r6.reqId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.videoScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.recommendTitle;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ArrayList<String> r7 = this.query;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.reqId;
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
        return "MarkdownUgcExtraData(videoScene=" + this.videoScene + ", recommendTitle=" + this.recommendTitle + ", query=" + this.query + ", reqId=" + this.reqId + ')';
    }

    public final ArrayList<String> getQuery() {
        return this.query;
    }

    public final String getRecommendTitle() {
        return this.recommendTitle;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final Integer getVideoScene() {
        return this.videoScene;
    }

    public MarkdownUgcExtraData(Integer r1, String r2, ArrayList<String> r3, String r4) {
        this.videoScene = r1;
        this.recommendTitle = r2;
        this.query = r3;
        this.reqId = r4;
    }

    public /* synthetic */ MarkdownUgcExtraData(Integer r2, String r3, ArrayList r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = new ArrayList();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
