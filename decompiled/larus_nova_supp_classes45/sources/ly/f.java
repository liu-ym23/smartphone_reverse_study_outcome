package ly;

import android.view.View;
import com.bytedance.android.live.lynx.ui.MultiLinkCustomClipImage;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends com.lynx.tasm.behavior.a {
    public f() {
        super("m-clips-background");
    }

    public final LynxUI<View> createUI(LynxContext r2) {
        return new MultiLinkCustomClipImage(r2);
    }
}
