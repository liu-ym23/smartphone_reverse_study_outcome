package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmAutoTranslationStage;", "", "<init>", "(Ljava/lang/String;I)V", "TRANSLATION", "BILINGUAL", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAutoTranslationStage extends Enum<MmAutoTranslationStage> {
    public static final MmAutoTranslationStage BILINGUAL = null;
    public static final MmAutoTranslationStage TRANSLATION = null;
    public static final /* synthetic */ MmAutoTranslationStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAutoTranslationStage> getEntries() {
        return b;
    }

    static {
        MmAutoTranslationStage r0 = new MmAutoTranslationStage("TRANSLATION", 0);
        TRANSLATION = r0;
        MmAutoTranslationStage r1 = new MmAutoTranslationStage("BILINGUAL", 1);
        BILINGUAL = r1;
        MmAutoTranslationStage[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmAutoTranslationStage[] values() {
        return (MmAutoTranslationStage[]) a.clone();
    }

    public static MmAutoTranslationStage valueOf(String r1) {
        return (MmAutoTranslationStage) r27.a.a(MmAutoTranslationStage.class, r1);
    }

    public MmAutoTranslationStage(String r1, int r2) {
        super(r1, r2);
    }
}
