package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSSDType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SSD_UNKNOWN", "SSD_USER", "SSD_ROOM", "SSD_SIP_USER", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmSSDType extends Enum<MmSSDType> {
    public static final a Companion = null;
    public static final MmSSDType SSD_ROOM = null;
    public static final MmSSDType SSD_SIP_USER = null;
    public static final MmSSDType SSD_UNKNOWN = null;
    public static final MmSSDType SSD_USER = null;
    public static final MmSSDType UNKNOWN = null;
    public static final /* synthetic */ MmSSDType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmSSDType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSSDType$a] */
    static {
        MmSSDType r0 = new MmSSDType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        MmSSDType r1 = new MmSSDType("SSD_UNKNOWN", 1, 0);
        SSD_UNKNOWN = r1;
        MmSSDType r3 = new MmSSDType("SSD_USER", 2, 1);
        SSD_USER = r3;
        MmSSDType r5 = new MmSSDType("SSD_ROOM", 3, 2);
        SSD_ROOM = r5;
        MmSSDType r7 = new MmSSDType("SSD_SIP_USER", 4, 3);
        SSD_SIP_USER = r7;
        MmSSDType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static MmSSDType[] values() {
        return (MmSSDType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmSSDType valueOf(String r1) {
        return (MmSSDType) r27.a.a(MmSSDType.class, r1);
    }

    public MmSSDType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
