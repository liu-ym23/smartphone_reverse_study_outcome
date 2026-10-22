package nh0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lnh0/c;", "Ltf0/d;", "", "iconUrl", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "emptyTips", "h", "tipsColor", "j", "emptyBg", "g", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c extends tf0.d {

    @SerializedName("empty_bg")
    private final String emptyBg;

    @SerializedName("empty_tips")
    private final String emptyTips;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("tips_color")
    private final String tipsColor;

    @Override // tf0.d
    public final String toString() {
        return super.toString() + ", iconUrl = " + this.iconUrl + ", emptyTips = " + this.emptyTips + ", tipsColor=" + this.tipsColor + ", emptyBg=" + this.emptyBg;
    }

    public final String g() {
        return this.emptyBg;
    }

    public final String h() {
        return this.emptyTips;
    }

    public final String i() {
        return this.iconUrl;
    }

    public final String j() {
        return this.tipsColor;
    }

    @Override // tf0.d
    public final boolean e(tf0.d r5) {
        if (super.e(r5) == true) goto L6;
        return false;
    L6:
        if (this != r5) goto L8;
        return true;
    L8:
        if (r5 != null) goto L10;
        return false;
    L10:
        if ((!Intrinsics.areEqual(c.class, r5.getClass())) == true) goto L27;
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.emptyTips, r6.emptyTips) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.tipsColor, r6.tipsColor) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.emptyBg, r6.emptyBg) == false) goto L26;
        return true;
    L26:
        return false;
    L27:
        return false;
    }
}
