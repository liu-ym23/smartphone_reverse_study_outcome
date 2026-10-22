package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwarePlaybackState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SYS_CALL", "APP_CALL", "MEDIA", "OTHER", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HardwarePlaybackState extends Enum<HardwarePlaybackState> {
    public static final HardwarePlaybackState APP_CALL = null;
    public static final HardwarePlaybackState IDLE = null;
    public static final HardwarePlaybackState MEDIA = null;
    public static final HardwarePlaybackState OTHER = null;
    public static final HardwarePlaybackState SYS_CALL = null;
    public static final /* synthetic */ HardwarePlaybackState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HardwarePlaybackState> getEntries() {
        return b;
    }

    static {
        HardwarePlaybackState r0 = new HardwarePlaybackState("IDLE", 0);
        IDLE = r0;
        HardwarePlaybackState r1 = new HardwarePlaybackState("SYS_CALL", 1);
        SYS_CALL = r1;
        HardwarePlaybackState r3 = new HardwarePlaybackState("APP_CALL", 2);
        APP_CALL = r3;
        HardwarePlaybackState r5 = new HardwarePlaybackState("MEDIA", 3);
        MEDIA = r5;
        HardwarePlaybackState r7 = new HardwarePlaybackState("OTHER", 4);
        OTHER = r7;
        HardwarePlaybackState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static HardwarePlaybackState[] values() {
        return (HardwarePlaybackState[]) a.clone();
    }

    public static HardwarePlaybackState valueOf(String r1) {
        return (HardwarePlaybackState) r27.a.a(HardwarePlaybackState.class, r1);
    }

    public HardwarePlaybackState(String r1, int r2) {
        super(r1, r2);
    }
}
