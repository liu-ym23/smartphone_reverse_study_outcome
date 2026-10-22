package com.ss.android.lark.officesdk.minutes.api.recording.common.data.notification;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/notification/MmRecordingNotificationType;", "", "<init>", "(Ljava/lang/String;I)V", "MAX_DURATION", "PHONE_CALL", "WEAK_NETWORK", "SUBTITLE_FAILED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingNotificationType extends Enum<MmRecordingNotificationType> {
    public static final MmRecordingNotificationType MAX_DURATION = null;
    public static final MmRecordingNotificationType PHONE_CALL = null;
    public static final MmRecordingNotificationType SUBTITLE_FAILED = null;
    public static final MmRecordingNotificationType WEAK_NETWORK = null;
    public static final /* synthetic */ MmRecordingNotificationType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingNotificationType> getEntries() {
        return b;
    }

    static {
        MmRecordingNotificationType r0 = new MmRecordingNotificationType("MAX_DURATION", 0);
        MAX_DURATION = r0;
        MmRecordingNotificationType r1 = new MmRecordingNotificationType("PHONE_CALL", 1);
        PHONE_CALL = r1;
        MmRecordingNotificationType r3 = new MmRecordingNotificationType("WEAK_NETWORK", 2);
        WEAK_NETWORK = r3;
        MmRecordingNotificationType r5 = new MmRecordingNotificationType("SUBTITLE_FAILED", 3);
        SUBTITLE_FAILED = r5;
        MmRecordingNotificationType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmRecordingNotificationType[] values() {
        return (MmRecordingNotificationType[]) a.clone();
    }

    public static MmRecordingNotificationType valueOf(String r1) {
        return (MmRecordingNotificationType) a.a(MmRecordingNotificationType.class, r1);
    }

    public MmRecordingNotificationType(String r1, int r2) {
        super(r1, r2);
    }
}
