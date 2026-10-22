package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslActionType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL_JUMP", "EXTERNAL_JUMP", "EXTERNAL_JUMP_BY_EXPLICIT_INTENT", "WEB_JUMP", "TOAST", "WAKEUP_AND_PLAY_TTS", "JUMP_OWEN_AND_CHECK_SHOW_TOAST", "JUMP_OWEN_AND_CHECK_SHOW_DIALOG", "INTERNAL_JUMP_TTS_SPEAKER", "JUMP_DYNAMIC_DATA", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslActionType extends Enum<DslActionType> {

    @SerializedName("external_jump")
    public static final DslActionType EXTERNAL_JUMP = null;

    @SerializedName("external_jump_by_explicit_intent")
    public static final DslActionType EXTERNAL_JUMP_BY_EXPLICIT_INTENT = null;

    @SerializedName("internal_jump")
    public static final DslActionType INTERNAL_JUMP = null;

    @SerializedName("internal_jump_tts_speaker")
    public static final DslActionType INTERNAL_JUMP_TTS_SPEAKER = null;

    @SerializedName("jump_dynamic_data")
    public static final DslActionType JUMP_DYNAMIC_DATA = null;

    @SerializedName("jump_owen_and_check_show_dialog")
    public static final DslActionType JUMP_OWEN_AND_CHECK_SHOW_DIALOG = null;

    @SerializedName("jump_owen_and_check_show_toast")
    public static final DslActionType JUMP_OWEN_AND_CHECK_SHOW_TOAST = null;

    @SerializedName("toast")
    public static final DslActionType TOAST = null;

    @SerializedName("wakeup_and_play_tts")
    public static final DslActionType WAKEUP_AND_PLAY_TTS = null;

    @SerializedName("web_jump")
    public static final DslActionType WEB_JUMP = null;
    public static final /* synthetic */ DslActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DslActionType> getEntries() {
        return b;
    }

    static {
        DslActionType r0 = new DslActionType("INTERNAL_JUMP", 0);
        INTERNAL_JUMP = r0;
        DslActionType r1 = new DslActionType("EXTERNAL_JUMP", 1);
        EXTERNAL_JUMP = r1;
        DslActionType r3 = new DslActionType("EXTERNAL_JUMP_BY_EXPLICIT_INTENT", 2);
        EXTERNAL_JUMP_BY_EXPLICIT_INTENT = r3;
        DslActionType r5 = new DslActionType("WEB_JUMP", 3);
        WEB_JUMP = r5;
        DslActionType r7 = new DslActionType("TOAST", 4);
        TOAST = r7;
        DslActionType r9 = new DslActionType("WAKEUP_AND_PLAY_TTS", 5);
        WAKEUP_AND_PLAY_TTS = r9;
        DslActionType r11 = new DslActionType("JUMP_OWEN_AND_CHECK_SHOW_TOAST", 6);
        JUMP_OWEN_AND_CHECK_SHOW_TOAST = r11;
        DslActionType r13 = new DslActionType("JUMP_OWEN_AND_CHECK_SHOW_DIALOG", 7);
        JUMP_OWEN_AND_CHECK_SHOW_DIALOG = r13;
        DslActionType r15 = new DslActionType("INTERNAL_JUMP_TTS_SPEAKER", 8);
        INTERNAL_JUMP_TTS_SPEAKER = r15;
        DslActionType r14 = new DslActionType("JUMP_DYNAMIC_DATA", 9);
        JUMP_DYNAMIC_DATA = r14;
        DslActionType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static DslActionType[] values() {
        return (DslActionType[]) a.clone();
    }

    public static DslActionType valueOf(String r1) {
        return (DslActionType) r27.a.a(DslActionType.class, r1);
    }

    public DslActionType(String r1, int r2) {
        super(r1, r2);
    }
}
