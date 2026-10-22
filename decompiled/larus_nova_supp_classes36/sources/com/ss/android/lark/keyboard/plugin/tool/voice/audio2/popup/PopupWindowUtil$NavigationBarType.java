package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/PopupWindowUtil$NavigationBarType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "CLASSIC", "GESTURES", "GESTURES_THREE_STAGE", "DOUBLE", "UNKNOWN", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum PopupWindowUtil$NavigationBarType extends Enum<PopupWindowUtil$NavigationBarType> {
    public static final PopupWindowUtil$NavigationBarType CLASSIC = null;
    public static final PopupWindowUtil$NavigationBarType DOUBLE = null;
    public static final PopupWindowUtil$NavigationBarType GESTURES = null;
    public static final PopupWindowUtil$NavigationBarType GESTURES_THREE_STAGE = null;
    public static final PopupWindowUtil$NavigationBarType UNKNOWN = null;
    public static final /* synthetic */ PopupWindowUtil$NavigationBarType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<PopupWindowUtil$NavigationBarType> getEntries() {
        return b;
    }

    static {
        PopupWindowUtil$NavigationBarType r0 = new PopupWindowUtil$NavigationBarType("CLASSIC", 0, 0);
        CLASSIC = r0;
        PopupWindowUtil$NavigationBarType r1 = new PopupWindowUtil$NavigationBarType("GESTURES", 1, 1);
        GESTURES = r1;
        PopupWindowUtil$NavigationBarType r3 = new PopupWindowUtil$NavigationBarType("GESTURES_THREE_STAGE", 2, 2);
        GESTURES_THREE_STAGE = r3;
        PopupWindowUtil$NavigationBarType r5 = new PopupWindowUtil$NavigationBarType("DOUBLE", 3, 3);
        DOUBLE = r5;
        PopupWindowUtil$NavigationBarType r7 = new PopupWindowUtil$NavigationBarType("UNKNOWN", 4, -1);
        UNKNOWN = r7;
        PopupWindowUtil$NavigationBarType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static PopupWindowUtil$NavigationBarType[] values() {
        return (PopupWindowUtil$NavigationBarType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static PopupWindowUtil$NavigationBarType valueOf(String r1) {
        return (PopupWindowUtil$NavigationBarType) r27.a.a(PopupWindowUtil$NavigationBarType.class, r1);
    }

    public PopupWindowUtil$NavigationBarType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
