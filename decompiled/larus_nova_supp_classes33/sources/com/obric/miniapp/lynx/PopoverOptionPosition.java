package com.obric.miniapp.lynx;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/miniapp/lynx/PopoverOptionPosition;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum PopoverOptionPosition extends Enum<PopoverOptionPosition> {
    public static final PopoverOptionPosition LEFT = null;
    public static final PopoverOptionPosition RIGHT = null;
    public static final /* synthetic */ PopoverOptionPosition[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PopoverOptionPosition> getEntries() {
        return b;
    }

    static {
        PopoverOptionPosition r0 = new PopoverOptionPosition("LEFT", 0);
        LEFT = r0;
        PopoverOptionPosition r1 = new PopoverOptionPosition("RIGHT", 1);
        RIGHT = r1;
        PopoverOptionPosition[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PopoverOptionPosition[] values() {
        return (PopoverOptionPosition[]) a.clone();
    }

    public static PopoverOptionPosition valueOf(String r1) {
        return (PopoverOptionPosition) r27.a.a(PopoverOptionPosition.class, r1);
    }

    public PopoverOptionPosition(String r1, int r2) {
        super(r1, r2);
    }
}
