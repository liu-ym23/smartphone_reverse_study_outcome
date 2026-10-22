package com.ss.android.lark.chat.preview.entity;

import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/UrlPreviewResponse;", "Ljava/io/Serializable;", "netCostMs", BuildConfig.FLAVOR, "urlPreViewEntries", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "Lkotlin/collections/ArrayList;", "<init>", "(JLjava/util/ArrayList;)V", "getNetCostMs", "()J", "getUrlPreViewEntries", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewResponse implements Serializable {
    private final long netCostMs;
    private final ArrayList<UrlPreViewEntries> urlPreViewEntries;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreviewResponse copy$default(UrlPreviewResponse r0, long r1, ArrayList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.netCostMs;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.urlPreViewEntries;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.netCostMs;
    }

    public final ArrayList<UrlPreViewEntries> component2() {
        return this.urlPreViewEntries;
    }

    public final UrlPreviewResponse copy(long r2, ArrayList<UrlPreViewEntries> r4) {
        Intrinsics.checkNotNullParameter(r4, "urlPreViewEntries");
        return new UrlPreviewResponse(r2, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof UrlPreviewResponse) == true) goto L8;
        return false;
    L8:
        UrlPreviewResponse r9 = (UrlPreviewResponse) r8;
        if (this.netCostMs == r9.netCostMs) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlPreViewEntries, r9.urlPreViewEntries) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r0 = this.netCostMs;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.urlPreViewEntries.hashCode();
    }

    public String toString() {
        return "UrlPreviewResponse(netCostMs=" + this.netCostMs + ", urlPreViewEntries=" + this.urlPreViewEntries + ')';
    }

    public final long getNetCostMs() {
        return this.netCostMs;
    }

    public final ArrayList<UrlPreViewEntries> getUrlPreViewEntries() {
        return this.urlPreViewEntries;
    }

    public UrlPreviewResponse(long r2, ArrayList<UrlPreViewEntries> r4) {
        Intrinsics.checkNotNullParameter(r4, "urlPreViewEntries");
        this.netCostMs = r2;
        this.urlPreViewEntries = r4;
    }
}
