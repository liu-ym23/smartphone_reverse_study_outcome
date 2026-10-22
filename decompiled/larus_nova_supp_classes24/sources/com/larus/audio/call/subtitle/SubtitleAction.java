package com.larus.audio.call.subtitle;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/audio/call/subtitle/SubtitleAction;", "", "<init>", "(Ljava/lang/String;I)V", "NEW", "UPDATE", "NOTIFY", "REFRESH", "PLACEHOLDER", "WAIT", "LISTENING", "DELETE", "OTHER", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum SubtitleAction extends Enum<SubtitleAction> {
    public static final SubtitleAction DELETE = null;
    public static final SubtitleAction LISTENING = null;
    public static final SubtitleAction NEW = null;
    public static final SubtitleAction NOTIFY = null;
    public static final SubtitleAction OTHER = null;
    public static final SubtitleAction PLACEHOLDER = null;
    public static final SubtitleAction REFRESH = null;
    public static final SubtitleAction UPDATE = null;
    public static final SubtitleAction WAIT = null;
    public static final /* synthetic */ SubtitleAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SubtitleAction> getEntries() {
        return b;
    }

    static {
        SubtitleAction r0 = new SubtitleAction("NEW", 0);
        NEW = r0;
        SubtitleAction r1 = new SubtitleAction("UPDATE", 1);
        UPDATE = r1;
        SubtitleAction r3 = new SubtitleAction("NOTIFY", 2);
        NOTIFY = r3;
        SubtitleAction r5 = new SubtitleAction("REFRESH", 3);
        REFRESH = r5;
        SubtitleAction r7 = new SubtitleAction("PLACEHOLDER", 4);
        PLACEHOLDER = r7;
        SubtitleAction r9 = new SubtitleAction("WAIT", 5);
        WAIT = r9;
        SubtitleAction r11 = new SubtitleAction("LISTENING", 6);
        LISTENING = r11;
        SubtitleAction r13 = new SubtitleAction("DELETE", 7);
        DELETE = r13;
        SubtitleAction r15 = new SubtitleAction("OTHER", 8);
        OTHER = r15;
        SubtitleAction[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static SubtitleAction[] values() {
        return (SubtitleAction[]) a.clone();
    }

    public static SubtitleAction valueOf(String r1) {
        return (SubtitleAction) a.a(SubtitleAction.class, r1);
    }

    public SubtitleAction(String r1, int r2) {
        super(r1, r2);
    }
}
