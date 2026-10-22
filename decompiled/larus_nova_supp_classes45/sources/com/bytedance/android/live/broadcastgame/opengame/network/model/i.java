package com.bytedance.android.live.broadcastgame.opengame.network.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/model/i;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/f;", "image", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/f;", "d", "()Lcom/bytedance/android/live/broadcastgame/opengame/network/model/f;", "", "description", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "e", "btnTitle", "a", "fadeColor", "c", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("btn_title")
    private final String btnTitle;

    @SerializedName("description")
    private final String description;

    @SerializedName("fade_color")
    private final String fadeColor;

    @SerializedName("CardImage")
    private final f image;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L16;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.description, r4.description) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btnTitle, r4.btnTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fadeColor, r4.fadeColor) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        f r0 = this.image;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.description;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.title;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.btnTitle;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.fadeColor;
        if (r14 == null) goto L22;
        r1 = r14.hashCode();
    L22:
        return r13 + r1;
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
        return "GameCard(image=" + this.image + ", description=" + this.description + ", title=" + this.title + ", btnTitle=" + this.btnTitle + ", fadeColor=" + this.fadeColor + ")";
    }

    public final String a() {
        return this.btnTitle;
    }

    public final String b() {
        return this.description;
    }

    public final String c() {
        return this.fadeColor;
    }

    public final f d() {
        return this.image;
    }

    public final String e() {
        return this.title;
    }
}
