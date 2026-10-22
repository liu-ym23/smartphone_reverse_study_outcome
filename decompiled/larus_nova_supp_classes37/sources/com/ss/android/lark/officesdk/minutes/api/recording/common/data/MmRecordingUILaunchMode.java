package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "PURE_SDK", "WITH_DOUBAO_UI", "WITH_FEISHU_UI", "WITH_DOUBAO_UI_HARDWARE", "shouldHandleUI", "", "supportAppletNavigator", "isFeishuUIStyle", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingUILaunchMode extends Enum<MmRecordingUILaunchMode> {
    public static final MmRecordingUILaunchMode PURE_SDK = null;
    public static final MmRecordingUILaunchMode UNKNOWN = null;
    public static final MmRecordingUILaunchMode WITH_DOUBAO_UI = null;
    public static final MmRecordingUILaunchMode WITH_DOUBAO_UI_HARDWARE = null;
    public static final MmRecordingUILaunchMode WITH_FEISHU_UI = null;
    public static final /* synthetic */ MmRecordingUILaunchMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingUILaunchMode> getEntries() {
        return b;
    }

    static {
        MmRecordingUILaunchMode r0 = new MmRecordingUILaunchMode("UNKNOWN", 0);
        UNKNOWN = r0;
        MmRecordingUILaunchMode r1 = new MmRecordingUILaunchMode("PURE_SDK", 1);
        PURE_SDK = r1;
        MmRecordingUILaunchMode r3 = new MmRecordingUILaunchMode("WITH_DOUBAO_UI", 2);
        WITH_DOUBAO_UI = r3;
        MmRecordingUILaunchMode r5 = new MmRecordingUILaunchMode("WITH_FEISHU_UI", 3);
        WITH_FEISHU_UI = r5;
        MmRecordingUILaunchMode r7 = new MmRecordingUILaunchMode("WITH_DOUBAO_UI_HARDWARE", 4);
        WITH_DOUBAO_UI_HARDWARE = r7;
        MmRecordingUILaunchMode[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MmRecordingUILaunchMode[] values() {
        return (MmRecordingUILaunchMode[]) a.clone();
    }

    public final boolean isFeishuUIStyle() {
        if (this != WITH_FEISHU_UI) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean shouldHandleUI() {
        if (this != UNKNOWN) goto L5;
    L7:
        return false;
    L5:
        if (this == PURE_SDK) goto L7;
        return true;
    }

    public final boolean supportAppletNavigator() {
        if (this != WITH_DOUBAO_UI) goto L5;
    L8:
        return true;
    L5:
        if (this == WITH_DOUBAO_UI_HARDWARE) goto L8;
        return false;
    }

    public static MmRecordingUILaunchMode valueOf(String r1) {
        return (MmRecordingUILaunchMode) a.a(MmRecordingUILaunchMode.class, r1);
    }

    public MmRecordingUILaunchMode(String r1, int r2) {
        super(r1, r2);
    }
}
