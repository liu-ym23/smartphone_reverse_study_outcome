package com.larus.canvas.feature.component.resultdisplay.image;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/canvas/feature/component/resultdisplay/image/CanvasSaveActionPlacement;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE_RIGHT", "IMAGE_OVERLAY_BOTTOM_START", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CanvasSaveActionPlacement extends Enum<CanvasSaveActionPlacement> {
    public static final CanvasSaveActionPlacement IMAGE_OVERLAY_BOTTOM_START = null;
    public static final CanvasSaveActionPlacement TITLE_RIGHT = null;
    public static final /* synthetic */ CanvasSaveActionPlacement[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CanvasSaveActionPlacement> getEntries() {
        return b;
    }

    static {
        CanvasSaveActionPlacement r0 = new CanvasSaveActionPlacement("TITLE_RIGHT", 0);
        TITLE_RIGHT = r0;
        CanvasSaveActionPlacement r1 = new CanvasSaveActionPlacement("IMAGE_OVERLAY_BOTTOM_START", 1);
        IMAGE_OVERLAY_BOTTOM_START = r1;
        CanvasSaveActionPlacement[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static CanvasSaveActionPlacement[] values() {
        return (CanvasSaveActionPlacement[]) a.clone();
    }

    public static CanvasSaveActionPlacement valueOf(String r1) {
        return (CanvasSaveActionPlacement) r27.a.a(CanvasSaveActionPlacement.class, r1);
    }

    public CanvasSaveActionPlacement(String r1, int r2) {
        super(r1, r2);
    }
}
