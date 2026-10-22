package com.obric.assistant.spi.window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/spi/window/WindowOpenSource;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "POP", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WindowOpenSource extends Enum<WindowOpenSource> {
    public static final WindowOpenSource OPEN = null;
    public static final WindowOpenSource POP = null;
    public static final /* synthetic */ WindowOpenSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WindowOpenSource> getEntries() {
        return b;
    }

    static {
        WindowOpenSource r0 = new WindowOpenSource("OPEN", 0);
        OPEN = r0;
        WindowOpenSource r1 = new WindowOpenSource("POP", 1);
        POP = r1;
        WindowOpenSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static WindowOpenSource[] values() {
        return (WindowOpenSource[]) a.clone();
    }

    public static WindowOpenSource valueOf(String r1) {
        return (WindowOpenSource) a.a(WindowOpenSource.class, r1);
    }

    public WindowOpenSource(String r1, int r2) {
        super(r1, r2);
    }
}
