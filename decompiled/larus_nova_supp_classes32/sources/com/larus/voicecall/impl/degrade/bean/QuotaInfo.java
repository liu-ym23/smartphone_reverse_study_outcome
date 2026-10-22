package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\""}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/QuotaInfo;", "Landroid/os/Parcelable;", "isOverQuota", NameKeys.UnloadStrategy_No_Strategy, "ctaResult", "Lcom/larus/voicecall/impl/degrade/bean/QuotaCtaResult;", "switchModalCtaToast", NameKeys.UnloadStrategy_No_Strategy, "limitType", "<init>", "(ZLcom/larus/voicecall/impl/degrade/bean/QuotaCtaResult;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getCtaResult", "()Lcom/larus/voicecall/impl/degrade/bean/QuotaCtaResult;", "getSwitchModalCtaToast", "()Ljava/lang/String;", "getLimitType", "component1", "component2", "component3", "component4", "copy", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuotaInfo implements Parcelable {
    public static final Parcelable.Creator<QuotaInfo> CREATOR = null;

    @SerializedName("cta_result")
    private final QuotaCtaResult ctaResult;

    @SerializedName("is_over_quota")
    private final boolean isOverQuota;

    @SerializedName("limit_type")
    private final String limitType;

    @SerializedName("switch_modal_cta_toast")
    private final String switchModalCtaToast;

    public static final class a implements Parcelable.Creator<QuotaInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaInfo createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            if (r5.readInt() == 0) goto L5;
            boolean r1 = true;
        L7:
            if (r5.readInt() != 0) goto L9;
            QuotaCtaResult r2 = null;
        L11:
            return new QuotaInfo(r1, r2, r5.readString(), r5.readString());
        L9:
            r2 = QuotaCtaResult.CREATOR.createFromParcel(r5);
            goto L11
        L5:
            r1 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaInfo[] newArray(int r1) {
            return new QuotaInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QuotaInfo() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ QuotaInfo copy$default(QuotaInfo r0, boolean r1, QuotaCtaResult r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.isOverQuota;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.ctaResult;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.switchModalCtaToast;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.limitType;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.isOverQuota;
    }

    public final QuotaCtaResult component2() {
        return this.ctaResult;
    }

    public final String component3() {
        return this.switchModalCtaToast;
    }

    public final String component4() {
        return this.limitType;
    }

    public final QuotaInfo copy(boolean r2, QuotaCtaResult r3, String r4, String r5) {
        return new QuotaInfo(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QuotaInfo) == true) goto L8;
        return false;
    L8:
        QuotaInfo r6 = (QuotaInfo) r5;
        if (this.isOverQuota == r6.isOverQuota) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ctaResult, r6.ctaResult) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.switchModalCtaToast, r6.switchModalCtaToast) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.limitType, r6.limitType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.isOverQuota == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        QuotaCtaResult r2 = this.ctaResult;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.switchModalCtaToast;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        String r9 = this.limitType;
        if (r9 == null) goto L19;
        r3 = r9.hashCode();
    L19:
        return r8 + r3;
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "QuotaInfo(isOverQuota=" + this.isOverQuota + ", ctaResult=" + this.ctaResult + ", switchModalCtaToast=" + this.switchModalCtaToast + ", limitType=" + this.limitType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.isOverQuota ? 1 : 0);
        QuotaCtaResult r0 = this.ctaResult;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.switchModalCtaToast);
        r3.writeString(this.limitType);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
        goto L6
    }

    public final QuotaCtaResult getCtaResult() {
        return this.ctaResult;
    }

    public final String getLimitType() {
        return this.limitType;
    }

    public final String getSwitchModalCtaToast() {
        return this.switchModalCtaToast;
    }

    public final boolean isOverQuota() {
        return this.isOverQuota;
    }

    public QuotaInfo(boolean r1, QuotaCtaResult r2, String r3, String r4) {
        this.isOverQuota = r1;
        this.ctaResult = r2;
        this.switchModalCtaToast = r3;
        this.limitType = r4;
    }

    public /* synthetic */ QuotaInfo(boolean r2, QuotaCtaResult r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
