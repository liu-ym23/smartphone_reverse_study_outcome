package com.larus.audio.call.subtitle;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/call/subtitle/DisplayType;", "", "<init>", "(Ljava/lang/String;I)V", "SCENE_MODE", "REPLY", "REPLY_TXT", "REPLY_BLOCK", "TTS_WAITING", "DEEP_THINKING", "QUERY", "QUERY_IMAGE", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum DisplayType extends Enum<DisplayType> {
    public static final DisplayType DEEP_THINKING = null;
    public static final DisplayType QUERY = null;
    public static final DisplayType QUERY_IMAGE = null;
    public static final DisplayType REPLY = null;
    public static final DisplayType REPLY_BLOCK = null;
    public static final DisplayType REPLY_TXT = null;
    public static final DisplayType SCENE_MODE = null;
    public static final DisplayType TTS_WAITING = null;
    public static final /* synthetic */ DisplayType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DisplayType> getEntries() {
        return b;
    }

    static {
        DisplayType r0 = new DisplayType("SCENE_MODE", 0);
        SCENE_MODE = r0;
        DisplayType r1 = new DisplayType("REPLY", 1);
        REPLY = r1;
        DisplayType r3 = new DisplayType("REPLY_TXT", 2);
        REPLY_TXT = r3;
        DisplayType r5 = new DisplayType("REPLY_BLOCK", 3);
        REPLY_BLOCK = r5;
        DisplayType r7 = new DisplayType("TTS_WAITING", 4);
        TTS_WAITING = r7;
        DisplayType r9 = new DisplayType("DEEP_THINKING", 5);
        DEEP_THINKING = r9;
        DisplayType r11 = new DisplayType("QUERY", 6);
        QUERY = r11;
        DisplayType r13 = new DisplayType("QUERY_IMAGE", 7);
        QUERY_IMAGE = r13;
        DisplayType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static DisplayType[] values() {
        return (DisplayType[]) a.clone();
    }

    public static DisplayType valueOf(String r1) {
        return (DisplayType) a.a(DisplayType.class, r1);
    }

    public DisplayType(String r1, int r2) {
        super(r1, r2);
    }
}
