package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmMarkedSpeakerType;", "", "<init>", "(Ljava/lang/String;I)V", "CLUSTER_ID", "TEMPORARY", "LARK_USER", "isLarkUser", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmMarkedSpeakerType extends Enum<MmMarkedSpeakerType> {
    public static final MmMarkedSpeakerType CLUSTER_ID = null;
    public static final MmMarkedSpeakerType LARK_USER = null;
    public static final MmMarkedSpeakerType TEMPORARY = null;
    public static final /* synthetic */ MmMarkedSpeakerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmMarkedSpeakerType> getEntries() {
        return b;
    }

    static {
        MmMarkedSpeakerType r0 = new MmMarkedSpeakerType("CLUSTER_ID", 0);
        CLUSTER_ID = r0;
        MmMarkedSpeakerType r1 = new MmMarkedSpeakerType("TEMPORARY", 1);
        TEMPORARY = r1;
        MmMarkedSpeakerType r3 = new MmMarkedSpeakerType("LARK_USER", 2);
        LARK_USER = r3;
        MmMarkedSpeakerType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmMarkedSpeakerType[] values() {
        return (MmMarkedSpeakerType[]) a.clone();
    }

    public final boolean isLarkUser() {
        if (this != LARK_USER) goto L5;
        return true;
    L5:
        return false;
    }

    public static MmMarkedSpeakerType valueOf(String r1) {
        return (MmMarkedSpeakerType) a.a(MmMarkedSpeakerType.class, r1);
    }

    public MmMarkedSpeakerType(String r1, int r2) {
        super(r1, r2);
    }
}
