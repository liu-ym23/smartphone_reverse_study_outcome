package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmChannelProfileType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VC", "SHARE_1V1", "ROOMS_1V1", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmChannelProfileType extends Enum<MmChannelProfileType> {
    public static final MmChannelProfileType ROOMS_1V1 = null;
    public static final MmChannelProfileType SHARE_1V1 = null;
    public static final MmChannelProfileType VC = null;
    public static final /* synthetic */ MmChannelProfileType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmChannelProfileType> getEntries() {
        return b;
    }

    static {
        MmChannelProfileType r0 = new MmChannelProfileType("VC", 0, 0);
        VC = r0;
        MmChannelProfileType r1 = new MmChannelProfileType("SHARE_1V1", 1, 1);
        SHARE_1V1 = r1;
        MmChannelProfileType r3 = new MmChannelProfileType("ROOMS_1V1", 2, 2);
        ROOMS_1V1 = r3;
        MmChannelProfileType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmChannelProfileType[] values() {
        return (MmChannelProfileType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmChannelProfileType valueOf(String r1) {
        return (MmChannelProfileType) r27.a.a(MmChannelProfileType.class, r1);
    }

    public MmChannelProfileType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
