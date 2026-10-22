package com.obric.miniapp.lynx;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/miniapp/lynx/PopoverOptionMode;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SINGLE", "MULTI", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum PopoverOptionMode extends Enum<PopoverOptionMode> {
    public static final PopoverOptionMode MULTI = null;
    public static final PopoverOptionMode NONE = null;
    public static final PopoverOptionMode SINGLE = null;
    public static final /* synthetic */ PopoverOptionMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PopoverOptionMode> getEntries() {
        return b;
    }

    static {
        PopoverOptionMode r0 = new PopoverOptionMode("NONE", 0);
        NONE = r0;
        PopoverOptionMode r1 = new PopoverOptionMode("SINGLE", 1);
        SINGLE = r1;
        PopoverOptionMode r3 = new PopoverOptionMode("MULTI", 2);
        MULTI = r3;
        PopoverOptionMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PopoverOptionMode[] values() {
        return (PopoverOptionMode[]) a.clone();
    }

    public static PopoverOptionMode valueOf(String r1) {
        return (PopoverOptionMode) r27.a.a(PopoverOptionMode.class, r1);
    }

    public PopoverOptionMode(String r1, int r2) {
        super(r1, r2);
    }
}
