package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageDisabledReason;", "", "<init>", "(Ljava/lang/String;I)V", "SAME_LANGUAGE", "SOURCE_TO_TARGET_UNSUPPORTED", "TARGET_TO_SOURCE_UNSUPPORTED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmStandaloneAIInterpretationLanguageDisabledReason extends Enum<MmStandaloneAIInterpretationLanguageDisabledReason> {
    public static final MmStandaloneAIInterpretationLanguageDisabledReason SAME_LANGUAGE = null;
    public static final MmStandaloneAIInterpretationLanguageDisabledReason SOURCE_TO_TARGET_UNSUPPORTED = null;
    public static final MmStandaloneAIInterpretationLanguageDisabledReason TARGET_TO_SOURCE_UNSUPPORTED = null;
    public static final /* synthetic */ MmStandaloneAIInterpretationLanguageDisabledReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmStandaloneAIInterpretationLanguageDisabledReason> getEntries() {
        return b;
    }

    static {
        MmStandaloneAIInterpretationLanguageDisabledReason r0 = new MmStandaloneAIInterpretationLanguageDisabledReason("SAME_LANGUAGE", 0);
        SAME_LANGUAGE = r0;
        MmStandaloneAIInterpretationLanguageDisabledReason r1 = new MmStandaloneAIInterpretationLanguageDisabledReason("SOURCE_TO_TARGET_UNSUPPORTED", 1);
        SOURCE_TO_TARGET_UNSUPPORTED = r1;
        MmStandaloneAIInterpretationLanguageDisabledReason r3 = new MmStandaloneAIInterpretationLanguageDisabledReason("TARGET_TO_SOURCE_UNSUPPORTED", 2);
        TARGET_TO_SOURCE_UNSUPPORTED = r3;
        MmStandaloneAIInterpretationLanguageDisabledReason[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmStandaloneAIInterpretationLanguageDisabledReason[] values() {
        return (MmStandaloneAIInterpretationLanguageDisabledReason[]) a.clone();
    }

    public static MmStandaloneAIInterpretationLanguageDisabledReason valueOf(String r1) {
        return (MmStandaloneAIInterpretationLanguageDisabledReason) r27.a.a(MmStandaloneAIInterpretationLanguageDisabledReason.class, r1);
    }

    public MmStandaloneAIInterpretationLanguageDisabledReason(String r1, int r2) {
        super(r1, r2);
    }
}
