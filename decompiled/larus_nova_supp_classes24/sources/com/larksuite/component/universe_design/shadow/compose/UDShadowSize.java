package com.larksuite.component.universe_design.shadow.compose;

import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/compose/UDShadowSize;", "", "blur", "Landroidx/compose/ui/unit/Dp;", "offset", "<init>", "(Ljava/lang/String;IFF)V", "getBlur-D9Ej5fM$universe_ui_shadow_release", "()F", "F", "getOffset-D9Ej5fM$universe_ui_shadow_release", "None", "S1", "S2", "S3", "S4", "S5", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDShadowSize extends Enum<UDShadowSize> {
    public static final UDShadowSize None = null;
    public static final UDShadowSize S1 = null;
    public static final UDShadowSize S2 = null;
    public static final UDShadowSize S3 = null;
    public static final UDShadowSize S4 = null;
    public static final UDShadowSize S5 = null;
    public static final /* synthetic */ UDShadowSize[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final float blur;
    private final float offset;

    public static EnumEntries<UDShadowSize> getEntries() {
        return b;
    }

    static {
        float r2 = 0;
        UDShadowSize r0 = new UDShadowSize("None", 0, Dp.constructor-impl(r2), Dp.constructor-impl(r2));
        None = r0;
        float r4 = 4;
        float r7 = 2;
        UDShadowSize r3 = new UDShadowSize("S1", 1, Dp.constructor-impl(r4), Dp.constructor-impl(r7));
        S1 = r3;
        float r9 = 6;
        UDShadowSize r5 = new UDShadowSize("S2", 2, Dp.constructor-impl(r9), Dp.constructor-impl(r7));
        S2 = r5;
        float r11 = 8;
        UDShadowSize r8 = new UDShadowSize("S3", 3, Dp.constructor-impl(r11), Dp.constructor-impl(r4));
        S3 = r8;
        UDShadowSize r6 = new UDShadowSize("S4", 4, Dp.constructor-impl(16), Dp.constructor-impl(r9));
        S4 = r6;
        UDShadowSize r10 = new UDShadowSize("S5", 5, Dp.constructor-impl(36), Dp.constructor-impl(r11));
        S5 = r10;
        UDShadowSize[] r12 = {r0, r3, r5, r8, r6, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static UDShadowSize[] values() {
        return (UDShadowSize[]) a.clone();
    }

    /* JADX INFO: renamed from: getBlur-D9Ej5fM$universe_ui_shadow_release, reason: not valid java name */
    public final float m310getBlurD9Ej5fM$universe_ui_shadow_release() {
        return this.blur;
    }

    /* JADX INFO: renamed from: getOffset-D9Ej5fM$universe_ui_shadow_release, reason: not valid java name */
    public final float m311getOffsetD9Ej5fM$universe_ui_shadow_release() {
        return this.offset;
    }

    public static UDShadowSize valueOf(String r1) {
        return (UDShadowSize) r27.a.a(UDShadowSize.class, r1);
    }

    public UDShadowSize(String r1, int r2, float r3, float r4) {
        super(r1, r2);
        this.blur = r3;
        this.offset = r4;
    }
}
