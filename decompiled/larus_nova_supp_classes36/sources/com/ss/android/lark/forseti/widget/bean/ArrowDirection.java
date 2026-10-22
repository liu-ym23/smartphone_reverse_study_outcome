package com.ss.android.lark.forseti.widget.bean;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/forseti/widget/bean/ArrowDirection;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "LEFT", "RIGHT", "NONE", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ArrowDirection extends Enum<ArrowDirection> {
    public static final ArrowDirection BOTTOM = null;
    public static final ArrowDirection LEFT = null;
    public static final ArrowDirection NONE = null;
    public static final ArrowDirection RIGHT = null;
    public static final ArrowDirection TOP = null;
    public static final /* synthetic */ ArrowDirection[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ArrowDirection> getEntries() {
        return b;
    }

    static {
        ArrowDirection r0 = new ArrowDirection("TOP", 0);
        TOP = r0;
        ArrowDirection r1 = new ArrowDirection("BOTTOM", 1);
        BOTTOM = r1;
        ArrowDirection r3 = new ArrowDirection("LEFT", 2);
        LEFT = r3;
        ArrowDirection r5 = new ArrowDirection("RIGHT", 3);
        RIGHT = r5;
        ArrowDirection r7 = new ArrowDirection("NONE", 4);
        NONE = r7;
        ArrowDirection[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ArrowDirection[] values() {
        return (ArrowDirection[]) a.clone();
    }

    public static ArrowDirection valueOf(String r1) {
        return (ArrowDirection) a.a(ArrowDirection.class, r1);
    }

    public ArrowDirection(String r1, int r2) {
        super(r1, r2);
    }
}
