package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0015HÆ\u0003J)\u0010@\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0018HÆ\u0003Jø\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0018HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0007\u0010!R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\t\u0010!R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\n\u0010!R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b'\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b+\u0010\u001cR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R6\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006I"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;", "Ljava/io/Serializable;", "aiAmount", "", "aiUsage", "asrAmount", "asrUsage", "isAIQuotaActive", "", "isASRQuotaActive", "isAIMinutesQuotaActive", "aiMinutesAmount", "aiMinutesUsage", "remainingAIQuota", "remainingAIMinutesQuota", "remainingASRQuota", "billUrl", "", "benefitCenterUrl", "aiMinutesQuotaStatus", "featureDetail", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "functionSceneBuyUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;)V", "getAiAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAiUsage", "getAsrAmount", "getAsrUsage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAiMinutesAmount", "getAiMinutesUsage", "getRemainingAIQuota", "getRemainingAIMinutesQuota", "getRemainingASRQuota", "getBillUrl", "()Ljava/lang/String;", "getBenefitCenterUrl", "getAiMinutesQuotaStatus", "getFeatureDetail", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "getFunctionSceneBuyUrlMap", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;Ljava/util/HashMap;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmDisplayQuotaData;", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmDisplayQuotaData implements Serializable {

    @SerializedName("ai_amount")
    private final Long aiAmount;

    @SerializedName("ai_minutes_amount")
    private final Long aiMinutesAmount;

    @SerializedName("ai_minutes_quota_status")
    private final Long aiMinutesQuotaStatus;

    @SerializedName("ai_minutes_usage")
    private final Long aiMinutesUsage;

    @SerializedName("ai_usage")
    private final Long aiUsage;

    @SerializedName("asr_amount")
    private final Long asrAmount;

    @SerializedName("asr_usage")
    private final Long asrUsage;

    @SerializedName("benefit_center_url")
    private final String benefitCenterUrl;

    @SerializedName("bill_url")
    private final String billUrl;

    @SerializedName("feature_detail")
    private final MmFeatureDetail featureDetail;

    @SerializedName("function_scene_buy_url_map")
    private final HashMap<String, String> functionSceneBuyUrlMap;

    @SerializedName("is_ai_minutes_quota_active")
    private final Boolean isAIMinutesQuotaActive;

    @SerializedName("is_ai_quota_active")
    private final Boolean isAIQuotaActive;

    @SerializedName("is_asr_quota_active")
    private final Boolean isASRQuotaActive;

    @SerializedName("remaining_ai_minutes_quota")
    private final Long remainingAIMinutesQuota;

    @SerializedName("remaining_ai_quota")
    private final Long remainingAIQuota;

    @SerializedName("remaining_asr_quota")
    private final Long remainingASRQuota;

    public MmDisplayQuotaData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmDisplayQuotaData copy$default(MmDisplayQuotaData r17, Long r18, Long r19, Long r20, Long r21, Boolean r22, Boolean r23, Boolean r24, Long r25, Long r26, Long r27, Long r28, Long r29, String r30, String r31, Long r32, MmFeatureDetail r33, HashMap r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        Long r2 = r17.aiAmount;
    L7:
        if ((r35 & 2) == 0) goto L9;
        Long r3 = r17.aiUsage;
    L11:
        if ((r35 & 4) == 0) goto L13;
        Long r4 = r17.asrAmount;
    L15:
        if ((r35 & 8) == 0) goto L17;
        Long r5 = r17.asrUsage;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Boolean r6 = r17.isAIQuotaActive;
    L23:
        if ((r35 & 32) == 0) goto L25;
        Boolean r7 = r17.isASRQuotaActive;
    L27:
        if ((r35 & 64) == 0) goto L29;
        Boolean r8 = r17.isAIMinutesQuotaActive;
    L31:
        if ((r35 & 128) == 0) goto L33;
        Long r9 = r17.aiMinutesAmount;
    L35:
        if ((r35 & 256) == 0) goto L37;
        Long r10 = r17.aiMinutesUsage;
    L39:
        if ((r35 & 512) == 0) goto L41;
        Long r11 = r17.remainingAIQuota;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        Long r12 = r17.remainingAIMinutesQuota;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        Long r13 = r17.remainingASRQuota;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        String r14 = r17.billUrl;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        String r15 = r17.benefitCenterUrl;
    L58:
        String r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        Long r16 = r17.aiMinutesQuotaStatus;
    L62:
        Long r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        MmFeatureDetail r110 = r17.featureDetail;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        HashMap r1 = r17.functionSceneBuyUrlMap;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L62
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
        return this.aiAmount;
    }

    public final Long component10() {
        return this.remainingAIQuota;
    }

    public final Long component11() {
        return this.remainingAIMinutesQuota;
    }

    public final Long component12() {
        return this.remainingASRQuota;
    }

    public final String component13() {
        return this.billUrl;
    }

    public final String component14() {
        return this.benefitCenterUrl;
    }

    public final Long component15() {
        return this.aiMinutesQuotaStatus;
    }

    public final MmFeatureDetail component16() {
        return this.featureDetail;
    }

    public final HashMap<String, String> component17() {
        return this.functionSceneBuyUrlMap;
    }

    public final Long component2() {
        return this.aiUsage;
    }

    public final Long component3() {
        return this.asrAmount;
    }

    public final Long component4() {
        return this.asrUsage;
    }

    public final Boolean component5() {
        return this.isAIQuotaActive;
    }

    public final Boolean component6() {
        return this.isASRQuotaActive;
    }

    public final Boolean component7() {
        return this.isAIMinutesQuotaActive;
    }

    public final Long component8() {
        return this.aiMinutesAmount;
    }

    public final Long component9() {
        return this.aiMinutesUsage;
    }

    public final MmDisplayQuotaData copy(Long r20, Long r21, Long r22, Long r23, Boolean r24, Boolean r25, Boolean r26, Long r27, Long r28, Long r29, Long r30, Long r31, String r32, String r33, Long r34, MmFeatureDetail r35, HashMap<String, String> r36) {
        return new MmDisplayQuotaData(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmDisplayQuotaData) == true) goto L8;
        return false;
    L8:
        MmDisplayQuotaData r6 = (MmDisplayQuotaData) r5;
        if (Intrinsics.areEqual(this.aiAmount, r6.aiAmount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aiUsage, r6.aiUsage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.asrAmount, r6.asrAmount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.asrUsage, r6.asrUsage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isAIQuotaActive, r6.isAIQuotaActive) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isASRQuotaActive, r6.isASRQuotaActive) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isAIMinutesQuotaActive, r6.isAIMinutesQuotaActive) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.aiMinutesAmount, r6.aiMinutesAmount) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.aiMinutesUsage, r6.aiMinutesUsage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.remainingAIQuota, r6.remainingAIQuota) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.remainingAIMinutesQuota, r6.remainingAIMinutesQuota) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.remainingASRQuota, r6.remainingASRQuota) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.billUrl, r6.billUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.benefitCenterUrl, r6.benefitCenterUrl) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.aiMinutesQuotaStatus, r6.aiMinutesQuotaStatus) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.featureDetail, r6.featureDetail) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.functionSceneBuyUrlMap, r6.functionSceneBuyUrlMap) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        Long r0 = this.aiAmount;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.aiUsage;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.asrAmount;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.asrUsage;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.isAIQuotaActive;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.isASRQuotaActive;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.isAIMinutesQuotaActive;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.aiMinutesAmount;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.aiMinutesUsage;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Long r28 = this.remainingAIQuota;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Long r31 = this.remainingAIMinutesQuota;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.remainingASRQuota;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.billUrl;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.benefitCenterUrl;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Long r43 = this.aiMinutesQuotaStatus;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        MmFeatureDetail r46 = this.featureDetail;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        HashMap<String, String> r49 = this.functionSceneBuyUrlMap;
        if (r49 == null) goto L71;
        r1 = r49.hashCode();
    L71:
        return r48 + r1;
    L65:
        r47 = r46.hashCode();
        goto L66
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
        return "MmDisplayQuotaData(aiAmount=" + this.aiAmount + ", aiUsage=" + this.aiUsage + ", asrAmount=" + this.asrAmount + ", asrUsage=" + this.asrUsage + ", isAIQuotaActive=" + this.isAIQuotaActive + ", isASRQuotaActive=" + this.isASRQuotaActive + ", isAIMinutesQuotaActive=" + this.isAIMinutesQuotaActive + ", aiMinutesAmount=" + this.aiMinutesAmount + ", aiMinutesUsage=" + this.aiMinutesUsage + ", remainingAIQuota=" + this.remainingAIQuota + ", remainingAIMinutesQuota=" + this.remainingAIMinutesQuota + ", remainingASRQuota=" + this.remainingASRQuota + ", billUrl=" + this.billUrl + ", benefitCenterUrl=" + this.benefitCenterUrl + ", aiMinutesQuotaStatus=" + this.aiMinutesQuotaStatus + ", featureDetail=" + this.featureDetail + ", functionSceneBuyUrlMap=" + this.functionSceneBuyUrlMap + ')';
    }

    public final Long getAiAmount() {
        return this.aiAmount;
    }

    public final Long getAiMinutesAmount() {
        return this.aiMinutesAmount;
    }

    public final Long getAiMinutesQuotaStatus() {
        return this.aiMinutesQuotaStatus;
    }

    public final Long getAiMinutesUsage() {
        return this.aiMinutesUsage;
    }

    public final Long getAiUsage() {
        return this.aiUsage;
    }

    public final Long getAsrAmount() {
        return this.asrAmount;
    }

    public final Long getAsrUsage() {
        return this.asrUsage;
    }

    public final String getBenefitCenterUrl() {
        return this.benefitCenterUrl;
    }

    public final String getBillUrl() {
        return this.billUrl;
    }

    public final MmFeatureDetail getFeatureDetail() {
        return this.featureDetail;
    }

    public final HashMap<String, String> getFunctionSceneBuyUrlMap() {
        return this.functionSceneBuyUrlMap;
    }

    public final Long getRemainingAIMinutesQuota() {
        return this.remainingAIMinutesQuota;
    }

    public final Long getRemainingAIQuota() {
        return this.remainingAIQuota;
    }

    public final Long getRemainingASRQuota() {
        return this.remainingASRQuota;
    }

    public final Boolean isAIMinutesQuotaActive() {
        return this.isAIMinutesQuotaActive;
    }

    public final Boolean isAIQuotaActive() {
        return this.isAIQuotaActive;
    }

    public final Boolean isASRQuotaActive() {
        return this.isASRQuotaActive;
    }

    public MmDisplayQuotaData(Long r3, Long r4, Long r5, Long r6, Boolean r7, Boolean r8, Boolean r9, Long r10, Long r11, Long r12, Long r13, Long r14, String r15, String r16, Long r17, MmFeatureDetail r18, HashMap<String, String> r19) {
        this.aiAmount = r3;
        this.aiUsage = r4;
        this.asrAmount = r5;
        this.asrUsage = r6;
        this.isAIQuotaActive = r7;
        this.isASRQuotaActive = r8;
        this.isAIMinutesQuotaActive = r9;
        this.aiMinutesAmount = r10;
        this.aiMinutesUsage = r11;
        this.remainingAIQuota = r12;
        this.remainingAIMinutesQuota = r13;
        this.remainingASRQuota = r14;
        this.billUrl = r15;
        this.benefitCenterUrl = r16;
        this.aiMinutesQuotaStatus = r17;
        this.featureDetail = r18;
        this.functionSceneBuyUrlMap = r19;
    }

    public /* synthetic */ MmDisplayQuotaData(Long r19, Long r20, Long r21, Long r22, Boolean r23, Boolean r24, Boolean r25, Long r26, Long r27, Long r28, Long r29, Long r30, String r31, String r32, Long r33, MmFeatureDetail r34, HashMap r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        Long r5 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Boolean r6 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        Boolean r7 = null;
    L27:
        if ((r36 & 64) == 0) goto L29;
        Boolean r8 = null;
    L31:
        if ((r36 & 128) == 0) goto L33;
        Long r9 = null;
    L35:
        if ((r36 & 256) == 0) goto L37;
        Long r10 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        Long r11 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        Long r12 = null;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        Long r13 = null;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        Long r2 = null;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        MmFeatureDetail r16 = null;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        HashMap r0 = null;
    L70:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r0);
        return;
    L69:
        r0 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r2 = r33;
        goto L63
    L57:
        r15 = r32;
        goto L59
    L53:
        r14 = r31;
        goto L55
    L49:
        r13 = r30;
        goto L51
    L45:
        r12 = r29;
        goto L47
    L41:
        r11 = r28;
        goto L43
    L37:
        r10 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }
}
