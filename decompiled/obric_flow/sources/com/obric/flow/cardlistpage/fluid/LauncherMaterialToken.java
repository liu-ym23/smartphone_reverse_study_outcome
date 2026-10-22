package com.obric.flow.cardlistpage.fluid;

import android.content.res.ColorStateList;
import androidx.annotation.Keep;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.color.a;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.c;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import s6.b;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR&\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/flow/cardlistpage/fluid/LauncherMaterialToken;", "", "<init>", "()V", "Lcom/obric/oui/material/c;", "SysUI_Launcher_Widget_Background_Overlay_Frost_Dark", "Lcom/obric/oui/material/c;", "SysUI_Launcher_Widget_Background_Overlay_Frost_Light", "SysUI_Launcher_Widget_Background_Overlay_Fluid_Dark", "SysUI_Launcher_Widget_Background_Overlay_Fluid_Light", "", "SysUI_Launcher_Widget_Background_Overlay_Dark", "[Lcom/obric/oui/material/c;", "SysUI_Launcher_Widget_Background_Overlay_Light", "Lkotlin/Function1;", "", "SysUI_Launcher_Widget_Background_Overlay", "Lkotlin/jvm/functions/Function1;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LauncherMaterialToken {
    public static final LauncherMaterialToken INSTANCE = null;

    @JvmField
    public static final Function1<Boolean, c[]> SysUI_Launcher_Widget_Background_Overlay = null;

    @JvmField
    public static final c[] SysUI_Launcher_Widget_Background_Overlay_Dark = null;

    @JvmField
    public static final c SysUI_Launcher_Widget_Background_Overlay_Fluid_Dark = null;

    @JvmField
    public static final c SysUI_Launcher_Widget_Background_Overlay_Fluid_Light = null;

    @JvmField
    public static final c SysUI_Launcher_Widget_Background_Overlay_Frost_Dark = null;

    @JvmField
    public static final c SysUI_Launcher_Widget_Background_Overlay_Frost_Light = null;

    @JvmField
    public static final c[] SysUI_Launcher_Widget_Background_Overlay_Light = null;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        INSTANCE = new LauncherMaterialToken();
        a[] r5 = SystemUiBlendToken.SysUI_Color_Base_Frost_Thin_Dark;
        BlendMode r10 = BlendMode.SRC_OVER;
        a[] r11 = (a[]) ArraysKt.plus(r5, new a(Integer.MIN_VALUE, r10));
        a r12 = SystemUiBlendToken.SysUI_Color_State_Pressed_Light;
        cs.a r13 = b.h(r11, null, r12, 58);
        float r14 = 60;
        float r15 = BlurToken.Blur_Regular + r14;
        ColorStateList r16 = null;
        a[] r17 = null;
        c r18 = new c(r16, r13, r17, null, Float.valueOf(r15), null, 893);
        SysUI_Launcher_Widget_Background_Overlay_Frost_Dark = r18;
        ColorStateList r19 = null;
        a[] r110 = null;
        c r20 = new c(r19, b.h((a[]) ArraysKt.plus(SystemUiBlendToken.SysUI_Color_Base_Frost_Thin_Light, new a(Integer.MIN_VALUE, r10)), null, r12, 58), r110, null, Float.valueOf(r15), null, 893);
        SysUI_Launcher_Widget_Background_Overlay_Frost_Light = r20;
        a[] r21 = SystemUiBlendToken.SysUI_Color_Base_Fluid_UltraThin_Light;
        cs.a r26 = b.h((a[]) ArraysKt.plus(r21, new a(Integer.MIN_VALUE, r10)), null, r12, 58);
        float r22 = BlurToken.Blur_UltraThin + r14;
        Float r29 = Float.valueOf(r22);
        SystemUiFluidToken r23 = SystemUiFluidToken.INSTANCE;
        ColorStateList r25 = null;
        c r24 = new c(r25, r26, null, null, r29, r23.getSysUI_Effect_Fluid_Thin(), 381);
        SysUI_Launcher_Widget_Background_Overlay_Fluid_Dark = r24;
        ColorStateList r111 = null;
        Object[] r112 = 0 == true ? 1 : 0;
        c r27 = new c(r111, b.h((a[]) ArraysKt.plus(r21, new a(Integer.MIN_VALUE, r10)), null, r12, 58), r112, null, Float.valueOf(r22), r23.getSysUI_Effect_Fluid_Thin(), 381);
        SysUI_Launcher_Widget_Background_Overlay_Fluid_Light = r27;
        SysUI_Launcher_Widget_Background_Overlay_Dark = new c[]{r18, r24};
        SysUI_Launcher_Widget_Background_Overlay_Light = new c[]{r20, r27};
        SysUI_Launcher_Widget_Background_Overlay = LauncherMaterialToken$SysUI_Launcher_Widget_Background_Overlay$1.INSTANCE;
    }

    private LauncherMaterialToken() {
    }
}
