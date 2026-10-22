package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012(\b\u0002\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u00103\u001a\u00020\bJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0014HÆ\u0003J)\u0010A\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0017HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jò\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142(\b\u0002\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\t\u0010$R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\n\u0010$R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\u0010\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R6\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"¨\u0006L"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;", "Ljava/io/Serializable;", "usage", "", "amount", "billUrl", "", "canBuy", "", "isAdmin", "isRequireAsrQuota", "ignoreUpgrade", "showSuperAdmin", "superAdminList", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaDataSuperAdmin;", "isFreeTenant", "licensePlanKey", "billFeatureKey", "featureDetail", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "functionSceneBuyUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "benefitCenterUrl", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;Ljava/lang/String;)V", "getUsage", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAmount", "getBillUrl", "()Ljava/lang/String;", "getCanBuy", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIgnoreUpgrade", "getShowSuperAdmin", "getSuperAdminList", "()Ljava/util/List;", "getLicensePlanKey", "getBillFeatureKey", "getFeatureDetail", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "getFunctionSceneBuyUrlMap", "()Ljava/util/HashMap;", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;", "getBenefitCenterUrl", "isExceed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmUnavailableReason;Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmAISummaryQuotaData;", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmAISummaryQuotaData implements Serializable {

    @SerializedName("amount")
    private final Long amount;

    @SerializedName("benefit_center_url")
    private final String benefitCenterUrl;

    @SerializedName("bill_feature_key")
    private final String billFeatureKey;

    @SerializedName("bill_url")
    private final String billUrl;

    @SerializedName("can_buy")
    private final Boolean canBuy;

    @SerializedName("feature_detail")
    private final MmFeatureDetail featureDetail;

    @SerializedName("function_scene_buy_url_map")
    private final HashMap<String, String> functionSceneBuyUrlMap;

    @SerializedName("ignore_upgrade")
    private final Boolean ignoreUpgrade;

    @SerializedName("is_super_admin")
    private final Boolean isAdmin;

    @SerializedName("is_free_tenant")
    private final Boolean isFreeTenant;

    @SerializedName("is_require_asr_quota")
    private final Boolean isRequireAsrQuota;

    @SerializedName("license_plan_key")
    private final String licensePlanKey;

    @SerializedName("show_super_admin")
    private final Boolean showSuperAdmin;

    @SerializedName("super_admin_list")
    private final List<MmQuotaDataSuperAdmin> superAdminList;

    @SerializedName("unavailable_reason")
    private final MmUnavailableReason unavailableReason;

    @SerializedName("usage")
    private final Long usage;

    public MmAISummaryQuotaData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmAISummaryQuotaData copy$default(MmAISummaryQuotaData r17, Long r18, Long r19, String r20, Boolean r21, Boolean r22, Boolean r23, Boolean r24, Boolean r25, List r26, Boolean r27, String r28, String r29, MmFeatureDetail r30, HashMap r31, MmUnavailableReason r32, String r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        Long r2 = r17.usage;
    L7:
        if ((r34 & 2) == 0) goto L9;
        Long r3 = r17.amount;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = r17.billUrl;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Boolean r5 = r17.canBuy;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Boolean r6 = r17.isAdmin;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Boolean r7 = r17.isRequireAsrQuota;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Boolean r8 = r17.ignoreUpgrade;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Boolean r9 = r17.showSuperAdmin;
    L35:
        if ((r34 & 256) == 0) goto L37;
        List r10 = r17.superAdminList;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Boolean r11 = r17.isFreeTenant;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r12 = r17.licensePlanKey;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = r17.billFeatureKey;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        MmFeatureDetail r14 = r17.featureDetail;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        HashMap r15 = r17.functionSceneBuyUrlMap;
    L58:
        HashMap r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        MmUnavailableReason r16 = r17.unavailableReason;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r1 = r17.benefitCenterUrl;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Long component1() {
        return this.usage;
    }

    public final Boolean component10() {
        return this.isFreeTenant;
    }

    public final String component11() {
        return this.licensePlanKey;
    }

    public final String component12() {
        return this.billFeatureKey;
    }

    public final MmFeatureDetail component13() {
        return this.featureDetail;
    }

    public final HashMap<String, String> component14() {
        return this.functionSceneBuyUrlMap;
    }

    public final MmUnavailableReason component15() {
        return this.unavailableReason;
    }

    public final String component16() {
        return this.benefitCenterUrl;
    }

    public final Long component2() {
        return this.amount;
    }

    public final String component3() {
        return this.billUrl;
    }

    public final Boolean component4() {
        return this.canBuy;
    }

    public final Boolean component5() {
        return this.isAdmin;
    }

    public final Boolean component6() {
        return this.isRequireAsrQuota;
    }

    public final Boolean component7() {
        return this.ignoreUpgrade;
    }

    public final Boolean component8() {
        return this.showSuperAdmin;
    }

    public final List<MmQuotaDataSuperAdmin> component9() {
        return this.superAdminList;
    }

    public final MmAISummaryQuotaData copy(Long r19, Long r20, String r21, Boolean r22, Boolean r23, Boolean r24, Boolean r25, Boolean r26, List<MmQuotaDataSuperAdmin> r27, Boolean r28, String r29, String r30, MmFeatureDetail r31, HashMap<String, String> r32, MmUnavailableReason r33, String r34) {
        return new MmAISummaryQuotaData(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmAISummaryQuotaData) == true) goto L8;
        return false;
    L8:
        MmAISummaryQuotaData r6 = (MmAISummaryQuotaData) r5;
        if (Intrinsics.areEqual(this.usage, r6.usage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.amount, r6.amount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.billUrl, r6.billUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.canBuy, r6.canBuy) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isAdmin, r6.isAdmin) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isRequireAsrQuota, r6.isRequireAsrQuota) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ignoreUpgrade, r6.ignoreUpgrade) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.showSuperAdmin, r6.showSuperAdmin) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.superAdminList, r6.superAdminList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isFreeTenant, r6.isFreeTenant) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.licensePlanKey, r6.licensePlanKey) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.billFeatureKey, r6.billFeatureKey) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.featureDetail, r6.featureDetail) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.functionSceneBuyUrlMap, r6.functionSceneBuyUrlMap) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.unavailableReason, r6.unavailableReason) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.benefitCenterUrl, r6.benefitCenterUrl) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        Long r0 = this.usage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.amount;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.billUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.canBuy;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.isAdmin;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.isRequireAsrQuota;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.ignoreUpgrade;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.showSuperAdmin;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<MmQuotaDataSuperAdmin> r25 = this.superAdminList;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.isFreeTenant;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.licensePlanKey;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.billFeatureKey;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        MmFeatureDetail r37 = this.featureDetail;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        HashMap<String, String> r40 = this.functionSceneBuyUrlMap;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        MmUnavailableReason r43 = this.unavailableReason;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.benefitCenterUrl;
        if (r46 == null) goto L67;
        r1 = r46.hashCode();
    L67:
        return r45 + r1;
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "MmAISummaryQuotaData(usage=" + this.usage + ", amount=" + this.amount + ", billUrl=" + this.billUrl + ", canBuy=" + this.canBuy + ", isAdmin=" + this.isAdmin + ", isRequireAsrQuota=" + this.isRequireAsrQuota + ", ignoreUpgrade=" + this.ignoreUpgrade + ", showSuperAdmin=" + this.showSuperAdmin + ", superAdminList=" + this.superAdminList + ", isFreeTenant=" + this.isFreeTenant + ", licensePlanKey=" + this.licensePlanKey + ", billFeatureKey=" + this.billFeatureKey + ", featureDetail=" + this.featureDetail + ", functionSceneBuyUrlMap=" + this.functionSceneBuyUrlMap + ", unavailableReason=" + this.unavailableReason + ", benefitCenterUrl=" + this.benefitCenterUrl + ')';
    }

    public final boolean isExceed() {
        Long r0 = this.usage;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.amount == null) goto L9;
        if (r0.longValue() < this.amount.longValue()) goto L9;
        return true;
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final String getBenefitCenterUrl() {
        return this.benefitCenterUrl;
    }

    public final String getBillFeatureKey() {
        return this.billFeatureKey;
    }

    public final String getBillUrl() {
        return this.billUrl;
    }

    public final Boolean getCanBuy() {
        return this.canBuy;
    }

    public final MmFeatureDetail getFeatureDetail() {
        return this.featureDetail;
    }

    public final HashMap<String, String> getFunctionSceneBuyUrlMap() {
        return this.functionSceneBuyUrlMap;
    }

    public final Boolean getIgnoreUpgrade() {
        return this.ignoreUpgrade;
    }

    public final String getLicensePlanKey() {
        return this.licensePlanKey;
    }

    public final Boolean getShowSuperAdmin() {
        return this.showSuperAdmin;
    }

    public final List<MmQuotaDataSuperAdmin> getSuperAdminList() {
        return this.superAdminList;
    }

    public final MmUnavailableReason getUnavailableReason() {
        return this.unavailableReason;
    }

    public final Long getUsage() {
        return this.usage;
    }

    public final Boolean isAdmin() {
        return this.isAdmin;
    }

    public final Boolean isFreeTenant() {
        return this.isFreeTenant;
    }

    public final Boolean isRequireAsrQuota() {
        return this.isRequireAsrQuota;
    }

    public MmAISummaryQuotaData(Long r3, Long r4, String r5, Boolean r6, Boolean r7, Boolean r8, Boolean r9, Boolean r10, List<MmQuotaDataSuperAdmin> r11, Boolean r12, String r13, String r14, MmFeatureDetail r15, HashMap<String, String> r16, MmUnavailableReason r17, String r18) {
        this.usage = r3;
        this.amount = r4;
        this.billUrl = r5;
        this.canBuy = r6;
        this.isAdmin = r7;
        this.isRequireAsrQuota = r8;
        this.ignoreUpgrade = r9;
        this.showSuperAdmin = r10;
        this.superAdminList = r11;
        this.isFreeTenant = r12;
        this.licensePlanKey = r13;
        this.billFeatureKey = r14;
        this.featureDetail = r15;
        this.functionSceneBuyUrlMap = r16;
        this.unavailableReason = r17;
        this.benefitCenterUrl = r18;
    }

    public /* synthetic */ MmAISummaryQuotaData(Long r18, Long r19, String r20, Boolean r21, Boolean r22, Boolean r23, Boolean r24, Boolean r25, List r26, Boolean r27, String r28, String r29, MmFeatureDetail r30, HashMap r31, MmUnavailableReason r32, String r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Boolean r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Boolean r6 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Boolean r7 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Boolean r8 = Boolean.FALSE;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        List r10 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Boolean r11 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        MmFeatureDetail r14 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        HashMap r15 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        MmUnavailableReason r2 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r0 = null;
    L66:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r0);
        return;
    L65:
        r0 = r33;
        goto L66
    L61:
        r2 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
