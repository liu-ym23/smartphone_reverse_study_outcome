package com.larus.avlink.env.diary.feedback.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackToastType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "SUCCESS", "FAILURE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum DiaryFeedbackToastType extends Enum<DiaryFeedbackToastType> {
    public static final DiaryFeedbackToastType FAILURE = null;
    public static final DiaryFeedbackToastType NORMAL = null;
    public static final DiaryFeedbackToastType SUCCESS = null;
    public static final /* synthetic */ DiaryFeedbackToastType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DiaryFeedbackToastType> getEntries() {
        return b;
    }

    static {
        DiaryFeedbackToastType r0 = new DiaryFeedbackToastType("NORMAL", 0);
        NORMAL = r0;
        DiaryFeedbackToastType r1 = new DiaryFeedbackToastType("SUCCESS", 1);
        SUCCESS = r1;
        DiaryFeedbackToastType r3 = new DiaryFeedbackToastType("FAILURE", 2);
        FAILURE = r3;
        DiaryFeedbackToastType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DiaryFeedbackToastType[] values() {
        return (DiaryFeedbackToastType[]) a.clone();
    }

    public static DiaryFeedbackToastType valueOf(String r1) {
        return (DiaryFeedbackToastType) a.a(DiaryFeedbackToastType.class, r1);
    }

    public DiaryFeedbackToastType(String r1, int r2) {
        super(r1, r2);
    }
}
