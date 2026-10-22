package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/DisplayState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PREPARING", "RECORDING", "RECOGNIZING", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum DisplayState extends Enum<DisplayState> {
    public static final DisplayState IDLE = null;
    public static final DisplayState PREPARING = null;
    public static final DisplayState RECOGNIZING = null;
    public static final DisplayState RECORDING = null;
    public static final /* synthetic */ DisplayState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DisplayState> getEntries() {
        return b;
    }

    static {
        DisplayState r0 = new DisplayState("IDLE", 0);
        IDLE = r0;
        DisplayState r1 = new DisplayState("PREPARING", 1);
        PREPARING = r1;
        DisplayState r3 = new DisplayState("RECORDING", 2);
        RECORDING = r3;
        DisplayState r5 = new DisplayState("RECOGNIZING", 3);
        RECOGNIZING = r5;
        DisplayState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DisplayState[] values() {
        return (DisplayState[]) a.clone();
    }

    public static DisplayState valueOf(String r1) {
        return (DisplayState) r27.a.a(DisplayState.class, r1);
    }

    public DisplayState(String r1, int r2) {
        super(r1, r2);
    }
}
