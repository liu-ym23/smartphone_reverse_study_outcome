package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/api/creation/PublisherTrackParams;", "Landroid/os/Parcelable;", "previousPage", "", "recommendFrom", "templateRecReqId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPreviousPage", "()Ljava/lang/String;", "getRecommendFrom", "getTemplateRecReqId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PublisherTrackParams implements Parcelable {
    public static final Parcelable.Creator<PublisherTrackParams> CREATOR = null;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName("recommend_from")
    private final String recommendFrom;

    @SerializedName("template_rec_req_id")
    private final String templateRecReqId;

    public static final class a implements Parcelable.Creator<PublisherTrackParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PublisherTrackParams createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new PublisherTrackParams(r4.readString(), r4.readString(), r4.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PublisherTrackParams[] newArray(int r1) {
            return new PublisherTrackParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PublisherTrackParams() {
        this(null, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PublisherTrackParams) == true) goto L8;
        return false;
    L8:
        PublisherTrackParams r6 = (PublisherTrackParams) r5;
        if (Intrinsics.areEqual(this.previousPage, r6.previousPage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recommendFrom, r6.recommendFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateRecReqId, r6.templateRecReqId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.previousPage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.recommendFrom;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.templateRecReqId;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublisherTrackParams(previousPage=" + this.previousPage + ", recommendFrom=" + this.recommendFrom + ", templateRecReqId=" + this.templateRecReqId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.previousPage);
        r1.writeString(this.recommendFrom);
        r1.writeString(this.templateRecReqId);
    }

    public final String a() {
        return this.previousPage;
    }

    public final String b() {
        return this.recommendFrom;
    }

    public final String c() {
        return this.templateRecReqId;
    }

    public /* synthetic */ PublisherTrackParams(String r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this(r2, null, null);
    }

    public PublisherTrackParams(String r1, String r2, String r3) {
        this.previousPage = r1;
        this.recommendFrom = r2;
        this.templateRecReqId = r3;
    }
}
