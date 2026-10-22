package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationAecPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "RESTORE", "TRANSCRIPT_ONLY", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAIInterpretationAecPolicy extends Enum<MmAIInterpretationAecPolicy> {
    public static final MmAIInterpretationAecPolicy RESTORE = null;
    public static final MmAIInterpretationAecPolicy TRANSCRIPT_ONLY = null;
    public static final /* synthetic */ MmAIInterpretationAecPolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAIInterpretationAecPolicy> getEntries() {
        return b;
    }

    static {
        MmAIInterpretationAecPolicy r0 = new MmAIInterpretationAecPolicy("RESTORE", 0);
        RESTORE = r0;
        MmAIInterpretationAecPolicy r1 = new MmAIInterpretationAecPolicy("TRANSCRIPT_ONLY", 1);
        TRANSCRIPT_ONLY = r1;
        MmAIInterpretationAecPolicy[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmAIInterpretationAecPolicy[] values() {
        return (MmAIInterpretationAecPolicy[]) a.clone();
    }

    public static MmAIInterpretationAecPolicy valueOf(String r1) {
        return (MmAIInterpretationAecPolicy) r27.a.a(MmAIInterpretationAecPolicy.class, r1);
    }

    public MmAIInterpretationAecPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
