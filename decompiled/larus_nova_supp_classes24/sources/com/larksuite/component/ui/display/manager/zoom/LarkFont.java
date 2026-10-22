package com.larksuite.component.ui.display.manager.zoom;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/ui/display/manager/zoom/LarkFont;", "", "small", "", "normal", "large1", "large2", "large3", "large4", "<init>", "(Ljava/lang/String;IIIIIII)V", "getSmall", "()I", "getNormal", "getLarge1", "getLarge2", "getLarge3", "getLarge4", "TITLE0", "TITLE1", "TITLE2", "TITLE3", "TITLE4", "HEADLINE", "BODY0", "BODY1", "BODY2", "CAPTION0", "CAPTION1", "CAPTION2", "CAPTION3", "display-manager_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum LarkFont extends Enum<LarkFont> {
    public static final LarkFont BODY0 = null;
    public static final LarkFont BODY1 = null;
    public static final LarkFont BODY2 = null;
    public static final LarkFont CAPTION0 = null;
    public static final LarkFont CAPTION1 = null;
    public static final LarkFont CAPTION2 = null;
    public static final LarkFont CAPTION3 = null;
    public static final LarkFont HEADLINE = null;
    public static final LarkFont TITLE0 = null;
    public static final LarkFont TITLE1 = null;
    public static final LarkFont TITLE2 = null;
    public static final LarkFont TITLE3 = null;
    public static final LarkFont TITLE4 = null;
    public static final /* synthetic */ LarkFont[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int large1;
    private final int large2;
    private final int large3;
    private final int large4;
    private final int normal;
    private final int small;

    public static EnumEntries<LarkFont> getEntries() {
        return b;
    }

    static {
        LarkFont r9 = new LarkFont("TITLE0", 0, 24, 26, 28, 30, 34, 40);
        TITLE0 = r9;
        LarkFont r0 = new LarkFont("TITLE1", 1, 22, 24, 26, 28, 32, 36);
        TITLE1 = r0;
        LarkFont r1 = new LarkFont("TITLE2", 2, 18, 20, 22, 24, 28, 32);
        TITLE2 = r1;
        LarkFont r2 = new LarkFont("TITLE3", 3, 16, 17, 18, 20, 24, 28);
        TITLE3 = r2;
        LarkFont r3 = new LarkFont("TITLE4", 4, 16, 17, 18, 20, 24, 28);
        TITLE4 = r3;
        LarkFont r4 = new LarkFont("HEADLINE", 5, 15, 16, 17, 18, 20, 24);
        HEADLINE = r4;
        LarkFont r5 = new LarkFont("BODY0", 6, 15, 16, 17, 18, 20, 24);
        BODY0 = r5;
        LarkFont r6 = new LarkFont("BODY1", 7, 13, 14, 15, 16, 18, 20);
        BODY1 = r6;
        LarkFont r7 = new LarkFont("BODY2", 8, 13, 14, 15, 16, 18, 20);
        BODY2 = r7;
        LarkFont r8 = new LarkFont("CAPTION0", 9, 11, 12, 13, 14, 15, 16);
        CAPTION0 = r8;
        LarkFont r10 = new LarkFont("CAPTION1", 10, 11, 12, 13, 14, 15, 16);
        CAPTION1 = r10;
        LarkFont r20 = new LarkFont("CAPTION2", 11, 9, 10, 11, 12, 13, 14);
        CAPTION2 = r20;
        LarkFont r11 = new LarkFont("CAPTION3", 12, 9, 10, 11, 12, 13, 14);
        CAPTION3 = r11;
        LarkFont[] r12 = {r9, r0, r1, r2, r3, r4, r5, r6, r7, r8, r10, r20, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static LarkFont[] values() {
        return (LarkFont[]) a.clone();
    }

    public final int getLarge1() {
        return this.large1;
    }

    public final int getLarge2() {
        return this.large2;
    }

    public final int getLarge3() {
        return this.large3;
    }

    public final int getLarge4() {
        return this.large4;
    }

    public final int getNormal() {
        return this.normal;
    }

    public final int getSmall() {
        return this.small;
    }

    public static LarkFont valueOf(String r1) {
        return (LarkFont) a.a(LarkFont.class, r1);
    }

    public LarkFont(String r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        super(r1, r2);
        this.small = r3;
        this.normal = r4;
        this.large1 = r5;
        this.large2 = r6;
        this.large3 = r7;
        this.large4 = r8;
    }
}
