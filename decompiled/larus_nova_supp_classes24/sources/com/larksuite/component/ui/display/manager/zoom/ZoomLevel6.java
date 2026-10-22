package com.larksuite.component.ui.display.manager.zoom;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/ui/display/manager/zoom/ZoomLevel6;", "", "level", "", "multiplier", "", "<init>", "(Ljava/lang/String;IIF)V", "getLevel", "()I", "getMultiplier", "()F", "SMALL", "NORMAL", "LARGE1", "LARGE2", "LARGE3", "LARGE4", "Companion", "display-manager_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ZoomLevel6 extends Enum<ZoomLevel6> {
    public static final a Companion = null;
    public static final ZoomLevel6 LARGE1 = null;
    public static final ZoomLevel6 LARGE2 = null;
    public static final ZoomLevel6 LARGE3 = null;
    public static final ZoomLevel6 LARGE4 = null;
    public static final ZoomLevel6 NORMAL = null;
    public static final ZoomLevel6 SMALL = null;
    public static final /* synthetic */ ZoomLevel6[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int level;
    private final float multiplier;

    public static EnumEntries<ZoomLevel6> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larksuite.component.ui.display.manager.zoom.ZoomLevel6$a] */
    static {
        ZoomLevel6 r0 = new ZoomLevel6("SMALL", 0, -1, 0.92f);
        SMALL = r0;
        ZoomLevel6 r1 = new ZoomLevel6("NORMAL", 1, 0, 1.0f);
        NORMAL = r1;
        ZoomLevel6 r3 = new ZoomLevel6("LARGE1", 2, 1, 1.08f);
        LARGE1 = r3;
        ZoomLevel6 r5 = new ZoomLevel6("LARGE2", 3, 2, 1.17f);
        LARGE2 = r5;
        ZoomLevel6 r7 = new ZoomLevel6("LARGE3", 4, 3, 1.28f);
        LARGE3 = r7;
        ZoomLevel6 r9 = new ZoomLevel6("LARGE4", 5, 4, 1.38f);
        LARGE4 = r9;
        ZoomLevel6[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static ZoomLevel6[] values() {
        return (ZoomLevel6[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public static ZoomLevel6 valueOf(String r1) {
        return (ZoomLevel6) r27.a.a(ZoomLevel6.class, r1);
    }

    public ZoomLevel6(String r1, int r2, int r3, float r4) {
        super(r1, r2);
        this.level = r3;
        this.multiplier = r4;
    }
}
