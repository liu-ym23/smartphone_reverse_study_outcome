package com.ss.android.lark.officesdk.minutes.api.hardware.aiknowledge;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/aiknowledge/MmAIKnowledgeEntryType;", "", "<init>", "(Ljava/lang/String;I)V", "KNOWLEDGE_AI", "DOUBAO", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAIKnowledgeEntryType extends Enum<MmAIKnowledgeEntryType> {
    public static final MmAIKnowledgeEntryType DOUBAO = null;
    public static final MmAIKnowledgeEntryType KNOWLEDGE_AI = null;
    public static final /* synthetic */ MmAIKnowledgeEntryType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAIKnowledgeEntryType> getEntries() {
        return b;
    }

    static {
        MmAIKnowledgeEntryType r0 = new MmAIKnowledgeEntryType("KNOWLEDGE_AI", 0);
        KNOWLEDGE_AI = r0;
        MmAIKnowledgeEntryType r1 = new MmAIKnowledgeEntryType("DOUBAO", 1);
        DOUBAO = r1;
        MmAIKnowledgeEntryType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmAIKnowledgeEntryType[] values() {
        return (MmAIKnowledgeEntryType[]) a.clone();
    }

    public static MmAIKnowledgeEntryType valueOf(String r1) {
        return (MmAIKnowledgeEntryType) a.a(MmAIKnowledgeEntryType.class, r1);
    }

    public MmAIKnowledgeEntryType(String r1, int r2) {
        super(r1, r2);
    }
}
