package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/search/MoreInfo;", "Lcom/larus/im/bean/message/ItemData;", "searchUrl", "", "searchUrlApp", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSearchUrl", "()Ljava/lang/String;", "setSearchUrl", "(Ljava/lang/String;)V", "getSearchUrlApp", "setSearchUrlApp", "getId", "getSearchUrlCompat", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MoreInfo extends ItemData {
    public final transient ItemType a;

    @SerializedName("search_url")
    private String searchUrl;

    @SerializedName("search_url_app")
    private String searchUrlApp;

    public MoreInfo() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ MoreInfo copy$default(MoreInfo r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.searchUrl;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.searchUrlApp;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.searchUrl;
    }

    public final String component2() {
        return this.searchUrlApp;
    }

    public final MoreInfo copy(String r2, String r3) {
        return new MoreInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MoreInfo) == true) goto L8;
        return false;
    L8:
        MoreInfo r6 = (MoreInfo) r5;
        if (Intrinsics.areEqual(this.searchUrl, r6.searchUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchUrlApp, r6.searchUrlApp) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.searchUrl;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.searchUrlApp;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MoreInfo(searchUrl=" + this.searchUrl + ", searchUrlApp=" + this.searchUrlApp + ')';
    }

    public final String getSearchUrlCompat() {
        String r0 = this.searchUrlApp;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return this.searchUrl;
    L12:
        return this.searchUrlApp;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public String getId() {
        return this.searchUrl;
    }

    public ItemType getSearchItemType() {
        return this.a;
    }

    public final String getSearchUrl() {
        return this.searchUrl;
    }

    public final String getSearchUrlApp() {
        return this.searchUrlApp;
    }

    public final void setSearchUrl(String r1) {
        this.searchUrl = r1;
    }

    public final void setSearchUrlApp(String r1) {
        this.searchUrlApp = r1;
    }

    public MoreInfo(String r1, String r2) {
        this.searchUrl = r1;
        this.searchUrlApp = r2;
        this.a = ItemType.TYPE_CARD_MORE;
    }

    public /* synthetic */ MoreInfo(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
