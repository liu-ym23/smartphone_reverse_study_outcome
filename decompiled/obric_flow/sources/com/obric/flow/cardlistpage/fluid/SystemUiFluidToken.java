package com.obric.flow.cardlistpage.fluid;

import androidx.annotation.Keep;
import com.obric.oui.fluid.a;
import com.obric.oui.graphic.BlendMode;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/flow/cardlistpage/fluid/SystemUiFluidToken;", "", "<init>", "()V", "Lcom/obric/oui/fluid/a;", "SysUI_Effect_Fluid_Thin", "Lcom/obric/oui/fluid/a;", "getSysUI_Effect_Fluid_Thin", "()Lcom/obric/oui/fluid/a;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SystemUiFluidToken {
    public static final SystemUiFluidToken INSTANCE = null;
    private static final a SysUI_Effect_Fluid_Thin = null;

    static {
        INSTANCE = new SystemUiFluidToken();
        FloatCompanionObject r5 = FloatCompanionObject.INSTANCE;
        SysUI_Effect_Fluid_Thin = new a(new float[]{30.0f, -60.0f, 1.5f, 3.0f, 6.0f, 1.0f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.porterDuffMode, Float.intBitsToFloat(872415231), BlendMode.PLUS_LIGHTER.porterDuffMode});
    }

    private SystemUiFluidToken() {
    }

    public final a getSysUI_Effect_Fluid_Thin() {
        return SysUI_Effect_Fluid_Thin;
    }
}
