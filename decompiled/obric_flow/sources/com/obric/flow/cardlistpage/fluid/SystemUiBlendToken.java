package com.obric.flow.cardlistpage.fluid;

import androidx.annotation.Keep;
import com.obric.oui.color.a;
import com.obric.oui.graphic.BlendMode;
import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/flow/cardlistpage/fluid/SystemUiBlendToken;", "", "<init>", "()V", "", "Lcom/obric/oui/color/a;", "SysUI_Color_Base_Fluid_UltraThin_Light", "[Lcom/obric/oui/color/a;", "SysUI_Color_Base_Frost_Thin_Dark", "SysUI_Color_Base_Frost_Thin_Light", "SysUI_Color_State_Pressed_Light", "Lcom/obric/oui/color/a;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SystemUiBlendToken {
    public static final SystemUiBlendToken INSTANCE = null;

    @JvmField
    public static final a[] SysUI_Color_Base_Fluid_UltraThin_Light = null;

    @JvmField
    public static final a[] SysUI_Color_Base_Frost_Thin_Dark = null;

    @JvmField
    public static final a[] SysUI_Color_Base_Frost_Thin_Light = null;

    @JvmField
    public static final a SysUI_Color_State_Pressed_Light = null;

    static {
        INSTANCE = new SystemUiBlendToken();
        SysUI_Color_Base_Fluid_UltraThin_Light = new a[]{new a(-15461356, BlendMode.PLUS_LIGHTER)};
        BlendMode r5 = BlendMode.LUMINOSITY;
        a r10 = new a(1721342361, r5);
        a r11 = new a(-3355444, BlendMode.COLOR_BURN);
        BlendMode r12 = BlendMode.SRC_OVER;
        SysUI_Color_Base_Frost_Thin_Dark = new a[]{r10, r11, new a(1295201075, r12)};
        SysUI_Color_Base_Frost_Thin_Light = new a[]{new a(1716342093, r5), new a(-11711155, BlendMode.COLOR_DODGE), new a(872415231, r12)};
        SysUI_Color_State_Pressed_Light = new a(335544320, r12);
    }

    private SystemUiBlendToken() {
    }
}
