package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0016\u001a\u00020\u0017J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaData;", "Ljava/io/Serializable;", "aiQuota", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;", "asrQuota", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmASRQuotaData;", "displayQuota", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;", "mempopeDeviceBonusPopup", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmMempopeDeviceBonusPopup;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmASRQuotaData;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmMempopeDeviceBonusPopup;)V", "getAiQuota", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;", "getAsrQuota", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmASRQuotaData;", "getDisplayQuota", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;", "getMempopeDeviceBonusPopup", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmMempopeDeviceBonusPopup;", "isAdmin", "", "quotaType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaType;", "getBillUrl", "", "functionScene", "getBenefitCenterUrl", "getFeatureDetail", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmQuotaData implements Serializable {

    @SerializedName("ai_quota")
    private final MmAISummaryQuotaData aiQuota;

    @SerializedName("asr_quota")
    private final MmASRQuotaData asrQuota;

    @SerializedName("display_quota")
    private final MmDisplayQuotaData displayQuota;

    @SerializedName("mempope_device_bonus_popup")
    private final MmMempopeDeviceBonusPopup mempopeDeviceBonusPopup;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmQuotaType.values().length];
            r0[MmQuotaType.AI_SUMMARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MmQuotaType.ASR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MmQuotaType.MempopeDeviceBonus.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public MmQuotaData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MmQuotaData copy$default(MmQuotaData r0, MmAISummaryQuotaData r1, MmASRQuotaData r2, MmDisplayQuotaData r3, MmMempopeDeviceBonusPopup r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.aiQuota;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.asrQuota;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.displayQuota;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.mempopeDeviceBonusPopup;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final MmAISummaryQuotaData component1() {
        return this.aiQuota;
    }

    public final MmASRQuotaData component2() {
        return this.asrQuota;
    }

    public final MmDisplayQuotaData component3() {
        return this.displayQuota;
    }

    public final MmMempopeDeviceBonusPopup component4() {
        return this.mempopeDeviceBonusPopup;
    }

    public final MmQuotaData copy(MmAISummaryQuotaData r2, MmASRQuotaData r3, MmDisplayQuotaData r4, MmMempopeDeviceBonusPopup r5) {
        return new MmQuotaData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmQuotaData) == true) goto L8;
        return false;
    L8:
        MmQuotaData r6 = (MmQuotaData) r5;
        if (Intrinsics.areEqual(this.aiQuota, r6.aiQuota) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrQuota, r6.asrQuota) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayQuota, r6.displayQuota) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mempopeDeviceBonusPopup, r6.mempopeDeviceBonusPopup) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        MmAISummaryQuotaData r0 = this.aiQuota;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        MmASRQuotaData r4 = this.asrQuota;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        MmDisplayQuotaData r7 = this.displayQuota;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        MmMempopeDeviceBonusPopup r10 = this.mempopeDeviceBonusPopup;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "MmQuotaData(aiQuota=" + this.aiQuota + ", asrQuota=" + this.asrQuota + ", displayQuota=" + this.displayQuota + ", mempopeDeviceBonusPopup=" + this.mempopeDeviceBonusPopup + ')';
    }

    public final MmAISummaryQuotaData getAiQuota() {
        return this.aiQuota;
    }

    public final MmASRQuotaData getAsrQuota() {
        return this.asrQuota;
    }

    public final MmDisplayQuotaData getDisplayQuota() {
        return this.displayQuota;
    }

    public final MmMempopeDeviceBonusPopup getMempopeDeviceBonusPopup() {
        return this.mempopeDeviceBonusPopup;
    }

    public final String getBenefitCenterUrl(MmQuotaType r4) {
        Intrinsics.checkNotNullParameter(r4, "quotaType");
        int r5 = a.a[r4.ordinal()];
        String r1 = null;
        if (r5 != 1) goto L5;
        MmAISummaryQuotaData r6 = this.aiQuota;
        if (r6 == null) goto L26;
        String r7 = r6.getBenefitCenterUrl();
        if (r7 == null) goto L26;
    L33:
        return r7;
    L26:
        MmDisplayQuotaData r8 = this.displayQuota;
        if (r8 == null) goto L29;
        r1 = r8.getBenefitCenterUrl();
    L29:
        if (r1 != null) goto L32;
        return "";
    L32:
        return r1;
    L5:
        if (r5 != 2) goto L7;
        MmASRQuotaData r9 = this.asrQuota;
        if (r9 == null) goto L15;
        r7 = r9.getBenefitCenterUrl();
        if (r7 != null) goto L33;
    L15:
        MmDisplayQuotaData r10 = this.displayQuota;
        if (r10 == null) goto L18;
        r1 = r10.getBenefitCenterUrl();
    L18:
        if (r1 != null) goto L32;
        return "";
    L7:
        if (r5 != 3) goto L10;
        return "";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final MmFeatureDetail getFeatureDetail(MmQuotaType r3) {
        Intrinsics.checkNotNullParameter(r3, "quotaType");
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        MmAISummaryQuotaData r5 = this.aiQuota;
        if (r5 != null) goto L19;
        return null;
    L19:
        return r5.getFeatureDetail();
    L5:
        if (r4 != 2) goto L7;
        MmASRQuotaData r6 = this.asrQuota;
        if (r6 != null) goto L23;
        return null;
    L23:
        return r6.getFeatureDetail();
    L7:
        if (r4 != 3) goto L12;
        MmMempopeDeviceBonusPopup r7 = this.mempopeDeviceBonusPopup;
        if (r7 != null) goto L21;
        return null;
    L21:
        return r7.getFeatureDetail();
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isAdmin(MmQuotaType r3) {
        Intrinsics.checkNotNullParameter(r3, "quotaType");
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        MmAISummaryQuotaData r5 = this.aiQuota;
        if (r5 == null) goto L25;
        Boolean r6 = r5.isAdmin();
        if (r6 != null) goto L21;
        return false;
    L21:
        return r6.booleanValue();
    L25:
        return false;
    L5:
        if (r4 != 2) goto L7;
        MmASRQuotaData r7 = this.asrQuota;
        if (r7 == null) goto L22;
        Boolean r8 = r7.isAdmin();
        if (r8 != null) goto L24;
        return false;
    L24:
        return r8.booleanValue();
    L22:
        return false;
    L7:
        if (r4 != 3) goto L10;
        return false;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final String getBillUrl(MmQuotaType r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "quotaType");
        Intrinsics.checkNotNullParameter(r7, "functionScene");
        int r8 = a.a[r6.ordinal()];
        boolean r0 = false;
        String r2 = null;
        if (r8 != 1) goto L5;
        MmAISummaryQuotaData r9 = this.aiQuota;
        if (r9 == null) goto L35;
        HashMap<String, String> r10 = r9.getFunctionSceneBuyUrlMap();
        if (r10 == null) goto L35;
        String r11 = r10.get(r7);
    L36:
        if (r11 != null) goto L39;
        r11 = "";
    L39:
        if (r11.length() != 0) goto L41;
        r0 = true;
    L41:
        if (r0 == false) goto L47;
        MmAISummaryQuotaData r12 = this.aiQuota;
        if (r12 == null) goto L45;
        r2 = r12.getBillUrl();
    L45:
        if (r2 != null) goto L46;
        return "";
    L46:
        return r2;
    L47:
        return r11;
    L35:
        r11 = null;
        goto L36
    L5:
        if (r8 != 2) goto L7;
        MmASRQuotaData r13 = this.asrQuota;
        if (r13 == null) goto L16;
        HashMap<String, String> r14 = r13.getFunctionSceneBuyUrlMap();
        if (r14 == null) goto L16;
        r11 = r14.get(r7);
    L17:
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        if (r11.length() != 0) goto L22;
        r0 = true;
    L22:
        if (r0 == false) goto L47;
        MmASRQuotaData r15 = this.asrQuota;
        if (r15 == null) goto L26;
        r2 = r15.getBillUrl();
    L26:
        if (r2 != null) goto L46;
        return "";
    L16:
        r11 = null;
        goto L17
    L7:
        if (r8 != 3) goto L10;
        return "";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public MmQuotaData(MmAISummaryQuotaData r1, MmASRQuotaData r2, MmDisplayQuotaData r3, MmMempopeDeviceBonusPopup r4) {
        this.aiQuota = r1;
        this.asrQuota = r2;
        this.displayQuota = r3;
        this.mempopeDeviceBonusPopup = r4;
    }

    public static /* synthetic */ String getBillUrl$default(MmQuotaData r0, MmQuotaType r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "";
    L6:
        return r0.getBillUrl(r1, r2);
    }

    public /* synthetic */ MmQuotaData(MmAISummaryQuotaData r2, MmASRQuotaData r3, MmDisplayQuotaData r4, MmMempopeDeviceBonusPopup r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
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
