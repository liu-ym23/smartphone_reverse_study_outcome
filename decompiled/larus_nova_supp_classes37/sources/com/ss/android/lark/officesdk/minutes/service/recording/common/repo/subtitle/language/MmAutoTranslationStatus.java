package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmAutoTranslationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "APPLYING", "APPLIED", "SKIPPED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAutoTranslationStatus extends Enum<MmAutoTranslationStatus> {
    public static final MmAutoTranslationStatus APPLIED = null;
    public static final MmAutoTranslationStatus APPLYING = null;
    public static final MmAutoTranslationStatus SKIPPED = null;
    public static final MmAutoTranslationStatus WAITING = null;
    public static final /* synthetic */ MmAutoTranslationStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAutoTranslationStatus> getEntries() {
        return b;
    }

    static {
        MmAutoTranslationStatus r0 = new MmAutoTranslationStatus("WAITING", 0);
        WAITING = r0;
        MmAutoTranslationStatus r1 = new MmAutoTranslationStatus("APPLYING", 1);
        APPLYING = r1;
        MmAutoTranslationStatus r3 = new MmAutoTranslationStatus("APPLIED", 2);
        APPLIED = r3;
        MmAutoTranslationStatus r5 = new MmAutoTranslationStatus("SKIPPED", 3);
        SKIPPED = r5;
        MmAutoTranslationStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmAutoTranslationStatus[] values() {
        return (MmAutoTranslationStatus[]) a.clone();
    }

    public static MmAutoTranslationStatus valueOf(String r1) {
        return (MmAutoTranslationStatus) r27.a.a(MmAutoTranslationStatus.class, r1);
    }

    public MmAutoTranslationStatus(String r1, int r2) {
        super(r1, r2);
    }
}
