package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmAutoLanguageSettingResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "OBSOLETE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAutoLanguageSettingResult extends Enum<MmAutoLanguageSettingResult> {
    public static final MmAutoLanguageSettingResult FAILED = null;
    public static final MmAutoLanguageSettingResult OBSOLETE = null;
    public static final MmAutoLanguageSettingResult SUCCESS = null;
    public static final /* synthetic */ MmAutoLanguageSettingResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAutoLanguageSettingResult> getEntries() {
        return b;
    }

    static {
        MmAutoLanguageSettingResult r0 = new MmAutoLanguageSettingResult("SUCCESS", 0);
        SUCCESS = r0;
        MmAutoLanguageSettingResult r1 = new MmAutoLanguageSettingResult("FAILED", 1);
        FAILED = r1;
        MmAutoLanguageSettingResult r3 = new MmAutoLanguageSettingResult("OBSOLETE", 2);
        OBSOLETE = r3;
        MmAutoLanguageSettingResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmAutoLanguageSettingResult[] values() {
        return (MmAutoLanguageSettingResult[]) a.clone();
    }

    public static MmAutoLanguageSettingResult valueOf(String r1) {
        return (MmAutoLanguageSettingResult) r27.a.a(MmAutoLanguageSettingResult.class, r1);
    }

    public MmAutoLanguageSettingResult(String r1, int r2) {
        super(r1, r2);
    }
}
