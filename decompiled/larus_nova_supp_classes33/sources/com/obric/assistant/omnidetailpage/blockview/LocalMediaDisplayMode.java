package com.obric.assistant.omnidetailpage.blockview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/LocalMediaDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum LocalMediaDisplayMode extends Enum<LocalMediaDisplayMode> {
    public static final LocalMediaDisplayMode HORIZONTAL = null;
    public static final LocalMediaDisplayMode VERTICAL = null;
    public static final /* synthetic */ LocalMediaDisplayMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LocalMediaDisplayMode> getEntries() {
        return b;
    }

    static {
        LocalMediaDisplayMode r0 = new LocalMediaDisplayMode("HORIZONTAL", 0);
        HORIZONTAL = r0;
        LocalMediaDisplayMode r1 = new LocalMediaDisplayMode("VERTICAL", 1);
        VERTICAL = r1;
        LocalMediaDisplayMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static LocalMediaDisplayMode[] values() {
        return (LocalMediaDisplayMode[]) a.clone();
    }

    public static LocalMediaDisplayMode valueOf(String r1) {
        return (LocalMediaDisplayMode) r27.a.a(LocalMediaDisplayMode.class, r1);
    }

    public LocalMediaDisplayMode(String r1, int r2) {
        super(r1, r2);
    }
}
