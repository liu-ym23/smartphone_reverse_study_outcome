package ly;

import android.view.View;
import com.bytedance.android.live.lynx.ui.MultiLinkCustomUIImage;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends com.lynx.tasm.behavior.a {
    public e() {
        super("m-image");
    }

    public final LynxUI<View> createUI(LynxContext r2) {
        return new MultiLinkCustomUIImage(r2);
    }
}
