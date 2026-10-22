package com.ss.android.lark.officesdk.minutes.ui.record;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/MmUiLogScene;", "", "tag", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "ENTRY", "ROUTER", "RECORDING", "StandaloneAIInterpretation", "TOOLBAR", "CONTENT", "SUBTITLE", "SUMMARY", "AI_NOTE", "LANGUAGE", "SPEAKER", "AUDIO_SAVE", "OVERLAY", "FLOAT", "END_WINDOW", "WEB", "NOTIFICATION", "STYLE", "FOUNDATION", "HARDWARE", "HW_WALLPAPER", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmUiLogScene extends Enum<MmUiLogScene> {
    public static final MmUiLogScene AI_NOTE = null;
    public static final MmUiLogScene AUDIO_SAVE = null;
    public static final MmUiLogScene CONTENT = null;
    public static final MmUiLogScene END_WINDOW = null;
    public static final MmUiLogScene ENTRY = null;
    public static final MmUiLogScene FLOAT = null;
    public static final MmUiLogScene FOUNDATION = null;
    public static final MmUiLogScene HARDWARE = null;
    public static final MmUiLogScene HW_WALLPAPER = null;
    public static final MmUiLogScene LANGUAGE = null;
    public static final MmUiLogScene NOTIFICATION = null;
    public static final MmUiLogScene OVERLAY = null;
    public static final MmUiLogScene RECORDING = null;
    public static final MmUiLogScene ROUTER = null;
    public static final MmUiLogScene SPEAKER = null;
    public static final MmUiLogScene STYLE = null;
    public static final MmUiLogScene SUBTITLE = null;
    public static final MmUiLogScene SUMMARY = null;
    public static final MmUiLogScene StandaloneAIInterpretation = null;
    public static final MmUiLogScene TOOLBAR = null;
    public static final MmUiLogScene WEB = null;
    public static final /* synthetic */ MmUiLogScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String tag;

    public static EnumEntries<MmUiLogScene> getEntries() {
        return b;
    }

    static {
        MmUiLogScene r0 = new MmUiLogScene("ENTRY", 0, "UI_ENTRY");
        ENTRY = r0;
        MmUiLogScene r1 = new MmUiLogScene("ROUTER", 1, "UI_ROUTER");
        ROUTER = r1;
        MmUiLogScene r2 = new MmUiLogScene("RECORDING", 2, "UI_RECORDING");
        RECORDING = r2;
        MmUiLogScene r4 = new MmUiLogScene("StandaloneAIInterpretation", 3, "UI_STANDALONE_AI_INTERPRETATION");
        StandaloneAIInterpretation = r4;
        MmUiLogScene r6 = new MmUiLogScene("TOOLBAR", 4, "UI_TOOLBAR");
        TOOLBAR = r6;
        MmUiLogScene r8 = new MmUiLogScene("CONTENT", 5, "UI_CONTENT");
        CONTENT = r8;
        MmUiLogScene r10 = new MmUiLogScene("SUBTITLE", 6, "UI_SUBTITLE");
        SUBTITLE = r10;
        MmUiLogScene r12 = new MmUiLogScene("SUMMARY", 7, "UI_SUMMARY");
        SUMMARY = r12;
        MmUiLogScene r14 = new MmUiLogScene("AI_NOTE", 8, "UI_AINOTE");
        AI_NOTE = r14;
        MmUiLogScene r13 = new MmUiLogScene("LANGUAGE", 9, "UI_LANGUAGE");
        LANGUAGE = r13;
        MmUiLogScene r11 = new MmUiLogScene("SPEAKER", 10, "UI_SPEAKER");
        SPEAKER = r11;
        MmUiLogScene r9 = new MmUiLogScene("AUDIO_SAVE", 11, "UI_AUDIO_SAVE");
        AUDIO_SAVE = r9;
        MmUiLogScene r7 = new MmUiLogScene("OVERLAY", 12, "UI_OVERLAY");
        OVERLAY = r7;
        MmUiLogScene r5 = new MmUiLogScene("FLOAT", 13, "UI_FLOAT");
        FLOAT = r5;
        MmUiLogScene r3 = new MmUiLogScene("END_WINDOW", 14, "UI_END");
        END_WINDOW = r3;
        MmUiLogScene r15 = new MmUiLogScene("WEB", 15, "UI_WEB");
        WEB = r15;
        MmUiLogScene r16 = new MmUiLogScene("NOTIFICATION", 16, "UI_NOTIFY");
        NOTIFICATION = r16;
        MmUiLogScene r17 = new MmUiLogScene("STYLE", 17, "UI_STYLE");
        STYLE = r17;
        MmUiLogScene r18 = new MmUiLogScene("FOUNDATION", 18, "UI_FOUNDATION");
        FOUNDATION = r18;
        MmUiLogScene r19 = new MmUiLogScene("HARDWARE", 19, "UI_HARDWARE");
        HARDWARE = r19;
        MmUiLogScene r20 = new MmUiLogScene("HW_WALLPAPER", 20, "UI_HW_WALLPAPER");
        HW_WALLPAPER = r20;
        MmUiLogScene[] r21 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20};
        a = r21;
        b = EnumEntriesKt.enumEntries(r21);
    }

    public static MmUiLogScene[] values() {
        return (MmUiLogScene[]) a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public static MmUiLogScene valueOf(String r1) {
        return (MmUiLogScene) a.a(MmUiLogScene.class, r1);
    }

    public MmUiLogScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.tag = r3;
    }
}
