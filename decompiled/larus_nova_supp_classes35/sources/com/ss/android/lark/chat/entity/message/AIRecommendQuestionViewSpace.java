package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Normal", "System", "Bubble", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIRecommendQuestionViewSpace extends Enum<AIRecommendQuestionViewSpace> {
    public static final AIRecommendQuestionViewSpace Bubble = null;
    public static final AIRecommendQuestionViewSpace Normal = null;
    public static final AIRecommendQuestionViewSpace System = null;
    public static final /* synthetic */ AIRecommendQuestionViewSpace[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AIRecommendQuestionViewSpace> getEntries() {
        return b;
    }

    static {
        AIRecommendQuestionViewSpace r0 = new AIRecommendQuestionViewSpace("Normal", 0);
        Normal = r0;
        AIRecommendQuestionViewSpace r1 = new AIRecommendQuestionViewSpace("System", 1);
        System = r1;
        AIRecommendQuestionViewSpace r3 = new AIRecommendQuestionViewSpace("Bubble", 2);
        Bubble = r3;
        AIRecommendQuestionViewSpace[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AIRecommendQuestionViewSpace[] values() {
        return (AIRecommendQuestionViewSpace[]) a.clone();
    }

    public static AIRecommendQuestionViewSpace valueOf(String r1) {
        return (AIRecommendQuestionViewSpace) r27.a.a(AIRecommendQuestionViewSpace.class, r1);
    }

    public AIRecommendQuestionViewSpace(String r1, int r2) {
        super(r1, r2);
    }
}
