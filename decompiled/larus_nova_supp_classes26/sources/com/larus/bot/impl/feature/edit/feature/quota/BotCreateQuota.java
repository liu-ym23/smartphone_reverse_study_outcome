package com.larus.bot.impl.feature.edit.feature.quota;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0005J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006%"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/quota/BotCreateQuota;", "Landroid/os/Parcelable;", "limitEnabled", "", "totalQuota", "", "usedQuota", "limitedMsg", "", "tipsContent", "<init>", "(ZIILjava/lang/String;Ljava/lang/String;)V", "getLimitEnabled", "()Z", "getTotalQuota", "()I", "getUsedQuota", "getLimitedMsg", "()Ljava/lang/String;", "getTipsContent", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateQuota implements Parcelable {
    public static final Parcelable.Creator<BotCreateQuota> CREATOR = null;

    @SerializedName("limited")
    private final boolean limitEnabled;

    @SerializedName("limited_msg")
    private final String limitedMsg;

    @SerializedName("tips_content")
    private final String tipsContent;

    @SerializedName("total_quota")
    private final int totalQuota;

    @SerializedName("used_quota")
    private final int usedQuota;

    public static final class a implements Parcelable.Creator<BotCreateQuota> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotCreateQuota createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            if (r8.readInt() == 0) goto L5;
            boolean r2 = true;
        L7:
            return new BotCreateQuota(r2, r8.readInt(), r8.readInt(), r8.readString(), r8.readString());
        L5:
            r2 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BotCreateQuota[] newArray(int r1) {
            return new BotCreateQuota[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotCreateQuota() {
        this(false, 0, 0, null, null, 31, null);
    }

    public static /* synthetic */ BotCreateQuota copy$default(BotCreateQuota r3, boolean r4, int r5, int r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.limitEnabled;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.totalQuota;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.usedQuota;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.limitedMsg;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.tipsContent;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.limitEnabled;
    }

    public final int component2() {
        return this.totalQuota;
    }

    public final int component3() {
        return this.usedQuota;
    }

    public final String component4() {
        return this.limitedMsg;
    }

    public final String component5() {
        return this.tipsContent;
    }

    public final BotCreateQuota copy(boolean r8, int r9, int r10, String r11, String r12) {
        return new BotCreateQuota(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotCreateQuota) == true) goto L8;
        return false;
    L8:
        BotCreateQuota r6 = (BotCreateQuota) r5;
        if (this.limitEnabled == r6.limitEnabled) goto L12;
        return false;
    L12:
        if (this.totalQuota == r6.totalQuota) goto L15;
        return false;
    L15:
        if (this.usedQuota == r6.usedQuota) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.limitedMsg, r6.limitedMsg) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tipsContent, r6.tipsContent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.limitEnabled == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.totalQuota) * 31) + this.usedQuota) * 31;
        String r2 = this.limitedMsg;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.tipsContent;
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
        return "BotCreateQuota(limitEnabled=" + this.limitEnabled + ", totalQuota=" + this.totalQuota + ", usedQuota=" + this.usedQuota + ", limitedMsg=" + this.limitedMsg + ", tipsContent=" + this.tipsContent + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.limitEnabled ? 1 : 0);
        r1.writeInt(this.totalQuota);
        r1.writeInt(this.usedQuota);
        r1.writeString(this.limitedMsg);
        r1.writeString(this.tipsContent);
    }

    public final boolean getLimitEnabled() {
        return this.limitEnabled;
    }

    public final String getLimitedMsg() {
        return this.limitedMsg;
    }

    public final String getTipsContent() {
        return this.tipsContent;
    }

    public final int getTotalQuota() {
        return this.totalQuota;
    }

    public final int getUsedQuota() {
        return this.usedQuota;
    }

    public BotCreateQuota(boolean r1, int r2, int r3, String r4, String r5) {
        this.limitEnabled = r1;
        this.totalQuota = r2;
        this.usedQuota = r3;
        this.limitedMsg = r4;
        this.tipsContent = r5;
    }

    public /* synthetic */ BotCreateQuota(boolean r4, int r5, int r6, String r7, String r8, int r9, DefaultConstructorMarker r10) {
        int r0 = 0;
        if ((r9 & 1) == 0) goto L5;
        boolean r11 = false;
    L7:
        if ((r9 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r9 & 4) != 0) goto L15;
        r0 = r6;
    L15:
        if ((r9 & 8) == 0) goto L17;
        String r2 = "";
    L19:
        if ((r9 & 16) == 0) goto L21;
        String r12 = "";
    L22:
        this(r11, r1, r0, r2, r12);
        return;
    L21:
        r12 = r8;
        goto L22
    L17:
        r2 = r7;
        goto L19
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
