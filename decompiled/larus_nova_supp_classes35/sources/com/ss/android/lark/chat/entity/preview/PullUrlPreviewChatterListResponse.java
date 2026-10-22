package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/PullUrlPreviewChatterListResponse;", "Ljava/io/Serializable;", "chatterInfos", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "chatterIds", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_HAS_MORE, BuildConfig.FLAVOR, "nextToken", "<init>", "(Ljava/util/List;Ljava/util/List;ZLjava/lang/String;)V", "getChatterInfos", "()Ljava/util/List;", "getChatterIds", "getHasMore", "()Z", "getNextToken", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PullUrlPreviewChatterListResponse implements Serializable {
    private final List<String> chatterIds;
    private final List<ChatterPreviewChatterInfo> chatterInfos;
    private final boolean hasMore;
    private final String nextToken;

    public PullUrlPreviewChatterListResponse() {
        this(null, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PullUrlPreviewChatterListResponse copy$default(PullUrlPreviewChatterListResponse r0, List r1, List r2, boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.chatterInfos;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.chatterIds;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.hasMore;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.nextToken;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<ChatterPreviewChatterInfo> component1() {
        return this.chatterInfos;
    }

    public final List<String> component2() {
        return this.chatterIds;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final String component4() {
        return this.nextToken;
    }

    public final PullUrlPreviewChatterListResponse copy(List<ChatterPreviewChatterInfo> r2, List<String> r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "chatterInfos");
        Intrinsics.checkNotNullParameter(r5, "nextToken");
        return new PullUrlPreviewChatterListResponse(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PullUrlPreviewChatterListResponse) == true) goto L8;
        return false;
    L8:
        PullUrlPreviewChatterListResponse r6 = (PullUrlPreviewChatterListResponse) r5;
        if (Intrinsics.areEqual(this.chatterInfos, r6.chatterInfos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterIds, r6.chatterIds) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r6.hasMore) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nextToken, r6.nextToken) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.chatterInfos.hashCode() * 31;
        List<String> r1 = this.chatterIds;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.hasMore == false) goto L9;
        int r4 = 1231;
    L11:
        return ((r3 + r4) * 31) + this.nextToken.hashCode();
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "PullUrlPreviewChatterListResponse(chatterInfos=" + this.chatterInfos + ", chatterIds=" + this.chatterIds + ", hasMore=" + this.hasMore + ", nextToken=" + this.nextToken + ')';
    }

    public final List<String> getChatterIds() {
        return this.chatterIds;
    }

    public final List<ChatterPreviewChatterInfo> getChatterInfos() {
        return this.chatterInfos;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextToken() {
        return this.nextToken;
    }

    public PullUrlPreviewChatterListResponse(List<ChatterPreviewChatterInfo> r2, List<String> r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "chatterInfos");
        Intrinsics.checkNotNullParameter(r5, "nextToken");
        this.chatterInfos = r2;
        this.chatterIds = r3;
        this.hasMore = r4;
        this.nextToken = r5;
    }

    public /* synthetic */ PullUrlPreviewChatterListResponse(List r1, List r2, boolean r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = false;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = BuildConfig.FLAVOR;
    L14:
        this(r1, r2, r3, r4);
    }
}
