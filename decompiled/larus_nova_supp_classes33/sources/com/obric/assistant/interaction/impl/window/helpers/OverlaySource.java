package com.obric.assistant.interaction.impl.window.helpers;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "", "<init>", "(Ljava/lang/String;I)V", "WINDOW", "ACTIVITY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OverlaySource extends Enum<OverlaySource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OverlaySource[] $VALUES = null;
    public static final OverlaySource ACTIVITY = null;
    public static final OverlaySource WINDOW = null;

    private static final /* synthetic */ OverlaySource[] $values() {
        return new OverlaySource[]{WINDOW, ACTIVITY};
    }

    public static EnumEntries<OverlaySource> getEntries() {
        return $ENTRIES;
    }

    static {
        WINDOW = new OverlaySource("WINDOW", 0);
        ACTIVITY = new OverlaySource("ACTIVITY", 1);
        OverlaySource[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static OverlaySource[] values() {
        return (OverlaySource[]) $VALUES.clone();
    }

    public static OverlaySource valueOf(String r1) {
        return (OverlaySource) r27.a.a(OverlaySource.class, r1);
    }

    private OverlaySource(String r1, int r2) {
        super(r1, r2);
    }
}
