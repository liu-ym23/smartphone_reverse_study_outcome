package com.larksuite.component.ui.display.manager.zoom;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/ui/display/manager/zoom/ZoomLevel4;", "", "level", "", "multiplier", "", "<init>", "(Ljava/lang/String;IIF)V", "getLevel", "()I", "getMultiplier", "()F", "SMALL", "NORMAL", "LARGE1", "LARGE2", "LARGE3", "LARGE4", "display-manager_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ZoomLevel4 extends Enum<ZoomLevel4> {
    public static final ZoomLevel4 LARGE1 = null;
    public static final ZoomLevel4 LARGE2 = null;
    public static final ZoomLevel4 LARGE3 = null;
    public static final ZoomLevel4 LARGE4 = null;
    public static final ZoomLevel4 NORMAL = null;
    public static final ZoomLevel4 SMALL = null;
    public static final /* synthetic */ ZoomLevel4[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int level;
    private final float multiplier;

    public static EnumEntries<ZoomLevel4> getEntries() {
        return b;
    }

    static {
        ZoomLevel4 r0 = new ZoomLevel4("SMALL", 0, -1, 0.92f);
        SMALL = r0;
        ZoomLevel4 r1 = new ZoomLevel4("NORMAL", 1, 0, 1.0f);
        NORMAL = r1;
        ZoomLevel4 r2 = new ZoomLevel4("LARGE1", 2, 1, 1.08f);
        LARGE1 = r2;
        ZoomLevel4 r3 = new ZoomLevel4("LARGE2", 3, 2, 1.08f);
        LARGE2 = r3;
        ZoomLevel4 r7 = new ZoomLevel4("LARGE3", 4, 3, 1.17f);
        LARGE3 = r7;
        ZoomLevel4 r8 = new ZoomLevel4("LARGE4", 5, 4, 1.17f);
        LARGE4 = r8;
        ZoomLevel4[] r11 = {r0, r1, r2, r3, r7, r8};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ZoomLevel4[] values() {
        return (ZoomLevel4[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public static ZoomLevel4 valueOf(String r1) {
        return (ZoomLevel4) a.a(ZoomLevel4.class, r1);
    }

    public ZoomLevel4(String r1, int r2, int r3, float r4) {
        super(r1, r2);
        this.level = r3;
        this.multiplier = r4;
    }
}
