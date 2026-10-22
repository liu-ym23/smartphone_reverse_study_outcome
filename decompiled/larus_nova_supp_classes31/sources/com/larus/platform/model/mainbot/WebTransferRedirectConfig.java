package com.larus.platform.model.mainbot;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/mainbot/WebTransferRedirectConfig;", "", "enable", "", "jsUrl", "", "whiteList", "", "<init>", "(ZLjava/lang/String;Ljava/util/List;)V", "getEnable", "()Z", "getJsUrl", "()Ljava/lang/String;", "getWhiteList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class WebTransferRedirectConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("js_url")
    private final String jsUrl;

    @SerializedName("white_list")
    private final List<String> whiteList;

    public WebTransferRedirectConfig() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebTransferRedirectConfig copy$default(WebTransferRedirectConfig r0, boolean r1, String r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.jsUrl;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.whiteList;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.jsUrl;
    }

    public final List<String> component3() {
        return this.whiteList;
    }

    public final WebTransferRedirectConfig copy(boolean r2, String r3, List<String> r4) {
        return new WebTransferRedirectConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebTransferRedirectConfig) == true) goto L8;
        return false;
    L8:
        WebTransferRedirectConfig r6 = (WebTransferRedirectConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jsUrl, r6.jsUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.whiteList, r6.whiteList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.jsUrl;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        List<String> r6 = this.whiteList;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "WebTransferRedirectConfig(enable=" + this.enable + ", jsUrl=" + this.jsUrl + ", whiteList=" + this.whiteList + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getJsUrl() {
        return this.jsUrl;
    }

    public final List<String> getWhiteList() {
        return this.whiteList;
    }

    public WebTransferRedirectConfig(boolean r1, String r2, List<String> r3) {
        this.enable = r1;
        this.jsUrl = r2;
        this.whiteList = r3;
    }

    public /* synthetic */ WebTransferRedirectConfig(boolean r1, String r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = "";
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = CollectionsKt.emptyList();
    L11:
        this(r1, r2, r3);
    }
}
