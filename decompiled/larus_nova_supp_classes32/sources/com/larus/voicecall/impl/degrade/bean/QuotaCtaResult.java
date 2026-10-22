package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/QuotaCtaResult;", "Landroid/os/Parcelable;", "ctaGuideTitle", NameKeys.UnloadStrategy_No_Strategy, "guideContent", "imageUrl", "actionUrl", "displayDurationMSec", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCtaGuideTitle", "()Ljava/lang/String;", "getGuideContent", "getImageUrl", "getActionUrl", "getDisplayDurationMSec", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", NameKeys.UnloadStrategy_No_Strategy, "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuotaCtaResult implements Parcelable {
    public static final Parcelable.Creator<QuotaCtaResult> CREATOR = null;

    @SerializedName("action_url")
    private final String actionUrl;

    @SerializedName("cta_guide_title")
    private final String ctaGuideTitle;

    @SerializedName("display_duration_msec")
    private final long displayDurationMSec;

    @SerializedName("guide_content")
    private final String guideContent;

    @SerializedName("image_url")
    private final String imageUrl;

    public static final class a implements Parcelable.Creator<QuotaCtaResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaCtaResult createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            return new QuotaCtaResult(r9.readString(), r9.readString(), r9.readString(), r9.readString(), r9.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaCtaResult[] newArray(int r1) {
            return new QuotaCtaResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QuotaCtaResult() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ QuotaCtaResult copy$default(QuotaCtaResult r4, String r5, String r6, String r7, String r8, long r9, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.ctaGuideTitle;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.guideContent;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.imageUrl;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.actionUrl;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.displayDurationMSec;
    L17:
        String r10 = r5;
        return r4.copy(r10, r13, r0, r1, r9);
    }

    public final String component1() {
        return this.ctaGuideTitle;
    }

    public final String component2() {
        return this.guideContent;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final String component4() {
        return this.actionUrl;
    }

    public final long component5() {
        return this.displayDurationMSec;
    }

    public final QuotaCtaResult copy(String r9, String r10, String r11, String r12, long r13) {
        return new QuotaCtaResult(r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof QuotaCtaResult) == true) goto L8;
        return false;
    L8:
        QuotaCtaResult r9 = (QuotaCtaResult) r8;
        if (Intrinsics.areEqual(this.ctaGuideTitle, r9.ctaGuideTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guideContent, r9.guideContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUrl, r9.imageUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionUrl, r9.actionUrl) == true) goto L21;
        return false;
    L21:
        if (this.displayDurationMSec == r9.displayDurationMSec) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.ctaGuideTitle;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.guideContent;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.imageUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.actionUrl;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        int r11 = (r9 + r1) * 31;
        long r12 = this.displayDurationMSec;
        return r11 + ((int) (r12 ^ (r12 >>> 32)));
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
        return "QuotaCtaResult(ctaGuideTitle=" + this.ctaGuideTitle + ", guideContent=" + this.guideContent + ", imageUrl=" + this.imageUrl + ", actionUrl=" + this.actionUrl + ", displayDurationMSec=" + this.displayDurationMSec + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.ctaGuideTitle);
        r3.writeString(this.guideContent);
        r3.writeString(this.imageUrl);
        r3.writeString(this.actionUrl);
        r3.writeLong(this.displayDurationMSec);
    }

    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final String getCtaGuideTitle() {
        return this.ctaGuideTitle;
    }

    public final long getDisplayDurationMSec() {
        return this.displayDurationMSec;
    }

    public final String getGuideContent() {
        return this.guideContent;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public QuotaCtaResult(String r1, String r2, String r3, String r4, long r5) {
        this.ctaGuideTitle = r1;
        this.guideContent = r2;
        this.imageUrl = r3;
        this.actionUrl = r4;
        this.displayDurationMSec = r5;
    }

    public /* synthetic */ QuotaCtaResult(String r4, String r5, String r6, String r7, long r8, int r10, DefaultConstructorMarker r11) {
        String r0 = null;
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) != 0) goto L19;
        r0 = r7;
    L19:
        if ((r10 & 16) == 0) goto L21;
        r8 = 3000;
    L21:
        this(r12, r1, r2, r0, r8);
        return;
    L13:
        r2 = r6;
        goto L15
    L9:
        r1 = r5;
        goto L11
    L5:
        r12 = r4;
        goto L7
    }
}
