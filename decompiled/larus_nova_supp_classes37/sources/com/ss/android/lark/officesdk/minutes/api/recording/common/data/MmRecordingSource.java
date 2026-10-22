package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.x;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OBRIC_RECORDER", "DOUBAO_PERSONAL", "DOUBAO_ENTERPRISE", "DOUBAO_EARBUDS", "DOUBAO_GLASSES", "DOUBAO_STANDALONE_AI_INTERPRETATION", "FEISHU", "FEISHU_DOUBAO", "FEISHU_HARDWARE_RECORDER", "FEISHU_HARDWARE_D1204", "FEISHU_HARDWARE_D1204_CASE", "FEISHU_STANDALONE_AI_INTERPRETATION", "toTrackSource", "isRecordingIdBasedSource", "", "usesRecordingApiByDefault", "isFeishuHost", "isStandaloneAIInterpretationSource", "shouldRetainOfflineRecordingParts", "needClientOpenSubtitle", "getSummaryWebConfig", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingWebConfig;", "getEndWindowWebConfig", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingSource extends Enum<MmRecordingSource> {
    public static final MmRecordingSource DOUBAO_EARBUDS = null;
    public static final MmRecordingSource DOUBAO_ENTERPRISE = null;
    public static final MmRecordingSource DOUBAO_GLASSES = null;
    public static final MmRecordingSource DOUBAO_PERSONAL = null;
    public static final MmRecordingSource DOUBAO_STANDALONE_AI_INTERPRETATION = null;
    public static final MmRecordingSource FEISHU = null;
    public static final MmRecordingSource FEISHU_DOUBAO = null;
    public static final MmRecordingSource FEISHU_HARDWARE_D1204 = null;
    public static final MmRecordingSource FEISHU_HARDWARE_D1204_CASE = null;
    public static final MmRecordingSource FEISHU_HARDWARE_RECORDER = null;
    public static final MmRecordingSource FEISHU_STANDALONE_AI_INTERPRETATION = null;
    public static final MmRecordingSource OBRIC_RECORDER = null;
    public static final /* synthetic */ MmRecordingSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[MmRecordingSource.FEISHU.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[MmRecordingSource.OBRIC_RECORDER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    public static EnumEntries<MmRecordingSource> getEntries() {
        return b;
    }

    static {
        MmRecordingSource r0 = new MmRecordingSource("OBRIC_RECORDER", 0, "OBRIC_RECORDER");
        OBRIC_RECORDER = r0;
        MmRecordingSource r1 = new MmRecordingSource("DOUBAO_PERSONAL", 1, "DOUBAO_PERSONAL");
        DOUBAO_PERSONAL = r1;
        MmRecordingSource r3 = new MmRecordingSource("DOUBAO_ENTERPRISE", 2, "DOUBAO_ENTERPRISE");
        DOUBAO_ENTERPRISE = r3;
        MmRecordingSource r5 = new MmRecordingSource("DOUBAO_EARBUDS", 3, "DOUBAO_EARBUDS");
        DOUBAO_EARBUDS = r5;
        MmRecordingSource r7 = new MmRecordingSource("DOUBAO_GLASSES", 4, "DOUBAO_GLASSES");
        DOUBAO_GLASSES = r7;
        MmRecordingSource r9 = new MmRecordingSource("DOUBAO_STANDALONE_AI_INTERPRETATION", 5, "DOUBAO_STANDALONE_AI_INTERPRETATION");
        DOUBAO_STANDALONE_AI_INTERPRETATION = r9;
        MmRecordingSource r11 = new MmRecordingSource("FEISHU", 6, "FEISHU");
        FEISHU = r11;
        MmRecordingSource r13 = new MmRecordingSource("FEISHU_DOUBAO", 7, "FEISHU_DOUBAO");
        FEISHU_DOUBAO = r13;
        MmRecordingSource r15 = new MmRecordingSource("FEISHU_HARDWARE_RECORDER", 8, "FEISHU_HARDWARE_RECORDER");
        FEISHU_HARDWARE_RECORDER = r15;
        MmRecordingSource r14 = new MmRecordingSource("FEISHU_HARDWARE_D1204", 9, "FEISHU_HARDWARE_D1204");
        FEISHU_HARDWARE_D1204 = r14;
        MmRecordingSource r12 = new MmRecordingSource("FEISHU_HARDWARE_D1204_CASE", 10, "FEISHU_HARDWARE_D1204_CASE");
        FEISHU_HARDWARE_D1204_CASE = r12;
        MmRecordingSource r10 = new MmRecordingSource("FEISHU_STANDALONE_AI_INTERPRETATION", 11, "STANDALONE_AI_INTERPRETATION");
        FEISHU_STANDALONE_AI_INTERPRETATION = r10;
        MmRecordingSource[] r4 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static MmRecordingSource[] values() {
        return (MmRecordingSource[]) a.clone();
    }

    public final x getEndWindowWebConfig() {
        if (isFeishuHost() == false) goto L5;
        String r1 = "/webview/minutes-end-summary";
    L7:
        if (isFeishuHost() == false) goto L9;
        String r2 = FEISHU.toTrackSource();
    L10:
        String r3 = OfficeSDKManager.getHostAppVersion();
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        return new x(r1, r2, r3);
    L9:
        r2 = "doubao";
        goto L10
    L5:
        r1 = "/webview/doubao-end-summary-mobile";
        goto L7
    }

    public final x getSummaryWebConfig() {
        if (isFeishuHost() == false) goto L5;
        String r1 = "/webview/minutes-ai-layout-mobile";
    L7:
        if (this != OBRIC_RECORDER) goto L10;
        String r2 = "obric";
    L13:
        String r3 = OfficeSDKManager.getHostAppVersion();
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        return new x(r1, r2, r3);
    L10:
        if (isFeishuHost() == false) goto L12;
        r2 = FEISHU.toTrackSource();
        goto L13
    L12:
        r2 = "doubao";
        goto L13
    L5:
        r1 = "/webview/doubao-ai-layout-mobile";
        goto L7
    }

    public final boolean isFeishuHost() {
        switch(a.a[ordinal()]) {
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        return true;
    }

    public final boolean isRecordingIdBasedSource() {
        switch(a.a[ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isStandaloneAIInterpretationSource() {
        if (this != FEISHU_STANDALONE_AI_INTERPRETATION) goto L5;
    L8:
        return true;
    L5:
        if (this == DOUBAO_STANDALONE_AI_INTERPRETATION) goto L8;
        return false;
    }

    public final boolean needClientOpenSubtitle() {
        if (this != OBRIC_RECORDER) goto L5;
    L16:
        return true;
    L5:
        if (this == FEISHU) goto L16;
        if (this == DOUBAO_GLASSES) goto L16;
        if (this == DOUBAO_EARBUDS) goto L16;
        if (this == FEISHU_HARDWARE_D1204) goto L16;
        if (this == FEISHU_HARDWARE_D1204_CASE) goto L16;
        return false;
    }

    public final boolean shouldRetainOfflineRecordingParts() {
        if (this != DOUBAO_GLASSES) goto L5;
    L8:
        return true;
    L5:
        if (this == DOUBAO_EARBUDS) goto L8;
        return false;
    }

    public final String toTrackSource() {
        switch(a.a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        return "obric_recorder";
    L7:
        return "anker_d1204";
    L8:
        return "anker_d3200";
    L9:
        return "doubao_in_lark";
    L10:
        return "lark";
    L11:
        return "doubao_glasses";
    L12:
        return "doubao_earbuds";
    L13:
        return "doubao";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean usesRecordingApiByDefault() {
        if (this != FEISHU) goto L5;
    L7:
        return false;
    L5:
        if (isRecordingIdBasedSource() == false) goto L7;
        return true;
    }

    public final String getValue() {
        return this.value;
    }

    public static MmRecordingSource valueOf(String r1) {
        return (MmRecordingSource) r27.a.a(MmRecordingSource.class, r1);
    }

    public MmRecordingSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
