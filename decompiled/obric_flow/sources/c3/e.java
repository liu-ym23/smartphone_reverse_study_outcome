package c3;

import com.relax.uirender.UIRenderRegistry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final UIRenderRegistry.RenderType a(String r5) {
        if (Intrinsics.areEqual(r5, "CLAY") == false) goto L7;
        return UIRenderRegistry.RenderType.CLAY;
    L7:
        if (Intrinsics.areEqual(r5, "LYNX_UI") == false) goto L11;
        return UIRenderRegistry.RenderType.LYNX_UI;
    L11:
        return UIRenderRegistry.RenderType.CLAY;
    }
}
