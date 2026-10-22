package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackClassification;", "", "<init>", "(Ljava/lang/String;I)V", "VALID_VALUE_ONLY", "INVALID_VALUE_ONLY", "ORDINARY_OR_MIXED", "EXPLICIT_CLEAR", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AiProactiveRecommendationFeedbackClassification extends Enum<AiProactiveRecommendationFeedbackClassification> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AiProactiveRecommendationFeedbackClassification[] $VALUES = null;
    public static final AiProactiveRecommendationFeedbackClassification EXPLICIT_CLEAR = null;
    public static final AiProactiveRecommendationFeedbackClassification INVALID_VALUE_ONLY = null;
    public static final AiProactiveRecommendationFeedbackClassification ORDINARY_OR_MIXED = null;
    public static final AiProactiveRecommendationFeedbackClassification VALID_VALUE_ONLY = null;

    private static final /* synthetic */ AiProactiveRecommendationFeedbackClassification[] $values() {
        return new AiProactiveRecommendationFeedbackClassification[]{VALID_VALUE_ONLY, INVALID_VALUE_ONLY, ORDINARY_OR_MIXED, EXPLICIT_CLEAR};
    }

    static {
        VALID_VALUE_ONLY = new AiProactiveRecommendationFeedbackClassification("VALID_VALUE_ONLY", 0);
        INVALID_VALUE_ONLY = new AiProactiveRecommendationFeedbackClassification("INVALID_VALUE_ONLY", 1);
        ORDINARY_OR_MIXED = new AiProactiveRecommendationFeedbackClassification("ORDINARY_OR_MIXED", 2);
        EXPLICIT_CLEAR = new AiProactiveRecommendationFeedbackClassification("EXPLICIT_CLEAR", 3);
        AiProactiveRecommendationFeedbackClassification[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AiProactiveRecommendationFeedbackClassification(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AiProactiveRecommendationFeedbackClassification> getEntries() {
        return $ENTRIES;
    }

    public static AiProactiveRecommendationFeedbackClassification valueOf(String r2) {
        return (AiProactiveRecommendationFeedbackClassification) ZeusTransformUtils.preCheckCast(Enum.valueOf(AiProactiveRecommendationFeedbackClassification.class, r2), AiProactiveRecommendationFeedbackClassification.class, "com.obric.memorydata.plugin");
    }

    public static AiProactiveRecommendationFeedbackClassification[] values() {
        return (AiProactiveRecommendationFeedbackClassification[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AiProactiveRecommendationFeedbackClassification[].class, "com.obric.memorydata.plugin");
    }
}
