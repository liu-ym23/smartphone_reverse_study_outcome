package ly;

import android.view.View;
import com.bytedance.android.live.lynx.ui.EcomCustomUIImage;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends com.lynx.tasm.behavior.a {
    public d() {
        super("ecom-image");
    }

    public final LynxUI<View> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new EcomCustomUIImage(r2);
    }
}
