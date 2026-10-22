package com.bytedance.ai.view.popup.anim;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/view/popup/anim/AnimationStyle;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "START", "END", "LEFT", "RIGHT", "ZOOM", "SLIDE", "AUTO", "NONE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AnimationStyle extends Enum<AnimationStyle> {
    public static final AnimationStyle AUTO = null;
    public static final AnimationStyle END = null;
    public static final AnimationStyle LEFT = null;
    public static final AnimationStyle NONE = null;
    public static final AnimationStyle RIGHT = null;
    public static final AnimationStyle SLIDE = null;
    public static final AnimationStyle START = null;
    public static final AnimationStyle ZOOM = null;
    public static final /* synthetic */ AnimationStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AnimationStyle> getEntries() {
        return b;
    }

    static {
        AnimationStyle r0 = new AnimationStyle("START", 0, "start");
        START = r0;
        AnimationStyle r1 = new AnimationStyle("END", 1, "end");
        END = r1;
        AnimationStyle r10 = new AnimationStyle("LEFT", 2, "left");
        LEFT = r10;
        AnimationStyle r11 = new AnimationStyle("RIGHT", 3, "right");
        RIGHT = r11;
        AnimationStyle r12 = new AnimationStyle("ZOOM", 4, "zoom");
        ZOOM = r12;
        AnimationStyle r13 = new AnimationStyle("SLIDE", 5, com.bytedance.android.ec.core.event.a.VALUE_SLIDE);
        SLIDE = r13;
        AnimationStyle r14 = new AnimationStyle("AUTO", 6, "auto");
        AUTO = r14;
        AnimationStyle r15 = new AnimationStyle("NONE", 7, "none");
        NONE = r15;
        AnimationStyle[] r16 = {r0, r1, r10, r11, r12, r13, r14, r15};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
    }

    public static AnimationStyle[] values() {
        return (AnimationStyle[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AnimationStyle valueOf(String r1) {
        return (AnimationStyle) r27.a.a(AnimationStyle.class, r1);
    }

    public AnimationStyle(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
