package com.larksuite.common_selection;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/common_selection/DrawHighlightStyle;", "", "<init>", "(Ljava/lang/String;I)V", "FOREGROUND", "BACKGROUND", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum DrawHighlightStyle extends Enum<DrawHighlightStyle> {
    public static final DrawHighlightStyle BACKGROUND = null;
    public static final DrawHighlightStyle FOREGROUND = null;
    public static final /* synthetic */ DrawHighlightStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DrawHighlightStyle> getEntries() {
        return b;
    }

    static {
        DrawHighlightStyle r0 = new DrawHighlightStyle("FOREGROUND", 0);
        FOREGROUND = r0;
        DrawHighlightStyle r1 = new DrawHighlightStyle("BACKGROUND", 1);
        BACKGROUND = r1;
        DrawHighlightStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DrawHighlightStyle[] values() {
        return (DrawHighlightStyle[]) a.clone();
    }

    public static DrawHighlightStyle valueOf(String r1) {
        return (DrawHighlightStyle) r27.a.a(DrawHighlightStyle.class, r1);
    }

    public DrawHighlightStyle(String r1, int r2) {
        super(r1, r2);
    }
}
