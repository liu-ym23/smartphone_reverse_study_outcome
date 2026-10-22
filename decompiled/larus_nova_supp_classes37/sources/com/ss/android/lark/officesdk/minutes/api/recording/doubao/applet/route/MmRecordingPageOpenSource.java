package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingPageOpenSource;", "", "<init>", "(Ljava/lang/String;I)V", "FLOAT_WINDOW", "RECORDING_START_AUTO_OPEN", "CLICK_RECORDING_CARD", "OUTER_PUSH", "DOUBAO_APPS_FLOAT_WINDOW", "DOUBAO_APPS_IN_TASK", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingPageOpenSource extends Enum<MmRecordingPageOpenSource> {
    public static final MmRecordingPageOpenSource CLICK_RECORDING_CARD = null;
    public static final a Companion = null;
    public static final MmRecordingPageOpenSource DOUBAO_APPS_FLOAT_WINDOW = null;
    public static final MmRecordingPageOpenSource DOUBAO_APPS_IN_TASK = null;
    public static final MmRecordingPageOpenSource FLOAT_WINDOW = null;
    public static final MmRecordingPageOpenSource OUTER_PUSH = null;
    public static final MmRecordingPageOpenSource RECORDING_START_AUTO_OPEN = null;
    public static final /* synthetic */ MmRecordingPageOpenSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingPageOpenSource> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingPageOpenSource$a] */
    static {
        MmRecordingPageOpenSource r0 = new MmRecordingPageOpenSource("FLOAT_WINDOW", 0);
        FLOAT_WINDOW = r0;
        MmRecordingPageOpenSource r1 = new MmRecordingPageOpenSource("RECORDING_START_AUTO_OPEN", 1);
        RECORDING_START_AUTO_OPEN = r1;
        MmRecordingPageOpenSource r3 = new MmRecordingPageOpenSource("CLICK_RECORDING_CARD", 2);
        CLICK_RECORDING_CARD = r3;
        MmRecordingPageOpenSource r5 = new MmRecordingPageOpenSource("OUTER_PUSH", 3);
        OUTER_PUSH = r5;
        MmRecordingPageOpenSource r7 = new MmRecordingPageOpenSource("DOUBAO_APPS_FLOAT_WINDOW", 4);
        DOUBAO_APPS_FLOAT_WINDOW = r7;
        MmRecordingPageOpenSource r9 = new MmRecordingPageOpenSource("DOUBAO_APPS_IN_TASK", 5);
        DOUBAO_APPS_IN_TASK = r9;
        MmRecordingPageOpenSource[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static MmRecordingPageOpenSource[] values() {
        return (MmRecordingPageOpenSource[]) a.clone();
    }

    public static MmRecordingPageOpenSource valueOf(String r1) {
        return (MmRecordingPageOpenSource) r27.a.a(MmRecordingPageOpenSource.class, r1);
    }

    public MmRecordingPageOpenSource(String r1, int r2) {
        super(r1, r2);
    }
}
