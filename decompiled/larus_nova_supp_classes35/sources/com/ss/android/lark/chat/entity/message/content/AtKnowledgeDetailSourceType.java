package com.ss.android.lark.chat.entity.message.content;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeDetailSourceType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "AIRecommendQuestions", "UserInsertInput", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AtKnowledgeDetailSourceType extends Enum<AtKnowledgeDetailSourceType> {
    public static final AtKnowledgeDetailSourceType AIRecommendQuestions = null;
    public static final AtKnowledgeDetailSourceType UserInsertInput = null;
    public static final /* synthetic */ AtKnowledgeDetailSourceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AtKnowledgeDetailSourceType> getEntries() {
        return b;
    }

    static {
        AtKnowledgeDetailSourceType r0 = new AtKnowledgeDetailSourceType("AIRecommendQuestions", 0);
        AIRecommendQuestions = r0;
        AtKnowledgeDetailSourceType r1 = new AtKnowledgeDetailSourceType("UserInsertInput", 1);
        UserInsertInput = r1;
        AtKnowledgeDetailSourceType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AtKnowledgeDetailSourceType[] values() {
        return (AtKnowledgeDetailSourceType[]) a.clone();
    }

    public static AtKnowledgeDetailSourceType valueOf(String r1) {
        return (AtKnowledgeDetailSourceType) r27.a.a(AtKnowledgeDetailSourceType.class, r1);
    }

    public AtKnowledgeDetailSourceType(String r1, int r2) {
        super(r1, r2);
    }
}
