package com.larus.share.service;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\nHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/share/service/ShareShortUrlCreateResponse;", "", "items", "", "Lcom/larus/share/service/ShareShortUrlItem;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "shortUrls", "", "getShortUrls", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShareShortUrlCreateResponse {
    private static final a Companion = null;
    public static final int SHORT_URL_STATUS_SUCCESS = 0;

    @SerializedName("items")
    private final List<ShareShortUrlItem> items;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShareShortUrlCreateResponse() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShareShortUrlCreateResponse copy$default(ShareShortUrlCreateResponse r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.items;
    L6:
        return r0.copy(r1);
    }

    public final List<ShareShortUrlItem> component1() {
        return this.items;
    }

    public final ShareShortUrlCreateResponse copy(List<ShareShortUrlItem> r2) {
        return new ShareShortUrlCreateResponse(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ShareShortUrlCreateResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.items, ((ShareShortUrlCreateResponse) r4).items) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<ShareShortUrlItem> r0 = this.items;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ShareShortUrlCreateResponse(items=" + this.items + ')';
    }

    public final List<String> getShortUrls() {
        List<ShareShortUrlItem> r0 = this.items;
        if (r0 == null) goto L41;
        List<ShareShortUrlItem> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L37;
        ShareShortUrlItem r4 = (ShareShortUrlItem) r3.next();
        if (r4 == null) goto L10;
        String r5 = r4.getShortUrl();
    L11:
        boolean r6 = true;
        if (r4 == null) goto L19;
        Integer r7 = r4.getStatus();
        if (r7 == null) goto L19;
        if (r7.intValue() != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L29;
        if (r5 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L29;
    L30:
        if (r6 == true) goto L33;
        r5 = null;
    L33:
        if (r5 != null) goto L35;
        r5 = "";
    L35:
        r2.add(r5);
        goto L6
    L23:
        if (StringsKt.isBlank(r5) == true) goto L26;
        r9 = false;
    L29:
        r6 = false;
    L19:
        r8 = false;
        goto L20
    L10:
        r5 = null;
        goto L11
    L37:
        return r2;
    L41:
        return null;
    }

    public final List<ShareShortUrlItem> getItems() {
        return this.items;
    }

    public ShareShortUrlCreateResponse(List<ShareShortUrlItem> r1) {
        this.items = r1;
    }

    public /* synthetic */ ShareShortUrlCreateResponse(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
