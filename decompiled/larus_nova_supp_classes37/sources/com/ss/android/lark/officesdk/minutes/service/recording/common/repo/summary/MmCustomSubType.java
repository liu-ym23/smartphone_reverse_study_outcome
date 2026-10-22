package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmCustomSubType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MY_TODO", "KEYPOINT", "SPEAKER_SUMMARY", "GOLDEN_SENTENCES", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmCustomSubType extends Enum<MmCustomSubType> {
    public static final a Companion = null;
    public static final MmCustomSubType GOLDEN_SENTENCES = null;
    public static final MmCustomSubType KEYPOINT = null;
    public static final MmCustomSubType MY_TODO = null;
    public static final MmCustomSubType SPEAKER_SUMMARY = null;
    public static final MmCustomSubType UNKNOWN = null;
    public static final /* synthetic */ MmCustomSubType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmCustomSubType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmCustomSubType$a] */
    static {
        MmCustomSubType r0 = new MmCustomSubType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        MmCustomSubType r1 = new MmCustomSubType("MY_TODO", 1, 1);
        MY_TODO = r1;
        MmCustomSubType r3 = new MmCustomSubType("KEYPOINT", 2, 2);
        KEYPOINT = r3;
        MmCustomSubType r5 = new MmCustomSubType("SPEAKER_SUMMARY", 3, 3);
        SPEAKER_SUMMARY = r5;
        MmCustomSubType r7 = new MmCustomSubType("GOLDEN_SENTENCES", 4, 4);
        GOLDEN_SENTENCES = r7;
        MmCustomSubType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static MmCustomSubType[] values() {
        return (MmCustomSubType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmCustomSubType valueOf(String r1) {
        return (MmCustomSubType) r27.a.a(MmCustomSubType.class, r1);
    }

    public MmCustomSubType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
