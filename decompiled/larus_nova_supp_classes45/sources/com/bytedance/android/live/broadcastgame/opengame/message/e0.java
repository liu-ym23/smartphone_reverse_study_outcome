package com.bytedance.android.live.broadcastgame.opengame.message;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/e0;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "screenShotUri", "getScreenShotUri", "startPageUrl", "getStartPageUrl", "setStartPageUrl", "(Ljava/lang/String;)V", "customizedCoverUri", "getCustomizedCoverUri", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "cardContent", "getCardContent", "customizedTitle", "getCustomizedTitle", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("card_content")
    private final String cardContent;

    @SerializedName("customized_cover_uri")
    private final String customizedCoverUri;

    @SerializedName("customized_title")
    private final String customizedTitle;

    @SerializedName("screen_shot_uri")
    private final String screenShotUri;

    @SerializedName("start_page_url")
    private String startPageUrl;

    @SerializedName("status")
    private int status;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e0) == false) goto L20;
        e0 r4 = (e0) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.screenShotUri, r4.screenShotUri) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.startPageUrl, r4.startPageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customizedCoverUri, r4.customizedCoverUri) == true) goto L14;
        return false;
    L14:
        if (this.status == r4.status) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cardContent, r4.cardContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.customizedTitle, r4.customizedTitle) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.screenShotUri;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.startPageUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.customizedCoverUri;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (((r9 + r12) * 31) + this.status) * 31;
        String r14 = this.cardContent;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.customizedTitle;
        if (r17 == null) goto L26;
        r1 = r17.hashCode();
    L26:
        return r16 + r1;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniCardInfo(title=" + this.title + ", screenShotUri=" + this.screenShotUri + ", startPageUrl=" + this.startPageUrl + ", customizedCoverUri=" + this.customizedCoverUri + ", status=" + this.status + ", cardContent=" + this.cardContent + ", customizedTitle=" + this.customizedTitle + ")";
    }

    public e0() {
        Intrinsics.checkNotNullParameter("", "title");
        Intrinsics.checkNotNullParameter("", "screenShotUri");
        Intrinsics.checkNotNullParameter("", "startPageUrl");
        Intrinsics.checkNotNullParameter("", "customizedCoverUri");
        Intrinsics.checkNotNullParameter("", "cardContent");
        Intrinsics.checkNotNullParameter("", "customizedTitle");
        this.title = "";
        this.screenShotUri = "";
        this.startPageUrl = "";
        this.customizedCoverUri = "";
        this.status = 0;
        this.cardContent = "";
        this.customizedTitle = "";
    }
}
