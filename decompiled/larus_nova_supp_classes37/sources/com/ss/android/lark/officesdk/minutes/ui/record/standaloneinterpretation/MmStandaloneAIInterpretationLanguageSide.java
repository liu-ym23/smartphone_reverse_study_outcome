package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageSide;", "", "<init>", "(Ljava/lang/String;I)V", "SPOKEN", "TARGET", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmStandaloneAIInterpretationLanguageSide extends Enum<MmStandaloneAIInterpretationLanguageSide> {
    public static final MmStandaloneAIInterpretationLanguageSide SPOKEN = null;
    public static final MmStandaloneAIInterpretationLanguageSide TARGET = null;
    public static final /* synthetic */ MmStandaloneAIInterpretationLanguageSide[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmStandaloneAIInterpretationLanguageSide> getEntries() {
        return b;
    }

    static {
        MmStandaloneAIInterpretationLanguageSide r0 = new MmStandaloneAIInterpretationLanguageSide("SPOKEN", 0);
        SPOKEN = r0;
        MmStandaloneAIInterpretationLanguageSide r1 = new MmStandaloneAIInterpretationLanguageSide("TARGET", 1);
        TARGET = r1;
        MmStandaloneAIInterpretationLanguageSide[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmStandaloneAIInterpretationLanguageSide[] values() {
        return (MmStandaloneAIInterpretationLanguageSide[]) a.clone();
    }

    public static MmStandaloneAIInterpretationLanguageSide valueOf(String r1) {
        return (MmStandaloneAIInterpretationLanguageSide) r27.a.a(MmStandaloneAIInterpretationLanguageSide.class, r1);
    }

    public MmStandaloneAIInterpretationLanguageSide(String r1, int r2) {
        super(r1, r2);
    }
}
